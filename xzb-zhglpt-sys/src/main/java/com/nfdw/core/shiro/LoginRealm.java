package com.nfdw.core.shiro;

import com.alibaba.fastjson.JSONArray;
import com.nfdw.entity.*;
import com.nfdw.service.MenuService;
import com.nfdw.service.RoleService;
import com.nfdw.service.SysUserService;
import com.nfdw.util.LoginUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 */
@Service
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    /**
     * 获取认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户获取角色 根据角色获取所有按钮权限

        CurrentUser cUser = (CurrentUser) ShiroUtil.getSession().getAttribute("curentUser");
        for (CurrentRole cRole : cUser.getCurrentRoleList()) {
            info.addRole(cRole.getRoleName());
        }
        for (CurrentMenu cMenu : cUser.getCurrentMenuList()) {
            if (!StringUtils.isEmpty(cMenu.getPermission()))
                info.addStringPermission(cMenu.getPermission());
        }
        return info;
    }

    /**
     * 获取授权
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String name = upToken.getUsername();
        String username = (String) authenticationToken.getPrincipal();
        SysUser s = null;
        try {
            s = userService.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (LoginUtil.Login(s)) {
            userService.updateByIdStatus(s.getId(), 1);
            CurrentUser currentUser = new CurrentUser(s.getId(), s.getUsername(), s.getAge(), s.getEmail(), s.getPhoto(), s.getRealName(), s.getGzarea());
            Subject subject = ShiroUtil.getSubject();
            /**角色权限封装进去*/
            //根据用户获取菜单
            List<SysMenu> menuList = new ArrayList<>(new HashSet<>(menuService.getUserMenu(s.getId())));

            JSONArray json = menuService.getMenuJsonByUser(menuList);
            String s1 = json.toString();
            Session session = subject.getSession();
            session.setAttribute("menu", json);
            CurrentMenu currentMenu = null;
            List<CurrentMenu> currentMenuList = new ArrayList<>();
            List<SysRole> roleList = new ArrayList<>();
            for (SysMenu m : menuList) {
                currentMenu = new CurrentMenu(m.getId(), m.getName(), m.getPId(), m.getUrl(), m.getOrderNum(), m.getIcon(), m.getPermission(), m.getMenuType(), m.getNum());
                currentMenuList.add(currentMenu);
                roleList.addAll(m.getRoleList());
            }
            roleList = new ArrayList<>(new HashSet<>(roleList));
            List<CurrentRole> currentRoleList = new ArrayList<>();
            CurrentRole role = null;
            for (SysRole r : roleList) {
                role = new CurrentRole(r.getId(), r.getRoleName(), r.getRemark());
                currentRoleList.add(role);
            }
            System.out.println(roleService.getUserRoles(currentUser.getId()));
            if (currentRoleList.size() > 0) {
                currentUser.setCurrentRoleList(currentRoleList);
            } else {
                currentUser.setCurrentRoleList(roleService.getUserRoles(currentUser.getId()));
            }

            currentUser.setCurrentMenuList(currentMenuList);
            session.setAttribute("user", s);
            session.setAttribute("curentUser", currentUser);
            session.setAttribute("curentUser.username", currentUser.getUsername());
        }
        ByteSource byteSource = ByteSource.Util.bytes(username);
        return new SimpleAuthenticationInfo(username, s.getPassword(), byteSource, getName());
    }
}

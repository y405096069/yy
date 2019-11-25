package com.nfdw.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nfdw.base.controller.BaseController;
import com.nfdw.common.SendSms;
import com.nfdw.core.annotation.Log;
import com.nfdw.core.shiro.ShiroUtil;
import com.nfdw.entity.*;
import com.nfdw.service.MenuService;
import com.nfdw.service.SysUserService;
import com.nfdw.util.EhcacheUtil;
import com.nfdw.util.JSONUtils;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.VerifyCodeUtils;
import com.nfdw.utils.ShiroKitUtils;
import com.nfdw.utils.ToolUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.cache.ehcache.EhCache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.UUID;

/**
 * 登录、退出页面
 */
@Controller
@Slf4j
public class LoginController extends BaseController implements BaseLoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysUserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping(value = "/register")
    public String goRegister() {
        return "/register";
    }

    @PostMapping(value = "/register")
    public String register(SysUser sysUser, String code, Model model) {
        if (sysUser == null) {
            model.addAttribute("message", "获取数据失败");
        }
        if (StringUtils.isBlank(sysUser.getUsername())) {
            model.addAttribute("message", "用户名不能为空");
        }
        if (StringUtils.isBlank(sysUser.getVerifyPassword())) {
            model.addAttribute("message", "密码不能为空");
        }
        String username = sysUser.getUsername();
        SysUser user = userService.login(username);
        try {
            if (null != user) {
                model.addAttribute("message", "该手机号码已经绑定");
            } else {
                Object cache = EhcacheUtil.getCache(cacheManager, username);
                if (cache == null || code == null) {
                    model.addAttribute("message", "验证码有误");
                } else {
                    if (code.equals(cache)) {
                        user = new SysUser();
                        user.setUsername(username);
                        user.setPassword(sysUser.getVerifyPassword());
                        userService.addStudent(user);
                        model.addAttribute("message", "注册成功,可以跳转登录");
                        return "redirect:/login";
                    } else {
                        model.addAttribute("message", "验证码有误");
                    }
                }
            }
        } catch (Exception ex) {
            model.addAttribute("message", "注册失败");
        }
        return "/register";
    }

    @PostMapping(value = "/sendSms")
    @ResponseBody
    public JsonUtil sendSms(@RequestBody JSONObject body, HttpServletRequest request) throws MalformedURLException, UnsupportedEncodingException {
        String username = body.getString("username");
        int count = userService.checkUser(username);
        if (count > 0) {
            return JsonUtil.sucess("该手机号码已经绑定");
        } else {
            return send(username);
        }
    }

    private synchronized JsonUtil send(String username) throws MalformedURLException, UnsupportedEncodingException {
        Object cache = EhcacheUtil.getCache(cacheManager, username);
        if (null == cache) {
            SendSms sendSms = new SendSms();
            String vertifyCode = ToolUtil.getRandomNumString(4);

            String msg = sendSms.sendSMS(username, vertifyCode);
            EhcacheUtil.setCache(cacheManager, username, vertifyCode, 300);
            return JsonUtil.sucess(msg);
        } else {
            return JsonUtil.sucess("短信已经发送");
        }
    }

    @GetMapping("/main")
    @RequiresRoles("teacher")
    public String main() {
        return "main/main";
    }

    @GetMapping("/index")
    @RequiresRoles("student")
    public String studentIndex() {
        return "studentIndex";
    }

    @GetMapping("/getStudentUser")
    public String getStudentUser() {
        return "addStudentUser";
    }

    @Log(desc = "用户退出平台")
    @GetMapping(value = "/out")
    public String logout() throws IOException {
        CurrentUser user = ShiroUtil.getCurrentUse();
        if (user != null) {
            userService.updateByIdStatus(user.getId(), 0);
        }
        return "redirect:logout";
    }

    /**
     * 组装菜单json格式
     * update by 17/12/13
     *
     * @return
     */
    public JSONArray getMenuJson() {
        List<SysMenu> mList = menuService.getMenuNotSuper();
        JSONArray jsonArr = new JSONArray();
        for (SysMenu sysMenu : mList) {
            SysMenu menu = getChild(sysMenu.getId());
            jsonArr.add(menu);
        }
        return jsonArr;
    }

    public SysMenu getChild(String id) {
        SysMenu sysMenu = menuService.selectByPrimaryKey(id);
        List<SysMenu> mList = menuService.getMenuChildren(id);
        for (SysMenu menu : mList) {
            SysMenu m = getChild(menu.getId());
            //sysMenu.addChild(m);
        }
        return sysMenu;
    }


    @GetMapping(value = "/getCode")
    public void getYzm(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpg");

            //生成随机字串
            String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
            //log.info("verifyCode:{}", verifyCode);
            //存入会话session
            HttpSession session = request.getSession(true);
            session.setAttribute("_code", verifyCode.toLowerCase());
            //生成图片
            int w = 146, h = 33;
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/menuMain")
    public ModelAndView menuMain(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("main/main");
        String type = request.getParameter("type");
        String url = request.getParameter("url");
        String name = request.getParameter("name");
        mv.addObject("type", type);
        mv.addObject("url", url);
        mv.addObject("name", name);
        return mv;
    }

    @RequestMapping("/domain")
    public ModelAndView domain(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("main/main");
        Subject subject = ShiroUtil.getSubject();
        String type = request.getParameter("type");
        String url = request.getParameter("url");
        String name = request.getParameter("name");
        String tokendate = request.getParameter("tokendate");
        String sessTokendate = (String) subject.getSession().getAttribute("tokendate");
        String cardType = request.getParameter("cardType");
        String value = request.getParameter("cardValue");
        if (sessTokendate != null && !"".equals(sessTokendate)) {
            if (!tokendate.equals(sessTokendate)) {
                mv.addObject("cardType", cardType);
                mv.addObject("cardValue", value);
            }
        } else {
            mv.addObject("cardType", cardType);
            mv.addObject("cardValue", value);
        }
        Session session = subject.getSession();
        session.setAttribute("tokendate", tokendate);
        mv.addObject("type", type);
        mv.addObject("url", url);
        mv.addObject("name", name);
        return mv;

    }

    @Override
    public String goLogin(Model model) {
        Subject sub = SecurityUtils.getSubject();
        if (sub.isAuthenticated()) {
            CurrentUser auth = (CurrentUser) sub.getSession().getAttribute("curentUser");
            if (null != auth.getCurrentRoleList() && auth.getCurrentRoleList().size() > 0) {
                for (CurrentRole currentRole : auth.getCurrentRoleList()) {
                    if ("teacher".equals(currentRole.getRoleName())) {
                        return "redirect:/main";
                    } else if ("student".equals(currentRole.getRoleName())) {
                        return "redirect:/index";
                    } else {
                        logger.debug("缺乏角色对应teacher或student");
                        sub.logout();
                        throw new UnknownAccountException("登录失败,请联系管理员");
                    }
                }
            }
        }
        return "/login";
    }

    @Override
    public String login(SysUser user, String code, Model model, HttpServletRequest request) {
        String codeMsg = (String) request.getSession().getAttribute("_code");
        if (null != code && !code.toLowerCase().equals(codeMsg)) {
            model.addAttribute("message", "验证码错误");
            return "/login";
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername().trim(),
                user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        String msg = null;
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                CurrentUser auth = (CurrentUser) subject.getSession().getAttribute("curentUser");
                if (null != auth.getCurrentRoleList() && auth.getCurrentRoleList().size() > 0) {
                    for (CurrentRole currentRole : auth.getCurrentRoleList()) {
                        if ("teacher".equals(currentRole.getRoleName())) {
                            return "redirect:/main";
                        } else if ("student".equals(currentRole.getRoleName())) {
                            return "redirect:/index";
                        } else {
                            logger.debug("缺乏角色对应teacher或student");
                            subject.logout();
                            throw new UnknownAccountException("登录失败,请联系管理员");
                        }
                    }
                }
            }
        } catch (UnknownAccountException e) {
            msg = e.getMessage();
        } catch (IncorrectCredentialsException e) {
            msg = "用户名/密码错误";
        } catch (ExcessiveAttemptsException e) {
            msg = e.getMessage();
        }
        if (msg != null) {
            model.addAttribute("message", msg);
        }
        return "/login";
    }
}

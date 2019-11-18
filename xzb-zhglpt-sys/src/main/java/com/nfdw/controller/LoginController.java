package com.nfdw.controller;

import com.alibaba.fastjson.JSONArray;
import com.nfdw.common.SendSms;
import com.nfdw.core.annotation.Log;
import com.nfdw.core.shiro.ShiroUtil;
import com.nfdw.entity.*;
import com.nfdw.service.MenuService;
import com.nfdw.service.SysUserService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.VerifyCodeUtils;
import com.nfdw.utils.ShiroKitUtils;
import com.nfdw.utils.ToolUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.UUID;

/**
 * 登录、退出页面
 */
@Controller
@Slf4j
public class LoginController extends BaseLoginController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "")
    public String loginInit(String type) {
        return loginCheck(type);
    }

    @GetMapping(value = "goLogin")
    public String goLogin(Model model, ServletRequest request) {
        System.out.println("333333333333333333333333333");
        Subject sub = SecurityUtils.getSubject();
        if (sub.isAuthenticated()) {
            return "/main/main";
        } else {
            model.addAttribute("message", "请重新登录");
            return "/login";
        }
    }
//    @GetMapping(value = "/addStudentUser")
//    public String addStudentUser() {
//        System.out.println("4");
//        return "/system/user/add-student-user";
//    }

    @GetMapping(value = "/login")
    public String loginCheck(String type) {

        System.out.println("11111111111111111111");
        if(null==type||("").equals(type)){
            System.out.println("1111111222221111111111");
            Subject sub = SecurityUtils.getSubject();
            Boolean flag2 = sub.isRemembered();
            boolean flag = sub.isAuthenticated() || flag2;
            Session session = sub.getSession();
            if (flag) {
                return "/main/main";
            }
        }else if("1".equals(type)){
            return "addStudentUser";
        }else if("2".equals(type)){
            return "/login";
        }
        return "/login";
    }

    /**
     * 登录动作
     *
     * @param user
     * @param model
     * @param request
     * @return
            */
    @ApiOperation(value = "/login", httpMethod = "POST", notes = "登录method")
    @PostMapping(value = "/login")
    @Log(desc = "登录用户")
    @Override
    public String login(SysUser user, String code, Model model, HttpServletRequest request,String type) {
        if(("1").equals(type)){
             return "/login";
        }else if(("2").equals(type)){
            if (user == null) {
                return "1";
            }
            if (StringUtils.isBlank(user.getUsername())) {
                return "1";
            }
            if (StringUtils.isBlank(user.getPassword())) {
                return "1";
            }
            if (StringUtils.isBlank(user.getVerifyPassword())) {
                return "1";
            }
            int result = userService.checkUser(user.getUsername());
            if (result > 0) {
                return "2";
            }
            JsonUtil j = new JsonUtil();
            user.setId(UUID.randomUUID().toString().replaceAll("\\-", ""));
//            user.setPhoto("".equals(user.getPhoto()) ? null : user.getPhoto());
//            if (StringUtils.isNotEmpty(user.getPhoto())) {
//                user.setPhoto(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/images/" + user.getPhoto());
//            }

            user.setUser_type("1");
            user.setStatus(1);
            if (userService.addSysUser(user)>0){
                return "3";
            }else{
                return "4";
            }
        }else if(("3").equals(type)){
            String vertifyCode = ToolUtil.getRandomNumString(4);
            //发送短信
            SendSms sendSms = new SendSms();
            try {
                System.out.println(vertifyCode);
                sendSms.sendSMS(user.getUsername(),vertifyCode);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            ShiroKitUtils.setSessionAttr(user.getUsername(),vertifyCode,"60000");
            if(user.getUsername()!=null){
                return "1";
            }else{
                return "2";
            }
        }else{
            user.setUser_type(userService.getStudentType(user.getUsername()));
            return super.login(user, code, model, request,type);
        }
    }

    @GetMapping("/main")
    public String main() {
        return "main/main";
    }
    @GetMapping("/studentIndex")
    public String studentIndex() {
        return "studentIndex";
    }
    @GetMapping("/getStudentUser")
    public String getStudentUser(){
        return "addStudentUser";
    }
    @PostMapping("/addStudentUser")
    public String addStudentUser(SysUser user){
        if(userService.addSysUser(user)>0){
            return "login";
        }
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
}

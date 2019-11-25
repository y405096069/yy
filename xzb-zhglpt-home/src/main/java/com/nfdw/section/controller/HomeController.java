package com.nfdw.section.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nfdw.dto.CallBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nfdw.base.controller.BaseController;
import com.nfdw.service.HomeService;

import java.io.IOException;

/**
 * 首页管理
 */
//@Api(value="user")
@Controller
@RequestMapping(value = "/home")
public class HomeController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
    //private static final Logger
    @Resource
    private HomeService homeService;


    @Resource
    private CallBack callBack;

    @RequestMapping(value = "showHomeModel")
    public String showHome(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        return "/home/newHomeShow";
    }

}

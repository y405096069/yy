package com.nfdw.controller;/**
 * @author caisheng
 * @create 2019-11-20 9:38
 */

import com.nfdw.service.AccurateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author caisheng
 * @create 2019-11-20 9:38
 */
@Controller
@RequestMapping(value = "/Accutate")
public class AccurateController {
    @Autowired
    AccurateService accurateService;

    @GetMapping(value = "/zhunkao")
    public String Accutatrzhunkao() {
        return "/system/accutrate/examinationList";
    }


    @GetMapping(value = "/add")
    public String Accutatrzhunkaoadd() {
        return "/system/accutrate/studInforColl";
    }


    @GetMapping(value = "/huixian")
    public void huixian(Model model){
       model.addAttribute("list",accurateService.selectAll());
    }

}

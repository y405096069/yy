package com.nfdw.controller;

import com.nfdw.entity.SpecManagement;
import com.nfdw.service.SpecManagementService;
import com.nfdw.util.ReType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/18
 * @Description:
 */
@Controller
@RequestMapping("/spec_manage")
public class SpecManagementController {


    @Autowired
    private SpecManagementService service;

    @GetMapping(value = "goSpec")
    public String goSpec(Model model, ServletRequest request){
        return "/system/spec/specList";
    }


    @GetMapping(value = "showSpecList")
    @ResponseBody
    public ReType showSpecList(Model model, SpecManagement specManagement, String page, String limit) {
        return service.show(specManagement,Integer.valueOf(page), Integer.valueOf(limit));
    }
}

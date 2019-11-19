package com.nfdw.controller;

import com.nfdw.service.ProfessionQualifiedService;
import com.nfdw.service.impl.ProfessionQualifiedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/professionQualified")
public class ProfessionQualifiedController {

    @Autowired
    ProfessionQualifiedService professionQualifiedService;

    @RequestMapping("/list")
    public String list(){
        return "/system/student/professionQualified";
    }


    @ResponseBody
    @RequestMapping("/map")
    public Map<String, List> map(){
        Map<String, List> map = new HashMap<String, List>();

        Integer qualifiedAvg=professionQualifiedService.QualifiedAvg();
        Integer qualifiedNumber=professionQualifiedService.QualifiedNumber();

        List<Object> qualifiedAvgList = new ArrayList();
        List<Object> qualifiedNumberList = new ArrayList();

        qualifiedAvgList.add(qualifiedAvg);
        qualifiedNumberList.add(qualifiedNumber);

        map.put("qualifiedAvgList", qualifiedAvgList);
        map.put("qualifiedNumberList", qualifiedNumberList);

        return map;
    }





}

package com.nfdw.controller;

import com.nfdw.service.impl.ExamineeDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/examineeData")
public class ExamineeDataController {

    @Autowired
    ExamineeDataServiceImpl examineeDataService;

    @GetMapping("/list")
    public String showAuthentication() {

        return "/system/student/examineeData";
    }



    @ResponseBody
    @RequestMapping("/map")
    public Map<String, List> list(){
        Map<String, List> map = new HashMap<String, List>();

        Integer man=examineeDataService.man();
        Integer goddess=examineeDataService.goddess();
        Integer freshGraduate=examineeDataService.freshGraduate();
        Integer formerGraduate=examineeDataService.formerGraduate();
        Integer ethnicHan=examineeDataService.ethnicHan();
        Integer nationalMinority=examineeDataService.nationalMinority();
        Integer science=examineeDataService.science();
        Integer arts=examineeDataService.arts();

        List<Object> manList = new ArrayList();
        List<Object> goddessList = new ArrayList();
        List<Object> freshGraduateList = new ArrayList();
        List<Object> formerGraduateList = new ArrayList();
        List<Object> ethnicHanList = new ArrayList();
        List<Object> nationalMinorityList = new ArrayList();
        List<Object> scienceList = new ArrayList();
        List<Object> artsList = new ArrayList();

        System.out.println(man);
        System.out.println(goddess);
        System.out.println(freshGraduate);
        System.out.println(formerGraduate);
        System.out.println(ethnicHan);

        manList.add(man);
        goddessList.add(goddess);
        freshGraduateList.add(freshGraduate);
        formerGraduateList.add(formerGraduate);
        ethnicHanList.add(ethnicHan);
        nationalMinorityList.add(nationalMinority);
        scienceList.add(science);
        artsList.add(arts);

        map.put("manList", manList);
        map.put("goddessList", goddessList);
        map.put("freshGraduateList", freshGraduateList);
        map.put("formerGraduateList", formerGraduateList);
        map.put("ethnicHanList", ethnicHanList);
        map.put("nationalMinorityList", nationalMinorityList);
        map.put("scienceList", scienceList);
        map.put("artsList", artsList);
        return map;
    }


}

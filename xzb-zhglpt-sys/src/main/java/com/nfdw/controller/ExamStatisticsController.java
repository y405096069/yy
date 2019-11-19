package com.nfdw.controller;

import com.nfdw.service.impl.CreaExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ExamStatistics")
public class ExamStatisticsController {

    @Autowired
    CreaExamServiceImpl creaExamService;


    @GetMapping("/toSelectExam")
    public String showAuthentication() {

        return "/system/student/exam";
    }



    @ResponseBody
    @RequestMapping("/selectExam")
    public Map<String, List> aa(){
        Map<String, List> map = new HashMap<String, List>();

        Integer integer=creaExamService.countPeople();
        BigDecimal bigDecimal=creaExamService.firstFee();
        BigDecimal bigDecimal2=creaExamService.reexamineFee();
        List<Object> list = new ArrayList();
        List<Object> list1 = new ArrayList();
        List<Object> list2= new ArrayList();
        List<Object> list3 = new ArrayList();

        list.add(integer);
        list1.add(bigDecimal);
        list2.add(bigDecimal2);

        map.put("aaa", list);
        map.put("data", list1);
        map.put("bbb", list2);
        return map;
    }




}

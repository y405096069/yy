package com.nfdw.controller;

import com.nfdw.service.RegistrationStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/registrationStatistics")
public class RegistrationStatisticsController {

    @Autowired
    RegistrationStatisticsService registrationStatisticsService;

    @RequestMapping("/list")
    public String list(){

        return "/system/student/registrationStatistics";
    }



    @ResponseBody
    @RequestMapping("/map")
    public Map<String, List> map(){
        Map<String, List> map = new HashMap<String, List>();
        Integer audited=registrationStatisticsService.Audited();
        Integer numberApplicants=registrationStatisticsService.NumberApplicants();
        Integer paid=registrationStatisticsService.Paid();
        Integer pendingPayment=registrationStatisticsService.PendingPayment();
//        Integer signUpSuccess=registrationStatisticsService.SignUpSuccess();
        Integer pendingReview=registrationStatisticsService.PendingReview();

        List<Object> auditedList=new ArrayList();
        List<Object> numberApplicantsList=new ArrayList();
        List<Object> paidList=new ArrayList();
        List<Object> pendingPaymentList=new ArrayList();
//        List<Object> signUpSuccessList=new ArrayList();
        List<Object> pendingReviewList=new ArrayList();

        auditedList.add(audited);
        numberApplicantsList.add(numberApplicants);
        paidList.add(paid);
        pendingPaymentList.add(pendingPayment);
//        auditedList.add(signUpSuccess);
        pendingReviewList.add(pendingReview);

        map.put("auditedList", auditedList);
        map.put("numberApplicantsList", numberApplicantsList);
        map.put("paidList", paidList);
        map.put("pendingPaymentList", pendingPaymentList);
//        map.put("signUpSuccessList", signUpSuccessList);
        map.put("pendingReviewList", pendingReviewList);
        return map;
    }

}

package com.nfdw.controller;

import com.nfdw.entity.AdmissionTicket;
import com.nfdw.service.AdmissionTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admissionTicket")
public class AdmissionTicketController {
    @Autowired
    AdmissionTicketService admissionTicketService;

    @RequestMapping("/getAll")
    public String admissionTicket(Model model){
        String id="31192a0ef43140bab6bd3273f02dfea4";
        AdmissionTicket admissionTicket=admissionTicketService.getById(id);
        model.addAttribute("list", admissionTicket);
        String a=admissionTicketService.getRemarks();
        System.out.println(a);
        model.addAttribute("a", a);
        return "/system/student/admissionTicket";
    }


}

package com.nfdw.controller;

import com.nfdw.entity.Subject;
import com.nfdw.service.SubjectService;
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
 * @Date: 2019/11/19
 * @Description:
 */
@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "goSubject")
    public String goSubject(Model model, ServletRequest request){
        return "/system/subject/subjectList";
    }

    @GetMapping(value = "showSubjectList")
    @ResponseBody
    public ReType showSpecList(Model model, Subject subject, String page, String limit) {
        return subjectService.show(subject,Integer.valueOf(page), Integer.valueOf(limit));
    }
}

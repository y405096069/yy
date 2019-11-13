
package com.nfdw.controller;
/*
 * @author caisheng
 * @create 2019-11-13 10:17
 */


import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Student;
import com.nfdw.entity.StudentUser;

import com.nfdw.entity.TheTestInformation;
import com.nfdw.pojo.Condition;
import com.nfdw.service.impl.DataManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author caisheng
 * @create 2019-11-13 10:17
 */
/*最新修改*/
@Controller
@RequestMapping("/dataManage")
public class DataManagementController {

    @Autowired
    DataManagementServiceImpl dataManagementService;

    /*所有学生部分信息*/
    @ResponseBody
    @RequestMapping("/Student")
    public PageInfo<Student> studentManage(Integer page, Integer pageSize) {
        return dataManagementService.datadisplay(page,pageSize);
    }

    /*单一学生详细信息*/
    @ResponseBody
    @RequestMapping("/Thedetailedinformation")
    public Student Thedetailedinformation(int id) {
        Student thedetailedinformation = dataManagementService.Thedetailedinformation(id);
        return thedetailedinformation;
    }

    /*考试审核信息*/
    @ResponseBody
    @RequestMapping("/Examinationreviewinformation")
    public List<TheTestInformation> Examinationreviewinformation(int id) {
        List<TheTestInformation> thetestinformationy = dataManagementService.Thetestinformationy(id);
        return thetestinformationy;
    }

    /*条件查询及分页*/
    @ResponseBody
    @RequestMapping("/selectUseIf")
    public PageInfo<Student> selectUseIf(Condition condition){
        PageInfo<Student> studentPageInfo = dataManagementService.selectUseIf(condition);
        return studentPageInfo;
    };






 }

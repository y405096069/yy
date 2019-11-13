package com.nfdw.controller;/**
 * @author caisheng
 * @create 2019-11-13 20:05
 */

import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Examinationstatistics;
import com.nfdw.pojo.Examination;
import com.nfdw.service.impl.AdministratoraccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author caisheng
 * @create 2019-11-13 20:05
 */

/*考试情况统计*/
    @RequestMapping("/Administratoraccount")
public class AdministratoraccountController {

    /*初始查询*/



    /*分页条件查询*/
    @Autowired
    AdministratoraccountServiceImpl administratoraccountService;

    @RequestMapping("/Examination")
    @ResponseBody
    public PageInfo<Examinationstatistics> Examinationstatistics(Examination examination){
        PageInfo<Examinationstatistics> examinationstatistics = administratoraccountService.Examinationstatistics(examination);
        return examinationstatistics;
    }



    /*初始分页查询*/
    @RequestMapping("/Examinationstatistics")
    @ResponseBody
    public PageInfo<Examinationstatistics> Examinationstatisticsimpl(Integer page,Integer pageSize){
        PageInfo<Examinationstatistics> examinationstatistics = administratoraccountService.Examinationstatisticsimpl(page,pageSize);
        return examinationstatistics;
    }



    /*搜索查询*/























}

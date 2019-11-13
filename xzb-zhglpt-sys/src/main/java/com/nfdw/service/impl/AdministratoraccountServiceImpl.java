package com.nfdw.service.impl;/**
 * @author caisheng
 * @create 2019-11-13 21:49
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Examinationstatistics;
import com.nfdw.entity.Student;
import com.nfdw.mapper.AdministratoraccountMapper;
import com.nfdw.pojo.Examination;
import com.nfdw.service.AdministratoraccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author caisheng
 * @create 2019-11-13 21:49
 */
public class AdministratoraccountServiceImpl implements AdministratoraccountService {

    @Autowired
    AdministratoraccountMapper administratoraccountMapper;

    @Override
    public PageInfo<Examinationstatistics> Examinationstatistics(Examination examination) {
        PageInfo<Examinationstatistics> pageInfo = null;
        try{
            PageHelper.startPage(examination.page,examination.pageSize);
            List<Examinationstatistics> articleList = administratoraccountMapper.Examinationstatistics(examination);
            pageInfo = new PageInfo<Examinationstatistics>(articleList);
        }catch(Exception e){
            e.printStackTrace();
        }

        return pageInfo;
    }

    @Override
    public PageInfo<Examinationstatistics> Examinationstatisticsimpl(Integer page,Integer pageSize) {
        PageInfo<Examinationstatistics> pageInfo = null;
        try{
            PageHelper.startPage(page,pageSize);
            List<Examinationstatistics> articleList = administratoraccountMapper.Examinationstatisticsimpl();
            pageInfo = new PageInfo<Examinationstatistics>(articleList);
        }catch(Exception e){
            e.printStackTrace();
        }

        return pageInfo;

    }
}

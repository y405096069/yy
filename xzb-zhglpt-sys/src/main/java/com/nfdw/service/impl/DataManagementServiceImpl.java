package com.nfdw.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Student;
import com.nfdw.entity.TheTestInformation;
import com.nfdw.mapper.DataManageMapper;
import com.nfdw.pojo.Condition;
import com.nfdw.service.DataManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



//数据统计

@Service
public class DataManagementServiceImpl implements DataManagementService {
    @Autowired
   private DataManageMapper dataManageMapper;

    @Override
    public PageInfo<Student> datadisplay(Integer page, Integer pageSize) {
        PageInfo<Student> pageInfo = null;
        try{
            PageHelper.startPage(page,pageSize);
            List<Student> articleList = dataManageMapper.datadisplay();
            pageInfo = new PageInfo<Student>(articleList);
        }catch(Exception e){
            e.printStackTrace();
        }

        return pageInfo;
    }

    @Override
    public Student Thedetailedinformation(int id) {
        Student thedetailedinformation = dataManageMapper.Thedetailedinformation(id);
        return thedetailedinformation;
    }

    @Override
    public List<TheTestInformation> Thetestinformationy(int id) {

        List<TheTestInformation> thetestinformationy = dataManageMapper.Thetestinformationy(id);
        return thetestinformationy;
    }

    public PageInfo<Student> selectUseIf(Condition condition){
        PageInfo<Student> pageInfo = null;
        try{
            PageHelper.startPage(condition.page,condition.pageSize);
            List<Student> articleList = dataManageMapper.selectUseIf(condition);
            pageInfo = new PageInfo<Student>(articleList);
        }catch(Exception e){
            e.printStackTrace();
        }

        return pageInfo;

    };


}

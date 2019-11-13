package com.nfdw.service;/**
 * @author caisheng
 * @create 2019-11-13 10:22
 */

import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Student;
import com.nfdw.entity.StudentUser;
import com.nfdw.entity.TheTestInformation;

import java.util.List;

/**
 * 数据信息管理
 * @author
 * @create 2019-11-13 10:22
 */
public interface DataManagementService {
    public PageInfo<Student> datadisplay(Integer page, Integer pageSize);

    public Student Thedetailedinformation(int id);

    public List<TheTestInformation> Thetestinformationy(int id);



}

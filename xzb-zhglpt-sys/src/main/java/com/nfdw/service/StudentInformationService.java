package com.nfdw.service;/**
 * @author caisheng
 * @create 2019-11-13 21:48
 */

import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Examinationstatistics;
import com.nfdw.entity.StudentInformation;
import com.nfdw.pojo.Examination;

/**
 * 考试情况统计
 * @author
 * @create 2019-11-13 21:48
 */
public interface StudentInformationService {

    //添加学员基本信息
    int addStudentInformation(StudentInformation studentInformation);
    //按学生用户ID查找该学生基本信息
    StudentInformation getUserIDByStudentInformation(String name);


}

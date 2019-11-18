package com.nfdw.service;

import com.nfdw.entity.StudentInformation;

public interface StudentInformationService {
    //添加学员基本信息
    int addStudentInformation(StudentInformation studentInformation);
    //按学生用户ID查找该学生基本信息
    StudentInformation getUserIDByStudentInformation(String name);
}

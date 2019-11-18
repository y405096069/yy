package com.nfdw.mapper;

import com.nfdw.entity.StudentInformation;
import org.apache.ibatis.annotations.Param;

public interface StudentInformationMapper {
    //添加学员基本信息
    int addStudentInformation(StudentInformation studentInformation);
    //按学生用户账号查找该学生基本信息
    StudentInformation getUserIDByStudentInformation(@Param("name")String name);
}

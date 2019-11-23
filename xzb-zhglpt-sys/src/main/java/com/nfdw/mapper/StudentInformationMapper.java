package com.nfdw.mapper;

import com.nfdw.entity.Examination;
import com.nfdw.entity.StudentExamAudit;
import com.nfdw.entity.StudentInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInformationMapper {
    //添加学员基本信息
    int addStudentInformation(StudentInformation studentInformation);
    //按学生用户账号查找该学生基本信息
    StudentInformation getUserIDByStudentInformation(@Param("name")String name);
    //按学生用户和当前日期查找报考信息
    List<Examination> getListExamination(@Param("create_start_time")String create_start_time,@Param("exam")String exam,@Param("name")String name,@Param("studentInformation")StudentInformation studentInformation,@Param("currentDate ") String currentDate);
    //学生上传文件审核
    int addStudentExamAudit(StudentExamAudit studentInformation);
}

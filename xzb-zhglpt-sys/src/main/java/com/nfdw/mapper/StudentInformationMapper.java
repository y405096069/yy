package com.nfdw.mapper;

import com.nfdw.entity.Examination;
import com.nfdw.entity.StudentExamAudit;
import com.nfdw.entity.StudentInformation;
import com.nfdw.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentInformationMapper {
    //添加学员基本信息
    int addStudentInformation(StudentInformation studentInformation);
    //按学生用户账号查找该学生基本信息
    StudentInformation getUserIDByStudentInformation(@Param("name")String name);
    //按学生用户和当前日期查找报考信息
    List<Examination> getListExamination(@Param("currentDate") Date currentDate, @Param("examinee_province")String examinee_province,
                                         @Param("subject_type")String subject_type, @Param("examName")String examName, @Param("subjectName")String subjectName,
                                         @Param("create_start_time")Date create_start_time);
    //学生上传文件审核
    int addStudentExamAudit(StudentExamAudit studentExamAudit);
    //根据用戶账号查询学生信息总数
    int getStudentInfoConunt(@Param("username")String username);
}

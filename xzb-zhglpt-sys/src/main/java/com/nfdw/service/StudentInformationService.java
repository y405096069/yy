package com.nfdw.service;/**
 * @author caisheng
 * @create 2019-11-13 21:48
 */

import com.github.pagehelper.PageInfo;
import com.nfdw.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    //按学生用户和当前日期查找报考信息
    List<Examination> getListExamination(String currentDate,String examinee_province,String subject_type,String examName,String subjectName,String create_start_time);
    //学生上传文件审核
    int addStudentExamAudit(StudentExamAudit studentExamAudit);
    //根据用戶账号查询学生信息总数
    int getStudentInfoConunt(String username);

    StudentInformation getStudentInfoByUserId(String id);
}

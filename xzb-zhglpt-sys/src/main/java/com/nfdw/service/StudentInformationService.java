package com.nfdw.service;/**
 * @author caisheng
 * @create 2019-11-13 21:48
 */

import com.github.pagehelper.PageInfo;
import com.nfdw.entity.Examination;
import com.nfdw.entity.Examinationstatistics;
import com.nfdw.entity.StudentInformation;
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
    List<Examination> getListExamination(String create_start_time,String exam,String name,StudentInformation studentInformation,String currentDate);

}

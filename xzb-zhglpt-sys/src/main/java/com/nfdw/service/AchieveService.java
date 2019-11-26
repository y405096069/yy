package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AchieveService extends BaseService<Achievement_Summary, String> {

    String[] selectAllHigh_province();

    String[] selectAllHigh_provinceByEId(int eid);

    Achievement_Summary getIdByExam_num(String exe_num); //考生号

    List<Achievement_Summary > selectListByPage2(int exam_id,String qualified_mark);

    String selectSpecialty_NameById(int id);

    Achievement_Summary getAchieveById_Card( String id_card);

    boolean updFirst_GradeByEId(int eid);

    boolean updComplex_GradeByEId(int eid);

    boolean updAchieve_Grade(Achievement_Summary a_sum);

    int selectFirstNational_same_name( int exam_id,String professional_name,
                                      String high_province,double first_subjects_total);

    int selectLastNational_same_name( int exam_id,String professional_name,
                                      String high_province,double total_score);

    StudentInformation selectStudentByUid(String student_userid);

    boolean addAchieve(Achievement_Summary a_sum);

    Examination getExamByEid(int exam_id);

    SpecManagement getSpcById(int id);

    List<Cskmqz> getByEid( int exam_id);

    List<Fskmqz> getByEid2(int exam_id);

}

package com.nfdw.mapper;


import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Achievement_Summary;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AchieveMapper extends BaseMapper<Achievement_Summary,String> {

    String[] selectAllHigh_province();

    String[] selectAllHigh_provinceByEId(@Param("eid")int eid);

    Achievement_Summary getIdByExam_num(@Param("exe_num") String exe_num); //考生号

    List<Achievement_Summary >selectListByPage2(@Param("exam_id") int exam_id,@Param("qualified_mark") String qualified_mark);

    String selectSpecialty_NameById(@Param("id")int id);

    int updFirst_GradeByEId(@Param("eid")int eid);     //清除所有初试成绩

    int updComplex_GradeByEId(@Param("eid")int eid);     //清除所有复试成绩

    Achievement_Summary getAchieveById_Card(@Param("id_card") String id_card); //根据身份证查询

    int updAchieve_Grade(Achievement_Summary a_sum);

    //初试全国同名次人数(省同名次人数)
    int selectFirstNational_same_name(@Param("exam_id") int exam_id,@Param("professional_name") String professional_name,
                                      @Param("high_province") String high_province,
                                      @Param("first_subjects_total") double first_subjects_total);

    //复试全国同名次人数(省同名次人数)
    int selectLastNational_same_name(@Param("exam_id") int exam_id,@Param("professional_name") String professional_name,
                                      @Param("high_province") String high_province,
                                      @Param("total_score") double total_score);




}

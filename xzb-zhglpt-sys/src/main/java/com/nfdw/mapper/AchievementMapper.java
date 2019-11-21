package com.nfdw.mapper;


import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.entity.Examination;
import org.apache.ibatis.annotations.Param;


public interface AchievementMapper extends BaseMapper<Examination,String> {

    int updateGrade_switch(@Param("id") int id, @Param("grade") int grade);

    int addFirstGrade(Achievement_Summary as);

    int delFirstGradeByEId(@Param("id") int id);



}

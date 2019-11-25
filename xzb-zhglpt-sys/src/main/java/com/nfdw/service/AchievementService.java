package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.entity.Examination;
import org.apache.ibatis.annotations.Param;

public interface AchievementService extends BaseService<Examination, String> {

    boolean updateGrade_switch(int id, int grade);

    boolean updateGrade_switch2(int id, int grade2);

    boolean addFirstGrade(Achievement_Summary as);

    boolean delFirstGradeByEId(int id);

    boolean updateGrade_Hgswitch( int id, int certificate);

    Examination selectExamination(String exam,String specialty_name);

}

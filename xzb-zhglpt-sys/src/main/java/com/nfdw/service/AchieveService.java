package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.Achievement_Summary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AchieveService extends BaseService<Achievement_Summary, String> {

    String[] selectAllHigh_province();

    Achievement_Summary getIdByExam_num(String exe_num); //考生号

    List<Achievement_Summary > selectListByPage2(int exam_id);

}

package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.mapper.AchieveMapper;
import com.nfdw.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AchieveServiceImpl extends BaseServiceImpl<Achievement_Summary, String> implements AchieveService {

    @Autowired
    AchieveMapper acMapper;

    @Override
    public BaseMapper<Achievement_Summary, String> getMappser() {
        return acMapper;
    }

    @Override
    public String[] selectAllHigh_province() {
        return acMapper.selectAllHigh_province();
    }

    @Override
    public Achievement_Summary getIdByExam_num(String exe_num) {
        return acMapper.getIdByExam_num(exe_num);
    }

    @Override
    public List<Achievement_Summary> selectListByPage2(int exam_id) {
        return acMapper.selectListByPage2(exam_id);
    }
}

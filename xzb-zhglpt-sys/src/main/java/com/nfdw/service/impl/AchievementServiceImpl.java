package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.entity.Examination;
import com.nfdw.mapper.AchievementMapper;
import com.nfdw.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AchievementServiceImpl extends BaseServiceImpl<Examination, String> implements AchievementService {

    @Autowired
    AchievementMapper acMapper;

    @Override
    public BaseMapper<Examination, String> getMappser() {
        return acMapper;
    }

    @Override
    public boolean updateGrade_switch(int id, int grade) {
        return acMapper.updateGrade_switch(id,grade)>0;
    }

    @Override
    public boolean updateGrade_switch2(int id, int grade2) {
        return acMapper.updateGrade_switch2(id, grade2)>0;
    }

    @Override
    public boolean addFirstGrade(Achievement_Summary as) {
        return acMapper.addFirstGrade(as)>0;
    }

    @Override
    public boolean delFirstGradeByEId(int id) {
        return acMapper.delFirstGradeByEId(id)>0;
    }
}

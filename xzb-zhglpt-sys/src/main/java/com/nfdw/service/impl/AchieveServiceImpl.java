package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.mapper.AchieveMapper;
import com.nfdw.service.AchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AchieveServiceImpl extends BaseServiceImpl<Achievement_Summary, String> implements AchieveService {

    @Autowired
    AchieveMapper acMapper;

    @Override
    public BaseMapper<Achievement_Summary, String> getMappser() {
        return acMapper;
    }

}

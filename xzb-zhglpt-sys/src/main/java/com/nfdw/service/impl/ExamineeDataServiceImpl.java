package com.nfdw.service.impl;

import com.nfdw.mapper.ExamineeDataMapper;
import com.nfdw.service.ExamineeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamineeDataServiceImpl implements ExamineeDataService {

    @Autowired
    ExamineeDataMapper examineeDataMapper;

    @Override
    public Integer man() {
        return examineeDataMapper.man();
    }

    @Override
    public Integer goddess() {
        return examineeDataMapper.goddess();
    }

    @Override
    public Integer freshGraduate() {
        return examineeDataMapper.freshGraduate();
    }

    @Override
    public Integer formerGraduate() {
        return examineeDataMapper.formerGraduate();
    }

    @Override
    public Integer ethnicHan() {
        return examineeDataMapper.ethnicHan();
    }

    @Override
    public Integer nationalMinority() {
        return examineeDataMapper.nationalMinority();
    }

    @Override
    public Integer science() {

        return examineeDataMapper.science();
    }

    @Override
    public Integer arts() {

        return examineeDataMapper.arts();
    }
}

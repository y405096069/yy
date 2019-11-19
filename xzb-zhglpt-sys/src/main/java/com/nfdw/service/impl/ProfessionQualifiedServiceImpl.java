package com.nfdw.service.impl;

import com.nfdw.mapper.ProfessionQualifiedMapper;
import com.nfdw.service.ProfessionQualifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionQualifiedServiceImpl implements ProfessionQualifiedService {
    @Autowired
    ProfessionQualifiedMapper professionQualifiedMapper;

    @Override
    public Integer QualifiedAvg() {
        return professionQualifiedMapper.QualifiedAvg();
    }

    @Override
    public Integer QualifiedNumber() {
        return professionQualifiedMapper.QualifiedNumber();
    }
}

package com.nfdw.service.impl;

import com.nfdw.mapper.CreaExamMapper;
import com.nfdw.service.CreaExamService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreaExamServiceImpl implements CreaExamService {

    @Autowired
    CreaExamMapper creaExamMapper;

    @Override
    public Integer countPeople() {
        return creaExamMapper.countPeople();
    }

    @Override
    public BigDecimal firstFee() {
        return creaExamMapper.firstFee();
    }

    @Override
    public BigDecimal reexamineFee() {
        return creaExamMapper.reexamineFee();
    }
}

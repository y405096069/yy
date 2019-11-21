package com.nfdw.service.impl;/**
 * @author caisheng
 * @create 2019-11-20 16:19
 */

import com.nfdw.entity.Examination;
import com.nfdw.mapper.AccurateMapper;
import com.nfdw.service.AccurateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author caisheng
 * @create 2019-11-20 16:19
 */
@Service
@Transactional
public class AccurateServiceimpl implements AccurateService {

    @Autowired
    AccurateMapper accurateMapper;


    @Override
    public List<Examination> selectAll() {
        return accurateMapper.selectAll();
    }
}

package com.nfdw.service.impl;

import com.nfdw.mapper.RegistrationStatisticsMapper;
import com.nfdw.service.RegistrationStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationStatisticsServiceImpl implements RegistrationStatisticsService {

    @Autowired
    RegistrationStatisticsMapper registrationStatisticsMapper;

    @Override
    public Integer NumberApplicants() {
        return registrationStatisticsMapper.NumberApplicants();
    }

    @Override
    public Integer PendingReview() {
        return registrationStatisticsMapper.PendingReview();
    }

    @Override
    public Integer Audited() {
        return registrationStatisticsMapper.Audited();
    }

    @Override
    public Integer PendingPayment() {
        return registrationStatisticsMapper.PendingPayment();
    }

    @Override
    public Integer Paid() {
        return registrationStatisticsMapper.Paid();
    }

    @Override
    public Integer SignUpSuccess() {
        return registrationStatisticsMapper.SignUpSuccess();
    }
}

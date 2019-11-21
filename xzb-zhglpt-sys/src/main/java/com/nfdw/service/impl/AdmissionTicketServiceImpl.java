package com.nfdw.service.impl;

import com.nfdw.entity.AdmissionTicket;
import com.nfdw.mapper.AdmissionTicketMapper;
import com.nfdw.service.AdmissionTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmissionTicketServiceImpl implements AdmissionTicketService {

    @Autowired
    private AdmissionTicketMapper admissionTicketMapper;

    @Override
    public AdmissionTicket getById(String id) {

        return admissionTicketMapper.getById(id);
    }

    @Override
    public String getRemarks() {

        return admissionTicketMapper.getRemarks();
    }
}

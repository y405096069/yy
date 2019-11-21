package com.nfdw.service;

import com.nfdw.entity.AdmissionTicket;
import org.apache.ibatis.annotations.Param;

public interface AdmissionTicketService {

    AdmissionTicket getById(@Param("id") String id);

    String getRemarks();

}

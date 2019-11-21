package com.nfdw.mapper;

import com.nfdw.base.BaseMapper;
import com.nfdw.entity.AdmissionTicket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdmissionTicketMapper extends BaseMapper<AdmissionTicket,String> {

    AdmissionTicket getById(@Param("id") String id);

    String getRemarks();




}

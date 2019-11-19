package com.nfdw.mapper;


import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Audit;
import com.nfdw.entity.Examinee_User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditMapper extends BaseMapper<Audit,String> {

    List<Audit> getAudit();

    Audit getAuditById(@Param("id") int id);

    int updAudit(Audit audit);

    Examinee_User getExaminee_UserById(@Param("id") int id);

}

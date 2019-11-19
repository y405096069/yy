package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.Audit;
import com.nfdw.entity.Examinee_User;

import java.util.List;

public interface AuditService extends BaseService<Audit, String> {

    List<Audit> getAudit();

    Audit getAuditById(String id);

    boolean updAudit(Audit audit);

    Examinee_User getExaminee_UserById(int id);
}

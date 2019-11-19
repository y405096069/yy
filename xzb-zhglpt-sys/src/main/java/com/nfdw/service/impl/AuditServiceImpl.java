package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.Audit;
import com.nfdw.entity.Examinee_User;
import com.nfdw.mapper.AuditMapper;
import com.nfdw.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditServiceImpl extends BaseServiceImpl<Audit, String> implements AuditService {

    @Autowired
    AuditMapper auditMapper;

    @Override
    public BaseMapper<Audit, String> getMappser() { return auditMapper; }

    @Override
    public List<Audit> getAudit() {
        return auditMapper.getAudit();
    }

    @Override
    public Audit getAuditById(String id) {
        return auditMapper.getAuditById(Integer.valueOf(id));
    }

    @Override
    public boolean updAudit(Audit audit) {
        return auditMapper.updAudit(audit)>0;
    }

    @Override
    public Examinee_User getExaminee_UserById(int id) {
        return auditMapper.getExaminee_UserById(id);
    }
}

package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.Audit;
import com.nfdw.entity.Examinee_User;
import com.nfdw.entity.StudentInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditService extends BaseService<Audit, String> {

    List<Audit> getAudit();

    Audit getAuditById(String id);

    boolean updAudit(Audit audit);

    Examinee_User getExaminee_UserById(int id);

    boolean addAudit(Audit audit);

    StudentInformation getUserInfoById(String student_userid);

    String[] selectAllBiog_land();
}

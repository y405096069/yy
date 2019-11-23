package com.nfdw.mapper;


import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Audit;
import com.nfdw.entity.Examinee_User;
import com.nfdw.entity.StudentInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuditMapper extends BaseMapper<Audit,String> {

    List<Audit> getAudit();

    Audit getAuditById(@Param("id") int id);

    int updAudit(Audit audit);

    Examinee_User getExaminee_UserById(@Param("id") int id);

    int addAudit(Audit audit);

    StudentInformation getUserInfoById(@Param("student_userid")String student_userid);

    String[] selectAllBiog_land();

}

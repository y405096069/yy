package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.ApplicationAnnoun;

import java.util.List;

public interface ApplicationAnnounService extends BaseService<ApplicationAnnoun,String> {
    int deleteById(String id);
    int updateById(ApplicationAnnoun applicationAnnoun);
    ApplicationAnnoun selectGetByPrimaryKey(String id);
    List<ApplicationAnnoun> showMenuJsonList();
    List<ApplicationAnnoun> getAll();
}

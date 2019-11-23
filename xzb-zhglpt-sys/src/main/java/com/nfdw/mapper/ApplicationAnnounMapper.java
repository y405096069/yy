package com.nfdw.mapper;


import com.nfdw.base.BaseMapper;
import com.nfdw.entity.ApplicationAnnoun;

import java.util.List;

public interface ApplicationAnnounMapper extends BaseMapper<ApplicationAnnoun,String> {
    int deleteById(String id);
    int updateById(ApplicationAnnoun applicationAnnoun);
    ApplicationAnnoun selectGetByPrimaryKey(String id);
    List<ApplicationAnnoun> getAll();

}

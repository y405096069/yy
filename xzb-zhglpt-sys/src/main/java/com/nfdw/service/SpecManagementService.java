package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.SpecCollect;
import com.nfdw.entity.SpecManagement;

import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/18
 * @Description:
 */
public interface SpecManagementService extends BaseService<SpecManagement,String> {

    List<SpecCollect> selectSpecCollect();

    SpecCollect selectIdByName(String id);
}

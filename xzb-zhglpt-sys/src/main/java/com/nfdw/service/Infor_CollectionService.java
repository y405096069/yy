package com.nfdw.service;

import com.nfdw.base.service.BaseService;
import com.nfdw.entity.Infor_collection;
import com.nfdw.entity.Infor_collection_temp_norms;

import java.util.List;

public interface Infor_CollectionService extends BaseService<Infor_collection, String> {

    int addInfor_Collection(Infor_collection ic);

    boolean addInfor_Collection_Temp(Infor_collection_temp_norms ictn);

    int selectLastInfor_CollectionID();

    boolean updateTemplate_status(int id, String template_status);

    Infor_collection selectInforById(int id);

    List<Infor_collection_temp_norms> selectTemp_NormsByInforId(int id, String temp_norms_name);

    boolean updInfor_Collection(Infor_collection ic);

    boolean delTemp_NormsByInforId(int id);

    boolean delInfor_CollectionById(int id);

}

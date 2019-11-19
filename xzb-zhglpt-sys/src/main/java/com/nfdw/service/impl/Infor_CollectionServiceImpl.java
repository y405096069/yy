package com.nfdw.service.impl;

import com.nfdw.base.BaseMapper;
import com.nfdw.base.service.impl.BaseServiceImpl;
import com.nfdw.entity.Infor_collection;
import com.nfdw.entity.Infor_collection_temp_norms;
import com.nfdw.mapper.Infor_CollectionMapper;
import com.nfdw.service.Infor_CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Infor_CollectionServiceImpl extends BaseServiceImpl<Infor_collection, String> implements Infor_CollectionService {

    @Autowired
    Infor_CollectionMapper icm;

    @Override
    public BaseMapper<Infor_collection, String> getMappser() { return icm; }


    @Override
    public int addInfor_Collection(Infor_collection ic) {
        return icm.addInfor_Collection(ic);
    }

    @Override
    public boolean addInfor_Collection_Temp(Infor_collection_temp_norms ictn) {
        return icm.addInfor_Collection_Temp(ictn)>0;
    }

    @Override
    public int selectLastInfor_CollectionID() {
        return icm.selectLastInfor_CollectionID();
    }

    @Override
    public boolean updateTemplate_status(int id, String template_status) {
        return icm.updateTemplate_status(id,template_status)>0;
    }

    @Override
    public Infor_collection selectInforById(int id) {
        return icm.selectInforById(id);
    }

    @Override
    public List<Infor_collection_temp_norms> selectTemp_NormsByInforId(int id, String temp_norms_name) {
        return icm.selectTemp_NormsByInforId(id,temp_norms_name);
    }

    @Override
    public boolean updInfor_Collection(Infor_collection ic) {
        return icm.updInfor_Collection(ic)>0;
    }

    @Override
    public boolean delTemp_NormsByInforId(int id) {
        return icm.delTemp_NormsByInforId(id)>0;
    }

    @Override
    public boolean delInfor_CollectionById(int id) {
        return icm.delInfor_CollectionById(id)>0;
    }
}

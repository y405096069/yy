package com.nfdw.mapper;


import com.nfdw.base.BaseMapper;
import com.nfdw.entity.Infor_collection;
import com.nfdw.entity.Infor_collection_temp_norms;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Infor_CollectionMapper extends BaseMapper<Infor_collection,String> {

    int addInfor_Collection(Infor_collection ic);

    int addInfor_Collection_Temp(Infor_collection_temp_norms ictn);

    int selectLastInfor_CollectionID();

    int updateTemplate_status(@Param("id") int id, @Param("template_status") String template_status);

    Infor_collection selectInforById(@Param("id") int id);

    List<Infor_collection_temp_norms> selectTemp_NormsByInforId(@Param("id") int id, @Param("temp_norms_name") String temp_norms_name);

    int updInfor_Collection(Infor_collection ic);

    int delTemp_NormsByInforId(@Param("id") int id);

    int delInfor_CollectionById(@Param("id") int id);

}

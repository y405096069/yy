package com.nfdw.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "infor_collection_temp_norms")
@Data
public class Infor_collection_temp_norms {      //信息采集模板_规格

    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;

    private String temp_norms_name;       //模板规格名称

    private String temp_norms_desc;       //模板规格描述

    private int infor_collection_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTemp_norms_name() {
        return temp_norms_name;
    }

    public void setTemp_norms_name(String temp_norms_name) {
        this.temp_norms_name = temp_norms_name;
    }

    public String getTemp_norms_desc() {
        return temp_norms_desc;
    }

    public void setTemp_norms_desc(String temp_norms_desc) {
        this.temp_norms_desc = temp_norms_desc;
    }

    public int getInfor_collection_id() {
        return infor_collection_id;
    }

    public void setInfor_collection_id(int infor_collection_id) {
        this.infor_collection_id = infor_collection_id;
    }
}

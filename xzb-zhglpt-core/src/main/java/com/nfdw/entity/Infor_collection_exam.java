package com.nfdw.entity;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "infor_collection_exam")
@Data
public class Infor_collection_exam {       // 信息采集模板-考试-关系表

    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;

    private int infor_id;

    private int exam_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfor_id() {
        return infor_id;
    }

    public void setInfor_id(int infor_id) {
        this.infor_id = infor_id;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }
}

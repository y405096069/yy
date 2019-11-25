package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-23 16:43
 */

/**
 * @author caisheng
 * @create 2019-11-23 16:43
 */
public class Kc {
    private Integer id;
    //考试开始时间
    private String  kcreate_start_time;
    //考试结束时间
    private String  kcreate_end_time;
    //报考人数
    private String bkrs;
    //考场位置
    private String kcwz;
    //新建考试外键
    private String exam_id;
    //专业外键
    private String spec_id;

    public Integer getId() {
        return id;
    }

    public String getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(String spec_id) {
        this.spec_id = spec_id;
    }

    public String getKcreate_start_time() {
        return kcreate_start_time;
    }

    public void setKcreate_start_time(String kcreate_start_time) {
        this.kcreate_start_time = kcreate_start_time;
    }

    public String getKcreate_end_time() {
        return kcreate_end_time;
    }

    public void setKcreate_end_time(String kcreate_end_time) {
        this.kcreate_end_time = kcreate_end_time;
    }

    public String getBkrs() {
        return bkrs;
    }

    public void setBkrs(String bkrs) {
        this.bkrs = bkrs;
    }

    public String getKcwz() {
        return kcwz;
    }

    public void setKcwz(String kcwz) {
        this.kcwz = kcwz;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }
}

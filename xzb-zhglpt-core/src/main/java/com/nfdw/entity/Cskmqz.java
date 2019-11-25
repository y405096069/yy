package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-25 11:28
 */

/**
 * @author caisheng
 * @create 2019-11-25 11:28
 */
public class Cskmqz {

    private Integer id;
    //科目id
    private String kmid;
    //科目权重
    private String kmqz;
    //科目总分
    private String kmzf;

    public String getKmzf() {
        return kmzf;
    }

    public void setKmzf(String kmzf) {
        this.kmzf = kmzf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKmid() {
        return kmid;
    }

    public void setKmid(String kmid) {
        this.kmid = kmid;
    }

    public String getKmqz() {
        return kmqz;
    }

    public void setKmqz(String kmqz) {
        this.kmqz = kmqz;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    //考试id
    private int exam_id;

}

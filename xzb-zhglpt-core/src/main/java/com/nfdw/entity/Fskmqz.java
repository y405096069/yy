package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-25 14:16
 */

/**
 * @author caisheng
 * @create 2019-11-25 14:16
 */
public class Fskmqz {

    private Integer id;
    //科目id
    private String fskmid;
    //科目权重
    private String fskmqz;
    //科目总分
    private String fskmzf;
    //考试id
    private int exam_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFskmid() {
        return fskmid;
    }

    public void setFskmid(String fskmid) {
        this.fskmid = fskmid;
    }

    public String getFskmqz() {
        return fskmqz;
    }

    public void setFskmqz(String fskmqz) {
        this.fskmqz = fskmqz;
    }

    public String getFskmzf() {
        return fskmzf;
    }

    public void setFskmzf(String fskmzf) {
        this.fskmzf = fskmzf;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }
}

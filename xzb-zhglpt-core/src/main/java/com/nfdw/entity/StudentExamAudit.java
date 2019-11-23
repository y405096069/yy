package com.nfdw.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "j_student_examAudit")
@Data
@ToString
public class StudentExamAudit {
    //主键ID
    @Id
    @GeneratedValue(generator = "JDBC")
    private int id;
    //学生信息id
    private String informationId;
    //考试时间
    private int managemnetId;
    //学生协议同意状态
    private int agreement;
    //照片
    private String view;
    //自拍视屏
    private String viewScreen;
    //文件
    private String fileName;
    //音乐
    private String music;
    //上传描述
    private String description;
    //审核状态
    private String audutType;
    //处理意见
    private String handlingSuggestion;
    //上传时间
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInformationId() {
        return informationId;
    }

    public void setInformationId(String informationId) {
        this.informationId = informationId;
    }

    public int getManagemnetId() {
        return managemnetId;
    }

    public void setManagemnetId(int managemnetId) {
        this.managemnetId = managemnetId;
    }

    public int getAgreement() {
        return agreement;
    }

    public void setAgreement(int agreement) {
        this.agreement = agreement;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getViewScreen() {
        return viewScreen;
    }

    public void setViewScreen(String viewScreen) {
        this.viewScreen = viewScreen;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudutType() {
        return audutType;
    }

    public void setAudutType(String audutType) {
        this.audutType = audutType;
    }

    public String getHandlingSuggestion() {
        return handlingSuggestion;
    }

    public void setHandlingSuggestion(String handlingSuggestion) {
        this.handlingSuggestion = handlingSuggestion;
    }
}

package com.nfdw.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
信息发布
 */
@Table(name = "t_information_publish")
@Data
@ToString
@EqualsAndHashCode
public class InformationPublish {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "publish_name")
    private String publishName;//发布者姓名

    @Column(name = "publish_department")
    private String publishDepartment;//发布部门
    
    private String title;//标题
    
    @Column(name = "information_type")
    private String informationType;//信息类型
    
    @Column(name = "important_type")
    private String importantType;//重要程度

    @Column(name = "file_ids")
    private String fileIds;//附件编号

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    @Column(name = "publish_time")
    private Date publishTime;//发布时间

    @Transient
    private List<File> files;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPublishDepartment() {
        return publishDepartment;
    }

    public void setPublishDepartment(String publishDepartment) {
        this.publishDepartment = publishDepartment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformationType() {
        return informationType;
    }

    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }

    public String getImportantType() {
        return importantType;
    }

    public void setImportantType(String importantType) {
        this.importantType = importantType;
    }

    public String getFileIds() {
        return fileIds;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
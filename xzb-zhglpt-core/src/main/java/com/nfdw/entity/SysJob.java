package com.nfdw.entity;

import com.nfdw.validator.group.AddGroup;
import com.nfdw.validator.group.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Table(name = "sys_job")
@Data
@ToString
@EqualsAndHashCode
public class SysJob {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    /**
     * 描述任务
     */
    @NotEmpty(message = "任务描述不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Column(name = "job_name")
    private String jobName;

    /**
     * 任务表达式
     */
    @NotEmpty(message = "表达式不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String cron;

    /**
     * 状态:0未启动false/1启动true
     */
    private Boolean status;

    /**
     * 任务执行方法
     */
    @NotEmpty(message = "执行方法不能未空", groups = {AddGroup.class, UpdateGroup.class})
    @Column(name = "clazz_path")
    private String clazzPath;

    /**
     * 其他描述
     */
    @Column(name = "job_desc")
    private String jobDesc;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getClazzPath() {
        return clazzPath;
    }

    public void setClazzPath(String clazzPath) {
        this.clazzPath = clazzPath;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
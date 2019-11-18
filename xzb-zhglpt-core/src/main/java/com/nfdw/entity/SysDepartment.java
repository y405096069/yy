package com.nfdw.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "sys_department")
@Data
@ToString
@EqualsAndHashCode
public class SysDepartment {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "creater")
    private String creater;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "gzarea")
    private String gzarea;

    @Transient
    private List<SysUser> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getGzarea() {
        return gzarea;
    }

    public void setGzarea(String gzarea) {
        this.gzarea = gzarea;
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }
}

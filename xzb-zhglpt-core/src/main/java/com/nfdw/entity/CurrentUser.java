package com.nfdw.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CurrentUser implements Serializable {
    private String id;

    private String username;

    private String password;

    private Integer age;

    private String email;

    private String photo;

    private String realName;

    private String createBy;

    private String updateBy;

    private Date createDate;

    private Date updateDate;

    private Byte delFlag;
    
    private String gzarea;

   private List<CurrentMenu> currentMenuList;
   private List<CurrentRole> currentRoleList;
    private static final long serialVersionUID = 1L;

    public CurrentUser(String id, String username, Integer age, String email, String photo,
        String realName, String gzarea) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.email = email;
        this.photo = photo;
        this.realName = realName;
        this.gzarea = gzarea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public String getGzarea() {
        return gzarea;
    }

    public void setGzarea(String gzarea) {
        this.gzarea = gzarea;
    }

    public List<CurrentMenu> getCurrentMenuList() {
        return currentMenuList;
    }

    public void setCurrentMenuList(List<CurrentMenu> currentMenuList) {
        this.currentMenuList = currentMenuList;
    }

    public List<CurrentRole> getCurrentRoleList() {
        return currentRoleList;
    }

    public void setCurrentRoleList(List<CurrentRole> currentRoleList) {
        this.currentRoleList = currentRoleList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CurrentUser() {
    }
}
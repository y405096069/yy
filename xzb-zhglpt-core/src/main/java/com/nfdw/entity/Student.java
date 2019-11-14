package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-13 11:12
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author caisheng
 * @create 2019-11-13 11:12
 */

public class Student {

    private int id;


    private String username;

    private String address;

    private String mingzu;

    private String information;

    private String homemange;

    private String email;

    private int telephone;

    private Date brithday;

    private int IDType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMingzu() {
        return mingzu;
    }

    public void setMingzu(String mingzu) {
        this.mingzu = mingzu;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getHomemange() {
        return homemange;
    }

    public void setHomemange(String homemange) {
        this.homemange = homemange;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getIDType() {
        return IDType;
    }

    public void setIDType(int IDType) {
        this.IDType = IDType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", mingzu='" + mingzu + '\'' +
                ", information='" + information + '\'' +
                ", homemange='" + homemange + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", brithday=" + brithday +
                ", IDType=" + IDType +
                '}';
    }
}

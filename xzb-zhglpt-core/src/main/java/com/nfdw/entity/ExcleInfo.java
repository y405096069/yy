package com.nfdw.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class ExcleInfo {
    @Id
    @Column(name = "rownum")
    private String rownum;
    @Column(name = "orgName")
    private String orgName;
    @Column(name = "principal")
    private String principal;
    @Column(name = "registerNum")
    private String registerNum;
    @Column(name = "addressArea")
    private String addressArea;
    @Column(name = "oph")
    private String oph;
    @Column(name = "fax")
    private String fax;
    @Column(name = "zip")
    private String zip;
    @Column(name = "departType")
    private String departType;
    @Column(name = "annals")
    private String annals;
    @Column(name = "clubYear")
    private String clubYear;
    @Column(name = "ismember")
    private String ismember;
    @Column(name = "state")
    private String state;

    public String getRownum() {
        return rownum;
    }

    public void setRownum(String rownum) {
        this.rownum = rownum;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(String registerNum) {
        this.registerNum = registerNum;
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    public String getOph() {
        return oph;
    }

    public void setOph(String oph) {
        this.oph = oph;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDepartType() {
        return departType;
    }

    public void setDepartType(String departType) {
        this.departType = departType;
    }

    public String getAnnals() {
        return annals;
    }

    public void setAnnals(String annals) {
        this.annals = annals;
    }

    public String getClubYear() {
        return clubYear;
    }

    public void setClubYear(String clubYear) {
        this.clubYear = clubYear;
    }

    public String getIsmember() {
        return ismember;
    }

    public void setIsmember(String ismember) {
        this.ismember = ismember;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

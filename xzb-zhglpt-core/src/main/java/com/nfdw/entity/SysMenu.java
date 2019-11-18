package com.nfdw.entity;

import com.nfdw.validator.group.AddGroup;
import com.nfdw.validator.group.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "sys_menu")
@Data
@ToString
@EqualsAndHashCode
public class SysMenu {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @NotEmpty(message = "菜单名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;

    @Column(name = "p_id")
    private String pId;

    private String url;

    
    
    /**
     * 排序字段
     */
    @Length(min = 1,max = 4, message = "序号长度不对")
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 2019/1/3
     * 新增区域列*/
    @Column(name = "menu_department")
    private String menuDepartment;

    /**
     * 权限
     */
    private String permission;

    /**
     * 1栏目2菜单
     */
    @Column(name = "menu_type")
    private Byte menuType;

    private int num;

    private List<SysRole> roleList;

    private static final long serialVersionUID = 1L;

    private List<SysMenu> children=new ArrayList<SysMenu>();

    public void addChild(SysMenu sysMenu){
        children.add(sysMenu);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getMenuDepartment() {
        return menuDepartment;
    }

    public void setMenuDepartment(String menuDepartment) {
        this.menuDepartment = menuDepartment;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Byte getMenuType() {
        return menuType;
    }

    public void setMenuType(Byte menuType) {
        this.menuType = menuType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<SysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

}
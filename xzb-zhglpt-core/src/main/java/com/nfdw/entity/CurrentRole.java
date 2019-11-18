package com.nfdw.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**

 */
@Getter
@Setter
@ToString
public class CurrentRole implements Serializable {

    /**  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)  
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String roleName;

    private String remark;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CurrentRole(String id, String roleName, String remark) {
        this.id = id;
        this.roleName = roleName;
        this.remark = remark;
    }
}

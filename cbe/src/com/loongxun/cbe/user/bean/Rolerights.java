package com.loongxun.cbe.user.bean;

/**
 * 权限角色映射表
 */

public class Rolerights implements java.io.Serializable {

	// Fields
	/**主键id*/
	private Integer rrId;
	/** 角色id*/
	private Integer roleId;
	/**权限id*/
	private Integer rightsId;

	// Constructors

	/** default constructor */
	public Rolerights() {
	}

	/** minimal constructor */
	public Rolerights(Integer rrId) {
		this.rrId = rrId;
	}

	/** full constructor */
	public Rolerights(Integer rrId, Integer roleId, Integer rightsId) {
		this.rrId = rrId;
		this.roleId = roleId;
		this.rightsId = rightsId;
	}

	// Property accessors

	public Integer getRrId() {
		return this.rrId;
	}

	public void setRrId(Integer rrId) {
		this.rrId = rrId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRightsId() {
		return this.rightsId;
	}

	public void setRightsId(Integer rightsId) {
		this.rightsId = rightsId;
	}

}
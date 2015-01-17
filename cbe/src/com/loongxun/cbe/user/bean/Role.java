package com.loongxun.cbe.user.bean;

/**
 * 角色实体
 * 
 * @author ZhangFT
 * @since 2014年12月10日20:43:49
 */

public class Role implements java.io.Serializable {

	// Fields
	/** 角色id */
	private Integer roleId;
	/** 角色名称 */
	private String roleName;
	/** 备注 */
	private String remark;
	/** 创建时间 */
	private String createTime;
	/** 是否删除 */
	private boolean isDelete;
	/**权限id*/
	private String privilegeIds;
	/**权限名称*/
	private String privilegeNames;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String roleName, String remark, String createTime,
			boolean isDelete) {
		this.roleName = roleName;
		this.remark = remark;
		this.createTime = createTime;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public void setPrivilegeNames(String privilegeNames) {
		this.privilegeNames = privilegeNames;
	}
	public void setPrivilegeIds(String privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	public String getPrivilegeNames() {
		return privilegeNames;
	}
	public String getPrivilegeIds() {
		return privilegeIds;
	}

}
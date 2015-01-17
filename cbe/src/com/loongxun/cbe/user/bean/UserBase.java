package com.loongxun.cbe.user.bean;
/**
 * 用户基本信息表
 * */
public class UserBase  implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 3480775222150303474L;
	/**主键id*/
	private Integer aid;
	/**
	 * 与企业用户中username进行关联
	 * */
	private String adminName;
	/**登录密码*/
	private String password;
	/**用户名*/
	private String aname;
	/**性别  0 女，1 男*/
	private String sex;
	/**删除状态 0 未删除  1 删除*/
	private Integer isDelete;
	/**创建时间*/
	private String createTime;
	/**备注*/
	private String remarks;
	/**登录次数*/
	private Integer  inputNumber;
	/**
	 * 1管理员 2企业用户 3银行用户
	 * */
	private Integer userType;
	/**角色id  1 管理员  2 企业用户  3  银行用户*/
	private Integer roleId;
	/**锁定时间*/
	private String lockTime;
	/**角色名称*/
	private String roleName;
	/**ip*/
	private String ip;
	public UserBase(Integer aid, String adminName, String password,
			String aname, String sex, Integer isDelete, String createTime,
			String remarks,Integer userType, Integer roleId,String lockTime ,Integer inputNumber) {
		super();
		this.aid = aid;
		this.adminName = adminName;
		this.password = password;
		this.aname = aname;
		this.sex = sex;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.remarks = remarks;
		this.userType = userType;
		this.roleId = roleId;
		this.lockTime= lockTime;
		this.inputNumber=inputNumber;
	}
	
	public UserBase() {
		super();
	}
	
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	
	

	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getLockTime() {
		return lockTime;
	}

	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}

	public Integer getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(Integer inputNumber) {
		this.inputNumber = inputNumber;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIp() {
		return ip;
	}
	
}

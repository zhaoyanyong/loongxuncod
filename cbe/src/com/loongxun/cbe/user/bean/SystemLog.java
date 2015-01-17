package com.loongxun.cbe.user.bean;
/**
 * 系统日志--记录用户操作
 * @author 韩文场
 *
 */
public class SystemLog {
	private Integer logId;//ID
	private String userName;//用户账号
	private String opreation;//动作
	private String opreationDate;//操作时间
	
	public SystemLog() {
		super();
	}

	public SystemLog(Integer logId, String userName, String opreation,
			String opreationDate) {
		super();
		this.logId = logId;
		this.userName = userName;
		this.opreation = opreation;
		this.opreationDate = opreationDate;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOpreation() {
		return opreation;
	}

	public void setOpreation(String opreation) {
		this.opreation = opreation;
	}

	public String getOpreationDate() {
		return opreationDate;
	}

	public void setOpreationDate(String opreationDate) {
		this.opreationDate = opreationDate;
	}
	

	
}

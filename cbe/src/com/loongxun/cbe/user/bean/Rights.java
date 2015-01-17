package com.loongxun.cbe.user.bean;

/**
 * 权限实体
 * @author ZhangFT
 * @since 2014年12月10日20:46:23
 */

public class Rights implements java.io.Serializable {

	// Fields
	/**权限id*/
	private Integer rightsId;
	/**权限的名称*/
	private String rightsName;
	/**权限的路径标示*/
	private String rightsUrl;
	/**创建时间*/
	private String createTime;
	/**是否删除*/
	private boolean isDelete;

	// Constructors

	/** default constructor */
	public Rights() {
	}

	/** minimal constructor */
	public Rights(Integer rightsId) {
		this.rightsId = rightsId;
	}

	/** full constructor */
	public Rights(Integer rightsId, String rightsName, String rightsUrl,
			String createTime, boolean isDelete) {
		this.rightsId = rightsId;
		this.rightsName = rightsName;
		this.rightsUrl = rightsUrl;
		this.createTime = createTime;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getRightsId() {
		return this.rightsId;
	}

	public void setRightsId(Integer rightsId) {
		this.rightsId = rightsId;
	}

	public String getRightsName() {
		return this.rightsName;
	}

	public void setRightsName(String rightsName) {
		this.rightsName = rightsName;
	}

	public String getRightsUrl() {
		return this.rightsUrl;
	}

	public void setRightsUrl(String rightsUrl) {
		this.rightsUrl = rightsUrl;
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

}
package com.loongxun.cbe.enterprise.bean;

/**
 * 评级结果 entity. @author MyEclipse Persistence Tools
 */

public class Ratingresultsh implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer companyId;
	private Integer attributeId;
	private double total;
	private Integer creditId;
	private String rating;
	private String lifecycle;
	private String createTime;
	private String orgNo;
	private String companyName;
	private String legalPerson;
	private String scale;//企业规模
	private String payPower;//偿债能力
	private String run;//营运能力
	private String gainPower;//盈利能力
	private String growth;//成长性
	private String creative;//创新性
	private String creditPerformance;//信用履约能力
	private String managePower;//管理水平
	private String marketCompetitive;//市场竞争力
	// 附加的属性 LL 2014年2月22日09:58:48
	private String CompanyName; // 公司的名字
	private String upAndDown;// 上升下降的属性
	
	
	
	// Constructors
	


	public Ratingresultsh(Integer id, Integer companyId, Integer attributeId,
			double total, Integer creditId, String rating, String lifecycle,
			String createTime, String orgNo, String companyName,
			String legalPerson, String scale, String payPower, String run,
			String gainPower, String growth, String creative,
			String creditPerformance, String managePower,
			String marketCompetitive, String companyName2, String upAndDown) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.attributeId = attributeId;
		this.total = total;
		this.creditId = creditId;
		this.rating = rating;
		this.lifecycle = lifecycle;
		this.createTime = createTime;
		this.orgNo = orgNo;
		this.companyName = companyName;
		this.legalPerson = legalPerson;
		this.scale = scale;
		this.payPower = payPower;
		this.run = run;
		this.gainPower = gainPower;
		this.growth = growth;
		this.creative = creative;
		this.creditPerformance = creditPerformance;
		this.managePower = managePower;
		this.marketCompetitive = marketCompetitive;
		CompanyName = companyName2;
		this.upAndDown = upAndDown;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	/** default constructor */
	public Ratingresultsh() {
	}

	/** full constructor */


	
	// Property accessors

	public Integer getId() {
		return this.id;
	}


	

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getCreditId() {
		return this.creditId;
	}

	public void setCreditId(Integer creditId) {
		this.creditId = creditId;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLifecycle() {
		return this.lifecycle;
	}

	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOrgNo() {
		return this.orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public Integer getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getPayPower() {
		return payPower;
	}

	public void setPayPower(String payPower) {
		this.payPower = payPower;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getGainPower() {
		return gainPower;
	}

	public void setGainPower(String gainPower) {
		this.gainPower = gainPower;
	}

	public String getGrowth() {
		return growth;
	}

	public void setGrowth(String growth) {
		this.growth = growth;
	}

	public String getCreative() {
		return creative;
	}

	public void setCreative(String creative) {
		this.creative = creative;
	}

	public String getCreditPerformance() {
		return creditPerformance;
	}

	public void setCreditPerformance(String creditPerformance) {
		this.creditPerformance = creditPerformance;
	}

	public String getManagePower() {
		return managePower;
	}

	public void setManagePower(String managePower) {
		this.managePower = managePower;
	}

	public String getMarketCompetitive() {
		return marketCompetitive;
	}

	public void setMarketCompetitive(String marketCompetitive) {
		this.marketCompetitive = marketCompetitive;
	}

	public String getUpAndDown() {
		return upAndDown;
	}

	public void setUpAndDown(String upAndDown) {
		this.upAndDown = upAndDown;
	}
	
	

}
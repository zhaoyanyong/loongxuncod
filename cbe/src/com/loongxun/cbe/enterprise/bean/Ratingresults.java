package com.loongxun.cbe.enterprise.bean;

/**
 * Ratingresults entity. @author MyEclipse Persistence Tools
 * 文件描述：评级报告实体
 */

public class Ratingresults implements java.io.Serializable {

	// Fields

	private Integer id;//评级结果id
	private Integer companyId;//企业id
	private Double total;//综合得分
	private Integer creditId;//信用等级id
	private String rating;//总分对应的级别符号(AAA)
	private String lifecycle;//生命周期
	private String createTime;//创建时间
	private String orgNo;//公司的机构代号
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
	private String legalPerson;// 法人的的名子
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return CompanyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	/**
	 * @return the upAndDown
	 */
	public String getUpAndDown() {
		return upAndDown;
	}

	/**
	 * @param upAndDown the upAndDown to set
	 */
	public void setUpAndDown(String upAndDown) {
		this.upAndDown = upAndDown;
	}

	/**
	 * @return the legalPerson
	 */
	public String getLegalPerson() {
		return legalPerson;
	}

	/**
	 * @param legalPerson the legalPerson to set
	 */
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	
	

	// Constructors

	/** default constructor */
	public Ratingresults() {
	}

	/** full constructor */
	public Ratingresults(Integer companyId, Double total, Integer creditId,
			String rating, String lifecycle, String createTime, String orgNo,
			 String scale, String payPower, String run,
			String gainPower, String growth, String creative,
			String creditPerformance, String managePower,
			String marketCompetitive) {
		this.companyId = companyId;
		this.total = total;
		this.creditId = creditId;
		this.rating = rating;
		this.lifecycle = lifecycle;
		this.createTime = createTime;
		this.orgNo = orgNo;
		this.scale = scale;
		this.payPower = payPower;
		this.run = run;
		this.gainPower = gainPower;
		this.growth = growth;
		this.creative = creative;
		this.creditPerformance = creditPerformance;
		this.managePower = managePower;
		this.marketCompetitive = marketCompetitive;
	}

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

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
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


	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getPayPower() {
		return this.payPower;
	}

	public void setPayPower(String payPower) {
		this.payPower = payPower;
	}

	public String getRun() {
		return this.run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getGainPower() {
		return this.gainPower;
	}

	public void setGainPower(String gainPower) {
		this.gainPower = gainPower;
	}

	public String getGrowth() {
		return this.growth;
	}

	public void setGrowth(String growth) {
		this.growth = growth;
	}

	public String getCreative() {
		return this.creative;
	}

	public void setCreative(String creative) {
		this.creative = creative;
	}

	public String getCreditPerformance() {
		return this.creditPerformance;
	}

	public void setCreditPerformance(String creditPerformance) {
		this.creditPerformance = creditPerformance;
	}

	public String getManagePower() {
		return this.managePower;
	}

	public void setManagePower(String managePower) {
		this.managePower = managePower;
	}

	public String getMarketCompetitive() {
		return this.marketCompetitive;
	}

	public void setMarketCompetitive(String marketCompetitive) {
		this.marketCompetitive = marketCompetitive;
	}



}
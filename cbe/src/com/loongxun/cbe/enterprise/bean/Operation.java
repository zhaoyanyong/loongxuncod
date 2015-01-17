package com.loongxun.cbe.enterprise.bean;

/**
 * Operation entity. @author MyEclipse Persistence Tools
 */

public class Operation implements java.io.Serializable {

	// Fields

	private Integer id;//评级结果id
	private Integer companyId;//企业id
	private Double total;//综合得分
	private Integer creditId;//信用等级id
	private String rating;//总分对应的级别符号(AAA)
	private String lifecycle;//生命周期
	private String createTime;//创建时间
	private String orgNo;//公司的机构代号
	private Integer reportType; //报告状态1：已初评2:生成报告3：等待审核4：等待复核5：已签发6：已登记 7 不通过 8 等待复评
	private String scale;//企业规模
	private String payPower;//偿债能力
	private String run;//营运能力
	private String gainPower;//盈利能力
	private String growth;//成长性
	private String creative;//创新性
	private String creditPerformance;//信用履约能力
	private String managePower;//管理水平
	private String marketCompetitive;//市场竞争力
	private Integer revaluation;//是否复评0：初评1：复评
	private String companyName;//公司名称
	private String preliminaryOpinions;//初级审核评级
	private String reviewOpinions;//二次审核评价
	private String registrationTime;//登记时间
	// 附加的属性 LL 2014年2月22日09:58:48
	private String upAndDown;// 上升下降的属性
	private String legalPerson;// 法人的的名子

	// Constructors

	/** default constructor */
	public Operation() {
	}

	/** minimal constructor */
	public Operation(Integer companyId, Double total, Integer creditId,
			String rating, String lifecycle, String createTime, String orgNo,
			Integer reportType, String scale, String payPower, String run,
			String gainPower, String growth, String creative,
			String creditPerformance, String managePower,
			String marketCompetitive, Integer revaluation, String companyName) {
		this.companyId = companyId;
		this.total = total;
		this.creditId = creditId;
		this.rating = rating;
		this.lifecycle = lifecycle;
		this.createTime = createTime;
		this.orgNo = orgNo;
		this.reportType = reportType;
		this.scale = scale;
		this.payPower = payPower;
		this.run = run;
		this.gainPower = gainPower;
		this.growth = growth;
		this.creative = creative;
		this.creditPerformance = creditPerformance;
		this.managePower = managePower;
		this.marketCompetitive = marketCompetitive;
		this.revaluation = revaluation;
		this.companyName = companyName;
	}

	/** full constructor */
	public Operation(Integer companyId, Double total, Integer creditId,
			String rating, String lifecycle, String createTime, String orgNo,
			Integer reportType, String scale, String payPower, String run,
			String gainPower, String growth, String creative,
			String creditPerformance, String managePower,
			String marketCompetitive, Integer revaluation, String companyName,
			String preliminaryOpinions, String reviewOpinions,
			String registrationTime) {
		this.companyId = companyId;
		this.total = total;
		this.creditId = creditId;
		this.rating = rating;
		this.lifecycle = lifecycle;
		this.createTime = createTime;
		this.orgNo = orgNo;
		this.reportType = reportType;
		this.scale = scale;
		this.payPower = payPower;
		this.run = run;
		this.gainPower = gainPower;
		this.growth = growth;
		this.creative = creative;
		this.creditPerformance = creditPerformance;
		this.managePower = managePower;
		this.marketCompetitive = marketCompetitive;
		this.revaluation = revaluation;
		this.companyName = companyName;
		this.preliminaryOpinions = preliminaryOpinions;
		this.reviewOpinions = reviewOpinions;
		this.registrationTime = registrationTime;
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

	public Integer getReportType() {
		return this.reportType;
	}

	public void setReportType(Integer reportType) {
		this.reportType = reportType;
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

	public Integer getRevaluation() {
		return this.revaluation;
	}

	public void setRevaluation(Integer revaluation) {
		this.revaluation = revaluation;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPreliminaryOpinions() {
		return this.preliminaryOpinions;
	}

	public void setPreliminaryOpinions(String preliminaryOpinions) {
		this.preliminaryOpinions = preliminaryOpinions;
	}

	public String getReviewOpinions() {
		return this.reviewOpinions;
	}

	public void setReviewOpinions(String reviewOpinions) {
		this.reviewOpinions = reviewOpinions;
	}

	public String getRegistrationTime() {
		return this.registrationTime;
	}

	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getUpAndDown() {
		return upAndDown;
	}

	public void setUpAndDown(String upAndDown) {
		this.upAndDown = upAndDown;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	

}
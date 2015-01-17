package com.loongxun.cbe.enterprise.bean;

// default package



/**
 * 描述：行业指标信息
 * @author 韩文场
 * @since 2014-12-11 15:40:36
 
*/

public class Attribute implements java.io.Serializable {

	private static final long serialVersionUID = -279830858115321981L;
	/**指标信息id标示*/
    private Integer attributeId;
    /**行业编号**
     */
    private Integer industryRatingNo;
    /**企业id标示*/
     private Integer enterpriseId;
    /**1.企业净资产总额*/
    private Double totalNetAssets;
    /**2.企业固定资产总额*/
    private Double totalCapitalAsserts;
    /**3.营业收入*/
    private Double operatingReceipt;
    /**4.企业税后利润总额*/
    private Double totalTaxProfit;
    /**5.固定资产净值*/
    private Double capitalAssertsNetValue;
    /**6.流动资产*/
    private Double floatingCapital;
    /**7.流动负债*/
    private Double cashLiabilities;
    /**8.现金*/
    private Double generalCash;
    /**9.短期债券投资*/
    private Double shortTermBondInvestment;
    /**10.应收账款*/
    private Double accountReceivable;
    /**11应收票据*/
    private Double noteReceivable;
    /**12.有价证券*/
    private Double valueSecurities;
    /**13.负债总额*/
    private Double grossLiabilities;
    /**14.资产总额*/
    private Double totalAssets;
    /**15.息税前利润*/
    private Double earningsInterestTaxes;
    /**16.利息费用*/
    private Double capitalCharges;
    /**17.对外担保额度*/
    private Double foreignGuaranteeAmount;
    /**18.销售收入*/
    private Double salesProceed;
    /**19.主营业务收入净额*/
    private Double mainBusinessNetIncome;
    /**20.年初流动资产总额*/
    private Double beginTotalCurrentAssets;
    /**21.年末流动资产总额*/
    private Double endTotalCurrentAssets;
    /**22.固定资产*/
    private Double fixedAssets;
    /**23.年初应收账款总额*/
    private Double beginTotalAccountsReceivable;
    /**24.年末应收账款总额*/
    private Double endTotalAccountsReceivable;
    /**25.销售成本*/
    private Double sellingCost;
    /**26.年初存货*/
    private Double beginningInventory;
    /**27.年末存货*/
    private Double endInventory;
    /**28.年初所有者权益*/
    private Double beginOwnerEquity;
    /**29.年末所有者权益*/
    private Double endOwnerEquity;
    /**30.年初销售收入*/
    private Double beginSalesProceed;
    /**31.年末销售收入*/
    private Double endSalesProceed;
    /**32利息支出*/
    private Double interestExpense;
    /**33.税后净利润*/
    private Double netIncomeRetainedAfterTax;
    /**34.净资产*/
    private Double netAssets;
    /**35.利润总额*/
    private Double totalProfit;
    /**36.成本费用总额*/
    private Double totalCost;
    /**37.主营业务收入*/
    private Double mainOperationIncome;
    /**38.主营业务成本*/
    private Double costOfSales;
    /**39.主营业务税金及附加*/
    private Double salesTax;
    /**年初主营业务收入*/
    private Double beginMainOperationIncome;
    /**年末主营业务收入*/
    private Double endMainOperationIncome;
    /**年初主营业务成本*/
    private Double beginCostOfSales;
    /**年末主营业务成本*/
    private Double endCostOfSales;
    /**年初主营业务税金及附加*/
    private Double beginSalesTax;
    /**年末主营业务税金及附加*/
    private Double endSalesTax;
    /**41.本年总资产增长额*/
    private Double totalAssetGrowth;
    /**42.年初资产总额*/
    private Double beginTotalAssets;
    /**年末资产总额*/
    private Double endTotalAssets;
    /**43.期初净资产*/
    private Double beginNetAssets;
    /**44.期末净资产*/
    private Double endNetAssets;
    /**45年初营业收入*/
    private Double beginBusinessReceipt;
    /**46年末营业收入*/
    private Double endBusinessReceipt;
    /**47年初营业外收入*/
    private Double beginNonrevenueReceipt;
    /**48.年末营业外收入*/
    private Double endNonrevenueReceipt;
    /**49.所得税*/
    private Double incomeTax;
    /**上期利润总额*/
    private Double lastTotalProfit;
    /**上期所得税*/
    private Double lastIncomeTax;

    /**50.本年员工数*/
    private Integer employeNumCurrentYear;
    /**51.上年员工数*/
    private Integer employeNumLastYear;
    /**52.1年龄*/
    private Integer ageGroup;
    /**52.2学历/学位/职称*/
    private Integer degreeTitles;
    /**52.3岗位工作时间*/
    private Double workingTime;
    /**52.4业内知名度\社会关系*/
    private Integer reputations;
    /**53.企业发展规划*/
    private Boolean enterpriseExpansionProjects;
    /**54.产品长期发展战略*/
    private Boolean producLongTermDevelopment;
    /**55.产品质量认证*/
    private boolean productQualityCertification;
    /**56.产业（阶段）性质*/
    private Integer lndustryProperties;
    /**57.近一年高新销售收入和技术收入额*/
    private Double yearNewSalesIncome;
    /**58.近一年销售总额*/
    private Double yearGrossSales;
    /**59.R＆D经费支出*/
    private Double appropriationExpenditure;
    /**60.年初R＆D经费投入额*/
    private Double beginFundingAmount;
    /**61.年末R＆D经费投入额*/
    private Double endFundingAmount;
    /**62.员工大专以上人数*/
    private Integer aboveCollegeEmployeeNum;
    /**63.员工总人数*/
    private Integer totalEmployees;
    /**64.获得市级以上科技成果奖励数*/
    private Integer scientificRewardsNum;
    /**65.申请和已授权的知识产权总数*/
    private Integer intellectualPropertyRightNum;
    /**66.专利总数*/
    private Integer patentNum;
    /**67.1国家级政府立项数量*/
    private Integer couontryGovernmentProjectNum;
    /**67.2省级政府立项数量*/
    private Integer provinceGovernmentprojectNum;
    /**67.3 地市级政府立项数量*/
    private Integer cityGovernmentprojectNum;
    /**68.创新人员激励制度*/
    private Boolean incentiveSystemOfInnovation;
    /**专门的研发机构*/
    private boolean researchinstitute;
    /**有无创业投资机构进入*/
    private boolean ventureCapitalInstitutions;
    /**69.国际化合作*/
    private boolean internationallyCooperative;
    /**70.国家重点实验室*/
    private boolean stateKeyLaboratory;
    /**71.利息总额*/
    private Double grossInterest;
    /**72.逾期贷款总额*/
    private Double overdueLoans;
    /**73.贷款总额*/
    private Double loanCeiling;
    /**74.已支付到期应付账款*/
    private Double alreadyPaidCredit;
    /**75.期内应付账款总额*/
    private Double shouldPaidCredit;
    /**76.经营决策者个人信誉*/
    private Integer personalReputation;
    /**77.经营管理水平*/
    private Integer operationControl;
    /**78.股东背景*/
    private Integer shareholdersBackground;
    /**79.1任职年份*/
    private Integer takeOfficeYear;
    /**79.2董事会规模*/
    private Integer boardOfDirectors;
    /**79.3董事长与CEO两职设置状况*/
    private Integer ceosetupStatus;
    /**79.4审计意见*/
    private Integer auditOpinion;
    /**79.5违规行为*/
    private Integer irregularities;
    /** 79.6管理者年龄*/
    private Integer managerAge;
    /** 79.7管理者教育背景*/
    private Integer eduBackground;
    /**79.8职称*/
    private Integer academicTitle;
    /**80国家产业政策*/
    private Integer stateIndustrialPolicies;
    /**81.行业地位*/
    private Integer industryPosition;
    /**82.主导产业*/
    private Integer leadingIndustry;
    /**83.产品竞争力*/
    private Integer productCompetitiveness;
    /**创建时间*/
    private String createTime;
    /**84.股东名称*/
    private String shareholderNameOne;
    /**股东持股比例*/
    private double shareholdingRatioOne;
    private String shareholderNameTwo;
    private double shareholdingRatioTwo;
    private String shareholderNameThree;
    private double shareholdingRatioThree;
    private String shareholderNameFour;
    private double shareholdingRatioFour;
    private String shareholderNameFive;
    private double shareholdingRatioFive;
    /**85.重要信息披露*/
    private String iinfoDisclosure;
    /**86.指标年份*/
    private String year;
    
    
    private Integer isDelete;
    // Constructors

    /** default constructor */
    public Attribute() {
    }

	/** minimal constructor */
    public Attribute(Integer attributeId) {
        this.attributeId = attributeId;
    }
    
  
   
   
   

	public Attribute(Integer attributeId, Integer industryRatingNo,
			Integer enterpriseId, Double totalNetAssets,
			Double totalCapitalAsserts, Double operatingReceipt,
			Double totalTaxProfit, Double capitalAssertsNetValue,
			Double floatingCapital, Double cashLiabilities, Double generalCash,
			Double shortTermBondInvestment, Double accountReceivable,
			Double noteReceivable, Double valueSecurities,
			Double grossLiabilities, Double totalAssets,
			Double earningsInterestTaxes, Double capitalCharges,
			Double foreignGuaranteeAmount, Double salesProceed,
			Double mainBusinessNetIncome, Double beginTotalCurrentAssets,
			Double endTotalCurrentAssets, Double fixedAssets,
			Double beginTotalAccountsReceivable,
			Double endTotalAccountsReceivable, Double sellingCost,
			Double beginningInventory, Double endInventory,
			Double beginOwnerEquity, Double endOwnerEquity,
			Double beginSalesProceed, Double endSalesProceed,
			Double interestExpense, Double netIncomeRetainedAfterTax,
			Double netAssets, Double totalProfit, Double totalCost,
			Double mainOperationIncome, Double costOfSales, Double salesTax,
			Double beginMainOperationIncome, Double endMainOperationIncome,
			Double beginCostOfSales, Double endCostOfSales,
			Double beginSalesTax, Double endSalesTax, Double totalAssetGrowth,
			Double beginTotalAssets, Double endTotalAssets,
			Double beginNetAssets, Double endNetAssets,
			Double beginBusinessReceipt, Double endBusinessReceipt,
			Double beginNonrevenueReceipt, Double endNonrevenueReceipt,
			Double incomeTax, Double lastTotalProfit, Double lastIncomeTax,
			Integer employeNumCurrentYear, Integer employeNumLastYear,
			Integer ageGroup, Integer degreeTitles, Double workingTime,
			Integer reputations, Boolean enterpriseExpansionProjects,
			Boolean producLongTermDevelopment,
			boolean productQualityCertification, Integer lndustryProperties,
			Double yearNewSalesIncome, Double yearGrossSales,
			Double appropriationExpenditure, Double beginFundingAmount,
			Double endFundingAmount, Integer aboveCollegeEmployeeNum,
			Integer totalEmployees, Integer scientificRewardsNum,
			Integer intellectualPropertyRightNum, Integer patentNum,
			Integer couontryGovernmentProjectNum,
			Integer provinceGovernmentprojectNum,
			Integer cityGovernmentprojectNum,
			Boolean incentiveSystemOfInnovation, boolean researchinstitute,
			boolean ventureCapitalInstitutions,
			boolean internationallyCooperative, boolean stateKeyLaboratory,
			Double grossInterest, Double overdueLoans, Double loanCeiling,
			Double alreadyPaidCredit, Double shouldPaidCredit,
			Integer personalReputation, Integer operationControl,
			Integer shareholdersBackground, Integer takeOfficeYear,
			Integer boardOfDirectors, Integer ceosetupStatus,
			Integer auditOpinion, Integer irregularities, Integer managerAge,
			Integer eduBackground, Integer academicTitle,
			Integer stateIndustrialPolicies, Integer industryPosition,
			Integer leadingIndustry, Integer productCompetitiveness,
			String createTime, String shareholderNameOne,
			double shareholdingRatioOne, String shareholderNameTwo,
			double shareholdingRatioTwo, String shareholderNameThree,
			double shareholdingRatioThree, String shareholderNameFour,
			double shareholdingRatioFour, String shareholderNameFive,
			double shareholdingRatioFive, String iinfoDisclosure, String year,
			Integer isDelete) {
		super();
		this.attributeId = attributeId;
		this.industryRatingNo = industryRatingNo;
		this.enterpriseId = enterpriseId;
		this.totalNetAssets = totalNetAssets;
		this.totalCapitalAsserts = totalCapitalAsserts;
		this.operatingReceipt = operatingReceipt;
		this.totalTaxProfit = totalTaxProfit;
		this.capitalAssertsNetValue = capitalAssertsNetValue;
		this.floatingCapital = floatingCapital;
		this.cashLiabilities = cashLiabilities;
		this.generalCash = generalCash;
		this.shortTermBondInvestment = shortTermBondInvestment;
		this.accountReceivable = accountReceivable;
		this.noteReceivable = noteReceivable;
		this.valueSecurities = valueSecurities;
		this.grossLiabilities = grossLiabilities;
		this.totalAssets = totalAssets;
		this.earningsInterestTaxes = earningsInterestTaxes;
		this.capitalCharges = capitalCharges;
		this.foreignGuaranteeAmount = foreignGuaranteeAmount;
		this.salesProceed = salesProceed;
		this.mainBusinessNetIncome = mainBusinessNetIncome;
		this.beginTotalCurrentAssets = beginTotalCurrentAssets;
		this.endTotalCurrentAssets = endTotalCurrentAssets;
		this.fixedAssets = fixedAssets;
		this.beginTotalAccountsReceivable = beginTotalAccountsReceivable;
		this.endTotalAccountsReceivable = endTotalAccountsReceivable;
		this.sellingCost = sellingCost;
		this.beginningInventory = beginningInventory;
		this.endInventory = endInventory;
		this.beginOwnerEquity = beginOwnerEquity;
		this.endOwnerEquity = endOwnerEquity;
		this.beginSalesProceed = beginSalesProceed;
		this.endSalesProceed = endSalesProceed;
		this.interestExpense = interestExpense;
		this.netIncomeRetainedAfterTax = netIncomeRetainedAfterTax;
		this.netAssets = netAssets;
		this.totalProfit = totalProfit;
		this.totalCost = totalCost;
		this.mainOperationIncome = mainOperationIncome;
		this.costOfSales = costOfSales;
		this.salesTax = salesTax;
		this.beginMainOperationIncome = beginMainOperationIncome;
		this.endMainOperationIncome = endMainOperationIncome;
		this.beginCostOfSales = beginCostOfSales;
		this.endCostOfSales = endCostOfSales;
		this.beginSalesTax = beginSalesTax;
		this.endSalesTax = endSalesTax;
		this.totalAssetGrowth = totalAssetGrowth;
		this.beginTotalAssets = beginTotalAssets;
		this.endTotalAssets = endTotalAssets;
		this.beginNetAssets = beginNetAssets;
		this.endNetAssets = endNetAssets;
		this.beginBusinessReceipt = beginBusinessReceipt;
		this.endBusinessReceipt = endBusinessReceipt;
		this.beginNonrevenueReceipt = beginNonrevenueReceipt;
		this.endNonrevenueReceipt = endNonrevenueReceipt;
		this.incomeTax = incomeTax;
		this.lastTotalProfit = lastTotalProfit;
		this.lastIncomeTax = lastIncomeTax;
		this.employeNumCurrentYear = employeNumCurrentYear;
		this.employeNumLastYear = employeNumLastYear;
		this.ageGroup = ageGroup;
		this.degreeTitles = degreeTitles;
		this.workingTime = workingTime;
		this.reputations = reputations;
		this.enterpriseExpansionProjects = enterpriseExpansionProjects;
		this.producLongTermDevelopment = producLongTermDevelopment;
		this.productQualityCertification = productQualityCertification;
		this.lndustryProperties = lndustryProperties;
		this.yearNewSalesIncome = yearNewSalesIncome;
		this.yearGrossSales = yearGrossSales;
		this.appropriationExpenditure = appropriationExpenditure;
		this.beginFundingAmount = beginFundingAmount;
		this.endFundingAmount = endFundingAmount;
		this.aboveCollegeEmployeeNum = aboveCollegeEmployeeNum;
		this.totalEmployees = totalEmployees;
		this.scientificRewardsNum = scientificRewardsNum;
		this.intellectualPropertyRightNum = intellectualPropertyRightNum;
		this.patentNum = patentNum;
		this.couontryGovernmentProjectNum = couontryGovernmentProjectNum;
		this.provinceGovernmentprojectNum = provinceGovernmentprojectNum;
		this.cityGovernmentprojectNum = cityGovernmentprojectNum;
		this.incentiveSystemOfInnovation = incentiveSystemOfInnovation;
		this.researchinstitute = researchinstitute;
		this.ventureCapitalInstitutions = ventureCapitalInstitutions;
		this.internationallyCooperative = internationallyCooperative;
		this.stateKeyLaboratory = stateKeyLaboratory;
		this.grossInterest = grossInterest;
		this.overdueLoans = overdueLoans;
		this.loanCeiling = loanCeiling;
		this.alreadyPaidCredit = alreadyPaidCredit;
		this.shouldPaidCredit = shouldPaidCredit;
		this.personalReputation = personalReputation;
		this.operationControl = operationControl;
		this.shareholdersBackground = shareholdersBackground;
		this.takeOfficeYear = takeOfficeYear;
		this.boardOfDirectors = boardOfDirectors;
		this.ceosetupStatus = ceosetupStatus;
		this.auditOpinion = auditOpinion;
		this.irregularities = irregularities;
		this.managerAge = managerAge;
		this.eduBackground = eduBackground;
		this.academicTitle = academicTitle;
		this.stateIndustrialPolicies = stateIndustrialPolicies;
		this.industryPosition = industryPosition;
		this.leadingIndustry = leadingIndustry;
		this.productCompetitiveness = productCompetitiveness;
		this.createTime = createTime;
		this.shareholderNameOne = shareholderNameOne;
		this.shareholdingRatioOne = shareholdingRatioOne;
		this.shareholderNameTwo = shareholderNameTwo;
		this.shareholdingRatioTwo = shareholdingRatioTwo;
		this.shareholderNameThree = shareholderNameThree;
		this.shareholdingRatioThree = shareholdingRatioThree;
		this.shareholderNameFour = shareholderNameFour;
		this.shareholdingRatioFour = shareholdingRatioFour;
		this.shareholderNameFive = shareholderNameFive;
		this.shareholdingRatioFive = shareholdingRatioFive;
		this.iinfoDisclosure = iinfoDisclosure;
		this.year = year;
		this.isDelete = isDelete;
	}

	// Property accessors

    public Integer getAttributeId() {
        return this.attributeId;
    }
    
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getEnterpriseId() {
        return this.enterpriseId;
    }
    
    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Double getTotalNetAssets() {
        return this.totalNetAssets;
    }
    
    public void setTotalNetAssets(Double totalNetAssets) {
        this.totalNetAssets = totalNetAssets;
    }

    public Double getTotalCapitalAsserts() {
        return this.totalCapitalAsserts;
    }
    
    public void setTotalCapitalAsserts(Double totalCapitalAsserts) {
        this.totalCapitalAsserts = totalCapitalAsserts;
    }

    public Double getOperatingReceipt() {
        return this.operatingReceipt;
    }
    
    public void setOperatingReceipt(Double operatingReceipt) {
        this.operatingReceipt = operatingReceipt;
    }

    public Double getTotalTaxProfit() {
        return this.totalTaxProfit;
    }
    
    public void setTotalTaxProfit(Double totalTaxProfit) {
        this.totalTaxProfit = totalTaxProfit;
    }

    public Double getCapitalAssertsNetValue() {
        return this.capitalAssertsNetValue;
    }
    
    public void setCapitalAssertsNetValue(Double capitalAssertsNetValue) {
        this.capitalAssertsNetValue = capitalAssertsNetValue;
    }

    public Double getFloatingCapital() {
        return this.floatingCapital;
    }
    
    public void setFloatingCapital(Double floatingCapital) {
        this.floatingCapital = floatingCapital;
    }

    public Double getCashLiabilities() {
        return this.cashLiabilities;
    }
    
    public void setCashLiabilities(Double cashLiabilities) {
        this.cashLiabilities = cashLiabilities;
    }

    public Double getGeneralCash() {
        return this.generalCash;
    }
    
    public void setGeneralCash(Double generalCash) {
        this.generalCash = generalCash;
    }

    public Double getShortTermBondInvestment() {
        return this.shortTermBondInvestment;
    }
    
    public void setShortTermBondInvestment(Double shortTermBondInvestment) {
        this.shortTermBondInvestment = shortTermBondInvestment;
    }

    public Double getAccountReceivable() {
        return this.accountReceivable;
    }
    
    public void setAccountReceivable(Double accountReceivable) {
        this.accountReceivable = accountReceivable;
    }

    public Double getNoteReceivable() {
        return this.noteReceivable;
    }
    
    public void setNoteReceivable(Double noteReceivable) {
        this.noteReceivable = noteReceivable;
    }

    public Double getValueSecurities() {
        return this.valueSecurities;
    }
    
    public void setValueSecurities(Double valueSecurities) {
        this.valueSecurities = valueSecurities;
    }

    public Double getGrossLiabilities() {
        return this.grossLiabilities;
    }
    
    public void setGrossLiabilities(Double grossLiabilities) {
        this.grossLiabilities = grossLiabilities;
    }

    public Double getTotalAssets() {
        return this.totalAssets;
    }
    
    public void setTotalAssets(Double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Double getEarningsInterestTaxes() {
        return this.earningsInterestTaxes;
    }
    
    public void setEarningsInterestTaxes(Double earningsInterestTaxes) {
        this.earningsInterestTaxes = earningsInterestTaxes;
    }

    public Double getCapitalCharges() {
        return this.capitalCharges;
    }
    
    public void setCapitalCharges(Double capitalCharges) {
        this.capitalCharges = capitalCharges;
    }

    public Double getForeignGuaranteeAmount() {
        return this.foreignGuaranteeAmount;
    }
    
    public void setForeignGuaranteeAmount(Double foreignGuaranteeAmount) {
        this.foreignGuaranteeAmount = foreignGuaranteeAmount;
    }

    public Double getSalesProceed() {
        return this.salesProceed;
    }
    
    public void setSalesProceed(Double salesProceed) {
        this.salesProceed = salesProceed;
    }

    public Double getMainBusinessNetIncome() {
        return this.mainBusinessNetIncome;
    }
    
    public void setMainBusinessNetIncome(Double mainBusinessNetIncome) {
        this.mainBusinessNetIncome = mainBusinessNetIncome;
    }

    public Double getBeginTotalCurrentAssets() {
        return this.beginTotalCurrentAssets;
    }
    
    public void setBeginTotalCurrentAssets(Double beginTotalCurrentAssets) {
        this.beginTotalCurrentAssets = beginTotalCurrentAssets;
    }

    public Double getEndTotalCurrentAssets() {
        return this.endTotalCurrentAssets;
    }
    
    public void setEndTotalCurrentAssets(Double endTotalCurrentAssets) {
        this.endTotalCurrentAssets = endTotalCurrentAssets;
    }

    public Double getFixedAssets() {
        return this.fixedAssets;
    }
    
    public void setFixedAssets(Double fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public Double getBeginTotalAccountsReceivable() {
        return this.beginTotalAccountsReceivable;
    }
    
    public void setBeginTotalAccountsReceivable(Double beginTotalAccountsReceivable) {
        this.beginTotalAccountsReceivable = beginTotalAccountsReceivable;
    }

    public Double getEndTotalAccountsReceivable() {
        return this.endTotalAccountsReceivable;
    }
    
    public void setEndTotalAccountsReceivable(Double endTotalAccountsReceivable) {
        this.endTotalAccountsReceivable = endTotalAccountsReceivable;
    }

    public Double getSellingCost() {
        return this.sellingCost;
    }
    
    public void setSellingCost(Double sellingCost) {
        this.sellingCost = sellingCost;
    }

    public Double getBeginningInventory() {
        return this.beginningInventory;
    }
    
    public void setBeginningInventory(Double beginningInventory) {
        this.beginningInventory = beginningInventory;
    }

    public Double getEndInventory() {
        return this.endInventory;
    }
    
    public void setEndInventory(Double endInventory) {
        this.endInventory = endInventory;
    }

    public Double getBeginOwnerEquity() {
        return this.beginOwnerEquity;
    }
    
    public void setBeginOwnerEquity(Double beginOwnerEquity) {
        this.beginOwnerEquity = beginOwnerEquity;
    }

    public Double getEndOwnerEquity() {
        return this.endOwnerEquity;
    }
    
    public void setEndOwnerEquity(Double endOwnerEquity) {
        this.endOwnerEquity = endOwnerEquity;
    }

    public Double getBeginSalesProceed() {
        return this.beginSalesProceed;
    }
    
    public void setBeginSalesProceed(Double beginSalesProceed) {
        this.beginSalesProceed = beginSalesProceed;
    }

    public Double getEndSalesProceed() {
        return this.endSalesProceed;
    }
    
    public void setEndSalesProceed(Double endSalesProceed) {
        this.endSalesProceed = endSalesProceed;
    }

    public Double getNetIncomeRetainedAfterTax() {
        return this.netIncomeRetainedAfterTax;
    }
    
    public void setNetIncomeRetainedAfterTax(Double netIncomeRetainedAfterTax) {
        this.netIncomeRetainedAfterTax = netIncomeRetainedAfterTax;
    }

    public Double getNetAssets() {
        return this.netAssets;
    }
    
    public void setNetAssets(Double netAssets) {
        this.netAssets = netAssets;
    }

    public Double getTotalProfit() {
        return this.totalProfit;
    }
    
    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Double getTotalCost() {
        return this.totalCost;
    }
    
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getMainOperationIncome() {
        return this.mainOperationIncome;
    }
    
    public void setMainOperationIncome(Double mainOperationIncome) {
        this.mainOperationIncome = mainOperationIncome;
    }

    public Double getCostOfSales() {
        return this.costOfSales;
    }
    
    public void setCostOfSales(Double costOfSales) {
        this.costOfSales = costOfSales;
    }

    public Double getSalesTax() {
        return this.salesTax;
    }
    
    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }

    public Double getTotalAssetGrowth() {
        return this.totalAssetGrowth;
    }
    
    public void setTotalAssetGrowth(Double totalAssetGrowth) {
        this.totalAssetGrowth = totalAssetGrowth;
    }

    public Double getBeginTotalAssets() {
        return this.beginTotalAssets;
    }
    
    public void setBeginTotalAssets(Double beginTotalAssets) {
        this.beginTotalAssets = beginTotalAssets;
    }

    public Double getBeginNetAssets() {
        return this.beginNetAssets;
    }
    
    public void setBeginNetAssets(Double beginNetAssets) {
        this.beginNetAssets = beginNetAssets;
    }

    public Double getEndNetAssets() {
        return this.endNetAssets;
    }
    
    public void setEndNetAssets(Double endNetAssets) {
        this.endNetAssets = endNetAssets;
    }

    public Double getBeginBusinessReceipt() {
        return this.beginBusinessReceipt;
    }
    
    public void setBeginBusinessReceipt(Double beginBusinessReceipt) {
        this.beginBusinessReceipt = beginBusinessReceipt;
    }

    public Double getEndBusinessReceipt() {
        return this.endBusinessReceipt;
    }
    
    public void setEndBusinessReceipt(Double endBusinessReceipt) {
        this.endBusinessReceipt = endBusinessReceipt;
    }

    public Double getBeginNonrevenueReceipt() {
        return this.beginNonrevenueReceipt;
    }
    
    public void setBeginNonrevenueReceipt(Double beginNonrevenueReceipt) {
        this.beginNonrevenueReceipt = beginNonrevenueReceipt;
    }

    public Double getEndNonrevenueReceipt() {
        return this.endNonrevenueReceipt;
    }
    
    public void setEndNonrevenueReceipt(Double endNonrevenueReceipt) {
        this.endNonrevenueReceipt = endNonrevenueReceipt;
    }

    public Double getIncomeTax() {
        return this.incomeTax;
    }
    
    public void setIncomeTax(Double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Integer getEmployeNumCurrentYear() {
        return this.employeNumCurrentYear;
    }
    
    public void setEmployeNumCurrentYear(Integer employeNumCurrentYear) {
        this.employeNumCurrentYear = employeNumCurrentYear;
    }

    public Integer getEmployeNumLastYear() {
        return this.employeNumLastYear;
    }
    
    public void setEmployeNumLastYear(Integer employeNumLastYear) {
        this.employeNumLastYear = employeNumLastYear;
    }

    public Integer getAgeGroup() {
        return this.ageGroup;
    }
    
    public void setAgeGroup(Integer ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Integer getDegreeTitles() {
        return this.degreeTitles;
    }
    
    public void setDegreeTitles(Integer degreeTitles) {
        this.degreeTitles = degreeTitles;
    }

    public Double getWorkingTime() {
        return this.workingTime;
    }
    
    public void setWorkingTime(Double workingTime) {
        this.workingTime = workingTime;
    }

    public Integer getReputations() {
        return this.reputations;
    }
    
    public void setReputations(Integer reputations) {
        this.reputations = reputations;
    }

    public Boolean getEnterpriseExpansionProjects() {
        return this.enterpriseExpansionProjects;
    }
    
    public void setEnterpriseExpansionProjects(Boolean enterpriseExpansionProjects) {
        this.enterpriseExpansionProjects = enterpriseExpansionProjects;
    }

    public Boolean getProducLongTermDevelopment() {
        return this.producLongTermDevelopment;
    }
    
    public void setProducLongTermDevelopment(Boolean producLongTermDevelopment) {
        this.producLongTermDevelopment = producLongTermDevelopment;
    }

    public Boolean getProductQualityCertification() {
        return this.productQualityCertification;
    }
    
    public void setProductQualityCertification(Boolean productQualityCertification) {
        this.productQualityCertification = productQualityCertification;
    }

    public Integer getLndustryProperties() {
        return this.lndustryProperties;
    }
    
    public void setLndustryProperties(Integer lndustryProperties) {
        this.lndustryProperties = lndustryProperties;
    }

    public Double getYearNewSalesIncome() {
        return this.yearNewSalesIncome;
    }
    
    public void setYearNewSalesIncome(Double yearNewSalesIncome) {
        this.yearNewSalesIncome = yearNewSalesIncome;
    }

    public Double getYearGrossSales() {
        return this.yearGrossSales;
    }
    
    public void setYearGrossSales(Double yearGrossSales) {
        this.yearGrossSales = yearGrossSales;
    }

    public Double getAppropriationExpenditure() {
        return this.appropriationExpenditure;
    }
    
    public void setAppropriationExpenditure(Double appropriationExpenditure) {
        this.appropriationExpenditure = appropriationExpenditure;
    }

    public Double getBeginFundingAmount() {
        return this.beginFundingAmount;
    }
    
    public void setBeginFundingAmount(Double beginFundingAmount) {
        this.beginFundingAmount = beginFundingAmount;
    }

    public Double getEndFundingAmount() {
        return this.endFundingAmount;
    }
    
    public void setEndFundingAmount(Double endFundingAmount) {
        this.endFundingAmount = endFundingAmount;
    }

    public Integer getAboveCollegeEmployeeNum() {
        return this.aboveCollegeEmployeeNum;
    }
    
    public void setAboveCollegeEmployeeNum(Integer aboveCollegeEmployeeNum) {
        this.aboveCollegeEmployeeNum = aboveCollegeEmployeeNum;
    }

    public Integer getScientificRewardsNum() {
        return this.scientificRewardsNum;
    }
    
    public void setScientificRewardsNum(Integer scientificRewardsNum) {
        this.scientificRewardsNum = scientificRewardsNum;
    }

    public Integer getIntellectualPropertyRightNum() {
        return this.intellectualPropertyRightNum;
    }
    
    public void setIntellectualPropertyRightNum(Integer intellectualPropertyRightNum) {
        this.intellectualPropertyRightNum = intellectualPropertyRightNum;
    }

    public Integer getPatentNum() {
        return this.patentNum;
    }
    
    public void setPatentNum(Integer patentNum) {
        this.patentNum = patentNum;
    }

    public Integer getCouontryGovernmentProjectNum() {
        return this.couontryGovernmentProjectNum;
    }
    
    public void setCouontryGovernmentProjectNum(Integer couontryGovernmentProjectNum) {
        this.couontryGovernmentProjectNum = couontryGovernmentProjectNum;
    }

    public Integer getProvinceGovernmentprojectNum() {
        return this.provinceGovernmentprojectNum;
    }
    
    public void setProvinceGovernmentprojectNum(Integer provinceGovernmentprojectNum) {
        this.provinceGovernmentprojectNum = provinceGovernmentprojectNum;
    }

    public Integer getCityGovernmentprojectNum() {
        return this.cityGovernmentprojectNum;
    }
    
    public void setCityGovernmentprojectNum(Integer cityGovernmentprojectNum) {
        this.cityGovernmentprojectNum = cityGovernmentprojectNum;
    }

    public Boolean getIncentiveSystemOfInnovation() {
        return this.incentiveSystemOfInnovation;
    }
    
    public void setIncentiveSystemOfInnovation(Boolean incentiveSystemOfInnovation) {
        this.incentiveSystemOfInnovation = incentiveSystemOfInnovation;
    }

    public Boolean getResearchinstitute() {
        return this.researchinstitute;
    }
    
    public void setResearchinstitute(Boolean researchinstitute) {
        this.researchinstitute = researchinstitute;
    }

    public Boolean getVentureCapitalInstitutions() {
        return this.ventureCapitalInstitutions;
    }
    
    public void setVentureCapitalInstitutions(Boolean ventureCapitalInstitutions) {
        this.ventureCapitalInstitutions = ventureCapitalInstitutions;
    }

    public Boolean getInternationallyCooperative() {
        return this.internationallyCooperative;
    }
    
    public void setInternationallyCooperative(Boolean internationallyCooperative) {
        this.internationallyCooperative = internationallyCooperative;
    }

    public Boolean getStateKeyLaboratory() {
        return this.stateKeyLaboratory;
    }
    
    public void setStateKeyLaboratory(Boolean stateKeyLaboratory) {
        this.stateKeyLaboratory = stateKeyLaboratory;
    }

    public Double getGrossInterest() {
        return this.grossInterest;
    }
    
    public void setGrossInterest(Double grossInterest) {
        this.grossInterest = grossInterest;
    }

    public Double getOverdueLoans() {
        return this.overdueLoans;
    }
    
    public void setOverdueLoans(Double overdueLoans) {
        this.overdueLoans = overdueLoans;
    }

    public Double getLoanCeiling() {
        return this.loanCeiling;
    }
    
    public void setLoanCeiling(Double loanCeiling) {
        this.loanCeiling = loanCeiling;
    }

    public Double getAlreadyPaidCredit() {
        return this.alreadyPaidCredit;
    }
    
    public void setAlreadyPaidCredit(Double alreadyPaidCredit) {
        this.alreadyPaidCredit = alreadyPaidCredit;
    }

    public Double getShouldPaidCredit() {
        return this.shouldPaidCredit;
    }
    
    public void setShouldPaidCredit(Double shouldPaidCredit) {
        this.shouldPaidCredit = shouldPaidCredit;
    }

    public Integer getPersonalReputation() {
        return this.personalReputation;
    }
    
    public void setPersonalReputation(Integer personalReputation) {
        this.personalReputation = personalReputation;
    }

    public Integer getOperationControl() {
        return this.operationControl;
    }
    
    public void setOperationControl(Integer operationControl) {
        this.operationControl = operationControl;
    }

    public Integer getShareholdersBackground() {
        return this.shareholdersBackground;
    }
    
    public void setShareholdersBackground(Integer shareholdersBackground) {
        this.shareholdersBackground = shareholdersBackground;
    }

    public Integer getTakeOfficeYear() {
        return this.takeOfficeYear;
    }
    
    public void setTakeOfficeYear(Integer takeOfficeYear) {
        this.takeOfficeYear = takeOfficeYear;
    }

    public Integer getBoardOfDirectors() {
        return this.boardOfDirectors;
    }
    
    public void setBoardOfDirectors(Integer boardOfDirectors) {
        this.boardOfDirectors = boardOfDirectors;
    }

    public Integer getCeosetupStatus() {
        return this.ceosetupStatus;
    }
    
    public void setCeosetupStatus(Integer ceosetupStatus) {
        this.ceosetupStatus = ceosetupStatus;
    }

    public Integer getAuditOpinion() {
        return this.auditOpinion;
    }
    
    public void setAuditOpinion(Integer auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public Integer getIrregularities() {
        return this.irregularities;
    }
    
    public void setIrregularities(Integer irregularities) {
        this.irregularities = irregularities;
    }

    public Integer getStateIndustrialPolicies() {
        return this.stateIndustrialPolicies;
    }
    
    public void setStateIndustrialPolicies(Integer stateIndustrialPolicies) {
        this.stateIndustrialPolicies = stateIndustrialPolicies;
    }

    public Integer getIndustryPosition() {
        return this.industryPosition;
    }
    
    public void setIndustryPosition(Integer industryPosition) {
        this.industryPosition = industryPosition;
    }

    public Integer getLeadingIndustry() {
        return this.leadingIndustry;
    }
    
    public void setLeadingIndustry(Integer leadingIndustry) {
        this.leadingIndustry = leadingIndustry;
    }

    public Integer getProductCompetitiveness() {
        return this.productCompetitiveness;
    }
    
    public void setProductCompetitiveness(Integer productCompetitiveness) {
        this.productCompetitiveness = productCompetitiveness;
    }

    public Double getEndTotalAssets() {
        return this.endTotalAssets;
    }
    
    public void setEndTotalAssets(Double endTotalAssets) {
        this.endTotalAssets = endTotalAssets;
    }

    public Double getLastTotalProfit() {
        return this.lastTotalProfit;
    }
    
    public void setLastTotalProfit(Double lastTotalProfit) {
        this.lastTotalProfit = lastTotalProfit;
    }

    public Double getLastIncomeTax() {
        return this.lastIncomeTax;
    }
    
    public void setLastIncomeTax(Double lastIncomeTax) {
        this.lastIncomeTax = lastIncomeTax;
    }

    public Integer getAcademicTitle() {
        return this.academicTitle;
    }
    
    public void setAcademicTitle(Integer academicTitle) {
        this.academicTitle = academicTitle;
    }

    public Double getBeginMainOperationIncome() {
        return this.beginMainOperationIncome;
    }
    
    public void setBeginMainOperationIncome(Double beginMainOperationIncome) {
        this.beginMainOperationIncome = beginMainOperationIncome;
    }

    public Double getEndMainOperationIncome() {
        return this.endMainOperationIncome;
    }
    
    public void setEndMainOperationIncome(Double endMainOperationIncome) {
        this.endMainOperationIncome = endMainOperationIncome;
    }

    public Double getBeginCostOfSales() {
        return this.beginCostOfSales;
    }
    
    public void setBeginCostOfSales(Double beginCostOfSales) {
        this.beginCostOfSales = beginCostOfSales;
    }

    public Double getEndCostOfSales() {
        return this.endCostOfSales;
    }
    
    public void setEndCostOfSales(Double endCostOfSales) {
        this.endCostOfSales = endCostOfSales;
    }

    public Double getBeginSalesTax() {
        return this.beginSalesTax;
    }
    
    public void setBeginSalesTax(Double beginSalesTax) {
        this.beginSalesTax = beginSalesTax;
    }

    public Double getEndSalesTax() {
        return this.endSalesTax;
    }
    
    public void setEndSalesTax(Double endSalesTax) {
        this.endSalesTax = endSalesTax;
    }

    public String getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getInterestExpense() {
        return this.interestExpense;
    }
    
    public void setInterestExpense(Double interestExpense) {
        this.interestExpense = interestExpense;
    }

    public String getShareholderNameOne() {
        return this.shareholderNameOne;
    }
    
    public void setShareholderNameOne(String shareholderNameOne) {
        this.shareholderNameOne = shareholderNameOne;
    }

    public Double getShareholdingRatioOne() {
        return this.shareholdingRatioOne;
    }
    
    public void setShareholdingRatioOne(Double shareholdingRatioOne) {
        this.shareholdingRatioOne = shareholdingRatioOne;
    }

    public String getShareholderNameTwo() {
        return this.shareholderNameTwo;
    }
    
    public void setShareholderNameTwo(String shareholderNameTwo) {
        this.shareholderNameTwo = shareholderNameTwo;
    }

    public Double getShareholdingRatioTwo() {
        return this.shareholdingRatioTwo;
    }
    
    public void setShareholdingRatioTwo(Double shareholdingRatioTwo) {
        this.shareholdingRatioTwo = shareholdingRatioTwo;
    }

    public String getShareholderNameThree() {
        return this.shareholderNameThree;
    }
    
    public void setShareholderNameThree(String shareholderNameThree) {
        this.shareholderNameThree = shareholderNameThree;
    }

    public Double getShareholdingRatioThree() {
        return this.shareholdingRatioThree;
    }
    
    public void setShareholdingRatioThree(Double shareholdingRatioThree) {
        this.shareholdingRatioThree = shareholdingRatioThree;
    }

    public String getShareholderNameFour() {
        return this.shareholderNameFour;
    }
    
    public void setShareholderNameFour(String shareholderNameFour) {
        this.shareholderNameFour = shareholderNameFour;
    }

    public Double getShareholdingRatioFour() {
        return this.shareholdingRatioFour;
    }
    
    public void setShareholdingRatioFour(Double shareholdingRatioFour) {
        this.shareholdingRatioFour = shareholdingRatioFour;
    }

    public String getShareholderNameFive() {
        return this.shareholderNameFive;
    }
    
    public void setShareholderNameFive(String shareholderNameFive) {
        this.shareholderNameFive = shareholderNameFive;
    }

    public Double getShareholdingRatioFive() {
        return this.shareholdingRatioFive;
    }
    
    public void setShareholdingRatioFive(Double shareholdingRatioFive) {
        this.shareholdingRatioFive = shareholdingRatioFive;
    }

    public String getIinfoDisclosure() {
        return this.iinfoDisclosure;
    }
    
    public void setIinfoDisclosure(String iinfoDisclosure) {
        this.iinfoDisclosure = iinfoDisclosure;
    }

    public Integer getManagerAge() {
        return this.managerAge;
    }
    
    public void setManagerAge(Integer managerAge) {
        this.managerAge = managerAge;
    }

    public Integer getEduBackground() {
        return this.eduBackground;
    }
    
    public void setEduBackground(Integer eduBackground) {
        this.eduBackground = eduBackground;
    }

    public Integer getTotalEmployees() {
        return this.totalEmployees;
    }
    
    public void setTotalEmployees(Integer totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIndustryRatingNo() {
		return industryRatingNo;
	}

	public void setIndustryRatingNo(Integer industryRatingNo) {
		this.industryRatingNo = industryRatingNo;
	} 
    
    
}

	

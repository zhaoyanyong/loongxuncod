package com.loongxun.cbe.enterprise.bean;

import com.loongxun.cbe.user.bean.Enterpriseinfo;


/**
*
* 描述：存储数据分析的指标实际值和分值

* @version 1.0
*/
public class Dataanaly implements java.io.Serializable {

	// Fields
	/**数据分析Id*/
	private Integer analyId;
	/**企业Id*/
	private Integer enterpriseId;
	/**企业指标Id*/
	private Integer attributeId;
	/**企业净资产总额（指标）*/
	private Double netAssetTarget;
	/**企业净资产总额（分值）*/
	private Double netAssetValue;
	/**企业固定资产总额（指标）*/
	private Double fixAssetTarget;
	/**企业固定资产总额（分值）*/
	private Double fixAssetValue;
	/**营业收入（指标）*/
	private Double incomeTarget;
	/**营业收入（分值）*/
	private Double incomeValue;
	/**企业税后利润总额（指标）*/
	private Double profitTarget;
	/**企业税后利润总额（分值）*/
	private Double profitValue;
	/**固定资产净值（指标）*/
	private Double netbalTarget;
	/**固定资产净值（分值）*/
	private Double netbalValue;
	/**流动比率（指标）。流动资产/流动负债 */
	private Double liquidRatioTarget;
	/**流动比率（分值）*/
	private Double liquidRatioValue;
	/**速动比率（指标）。（现金＋有价证券＋应收款项／流动负债）*/
	private Double quickRatioTarget;
	/**速动比率（分值）*/
	private Double quickRatioValue;
	/**现金比率（指标）。现金/流动负债*/
	private Double cashRatioTarget;
	/**现金比率（分值）*/
	private Double cashRatioValue;
	/**资产负债率（指标）。负债总额/资产总额*100%*/
	private Double debtRatioTarget;
	/**资产负债率（分值）*/
	private Double debtRatioValue;
	/**产权比率（指标）。（负债总额 /股东权益）*100%）*/
	private Double equityRatioTarget;
	/**产权比率（分值）*/
	private Double equityRatioValue;
	/**利息保障倍数（指标）。息税前利润/利息费用*/
	private Double interestTimesTarget;
	/**利息保障倍数（分值）*/
	private Double interestTimesValue;
	/**股东权益比率（指标）。所有者权益/资产总额*100%*/
	private Double shareholderRatioTarget;
	/**股东权益比率（分值）*/
	private Double shareholderRatioValue;
	/**担保比率（指标）。担保额/贷款额*100%*/
	private Double collateralRatioTarget;
	/**担保比率（分值）*/
	private Double collateralRatioValue;
	/**总资产周转率（指标）*/
	private Double totalAssetTurnRatioTarget;
	/**总资产周转率（分值）*/
	private Double totalAssetTurnRatioValue;
	/**流动资产周转率（指标）*/
	private Double liquidAssetTurnRatioTarget;
	/**流动资产周转率（分值）*/
	private Double liquidAssetTurnRatioValue;
	/**固定资产周转率（指标）*/
	private Double fixAssetTurnRatioTarget;
	/**固定资产周转率（分值）*/
	private Double fixAssetTurnRatioValue;
	/**应收帐款周转率（指标）*/
	private Double receivableTurnRatioTarget;
	/**应收帐款周转率（分值）*/
	private Double receivableTurnRatioValue;
	/**存货周转率（指标）*/
	private Double stockTurnRatioTarget;
	/**存货周转率（分值）*/
	private Double stockTurnRatioValue;
	/**资产保值、增值率（指标）*/
	private Double assetIncrementRatioTarget;
	/**资产保值、增值率（分值）*/
	private Double assetIncrementRatioValue;
	/**销售收入增长率（指标）*/
	private Double saleGrowRatioTarget;
	/**销售收入增长率（分值）*/
	private Double saleGrowRatioValue;
	/**总资产回报率（指标）。（税前利润+利息支出）/平均资产总额*100%*/
	private Double totalAssetReturnRatioTarget;
	/**总资产回报率（分值）*/
	private Double totalAssetReturnRatioValue;
	/**净资产回报率（指标）。税后利润/平均净资产*100%*/
	private Double netAssetReturnRatioTarget;
	/**净资产回报率（分值）*/
	private Double netAssetReturnRatioValue;
	/**成本费用利润率（指标）*/
	private Double perfitCostRatioTarget;
	/**成本费用利润率（分值）*/
	private Double perfitCostRatioValue;
	/**主营业务税后利润率（指标）*/
	private Double afterTaxProfitTarget;
	/**主营业务税后利润率（分值）*/
	private Double afterTaxProfitValue;
	/**销售利润率（指标）*/
	private Double saleProfitTarget;
	/**销售利润率（分值）*/
	private Double saleProfitValue;
	/**总资产增长率（指标）*/
	private Double totalAssetGrowRatioTarget;
	/**总资产增长率（分值）*/
	private Double totalAssetGrowRatioValue;
	/**净资产增长率（指标）*/
	private Double netAssetGrowRatioTarget;
	/**净资产增长率（分值）*/
	private Double netAssetGrowRatioValue;
	/**总收益增长率（指标）*/
	private Double totalIncomeGrowRatioTarget;
	/**总收益增长率（分值）*/
	private Double totalIncomeGrowRatioValue;
	/**净利润增长率（指标）*/
	private Double netIncomeGrowRatioTarget;
	/**净利润增长率（分值）*/
	private Double netIncomeGrowRatioValue;
	/**主营业务利润率增长（指标）*/
	private Double mainBusProfitGrowTarget;
	/**主营业务利润率增长（分值）*/
	private Double mainBusProfitGrowValue;
	/**员工数量增长率（指标）*/
	private Double employeeGrowRatioTarget;
	/**员工数量增长率（分值）*/
	private Double employeeGrowRatioValue;
	/**企业家年龄段（指标）。0：<35，1：35~50，2：>50*/
	private Integer euntreponierAgeTarget;
	/**企业家年龄段（分值）*/
	private Double euntreponierAgeValue;
	/**企业家学历（指标）0:特殊知名人物,1:博士/高级,2:硕士/副高,3:本科/中级,4:专科/初级*/
	private Integer euntreponierDegreeTarget;
	/**企业家学历（分值）*/
	private Double euntreponierDegreeValue;
	/**岗位工作时间（指标）*/
	private Double euntreponierWorkTimeTarget;
	/**岗位工作时间（分值）*/
	private Double euntreponierWorkTimeValue;
	/**企业家业内知名度社会关系（指标）。0：很强，1：强，2：比较强，3：一般*/
	private Integer euntreponierPopularyTarget;
	/**企业家知名度（分值）*/
	private Double euntreponierPopularyValue;
	/**企业发展规划（指标）。0：无，1：有*/
	private Integer developPlanTarget;
	/**企业发展规划（分值）*/
	private Double developPlanValue;
	/**长期发展战略（指标）。0：无，1：有*/
	private Integer developStrategyTarget;
	/**长期发展战略（分值）*/
	private Double developStrategyValue;
	/**产品质量认证（指标）。0：无，1：有*/
	private Integer qualityCertificateTarget;
	/**产品质量认证（分值）*/
	private Double qualityCertificateValue;
	/**产业（阶段）性质（指标）。0：夕阳产业，1：普通产业，3:朝阳产业*/
	private Integer industryNatureTarget;
	/**企业性质（分值）*/
	private Double industryNatureValue;
	/**高新技术产品（服务）销售收入（指标）*/
	private Double highTechIncomeRatioTarget;
	/**高新技术产品（服务）销售收入（分值）*/
	private Double highTechIncomeRatioValue;
	/**R&D投入占比（指标）*/	
	private Double rdinputRatioTarget;
	/**R&D投入占比（分值）*/
	private Double rdinputRatioValue;
	/**R&D经费增长率（指标）*/
	private Double rdmoneyGrowRatioTarget;
	/**R&D经费增长率（分值）*/
	private Double rdmoneyGrowRatioValue;
	/**大专以上人数占比（指标）*/
	private Double collageRatioTarget;
	/**大专以上人数占比（分值）*/
	private Double collageRatioValue;
	/**科技成果奖励数（指标）*/
	private Integer technicalPayoffNumTarget;
	/**科技成果奖励数（分值）*/
	private Double technicalPayoffNumValue;
	/**知识产权总数（指标）*/
	private Integer iprnumTarget;
	/**知识产权总数（分值）*/
	private Double iprnumValue;
	/**专利总数（指标）*/
	private Integer patentNumTarget;
	/**专利总数（分值）*/
	private Double patentNumValue;
	/**近三年获政府立项数量(国家级)（指标）*/
	private Integer govprojectNumLandTarget;
	/**近三年获政府立项数量(国家级)（分值）*/
	private Double govprojectNumLandValue;
	/**近三年获政府立项数量(省级)（指标）*/
	private Integer govprojectNumProTarget;
	/**近三年获政府立项数量(省级)（分值）*/
	private Double govprojectNumProValue;
	/**近三年获政府立项数量(市级)（指标）*/
	private Integer govprojectNumCityTarget;
	/**近三年获政府立项数量(市级)（分值）*/
	private Double govprojectNumCityValue;
	/**有无创新人员激励制度（指标）。0：无，1：有*/
	private Integer incentiveTarget;
	/**创新人员激励制度（分值）*/
	private Double incentiveValue;
	/**专门的研发机构（指标）。0：无，1：有*/
	private Integer rdorganizationTarget;
	/**专门的研发机构（分值）*/
	private Double rdorganizationValue;
	/**有无投资机构（指标）。0：无，1：有*/
	private Integer investmentOrganizationTarget;
	/**有无投资机构（分值）*/
	private Double investmentOrganizationValue;
	/**有无国际化合作（指标）。0：无，1：有*/
	private Integer internateCooTarget;
	/**有无国际化合作（分值）*/
	private Double internateCooValue;
	/**有无国家重点实验室（指标）。0：无，1：有*/
	private Integer lhdtarget;
	/**有无国家重点实验室（分值）*/
	private Double lhdvalue;
	/**利息偿付率（指标）*/
	private Double interestCoverageRatioTarget;
	/**利息偿付率（分值）*/
	private Double interestCoverageRatioValue;
	/**贷款逾期率（指标）*/
	private Double loanOutdateRatioTarget;
	/**贷款逾期率（分值）*/
	private Double loanOutdateRatioValue;
	/**应付账款清付率（指标）*/
	private Double payMoneyRatioTarget;
	/**应付账款清付率（分值）*/
	private Double payMoneyRatioValue;
	/**经营决策者个人信誉（指标）。1：优秀，2：良好，3：一般，4：差*/
	private Integer personalCreditTarget;
	/**经营决策者个人信誉（分值）*/
	private Double personalCreditValue;
	/**经营管理水平（指标）。1：优秀，3：良好，2：一般，4：差*/
	private Integer manageLevelTarget;
	/**经营管理水平（分值）*/
	private Double manageLevelValue;
	/**股东背景（指标）。0:民营企业及其他，1：地市级以上（含）政府控投企业，2：中央级企业、上市公司*/
	private Integer shareholderBackgroundTarget;
	/**股东背景（分值）*/
	private Double shareholderBackgroundValue;
	/**管理者任职年份（指标）*/
	private String managerWorkTimeTarget;
	/**管理者任职年份（分值）*/
	private Double managerWorkTimeValue;
	/**董事会规模（指标）。0：按规定设置，1：未按规定设置*/
	private Integer boardSizeTarget;
	/**董事会规模（分值）*/
	private Double boardSizeValue;
	/**董事长与CEO两职设置状况（指标）。0：按规定设置，1：未按规定设置*/
	private Integer chairCeotarget;
	/**董事长与CEO两职设置状况（分值）*/
	private Double chairCeovalue;
	/**管理者审计意见（指标）*/
	private Integer auditOpinionTarget;
	/**管理者审计意见（分值）*/
	private Double auditOpinionValue;
	/**管理者违规行为（指标）。0：无，1：有*/
	private Integer illegalBehaviorTarget;
	/**管理者违规行为（分值）*/
	private Double illegalBehaviorValue;
	/**管理者年龄（指标）。0：<35，1：35~50，2：>50*/
	private Integer managerAgeTarget;
	/**管理者年龄（分值）*/
	private Double managerAgeValue;
	/**管理者教育背景（指标）。0：特殊知名人物，1：博士/高级，2：硕士/副高，3：本科/中级,4:专科/初级*/
	private Integer managerEdubackgroundTarget;
	/**管理者教育背景（分值）*/
	private Double managerEdubackgroundValue;
	/**管理者职称（指标）。0：无，1：初，2：中，3：副高，4：高*/
	private Integer managerTitalTarget;
	/**管理者职称（分值）*/
	private Double managerTitalValue;
	/**国家产业政策（指标）。0：鼓励发展，1：一般态度，2：限制发展，3：要求淘汰*/
	private Integer industryPolicyTarget;
	/**国家产业政策（分值）*/
	private Double industryPolicyValue;
	/**行业地位（指标）。0：产品市场占有率高，议价能力强，1：议价能力一般，2：议价能力差*/
	private Integer industryPositionTarget;
	/**行业地位（分值）*/
	private Double industryPositionValue;
	/**主导产业个数（指标）。1:1~3个，3:3~4个，5:4个以上*/
	private Integer leaderIndustryNumTarget;
	/**主导产业个数（分值）*/
	private Double leaderIndustryNumValue;
	/**产品竞争力（指标）。0：好，1：中，2：差*/
	private Integer competitivePowerTarget;
	/**产品竞争力（分值）*/
	private Double competitivePowerValue;
	/**评级时间*/
	private String createTime;
	/**评定等级*/
	private Integer creditClassId;
	
	// Fields

	/**企业规模总得分*/
	private double scaleMeritTotalScores;
	/**偿债能力总得分*/
	private double debtTotalScores;
	/**营运能力总得分*/
	private double operationTotalScores;
	/**盈利能力总得分*/
	private double earningTotalScores;
	/**成长性指标总得分*/
	private double growthTotalScores;
	/**创新性指标总得分*/
	private double creativeTotalScores;
	/**信用履约能力总得分*/
	private double creditExerciseTotalScores;
	/**管理水平总得分*/
	private double managerLevelTotalScores;
	/**市场竞争力力总得分*/
	private double marketCompeteTotalScores;
	/**所有评估项总得分*/
	private double allTotalScores;
	//附加属性
	private Enterpriseinfo user;


    // Constructors

    /** default constructor */
    public Dataanaly() {
    }

	/** minimal constructor */
    public Dataanaly(Integer enterpriseId,Integer attributeId,Double netAssetTarget, Double netAssetValue, Double fixAssetTarget, Double fixAssetValue, Double incomeTarget, Double incomeValue, Double profitTarget, Double profitValue, Double netbalTarget, Double netbalValue, Double scaleMeritTotalScores, Double liquidRatioTarget, Double liquidRatioValue, Double quickRatioTarget, Double quickRatioValue, Double cashRatioTarget, Double cashRatioValue, Double debtRatioTarget, Double debtRatioValue, Double equityRatioTarget, Double equityRatioValue, Double interestTimesTarget, Double interestTimesValue, Double shareholderRatioTarget, Double shareholderRatioValue, Double collateralRatioTarget, Double collateralRatioValue, Double debtTotalScores, Double totalAssetTurnRatioTarget, Double totalAssetTurnRatioValue, Double liquidAssetTurnRatioTarget, Double liquidAssetTurnRatioValue, Double fixAssetTurnRatioTarget, Double fixAssetTurnRatioValue, Double receivableTurnRatioTarget, Double receivableTurnRatioValue, Double stockTurnRatioTarget, Double stockTurnRatioValue, Double assetIncrementRatioTarget, Double assetIncrementRatioValue, Double saleGrowRatioTarget, Double saleGrowRatioValue, Double operationTotalScores, Double totalAssetReturnRatioTarget, Double totalAssetReturnRatioValue, Double netAssetReturnRatioTarget, Double netAssetReturnRatioValue, Double perfitCostRatioTarget, Double perfitCostRatioValue, Double afterTaxProfitTarget, Double afterTaxProfitValue, Double saleProfitTarget, Double saleProfitValue, Double earningTotalScores, Double totalAssetGrowRatioTarget, Double totalAssetGrowRatioValue, Double netAssetGrowRatioTarget, Double netAssetGrowRatioValue, Double totalIncomeGrowRatioTarget, Double totalIncomeGrowRatioValue, Double netIncomeGrowRatioTarget, Double netIncomeGrowRatioValue, Double mainBusProfitGrowTarget, Double mainBusProfitGrowValue, Double employeeGrowRatioTarget, Double employeeGrowRatioValue, Integer euntreponierAgeTarget, Double euntreponierAgeValue, Integer euntreponierDegreeTarget, Double euntreponierDegreeValue, Double euntreponierWorkTimeTarget, Double euntreponierWorkTimeValue, Integer euntreponierPopularyTarget, Double euntreponierPopularyValue, Integer developPlanTarget, Double developPlanValue, Integer developStrategyTarget, Double developStrategyValue, Integer qualityCertificateTarget, Double qualityCertificateValue, Integer industryNatureTarget, Double industryNatureValue, Double growthTotalScores, Double highTechIncomeRatioTarget, Double highTechIncomeRatioValue, Double rdinputRatioTarget, Double rdinputRatioValue, Double rdmoneyGrowRatioTarget, Double rdmoneyGrowRatioValue, Double collageRatioTarget, Double collageRatioValue, Integer technicalPayoffNumTarget, Double technicalPayoffNumValue, Integer iprnumTarget, Double iprnumValue, Integer patentNumTarget, Double patentNumValue, Integer govprojectNumLandTarget, Double govprojectNumLandValue, Integer govprojectNumProTarget, Double govprojectNumProValue, Integer govprojectNumCityTarget, Double govprojectNumCityValue, Integer incentiveTarget, Double incentiveValue, Integer rdorganizationTarget, Double rdorganizationValue, Integer investmentOrganizationTarget, Double investmentOrganizationValue, Integer internateCooTarget, Double internateCooValue, Integer lhdtarget, Double lhdvalue, Double creativeTotalScores, Double interestCoverageRatioTarget, Double interestCoverageRatioValue, Double loanOutdateRatioTarget, Double loanOutdateRatioValue, Double payMoneyRatioTarget, Double payMoneyRatioValue, Integer personalCreditTarget, Double personalCreditValue, Double creditExerciseTotalScores, Integer manageLevelTarget, Double manageLevelValue, Integer shareholderBackgroundTarget, Double shareholderBackgroundValue, String managerWorkTimeTarget, Double managerWorkTimeValue, Integer boardSizeTarget, Double boardSizeValue, Integer chairCeotarget, Double chairCeovalue, Integer auditOpinionTarget, Double auditOpinionValue, Integer illegalBehaviorTarget, Double illegalBehaviorValue, Integer managerAgeTarget, Double managerAgeValue, Integer managerEdubackgroundTarget, Double managerEdubackgroundValue, Integer managerTitalTarget, Double managerTitalValue, Double managerLevelTotalScores, Integer industryPolicyTarget, Double industryPolicyValue, Integer industryPositionTarget, Double industryPositionValue, Integer leaderIndustryNumTarget, Double leaderIndustryNumValue, Integer competitivePowerTarget, Double competitivePowerValue, Double marketCompeteTotalScores, Double allTotalScores, String createTime) {
        this.enterpriseId = enterpriseId;
        this.attributeId = attributeId;
        this.netAssetTarget = netAssetTarget;
        this.netAssetValue = netAssetValue;
        this.fixAssetTarget = fixAssetTarget;
        this.fixAssetValue = fixAssetValue;
        this.incomeTarget = incomeTarget;
        this.incomeValue = incomeValue;
        this.profitTarget = profitTarget;
        this.profitValue = profitValue;
        this.netbalTarget = netbalTarget;
        this.netbalValue = netbalValue;
        this.scaleMeritTotalScores = scaleMeritTotalScores;
        this.liquidRatioTarget = liquidRatioTarget;
        this.liquidRatioValue = liquidRatioValue;
        this.quickRatioTarget = quickRatioTarget;
        this.quickRatioValue = quickRatioValue;
        this.cashRatioTarget = cashRatioTarget;
        this.cashRatioValue = cashRatioValue;
        this.debtRatioTarget = debtRatioTarget;
        this.debtRatioValue = debtRatioValue;
        this.equityRatioTarget = equityRatioTarget;
        this.equityRatioValue = equityRatioValue;
        this.interestTimesTarget = interestTimesTarget;
        this.interestTimesValue = interestTimesValue;
        this.shareholderRatioTarget = shareholderRatioTarget;
        this.shareholderRatioValue = shareholderRatioValue;
        this.collateralRatioTarget = collateralRatioTarget;
        this.collateralRatioValue = collateralRatioValue;
        this.debtTotalScores = debtTotalScores;
        this.totalAssetTurnRatioTarget = totalAssetTurnRatioTarget;
        this.totalAssetTurnRatioValue = totalAssetTurnRatioValue;
        this.liquidAssetTurnRatioTarget = liquidAssetTurnRatioTarget;
        this.liquidAssetTurnRatioValue = liquidAssetTurnRatioValue;
        this.fixAssetTurnRatioTarget = fixAssetTurnRatioTarget;
        this.fixAssetTurnRatioValue = fixAssetTurnRatioValue;
        this.receivableTurnRatioTarget = receivableTurnRatioTarget;
        this.receivableTurnRatioValue = receivableTurnRatioValue;
        this.stockTurnRatioTarget = stockTurnRatioTarget;
        this.stockTurnRatioValue = stockTurnRatioValue;
        this.assetIncrementRatioTarget = assetIncrementRatioTarget;
        this.assetIncrementRatioValue = assetIncrementRatioValue;
        this.saleGrowRatioTarget = saleGrowRatioTarget;
        this.saleGrowRatioValue = saleGrowRatioValue;
        this.operationTotalScores = operationTotalScores;
        this.totalAssetReturnRatioTarget = totalAssetReturnRatioTarget;
        this.totalAssetReturnRatioValue = totalAssetReturnRatioValue;
        this.netAssetReturnRatioTarget = netAssetReturnRatioTarget;
        this.netAssetReturnRatioValue = netAssetReturnRatioValue;
        this.perfitCostRatioTarget = perfitCostRatioTarget;
        this.perfitCostRatioValue = perfitCostRatioValue;
        this.afterTaxProfitTarget = afterTaxProfitTarget;
        this.afterTaxProfitValue = afterTaxProfitValue;
        this.saleProfitTarget = saleProfitTarget;
        this.saleProfitValue = saleProfitValue;
        this.earningTotalScores = earningTotalScores;
        this.totalAssetGrowRatioTarget = totalAssetGrowRatioTarget;
        this.totalAssetGrowRatioValue = totalAssetGrowRatioValue;
        this.netAssetGrowRatioTarget = netAssetGrowRatioTarget;
        this.netAssetGrowRatioValue = netAssetGrowRatioValue;
        this.totalIncomeGrowRatioTarget = totalIncomeGrowRatioTarget;
        this.totalIncomeGrowRatioValue = totalIncomeGrowRatioValue;
        this.netIncomeGrowRatioTarget = netIncomeGrowRatioTarget;
        this.netIncomeGrowRatioValue = netIncomeGrowRatioValue;
        this.mainBusProfitGrowTarget = mainBusProfitGrowTarget;
        this.mainBusProfitGrowValue = mainBusProfitGrowValue;
        this.employeeGrowRatioTarget = employeeGrowRatioTarget;
        this.employeeGrowRatioValue = employeeGrowRatioValue;
        this.euntreponierAgeTarget = euntreponierAgeTarget;
        this.euntreponierAgeValue = euntreponierAgeValue;
        this.euntreponierDegreeTarget = euntreponierDegreeTarget;
        this.euntreponierDegreeValue = euntreponierDegreeValue;
        this.euntreponierWorkTimeTarget = euntreponierWorkTimeTarget;
        this.euntreponierWorkTimeValue = euntreponierWorkTimeValue;
        this.euntreponierPopularyTarget = euntreponierPopularyTarget;
        this.euntreponierPopularyValue = euntreponierPopularyValue;
        this.developPlanTarget = developPlanTarget;
        this.developPlanValue = developPlanValue;
        this.developStrategyTarget = developStrategyTarget;
        this.developStrategyValue = developStrategyValue;
        this.qualityCertificateTarget = qualityCertificateTarget;
        this.qualityCertificateValue = qualityCertificateValue;
        this.industryNatureTarget = industryNatureTarget;
        this.industryNatureValue = industryNatureValue;
        this.growthTotalScores = growthTotalScores;
        this.highTechIncomeRatioTarget = highTechIncomeRatioTarget;
        this.highTechIncomeRatioValue = highTechIncomeRatioValue;
        this.rdinputRatioTarget = rdinputRatioTarget;
        this.rdinputRatioValue = rdinputRatioValue;
        this.rdmoneyGrowRatioTarget = rdmoneyGrowRatioTarget;
        this.rdmoneyGrowRatioValue = rdmoneyGrowRatioValue;
        this.collageRatioTarget = collageRatioTarget;
        this.collageRatioValue = collageRatioValue;
        this.technicalPayoffNumTarget = technicalPayoffNumTarget;
        this.technicalPayoffNumValue = technicalPayoffNumValue;
        this.iprnumTarget = iprnumTarget;
        this.iprnumValue = iprnumValue;
        this.patentNumTarget = patentNumTarget;
        this.patentNumValue = patentNumValue;
        this.govprojectNumLandTarget = govprojectNumLandTarget;
        this.govprojectNumLandValue = govprojectNumLandValue;
        this.govprojectNumProTarget = govprojectNumProTarget;
        this.govprojectNumProValue = govprojectNumProValue;
        this.govprojectNumCityTarget = govprojectNumCityTarget;
        this.govprojectNumCityValue = govprojectNumCityValue;
        this.incentiveTarget = incentiveTarget;
        this.incentiveValue = incentiveValue;
        this.rdorganizationTarget = rdorganizationTarget;
        this.rdorganizationValue = rdorganizationValue;
        this.investmentOrganizationTarget = investmentOrganizationTarget;
        this.investmentOrganizationValue = investmentOrganizationValue;
        this.internateCooTarget = internateCooTarget;
        this.internateCooValue = internateCooValue;
        this.lhdtarget = lhdtarget;
        this.lhdvalue = lhdvalue;
        this.creativeTotalScores = creativeTotalScores;
        this.interestCoverageRatioTarget = interestCoverageRatioTarget;
        this.interestCoverageRatioValue = interestCoverageRatioValue;
        this.loanOutdateRatioTarget = loanOutdateRatioTarget;
        this.loanOutdateRatioValue = loanOutdateRatioValue;
        this.payMoneyRatioTarget = payMoneyRatioTarget;
        this.payMoneyRatioValue = payMoneyRatioValue;
        this.personalCreditTarget = personalCreditTarget;
        this.personalCreditValue = personalCreditValue;
        this.creditExerciseTotalScores = creditExerciseTotalScores;
        this.manageLevelTarget = manageLevelTarget;
        this.manageLevelValue = manageLevelValue;
        this.shareholderBackgroundTarget = shareholderBackgroundTarget;
        this.shareholderBackgroundValue = shareholderBackgroundValue;
        this.managerWorkTimeTarget = managerWorkTimeTarget;
        this.managerWorkTimeValue = managerWorkTimeValue;
        this.boardSizeTarget = boardSizeTarget;
        this.boardSizeValue = boardSizeValue;
        this.chairCeotarget = chairCeotarget;
        this.chairCeovalue = chairCeovalue;
        this.auditOpinionTarget = auditOpinionTarget;
        this.auditOpinionValue = auditOpinionValue;
        this.illegalBehaviorTarget = illegalBehaviorTarget;
        this.illegalBehaviorValue = illegalBehaviorValue;
        this.managerAgeTarget = managerAgeTarget;
        this.managerAgeValue = managerAgeValue;
        this.managerEdubackgroundTarget = managerEdubackgroundTarget;
        this.managerEdubackgroundValue = managerEdubackgroundValue;
        this.managerTitalTarget = managerTitalTarget;
        this.managerTitalValue = managerTitalValue;
        this.managerLevelTotalScores = managerLevelTotalScores;
        this.industryPolicyTarget = industryPolicyTarget;
        this.industryPolicyValue = industryPolicyValue;
        this.industryPositionTarget = industryPositionTarget;
        this.industryPositionValue = industryPositionValue;
        this.leaderIndustryNumTarget = leaderIndustryNumTarget;
        this.leaderIndustryNumValue = leaderIndustryNumValue;
        this.competitivePowerTarget = competitivePowerTarget;
        this.competitivePowerValue = competitivePowerValue;
        this.marketCompeteTotalScores = marketCompeteTotalScores;
        this.allTotalScores = allTotalScores;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public Dataanaly(Integer enterpriseId,Integer attributeId, Double netAssetTarget, Double netAssetValue, Double fixAssetTarget, Double fixAssetValue, Double incomeTarget, Double incomeValue, Double profitTarget, Double profitValue, Double netbalTarget, Double netbalValue, Double scaleMeritTotalScores, Double liquidRatioTarget, Double liquidRatioValue, Double quickRatioTarget, Double quickRatioValue, Double cashRatioTarget, Double cashRatioValue, Double debtRatioTarget, Double debtRatioValue, Double equityRatioTarget, Double equityRatioValue, Double interestTimesTarget, Double interestTimesValue, Double shareholderRatioTarget, Double shareholderRatioValue, Double collateralRatioTarget, Double collateralRatioValue, Double debtTotalScores, Double totalAssetTurnRatioTarget, Double totalAssetTurnRatioValue, Double liquidAssetTurnRatioTarget, Double liquidAssetTurnRatioValue, Double fixAssetTurnRatioTarget, Double fixAssetTurnRatioValue, Double receivableTurnRatioTarget, Double receivableTurnRatioValue, Double stockTurnRatioTarget, Double stockTurnRatioValue, Double assetIncrementRatioTarget, Double assetIncrementRatioValue, Double saleGrowRatioTarget, Double saleGrowRatioValue, Double operationTotalScores, Double totalAssetReturnRatioTarget, Double totalAssetReturnRatioValue, Double netAssetReturnRatioTarget, Double netAssetReturnRatioValue, Double perfitCostRatioTarget, Double perfitCostRatioValue, Double afterTaxProfitTarget, Double afterTaxProfitValue, Double saleProfitTarget, Double saleProfitValue, Double earningTotalScores, Double totalAssetGrowRatioTarget, Double totalAssetGrowRatioValue, Double netAssetGrowRatioTarget, Double netAssetGrowRatioValue, Double totalIncomeGrowRatioTarget, Double totalIncomeGrowRatioValue, Double netIncomeGrowRatioTarget, Double netIncomeGrowRatioValue, Double mainBusProfitGrowTarget, Double mainBusProfitGrowValue, Double employeeGrowRatioTarget, Double employeeGrowRatioValue, Integer euntreponierAgeTarget, Double euntreponierAgeValue, Integer euntreponierDegreeTarget, Double euntreponierDegreeValue, Double euntreponierWorkTimeTarget, Double euntreponierWorkTimeValue, Integer euntreponierPopularyTarget, Double euntreponierPopularyValue, Integer developPlanTarget, Double developPlanValue, Integer developStrategyTarget, Double developStrategyValue, Integer qualityCertificateTarget, Double qualityCertificateValue, Integer industryNatureTarget, Double industryNatureValue, Double growthTotalScores, Double highTechIncomeRatioTarget, Double highTechIncomeRatioValue, Double rdinputRatioTarget, Double rdinputRatioValue, Double rdmoneyGrowRatioTarget, Double rdmoneyGrowRatioValue, Double collageRatioTarget, Double collageRatioValue, Integer technicalPayoffNumTarget, Double technicalPayoffNumValue, Integer iprnumTarget, Double iprnumValue, Integer patentNumTarget, Double patentNumValue, Integer govprojectNumLandTarget, Double govprojectNumLandValue, Integer govprojectNumProTarget, Double govprojectNumProValue, Integer govprojectNumCityTarget, Double govprojectNumCityValue, Integer incentiveTarget, Double incentiveValue, Integer rdorganizationTarget, Double rdorganizationValue, Integer investmentOrganizationTarget, Double investmentOrganizationValue, Integer internateCooTarget, Double internateCooValue, Integer lhdtarget, Double lhdvalue, Double creativeTotalScores, Double interestCoverageRatioTarget, Double interestCoverageRatioValue, Double loanOutdateRatioTarget, Double loanOutdateRatioValue, Double payMoneyRatioTarget, Double payMoneyRatioValue, Integer personalCreditTarget, Double personalCreditValue, Double creditExerciseTotalScores, Integer manageLevelTarget, Double manageLevelValue, Integer shareholderBackgroundTarget, Double shareholderBackgroundValue, String managerWorkTimeTarget, Double managerWorkTimeValue, Integer boardSizeTarget, Double boardSizeValue, Integer chairCeotarget, Double chairCeovalue, Integer auditOpinionTarget, Double auditOpinionValue, Integer illegalBehaviorTarget, Double illegalBehaviorValue, Integer managerAgeTarget, Double managerAgeValue, Integer managerEdubackgroundTarget, Double managerEdubackgroundValue, Integer managerTitalTarget, Double managerTitalValue, Double managerLevelTotalScores, Integer industryPolicyTarget, Double industryPolicyValue, Integer industryPositionTarget, Double industryPositionValue, Integer leaderIndustryNumTarget, Double leaderIndustryNumValue, Integer competitivePowerTarget, Double competitivePowerValue, Double marketCompeteTotalScores, Double allTotalScores, String createTime, Integer creditClassId) {
        this.enterpriseId = enterpriseId;
        this.attributeId = attributeId;
        this.netAssetTarget = netAssetTarget;
        this.netAssetValue = netAssetValue;
        this.fixAssetTarget = fixAssetTarget;
        this.fixAssetValue = fixAssetValue;
        this.incomeTarget = incomeTarget;
        this.incomeValue = incomeValue;
        this.profitTarget = profitTarget;
        this.profitValue = profitValue;
        this.netbalTarget = netbalTarget;
        this.netbalValue = netbalValue;
        this.scaleMeritTotalScores = scaleMeritTotalScores;
        this.liquidRatioTarget = liquidRatioTarget;
        this.liquidRatioValue = liquidRatioValue;
        this.quickRatioTarget = quickRatioTarget;
        this.quickRatioValue = quickRatioValue;
        this.cashRatioTarget = cashRatioTarget;
        this.cashRatioValue = cashRatioValue;
        this.debtRatioTarget = debtRatioTarget;
        this.debtRatioValue = debtRatioValue;
        this.equityRatioTarget = equityRatioTarget;
        this.equityRatioValue = equityRatioValue;
        this.interestTimesTarget = interestTimesTarget;
        this.interestTimesValue = interestTimesValue;
        this.shareholderRatioTarget = shareholderRatioTarget;
        this.shareholderRatioValue = shareholderRatioValue;
        this.collateralRatioTarget = collateralRatioTarget;
        this.collateralRatioValue = collateralRatioValue;
        this.debtTotalScores = debtTotalScores;
        this.totalAssetTurnRatioTarget = totalAssetTurnRatioTarget;
        this.totalAssetTurnRatioValue = totalAssetTurnRatioValue;
        this.liquidAssetTurnRatioTarget = liquidAssetTurnRatioTarget;
        this.liquidAssetTurnRatioValue = liquidAssetTurnRatioValue;
        this.fixAssetTurnRatioTarget = fixAssetTurnRatioTarget;
        this.fixAssetTurnRatioValue = fixAssetTurnRatioValue;
        this.receivableTurnRatioTarget = receivableTurnRatioTarget;
        this.receivableTurnRatioValue = receivableTurnRatioValue;
        this.stockTurnRatioTarget = stockTurnRatioTarget;
        this.stockTurnRatioValue = stockTurnRatioValue;
        this.assetIncrementRatioTarget = assetIncrementRatioTarget;
        this.assetIncrementRatioValue = assetIncrementRatioValue;
        this.saleGrowRatioTarget = saleGrowRatioTarget;
        this.saleGrowRatioValue = saleGrowRatioValue;
        this.operationTotalScores = operationTotalScores;
        this.totalAssetReturnRatioTarget = totalAssetReturnRatioTarget;
        this.totalAssetReturnRatioValue = totalAssetReturnRatioValue;
        this.netAssetReturnRatioTarget = netAssetReturnRatioTarget;
        this.netAssetReturnRatioValue = netAssetReturnRatioValue;
        this.perfitCostRatioTarget = perfitCostRatioTarget;
        this.perfitCostRatioValue = perfitCostRatioValue;
        this.afterTaxProfitTarget = afterTaxProfitTarget;
        this.afterTaxProfitValue = afterTaxProfitValue;
        this.saleProfitTarget = saleProfitTarget;
        this.saleProfitValue = saleProfitValue;
        this.earningTotalScores = earningTotalScores;
        this.totalAssetGrowRatioTarget = totalAssetGrowRatioTarget;
        this.totalAssetGrowRatioValue = totalAssetGrowRatioValue;
        this.netAssetGrowRatioTarget = netAssetGrowRatioTarget;
        this.netAssetGrowRatioValue = netAssetGrowRatioValue;
        this.totalIncomeGrowRatioTarget = totalIncomeGrowRatioTarget;
        this.totalIncomeGrowRatioValue = totalIncomeGrowRatioValue;
        this.netIncomeGrowRatioTarget = netIncomeGrowRatioTarget;
        this.netIncomeGrowRatioValue = netIncomeGrowRatioValue;
        this.mainBusProfitGrowTarget = mainBusProfitGrowTarget;
        this.mainBusProfitGrowValue = mainBusProfitGrowValue;
        this.employeeGrowRatioTarget = employeeGrowRatioTarget;
        this.employeeGrowRatioValue = employeeGrowRatioValue;
        this.euntreponierAgeTarget = euntreponierAgeTarget;
        this.euntreponierAgeValue = euntreponierAgeValue;
        this.euntreponierDegreeTarget = euntreponierDegreeTarget;
        this.euntreponierDegreeValue = euntreponierDegreeValue;
        this.euntreponierWorkTimeTarget = euntreponierWorkTimeTarget;
        this.euntreponierWorkTimeValue = euntreponierWorkTimeValue;
        this.euntreponierPopularyTarget = euntreponierPopularyTarget;
        this.euntreponierPopularyValue = euntreponierPopularyValue;
        this.developPlanTarget = developPlanTarget;
        this.developPlanValue = developPlanValue;
        this.developStrategyTarget = developStrategyTarget;
        this.developStrategyValue = developStrategyValue;
        this.qualityCertificateTarget = qualityCertificateTarget;
        this.qualityCertificateValue = qualityCertificateValue;
        this.industryNatureTarget = industryNatureTarget;
        this.industryNatureValue = industryNatureValue;
        this.growthTotalScores = growthTotalScores;
        this.highTechIncomeRatioTarget = highTechIncomeRatioTarget;
        this.highTechIncomeRatioValue = highTechIncomeRatioValue;
        this.rdinputRatioTarget = rdinputRatioTarget;
        this.rdinputRatioValue = rdinputRatioValue;
        this.rdmoneyGrowRatioTarget = rdmoneyGrowRatioTarget;
        this.rdmoneyGrowRatioValue = rdmoneyGrowRatioValue;
        this.collageRatioTarget = collageRatioTarget;
        this.collageRatioValue = collageRatioValue;
        this.technicalPayoffNumTarget = technicalPayoffNumTarget;
        this.technicalPayoffNumValue = technicalPayoffNumValue;
        this.iprnumTarget = iprnumTarget;
        this.iprnumValue = iprnumValue;
        this.patentNumTarget = patentNumTarget;
        this.patentNumValue = patentNumValue;
        this.govprojectNumLandTarget = govprojectNumLandTarget;
        this.govprojectNumLandValue = govprojectNumLandValue;
        this.govprojectNumProTarget = govprojectNumProTarget;
        this.govprojectNumProValue = govprojectNumProValue;
        this.govprojectNumCityTarget = govprojectNumCityTarget;
        this.govprojectNumCityValue = govprojectNumCityValue;
        this.incentiveTarget = incentiveTarget;
        this.incentiveValue = incentiveValue;
        this.rdorganizationTarget = rdorganizationTarget;
        this.rdorganizationValue = rdorganizationValue;
        this.investmentOrganizationTarget = investmentOrganizationTarget;
        this.investmentOrganizationValue = investmentOrganizationValue;
        this.internateCooTarget = internateCooTarget;
        this.internateCooValue = internateCooValue;
        this.lhdtarget = lhdtarget;
        this.lhdvalue = lhdvalue;
        this.creativeTotalScores = creativeTotalScores;
        this.interestCoverageRatioTarget = interestCoverageRatioTarget;
        this.interestCoverageRatioValue = interestCoverageRatioValue;
        this.loanOutdateRatioTarget = loanOutdateRatioTarget;
        this.loanOutdateRatioValue = loanOutdateRatioValue;
        this.payMoneyRatioTarget = payMoneyRatioTarget;
        this.payMoneyRatioValue = payMoneyRatioValue;
        this.personalCreditTarget = personalCreditTarget;
        this.personalCreditValue = personalCreditValue;
        this.creditExerciseTotalScores = creditExerciseTotalScores;
        this.manageLevelTarget = manageLevelTarget;
        this.manageLevelValue = manageLevelValue;
        this.shareholderBackgroundTarget = shareholderBackgroundTarget;
        this.shareholderBackgroundValue = shareholderBackgroundValue;
        this.managerWorkTimeTarget = managerWorkTimeTarget;
        this.managerWorkTimeValue = managerWorkTimeValue;
        this.boardSizeTarget = boardSizeTarget;
        this.boardSizeValue = boardSizeValue;
        this.chairCeotarget = chairCeotarget;
        this.chairCeovalue = chairCeovalue;
        this.auditOpinionTarget = auditOpinionTarget;
        this.auditOpinionValue = auditOpinionValue;
        this.illegalBehaviorTarget = illegalBehaviorTarget;
        this.illegalBehaviorValue = illegalBehaviorValue;
        this.managerAgeTarget = managerAgeTarget;
        this.managerAgeValue = managerAgeValue;
        this.managerEdubackgroundTarget = managerEdubackgroundTarget;
        this.managerEdubackgroundValue = managerEdubackgroundValue;
        this.managerTitalTarget = managerTitalTarget;
        this.managerTitalValue = managerTitalValue;
        this.managerLevelTotalScores = managerLevelTotalScores;
        this.industryPolicyTarget = industryPolicyTarget;
        this.industryPolicyValue = industryPolicyValue;
        this.industryPositionTarget = industryPositionTarget;
        this.industryPositionValue = industryPositionValue;
        this.leaderIndustryNumTarget = leaderIndustryNumTarget;
        this.leaderIndustryNumValue = leaderIndustryNumValue;
        this.competitivePowerTarget = competitivePowerTarget;
        this.competitivePowerValue = competitivePowerValue;
        this.marketCompeteTotalScores = marketCompeteTotalScores;
        this.allTotalScores = allTotalScores;
        this.createTime = createTime;
        this.creditClassId = creditClassId;
    }

   
    // Property accessors

    public Integer getAnalyId() {
        return this.analyId;
    }
    
    public void setAnalyId(Integer analyId) {
        this.analyId = analyId;
    }
    
    
    public Integer getAttributeId() {
		return attributeId;
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

    public Double getNetAssetTarget() {
        return this.netAssetTarget;
    }
    
    public void setNetAssetTarget(Double netAssetTarget) {
        this.netAssetTarget = netAssetTarget;
    }

    public Double getNetAssetValue() {
        return this.netAssetValue;
    }
    
    public void setNetAssetValue(Double netAssetValue) {
        this.netAssetValue = netAssetValue;
    }

    public Double getFixAssetTarget() {
        return this.fixAssetTarget;
    }
    
    public void setFixAssetTarget(Double fixAssetTarget) {
        this.fixAssetTarget = fixAssetTarget;
    }

    public Double getFixAssetValue() {
        return this.fixAssetValue;
    }
    
    public void setFixAssetValue(Double fixAssetValue) {
        this.fixAssetValue = fixAssetValue;
    }

    public Double getIncomeTarget() {
        return this.incomeTarget;
    }
    
    public void setIncomeTarget(Double incomeTarget) {
        this.incomeTarget = incomeTarget;
    }

    public Double getIncomeValue() {
        return this.incomeValue;
    }
    
    public void setIncomeValue(Double incomeValue) {
        this.incomeValue = incomeValue;
    }

    public Double getProfitTarget() {
        return this.profitTarget;
    }
    
    public void setProfitTarget(Double profitTarget) {
        this.profitTarget = profitTarget;
    }

    public Double getProfitValue() {
        return this.profitValue;
    }
    
    public void setProfitValue(Double profitValue) {
        this.profitValue = profitValue;
    }

    public Double getNetbalTarget() {
        return this.netbalTarget;
    }
    
    public void setNetbalTarget(Double netbalTarget) {
        this.netbalTarget = netbalTarget;
    }

    public Double getNetbalValue() {
        return this.netbalValue;
    }
    
    public void setNetbalValue(Double netbalValue) {
        this.netbalValue = netbalValue;
    }

    public Double getScaleMeritTotalScores() {
        return this.scaleMeritTotalScores;
    }
    
    public void setScaleMeritTotalScores(Double scaleMeritTotalScores) {
        this.scaleMeritTotalScores = scaleMeritTotalScores;
    }

    public Double getLiquidRatioTarget() {
        return this.liquidRatioTarget;
    }
    
    public void setLiquidRatioTarget(Double liquidRatioTarget) {
        this.liquidRatioTarget = liquidRatioTarget;
    }

    public Double getLiquidRatioValue() {
        return this.liquidRatioValue;
    }
    
    public void setLiquidRatioValue(Double liquidRatioValue) {
        this.liquidRatioValue = liquidRatioValue;
    }

    public Double getQuickRatioTarget() {
        return this.quickRatioTarget;
    }
    
    public void setQuickRatioTarget(Double quickRatioTarget) {
        this.quickRatioTarget = quickRatioTarget;
    }

    public Double getQuickRatioValue() {
        return this.quickRatioValue;
    }
    
    public void setQuickRatioValue(Double quickRatioValue) {
        this.quickRatioValue = quickRatioValue;
    }

    public Double getCashRatioTarget() {
        return this.cashRatioTarget;
    }
    
    public void setCashRatioTarget(Double cashRatioTarget) {
        this.cashRatioTarget = cashRatioTarget;
    }

    public Double getCashRatioValue() {
        return this.cashRatioValue;
    }
    
    public void setCashRatioValue(Double cashRatioValue) {
        this.cashRatioValue = cashRatioValue;
    }

    public Double getDebtRatioTarget() {
        return this.debtRatioTarget;
    }
    
    public void setDebtRatioTarget(Double debtRatioTarget) {
        this.debtRatioTarget = debtRatioTarget;
    }

    public Double getDebtRatioValue() {
        return this.debtRatioValue;
    }
    
    public void setDebtRatioValue(Double debtRatioValue) {
        this.debtRatioValue = debtRatioValue;
    }

    public Double getEquityRatioTarget() {
        return this.equityRatioTarget;
    }
    
    public void setEquityRatioTarget(Double equityRatioTarget) {
        this.equityRatioTarget = equityRatioTarget;
    }

    public Double getEquityRatioValue() {
        return this.equityRatioValue;
    }
    
    public void setEquityRatioValue(Double equityRatioValue) {
        this.equityRatioValue = equityRatioValue;
    }

    public Double getInterestTimesTarget() {
        return this.interestTimesTarget;
    }
    
    public void setInterestTimesTarget(Double interestTimesTarget) {
        this.interestTimesTarget = interestTimesTarget;
    }

    public Double getInterestTimesValue() {
        return this.interestTimesValue;
    }
    
    public void setInterestTimesValue(Double interestTimesValue) {
        this.interestTimesValue = interestTimesValue;
    }

    public Double getShareholderRatioTarget() {
        return this.shareholderRatioTarget;
    }
    
    public void setShareholderRatioTarget(Double shareholderRatioTarget) {
        this.shareholderRatioTarget = shareholderRatioTarget;
    }

    public Double getShareholderRatioValue() {
        return this.shareholderRatioValue;
    }
    
    public void setShareholderRatioValue(Double shareholderRatioValue) {
        this.shareholderRatioValue = shareholderRatioValue;
    }

    public Double getCollateralRatioTarget() {
        return this.collateralRatioTarget;
    }
    
    public void setCollateralRatioTarget(Double collateralRatioTarget) {
        this.collateralRatioTarget = collateralRatioTarget;
    }

    public Double getCollateralRatioValue() {
        return this.collateralRatioValue;
    }
    
    public void setCollateralRatioValue(Double collateralRatioValue) {
        this.collateralRatioValue = collateralRatioValue;
    }

    public Double getDebtTotalScores() {
        return this.debtTotalScores;
    }
    
    public void setDebtTotalScores(Double debtTotalScores) {
        this.debtTotalScores = debtTotalScores;
    }

    public Double getTotalAssetTurnRatioTarget() {
        return this.totalAssetTurnRatioTarget;
    }
    
    public void setTotalAssetTurnRatioTarget(Double totalAssetTurnRatioTarget) {
        this.totalAssetTurnRatioTarget = totalAssetTurnRatioTarget;
    }

    public Double getTotalAssetTurnRatioValue() {
        return this.totalAssetTurnRatioValue;
    }
    
    public void setTotalAssetTurnRatioValue(Double totalAssetTurnRatioValue) {
        this.totalAssetTurnRatioValue = totalAssetTurnRatioValue;
    }

    public Double getLiquidAssetTurnRatioTarget() {
        return this.liquidAssetTurnRatioTarget;
    }
    
    public void setLiquidAssetTurnRatioTarget(Double liquidAssetTurnRatioTarget) {
        this.liquidAssetTurnRatioTarget = liquidAssetTurnRatioTarget;
    }

    public Double getLiquidAssetTurnRatioValue() {
        return this.liquidAssetTurnRatioValue;
    }
    
    public void setLiquidAssetTurnRatioValue(Double liquidAssetTurnRatioValue) {
        this.liquidAssetTurnRatioValue = liquidAssetTurnRatioValue;
    }

    public Double getFixAssetTurnRatioTarget() {
        return this.fixAssetTurnRatioTarget;
    }
    
    public void setFixAssetTurnRatioTarget(Double fixAssetTurnRatioTarget) {
        this.fixAssetTurnRatioTarget = fixAssetTurnRatioTarget;
    }

    public Double getFixAssetTurnRatioValue() {
        return this.fixAssetTurnRatioValue;
    }
    
    public void setFixAssetTurnRatioValue(Double fixAssetTurnRatioValue) {
        this.fixAssetTurnRatioValue = fixAssetTurnRatioValue;
    }

    public Double getReceivableTurnRatioTarget() {
        return this.receivableTurnRatioTarget;
    }
    
    public void setReceivableTurnRatioTarget(Double receivableTurnRatioTarget) {
        this.receivableTurnRatioTarget = receivableTurnRatioTarget;
    }

    public Double getReceivableTurnRatioValue() {
        return this.receivableTurnRatioValue;
    }
    
    public void setReceivableTurnRatioValue(Double receivableTurnRatioValue) {
        this.receivableTurnRatioValue = receivableTurnRatioValue;
    }

    public Double getStockTurnRatioTarget() {
        return this.stockTurnRatioTarget;
    }
    
    public void setStockTurnRatioTarget(Double stockTurnRatioTarget) {
        this.stockTurnRatioTarget = stockTurnRatioTarget;
    }

    public Double getStockTurnRatioValue() {
        return this.stockTurnRatioValue;
    }
    
    public void setStockTurnRatioValue(Double stockTurnRatioValue) {
        this.stockTurnRatioValue = stockTurnRatioValue;
    }

    public Double getAssetIncrementRatioTarget() {
        return this.assetIncrementRatioTarget;
    }
    
    public void setAssetIncrementRatioTarget(Double assetIncrementRatioTarget) {
        this.assetIncrementRatioTarget = assetIncrementRatioTarget;
    }

    public Double getAssetIncrementRatioValue() {
        return this.assetIncrementRatioValue;
    }
    
    public void setAssetIncrementRatioValue(Double assetIncrementRatioValue) {
        this.assetIncrementRatioValue = assetIncrementRatioValue;
    }

    public Double getSaleGrowRatioTarget() {
        return this.saleGrowRatioTarget;
    }
    
    public void setSaleGrowRatioTarget(Double saleGrowRatioTarget) {
        this.saleGrowRatioTarget = saleGrowRatioTarget;
    }

    public Double getSaleGrowRatioValue() {
        return this.saleGrowRatioValue;
    }
    
    public void setSaleGrowRatioValue(Double saleGrowRatioValue) {
        this.saleGrowRatioValue = saleGrowRatioValue;
    }

    public Double getOperationTotalScores() {
        return this.operationTotalScores;
    }
    
    public void setOperationTotalScores(Double operationTotalScores) {
        this.operationTotalScores = operationTotalScores;
    }

    public Double getTotalAssetReturnRatioTarget() {
        return this.totalAssetReturnRatioTarget;
    }
    
    public void setTotalAssetReturnRatioTarget(Double totalAssetReturnRatioTarget) {
        this.totalAssetReturnRatioTarget = totalAssetReturnRatioTarget;
    }

    public Double getTotalAssetReturnRatioValue() {
        return this.totalAssetReturnRatioValue;
    }
    
    public void setTotalAssetReturnRatioValue(Double totalAssetReturnRatioValue) {
        this.totalAssetReturnRatioValue = totalAssetReturnRatioValue;
    }

    public Double getNetAssetReturnRatioTarget() {
        return this.netAssetReturnRatioTarget;
    }
    
    public void setNetAssetReturnRatioTarget(Double netAssetReturnRatioTarget) {
        this.netAssetReturnRatioTarget = netAssetReturnRatioTarget;
    }

    public Double getNetAssetReturnRatioValue() {
        return this.netAssetReturnRatioValue;
    }
    
    public void setNetAssetReturnRatioValue(Double netAssetReturnRatioValue) {
        this.netAssetReturnRatioValue = netAssetReturnRatioValue;
    }

    public Double getPerfitCostRatioTarget() {
        return this.perfitCostRatioTarget;
    }
    
    public void setPerfitCostRatioTarget(Double perfitCostRatioTarget) {
        this.perfitCostRatioTarget = perfitCostRatioTarget;
    }

    public Double getPerfitCostRatioValue() {
        return this.perfitCostRatioValue;
    }
    
    public void setPerfitCostRatioValue(Double perfitCostRatioValue) {
        this.perfitCostRatioValue = perfitCostRatioValue;
    }

    public Double getAfterTaxProfitTarget() {
        return this.afterTaxProfitTarget;
    }
    
    public void setAfterTaxProfitTarget(Double afterTaxProfitTarget) {
        this.afterTaxProfitTarget = afterTaxProfitTarget;
    }

    public Double getAfterTaxProfitValue() {
        return this.afterTaxProfitValue;
    }
    
    public void setAfterTaxProfitValue(Double afterTaxProfitValue) {
        this.afterTaxProfitValue = afterTaxProfitValue;
    }

    public Double getSaleProfitTarget() {
        return this.saleProfitTarget;
    }
    
    public void setSaleProfitTarget(Double saleProfitTarget) {
        this.saleProfitTarget = saleProfitTarget;
    }

    public Double getSaleProfitValue() {
        return this.saleProfitValue;
    }
    
    public void setSaleProfitValue(Double saleProfitValue) {
        this.saleProfitValue = saleProfitValue;
    }

    public Double getEarningTotalScores() {
        return this.earningTotalScores;
    }
    
    public void setEarningTotalScores(Double earningTotalScores) {
        this.earningTotalScores = earningTotalScores;
    }

    public Double getTotalAssetGrowRatioTarget() {
        return this.totalAssetGrowRatioTarget;
    }
    
    public void setTotalAssetGrowRatioTarget(Double totalAssetGrowRatioTarget) {
        this.totalAssetGrowRatioTarget = totalAssetGrowRatioTarget;
    }

    public Double getTotalAssetGrowRatioValue() {
        return this.totalAssetGrowRatioValue;
    }
    
    public void setTotalAssetGrowRatioValue(Double totalAssetGrowRatioValue) {
        this.totalAssetGrowRatioValue = totalAssetGrowRatioValue;
    }

    public Double getNetAssetGrowRatioTarget() {
        return this.netAssetGrowRatioTarget;
    }
    
    public void setNetAssetGrowRatioTarget(Double netAssetGrowRatioTarget) {
        this.netAssetGrowRatioTarget = netAssetGrowRatioTarget;
    }

    public Double getNetAssetGrowRatioValue() {
        return this.netAssetGrowRatioValue;
    }
    
    public void setNetAssetGrowRatioValue(Double netAssetGrowRatioValue) {
        this.netAssetGrowRatioValue = netAssetGrowRatioValue;
    }

    public Double getTotalIncomeGrowRatioTarget() {
        return this.totalIncomeGrowRatioTarget;
    }
    
    public void setTotalIncomeGrowRatioTarget(Double totalIncomeGrowRatioTarget) {
        this.totalIncomeGrowRatioTarget = totalIncomeGrowRatioTarget;
    }

    public Double getTotalIncomeGrowRatioValue() {
        return this.totalIncomeGrowRatioValue;
    }
    
    public void setTotalIncomeGrowRatioValue(Double totalIncomeGrowRatioValue) {
        this.totalIncomeGrowRatioValue = totalIncomeGrowRatioValue;
    }

    public Double getNetIncomeGrowRatioTarget() {
        return this.netIncomeGrowRatioTarget;
    }
    
    public void setNetIncomeGrowRatioTarget(Double netIncomeGrowRatioTarget) {
        this.netIncomeGrowRatioTarget = netIncomeGrowRatioTarget;
    }

    public Double getNetIncomeGrowRatioValue() {
        return this.netIncomeGrowRatioValue;
    }
    
    public void setNetIncomeGrowRatioValue(Double netIncomeGrowRatioValue) {
        this.netIncomeGrowRatioValue = netIncomeGrowRatioValue;
    }

    public Double getMainBusProfitGrowTarget() {
        return this.mainBusProfitGrowTarget;
    }
    
    public void setMainBusProfitGrowTarget(Double mainBusProfitGrowTarget) {
        this.mainBusProfitGrowTarget = mainBusProfitGrowTarget;
    }

    public Double getMainBusProfitGrowValue() {
        return this.mainBusProfitGrowValue;
    }
    
    public void setMainBusProfitGrowValue(Double mainBusProfitGrowValue) {
        this.mainBusProfitGrowValue = mainBusProfitGrowValue;
    }

    public Double getEmployeeGrowRatioTarget() {
        return this.employeeGrowRatioTarget;
    }
    
    public void setEmployeeGrowRatioTarget(Double employeeGrowRatioTarget) {
        this.employeeGrowRatioTarget = employeeGrowRatioTarget;
    }

    public Double getEmployeeGrowRatioValue() {
        return this.employeeGrowRatioValue;
    }
    
    public void setEmployeeGrowRatioValue(Double employeeGrowRatioValue) {
        this.employeeGrowRatioValue = employeeGrowRatioValue;
    }

    public Integer getEuntreponierAgeTarget() {
        return this.euntreponierAgeTarget;
    }
    
    public void setEuntreponierAgeTarget(Integer euntreponierAgeTarget) {
        this.euntreponierAgeTarget = euntreponierAgeTarget;
    }

    public Double getEuntreponierAgeValue() {
        return this.euntreponierAgeValue;
    }
    
    public void setEuntreponierAgeValue(Double euntreponierAgeValue) {
        this.euntreponierAgeValue = euntreponierAgeValue;
    }

    public Integer getEuntreponierDegreeTarget() {
        return this.euntreponierDegreeTarget;
    }
    
    public void setEuntreponierDegreeTarget(Integer euntreponierDegreeTarget) {
        this.euntreponierDegreeTarget = euntreponierDegreeTarget;
    }

    public Double getEuntreponierDegreeValue() {
        return this.euntreponierDegreeValue;
    }
    
    public void setEuntreponierDegreeValue(Double euntreponierDegreeValue) {
        this.euntreponierDegreeValue = euntreponierDegreeValue;
    }

    public Double getEuntreponierWorkTimeTarget() {
        return this.euntreponierWorkTimeTarget;
    }
    
    public void setEuntreponierWorkTimeTarget(Double euntreponierWorkTimeTarget) {
        this.euntreponierWorkTimeTarget = euntreponierWorkTimeTarget;
    }

    public Double getEuntreponierWorkTimeValue() {
        return this.euntreponierWorkTimeValue;
    }
    
    public void setEuntreponierWorkTimeValue(Double euntreponierWorkTimeValue) {
        this.euntreponierWorkTimeValue = euntreponierWorkTimeValue;
    }

    public Integer getEuntreponierPopularyTarget() {
        return this.euntreponierPopularyTarget;
    }
    
    public void setEuntreponierPopularyTarget(Integer euntreponierPopularyTarget) {
        this.euntreponierPopularyTarget = euntreponierPopularyTarget;
    }

    public Double getEuntreponierPopularyValue() {
        return this.euntreponierPopularyValue;
    }
    
    public void setEuntreponierPopularyValue(Double euntreponierPopularyValue) {
        this.euntreponierPopularyValue = euntreponierPopularyValue;
    }

    public Integer getDevelopPlanTarget() {
        return this.developPlanTarget;
    }
    
    public void setDevelopPlanTarget(Integer developPlanTarget) {
        this.developPlanTarget = developPlanTarget;
    }

    public Double getDevelopPlanValue() {
        return this.developPlanValue;
    }
    
    public void setDevelopPlanValue(Double developPlanValue) {
        this.developPlanValue = developPlanValue;
    }

    public Integer getDevelopStrategyTarget() {
        return this.developStrategyTarget;
    }
    
    public void setDevelopStrategyTarget(Integer developStrategyTarget) {
        this.developStrategyTarget = developStrategyTarget;
    }

    public Double getDevelopStrategyValue() {
        return this.developStrategyValue;
    }
    
    public void setDevelopStrategyValue(Double developStrategyValue) {
        this.developStrategyValue = developStrategyValue;
    }

    public Integer getQualityCertificateTarget() {
        return this.qualityCertificateTarget;
    }
    
    public void setQualityCertificateTarget(Integer qualityCertificateTarget) {
        this.qualityCertificateTarget = qualityCertificateTarget;
    }

    public Double getQualityCertificateValue() {
        return this.qualityCertificateValue;
    }
    
    public void setQualityCertificateValue(Double qualityCertificateValue) {
        this.qualityCertificateValue = qualityCertificateValue;
    }

    public Integer getIndustryNatureTarget() {
        return this.industryNatureTarget;
    }
    
    public void setIndustryNatureTarget(Integer industryNatureTarget) {
        this.industryNatureTarget = industryNatureTarget;
    }

    public Double getIndustryNatureValue() {
        return this.industryNatureValue;
    }
    
    public void setIndustryNatureValue(Double industryNatureValue) {
        this.industryNatureValue = industryNatureValue;
    }

    public Double getGrowthTotalScores() {
        return this.growthTotalScores;
    }
    
    public void setGrowthTotalScores(Double growthTotalScores) {
        this.growthTotalScores = growthTotalScores;
    }

    public Double getHighTechIncomeRatioTarget() {
        return this.highTechIncomeRatioTarget;
    }
    
    public void setHighTechIncomeRatioTarget(Double highTechIncomeRatioTarget) {
        this.highTechIncomeRatioTarget = highTechIncomeRatioTarget;
    }

    public Double getHighTechIncomeRatioValue() {
        return this.highTechIncomeRatioValue;
    }
    
    public void setHighTechIncomeRatioValue(Double highTechIncomeRatioValue) {
        this.highTechIncomeRatioValue = highTechIncomeRatioValue;
    }

    public Double getRdinputRatioTarget() {
        return this.rdinputRatioTarget;
    }
    
    public void setRdinputRatioTarget(Double rdinputRatioTarget) {
        this.rdinputRatioTarget = rdinputRatioTarget;
    }

    public Double getRdinputRatioValue() {
        return this.rdinputRatioValue;
    }
    
    public void setRdinputRatioValue(Double rdinputRatioValue) {
        this.rdinputRatioValue = rdinputRatioValue;
    }

    public Double getRdmoneyGrowRatioTarget() {
        return this.rdmoneyGrowRatioTarget;
    }
    
    public void setRdmoneyGrowRatioTarget(Double rdmoneyGrowRatioTarget) {
        this.rdmoneyGrowRatioTarget = rdmoneyGrowRatioTarget;
    }

    public Double getRdmoneyGrowRatioValue() {
        return this.rdmoneyGrowRatioValue;
    }
    
    public void setRdmoneyGrowRatioValue(Double rdmoneyGrowRatioValue) {
        this.rdmoneyGrowRatioValue = rdmoneyGrowRatioValue;
    }

    public Double getCollageRatioTarget() {
        return this.collageRatioTarget;
    }
    
    public void setCollageRatioTarget(Double collageRatioTarget) {
        this.collageRatioTarget = collageRatioTarget;
    }

    public Double getCollageRatioValue() {
        return this.collageRatioValue;
    }
    
    public void setCollageRatioValue(Double collageRatioValue) {
        this.collageRatioValue = collageRatioValue;
    }

    public Integer getTechnicalPayoffNumTarget() {
        return this.technicalPayoffNumTarget;
    }
    
    public void setTechnicalPayoffNumTarget(Integer technicalPayoffNumTarget) {
        this.technicalPayoffNumTarget = technicalPayoffNumTarget;
    }

    public Double getTechnicalPayoffNumValue() {
        return this.technicalPayoffNumValue;
    }
    
    public void setTechnicalPayoffNumValue(Double technicalPayoffNumValue) {
        this.technicalPayoffNumValue = technicalPayoffNumValue;
    }

    public Integer getIprnumTarget() {
        return this.iprnumTarget;
    }
    
    public void setIprnumTarget(Integer iprnumTarget) {
        this.iprnumTarget = iprnumTarget;
    }

    public Double getIprnumValue() {
        return this.iprnumValue;
    }
    
    public void setIprnumValue(Double iprnumValue) {
        this.iprnumValue = iprnumValue;
    }

    public Integer getPatentNumTarget() {
        return this.patentNumTarget;
    }
    
    public void setPatentNumTarget(Integer patentNumTarget) {
        this.patentNumTarget = patentNumTarget;
    }

    public Double getPatentNumValue() {
        return this.patentNumValue;
    }
    
    public void setPatentNumValue(Double patentNumValue) {
        this.patentNumValue = patentNumValue;
    }

    public Integer getGovprojectNumLandTarget() {
        return this.govprojectNumLandTarget;
    }
    
    public void setGovprojectNumLandTarget(Integer govprojectNumLandTarget) {
        this.govprojectNumLandTarget = govprojectNumLandTarget;
    }

    public Double getGovprojectNumLandValue() {
        return this.govprojectNumLandValue;
    }
    
    public void setGovprojectNumLandValue(Double govprojectNumLandValue) {
        this.govprojectNumLandValue = govprojectNumLandValue;
    }

    public Integer getGovprojectNumProTarget() {
        return this.govprojectNumProTarget;
    }
    
    public void setGovprojectNumProTarget(Integer govprojectNumProTarget) {
        this.govprojectNumProTarget = govprojectNumProTarget;
    }

    public Double getGovprojectNumProValue() {
        return this.govprojectNumProValue;
    }
    
    public void setGovprojectNumProValue(Double govprojectNumProValue) {
        this.govprojectNumProValue = govprojectNumProValue;
    }

    public Integer getGovprojectNumCityTarget() {
        return this.govprojectNumCityTarget;
    }
    
    public void setGovprojectNumCityTarget(Integer govprojectNumCityTarget) {
        this.govprojectNumCityTarget = govprojectNumCityTarget;
    }

    public Double getGovprojectNumCityValue() {
        return this.govprojectNumCityValue;
    }
    
    public void setGovprojectNumCityValue(Double govprojectNumCityValue) {
        this.govprojectNumCityValue = govprojectNumCityValue;
    }

    public Integer getIncentiveTarget() {
        return this.incentiveTarget;
    }
    
    public void setIncentiveTarget(Integer incentiveTarget) {
        this.incentiveTarget = incentiveTarget;
    }

    public Double getIncentiveValue() {
        return this.incentiveValue;
    }
    
    public void setIncentiveValue(Double incentiveValue) {
        this.incentiveValue = incentiveValue;
    }

    public Integer getRdorganizationTarget() {
        return this.rdorganizationTarget;
    }
    
    public void setRdorganizationTarget(Integer rdorganizationTarget) {
        this.rdorganizationTarget = rdorganizationTarget;
    }

    public Double getRdorganizationValue() {
        return this.rdorganizationValue;
    }
    
    public void setRdorganizationValue(Double rdorganizationValue) {
        this.rdorganizationValue = rdorganizationValue;
    }

    public Integer getInvestmentOrganizationTarget() {
        return this.investmentOrganizationTarget;
    }
    
    public void setInvestmentOrganizationTarget(Integer investmentOrganizationTarget) {
        this.investmentOrganizationTarget = investmentOrganizationTarget;
    }

    public Double getInvestmentOrganizationValue() {
        return this.investmentOrganizationValue;
    }
    
    public void setInvestmentOrganizationValue(Double investmentOrganizationValue) {
        this.investmentOrganizationValue = investmentOrganizationValue;
    }

    public Integer getInternateCooTarget() {
        return this.internateCooTarget;
    }
    
    public void setInternateCooTarget(Integer internateCooTarget) {
        this.internateCooTarget = internateCooTarget;
    }

    public Double getInternateCooValue() {
        return this.internateCooValue;
    }
    
    public void setInternateCooValue(Double internateCooValue) {
        this.internateCooValue = internateCooValue;
    }

    public Integer getLhdtarget() {
        return this.lhdtarget;
    }
    
    public void setLhdtarget(Integer lhdtarget) {
        this.lhdtarget = lhdtarget;
    }

    public Double getLhdvalue() {
        return this.lhdvalue;
    }
    
    public void setLhdvalue(Double lhdvalue) {
        this.lhdvalue = lhdvalue;
    }

    public Double getCreativeTotalScores() {
        return this.creativeTotalScores;
    }
    
    public void setCreativeTotalScores(Double creativeTotalScores) {
        this.creativeTotalScores = creativeTotalScores;
    }

    public Double getInterestCoverageRatioTarget() {
        return this.interestCoverageRatioTarget;
    }
    
    public void setInterestCoverageRatioTarget(Double interestCoverageRatioTarget) {
        this.interestCoverageRatioTarget = interestCoverageRatioTarget;
    }

    public Double getInterestCoverageRatioValue() {
        return this.interestCoverageRatioValue;
    }
    
    public void setInterestCoverageRatioValue(Double interestCoverageRatioValue) {
        this.interestCoverageRatioValue = interestCoverageRatioValue;
    }

    public Double getLoanOutdateRatioTarget() {
        return this.loanOutdateRatioTarget;
    }
    
    public void setLoanOutdateRatioTarget(Double loanOutdateRatioTarget) {
        this.loanOutdateRatioTarget = loanOutdateRatioTarget;
    }

    public Double getLoanOutdateRatioValue() {
        return this.loanOutdateRatioValue;
    }
    
    public void setLoanOutdateRatioValue(Double loanOutdateRatioValue) {
        this.loanOutdateRatioValue = loanOutdateRatioValue;
    }

    public Double getPayMoneyRatioTarget() {
        return this.payMoneyRatioTarget;
    }
    
    public void setPayMoneyRatioTarget(Double payMoneyRatioTarget) {
        this.payMoneyRatioTarget = payMoneyRatioTarget;
    }

    public Double getPayMoneyRatioValue() {
        return this.payMoneyRatioValue;
    }
    
    public void setPayMoneyRatioValue(Double payMoneyRatioValue) {
        this.payMoneyRatioValue = payMoneyRatioValue;
    }

    public Integer getPersonalCreditTarget() {
        return this.personalCreditTarget;
    }
    
    public void setPersonalCreditTarget(Integer personalCreditTarget) {
        this.personalCreditTarget = personalCreditTarget;
    }

    public Double getPersonalCreditValue() {
        return this.personalCreditValue;
    }
    
    public void setPersonalCreditValue(Double personalCreditValue) {
        this.personalCreditValue = personalCreditValue;
    }

    public Double getCreditExerciseTotalScores() {
        return this.creditExerciseTotalScores;
    }
    
    public void setCreditExerciseTotalScores(Double creditExerciseTotalScores) {
        this.creditExerciseTotalScores = creditExerciseTotalScores;
    }

    public Integer getManageLevelTarget() {
        return this.manageLevelTarget;
    }
    
    public void setManageLevelTarget(Integer manageLevelTarget) {
        this.manageLevelTarget = manageLevelTarget;
    }

    public Double getManageLevelValue() {
        return this.manageLevelValue;
    }
    
    public void setManageLevelValue(Double manageLevelValue) {
        this.manageLevelValue = manageLevelValue;
    }

    public Integer getShareholderBackgroundTarget() {
        return this.shareholderBackgroundTarget;
    }
    
    public void setShareholderBackgroundTarget(Integer shareholderBackgroundTarget) {
        this.shareholderBackgroundTarget = shareholderBackgroundTarget;
    }

    public Double getShareholderBackgroundValue() {
        return this.shareholderBackgroundValue;
    }
    
    public void setShareholderBackgroundValue(Double shareholderBackgroundValue) {
        this.shareholderBackgroundValue = shareholderBackgroundValue;
    }

    public String getManagerWorkTimeTarget() {
        return this.managerWorkTimeTarget;
    }
    
    public void setManagerWorkTimeTarget(String managerWorkTimeTarget) {
        this.managerWorkTimeTarget = managerWorkTimeTarget;
    }

    public Double getManagerWorkTimeValue() {
        return this.managerWorkTimeValue;
    }
    
    public void setManagerWorkTimeValue(Double managerWorkTimeValue) {
        this.managerWorkTimeValue = managerWorkTimeValue;
    }

    public Integer getBoardSizeTarget() {
        return this.boardSizeTarget;
    }
    
    public void setBoardSizeTarget(Integer boardSizeTarget) {
        this.boardSizeTarget = boardSizeTarget;
    }

    public Double getBoardSizeValue() {
        return this.boardSizeValue;
    }
    
    public void setBoardSizeValue(Double boardSizeValue) {
        this.boardSizeValue = boardSizeValue;
    }

    public Integer getChairCeotarget() {
        return this.chairCeotarget;
    }
    
    public void setChairCeotarget(Integer chairCeotarget) {
        this.chairCeotarget = chairCeotarget;
    }

    public Double getChairCeovalue() {
        return this.chairCeovalue;
    }
    
    public void setChairCeovalue(Double chairCeovalue) {
        this.chairCeovalue = chairCeovalue;
    }

    public Integer getAuditOpinionTarget() {
        return this.auditOpinionTarget;
    }
    
    public void setAuditOpinionTarget(Integer auditOpinionTarget) {
        this.auditOpinionTarget = auditOpinionTarget;
    }

    public Double getAuditOpinionValue() {
        return this.auditOpinionValue;
    }
    
    public void setAuditOpinionValue(Double auditOpinionValue) {
        this.auditOpinionValue = auditOpinionValue;
    }

    public Integer getIllegalBehaviorTarget() {
        return this.illegalBehaviorTarget;
    }
    
    public void setIllegalBehaviorTarget(Integer illegalBehaviorTarget) {
        this.illegalBehaviorTarget = illegalBehaviorTarget;
    }

    public Double getIllegalBehaviorValue() {
        return this.illegalBehaviorValue;
    }
    
    public void setIllegalBehaviorValue(Double illegalBehaviorValue) {
        this.illegalBehaviorValue = illegalBehaviorValue;
    }

    public Integer getManagerAgeTarget() {
        return this.managerAgeTarget;
    }
    
    public void setManagerAgeTarget(Integer managerAgeTarget) {
        this.managerAgeTarget = managerAgeTarget;
    }

    public Double getManagerAgeValue() {
        return this.managerAgeValue;
    }
    
    public void setManagerAgeValue(Double managerAgeValue) {
        this.managerAgeValue = managerAgeValue;
    }

    public Integer getManagerEdubackgroundTarget() {
        return this.managerEdubackgroundTarget;
    }
    
    public void setManagerEdubackgroundTarget(Integer managerEdubackgroundTarget) {
        this.managerEdubackgroundTarget = managerEdubackgroundTarget;
    }

    public Double getManagerEdubackgroundValue() {
        return this.managerEdubackgroundValue;
    }
    
    public void setManagerEdubackgroundValue(Double managerEdubackgroundValue) {
        this.managerEdubackgroundValue = managerEdubackgroundValue;
    }

    public Integer getManagerTitalTarget() {
        return this.managerTitalTarget;
    }
    
    public void setManagerTitalTarget(Integer managerTitalTarget) {
        this.managerTitalTarget = managerTitalTarget;
    }

    public Double getManagerTitalValue() {
        return this.managerTitalValue;
    }
    
    public void setManagerTitalValue(Double managerTitalValue) {
        this.managerTitalValue = managerTitalValue;
    }

    public Double getManagerLevelTotalScores() {
        return this.managerLevelTotalScores;
    }
    
    public void setManagerLevelTotalScores(Double managerLevelTotalScores) {
        this.managerLevelTotalScores = managerLevelTotalScores;
    }

    public Integer getIndustryPolicyTarget() {
        return this.industryPolicyTarget;
    }
    
    public void setIndustryPolicyTarget(Integer industryPolicyTarget) {
        this.industryPolicyTarget = industryPolicyTarget;
    }

    public Double getIndustryPolicyValue() {
        return this.industryPolicyValue;
    }
    
    public void setIndustryPolicyValue(Double industryPolicyValue) {
        this.industryPolicyValue = industryPolicyValue;
    }

    public Integer getIndustryPositionTarget() {
        return this.industryPositionTarget;
    }
    
    public void setIndustryPositionTarget(Integer industryPositionTarget) {
        this.industryPositionTarget = industryPositionTarget;
    }

    public Double getIndustryPositionValue() {
        return this.industryPositionValue;
    }
    
    public void setIndustryPositionValue(Double industryPositionValue) {
        this.industryPositionValue = industryPositionValue;
    }

    public Integer getLeaderIndustryNumTarget() {
        return this.leaderIndustryNumTarget;
    }
    
    public void setLeaderIndustryNumTarget(Integer leaderIndustryNumTarget) {
        this.leaderIndustryNumTarget = leaderIndustryNumTarget;
    }

    public Double getLeaderIndustryNumValue() {
        return this.leaderIndustryNumValue;
    }
    
    public void setLeaderIndustryNumValue(Double leaderIndustryNumValue) {
        this.leaderIndustryNumValue = leaderIndustryNumValue;
    }

    public Integer getCompetitivePowerTarget() {
        return this.competitivePowerTarget;
    }
    
    public void setCompetitivePowerTarget(Integer competitivePowerTarget) {
        this.competitivePowerTarget = competitivePowerTarget;
    }

    public Double getCompetitivePowerValue() {
        return this.competitivePowerValue;
    }
    
    public void setCompetitivePowerValue(Double competitivePowerValue) {
        this.competitivePowerValue = competitivePowerValue;
    }

    public Double getMarketCompeteTotalScores() {
        return this.marketCompeteTotalScores;
    }
    
    public void setMarketCompeteTotalScores(Double marketCompeteTotalScores) {
        this.marketCompeteTotalScores = marketCompeteTotalScores;
    }

    public Double getAllTotalScores() {
        return this.allTotalScores;
    }
    
    public void setAllTotalScores(Double allTotalScores) {
        this.allTotalScores = allTotalScores;
    }

    public String getcreateTime() {
        return this.createTime;
    }
    
    public void setcreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCreditClassId() {
        return this.creditClassId;
    }
    
    public void setCreditClassId(Integer creditClassId) {
        this.creditClassId = creditClassId;
    }
    public Enterpriseinfo getUser() {
		return user;
	}

	public void setUser(Enterpriseinfo user) {
		this.user = user;
	}

	public void setScaleMeritTotalScores(double scaleMeritTotalScores) {
		this.scaleMeritTotalScores = scaleMeritTotalScores;
	}

	public void setDebtTotalScores(double debtTotalScores) {
		this.debtTotalScores = debtTotalScores;
	}

	public void setOperationTotalScores(double operationTotalScores) {
		this.operationTotalScores = operationTotalScores;
	}

	public void setEarningTotalScores(double earningTotalScores) {
		this.earningTotalScores = earningTotalScores;
	}

	public void setGrowthTotalScores(double growthTotalScores) {
		this.growthTotalScores = growthTotalScores;
	}

	public void setCreativeTotalScores(double creativeTotalScores) {
		this.creativeTotalScores = creativeTotalScores;
	}

	public void setCreditExerciseTotalScores(double creditExerciseTotalScores) {
		this.creditExerciseTotalScores = creditExerciseTotalScores;
	}

	public void setManagerLevelTotalScores(double managerLevelTotalScores) {
		this.managerLevelTotalScores = managerLevelTotalScores;
	}

	public void setMarketCompeteTotalScores(double marketCompeteTotalScores) {
		this.marketCompeteTotalScores = marketCompeteTotalScores;
	}

	public void setAllTotalScores(double allTotalScores) {
		this.allTotalScores = allTotalScores;
	}








}
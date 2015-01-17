package com.loongxun.cbe.enterprise.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.bean.CreditRating;
import com.loongxun.cbe.enterprise.bean.Dataanaly;
import com.loongxun.cbe.enterprise.bean.Dataanalyh;
import com.loongxun.cbe.enterprise.bean.Operation;
import com.loongxun.cbe.enterprise.bean.Ratingresults;
import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.AttributeDao;
import com.loongxun.cbe.enterprise.dao.DataAnalyDAO;
import com.loongxun.cbe.enterprise.dao.DataAnalyHDAO;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.enterprise.dao.RatingResultsDAO;
import com.loongxun.cbe.enterprise.dao.RatingResultsHDAO;
import com.loongxun.cbe.until.CreativeKPI;
import com.loongxun.cbe.until.CreditPerformancePowerUtil;
import com.loongxun.cbe.until.DebtResemption;
import com.loongxun.cbe.until.GrowthIndexValue;
import com.loongxun.cbe.until.ManagementLevel;
import com.loongxun.cbe.until.MarketCompetition;
import com.loongxun.cbe.until.OperationModel;
import com.loongxun.cbe.until.OperationalCapacity;
import com.loongxun.cbe.until.ProfitAbility;
import com.loongxun.cbe.user.bean.Enterpriseinfo;

/**
 * 描述：指标信息service
 * @version 1.0
 */
public class AttributeService {
	private AttributeDao attributeDao;//指标DAO
	private DataAnalyDAO analyDAO;//数据分析DAO
	private DataAnalyHDAO analyHDAO;//数据分析历史记录DAO
	private RatingResultsDAO ratingResultsDAO;//评级结果DAO
	private RatingResultsHDAO ratingHDAO;//评级结果的历史DAO
	private EnterpriseDAO enterpriseDAO;//
	
	public void saveDataanaly(int epId,int revaluation,int attirbuteId) throws Exception {
		Dataanaly dataanaly = new Dataanaly();
		Ratingresults ratingResults = new Ratingresults();
		Ratingresultsh ratingResultsh = new Ratingresultsh();
		Enterpriseinfo epinfo = enterpriseDAO.findById(epId);
		Attribute attribute = attributeDao.findByAbId(attirbuteId);
		dataanaly.setEnterpriseId(epId);
		dataanaly.setAttributeId(attirbuteId);
		// 1 企业规模指标
		// 企业净资产总额
		dataanaly.setNetAssetTarget(attribute.getTotalNetAssets());
		double netAssetValue = OperationModel.netAssetsSore(epinfo.getStage(),
				1, !epinfo.getIsHeavyIndustry(), attribute.getTotalNetAssets());

		dataanaly.setNetAssetValue(netAssetValue);
		// 企业固定资产总额
		dataanaly.setFixAssetTarget(attribute.getTotalCapitalAsserts());
		double fixAssetValue = OperationModel.netAssetsSore(epinfo.getStage(),
				2, !epinfo.getIsHeavyIndustry(), attribute
						.getTotalCapitalAsserts());

		dataanaly.setFixAssetValue(fixAssetValue);
		// 营业收入
		dataanaly.setIncomeTarget(attribute.getOperatingReceipt());
		double incomeValue = OperationModel.netAssetsSore(epinfo.getStage(), 3,
				!epinfo.getIsHeavyIndustry(), attribute.getOperatingReceipt());

		dataanaly.setIncomeValue(incomeValue);
		// 企业税后利润总额
		dataanaly.setProfitTarget(attribute.getTotalCapitalAsserts());
		double profitValue = OperationModel.netAssetsSore(epinfo.getStage(), 4,
				!epinfo.getIsHeavyIndustry(), attribute
						.getTotalCapitalAsserts());
		dataanaly.setProfitValue(profitValue);
		// 固定资产净值
		dataanaly.setNetbalTarget(attribute.getCapitalAssertsNetValue());
		double netbalValue = OperationModel.netAssetsSore(epinfo.getStage(), 5,
				!epinfo.getIsHeavyIndustry(), attribute
						.getCapitalAssertsNetValue());

		dataanaly.setNetbalValue(netbalValue);
		// 企业企业规模总得分总得分
		double scaleMeritTotalScores = netAssetValue + fixAssetValue
				+ incomeValue + profitValue + netbalValue;
		dataanaly.setScaleMeritTotalScores(scaleMeritTotalScores);
		// 偿债能力总得分
		double debtTotalScores = 0;
		// 流动比率
		dataanaly.setLiquidRatioTarget(DebtResemption.getCurrentRatio(attribute
				.getFloatingCapital(), attribute.getCashLiabilities()));
		dataanaly.setLiquidRatioValue(DebtResemption.getCurrentRatioValue(
				epinfo.getStage(), attribute.getFloatingCapital(), attribute
						.getCashLiabilities()));
		debtTotalScores += dataanaly.getLiquidRatioValue();
		// 速动比率
		dataanaly.setQuickRatioTarget(DebtResemption.getquickRatio(attribute
				.getGeneralCash(), attribute.getShortTermBondInvestment(),
				attribute.getAccountReceivable(),
				attribute.getNoteReceivable(), attribute.getCashLiabilities()));
		dataanaly.setQuickRatioValue(DebtResemption.getquickRatioValue(epinfo
				.getStage(), attribute.getGeneralCash(), attribute
				.getShortTermBondInvestment(),
				attribute.getAccountReceivable(),
				attribute.getNoteReceivable(), attribute.getCashLiabilities()));
		debtTotalScores += dataanaly.getQuickRatioValue();
		// 现金比率
		dataanaly.setCashRatioTarget(DebtResemption.getCashRatio(attribute
				.getValueSecurities(), attribute.getGeneralCash(), attribute
				.getCashLiabilities()));
		dataanaly.setCashRatioValue(DebtResemption.getCashRatioValue(epinfo
				.getStage(), attribute.getValueSecurities(), attribute
				.getGeneralCash(), attribute.getCashLiabilities()));
		debtTotalScores += dataanaly.getCashRatioValue();
		// 资产负债率
		dataanaly.setDebtRatioTarget(DebtResemption.getAssetliabilityRatio(
				attribute.getGrossLiabilities(), attribute.getTotalAssets()));
		dataanaly.setDebtRatioValue(DebtResemption.getAssetliabilityRatioValue(
				epinfo.getStage(), attribute.getGrossLiabilities(), attribute
						.getTotalAssets()));
		debtTotalScores += dataanaly.getDebtRatioValue();
		// 产权比率
		dataanaly.setEquityRatioTarget(DebtResemption.getEquityRatio(attribute
				.getGrossLiabilities(), attribute.getTotalAssets()));
		dataanaly.setEquityRatioValue(DebtResemption.getEquityRatioValue(epinfo
				.getStage(), attribute.getGrossLiabilities(), attribute
				.getTotalAssets()));
		debtTotalScores += dataanaly.getEquityRatioValue();
		// 利息保障倍数
		dataanaly.setInterestTimesTarget(DebtResemption.getInterestCover(
				attribute.getEarningsInterestTaxes(), attribute
						.getCapitalCharges()));
		dataanaly.setInterestTimesValue(DebtResemption.getInterestCoverValue(
				epinfo.getStage(), attribute.getEarningsInterestTaxes(),
				attribute.getCapitalCharges()));
		debtTotalScores += dataanaly.getInterestTimesValue();
		// 股东权益比率
		dataanaly.setShareholderRatioTarget(DebtResemption.getEquityratio(
				attribute.getGrossLiabilities(), attribute.getTotalAssets()));
		dataanaly.setShareholderRatioValue(DebtResemption.getEquityratioValue(
				epinfo.getStage(), attribute.getGrossLiabilities(), attribute
						.getTotalAssets()));
		debtTotalScores += dataanaly.getShareholderRatioValue();
		// 担保比率
		dataanaly.setCollateralRatioTarget(DebtResemption.getGuaranteeRatio(
				attribute.getForeignGuaranteeAmount(), attribute
						.getGrossLiabilities(), attribute.getTotalAssets()));
		dataanaly.setCollateralRatioValue(DebtResemption
				.getGuaranteeRatioValue(epinfo.getStage(), attribute
						.getForeignGuaranteeAmount(), attribute
						.getGrossLiabilities(), attribute.getTotalAssets()));
		debtTotalScores += dataanaly.getCollateralRatioValue();
		dataanaly.setDebtTotalScores(debtTotalScores);
		// 营运能力总得分
		double operationTotalScores = 0;

		// 总资产周转率
		dataanaly.setTotalAssetTurnRatioTarget(OperationalCapacity
				.OTotalAssetsTurnoverTarget(attribute.getSalesProceed(),
						attribute.getTotalAssets()));
		dataanaly.setTotalAssetTurnRatioValue(OperationalCapacity
				.OTotalAssetsTurnoverValue(epinfo.getStage(), attribute
						.getSalesProceed(), attribute.getTotalAssets()));
		operationTotalScores += dataanaly.getTotalAssetTurnRatioValue();
		// 流动资产周转率
		dataanaly.setLiquidAssetTurnRatioTarget(OperationalCapacity
				.OCurrentAssetsTurnoverTarget(attribute
						.getMainBusinessNetIncome(), attribute
						.getBeginTotalCurrentAssets(), attribute
						.getEndTotalCurrentAssets()));
		dataanaly.setLiquidAssetTurnRatioValue(OperationalCapacity
				.OCurrentAssetsTurnoverValue(epinfo.getStage(), attribute
						.getMainBusinessNetIncome(), attribute
						.getBeginTotalCurrentAssets(), attribute
						.getEndTotalCurrentAssets()));
		operationTotalScores += dataanaly.getLiquidAssetTurnRatioValue();
		// 固定资产周转率
		dataanaly.setFixAssetTurnRatioTarget(OperationalCapacity
				.OFixedAssetTurnoverTarget(attribute.getSalesProceed(),
						attribute.getFixedAssets()));
		dataanaly.setFixAssetTurnRatioValue(OperationalCapacity
				.OFixedAssetTurnoverValue(epinfo.getStage(), attribute
						.getSalesProceed(), attribute.getFixedAssets()));
		operationTotalScores += dataanaly.getFixAssetTurnRatioValue();
		// 应收帐款周转率
		dataanaly.setReceivableTurnRatioTarget(OperationalCapacity
				.OAccountsReceivableTurnoverRatioTarget(attribute
						.getSalesProceed(), attribute
						.getBeginTotalAccountsReceivable(), attribute
						.getEndTotalAccountsReceivable()));
		dataanaly.setReceivableTurnRatioValue(OperationalCapacity
				.OAccountsReceivableTurnoverRatioValue(epinfo.getStage(),
						attribute.getSalesProceed(), attribute
								.getBeginTotalAccountsReceivable(), attribute
								.getEndTotalAccountsReceivable()));
		operationTotalScores += dataanaly.getReceivableTurnRatioValue();
		// 存货周转率
		dataanaly.setStockTurnRatioTarget(OperationalCapacity
				.OInventoryTurnoverTarget(attribute.getSellingCost(), attribute
						.getBeginningInventory(), attribute.getEndInventory()));
		dataanaly.setStockTurnRatioValue(OperationalCapacity
				.OInventoryTurnoverValue(epinfo.getStage(), attribute
						.getSellingCost(), attribute.getBeginningInventory(),
						attribute.getEndInventory()));
		operationTotalScores += dataanaly.getStockTurnRatioValue();
		// 资产保值、增值率
		dataanaly.setAssetIncrementRatioTarget(OperationalCapacity
				.OIncreasingGrowthRateOfAssetsTarget(attribute
						.getEndOwnerEquity(), attribute.getBeginOwnerEquity()));
		dataanaly.setAssetIncrementRatioValue(OperationalCapacity
				.OIncreasingGrowthRateOfAssetsValue(epinfo.getStage(),
						attribute.getEndOwnerEquity(), attribute
								.getBeginOwnerEquity()));
		operationTotalScores += dataanaly.getAssetIncrementRatioValue();
		// 销售收入增长率
		dataanaly.setSaleGrowRatioTarget(OperationalCapacity
				.OSalesRevenueGrowthTarget(attribute.getEndSalesProceed(),
						attribute.getBeginSalesProceed()));
		dataanaly
				.setSaleGrowRatioValue(OperationalCapacity
						.OSalesRevenueGrowthValue(epinfo.getStage(), attribute
								.getEndSalesProceed(), attribute
								.getBeginSalesProceed()));
		operationTotalScores += dataanaly.getSaleGrowRatioValue();
		dataanaly.setOperationTotalScores(operationTotalScores);
		// 盈利能力总得分
		double earningTotalScores = 0;
		// 总资产回报率
		dataanaly.setTotalAssetReturnRatioTarget(ProfitAbility.getAssetsRate(
				attribute.getBeginTotalAssets(), attribute.getEndTotalAssets(),
				attribute.getGrossInterest(), attribute.getInterestExpense()));
		dataanaly.setTotalAssetReturnRatioValue(ProfitAbility
				.getAssetsRateScore(epinfo.getStage(), attribute
						.getBeginTotalAssets(), attribute.getEndTotalAssets(),
						attribute.getGrossInterest(), attribute
								.getInterestExpense()));
		earningTotalScores += dataanaly.getTotalAssetReturnRatioValue();
		// 净资产回报率
		dataanaly.setNetAssetReturnRatioTarget(ProfitAbility.getRona(attribute
				.getNetIncomeRetainedAfterTax(), attribute.getNetAssets()));
		dataanaly.setNetAssetReturnRatioValue(ProfitAbility.getRonaScore(epinfo
				.getStage(), attribute.getNetIncomeRetainedAfterTax(),
				attribute.getNetAssets()));
		earningTotalScores += dataanaly.getNetAssetReturnRatioValue();
		// 成本费用利润率
		dataanaly.setPerfitCostRatioTarget(ProfitAbility.getCostEfficiency(
				attribute.getTotalProfit(), attribute.getTotalCost()));
		dataanaly.setPerfitCostRatioValue(ProfitAbility.getCostEfficiencyScore(
				epinfo.getStage(), attribute.getTotalProfit(), attribute
						.getTotalCost()));
		earningTotalScores += dataanaly.getPerfitCostRatioValue();
		// 主营业务税后利润率
		dataanaly.setAfterTaxProfitTarget(ProfitAbility.getMainProfitRate(
				attribute.getMainOperationIncome(), attribute.getCostOfSales(),
				attribute.getSalesTax()));
		dataanaly.setAfterTaxProfitValue(ProfitAbility.getMainProfitRateScore(
				epinfo.getStage(), attribute.getMainOperationIncome(),
				attribute.getCostOfSales(), attribute.getSalesTax()));
		earningTotalScores += dataanaly.getAfterTaxProfitValue();
		// 销售利润率
		dataanaly.setSaleProfitTarget(ProfitAbility.getNetProfitRatio(attribute
				.getTotalProfit(), attribute.getOperatingReceipt()));
		dataanaly.setSaleProfitValue(ProfitAbility.getNetProfitRatioScore(
				epinfo.getStage(), attribute.getTotalProfit(), attribute
						.getOperatingReceipt()));
		earningTotalScores += dataanaly.getSaleProfitValue();
		dataanaly.setEarningTotalScores(earningTotalScores);

		double growthScores = 0;

		// 总资产增长率
		dataanaly.setTotalAssetGrowRatioTarget(GrowthIndexValue
				.getTotalAssetGrowRatioTarget(attribute.getEndTotalAssets(),
						attribute.getBeginTotalAssets()));

		dataanaly.setTotalAssetGrowRatioValue(GrowthIndexValue
				.getTotalAssetGrowRatioValue(epinfo.getStage(), attribute
						.getEndTotalAssets(), attribute.getBeginTotalAssets()));

		growthScores += dataanaly.getTotalAssetGrowRatioValue();
		// 净资产增长率
		dataanaly.setNetAssetGrowRatioTarget(GrowthIndexValue
				.getNetAssetGrowRatioTarget(attribute.getBeginNetAssets(),
						attribute.getEndNetAssets()));

		dataanaly.setNetAssetGrowRatioValue(GrowthIndexValue
				.getNetAssetGrowRatioValue(epinfo.getStage(), attribute
						.getBeginNetAssets(), attribute.getEndNetAssets()));
		growthScores += dataanaly.getNetAssetGrowRatioValue();
		// 总收益增长率
		dataanaly.setTotalIncomeGrowRatioTarget(GrowthIndexValue
				.getTotalIncomeGrowRatioTarget(attribute
						.getBeginBusinessReceipt(), attribute
						.getEndBusinessReceipt(), attribute
						.getBeginNonrevenueReceipt(), attribute
						.getEndNonrevenueReceipt()));

		dataanaly.setTotalIncomeGrowRatioValue(GrowthIndexValue
				.getTotalIncomeGrowRatioValue(epinfo.getStage(), attribute
						.getBeginBusinessReceipt(), attribute
						.getEndBusinessReceipt(), attribute
						.getBeginNonrevenueReceipt(), attribute
						.getEndNonrevenueReceipt()));
		growthScores += dataanaly.getTotalIncomeGrowRatioValue();
		// 净利润增长率
		dataanaly.setNetIncomeGrowRatioTarget(GrowthIndexValue
				.getNetIncomeGrowRatioTarget(attribute.getLastTotalProfit(),
						attribute.getLastIncomeTax(), attribute
								.getTotalProfit(), attribute.getIncomeTax()));

		dataanaly.setNetIncomeGrowRatioValue(GrowthIndexValue
				.getNetIncomeGrowRatioValue(epinfo.getStage(), attribute
						.getLastTotalProfit(), attribute.getLastIncomeTax(),
						attribute.getTotalProfit(), attribute.getIncomeTax()));
		growthScores += dataanaly.getNetIncomeGrowRatioValue();
		// 主营业务利润率增长
		dataanaly.setMainBusProfitGrowTarget(GrowthIndexValue
				.getMainBusProfitGrowTarget(attribute
						.getBeginMainOperationIncome(), attribute
						.getEndMainOperationIncome(), attribute
						.getBeginCostOfSales(), attribute.getEndCostOfSales(),
						attribute.getBeginSalesTax(), attribute
								.getEndSalesTax()));

		dataanaly.setMainBusProfitGrowValue(GrowthIndexValue
				.getMainBusProfitGrowValue(epinfo.getStage(), attribute
						.getBeginMainOperationIncome(), attribute
						.getEndMainOperationIncome(), attribute
						.getBeginCostOfSales(), attribute.getEndCostOfSales(),
						attribute.getBeginSalesTax(), attribute
								.getEndSalesTax()));
		growthScores += dataanaly.getMainBusProfitGrowValue();
		// 员工数量增长率
		dataanaly.setEmployeeGrowRatioTarget(GrowthIndexValue
				.getEmployeeGrowRatioTarget(attribute.getEmployeNumLastYear(),
						attribute.getEmployeNumCurrentYear()));

		dataanaly.setEmployeeGrowRatioValue(GrowthIndexValue
				.getEmployeeGrowRatioValue(epinfo.getStage(), attribute
						.getEmployeNumLastYear(), attribute
						.getEmployeNumCurrentYear()));
		growthScores += dataanaly.getEmployeeGrowRatioValue();
		// 企业家年龄
		dataanaly.setEuntreponierAgeTarget(attribute.getAgeGroup());

		dataanaly.setEuntreponierAgeValue(GrowthIndexValue
				.getEuntreponierAgeValue(epinfo.getStage(), attribute
						.getAgeGroup()));
		growthScores += dataanaly.getEuntreponierAgeValue();
		// 企业家学历/学位/职称
		dataanaly.setEuntreponierDegreeTarget(attribute.getDegreeTitles());

		dataanaly.setEuntreponierDegreeValue(GrowthIndexValue
				.getEuntreponierDegreeValue(epinfo.getStage(), attribute
						.getDegreeTitles()));
		growthScores += dataanaly.getEuntreponierDegreeValue();

		// 企业家岗位工作时间
		dataanaly.setEuntreponierWorkTimeTarget(attribute.getWorkingTime());

		dataanaly.setEuntreponierWorkTimeValue(GrowthIndexValue
				.getEuntreponierWorkTimeValue(epinfo.getStage(), attribute
						.getWorkingTime()));
		growthScores += dataanaly.getEuntreponierWorkTimeValue();
		// 企业家业内知名度\社会关系
		dataanaly.setEuntreponierPopularyTarget(attribute.getReputations());

		dataanaly.setEuntreponierPopularyValue(GrowthIndexValue
				.getEuntreponierPopularyValue(epinfo.getStage(), attribute
						.getReputations()));
		growthScores += dataanaly.getEuntreponierPopularyValue();
		// 企业发展规划
		if (attribute.getEnterpriseExpansionProjects()) {
			dataanaly.setDevelopPlanTarget(1);

			dataanaly.setDevelopPlanValue(GrowthIndexValue
					.getEnterpriseExpansionProjectsValue(epinfo.getStage(),
							true));
		} else {
			dataanaly.setDevelopPlanTarget(0);

			dataanaly.setDevelopPlanValue(GrowthIndexValue
					.getEnterpriseExpansionProjectsValue(epinfo.getStage(),
							false));
		}
		growthScores += dataanaly.getDevelopPlanValue();
		// 产品长期发展战略
		if (attribute.getProducLongTermDevelopment()) {
			dataanaly.setDevelopStrategyTarget(1);

			dataanaly
					.setDevelopStrategyValue(GrowthIndexValue
							.getProducLongTermDevelopmentValue(epinfo
									.getStage(), true));
		} else {
			dataanaly.setDevelopStrategyTarget(0);

			dataanaly
					.setDevelopStrategyValue(GrowthIndexValue
							.getProducLongTermDevelopmentValue(epinfo
									.getStage(), false));
		}
		growthScores += dataanaly.getDevelopStrategyValue();

		if (attribute.getProductQualityCertification()) {
			dataanaly.setQualityCertificateTarget(1);

			dataanaly.setQualityCertificateValue(GrowthIndexValue
					.getProductQualityCertificationValue(epinfo.getStage(),
							true));
		} else {
			dataanaly.setQualityCertificateTarget(0);

			dataanaly.setQualityCertificateValue(GrowthIndexValue
					.getProductQualityCertificationValue(epinfo.getStage(),
							false));
		}
		growthScores += dataanaly.getQualityCertificateValue();

		dataanaly.setIndustryNatureTarget(attribute.getLndustryProperties());

		dataanaly.setIndustryNatureValue(GrowthIndexValue
				.getLndustryPropertiesValue(epinfo.getStage(), attribute
						.getLndustryProperties()));
		growthScores += dataanaly.getIndustryNatureValue();

		dataanaly.setGrowthTotalScores(growthScores);

		double creativeTotalScores = 0;
		/** 6.1.1高新技术产品（服务）销售收入（指标） */
		dataanaly.setHighTechIncomeRatioTarget(CreativeKPI
				.getAllYHighIncomeRatio(attribute.getYearNewSalesIncome(),
						attribute.getYearGrossSales()));
		/** 6.1.2高新技术产品（服务）销售收入（分值） */
		dataanaly
				.setHighTechIncomeRatioValue(CreativeKPI
						.getAllYHighIncomeRatioValue(epinfo.getStage(),
								attribute.getYearNewSalesIncome(), attribute
										.getYearGrossSales()));
		creativeTotalScores += dataanaly.getHighTechIncomeRatioValue();

		/** 6.2.1R&D投入占比（指标） */
		dataanaly.setRdinputRatioTarget(CreativeKPI.getRDInputRatio(attribute
				.getAppropriationExpenditure(), attribute.getYearGrossSales()));
		/** 6.2.2R&D投入占比（分值） */
		dataanaly.setRdinputRatioValue(CreativeKPI.getRDInputRatioValue(epinfo
				.getStage(), attribute.getAppropriationExpenditure(), attribute
				.getYearGrossSales()));
		creativeTotalScores += dataanaly.getRdinputRatioValue();

		/** 6.3.1R&D经费增长率（指标） */
		dataanaly.setRdmoneyGrowRatioTarget(CreativeKPI.getRDIncreRatio(
				attribute.getBeginFundingAmount(), attribute
						.getEndFundingAmount()));
		/** 6.3.2R&D经费增长率（分值） */
		dataanaly.setRdmoneyGrowRatioValue(CreativeKPI.getRDIncreRatioValue(
				epinfo.getStage(), attribute.getBeginFundingAmount(), attribute
						.getEndFundingAmount()));
		creativeTotalScores += dataanaly.getRdmoneyGrowRatioValue();

		/** 6.4.1大专以上人数占比（指标） */
		dataanaly.setCollageRatioTarget(CreativeKPI.collageRatioTarget(
				attribute.getAboveCollegeEmployeeNum(), attribute
						.getEmployeNumCurrentYear()));
		/** 6.4.2大专以上人数占比（分值） */
		dataanaly.setCollageRatioValue(CreativeKPI.collageRatioValue(epinfo
				.getStage(), attribute.getAboveCollegeEmployeeNum(), attribute
				.getEmployeNumCurrentYear()));
		creativeTotalScores += dataanaly.getCollageRatioValue();

		/** 6.5.1科技成果奖励数（指标） */
		dataanaly.setTechnicalPayoffNumTarget(attribute
				.getScientificRewardsNum());
		/** 6.5.2科技成果奖励数（分值） */
		dataanaly.setTechnicalPayoffNumValue(CreativeKPI.rewardValue(epinfo
				.getStage(), attribute.getScientificRewardsNum()));
		creativeTotalScores += dataanaly.getTechnicalPayoffNumValue();

		/** 6.6.1知识产权总数（指标） */
		dataanaly.setIprnumTarget(attribute.getIntellectualPropertyRightNum());
		/** 6.6.2知识产权总数（分值） */
		dataanaly.setIprnumValue(CreativeKPI.rewardValue(epinfo.getStage(),
				attribute.getIntellectualPropertyRightNum()));
		creativeTotalScores += dataanaly.getIprnumValue();

		/** 6.7.1专利总数（指标） */
		dataanaly.setPatentNumTarget(attribute.getPatentNum());
		/** 6.7.2专利总数（分值） */
		dataanaly.setPatentNumValue(CreativeKPI.rewardValue(epinfo.getStage(),
				attribute.getPatentNum()));
		creativeTotalScores += dataanaly.getPatentNumValue();

		/** 6.8.1近三年获政府立项数量(国家级)（指标） */
		dataanaly.setGovprojectNumLandTarget(attribute
				.getCouontryGovernmentProjectNum());
		/** 6.8.2近三年获政府立项数量(国家级)（分值） */
		dataanaly.setGovprojectNumLandValue(CreativeKPI.projectValue(epinfo
				.getStage(), attribute.getCouontryGovernmentProjectNum()));
		creativeTotalScores += dataanaly.getGovprojectNumLandValue();

		/** 6.9.1近三年获政府立项数量(省级)（指标） */
		dataanaly.setGovprojectNumProTarget(attribute
				.getProvinceGovernmentprojectNum());
		/** 6.9.2近三年获政府立项数量(省级)（分值） */
		dataanaly.setGovprojectNumProValue(CreativeKPI.projectValue(epinfo
				.getStage(), attribute.getProvinceGovernmentprojectNum()));
		creativeTotalScores += dataanaly.getGovprojectNumProValue();

		/** 6.10.1近三年获政府立项数量(市级)（指标） */
		dataanaly.setGovprojectNumCityTarget(attribute
				.getCityGovernmentprojectNum());
		/** 6.10.2近三年获政府立项数量(市级)（分值） */
		dataanaly.setGovprojectNumCityValue(CreativeKPI.projectValue(epinfo
				.getStage(), attribute.getCityGovernmentprojectNum()));
		creativeTotalScores += dataanaly.getGovprojectNumCityValue();

		/** 6.11.1有无创新人员激励制度（指标）。0：无，1：有 */
		dataanaly.setIncentiveTarget(CreativeKPI.toInteger(attribute
				.getIncentiveSystemOfInnovation()));
		/** 6.11.2创新人员激励制度（分值） */
		dataanaly.setIncentiveValue(CreativeKPI.incentiveValue(epinfo
				.getStage(), attribute.getIncentiveSystemOfInnovation()));
		creativeTotalScores += dataanaly.getIncentiveValue();

		/** 6.12.1专门的研发机构（指标）。0：无，1：有 */
		dataanaly.setRdorganizationTarget(CreativeKPI.toInteger(attribute
				.getResearchinstitute()));
		/** 6.12.2专门的研发机构（分值） */
		dataanaly.setRdorganizationValue(CreativeKPI
				.internationalOrgnizationValue(epinfo.getStage(), attribute
						.getResearchinstitute()));
		creativeTotalScores += dataanaly.getRdorganizationValue();

		/** 6.13.1有无投资机构（指标）。0：无，1：有 */
		dataanaly.setInvestmentOrganizationTarget(CreativeKPI
				.toInteger(attribute.getVentureCapitalInstitutions()));
		/** 6.13.2有无投资机构（分值） */
		dataanaly.setInvestmentOrganizationValue(CreativeKPI
				.internationalOrgnizationValue(epinfo.getStage(), attribute
						.getVentureCapitalInstitutions()));
		creativeTotalScores += dataanaly.getInvestmentOrganizationValue();

		/** 6.14.1有无国际化合作（指标）。0：无，1：有 */
		dataanaly.setInternateCooTarget(CreativeKPI.toInteger(attribute
				.getInternationallyCooperative()));
		/** 6.14.2有无国际化合作（分值） */
		dataanaly.setInternateCooValue(CreativeKPI
				.internationalOrgnizationValue(epinfo.getStage(), attribute
						.getInternationallyCooperative()));
		creativeTotalScores += dataanaly.getInternateCooValue();

		/** 6.15.1有无国家重点实验室（指标）。0：无，1：有 */
		dataanaly.setLhdtarget(CreativeKPI.toInteger(attribute
				.getStateKeyLaboratory()));
		/** 6.15.2有无国家重点实验室（分值） */
		dataanaly.setLhdvalue(CreativeKPI.labouratoryValue(epinfo.getStage(),
				attribute.getStateKeyLaboratory()));
		creativeTotalScores += dataanaly.getLhdvalue();

		/** 创新性指标总得分 */
		dataanaly.setCreativeTotalScores(creativeTotalScores);

		/** 信用履约能力指标 WCW */
		/** 7.1.1 利息偿付率 WCW */
		dataanaly.setInterestCoverageRatioTarget(
		/** 计算利息偿付率 */
		CreditPerformancePowerUtil.getInterestCoverageRate(
		/** 函数赋值：用atrribute的get方法获得: 企业税后利润总额 */
		attribute.getTotalTaxProfit(),
		/** 所得税 */
		attribute.getIncomeTax(),
		/** 利息费用 */
		attribute.getCapitalCharges()));
		/** 7.1 .2 利息偿付率得分值 interestCoverageRatioValue */
		/** 计算利息偿付率 */
		double interestCoverageRatioValue = CreditPerformancePowerUtil
				.getInterestCoverageRateScores(
				/** 函数赋值：用atrribute的get方法获得 */
				epinfo.getStage(), CreditPerformancePowerUtil
						.getInterestCoverageRate(
						/** 函数赋值：用atrribute的get方法获得: 企业税后利润总额 */
						attribute.getTotalTaxProfit(),
						/** 所得税 */
						attribute.getIncomeTax(),
						/** 利息费用 */
						attribute.getCapitalCharges()));
		dataanaly.setInterestCoverageRatioValue(interestCoverageRatioValue);
		/** 7.2.1 贷款逾期率 */
		dataanaly.setLoanOutdateRatioTarget(
		/** 计算贷款逾期率 */
		CreditPerformancePowerUtil.getOverdueLoansRate(
		/** 函数赋值：用atrribute的get方法获得 */
		attribute.getOverdueLoans(), attribute.getLoanCeiling()));

		/** 7.2.2 贷款逾期率得分值 */
		double loanOutdateRatioValue = CreditPerformancePowerUtil
				.getOverdueLoansRateScores(epinfo.getStage(),
						CreditPerformancePowerUtil
								.getOverdueLoansRate(
								/** 函数赋值：用atrribute的get方法获得 */
								attribute.getOverdueLoans(), attribute
										.getLoanCeiling()));
		dataanaly.setLoanOutdateRatioValue(loanOutdateRatioValue);
		/** 7.3.1 应付账款清付率（指标） */
		dataanaly.setPayMoneyRatioTarget(CreditPerformancePowerUtil
				.getShouldPaidCreditRate(attribute.getAlreadyPaidCredit(),
						attribute.getShouldPaidCredit()));
		/** 7.3.2 应付账款清付率（分值） */
		double payMoneyRatioValue = CreditPerformancePowerUtil
				.getShouldPaidCreditRateScores(epinfo.getStage(),
						CreditPerformancePowerUtil.getShouldPaidCreditRate(
								attribute.getAlreadyPaidCredit(), attribute
										.getShouldPaidCredit()));
		dataanaly.setPayMoneyRatioValue(payMoneyRatioValue);
		/** 7.4.1 经营决策者个人信誉 */
		dataanaly.setPersonalCreditTarget(attribute.getPersonalReputation());
		double personalCreditValue = CreditPerformancePowerUtil
				.getPersonalReputationScores(epinfo.getStage(), attribute
						.getPersonalReputation());
		/** 7.4.2 经营决策者个人信誉 （分值） */
		dataanaly.setPersonalCreditValue(personalCreditValue);
		/** 信用履约能力总得分 */
		dataanaly.setCreditExerciseTotalScores(interestCoverageRatioValue
				+ loanOutdateRatioValue + payMoneyRatioValue
				+ personalCreditValue);

		/** 管理水平指标 WCW */
		/** 8.1.1 经营管理水平（指标）。1：优秀，3：良好，2：一般，4：差 */
		dataanaly.setManageLevelTarget(attribute.getOperationControl());
		/** 8.1.2 经营管理水平（分值） */
		double manageLevelValue = ManagementLevel.ToOperationControl(epinfo
				.getStage(), attribute.getOperationControl());
		dataanaly.setManageLevelValue(manageLevelValue);
		/** 8.2.1股东背景（指标）。0:中央级企业、上市公司，1：地市级以上（含）政府控投企业，2：民营企业及其他 */
		dataanaly.setShareholderBackgroundTarget(attribute
				.getShareholdersBackground());
		/** 8.2.2 股东背景（分值） */
		double shareholderBackgroundValue = ManagementLevel
				.ToShareholdersBackground(epinfo.getStage(), attribute
						.getShareholdersBackground());
		dataanaly.setShareholderBackgroundValue(shareholderBackgroundValue);
		/** 8.3.1管理者任职年份（指标） */
		dataanaly.setManagerWorkTimeTarget(attribute.getTakeOfficeYear()
				.toString());
		/** 8.3.2管理者任职年份（分值） */
		double managerWorkTimeValue = ManagementLevel.ToTakeOfficeYear(epinfo
				.getStage(), attribute.getTakeOfficeYear());
		dataanaly.setManagerWorkTimeValue(managerWorkTimeValue);
		/** 8.4.1董事会规模（指标）。0：按规定设置，1：未按规定设置 */
		dataanaly.setBoardSizeTarget(attribute.getBoardOfDirectors());
		/** 8.4.2董事会规模（分值） */
		double BoardSizeValue = 0;
		if (attribute.getBoardOfDirectors() == 1) {
			BoardSizeValue = ManagementLevel.ToBoardDCEO(epinfo.getStage(),
					false);
		} else {
			BoardSizeValue = ManagementLevel.ToBoardDCEO(epinfo.getStage(),
					true);
		}
		dataanaly.setBoardSizeValue(BoardSizeValue);
		/** 8.5.1董事长与CEO两职设置状况（指标）。0：按规定设置，1：未按规定设置 */
		dataanaly.setChairCeotarget(attribute.getCeosetupStatus());
		/** 8.5.2董事长与CEO两职设置状况（分值） */
		double chairCeovalue = 0;
		if (attribute.getCeosetupStatus() == 1) {
			chairCeovalue = ManagementLevel.ToBoardDCEO(epinfo.getStage(),
					false);
		} else {
			chairCeovalue = ManagementLevel
					.ToBoardDCEO(epinfo.getStage(), true);
		}

		dataanaly.setChairCeovalue(chairCeovalue);
		/** 8.6.1管理者审计意见（指标） */
		dataanaly.setAuditOpinionTarget(attribute.getAuditOpinion());
		/** 8.6.2管理者审计意见（分值） */
		double auditOpinionValue = ManagementLevel.ToAuditOpinion(epinfo
				.getStage(), attribute.getAuditOpinion());
		dataanaly.setAuditOpinionValue(auditOpinionValue);
		/** 8.7.1管理者违规行为（指标）。0：无，1：有 */
		dataanaly.setIllegalBehaviorTarget(attribute.getIrregularities());
		/** 8.7.2管理者违规行为（分值） */
		double illegalBehaviorValue = 0;
		if (attribute.getIrregularities() == 0) {
			illegalBehaviorValue = ManagementLevel.ToIrregularities(epinfo
					.getStage(), false);
		} else {
			illegalBehaviorValue = ManagementLevel.ToIrregularities(epinfo
					.getStage(), true);
		}

		dataanaly.setIllegalBehaviorValue(illegalBehaviorValue);
		/** 8.8.1管理者年龄（指标）。0：<35，1：35~50，2：>50 */
		dataanaly.setManagerAgeTarget(attribute.getAgeGroup());
		/** 8.8.2管理者年龄（分值） */
		double managerAgeValue = ManagementLevel.ToAgeGroup(epinfo.getStage(),
				attribute.getAgeGroup());
		dataanaly.setManagerAgeValue(managerAgeValue);
		/** 8.9.1管理者教育背景（指标）。0：特殊知名人物，1：博士/高级，2：硕士/副高，3：本科/中级 ,4：专科/初级 */
		// dataanaly.setManagerEdubackgroundTarget(attribute.getDegreeTitles());
		dataanaly.setManagerEdubackgroundTarget(attribute.getEduBackground());
		/** 8.9.2管理者教育背景（分值） */
		// double managerEdubackgroundValue = ManagementLevel.ToDegreeTitles(
		// epinfo.getStage(), attribute.getDegreeTitles());
		double managerEdubackgroundValue = ManagementLevel.ToDegreeTitles(
				epinfo.getStage(), attribute.getEduBackground());
		dataanaly.setManagerEdubackgroundValue(managerEdubackgroundValue);
		/** 8.10.1管理者职称（指标）。0：无，1：初，2：中，3：副高，4：高 */
		dataanaly.setManagerTitalTarget(attribute.getAcademicTitle());
		/** 8.10.2管理者职称（分值） */
		double managerTitalValue = ManagementLevel.ToAcademicTitle(epinfo
				.getStage(), attribute.getAcademicTitle());
		dataanaly.setManagerTitalValue(managerTitalValue);

		/** 管理水平总得分 */
		dataanaly.setManagerLevelTotalScores(manageLevelValue
				+ shareholderBackgroundValue + managerWorkTimeValue
				+ BoardSizeValue + chairCeovalue + auditOpinionValue
				+ illegalBehaviorValue + managerAgeValue
				+ managerEdubackgroundValue + managerTitalValue);
		/** 9.1.1国家产业政策（指标）。0：鼓励发展，1：一般态度，2：限制发展，3：要求淘汰 */
		dataanaly.setIndustryPolicyTarget(attribute
				.getStateIndustrialPolicies());

		/** 9.1.2国家产业政策（分值） */
		double industryPolicyValue = MarketCompetition
				.getStateIndustrialPolicies(epinfo.getStage(), attribute
						.getStateIndustrialPolicies());
		dataanaly.setIndustryPolicyValue(industryPolicyValue);

		/** 9.2.1行业地位（指标）。0：产品市场占有率高，议价能力强，1：议价能力一般，2：议价能力差 */
		dataanaly.setIndustryPositionTarget(attribute.getIndustryPosition());
		/** 9.2.2行业地位（分值） */
		double industryPositionValue = MarketCompetition.getIndustryPosition(
				epinfo.getStage(), attribute.getIndustryPosition());
		dataanaly.setIndustryPositionValue(industryPositionValue);
		/** 9.3.1主导产业个数（指标）。1:1~3个，3:3~4个，5:4个以上 */
		dataanaly.setLeaderIndustryNumTarget(attribute.getLeadingIndustry());
		/** 9.3.2主导产业个数（分值） */
		double leadingIndustry = MarketCompetition.getLeadingIndustry(epinfo
				.getStage(), attribute.getLeadingIndustry());
		dataanaly.setLeaderIndustryNumValue(leadingIndustry);
		/** 9.4.1产品竞争力（指标）。0：好，1：中，2：差 */
		dataanaly.setCompetitivePowerTarget(attribute
				.getProductCompetitiveness());
		/** 9.4.2产品竞争力（分值） */
		double productCompetitiveness = MarketCompetition
				.getProductCompetitiveness(epinfo.getStage(), attribute
						.getProductCompetitiveness());
		dataanaly.setCompetitivePowerValue(productCompetitiveness);
		/** 9.4.2市场竞争力总得分 */
		dataanaly.setMarketCompeteTotalScores(industryPolicyValue
				+ industryPositionValue + leadingIndustry
				+ productCompetitiveness);
		double allTotalScores = dataanaly.getScaleMeritTotalScores()
				+ dataanaly.getDebtTotalScores()
				+ dataanaly.getOperationTotalScores()
				+ dataanaly.getEarningTotalScores()
				+ dataanaly.getGrowthTotalScores()
				+ dataanaly.getCreativeTotalScores()
				+ dataanaly.getCreditExerciseTotalScores()
				+ dataanaly.getManagerLevelTotalScores()
				+ dataanaly.getMarketCompeteTotalScores();
		dataanaly.setAllTotalScores(allTotalScores);
		ratingResults.setCompanyId(epId);
		ratingResults.setTotal(allTotalScores);
		ratingResults.setCreateTime(new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date()));
		ratingResults.setLifecycle(epinfo.getStage() + "");
		CreditRating creditRating = attributeDao
				.findCreditRating(allTotalScores);
		ratingResults.setCreditId(creditRating.getCreditId());
		ratingResults.setOrgNo(epinfo.getOrgNo());
		ratingResults.setRating(creditRating.getCreditSymbol());
		dataanaly.setcreateTime(new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date()));
		analyDAO.saveDataanaly(dataanaly);//保存数据分析
		// 企业规模
		String scaleMerit = null;

		if (epinfo.getStage() == 1) {
			if (dataanaly.getScaleMeritTotalScores() > 0
					&& dataanaly.getScaleMeritTotalScores() < 1.1) {
				scaleMerit = "该企业规模不足，实力弱。企业净资产低于业内水平且营业收入低，"
						+ "导致税后利润低，从而影响企业发展速度；也可能存在固定资产折旧严重的状况。";
			} else if (dataanaly.getScaleMeritTotalScores() >= 1.1
					&& dataanaly.getScaleMeritTotalScores() < 2.2) {
				scaleMerit = "该企业规模处于行业中游水平。企业净资产符合业内平均水平，营业收入属平均水平，因此，税后利润尚可。固定资产存在一定程度折旧状况。";
			} else {
				scaleMerit = "该企业规模很大，实力非常雄厚。企业营业收入高，净资产高于业内平均值。主营业务突出，具有良好竞争力，税后利润相当可观，固定资产折旧较少。";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getScaleMeritTotalScores() > 0
					&& dataanaly.getScaleMeritTotalScores() < 3.1) {
				scaleMerit = "该企业规模不足，实力弱。企业净资产低于业内水平且营业收入低，导致税后利润低，从而影响企业发展速度；也可能存在固定资产折旧严重的状况。";
			} else if (dataanaly.getScaleMeritTotalScores() >= 3.1
					&& dataanaly.getScaleMeritTotalScores() < 6.2) {
				scaleMerit = "该企业规模处于行业中游水平。企业净资产符合业内平均水平，营业收入属平均水平，因此，税后利润尚可。固定资产存在一定程度折旧状况。";
			} else {
				scaleMerit = "该企业规模很大，实力非常雄厚。企业营业收入高，净资产高于业内平均值。主营业务突出，具有良好竞争力，税后利润相当可观，固定资产折旧较少。";
			}
		} else {
			if (dataanaly.getScaleMeritTotalScores() > 0
					&& dataanaly.getScaleMeritTotalScores() < 2.8) {
				scaleMerit = "该企业规模不足，实力弱。企业净资产低于业内水平且营业收入低，导致税后利润低，从而影响企业发展速度；也可能存在固定资产折旧严重的状况。";
			} else if (dataanaly.getScaleMeritTotalScores() >= 2.8
					&& dataanaly.getScaleMeritTotalScores() < 5.6) {
				scaleMerit = "该企业规模处于行业中游水平。企业净资产符合业内平均水平，营业收入属平均水平，因此，税后利润尚可。固定资产存在一定程度折旧状况。";
			} else {
				scaleMerit = "该企业规模很大，实力非常雄厚。企业营业收入高，净资产高于业内平均值。主营业务突出，具有良好竞争力，税后利润相当可观，固定资产折旧较少。";
			}
		}
		ratingResults.setScale(scaleMerit);
		ratingResultsh.setScale(scaleMerit);                                                     
		// 偿债能力
		String debt;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getDebtTotalScores() > 0
					&& dataanaly.getDebtTotalScores() < 3.1) {
				debt = "偿债能力很小，企业风险大。";
			} else if (dataanaly.getDebtTotalScores() >= 3.1
					&& dataanaly.getDebtTotalScores() < 6.2) {
				debt = "企业偿债能力一般，风险较高。";
			} else {
				debt = "偿债能力很强，企业风险较小。";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getDebtTotalScores() > 0
					&& dataanaly.getDebtTotalScores() < 3.1) {
				debt = "偿债能力很小，企业风险大。";
			} else if (dataanaly.getDebtTotalScores() >= 3.1
					&& dataanaly.getDebtTotalScores() < 6.2) {
				debt = "企业偿债能力一般，风险较高。";
			} else {
				debt = "偿债能力很强，企业风险较小。";
			}
		} else {
			if (dataanaly.getDebtTotalScores() > 0
					&& dataanaly.getDebtTotalScores() < 2.8) {
				debt = "偿债能力很小，企业风险大。";
			} else if (dataanaly.getDebtTotalScores() >= 2.8
					&& dataanaly.getDebtTotalScores() < 5.6) {
				debt = "企业偿债能力一般，风险较高。";
			} else {
				debt = "偿债能力很强，企业风险较小。";
			}
		}
		ratingResults.setPayPower(debt);
		ratingResultsh.setPayPower(debt);
		// 营运能力
		String operation;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getOperationTotalScores() > 0
					&& dataanaly.getOperationTotalScores() < 3.1) {
				operation = "企业资本保持不变，销售收入增长缓慢。同时该企业还存在以下一个以上的问题：资产周转速度过慢，营运存在可能问题;催收账款效率太低，影响资金正常周转；库存积压；销售能力差，营运效率不佳；";
			} else if (dataanaly.getOperationTotalScores() >= 3.1
					&& dataanaly.getOperationTotalScores() < 6.2) {
				operation = "企业维持在一定经营水平，资本实现缓慢增值， 销售收入实现一定的增长。资产周转速度尚可， 营运状况一般; 企业信用政策略松，资金利用率基本正常; 存货周转效率一般，存在一定呆滞，目标市场规划不够。";
			} else {
				operation = "企业有经济效益，资本在原有基础上实现了增值，销售收入增长快速。同时还具备以下一个以上的特点：资产周转速度快，企业资产利用效率高；催收账款速度快，资产流动性强，对应收账款管理较为理性；企业销售能力强，产品销路好，市场定位明确，为企业带来较大利润； ";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getOperationTotalScores() > 0
					&& dataanaly.getOperationTotalScores() < 3.1) {
				operation = "企业资本保持不变，销售收入增长缓慢。同时该企业还存在以下一个以上的问题：资产周转速度过慢，营运存在可能问题；催收账款效率太低，影响资金正常周转；库存积压；销售能力差，营运效率不佳；";
			} else if (dataanaly.getOperationTotalScores() >= 3.1
					&& dataanaly.getOperationTotalScores() < 6.2) {
				operation = "企业维持在一定经营水平，资本实现缓慢增值， 销售收入实现一定的增长。资产周转速度尚可， 营运状况一般; 企业信用政策略松，资金利用率基本正常; 存货周转效率一般，存在一定呆滞，目标市场规划不够。";
			} else {
				operation = "企业有经济效益，资本在原有基础上实现了增值，销售收入增长快速。同时还具备以下一个以上的特点：资产周转速度快，企业资产利用效率高；催收账款速度快，资产流动性强，对应收账款管理较为理性；企业销售能力强，产品销路好，市场定位明确，为企业带来较大利润；";
			}
		} else {
			if (dataanaly.getOperationTotalScores() > 0
					&& dataanaly.getOperationTotalScores() < 2.8) {
				operation = "企业资本保持不变，销售收入增长缓慢。同时该企业还存在以下一个以上的问题：资产周转速度过慢，营运存在可能问题；催收账款效率太低，影响资金正常周转；库存积压；销售能力差，营运效率不佳； ";
			} else if (dataanaly.getOperationTotalScores() >= 2.8
					&& dataanaly.getOperationTotalScores() < 5.6) {
				operation = "企业维持在一定经营水平，资本实现缓慢增值， 销售收入实现一定的增长。资产周转速度尚可， 营运状况一般; 企业信用政策略松，资金利用率基本正常; 存货周转效率一般，存在一定呆滞，目标市场规划不够。";
			} else {
				operation = "企业有经济效益，资本在原有基础上实现了增值，销售收入增长快速。同时还具备以下一个以上的特点：资产周转速度快，企业资产利用效率高；催收账款速度快，资产流动性强，对应收账款管理较为理性；企业销售能力强，产品销路好，市场定位明确，为企业带来较大利润； ";
			}
		}
		ratingResults.setRun(operation);
		ratingResultsh.setRun(operation);
		// 盈利能力
		String earn;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getEarningTotalScores() > 0
					&& dataanaly.getEarningTotalScores() < 1.1) {
				earn = "企业经营水平低，需调整经营方针。同时，该企业还存在的问题有：投资者投资报酬不足，成本费用利润率低，企业应加强成本控制；营业、销售利润率偏低，期间费用过高，持续经营较吃力。";
			} else if (dataanaly.getEarningTotalScores() >= 1.1
					&& dataanaly.getEarningTotalScores() < 2.2) {
				earn = "企业业绩良好，资产利用效率尚佳；投资者收益一般，成本费用利润率一般；营业、销售利润率属正常水平，保证其持续经营。";
			} else {
				earn = "企业获利能力强，投资者收益高，成本费用利润率高，取得收益的代价小，营业、销售利润率属较好水平，说明企业在降低期间费用和增加其他收益方面做了较大工作。";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getEarningTotalScores() > 0
					&& dataanaly.getEarningTotalScores() < 3.1) {
				earn = "企业经营水平低，需调整经营方针。同时，该企业还存在的问题有：投资者投资报酬不足，成本费用利润率低，企业应加强成本控制；营业、销售利润率偏低，期间费用过高，持续经营较吃力。";
			} else if (dataanaly.getEarningTotalScores() >= 3.1
					&& dataanaly.getEarningTotalScores() < 6.2) {
				earn = "企业业绩良好，资产利用效率尚佳；投资者收益一般，成本费用利润率一般；营业、销售利润率属正常水平，保证其持续经营。";
			} else {
				earn = "企业获利能力强，投资者收益高，成本费用利润率高，取得收益的代价小，营业、销售利润率属较好水平，说明企业在降低期间费用和增加其他收益方面做了较大工作。";
			}
		} else {
			if (dataanaly.getEarningTotalScores() > 0
					&& dataanaly.getEarningTotalScores() < 7.8) {
				earn = "企业经营水平低，需调整经营方针。同时，该企业还存在的问题有：投资者投资报酬不足，成本费用利润率低，企业应加强成本控制；营业、销售利润率偏低，期间费用过高，持续经营较吃力。";
			} else if (dataanaly.getEarningTotalScores() >= 7.8
					&& dataanaly.getEarningTotalScores() < 15.6) {
				earn = "企业业绩良好，资产利用效率尚佳；投资者收益一般，成本费用利润率一般；营业、销售利润率属正常水平，保证其持续经营。";
			} else {
				earn = "企业获利能力强，投资者收益高，成本费用利润率高，取得收益的代价小，营业、销售利润率属较好水平，说明企业在降低期间费用和增加其他收益方面做了较大工作。";
			}
		}
		ratingResults.setGainPower(earn);
		ratingResultsh.setGainPower(earn);
		// 成长性
		String growth;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getGrowthTotalScores() > 0
					&& dataanaly.getGrowthTotalScores() < 8.8) {
				growth = "该企业总收益增长有限，净利润增长缓慢，员工数量维持小幅增加。同时存在以下一个或以上的问题：企业成长性不足，资产规模发展不足；企业家学历偏低且行业资历较浅，业内影响力不足；同时，该企业未做出合理的长期战略规划，或是产品未通过质量认证亦或企业属于夕阳产业，产业周期处于衰退阶段，市场基本饱和，企业成长相当困难。";
			} else if (dataanaly.getGrowthTotalScores() >= 8.8
					&& dataanaly.getGrowthTotalScores() < 17.6) {
				growth = "企业成长性良好，有一定成长空间；资产规模发展尚可，总收益有一定增长，净利润小幅增长，员工数量保持稳步增长；企业家学历水平较高且有一定的资历和一定行内的影响力。企业属于普通产业，市场发展较为成熟，市场竞争较激烈，发展存在一定的风险。";
			} else {
				growth = "企业快速发展壮大，后续发展仍有较大空间和潜力，资产规模扩张迅速，总收益大幅增长，净利润同比快速增长，员工数量快速增长；企业家学历高且有丰富的经验，行内影响力较大；受评级企业的战略、规划及部署合理，产品通过了产品质量认证，企业属于朝阳产业，市场潜力大，竞争少，无市场垄断和进入限制，有较好的成长空间。";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getGrowthTotalScores() > 0
					&& dataanaly.getGrowthTotalScores() < 8.8) {
				growth = "该企业总收益增长有限，净利润增长缓慢，员工数量维持小幅增加。同时存在以下一个或以上的问题：企业成长性不足，资产规模发展不足；企业家学历偏低且行业资历较浅，业内影响力不足；同时，该企业未做出合理的长期战略规划，或是产品未通过质量认证亦或企业属于夕阳产业，产业周期处于衰退阶段，市场基本饱和，企业成长相当困难。";
			} else if (dataanaly.getGrowthTotalScores() >= 8.8
					&& dataanaly.getGrowthTotalScores() < 17.6) {
				growth = "企业成长性良好，有一定成长空间；资产规模发展尚可，总收益有一定增长，净利润小幅增长，员工数量保持稳步增企业家学历水平较高且有一定的资历和一定行内的影响力。企业属于普通产业，市场发展较为成熟，市场竞争较激烈，发展存在一定的风险。";
			} else {
				growth = "企业快速发展壮大，后续发展仍有较大空间和潜力，资产规模扩张迅速，总收益大幅增长，净利润同比快速增长，员工数量快速增长；企业家学历高且有丰富的经验，行内影响力较大；受评级企业的战略、规划及部署合理，产品通过了产品质量认证，企业属于朝阳产业，市场潜力大，竞争少，无市场垄断和进入限制，有较好的成长空间。";
			}
		} else {
			if (dataanaly.getGrowthTotalScores() > 0
					&& dataanaly.getGrowthTotalScores() < 1.1) {
				growth = "该企业总收益增长有限，净利润增长缓慢，员工数量维持小幅增加。同时存在以下一个或以上的问题：企业成长性不足，资产规模发展不足；企业家学历偏低且行业资历较浅，业内影响力不足；同时，该企业未做出合理的长期战略规划，或是产品未通过质量认证亦或企业属于夕阳产业，产业周期处于衰退阶段，市场基本饱和，企业成长相当困难。";
			} else if (dataanaly.getGrowthTotalScores() >= 1.1
					&& dataanaly.getGrowthTotalScores() < 2.2) {
				growth = "企业成长性良好，有一定成长空间；资产规模发展尚可，总收益有一定增长，净利润小幅增长，员工数量保持稳步增长；企业家学历水平较高且有一定的资历和一定行内的影响力。企业属于普通产业，市场发展较为成熟，市场竞争较激烈，发展存在一定的风险。";
			} else {
				growth = "企业快速发展壮大，后续发展仍有较大空间和潜力，资产规模扩张迅速，总收益大幅增长，净利润同比快速增长，员工数量快速增长；企业家学历高且有丰富的经验，行内影响力较大；受评级企业的战略、规划及部署合理，产品通过了产品质量认证，企业属于朝阳产业，市场潜力大，竞争少，无市场垄断和进入限制，有较好的成长空间。";
			}
		}
		ratingResults.setGrowth(growth);
		ratingResultsh.setGrowth(growth);
		// 创新性
		String creative;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getCreativeTotalScores() > 0
					&& dataanaly.getCreativeTotalScores() < 8.8) {
				creative = "该企业创新能力很差，原因可能有：科技成果转化能力差，企业研发经费投入不足，创新性发展疲弱，高水平人才资源不足，影响企业发展，自有知识产权不足， 发展受技术垄断的影响，不重视创新人员激励。";
			} else if (dataanaly.getCreativeTotalScores() >= 8.8
					&& dataanaly.getCreativeTotalScores() < 17.6) {
				creative = "该企业创新能力较好。其专业人才较多，科技实力较高科技成果转化能力一般，企业有一定研发经费投入；有市级以上科技成果奖励，拥有知识产权，后期发展有一定技术优势；同时，近三年有研发项目获得政府立项，有合理的创新人员激励制度。";
			} else {
				creative = "该企业创新能力很强，具备以下优秀的素质：科技成果转化能力非常强，企业重视技术创新，研发投入比例大，经费增长较高，企业高水平人才比例大，拥有优秀的科技人员队伍，获得多项科技成果奖励，掌握多项核心专利技术，在相当长一段时间内拥有技术优势，近三年多项研发项目获得政府立项，有很好的创新人员激励制度，设有专门的研发机构，有创业投资机构进入，有国际化合作，专业水平高，有国家重点实验室。";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getCreativeTotalScores() > 0
					&& dataanaly.getCreativeTotalScores() < 2.8) {
				creative = "该企业创新能力很差，原因可能有：科技成果转化能力差，企业研发经费投入不足，创新性发展疲弱，高水平人才资源不足，影响企业发展，自有知识产权不足， 发展受技术垄断的影响，不重视创新人员激励。";
			} else if (dataanaly.getCreativeTotalScores() >= 2.8
					&& dataanaly.getCreativeTotalScores() < 5.6) {
				creative = "该企业创新能力较好。其专业人才较多，科技实力较高科技成果转化能力一般，企业有一定研发经费投入；有市级以上科技成果奖励，拥有知识产权，后期发展有一定技术优势；同时，近三年有研发项目获得政府立项，有合理的创新人员激励制度。";
			} else {
				creative = "该企业创新能力很强，具备以下优秀的素质：科技成果转化能力非常强，企业重视技术创新，研发投入比例大，经费增长较高，企业高水平人才比例大，拥有优秀的科技人员队伍，获得多项科技成果奖励，掌握多项核心专利技术，在相当长一段时间内拥有技术优势，近三年多项研发项目获得政府立项，有很好的创新人员激励制度，设有专门的研发机构，有创业投资机构进入，有国际化合作，专业水平高，有国家重点实验室。";
			}
		} else {
			if (dataanaly.getCreativeTotalScores() > 0
					&& dataanaly.getCreativeTotalScores() < 2.8) {
				creative = "该企业创新能力很差，原因可能有：科技成果转化能力差，企业研发经费投入不足，创新性发展疲弱，高水平人才资源不足，影响企业发展，自有知识产权不足， 发展受技术垄断的影响，不重视创新人员激励。";
			} else if (dataanaly.getCreativeTotalScores() >= 2.8
					&& dataanaly.getCreativeTotalScores() < 5.6) {
				creative = "该企业创新能力较好。其专业人才较多，科技实力较高科技成果转化能力一般，企业有一定研发经费投入；有市级以上科技成果奖励，拥有知识产权，后期发展有一定技术优势；同时，近三年有研发项目获得政府立项，有合理的创新人员激励制度。";
			} else {
				creative = "该企业创新能力很强，具备以下优秀的素质：科技成果转化能力非常强，企业重视技术创新，研发投入比例大，经费增长较高，企业高水平人才比例大，拥有优秀的科技人员队伍，获得多项科技成果奖励，掌握多项核心专利技术，在相当长一段时间内拥有技术优势，近三年多项研发项目获得政府立项，有很好的创新人员激励制度，设有专门的研发机构，有创业投资机构进入，有国际化合作，专业水平高，有国家重点实验室。";
			}
		}
		ratingResults.setCreative(creative);
		ratingResultsh.setCreative(creative);
		// 信用履约能力
		String credit;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getCreditExerciseTotalScores() > 0
					&& dataanaly.getCreditExerciseTotalScores() < 3.1) {
				credit = "企业信用履约能力较差，存在以下一点或几点问题：应付利息未能全部支付，到期贷款无法及时偿还，应付账款不能全部清付，决策者存在信誉问题，企业存在信用问题，履约能力有限。";
			} else if (dataanaly.getCreditExerciseTotalScores() >= 3.1
					&& dataanaly.getCreditExerciseTotalScores() < 6.2) {
				credit = "企业信用履约能力一般，主要表现为：应付利息基本全部支付，到期贷款基本及时偿还，应付账款基本全部清付，决策者个人无不良记录，企业无不良信用，履约能力较好。";
			} else {
				credit = "企业信用履约能力强，具有以下优良品质：应付利息全部支付，到期贷款及时偿还本息，应付账款全部清付，决策者个人信誉极佳，有良好的道德品质和社会声誉，企业无任何不良信用记录，履约能力强。";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getCreditExerciseTotalScores() > 0
					&& dataanaly.getCreditExerciseTotalScores() < 3.1) {
				credit = "企业信用履约能力较差，存在以下一点或几点问题：应付利息未能全部支付，到期贷款无法及时偿还，应付账款不能全部清付，决策者存在信誉问题，企业存在信用问题，履约能力有限。";
			} else if (dataanaly.getCreditExerciseTotalScores() >= 3.1
					&& dataanaly.getCreditExerciseTotalScores() < 6.2) {
				credit = "企业信用履约能力一般，主要表现为：应付利息基本全部支付，到期贷款基本及时偿还，应付账款基本全部清付，决策者个人无不良记录，企业无不良信用，履约能力较好。";
			} else {
				credit = "企业信用履约能力强，具有以下优良品质：应付利息全部支付，到期贷款及时偿还本息，应付账款全部清付，决策者个人信誉极佳，有良好的道德品质和社会声誉，企业无任何不良信用记录，履约能力强。";
			}
		} else {
			if (dataanaly.getCreditExerciseTotalScores() > 0
					&& dataanaly.getCreditExerciseTotalScores() < 7.8) {
				credit = "企业信用履约能力较差，存在以下一点或几点问题：应付利息未能全部支付，到期贷款无法及时偿还，应付账款不能全部清付，决策者存在信誉问题，企业存在信用问题，履约能力有限。";
			} else if (dataanaly.getCreditExerciseTotalScores() >= 7.8
					&& dataanaly.getCreditExerciseTotalScores() < 15.6) {
				credit = "企业信用履约能力一般，主要表现为：应付利息基本全部支付，到期贷款基本及时偿还，应付账款基本全部清付，决策者个人无不良记录，企业无不良信用，履约能力较好。";
			} else {
				credit = "企业信用履约能力强，具有以下优良品质：应付利息全部支付，到期贷款及时偿还本息，应付账款全部清付，决策者个人信誉极佳，有良好的道德品质和社会声誉，企业无任何不良信用记录，履约能力强。";
			}
		}
		ratingResults.setCreditPerformance(credit);
		ratingResultsh.setCreditPerformance(credit);
		// 管理水平
		String manager;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getManagerLevelTotalScores() > 0
					&& dataanaly.getManagerLevelTotalScores() < 3.1) {
				manager = "企业管理水平低，管理存在问题。企业发展对管理者能力有较大依赖性，股东实力弱，承担能力有限，未按规定设立董事会，董事长与CEO未进行两职设置，审计无法表达意见，存在违规行为；";
			} else if (dataanaly.getManagerLevelTotalScores() >= 3.1
					&& dataanaly.getManagerLevelTotalScores() < 6.2) {
				manager = "企业管理水平较好，管理结构较合理，管理者有一定行业经验；依照规定设立董事会，董事长与CEO两职设置，审计结果无保留，无违规行为。";
			} else {
				manager = "企业管理水平高，发展稳定，有科学成熟的管理体制机制；股东实力雄厚，企业管理结构合理，管理者行业经验丰富；";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getManagerLevelTotalScores() > 0
					&& dataanaly.getManagerLevelTotalScores() < 3.1) {
				manager = "企业管理水平低，管理存在问题。企业发展对管理者能力有较大依赖性，股东实力弱，承担能力有限，未按规定设立董事会，董事长与CEO未进行两职设置，审计无法表达意见，存在违规行为；";
			} else if (dataanaly.getManagerLevelTotalScores() >= 3.1
					&& dataanaly.getManagerLevelTotalScores() < 6.2) {
				manager = "企业管理水平较好，管理结构较合理，管理者有一定行业经验；依照规定设立董事会，董事长与CEO两职设置，审计结果无保留，无违规行为。";
			} else {
				manager = "企业管理水平高，发展稳定，有科学成熟的管理体制机制；股东实力雄厚，企业管理结构合理，管理者行业经验丰富；";
			}
		} else {
			if (dataanaly.getManagerLevelTotalScores() > 0
					&& dataanaly.getManagerLevelTotalScores() < 2.8) {
				manager = "企业管理水平低，管理存在问题。企业发展对管理者能力有较大依赖性，股东实力弱，承担能力有限，未按规定设立董事会，董事长与CEO未进行两职设置，审计无法表达意见，存在违规行为；";
			} else if (dataanaly.getManagerLevelTotalScores() >= 2.8
					&& dataanaly.getManagerLevelTotalScores() < 5.6) {
				manager = "企业管理水平较好，管理结构较合理，管理者有一定行业经验；依照规定设立董事会，董事长与CEO两职设置，审计结果无保留，无违规行为。";
			} else {
				manager = "企业管理水平高，发展稳定，有科学成熟的管理体制机制；股东实力雄厚，企业管理结构合理，管理者行业经验丰富；";
			}
		}
		ratingResults.setManagePower(manager);
		ratingResultsh.setManagePower(manager);
		// 市场竞争力
		String compete;
		if (epinfo.getStage() == 1) {
			if (dataanaly.getMarketCompeteTotalScores() > 0
					&& dataanaly.getMarketCompeteTotalScores() < 1.1) {
				compete = "企业市场竞争力差，主要体现在：发展受政策限制，政策上不支持，不鼓励该类产业的发展，企业未来前景不看好，企业在行业内处于落后地位，议价能力差，属于价格接受者；产品基本无竞争力，技术和成本均落后于行业平均水平。";
			} else if (dataanaly.getMarketCompeteTotalScores() >= 1.1
					&& dataanaly.getMarketCompeteTotalScores() < 2.2) {
				compete = "企业竞争力一般，主要体现在目前没有相关扶持政策，企业的发展需参考地方政策，发展存在一定困难；企业在行业内处于中游，在市场中占有一定的份额；产品竞争力一般，市场上存在同质或替代产品。";
			} else {
				compete = "企业竞争力很强，具备以下优势：属于国家支持产业，有相关国家财税、教育和产业政策支持其发展，地方政府出台扶持鼓励措施，市场空间大，发展前景良好；企业在行业内处于优势地位，市场占有率高；企业产品极具竞争力。";
			}
		} else if (epinfo.getStage() == 2) {
			if (dataanaly.getMarketCompeteTotalScores() > 0
					&& dataanaly.getMarketCompeteTotalScores() < 3.1) {
				compete = "企业市场竞争力差，主要体现在：发展受政策限制，政策上不支持，不鼓励该类产业的发展，企业未来前景不看好，企业在行业内处于落后地位，议价能力差，属于价格接受者；产品基本无竞争力，技术和成本均落后于行业平均水平。";
			} else if (dataanaly.getMarketCompeteTotalScores() >= 3.1
					&& dataanaly.getMarketCompeteTotalScores() < 6.2) {
				compete = "企业竞争力一般，主要体现在目前没有相关扶持政策，企业的发展需参考地方政策，发展存在一定困难；企业在行业内处于中游，在市场中占有一定的份额；产品竞争力一般，市场上存在同质或替代产品。";
			} else {
				compete = "企业竞争力很强，具备以下优势：属于国家支持产业，有相关国家财税、教育和产业政策支持其发展，地方政府出台扶持鼓励措施，市场空间大，发展前景良好；企业在行业内处于优势地位，市场占有率高；企业产品极具竞争力。";
			}
		} else {
			if (dataanaly.getMarketCompeteTotalScores() > 0
					&& dataanaly.getMarketCompeteTotalScores() < 2.8) {
				compete = "企业市场竞争力差，主要体现在：发展受政策限制，政策上不支持，不鼓励该类产业的发展，企业未来前景不看好，企业在行业内处于落后地位，议价能力差，属于价格接受者；产品基本无竞争力，技术和成本均落后于行业平均水平。";
			} else if (dataanaly.getMarketCompeteTotalScores() >= 2.8
					&& dataanaly.getMarketCompeteTotalScores() < 5.6) {
				compete = "企业竞争力一般，主要体现在目前没有相关扶持政策，企业的发展需参考地方政策，发展存在一定困难；企业在行业内处于中游，在市场中占有一定的份额；产品竞争力一般，市场上存在同质或替代产品。";
			} else {
				compete = "企业竞争力很强，具备以下优势：属于国家支持产业，有相关国家财税、教育和产业政策支持其发展，地方政府出台扶持鼓励措施，市场空间大，发展前景良好；企业在行业内处于优势地位，市场占有率高；企业产品极具竞争力。";
			}
		}
		ratingResults.setMarketCompetitive(compete);
		ratingResultsh.setMarketCompetitive(compete);
		Operation operationFist = new Operation();
		operationFist.setCompanyId(ratingResults.getCompanyId());
		operationFist.setTotal(ratingResults.getTotal());
		operationFist.setCreditId(ratingResults.getCreditId());
		operationFist.setRating(ratingResults.getRating());
		operationFist.setLifecycle(ratingResults.getLifecycle());
		operationFist.setCreateTime(ratingResults.getCreateTime());
		operationFist.setOrgNo(ratingResults.getOrgNo());
		operationFist.setReportType(1);
		operationFist.setScale(ratingResults.getScale());
		operationFist.setPayPower(ratingResults.getPayPower());
		operationFist.setRun(ratingResults.getRun());
		operationFist.setGainPower(ratingResults.getGainPower());
		operationFist.setGrowth(ratingResults.getGrowth());
		operationFist.setCreative(ratingResults.getCreative());
		operationFist.setCreditPerformance(ratingResults.getCreditPerformance());
		operationFist.setManagePower(ratingResults.getManagePower());
		operationFist.setMarketCompetitive(ratingResults.getMarketCompetitive());
		operationFist.setRevaluation(revaluation);
		operationFist.setCompanyName(epinfo.getEpname());
		Operation operationOld = ratingResultsDAO.findOperByCompanyId(epinfo.getId());
		if(operationOld!=null){
			operationFist.setId(operationOld.getId());
		}
		ratingResultsDAO.saveRatingResults(ratingResults);//保存评级结果
		
		ratingResultsDAO.saveOperation(operationFist);
		Dataanalyh datah=new Dataanalyh();
		datah.setEnterpriseId(epId);
		datah.setAttributeId(attirbuteId);
		// 1 企业规模指标
		// 企业净资产总额
		datah.setNetAssetTarget(attribute.getTotalNetAssets());
		datah.setNetAssetValue(netAssetValue);
		// 企业固定资产总额
		datah.setFixAssetTarget(attribute.getTotalCapitalAsserts());
		datah.setFixAssetValue(fixAssetValue);
		// 营业收入
		datah.setIncomeTarget(attribute.getOperatingReceipt());
		datah.setIncomeValue(incomeValue);
		// 企业税后利润总额
		datah.setProfitTarget(attribute.getTotalCapitalAsserts());
		datah.setProfitValue(profitValue);
		// 固定资产净值
		datah.setNetbalTarget(attribute.getCapitalAssertsNetValue());
		datah.setNetbalValue(netbalValue);
		// 企业企业规模总得分总得分
		datah.setScaleMeritTotalScores(scaleMeritTotalScores);
		// 偿债能力总得分
		// 流动比率
		datah.setLiquidRatioTarget(DebtResemption.getCurrentRatio(attribute
				.getFloatingCapital(), attribute.getCashLiabilities()));
		datah.setLiquidRatioValue(DebtResemption.getCurrentRatioValue(
				epinfo.getStage(), attribute.getFloatingCapital(), attribute
						.getCashLiabilities()));
		// 速动比率
		datah.setQuickRatioTarget(DebtResemption.getquickRatio(attribute
				.getGeneralCash(), attribute.getShortTermBondInvestment(),
				attribute.getAccountReceivable(),
				attribute.getNoteReceivable(), attribute.getCashLiabilities()));
		datah.setQuickRatioValue(DebtResemption.getquickRatioValue(epinfo
				.getStage(), attribute.getGeneralCash(), attribute
				.getShortTermBondInvestment(),
				attribute.getAccountReceivable(),
				attribute.getNoteReceivable(), attribute.getCashLiabilities()));
		// 现金比率
		datah.setCashRatioTarget(DebtResemption.getCashRatio(attribute
				.getValueSecurities(), attribute.getGeneralCash(), attribute
				.getCashLiabilities()));
		datah.setCashRatioValue(DebtResemption.getCashRatioValue(epinfo
				.getStage(), attribute.getValueSecurities(), attribute
				.getGeneralCash(), attribute.getCashLiabilities()));
		// 资产负债率
		datah.setDebtRatioTarget(DebtResemption.getAssetliabilityRatio(
				attribute.getGrossLiabilities(), attribute.getTotalAssets()));
		datah.setDebtRatioValue(DebtResemption.getAssetliabilityRatioValue(
				epinfo.getStage(), attribute.getGrossLiabilities(), attribute
						.getTotalAssets()));
		// 产权比率
		datah.setEquityRatioTarget(DebtResemption.getEquityRatio(attribute
				.getGrossLiabilities(), attribute.getTotalAssets()));
		datah.setEquityRatioValue(DebtResemption.getEquityRatioValue(epinfo
				.getStage(), attribute.getGrossLiabilities(), attribute
				.getTotalAssets()));
		// 利息保障倍数
		datah.setInterestTimesTarget(DebtResemption.getInterestCover(
				attribute.getEarningsInterestTaxes(), attribute
						.getCapitalCharges()));
		datah.setInterestTimesValue(DebtResemption.getInterestCoverValue(
				epinfo.getStage(), attribute.getEarningsInterestTaxes(),
				attribute.getCapitalCharges()));
		// 股东权益比率
		datah.setShareholderRatioTarget(DebtResemption.getEquityratio(
				attribute.getGrossLiabilities(), attribute.getTotalAssets()));
		datah.setShareholderRatioValue(DebtResemption.getEquityratioValue(
				epinfo.getStage(), attribute.getGrossLiabilities(), attribute
						.getTotalAssets()));
		// 担保比率
		datah.setCollateralRatioTarget(DebtResemption.getGuaranteeRatio(
				attribute.getForeignGuaranteeAmount(), attribute
						.getGrossLiabilities(), attribute.getTotalAssets()));
		datah.setCollateralRatioValue(DebtResemption
				.getGuaranteeRatioValue(epinfo.getStage(), attribute
						.getForeignGuaranteeAmount(), attribute
						.getGrossLiabilities(), attribute.getTotalAssets()));
		datah.setDebtTotalScores(debtTotalScores);
		// 营运能力总得分
		// 总资产周转率
		datah.setTotalAssetTurnRatioTarget(OperationalCapacity
				.OTotalAssetsTurnoverTarget(attribute.getSalesProceed(),
						attribute.getTotalAssets()));
		datah.setTotalAssetTurnRatioValue(OperationalCapacity
				.OTotalAssetsTurnoverValue(epinfo.getStage(), attribute
						.getSalesProceed(), attribute.getTotalAssets()));
		// 流动资产周转率
		datah.setLiquidAssetTurnRatioTarget(OperationalCapacity
				.OCurrentAssetsTurnoverTarget(attribute
						.getMainBusinessNetIncome(), attribute
						.getBeginTotalCurrentAssets(), attribute
						.getEndTotalCurrentAssets()));
		datah.setLiquidAssetTurnRatioValue(OperationalCapacity
				.OCurrentAssetsTurnoverValue(epinfo.getStage(), attribute
						.getMainBusinessNetIncome(), attribute
						.getBeginTotalCurrentAssets(), attribute
						.getEndTotalCurrentAssets()));
		// 固定资产周转率
		datah.setFixAssetTurnRatioTarget(OperationalCapacity
				.OFixedAssetTurnoverTarget(attribute.getSalesProceed(),
						attribute.getFixedAssets()));
		datah.setFixAssetTurnRatioValue(OperationalCapacity
				.OFixedAssetTurnoverValue(epinfo.getStage(), attribute
						.getSalesProceed(), attribute.getFixedAssets()));
		// 应收帐款周转率
		datah.setReceivableTurnRatioTarget(OperationalCapacity
				.OAccountsReceivableTurnoverRatioTarget(attribute
						.getSalesProceed(), attribute
						.getBeginTotalAccountsReceivable(), attribute
						.getEndTotalAccountsReceivable()));
		datah.setReceivableTurnRatioValue(OperationalCapacity
				.OAccountsReceivableTurnoverRatioValue(epinfo.getStage(),
						attribute.getSalesProceed(), attribute
								.getBeginTotalAccountsReceivable(), attribute
								.getEndTotalAccountsReceivable()));
		// 存货周转率
		datah.setStockTurnRatioTarget(OperationalCapacity
				.OInventoryTurnoverTarget(attribute.getSellingCost(), attribute
						.getBeginningInventory(), attribute.getEndInventory()));
		datah.setStockTurnRatioValue(OperationalCapacity
				.OInventoryTurnoverValue(epinfo.getStage(), attribute
						.getSellingCost(), attribute.getBeginningInventory(),
						attribute.getEndInventory()));
		// 资产保值、增值率
		datah.setAssetIncrementRatioTarget(OperationalCapacity
				.OIncreasingGrowthRateOfAssetsTarget(attribute
						.getEndOwnerEquity(), attribute.getBeginOwnerEquity()));
		datah.setAssetIncrementRatioValue(OperationalCapacity
				.OIncreasingGrowthRateOfAssetsValue(epinfo.getStage(),
						attribute.getEndOwnerEquity(), attribute
								.getBeginOwnerEquity()));
		// 销售收入增长率
		datah.setSaleGrowRatioTarget(OperationalCapacity
				.OSalesRevenueGrowthTarget(attribute.getEndSalesProceed(),
						attribute.getBeginSalesProceed()));
		datah
				.setSaleGrowRatioValue(OperationalCapacity
						.OSalesRevenueGrowthValue(epinfo.getStage(), attribute
								.getEndSalesProceed(), attribute
								.getBeginSalesProceed()));
		datah.setOperationTotalScores(operationTotalScores);
		// 盈利能力总得分
		// 总资产回报率
		datah.setTotalAssetReturnRatioTarget(ProfitAbility.getAssetsRate(
				attribute.getBeginTotalAssets(), attribute.getEndTotalAssets(),
				attribute.getGrossInterest(), attribute.getInterestExpense()));
		datah.setTotalAssetReturnRatioValue(ProfitAbility
				.getAssetsRateScore(epinfo.getStage(), attribute
						.getBeginTotalAssets(), attribute.getEndTotalAssets(),
						attribute.getGrossInterest(), attribute
								.getInterestExpense()));
		// 净资产回报率
		datah.setNetAssetReturnRatioTarget(ProfitAbility.getRona(attribute
				.getNetIncomeRetainedAfterTax(), attribute.getNetAssets()));
		datah.setNetAssetReturnRatioValue(ProfitAbility.getRonaScore(epinfo
				.getStage(), attribute.getNetIncomeRetainedAfterTax(),
				attribute.getNetAssets()));
		// 成本费用利润率
		datah.setPerfitCostRatioTarget(ProfitAbility.getCostEfficiency(
				attribute.getTotalProfit(), attribute.getTotalCost()));
		datah.setPerfitCostRatioValue(ProfitAbility.getCostEfficiencyScore(
				epinfo.getStage(), attribute.getTotalProfit(), attribute
						.getTotalCost()));
		// 主营业务税后利润率
		datah.setAfterTaxProfitTarget(ProfitAbility.getMainProfitRate(
				attribute.getMainOperationIncome(), attribute.getCostOfSales(),
				attribute.getSalesTax()));
		datah.setAfterTaxProfitValue(ProfitAbility.getMainProfitRateScore(
				epinfo.getStage(), attribute.getMainOperationIncome(),
				attribute.getCostOfSales(), attribute.getSalesTax()));
		// 销售利润率
		datah.setSaleProfitTarget(ProfitAbility.getNetProfitRatio(attribute
				.getTotalProfit(), attribute.getOperatingReceipt()));
		datah.setSaleProfitValue(ProfitAbility.getNetProfitRatioScore(
				epinfo.getStage(), attribute.getTotalProfit(), attribute
						.getOperatingReceipt()));
		datah.setEarningTotalScores(earningTotalScores);


		// 总资产增长率
		datah.setTotalAssetGrowRatioTarget(GrowthIndexValue
				.getTotalAssetGrowRatioTarget(attribute.getEndTotalAssets(),
						attribute.getBeginTotalAssets()));

		datah.setTotalAssetGrowRatioValue(GrowthIndexValue
				.getTotalAssetGrowRatioValue(epinfo.getStage(), attribute
						.getEndTotalAssets(), attribute.getBeginTotalAssets()));

		// 净资产增长率
		datah.setNetAssetGrowRatioTarget(GrowthIndexValue
				.getNetAssetGrowRatioTarget(attribute.getBeginNetAssets(),
						attribute.getEndNetAssets()));

		datah.setNetAssetGrowRatioValue(GrowthIndexValue
				.getNetAssetGrowRatioValue(epinfo.getStage(), attribute
						.getBeginNetAssets(), attribute.getEndNetAssets()));
		// 总收益增长率
		datah.setTotalIncomeGrowRatioTarget(GrowthIndexValue
				.getTotalIncomeGrowRatioTarget(attribute
						.getBeginBusinessReceipt(), attribute
						.getEndBusinessReceipt(), attribute
						.getBeginNonrevenueReceipt(), attribute
						.getEndNonrevenueReceipt()));

		datah.setTotalIncomeGrowRatioValue(GrowthIndexValue
				.getTotalIncomeGrowRatioValue(epinfo.getStage(), attribute
						.getBeginBusinessReceipt(), attribute
						.getEndBusinessReceipt(), attribute
						.getBeginNonrevenueReceipt(), attribute
						.getEndNonrevenueReceipt()));
		// 净利润增长率
		datah.setNetIncomeGrowRatioTarget(GrowthIndexValue
				.getNetIncomeGrowRatioTarget(attribute.getLastTotalProfit(),
						attribute.getLastIncomeTax(), attribute
								.getTotalProfit(), attribute.getIncomeTax()));

		datah.setNetIncomeGrowRatioValue(GrowthIndexValue
				.getNetIncomeGrowRatioValue(epinfo.getStage(), attribute
						.getLastTotalProfit(), attribute.getLastIncomeTax(),
						attribute.getTotalProfit(), attribute.getIncomeTax()));
		// 主营业务利润率增长
		datah.setMainBusProfitGrowTarget(GrowthIndexValue
				.getMainBusProfitGrowTarget(attribute
						.getBeginMainOperationIncome(), attribute
						.getEndMainOperationIncome(), attribute
						.getBeginCostOfSales(), attribute.getEndCostOfSales(),
						attribute.getBeginSalesTax(), attribute
								.getEndSalesTax()));

		datah.setMainBusProfitGrowValue(GrowthIndexValue
				.getMainBusProfitGrowValue(epinfo.getStage(), attribute
						.getBeginMainOperationIncome(), attribute
						.getEndMainOperationIncome(), attribute
						.getBeginCostOfSales(), attribute.getEndCostOfSales(),
						attribute.getBeginSalesTax(), attribute
								.getEndSalesTax()));
		// 员工数量增长率
		datah.setEmployeeGrowRatioTarget(GrowthIndexValue
				.getEmployeeGrowRatioTarget(attribute.getEmployeNumLastYear(),
						attribute.getEmployeNumCurrentYear()));

		datah.setEmployeeGrowRatioValue(GrowthIndexValue
				.getEmployeeGrowRatioValue(epinfo.getStage(), attribute
						.getEmployeNumLastYear(), attribute
						.getEmployeNumCurrentYear()));
		// 企业家年龄
		datah.setEuntreponierAgeTarget(attribute.getAgeGroup());

		datah.setEuntreponierAgeValue(GrowthIndexValue
				.getEuntreponierAgeValue(epinfo.getStage(), attribute
						.getAgeGroup()));
		// 企业家学历/学位/职称
		datah.setEuntreponierDegreeTarget(attribute.getDegreeTitles());

		datah.setEuntreponierDegreeValue(GrowthIndexValue
				.getEuntreponierDegreeValue(epinfo.getStage(), attribute
						.getDegreeTitles()));

		// 企业家岗位工作时间
		datah.setEuntreponierWorkTimeTarget(attribute.getWorkingTime());

		datah.setEuntreponierWorkTimeValue(GrowthIndexValue
				.getEuntreponierWorkTimeValue(epinfo.getStage(), attribute
						.getWorkingTime()));
		// 企业家业内知名度\社会关系
		datah.setEuntreponierPopularyTarget(attribute.getReputations());

		datah.setEuntreponierPopularyValue(GrowthIndexValue
				.getEuntreponierPopularyValue(epinfo.getStage(), attribute
						.getReputations()));
		// 企业发展规划
		if (attribute.getEnterpriseExpansionProjects()) {
			datah.setDevelopPlanTarget(1);

			datah.setDevelopPlanValue(GrowthIndexValue
					.getEnterpriseExpansionProjectsValue(epinfo.getStage(),
							true));
		} else {
			datah.setDevelopPlanTarget(0);

			datah.setDevelopPlanValue(GrowthIndexValue
					.getEnterpriseExpansionProjectsValue(epinfo.getStage(),
							false));
		}
		// 产品长期发展战略
		if (attribute.getProducLongTermDevelopment()) {
			datah.setDevelopStrategyTarget(1);
			datah.setDevelopStrategyValue(GrowthIndexValue
							.getProducLongTermDevelopmentValue(epinfo
									.getStage(), true));
		} else {
			datah.setDevelopStrategyTarget(0);

			datah
					.setDevelopStrategyValue(GrowthIndexValue
							.getProducLongTermDevelopmentValue(epinfo
									.getStage(), false));
		}

		if (attribute.getProductQualityCertification()) {
			datah.setQualityCertificateTarget(1);

			datah.setQualityCertificateValue(GrowthIndexValue
					.getProductQualityCertificationValue(epinfo.getStage(),
							true));
		} else {
			datah.setQualityCertificateTarget(0);

			datah.setQualityCertificateValue(GrowthIndexValue
					.getProductQualityCertificationValue(epinfo.getStage(),
							false));
		}

		datah.setIndustryNatureTarget(attribute.getLndustryProperties());

		datah.setIndustryNatureValue(GrowthIndexValue
				.getLndustryPropertiesValue(epinfo.getStage(), attribute
						.getLndustryProperties()));

		datah.setGrowthTotalScores(growthScores);

		/** 6.1.1高新技术产品（服务）销售收入（指标） */
		datah.setHighTechIncomeRatioTarget(CreativeKPI
				.getAllYHighIncomeRatio(attribute.getYearNewSalesIncome(),
						attribute.getYearGrossSales()));
		/** 6.1.2高新技术产品（服务）销售收入（分值） */
		datah.setHighTechIncomeRatioValue(CreativeKPI
						.getAllYHighIncomeRatioValue(epinfo.getStage(),
								attribute.getYearNewSalesIncome(), attribute
										.getYearGrossSales()));

		/** 6.2.1R&D投入占比（指标） */
		datah.setRdinputRatioTarget(CreativeKPI.getRDInputRatio(attribute
				.getAppropriationExpenditure(), attribute.getYearGrossSales()));
		/** 6.2.2R&D投入占比（分值） */
		datah.setRdinputRatioValue(CreativeKPI.getRDInputRatioValue(epinfo
				.getStage(), attribute.getAppropriationExpenditure(), attribute
				.getYearGrossSales()));

		/** 6.3.1R&D经费增长率（指标） */
		datah.setRdmoneyGrowRatioTarget(CreativeKPI.getRDIncreRatio(
				attribute.getBeginFundingAmount(), attribute
						.getEndFundingAmount()));
		/** 6.3.2R&D经费增长率（分值） */
		datah.setRdmoneyGrowRatioValue(CreativeKPI.getRDIncreRatioValue(
				epinfo.getStage(), attribute.getBeginFundingAmount(), attribute
						.getEndFundingAmount()));

		/** 6.4.1大专以上人数占比（指标） */
		datah.setCollageRatioTarget(CreativeKPI.collageRatioTarget(
				attribute.getAboveCollegeEmployeeNum(), attribute
						.getEmployeNumCurrentYear()));
		/** 6.4.2大专以上人数占比（分值） */
		datah.setCollageRatioValue(CreativeKPI.collageRatioValue(epinfo
				.getStage(), attribute.getAboveCollegeEmployeeNum(), attribute
				.getEmployeNumCurrentYear()));

		/** 6.5.1科技成果奖励数（指标） */
		datah.setTechnicalPayoffNumTarget(attribute
				.getScientificRewardsNum());
		/** 6.5.2科技成果奖励数（分值） */
		datah.setTechnicalPayoffNumValue(CreativeKPI.rewardValue(epinfo
				.getStage(), attribute.getScientificRewardsNum()));

		/** 6.6.1知识产权总数（指标） */
		datah.setIprnumTarget(attribute.getIntellectualPropertyRightNum());
		/** 6.6.2知识产权总数（分值） */
		datah.setIprnumValue(CreativeKPI.rewardValue(epinfo.getStage(),
				attribute.getIntellectualPropertyRightNum()));

		/** 6.7.1专利总数（指标） */
		datah.setPatentNumTarget(attribute.getPatentNum());
		/** 6.7.2专利总数（分值） */
		datah.setPatentNumValue(CreativeKPI.rewardValue(epinfo.getStage(),
				attribute.getPatentNum()));

		/** 6.8.1近三年获政府立项数量(国家级)（指标） */
		datah.setGovprojectNumLandTarget(attribute
				.getCouontryGovernmentProjectNum());
		/** 6.8.2近三年获政府立项数量(国家级)（分值） */
		datah.setGovprojectNumLandValue(CreativeKPI.projectValue(epinfo
				.getStage(), attribute.getCouontryGovernmentProjectNum()));

		/** 6.9.1近三年获政府立项数量(省级)（指标） */
		datah.setGovprojectNumProTarget(attribute
				.getProvinceGovernmentprojectNum());
		/** 6.9.2近三年获政府立项数量(省级)（分值） */
		datah.setGovprojectNumProValue(CreativeKPI.projectValue(epinfo
				.getStage(), attribute.getProvinceGovernmentprojectNum()));

		/** 6.10.1近三年获政府立项数量(市级)（指标） */
		datah.setGovprojectNumCityTarget(attribute
				.getCityGovernmentprojectNum());
		/** 6.10.2近三年获政府立项数量(市级)（分值） */
		datah.setGovprojectNumCityValue(CreativeKPI.projectValue(epinfo
				.getStage(), attribute.getCityGovernmentprojectNum()));

		/** 6.11.1有无创新人员激励制度（指标）。0：无，1：有 */
		datah.setIncentiveTarget(CreativeKPI.toInteger(attribute
				.getIncentiveSystemOfInnovation()));
		/** 6.11.2创新人员激励制度（分值） */
		datah.setIncentiveValue(CreativeKPI.incentiveValue(epinfo
				.getStage(), attribute.getIncentiveSystemOfInnovation()));

		/** 6.12.1专门的研发机构（指标）。0：无，1：有 */
		datah.setRdorganizationTarget(CreativeKPI.toInteger(attribute
				.getResearchinstitute()));
		/** 6.12.2专门的研发机构（分值） */
		datah.setRdorganizationValue(CreativeKPI
				.internationalOrgnizationValue(epinfo.getStage(), attribute
						.getResearchinstitute()));

		/** 6.13.1有无投资机构（指标）。0：无，1：有 */
		datah.setInvestmentOrganizationTarget(CreativeKPI
				.toInteger(attribute.getVentureCapitalInstitutions()));
		/** 6.13.2有无投资机构（分值） */
		datah.setInvestmentOrganizationValue(CreativeKPI
				.internationalOrgnizationValue(epinfo.getStage(), attribute
						.getVentureCapitalInstitutions()));

		/** 6.14.1有无国际化合作（指标）。0：无，1：有 */
		datah.setInternateCooTarget(CreativeKPI.toInteger(attribute
				.getInternationallyCooperative()));
		/** 6.14.2有无国际化合作（分值） */
		datah.setInternateCooValue(CreativeKPI
				.internationalOrgnizationValue(epinfo.getStage(), attribute
						.getInternationallyCooperative()));

		/** 6.15.1有无国家重点实验室（指标）。0：无，1：有 */
		datah.setLhdtarget(CreativeKPI.toInteger(attribute
				.getStateKeyLaboratory()));
		/** 6.15.2有无国家重点实验室（分值） */
		datah.setLhdvalue(CreativeKPI.labouratoryValue(epinfo.getStage(),
				attribute.getStateKeyLaboratory()));

		/** 创新性指标总得分 */
		datah.setCreativeTotalScores(creativeTotalScores);

		/** 信用履约能力指标 WCW */
		/** 7.1.1 利息偿付率 WCW */
		datah.setInterestCoverageRatioTarget(
		/** 计算利息偿付率 */
		CreditPerformancePowerUtil.getInterestCoverageRate(
		/** 函数赋值：用atrribute的get方法获得: 企业税后利润总额 */
		attribute.getTotalTaxProfit(),
		/** 所得税 */
		attribute.getIncomeTax(),
		/** 利息费用 */
		attribute.getCapitalCharges()));
		/** 7.1 .2 利息偿付率得分值 interestCoverageRatioValue */
		/** 计算利息偿付率 */
		
		datah.setInterestCoverageRatioValue(interestCoverageRatioValue);
		/** 7.2.1 贷款逾期率 */
		datah.setLoanOutdateRatioTarget(
		/** 计算贷款逾期率 */
		CreditPerformancePowerUtil.getOverdueLoansRate(
		/** 函数赋值：用atrribute的get方法获得 */
		attribute.getOverdueLoans(), attribute.getLoanCeiling()));

		/** 7.2.2 贷款逾期率得分值 */
		datah.setLoanOutdateRatioValue(loanOutdateRatioValue);
		/** 7.3.1 应付账款清付率（指标） */
		datah.setPayMoneyRatioTarget(CreditPerformancePowerUtil
				.getShouldPaidCreditRate(attribute.getAlreadyPaidCredit(),
						attribute.getShouldPaidCredit()));
		/** 7.3.2 应付账款清付率（分值） */
		datah.setPayMoneyRatioValue(payMoneyRatioValue);
		/** 7.4.1 经营决策者个人信誉 */
		datah.setPersonalCreditTarget(attribute.getPersonalReputation());
		/** 7.4.2 经营决策者个人信誉 （分值） */
		datah.setPersonalCreditValue(personalCreditValue);
		/** 信用履约能力总得分 */
		datah.setCreditExerciseTotalScores(loanOutdateRatioValue
				+ loanOutdateRatioValue + payMoneyRatioValue
				+ personalCreditValue);

		/** 管理水平指标 WCW */
		/** 8.1.1 经营管理水平（指标）。1：优秀，3：良好，2：一般，4：差 */
		datah.setManageLevelTarget(attribute.getOperationControl());
		/** 8.1.2 经营管理水平（分值） */
		datah.setManageLevelValue(manageLevelValue);
		/** 8.2.1股东背景（指标）。0:中央级企业、上市公司，1：地市级以上（含）政府控投企业，2：民营企业及其他 */
		datah.setShareholderBackgroundTarget(attribute
				.getShareholdersBackground());
		/** 8.2.2 股东背景（分值） */
		datah.setShareholderBackgroundValue(shareholderBackgroundValue);
		/** 8.3.1管理者任职年份（指标） */
		datah.setManagerWorkTimeTarget(attribute.getTakeOfficeYear()
				.toString());
		/** 8.3.2管理者任职年份（分值） */
		datah.setManagerWorkTimeValue(managerWorkTimeValue);
		/** 8.4.1董事会规模（指标）。0：按规定设置，1：未按规定设置 */
		datah.setBoardSizeTarget(attribute.getBoardOfDirectors());
		/** 8.4.2董事会规模（分值） */
		datah.setBoardSizeValue(BoardSizeValue);
		/** 8.5.1董事长与CEO两职设置状况（指标）。0：按规定设置，1：未按规定设置 */
		datah.setChairCeotarget(attribute.getCeosetupStatus());
		/** 8.5.2董事长与CEO两职设置状况（分值） */
		datah.setChairCeovalue(chairCeovalue);
		/** 8.6.1管理者审计意见（指标） */
		datah.setAuditOpinionTarget(attribute.getAuditOpinion());
		/** 8.6.2管理者审计意见（分值） */
		datah.setAuditOpinionValue(auditOpinionValue);
		/** 8.7.1管理者违规行为（指标）。0：无，1：有 */
		datah.setIllegalBehaviorTarget(attribute.getIrregularities());
		/** 8.7.2管理者违规行为（分值） */

		datah.setIllegalBehaviorValue(illegalBehaviorValue);
		/** 8.8.1管理者年龄（指标）。0：<35，1：35~50，2：>50 */
		datah.setManagerAgeTarget(attribute.getAgeGroup());
		/** 8.8.2管理者年龄（分值） */
		datah.setManagerAgeValue(managerAgeValue);
		/** 8.9.1管理者教育背景（指标）。0：特殊知名人物，1：博士/高级，2：硕士/副高，3：本科/中级 ,4：专科/初级 */
		// dataanaly.setManagerEdubackgroundTarget(attribute.getDegreeTitles());
		datah.setManagerEdubackgroundTarget(attribute.getEduBackground());
		/** 8.9.2管理者教育背景（分值） */
		// double managerEdubackgroundValue = ManagementLevel.ToDegreeTitles(
		// epinfo.getStage(), attribute.getDegreeTitles());
		datah.setManagerEdubackgroundValue(managerEdubackgroundValue);
		/** 8.10.1管理者职称（指标）。0：无，1：初，2：中，3：副高，4：高 */
		datah.setManagerTitalTarget(attribute.getAcademicTitle());
		/** 8.10.2管理者职称（分值） */
		datah.setManagerTitalValue(managerTitalValue);

		/** 管理水平总得分 */
		datah.setManagerLevelTotalScores(manageLevelValue
				+ shareholderBackgroundValue + managerWorkTimeValue
				+ BoardSizeValue + chairCeovalue + auditOpinionValue
				+ illegalBehaviorValue + managerAgeValue
				+ managerEdubackgroundValue + managerTitalValue);
		/** 9.1.1国家产业政策（指标）。0：鼓励发展，1：一般态度，2：限制发展，3：要求淘汰 */
		datah.setIndustryPolicyTarget(attribute
				.getStateIndustrialPolicies());

		/** 9.1.2国家产业政策（分值） */
		datah.setIndustryPolicyValue(industryPolicyValue);

		/** 9.2.1行业地位（指标）。0：产品市场占有率高，议价能力强，1：议价能力一般，2：议价能力差 */
		datah.setIndustryPositionTarget(attribute.getIndustryPosition());
		/** 9.2.2行业地位（分值） */
		datah.setIndustryPositionValue(industryPositionValue);
		/** 9.3.1主导产业个数（指标）。1:1~3个，3:3~4个，5:4个以上 */
		datah.setLeaderIndustryNumTarget(attribute.getLeadingIndustry());
		/** 9.3.2主导产业个数（分值） */
		datah.setLeaderIndustryNumValue(leadingIndustry);
		/** 9.4.1产品竞争力（指标）。0：好，1：中，2：差 */
		datah.setCompetitivePowerTarget(attribute
				.getProductCompetitiveness());
		/** 9.4.2产品竞争力（分值） */
		datah.setCompetitivePowerValue(productCompetitiveness);
		/** 9.4.2市场竞争力总得分 */
		datah.setMarketCompeteTotalScores(industryPolicyValue
				+ industryPositionValue + leadingIndustry
				+ productCompetitiveness);
		datah.setAllTotalScores(allTotalScores);
		datah.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()));
		analyHDAO.saveDataanaly(datah);
		///////
		ratingResultsh.setCompanyId(epId);
		ratingResultsh.setAttributeId(attirbuteId);
		ratingResultsh.setTotal(allTotalScores);
		ratingResultsh.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()));
		ratingResultsh.setLifecycle(epinfo.getStage() + "");
		ratingResultsh.setCreditId(creditRating.getCreditId());
		ratingResultsh.setOrgNo(epinfo.getOrgNo());
		ratingResultsh.setRating(creditRating.getCreditSymbol());
		ratingHDAO.saveRatingResults(ratingResultsh);
	}
	public void setAttributeDao(AttributeDao attributeDao) {
		this.attributeDao = attributeDao;
	}
	public void setAnalyDAO(DataAnalyDAO analyDAO) {
		this.analyDAO = analyDAO;
	}

	public void setRatingResultsDAO(RatingResultsDAO ratingResultsDAO) {
		this.ratingResultsDAO = ratingResultsDAO;
	}
	
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	
	public void setAnalyHDAO(DataAnalyHDAO analyHDAO) {
		this.analyHDAO = analyHDAO;
	}

	public void setRatingHDAO(RatingResultsHDAO ratingHDAO) {
		this.ratingHDAO = ratingHDAO;
	}


	/**
	 * 根据 企业是否为轻工业返还 boolean类型
	 * 
	 * @return
	 */
	public boolean getBoolean(int value) {
		if (value == 1) {

			return true;
		} else {
			return false;
		}
	}
}

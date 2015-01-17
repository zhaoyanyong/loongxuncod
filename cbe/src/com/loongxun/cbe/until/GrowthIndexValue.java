package com.loongxun.cbe.until;



/**
 * 成长性指标
 * 
 * @author WHB 2014年2月20日 10:46:00 获取成长性指标中每项的指标实际值
 */

public class GrowthIndexValue {
	/**
	 * 总资产增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param EndTotalAssets
	 *            年末资产总额
	 * @param BeginTotalAssets
	 *            年初资产总额
	 * @return 总资产增长率（指标）
	 */
	public static double getTotalAssetGrowRatioTarget(double EndTotalAssets,
			double BeginTotalAssets) {
		if(BeginTotalAssets==0){
			return 0;
		}
		return PublicCompareUtil.choice((EndTotalAssets - BeginTotalAssets)
				/ BeginTotalAssets);

	}

	/**
	 * 总资产增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param EndTotalAssets
	 *            年末资产总额
	 * @param BeginTotalAssets
	 *            年初资产总额
	 * @return 总资产增长率（分值）
	 */
	public static double getTotalAssetGrowRatioValue(int type,
			double EndTotalAssets, double BeginTotalAssets) {
		double TotalAssetGrowRatioTarget = getTotalAssetGrowRatioTarget(
				EndTotalAssets, BeginTotalAssets);
		if (type == 1) {
			return PublicCompareUtil.getScores(1.394, 0.200, 0.100,
					TotalAssetGrowRatioTarget);
		} else if (type == 2) {
			return PublicCompareUtil.getScores(1.394, 0.200, 0.100,
					TotalAssetGrowRatioTarget);
		} else {
			return PublicCompareUtil.getScores(0.297, 0.200, 0.100,
					TotalAssetGrowRatioTarget);
		}

	}

	/**
	 * 净资产增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param BeginNetAssets
	 *            期初净资产
	 * @param EndNetAssets
	 *            期末净资产
	 * @return 净资产增长率（指标志）
	 */
	public static double getNetAssetGrowRatioTarget(double BeginNetAssets,
			double EndNetAssets) {
		if(BeginNetAssets==0){
			return 0;
		}
		return PublicCompareUtil.choice((EndNetAssets - BeginNetAssets)
				/ BeginNetAssets);

	}

	/**
	 * 净资产增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param BeginNetAssets
	 *            期初净资产
	 * @param EndNetAssets
	 *            期末净资产
	 * @return 净资产增长率（分值）
	 */
	public static double getNetAssetGrowRatioValue(int type,
			double BeginNetAssets, double EndNetAssets) {
		double NetAssetGrowRatioTarget = getNetAssetGrowRatioTarget(
				BeginNetAssets, EndNetAssets);
		if (type == 1) {
			return PublicCompareUtil.getScores(3.025, 0.250, 0.100,
					NetAssetGrowRatioTarget);
		} else if (type == 2) {
			return PublicCompareUtil.getScores(3.025, 0.250, 0.100,
					NetAssetGrowRatioTarget);
		} else {
			return PublicCompareUtil.getScores(0.531, 0.250, 0.100,
					NetAssetGrowRatioTarget);
		}
	}

	/**
	 * 总收益增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param BeginBusinessReceipt
	 *            年初营业收入
	 * @param EndBusinessReceipt
	 *            年末营业收入
	 * @param BeginNonrevenueReceipt
	 *            年初营业外收入
	 * @param EndNonrevenueReceipt
	 *            年末营业外收入
	 * @return 总收益增长率（分值）
	 */
	public static double getTotalIncomeGrowRatioTarget(
			double BeginBusinessReceipt, double EndBusinessReceipt,
			double BeginNonrevenueReceipt, double EndNonrevenueReceipt) {
		if( (BeginBusinessReceipt + BeginNonrevenueReceipt)==0){
			return 0;
		}
		return PublicCompareUtil
				.choice((EndBusinessReceipt + EndNonrevenueReceipt
						- BeginBusinessReceipt - BeginNonrevenueReceipt)
						/ (BeginBusinessReceipt + BeginNonrevenueReceipt));

	}

	/**
	 * 总收益增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param BeginBusinessReceipt
	 *            年初营业收入
	 * @param EndBusinessReceipt
	 *            年末营业收入
	 * @param BeginNonrevenueReceipt
	 *            年初营业外收入
	 * @param EndNonrevenueReceipt
	 *            年末营业外收入
	 * @return 总收益增长率（指标值）
	 */
	public static double getTotalIncomeGrowRatioValue(int type,
			double BeginBusinessReceipt, double EndBusinessReceipt,
			double BeginNonrevenueReceipt, double EndNonrevenueReceipt) {
		double TotalIncomeGrowRatioTarget = getTotalIncomeGrowRatioTarget(
				BeginBusinessReceipt, EndBusinessReceipt,
				BeginNonrevenueReceipt, EndNonrevenueReceipt);
		if (type == 1) {
			return PublicCompareUtil.getScores(1.394, 0.200, 0.100,
					TotalIncomeGrowRatioTarget);
		} else if (type == 2) {
			return PublicCompareUtil.getScores(1.394, 0.200, 0.100,
					TotalIncomeGrowRatioTarget);
		} else {
			return PublicCompareUtil.getScores(0.297, 0.200, 0.100,
					TotalIncomeGrowRatioTarget);
		}
	}

	/**
	 * 净利润增长率
	 * 
	 * @param BeginBusinessReceipt
	 *            年初营业收入
	 * @param EndBusinessReceipt
	 *            年末营业收入
	 * @param BeginNonrevenueReceipt
	 *            年初营业外收入
	 * @param EndNonrevenueReceipt
	 *            年末营业外收入
	 * @return 总收益增长率（指标值）
	 */
	public static double getNetIncomeGrowRatioTarget(double LastTotalProfit,
			double LastIncomeTax, double TotalProfit, double IncomeTax) {
		if((LastTotalProfit - LastIncomeTax)==0){
			return 0;
		}else{
		return PublicCompareUtil
				.choice(((TotalProfit - IncomeTax) - (LastTotalProfit - LastIncomeTax))
						/ (LastTotalProfit - LastIncomeTax));}

	}

	/**
	 * 净利润增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param BeginBusinessReceipt
	 *            年初营业收入
	 * @param EndBusinessReceipt
	 *            年末营业收入
	 * @param BeginNonrevenueReceipt
	 *            年初营业外收入
	 * @param EndNonrevenueReceipt
	 *            年末营业外收入
	 * @return 总收益增长率（分值）
	 */
	public static double getNetIncomeGrowRatioValue(int type,
			double LastTotalProfit, double LastIncomeTax, double TotalProfit,
			double IncomeTax) {
		double NetIncomeGrowRatioTarget = getNetIncomeGrowRatioTarget(
				LastTotalProfit, LastIncomeTax, TotalProfit, IncomeTax);
		if (type == 1) {
			return PublicCompareUtil.getScores(3.025, 0.200, 0.100,
					NetIncomeGrowRatioTarget);
		} else if (type == 2) {
			return PublicCompareUtil.getScores(3.025, 0.200, 0.100,
					NetIncomeGrowRatioTarget);
		} else {
			return PublicCompareUtil.getScores(0.531, 0.200, 0.100,
					NetIncomeGrowRatioTarget);
		}
	}

	/**
	 * 主营业务利润率增长
	 * 
	 * @param BeginMainOperationIncome
	 *            年初主营业务收入
	 * @param EndMainOperationIncome
	 *            年末主营业务收入
	 * @param BeginCostOfSales
	 *            年初主营业务成本
	 * @param EndCostOfSales
	 *            年末主营业务成本
	 * @param BeginSalesTax
	 *            年初主营业务税金及附加
	 * @param EndSalesTax
	 *            年末主营业务税金及附加
	 * @return 主营业务利润率增长（分值）
	 * 16000.0**24000.0**1000.0**16000.0**400.0**800.0
	 */
	public static double getMainBusProfitGrowTarget(
			double BeginMainOperationIncome, double EndMainOperationIncome,
			double BeginCostOfSales, double EndCostOfSales,
			double BeginSalesTax, double EndSalesTax) {
		if(EndMainOperationIncome==0){
			return 0;
		}else if(BeginMainOperationIncome==0){
			return PublicCompareUtil.choice((EndMainOperationIncome- EndCostOfSales - EndSalesTax)/ EndMainOperationIncome);
		}
		return PublicCompareUtil.choice(((EndMainOperationIncome- EndCostOfSales - EndSalesTax)/ EndMainOperationIncome)- 
				((BeginMainOperationIncome - BeginCostOfSales - BeginSalesTax)/ BeginMainOperationIncome));

	}

	/**
	 * 主营业务利润率增长
	 * 
	 * @param type
	 *            成长类型
	 * @param BeginMainOperationIncome
	 *            年初主营业务收入
	 * @param EndMainOperationIncome
	 *            年末主营业务收入
	 * @param BeginCostOfSales
	 *            年初主营业务成本
	 * @param EndCostOfSales
	 *            年末主营业务成本
	 * @param BeginSalesTax
	 *            年初主营业务税金及附加
	 * @param EndSalesTax
	 *            年末主营业务税金及附加
	 * @return 主营业务利润率增长（指标值）
	 */
	public static double getMainBusProfitGrowValue(int type,
			double BeginMainOperationIncome, double EndMainOperationIncome,
			double BeginCostOfSales, double EndCostOfSales,
			double BeginSalesTax, double EndSalesTax) {
		double MainBusProfitGrowTarget = getMainBusProfitGrowTarget(
				BeginMainOperationIncome, EndMainOperationIncome,
				BeginCostOfSales, EndCostOfSales, BeginSalesTax, EndSalesTax);
		if (type == 1) {
			return PublicCompareUtil.getScores(1.394, 0.300, 0.050,
					MainBusProfitGrowTarget);
		} else if (type == 2) {
			return PublicCompareUtil.getScores(1.394, 0.300, 0.050,
					MainBusProfitGrowTarget);
		} else {
			return PublicCompareUtil.getScores(0.297, 0.300, 0.050,
					MainBusProfitGrowTarget);
		}
	}

	/**
	 * 员工数量增长率
	 * 
	 * @param EmployeNumCurrentYear
	 *            本年员工数
	 * @param EmployeNumLastYear
	 *            上年员工数
	 * @param EmployeeGrowRatioTarget
	 *            员工数量增长率
	 * @return 员工数量增长率（指标值）
	 * 80**96
	 */
	public static double getEmployeeGrowRatioTarget(int EmployeNumLastYear,
			int EmployeNumCurrentYear) {
		if(EmployeNumLastYear==0){
			return 0;
		}else{
			return PublicCompareUtil.choice((EmployeNumCurrentYear - EmployeNumLastYear)*1.0/ EmployeNumLastYear);
		}
	}

	/**
	 * 员工数量增长率
	 * 
	 * @param type
	 *            成长类型
	 * @param EmployeNumCurrentYear
	 *            本年员工数
	 * @param EmployeNumLastYear
	 *            上年员工数
	 * @param EmployeeGrowRatioTarget
	 *            员工数量增长率
	 * @return 员工数量增长率（分值）
	 */
	public static double getEmployeeGrowRatioValue(int type,
			int EmployeNumLastYear, int EmployeNumCurrentYear) {
		double EmployeeGrowRatioTarget = getEmployeeGrowRatioTarget(
				EmployeNumLastYear, EmployeNumCurrentYear);
		if (type == 1) {
			return PublicCompareUtil.getScores(3.629, 0.150, 0.050,
					EmployeeGrowRatioTarget);
		} else if (type == 2) {
			return PublicCompareUtil.getScores(3.629, 0.150, 0.050,
					EmployeeGrowRatioTarget);
		} else {
			return PublicCompareUtil.getScores(0.191, 0.150, 0.050,
					EmployeeGrowRatioTarget);
		}
	}
	

	/**
	 * @Effect 企业家年龄段求分值方法
	 * @Time 2014年2月21日 11:51:38
	 * @Author whb
	 * @param type 企业类型
	 * @param EuntreponierAgeTarget 年龄段
	 * @return 分值
	 */
	public static double getEuntreponierAgeValue(int type ,int EuntreponierAgeTarget){
		double h ;
		if(type==1 || type==2){
			h=0.907;
			}else {
				h=0.048;
			}
		if(EuntreponierAgeTarget==1){
			return PublicCompareUtil.choice(h);
		}else {
			return 0.000;
		}
	}
	
	
	/**
	 * @Effect 企业家学历求分值方法
	 * @Time 2014年2月21日 11:51:38
	 * @Author whb
	 * @param type 企业类型
	 * @param EuntreponierDegreeTarget 企业家学历
	 * @return 分值
	 */
	public static double getEuntreponierDegreeValue(int type ,int EuntreponierDegreeTarget){
		double h ;
		if(type==1 || type==2){
			h=0.907;
			}else {
				h=0.048;
			}
		//修改对应算法应减去的值
		if(EuntreponierDegreeTarget==4){
			return 0.000;
		}else if(EuntreponierDegreeTarget==3){
			return PublicCompareUtil.choice(h-0.04);
		}else if(EuntreponierDegreeTarget==2){
			return PublicCompareUtil.choice(h-0.03);
		}else if(EuntreponierDegreeTarget==1){
			return PublicCompareUtil.choice(h-0.015);
		}else{
			return PublicCompareUtil.choice(h);
		}
	}
	
	
	/**
	 * @Effect 企业家工作时间求分值方法
	 * @Time 2014年2月21日 11:51:38
	 * @Author whb
	 * @param type 企业类型
	 * @param EuntreponierWorkTimeTarget 企业家工作时间
	 * @return 分值
	 */
	public static double getEuntreponierWorkTimeValue(int type ,Double EuntreponierWorkTimeTarget){
		double h ; int i=10; int j = 0;
		if(type==1 || type==2){
			h=0.907;
		}else {
			h=0.048;
		}
		return PublicCompareUtil.getScores(h, 10.0, EuntreponierWorkTimeTarget);
		
	}
	
	
	/**
	 * @Effect 企业家知名度求分值方法
	 * @Time 2014年2月21日 11:51:38
	 * @Author whb
	 * @param type 企业类型
	 * @param EuntreponierPopularyTarget 企业家知名度
	 * @return 分值
	 */
	public static double getEuntreponierPopularyValue(int type ,int EuntreponierPopularyTarget){
		double h ;
		if(type==1 || type==2){
			h=0.907;
			}else {
				h=0.048;
			}
		if(EuntreponierPopularyTarget==0){
			return PublicCompareUtil.choice(h);
		}else if(EuntreponierPopularyTarget==1){
			return PublicCompareUtil.choice(h-0.02);
		}else if(EuntreponierPopularyTarget==2){
			return PublicCompareUtil.choice(h-0.04);
		}else{
			return 0.000;
		}
	}
	/**
	 * 企业发展规划
	 * 
	 * @param h
	 *            对整体指标权数（指标满分值）
	 * @param DevelopPlanTarget
	 *            企业发展规划（指标）
	 */
	public static double getEnterpriseExpansionProjectsValue(int type,
			boolean DevelopPlanTarget) {
		double h;
		if (type == 1 || type == 2) {
			h = 3.025;
		} else {
			h = 0.191;
		}
		if (DevelopPlanTarget) {
			return PublicCompareUtil.choice(h);
		} else {
			return 0.000;
		}
	}

	/**
	 * 产品长期发展战略
	 * 
	 * @param type
	 *            成长类型
	 * @param h
	 *            对整体指标权数（指标满分值）
	 * @param DevelopStrategyTarget
	 *            长期发展战略（指标）
	 * @return
	 */
	public static double getProducLongTermDevelopmentValue(int type,
			boolean DevelopStrategyTarget) {
		double h;
		if (type == 1 || type == 2) {
			h = 1.394;
		} else {
			h = 0.191;
		}
		if (DevelopStrategyTarget) {
			return PublicCompareUtil.choice(h);
		} else {
			return 0.000;
		}
	}

	/**
	 * 产品质量认证
	 * 
	 * @param type
	 *            成长类型
	 * @param h
	 *            对整体指标权数（指标满分值）
	 * @param QualityCertificateTarget
	 *            产品质量认证（指标）
	 * @return
	 */
	public static double getProductQualityCertificationValue(int type,
			boolean QualityCertificateTarget) {
		double h;
		if (type == 1 || type == 2) {
			h = 1.394;
		} else {
			h = 0.297;
		}
		if (QualityCertificateTarget) {
			return PublicCompareUtil.choice(h);
		} else {
			return 0.000;
		}
	}

	/**
	 * 产业（阶段）性质
	 * 
	 * @param type
	 *            成长类型
	 * @param h
	 *            对整体指标权数（指标满分值）
	 * @param IndustryNatureTarget
	 *            产业（阶段）性质（指标）
	 * @return
	 */
	public static double getLndustryPropertiesValue(int type,
			int IndustryNatureTarget) {
		double h = 0;
		if (type == 1 || type == 2) {
			h = 3.025;
		} else {
			h = 0.191;
		}
		if (IndustryNatureTarget == 0) {
			return PublicCompareUtil.choice(0);
		}
		if (IndustryNatureTarget == 1) {
			return PublicCompareUtil.choice(h / 2);
		} else {
			return PublicCompareUtil.choice(h);
		}
	}
}

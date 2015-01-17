package com.loongxun.cbe.until;

import java.math.BigDecimal;

/**
 * 文件名：营运能力计算公式
 * 作者：王传伟
 * 描述：计算公司营运能力有关的公式
 * 方法名规则：Operating，取首字母；加上方法名:总资产周转率Total assets turnover；
 * 公司类型规则：1——初创型
 *         2——成长性
 *         3——稳定性
 * 版本：1.0
 * 时间：2014-2-20 11:06:46
 *
 */

public class OperationalCapacity {
	
	/**
	 * 分值的计算公式，对应表里的h、i、j、k列
	 * @param h   对总体指标权数（指标满分值）
	 * @param i   满意值
	 * @param j   不允许值
	 * @param k   指标实际值
	 * @return
	 */
	public static double getScores(double h,double i,double j,double k){
		if(k >= i){
			return h;
		}else if(k <= j){
			return 0;
		}else{
			return (k - j)/(i - j) * h;
		}
	}
	/**
	 * 保留三位小数使用的方法
	 * @param arg
	 * @return
	 */
	public static Double choice(double arg){
		 BigDecimal b = new BigDecimal(arg);
		 double f1 = b.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		 return f1;
	}
    
	/**
	 * 1、总资产周转率  Total assets turnover；  比率  指标实际值
	 * 计算公式：总资产周转率=销售收入/总资产														
	 * @param sales   销售收入
	 * @param totalAssets   总资产
	 * 
	 */
	public static double OTotalAssetsTurnoverTarget(double sales,double totalAssets){
		if(totalAssets==0){
			return 0;
		}
		return choice(sales/totalAssets);			
	}
	
	/**
	 * 1、总资产周转率  Total assets turnover； 得分值
	 * 计算公式：总资产周转率=销售收入/总资产
	 * @param CompanyType   公司类型														
	 * @param sales   销售收入
	 * @param totalAssets   总资产
	 * 
	 */
	public static double OTotalAssetsTurnoverValue(int CompanyType,double sales,double totalAssets){
		if(totalAssets==0){
			return 0;
		}
		if(CompanyType == 1){
			double d =  getScores(1.034,1,0.2,sales/totalAssets);
			return choice(d);
		}else if(CompanyType == 2){
			double d =  getScores(1.034,1,0.2,sales/totalAssets);
			return choice(d);
		}else{
			double d =  getScores(0.923,1,0.2,sales/totalAssets);
			return choice(d);
		}
	
	}
	
	/**
	 * 2、流动资产周转率  Current Assets Turnover   比率  指标实际值
	 * 计算公式1：流动资产周转率 =主营业务收入净额/平均流动资产总额  
	 * 计算公式2：平均流动资产总额  =（年初流动资产总额+年末流动资产总额）/2													
	 * @param netIncomeFromPrincipalOperations   主营业务收入净额
	 * @param Average Total current assets   平均流动资产总额
	 * @param beginTotalCurrentAssets 年初流动资产总额  
	 * @param endTotalCurrentAssets 年末流动资产总额  
	 */
	public static double OCurrentAssetsTurnoverTarget(
			double netIncomeFromPrincipalOperations,
			double beginTotalCurrentAssets,
			double endTotalCurrentAssets){
		if(((endTotalCurrentAssets+beginTotalCurrentAssets)/2)==0){
			return 0;
		}
		return choice(netIncomeFromPrincipalOperations/((endTotalCurrentAssets+beginTotalCurrentAssets)/2));		
	}
	
	/**
	 * 2、流动资产周转率  Current Assets Turnover     得分值
	 * 计算公式1：流动资产周转率 =主营业务收入净额/平均流动资产总额  
	 * 计算公式2：平均流动资产总额  =（年初流动资产总额+年末流动资产总额）/2
	 * @param CompanyType   公司类型														
	 * @param netIncomeFromPrincipalOperations   主营业务收入净额
	 * @param Average Total current assets   平均流动资产总额
	 * @param beginTotalCurrentAssets 年初流动资产总额  
	 * @param endTotalCurrentAssets 年末流动资产总额  
	 */
	public static double OCurrentAssetsTurnoverValue(int CompanyType,
			double netIncomeFromPrincipalOperations,
			double beginTotalCurrentAssets,
			double endTotalCurrentAssets){
		if(((endTotalCurrentAssets+beginTotalCurrentAssets)/2)==0){
			return 0;
		}
		if(CompanyType == 1){
			double d = 
			 getScores(1.034,3,1,
					netIncomeFromPrincipalOperations/((endTotalCurrentAssets+beginTotalCurrentAssets)/2));	
			return choice(d);
		}else if(CompanyType == 2){
			double d =  getScores(1.034,3,1,
					netIncomeFromPrincipalOperations/((endTotalCurrentAssets+beginTotalCurrentAssets)/2));	
			return choice(d);
		}else{
			double d =  getScores(0.923,3,1,
					netIncomeFromPrincipalOperations/((endTotalCurrentAssets+beginTotalCurrentAssets)/2));
			return choice(d);
		}
	}
	/**
	 * 3、固定资产周转率 Fixed asset turnover  比率  指标实际值
	 * 计算公式：固定资产周转率=销售收入\固定资产		
	 * @param sales   销售收入
	 * @param fixedAssets   固定资产											
	 */
		public static double OFixedAssetTurnoverTarget(double sales,double fixedAssets){
			if(fixedAssets==0){
				return 0;
			}
			return choice(sales/fixedAssets);			
		}
	/**
	 * 3、固定资产周转率 Fixed asset turnover    得分值
	 * 计算公式：固定资产周转率=销售收入\固定资产		
	 * @param CompanyType   公司类型
	 * @param sales   销售收入
	 * @param fixedAssets   固定资产											
	 */
		public static double OFixedAssetTurnoverValue(
				int CompanyType,double sales,double fixedAssets){
			if(fixedAssets==0){
				return 0;
			}
			if(CompanyType == 1){
				double d =  getScores(1.034,1,0,sales/fixedAssets);
				return choice(d);
			}else if(CompanyType == 2){
				double d =  getScores(1.034,1,0,sales/fixedAssets);
				return choice(d);
			}else{
				double d =  getScores(0.923,1,0,sales/fixedAssets);
				return choice(d);
			}
		}
		
	/**
	 * 4、应收帐款周转率 Accounts receivable turnover ratio   比率  指标实际值
	 * 计算公式：应收帐款周转率  =销售收入/{（年初应收账款总额+年末应收账款总额）/2}	
	 * @param sales   销售收入
	 * @param totalAccountsReceivableInEarly   年末应收账款总额
	 * @param totalAccountsReceivableAtTheEndOf   年末应收账款总额												
	 */
		public static double OAccountsReceivableTurnoverRatioTarget(
				double sales,double totalAccountsReceivableInEarly,double totalAccountsReceivableAtTheEndOf){
			if(((totalAccountsReceivableInEarly+totalAccountsReceivableAtTheEndOf)/2)==0){
				return 0;
			}
			return choice(sales/((totalAccountsReceivableInEarly+totalAccountsReceivableAtTheEndOf)/2));			
		}
		
		/**
		 * 4、应收帐款周转率 Accounts receivable turnover ratio    得分值
		 * 计算公式：应收帐款周转率  =销售收入/{（年初应收账款总额+年末应收账款总额）/2}	
		 * @param CompanyType   公司类型
		 * @param sales   销售收入
		 * @param totalAccountsReceivableInEarly   年末应收账款总额
		 * @param totalAccountsReceivableAtTheEndOf   年末应收账款总额												
		 */
			public static double OAccountsReceivableTurnoverRatioValue(
					int CompanyType,double sales,
					double totalAccountsReceivableInEarly,double totalAccountsReceivableAtTheEndOf){
				if(((totalAccountsReceivableInEarly+totalAccountsReceivableAtTheEndOf)/2)==0){
					return 0;
				}
				if(CompanyType == 1){
					double d =  getScores(1.034,10,3,
							sales/((totalAccountsReceivableInEarly+totalAccountsReceivableAtTheEndOf)/2));	
					return choice(d);
				}else if(CompanyType == 2){
					double d =  getScores(1.034,10,3,
							sales/((totalAccountsReceivableInEarly+totalAccountsReceivableAtTheEndOf)/2));
					return choice(d);
				}else{
					double d =  getScores(0.923,10,3,
							sales/((totalAccountsReceivableInEarly+totalAccountsReceivableAtTheEndOf)/2));
					return choice(d);
				}
			}
	/**
	 * 5、存货周转率 Inventory Turnover  比率  指标实际值
	 * 计算公式：存货周转率 =销售成本/{（年初存货+年末存货）/2}
	 * @param costOfSales   销售成本	
	 * @param OpeningInventory   年初存货	
	 * @param endingInventory   年末存货													
	 */
	public static double OInventoryTurnoverTarget(
			double costOfSales,double OpeningInventory,double endingInventory){	
		if(((OpeningInventory+endingInventory)/2)==0){
			return 0;
		}
		return choice(costOfSales/((OpeningInventory+endingInventory)/2));		
	}
	/**
	 * 5、存货周转率 Inventory Turnover    得分值
	 * 计算公式：存货周转率 =销售成本/{（年初存货+年末存货）/2}
	 * @param CompanyType   公司类型	
	 * @param costOfSales   销售成本	
	 * @param OpeningInventory   年初存货	
	 * @param endingInventory   年末存货													
	 */
	public static double OInventoryTurnoverValue(
			int CompanyType,double costOfSales,double OpeningInventory,double endingInventory){
		if(((OpeningInventory+endingInventory)/2)==0){
			return 0;
		}
		if(CompanyType == 1){
			double d =  getScores(1.034,8,1.25,costOfSales/((OpeningInventory+endingInventory)/2));
			return choice(d);
		}else if(CompanyType == 2){
			double d =  getScores(1.034,8,1.25,costOfSales/((OpeningInventory+endingInventory)/2));
			return choice(d);
		}else{
			double d =  getScores(0.923,8,1.25,costOfSales/((OpeningInventory+endingInventory)/2));
			return choice(d);
		}
	}
	/**
	 * 6、资产保值增长率  Increasing the growth rate of assets   比率  指标实际值
	 * 计算公式：资产保值增长率=年末所有者权益/年初所有者权益	
	 * @param OwnerEquityAtTheEnd   年末所有者权益
	 * @param OwnerEquityAtTheBegin   年初所有者权益														
	 */
	public static double OIncreasingGrowthRateOfAssetsTarget(
			double OwnerEquityAtTheEnd,double OwnerEquityAtTheBegin){		
		if(OwnerEquityAtTheBegin==0){
			return 0;
		}
		return choice(OwnerEquityAtTheEnd/OwnerEquityAtTheBegin);		
	}
	/**
	 * 6、资产保值增长率  Increasing the growth rate of assets    得分值
	 * 计算公式：资产保值增长率=年末所有者权益/年初所有者权益	
	 * @param CompanyType   公司类型	
	 * @param OwnerEquityAtTheEnd   年末所有者权益
	 * @param OwnerEquityAtTheBegin   年初所有者权益														
	 */
	public static double OIncreasingGrowthRateOfAssetsValue(
			int CompanyType,double OwnerEquityAtTheEnd,double OwnerEquityAtTheBegin){
		if(OwnerEquityAtTheBegin==0){
			return 0;
		}
		if(CompanyType == 1){
			double d =  getScores(1.034,1.2,1.0,OwnerEquityAtTheEnd/OwnerEquityAtTheBegin);
			return choice(d);
		}else if(CompanyType == 2){
			double d =  getScores(1.034,1.2,1.0,OwnerEquityAtTheEnd/OwnerEquityAtTheBegin);
			return choice(d);
		}else{
			double d =  getScores(0.923,1.2,1.0,OwnerEquityAtTheEnd/OwnerEquityAtTheBegin);
			return choice(d);
		}
	}
	/**
	 * 7、销售收入增长率  Sales revenue growth    比率  指标实际值
	 * 计算公式：销售收入增长率=（新的销售额-原销售额）/原销售额
	 * @param nowSales   新的销售额
	 * @param everSales  原销售额
	 * 													
	 */
	public static double OSalesRevenueGrowthTarget(double nowSales,double everSales){	
		if(everSales==0){
			return 0;
		}
		return choice((nowSales-everSales)/everSales);	
	}
	/**
	 * 7、销售收入增长率  Sales revenue growth    得分值
	 * 计算公式：销售收入增长率=（新的销售额-原销售额）/原销售额
	 * @param CompanyType   公司类型	
	 * @param nowSales   新的销售额
	 * @param everSales  原销售额
	 * 													
	 */
	public static double OSalesRevenueGrowthValue(int CompanyType,double nowSales,double everSales){
		if(everSales==0){
			return 0;
		}
		if(CompanyType == 1){
			double d =  getScores(3.101,0.1,0.03,(nowSales-everSales)/everSales);	
			return choice(d);
		}else if(CompanyType == 2){
			double d =  getScores(3.101,0.1,0.03,(nowSales-everSales)/everSales);
			return choice(d);
		}else{
			double d =  getScores(2.768,0.1,0.03,(nowSales-everSales)/everSales);
			return choice(d);
		}		
	}

}

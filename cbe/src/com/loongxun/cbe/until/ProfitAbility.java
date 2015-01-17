package com.loongxun.cbe.until;

import java.math.BigDecimal;

/**
 * 盈利能力
 * @author swj
 *
 */
public class ProfitAbility {
	/**
	 * 保留三位小数
	 * @param arg
	 * @return
	 */
	public static Double choice(double arg){
		 BigDecimal b = new BigDecimal(arg);
		 double f1 = b.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		 return f1;
	}
	
	
	/**
	 * 计算盈利分值的方法：
	 * 分值=IF(K>=I,H,IF(K<=J,0,(K-J)/(I-J)*H))
	 * @param f:2级指标权重
	 * @param g：对总体目标权重
	 * @param h：对总体指标权数
	 * @param i：满意值
	 * @param j：不允许值
	 * @param k：指标实际值（各种比率）
	 * @return
	 */
	public static double a2(double f,double g,double h,double i,double j,double k){
		double  pef;//分值
		if(k>=i){
			pef=choice(h);
		}else if(k<=j){
			pef=0;
		}else{
			pef=choice((k-j)/(i-j)*h);
		}
		return choice(pef);		
	}
	/**
	 * 1、计算总资产报酬率：
	 * 总资产报酬率=（利息总额+利息支出）/平均资产总额              平均资产总额=（年初资产总额+年末资产总额）/2
	 *
	 * @param BeginTotalAssets：年初资产总额
	 * @param EndTotalAssets： 年末资产总额
	 * @param grossInterest：利息总额
	 * @param interestExchange：利息支出
	 * @return  总资产报酬率
	 */
	public static double getAssetsRate(double beginTotalAssets,double endTotalAssets,
			double grossInterest,double interestExchange){
		double averageAssets=(beginTotalAssets+endTotalAssets)/2;//得到平均资产总额
		if(averageAssets==0){
			return 0;
		}
		double assetsRate=(grossInterest+interestExchange)/averageAssets;//得到总资产报酬率
		double k=choice(assetsRate);//调用函数使总资产报酬率保留三位小数
	   
		return k;
	}
	/**
	 * 计算总资产报酬率的分值：
	 * 总资产报酬率=（利息总额+利息支出）/平均资产总额              平均资产总额=（年初资产总额+年末资产总额）/2
	 *算出总资产报酬率再调用计算分值的方法。
	 * @param type：成长类型    type=1:初创型；type=2：成长型；type=3:稳定性
	 * @param BeginTotalAssets：年初资产总额
	 * @param EndTotalAssets： 年末资产总额
	 * @param grossInterest：利息总额
	 * @param interestExchange：利息支出
	 * @return  总资产报酬率的分值
	 */
	public static double getAssetsRateScore(int type,double beginTotalAssets,double endTotalAssets,
			double grossInterest,double interestExchange){
		double averageAssets=(beginTotalAssets+endTotalAssets)/2;//得到平均资产总额
		if(averageAssets==0){
			return 0;
		}
		double assetsRate=(grossInterest+interestExchange)/averageAssets;//得到总资产报酬率
		System.out.println("assetsRate"+assetsRate);
		double k=choice(assetsRate);//调用函数使总资产报酬率保留三位小数
	   if(type==1){
		   double pef=choice(a2(0.230690914743614,0.008,0.760,0.100,0.020,k));
		   return pef;
	   }else if(type==2){
		   double pef=choice(a2(0.230690914743614,0.021,2.145,0.100,0.020,k));
		   return pef;
	   }else{
		   double pef=choice(a2(0.230690914743614,0.054,5.375,0.100,0.020,k));
		   return pef;
	   }
	
		
	}
	/**
	 * 2、计算净资产收益率：
	 * 净资产收益率=税后净利润/净资产
	 * @param NetIncomeRetainedAfterTax:税后净利润
	 * @param netAssets：净资产
	 * @return 净资产收益率
	 */
	public static double getRona(double netIncomeRetainedAfterTax,double netAssets){
		if(netAssets==0){
			return 0;
		}
		double rona=netIncomeRetainedAfterTax/netAssets;//净资产收益率
		double k=choice(rona);//保留三位小数
		return k;
		
	}
	/**
	 * 计算净资产收益率的分值：
	 * 净资产收益率=税后净利润/净资产
	 * @param type：成长类型  type=1:初创型；type=2：成长型；type=3:稳定性
	 * @param NetIncomeRetainedAfterTax:税后净利润
	 * @param netAssets：净资产
	 * @return 净资产收益率的分值
	 */
	public static double getRonaScore(int type,double netIncomeRetainedAfterTax,double netAssets){
		if(netAssets==0){
			return 0;
		}
		double rona=netIncomeRetainedAfterTax/netAssets;//净资产收益率
		double k=choice(rona);//保留三位小数
		if(type==1){
			   double pef=choice(a2(0.230690914743614,0.008,0.761,0.150,0.010,k));
			   return pef;
		   }
		   else if(type==2){
			   double pef=choice(a2(0.230690914743614,0.021,2.145,0.150,0.010,k));
			   return pef;
		   }
		   else{
			   double pef=choice(a2(0.230690914743614,0.054,5.375,0.150,0.010,k));
			   return pef;
		   }
		
		
	}
	/**
	 * 3、计算成本费用利用率：
	 * 成本费用利用率=利润总额/成本费用总额
	 * @param totalProfit：利润总额
	 * @param totalCost：成本费用总额
	 * @return 成本费用利用率
	 */
	public static double getCostEfficiency(double totalProfit,double totalCost ){
		if(totalCost==0){
			return 0;
		}
		double costEfficiency=totalProfit/totalCost;//成本费用利用率
		double k=choice(costEfficiency);//保留三位小数	
		return k;
		}
	/**
	 * 计算成本费用利用率的分值：
	 * 成本费用利用率=利润总额/成本费用总额
	 * @param type：成长类型   type=1:初创型；type=2：成长型；type=3:稳定性
	 * @param totalProfit：利润总额
	 * @param totalCost：成本费用总额
	 * @return 成本费用利用率的分值
	 */
	public static double getCostEfficiencyScore(int type,double totalProfit,double totalCost ){
		if(totalCost==0){
			return 0;
		}
		double costEfficiency=totalProfit/totalCost;//成本费用利用率
		double k=choice(costEfficiency);//保留三位小数
		if(type==1){
			   double pef=choice(a2(0.230690914743614,0.008,0.761,0.200,0.000,k));
			   return pef;
		   }
		   else if(type==2){
			   double pef=choice(a2(0.230690914743614,0.021,2.145,0.200,0.000,k));
			   return pef;
		   }
		   else{
			   double pef=choice(a2(0.230690914743614,0.054,5.375,0.200,0.000,k));
			   return pef;
		   }
	
		}
	/**
	 * 4、计算主营业务利润率：
	 * 主营业务利润率=（主营业务收入-主营业务成本-主营业务税金及附加）/主营业务收入
	 * @param MainOperationIncome：主营业务收入
	 * @param CostOfSales：主营业务成本
	 * @param SalesTax：主营业务税金及附加
	 * @return  主营业务利润率
	 */
	public static double getMainProfitRate(double mainOperationIncome,double costOfSales,double salesTax ){
		if(mainOperationIncome==0){
			return 0;
		}
		double mainProfitRate=(mainOperationIncome-costOfSales-salesTax)/mainOperationIncome;//得出主营业务利润率
		double k=choice(mainProfitRate);//保留三位小数
		return k;
		
	}
	/**
	 * 计算主营业务利润率的分值：
	 * 主营业务利润率=（主营业务收入-主营业务成本-主营业务税金及附加）/主营业务收入
	 * @param type：成长类型   type=1:初创型；type=2：成长型；type=3:稳定性
	 * @param MainOperationIncome：主营业务收入
	 * @param CostOfSales：主营业务成本
	 * @param SalesTax：主营业务税金及附加
	 * @return  主营业务利润率的分值
	 */
	public static double getMainProfitRateScore(int type,double mainOperationIncome,double costOfSales,double salesTax ){
		if(mainOperationIncome==0){
			return 0;
		}
		double mainProfitRate=(mainOperationIncome-costOfSales-salesTax)/mainOperationIncome;//得出主营业务利润率
		double k=choice(mainProfitRate);//保留三位小数
		if(type==1){
			   double pef=choice(a2(0.230690914743614,0.008,0.761,0.200,0.050,k));
			   return pef;
		   }
		   else if(type==2){
			   double pef=choice(a2(0.230690914743614,0.021,2.145,0.200,0.050,k));
			   return pef;
		   }
		   else{
			   double pef=choice(a2(0.230690914743614,0.054,5.375,0.200,0.050,k));
			   return pef;
		   }
		
	}
	/**
	 * 5、计算销售利润率：
	 * 销售利润率=利润总额/营业收入
	 * @param totalProfit：利润总额
	 * @param OperatingReceipt：营业收入
	 * @return 销售利润率
	 */
	public static double getNetProfitRatio(double totalProfit,double operatingReceipt){
		if(operatingReceipt==0){
			return 0;
		}
		double  netProfitRatio=totalProfit/operatingReceipt;//得到销售利润率
		double k=choice(netProfitRatio);//保留三位小数
		return k;
		
	}
	/**
	 * 计算销售利润率的分值：
	 * 销售利润率=利润总额/营业收入
	 * @param type：成长类型   type=1:初创型；type=2：成长型；type=3:稳定性
	 * @param totalProfit：利润总额
	 * @param OperatingReceipt：营业收入
	 * @return 销售利润率的分值
	 */
	public static double getNetProfitRatioScore(int type,double totalProfit,double operatingReceipt){
		if(operatingReceipt==0){
			return 0;
		}
		double  netProfitRatio=totalProfit/operatingReceipt;//得到销售利润率
		double k=choice(netProfitRatio);//保留三位小数
		if(type==1){
			   double pef=choice(a2(0.0768969715812048,0.003,0.254,0.100,0.060,k));
			   return pef;
		   }
		   else if(type==2){
			   double pef=choice(a2(0.0768969715812048,0.007,0.715,0.100,0.060,k));
			   return pef;
		   }
		   else{
			   double pef=choice(a2(0.0768969715812048,0.018,1.792,0.100,0.060,k));
			   return pef;
		   }
		
	}
	
}

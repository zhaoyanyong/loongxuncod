package com.loongxun.cbe.until;

import java.math.BigDecimal;


/**
 * 信用履约能力指标各项分值计算公式
 * @author zhs
 *
 */
public class CreditPerformancePowerUtil {
	/**
	 * 分值的计算公式
	 * @param h   对总体指标权数（指标满分值）
	 * @param i   满意值
	 * @param j   不允许值
	 * @param k   指标实际值
	 * @return 分值
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
	
	
	
	public static double getScores1(double h,double i,double j,double k){
		if(k <= i){
			return h;
		}else if(k >= j){
			return 0;
		}else{
			return (j -k )/(j - i) * h;
		}
	}
	/**
	 * 利息偿付率指标实际值计算公式
	 * @param totalTaxProfit 企业税后利润总额
	 * @param incomeTax 所得税
	 * @param capitalCharges 利息费用
	 * @return 利息偿付率
	 */
	public static double getInterestCoverageRate(double totalTaxProfit,
			double incomeTax,double capitalCharges){
		if(capitalCharges==0){
			return 0;
		}
		double interestCoverageRate = choice((totalTaxProfit+incomeTax+capitalCharges)/capitalCharges);
		return interestCoverageRate;
	}
	/**
	 * @param companyType 公司类型
	 * @return 利息偿付率分值
	 */
	public static double getInterestCoverageRateScores(
			int companyType,double interestCoverageRate){
		
		if(companyType == 1){
			double d =  getScores(2.325,1,0.8,interestCoverageRate);
			return choice(d);
		}else if(companyType == 2){
			double d =  getScores(2.325,1,0.8,interestCoverageRate);
			return choice(d);
		}else{
			double d =  getScores(5.825,1,0.8,interestCoverageRate);
			return choice(d);
		}
	}
	
	/**
	 * 贷款逾期率指标实际值计算公式
	 * @param overdueLoans 逾期贷款总额
	 * @param loanCeiling 贷款总额
	 * @return 贷款逾期率
	 */
	public static double getOverdueLoansRate(double overdueLoans,double loanCeiling){
		if(loanCeiling==0){
			return 0;
		}
		double overdueLoansRate = choice(overdueLoans/loanCeiling);
		return overdueLoansRate;
	}
	/**
	 * @param companyType 公司类型
	 * @return 贷款逾期率分值
	 */
	public static double getOverdueLoansRateScores(
			int companyType,double overdueLoansRate){
		if(companyType == 1){
			double d =  getScores1(2.325,0,0.08,overdueLoansRate);
			return choice(d);
		}else if(companyType == 2){
			double d =  getScores1(2.325,0,0.08,overdueLoansRate);
			return choice(d);
		}else{
			double d =  getScores1(5.825,0,0.08,overdueLoansRate);
			return choice(d);
		}
	}
	/**
	 * 应付账款清付率指标实际值计算公式
	 * @param alreadyPaidCredit 已支付到期应付账款
	 * @param shouldPaidCredit 期内应付账款总额
	 * @return 应付账款清付率
	 */
	public static double getShouldPaidCreditRate(double alreadyPaidCredit,double shouldPaidCredit){
		if(shouldPaidCredit==0){
			return 0;
		}
		double shouldPaidCreditRate = choice(alreadyPaidCredit/shouldPaidCredit);
		return shouldPaidCreditRate;
	}
	/**
	 * @param companyType 公司类型
	 * @return 应付账款清付率分值
	 */
	public static double getShouldPaidCreditRateScores(
			int companyType,double shouldPaidCreditRate){
		if(companyType == 1){
			double d =  getScores(2.325,1,0.8,shouldPaidCreditRate);
			return choice(d);
		}else if(companyType == 2){
			double d =  getScores(2.325,1,0.8,shouldPaidCreditRate);
			return choice(d);
		}else{
			double d =  getScores(5.825,1,0.8,shouldPaidCreditRate);
			return choice(d);
		}
	}
	
	/**
	 * 经营决策者个人信誉分值计算公式     
	 * @param k 经营决策者个人信誉 
	 * @param h 对总体指标权数（指标满分值）
	 * @return 分值
	 */
	public static double getScoresTwo(int k,double h){
		if(k==0){
			return h;
		}else if(k==1){
			return h/2;
		}else if(k==2){
			return h/4;
		}else{
			return 0;
		}
	}
	/** 
	 * @param companyType  公司类型
	 * @param PersonalReputation 经营决策者个人信誉 
	 * @return 经营决策者个人信誉 分值
	 */
	public static double getPersonalReputationScores(int companyType,int PersonalReputation){
		if(companyType == 1 ||companyType == 2){
			if(PersonalReputation==0){//优秀
				return choice(2.325);
			}else if(PersonalReputation==1){//良好
				return choice(2.325/2);
			}else if(PersonalReputation==2){//一般、差
				return choice(2.325/4);
			}else{
				return choice(0);
			}		
		}else{
			if(PersonalReputation==0){
				return choice(5.825);
			}else if(PersonalReputation==1){
				return choice(5.825/2);
			}else if(PersonalReputation==2){
				return choice(5.825/4);
			}else{
				return choice(0);
			}				
		}
	}
	/** WCW_______经营者个人信誉得分的计算方法
	 * @param companyType  公司类型
	 * @param PersonalReputation 经营决策者个人信誉 
	 * @return 经营决策者个人信誉 分值
	 */
	public static double getPersonalReputationScores2(int companyType,int PersonalReputation){
		if(companyType == 1 || companyType == 2){
			double d =  getScoresTwo(PersonalReputation,2.325);
			return choice(d);
		}else{
			double d =  getScoresTwo(PersonalReputation,5.825);
			return choice(d);
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
	
	public static void main(String[] args) {
		System.out.println(getPersonalReputationScores(1,3));
	}

}

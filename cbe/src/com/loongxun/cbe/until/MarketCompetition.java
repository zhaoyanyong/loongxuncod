package com.loongxun.cbe.until;

import java.math.BigDecimal;

public class MarketCompetition {
	/**
	 * 市场竞争力
	 * 
	 * @Effect 比较方法
	 * @Time 2014年2月20日 10:42:52
	 * @Author wzz
	 * @param h 对总体指标权数（指标满分值）
	 * @param a 1级指标权重
	 *  @param b 2级指标权重
	 * @param n 指标实际值
	 * @return score 分值
	 * 
	 * @param type 成长类型
	 */
	
	
	static double h;
	static double score;

	public static Double choice(double arg){
		 BigDecimal b = new BigDecimal(arg);
		 double f1 = b.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		 return f1;
	}
	
	
	/**
	 * 国家产业政策
	 * @param type 成长类型
	 * @param n 国家产业政策指标实际值
	 * @param a  1级指标权重
	 * @return score 分值
	 */
	public static double getStateIndustrialPolicies(int type,int n){
		double a;
		if(type==1){
			 a=0.033;
		}else if(type==2){
			a=0.093;
		}else{
			a=0.083;
		}
		double b=0.455096585043552;
		h=a*b*100;
		if(n==0){
			score=choice(h);
			return score;
		}else if(n==1){
			score=choice(h/2);
			
			return score;
		}else if(n==2){
			score=0.000;
			return score;
		}else{
			score=choice(-1.000);
			return score;
		}

	}
	

	/**
	 * 行业地位
	 * @param type 成长类型
	 * @param n 行业地位指标实际值
	 * @param a  1级指标权重
	 * @return score 分值
	 */
	public static double getIndustryPosition(int type,int n){
		double b=0.141171697800767;
		double a;
		if(type==1){
			 a=0.033;
		}else if(type==2){
			a=0.093;
		}else{
			a=0.083;
		}
		h=a*b*100;
		if(n==0){
			score=choice(h);
			return score;
		}else if(n==1){
			score=choice(h/2);
			
			return score;
		}else{
			score=0.000;
			return score;
		}

	}
	
	/**
	 * 主导产业
	 * @param type 成长类型
	 * @param n 主导产业指标实际值
	 * @param a  1级指标权重
	 * @return score 分值
	 */
	public static double getLeadingIndustry(int type,int n){
		double b=0.141171697800767;
		double a;
		if(type==1){
			 a=0.033;
		}else if(type==2){
			a=0.093;
		}else{
			a=0.083;
		}
		h=a*b*100;
		if(n==0){
			score=choice(h);
			return score;
		}else if(n==1){
			score=choice(h/2);
			return score;
		}else{
			score=0.000;
			return score;
		}

	}
	
	/**
	 * 产品竞争力
	 * @param type 成长类型
	 * @param n   产品竞争力指标实际值
	 * @param a  1级指标权重
	 * @return score 分值
	 */
	public static double getProductCompetitiveness(int type,int n){
		double b=0.262750135882174;
		double a;
		if(type==1){
			 a=0.033;
		}else if(type==2){
			a=0.093;
		}else{
			a=0.083;
		}
		h=a*b*100;
		if(n==0){
			score=choice(h);
			return score;
		}else if(n==1){
			score=choice(h/2);
			
			return score;
		}else{
			score=0.000;
			return score;
		}

	}

	
	
}

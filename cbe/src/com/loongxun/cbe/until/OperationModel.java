package com.loongxun.cbe.until;

import java.math.BigDecimal;


/**
* 文 件 名 : 企业信用评级模型企业规模指标分值计算
* 创 建 人： 韩文场
* 日    期： 2014年2月19日 15:21:17
* 描   述： 根据运算规则调用不同的函数方法
* 版 本 号：1.0
 */
public class OperationModel {
	/**
	 *计算企业规模指标各项所得分值
	 *@param stage 企业生命周期(发展阶段) 1初创型 2成长型 3稳定型
	 *@param type-1企业净资产总额,2企业固定资产总额,3营业收入,4企业税后利润总额,5固定资产净值
	 *@param flag-轻工业是true,重工业是false
	 *@param real-指标实际值
	 *  
	 * @return
	 */
	public static Double netAssetsSore(int stage,int type,Boolean flag,Double real){
		@SuppressWarnings("unused")
		//score 返回所得分值  asocre-满意值  nascore-不允许值 oaiw-对总体指标权数
		Double score =0.0,ascore = 0.0,nascore = 0.0,oaiw = 0.0;
		//根据轻工业和重工业以及2级指标系数，调整满意值和不允许值。 
	
		
		if(flag){//轻工业
			if(type==1){
				ascore=3000.000;
				nascore=300.000;
			}else if(type==2){
				ascore=1000.000;
				nascore=0.000;
			}else if(type==3){
				ascore=5000.000;
				nascore=500.000;
			}else if(type==4){
				ascore=500.000;
				nascore=60.000;
			}else if(type==5){
				ascore=1000.000;
				nascore=0.000;
			}
		}else{//重工业
			if(type==1){
				ascore=40000.000;
				nascore=1000.000;
			}else if(type==2){
				ascore=20000.000;
				nascore=500.000;
			}else if(type==3){
				ascore=5000.000;
				nascore=1000.000;
			}else if(type==4){
				ascore=500.000;
				nascore=60.000;
			}else if(type==5){
				ascore=10000.000;
				nascore=250.000;
			}
		}
		
		//根据企业生命周期调整对总体指标权数
		if(stage==1){
			oaiw = 0.660;		
		}else if(stage==2){
			oaiw = 1.860;		
		}else if(stage==3){
			oaiw = 1.660;			
		}
		//有IF(K11>=I11,H11,IF(K11<=J11,0,(K11-J11)/(I11-J11)*H11)) 计算返回分值
		if(oaiw==0){
			return 0.000;
		}
		if(real>ascore||real==ascore){
			return oaiw;
		}else{
			if(real<nascore||real==nascore){
				 score=0.000;
			}else{
				double x=real-nascore;
				double j=ascore - nascore;
				score=x / j * oaiw;
			}
			return choice(score);
			
		}
		
		
	}
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
	
	
	
	
}

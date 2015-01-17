package com.loongxun.cbe.until;

import java.math.BigDecimal;

/**
 * @Effect 得到指标值后比较的方法工具类
 * @Time 2014年2月20日 10:42:25
 * @Author hjh
 */


public class PublicCompareUtil {

	/**
	 * @Effect 比较方法(对指标值是比率型的适用)
	 * @Time 2014年2月20日 10:42:52
	 * @Author hjh
	 * @param h 对总体指标权数（指标满分值）
	 * @param i 满意值
	 * @param j 不允许值
	 * @param k 指标实际值
	 * @return 分值
	 */
	public static Double getScores(double h,double i,double j,double k){
		if(k >= i){
			return choice(h);
			
		}else if(k <= j){
			return choice(0);
		}else{
			return choice((k - j)/(i - j) * (h * 1.0));
		}
	}
	
	/**
	 * @Effect 比较方法(对指标值是有或无类型的适用)
	 * @Time 2014年2月20日 13:07:16
	 * @Author hjh
	 * @param h 对总体指标权数（指标满分值）
	 * @param k 是否拥有该项数据
	 * @return 分值
	 */
	public static Double getScores(double h, boolean k){
		if(k){
			return choice(h);
		}else{
			return choice(0);
		}
	}
	
	/**
	 * @Effect 比较方法(对指标值是数值类型的适用)
	 * @Time 2014年2月20日 13:18:16
	 * @Author hjh
	 * @param h 对总体指标权数（指标满分值）
	 * @param i 满意值
	 * @param k 是否拥有该项数据
	 * @return 分值
	 */
	public static Double getScores(double h , double i , int k){
		if(k >= i){
			return choice(h);
		}else if(k <= 0){
			return choice(0);
		}else{
			return choice(((k*1.0 / i) * h));
		}
	}
	/**
	 * @Effect 比较方法(对指标值是数值类型的适用)
	 * @Time 2014年2月20日 13:18:16
	 * @Author hjh
	 * @param h 对总体指标权数（指标满分值）
	 * @param i 满意值
	 * @param k 是否拥有该项数据
	 * @return 分值
	 */
	public static Double getScores(double h , Double i , Double k){
		if(k >= i){
			return choice(h);
		}else if(k > 0 && k < i){
			return choice(((k*1.0 / i) * h));
		}else{
			return choice(0);
		}
	}
	/**
	 * @Effect 比较方法
	 * @param h 对总体指标权数（指标满分值）
	 * @param k 是否拥有该项数据
	 * @return 产业类型
	 */
	public static Double getScores(double h,int k){
		if(k==2){
			return choice(h);
		}else if(k==1){
			return choice(h/2.0);
		}else{
			return choice(0);
		}
	}
	
	
	/**
	 * @Effect 小数点保留3位
	 * @Time 2014年2月21日 11:23:49
	 * @Author hjh
	 * @param arg 传入小数
	 * @return 三位小数
	 */
	public static Double choice(double arg){
		 String args = Double.toString(arg);//转换成String类型,才能得到四舍五入的值
		 BigDecimal b = new BigDecimal(args);
		 double f1 = b.setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
		 
	}
}

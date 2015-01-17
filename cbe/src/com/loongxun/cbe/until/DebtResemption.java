package com.loongxun.cbe.until;
/**
* 文 件 名 : 偿债能力比率工具类
* 创 建 人： zft
* 日    期： 2014年2月20日 10:52:42
* 描   述： 用于计算偿债能力的计算公式
* 版 本 号：1.0
 */
public class DebtResemption {
	/**
	 * 获得流动比率分值
	 * @param type 生命周期类型
	 * @param floatingCapital 流动资产
     * @param cashLiabilities 流动负债
     * @return  流动比率分值
	 */
	public static Double getCurrentRatioValue(int type,double floatingCapital,double cashLiabilities){
		double indexValue = PublicCompareUtil.choice(floatingCapital/cashLiabilities);
		if(type==1){
			return PublicCompareUtil.getScores(1.110,2.000, 1.000, indexValue);
		}else if (type==2) {
			return PublicCompareUtil.getScores(1.110,2.000, 1.000, indexValue);
		}else{
			return PublicCompareUtil.getScores(0.991,2.000, 1.000, indexValue);
		}
	}
	/**
	 * 获得流动比率
	 * @param floatingCapital 流动资产
     * @param cashLiabilities 流动负债
     * @return  流动比率分值
	 */
	public static Double getCurrentRatio(double floatingCapital,double cashLiabilities){
		if(cashLiabilities==0){
			return 0.0;
		}
		double indexValue = PublicCompareUtil.choice(floatingCapital/cashLiabilities);
		return indexValue;
	}
	/**
	 * 获得速动比率分值
	 * @param type 生命周期类型
	 * @param generalCash 现金
	 * @param si 短期债券投资
	 * @param accountReceivable 应收账款
	 * @param noteReceivable 应收票据
	 * @param cashLiabilities 流动负债
	 * @return 速动比率分值
	 */
	public static Double getquickRatioValue(int type,double generalCash,double si,double accountReceivable,double noteReceivable ,double cashLiabilities){
		if(cashLiabilities==0){
			return 0.0;
		}
		double indexValue = PublicCompareUtil.choice((generalCash+si+accountReceivable+noteReceivable)/cashLiabilities);
        if(type==1){
			return PublicCompareUtil.getScores(1.110,1.000, 0.500, indexValue);
		}else if (type==2) {
			return PublicCompareUtil.getScores(1.110,1.000, 0.500, indexValue);
		}else{
			return PublicCompareUtil.getScores(0.991,1.000, 0.500, indexValue);
		}
		
	}
	/**
	 * 获得速动比率
	 * @param generalCash 现金
	 * @param si 短期债券投资
	 * @param accountReceivable 应收账款
	 * @param noteReceivable 应收票据
	 * @param cashLiabilities 流动负债
	 * @return 速动比率分值
	 */
	public static Double getquickRatio(double generalCash,double si,double accountReceivable,double noteReceivable ,double cashLiabilities){
		if(cashLiabilities==0){
			return 0.0;
		}
		double indexValue = PublicCompareUtil.choice((generalCash+si+accountReceivable+noteReceivable)/cashLiabilities);
        return indexValue;
		
	}
	/**
	 * 获得现金比率分数
	 * @param type 生命周期类型
	 * @param valueSecurities  有价证券
	 * @param generalCash 现金
	 * @param cashLiabilities 流动负债
	 * @return 现金比率分数
	 */
	public static Double getCashRatioValue(int type,double valueSecurities,double generalCash,double cashLiabilities){
		if(cashLiabilities==0){
			return 0.0;
		}
		double indexValue = PublicCompareUtil.choice((valueSecurities+generalCash)/cashLiabilities);
        if(type==1){
			return PublicCompareUtil.getScores(1.110,1.000, 0.200, indexValue);
		}else if (type==2) {
			return PublicCompareUtil.getScores(1.110,1.000, 0.200, indexValue);
		}else{
			return PublicCompareUtil.getScores(0.991,1.000, 0.200, indexValue);
		}
		
	}
	/**
	 * 获得现金比率
	 * @param valueSecurities  有价证券
	 * @param generalCash 现金
	 * @param cashLiabilities 流动负债
	 * @return 现金比率分数
	 */
	public static Double getCashRatio(double valueSecurities,double generalCash,double cashLiabilities){
		if(cashLiabilities==0){
			return 0.0;
		}
		double indexValue = PublicCompareUtil.choice((valueSecurities+generalCash)/cashLiabilities);
        return indexValue;
		
	}
	/**
	 * 获得资产负债率分数	
	 * @param type 生命周期类型
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 资产负债率分数	
	 */
	public static Double getAssetliabilityRatioValue(int type,double grossLiabilities,double totalAssets){
		if(totalAssets==0){
			return 0.0;
		}
		double indexValue = PublicCompareUtil.choice(grossLiabilities/totalAssets);
        if(type==1){
			return getScores(2.167,0.650, 0.850, indexValue);
		}else if (type==2) {
			return getScores(2.167,0.650, 0.850, indexValue);
		}else{
			return getScores(1.934,0.650, 0.850, indexValue);
		}
		
	}
	/**
	 * 获得资产负债率
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 资产负债率分数	
	 */
	public static Double getAssetliabilityRatio(double grossLiabilities,double totalAssets){
		if(totalAssets==0){
			return 0.0;
		}
		double indexValue = PublicCompareUtil.choice(grossLiabilities/totalAssets);
       return indexValue;
		
	}
	/**
	 * 获得产权比率分数	
	 * @param type 生命周期类型
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 产权比率分数
	 */
	public static double getEquityRatioValue(int type , double grossLiabilities,double totalAssets){
		if((totalAssets-grossLiabilities)==0){
			return 0;			
		}
		double indexValue = PublicCompareUtil.choice(grossLiabilities/(totalAssets-grossLiabilities));
        if(type==1){
			return getScores(0.546,0.800, 1, indexValue);
		}else if (type==2) {
			return getScores(0.546,0.800, 1, indexValue);
		}else{
			return getScores(0.487,0.800, 1, indexValue);
		}
		
	}
	/**
	 * 获得产权比率	
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 产权比率分数
	 */
	public static double getEquityRatio( double grossLiabilities,double totalAssets){
		if((totalAssets-grossLiabilities)==0){
			return 0;		
		}
		double indexValue = PublicCompareUtil.choice(grossLiabilities/(totalAssets-grossLiabilities));
       return indexValue;
		
	}
	/**
	 * 获得利息保障倍数分数	
	 * @param type  生命周期类型
	 * @param earningsInterestTaxes 息税前利润
	 * @param capitalCharges 利息费用
	 * @return 利息保障倍数分数	
	 */
	public static double getInterestCoverValue(int type,double earningsInterestTaxes ,double capitalCharges){
		if(capitalCharges==0){
			return 0;
		}
		double indexValue = PublicCompareUtil.choice(earningsInterestTaxes/capitalCharges);
        if(type==1){
			return PublicCompareUtil.getScores(0.546,10, 1, indexValue);
		}else if (type==2) {
			return PublicCompareUtil.getScores(0.546,10, 1, indexValue);
		}else{
			return PublicCompareUtil.getScores(0.487,10, 1, indexValue);
		} 
		
	}
	/**
	 * 获得利息保障倍数	
	 * @param earningsInterestTaxes 息税前利润
	 * @param capitalCharges 利息费用
	 * @return 利息保障倍数分数	
	 */
	public static double getInterestCover(double earningsInterestTaxes ,double capitalCharges){
		if(capitalCharges==0){
			return 0;
		}
		double indexValue = PublicCompareUtil.choice(earningsInterestTaxes/capitalCharges);
       return indexValue;
		
	}
	/**
	 * 获得担保比率分数
	 * @param type 生命周期类型
	 * @param foreignGuaranteeAmount 对外担保额度
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 担保比率分数
	 */
	public static double getGuaranteeRatioValue(int type,double foreignGuaranteeAmount,double grossLiabilities,double totalAssets){
		if((totalAssets-grossLiabilities)==0){
			return 0;
		};
		double indexValue = PublicCompareUtil.choice(foreignGuaranteeAmount/(totalAssets-grossLiabilities));
        if(type==1){
			return PublicCompareUtil.getScores(2.167,1, 0.200, indexValue);
		}else if (type==2) {
			return PublicCompareUtil.getScores(2.167,1, 0.200, indexValue);
		}else{
			return PublicCompareUtil.getScores(1.934,1, 0.200, indexValue);
		} 
		
	}
	/**
	 * 获得担保比率
	 * @param foreignGuaranteeAmount 对外担保额度
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 担保比率分数
	 */
	public static double getGuaranteeRatio(double foreignGuaranteeAmount,double grossLiabilities,double totalAssets){
		
		if((totalAssets-grossLiabilities)==0){
			return 0;
			
		}
		double indexValue = PublicCompareUtil.choice(foreignGuaranteeAmount/(totalAssets-grossLiabilities));
       return indexValue;
		
	}
	/**
	 * 获得股东权益比率分数
	 * @param type 生命周期类型
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 股东权益比率分数
	 */
	public static double getEquityratioValue(int type,double grossLiabilities,double totalAssets){
		if(totalAssets==0){
			return 0;
		}
		double indexValue = PublicCompareUtil.choice( (totalAssets-grossLiabilities)/totalAssets);
        if(type==1){
			return getScores(0.546,0.4, 0.6,0.8,0.2, indexValue);
		}else if (type==2) {
			return getScores(0.546,0.4, 0.6,0.8,0.2, indexValue);
		}else{
			return getScores(0.487,0.4, 0.6,0.8,0.2, indexValue);
		} 
		
	}
	/**
	 * 获得股东权益比率
	 * @param grossLiabilities 负债总额
	 * @param totalAssets 资产总额
	 * @return 股东权益比率分数
	 */
	public static double getEquityratio(double grossLiabilities,double totalAssets){
		if(totalAssets==0){
			return 0;
		}
		double indexValue = PublicCompareUtil.choice( (totalAssets-grossLiabilities)/totalAssets);
		return indexValue;
		
	}
	/**
	 * 得到股东权益比率指标值后比较的方法
	 * * @param h 对总体指标权数（指标满分值）
	 * @param i1 满意值
	 * @param i2 满意值
	 * @param j1 不允许值
	 * @param j2 不允许值
	 * @param k 指标实际值
	 * @return 分值
	 */
	public static double getScores(double h,double i1,double i2,double j1,double j2,double k){
		if(k>=j1){
			return 0;
		}else {
			if(k <=j2){
				return 0;
			}else if(k>=i1&&k<=i2){
				return PublicCompareUtil.choice(h);
			}else if(k>i2){
				return PublicCompareUtil.choice((j1-k)/(j1-i2)*h);
			}else{
				return PublicCompareUtil.choice((k-j2)/(i1-j2)*h);
			}
		}
		
	}
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
		if(k <= i){
			return PublicCompareUtil.choice(h);
		}else if(k >= j){
			return PublicCompareUtil.choice(0);
		}else{
			return PublicCompareUtil.choice((k - j)/(i - j) * (h * 1.0));
		}
	}
	
	
	
}

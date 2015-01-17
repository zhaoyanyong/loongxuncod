package com.loongxun.cbe.until;

/**
 * @Effect 创新性指标
 * @Time 2014年2月20日 11:14:55
 * @Author hjh
 */

public class CreativeKPI {
	
	/**
	 * 将booean值转换为Integer  的方法    WCW
	 * @param b
	 * @return
	 */
	public static Integer toInteger(boolean b){
		/**
		 * 举例说明：国家重点实验室   boolean  stateKeyLaboratory
		 * 如果true，表示有国家重点实验室；对应dataanaly表中存放  1
		 */
		if(b){
			return 1;
		}else{
			return 0;
		}
		
	}
    
	/**
	   * 近1年高新技术产品（服务）销售收入和技术收入占销售收入的比率方法
	 * @param highTechincome 1年 高新技术产品（服务）销售收入和技术收入的总和
	 * @param allyearincom 1年销售总收入收入
	 * 
	 * @return 近1年高新技术产品（服务）销售收入和技术收入占销售收入的比率值
	 */
	
	public static double getAllYHighIncomeRatio( Double highTechincome, Double allyearincom){
	 if(allyearincom==0){
		 return 0;
	 }
		return highTechincome/allyearincom*1.000;
	}
	/**
	  * 近1年高新技术产品（服务）销售收入和技术收入占销售收入的指标值
	 * @param highTechincome 1年 高新技术产品（服务）销售收入和技术收入的总和
	 * @param allyearincom 1年销售总收入收入
	 * @param companyType  公司类型 1代表初创型 2代表成长型3代表稳定型
	 * @return 近1年高新技术产品（服务）销售收入和技术收入占销售收入的比率值
	 */
	public static double getAllYHighIncomeRatioValue(int companyType , Double highTechincome, Double allyearincom){
		double k= getAllYHighIncomeRatio( highTechincome,  allyearincom);
		if(companyType==1){
			 return PublicCompareUtil.getScores(1.315, 0.600, 0, k);
		}else if(companyType==2){
			return PublicCompareUtil.getScores(0.398, 0.600, 0,k);
		}else{
			return PublicCompareUtil.getScores(0.515, 0.600,0, k);
		}
	}
	
	/**
	 *   R&D投入占比方法
	 * @param RDOutLay R＆D经费支出
	 * @param sellIncome年销售收入
	 * 
	 * @return R&D投入占比率
	 */
	public static double getRDInputRatio(Double  RDOutLay, Double sellIncome){
		if(sellIncome==0){
			return 0;
		}
     return  RDOutLay/sellIncome*1.000;
	
		
	}
	/**
	 *   R&D投入占比方法指标值
	 * @param RDOutLay R＆D经费支出
	 * @param sellIncome年销售收入
	 *  @param companyType  公司类型 1代表初创型 2代表成长型3代表稳定型
	 * @return R&D投入占比率
	 */
public static double getRDInputRatioValue(int companyType, Double  RDOutLay, Double sellIncome){
	double k= getRDInputRatio(RDOutLay, sellIncome);
		if(companyType==1){
			 return PublicCompareUtil.getScores(1.315, 0.0875, 0.03, k);
	  }else if(companyType==2){
			return PublicCompareUtil.getScores(0.473, 0.0875, 0.03,k);
		}else{
			return PublicCompareUtil.getScores(1.038, 0.0875,0.03, k);
		}
		
	}

	/**
	 *  R＆D经费增长率=（本年R＆D经费投入额-上年R＆D经费投入额）/上年R＆D经费投入额
	 * @param lastYearFAmount上年R＆D经费投入额
	 * @param thisYearFAmount本年R＆D经费投入额
	 *  @param companyType  公司类型 1代表初创型 2代表成长型3代表稳定型
	 * @return R＆D经费增长率
	 */
	public static double getRDIncreRatio(Double lastYearFAmount ,Double thisYearFAmount){
		
	if(lastYearFAmount==0){
		return 0;
	}
		return	(thisYearFAmount-lastYearFAmount)/lastYearFAmount*1.000;
		 
	}
	/**
	 *  R＆D经费增长率=（本年R＆D经费投入额-上年R＆D经费投入额）/上年R＆D经费投入额指标值
	 * @param lastYearFAmount上年R＆D经费投入额
	 * @param thisYearFAmount本年R＆D经费投入额
	 *  @param companyType  公司类型 1代表初创型 2代表成长型3代表稳定型
	 * @return R＆D经费增长率
	 */
	public static double getRDIncreRatioValue(int companyType,Double lastYearFAmount ,Double thisYearFAmount){
		double k=getRDIncreRatio( lastYearFAmount ,thisYearFAmount);
		double h=0.3; 
		if(companyType==1){
			h=1.315; 
			  
		  }else if(companyType==2){
			  h=0.440; 
			  
		  }else{
			  
			  h=0.515; 
		  }
		return	PublicCompareUtil.getScores(h, 0.15, 0.05, k);
		 
	}

	/**
	 * @Effect 大专以上人数占比率分值(获得指标实际值)
	 * @Time 2014年2月20日 11:19:26
	 * @Author hjh
	 * @param collageCount 大专以上人数
	 * @param totalCount 总人数
	 * @return 比例数
	 */
	public static double collageRatioTarget(int collageCount , int totalCount){
		if(totalCount==0){
			return 0;
		}
		double ratio = collageCount * 1.0 / totalCount ;
		return ratio;
	}
	
	/**
	 * @Effect 大专以上人数占比率分值(分值)
	 * @Time 2014年2月20日 11:19:26
	 * @Author hjh
	 * @param collageCount 大专以上人数
	 * @param totalCount 总人数
	 * @return 比例数
	 */
	public static double collageRatioValue(int companyType , int collageCount , int totalCount){
		double h=0; 
		if(companyType==1){
			h=3.629; 
			  
		  }else if(companyType==2){
			  h=1.096; 
		  }else{
			  h=1.038; 
		  }
		double ratio = collageRatioTarget(collageCount , totalCount) ;
		return	PublicCompareUtil.getScores(h, 0.4, 0.3, ratio);
	}
	
	/**
	 * @Effect 获得奖励数算分值调用的方法（5获得市级以上科技成果奖励数      6申请和已授权的知识产权总数	7专利总数）
	 * @Time 2014年2月20日 14:10:43
	 * @Author hjh
	 * @param companyType 公司类型
	 * @param wardCount 获得奖励数量
	 * @return 该项分值
	 */
	public static double rewardValue(int companyType , int wardCount ){
		double h=0; 
		if(companyType==1){
			h=1.315; 
			  
		  }else if(companyType==2){
			  h=0.440; 
			  
		  }else{
			  h=0.515; 
		  }
		return	PublicCompareUtil.getScores(h,5 ,wardCount);
	}
	

	/**
	 * @Effect 获得政府立项算分值调用的方法（8近三年获政府立项数量	国家级  省部级  地市级）
	 * @Time 2014年2月20日 14:17:11
	 * @Author hjh
	 * @param companyType 公司类型
	 * @param projectCount 政府立项数量
	 * @return 该项分值
	 */
	public static double projectValue(int companyType , int projectCount ){
		double h=0; 
		if(companyType==1){
			h=0.438;
		  }else if(companyType==2){
			  h=0.147;
		  }else{
			  h=0.1715; 
		  }
		return	PublicCompareUtil.getScores(h, 3.0 ,projectCount);
	}
	
	/**
	 * @Effect 创新人员激励制度计算分值方法（9 创新人员激励制度）
	 * @Time 2014年2月20日 14:18:25
	 * @Author hjh
	 * @param companyType 公司类型
	 * @param hasIncentive 有无创新激励
	 * @return 该项分值
	 */
	public static double incentiveValue(int companyType , boolean hasIncentive ){
		double h=0; 
		if(companyType==1){
			h=3.629; 
		  }else if(companyType==2){
			  h=1.096; 
		  }else{
			  h=1.038; 
		  }
		return	PublicCompareUtil.getScores(h,hasIncentive);
	}
	
	/**
	 * @Effect 有无国际机构合作（10专门的研发机构	11有无创业投资机构进入	 12国际化合作）
	 * @Time 2014年2月20日 14:29:45
	 * @Author hjh
	 * @param companyType 公司性质
	 * @param hasOrg 有无国际机构合作
	 * @return 该项分值
	 */
	public static double internationalOrgnizationValue(int companyType , boolean hasOrg){
		double h=0; 
		if(companyType==1){
			h=2.814; 
		  }else if(companyType==2){
			  h=0.880; 
		  }else{
			  h=0.515; 
		  }
		return	PublicCompareUtil.getScores(h,hasOrg);
	}
	
	/**
	 * @Effect 有无国家重点实验室
	 * @Time 2014年2月20日 14:32:31
	 * @Author hjh
	 * @param companyType 公司性质
	 * @param hasLab 有无国家重点实验室
	 * @return 该项分值
	 */
	public static double  labouratoryValue(int companyType , boolean hasLab){
		double h=0; 
		if(companyType==1){
			h=1.315; 
		  }else if(companyType==2){
			  h=0.398; 
		  }else{
			  h=0.515; 
		  }
		return	PublicCompareUtil.getScores(h,hasLab);
	}
	
}

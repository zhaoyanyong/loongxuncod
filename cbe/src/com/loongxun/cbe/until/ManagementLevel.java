package com.loongxun.cbe.until;

import java.math.BigDecimal;

import org.apache.log4j.chainsaw.Main;

/**
 * @author 管理水平 lhq
 * 
 */
public class ManagementLevel {

	/**
	 * 保留三位小数
	 * 
	 * @param arg
	 * @return
	 */
	public static Double choice(double arg) {
		String args = Double.toString(arg);//转换成String类型,才能得到四舍五入的值
		BigDecimal b = new BigDecimal(args);
		double f1 = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	// 对总体指标权数（指标满分值）
	double h;
	// 指标实际值
	int k;

	/**
	 * 经营管理水平
	 * 
	 * @param k
	 *            指标实际值
	 * @param conpanyType
	 *            公司了类型 1 初级 2 成长 3 稳定
	 * @return
	 */
	public static double ToOperationControl(int conpanyType, int k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 3.069;
		} else {
			h = 2.739;
		}

		if (k == 0) {
			return choice(h);
		} else if (k == 1) {
			return choice(h / 2);
		} else if (k == 2) {
			return choice(h / 4);
		} else {
			return 0.000;
		}

	}

	/**
	 * 股东背景
	 * 
	 * @param k
	 *            指标实际值
	 * @param conpanyType
	 *            公司了类型 1 初级 2 成长 3 稳定
	 * @return
	 */
	public static double ToShareholdersBackground(int conpanyType, int k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 3.069;
		} else {
			h = 2.739;
		}
		if (k == 0) {//中央
			return choice(h);
		} else if (k == 1) {//地市
			return choice(h / 2);
		} else {//民营
			return choice(h / 4);
		}
	}

	/**
	 * 任职年份算法
	 * 
	 * @param conpanyType
	 *            公司了类型 1 初级 2 成长 3 稳定
	 * @param k指标实际值
	 * @return
	 */
	public static double ToTakeOfficeYear(int conpanyType, int k) {

		if (conpanyType == 1 || conpanyType == 2) {
			return choice(PublicCompareUtil.getScores(0.383625, 5, 0, k));
		} else {
			return choice(PublicCompareUtil.getScores(0.342375, 5, 0, k));
		}
	}

	/**
	 * 董事长与CEO两职设置状况(CEO) 、董事会规模(Board)
	 * 
	 * @param conpanyType公司了类型
	 *            1 初级 2 成长 3 稳定
	 * @param k指标实际值
	 * @return
	 */
	public static double ToBoardDCEO(int conpanyType, boolean k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 0.383625;
		} else {
			h = 0.342375;
		}
		PublicCompareUtil.getScores(h, k);
		return PublicCompareUtil.getScores(h,k);
	}

	/**
	 * 审计意见
	 * 
	 * @param conpanyType公司了类型
	 *            1 初级 2 成长 3 稳定
	 * @param k指标实际值
	 * @return
	 */
	public static double ToAuditOpinion(int conpanyType, int k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 0.383625;
		} else {
			h = 0.342375;
		}

		if (k == 0) {
			return choice(h);
		} else if (k == 1) {
			return choice(h / 2);
		} else if (k == 2) {
			return choice(h / 4);
		} else if (k == 3) {
			return 0.000;
		} else {
			return -0.100;
		}

	}

	/**
	 * 违规行为
	 * 
	 * @param conpanyType
	 *            公司了类型 1 初级 2 成长 3 稳定
	 * @param k指标实际值
	 * @return
	 */
	public static double ToIrregularities(int conpanyType, boolean k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 0.383625;
		} else {
			h = 0.342375;
		}
		PublicCompareUtil.getScores(h, k);
		return PublicCompareUtil.getScores(h, k);
	}

	/**
	 * 年龄
	 * 
	 * @param conpanyType
	 *            公司了类型 1 初级 2 成长 3 稳定
	 * @param k指标实际值
	 * @return
	 */
	public static double ToAgeGroup(int conpanyType, int k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 0.383625;
		} else {
			h = 0.342375;
		}

		if (k == 1) {
			return choice(h);
		} else {
			return 0.000;
		}

	}

	/**
	 * 教育背景
	 * 
	 * @param conpanyType
	 *            公司了类型 1 初级 2 成长 3 稳定
	 * @param k指标实际值
	 * @return
	 */
	public static double ToDegreeTitles(int conpanyType, int k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 0.383625;
		} else {
			h = 0.342375;
		}

		//修改了对应应减去的值
		if (k == 0) {
			return choice(h);
		} else if (k == 1) {
			return choice(h - 0.100);
		} else if (k == 2) {
			return choice(h - 0.200);
		} else if (k == 3) {
			return choice(h - 0.300);
		} else {
			return 0.000;
		}

	}

	/**
	 * 职称
	 * 
	 * @param conpanyType
	 *            公司了类型 1 初级 2 成长 3 稳定
	 * @param k
	 *            指标实际值
	 * @return
	 */
	public static double ToAcademicTitle(int conpanyType, int k) {
		double h;
		if (conpanyType == 1 || conpanyType == 2) {
			h = 0.383625;
		} else {
			h = 0.342375;
		}

		if (k == 0) {
			return choice(h);
		} else if (k == 1) {
			return choice(h - 0.100);
		} else if (k == 2) {
			return choice(h - 0.150);
		} else if (k == 3) {
			return choice(h - 0.200);
		} else {
			return 0.000;
		}

	}

}

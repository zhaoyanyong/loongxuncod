package com.loongxun.cbe.until;
/**
 * 各项指标满分分值
 * @author Administrator
 *
 */
public class CompanyConstant {
	// 初创期企业 1
	public final static double ISTS = 3.30;// 企业规模
	public final static double IDTS = 9.30;// 偿债能力
	public final static double IOTS = 9.30;// 营运
	public final static double IETS = 3.30;// 盈利
	public final static double IGTS = 26.30;// 成长
	public final static double ICTS = 26.30;// 创新
	public final static double ICETS = 9.30;// 信用履约能力
	public final static double IMTS = 9.30;// 管理
	public final static double IMCTS = 3.30;// 市场竞争力
	// 成长性企业 2
	public final static double GSTS = 9.30;// 企业规模
	public final static double GDTS = 9.30;// 偿债能力
	public final static double GOTS = 9.30;// 营运
	public final static double GETS = 9.30;// 盈利
	public final static double GGTS = 26.30;// 成长
	public final static double GCTS = 8.30;// 创新
	public final static double GCETS = 9.30;// 信用履约能力
	public final static double GMTS = 9.30;// 管理
	public final static double GMCTS = 9.30;// 市场竞争力
	// 稳定期企业 3
	public final static double SSTS = 8.30;// 企业规模
	public final static double SDTS = 8.30;// 偿债能力
	public final static double SOTS = 8.30;// 营运
	public final static double SETS = 23.30;// 盈利
	public final static double SGTS = 3.30;// 成长
	public final static double SCTS = 8.30;// 创新
	public final static double SCETS = 23.30;// 信用履约能力
	public final static double SMTS = 8.30;// 管理
	public final static double SMCTS = 8.30;// 市场竞争力

	// 九大指标的满分值（数组内顺序依次为：初创型、成长型、稳定型）
	public final static double[] STS = { 3.30, 9.30, 8.30 };// 企业规模
	public final static double[] DTS = { 9.30, 9.30, 8.30 };// 偿债能力
	public final static double[] OTS = { 9.30, 9.30, 8.30 };// 营运
	public final static double[] ETS = { 3.30, 9.30, 23.30 };// 盈利
	public final static double[] GTS = { 26.30, 26.30, 3.30 };// 成长
	public final static double[] CTS = { 26.30, 8.30, 8.30 };// 创新
	public final static double[] CETS = { 9.30, 9.30, 23.30 };// 信用履约能力
	public final static double[] MTS = { 9.30, 9.30, 8.30 };// 管理
	public final static double[] MCTS = { 3.30, 9.30, 8.30 };// 市场竞争力
	
	//初创型企业规模指标
	public final static double[] ISTSTEMP={0.660, 0.660, 0.660, 0.660, 0.660};
	//初创型偿债能力
	public final static double[] IDTSTEMP={1.110, 1.110, 1.110, 2.167, 0.546, 0.546, 0.546, 2.167};
	//初创型营运能力
	public final static double[] IOTSTEMP={1.034, 1.034, 1.034, 1.034, 1.034, 1.034, 3.101};
	//初创型盈利能力
	public final static double[] IETSTEMP={0.761, 0.761, 0.761, 0.761, 0.254};
	//初创型成长性指标
	public final static double[] IGTSTEMP={1.394, 3.025, 1.394, 3.025, 1.394, 3.629, 0.907,0.907,0.907,0.907, 3.025, 1.394, 1.394, 3.025};
	//初创型创新性指标
	public final static double[] ICTSTEMP={1.315, 1.315, 1.315, 3.629, 1.315, 1.315, 1.315, 0.430, 0.430, 0.430, 3.629, 2.814, 2.814, 2.814, 1.315};
	//初创型信用履约能力指标
	public final static double[] ICETSTEMP={2.325, 2.325, 2.325, 2.325};
	//初创型管理水平
	public final static double[] IMTSTEMP={3.069, 3.069, 0.384, 0.384, 0.384, 0.384, 0.384, 0.384, 0.384, 0.384 };
	//初创型市场竞争力
	public final static double[] IMCTSTEMP={1.502, 0.466, 0.466, 0.867};
	
	
	//成长型企业规模指标
	public final static double[] GSTSTEMP={1.860, 1.860, 1.860, 1.860, 1.860};
	//成长型偿债能力
	public final static double[] GDTSTEMP={1.110, 1.110, 1.110, 2.167, 0.546, 0.546, 0.546, 2.167};
	//成长型营运能力
	public final static double[] GOTSTEMP={1.034, 1.034, 1.034, 1.034, 1.034, 1.034, 3.101};
	//成长型盈利能力
	public final static double[] GETSTEMP={2.145, 2.145, 2.145, 2.145, 0.715};
	//成长型成长性指标
	public final static double[] GGTSTEMP={1.394, 3.025, 1.394, 3.025, 1.394, 3.629, 0.907,0.907,0.907,0.907, 3.025, 1.394, 1.394, 3.025};
	//成长型创新性指标
	public final static double[] GCTSTEMP={0.398, 0.473, 0.440, 1.096, 0.440, 0.440, 0.440, 0.430, 0.430, 0.430, 1.096, 0.880, 0.880, 0.880, 0.398};
	//成长型信用履约能力指标
	public final static double[] GCETSTEMP={2.325, 2.325, 2.325, 2.325};
	//成长型管理水平
	public final static double[] GMTSTEMP={3.069, 3.069, 0.384, 0.384, 0.384, 0.384, 0.384, 0.384, 0.384, 0.384 };
	//成长型市场竞争力
	public final static double[] GMCTSTEMP={4.232, 1.313, 1.313, 2.444};
	
	//稳定型企业规模指标
	public final static double[] SSTSTEMP={1.660, 1.660, 1.660, 1.660, 1.660};
	//稳定型偿债能力
	public final static double[] SDTSTEMP={0.991, 0.991, 0.991, 1.934, 0.487, 0.487, 0.487, 1.934};
	//稳定型营运能力
	public final static double[] SOTSTEMP={0.923, 0.923, 0.923, 0.923, 0.923, 0.923, 2.768};
	//稳定型盈利能力
	public final static double[] SETSTEMP={5.375, 5.375, 5.375, 5.375, 1.792};
	//稳定型成长性指标
	public final static double[] SGTSTEMP={0.297, 0.531, 0.297, 0.531, 0.297, 0.191, 0.048,0.048,0.048,0.048, 0.191, 0.191, 0.297, 0.191};
	//稳定型创新性指标
	public final static double[] SCTSTEMP={0.515, 1.038, 0.515, 1.038, 0.515, 0.515, 0.515, 0.430, 0.430, 0.430, 1.038, 0.515, 0.515, 0.515, 0.515};
	//稳定型信用履约能力指标
	public final static double[] SCETSTEMP={5.825, 5.825, 5.825, 5.825};
	//稳定型管理水平
	public final static double[] SMTSTEMP={2.739, 2.739, 0.342, 0.342, 0.342, 0.342, 0.342, 0.342, 0.342, 0.342 };
	//稳定型市场竞争力
	public final static double[] SMCTSTEMP={3.777, 1.172, 1.172, 2.181};
	
	
	
}

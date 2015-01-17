package com.loongxun.cbe.enterprise.action;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jfree.chart.JFreeChart;
import com.loongxun.cbe.enterprise.bean.Dataanalyh;
import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.DataAnalyHDAO;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.enterprise.dao.RatingResultsHDAO;
import com.loongxun.cbe.until.CompanyConstant;
import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.opensymphony.xwork2.ActionContext;



/**
 * 查看数据分析各项分数
 * 
 * @author Administrator
 * 
 */
public class FinddataTotalScoerAction {

	private int enterpriseId;
	private Enterpriseinfo user;
	private String loginuser;
	private Ratingresultsh rati;
	private DataAnalyHDAO analyHDAO;//数据分析DAO
	private JFreeChart chart;
	private EnterpriseDAO enterpriseDAO;
	private RatingResultsHDAO ratingHDAO;
	private List<Dataanalyh> foursdatahs;
	private int size;
	private List<Dataanalyh> arr=new ArrayList<Dataanalyh>();
	private int total;
	private double[] STS;//企业规模满分值数组
	private double[] DTS;//偿债能力数组
	private double[] OTS;//营运能力数组
	private double[] ETS;//盈利能力
	private double[] GTS;//成长性指标
	private double[] CTS;//创新性指标
	private double[] CETS;//信用履约能力指标
	private double[] MTS;//管理水平
	private double[] MCTS;//市场竞争力
	private int attributeId;//指标id
	private Dataanalyh dataanaly ;//企业数据
	// 查看各项指标实际分值 和分值
	public String secondSearch() {
		try {
			dataanaly = analyHDAO.findByEIdAndAId(enterpriseId, attributeId);//指标分析数据
			Enterpriseinfo enter = enterpriseDAO.findById(enterpriseId);
			int lifeCycle = enter.getStage();// 企业所处生命周期
			CompanyConstant com=new CompanyConstant();
			if(lifeCycle==1){
				STS=com.ISTSTEMP;
				DTS=com.IDTSTEMP;
				OTS=com.IOTSTEMP;
				GTS=com.IGTSTEMP;
				CTS=com.ICTSTEMP;
				ETS=com.IETSTEMP;
			
			}
			if(lifeCycle==2){
				STS=com.GSTSTEMP;
				DTS=com.GDTSTEMP;
				OTS=com.GOTSTEMP;
				GTS=com.GGTSTEMP;
				CTS=com.GCTSTEMP;
				ETS=com.GETSTEMP;
			}
			if(lifeCycle==3){
				STS=com.SSTSTEMP;
				DTS=com.SSTSTEMP;
				OTS=com.SOTSTEMP;
				GTS=com.SGTSTEMP;
				CTS=com.SCTSTEMP;
				ETS=com.SETSTEMP;
			}
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success1";
	}
	
	/**
	 * 查看信用履约能力指标
	 * @return
	 */
	public String performanceDetail() {
		try {
			dataanaly = analyHDAO.findByEIdAndAId(enterpriseId, attributeId);//指标分析数据
			Enterpriseinfo enter = enterpriseDAO.findById(enterpriseId);
			int lifeCycle = enter.getStage();// 企业所处生命周期
			CompanyConstant com=new CompanyConstant();
			if(lifeCycle==1){
				CETS=com.ICETSTEMP;
				
			}
			if(lifeCycle==2){
				CETS=com.GCETSTEMP;
			}
			if(lifeCycle==3){
				CETS=com.SCETSTEMP;	
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success1";
	}
	//管理水平
	public String managePowerDetail(){
		try {
			dataanaly = analyHDAO.findByEIdAndAId(enterpriseId, attributeId);//指标分析数据
			Enterpriseinfo enter = enterpriseDAO.findById(enterpriseId);
			int lifeCycle = enter.getStage();// 企业所处生命周期
			CompanyConstant com=new CompanyConstant();
			if(lifeCycle==1){
				MTS=com.IMTSTEMP;
				
			}
			if(lifeCycle==2){
				MTS=com.GMTSTEMP;
			}
			if(lifeCycle==3){
				MTS=com.SMTSTEMP;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	//市场竞争力
		public String marketCompeteDetail(){
			try {
				dataanaly = analyHDAO.findByEIdAndAId(enterpriseId, attributeId);//指标分析数据
				Enterpriseinfo enter = enterpriseDAO.findById(enterpriseId);
				int lifeCycle = enter.getStage();// 企业所处生命周期
				CompanyConstant com=new CompanyConstant();
				if(lifeCycle==1){
					MCTS=com.IMCTSTEMP;
					
				}
				if(lifeCycle==2){
					MCTS=com.GMCTSTEMP;
				}
				if(lifeCycle==3){
					MCTS=com.SMCTSTEMP;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "success";
		}
	@SuppressWarnings("unchecked")
	public String firstSearch() {
		Map<String, Object> session = (Map<String, Object>) ActionContext
				.getContext().get(ActionContext.SESSION);
		loginuser = (String) session.get("loginuser");
		try {
			dataanaly = analyHDAO.findByEIdAndAId(enterpriseId, attributeId);//指标分析数据
			rati = ratingHDAO.findRathByAid(attributeId);//分析结果
			user = enterpriseDAO.findById(enterpriseId);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";

	}

	
	
	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}


	public Enterpriseinfo getUser() {
		return user;
	}

	public void setUser(Enterpriseinfo user) {
		this.user = user;
	}

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}


	public JFreeChart getChart() {
		return chart;
	}
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	
	public List<Dataanalyh> getFoursdatahs() {
		return foursdatahs;
	}

	public void setFoursdatahs(List<Dataanalyh> foursdatahs) {
		this.foursdatahs = foursdatahs;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	



	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Dataanalyh> getArr() {
		return arr;
	}

	public void setArr(List<Dataanalyh> arr) {
		this.arr = arr;
	}

	public double[] getSTS() {
		return STS;
	}

	public void setSTS(double[] sTS) {
		STS = sTS;
	}

	public double[] getDTS() {
		return DTS;
	}

	public void setDTS(double[] dTS) {
		DTS = dTS;
	}

	public double[] getOTS() {
		return OTS;
	}

	public void setOTS(double[] oTS) {
		OTS = oTS;
	}

	public double[] getETS() {
		return ETS;
	}

	public void setETS(double[] eTS) {
		ETS = eTS;
	}

	public double[] getGTS() {
		return GTS;
	}

	public void setGTS(double[] gTS) {
		GTS = gTS;
	}

	public double[] getCTS() {
		return CTS;
	}

	public void setCTS(double[] cTS) {
		CTS = cTS;
	}

	public double[] getCETS() {
		return CETS;
	}

	public void setCETS(double[] cETS) {
		CETS = cETS;
	}

	public double[] getMTS() {
		return MTS;
	}

	public void setMTS(double[] mTS) {
		MTS = mTS;
	}

	public double[] getMCTS() {
		return MCTS;
	}

	public void setMCTS(double[] mCTS) {
		MCTS = mCTS;
	}

	public void setAnalyHDAO(DataAnalyHDAO analyHDAO) {
		this.analyHDAO = analyHDAO;
	}

	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	public void setRatingHDAO(RatingResultsHDAO ratingHDAO) {
		this.ratingHDAO = ratingHDAO;
	}


	public void setRati(Ratingresultsh rati) {
		this.rati = rati;
	}


	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}


	public void setDataanaly(Dataanalyh dataanaly) {
		this.dataanaly = dataanaly;
	}


	public Ratingresultsh getRati() {
		return rati;
	}


	public int getAttributeId() {
		return attributeId;
	}


	public Dataanalyh getDataanaly() {
		return dataanaly;
	}



	
	
	
	
}

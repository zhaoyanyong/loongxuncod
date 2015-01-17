package com.loongxun.cbe.ratingAction;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.bean.Dataanaly;
import com.loongxun.cbe.enterprise.bean.Dataanalyh;
import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.AttributeDao;
import com.loongxun.cbe.enterprise.dao.DataAnalyHDAO;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.enterprise.dao.RatingResultsHDAO;
import com.loongxun.cbe.until.CompanyConstant;
import com.loongxun.cbe.until.PublicCompareUtil;
import com.loongxun.cbe.user.bean.Enterpriseinfo;



/**
 * 查询企业的评估报告
 *
 */
public class FindRatingReportAction {
	//输入
	private int companyId;
	private int attributeId;
	//输出
	private Ratingresultsh rating;//评级结果
	private Enterpriseinfo enter;//企业基本信息
	private Dataanalyh data;//企业数据分析结果
	private Attribute att;//企业指标信息查询结果
	private double ownerEquity;//所有者权益 需要计算
	private String aaa;//所属行业
	//企业九大指标,保持companyIndexTitle,companyIndexPoint一一对应，一个是指标的title，一个是具体企业指标值
	private String companyIndexTitle = new String("企业规模指标;偿债能力;营运能力;盈利能力;成长性指标;创新性指标;信用履约能力指标;管理水平;市场竞争力");
	private String companyIndexPoint = null;
	
	//注入DAO
	private RatingResultsHDAO ratingHDAO;
	private EnterpriseDAO enterpriseDAO;
	private DataAnalyHDAO analyHDAO;//数据分析DAO
	private AttributeDao attributeDao;
	private List<Ratingresultsh> ratingresults = new ArrayList<Ratingresultsh>();//用于显示图标。
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Dataanalyh getData() {
		return data;
	}
	public void setData(Dataanalyh data) {
		this.data = data;
	}
	public String getAaa() {
		return aaa;
	}
	public void setAaa(String aaa) {
		this.aaa = aaa;
	}
	public Enterpriseinfo getEnter() {
		return enter;
	}
	public void setEnter(Enterpriseinfo enterh) {
		this.enter = enterh;
	}
	public Attribute getAtt() {
		return att;
	}
	public void setAtt(Attribute att) {
		this.att = att;
	}
	public void setOwnerEquity(double ownerEquity) {
		this.ownerEquity = ownerEquity;
	}
	public double getOwnerEquity() {
		return ownerEquity;
	}

	
	public String getCompanyIndexTitle() {
		return companyIndexTitle;
	}
	public void setCompanyIndexTitle(String companyIndexTitle) {
		this.companyIndexTitle = companyIndexTitle;
	}
	public String getCompanyIndexPoint() {
		return companyIndexPoint;
	}
	public void setCompanyIndexPoint(String companyIndexPoint) {
		this.companyIndexPoint = companyIndexPoint;
	}
	
	public List<Ratingresultsh> getRatingresults() {
		return ratingresults;
	}
	public void setRatingresults(List<Ratingresultsh> ratingresults) {
		this.ratingresults = ratingresults;
	}
	
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public Ratingresultsh getRating() {
		return rating;
	}
	public void setRating(Ratingresultsh rating) {
		this.rating = rating;
	}
	public void setRatingHDAO(RatingResultsHDAO ratingHDAO) {
		this.ratingHDAO = ratingHDAO;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	public void setAnalyHDAO(DataAnalyHDAO analyHDAO) {
		this.analyHDAO = analyHDAO;
	}
	public void setAttributeDao(AttributeDao attributeDao) {
		this.attributeDao = attributeDao;
	}
	public String execute(){
		ratingresults.clear();
		try{
			//查询评级结果
			rating=ratingHDAO.findRathByAid(attributeId);
			//查询企业基本信息
			enter=enterpriseDAO.findById(companyId);
			//读取配置文件
			Properties pro = new Properties();
			InputStream ins=FindRatingReportAction.class.getResourceAsStream("/123.properties");  
			pro.load(ins);
			aaa=pro.getProperty(enter.getProfession().toString());
			//查询企业数据分析后的结果
			data=analyHDAO.findByEIdAndAId(companyId, attributeId);
			//查询指标信息；
			att=attributeDao.findByAbId(attributeId);
			//所有者权益
			ownerEquity=PublicCompareUtil.choice( att.getTotalAssets()-att.getGrossLiabilities());	
			
			HttpServletRequest request = ServletActionContext.getRequest(); 
			String userAgent = request.getHeader("User-Agent");
			/*if(userAgent.indexOf("MSIE 8.0")>0 || userAgent.indexOf("MSIE 7.0")>0 || userAgent.indexOf("MSIE 6.0")>0)
			{
				return "oldsuccess";
			}*/
			
			int companyStage = enter.getStage()-1;
			{
				companyIndexPoint=""+String.format("%.2f", data.getScaleMeritTotalScores() / CompanyConstant.STS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getDebtTotalScores() / CompanyConstant.DTS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getOperationTotalScores() / CompanyConstant.OTS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getEarningTotalScores() / CompanyConstant.ETS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getGrowthTotalScores() / CompanyConstant.GTS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getCreativeTotalScores() / CompanyConstant.CTS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getCreditExerciseTotalScores() / CompanyConstant.CETS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getManagerLevelTotalScores() / CompanyConstant.MTS[companyStage]*100);
				companyIndexPoint=companyIndexPoint+";"+String.format("%.2f", data.getMarketCompeteTotalScores() / CompanyConstant.MCTS[companyStage]*100);		
			}
			String [] points = companyIndexPoint.split(";");
			String [] title = companyIndexTitle.split(";");
			//System.out.println(title.length);
			for(int i = 0 ;i< title.length;i++){
				Ratingresultsh res= new Ratingresultsh();
				res.setCompanyName(title[i]);
				Double d=Double.parseDouble(points[i]);
				if(d > 100){
					points[i] = "100";
				}
				res.setCreateTime(points[i]);
				ratingresults.add(res);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
}

package com.loongxun.cbe.enterprise.action;


import com.loongxun.cbe.enterprise.bean.Dataanalyh;
import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.DataAnalyHDAO;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.enterprise.dao.RatingResultsHDAO;
import com.loongxun.cbe.enterprise.service.AttributeService;
import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 分析指标数据
 * @author 韩文场
 *
 */
public class AnalysisAction extends ActionSupport{

	private AttributeService  attributeService;
	private DataAnalyHDAO analyHDAO;//数据分析DAO
	private EnterpriseDAO enterpriseDAO;
	private RatingResultsHDAO ratingHDAO;
	public Dataanalyh dataanalyh;
	private Ratingresultsh rati;
	private Enterpriseinfo user;
	private int attributeId;
	private int enterpriseId;
	/**
	 * 产生指标分析数据
	 * @return
	 * @throws Exception
	 */
	public String Analy() throws Exception{
		int revaluation=1;
		attributeService.saveDataanaly(enterpriseId, revaluation,attributeId);
		return SUCCESS;
	}
	/**
	 * 查看指标的综合分析数据
	 * @throws Exception 
	 */
	public String comAnaly() throws Exception{
		dataanalyh = analyHDAO.findByEIdAndAId(enterpriseId, attributeId);//指标分析数据
		rati = ratingHDAO.findRathByAid(attributeId);//分析结果
		user = enterpriseDAO.findById(enterpriseId);
		return "resultjsp";
	}

	
	public void setAttributeService(AttributeService attributeService) {
		this.attributeService = attributeService;
	}
	public int getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public int getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	
	public void setAnalyHDAO(DataAnalyHDAO analyHDAO) {
		this.analyHDAO = analyHDAO;
	}

	public DataAnalyHDAO getAnalyHDAO() {
		return analyHDAO;
	}
	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}
	public RatingResultsHDAO getRatingHDAO() {
		return ratingHDAO;
	}
	public Ratingresultsh getRati() {
		return rati;
	}
	public void setRati(Ratingresultsh rati) {
		this.rati = rati;
	}
	public Dataanalyh getDataanalyh() {
		return dataanalyh;
	}
	public void setDataanalyh(Dataanalyh dataanalyh) {
		this.dataanalyh = dataanalyh;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	
	public void setRatingHDAO(RatingResultsHDAO ratingHDAO) {
		this.ratingHDAO = ratingHDAO;
	}
	
	public Enterpriseinfo getUser() {
		return user;
	}
	public void setUser(Enterpriseinfo user) {
		this.user = user;
	}

	
	
}

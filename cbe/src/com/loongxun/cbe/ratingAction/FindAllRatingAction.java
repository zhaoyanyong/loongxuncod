package com.loongxun.cbe.ratingAction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;

import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.enterprise.dao.RatingResultsHDAO;
import com.loongxun.cbe.user.bean.Enterpriseinfo;



/**
 * 描述: 查看评级结果
 * @author ZYY
 * @date 2015-1-12 上午10:41:28
 * @version 
 */
public class FindAllRatingAction {
	//
	private int page=1;
	private int pageSize=10;
	private long totalPage;
	private String createTime;
	private String orgNo;
	private String enterpriseId;//企业ID编号
	//
	private List<Ratingresultsh> ratingresults;
	
	private RatingResultsHDAO ratingHDao;
	private EnterpriseDAO enterpriseDAO;
	private Enterpriseinfo Enterpriseinfo;
	private String rs;
	
	@SuppressWarnings("unchecked")
	public String findRating(){
		try{
			
		Enterpriseinfo = enterpriseDAO.findById(Integer.parseInt(enterpriseId));
		ratingresults = ratingHDao.findById(Integer.parseInt(enterpriseId));
		/**
		List<Ratingresultsh> rr = new ArrayList<Ratingresultsh>();
		for(int i = 0;i<ratingresults.size();i++){
			ratingresults.get(i);
			
		}
		**/
		return "findRating";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "findRating";
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}


	public String getEnterpriseId() {
		return enterpriseId;
	}


	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}



	public RatingResultsHDAO getRatingHDao() {
		return ratingHDao;
	}


	public void setRatingHDao(RatingResultsHDAO ratingHDao) {
		this.ratingHDao = ratingHDao;
	}


	public void setRatingresults(List<Ratingresultsh> ratingresults) {
		this.ratingresults = ratingresults;
	}


	public EnterpriseDAO getEnterpriseDAO() {
		return enterpriseDAO;
	}


	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}


	public Enterpriseinfo getEnterpriseinfo() {
		return Enterpriseinfo;
	}


	public void setEnterpriseinfo(Enterpriseinfo enterpriseinfo) {
		Enterpriseinfo = enterpriseinfo;
	}


	public String getRs() {
		return rs;
	}


	public void setRs(String rs) {
		this.rs = rs;
	}


	public List<Ratingresultsh> getRatingresults() {
		return ratingresults;
	}


	
}


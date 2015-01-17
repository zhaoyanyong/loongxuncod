package com.loongxun.cbe.until;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 页面跳转--首页
 * @author 韩文场
 * */
public class ToFrameController extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6149683322035305726L;
	private String dir;
	private String enterpriseId;
	public String addAttribute(){
		
		return "addAttribute";
	}
	public String addEnterAttribute(){
		
		return "addEnterAttribute";
	}
	/**
	 * 定量数据查看
	 */
	public String dataview(){
		
		return "dataview";
	}
	/**
	 * 定性数据查看
	 */
	public String datashow(){
		
		return "datashow";
	}
	/**
	 * 评定介绍
	 */
	public String evaluationIntroduction(){
		
		return "evaluationIntroduction";
	}
	/**
	 * 评定查询
	 */
	public String findAllevaluation(){
		
		return "findAllevaluation";
	}
	
	/**
	 * 财务信息查询
	 */
	public String finance(){
		
		return "finance";
	}
	
	/**
	 * 财务信息录入
	 */
	public String financeAdd(){
		
		return "financeAdd";
	}
	
	/**
	 * 投融资信息查询
	 */
	public String financing(){
		
		return "financing";
	}
	
	/**
	 * 投融资信息录入
	 */
	public String financingAdd(){
		
		return "financingAdd";
	}
	
	/**
	 * 企业文化信息查询
	 */
	public String culture(){
		
		return "culture";
	}
	
	/**
	 * 企业文化信息录入
	 */
	public String cultureAdd(){
		
		return "cultureAdd";
	}
	
	
	/**
	 * 社会公众信息查询
	 */
	public String thePublic(){
		
		return "thePublic";
	}
	
	/**
	 * 社会公众信息录入
	 */
	public String thePublicAdd(){
		
		return "thePublicAdd";
	}
	
	
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	
}

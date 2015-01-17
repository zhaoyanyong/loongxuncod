package com.loongxun.cbe.dataAnalysis.action;

import java.util.ArrayList;
import java.util.List;

import com.loongxun.cbe.dataAnalysis.dao.dataAnalysisDao;
import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.bean.Dataanalyh;
import com.loongxun.cbe.enterprise.dao.AttributeDao;


/**
 * 文 件 名 : 数据分析查询页面 
 * 号：1.0
 */
public class ToDataAnalysisAction {
	private List<Dataanalyh> ab;//企业指标集合
	private AttributeDao attributeDao;
	private String enterpriseId;//企业ID编号
	private dataAnalysisDao dataAnalysisdao;
	private int aid;
	private Attribute attribute;
	private List<Attribute> abb;
	
	@SuppressWarnings("unchecked")
	public String dataview() throws Exception{
		
		ab=dataAnalysisdao.findDataAnalysisById(Integer.parseInt(enterpriseId));
		
		List<Attribute> abs=new ArrayList<Attribute>();
		if(ab != null){
			for(int i=0;i<ab.size();i++){
				aid = ab.get(i).getAttributeId();
				attribute = attributeDao.findByAbId(aid);
				abs.add(attribute);			
			}
			
		}
		
		abb=abs;
			return "dataview";
	}

	public List<Dataanalyh> getAb() {
		return ab;
	}

	public void setAb(List<Dataanalyh> ab) {
		this.ab = ab;
	}

	public AttributeDao getAttributeDao() {
		return attributeDao;
	}

	public void setAttributeDao(AttributeDao attributeDao) {
		this.attributeDao = attributeDao;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}





	public dataAnalysisDao getDataAnalysisdao() {
		return dataAnalysisdao;
	}





	public int getAid() {
		return aid;
	}





	public void setAid(int aid) {
		this.aid = aid;
	}





	public Attribute getAttribute() {
		return attribute;
	}





	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}





	public void setDataAnalysisdao(dataAnalysisDao dataAnalysisdao) {
		this.dataAnalysisdao = dataAnalysisdao;
	}





	public List<Attribute> getAbb() {
		return abb;
	}





	public void setAbb(List<Attribute> abb) {
		this.abb = abb;
	}

}

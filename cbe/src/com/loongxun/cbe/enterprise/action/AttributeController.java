package com.loongxun.cbe.enterprise.action;

import java.util.List;
import java.util.Map;

import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.dao.AttributeDao;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.SysLogDao;
import com.loongxun.cbe.user.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 指标信息控制器
 * @author 韩文场
 *
 */
public class AttributeController extends ActionSupport{

	private static final long serialVersionUID = -5545423380334720696L;
	private Attribute attribute;
	private AttributeDao attributeDao;
	private SysLogDao sysLogDao;
	private EnterpriseDAO enterpriseDAO;
	private UserDao userDao;
	private String enterpriseId;//企业ID编号
	private List<Attribute> abs;//企业指标集合
	private String attributeId;//指标信息id
	/**
	 *企业用户 录入指标信息
	 * @return
	 */
	public String addAttribute(){
		try {
			Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
			UserBase userbase = (UserBase)session.get("admin");
			if(userbase!=null){
			Enterpriseinfo  eis = enterpriseDAO.findByUsername(userbase.getAdminName());
			enterpriseId =String.valueOf(eis.getId()) ;
			attribute.setEnterpriseId(eis.getId());
			attribute.setIsDelete(0);
			attributeDao.saveAttribute(attribute);
			
			}
		} catch (Exception e) {
			System.out.println("保存行业指标错误");
			e.printStackTrace();
		}
		return "moreAttributeTWO";
	}
	/**
	 *管理人员 录入指标信息
	 * @return
	 */
	public String addEnterAttribute(){
		try {
			Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
			UserBase userbase = (UserBase)session.get("admin");
			if(userbase!=null){
			attribute.setEnterpriseId(Integer.valueOf(enterpriseId));
			attribute.setIsDelete(0);
			attributeDao.saveAttribute(attribute);
			}
		} catch (Exception e) {
			System.out.println("保存行业指标错误");
			e.printStackTrace();
		}
		return "moreAttributeTWO";
	}
	/**
	 * 查看企业指标列表
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String moreAttribute() throws Exception{
		 abs =	attributeDao.findByEpId(Integer.parseInt(enterpriseId));
		return "moreAttribute";
	}
	
	
	/**
	 * 查看企业指标列表财务管理
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public String moreAttributeJudge() throws Exception{
		 abs =	attributeDao.findByEpId(Integer.parseInt(enterpriseId));
		return "moreAttributeJudge";
	}
	
	/**
	 * 删除指标信息
	 * @return
	 * @throws Exception
	 */
	public String delAttribute() throws Exception{
		attribute = attributeDao.findByAbId(Integer.parseInt(attributeId));
		enterpriseId = String.valueOf(attribute.getEnterpriseId());
		attribute.setIsDelete(1);
		attributeDao.updateAttribute(attribute);
		return "moreAttributeTWO";
	}
	/**
	 * 查看单个指标详细信息
	 * @return
	 * @throws Exception
	 */
	public String infoAttribute()throws Exception{
		attribute = attributeDao.findByAbId(Integer.parseInt(attributeId));
		return "infoAttribute";
	}
	
	/**
	 * 查看单个指标详细信息财务管理
	 * @return
	 * @throws Exception
	 */
	public String infoAttributeJudge()throws Exception{
		attribute = attributeDao.findByAbId(Integer.parseInt(attributeId));
		return "infoAttributeJudge";
	}
	
	/**
	 * 跳转修改单个指标详细信息
	 * @return
	 * @throws Exception
	 */
	public String updateAttribute()throws Exception{
		attribute = attributeDao.findByAbId(Integer.parseInt(attributeId));
		return "updateAttribute";
	}
	/**
	 * 修改单个指标详细信息
	 * @return
	 * @throws Exception
	 */
	public String completeUpdateAttribute()throws Exception{
		try {
			Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
			UserBase userbase = (UserBase)session.get("admin");
			if(userbase!=null){
			attribute.setIsDelete(0);
			attributeDao.updateAttribute(attribute);
			
			}
			enterpriseId = String.valueOf(attribute.getEnterpriseId());
		} catch (Exception e) {
			System.out.println("修改行业指标错误");
			e.printStackTrace();
		}
		return "moreAttributeTWO";
	}
	
	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public void setAttributeDao(AttributeDao attributeDao) {
		this.attributeDao = attributeDao;
	}
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public List<Attribute> getAbs() {
		return abs;
	}

	public void setAbs(List<Attribute> abs) {
		this.abs = abs;
	}
	public String getAttributeId() {
		return attributeId;
	}
	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}
	
	
}

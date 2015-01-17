package com.loongxun.cbe.enterprise.dao;

import java.util.List;

import com.loongxun.cbe.user.bean.Enterpriseinfo;



/**
 * 企业基本信息的DAO
 * @author 韩文场
 *
 */
public interface EnterpriseDAO {
	/**
	 * 通过企业ID查询企业的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Enterpriseinfo findById(int id) throws Exception;
	
	/**
	 * 通过公司的机构代号来查询公司
	 * @param orgNo 机构代号
	 * @throws Exception
	 */
	public Enterpriseinfo findbyorgNo(String orgNo)throws Exception;

	/** 
	 *
	 * 描述: 修改企业基本信息
	 *
	 * @param einfo 企业基本信息
	 */
		void updateEnterpriseinfo(Enterpriseinfo user)throws Exception;
	
	/** 
	 *
	 * 描述: 保存企业基本信息
	 *
	 * @param einfo 企业基本信息
	 */
	public void save(Enterpriseinfo einfo) throws Exception;
	/** 
	 *
	 * 描述: 根据登录账号查找企业
	 *
	 * @param username
	 * @return 
	 * @throws Exception
	 */
	public Enterpriseinfo findByUsername(String username) throws Exception ;
	/** 
	 *
	 * 描述: 分页查询所有企业
	 *
	 * @param page,pageSize
	 * @return 
	 * @throws Exception
	 */
	public List<Enterpriseinfo> findEnterpriseinfoByPage(int page, int pageSize)throws Exception;
	/** 
	 *
	 * 描述: 查询所有企业
	 *
	 * @param 
	 * @return 
	 * @throws Exception
	 */
	public List<Enterpriseinfo> findEnterpriseinfo();
	/** 
	 *
	 * 描述：查询所有企业总页数
	 *
	 * @param pageSize
	 * @return 
	 * @throws Exception
	 */
	public int findTotalPage(int pageSize) throws Exception;
	/** 
	 *
	 * 描述：根据企业名称查询企业列表
	 *
	 * @param epname,page,pageSize
	 * @return 
	 * @throws Exception
	 */
	public List<Enterpriseinfo> findEnterpriseinfoByEpname(String epname,int page, int pageSize);
	/** 
	 *
	 * 描述：根据企业名称查询企业列表总页数
	 *
	 * @param epname,pageSize
	 * @return 
	 * @throws Exception
	 */
	public int findTotalPageByEpnam(String epname,int pageSize) throws Exception;
	/**
	 * 描述：根据企业名称查询企业列表
	 */
	public List<Enterpriseinfo> findEnterpriseinfoByEpname(String epname);
}

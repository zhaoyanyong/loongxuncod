package com.loongxun.cbe.enterprise.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.loongxun.cbe.enterprise.bean.Dataanaly;
import com.loongxun.cbe.enterprise.bean.Industrydatananly;
import com.loongxun.cbe.enterprise.bean.Ratingresults;
import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.user.bean.Enterpriseinfo;

/**
 * 数据分析的DAO
 * 
 * @author WHB
 * 
 */
public interface DataAnalyDAO {
	/**
	 * 通过企业ID查询企业 数据分析后的企业得分情况；
	 * 
	 * @param id
	 *            企业ID
	 * @return 一条数据分析的记录
	 * @Author LY
	 * @throws Exception
	 */
	public Dataanaly findById(int enterpriseId) throws Exception;

	/**
	 * @Effect 根据当前企业Id查询对应的数据分析结果
	 * @Time 2014年2月21日 13:48:17
	 * @param pageSize
	 *            页容量
	 * @param page
	 *            页码
	 * @param EnterpriseId
	 *            企业Id
	 * @Author WHB
	 * @return 数据分析的集合
	 */
	public List<Dataanaly> findDataanalyById(int page, int pageSize,
			int EnterpriseId) throws Exception;

	/**
	 * @Effect 获取总页数
	 * @Time 2014年2月21日 14:22:14
	 * @Author WHB
	 * @param pageSize
	 *            页容量
	 * @return 总页数
	 */
	// public int getTotalpage(int pageSize ,String EPName)throws Exception;
	public int getTotalpage1(int pageSize, String EPName,String OrgNo) throws Exception;

	/**
	 * @Effect 获取总记录数
	 * @Time 2014年2月21日 17:49:25
	 * @Author WHB
	 * @return 总页数
	 */
	public int getTotalCount(String EPName,String OrgNo) throws Exception;

	public int getTotalCount() throws Exception;

	/**
	 * @Effect 根据当前企业Id和时间查询对应的数据分析结果
	 * @Time 2014年2月21日 14:42:45
	 * @param EPName
	 *            企业名称
	 * @Author WHB
	 * @return 数据分析的集合
	 */
	public List<Enterpriseinfo> findAllByCondition(int page, int pageSize,
			String EPName,String OrgNo) throws Exception;

	/**
	 * 根据id查看公司指标分值
	 * 
	 * @param id
	 * @return2014年2月21日 13:50:21
	 * @throws Exception
	 */
	public Dataanaly findDataanalyById(int AnalyId) throws Exception;

	/**
	 * 保存公司指标分值实体
	 * 
	 * @param dataanaly
	 * @throws Exception
	 */
	public void saveDataanaly(Dataanaly dataanaly) throws Exception;

	// 查询所有企业
	public List<Enterpriseinfo> findAllUser(int page, int pageSize)
			throws Exception;

	public Enterpriseinfo findUser(int id) throws Exception;
	
	/**
	 * 通过企业ID查询企业 数据分析后的企业得评级结果；
	 * 
	 * @param id
	 *            企业ID
	 * @return 一条数据分析的记录
	 * @Author LY
	 * @throws Exception
	 */
	public Ratingresults findRatiById(int companyId) throws Exception;
	
	
	
	
	/**根据当前企业Id查询对应的数据分析历史结果记录
	 * @param companyId
	 * @return
	 * @throws Exception
	 */
	public List<Ratingresultsh> findRatinghById(int companyId) throws Exception;
	
	public List<Ratingresultsh> findById1(int id) throws Exception ;
	
	
	/**
	 * 通过行业编号查找行业指标数据；
	 * 
	 * @param id
	 *            企业ID
	 * @return 一条数据分析的记录
	 * @Author LY
	 * @throws Exception
	 */
	public List<Industrydatananly> findIndById(int industryRatingNo) throws Exception;
	
}

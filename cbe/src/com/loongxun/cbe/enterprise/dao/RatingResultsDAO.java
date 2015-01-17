package com.loongxun.cbe.enterprise.dao;

import java.util.List;

import com.loongxun.cbe.enterprise.bean.Operation;
import com.loongxun.cbe.enterprise.bean.Ratingresults;



/**
 * 评级管理的DAO
 * 
 * @author LY
 * 
 */
public interface RatingResultsDAO {
	/**
	 * 通过企业ID查询该企业的评级信息；
	 * 
	 * @param CompanyId
	 *            企业ID
	 * @return
	 * @throws Exception
	 */
	public Ratingresults findByCompanyId(int CompanyId) throws Exception;

	/**
	 * 管理员查看所有企业的评级结果
	 * @param createTime
	 * @param orgNo
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Ratingresults> findAllRating(String createTime,String orgNo, Integer page,Integer pageSize) throws Exception;
	/**
	 * 管理员查看所有企业的评级结果的总页数
	 * @param createTime
	 * @param orgNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public long findAllTotalPage(String createTime,String orgNo,Integer pageSize) throws Exception;
	/**
	 * 保存评级结果
	 * @param ratingResults 评级结果实体
	 * @throws Exception
	 */
	public void saveRatingResults(Ratingresults ratingResults) throws Exception;
	/**
	 * 保存初级评审报告
	 * @param operation
	 * @throws Exception
	 */
	public void saveOperation(Operation operation)throws Exception;
	/**
	 * 根据公司id查询评审报告
	 * @param companyId
	 * @return
	 * @throws Exception
	 */
	public Operation findOperByCompanyId(int companyId)throws Exception;

	
	/**
	 * 修改报告状态
	 * @param companyId
	 * @param dateString 
	 */
	public void updateReportStatus(int companyId, String dateString);
	
}

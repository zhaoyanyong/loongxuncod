package com.loongxun.cbe.enterprise.dao;

import java.util.List;

import com.loongxun.cbe.enterprise.bean.Ratingresultsh;


/**
 * 描述: 
 * @author LY
 * @date 2014-5-30 上午11:23:56
 */
public interface RatingResultsHDAO {
	/**
	 * 保存评级结果
	 * @param ratingResults 评级结果实体
	 * @throws Exception
	 */
	public void saveRatingResults(Ratingresultsh ratingh) throws Exception;
	/**
	 * 根据指标ID获取评级结果
	 */
	public Ratingresultsh findRathByAid(int aid)throws Exception;
	/**
	 * 通过条件查询企业评级信息
	 * @param year
	 * @param orgNo
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Ratingresultsh> findByCondition(int id,String createTime ,String orgNo,final int page,final int pageSize) throws Exception;
	/**
	 * 查看企业评级历史记录的总页数
	 * @param id
	 * @param createTime
	 * @param orgNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public long findTotalPage(int id,String createTime ,String orgNo,final int pageSize)throws Exception;
	/**
	 * 通过企业ID查看企业评级历史记录的详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Ratingresultsh> findById(int id) throws Exception;
	/**
	 * 管理员查看所有企业的评级历史记录
	 * @param createTime
	 * @param orgNo
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Ratingresultsh> findAllByCondition(String createTime ,String orgNo,final int page,final int pageSize) throws Exception;
	/**
	 * 管理员查看所有企业的评级历史记录的总页数
	 * @param createTime
	 * @param orgNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public long findAllTotalPage(String createTime ,String orgNo,final int pageSize)throws Exception;
}


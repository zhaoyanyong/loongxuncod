package com.loongxun.cbe.enterprise.dao;

import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.bean.CreditRating;


/**
*
* 描述：指标信息实现接口
*
* @author zft 
* @since 2014-2-21 11:19:04
* @version 1.0
*/
public interface IAttributeDao {
	/**
	 * 根据公司id查询公司指标信息
	 * @param epId 公司id
	 * @return 指标信息实体
	 * @throws Exception
	 */
	public Attribute findByEpId(int epId)throws Exception;
	/**
	 * 保存指标信息
	 * @param attribute 指标信息
	 * @throws Exception
	 */
	public void saveAttribute(Attribute attribute) throws Exception;
	/**
	 * 根据总评分获得评级实体
	 * @param allTotalScores 总评分
	 * @return 评级实体
	 * @throws Exception
	 */
	public CreditRating findCreditRating(double allTotalScores)throws Exception;
	/**
	 * 通过企业id查询企业指标信息；
	 * @param enterpriseId 企业Id
	 * @return 返回一条企业信息数据
	 * @throws Exception
	 */
	public Attribute findById(int enterpriseId) throws Exception; 
	
	
}

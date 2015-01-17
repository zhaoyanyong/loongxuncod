package com.loongxun.cbe.enterprise.dao;

import java.util.List;

import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.bean.CreditRating;


/**
*
* 描述：指标信息实现接口
*
* @author 韩文场
* @since 2014-12-11 14:19:04
* @version 1.0
*/
public interface AttributeDao {
	/**
	 * 根据公司id查询公司指标信息
	 * @param epId 公司id
	 * @return 指标信息实体集合
	 * @throws Exception
	 */
	public List<Attribute> findByEpId(int epId)throws Exception;
	/**
	 * 保存指标信息
	 * @param attribute 指标信息
	 * @throws Exception
	 */
	public void saveAttribute(Attribute attribute) throws Exception;
	
	/**
	 * 根据指标ID获得指标实体
	 *  @param attributeId  指标id
	 * @return 指标信息实体
	 * @throws Exception
	 */
	public  Attribute  findByAbId(int attributeId)throws Exception;
	/**
	 * 修改指标实体
	 * @param attribute
	 * @throws Exception
	 */
	public void updateAttribute(Attribute attribute)throws Exception;
	
	public CreditRating findCreditRating(double allTotalScores)throws Exception;
	
}

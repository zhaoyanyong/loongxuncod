package com.loongxun.cbe.dataAnalysis.dao;

import java.util.List;

import com.loongxun.cbe.enterprise.bean.Dataanalyh;

/**
*
* 描述：数据查看接口实现
*
* @author 赵延勇
* @version 1.0
*/
public interface dataAnalysisDao {
	/**
	 * 根据公司id查询数据分析
	 * @param epId 公司id
	 * @return 数据分析集合
	 * @throws Exception
	 */
	 public List<Dataanalyh> findDataAnalysisById(int epId);
}

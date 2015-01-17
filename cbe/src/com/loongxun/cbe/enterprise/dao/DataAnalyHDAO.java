package com.loongxun.cbe.enterprise.dao;

import java.util.List;

import com.loongxun.cbe.enterprise.bean.Dataanalyh;



/**
 * 描述: 数据分析历史记录结果
 * @author LY
 * @date 2014-5-30 上午10:34:04
 */
public interface DataAnalyHDAO {
	/**
	 * 保存公司指标数据到历史记录表中
	 * @param dataanaly
	 * @throws Exception
	 */
	public void saveDataanaly(Dataanalyh dataanalyh) throws Exception;
	/**
	 * 通过企业Id查看企业历史数据记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<Dataanalyh> findById(int id) throws Exception;
	/**
	 * 通过企业ID和指标ID获得记录
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public  Dataanalyh  findByEIdAndAId(int eid,int aid) throws Exception;
	/**
	 * 通过指标ID获得评级结果
	 */
	
}


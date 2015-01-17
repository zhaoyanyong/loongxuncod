package com.loongxun.cbe.user.dao;

import java.util.List;

import com.loongxun.cbe.user.bean.SystemLog;
/**
 * 日志操作接口
 * @author 韩文场
 *
 */
public interface SysLogDao {
	
	public void save(SystemLog log);
	
	public SystemLog getSystemLogById(int id);
	
	public int findTotalPage(int pageSize) throws Exception;
	
	public List<SystemLog> findSystemLogByPage(int page, int pageSize)throws Exception;
	
}

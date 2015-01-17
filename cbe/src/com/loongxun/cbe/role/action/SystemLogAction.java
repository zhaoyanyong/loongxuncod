package com.loongxun.cbe.role.action;

import java.util.List;

import com.loongxun.cbe.role.dao.RoleDao;
import com.loongxun.cbe.user.bean.SystemLog;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 系统日志action
 * @author ZhangFT
 * @since 2014年12月13日20:07:18
 */
public class SystemLogAction extends ActionSupport{
	private RoleDao roleDao;
	private List<SystemLog> systemLogs;
	private SystemLog systemLog = new SystemLog();
	private int page =1;
	private int pageSize=10;
	private int totalPage;
	private int line;
	/**
	 * 查询系统日志
	 */
	public String execute(){
		try {
			systemLogs = roleDao.findSystemLogByPram(systemLog, page, pageSize);
			line=roleDao.findLogTotalPage(systemLog, pageSize);
			totalPage = (line+pageSize-1)/pageSize;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public List<SystemLog> getSystemLogs() {
		return systemLogs;
	}

	public void setSystemLogs(List<SystemLog> systemLogs) {
		this.systemLogs = systemLogs;
	}

	public SystemLog getSystemLog() {
		return systemLog;
	}

	public void setSystemLog(SystemLog systemLog) {
		this.systemLog = systemLog;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}
	
}

package com.loongxun.cbe.role.dao;

import java.util.List;

import com.loongxun.cbe.user.bean.Rights;
import com.loongxun.cbe.user.bean.Role;
import com.loongxun.cbe.user.bean.SystemLog;
import com.loongxun.cbe.user.bean.UserBase;



/**
 * 角色接口
 * @author ZhangFT
 *
 */
public interface RoleDao {

	/**
	 * 查找所有角色
	 * @return 角色集合
	 * @throws Exception
	 */
	public List<Role> findAllRole() throws Exception;

	/**
	 * 到达修改角色页面
	 * @param id 角色id
	 * @throws Exception
	 */
	public Role findById(int id) throws Exception;
	/**
	 * 修改角色
	 * @param role 角色实体
	 * @throws Exception
	 */
	public void updateRole(Role role,List<Integer> privilegeIds) throws Exception;
	
	/** 
	 *
	 * 描述: 根据角色id获取角色拥有的所有权限
	 * @return List<Rights> 
	 * @param roleId
	 * @throws Exception 
	 */
	public List<Rights> allPrivilegeByRoleId(int roleId) throws Exception;
	/** 
	 * 描述:查找所有的权限
	 * @return 权限的集合
	 * @throws Exception 
	 */
	public List<Rights> findAllPrivilege() throws Exception;
	
	  /**
	   * 根据系统日志属性 搜索 日志
	   * @param systemLog
	   * @param page
	   * @param pageSize
	   * @return
	   * @throws Exception
	   */
	  public List<SystemLog> findSystemLogByPram(SystemLog systemLog,int page,int pageSize)throws Exception;
	  /**
	   * 查询总页数
	   * @param systemLog
	   * @param pageSize
	   * @return
	   * @throws Exception
	   */
	  public int findLogTotalPage(SystemLog systemLog,int pageSize)throws Exception;

}

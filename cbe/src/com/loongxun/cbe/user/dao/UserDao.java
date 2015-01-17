package com.loongxun.cbe.user.dao;

import java.util.List;

import com.loongxun.cbe.user.bean.UserBase;

public interface UserDao {
	
	public UserBase getId(int id);
	//根据账号查询用户
	public UserBase findByAdminName(String adminName);
	//保存用户信息
	public void save(UserBase userBase);
	
	public void updateUser(UserBase userBase);
	
	 /**
	   * 根据用户名或者性别查询管理员信息
	   * @param adminName:用户名
	   * @param sex：性别
	   * @param page
	   * @param pageSize
	   * @return 管理员基本信息
	   * @throws Exception  
	   */
	  public List<UserBase> findUserBaseByAname(UserBase userBase,int page,int pageSize)throws Exception;
	  /**
	   * 根据条件查询查询总页数
	   * @param adminName:用户名
	   * @param sex：性别
	   * @param pageSize
	   * @return 总页数
	   * @throws Exception  
	   */
	  public int findTotalPage(UserBase userBase,int pageSize)throws Exception;
}

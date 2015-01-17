package com.loongxun.cbe.user.dao;

/** 
*
* 描述: 登录功能
*
* @throws Exception
* @author 韩文场
* @since 2014-12-09下午11:22:11
*/

public interface LoginDao {
	public Object findByAdminnameAndPwd(String adminName,String password,String type) throws Exception;

	public void clearTable() throws Exception;
}

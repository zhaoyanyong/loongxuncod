package com.loongxun.cbe.user.support;

import java.net.URLDecoder;

import org.apache.struts2.json.annotations.JSON;

import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * 描述：验证企业用户名唯一性
 *
 * @author 韩文场
 * @since 2014-12-09 上午16:26:02
 * @version 1.0
 */
public class UniqueUserName extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7694414436536180180L;
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private UserDao userDao;
	private String username;// 企业用户名
	private boolean flag;// 

	
	/** 
	 *
	 * 描述: 验证企业用户名唯一性
	 *
	 * @return
	 */
	public String uniqueName() {
		try {
			
			username = URLDecoder.decode(username, "utf-8");
			
			UserBase userBase = userDao.findByAdminName(username);
			if (userBase == null) {
				flag = true;//不存在，则唯一
			} else {
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
		}

		return SUCCESS;
	}
	
	/**
	 * @return the flag
	 */
	public boolean getFlag() {
		return flag;
	}

	/**
	 * @return the username
	 */
	@JSON(serialize = false)
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @param flag
	 *            the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}

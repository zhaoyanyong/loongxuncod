package com.loongxun.cbe.user.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.loongxun.cbe.user.bean.UserBase;
import com.opensymphony.xwork2.ActionContext;


/**
 * 文件名：用户退出
 * 时间：2014-2-23 12:53:50
 * 版本：1.0
 *
 */
public class LogoutAction  {
	
	@SuppressWarnings("unchecked")
	public String logOut() {
		Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
		UserBase admin = (UserBase) session.get("admin");
		//把session中user值填为空
		if(admin==null){
			return "success";
		}
		SingleLogin.goOut(ServletActionContext.getRequest().getSession(), admin.getAdminName());
		session.remove("admin");
		session.remove("enterprise");
		session.remove("loginuser");
		session.remove("accessMap");
		return "success";
	}
}

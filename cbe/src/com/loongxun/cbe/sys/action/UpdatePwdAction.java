package com.loongxun.cbe.sys.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.loongxun.cbe.until.MD5Util;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdatePwdAction extends ActionSupport {
	private UserDao userDao;
	private String newPassword;
	private String oldPassword;

	public String execute() {
		 try {
		Map<String, Object> session = (Map<String, Object>) ActionContext
		.getContext().get(ActionContext.SESSION);
		 PrintWriter out=null; 
		 HttpServletResponse  resp=ServletActionContext.getResponse();
		 resp.setContentType("text/html;charset=utf-8");
		 resp.setCharacterEncoding("utf-8");
		 out=resp.getWriter();
		 UserBase admin = (UserBase) session.get("admin");
		 UserBase userBase = userDao.getId(admin.getAid());
		 String md3Pwd = MD5Util.string2MD5(oldPassword);
		 System.out.println();
		 if(!userBase.getPassword().equals(md3Pwd)){
		 out.print("<script>alert('旧密码输入不正确，请重新输入！')</script>");//提示信息
		 out.print("<script>window.location.href='toUpdatePassword'</script>");//跳转到查询项目
		 out.flush();
		 out.close();
		 }else{
			 md3Pwd = MD5Util.string2MD5(newPassword);
			 userBase.setPassword(md3Pwd);
			userDao.updateUser(userBase);
			out.print("<script>alert('修改成功，请重新登录！')</script>");//提示信息
			out.print("<script>top.location.href='login.jsp'</script>");//跳转到查询项目
			 out.flush();
			 out.close();
		 }
		
		
		 } catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
		return SUCCESS;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

}

package com.loongxun.cbe.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.loongxun.cbe.user.action.SingleLogin;
import com.loongxun.cbe.user.bean.UserBase;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 登录控制拦截器
 * 
 * @author Administrator
 * 
 */
public class LoginInterceptor implements Interceptor {

	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation ai) throws Exception {
		Map<String, Object> session = ai.getInvocationContext().getSession();
		UserBase loginuser = (UserBase) session.get("admin");

		HttpServletResponse response = (HttpServletResponse) ai
				.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");// 防止弹出的信息出现乱码
		PrintWriter out = response.getWriter();
		//是否在线
		Boolean isOnline = SingleLogin.isOnline(ServletActionContext.getRequest().getSession());
		
		if (loginuser == null ) {
			session.remove("admin");
			session.remove("enterprise");
			session.remove("loginuser");
			session.remove("accessMap");
			out.print("<script>alert('登录信息已过期，重新登录！')</script>");
			out.print("<script>top.location.href='login.jsp'</script>");
			out.flush();
			out.close();
			return null;
		}else if(!isOnline){
			session.remove("admin");
			session.remove("enterprise");
			session.remove("loginuser");
			session.remove("accessMap");
			out.print("<script>alert('本账号已在其他终端登录！')</script>");
			out.print("<script>top.location.href='login.jsp'</script>");
			out.flush();
			out.close();
			return null;
		}
		return ai.invoke();
	}
}

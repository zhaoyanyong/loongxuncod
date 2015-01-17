package com.loongxun.cbe.user.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.loongxun.cbe.role.dao.RoleDao;
import com.loongxun.cbe.user.bean.Rights;
import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.loongxun.cbe.user.bean.SystemLog;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.LoginDao;
import com.loongxun.cbe.user.dao.SysLogDao;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String username;
	private String password;
	private String message;
	private String messageCode;
	private String loginuser;
	private String loginCode;
	private LoginDao loginDao;
	private SysLogDao sysLogDao;
	private EnterpriseDAO enterpriseDAO;
	private RoleDao roleDao;
	private int page=1;
	private List<Enterpriseinfo> ei;


	@SuppressWarnings("unchecked")
	public String execute() throws Exception{
		Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
		UserBase loginUser = (UserBase) session.get("admin");
		if(loginUser != null || loginUser !=null){
			return "success";
		}
		String code = (String) session.get("imageCode");
		if(loginCode != null &&loginCode.length()==0){
			messageCode="验证码不能为空";
    		return "fail";
		}
		if(code==null||!code.equalsIgnoreCase(loginCode)){
			messageCode="验证码错误";
    		return "fail";
		}else{
			
			
			HashMap<String, String> accessMap = new HashMap<String, String>();
		if(loginuser != ""){
			Object o=loginDao.findByAdminnameAndPwd(username, password, loginuser);
			if(o!=null){
				String loginmessage=o.toString();
			if(loginmessage=="loock"||loginmessage.equals("loock")){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String now=sdf.format(new Date());//当前时间
				message="账号已被锁定，5分钟后尝试再次登录";
				SystemLog sl=new SystemLog();
				sl.setOpreation("账号："+username+"，登录被拒绝");
				sl.setUserName("游客");
				sl.setOpreationDate(now);
				sysLogDao.save(sl);
        		return "fail";
			}
			}
		UserBase admin=(UserBase)o;
        if(admin == null){
        		message="用户名或密码错误";
        		return "fail";
        	}else{
        		admin.setRoleName(roleDao.findById(admin.getRoleId()).getRoleName());
        		admin.setIp(getClientIp());
        		//清除系统原有保存的session
        		session.remove("admin");
        		session.remove("accessMap");
        		session.remove("enterprise");
        		session.put("admin", admin);
        		session.remove("accessMap");
        		
        		
        		//获取登录用户时不要获取loginuser  loginuser存的1  2两个数字
        		session.put("loginUserAtLine",loginuser);
        			//登录用户的权限
        		if(admin.getRoleId()!=null){
        		List<Rights> rights = roleDao.allPrivilegeByRoleId(admin.getRoleId());
        		if(rights!=null){
        			for(Rights rights2:rights){
        				accessMap.put(rights2.getRightsUrl(), "1");
        			}
        		}
        		session.put("accessMap", accessMap);
        		}
        		Boolean isEnter =SingleLogin.isAlreadyEnter(ServletActionContext.getRequest().getSession(), admin.getAdminName());
        		SystemLog sl=new SystemLog();
        		if(isEnter){
        			sl.setOpreation("账号："+username+"，在另一处登录成功");
        		}else{
        			sl.setOpreation("账号："+username+"，登录成功");
        		}
        		//添加系统日志
				sl.setUserName(username);
				sysLogDao.save(sl);
        		return "success";
        	}
        	
        }else{
        	message="选择一种登陆类型！";
        	return "fail";
        }
		}
			
		}
	
	
	public static String getClientIp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		return ip;
		}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}



	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public String getLoginCode() {
		return loginCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessageCode() {
		return messageCode;
	}



	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}



	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}
		public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public List<Enterpriseinfo> getEi() {
		return ei;
	}



	public void setEi(List<Enterpriseinfo> ei) {
		this.ei = ei;
	}
   
}

package com.loongxun.cbe.sys.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.loongxun.cbe.role.dao.RoleDao;
import com.loongxun.cbe.until.MD5Util;
import com.loongxun.cbe.user.bean.Role;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户列表action
 * @author ZhangFT
 * @since 2014年12月13日10:49:38
 *
 */
public class FindUserAction extends ActionSupport{
	private UserDao userDao;
	private RoleDao roleDao;
	private List<UserBase> userBases;
	private UserBase userBase = new UserBase();
	private List<Role> roles;
	private int page =1;
	private int pageSize=10;
	private int totalPage;
	private int line;
	private int userId;
	private String adminName;
	private int isSucc;
	/**
	 * 用户列表
	 * @return
	 */
	public String userList(){
		try {
			userBases = userDao.findUserBaseByAname(userBase, page, pageSize);
			for(UserBase userBase:userBases){
				userBase.setRoleName(roleDao.findById(userBase.getRoleId()).getRoleName());
			}
			line=userDao.findTotalPage(userBase, pageSize);
			totalPage = (line+pageSize-1)/pageSize;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 查看用户详情
	 * @return
	 */
	public String userDetail(){
		userBase = userDao.getId(userId);
		try {
			userBase.setRoleName(roleDao.findById(userBase.getRoleId()).getRoleName());
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 修改用户数据初始化
	 * @return
	 */
	public String toUpdateUser(){
		userBase = userDao.getId(userId);
		try {
			roles = roleDao.findAllRole();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 修改用户
	 * @return
	 */
	public String updateUser(){
		userDao.updateUser(userBase);
		return SUCCESS;
	}
	/**
	 * 删除用户
	 * @return
	 */
	public String delUser(){
		userBase = userDao.getId(userId);
		userBase.setIsDelete(1);
		userDao.updateUser(userBase);
		return SUCCESS;
	}
	/**
	 * 判断 用户是否存在
	 * @return
	 */
	public String checkAdminName(){
		userBase = userDao.findByAdminName(adminName);
		if(userBase==null){
			isSucc = 1;
		}else{
			isSucc=0;
		}
		return SUCCESS;
	}
	/**
	 * 保存用户
	 * @return
	 */
	public String saveUser(){
		userBase.setPassword(MD5Util.string2MD5(userBase.getPassword()));
		userBase.setIsDelete(0);
		userBase.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		userBase.setRoleId(userBase.getUserType());
		userBase.setLockTime("0");
		userBase.setInputNumber(0);
		userDao.save(userBase);
		return SUCCESS;
	}
	/**
	 * 修改密码
	 * @return
	 */
	public String updatPassword(){
		return SUCCESS;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public List<UserBase> getUserBases() {
		return userBases;
	}
	public void setUserBases(List<UserBase> userBases) {
		this.userBases = userBases;
	}
	public UserBase getUserBase() {
		return userBase;
	}
	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
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
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setIsSucc(int isSucc) {
		this.isSucc = isSucc;
	}
	public int getIsSucc() {
		return isSucc;
	}
}

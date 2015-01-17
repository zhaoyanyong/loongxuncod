package com.loongxun.cbe.role.action;

import java.util.List;

import com.loongxun.cbe.role.dao.RoleDao;
import com.loongxun.cbe.user.bean.Rights;
import com.loongxun.cbe.user.bean.Role;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 查询所有角色列表
 * @author ZhangFT
 * @since 2014年12月10日22:13:26
 */
public class FindRolesAction extends ActionSupport{
	private List<Role> roles;
	private RoleDao roleDao;
	private List<Rights> rights;
	private Role role;
	private int roleId;
	private List<Integer> privilegeIds;
	/**
	 * 查询出所有角色
	 * @return
	 */
	public String findAllRole(){
		try {
			roles = roleDao.findAllRole();
			for(Role role:roles){
				List<Rights> rights = roleDao.allPrivilegeByRoleId(role.getRoleId());
				String privilegeNames = "";
				for(Rights rights2:rights){
					privilegeNames += "," + rights2.getRightsName();
				}
				if(privilegeNames.length()>0){
					privilegeNames = privilegeNames.replaceFirst(",", "");
				}
				role.setPrivilegeNames(privilegeNames);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
	/**
	 * 修改角色数据初始化
	 * @return
	 */
	public String toUpdateRole(){
		try {
			role = roleDao.findById(roleId);
			rights = roleDao.findAllPrivilege();
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	/**
	 * 修改角色
	 * @return
	 */
	public String updateRole(){
		try {
			roleDao.updateRole(role, privilegeIds);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public List<Rights> getRights() {
		return rights;
	}
	public void setRights(List<Rights> rights) {
		this.rights = rights;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public void setPrivilegeIds(List<Integer> privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	public List<Integer> getPrivilegeIds() {
		return privilegeIds;
	}
	
}

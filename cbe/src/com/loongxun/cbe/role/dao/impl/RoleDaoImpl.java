package com.loongxun.cbe.role.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.loongxun.cbe.role.dao.RoleDao;
import com.loongxun.cbe.user.bean.Rights;
import com.loongxun.cbe.user.bean.Role;
import com.loongxun.cbe.user.bean.Rolerights;
import com.loongxun.cbe.user.bean.SystemLog;

/**
 * 角色实现类
 * @author ZhangFT
 *
 */
public class RoleDaoImpl implements RoleDao{
	private SessionFactory sessionFactory;
	/**
	 * 通过注入hibernateTemplate进行数据库的操作
	 */
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;// 通过sessionAPI操作
	}

	@Override
	public List<Rights> allPrivilegeByRoleId(int roleId) throws Exception {

		Session hs = sessionFactory.getCurrentSession();
		String hql = "from Rolerights where roleId=:roleId ";
		Query query = hs.createQuery(hql);
		query.setInteger("roleId", roleId);
		List<Rolerights> list = query.list();
		List<Rights> rights = new ArrayList<Rights>();
		if (list != null) {
			for (Rolerights rp : list) {
				String hql1 = "from Rights where rightsId=:rightsId ";
				Query query2 = hs.createQuery(hql1);
				query2.setInteger("rightsId", rp.getRightsId());
				List list2 = query2.list();
				if (list2 != null && list2.size() > 0) {
					rights.add((Rights) list2.get(0));
				}
			}
		}

		return rights;
	
	}

	@Override
	public List<Rights> findAllPrivilege() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String priviHql = "from Rights ";
		Query priviquery = session.createQuery(priviHql);
		List<Rights> privis = priviquery.list();
		return privis;
	}

	@Override
	public List<Role> findAllRole() throws Exception {
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println(session);
		String hql = "from Role ";
		Query query = session.createQuery(hql);
		List<Role> list = query.list();
		
			return list;
		
	}

	@Override
	public Role findById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Role where roleid=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		Role role = (Role) query.uniqueResult();
		String hql1 = "select rightsId from Rolerights where roleId=:roleId ";
		Query query1 = session.createQuery(hql1);
		query1.setInteger("roleId", id);
		List<Integer> privilegeIds = query1.list();
		String privilegeIds1 = "";
		for (int i = 0; i < privilegeIds.size(); i++) {
			Integer pIds = privilegeIds.get(i);
			privilegeIds1 += (i == 0) ? pIds : ("," + pIds);
		}
		role.setPrivilegeIds(privilegeIds1);
		String comments = "";
		for (int i = 0; i < privilegeIds.size(); i++) {
			Integer privilegeId = (Integer) privilegeIds.get(i);
			String priviHql = "select rightsName from Rights where rightsId=? ";
			Query priviquery = session.createQuery(priviHql);
			priviquery.setInteger(0, privilegeId);
			String comment = (String) priviquery.list().get(0);
			comments += "," + comment;
		}
		if (comments.length() > 0) {
			comments = comments.replaceFirst(",", "");
		}
		role.setPrivilegeNames(comments);
		return role;
	}

	@Override
	public void updateRole(Role role, List<Integer> privilegeIds)
			throws Exception {
		Session session = sessionFactory.getCurrentSession();
		// 根据roleId删除role_privilege
		String hql = "delete from Rolerights where roleId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, role.getRoleId());
		query.executeUpdate();
		// 添加role_privilege
		for (Integer privilegeId : privilegeIds) {
			Rolerights rp = new Rolerights();
			rp.setRoleId(role.getRoleId());
			rp.setRightsId(privilegeId);
			session.save(rp);
		}
	}

	@Override
	public int findLogTotalPage(SystemLog systemLog, int pageSize)
			throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				"select count(logId) from SystemLog where 1=1 ");
		if (systemLog.getUserName() != null && systemLog.getUserName().length() > 0) {
			sb.append(" and userName like ? ");
			paramList.add("%" + systemLog.getUserName() + "%");
		}
		String hql = sb.toString();
		Query query = session.createQuery(hql);
		for (int i = 0; i < paramList.size(); i++) {
			query.setParameter(i, paramList.get(i));
		}
		Long lines = (Long) query.list().get(0);
			return Integer.parseInt(lines+"");
	}

	@Override
	public List<SystemLog> findSystemLogByPram(SystemLog systemLog, int page,
			int pageSize) throws Exception {

		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				" from SystemLog where 0=0 ");
		
		if (systemLog.getUserName() != null && systemLog.getUserName().length() > 0) {
			sb.append(" and userName like ? ");
			paramList.add("%" + systemLog.getUserName() + "%");
		}
		sb.append(" order by opreationDate desc");
		String hql = sb.toString();
		Query query = session.createQuery(hql);
		for (int i = 0; i < paramList.size(); i++) {
			query.setParameter(i, paramList.get(i));
		}
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	
	}

}

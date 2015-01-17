package com.loongxun.cbe.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.UserDao;

public class UserDaoImpl implements UserDao {
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
	public UserBase getId(int id) {

		Session session = sessionFactory.getCurrentSession();
		UserBase user = (UserBase) session.get(UserBase.class, id);
		return user;
	}

	@Override
	public UserBase findByAdminName(String adminName) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from UserBase where adminName= ? and isDelete=0";
		List<UserBase> userBases = (List<UserBase>) hibernateTemplate.find(hql,
				new Object[] { adminName });

		UserBase userBase = null;
		if (userBases.size() > 0) {
			userBase = (UserBase) userBases.get(0);

		}
		return userBase;
	}

	@Override
	public void save(UserBase userBase) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userBase);
	}

	@Override
	public void updateUser(UserBase userBase) {
		Session session = sessionFactory.getCurrentSession();
		session.update(userBase);

	}

	@Override
	public int findTotalPage(UserBase userBase, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				"select count(id) from UserBase where isDelete=0 ");
		if (userBase.getAname() != null && userBase.getAname().length() > 0) {
			sb.append(" and aname like ? ");
			paramList.add("%" + userBase.getAname() + "%");
		}
		sb.append(" order by createTime desc");
		String hql = sb.toString();
		Query query = session.createQuery(hql);
		for (int i = 0; i < paramList.size(); i++) {
			query.setParameter(i, paramList.get(i));
		}
		Long lines = (Long) query.list().get(0);
			return Integer.parseInt(lines+"");
	}

	@Override
	public List<UserBase> findUserBaseByAname(UserBase userBase, int page,
			int pageSize) throws Exception {

		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				" from UserBase where isDelete=0 ");
		
		if (userBase.getAname() != null && userBase.getAname().length() > 0) {
			sb.append(" and aname like ? ");
			paramList.add("%" + userBase.getAname() + "%");
		}
		sb.append(" order by createTime desc");
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

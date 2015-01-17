package com.loongxun.cbe.user.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.loongxun.cbe.user.bean.SystemLog;
import com.loongxun.cbe.user.dao.SysLogDao;

public class SysLogDaoImpl implements SysLogDao{
	/**
	 * 通过注入hibernateTemplate进行数据库的操作
	 */
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate=new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;// 通过sessionAPI操作
	}
	@Override
	public void save(SystemLog log) {
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat df = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = df.format(date);
		log.setOpreationDate(time);
		session.save(log);
		
	}
	@Override
	public SystemLog getSystemLogById(int id) {
		Session session = sessionFactory.getCurrentSession();
		SystemLog sl= (SystemLog)session.get(SystemLog.class, id);
		
		return sl;
	}
	
	public List<SystemLog> findSystemLogByPage(int page, int pageSize)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from SystemLog order by OpreationDate desc";
		Query query = session.createQuery(hql);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<SystemLog> systemLogs = query.list();
		return systemLogs;
	};
	// 查询总页数
		public int findTotalPage(int pageSize) throws Exception {
			Session session = sessionFactory.getCurrentSession();
			String hql = "select count(LogId) from SystemLog ";
			Query query = session.createQuery(hql);
			int totalNum = new Integer(query.list().get(0).toString());
			if (totalNum % pageSize == 0) {
				return totalNum / pageSize;
			} else {
				return totalNum / pageSize + 1;
			}
		}
}

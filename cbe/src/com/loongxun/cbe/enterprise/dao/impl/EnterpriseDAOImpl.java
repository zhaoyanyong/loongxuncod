package com.loongxun.cbe.enterprise.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.loongxun.cbe.user.bean.SystemLog;




/**
 * 企业信息DAO的实现Impl
 * 
 * @author 韩文场
 * 
 */
public class EnterpriseDAOImpl implements EnterpriseDAO {

	private SessionFactory sessionFactory;
	/**
	 * 通过注入hibernateTemplate进行数据库的操作
	 */
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;// 通过sessionAPI操作
	}
	/**
	 * 通过企业ID查询企业基本信息；
	 */
	@SuppressWarnings("unchecked")
	public Enterpriseinfo findById(int id) throws Exception {
		String hql = "from Enterpriseinfo where id=?";
		List<Enterpriseinfo> enters= (List<Enterpriseinfo>) hibernateTemplate.find(hql, new Object[] { id });
		if(!enters.isEmpty()){
			return enters.get(0);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.elite.FA.dao.EIdao.EnterpriseDAO#findbyorgNo(java.lang.String)
	 */
	public Enterpriseinfo findbyorgNo(String orgNo) throws Exception {
		String hql = "from Enterpriseinfo where orgNo=?";
		
		List<Enterpriseinfo>  enters= (List<Enterpriseinfo>) hibernateTemplate.find(hql,
				new Object[] { orgNo });
		if(!enters.isEmpty()){
			return enters.get(0);
		}
		return null;
		
	}

	/*
	 * <p>Title: save</p> <p>Description: </p>
	 * 
	 * @param einfo
	 * 
	 * @see
	 * com.elite.FA.dao.EIdao.EnterpriseDAO#save(com.elite.FA.po.Enterpriseinfo)
	 */
	public void save(Enterpriseinfo einfo) throws Exception {
		Session hs = this.sessionFactory.getCurrentSession();
		hs.save(einfo);
	}
    

	/*
	 * <p>Title: findByUsername</p> <p>Description: </p>
	 * 
	 * @param username
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see
	 */
	public Enterpriseinfo findByUsername(String username) throws Exception {
		Session hs = this.sessionFactory.getCurrentSession();
		String hql = "from Enterpriseinfo where username=:username and deleteFlag=0";
		Query query = hs.createQuery(hql);
		query.setString("username", username);
		List list = query.list();
		Enterpriseinfo einfo = null;
		if (list.size() > 0) {
			einfo = (Enterpriseinfo) list.get(0);

		}
		return einfo;
	}
	
	
	/**
	 * 修改企业信息 
	 * @param user
	 * @throws Exception
	 */
	
		public void updateEnterpriseinfo(Enterpriseinfo user) throws Exception {
		// TODO Auto-generated method stub
		// hibernateTemplate.update(user);
	
	hibernateTemplate.saveOrUpdate(user);
		}
	@Override
	public List<Enterpriseinfo> findEnterpriseinfoByPage(int page, int pageSize)
			throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Enterpriseinfo where deleteFlag=0";
		Query query = session.createQuery(hql);
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<Enterpriseinfo> einfos = query.list();
		return einfos;
	}
	public List<Enterpriseinfo> findEnterpriseinfo(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Enterpriseinfo where deleteFlag=0";
		Query query = session.createQuery(hql);
		return query.list();
	}
	@Override
	public int findTotalPage(int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(id) from Enterpriseinfo where deleteFlag=0";
		Query query = session.createQuery(hql);
		int totalNum = new Integer(query.list().get(0).toString());
		if (totalNum % pageSize == 0) {
			return totalNum / pageSize;
		} else {
			return totalNum / pageSize + 1;
		
	}
	}
@Override
public List<Enterpriseinfo> findEnterpriseinfoByEpname(String epname,
		int page, int pageSize) {
	Session session = sessionFactory.getCurrentSession();
	StringBuffer hql = new StringBuffer(" from Enterpriseinfo where deleteFlag = 0");
	hql.append(" and epname like  '%"+epname+"%"+"'");
	Query query = session.createQuery(hql.toString());
	query.setFirstResult((page - 1) * pageSize);
	query.setMaxResults(pageSize);
	List<Enterpriseinfo> einfos = query.list();
	return einfos;
}
@Override
public int findTotalPageByEpnam(String epname,int pageSize) throws Exception {
	Session session = sessionFactory.getCurrentSession();
	StringBuffer hql = new StringBuffer("select count(*) from Enterpriseinfo where deleteFlag = 0");
	hql.append(" and epname like '%"+epname+"%"+"'");
	Query query = session.createQuery(hql.toString());
	int totalNum = new Integer(query.list().get(0).toString());
	if (totalNum % pageSize == 0) {
		return totalNum / pageSize;
	} else {
		return totalNum / pageSize + 1;
	
}
}
	@Override
		public List<Enterpriseinfo> findEnterpriseinfoByEpname(String epname) {
		Session session = sessionFactory.getCurrentSession();
		StringBuffer hql = new StringBuffer("from Enterpriseinfo where deleteFlag = 0");
		hql.append(" and epname like '"+epname+"%"+"'");
		Query query = session.createQuery(hql.toString());
			return query.list();
		}	
}

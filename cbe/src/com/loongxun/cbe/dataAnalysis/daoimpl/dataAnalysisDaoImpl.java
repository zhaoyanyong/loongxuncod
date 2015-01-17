package com.loongxun.cbe.dataAnalysis.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.loongxun.cbe.dataAnalysis.dao.dataAnalysisDao;
import com.loongxun.cbe.enterprise.bean.Dataanalyh;

public class dataAnalysisDaoImpl implements dataAnalysisDao {
	private SessionFactory sessionFactory;
	/**
	 * 通过注入hibernateTemplate进行数据库的操作
	 */
	private HibernateTemplate hibernateTemplate;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate=new HibernateTemplate(sessionFactory);
	this.sessionFactory = sessionFactory;// 通过sessionAPI操作
	}
	
	
	@Override
	public List<Dataanalyh> findDataAnalysisById(int epId) {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanalyh where enterpriseId = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, epId);
		if(query.list().size()==0){
			return null;
		}else{
			return  query.list();
		}
	}

}

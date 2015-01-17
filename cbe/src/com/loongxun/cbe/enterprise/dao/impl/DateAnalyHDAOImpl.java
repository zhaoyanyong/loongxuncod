package com.loongxun.cbe.enterprise.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.loongxun.cbe.enterprise.bean.Dataanalyh;
import com.loongxun.cbe.enterprise.dao.DataAnalyHDAO;


/**
 * 描述: 
 * @author LY
 * @date 2014-5-30 上午10:34:53
 */
public class DateAnalyHDAOImpl implements DataAnalyHDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	/* 
	 * 描述:
	 * @see com.elite.FA.dao.DADao.DataAnalyHDAO#saveDataanaly(com.elite.FA.po.Dataanaly)
	 * 上午10:43:04
	 */
	public void saveDataanaly(Dataanalyh dataanalyh) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanalyh  where enterpriseId = ? and attributeId = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, dataanalyh.getEnterpriseId());
		query.setInteger(1, dataanalyh.getAttributeId());
		if(query.list().size()!=0){
			Dataanalyh dl = (Dataanalyh)query.list().get(0);
			if(dl != null){
				session.update(dl);
			}else{
				
			}
			
		}else{
			session.save(dataanalyh);
		}
		
	
	}
	/* 
	 * 描述:
	 * @see com.elite.FA.dao.DADao.DataAnalyHDAO#findById(int)
	 * 下午02:53:38
	 */
	public List<Dataanalyh> findById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanalyh where enterpriseId=? order by createTime desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult(0);
		query.setMaxResults(10);
		return query.list();
	}
	@Override
	public Dataanalyh  findByEIdAndAId(int eid, int aid) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanalyh where enterpriseId=? and  attributeId=? order by createTime desc";
		Query query=session.createQuery(hql);
		query.setInteger(0, eid);
		query.setInteger(1, aid);
		return (Dataanalyh)query.list().get(0);
	}
	
	
}


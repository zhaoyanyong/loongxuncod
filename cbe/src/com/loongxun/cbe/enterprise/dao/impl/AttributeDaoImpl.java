package com.loongxun.cbe.enterprise.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.loongxun.cbe.enterprise.bean.Attribute;
import com.loongxun.cbe.enterprise.bean.CreditRating;
import com.loongxun.cbe.enterprise.dao.AttributeDao;

/**
*
* 描述：指标信息接口实现类
*

*/
public class AttributeDaoImpl implements AttributeDao {
	private SessionFactory sessionFactory;
	/**
	 * 通过注入hibernateTemplate进行数据库的操作
	 */
	private HibernateTemplate hibernateTemplate;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate=new HibernateTemplate(sessionFactory);
	this.sessionFactory = sessionFactory;// 通过sessionAPI操作
	}
	
	public List<Attribute> findByEpId(int epId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Attribute where enterpriseId = ? and isDelete =0";
		Query query = session.createQuery(hql);
		query.setInteger(0, epId);
		if(query.list().size()==0){
			return null;
		}else{
			return  query.list();
		}
	
	}
	
	public void saveAttribute(Attribute attribute) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.save(attribute);
	}
    
	public void updateAttribute(Attribute attribute) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(attribute);
	}
	/**
	 * 通过企业id查询企业指标信息；
	 * @param enterpriseId 企业Id
	 * @return 返回一条企业信息数据
	 * @throws Exception
	 */
	public Attribute findById(int enterpriseId) throws Exception {
		String hql="from Attribute where enterpriseId = ? ";
		List<Attribute> atts= (List<Attribute>) hibernateTemplate.find(hql, new Object[]{enterpriseId});
		if(atts.size()>0){
			return atts.get(0);
		}
		return null;
	}

	@Override
	public Attribute findByAbId(int attributeId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Attribute ab=(Attribute)session.get(Attribute.class, attributeId);
		return ab;
	}
	public CreditRating findCreditRating(double allTotalScores)
			throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from CreditRating where lowScores < ? and highScores >= ? ";
		Query query = session.createQuery(hql);
		query.setDouble(0, allTotalScores);
		query.setDouble(1, allTotalScores);
		return (CreditRating) query.uniqueResult();
	}
	

}

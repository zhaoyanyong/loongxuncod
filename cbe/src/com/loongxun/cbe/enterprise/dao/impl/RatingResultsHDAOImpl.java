package com.loongxun.cbe.enterprise.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.RatingResultsHDAO;


/**
 * 描述:
 * 
 * @author LY
 * @date 2014-5-30 上午11:24:14
 */
public class RatingResultsHDAOImpl implements RatingResultsHDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * 描述:
	 * 
	 * @see
	 * com.elite.FA.dao.ratingDao.RatingResultsHDAO#saveRatingResults(com.elite
	 * .FA.po.Ratingresultsh) 上午11:27:46
	 */
	public void saveRatingResults(Ratingresultsh ratingh) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from  Ratingresultsh where companyId=? and attributeId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, ratingh.getCompanyId());
		query.setInteger(1, ratingh.getAttributeId());
		if(query.list().size()!=0){
			Ratingresultsh  rs = (Ratingresultsh)query.list().get(0);
			ratingh.setId(rs.getId());
			
			session.merge(ratingh);
		}else{
			session.save(ratingh);
		}
	}
@Override
public Ratingresultsh findRathByAid(int aid) throws Exception {
	Session session = sessionFactory.getCurrentSession();
	String hql="from  Ratingresultsh where  attributeId=?";
	Query query = session.createQuery(hql);
	query.setInteger(0, aid);
	
	return  (Ratingresultsh)query.list().get(0);
}
	public List<Ratingresultsh> findByCondition(int id, String createTime,
			String orgNo, final int page, final int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				" from Ratingresultsh where 1=1  and companyId=? ");
		paramList.add(id);
		if (createTime!=null && createTime.length() > 0) {
			sb.append(" and createTime >= ? and createTime <= ?  ");
			paramList.add(createTime + "-01-01");
			paramList.add(createTime + "-12-31");
		}
		if (orgNo != null && orgNo.length() > 0) {
			sb.append(" and orgNo like ? ");
			paramList.add("%" + orgNo + "%");
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

	/*
	 * 描述:
	 * 
	 * @see com.elite.FA.dao.ratingDao.RatingResultsHDAO#findTotalPage(int,
	 * java.lang.String, java.lang.String, int) 上午08:57:02
	 */
	public long findTotalPage(int id, String createTime, String orgNo,
			int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				"select count(id) from Ratingresultsh where 1=1  and companyId=?  ");
		paramList.add(id);
		if (createTime!=null&& createTime.length() > 0) {
			sb.append(" and createTime >= ? and createTime <= ?  ");
			paramList.add(createTime + "-01-01");
			paramList.add(createTime + "-12-31");
		}
		if (orgNo != null && orgNo.length() > 0) {
			sb.append(" and orgNo like ? ");
			paramList.add("%" + orgNo + "%");
		}
		sb.append(" order by createTime desc");
		String hql = sb.toString();
		Query query = session.createQuery(hql);
		for (int i = 0; i < paramList.size(); i++) {
			query.setParameter(i, paramList.get(i));
		}
		Long lines = (Long) query.list().get(0);
		if (lines % pageSize == 0) {
			return (int) (lines / pageSize);
		} else {
			return (int) (lines / pageSize + 1);
		}
	}

	/*
	 * 描述:
	 * 
	 * @see com.elite.FA.dao.ratingDao.RatingResultsHDAO#findById(int)
	 * 上午08:56:26
	 */
	public List<Ratingresultsh> findById(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Ratingresultsh where companyId=? ";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		return query.list();
	}

	/* 
	 * 描述:
	 * @see com.elite.FA.dao.ratingDao.RatingResultsHDAO#findAllByCondition(java.lang.String, java.lang.String, int, int)
	 * 下午05:27:37
	 */
	public List<Ratingresultsh> findAllByCondition(String createTime,
			String orgNo, int page, int pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				" from Ratingresultsh where 1=1 ");
		if (createTime!=null && createTime.length() > 0) {
			sb.append(" and createTime >= ? and createTime <= ?  ");
			paramList.add(createTime + "-01-01");
			paramList.add(createTime + "-12-31");
		}
		if (orgNo != null && orgNo.length() > 0) {
			sb.append(" and orgNo like ? ");
			paramList.add("%" + orgNo + "%");
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

	/* 
	 * 描述:
	 * @see com.elite.FA.dao.ratingDao.RatingResultsHDAO#findAllTotalPage(java.lang.String, java.lang.String, int)
	 * 下午05:27:37
	 */
	public long findAllTotalPage(String createTime, String orgNo, int pageSize)
			throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				"select count(id) from Ratingresultsh where 1=1 ");
		if (createTime!=null&& createTime.length() > 0) {
			sb.append(" and createTime >= ? and createTime <= ?  ");
			paramList.add(createTime + "-01-01");
			paramList.add(createTime + "-12-31");
		}
		if (orgNo != null && orgNo.length() > 0) {
			sb.append(" and orgNo like ? ");
			paramList.add("%" + orgNo + "%");
		}
		sb.append(" order by createTime desc");
		String hql = sb.toString();
		Query query = session.createQuery(hql);
		for (int i = 0; i < paramList.size(); i++) {
			query.setParameter(i, paramList.get(i));
		}
		Long lines = (Long) query.list().get(0);
		if (lines % pageSize == 0) {
			return (int) (lines / pageSize);
		} else {
			return (int) (lines / pageSize + 1);
		}
	}

}

package com.loongxun.cbe.enterprise.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.loongxun.cbe.enterprise.bean.Operation;
import com.loongxun.cbe.enterprise.bean.Ratingresults;
import com.loongxun.cbe.enterprise.dao.RatingResultsDAO;

/**
 * 评级管理的实现Impl
 * 
 * @author LY
 * 
 */
public class RatingResultsDAOImpl implements RatingResultsDAO {
	/**
	 * 通过注入hibernateTemplate进行数据库的操作
	 */
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 通过企业ID查询企业的评级结果
	 */
	@SuppressWarnings("unchecked")
	public Ratingresults findByCompanyId(int CompanyId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Ratingresults where companyId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, CompanyId);
		List<Ratingresults> rrs = query.list();
		if (!rrs.isEmpty()) {
			return rrs.get(0);
		}
		return null;
	}

	public List<Ratingresults> findAllRating(String createTime,String orgNo, Integer page,
			Integer pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				" from Ratingresults where 1=1 ");
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
	 * @see com.elite.FA.dao.ratingDao.RatingResultsDAO#findAllTotalPage(java.lang.String, java.lang.String, java.lang.Integer)
	 * 上午10:51:02
	 */
	public long findAllTotalPage(String createTime, String orgNo,
			Integer pageSize) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		final List<Object> paramList = new ArrayList<Object>();
		final StringBuffer sb = new StringBuffer(
				"select count(id) from Ratingresults where 1=1 ");
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

	public void saveRatingResults(Ratingresults ratingResults) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Ratingresults where companyId = ? ";
		Query query = session.createQuery(hql);
		query.setInteger(0, ratingResults.getCompanyId());
		query.executeUpdate();
		session.save(ratingResults);
	}
	public void saveOperation(Operation operation) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(operation);
	}
	public Operation findOperByCompanyId(int companyId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Operation where companyId = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, companyId);
		List<Operation> rrs = query.list();
		if (!rrs.isEmpty()) {
			return rrs.get(0);
		}
		return null;
	}
	public void updateReportStatus(int companyId,String dateString) {
		System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Operation op set op.reportType=6,op.registrationTime='"+dateString+"' where op.companyId="+companyId);
		query.executeUpdate();
		
	}
	
}

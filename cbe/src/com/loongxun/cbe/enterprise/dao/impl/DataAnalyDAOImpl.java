package com.loongxun.cbe.enterprise.dao.impl;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.loongxun.cbe.enterprise.bean.Dataanaly;
import com.loongxun.cbe.enterprise.bean.Industrydatananly;
import com.loongxun.cbe.enterprise.bean.Ratingresults;
import com.loongxun.cbe.enterprise.bean.Ratingresultsh;
import com.loongxun.cbe.enterprise.dao.DataAnalyDAO;
import com.loongxun.cbe.user.bean.Enterpriseinfo;


/**
 * 数据分析的实现方法Impl
 *
 */
public class DataAnalyDAOImpl implements DataAnalyDAO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public Dataanaly findDataanalyById(int AnalyId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanaly where enterpriseId=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, AnalyId);
	    Dataanaly dys = (Dataanaly) query.list().get(0);
		 if(dys!=null)
			 return dys;
		 return null;
		
	}
	/**
	 * @Effect 通过当前企业Id查询对应的数据分析结果
	 * @Author LY
	 * @return 仅有一条数据分析的记录
	 */
	public Dataanaly findById(int enterpriseId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanaly where  enterpriseId=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, enterpriseId);
		List<Dataanaly> data=query.list();
		if(!data.isEmpty()){
			return data.get(0);
		}
		return null;
	}
	
	
	
	
	
	/**
	 * @Effect 根据当前企业Id查询对应的数据分析结果
	 * @Time 2014年2月21日 13:48:17
	 * @Author WHB
	 * @return 数据分析的集合
	 */
	public List<Dataanaly> findDataanalyById(int page, int pageSize,
			int EnterpriseId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanaly where EnterpriseId =:EnterpriseId ";
		Query query = session.createQuery(hql);
		query.setInteger("EnterpriseId", EnterpriseId);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Dataanaly> dataanaly = new ArrayList<Dataanaly>();
		dataanaly=query.list();
		return dataanaly;
	}
	/**
	 * @Effect 获取总页数
	 * @Time 2014年2月21日 14:01:59
	 * @Author WHB
	 * @return 总页数
	 */
	public int getTotalpage( int pageSize, int EnterpriseId)
	throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Dataanaly where EnterpriseId =:EnterpriseId ";
		Query query = session.createQuery(hql);
		query.setInteger("EnterpriseId", EnterpriseId);
		Long rows = (Long) query.list().get(0);
		if(rows % pageSize == 0)
			return (int) (rows / pageSize);
		else
			return (int) (rows / pageSize + 1);
	}
	
	/**
	 * @Effect admin获取总页数
	 * @Time 2014年2月21日 14:01:59
	 * @Author WHB
	 * @return 总页数
	 */
	public int getTotalpage(int pageSize,String EPName) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql=" select count(*) from Dataanaly where EPName like ?";
		Query query = session.createQuery(hql);
		query.setString(0, EPName);
		Long rows = (Long) query.list().get(0);
		if(rows % pageSize == 0)
			return (int) (rows / pageSize);
		else
			return (int) (rows / pageSize + 1);
	}
	/**
	 * @Effect admin根据当前企业Id和时间查询对应的数据分析结果
	 * @Time 2014年2月21日 14:42:45
	 * @param pageSize 页容量
	 * @param creditTime 分析时间
	 * @param page 页码
	 * @param EPName 企业名称
	 * @Author WHB
	 * @return 数据分析的集合
	 */
	@SuppressWarnings({ "unchecked", "null" })
	public List<Enterpriseinfo> findAllByCondition(int page ,int pageSize ,String EPName,String OrgNo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		StringBuffer   hql=new StringBuffer("from Enterpriseinfo  where  deleteFlag=0 and 1=1 "); 
		//String hql="from Enterpriseinfo where  EPName like ? ";
		     List param=new ArrayList();
		if(EPName!=null&&EPName.length()>0){
			hql.append("and epname like ?");
			param.add("%"+EPName+"%");
		}
		if(OrgNo!=null&&OrgNo.length()>0){
			hql.append("and orgNo like ?");
			param.add("%"+OrgNo+"%");
		}
		Query query = session.createQuery(hql.toString());
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize); 
		 for(int i=0;i<param.size();i++){
			 
			query.setParameter(i, param.get(i));
		 }
		//List<Enterpriseinfo> user = new ArrayList<Enterpriseinfo>();
		//user=query.list();
		return query.list();
		}
	

	/**
	 * @Effect admin获取总记录数
	 * @Time 2014年2月21日 17:49:25
	 * @Author WHB
	 * @return 总页数
	 */
	public int getTotalCount(String EPName,String OrgNo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		//String hql="select count(analyId)from Dataanaly where EPName like ? ";
		StringBuffer   hql=new StringBuffer("select count(*)from Enterpriseinfo  where  deleteFlag=0 and  1=1 ");
		  List param=new ArrayList();
		if(EPName!=null&&EPName.length()>0){
			hql.append("and epname like ?");
			param.add("%"+EPName+"%");
		}
		if(OrgNo!=null&&OrgNo.length()>0){
			hql.append("and orgNo like ?");
			param.add("%"+OrgNo+"%");
		}
		Query query = session.createQuery(hql.toString());
		 for(int i=0;i<param.size();i++){
			 
				query.setParameter(i, param.get(i));
			 }
		
		long rows = (Long) query.list().get(0);
		return (int) rows;
	}

	
	
	
	public void saveDataanaly(Dataanaly dataanaly) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="delete from Dataanaly where enterpriseId = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, dataanaly.getEnterpriseId());
		query.executeUpdate();
		session.save(dataanaly);
}

	public List<Enterpriseinfo> findAllUser(int page , int pageSize ) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Enterpriseinfo ";
		Query query = session.createQuery(hql);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		List<Enterpriseinfo> users = new ArrayList<Enterpriseinfo>();
		users=query.list();
		return users;
	}

	public int getTotalCount() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="select count(Id)from Enterpriseinfo ";
		Query query = session.createQuery(hql);
		long rows = (Long) query.list().get(0);
		return (int) rows;
	}

	public int getTotalpage1(int pageSize ,String EPName,String OrgNo) throws Exception {
		//Session session = sessionFactory.getCurrentSession();
	//	String hql="select count(*)from Enterpriseinfo ";
		//Query query = session.createQuery(hql);
		//Long rows = (Long) query.list().get(0);
	 int rows=	getTotalCount(EPName,OrgNo);
		
		if(rows % pageSize == 0)
			return (int) (rows / pageSize);
		else
			return (int) (rows / pageSize + 1);
	}

	public Enterpriseinfo findUser(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Enterpriseinfo where deleteFlag=0 and Id=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, id);
		Enterpriseinfo dys = (Enterpriseinfo) query.list().get(0);
		 if(dys!=null)
			 return dys;
		 return null;
	}

	public Ratingresults findRatiById(int companyId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Ratingresults where  companyId=?";
		Query query=session.createQuery(hql);
		query.setInteger(0, companyId);
		List<Ratingresults> rati=query.list();
		if(!rati.isEmpty()){
			return rati.get(0);
		}
		return null;
	}

	public List<Ratingresultsh> findRatinghById(int companyId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Ratingresultsh where companyId =? ";
		Query query = session.createQuery(hql);
		query.setInteger(0, companyId);		
		List<Ratingresultsh> rati = new ArrayList<Ratingresultsh>();
		rati=query.list();
		return rati;
	}
	
	public List<Ratingresultsh> findById1(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Ratingresultsh where companyId=? order by createTime desc ";
		Query query=session.createQuery(hql);
		query.setInteger(0, id);	
		query.setFirstResult(0);
		query.setMaxResults(10);
		return query.list();
	}

	public List<Industrydatananly> findIndById(int industryRatingNo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		String hql="from Industrydatananly where  industryRatingNo=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, industryRatingNo);		
		List<Industrydatananly> ind = new ArrayList<Industrydatananly>();
		ind=query.list();
		return ind;
	
}
}

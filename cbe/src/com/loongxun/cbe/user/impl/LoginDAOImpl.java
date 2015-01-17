package com.loongxun.cbe.user.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.loongxun.cbe.until.MD5Util;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.LoginDao;





public class LoginDAOImpl implements LoginDao{
	/**
	 * 通过注入hibernateTemplate进行数据库的操作
	 */
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate=new HibernateTemplate(sessionFactory);
		this.sessionFactory = sessionFactory;// 通过sessionAPI操作
	}
	
	public Object findByAdminnameAndPwd(String adminName, String password,
			String type) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date nowdate=new Date();
		String now=sdf.format(new Date());//当前时间
		Date afterDate = new Date(nowdate .getTime() -300000);//5分钟之前
		String after=sdf.format(afterDate);
		Integer tp = Integer.parseInt(type);
		String hql="from UserBase where  adminName=?  and userType=? and isDelete=0 ";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		query.setString(0, adminName);
		query.setInteger(1,tp );
		List<UserBase> userBases = query.list();
		if(!userBases.isEmpty()){
			if(userBases.size() !=1){
				return null;
			}else{
				UserBase userBase= (UserBase)userBases.get(0);
				String pasw=userBase.getPassword();
				String pwd = MD5Util.string2MD5(password);
				//得到登录用户的上次锁定时间
				
				Long userlt=Long.valueOf(userBase.getLockTime());
				Long afterlt=Long.valueOf(after);
				if(userlt>afterlt){
					return "loock";
				}
				if(pasw.equals(pwd)){
					userBase.setInputNumber(0);
				   return userBase;
				}else{
					//三次密码输入错误，锁定用户				
					int ln=userBase.getInputNumber()+1;
					userBase.setInputNumber(ln);
					if(ln>=3){
						userBase.setLockTime(now);
					}
					session.flush();
					Transaction  transaction = session.beginTransaction();//
				    transaction.begin();//
				   session.update(userBase);
				    transaction.commit();//
				    session.close(); 
					return null;
				}
			
			}
		}
		return null;
	}
	
	/* 
	 * <p>Title: clearTable</p>  
	 * <p>Description: </p>  
	 * @throws Exception   
	 * @see com.elite.FA.dao.LoginDao.LoginDAO#clearTable()  
	 */ 
	public void clearTable() throws Exception {
		Session hs = sessionFactory.getCurrentSession();
		String hql1="delete from Attribute";
		String hql2="delete from Attributeh";
		String hql3="delete from Dataanaly";
		String hql4="delete from Enterpriseinfoh";
		String hql5="delete from RatingResults";
		
		hs.createQuery(hql1).executeUpdate();
		hs.createQuery(hql2).executeUpdate();
		hs.createQuery(hql3).executeUpdate();
		hs.createQuery(hql4).executeUpdate();
		hs.createQuery(hql5).executeUpdate();
		
	}

}

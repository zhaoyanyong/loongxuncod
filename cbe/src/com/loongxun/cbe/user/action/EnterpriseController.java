/**   
 * @文件名称: EnterpriseAction.java
 * @作者：韩文场
 * @时间：2014-12-09 上午11:03:21
 * @版本：V1.0
 * @Copyright: 2014. All rights reserved.
 */
package com.loongxun.cbe.user.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.loongxun.cbe.enterprise.dao.EnterpriseDAO;
import com.loongxun.cbe.until.ImageUtils;
import com.loongxun.cbe.until.MD5Util;
import com.loongxun.cbe.user.bean.Enterpriseinfo;
import com.loongxun.cbe.user.bean.SystemLog;
import com.loongxun.cbe.user.bean.UserBase;
import com.loongxun.cbe.user.dao.SysLogDao;
import com.loongxun.cbe.user.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 描述：企业action，完成企业注册、基本信息录入
 * 
 * @author 韩文场
 * @since 2014-12-09上午11:03:21
 * @version 1.0
 */

public class EnterpriseController extends ActionSupport {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1494196074079943727L;
	private Enterpriseinfo einfo;// 企业信息
	private Enterpriseinfo enter;//用于修改与查看企业基本信息
	private UserBase userBase;//用户信息
	private String message;// 提示信息
	private EnterpriseDAO enterpriseDAO;
	private UserDao userDao;
	private SysLogDao sysLogDao;
	private List<Enterpriseinfo> ei;//登录人可读取的企业信息列表
	private String epname;
	private int page = 1;
	private int pageSize;
	private int totalPage;
	private int line;
	private String lookOrUpdate;
	private String toRight;
	private String owner;
	private String url;// 跳转链接
	private File imageTax;//税务图片
	private File imageLicense;//营业执照图片
	private File imageOrgNo;//组织机构代码图片
	private String imageTaxFileName;
	private String imageLicenseFileName;
	private String imageOrgNoFileName;
	private String imageTaxContentType;
	private String imageLicenseContentType;
	private String imageOrgNoContentType;
	
	/**
	 * 
	 * 描述: 企业注册
	 * 
	 * @return
	 * @author 韩文场
	 * @since 2014-2-21 上午11:39:19
	 */
	public String register() {

		try {
			/* 从页面获取企业信息不为空时，保存注册 */
			if (einfo != null) {// 根据行业判断轻重工业
				switch (einfo.getProfession()) {
				case 23://航天航空
				case 25://新材料
				case 28://地球、空间与海洋
				case 31://金属冶炼、金属制品业
				case 33://核应用技术
				case 35://机械设备制造
				case 38://化学化工原料及化学制品
					einfo.setIsHeavyIndustry(true);
					break;// 以上行业为重工业
				default:
					einfo.setIsHeavyIndustry(false);// 其他为轻工业
					break;
				}
				/* 获取创建时间 */
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String time = df.format(date);
				MD5Util m5u = new MD5Util();
				String psw = m5u.string2MD5(userBase.getPassword());
				userBase.setPassword(psw);
				userBase.setCreateTime(time);
				userBase.setIsDelete(0);
				userBase.setUserType(2);
				userBase.setLockTime("0");
				userBase.setInputNumber(0);
				userBase.setRoleId(2);
				userDao.save(userBase);
				//处理上传的图片内容
				String pirealpath = ServletActionContext.getServletContext().getRealPath("/images/yqtlogo.jpg");
				String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
				long now=new Date().getTime(); 
				String eid = einfo.getLicense();
				String extensionName;
				String fileName;
		        if (imageTax != null) {
		        	extensionName = imageTaxFileName.substring(imageTaxFileName.indexOf("."));
		        	fileName = now+"tax"+eid+extensionName;
		            File savefile = new File(new File(realpath), fileName);
		            if (!savefile.getParentFile().exists())
		                savefile.getParentFile().mkdirs();
		            FileUtils.copyFile(imageTax, savefile);
		            ImageUtils.resize(pirealpath, 70, 100, true);
		            ImageUtils.pressImage(savefile.getPath(), pirealpath, -1, -1, 0.5f);
		            ActionContext.getContext().put("message", "文件上传成功");
		            einfo.setTaxUrl(fileName);
		        }
		        
		        if (imageOrgNo != null) {
		        	extensionName = imageOrgNoFileName.substring(imageOrgNoFileName.indexOf("."));
		        	fileName = now+"org"+eid+extensionName;
		            File savefile = new File(new File(realpath), fileName);
		            if (!savefile.getParentFile().exists())
		                savefile.getParentFile().mkdirs();
		            FileUtils.copyFile(imageOrgNo, savefile);
		            ImageUtils.resize(pirealpath, 70, 100, true);
		            ImageUtils.pressImage(savefile.getPath(), pirealpath, -1, -1, 0.5f);
		            ActionContext.getContext().put("message", "文件上传成功");
		            einfo.setOrgNoUrl(fileName);
		        }
		        if (imageLicense != null) {
		        	extensionName = imageLicenseFileName.substring(imageLicenseFileName.indexOf("."));
		        	fileName = now+"lic"+eid+extensionName;
		            File savefile = new File(new File(realpath), fileName);
		            if (!savefile.getParentFile().exists())
		                savefile.getParentFile().mkdirs();
		            FileUtils.copyFile(imageLicense, savefile);
		            ImageUtils.resize(pirealpath, 70, 100, true);
		            ImageUtils.pressImage(savefile.getPath(), pirealpath, -1, -1, 0.5f);
		            ActionContext.getContext().put("message", "文件上传成功");
		            einfo.setLicenseUrl(fileName);
		        }
				einfo.setUsername(userBase.getAdminName());
				einfo.setCreateTime(time);
				einfo.setDeleteFlag(0);
				enterpriseDAO.save(einfo);
				/***添加系统日志**/
				SystemLog sl=new SystemLog();
				sl.setOpreation("账号："+userBase.getAdminName()+"，注册成功");
				sl.setUserName("游客");
				sl.setOpreationDate(time);
				sysLogDao.save(sl);
				message="您已注册成功，请登录！";
				url="login.jsp";
				return SUCCESS;
				
			} else {
				message = "请录入企业信息";
				url="register.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "注册失败，请重新注册！";
			url="register.jsp";
		}
		return "failure";
	}
	/***
	 * 根据登录者获取企业信息
	 * @return
	 * @throws Exception 
	 */
	public String enterpriseInfo() throws Exception{
		@SuppressWarnings("unchecked")
		Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
		UserBase admin = (UserBase) session.get("admin");
		//登录用户获取企业信息
		int pageSize = 10;
		if(admin.getUserType()!=2){
			totalPage = enterpriseDAO.findTotalPage(pageSize);
			ei = enterpriseDAO.findEnterpriseinfoByPage(page, pageSize);
			List<Enterpriseinfo> epl=null;
			epl = enterpriseDAO.findEnterpriseinfo();
			session.put("cureeenter", epl.get(0));
			if(!epl.equals(null)){
				line = epl.size();
			}
		}else{
			ei=new ArrayList<Enterpriseinfo>();
			Enterpriseinfo einfo =	enterpriseDAO.findByUsername(admin.getAdminName());
			ei.add(einfo);
			session.put("ei", ei);
			session.put("cureeenter", ei.get(0));
		}
		if(toRight.equalsIgnoreCase("toGovernment")){
			return "right";
		}else if(toRight.equalsIgnoreCase("listAttribute")){
			return "listAttribute";
		}
		
		return SUCCESS;
	}
	
	
	/***
	 * 根据登录者获取企业信息财务管理
	 * @return
	 * @throws Exception 
	 */
	public String findJudge() throws Exception{
		@SuppressWarnings("unchecked")
		Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
		UserBase admin = (UserBase) session.get("admin");
		//登录用户获取企业信息
		int pageSize = 10;
		if(admin.getUserType()!=2){
			totalPage = enterpriseDAO.findTotalPage(pageSize);
			ei = enterpriseDAO.findEnterpriseinfoByPage(page, pageSize);
			List<Enterpriseinfo> epl=null;
			epl = enterpriseDAO.findEnterpriseinfo();
			if(epl!=null &&!epl.equals(null)){
				line = epl.size();
			}
		}else{
			ei=new ArrayList<Enterpriseinfo>();
			Enterpriseinfo einfo =	enterpriseDAO.findByUsername(admin.getAdminName());
			ei.add(einfo);
			session.put("ei", ei);
		}
		if(toRight.equalsIgnoreCase("toGovernment")){
			return "right";
		}else if(toRight.equalsIgnoreCase("listAttributeJudge")){
			return "listAttributeJudge";
		}
		
		return SUCCESS;
	}
	
	
	
	/**
	 * 企业用户名查询并分页显示
	 * @return
	 * @throws Exception 
	 */
	public String searchEnterprise() throws Exception{
		epname = new String(epname.getBytes("ISO-8859-1"),"UTF-8"); 
			int pageSize = 10;
			totalPage = enterpriseDAO.findTotalPageByEpnam(epname,pageSize);
			ei = enterpriseDAO.findEnterpriseinfoByEpname(epname, page,  pageSize);
			List<Enterpriseinfo> epl=null;
			epl = enterpriseDAO.findEnterpriseinfoByEpname(epname);
			if(epl!=null &&!epl.equals(null)){
				line = epl.size();
			}
			if(toRight.equalsIgnoreCase("toGovernment")){
				return "right";
			}else if(toRight.equalsIgnoreCase("listAttribute")){
				return "listAttribute";
			}
			return SUCCESS;
	}
	/**
	 * 企业信息修改跳转
	 * @return
	 * @throws Exception 
	 */
	public  String toUpdateEnterprise() throws Exception{
	
		Map<String , Object> session=(Map<String ,Object>)ActionContext.getContext().get(ActionContext.SESSION);
		UserBase userBase=(UserBase)session.get("admin");
		
		enter=enterpriseDAO.findByUsername(owner);
			
		session.put("cureeenter", enter);
		if(lookOrUpdate.equals("look")){
			return "LOOK";
		}else{
			return "UPDATE";
			
		}
	}
	/**
	 * 企业信息修改
	 * @return
	 */
	public String updateEnterprise()throws Exception{
		try {
			if (enter != null) {// 根据行业判断轻重工业
				switch (enter.getProfession()) {
				case 23://航天航空
				case 25://新材料
				case 28://地球、空间与海洋
				case 31://金属冶炼、金属制品业
				case 33://核应用技术
				case 35://机械设备制造
				case 38://化学化工原料及化学制品
					enter.setIsHeavyIndustry(true);
					break;// 以上行业为重工业
				default:
					enter.setIsHeavyIndustry(false);// 其他为轻工业
					break;
				}
			}
		     
			//处理上传的图片内容
			String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
			String pirealpath = ServletActionContext.getServletContext().getRealPath("/images/yqtlogo.jpg");
		
			long now=new Date().getTime(); 
			String eid = enter.getLicense();
			String extensionName;
			String fileName;
	        if (imageTax != null) {
	        	extensionName = imageTaxFileName.substring(imageTaxFileName.indexOf("."));
	        	fileName = now+"tax"+eid+extensionName;
	            File savefile = new File(new File(realpath), fileName);
	            if (!savefile.getParentFile().exists())
	                savefile.getParentFile().mkdirs();
	            FileUtils.copyFile(imageTax, savefile);
	            ImageUtils.resize(pirealpath, 70, 100, true);
	            ImageUtils.pressImage(savefile.getPath(), pirealpath, -1, -1, 0.5f);
	            ActionContext.getContext().put("message", "文件上传成功");
	            enter.setTaxUrl(fileName);
	        }
	        
	        if (imageOrgNo != null) {
	        	extensionName = imageOrgNoFileName.substring(imageOrgNoFileName.indexOf("."));
	        	fileName = now+"org"+eid+extensionName;
	            File savefile = new File(new File(realpath), fileName);
	            
	            if (!savefile.getParentFile().exists())
	                savefile.getParentFile().mkdirs();
	            FileUtils.copyFile(imageOrgNo, savefile);
	            ActionContext.getContext().put("message", "文件上传成功");
	            ImageUtils.resize(pirealpath, 70, 100, true);
	            ImageUtils.pressImage(savefile.getPath(), pirealpath, -1, -1, 0.8f);
	            enter.setOrgNoUrl(fileName);
	        }
	        if (imageLicense != null) {
	        	
	        	extensionName = imageLicenseFileName.substring(imageLicenseFileName.indexOf("."));
	        	fileName = now+"lic"+eid+extensionName;
	            File savefile = new File(new File(realpath), fileName);
	            if (!savefile.getParentFile().exists())
	                savefile.getParentFile().mkdirs();
	            FileUtils.copyFile(imageLicense, savefile);
	            ImageUtils.resize(pirealpath, 70, 100, true);
	            ImageUtils.pressImage(savefile.getPath(), pirealpath, -1, -1, 0.8f);
	            ActionContext.getContext().put("message", "文件上传成功");
	            enter.setLicenseUrl(fileName);
	        }
			enterpriseDAO.updateEnterpriseinfo(enter);
			toRight="toGovernment";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "findEnter";
	}
	public String delateEnterprise()throws Exception{
		
		Enterpriseinfo delEnt=enterpriseDAO.findByUsername(owner);
		delEnt.setDeleteFlag(1);
		enterpriseDAO.updateEnterpriseinfo(delEnt);
		UserBase ub=userDao.findByAdminName(owner);
		ub.setIsDelete(1);
		userDao.updateUser(ub);
		toRight="toGovernment";
		return "del";
	}
	public UserBase getUserBase() {
		return userBase;
	}

	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}

	/**
	 * @return the einfo
	 */
	public Enterpriseinfo getEinfo() {
		return einfo;
	}

	/**
	 * @param einfo
	 *            the einfo to set
	 */
	public void setEinfo(Enterpriseinfo einfo) {
		this.einfo = einfo;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param enterpriseDAO
	 *            the enterpriseDAO to set
	 */
	public void setEnterpriseDAO(EnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}


	public File getImageTax() {
		return imageTax;
	}

	public void setImageTax(File imageTax) {
		this.imageTax = imageTax;
	}

	public File getImageLicense() {
		return imageLicense;
	}

	public void setImageLicense(File imageLicense) {
		this.imageLicense = imageLicense;
	}

	public File getImageOrgNo() {
		return imageOrgNo;
	}

	public void setImageOrgNo(File imageOrgNo) {
		this.imageOrgNo = imageOrgNo;
	}

	public String getImageTaxContentType() {
		return imageTaxContentType;
	}

	public void setImageTaxContentType(String imageTaxContentType) {
		this.imageTaxContentType = imageTaxContentType;
	}

	public String getImageLicenseContentType() {
		return imageLicenseContentType;
	}

	public void setImageLicenseContentType(String imageLicenseContentType) {
		this.imageLicenseContentType = imageLicenseContentType;
	}

	public String getImageOrgNoContentType() {
		return imageOrgNoContentType;
	}

	public void setImageOrgNoContentType(String imageOrgNoContentType) {
		this.imageOrgNoContentType = imageOrgNoContentType;
	}

	public String getImageTaxFileName() {
		return imageTaxFileName;
	}

	public void setImageTaxFileName(String imageTaxFileName) {
		this.imageTaxFileName = imageTaxFileName;
	}

	public String getImageLicenseFileName() {
		return imageLicenseFileName;
	}

	public void setImageLicenseFileName(String imageLicenseFileName) {
		this.imageLicenseFileName = imageLicenseFileName;
	}

	public String getImageOrgNoFileName() {
		return imageOrgNoFileName;
	}

	public void setImageOrgNoFileName(String imageOrgNoFileName) {
		this.imageOrgNoFileName = imageOrgNoFileName;
	}
	public List<Enterpriseinfo> getEi() {
		return ei;
	}
	public void setEi(List<Enterpriseinfo> ei) {
		this.ei = ei;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getEpname() {
		return epname;
	}
	public void setEpname(String epname) {
		this.epname = epname;
	}
	public String getLookOrUpdate() {
		return lookOrUpdate;
	}
	public void setLookOrUpdate(String lookOrUpdate) {
		this.lookOrUpdate = lookOrUpdate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Enterpriseinfo getEnter() {
		return enter;
	}
	public void setEnter(Enterpriseinfo enter) {
		this.enter = enter;
	}
	public String getToRight() {
		return toRight;
	}
	public void setToRight(String toRight) {
		this.toRight = toRight;
	}

	
	
}

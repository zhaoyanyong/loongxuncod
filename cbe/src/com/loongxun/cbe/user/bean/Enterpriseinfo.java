package com.loongxun.cbe.user.bean;

/**
 * /**
 * 
 * 企业基本信息表字段 Enterpriseinfo entity.
 *  @author 韩文场
 */

public class Enterpriseinfo implements java.io.Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 4645496292388533080L;
	private Integer id;
	private String epname;// 企业名称
	private String orgNo;// 机构代码
	private String username;// 企业账号
	private String address;// 企业地址
	private String postcode;// 邮政编号
	private String registAddress;// 注册地址
	private Double registMoney;// 注册资金
	private String contacts;// 企业联系人
	private String contactPhone;// 联系人电话
	private String contactEmail;// 联系人邮箱
	private String legalPerson;// 企业法人代表
	private String legalPhone;// 法人代表电话
	private String legalEmail;// 法人代表邮箱
	private Integer area;// 企业所属地区
	private Integer profession;// 企业所属行业
	private Integer property;// 企业所属性质
	private Integer charac;// 企业所属特性
	private String staff;// 企业员工总数
	private String colleageStaff;// 大专及以上毕业生的员工数
	private String technicalStaff;// 技术人员数量
	private String manageStaff;// 管理人员数量
	private String womenStaff;
	private String minorityStaff;
	private Integer stage;// 企业所属阶段(生命周期) 1初创 2成长 3稳定
	private boolean isHeavyIndustry;// 是否为重工业
	private String otherProperty;// 其他企业性质
	private String otherCharac;// 其他企业特性
	private String createTime;// 创建时间
	private Integer deleteFlag;// 删除标志0：正常；1：删除
	private String license;//营业执照
	private String tax;//税务登记证
	private String licenseUrl;
	private String taxUrl;
	private String orgNoUrl;


    // Constructors

    /** default constructor */
    public Enterpriseinfo() {
    }

	/** minimal constructor */

	public Enterpriseinfo(Integer id, String epname, String orgNo,
			String username, String address, String postcode,
			String registAddress, Double registMoney, String contacts,
			String contactPhone, String contactEmail, String legalPerson,
			String legalPhone, String legalEmail, Integer area,
			Integer profession, Integer property, Integer charac, String staff,
			String colleageStaff, String technicalStaff, String manageStaff,
			Integer stage, boolean isHeavyIndustry, String otherProperty,
			String otherCharac, String createTime, Integer deleteFlag,
			String license, String tax, String licenseUrl, String taxUrl,
			String orgNoUrl, String womanStaff,String minorityStaff) {
		super();
		this.id = id;
		this.womenStaff=womanStaff;
		this.minorityStaff=minorityStaff;
		this.epname = epname;
		this.orgNo = orgNo;
		this.username = username;
		this.address = address;
		this.postcode = postcode;
		this.registAddress = registAddress;
		this.registMoney = registMoney;
		this.contacts = contacts;
		this.contactPhone = contactPhone;
		this.contactEmail = contactEmail;
		this.legalPerson = legalPerson;
		this.legalPhone = legalPhone;
		this.legalEmail = legalEmail;
		this.area = area;
		this.profession = profession;
		this.property = property;
		this.charac = charac;
		this.staff = staff;
		this.colleageStaff = colleageStaff;
		this.technicalStaff = technicalStaff;
		this.manageStaff = manageStaff;
		this.stage = stage;
		this.isHeavyIndustry = isHeavyIndustry;
		this.otherProperty = otherProperty;
		this.otherCharac = otherCharac;
		this.createTime = createTime;
		this.deleteFlag = deleteFlag;
		this.license = license;
		this.tax = tax;
		this.licenseUrl = licenseUrl;
		this.taxUrl = taxUrl;
		this.orgNoUrl = orgNoUrl;
	}

	// Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEpname() {
        return this.epname;
    }
    
    public void setEpname(String epname) {
        this.epname = epname;
    }

    public String getOrgNo() {
        return this.orgNo;
    }
    
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegistAddress() {
        return this.registAddress;
    }
    
    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress;
    }

    public Double getRegistMoney() {
        return this.registMoney;
    }
    
    public void setRegistMoney(Double registMoney) {
        this.registMoney = registMoney;
    }

    public String getContacts() {
        return this.contacts;
    }
    
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }
    
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }
    
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLegalPerson() {
        return this.legalPerson;
    }
    
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalPhone() {
        return this.legalPhone;
    }
    
    public void setLegalPhone(String legalPhone) {
        this.legalPhone = legalPhone;
    }

    public String getLegalEmail() {
        return this.legalEmail;
    }
    
    public void setLegalEmail(String legalEmail) {
        this.legalEmail = legalEmail;
    }

    public Integer getArea() {
        return this.area;
    }
    
    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getProfession() {
        return this.profession;
    }
    
    public void setProfession(Integer profession) {
        this.profession = profession;
    }

    public Integer getProperty() {
        return this.property;
    }
    
    public void setProperty(Integer property) {
        this.property = property;
    }

    public Integer getCharac() {
        return this.charac;
    }
    
    public void setCharac(Integer charac) {
        this.charac = charac;
    }

    public String getStaff() {
        return this.staff;
    }
    
    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getColleageStaff() {
        return this.colleageStaff;
    }
    
    public void setColleageStaff(String colleageStaff) {
        this.colleageStaff = colleageStaff;
    }

    public String getTechnicalStaff() {
        return this.technicalStaff;
    }
    
    public void setTechnicalStaff(String technicalStaff) {
        this.technicalStaff = technicalStaff;
    }

    public String getManageStaff() {
        return this.manageStaff;
    }
    
    public void setManageStaff(String manageStaff) {
        this.manageStaff = manageStaff;
    }

    public Integer getStage() {
        return this.stage;
    }
    
    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Boolean getIsHeavyIndustry() {
        return this.isHeavyIndustry;
    }
    
    public void setIsHeavyIndustry(Boolean isHeavyIndustry) {
        this.isHeavyIndustry = isHeavyIndustry;
    }

    public String getOtherProperty() {
        return this.otherProperty;
    }
    
    public void setOtherProperty(String otherProperty) {
        this.otherProperty = otherProperty;
    }

    public String getOtherCharac() {
        return this.otherCharac;
    }
    
    public void setOtherCharac(String otherCharac) {
        this.otherCharac = otherCharac;
    }

    public String getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public void setHeavyIndustry(boolean isHeavyIndustry) {
		this.isHeavyIndustry = isHeavyIndustry;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public String getTaxUrl() {
		return taxUrl;
	}

	public void setTaxUrl(String taxUrl) {
		this.taxUrl = taxUrl;
	}

	public String getOrgNoUrl() {
		return orgNoUrl;
	}

	public void setOrgNoUrl(String orgNoUrl) {
		this.orgNoUrl = orgNoUrl;
	}

	public String getWomenStaff() {
		return womenStaff;
	}

	public void setWomenStaff(String womenStaff) {
		this.womenStaff = womenStaff;
	}

	public String getMinorityStaff() {
		return minorityStaff;
	}

	public void setMinorityStaff(String minorityStaff) {
		this.minorityStaff = minorityStaff;
	}
   

}
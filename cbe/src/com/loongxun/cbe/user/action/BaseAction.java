package com.loongxun.cbe.user.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于页面跳转 传参的action
 * @author ZhangFT
 *
 */
public class BaseAction extends ActionSupport{
	private int id;
	public String execute(){
	
		return SUCCESS;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	}


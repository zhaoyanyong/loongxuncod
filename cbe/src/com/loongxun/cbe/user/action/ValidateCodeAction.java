package com.loongxun.cbe.user.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.log4j.Logger;

import com.loongxun.cbe.until.ImageUtil;
import com.opensymphony.xwork2.ActionContext;
/**
 * @Effect 更换验证码
 * @Time  2014-12-9 11:03:52
 * @Author 
 */
public class ValidateCodeAction {
	static Logger logger = Logger.getLogger(ValidateCodeAction.class.getName());
	
	private InputStream codeStream;
	
	public String execute() {
		Map<String, BufferedImage> imageMap = ImageUtil.createImage();
		String code = imageMap.keySet().iterator().next();
		Map session=(Map)ActionContext.getContext().get(ActionContext.SESSION);
	    session.put("imageCode", code);
		BufferedImage image = imageMap.get(code);
		try {
			codeStream = ImageUtil.getInputStream(image);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public InputStream getCodeStream() {
		return codeStream;
	}

	public void setCodeStream(InputStream codeStream) {
		this.codeStream = codeStream;
	}

	
}

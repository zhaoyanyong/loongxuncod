<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="js/sample.js"></script>
		<title>message</title>
		<style type="text/css">
table {
	border-right:1px #a8c7ce solid;
	border-top:1px #a8c7ce solid;
	}
td {
	border-left:1px #a8c7ce solid;
	border-bottom:1px #a8c7ce solid;
	height:28px;
	text-align:left;
	padding-left:1%;
	}
body {
	font-family:"宋体";
	font-size:13px;
	}
a {
	font-family:"宋体";
	font-size:13px;
	text-decoration:none;
	color:#fff;
	}
</style>

	</head>
	<body>
		
			<div style="margin-right:0.5%"><img src="images/right.png" width="100%" height="524"></div>
        
        <div style="position:absolute; top:2%; left:2%; width:10px;"><img src="images/right-bai.jpg" height="8" width="8"></div>
        
<div style="position: absolute; top: 1%; left: 3%; width: 350px;">
			当前登录的用户：<span style="font-weight: bold;font-size: 18px;">${admin.aname }</span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：<span style="font-weight: bold;font-size: 16px;">${admin.roleName }</span>
		</div>

		<div style="position: absolute; top: 2%; left: 85.5%; width: 10px;">
			<img src="images/right-sanjiao.png" width="8" height="8">
		</div>

		<div style="position: absolute; top: 1.6%; left: 87%; width: 30px;">
			IP:${admin.ip }
		</div>      
      <div style="position: absolute; top: 7%; left: 1%; width: 30px;"><img src="images/right-dangqian.png" width="20" height="20"></div>
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：分析成功</div>
        <div style="position: absolute; top: 6.5%; left: 93%; width: 200px; color:#FFF;">
		<div style="float: left; margin-top: 3%; margin-left: 5%;"
			onclick=
	window.history.back();
>
			<img src="images/right-fanhui.png" width="13" height="13" />
		</div>
		<div style="float: left; margin-top: 3%"
			onclick=
	window.history.back();;
>
			返回
		</div>
		</div>
			
       
			<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
			</br>
	
		<span style="color:green;font-size:20px;">分析成功</span>
		</div>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>模板</title>

<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
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
	color:#000;
	}
.btn {
	background-image:url(images/right-anniubg1.png);
	border:0px;
	width:20px;
	height:20px;
	line-height:20px;
	}
</style>
</head>
  
  <body>
  	
   <div style="margin-right:0.5%">
			<img src="images/right.png" width="100%" height="524">
		</div>
		<div style="position:absolute; top:2%; left:2%; width:10px;">
			<img src="images/right-bai.jpg" height="8" width="8">
		</div>

	<div style="position: absolute; top: 1.6%; left: 3%; width: 320px;">
			当前登录的用户：<span style="font-weight: bold;font-size: 18px;">${admin.aname }</span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：<span style="font-weight: bold;font-size: 16px;">${admin.roleName }</span>
		</div>

		<div style="position: absolute; top: 2%; left: 85.5%; width: 10px;">
			<img src="images/right-sanjiao.png" width="8" height="8">
		</div>

		<div style="position: absolute; top: 1.6%; left: 87%; width: 30px;">
			IP:${admin.ip }
		</div>
        
      <div style="position: absolute; top: 7%; left: 1%; width: 30px;"><img src="images/right-dangqian.png" width="20" height="20"></div>
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：企业文化信息录入</div>
        
        <div style="position: absolute; top: 6.5%; left: 85%; width: 200px; color:#FFF;">
        	<div style="float:left; margin-top:3%"><img src="images/right-jiahao.png" width="13" height="13"></div>
            <div style="float:left; margin-top:3%">添加</div>
            <div style="float:left; margin-top:3%; margin-left:5%"><img src="images/right-lese.png" width="13" height="13"></div>
            <div style="float:left; margin-top:3%">删除</div>
            <div style="float:left; margin-top:3%; margin-left:5%""><img src="images/right-bianji.png" width="13" height="13"></div>
            <div style="float:left; margin-top:3%">编辑</div>
        </div>
        
        
        
    	
    	<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
        	<div style="width:98.5%;">
            	
   			</div>
         </div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
	text-align:center;
	}
body {
	font-family:"宋体";
	font-size:13px;
	}
.btn {
	background-image:url(images/right-anniubg1.png);
	border:0px;
	width:86px;
	height:20px;
	line-height:20px;}
</style>
</head>

<body>
	<div>
		<div style="margin-right:0.5%"><img src="images/right.png" width="100%" height="524"></div>
        
        <div style="position:absolute; top:2%; left:2%; width:10px;"><img src="images/right-bai.jpg" height="8" width="8"></div>
        
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：角色信息查询</div>
        
        
        <div style="width:100%; height:450px; position:absolute; top:12%; left:0.4%;">
        	<div style="width:98.5%; height:100%;">
            <!-- table内嵌样式 -->
       		<table cellpadding="0" cellspacing="0" width="100%">
            	<tr style="background-color:#d3eaf0;">
                    <td width="10%" style=" font-size:14px">序号</td>
                    <td width="12%" style=" font-size:14px">角色名称</td>
                    <td width="68%" style=" font-size:14px">拥有权限</td>
                    <td width="10%" style=" font-size:14px">编辑</td>
                </tr>
                <s:iterator value="roles" status="L">
                <tr>
                    <td>&nbsp;<s:property value="#L.index+1" /></td>
                    <td>&nbsp;<s:property value="roleName" /></td>
                    <td><p align="left" style="line-height: 20px;"><s:property value="privilegeNames" /></p></td>
                    <td>&nbsp;<img src="images/037.gif" width="9" height="9" />
											<span class="STYLE1"> [</span>
											<a href="toUpdateRole?roleId=<s:property value="roleId" />">编辑</a>
											<span class="STYLE1">]</span></td>
                </tr>
                </s:iterator>
            </table>
            </div>
        </div>
    </div>
</body>
</html>

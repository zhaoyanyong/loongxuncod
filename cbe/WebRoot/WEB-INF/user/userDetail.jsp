﻿<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>录入员工信息</title>
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<link  href="css/right.css" rel="stylesheet" type="text/css"/>
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
</style>

</head>

<body>
<form action="addAdmin.action" method="post" id="loginForm">

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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：用户信息查看</div>
         <div style="position: absolute; top: 6.5%; left: 93%; width: 200px; color:#FFF;">
            <div style="float:left; margin-top:3%; margin-left:5%;" onclick="window.history.back();" ><img src="images/right-fanhui.png" width="13" height="13" /></div>
            <div style="float:left; margin-top:3%" onclick="window.history.back();">返回</div>
        </div>
	<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
					<div style="width:98.5%; height:100%; margin-top:0.5%;">
					<table cellpadding="0" cellspacing="0" width="100%" align="left">
						<tr align="center" class="trBg">
							<td height="21"  width="10%">
								<div align="center" >
								&nbsp;帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：   </div>
							</td>
							<td height="21"  width="37%" align="left">
								<s:property value="userBase.adminName" />
							</td>
						
						</tr>
						<tr align="center" class="trBg">
								<td height="21" width="13%">
								<div align="center" >
								用&nbsp;户&nbsp;名：  </div>
							</td>
							<td height="21"  width="40%" align="left">
                          	<s:property value="userBase.aname" />
							</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="21" >
								<div align="center" >&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别： </div>
							</td>
							<td height="21" align="left">
                             <s:if test="userBase.sex==0"> 女</s:if>
									<s:elseif test="userBase.sex==1">男</s:elseif>
							</td>
							</tr>
							<tr align="center" class="trBg">
								<td height="21" width="13%">
								<div align="center" >
								用户类型：  </div>
							</td>
							<td height="21"  width="40%" align="left">
                          	<s:if test="userBase.userType==1"> 管理员</s:if>
									<s:elseif test="userBase.userType==2">企业用户</s:elseif>
									<s:elseif test="userBase.userType==3">银行用户</s:elseif>
							</td>
						</tr>
								<tr align="center" class="trBg">
							<td height="21" >
								<div align="center" >&nbsp;角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色： </div>
							</td>
							<td height="21" align="left">
                            	<s:property value="userBase.roleName" />
							</td>
							</tr>
							
							
							 <tr align="left" class="trBg">
							<td height="21">
								<div align="center" >&nbsp; 备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注： </div>
							</td>
							<td height="21" align="left"> <s:textarea id="remarks" name="userBase.remarks" theme="simple"  rows="4" cols="100"></s:textarea>
								
							</td>
						</tr>
		</table>
        </div>
        </div>
	</form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link  href="../css/right.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="javascript" src="../js/jquery.js"></script>
		<title>金融风险评估系统</title>
		<style type="text/css">
	
		</style>
		<SCRIPT type="text/javascript">
	           	
	 function toPage(currPage){
       	document.getElementById("currPage").value = currPage;
       	document.forms[0].submit();
       }
      function turnPage(){
        var thepage= document.getElementById("thePage").value;
        var totalPage= document.getElementById("totalPage").value;
        if(thepage>0&&thepage<=totalPage){
           toPage(thepage);
        }else{
           toPage(totalPage);
        }
      }

      function res(){
          $("#ryear").val("");
          $("#OrgNo").val("");
             }
    </SCRIPT>
    <style type="text/css">
table {
	border-right: 1px #a8c7ce solid;
	border-top: 1px #a8c7ce solid;
}

td {
	border-left: 1px #a8c7ce solid;
	border-bottom: 1px #a8c7ce solid;
	height: 28px;
	text-align: left;
	padding-left: 1%;
}

body {
	font-family: "宋体";
	font-size: 13px;
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
	width:86px;
	height:20px;
	line-height:20px;}
</style>
	</head>
	<body>
		<form action="findAllRating" method="post">
			<s:hidden name="page" id="currPage"></s:hidden>
			
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：评定查询/评定列表</div>
        
		
				<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
				<div style="width:98.5%;">
				<table cellpadding="0" cellspacing="0" width="100%" align="left" >
				<tr align="center" style="background-color:#d3eaf0;">
					    <td  width="15%">公司名称</td>
							<td width="15%">公司法人</td>
					        <td  width="15%">指标编号</td>
							<td  width="15%">生命周期</td>
							<td  width="14%">级别</td>
							<td  width="14%">评定日期</td>
							<td width="12%">操作</td>	
			    </tr>
				
				<s:iterator value="Enterpriseinfo">
				<s:iterator value="ratingresults">
							<tr>
							
							
								<td ><s:property value="Enterpriseinfo.epname" /></td>
								<td ><s:property value="Enterpriseinfo.legalPerson" /></td>
								
								
								<td ><s:property value="attributeId" /></td>
								
								
								<td >
									<s:if test="lifecycle==1"> 初创期</s:if>
									<s:elseif test="lifecycle==2">发展期</s:elseif>
									<s:else> 稳定期</s:else>
								</td>
								<td >
									<s:if test="creditId==1">
										<font size="+2" color="#C22227">
											<s:if test="rating=='AAA'">
										优秀
										</s:if>
										 </font>
									</s:if>
									<s:elseif test="creditId==2">
										<font size="+2" color="#DC8E28"> 
										<s:if test="rating=='AA'">
										优良
										</s:if>
										</font>
									</s:elseif>
									<s:elseif test="creditId==3">
										<font size="+2" color="#EBC025">
												<s:if test="rating=='A'">
										较好
										</s:if>
										 </font>
									</s:elseif>
									<s:elseif test="creditId==4">
										<font size="+2" color="#FFCC00"> 
										<s:if test="rating=='BBB'">
										一般
										</s:if>
										</font>
									</s:elseif>
									<s:elseif test="creditId==5">
										<font size="+2" color="#999900"> 
										<s:if test="rating=='BB'">
										欠佳
										</s:if>
										</font>
									</s:elseif>
									<s:elseif test="creditId==6">
										<font size="+2" color="#99CC33"> 
										<s:if test="rating=='B'">
										较差
										</s:if>
										</font>
									</s:elseif>
									<s:elseif test="creditId==7">
										<font size="+2" color="#99FF66"> 
										<s:if test="rating=='CCC'">
										很差
										</s:if>
										</font>
									</s:elseif>
								</td>
								<td ><s:property value="createTime" /></td>
								<td >
									<a href="findRatingReport?companyId=<s:property value="companyId"/>&attributeId=<s:property value="attributeId"/>" 
									style="text-decoration:none;"> 查看评定报告</a>
							</td>
							
							</tr>
							</s:iterator>
							</s:iterator>
				</table>
				
				</div>
				</div>
		</form>
	</body>
</html>

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
<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
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
	width:86px;
	height:20px;
	line-height:20px;
	}
</style>
	</head>
	<body>
	
	
	
	
		<form action="findAllRating" method="post">
		
		
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：评定查询</div>
        
        <div style="position: absolute; top: 6.5%; left: 85%; width: 200px; color:#FFF;">
        	<div style="float:left; margin-top:3%"><img src="images/right-jiahao.png" width="13" height="13"></div>
            <div style="float:left; margin-top:3%">添加</div>
            <div style="float:left; margin-top:3%; margin-left:5%"><img src="images/right-lese.png" width="13" height="13"></div>
            <div style="float:left; margin-top:3%">删除</div>
            <div style="float:left; margin-top:3%; margin-left:5%""><img src="images/right-bianji.png" width="13" height="13"></div>
            <div style="float:left; margin-top:3%">编辑</div>
        </div>
        
        
		<s:if test="#session.enterprise==null||#session.enterprise.isEmpty()">
		<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
			<s:hidden name="page" id="currPage"></s:hidden>
			<div style="width:98.5%;">
			<table cellpadding="0" cellspacing="0" width="100%">
			<tr style="height: 105px;background-color:#FFFFFF" >
				<td >
					<div align="center" style="border: 0px solid blue; height: 105px;padding-left: 50px;"><br/>
							<span>评定年份：</span>	<s:select id="ryear" list="#{'2014':'2014','2015':'2015','2016':'2016','2017':'2017','2018':'2018','2019':'2019','2020':'2020'}"
							name="createTime" headerKey=""  headerValue="--请选择--" theme="simple"></s:select>
							&nbsp;&nbsp;&nbsp;&nbsp;					
							<span>机构代码：</span><input id="OrgNo" name="orgNo" type="text" maxlength="20" value="<s:property value="orgNo"/>"/>	<br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input  type="button" class="btn"    value="查询"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input  type="button" class="btn"  value="重置"/> 
					</div>
				</td>
			</tr>
		</table>
				
				
		
			
		<s:if test="results==null||results.isEmpty()">
				<div align="left" style="color: red;">
					<STRONG>没有要查询的记录</STRONG>
				</div>
			</s:if>
			
				<s:else>
				
			<div style="border: 0px; width: 100%; height: 500px; margin-top: 10px;" >
				<table style="width:100%; border: 0px;background-color:#ACACAC;" cellspacing="1" cellpadding="0" >
			<tr style="height: 28px;">
			<td colspan="8" align="left">
				<table style="width: 100%; border:0px;margin:0px;" cellpadding="0" cellspacing="0"><tr height="28px">
				<td style="width: 7px;" class="td1"></td>
				<td class="td2"><img alt="评定列表" height="15px;" src="../images/Content.png"/><span>评定列表</span></td>
				<td style="width: 7px;" class="td3"></td>
				</tr></table>
			</td>
			</tr>
			
				<tr align="center" style=" background-color: #E1E1E1;">
					    <td  width="15%">公司名称</td>
							<td width="15%">编号</td>
					        <td  width="15%">公司法人</td>
							<td  width="15%">生命周期</td>
							<td  width="14%">级别</td>
							<td  width="14%">评定日期</td>
							<td width="12%">操作</td>	
			    </tr>
				
				<s:iterator value="results">
							<tr class="trBg">
								<td ><s:property value="CompanyName" /></td>
								<td ><s:property value="orgNo" /></td>
								<td ><s:property value="legalPerson" /></td>
								<td >
									<s:if test="lifecycle==1"> 初创期</s:if>
									<s:elseif test="lifecycle==2">发展期</s:elseif>
									<s:else> 稳定期</s:else>
								</td>
								<td >
									<s:if test="creditId==1">
										<font size="+2" color="#C22227"> <s:property value="rating" /></font>
									</s:if>
									<s:elseif test="creditId==2">
										<font size="+2" color="#DC8E28"> <s:property value="rating" /></font>
									</s:elseif>
									<s:elseif test="creditId==3">
										<font size="+2" color="#EBC025"> <s:property value="rating" /></font>
									</s:elseif>
									<s:elseif test="creditId==4">
										<font size="+2" color="#FFCC00"> <s:property value="rating" /></font>
									</s:elseif>
									<s:elseif test="creditId==5">
										<font size="+2" color="#999900"> <s:property value="rating" /></font>
									</s:elseif>
									<s:elseif test="creditId==6">
										<font size="+2" color="#99CC33"> <s:property value="rating" /></font>
									</s:elseif>
									<s:elseif test="creditId==7">
										<font size="+2" color="#99FF66"> <s:property value="rating" /></font>
									</s:elseif>
								</td>
								<td ><s:property value="createTime" /></td>
								<td >
									<img src="../images/edit.gif" />
									<a href="findRatingReport?companyId=<s:property value="companyId"/>" 
									style="text-decoration:none;"> 查看评定报告</a>
							</td>
							</tr>
						</s:iterator>
				<tr style="height: 30px; text-align: center; background-color: #F2F2F2;">
				
					
							<td colspan="5">
								<div align="left">
									<span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;
									当前第 <strong><s:property value="page" />
									</strong> 页，共 <strong><s:property value="totalPage" /> </strong> 页</span>
								</div>
							</td>
							<td colspan="2">
								<table border="0" cellspacing="0" cellpadding="0" align="right">
									<tr>
										<s:if test="page==1">
											<td>
												<div align="left">
													<a href="javascript:void(0)" onclick="">
													 <img src="../images/main_54.gif" width="40" height="15" border="0" /></a>
												</div>
											</td>
											<td width="70">
												<div align="center">
													<a href="#none"> 
													<img src="../images/main_56.gif" width="45" height="15" border="0" /></a>
												</div>
											</td>
										</s:if>
										<s:else>
											<td>
												<div align="left">
													<a href="javascript:void(0)" onclick="toPage(1)">
													<img src="../images/main_54.gif" width="40" height="15" border="0" /></a>
												</div>
											</td>
											<td width="70">
												<div align="center">
													<a href="javascript:void(0)"	onclick="toPage(<s:property value='page-1'/>)"> 
														<img src="../images/main_56.gif" width="45" height="15" border="0" /></a>
												</div>
											</td>
										</s:else>

										<s:if test="page==totalPage">
											<td width="70">
												<div align="center">
													<a href="#none">
													<img src="../images/main_58.gif" width="45" height="15" border="0" /></a>
												</div>
											</td>
											<td width="60">
												<div align="center">
													<a href="#none">
													<img src="../images/main_60.gif" width="40" height="15" border="0" /> </a>
												</div>
											</td>
										</s:if>
										<s:else>
											<td width="70">
												<div align="center">
													<a href="javascript:void(0)"
														onclick="toPage(<s:property value='page+1'/>)">
														 <img src="../images/main_58.gif" width="45" height="15" border="0" /> </a>
												</div>
											</td>

											<td width="60">
												<div align="center">
													<a href="javascript:void(0)"
														onclick="toPage(<s:property value='totalPage'/>)">
														<img src="../images/main_60.gif" width="40" height="15" border="0" /> </a>
												</div>
											</td>
										</s:else>

									</tr>
								</table>
							</td>
						</tr>
				
				</table>
				</div>
		</s:else>
		</div>
				</div>
			</s:if>
			
  		 <s:else>
  		  <div style="color:red;"><strong>企业不能执行此操作!</strong></div>  
  		 </s:else>
  		 
		</form>
	</body>
</html>

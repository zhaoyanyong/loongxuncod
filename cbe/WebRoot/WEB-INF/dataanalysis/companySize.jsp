<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script language="javascript" type="text/javascript"
			src="js/jquery-1.9.1.min.js"></script>
<script src="highcharts/highcharts.js"></script>
<script src="highcharts/modules/exporting.js"></script>
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
	color:#fff;
	}
.btn {
	background-image:url(images/right-anniubg1.png);
	border:0px;
	width:86px;
	height:20px;
	line-height:20px;}
</style>
<title>企业规模指标详细参数</title>

</head>

<body >

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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：企业规模指标</div>
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
        	<div style="width:98.5%;">
				<table cellpadding="0" cellspacing="0" width="100%" align="left" >
					<tr height="22" align="center" style=" background-color:#d3eaf0;">
						<th width="20%" align="center" style="border-left:1px #a8c7ce solid; ">
							企业规模指标
						</th>
						<th width="20%" align="center">
							指标实际值
						</th>
						<th width="20%" align="center">
							指标满分值
						</th>
						<th width="20%" align="center">
							分值
						</th>
						<th width="20%" align="center">
							得分率
						</th>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">企业净资产总额</td>
						<td height="20"><s:property value="dataanaly.netAssetTarget"/></td>
						<td height="20"><fmt:formatNumber value="${STS[0] }" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.netAssetValue }" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.netAssetValue / STS[0] * 100}" pattern="#0.00"/>%</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" >企业固定资产总额</td>
						<td height="20" ><s:property value="dataanaly.fixAssetTarget"/></td>
						<td height="20"><fmt:formatNumber value="${STS[1] }" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.fixAssetValue}" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.fixAssetValue / STS[1] * 100}" pattern="#0.00"/>%</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">营业收入</td>
						<td height="20"  ><s:property value="dataanaly.incomeTarget"/></td>
						<td height="20"><fmt:formatNumber value="${STS[2] }" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.incomeValue}" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.incomeValue / STS[2] * 100}" pattern="#0.00"/>%</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" >企业税后利润总额</td>
						<td height="20"  ><s:property value="dataanaly.profitTarget"/></td>
						<td height="20"><fmt:formatNumber value="${STS[3] }" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.profitValue}" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.profitValue / STS[3] * 100}" pattern="#0.00"/>%</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" >固定资产净值</td>
						<td height="20"  ><s:property value="dataanaly.netbalTarget"/></td>
						<td height="20"><fmt:formatNumber value="${STS[4] }" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.netbalValue}" pattern="#0.000"/></td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.netbalValue / STS[4] * 100}" pattern="#0.00"/>%</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" >
						合计
						</td>
						<td height="20"  ></td>
						<td height="20"  >
						<fmt:formatNumber value="${STS[0]+STS[1]+STS[2]+STS[3]+STS[4] }" pattern="#0.000"/>
						</td>
						<td height="20" ><fmt:formatNumber value="${dataanaly.scaleMeritTotalScores}" pattern="#0.000"/></td>
						<td height="20"  >
						<fmt:formatNumber value="${dataanaly.scaleMeritTotalScores / (STS[0]+STS[1]+STS[2]+STS[3]+STS[4]) * 100}" pattern="#0.00"/>%
						</td>
					</tr>
				</table>
				</div>
				</div>
			<br/>
</body>
</html>


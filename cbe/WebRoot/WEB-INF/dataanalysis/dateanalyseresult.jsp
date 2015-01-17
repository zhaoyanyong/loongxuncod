<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <script type="text/javascript"  src="js/jquery-1.4.3.js"></script>
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
	<SCRIPT type="text/javascript">

	function  Enterprisescale(){
	    var analyId=$("#analyId").val();
	    window.location.href = "findEnterprisescale.action?analyId=" + analyId;
	}
	</SCRIPT>
	
<title>综合评分</title>
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：数据分析/数据查看</div>
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
        
        
 
			<s:if test=" dataanalyh!= null ">
			 <div style="width:100%; height:437px; position:absolute; top:12%; left:0.4%;">
			<div style="width:98.5%;">
			<table cellpadding="0" cellspacing="0" width="100%" align="left" >
			<tr>
				<td align="left">
						公司名称:<s:property value="user.epname"/>
				</td>
			</tr>
			<tr style="background-color:#FFFFFF" >
				<td align="left">
						综合得分:<s:property value="rati.total"/>
						<input type="hidden" value='<s:property value='enterpriseId'/>' id="analyId"/>
				</td>
			</tr>
			<tr style="background-color:#FFFFFF" >
				<td align="left">
						评定结果:<s:property value="rati.rating"/>
				</td>
			</tr>
			</table>	
			</div>
			<div style="width:100%; height:100%; margin-top:93px; overflow-y:scroll; ">
		<table cellpadding="0" cellspacing="0" width="100%" align="left" >
			<tr style=" background-color:#d3eaf0;" class="trBg" >
			    <td>指标参数模块</td>
				<td>分值</td>
				<td>详细分值</td>
			</tr>
			<tr class="trBg" >
				<td >企业规模指标</td>
				<td><s:property value="dataanalyh.scaleMeritTotalScores"/></td>
				<td><a href="findEnterprisescale?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>" >点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >偿债能力</td>
				<td><s:property value="dataanalyh.debtTotalScores"/></td>
				<td><a href="findSolvency?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >营运能力</td>
				<td><s:property value="dataanalyh.operationTotalScores"/></td>
				<td><a href="findOperational?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >盈利能力</td>
				<td><s:property value="dataanalyh.earningTotalScores"/></td>
				<td><a href="findProfitability?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >成长性指标</td>
				<td><s:property value="dataanalyh.growthTotalScores"/></td>
				<td><a href="findGrowth?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >创新性指标</td>
				<td><s:property value="dataanalyh.creativeTotalScores"/></td>
				<td><a href="findInnovation?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >信用履约能力指标</td>
				<td><s:property value="dataanalyh.creditExerciseTotalScores"/></td>
				<td><a href="findperformance?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >管理水平</td>
				<td><s:property value="dataanalyh.managerLevelTotalScores"/></td>
				<td><a href="findManagement?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
			<tr class="trBg" >
				<td >市场竞争力</td>
				<td><s:property value="dataanalyh.marketCompeteTotalScores"/></td>
				<td><a href="findcompetitiveness?enterpriseId=<s:property value='enterpriseId'/>&attributeId=<s:property value="dataanalyh.attributeId"/>">点击查看详细</a></td>
			</tr>
		</table>
		</div>
		</div>
		</s:if>
		
		<s:else>
		  <strong  style="color: red;">公司数据录入不完整，没有数据分析结果。</strong>
		</s:else>
  </body>
  </html>

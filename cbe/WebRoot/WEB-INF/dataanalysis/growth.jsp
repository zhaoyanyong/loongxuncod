<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<title>成长性指标</title>


<script language="javascript" type="text/javascript"
			src="js/jquery-1.9.1.min.js"></script>
			<script src="highcharts/highcharts.js"></script>
<script src="highcharts/modules/exporting.js"></script>
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：成长性指标</div>
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
				<table cellpadding="0" cellspacing="0" width="100%">
					<tr height="22" align="center" style=" background-color:#d3eaf0;">
						<th width="20%" align="center" style="border-left:1px #a8c7ce solid; " colspan="2"> 
								<div >
									成长性指标
								</div>
							</th>
							<th width="15%" align="center">
								指标实际值 
							</th>
							<th width="15%" align="center">
								指标满分值
							</th>
							<th  width="15%" align="center">
								分值
							</th>
							<th  width="15%" align="center">
								得分率
							</th>
							
						</tr>
						
						<tr align="center" class="trBg">
							<td height="20"  colspan="2" >
								<div >
									总资产增长率
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.totalAssetGrowRatioTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${GTS[0] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div >
									<fmt:formatNumber value="${dataanaly.totalAssetGrowRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.totalAssetGrowRatioValue / GTS[0] * 100}" pattern="#0.00"/>%</td>
							
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20"   colspan="2">
								<div class="STYLE10">
									净资产增长率
								</div>
							</td>
							<td height="20" >
								<s:property value="dataanaly.netAssetGrowRatioTarget"/>
							</td>
							
							<td height="20"  >
								<fmt:formatNumber value="${GTS[1] }" pattern="#0.000"/>
							</td> 
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.netAssetGrowRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.netAssetGrowRatioValue / GTS[1] * 100}" pattern="#0.00"/>%</td>
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									总收益增长率
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.totalIncomeGrowRatioTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${GTS[2] }" pattern="#0.000"/>
							</td>
							
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.totalIncomeGrowRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.totalIncomeGrowRatioValue / GTS[2] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"   colspan="2">
								<div class="STYLE10">
									净利润增长率
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.netIncomeGrowRatioTarget"/>
							</td>
							
							
<td height="20"  >
								<fmt:formatNumber value="${GTS[3] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.netIncomeGrowRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.netIncomeGrowRatioValue / GTS[3] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									主营业务利润率增长
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.mainBusProfitGrowTarget"/>
							</td>
							
<td height="20"  >
								<fmt:formatNumber value="${GTS[4] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.mainBusProfitGrowValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.mainBusProfitGrowValue / GTS[4] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"   colspan="2">
								<div class="STYLE10">
									员工数量增长率
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.employeeGrowRatioTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${GTS[5] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.employeeGrowRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.employeeGrowRatioValue / GTS[5] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  rowspan="4" width="20%">
								<div class="STYLE10">
									企业家禀赋
								</div>
							</td>
							<td height="20"  width="20%">
								<div class="STYLE10">
									年龄
								</div>
							</td>
							<td height="20"  >
								<s:if test="dataanaly.euntreponierAgeTarget==0">0至35</s:if>
								<s:elseif test="dataanaly.euntreponierAgeTarget==1">35至50</s:elseif>
								<s:elseif test="dataanaly.euntreponierAgeTarget==2">50以上</s:elseif>
							</td>
							

<td height="20"  >
								<fmt:formatNumber value="${GTS[6] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.euntreponierAgeValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.euntreponierAgeValue / GTS[6] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
								<div class="STYLE10">
									学历/学位/职称
								</div>
							</td>
							<td height="20"  >
								<s:if test="dataanaly.euntreponierDegreeTarget==0">特殊知名人物</s:if>
								<s:elseif test="dataanaly.euntreponierDegreeTarget==1">博士/高级</s:elseif>
								<s:elseif test="dataanaly.euntreponierDegreeTarget==2">硕士/副高</s:elseif>
								<s:elseif test="dataanaly.euntreponierDegreeTarget==3">本科/中级</s:elseif>
								<s:elseif test="dataanaly.euntreponierDegreeTarget==4">专科/初级</s:elseif>
							</td>
							
							
<td height="20"  >
									<fmt:formatNumber value="${GTS[7] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.euntreponierDegreeValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.euntreponierDegreeValue / GTS[7] * 100}" pattern="#0.00"/>%</td>
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
								<div class="STYLE10">
									岗位工作时间
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.euntreponierWorkTimeTarget"/>年
							</td>
							 <td height="20"  >
									<fmt:formatNumber value="${GTS[8] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.euntreponierWorkTimeValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.euntreponierWorkTimeValue / GTS[8] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
								<div class="STYLE10">
									业内知名度\社会关系
								</div>
							</td>
							<td height="20"  >
								<s:if test="dataanaly.euntreponierPopularyTarget==0">很强</s:if>
								<s:elseif test="dataanaly.euntreponierPopularyTarget==1">强</s:elseif>
								<s:elseif test="dataanaly.euntreponierPopularyTarget==2">比较强</s:elseif>
								<s:elseif test="dataanaly.euntreponierPopularyTarget==3">一般</s:elseif>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${GTS[9] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.euntreponierPopularyValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.euntreponierPopularyValue / GTS[9]  * 100}" pattern="#0.00"/>%</td>
						</tr>
						
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									企业发展规划
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.developPlanTarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${GTS[10] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.developPlanValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.developPlanValue / GTS[10] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									产品长期发展战略
								</div>
							</td>
							<td height="20" >
							<s:if test="dataanaly.developStrategyTarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${GTS[11] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.developStrategyValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.developStrategyValue / GTS[11]  * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									产品质量认证
								</div>
							</td>
							<td height="20" >
							<s:if test="dataanaly.qualityCertificateTarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${GTS[12] }" pattern="#0.000"/>
							</td>
							
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.qualityCertificateValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.qualityCertificateValue / GTS[12] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									产业（阶段）性质
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.industryNatureTarget==0">夕阳产业</s:if>
							<s:elseif test="dataanaly.industryNatureTarget==1">普通产业</s:elseif>
							<s:else>朝阳产业</s:else>
							</td>
							  <td height="20"  >
								<fmt:formatNumber value="${GTS[13] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.industryNatureValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.industryNatureValue / GTS[13] * 100}" pattern="#0.00"/>%</td>
						</tr>
						
						
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
							合计
							</td>
							<td height="20">
							</td>
							<td height="20"  >
							<fmt:formatNumber value="${GTS[0]+GTS[1]+GTS[2]+GTS[3]+GTS[4]+GTS[5]+GTS[6]+GTS[7]+GTS[8]+GTS[9]+GTS[10]+GTS[11]+GTS[12]+GTS[13] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10" align="center">
									<fmt:formatNumber value="${dataanaly.growthTotalScores}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"  >
							<fmt:formatNumber value="${dataanaly.growthTotalScores / (GTS[0]+GTS[1]+GTS[2]+GTS[3]+GTS[4]+GTS[5]+GTS[6]+GTS[7]+GTS[8]+GTS[9]+GTS[10]+GTS[11]+GTS[12]+GTS[13] ) * 100}" pattern="#0.00"/>%
							</td>
						</tr>
						
					</table>
				</div>
				</div>
			
</body>
</html>


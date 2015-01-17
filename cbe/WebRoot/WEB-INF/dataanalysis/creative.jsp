<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>创新性指标</title>


<script language="javascript" type="text/javascript"
			src="js/jquery-1.9.1.min.js"></script>
			<script src="highcharts/highcharts.js"></script>
<script src="highcharts/modules/exporting.js"></script>
 <script src="js/excanvas.js"></script>
 
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：创新能力</div>
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
		
		<div style="width:100%; height:457px; position:absolute; top:11%; left:0.4%;">
        	<div style="width:100%; height:100%; margin-top:0.5%; overflow-y: scroll;">
				<table cellpadding="0" cellspacing="0" width="100%">
					<tr height="22" align="center" style=" background-color:#d3eaf0;">
							
							
							<th  width="40%" colspan="2" style="border-left:1px #a8c7ce solid; ">
								<div >
									创新性指标
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
							<td height="20"  colspan="2">
								<div class="STYLE10">
									近1年高新技术产品（服务）销售收入和技术收入占销售收入的比率
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.highTechIncomeRatioTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[0] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.highTechIncomeRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							
                           <td height="20"><fmt:formatNumber value="${dataanaly.highTechIncomeRatioValue / CTS[0] * 100}" pattern="#0.00"/>%</td>
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									R&D投入占比
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.rdinputRatioTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[1] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.rdinputRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.rdinputRatioValue / CTS[1] * 100}" pattern="#0.00"/>%</td>
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									R&D经费增长率
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.rdmoneyGrowRatioTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[2] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.rdmoneyGrowRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.rdmoneyGrowRatioValue / CTS[2] * 100}" pattern="#0.00"/>%</td>
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									大专以上人数占比
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.collageRatioTarget"/>
							</td>
							
                                                        <td height="20"  >
									<fmt:formatNumber value="${CTS[3] }" pattern="#0.000"/>
							</td>
							
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.collageRatioValue}" pattern="#0.000"/>
								</div>
							</td>
							
							
<td height="20"><fmt:formatNumber value="${dataanaly.collageRatioValue / CTS[3] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									获得市级以上科技成果奖励数
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.technicalPayoffNumTarget"/>
							</td>
							 <td height="20"  >
								<fmt:formatNumber value="${CTS[4] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.technicalPayoffNumValue}" pattern="#0.000"/>
								</div>
							</td>
							
							<td height="20"><fmt:formatNumber value="${dataanaly.technicalPayoffNumValue / CTS[4] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									申请和已授权的知识产权总数
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.iprnumTarget"/>
							</td>
							 <td height="20"  >
									<fmt:formatNumber value="${CTS[5] }" pattern="#0.000"/>
							</td>
							
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.iprnumValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.iprnumValue / 	CTS[5]  * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									专利总数
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.patentNumTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[6] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.patentNumValue}" pattern="#0.000"/>
								</div>
							</td>
							
<td height="20"><fmt:formatNumber value="${dataanaly.patentNumValue / CTS[6] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center"  class="trBg">
							<td height="20"  rowspan="3" width="30%">
								<div class="STYLE10">
									近三年获政府立项数量
								</div>
							</td>
							<td height="20"  >
								<div class="STYLE10">
									国家级
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.govprojectNumLandTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[7] }" pattern="#0.000"/>
							</td>
							<td height="20"  >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.govprojectNumLandValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.govprojectNumLandValue / CTS[7]  * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
								<div class="STYLE10">
									省部级
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.govprojectNumProTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[8] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.govprojectNumProValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.govprojectNumProValue / CTS[8] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
								<div class="STYLE10">
									地市级
								</div>
							</td>
							<td height="20"  >
								<s:property value="dataanaly.govprojectNumCityTarget"/>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[9] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.govprojectNumCityValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.govprojectNumCityValue / CTS[9] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									创新人员激励制度
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.incentiveTarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							
                                                        <td height="20"  >
								<fmt:formatNumber value="${CTS[10] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.incentiveValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.incentiveValue / CTS[10]  * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									专门的研发机构
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.rdorganizationTarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							 <td height="20"  >
								<fmt:formatNumber value="${CTS[11] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.rdorganizationValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.rdorganizationValue / CTS[11] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									有无创业投资机构进入
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.investmentOrganizationTarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[12] }" pattern="#0.000"/>
							</td>
							
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.investmentOrganizationValue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.investmentOrganizationValue / CTS[12] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									国际化合作
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.internateCooTarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${CTS[13] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.internateCooValue}" pattern="#0.000"/>
								</div>
							</td>
							
<td height="20"><fmt:formatNumber value="${dataanaly.internateCooValue / CTS[13] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
								<div class="STYLE10">
									国家重点实验室
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.lhdtarget==1">有</s:if>
							<s:else>无</s:else>
							</td>
							 <td height="20"  >
								<fmt:formatNumber value="${CTS[14] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.lhdvalue}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.lhdvalue / CTS[14] * 100}" pattern="#0.00"/>%</td>
						</tr>
						
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
							合计
							</td>
							<td height="20">
							</td>
							<td height="20"  >
							<fmt:formatNumber value="${CTS[0]+CTS[1]+CTS[2]+CTS[3]+CTS[4]+CTS[5]+CTS[6]+CTS[7]+CTS[8]+CTS[9]+CTS[10]+CTS[11]+CTS[12]+CTS[13]+CTS[14] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10" align="center">
									<fmt:formatNumber value="${dataanaly.creativeTotalScores}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"  >
							<fmt:formatNumber value="${dataanaly.creativeTotalScores / (CTS[0]+CTS[1]+CTS[2]+CTS[3]+CTS[4]+CTS[5]+CTS[6]+CTS[7]+CTS[8]+CTS[9]+CTS[10]+CTS[11]+CTS[12]+CTS[13]+CTS[14]) * 100}" pattern="#0.00"/>%
							</td>
						</tr>
						
					</table>
			</div>
			</div>
</body>
</html>


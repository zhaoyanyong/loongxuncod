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
    <script src="js/jquery-1.9.1.min.js"></script>
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
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 
 
<title>市场竞争力</title>
</head>

<body onload="crelineandbar();">
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：市场竞争力</div>
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
						<th width="20%" align="center" style="border-left:1px #a8c7ce solid; "> 
								<div class="STYLE10">
									市场竞争力
								</div>
							</th>
							<th  width="20%">
								<div class="STYLE10"> 
								指标实际值 
								</div>
							</th>
							<th  width="20%">
								<div class="STYLE10"> 
								指标满分值 
								</div>
							</th>
							<th  width="20%">
								<div class="STYLE10">
									分值
								</div>
							</th>
							<th  width="20%">
								<div class="STYLE10">
									得分率
								</div>
							</th>
							
						</tr>
						
						<tr align="center" class="trBg">
							<td height="20" >
								<div class="STYLE10">
									国家产业政策
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.industryPolicyTarget==0">鼓励发展</s:if>
							<s:elseif test="dataanaly.industryPolicyTarget==1">一般态度</s:elseif>
							<s:elseif test="dataanaly.industryPolicyTarget==2">限制发展</s:elseif>
							<s:elseif test="dataanaly.industryPolicyTarget==3">要求淘汰</s:elseif>
							</td>
							
                                                        <td height="20"  >
								<fmt:formatNumber value="${MCTS[0] }" pattern="#0.000"/>
							</td>
							
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.industryPolicyValue}" pattern="#0.000"/>
									
								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.industryPolicyValue / MCTS[0] * 100}" pattern="#0.00"/>%</td>
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20" >
								<div class="STYLE10">
									行业地位
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.industryPositionTarget==0">产品市场占有率高</s:if>
							<s:elseif test="dataanaly.industryPositionTarget==1">议价能力一般</s:elseif>
							<s:else>议价能力高</s:else>
							</td>
							 <td height="20"  >
								<fmt:formatNumber value="${MCTS[1] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.industryPositionValue}" pattern="#0.000"/>

								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.industryPositionValue / MCTS[1] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20" >
								<div class="STYLE10">
									主导产业个数
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.leaderIndustryNumTarget==0">1-2个</s:if>
							<s:elseif test="dataanaly.leaderIndustryNumTarget==1">3-4个</s:elseif>
							<s:else>4个以上</s:else>

							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MCTS[2] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.leaderIndustryNumValue}" pattern="#0.000"/>

								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.leaderIndustryNumValue / MCTS[2] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20" >
								<div class="STYLE10">
									产品竞争力
								</div>
							</td>
							<td height="20"  >
							<s:if test="dataanaly.competitivePowerTarget==0">好</s:if>
							<s:elseif test="dataanaly.competitivePowerTarget==1">中</s:elseif>
							<s:else>差</s:else>

							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MCTS[3] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10">
									<fmt:formatNumber value="${dataanaly.competitivePowerValue}" pattern="#0.000"/>

								</div>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.competitivePowerValue / MCTS[3] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20" >
							合计
							</td>
							<td height="20" >
							</td>
							<td height="20" >
							<fmt:formatNumber value="${MCTS[0]+MCTS[1]+MCTS[2]+MCTS[3] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div class="STYLE10" align="center">
									<fmt:formatNumber value="${dataanaly.marketCompeteTotalScores}" pattern="#0.000"/>

								</div>
							</td>
							<td height="20" >
							<fmt:formatNumber value="${dataanaly.marketCompeteTotalScores / (MCTS[0]+MCTS[1]+MCTS[2]+MCTS[3]) * 100}" pattern="#0.00"/>%
							</td>
						</tr>
						
					</table>
					</div>
					</div>
</body>
</html>


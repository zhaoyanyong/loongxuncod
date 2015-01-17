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
  <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
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
<title>管理水平</title>
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：管理水平</div>
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
								<div class="STYLE10">
									管理水平
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
									经营管理水平
							</td>
							<td height="20"  >
							<s:if test="dataanaly.manageLevelTarget==0">
							   优秀
							</s:if>
							 <s:elseif test="dataanaly.manageLevelTarget==1">
							  良
							 </s:elseif><s:elseif test="dataanaly.manageLevelTarget==2">
							 中
							 </s:elseif><s:else>
							  差
							 </s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[0] }" pattern="#0.000"/>
							</td>
							<td height="20" >
							
									<fmt:formatNumber value="${dataanaly.manageLevelValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.manageLevelValue / MTS[0] * 100}" pattern="#0.00"/>%</td>
							
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
									股东背景
							</td>
							<td height="20"  >
							<s:if test="dataanaly.shareholderBackgroundTarget==0">
							中央级企业、上市公司
							</s:if><s:elseif test="dataanaly.shareholderBackgroundTarget==1">
							地市级以上（含）政府控投企业
							</s:elseif><s:else>
							 民营企业及其他 
							</s:else>
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[1] }" pattern="#0.000"/>
							</td>
							<td height="20" >
									<fmt:formatNumber value="${dataanaly.shareholderBackgroundValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.shareholderBackgroundValue / MTS[1] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  rowspan="8" >
									管理者行业经验
							</td>
							<td height="20" >
									任职年份
							</td>
							<td height="20" >
								<s:property value="dataanaly.managerWorkTimeTarget"/>年
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[2] }" pattern="#0.000"/>
							</td>
							<td height="20"  >
									<fmt:formatNumber value="${dataanaly.managerWorkTimeValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.managerWorkTimeValue / MTS[2] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
									董事会规模
							</td>
							<td height="20"  >
							<s:if test="dataanaly.boardSizeTarget==0">
							按规定设定
							</s:if><s:else>
							未按规定设定
							</s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[3] }" pattern="#0.000"/>
							</td>
							<td height="20" >
									<fmt:formatNumber value="${dataanaly.boardSizeValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.boardSizeValue / MTS[3] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
									董事长与CEO两职设置状况
							</td>
							<td height="20"  >
							<s:if test="dataanaly.chairCeotarget==0">
							按规定设定
							</s:if><s:else>
							未按规定设定
							</s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[4] }" pattern="#0.000"/>
							</td>
							<td height="20" >
									<fmt:formatNumber value="${dataanaly.chairCeovalue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.chairCeovalue / MTS[4] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
									审计意见
							</td>
							<td height="20"  >
							<s:if test="dataanaly.auditOpinionTarget==0">
							标准的无保留意见
							</s:if>
							 <s:elseif test="dataanaly.auditOpinionTarget==1">
							 带强调事项段的无保留意见
							 </s:elseif>
							 <s:elseif test="dataanaly.auditOpinionTarget==2">
							 保留意见
							 </s:elseif>
							 <s:elseif test="dataanaly.auditOpinionTarget==3">
							 否定意见
							 </s:elseif><s:else>
							 无法表示意见
							 </s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[5] }" pattern="#0.000"/>
							</td>
							<td height="20" >
									<fmt:formatNumber value="${dataanaly.auditOpinionValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.auditOpinionValue / MTS[5] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
									违规行为
							</td>
							<td height="20"  >
							 <s:if test="dataanaly.illegalBehaviorTarget==0">
							   有
							 </s:if>
							 <s:else>
							 无
							 </s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[6] }" pattern="#0.000"/>
							</td>
							<td height="20" >
									<fmt:formatNumber value="${dataanaly.illegalBehaviorValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.illegalBehaviorValue / MTS[6] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
									年龄
							</td>
							<td height="20"  >
							 <s:if test="dataanaly.managerAgeTarget==0">
							 小于等于35
							 </s:if>
							 <s:elseif test="dataanaly.managerAgeTarget==1" >
							35至50
							 </s:elseif><s:else>
							 50以上
							 </s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[7] }" pattern="#0.000"/>
							</td>
							<td height="20" >
							  
									<fmt:formatNumber value="${dataanaly.managerAgeValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.managerAgeValue / MTS[7] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
									教育背景
							</td>
							<td height="20"  >
							 <s:if test="dataanaly.managerEdubackgroundTarget==0">
							 特殊知名人物
							 </s:if>
							 <s:elseif test="dataanaly.managerEdubackgroundTarget==1" >
							博士/高级
							 </s:elseif>
							 <s:elseif test="dataanaly.managerEdubackgroundTarget==2" >
							硕士/副高
							 </s:elseif>
							 <s:elseif test="dataanaly.managerEdubackgroundTarget==3" >
							本科/中级
							 </s:elseif>
							 <s:else>
							 专科/初级
							 </s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[8] }" pattern="#0.000"/>
							</td>
							<td height="20" >
									<fmt:formatNumber value="${dataanaly.managerEdubackgroundValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.managerEdubackgroundValue / MTS[8] * 100}" pattern="#0.00"/>%</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="20"  >
									职称
							</td>
							<td height="20"  >
							 <s:if test="dataanaly.managerTitalTarget==0">
							 高级
							 </s:if><s:elseif test="dataanaly.managerTitalTarget==1">
							  副高级
							 </s:elseif>
							 <s:elseif test="dataanaly.managerTitalTarget==2">
							  中级
							 </s:elseif>
							 <s:elseif test="dataanaly.managerTitalTarget==3">
							 
							 初级</s:elseif>
							 <s:else>
							  无
							 </s:else>
								
							</td>
							<td height="20"  >
								<fmt:formatNumber value="${MTS[9] }" pattern="#0.000"/>
							</td>
							<td height="20" >
									<fmt:formatNumber value="${dataanaly.managerTitalValue}" pattern="#0.000"/>
							</td>
							<td height="20"><fmt:formatNumber value="${dataanaly.managerTitalValue / MTS[9] * 100}" pattern="#0.00"/>%</td>
						</tr>
						
						<tr align="center" class="trBg">
							<td height="20"  colspan="2">
							合计
							</td>
							<td height="20"  >
							</td>
							<td height="20" >
							<fmt:formatNumber value="${MTS[0]+MTS[1]+MTS[2]+MTS[3]+MTS[4]+MTS[5]+MTS[6]+MTS[7]+MTS[8]+MTS[9] }" pattern="#0.000"/>
							</td>
							<td height="20" >
								<div align="center">
								<fmt:formatNumber value="${dataanaly.managerLevelTotalScores}" pattern="#0.000"/>
								</div>
							</td>
							<td height="20"  >
							<fmt:formatNumber value="${dataanaly.managerLevelTotalScores /(MTS[0]+MTS[1]+MTS[2]+MTS[3]+MTS[4]+MTS[5]+MTS[6]+MTS[7]+MTS[8]+MTS[9] ) * 100}" pattern="#0.00"/>%
							</td>
						</tr>
						
					</table>
					<br/>
					
			
			
					<div style="width: 80%" id="containerLine">
					
				
				</div>
				
				<br />
	</div>
	</div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<base href="<%=basePath%>"></base>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>评估系统</title>
		<script language="javascript" type="text/javascript" src="js/jquery-1.4.3.js"></script>
		<script language="javascript" type="text/javascript" src="js/Chart.js"></script>
		<script type="text/javascript" src="highcharts/highcharts.js"></script>
		<script type="text/javascript" src="highcharts/highcharts-more.js"></script>
		<script type="text/javascript" src="highcharts/modules/data.js"></script>
		<script type="text/javascript" src="highcharts/modules/exporting.js"></script>
		<script type="text/javascript">	
$(function () {
    
    // Parse the data from an inline table using the Highcharts Data plugin
    $('#container').highcharts({
    	data: {
	    	table: 'freq',
	    	startRow: 2,
	    	endRow: 17,
	    	endColumn: 7
	    },
	    
	    chart: {
	        polar: true,
	        type: 'column'
	    },
	    
	    title: {
	        text: '企业指标得分占指标满分比值',
	        	x: -40
	    },
	    
	    subtitle: {
	    	text: ''
	    },
	    
	    pane: {
	    	size: '85%'
	    },
	    
	    legend: {
	    	reversed: true,
	    	align: 'right',
	    	verticalAlign: 'top',
	    	y: 100,
	    	layout: 'vertical'
	    },
	    
	    xAxis: {
	    	tickmarkPlacement: 'on'
	    },
	        
	    yAxis: {
	        min: 0,
	        endOnTick: false,
	        showLastLabel: true,
	        title: {
	        	text: ''
	        },
	        labels: {
	        	formatter: function () {
	        	}
	        }
	    },
	    
	    tooltip: {
	    	valueSuffix: '%'
	    },
	        
	    plotOptions: {
	        series: {
	        	stacking: 'normal',
	        	shadow: false,
	        	groupPadding: 0,
	        	pointPlacement: 'on'
	        }
	    }
	});
});
		</script>
		<script language="javascript" type="text/javascript" src="js/excanvas.js"></script>
				<script type="text/javascript">
			function download(){
				var chart_line = $("#container").highcharts();  
		     
		        var svg_line = chart_line.getSVG();  
		        $("#imgSvg").val(svg_line);
		      
				$("#writeWord").submit();
			}

		
			
		</script>
<style type="text/css">
table {
	border-right: 1px #a8c7ce solid;
	border-top: 1px #a8c7ce solid;
}

td {
	border-left: 1px #a8c7ce solid;
	border-bottom: 1px #a8c7ce solid;
	height: 28px;
	text-align: center;
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
	}
.btn {
	background-image:url(images/right-anniubg1.png);
	border:0px;
	width:86px;
	height:20px;
	line-height:20px;}
</style>
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
			
	
	
	
	
	<div style="width:100%; height:457px; position:absolute; top:11%; left:0.4%;">
	<div style="width:100%; height:100%; margin-top:0.5%; overflow-y: scroll;">
		<div style="padding-left:  200px;padding-right: 200px;">
			<h1 align="center">科技型中小企业信用评定系统评定报告</h1>
           <div align="right">
           <!-- 
           <span><input type="button" value="下载" onclick='download();' /></span>
            -->
           </div>
           
			<input type="hidden" value="<s:property value="rating.companyId"/>" id="id" />
			<h4 align="right">评定日期:<s:property value="rating.createTime" /></h4>
			<form action="rating/writeWord" method="post" id="writeWord">
			<input name="imgBase64" id="imgSvg"  type="hidden"/>
			<input name="companyId" value="${rating.companyId}"   type="hidden"/>
			<input name="companyName" value="${enter.epname}"   type="hidden"/>
			</form>
			<h2>一、评定结果</h2>
			<table align="center" width="400px" height="300px" cellspacing="0px">
				<tr style="height:45px;">
				<td style="background-color: #086FB4;color: #FFFFFF; font-size: 25px;text-align: left;"  >&nbsp;<s:property value="enter.epname" /></td>
				</tr>
				<tr>
					<td style="color: #7D7D7B; font-size: 25px;height: 45px;text-align: left;border-bottom: 0px;" >&nbsp;综合得分：<s:property value="rating.total" /></td>
				</tr>
				<tr>
					<td style="height: 200px;border-top: 0px;">
			<s:if test="rating.rating == 'AAA'">
					<font size="25px"  color="#99CC33">
				优秀
				</font>
			</s:if>
			<s:elseif test="rating.rating == 'AA'">优良</s:elseif>
			<s:elseif test="rating.rating == \"A\"">较好</s:elseif>
			<s:elseif test="rating.rating == 'BBB'">一般</s:elseif>
			<s:elseif test="rating.rating == 'BB'">欠佳</s:elseif>
			<s:elseif test="rating.rating == 'B'">较差</s:elseif>
			<s:elseif test="rating.rating == 'CCC'">
		
			很差
			</s:elseif>
</td>
				</tr>
			</table>
			<h2>二、评定综述</h2>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;被评公司<s:property value="enter.epname" />
				为
				<s:if test="enter.stage==1">初创</s:if>
				<s:if test="enter.stage==2">成长</s:if>
				<s:if test="enter.stage==3">稳定</s:if>型企业，所属行业为<s:property value="aaa" />
			</p>
			<p style="width: 700px;line-height:30px;">&nbsp;&nbsp;&nbsp;
			<s:if test="rating.rating == 'AAA'">企业信用优秀。企业信用程度高，债务风险小，经营状况佳，盈利能力强，公司治理结构合理，管理制度十分完善，研发能力优异，科技创新能力很强，发展前景广阔，不确定性因素对其经营与发展影响极小。</s:if>
			<s:elseif test="rating.rating == 'AA'">企业信用优良。企业的信用程度较高，债务风险较小，经营状况较佳，盈利水平较高，公司治理结构合理，管理制度比较完善，有较强的研发能力，科技创新能力也较强，发展前景较为广阔，不确定性因素对其经营与发展的影响很小。</s:elseif>
			<s:elseif test="rating.rating == \"A\"">企业信用较好。企业的信用程度良好，在正常情况下偿还债务没有问题，经营处于良性循环状态，盈利能力较好，公司治理结构比较合理，管理制度比较完善，研发能力较好，科技创新能力较强，发展前景较好，但是可能会有些影响其未来经营与发展的不确定因素，进而削弱其盈利能力和偿债能力。</s:elseif>
			<s:elseif test="rating.rating == 'BBB'">企业信用一般。企业的信用程度一般，偿还债务的能力一般，易受外界影响而波动，各项指标处于中等水平，公司治理结构上课，管理制度不算特别完善，研发能力中等，科技创新能力一般，其经营状况、盈利水平及未来发展前景易受不确定因素影响。</s:elseif>
			<s:elseif test="rating.rating == 'BB'">企业信用欠佳。企业的信用程度较差，资产质量和信用状况较差，盈利能力和偿债能力较弱，公司管理体系也较差，科技创新能力偏低，经营上存在一定风险发展前景不乐观，投资该企业含有投机性因素。</s:elseif>
			<s:elseif test="rating.rating == 'B'">企业信用较差。资产质量和和信用状况差，经济实力低，经营业绩差，盈利能力和偿债能力偏低，公司管理结构不完善，研发能力不好，科技创新能力很差，经营风险较大，但目前尚有能力还本付息。</s:elseif>
			<s:elseif test="rating.rating == 'CCC'">企业信用很差。企业信用程度很差，基本上没有或者已经没有了偿债能力，有的甚至处于破产边缘。公司管理结构处于瘫痪边缘，几乎没有研发能力和创新能力，经营具有重大风险，属于高度投机性公司。</s:elseif>
			</p>
			<br></br>
			<div align="center">
			<font></font>
			<div style="width:80%" >
			<div id="container" style="min-width: 420px; max-width: 800px; height: 450px; margin: 0 auto"></div>

<div style="display:none">
	<table id="freq" border="0" cellspacing="0" cellpadding="0">
		<tr nowrap bgcolor="#CCCCFF">
			<th colspan="9" class="hdr"></th>
		</tr>
		<tr nowrap bgcolor="#CCCCFF">
		
		</tr>
		<tr nowrap>
			<td class="dir">N</td>
			<td class="data">指标得分率</td>
		
		</tr>	
		<s:iterator value="ratingresults" >
		<tr  >
			<td class="dir"><s:property value="CompanyName" /></td>
			<td class="data"><s:property value="createTime" /></td>
		</tr>
		</s:iterator>	
		
	</table>
</div>
			</div>
			</div>
			<br></br>
			<h2>三、企业概述</h2>
			<h4>&nbsp;&nbsp;&nbsp;&nbsp;3.1 企业基本信息</h4>
			<span>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="enter.epname" />是
			<s:if test="enter.stage==1">初创</s:if>
				<s:if test="enter.stage==2">成长</s:if>
				<s:if test="enter.stage==3">稳定</s:if>型企业， 成立于
				<s:property value="enter.createTime.substring(0, 4)"/>年。公司注册资本
				<s:property value="enter.registMoney" />万元。公司概况如下：</span>
			<br />
			<table width="60%" align="center" border="1px" bordercolor="#a8c7ce"
				cellspacing="0px">

				<tr>
					<td width="50%" colspan="2">公司所属行业：</td>
					<td width="50%"><s:property value="aaa" /></td>
				</tr>
				<tr>
					<td width="50%" colspan="2">公司法定代表人：</td>
					<td width="50%"><s:property value="enter.legalPerson" /></td>
				</tr>
				<tr>
					<td width="50%" colspan="2">公司注册地址：</td>
					<td width="50%"><s:property value="enter.registAddress" /></td>
				</tr>
				<tr>
					<td width="25%" rowspan="4">公司联系方式</td>
					<td width="25%">地址：</td>
					<td width="25%"><s:property value="enter.address" /></td>
				</tr>
				<tr>
					<td width="25%">电话：</td>
					<td width="25%"><s:property value="enter.contactPhone" /></td>
				</tr>
				<tr>
					<td width="25%">E-mail：</td>
					<td width="25%"><s:property value="enter.contactEmail" /></td>
				</tr>
			</table>

			<h4>&nbsp;&nbsp;&nbsp;&nbsp;3.2 重大信息披露 </h4>
			<h4>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="att.IinfoDisclosure" /></h4>

			<h4>&nbsp;&nbsp;&nbsp;&nbsp;3.3 受评定企业股东及股权结构 </h4>
			<br />
			<table width="60%" align="center" border="1px" bordercolor="#a8c7ce"
				cellspacing="0px">

				<tr>
					<td width="50%">股东名称：
					</td>
					<td width="50%">持股比例：</td>
				</tr>
				<tr>
					<td width="50%"><s:property value="att.shareholderNameOne" /></td>
					<td width="50%"><s:property value="att.shareholdingRatioOne" />%</td>
				</tr>
				<tr>
					<td width="50%"><s:property value="att.shareholderNameTwo" /></td>
					<td width="50%"><s:property value="att.shareholdingRatioTwo" />%</td>
				</tr>
				<tr>
					<td width="50%"><s:property value="att.shareholderNameThree" /></td>
					<td width="50%"><s:property value="att.shareholdingRatioThree" />%</td>
				</tr>
				<tr>
					<td width="50%"><s:property value="att.shareholderNameFour" />
					</td>
					<td width="50%"><s:property value="att.shareholdingRatioFour" />%</td>
				</tr>
				<tr>
					<td width="50%"><s:property value="att.shareholderNameFive" /></td>
					<td width="50%"><s:property value="att.shareholdingRatioFive" />%</td>
				</tr>

			</table>
			<h4>&nbsp;&nbsp;&nbsp;&nbsp;3.4 主要财务数据和指标 </h4>
			<table width="60%" align="center" border="1px" bordercolor="#a8c7ce"
				cellspacing="0px">
				<tr>
					<td width="50%">项目：</td>
					<td width="50%"><s:property value="att.createTime" /></td>
				</tr>
				<tr>
					<td width="50%">总资产</td>
					<td width="50%"><s:property value="att.totalAssets" />(万元)</td>
				</tr>
				<tr>
					<td width="50%">所有者权益</td>
					<td width="50%"><s:property value="ownerEquity" />(万元)</td>
				</tr>
				<tr>
					<td width="50%">主营业务收入</td>
					<td width="50%"><s:property value="att.mainOperationIncome" />(万元)</td>
				</tr>
				<tr>
					<td width="50%">利润总额</td>
					<td width="50%"><s:property value="att.totalProfit" />(万元)</td>
				</tr>
			<tr>
					<td width="50%">净资产收益率 (%)</td>
					<td width="50%"><s:property value="data.netAssetReturnRatioTarget * 100 " /></td>
				</tr>
				<tr>
					<td width="50%">流动比率 </td>
					<td width="50%"><s:property value="data.liquidRatioTarget" /></td>
				</tr>
				<tr>
					<td width="50%">速动比率 </td>
					<td width="50%"><s:property value="data.quickRatioTarget" /></td>
				</tr>
				<tr>
					<td width="50%">总资产回报率 (%)</td>
					<td width="50%">
					<fmt:formatNumber type="number" pattern="###.#">
					<s:property value="data.totalAssetReturnRatioTarget  * 100" />
					</fmt:formatNumber>
					</td>
				</tr>

			</table>

		
		<h2>四、评定内容</h2>
		<!--初创型企业 -->
		<div id="" class="dis">
			<!-- 显示内容包括两部分：得分和评语，评语根据得分所处的范围选择对应的描述文字-->
			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.1、企业规模
			</h4>
			评价：
			<div id="" class="dis">
				<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.scale" /></p>
			</div>


			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.2、偿债能力
			</h4>
			评价：
			<div id="" class="dis">
				<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.payPower" /></p>
			</div>


			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.3、营运能力
			</h4>
			评价：
			<div id="" class="dis">
			<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.run" /></p>

			</div>


			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.4、盈利能力
			</h4>
			评价：
			<div id="" class="dis">
			<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.gainPower" /></p>

			</div>

			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.5、成长性
			</h4>
			评价:
			<div id="" class="dis">
			<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.growth" /></p>

			</div>

			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.6、创新性

			</h4>
			评价：
			<div id="" class="dis">
				<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.creative" /></p>
			</div>

			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.7、信用履约能力
			</h4>
			评价：
			<div id="" class="dis">
			<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.creditPerformance" /></p>
			</div>

			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.8、管理水平
			</h4>
			评价：
			<div id="" class="dis">
				<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.managePower" /></p>

			</div>

			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;4.9、市场竞争力
			</h4>
			评价：
			<div id="" class="dis">
				<p style="line-height:30px;width: 800px;">&nbsp;&nbsp;<s:property value="rating.marketCompetitive" /></p>
			</div>
		</div>
		</div>
		
		</div>
		</div>
	</body>
</html>

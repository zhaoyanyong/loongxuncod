<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	font-family: "宋体";
	font-size: 13px;
	text-decoration: none;
	color: #fff;
}

.btn {
	background-image: url(images/right-anniubg1.png);
	border: 0px;
	width: 86px;
	height: 20px;
	line-height: 20px;
}
</style>
		<title>营运能力</title>

		<script language="javascript" type="text/javascript"
			src="js/jquery-1.9.1.min.js"></script>
		<script src="highcharts/highcharts.js"></script>
		<script src="highcharts/modules/exporting.js"></script>
	</head>

	<body>
		<div style="margin-right: 0.5%">
			<img src="images/right.png" width="100%" height="524">
		</div>

		<div style="position: absolute; top: 2%; left: 2%; width: 10px;">
			<img src="images/right-bai.jpg" height="8" width="8">
		</div>

		<div style="position: absolute; top: 1%; left: 3%; width: 350px;">
			当前登录的用户：
			<span style="font-weight: bold; font-size: 18px;">${admin.aname
				}</span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：
			<span style="font-weight: bold; font-size: 16px;">${admin.roleName
				}</span>
		</div>

		<div style="position: absolute; top: 2%; left: 85.5%; width: 10px;">
			<img src="images/right-sanjiao.png" width="8" height="8">
		</div>

		<div style="position: absolute; top: 1.6%; left: 87%; width: 30px;">
			IP:${admin.ip }
		</div>
		<div style="position: absolute; top: 7%; left: 1%; width: 30px;">
			<img src="images/right-dangqian.png" width="20" height="20">
		</div>
		<div
			style="position: absolute; top: 7.7%; left: 3%; width: 250px; color: #FFF;">
			目前操作的功能：营运能力
		</div>
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

		<div
			style="width: 100%; height: 407px; position: absolute; top: 12%; left: 0.4%;">
			<div style="width: 98.5%;">
				<table cellpadding="0" cellspacing="0" width="100%">
					<tr height="22" align="center" style="background-color: #d3eaf0;">
						<th width="20%" align="center"
							style="border-left: 1px #a8c7ce solid;">
							营运能力
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
						<td height="20">
							总资产周转率
						</td>
						<td height="20">
							<s:property value="dataanaly.totalAssetTurnRatioTarget" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${OTS[0] }" pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.totalAssetTurnRatioValue}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.totalAssetTurnRatioValue / OTS[0] * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">
							流动资产周转率
						</td>
						<td height="20">
							<s:property value="dataanaly.liquidAssetTurnRatioTarget" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${OTS[1] }" pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.liquidAssetTurnRatioValue}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.liquidAssetTurnRatioValue / OTS[1] * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">
							固定资产周转率
						</td>
						<td height="20">
							<s:property value="dataanaly.fixAssetTurnRatioTarget" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${OTS[2] }" pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.fixAssetTurnRatioValue}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.fixAssetTurnRatioValue / OTS[2] * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">
							应收帐款周转率
						</td>
						<td height="20">
							<s:property value="dataanaly.receivableTurnRatioTarget" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${OTS[3] }" pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.receivableTurnRatioValue}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.receivableTurnRatioValue / OTS[3]  * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">
							存货周转率
						</td>
						<td height="20">
							<s:property value="dataanaly.stockTurnRatioTarget" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${OTS[4] }" pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.stockTurnRatioValue}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.stockTurnRatioValue / OTS[4] * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">
							资产保值增值率
						</td>
						<td height="20">
							<s:property value="dataanaly.assetIncrementRatioTarget" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${OTS[5] }" pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.assetIncrementRatioValue}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.assetIncrementRatioValue / OTS[5] * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">
							销售收入增长率
						</td>
						<td height="20">
							<s:property value="dataanaly.saleGrowRatioTarget" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${OTS[6] }" pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.saleGrowRatioValue}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.saleGrowRatioValue / OTS[6] * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20">
							合计
						</td>
						<td height="20"></td>
						<td height="20">
							<fmt:formatNumber
								value="${OTS[0]+OTS[1]+OTS[2]+OTS[3]+OTS[4]+OTS[5]+OTS[6] }"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber value="${dataanaly.operationTotalScores}"
								pattern="#0.000" />
						</td>
						<td height="20">
							<fmt:formatNumber
								value="${dataanaly.operationTotalScores / (OTS[0]+OTS[1]+OTS[2]+OTS[3]+OTS[4]+OTS[5]+OTS[6]) * 100}"
								pattern="#0.00" />
							%
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>

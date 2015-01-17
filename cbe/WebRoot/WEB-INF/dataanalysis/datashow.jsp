<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<script type="text/javascript" src="js/jquery.js"></script>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>查看数据</title>
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
<script type="text/javascript">
$(function () {
    	
    	// Radialize the colors
		Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function(color) {
		    return {
		        radialGradient: { cx: 0.5, cy: 0.3, r: 0.7 },
		        stops: [
		            [0, color],
		            [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
		        ]
		    };
		});
		
		// Build the chart
        $('#container').highcharts({
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '信用履约能力指标, 2014'
            },
            tooltip: {
        	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                        style: {
                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                        },
                        connectorColor: 'silver'
                    }
                }
            },
            series: [{
                type: 'pie',
                name: '数据值：',
                data: [
                    ['合计',   45.0],
                    ['经营决策者个人信誉',       26.8],
                    {
                        name: '应付账款清付率',
                        y: 12.8,
                        sliced: true,
                        selected: true
                    },
                    ['贷款逾期率',    8.5],
                    ['利息偿付率 ',     6.2],
                    ['其他',   0.7]
                ]
            }]
        });
    });
    

		</script>
</head>
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
</style>
<body>
	<div style="margin-right:0.5%">
		<img src="images/right.png" width="100%" height="524">
	</div>
	<div style="position:absolute; top:2%; left:2%; width:10px;">
		<img src="images/right-bai.jpg" height="8" width="8">
	</div>

<div style="position: absolute; top: 1.6%; left: 3%; width: 320px;">
			当前登录的用户：<span style="font-weight: bold;font-size: 18px;">${admin.aname }</span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：<span style="font-weight: bold;font-size: 16px;">${admin.roleName }</span>
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
		style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：定性数据查看</div>

	<div
		style="position: absolute; top: 6.5%; left: 85%; width: 200px; color:#FFF;">
		<div style="float:left; margin-top:3%">
			<img src="images/right-jiahao.png" width="13" height="13">
		</div>
		<div style="float:left; margin-top:3%">添加</div>
		<div style="float:left; margin-top:3%; margin-left:5%">
			<img src="images/right-lese.png" width="13" height="13">
		</div>
		<div style="float:left; margin-top:3%">删除</div>
		<div style="float:left; margin-top:3%; margin-left:5%"">
			<img src="images/right-bianji.png" width="13" height="13">
		</div>
		<div style="float:left; margin-top:3%">编辑</div>
	</div>
	
	<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
		<div style="width:98.5%; height:100%; margin-top:0.5%;">
			<script src="jsM/highcharts.js"></script>
			<script src="jsM/modules/exporting.js"></script>

			<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>			
		</div>
	</div>
</body>
</html>

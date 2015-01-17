<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
		<script type="text/javascript">
	function logout(){
	var r = window.confirm("确定要退出？");
  	if (!r) {
	    return null;
      }    
  	
    top.location.href="logout";
}
	function logout1(){
		var r = window.confirm("确定要更换用户？");
	  	if (!r) {
		    return null;
	      }    
	  	
	    top.location.href="logout";
	}
	function leftF(){
		var objs=document.getElementById("firMenu").getElementsByTagName("a");
		objs[0].id="menuId";
		lnk = document.getElementById("menuId");
		lnk.click();
	}
	function showtime()
	{
	var today,hour,second,minute,year,month,date;
	var strDate ;
	today=new Date();
	var n_day = today.getDay();
	switch (n_day)
	{
	    case 0:{
	      strDate = "星期日"
	    }break;
	    case 1:{
	      strDate = "星期一"
	    }break;
	    case 2:{
	      strDate ="星期二"
	    }break;
	    case 3:{
	      strDate = "星期三"
	    }break;
	    case 4:{
	      strDate = "星期四"
	    }break;
	    case 5:{
	      strDate = "星期五"
	    }break;
	    case 6:{
	      strDate = "星期六"
	    }break;
	    case 7:{
	      strDate = "星期日"
	    }break;
	}
	year = today.getFullYear();
	month = today.getMonth()+1;
	date = today.getDate();
	hour = today.getHours();
	minute =today.getMinutes();
	second = today.getSeconds();
	document.getElementById('time').innerHTML = year + "年" + month + "月" + date + "日   " + strDate +" " + hour + ":" + minute + ":" + second; //显示时间
	setTimeout("showtime();", 1000); //设定函数自动执行时间为 1000 ms(1 s)
	}
	
</script>
		<style type="text/css">
body {
	font-family: "宋体";
	font-size: 13px;
}

a {
	font-family: "宋体";
	font-size: 13px;
	text-decoration: none;
	color: #FFF;
}
</style>
	</head>

	<body onload="setTimeout(function(){leftF();}, 100);">
		<div style="width: 100%; height: 100%">

			<div>
				<img src="images/top-yetou.jpg" width="100%" height="120" />
			</div>
			<div style="position: absolute; top: 0%; left: 14%; width: 361px;">
				<img src="images/logo.png" width="300" height="75" />
			</div>

			<div style="position: absolute; top: 44%; left: 77%; width: 100%;">
				<div style="float: left">
					<a href="toUpdatePassword" target="rightFrame"><span style="color: #000;">修改密码</span></a>
				</div>
				<div style="float: left; margin-left: 4.5%">
					<a href="javascript:void(0);" target="_top" onClick="logout1()"><span style="color: #000;">更换用户</span></a>
				</div>
				<div style="float: left; margin-left: 4.5%">
					<a href="javascript:void(0);" target="_top" onClick="logout()"><span style="color: #FFF;">安全退出</span></a>
				</div>
			</div>

			<div id="firMenu"
				style="position: absolute; top: 72%; left: 23%; width: 750px; color: #FFF">
				<c:if
					test="${accessMap.qyxxcx=='1' || accessMap.qyxxlr=='1' || accessMap.zfgkxxcx=='1' || accessMap.zfgkxxlr=='1' || accessMap.scjyxxcx=='1' || accessMap.scjyxxlr=='1' || accessMap.cwglxxcx=='1' || accessMap.cwglxxlr=='1' || accessMap.trzxxcx=='1' || accessMap.trzxxlr=='1' || accessMap.qywhxxcx=='1' || accessMap.qywhxxlr=='1' || accessMap.shgzxxcx=='1' || accessMap.shgzxxlr=='1' }">
					<div style="float: left; margin-left: 2%">
						<a href="framleft?id=1" target="leftFrame"><span style="font-size:15px;">资信调查</span></a>
					</div>
				</c:if>
				<c:if
					test="${accessMap.dlsjck=='1' || accessMap.dxsjck=='1'}">
					<div style="float: left; margin-left: 2%">
						<a href="framleft?id=2" target="leftFrame"><span style="font-size:15px;">数据分析</span></a>
					</div>
				</c:if>
				<c:if
					test="${accessMap.pdjs=='1' || accessMap.pkcx=='1'}">
					<div style="float: left; margin-left: 2%">
						<a href="framleft?id=3" target="leftFrame"><span style="font-size:15px;">信用评定</span></a>
					</div>
				</c:if>
				
				<div style="float: left; margin-left: 2%">
						<a href="framleft?id=6" target="leftFrame"><span style="font-size:15px;">信用报告</span></a>
					</div>
				
				<div style="float: left; margin-left: 2%">
						<a href="framleft?id=7" target="leftFrame"><span style="font-size:15px;">债务催收</span></a>
					</div>
					
				<div style="float: left; margin-left: 2%">
						<a href="framleft?id=8" target="leftFrame"><span style="font-size:15px;">风险预警</span></a>
					</div>
				
				<div style="float: left; margin-left: 2%">
						<a href="framleft?id=5" target="leftFrame"><span style="font-size:15px;">交易支付</span></a>
					</div>
				<c:if
					test="${accessMap.yhlb=='1' || accessMap.jslb=='1' || accessMap.rzlb=='1'}">
					<div style="float: left; margin-left: 2%">
						<a href="framleft?id=4" target="leftFrame"><span style="font-size:15px;">系统设置</span></a>
					</div>
				</c:if>
			</div>

			<div
				style="position: absolute; top: 73%; left: 78.8%; width: 300px; color: #FFF">
				<span id="time"></span>
<script language="javascript"> showtime();</script>
			</div>

		</div>

	</body>

</html>

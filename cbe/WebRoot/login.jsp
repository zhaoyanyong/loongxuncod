<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
<title>银企通企业信用信息系统</title>
<style>
#loginpot {
	position: absolute;
	left: 40%;
	top: 30%;
}
</style>
<script type='text/javascript'>
	function change() {
		document.getElementById("imageCode").src = "validateCode?date="
				+ new Date().getTime();
	}
	document.onkeydown = function(event) {
		e = event ? event : (window.event ? window.event : null);
		if (e.keyCode == 13) {
			//执行的方法  
			document.getElementById("butnLogin").click(); //调用登录按钮的登录事件  
		}
	}
	$(function() {
		$("#example-one").organicTabs({
			"speed" : 200
		});
	});
</script>
<style type="text/css">
html, body {
	height: 100%;
	width: 100%;
	font-family: "宋体";
	font-size: 16px;
	color: #000;
}
</style>
</head>

<body
	style="overflow:hidden; width:100%; height:100%; z-index:-1; margin:-8px; background-image: url('images/login_bg.jpg'); background-repeat: no-repeat; background-size:100% 100%;">
	<form id="loginForm" action="login" method="post" class="form-inline"
		role="form">

		<div id="loginpot"
			style="width:650px; height:300px; background-image: url('images/login_loginbg.png'); background-repeat: no-repeat;">
			<div
				style="position: absolute; left:100px; top:10px; width:400px; height:250px; ">

				<div style=" width:100%; height: 22%;">
					<span style="padding-left:30px; color: #f1f1f1"><input
						value="1" name="loginuser" id="radio1" type="radio" /><label
						for="radio1">管理员</label></span> <span
						style="padding-left:5px;color: #f1f1f1"><input
						value="2" name="loginuser" checked="checked" id="radio2"
						type="radio" checked="checked" /><label for="radio2">企业用户</label></span>

					<span style="padding-left:5px;color: #f1f1f1"><input
						value="3" name="loginuser" id="radio3" type="radio" /><label
						for="radio3">银行用户</label></span>
				</div>

				<div style=" width:100%; height:65%;">
					<span style="line-height:37px;padding-left:40px;">用户名：
						<input type="text" name="username" id="username"
						style="width:168px" class="form-control" />
					</span> <br /> <span
						style="line-height:37px;padding-left:40px;">密&nbsp;&nbsp;码：
						<input type="password" name="password" id="password"
						style="width:168px" class="form-control" />
					</span> <span style="font-size:9;color:red;">${message}</span><br /> <span
						style="line-height:37px;padding-left:40px;">验证码&nbsp;&nbsp;
						<input style="width:66px;vertical-align:middle;" type="text"
						name="loginCode" id="loginCode" maxlength="4" class="form-control" />
						<img src="validateCode" alt="点击更换验证码"
						style="vertical-align:middle;" title="点击更换验证码" id="imageCode"
						onclick="change();" />
					</span> <span style="font-size:9;color:red;">${messageCode}</span>
					<p />
				</div>

				<div style="margin-left: 10%">

					<span>&nbsp;&nbsp; <input class="btn btn-default"
						onclick="javascript:document.getElementById('loginForm').submit();return false;"
						id="butnLogin" type="button" value="登录用户" /> &nbsp;<input
						class="btn btn-default" onclick="location='register.jsp'"
						type="button" value="企业注册" />

					</span><br />
				</div>

			</div>
		</div>

		<div
			style="width: 310px; height: 300px; position: absolute; top:30%; right:60.5%">
			<div style="margin-top: 10%">
				<img src="images/login_log.jpg" />
			</div>
			<div style="margin-left:18%; margin-top: 30%">
				<img src="images/login_user.png" />
			</div>
		</div>

		<div
			style="width: 320px; height: 58px; position: absolute; top:15%; left:40%;">
			<div>
				<img src="images/login_font.png" />
			</div>
		</div>

	</form>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>银企通全国企业信用信息系统</title>
	<style>

	body{
	border:none;
	}
	
	</style>
	
</head>
<body style="margin: 0px;" >
<div style="position:absolute; top:0px; left:0px; width:100%; height:100%;">
	<iframe src=" framtop.action"width="100%" height="125px;" frameborder="0" marginheight="0" marginwidth="0" scrolling="no" style="background-color:#353c44;"></iframe>
	<iframe src="frammain.action"width="100%" height="530px;;"  id="center" name="center" frameborder="0" scrolling="no"
		marginheight="0" marginwidth="0" style="background-color:#353c44;"></iframe>
</div>
        		

</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
-->
</style>
</head>

<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="210"  valign="top" id="td2"> 
   <div  id="td1"  style="height:100%">
	    	<iframe height="100%" width="100%" scrolling="no" marginheight="0"  marginwidth="0" frameborder="0" src="" name="leftFrame" id="leftFrame" title="leftFrame" style="background-color:#353c44;"></iframe>
	</div>
    </td>
   
    <td valign="top">
    	<iframe height="100%" width="100%" scrolling="no" marginheight="0" marginwidth="0" frameborder="0" src="findEnter.action?toRight=toGovernment" name="rightFrame" id="rightFrame" title="rightFrame" style="background-color:#353c44;"></iframe>
	
    </td>
    
  </tr>
</table>
</body>
</html>

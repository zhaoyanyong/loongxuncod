<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>模板</title>

<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
<script type="text/javascript" language="javascript" >
//使标签checkboxlist的值回显
function check(priviId){
	var val = document.getElementsByName("privilegeIds");
//		alert("val:"+val);
	for(var j=0;j<priviId.split(",").length;j++){
		for(var i=0;i<val.length;i++){
			if(priviId.split(",")[j]==val[i].value){
				val[i].checked=true;
			}
		}
	}
//		alert(val[0].value);
}
//判断多选框checkboxlist是否选中
function checkSelect(){
	var n = $('input[type="checkbox"]:checked').length
	if(n>0)
		return true; 
	else
		alert("请至少选择一个权限");
	return false;
	}
function saveRole(){
	if(checkSelect()){
		document.forms[0].submit();
	}
}

</script>
<style type="text/css">
table {
	border-right:1px #a8c7ce solid;
	border-top:1px #a8c7ce solid;
	}
td {
	border-left:1px #a8c7ce solid;
	border-bottom:1px #a8c7ce solid;
	height:28px;
	text-align:center;
	}
body {
	font-family:"宋体";
	font-size:13px;
	}
.btn {
	background-image:url(images/right-anniubg1.png);
	border:0px;
	width:86px;
	height:20px;
	line-height:20px;}
</style>
</head>

<body onload="check('${role.privilegeIds }');">
	<div>
		<div style="margin-right:0.5%"><img src="images/right.png" width="100%" height="524"></div>
        
        <div style="position:absolute; top:2%; left:2%; width:10px;"><img src="images/right-bai.jpg" height="8" width="8"></div>
        
<div style="position: absolute; top: 1.6%; left: 3%; width: 320px;">
			当前登录的用户：<span style="font-weight: bold;font-size: 18px;">${admin.aname }</span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：<span style="font-weight: bold;font-size: 16px;">${admin.roleName }</span>
		</div>

		<div style="position: absolute; top: 2%; left: 85.5%; width: 10px;">
			<img src="images/right-sanjiao.png" width="8" height="8">
		</div>

		<div style="position: absolute; top: 1.6%; left: 87%; width: 30px;">
			IP:${admin.ip }
		</div>
      <div style="position: absolute; top: 7%; left: 1%; width: 30px;"><img src="images/right-dangqian.png" width="20" height="20"></div>
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：角色信息修改</div>
        
        
        <div style="width:100%; height:450px; position:absolute; top:12%; left:0.4%;">
        	<div style="width:98.5%; height:100%;">
            <!-- table内嵌样式 -->
            <form action="updateRole" method="post">
            <s:hidden name="role.roleId"/>
       		<table cellpadding="0" cellspacing="0" width="100%">
            	
                <tr>
                    <td width="13%">&nbsp;角色名称：</td>
                    <td width="66%" style="text-align: left;">&nbsp;<s:property value="role.roleName" /></td>
                    <td width="18%">&nbsp;</td>
                </tr>
                <tr>
                    <td>&nbsp;设置权限：</td>
                    <td style="text-align: left;">
                        	<s:checkboxlist id="checkbox" name="privilegeIds" list="rights" 
                        	listKey="rightsId" listValue="rightsName" theme="simple"/> 
										</td>
                    <td style="text-align: left;">&nbsp;<span class="required" style="color:red;">*</span>至少选择一个权限</td>
                </tr>
               
            </table>
            </form>
            <div align="center" style="margin-top: 20px;">
			<input type="button" value="保存" class="btn"
						onclick="saveRole();" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="button" value="返回" class="btn"
						onclick="window.history.back();" />
			</div> 
            </div>
        </div>
    </div>
</body>
</html>

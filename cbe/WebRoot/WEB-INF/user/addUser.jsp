<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>录入员工信息</title>
		<script type="text/javascript" language="javascript"
			src="js/jquery-1.4.3.js"></script>
		<script type="text/javascript" language="javascript">
		var c_ =false;
	function checkAname() {
		if ($("#aname").val() == '') {
			$("#anamemessage").text("用户名不能为空");
			$("#anamemessage").css({ 'color' : 'red'});
			return  false;
		}else{
			return true;
		}
	}
	function checkAdminNa(){
		var adminName = $("#adminName").val();
		// 先校验是否为空
		if ( adminName == null || adminName.length < 6  ) {
			c_=false;
			$("#adminmessage").text("格式不正确（6-16位字母或数字）");
			$("#adminmessage").css({ 'color' : 'red'});
			return;
		}else{
		// 校验是否重复
		$.post("checkAdminName",{"adminName":adminName},
                function(data){
			var repeat = data;
			if (repeat==0) {
				c_=false;
				$("#adminmessage").text("该账户已被注册！");
				$("#adminmessage").css({ 'color' : 'red'});
			} else {
				// 没重复的情况
				c_=true;
				$("#adminmessage").text("输入正确！");
				$("#adminmessage").css({ 'color' : 'green'});
      
			}
		});
		
		}
		}
	function checknewPass() {
		var reg = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}/;
		var  repeatpwd= document.getElementById("repeatpwd").value;
		var pwd = document.getElementById("pwd").value;
		
		if (pwd == null || !reg.test(pwd)) {
			$("#pwdmessage").css({ 'color' : 'red'});
			$("#pwdmessage").text('输入8-16位数字和大小写字母组合');
			return false;
		}else if (repeatpwd == null || !reg.test(repeatpwd)) {
			$("#repeatpwdmessage").css({ 'color' : 'red'});
			$("#repeatpwdmessage").text('输入8-16位数字和大小写字母组合');
			return false;
		}else if (pwd != repeatpwd) {
			$("#repeatpwdmessage").css({ 'color' : 'red'});
				$("#repeatpwdmessage").text( '两次密码不一致,请重新输入。');
				return false;
		}else{
			$("#pwdmessage").text("输入正确！");
			$("#pwdmessage").css({ 'color' : 'green'});
			$("#repeatpwdmessage").text("输入正确！");
			$("#repeatpwdmessage").css({ 'color' : 'green'});
			return true;
		}
	}
	function checkSex(){
		 var sex= $('input:radio[name="userBase.sex"]:checked').val();
		 if(sex==null ){
             alert("请选择性别");
             return false;
         }else{
             return true;
         }
		}
	function checkUserType(){
		 var userType= $('input:radio[name="userBase.userType"]:checked').val();
         if(userType==null ){
             alert("请选择用户类型");
             return false;
         }else{
			return true;
         }
	}
	function save(){
		if(checkUserType()&&checkSex()&&checknewPass()&&checkAname()&&c_){
			document.getElementById("save1").style.display="none";
			document.getElementById("save2").style.display="none";
			document.forms[0].submit();
			}
		}
</script>
		<link href="css/right.css" rel="stylesheet" type="text/css" />
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

	</head>

	<body>

		<div style="margin-right: 0.5%">
			<img src="images/right.png" width="100%" height="524">
		</div>
		<div style="position: absolute; top: 2%; left: 2%; width: 10px;">
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
			style="position: absolute; top: 7.7%; left: 3%; width: 250px; color: #FFF;">
			目前操作的功能：用户信息录入
		</div>
		<div
			style="position: absolute; top: 6.5%; left: 90%; width: 200px; color: #FFF;">
			<div style="float: left; margin-top: 3%"></div>
			<div style="float: left; margin-top: 3%"></div>
			<div style="float: left; margin-top: 3%;  margin-left: 5%" id="save1"
				onclick=
	save();
>
				<img src="images/right-bianji.png" width="13" height="13">
			</div>
			<div style="float: left; margin-top: 3%" id="save2" onclick=
	save();
>
				保存
			</div>
			<div style="float: left; margin-top: 3%; margin-left: 5%;"
				onclick=
	window.history.back();;
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
			<div style="width: 98.5%; height: 100%; margin-top: 0.5%;">
				<form action="saveUser" method="post">
					<table cellpadding="0" cellspacing="0" width="100%" align="left">
						<tr align="center" class="trBg">
							<td height="21" width="10%">
								<div align="center">
									&nbsp;帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：
								</div>
							</td>
							<td height="21" width="37%" align="left">
								<s:textfield theme="simple" maxlength="16" id="adminName"
									style="width:150px;" name="userBase.adminName" onblur="checkAdminNa();"></s:textfield><font color="red">&nbsp;*</font>
							<span id="adminmessage" ></span>
							</td>

						</tr>
						<tr align="center" class="trBg">
							<td height="21" width="13%">
								<div align="center">
									&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：
								</div>
							</td>
							<td height="21" width="40%" align="left">
								<input type="password"  id="pwd"
									name="userBase.password" onblur="checknewPass();" class="pwd" />
								<font color="red">*</font><span id="pwdmessage"
									style="color: red;"></span>
							</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="21" width="13%">
								<div align="center">
									&nbsp;确认密码：
								</div>
							</td>
							<td height="21" width="40%" align="left">
								<input type="password" 
									id="repeatpwd" onblur="checknewPass();" class="pwd" />
								<font color="red">*</font><span id="repeatpwdmessage"
									style="color: red;"></span>
							</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="21" width="13%">
								<div align="center">
									用&nbsp;户&nbsp;名：
								</div>
							</td>
							<td height="21" width="40%" align="left">
								<s:textfield theme="simple" maxlength="15" onblur="checkAname();" id="aname"
									style="width:150px;" name="userBase.aname"></s:textfield><font color="red">&nbsp;*</font><span id="anamemessage" 

style="color:red;"></span>
							</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="21">
								<div align="center">
									&nbsp;性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
								</div>
							</td>
							<td height="21" align="left">
								<s:radio name="userBase.sex" list="#{'0':'女','1':'男'}" id="sex"
									theme="simple"></s:radio>
							</td>
						</tr>
						<tr align="center" class="trBg">
							<td height="21">
								<div align="center">
									用户类型
								</div>
							</td>
							<td height="21" align="left">
								<s:radio name="userBase.userType" list="#{'1':'管理员','3':'银行用户'}" id="userType"
									theme="simple"></s:radio>

							</td>
						</tr>


						<tr align="left" class="trBg">
							<td height="21">
								<div align="center">
									&nbsp; 备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：
								</div>
							</td>
							<td height="21" align="left">
								<s:textarea maxlength="100" id="remarks" name="userBase.remarks"
									theme="simple" rows="4" cols="100"></s:textarea>

							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>

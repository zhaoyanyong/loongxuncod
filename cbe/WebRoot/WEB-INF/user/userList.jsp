<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

		<title>用户列表信息</title>

		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
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
	background-image: url(images/right-anniubg1.png);
	border: 0px;
	width: 86px;
	height: 20px;
	line-height: 20px;
}
</style>
		<script type="text/javascript">
//分页请求
function toPage(currPage){
      	var totalPage = $("#totalPage").val();
		if(currPage > totalPage ){
			currPage = totalPage;
		}
		if(currPage < 1){
			currPage =1;
		}
      	document.getElementById("currPage").value=currPage;
		document.forms[0].submit();
}
function del(id){
	var d = window.confirm('确定要删除?');
	if(!d){
	return;
		}
	location.href="delUser?userId="+id;
	}
		
			</script>
	</head>

	<body>
		<div>
			<div style="margin-right: 0.5%">
				<img src="images/right.png" width="100%" height="524">
			</div>

			<div style="position: absolute; top: 2%; left: 2%; width: 10px;">
				<img src="images/right-bai.jpg" height="8" width="8">
			</div>

			<div style="position: absolute; top: 1.6%; left: 3%; width: 350px;">
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
				目前操作的功能：用户列表
			</div>

			<div style="position: absolute; top: 6.5%; left: 92%; width: 200px; color:#FFF;">
            <div style="float:left; margin-top:3%; margin-left:5%"></div>
            <div style="float:left; margin-top:3%"></div>
            <div style="float:left; margin-top:3%; margin-left:5%"></div>
            <div style="float:left; margin-top:3%"></div>
            <div style="float:left; margin-top:3%" onclick="location.href='toAddUser'"><img src="images/right-jiahao.png" width="13" height="13"></div>
            <div style="float:left; margin-top:3%" onclick="location.href='toAddUser'">添加</div>
        </div>

			<div
				style="width: 100%; height: 450px; position: absolute; top: 12%; left: 0.4%;">
				<div style="width: 98.5%; height: 11%;">
					<form action="userList" method="post">
						<input type="hidden" name="page" id="currPage">
						<s:hidden name="totalPage" id="totalPage"/>
						<table cellpadding="0" cellspacing="0"
							style="border: 1px #a8c7ce solid;" width="100%">
							<tr>
								<td
									style="border-bottom: none; border-left: none; height: 50px;">
									<div style="float: left; margin-left: 28%">
										用户名：
										<s:textfield theme="simple" style="width:150px;"
											name="userBase.aname"></s:textfield>
										<button type="button" id="searchepname" onclick="toPage(1);"
											class="btn">
											查询
										</button>
									</div>
									<div style="float: left; margin-left: 40%"></div>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div style="width: 98.5%; height: 100%;">
					<!-- table内嵌样式 -->
					<table cellpadding="0" cellspacing="0" width="100%">
						<tr style="background-color: #d3eaf0;">
							<td width="18%" style="font-size: 14px">
								用户名
							</td>
							<td width="12%" style="font-size: 14px">
								账号
							</td>
							<td width="26%" style="font-size: 14px">
								用户类型
							</td>
							<td width="14%" style="font-size: 14px">
								性别
							</td>
							<td width="14%" style="font-size: 14px">
								角色
							</td>
							<td width="13%" style="font-size: 14px">
								操作
							</td>
						</tr>
						<s:iterator value="userBases">
							<tr>
								<td>
									<s:property value="aname" />
								</td>
								<td>
									<s:property value="adminName" />
								</td>
								<td>
									<s:if test="userType==1"> 管理员</s:if>
									<s:elseif test="userType==2">企业用户</s:elseif>
									<s:elseif test="userType==3">银行用户</s:elseif>
								</td>
								<td>
									<s:if test="sex==0"> 女</s:if>
									<s:elseif test="sex==1">男</s:elseif>
								</td>
								<td>
									<s:property value="roleName" />
								</td>
								<td>
									<a
										href="userDetail?userId=<s:property value="aid" />">查看</a>
									<c:if test="${loginUserAtLine!=3}">
                    &nbsp;
                    <a
											href="toUpdateUser?userId=<s:property value="aid" />">修改</a>
                      &nbsp;
                    <a href="javascript:;" onclick="del(<s:property value="aid" />);">删除</a>
									</c:if>
								</td>
							</tr>
						</s:iterator>

					</table>
							<div style="width: 100%; margin-top: 1%">
								共有${line }条记录，当前是第${page }页，共<s:property value="totalPage"/>页
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

								<c:if test="${totalPage>1 }">
									<button type="button" name="" value="" class="btn"
										onclick="javascript:toPage(1)">
										首页
									</button>&nbsp;
                    <button type="button" name="" value="" class="btn"
										onclick="javascript:toPage(${page-1})">
										上一页
									</button>&nbsp;
                  <c:if test="${page!= totalPage }">
										<button type="button" name="" value="" class="btn"
											onclick="javascript:toPage(${page+1})">
											下一页
										</button>&nbsp;
                    </c:if>
									<button type="button" name="" value="" class="btn"
										onclick="javascript:toPage(${totalPage})">
										尾页
									</button>&nbsp;
                    转到<input type="text"
										style="width: 20px; text-align: center;" id="jumpPage"
										onkeyup="this.value=this.value.replace(/\D/g,'')" />页&nbsp;
                    <button type="button" name="" value="" class="btn"
										onclick="javascript:toPage(document.getElementById('jumpPage').value)">
										跳转
									</button>
								</c:if>
							</div>
				</div>
			</div>
		</div>
	</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>生产经营信息</title>

<script type="text/javascript" language="javascript" src="js/jquery.js"></script>
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
<script type="text/javascript">

			function searchepname(){
			var epname = document.getElementById("epname").value;
			if(epname!=""&& epname!=null){
			location.href="searchEnterprise?epname="+epname+"&toRight=listAttribute";
			}
			}
			</script>
</head>

<body>
	<div>
		<div style="margin-right:0.5%"><img src="images/right.png" width="100%" height="524"></div>
        
        <div style="position:absolute; top:2%; left:2%; width:10px;"><img src="images/right-bai.jpg" height="8" width="8"></div>
        
<div style="position: absolute; top: 1.6%; left: 3%; width: 350px;">
			当前登录的用户：<span style="font-weight: bold;font-size: 18px;">${admin.aname }</span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：<span style="font-weight: bold;font-size: 16px;">${admin.roleName }</span>
		</div>

		<div style="position: absolute; top: 2%; left: 85.5%; width: 10px;">
			<img src="images/right-sanjiao.png" width="8" height="8">
		</div>

		<div style="position: absolute; top: 1.6%; left: 87%; width: 30px;">
			IP:${admin.ip }
		</div>  
      <div style="position: absolute; top: 7%; left: 1%; width: 30px;"><img src="images/right-dangqian.png" width="20" height="20"></div>
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：数据分析/数据查看</div>
        
        <div style="position: absolute; top: 6.5%; left: 93%; width: 200px; color:#FFF;">
        </div>
        
        <div style="width:100%; height:450px; position:absolute; top:12%; left:0.4%;">
        	
        	<div style="width:98.5%; height:100%;">
            <!-- table内嵌样式 -->
       		<table cellpadding="0" cellspacing="0" width="100%">
            	<tr style="background-color:#d3eaf0;">
                    <td width="10%" style=" font-size:14px">编号</td>
                    <td width="12%" style=" font-size:14px">指标年份</td>
                    <td width="40%" style=" font-size:14px">重要信息披露</td>
                    <td width="13%" style=" font-size:14px">操作</td>
                </tr>
                <c:forEach items="${abb }" var="lb"   varStatus="s">
                <tr>
                    <td>${s.count }</td>
                    <td>${lb.year}</td>
                    <td>${lb.iinfoDisclosure}</td>
                    <td>
                   
                    <a href="AnalysiscomAnaly?enterpriseId=${lb.enterpriseId}&attributeId=${lb.attributeId}">查看分析数据</a>
                    </td>
                </tr>
                </c:forEach>
               
            </table>
            	<c:if test="${loginUserAtLine!=2 }">
            	<c:if test="${line!= null }">
            	<div style="width:100%; margin-top:1%">
            		共有${line }条记录，当前是第${page }页，共${totalPage }页
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   
                   	<c:if test="${totalPage>1 }">
                    <button type="button" name="" value="" class="btn" onclick="javascript:goPage(1)">首页</button>&nbsp;
                    <button type="button" name="" value="" class="btn" onclick="javascript:goPage(${page-1})">上一页</button>&nbsp;
                  <c:if test="${page!= totalPage }">
                    <button type="button" name="" value="" class="btn"  onclick="javascript:goPage(${page+1})">下一页</button>&nbsp;
                    </c:if>
                    <button type="button" name="" value="" class="btn" onclick="javascript:goPage(${totalPage})">尾页</button>&nbsp;
                    转到<input type="text" style="width:20px; text-align:center;" id="jumpPage" onkeyup="this.value=this.value.replace(/\D/g,'')"/>页&nbsp;
                    <button type="button" name="" value="" class="btn" onclick="javascript:gotoPage()">跳转</button>
                    </c:if>
                </div>
            </c:if>
            </c:if>
            </div>
        </div>
    </div>
    <script type="text/javascript" >
    function goPage(pageNo){
               var hepname=document.getElementById('epname').value;
				var totalPage=${totalPage};
				var pageNo1=${page};
				
				if (totalPage==''||pageNo1==''){
					var max = 0;
					var s = 0;
					if((pageNo>0)&&(pageNo<=max)&&(pageNo!=s)){
						if(hepname=="" || hepname==null){
						location.href="findEnter?page="+pageNo+"&toRight=listAttribute";
						}else{
						location.href="searchEnterprise?epname="+hepname+"&page="+pageNo+"&toRight=listAttribute";
						}
					}
				}else{	
					var max = totalPage;
					var s = pageNo1;
					if((pageNo>0)&&(pageNo<=max)&&(pageNo!=s)){
				
							if(hepname=="" || hepname==null){
						location.href="findEnter?page="+pageNo+"&toRight=listAttribute";
						}else{
						location.href="searchEnterprise?epname="+hepname+"&page="+pageNo+"&toRight=listAttribute";
						}
						
					}
				}
			}
			function gotoPage(){
				
					var max = ${totalPage};
					var now = ${page};
					var s=document.getElementById('jumpPage').value;
					 var hepname=document.getElementById('epname').value;
					
					var reg1 =  /^\d+$/;//验证大于0 的整数
				
						if(hepname=="" || hepname==null){
						
							if(reg1.test(s) && s!='0' && s!='' && parseInt(s)<=parseInt(max)){
					location.href="findEnter?page="+s+"&toRight=listAttribute";
					}else{
					
					}
						}else{
							if(reg1.test(s) && s!='0' && s!='' && parseInt(s)<=parseInt(max)){
								location.href="searchEnterprise?epname="+hepname+"&page="+s+"&toRight=listAttribute";
						}
				
				
				
}}			</script>
</body>
</html>

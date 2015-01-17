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
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>信用信息征集</title>
		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
        <script type="text/javascript">
        function load(){
        	var admin ="<%=session.getAttribute("admin")%>";
        	       if(admin == "null")
        	       {
        	          top.location.href="login.jsp";
        	        }
        	var id=parseInt($("#currId").val());
        	var QiYe=$("#QiYe");
        	var DingLiang=$("#DingLiang");
        	var ZhengFu=$("#ZhengFu");
        	var JingYing=$("#JingYing");
        	var CaiWu=$("#CaiWu");
        	var RongZi=$("#RongZi");
        	var WenHua=$("#WenHua");
        	var GongZhong=$("#GongZhong");
        	var DingXing=$("#DingXing");
        	var PingDing=$("#PingDing");
			var YongHu=$("#YongHu");
			var QuanXian=$("#QuanXian");
			var ShenJi=$("#ShenJi");
			var ZhiFu=$("#ZhiFu");
			var GuanLi=$("#GuanLi");
			var XinDai=$("#XinDai");
			var TuiGuang=$("#TuiGuang");
			var BaoGao=$("#BaoGao");
			var ShiXin=$("#ShiXin");
        	
        	switch (id) {
        		case 1:
        			QiYe.css("display","block");
        			GongZhong.css("display","block");
        			WenHua.css("display","block");
        			RongZi.css("display","block");
        			CaiWu.css("display","block");
        			JingYing.css("display","block");
        			ZhengFu.css("display","block");
        			XinDai.css("display","block");
        			TuiGuang.css("display","block");
        			ShiXin.css("display","block")
        		break;
        		case 2:
        			DingXing.css("display","block");
        			DingLiang.css("display","block");
        		break;
        		case 3:
        			PingDing.css("display","block");
        		break;
				case 4:
        			YongHu.css("display","block");
					QuanXian.css("display","block");
					ShenJi.css("display","block");
        		break;
				case 5:
					ZhiFu.css("display","block");
					GuanLi.css("display","block");
        		break;
				case 6:
        			BaoGao.css("display","block");
        		break;
            }

        }
       
        $(document).ready(function(){
    		$(".menuStyle").click(function(){//主菜单点击事件
    		   	var t=$(".menuStyle").index(this);
    		   	var nav=$(".nav");
    		   	/*其他主菜单的子菜单隐藏*/
    		   	for(var i=0;i<nav.length;i++){
    		   		if(i!=t) nav[i].style.display="none";
    			}
    			/*该主菜单的子菜单改变显示或隐藏*/
    			if(nav[t].style.display=="none"){
    				nav[t].style.display="block";
    			}else{
    				nav[t].style.display="none";
    			}
    			
    		});
    	});	
        function Initdiv() {
    		var nav=$(".nav");
    		for(var i=0;i<nav.length;i++){
    			nav[i].style.display="none";
    		}	
    	}
</script>



        <style type="text/css">
body {
	font-family:"宋体";
	font-size:13px;
	}
	a {
	font-family:"宋体";
	font-size:13px;
	text-decoration:none;
	color:#000;
	}
	.menuStyle{
		margin-bottom: 4.8%;
		display: none;
	}
	.secMenu{
	margin-top: -11%; 
	margin-left: 28%;
	}
</style>
</head>
<body onload="load();Initdiv();">

	<s:hidden name="id" id="currId"></s:hidden>
	<div>
    	<div style="margin-left:1.5%"><img src="images/left.png" width="100%" height="524px;"></div>
        
        <div style="position: absolute; top: 1%; left: 5%; width: 227px;">
        	<div style="float:left"><img src="images/left-menu.png" width="20" height="20"></div>
        	<div style="float:left; margin-left:2%; margin-top:1.3%">管理菜单</div>
            <div style="float:left; margin-left:10%; margin-top:3.5%"><span style="font-size:10px; font-family:'Bradley Hand ITC'">MAIN MENU</span></div>
        </div>
       
    </div>
    <div style="width:100%; height:100%; position: absolute; top:5.8%; left:1.7%">
    
     <c:if
					test="${accessMap.zfgkxxcx=='1' || accessMap.zfgkxxlr=='1'}">   
        <div id="ZhengFu" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;" >企业基本信息</a></div>
        </div>
        	<div class="nav"  id="zhengfu"><Br/>
     				<c:if
					test="${accessMap.zfgkxxcx=='1' }">
        			<div style="margin-left: 16%;">
        			<a href="findEnter.action?toRight=toGovernment" target="rightFrame">---
        			企业基本信息查询
        			</a>
        			</div><Br/>
        			</c:if>
     				<c:if
					test="${accessMap.zfgkxxlr=='1' }">
        			<div style="margin-left: 16%;">---&nbsp;企业基本信息录入</div><Br/>
        			</c:if>
        		</div>
        		</c:if>
     <c:if
					test="${accessMap.scjyxxcx=='1' || accessMap.scjyxxlr=='1'}"> 
        <div id="JingYing" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">生产经营信息</a></div>
        </div>
        <div class="nav"  id="jingying"><Br/>
     				<c:if
					test="${accessMap.scjyxxcx=='1' }">
        		<div style="margin-left: 16%;">---&nbsp;<a href="moreAttribute_Attribute?enterpriseId=${cureeenter.id}" target="rightFrame">生产经营信息查询</a></div><Br/>
        		</c:if>
     				<c:if
					test="${accessMap.scjyxxlr=='1' }">
        		<div style="margin-left: 16%;">---&nbsp;<a href="showright_attributeinfo_addAttribute" target="rightFrame">生产经营信息录入</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.cwglxxcx=='1' || accessMap.cwglxxlr=='1'}"> 
        <div id="CaiWu" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">财务管理信息</a></div>
        </div>
        <div class="nav"  id="caiwu"><Br/>
     				<c:if
					test="${accessMap.cwglxxcx=='1' }">
        		<div style="margin-left: 16%;"><a href="moreAttributeJudge_Attribute?enterpriseId=${cureeenter.id}" target="rightFrame">---&nbsp;财务管理信息查询</a></div><Br/>
        		</c:if>
     				<c:if
					test="${accessMap.cwglxxlr=='1' }">
        		<div style="margin-left: 16%;"><a href="showright_dataanalysis_financeAdd" target="rightFrame">---&nbsp;财务管理信息录入</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
        	
        	
        	
        
        
        <div id="TuiGuang" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">产品推广信息</a></div>
        </div>
        <div class="nav"  id="tuiguang"><Br/>
     			
				
        		<div style="margin-left: 16%;">---&nbsp;推广信息查询</div><Br/>
  
        	</div>
        	
        	
     <c:if
					test="${accessMap.trzxxcx=='1' || accessMap.trzxxlr=='1'}"> 
        <div id="RongZi" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">投融资信息</a></div>
        </div>
        <div class="nav"  id="rongzi"><Br/>
     				<c:if
					test="${accessMap.trzxxcx=='1' }">
        		<div style="margin-left: 16%;"><a href="showright_dataanalysis_financing" target="rightFrame">---&nbsp;投融资信息查询</a></div><Br/>
        		</c:if>
     				<c:if
					test="${accessMap.trzxxlr=='1' }">
        		<div style="margin-left: 16%;"><a href="showright_dataanalysis_financingAdd" target="rightFrame">---&nbsp;投融资信息录入</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.qywhxxcx=='1' || accessMap.qywhxxlr=='1'}"> 
        <div id="WenHua" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">企业文化信息</a></div>
        </div>
        <div class="nav"  id="wenhua"><Br/>
     				<c:if
					test="${accessMap.qywhxxcx=='1' }">
        		<div style="margin-left: 16%;"><a href="showright_dataanalysis_culture" target="rightFrame">---&nbsp;企业文化信息查询</a></div><Br/>
        		</c:if>
     				<c:if
					test="${accessMap.qywhxxlr=='1' }">
        		<div style="margin-left: 16%;"><a href="showright_dataanalysis_cultureAdd" target="rightFrame">---&nbsp;企业文化信息录入</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.shgzxxcx=='1' || accessMap.shgzxxlr=='1'}"> 
        <div id="GongZhong" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">社会公众信息</a></div>
        </div>
        <div class="nav"  id="gongzhong"><Br/>
     				<c:if
					test="${accessMap.shgzxxcx=='1' }">
        		<div style="margin-left: 16%;"><a href="showright_dataanalysis_thePublic" target="rightFrame">---&nbsp;社会公众信息查询</a></div><Br/>
        		</c:if>
     				<c:if
					test="${accessMap.shgzxxlr=='1' }">
        		<div style="margin-left: 16%;"><a href="showright_dataanalysis_thePublicAdd" target="rightFrame">---&nbsp;社会公众信息录入</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.dlsjck=='1' }"> 
        <div id="DingLiang" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">定量分析</a></div>
        </div>
        <div class="nav"  id="dingliang"><Br/>
     				<c:if
					test="${accessMap.dlsjck=='1' }">
        		<div style="margin-left: 16%; "><a href="showDataAnalysis_dataanalysis_dataview?enterpriseId=${cureeenter.id}" target="rightFrame">---&nbsp;数据查看</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.dxsjck=='1'}"> 
        <div id="DingXing" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">定性分析</a></div>
        </div>
        <div class="nav"  id="dingxing"><Br/>
     				<c:if
					test="${accessMap.dxsjck=='1' }">
        		<div style="margin-left: 16%; "><a href="showright_dataanalysis_datashow" target="rightFrame">---&nbsp;数据查看</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.pdjs=='1' || accessMap.pkcx=='1'}"> 
        <div id="PingDing" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">评定管理</a></div>
        </div>
        <div class="nav"  id="pingding"><Br/>
     				<c:if
					test="${accessMap.pdjs=='1' }">
        		<div style="margin-left: 16%; "><a href="showright_evaluation_evaluationIntroduction" target="rightFrame">---&nbsp;评定介绍</a></div><Br/>
        		</c:if>
     				<c:if
					test="${accessMap.pkcx=='1' }">
        		<div style="margin-left: 16%; "><a href="showRating_rating_findRating?enterpriseId=${cureeenter.id}" target="rightFrame">---&nbsp;评定查询</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.yhlb=='1'}"> 
        <div id="YongHu" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">用户管理</a></div>
        </div>
        <div class="nav"  id="yonghu"><Br/>
     				<c:if
					test="${accessMap.yhlb=='1' }">
        		<div style="margin-left: 16%; "><a href="userList" target="rightFrame">---&nbsp;用户列表</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.jslb=='1' }"> 
        <div id="QuanXian" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu">角色管理</div>
        </div>
        <div class="nav"  id="quanxian"><Br/>
     				<c:if
					test="${accessMap.jslb=='1' }">
        		<div style="margin-left: 16%; "><a href="findRoles" target="rightFrame">---&nbsp;角色列表</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
     <c:if
					test="${accessMap.rzlb=='1'}"> 
        <div id="ShenJi" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">审计日志</a></div>
        </div>
        <div class="nav"  id="shenji"><Br/>
     				<c:if
					test="${accessMap.rzlb=='1' }">
        		<div style="margin-left: 16%; "><a href="logAction" target="rightFrame">---&nbsp;日志列表</a></div><Br/>
        		</c:if>
        	</div>
        	</c:if>
        	<div id="BaoGao" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">报告管理</a></div>
        </div>
        <div class="nav"  id="baogao"><Br/>
        		<div style="margin-left: 16%;"><a href="showRating_rating_findRating?enterpriseId=${cureeenter.id}" target="rightFrame">---&nbsp;报告列表</a></div><Br/>
        	</div>
        	
     
        	
        <div id="ZhiFu" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">支付查询</a></div>
        </div>
        
        <div id="GuanLi" class="menuStyle">
        	<img src="images/left-anniu.jpg" width="91%" height="32">
        	<div class="secMenu"><a href="javascript:;">支付管理</a></div>
        </div>
        
        <div id="ShiXin" class="menuStyle">
        		<img src="images/left-anniu.jpg" width="91%" height="32">
        		<div class="secMenu"><a href="javascript:;">失信记录信息</a></div>
       		 </div>
      
    </div>
</body>
</html>

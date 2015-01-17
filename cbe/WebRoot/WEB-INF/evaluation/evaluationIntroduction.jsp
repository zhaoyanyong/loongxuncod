<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
   <title>评定介绍</title>
<style type="text/css">
table {
	border-right:1px #a8c7ce solid;
	border-top:1px #a8c7ce solid;
	}
td {
	border-left:1px #a8c7ce solid;
	border-bottom:1px #a8c7ce solid;
	height:28px;
	text-align:left;
	padding-left:1%;
	}
body {
	font-family:"宋体";
	font-size:13px;
	}
</style>
</head>
<body>
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
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：评定介绍</div>

<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
<div style="width:98.5%;">
<table cellpadding="0" cellspacing="0" width="100%">

  <tr align="center">
	      <td width="10%">等级符号</td>
	      <td width="90%">释义</td>
	      </tr>
	    <tr class="trBg1" >
	      <td style="color:#FF0000" align="center">优秀</td>
	      <td><p>企业信用优秀。企业信用程度高，债务风险小，经营状况佳，盈利能力强，公司治理结构合理，管理制度十分完善，研发能力优异，科技创新能力很强，发展前景广阔，不确定性因素对其经营与发展影响极小。</p></td>
	      </tr>
	    <tr class="trBg1"  >
	      <td style="color: #FF3300" align="center">优良</td>
	      <td><p>企业信用优良。企业的信用程度较高，债务风险较小，经营状况较佳，盈利水平较高，公司治理结构合理，管理制度比较完善，有较强的研发能力，科技创新能力也较强，发展前景较为广阔，不确定性因素对其经营与发展的影响很小。</p></td>
	      </tr>
	    <tr class="trBg1" >
	      <td style="color: #FF6600" align="center">较好</td>
	      <td><P>企业信用较好。企业的信用程度良好，在正常情况下偿还债务没有问题，经营处于良性循环状态，盈利能力较好，公司治理结构比较合理，管理制度比较完善，研发能力较好，科技创新能力较强，发展前景较好，但是可能会有些影响其未来经营与发展的不确定因素，进而削弱其盈利能力和偿债能力。</P></td>
	      </tr>
	    <tr class="trBg1" >
	      <td style="color: #FFCC00" align="center">一般</td>
	      <td><P>企业信用一般。企业的信用程度一般，偿还债务的能力一般，易受外界影响而波动，各项指标处于中等水平，公司治理结构上课，管理制度不算特别完善，研发能力中等，科技创新能力一般，其经营状况、盈利水平及未来发展前景易受不确定因素影响。</P></td>
	      </tr>
	    <tr class="trBg1" >
	      <td style="color: #CCCC00" align="center">欠佳</td>
	      <td><P>企业信用欠佳。企业的信用程度较差，资产质量和信用状况较差，盈利能力和偿债能力较弱，公司管理体系也较差，科技创新能力偏低，经营上存在一定风险发展前景不乐观，投资该企业含有投机性因素。</P></td>
	      </tr>
	    <tr class="trBg1"  >
	      <td style="color: #66CC00" align="center">较差</td>
	      <td><p>企业信用较差。资产质量和和信用状况差，经济实力低，经营业绩差，盈利能力和偿债能力偏低，公司管理结构不完善，研发能力不好，科技创新能力很差，经营风险较大，但目前尚有能力还本付息。</p></td>
	      </tr>
	    <tr class="trBg1" >
	      <td style="color: #009900" align="center">很差</td>
	      <td><P>企业信用很差。企业信用程度很差，基本上没有或者已经没有了偿债能力，有的甚至处于破产边缘。公司管理结构处于瘫痪边缘，几乎没有研发能力和创新能力，经营具有重大风险，属于高度投机性公司。</P></td>
        </tr>
	    </table>
</div>
</div>
</body>
</html>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<script type="text/javascript" src="js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="js/sample.js"></script>
		<title>生产经营信息</title>
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
	a {
	font-family:"宋体";
	font-size:13px;
	text-decoration:none;
	color:#fff;
	}
</style>
		<script type="text/javascript">
	function saveAttri() {
		var flag = true;
		var arr = $("input");
		var arr1 = $(".span");
		for(i=20;i<arr.length;i++){
			var val = arr[i].value;
			if(val==null||val==""){
				flag = false;
				arr1[i-20].style.display="inline";
				arr1[i-20].style.color="red";
				}
			}
		if(flag){
			document.forms[0].submit();
		}else{
			alert("保存失败，数据填写不完整");
			}
	}
	
</script>
	</head>
	<body>
		
			
			<div style="margin-right:0.5%"><img src="images/right.png" width="100%" height="524" /></div>
        
        <div style="position:absolute; top:2%; left:2%; width:10px;"><img src="images/right-bai.jpg" height="8" width="8" /></div>
        
<div style="position: absolute; top: 1.6%; left: 3%; width: 320px;">
			当前登录的用户：<span style="font-weight: bold;font-size: 18px;">${admin.aname }</span>&nbsp;&nbsp;&nbsp;&nbsp;用户角色：<span style="font-weight: bold;font-size: 16px;">${admin.roleName }</span>
		</div>

		<div style="position: absolute; top: 2%; left: 85.5%; width: 10px;">
			<img src="images/right-sanjiao.png" width="8" height="8" />
		</div>

		<div style="position: absolute; top: 1.6%; left: 87%; width: 30px;">
			IP:${admin.ip }
		</div>  
    
         <form action="addEnterAttribute_Attribute" method="post"  name="saveAttri">  
      <div style="position: absolute; top: 7%; left: 1%; width: 30px;"><img src="images/right-dangqian.png" width="20" height="20" /></div>
        <div style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：生产经营信息</div>
       
        <div style="position: absolute; top: 6.5%; left: 86%; width: 200px; color:#FFF;">
        
            <div style="float:left; margin-top:3%; margin-left:5%""><img src="images/right-bianji.png" width="13" height="13" /></div>
            <div style="float:left; margin-top:3%"> <a href="javascript:saveAttri()">保存</a>&nbsp;
            <a href="javascript:ysyb()">||预设样板</a>		
            </div>
        </div>
        
        
        	
	         
	
	  
        				<div style="width:100%; height:407px; position:absolute; top:12%; left:0.4%;">
        
							
                            <div style="width:98.5%;">
							<table cellpadding="0" cellspacing="0" width="100%" align="left">	
								<tr style="font-size:12px;">
									<td  width="16%" align="center">
										&nbsp;请选择行业类别：
									</td>
										<td width="82%" align="left" colspan="2">
										<input type="radio" class="radio" name="attribute.industryRatingNo" value="20"  checked="checked"/>电子信息 <input type="radio" class="radio" name="attribute.industryRatingNo" value="21" />光电一体化
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="22" />生物、医药与医疗器械 <input type="radio" class="radio" name="attribute.industryRatingNo" value="23" />航天航空
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="24" />软件	<input type="radio" class="radio" name="attribute.industryRatingNo" value="25" />新材料 
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="26" />环境保护<input type="radio" class="radio" name="attribute.industryRatingNo" value="27" />新能源与高效节能	
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="28" />地球、空间与海洋 <input type="radio" class="radio" name="attribute.industryRatingNo" value="29" />高技术服务  
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="30" />造纸、纸制
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="31" />金属冶炼、金属制品业<input type="radio" class="radio" name="attribute.industryRatingNo" value="32" />农、林、牧、渔 
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="33" />核应用技术
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="34" />仪器仪表 
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="35" />机械设备制造 <input type="radio" class="radio" name="attribute.industryRatingNo" value="36" />食品保健品
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="37" />纺织业皮革<input type="radio" class="radio" name="attribute.industryRatingNo" value="38" />化学化工原料及化学制品
									<input type="radio" class="radio" name="attribute.industryRatingNo" value="39" />其他
									</td>
									
								</tr>
								<tr  style="font-size:12px;">
								
								
								</tr>
							</table>
                            </div>


				<div style="width:100%; height:100%; margin-top:4%; overflow-y: scroll;">
						<table cellpadding="0" cellspacing="0" width="100%" align="left">	
								<tr align="center" class="trBg">

									<td colspan="2" width="25%">
										&nbsp;1.企业净资产总额
									</td>
									<td width="25%">
										&nbsp;
										<input id="1a" onblur="checkValue1(this)"
											value="<s:property  value="attribute.totalNetAssets"/>"
											type="text" name="attribute.totalNetAssets" />
										万元&nbsp;&nbsp;
										<span id="span1"></span>
									</td>
									<td colspan="2" width="25%">
										&nbsp;2.企业固定资产总额
									</td>
									<td width="25%">
									<input type="hidden"  value="${enterpriseId }" name="enterpriseId"/>
											
										&nbsp;
										<input id="2a" onblur="checkValue2(this)"
											value="<s:property  value="attribute.totalCapitalAsserts"/>"
											type="text" name="attribute.totalCapitalAsserts" />
										万元&nbsp;&nbsp;
										<span id="span2"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;3.营业收入
									</td>
									<td>
										&nbsp;
										<input id="3a" onblur="checkValue3(this)"
											value="<s:property value="attribute.operatingReceipt"/>"
											type="text" name="attribute.operatingReceipt" />
										万元&nbsp;&nbsp;
										<span id="span3"></span>
									</td>
									<td colspan="2">
										&nbsp;4.企业税后利润总额
									</td>
									<td>
										&nbsp;
										<input id="4a"
											value="<s:property 

value="attribute.totalTaxProfit"/>"
											onblur="checkValue4(this)" type="text"
											name="attribute.totalTaxProfit" />
										万元&nbsp;&nbsp;
										<span id="span4"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;5.固定资产净值
									</td>
									<td>
										&nbsp;
										<input id="5a" onblur="checkValue5(this)"
											value="<s:property 

value="attribute.capitalAssertsNetValue"/>"
											type="text" name="attribute.capitalAssertsNetValue" />
										万元&nbsp;&nbsp;
										<span id="span5"></span>
									</td>
									<td colspan="2">
										&nbsp;6.流动资产
									</td>
									<td>
										&nbsp;
										<input id="6a" onblur="checkValue6(this)"
											value="<s:property 

value="attribute.floatingCapital"/>"
											type="text" name="attribute.floatingCapital" />
										万元&nbsp;&nbsp;
										<span id="span6"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;7.流动负债
									</td>
									<td>
										&nbsp;
										<input id="7a" onblur="checkValue7(this)"
											value="<s:property 

value="attribute.cashLiabilities"/>"
											type="text" name="attribute.cashLiabilities" />
										万元&nbsp;&nbsp;
										<span id="span7"></span>
									</td>
									<td colspan="2">
										&nbsp;8.现金
									</td>
									<td>
										&nbsp;
										<input id="8a" onblur="checkValue8(this)"
											value="<s:property 

value="attribute.generalCash"/>"
											type="text" name="attribute.generalCash" />
										万元&nbsp;&nbsp;
										<span id="span8"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;9.短期债券投资
									</td>
									<td>
										&nbsp;
										<input id="9a" onblur="checkValue9(this)"
											value="<s:property 

value="attribute.shortTermBondInvestment"/>"
											type="text" name="attribute.shortTermBondInvestment" />
										万元&nbsp;&nbsp;
										<span id="span9"></span>
									</td>
									<td colspan="2">
										&nbsp;10.应收账款
									</td>
									<td>
										&nbsp;
										<input id="10a" onblur="checkValue10(this)"
											value="<s:property 

value="attribute.accountReceivable"/>"
											type="text" name="attribute.accountReceivable" />
										万元&nbsp;&nbsp;
										<span id="span10"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;11.应收票据
									</td>
									<td>
										&nbsp;
										<input id="1b" onblur="checkValue11(this)"
											value="<s:property 

value="attribute.noteReceivable"/>"
											type="text" name="attribute.noteReceivable" />
										万元&nbsp;&nbsp;
										<span id="span11"></span>
									</td>
									<td colspan="2">
										&nbsp;12.有价证券
									</td>
									<td>
										&nbsp;
										<input id="2b" onblur="checkValue12(this)"
											value="<s:property 

value="attribute.valueSecurities"/>"
											type="text" name="attribute.valueSecurities" />
										万元&nbsp;&nbsp;
										<span id="span12"></span>
									</td>
								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;13.负债总额
									</td>
									<td>
										&nbsp;
										<input id="3b" onblur="checkValue13(this)"
											value="<s:property 

value="attribute.grossLiabilities"/>"
											type="text" name="attribute.grossLiabilities" />
										万元&nbsp;&nbsp;
										<span id="span13"></span>
									</td>
									<td colspan="2">
										&nbsp;14.资产总额
									</td>
									<td>
										&nbsp;
										<input id="4b" onblur="checkValue14(this)"
											value="<s:property 

value="attribute.totalAssets"/>"
											type="text" name="attribute.totalAssets" />
										万元&nbsp;&nbsp;
										<span id="span14"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;15.息税前利润
									</td>
									<td>
										&nbsp;
										<input id="5b" onblur="checkValue15(this)"
											value="<s:property 

value="attribute.earningsInterestTaxes"/>"
											type="text" name="attribute.earningsInterestTaxes" />
										万元&nbsp;&nbsp;
										<span id="span15"></span>
									</td>
									<td colspan="2">
										&nbsp;16.利息费用
									</td>
									<td>
										&nbsp;
										<input id="6b" onblur="checkValue16(this)"
											value="<s:property 

value="attribute.capitalCharges"/>"
											type="text" name="attribute.capitalCharges" />
										万元&nbsp;&nbsp;
										<span id="span16"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;17.对外担保额度
									</td>
									<td>
										&nbsp;
										<input id="7b" onblur="checkValue17(this)"
											value="<s:property 

value="attribute.foreignGuaranteeAmount"/>"
											type="text" name="attribute.foreignGuaranteeAmount" />
										万元&nbsp;&nbsp;
										<span id="span17"></span>
									</td>
									<td colspan="2">
										&nbsp;18.销售收入
									</td>
									<td>
										&nbsp;
										<input id="8b" onblur="checkValue18(this)"
											value="<s:property 

value="attribute.salesProceed"/>"
											type="text" name="attribute.salesProceed" />
										万元&nbsp;&nbsp;
										<span id="span18"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;19.主营业务收入净额
									</td>
									<td>
										&nbsp;
										<input id="9b" onblur="checkValue19(this)"
											value="<s:property 

value="attribute.mainBusinessNetIncome"/>"
											type="text" name="attribute.mainBusinessNetIncome" />
										万元&nbsp;&nbsp;
										<span id="span19"></span>
									</td>
									<td colspan="2">
										&nbsp;20.年初流动资产总额
									</td>
									<td>
										&nbsp;
										<input id="10b" onblur="checkValue20(this)"
											value="<s:property 

value="attribute.beginTotalCurrentAssets"/>"
											type="text" name="attribute.beginTotalCurrentAssets" />
										万元&nbsp;&nbsp;
										<span id="span20"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;21.年末流动资产总额
									</td>
									<td>
										&nbsp;
										<input id="1c" onblur="checkValue21(this)"
											value="<s:property 

value="attribute.endTotalCurrentAssets"/>"
											type="text" name="attribute.endTotalCurrentAssets" />
										万元&nbsp;&nbsp;
										<span id="span21"></span>
									</td>
									<td colspan="2">
										&nbsp;22.固定资产
									</td>
									<td>
										&nbsp;
										<input id="2c" onblur="checkValue22(this)"
											value="<s:property 

value="attribute.fixedAssets"/>"
											type="text" name="attribute.fixedAssets" />
										万元&nbsp;&nbsp;
										<span id="span22"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;23.年初应收账款总额
									</td>
									<td>
										&nbsp;
										<input id="3c" onblur="checkValue23(this)"
											value="<s:property 

value="attribute.beginTotalAccountsReceivable"/>"
											type="text" name="attribute.beginTotalAccountsReceivable" />
										万元&nbsp;&nbsp;
										<span id="span23"></span>
									</td>
									<td colspan="2">
										&nbsp;24.年末应收账款总额
									</td>
									<td>
										&nbsp;
										<input id="4c" onblur="checkValue24(this)"
											value="<s:property 

value="attribute.endTotalAccountsReceivable"/>"
											type="text" name="attribute.endTotalAccountsReceivable" />
										万元&nbsp;&nbsp;
										<span id="span24"></span>
									</td>

								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;25.销售成本
									</td>
									<td>
										&nbsp;
										<input id="5c" onblur="checkValue25(this)"
											value="<s:property 

value="attribute.sellingCost"/>"
											type="text" name="attribute.sellingCost" />
										万元&nbsp;&nbsp;
										<span id="span25"></span>
									</td>
									<td colspan="2">
										&nbsp;26.年初存货
									</td>
									<td>
										&nbsp;
										<input id="6c" onblur="checkValue26(this)"
											value="<s:property 

value="attribute.beginningInventory"/>"
											type="text" name="attribute.beginningInventory" />
										万元&nbsp;&nbsp;
										<span id="span26"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;27.年末存货
									</td>
									<td>
										&nbsp;
										<input id="7c" onblur="checkValue27(this)"
											value="<s:property 

value="attribute.endInventory"/>"
											type="text" name="attribute.endInventory" />
										万元&nbsp;&nbsp;
										<span id="span27"></span>
									</td>
									<td colspan="2">
										&nbsp;28.年初所有者权益
									</td>
									<td>
										&nbsp;
										<input id="8c" onblur="checkValue28(this)"
											value="<s:property 

value="attribute.beginOwnerEquity"/>"
											type="text" name="attribute.beginOwnerEquity" />
										万元&nbsp;&nbsp;
										<span id="span28"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;29.年末所有者权益
									</td>
									<td>
										&nbsp;
										<input id="9c" onblur="checkValue29(this)"
											value="<s:property 

value="attribute.endOwnerEquity"/>"
											type="text" name="attribute.endOwnerEquity" />
										万元&nbsp;&nbsp;
										<span id="span29"></span>
									</td>
									<td colspan="2">
										&nbsp;30.年初销售收入
									</td>
									<td>
										&nbsp;
										<input id="10c" onblur="checkValue30(this)"
											value="<s:property 

value="attribute.beginSalesProceed"/>"
											type="text" name="attribute.beginSalesProceed" />
										万元&nbsp;&nbsp;
										<span id="span30"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;31.年末销售收入
									</td>
									<td>
										&nbsp;
										<input id="1d" onblur="checkValue31(this)"
											value="<s:property 

value="attribute.endSalesProceed"/>"
											type="text" name="attribute.endSalesProceed" />
										万元&nbsp;&nbsp;
										<span id="span31"></span>
									</td>
									<td colspan="2">
										&nbsp;32.利息支出
									</td>
									<td>
										&nbsp;
										<input id="2d" onblur="checkValue32(this)"
											value="<s:property 

value="attribute.interestExpense"/>"
											type="text" name="attribute.interestExpense" />
										万元&nbsp;&nbsp;
										<span id="span32"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;33. 税后净利润
									</td>
									<td>
										&nbsp;
										<input id="3d" onblur="checkValue33(this)"
											value="<s:property 

value="attribute.netIncomeRetainedAfterTax"/>"
											type="text" name="attribute.netIncomeRetainedAfterTax" />
										万元&nbsp;&nbsp;
										<span id="span33"></span>
									</td>
									<td colspan="2">
										&nbsp;34. 净资产
									</td>
									<td>
										&nbsp;
										<input id="4d" onblur="checkValue34(this)"
											value="<s:property 

value="attribute.netAssets"/>"
											type="text" name="attribute.netAssets" />
										万元&nbsp;&nbsp;
										<span id="span34"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;35. 利润总额
									</td>
									<td>
										&nbsp;
										<input id="5d" onblur="checkValue35(this)"
											value="<s:property 

value="attribute.totalProfit"/>"
											type="text" name="attribute.totalProfit" />
										万元&nbsp;&nbsp;
										<span id="span35"></span>
									</td>
									<td colspan="2">
										&nbsp;36. 成本费用总额
									</td>
									<td>
										&nbsp;
										<input id="6d" onblur="checkValue36(this)"
											value="<s:property 

value="attribute.totalCost"/>"
											type="text" name="attribute.totalCost" />
										万元&nbsp;&nbsp;
										<span id="span36"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;37. 主营业务收入
									</td>
									<td>
										&nbsp;
										<input id="7d" onblur="checkValue37(this)"
											value="<s:property 

value="attribute.mainOperationIncome"/>"
											type="text" name="attribute.mainOperationIncome" />
										万元&nbsp;&nbsp;
										<span id="span37"></span>
									</td>
									<td colspan="2">
										&nbsp;38. 主营业务成本
									</td>
									<td>
										&nbsp;
										<input id="8d" onblur="checkValue38(this)"
											value="<s:property 

value="attribute.costOfSales"/>"
											type="text" name="attribute.costOfSales" />
										万元&nbsp;&nbsp;
										<span id="span38"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;39. 主营业务税金及附加
									</td>
									<td>
										&nbsp;
										<input id="9d" onblur="checkValue39(this)"
											value="<s:property 

value="attribute.salesTax"/>"
											type="text" name="attribute.salesTax" />
										万元&nbsp;&nbsp;
										<span id="span39"></span>
									</td>
									<td colspan="2">
										&nbsp;40. 年初主营业务收入
									</td>
									<td>
										&nbsp;
										<input id="10d" onblur="checkValue40(this)"
											value="<s:property 

value="attribute.beginMainOperationIncome"/>"
											type="text" name="attribute.beginMainOperationIncome" />
										万元&nbsp;&nbsp;
										<span id="span40"></span>
									</td>
								</tr>
								<!--  -->
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;41. 年初主营业务成本
									</td>
									<td>
										&nbsp;
										<input id="1e" onblur="checkValue41(this)"
											value="<s:property 

value="attribute.beginCostOfSales"/>"
											type="text" name="attribute.beginCostOfSales" />
										万元&nbsp;&nbsp;
										<span id="span41"></span>
									</td>
									<td colspan="2">
										&nbsp;42. 年初主营业务税金及附加
									</td>
									<td>
										&nbsp;
										<input id="2e" onblur="checkValue42(this)"
											value="<s:property 

value="attribute.beginSalesTax"/>"
											type="text" name="attribute.beginSalesTax" />
										万元&nbsp;&nbsp;
										<span id="span42"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;43. 年末主营业务收入
									</td>
									<td>
										&nbsp;
										<input id="3e" onblur="checkValue43(this)"	value="<s:property  value="attribute.endMainOperationIncome"/>"			type="text" name="attribute.endMainOperationIncome" />
										万元&nbsp;&nbsp;
										<span id="span43"></span>
									</td>
									<td colspan="2">
										&nbsp;44. 年末主营业务成本
									</td>
									<td>
										&nbsp;
										<input id="4e" onblur="checkValue44(this)"
											value="<s:property 

value="attribute.endCostOfSales"/>"
											type="text" name="attribute.endCostOfSales" />
										万元&nbsp;&nbsp;
										<span id="span44"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;45. 年末主营业务税金及附加
									</td>
									<td>
										&nbsp;
										<input id="5e" onblur="checkValue45(this)"
											value="<s:property 

value="attribute.endSalesTax"/>"
											type="text" name="attribute.endSalesTax" />
										万元&nbsp;&nbsp;
										<span id="span45"></span>
									</td>
									<td colspan="2">
										&nbsp;46.本年总资产增长额
									</td>
									<td>
										&nbsp;
										<input id="6e" onblur="checkValue46(this)"
											value="<s:property 

value="attribute.totalAssetGrowth"/>"
											type="text" name="attribute.totalAssetGrowth" />
										万元&nbsp;&nbsp;
										<span id="span46"></span>
									</td>
								</tr>
								<!--  -->
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;47.年初资产总额
									</td>
									<td>
										&nbsp;
										<input id="7e" onblur="checkValue47(this)"
											value="<s:property 

value="attribute.beginTotalAssets"/>"
											type="text" name="attribute.beginTotalAssets" />
										万元&nbsp;&nbsp;
										<span id="span47"></span>
									</td>
									<td colspan="2">
										&nbsp;48.年末资产总额
									</td>
									<td>
										&nbsp;
										<input id="8e" onblur="checkValue48(this)"
											value="<s:property 

value="attribute.endTotalAssets"/>"
											type="text" name="attribute.endTotalAssets" />
										万元&nbsp;&nbsp;
										<span id="span48"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;49.期初净资产
									</td>
									<td>
										&nbsp;
										<input id="9e" onblur="checkValue49(this)"
											value="<s:property 

value="attribute.beginNetAssets"/>"
											type="text" name="attribute.beginNetAssets" />
										万元&nbsp;&nbsp;
										<span id="span49"></span>
									</td>
									<td colspan="2">
										&nbsp;50.期末净资产
									</td>
									<td>
										&nbsp;
										<input id="10e" onblur="checkValue50(this)"
											value="<s:property 

value="attribute.endNetAssets"/>"
											type="text" name="attribute.endNetAssets" />
										万元&nbsp;&nbsp;
										<span id="span50"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;51.年末营业收入
									</td>
									<td>
										&nbsp;
										<input id="1f" onblur="checkValue51(this)"
											value="<s:property 

value="attribute.endBusinessReceipt"/>"
											type="text" name="attribute.endBusinessReceipt" />
										万元&nbsp;&nbsp;
										<span id="span51"></span>
									</td>
									<td colspan="2">
										&nbsp;52.年末营业外收入
									</td>
									<td>
										&nbsp;
										<input id="2f" onblur="checkValue52(this)"
											value="<s:property 

value="attribute.endNonrevenueReceipt"/>"
											type="text" name="attribute.endNonrevenueReceipt" />
										万元&nbsp;&nbsp;
										<span id="span52"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;53.年初营业收入
									</td>
									<td>
										&nbsp;
										<input id="3f" onblur="checkValue53(this)"
											value="<s:property 

value="attribute.beginBusinessReceipt"/>"
											type="text" name="attribute.beginBusinessReceipt" />
										万元&nbsp;&nbsp;
										<span id="span53"></span>
									</td>
									<td colspan="2">
										&nbsp;54.年初营业外收入
									</td>
									<td>
										&nbsp;
										<input id="4f" onblur="checkValue54(this)"
											value="<s:property 

value="attribute.beginNonrevenueReceipt"/>"
											type="text" name="attribute.beginNonrevenueReceipt" />
										万元&nbsp;&nbsp;
										<span id="span54"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;55.所得税
									</td>
									<td>
										&nbsp;
										<input id="5f" onblur="checkValue55(this)"
											value="<s:property 

value="attribute.incomeTax"/>"
											type="text" name="attribute.incomeTax" />
										万元&nbsp;&nbsp;
										<span id="span55"></span>
									</td>
									<td colspan="2">
										&nbsp;56.上期所得税
									</td>
									<td>
										&nbsp;
										<input id="6f" onblur="checkValue56(this)"
											value="<s:property 

value="attribute.lastIncomeTax"/>"
											type="text" name="attribute.lastIncomeTax" />
										万元&nbsp;&nbsp;
										<span id="span56"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;57.上期利润总额
									</td>
									<td>
										&nbsp;
										<input id="7f" onblur="checkValue57(this)"
											value="<s:property 

value="attribute.lastTotalProfit"/>"
											type="text" name="attribute.lastTotalProfit" />
										万元&nbsp;&nbsp;
										<span id="span57"></span>
									</td>
									<td colspan="2">
										&nbsp;58.本年员工数
									</td>
									<td>
										&nbsp;
										<input id="8f" onblur="checkValue58(this)"
											value="<s:property 

value="attribute.employeNumCurrentYear"/>"
											type="text" name="attribute.employeNumCurrentYear" />
										人&nbsp;&nbsp;
										<span id="span58"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;59.上年员工数
									</td>
									<td colspan="4">
										&nbsp;
										<input id="9f" onblur="checkValue59(this)"
											value="<s:property 

value="attribute.employeNumLastYear"/>"
											type="text" name="attribute.employeNumLastYear" />
										人&nbsp;&nbsp;
										<span id="span59"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2" rowspan="4">
										&nbsp;60.企业家禀赋
									</td>
									<td colspan="2">
										&nbsp;1.年龄：
									</td>
									<td colspan="2">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'小余 35',1:'35-50',2:'50 以上'}" listKey="key"
											listValue="value" name="attribute.ageGroup" id="select1"></s:select>
									</td>
								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;2.学历/学位/职称
									</td>
									<td colspan="2">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'特殊知名人物',1:'博士/高级',2:'硕士/副高',3:'本科/

中级',4:'专科/初级'}"
											listKey="key" listValue="value" name="attribute.degreeTitles">

										</s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;3.岗位工作时间
									</td>
									<td colspan="2">
										&nbsp;
										<input id="10f" onblur="checkValue60(this)"
											value="<s:property 

value="attribute.workingTime"/>"
											type="text" name="attribute.workingTime" />
										年&nbsp;&nbsp;
										<span id="span60"></span>
									</td>
								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;4.业内知名度\社会关系
									</td>
									<td colspan="2">
										&nbsp;
										<s:select theme="simple" list="#{0:'很强',1:'强',2:'比较强',3:'一般'}"
											listKey="key" listValue="value" name="attribute.reputations"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;61.企业发展规划
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.enterpriseExpansionProjects"></s:select>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;62.产品长期发展战略
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.producLongTermDevelopment"></s:select>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;63.产品质量认证
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.productQualityCertification"></s:select>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;64.产业（阶段）性质
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{0:'夕阳产业',1:'普通产业',2:'朝阳产业'}"
											listKey="key" listValue="value"
											name="attribute.lndustryProperties" id="select2"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">

									<td colspan="2">
										&nbsp;65.近一年高新销售收入和技术收入额
									</td>
									<td>
										&nbsp;
										<input id="5g" onblur="checkValue61(this)"
											value="<s:property 

value="attribute.yearNewSalesIncome"/>"
											type="text" name="attribute.yearNewSalesIncome" />
										万元&nbsp;&nbsp;
										<span id="span65"></span>
									</td>
									<td colspan="2">
										&nbsp;66.近一年销售总额
									</td>
									<td>
										&nbsp;
										<input id="6g" onblur="checkValue62(this)"
											value="<s:property 

value="attribute.yearGrossSales"/>"
											type="text" name="attribute.yearGrossSales" />
										万元&nbsp;&nbsp;
										<span id="span66"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;67.R＆D经费支出
									</td>
									<td>
										&nbsp;
										<input id="7g" onblur="checkValue63(this)"
											value="<s:property 

value="attribute.appropriationExpenditure"/>"
											type="text" name="attribute.appropriationExpenditure" />
										万元&nbsp;&nbsp;
										<span id="span67"></span>
									</td>
									<td colspan="2">
										&nbsp;68.年末R＆D经费投入额
									</td>
									<td>
										&nbsp;
										<input id="8g" onblur="checkValue64(this)"
											value="<s:property 

value="attribute.endFundingAmount"/>"
											type="text" name="attribute.endFundingAmount" />
										万元&nbsp;&nbsp;
										<span id="span68"></span>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;69.年初R＆D经费投入额
									</td>
									<td>
										&nbsp;
										<input id="9g" onblur="checkValue65(this)"
											value="<s:property 

value="attribute.beginFundingAmount"/>"
											type="text" name="attribute.beginFundingAmount" />
										万元&nbsp;&nbsp;
										<span id="span69"></span>
									</td>
									<td colspan="2">
										&nbsp;70.员工大专以上人数
									</td>
									<td>
										&nbsp;
										<input id="10g" onblur="checkValue66(this)"
											value="<s:property 

value="attribute.aboveCollegeEmployeeNum"/>"
											type="text" name="attribute.aboveCollegeEmployeeNum" />
										人&nbsp;&nbsp;
										<span id="span70"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;71.员工总人数
									</td>
									<td>
										&nbsp;
										<input id="1h" onblur="checkValue67(this)"
											value="<s:property 

value="attribute.totalEmployees"/>"
											type="text" name="attribute.totalEmployees" />
										人&nbsp;&nbsp;
										<span id="span71"></span>
									</td>
									<td colspan="2">
										&nbsp;72.获得市级以上科技成果奖励数
									</td>
									<td>
										&nbsp;
										<input id="2h" onblur="checkValue68(this)"
											value="<s:property 

value="attribute.scientificRewardsNum"/>"
											type="text" name="attribute.scientificRewardsNum" />
										个&nbsp;&nbsp;
										<span id="span72"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;73.申请和已授权的知识产权总数
									</td>
									<td>
										&nbsp;
										<input id="3h" onblur="checkValue69(this)"
											value="<s:property 

value="attribute.intellectualPropertyRightNum"/>"
											type="text" name="attribute.intellectualPropertyRightNum" />
										个&nbsp;&nbsp;
										<span id="span73"></span>
									</td>
									<td colspan="2">
										&nbsp;74.专利总数
									</td>
									<td>
										&nbsp;
										<input id="4h" onblur="checkValue70(this)"
											value="<s:property 

value="attribute.patentNum"/>"
											type="text" name="attribute.patentNum" />
										个&nbsp;&nbsp;
										<span id="span74"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2" rowspan="3">
										&nbsp;75.近三年获政府立项数量
									</td>
									<td colspan="2">
										&nbsp;1.国家级
									</td>
									<td colspan="2">
										&nbsp;
										<input id="5h1" onblur="checkValue71(this)"
											value="<s:property 

value="attribute.couontryGovernmentProjectNum"/>"
											type="text" name="attribute.couontryGovernmentProjectNum" />
										个&nbsp;&nbsp;
										<span id="span751"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;2.省部级
									</td>
									<td colspan="2">
										&nbsp;
										<input id="5h2" onblur="checkValue72(this)"
											value="<s:property 

value="attribute.provinceGovernmentprojectNum"/>"
											type="text" name="attribute.provinceGovernmentprojectNum" />
										个&nbsp;&nbsp;
										<span id="span752"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;3.地市级
									</td>
									<td colspan="2">
										&nbsp;
										<input id="5h3" onblur="checkValue73(this)"
											value="<s:property 

value="attribute.cityGovernmentprojectNum"/>"
											type="text" name="attribute.cityGovernmentprojectNum" />
										个&nbsp;&nbsp;
										<span id="span753"></span>
									</td>
								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;76.创新人员激励制度
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.incentiveSystemOfInnovation"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;77.专门的研发机构
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.researchinstitute"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;78.有无创业投资机构进入
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.ventureCapitalInstitutions"></s:select>
									</td>
								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;79.国际化合作
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.internationallyCooperative"></s:select>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;80.国家重点实验室
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{true:'有',false:'无'}"
											listKey="key" listValue="value"
											name="attribute.stateKeyLaboratory"></s:select>
									</td>

								</tr>




								<tr align="center" class="trBg">

									<td colspan="2">
										&nbsp;81.利息总额
									</td>
									<td>
										&nbsp;
										<input id="1i" onblur="checkValue74(this)"
											value="<s:property 

value="attribute.grossInterest"/>"
											type="text" name="attribute.grossInterest" />
										万元&nbsp;&nbsp;
										<span id="span81"></span>
									</td>
									<td colspan="2">
										&nbsp;82.逾期贷款总额
									</td>
									<td>
										&nbsp;
										<input id="2i" onblur="checkValue75(this)"
											value="<s:property 

value="attribute.overdueLoans"/>"
											type="text" name="attribute.overdueLoans" />
										万元&nbsp;&nbsp;
										<span id="span82"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;83.贷款总额
									</td>
									<td>
										&nbsp;
										<input id="3i" onblur="checkValue76(this)"
											value="<s:property 

value="attribute.loanCeiling"/>"
											type="text" name="attribute.loanCeiling" />
										万元&nbsp;&nbsp;
										<span id="span83"></span>
									</td>
									<td colspan="2">
										&nbsp;84. 已支付到期应付账款
									</td>
									<td colspan="4">
										&nbsp;
										<input id="4i" onblur="checkValue77(this)"
											value="<s:property 

value="attribute.alreadyPaidCredit"/>"
											type="text" name="attribute.alreadyPaidCredit" />
										万元&nbsp;&nbsp;
										<span id="span84"></span>
									</td>
								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;85. 期内应付账款总额
									</td>
									<td colspan="4">
										&nbsp;
										<input id="5i" onblur="checkValue78(this)"
											value="<s:property 

value="attribute.shouldPaidCredit"/>"
											type="text" name="attribute.shouldPaidCredit" />
										万元&nbsp;&nbsp;
										<span id="span85"></span>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;86.经营决策者个人信誉
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{0:'优秀',1:'良好',2:'一般',3:'差'}"
											listKey="key" listValue="value"
											name="attribute.personalReputation"></s:select>
									</td>

								</tr>





								<tr align="center" class="trBg">

									<td colspan="2">
										&nbsp;87.经营管理水平
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{0:'优秀',1:'良好',2:'一般',4:'差'}"
											listKey="key" listValue="value"
											name="attribute.operationControl"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;88.股东背景
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'中央级企业、上市公司',1:'地市级以上（含）政府控投企业）',2:'民营企业及其他

'}"
											listKey="key" listValue="value" id="select3"
											name="attribute.shareholdersBackground"></s:select>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2" rowspan="8">
										&nbsp;89.管理者行业经验
									</td>
									<td>
										&nbsp;1.任职年份
									</td>
									<td colspan="3">
										&nbsp;
										<input id="9i" onblur="checkValue79(this)"
											value="<s:property 

value="attribute.takeOfficeYear"/>"
											type="text" name="attribute.takeOfficeYear" />
									年&nbsp;&nbsp;
										<span id="span89"></span>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;2.董事会规模：
									</td>
									<td colspan="3">
										&nbsp;
										<s:select theme="simple" list="#{0:'按规定设定',1:'未按规定设定'}"
											listKey="key" listValue="value"
											name="attribute.boardOfDirectors"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;3.董事长与CEO两职设置状况
									</td>
									<td colspan="3">
										&nbsp;
										<s:select theme="simple" list="#{0:'按规定设定',1:'未按规定设定'}"
											listKey="key" listValue="value"
											name="attribute.ceosetupStatus"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;4.审计意见
									</td>
									<td colspan="3">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'标准的无保留意见的',1:'带强调事项段的无保留意见',2:'保留意见',3:'否定意见',4:'无法表示意见'}"
											listKey="key" listValue="value" name="attribute.auditOpinion"></s:select>
									</td>
								</tr>


								<tr align="center" class="trBg">
									<td>
										&nbsp;5.违规行为
									</td>
									<td colspan="3">
										&nbsp;
										<s:select theme="simple" list="#{0:'有',1:'无'}" listKey="key"
											listValue="value" name="attribute.irregularities"
											id="select4"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;6.年龄
									</td>
									<td colspan="3">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'小余 35',1:'35-50',2:'50 以上'}" listKey="key"
											listValue="value" name="attribute.managerAge" id="select5"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;7.教育背景
									</td>
									<td colspan="3">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'特殊知名人物',1:'博士/高级',2:'硕士/副高',3:'本科/

中级',4:'专科/初级'}"
											listKey="key" listValue="value"
											name="attribute.eduBackground"></s:select>
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;8.职称
									</td>
									<td colspan="3">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'高级',1:'副高级',2:'中级',3:'初级',4:'无'}" listKey="key"
											listValue="value" name="attribute.academicTitle"></s:select>
									</td>
								</tr>


								<tr align="center" class="trBg">

									<td colspan="2">
										&nbsp;90.国家产业政策
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'鼓励发展',1:'一般态度',2:'限制发展',3:'要求淘

汰'}"
											listKey="key" listValue="value"
											name="attribute.stateIndustrialPolicies"></s:select>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;91.行业地位
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple"
											list="#{0:'产品市场占有率高',1:'议价能力一般',2:'议价能

力高'}" listKey="key"
											listValue="value" name="attribute.industryPosition"></s:select>
									</td>

								</tr>

								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;92.主导产业个数
									</td>
									<td colspan="4">
										&nbsp;
										<s:select theme="simple" list="#{0:'1-2个',1:'3-4个',2:'4个以上'}"
											listKey="key" listValue="value"
											name="attribute.leadingIndustry"></s:select>
									</td>

								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;93.产品竞争力
									</td>
									<td colspan="2">
										&nbsp;
										<s:select theme="simple" list="#{0:'好',1:'中',2:'差'}"
											listKey="key" listValue="value"
											name="attribute.productCompetitiveness"></s:select>
									</td>
		<td>指标年份</td>
		<td>	<input id="6j"
											value="<s:property 

value="attribute.year"/>"
											type="text" name="attribute.year" /></td>
								</tr>
								<tr align="center" class="trBg">
									<td rowspan="5" colspan="2">
										&nbsp;94.股东及股权结构
									</td>
									<td>
										&nbsp;股东名称
									</td>
									<td>
										&nbsp;
										<input id="4j1"
											value="<s:property 

value="attribute.shareholderNameOne"/>"
											type="text" name="attribute.shareholderNameOne" />
									</td>
									<td>
										&nbsp;持股比例
									</td>
									<td>
										&nbsp;
										<input id="4j2"
											value="<s:property 

value="attribute.shareholdingRatioOne"/>"
											type="text" name="attribute.shareholdingRatioOne" />
										%
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;股东名称
									</td>
									<td>
										&nbsp;
										<input id="4j3"
											value="<s:property 

value="attribute.shareholderNameTwo"/>"
											type="text" name="attribute.shareholderNameTwo" />
									</td>
									<td>
										&nbsp;持股比例
									</td>
									<td>
										&nbsp;
										<input id="4j4"
											value="<s:property 

value="attribute.shareholdingRatioTwo"/>"
											type="text" name="attribute.shareholdingRatioTwo" />
										%
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;股东名称
									</td>
									<td>
										&nbsp;
										<input id="4j5"
											value="<s:property 

value="attribute.shareholderNameThree"/>"
											type="text" name="attribute.shareholderNameThree" />
									</td>
									<td>
										&nbsp;持股比例
									</td>
									<td>
										&nbsp;
										<input id="4j6"
											value="<s:property 

value="attribute.shareholdingRatioThree"/>"
											type="text" name="attribute.shareholdingRatioThree" />
										%
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;股东名称
									</td>
									<td>
										&nbsp;
										<input id="4j7"
											value="<s:property 

value="attribute.shareholderNameFour"/>"
											type="text" name="attribute.shareholderNameFour" />
									</td>
									<td>
										&nbsp;持股比例
									</td>
									<td>
										&nbsp;
										<input id="4j8"
											value="<s:property 

value="attribute.shareholdingRatioFour"/>"
											type="text" name="attribute.shareholdingRatioFour" />
										%
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td>
										&nbsp;股东名称
									</td>
									<td>
										&nbsp;
										<input id="4j9"
											value="<s:property 

value="attribute.shareholderNameFive"/>"
											type="text" name="attribute.shareholderNameFive" />
									</td>
									<td>
										&nbsp;持股比例
									</td>
									<td>
										&nbsp;
										<input id="4j0"
											value="<s:property 

value="attribute.shareholdingRatioFive"/>"
											type="text" name="attribute.shareholdingRatioFive" />
										%
									</td>
								</tr>
								<tr align="center" class="trBg">
									<td colspan="2">
										&nbsp;95.重要信息披露
									</td>
									<td colspan="4">
										&nbsp;
<textarea id="5j" name="attribute.iinfoDisclosure" style="width: 600px; font-size: 12px;" rows="4"><s:property value="attribute.iinfoDisclosure" /></textarea>
										<span style="color: black;">（请注明企业股份转让、关联控股入股、购并行为、重大战略合作伙伴引入、核心技术人员和专利技术流动等历史行为）字数0-200之间</span>
										&nbsp;&nbsp;
										<span id="vali_msg"></span>
									</td>

								</tr>
							</table>
							</div>
       </div>
   </form>
		<script type="text/javascript">
	/*去左右空格**/
	function trim(str) {
		return str.replace(/(^\s*)|(\s*$)/, "");
	}
	function checkValue1(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1a").val();
		//判断资费名称是否为空
		if (name == null || name == "") {
			//若为空，则提示，并给出错误提示的样式
			$("#span1").text("不能为空！");
			return false;
		} else {
			$("#span1").text("");
			return true;
		}
	}

	function checkValue2(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2a").val();
		if (name == null || name == "") {
			$("#span2").text("不能为空！");
			return false;
		} else {
			$("#span2").text("");
			return true;
		}
	}

	function checkValue3(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3a").val();
		if (name == null || name == "") {
			$("#span3").text("不能为空！");
			return false;
		} else {
			$("#span3").text("");
			return true;
		}
	}

	function checkValue4(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4a").val();
		if (name == null || name == "") {
			$("#span4").text("不能为空！");
			return false;
		} else {
			$("#span4").text("");
			return true;
		}
	}

	function checkValue5(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5a").val();
		if (name == null || name == "") {
			$("#span5").text("不能为空！");
			return false;
		} else {
			$("#span5").text("");
			return true;
		}
	}

	function checkValue6(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#6a").val();
		if (name == null || name == "") {
			$("#span6").text("不能为空！");
			return false;
		} else {
			$("#span6").text("");
			return true;
		}
	}

	function checkValue7(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#7a").val();
		if (name == null || name == "") {
			$("#span7").text("不能为空！");
			return false;
		} else {
			$("#span7").text("");
			return true;
		}
	}

	function checkValue8(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#8a").val();
		if (name == null || name == "") {
			$("#span8").text("不能为空！");
			return false;
		} else {
			$("#span8").text("");
			return true;
		}
	}
	function checkValue9(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9a").val();
		if (name == null || name == "") {
			$("#span9").text("不能为空！");
			return false;
		} else {
			$("#span9").text("");
			return true;
		}
	}

	function checkValue10(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#10a").val();
		if (name == null || name == "") {
			$("#span10").text("不能为空！");
			return false;
		} else {
			$("#span10").text("");
			return true;
		}
	}

	function checkValue11(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1b").val();
		if (name == null || name == "") {
			$("#span11").text("不能为空！");
			return false;
		} else {
			$("#span11").text("");
			return true;
		}
	}

	function checkValue12(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2b").val();
		if (name == null || name == "") {
			$("#span12").text("不能为空！");
			return false;
		} else {
			$("#span12").text("");
			return true;
		}
	}

	function checkValue13(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3b").val();
		if (name == null || name == "") {
			$("#span13").text("不能为空！");
			return false;
		} else {
			$("#span13").text("");
			return true;
		}
	}

	function checkValue14(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4b").val();
		if (name == null || name == "") {
			$("#span14").text("不能为空！");
			return false;
		} else {
			$("#span14").text("");
			return true;
		}
	}

	function checkValue15(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5b").val();
		if (name == null || name == "") {
			$("#span15").text("不能为空！");
			return false;
		} else {
			$("#span15").text("");
			return true;
		}
	}
	function checkValue16(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#6b").val();
		if (name == null || name == "") {
			$("#span16").text("不能为空！");
			return false;
		} else {
			$("#span16").text("");
			return true;
		}
	}

	function checkValue17(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#7b").val();
		if (name == null || name == "") {
			$("#span17").text("不能为空！");
			return false;
		} else {
			$("#span17").text("");
			return true;
		}
	}

	function checkValue18(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#8b").val();
		if (name == null || name == "") {
			$("#span18").text("不能为空！");
			return false;
		} else {
			$("#span18").text("");
			return true;
		}
	}

	function checkValue19(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9b").val();
		if (name == null || name == "") {
			$("#span19").text("不能为空！");
			return false;
		} else {
			$("#span19").text("");
			return true;
		}
	}

	function checkValue20(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#10b").val();
		if (name == null || name == "") {
			$("#span20").text("不能为空！");
			return false;
		} else {
			$("#span20").text("");
			return true;
		}
	}

	function checkValue21(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1c").val();
		if (name == null || name == "") {
			$("#span21").text("不能为空！");
			return false;
		} else {
			$("#span21").text("");
			return true;
		}
	}

	function checkValue22(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2c").val();
		if (name == null || name == "") {
			$("#span22").text("不能为空！");
			return false;
		} else {
			$("#span22").text("");
			return true;
		}
	}

	function checkValue23(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3c").val();
		if (name == null || name == "") {
			$("#span23").text("不能为空！");
			return false;
		} else {
			$("#span23").text("");
			return true;
		}
	}

	function checkValue24(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4c").val();
		if (name == null || name == "") {
			$("#span24").text("不能为空！");
			return false;
		} else {
			$("#span24").text("");
			return true;
		}
	}

	function checkValue25(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5c").val();
		if (name == null || name == "") {
			$("#span25").text("不能为空！");
			return false;
		} else {
			$("#span25").text("");
			return true;
		}
	}

	function checkValue26(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#6c").val();
		if (name == null || name == "") {
			$("#span26").text("不能为空！");
			return false;
		} else {
			$("#span26").text("");
			return true;
		}
	}

	function checkValue27(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#7c").val();
		if (name == null || name == "") {
			$("#span27").text("不能为空！");
			return false;
		} else {
			$("#span27").text("");
			return true;
		}
	}

	function checkValue28(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#8c").val();
		if (name == null || name == "") {
			$("#span28").text("不能为空！");
			return false;
		} else {
			$("#span28").text("");
			return true;
		}
	}

	function checkValue29(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9c").val();
		if (name == null || name == "") {
			$("#span29").text("不能为空！");
			return false;
		} else {
			$("#span29").text("");
			return true;
		}
	}

	function checkValue30(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#10c").val();
		if (name == null || name == "") {
			$("#span30").text("不能为空！");
			return false;
		} else {
			$("#span30").text("");
			return true;
		}
	}
	function checkValue31(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1d").val();
		if (name == null || name == "") {
			$("#span31").text("不能为空！");
			return false;
		} else {
			$("#span31").text("");
			return true;
		}
	}
	function checkValue32(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2d").val();
		if (name == null || name == "") {
			$("#span32").text("不能为空！");
			return false;
		} else {
			$("#span32").text("");
			return true;
		}
	}

	function checkValue33(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3d").val();
		if (name == null || name == "") {
			$("#span33").text("不能为空！");
			return false;
		} else {
			$("#span33").text("");
			return true;
		}
	}

	function checkValue34(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4d").val();
		if (name == null || name == "") {
			$("#span34").text("不能为空！");
			return false;
		} else {
			$("#span34").text("");
			return true;
		}
	}

	function checkValue35(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5d").val();
		if (name == null || name == "") {
			$("#span35").text("不能为空！");
			return false;
		} else {
			$("#span35").text("");
			return true;
		}
	}

	function checkValue36(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#6d").val();
		if (name == null || name == "") {
			$("#span36").text("不能为空！");
			return false;
		} else {
			$("#span36").text("");
			return true;
		}
	}

	function checkValue37(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#7d").val();
		if (name == null || name == "") {
			$("#span37").text("不能为空！");
			return false;
		} else {
			$("#span37").text("");
			return true;
		}
	}

	function checkValue38(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#8d").val();
		if (name == null || name == "") {
			$("#span38").text("不能为空！");
			return false;
		} else {
			$("#span38").text("");
			return true;
		}
	}

	function checkValue39(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9d").val();
		if (name == null || name == "") {
			$("#span39").text("不能为空！");
			return false;
		} else {
			$("#span39").text("");
			return true;
		}
	}

	function checkValue40(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#10d").val();
		if (name == null || name == "") {
			$("#span40").text("不能为空！");
			return false;
		} else {
			$("#span40").text("");
			return true;
		}
	}

	function checkValue41(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1e").val();
		if (name == null || name == "") {
			$("#span41").text("不能为空！");
			return false;
		} else {
			$("#span41").text("");
			return true;
		}
	}

	function checkValue42(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2e").val();
		if (name == null || name == "") {
			$("#span42").text("不能为空！");
			return false;
		} else {
			$("#span42").text("");
			return true;
		}
	}

	function checkValue43(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3e").val();
		if (name == null || name == "") {
			$("#span43").text("不能为空！");
			return false;
		} else {
			$("#span43").text("");
			return true;
		}
	}

	function checkValue44(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4e").val();
		if (name == null || name == "") {
			$("#span44").text("不能为空！");
			return false;
		} else {
			$("#span44").text("");
			return true;
		}
	}

	function checkValue45(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5e").val();
		if (name == null || name == "") {
			$("#span45").text("不能为空！");
			return false;
		} else {
			$("#span45").text("");
			return true;
		}
	}

	function checkValue46(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#6e").val();
		if (name == null || name == "") {
			$("#span46").text("不能为空！");
			return false;
		} else {
			$("#span46").text("");
			return true;
		}
	}

	function checkValue47(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#7e").val();
		if (name == null || name == "") {
			$("#span47").text("不能为空！");
			return false;
		} else {
			$("#span47").text("");
			return true;
		}
	}

	function checkValue48(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#8e").val();
		if (name == null || name == "") {
			$("#span48").text("不能为空！");
			return false;
		} else {
			$("#span48").text("");
			return true;
		}
	}

	function checkValue49(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9e").val();
		if (name == null || name == "") {
			$("#span49").text("不能为空！");
			return false;
		} else {
			$("#span49").text("");
			return true;
		}
	}

	function checkValue50(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#10e").val();
		if (name == null || name == "") {
			$("#span50").text("不能为空！");
			return false;
		} else {
			$("#span50").text("");
			return true;
		}
	}

	function checkValue51(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1f").val();
		if (name == null || name == "") {
			$("#span51").text("不能为空！");
			return false;
		} else {
			$("#span51").text("");
			return true;
		}
	}

	function checkValue52(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2f").val();
		if (name == null || name == "") {
			$("#span52").text("不能为空！");
			return false;
		} else {
			$("#span52").text("");
			return true;
		}
	}

	function checkValue53(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3f").val();
		if (name == null || name == "") {
			$("#span53").text("不能为空！");
			return false;
		} else {
			$("#span53").text("");
			return true;
		}
	}

	function checkValue54(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4f").val();
		if (name == null || name == "") {
			$("#span54").text("不能为空！");
			return false;
		} else {
			$("#span54").text("");
			return true;
		}
	}

	function checkValue55(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5f").val();
		if (name == null || name == "") {
			$("#span55").text("不能为空！");
			return false;
		} else {
			$("#span55").text("");
			return true;
		}
	}
	function checkValue56(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#6f").val();
		if (name == null || name == "") {
			$("#span56").text("不能为空！");
			return false;
		} else {
			$("#span56").text("");
			return true;
		}
	}

	function checkValue57(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#7f").val();
		if (name == null || name == "") {
			$("#span57").text("不能为空！");
			return false;
		} else {
			$("#span57").text("");
			return true;
		}
	}

	function checkValue58(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#8f").val();
		if (name == null || name == "") {
			$("#span58").text("不能为空！");
			return false;
		} else {
			$("#span58").text("");
			return true;
		}
	}

	function checkValue59(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9f").val();
		if (name == null || name == "") {
			$("#span59").text("不能为空！");
			return false;
		} else {
			$("#span59").text("");
			return true;
		}
	}
	function checkValue60(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#10f").val();
		if (name == null || name == "") {
			$("#span60").text("不能为空！");
			return false;
		} else {
			$("#span60").text("");
			return true;
		}
	}
	function checkValue61(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5g").val();
		if (name == null || name == "") {
			$("#span65").text("不能为空！");
			return false;
		} else {
			$("#span65").text("");
			return true;
		}
	}

	function checkValue62(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#6g").val();
		if (name == null || name == "") {
			$("#span66").text("不能为空！");
			return false;
		} else {
			$("#span66").text("");
			return true;
		}
	}

	function checkValue63(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#7g").val();
		if (name == null || name == "") {
			$("#span67").text("不能为空！");
			return false;
		} else {
			$("#span67").text("");
			return true;
		}
	}

	function checkValue64(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#8g").val();
		if (name == null || name == "") {
			$("#span68").text("不能为空！");
			return false;
		} else {
			$("#span68").text("");
			return true;
		}
	}
	function checkValue65(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9g").val();
		if (name == null || name == "") {
			$("#span69").text("不能为空！");
			return false;
		} else {
			$("#span69").text("");
			return true;
		}
	}

	function checkValue66(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#10g").val();
		if (name == null || name == "") {
			$("#span70").text("不能为空！");
			return false;
		} else {
			$("#span70").text("");
			return true;
		}
	}

	function checkValue67(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1h").val();
		if (name == null || name == "") {
			$("#span71").text("不能为空！");
			return false;
		} else {
			$("#span71").text("");
			return true;
		}
	}

	function checkValue68(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2h").val();
		if (name == null || name == "") {
			$("#span72").text("不能为空！");
			return false;
		} else {
			$("#span72").text("");
			return true;
		}
	}

	function checkValue69(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3h").val();
		if (name == null || name == "") {
			$("#span73").text("不能为空！");
			return false;
		} else {
			$("#span73").text("");
			return true;
		}
	}

	function checkValue70(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4h").val();
		if (name == null || name == "") {
			$("#span74").text("不能为空！");
			return false;
		} else {
			$("#span74").text("");
			return true;
		}
	}

	function checkValue71(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5h1").val();
		if (name == null || name == "") {
			$("#span751").text("不能为空！");
			return false;
		} else {
			$("#span751").text("");
			return true;
		}
	}

	function checkValue72(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5h2").val();
		if (name == null || name == "") {
			$("#span752").text("不能为空！");
			return false;
		} else {
			$("#span752").text("");
			return true;
		}
	}

	function checkValue73(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5h3").val();
		if (name == null || name == "") {
			$("#span753").text("不能为空！");
			return false;
		} else {
			$("#span753").text("");
			return true;
		}
	}

	function checkValue74(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#1i").val();
		if (name == null || name == "") {
			$("#span81").text("不能为空！");
			return false;
		} else {
			$("#span81").text("");
			return true;
		}
	}

	function checkValue75(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#2i").val();
		if (name == null || name == "") {
			$("#span82").text("不能为空！");
			return false;
		} else {
			$("#span82").text("");
			return true;
		}
	}

	function checkValue76(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#3i").val();
		if (name == null || name == "") {
			$("#span83").text("不能为空！");
			return false;
		} else {
			$("#span83").text("");
			return true;
		}
	}

	function checkValue77(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#4i").val();
		if (name == null || name == "") {
			$("#span84").text("不能为空！");
			return false;
		} else {
			$("#span84").text("");
			return true;
		}
	}

	function checkValue78(isvalue) {
		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#5i").val();

		if (name == null || name == "") {
			$("#span85").text("不能为空！");
			return false;
		} else {
			$("#span85").text("");
			return true;
		}
	}

	function checkValue79(isvalue) {

		//取得文本框的值
		var name = $(isvalue).val();
		var name = $("#9i").val();
		if (name == null || name == "") {
			$("#span89").text("不能为空！");
			return false;
		} else {
			$("#span89").text("");
			return true;
		}
	}

	function saveAttri() {

		if (checkValue1() && checkValue2() && checkValue3() && checkValue4()
				&& checkValue5() && checkValue6() && checkValue7()
				&& checkValue8() && checkValue9() && checkValue10()
				&& checkValue11() && checkValue12() && checkValue13()
				&& checkValue14() && checkValue15() && checkValue16()
				&& checkValue17() && checkValue18() && checkValue19()
				&& checkValue20() && checkValue21() && checkValue22()
				&& checkValue23() && checkValue24() && checkValue25()
				&& checkValue26() && checkValue27() && checkValue28()
				&& checkValue29() && checkValue30() && checkValue31()
				&& checkValue32() && checkValue33() && checkValue34()
				&& checkValue35() && checkValue36() && checkValue37()
				&& checkValue38() && checkValue39() && checkValue40()
				&& checkValue41() && checkValue42() && checkValue43()
				&& checkValue44() && checkValue45() && checkValue46()
				&& checkValue47() && checkValue48() && checkValue49()
				&& checkValue50() && checkValue51() && checkValue52()
				&& checkValue53() && checkValue54() && checkValue55()
				&& checkValue56() && checkValue57() && checkValue58()
				&& checkValue59() && checkValue60() && checkValue61()
				&& checkValue62() && checkValue63() && checkValue64()
				&& checkValue65() && checkValue66() && checkValue67()
				&& checkValue68() && checkValue69() && checkValue70()
				&& checkValue71() && checkValue72() && checkValue73()
				&& checkValue74() && checkValue75() && checkValue76()
				&& checkValue77() && checkValue78() && checkValue79())

		{
			if (document.getElementById("5j").value.length > 200) {
				$("#vali_msg").text("*输入长度不能超过200个字符!");
				return;
			}
			document.forms[0].submit();
		} else {
			alert("数据未填写完整，保存失败");
			return;
		}
	}

	//if(v1  v2 && v3 && v4 && v5 && v6 && v7 && v8 && v9 && v10 &&v11 && v12 && v13 && v14 && v15 && v16 && v17 && v18 && v19 && v20 &&v21 && v22 && v23 && v24 && v25 && v26 && v27 && v28 && v29 && v30 &&v31 && v32 && v33 && v34 && v35 && v36 && v37 && v38 && v39 && v40 ){
	// 

	//	}else{		
	//	alert("数据未填写完整，保存失败");	
	//	return ;
	//	}
</script>
	</body>
</html>

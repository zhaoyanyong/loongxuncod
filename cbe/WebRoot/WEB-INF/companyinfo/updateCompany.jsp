<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>政府公开信息</title>
<script language="javascript" type="text/javascript"
	src="js/jquery-1.4.3.js"></script>
<script language="javascript" type="text/javascript" src="js/update.js"></script>

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
a {
	font-family:"宋体";
	font-size:13px;
	text-decoration:none;
	color:#fff;
	}
.btn {
	background-image:url(images/right-anniubg1.png);
	border:0px;
	width:86px;
	height:20px;
	line-height:20px;}
</style>
<script>

function show( arg){
	if(arg=="tax"){
	document.getElementById("imageid").src ="upload/${enter.taxUrl}";
	}
	if(arg=="lic"){
	document.getElementById("imageid").src ="upload/${enter.licenseUrl}";
	}
	if(arg=="org"){
	document.getElementById("imageid").src ="upload/${enter.orgNoUrl}";
	}
	

	document.getElementById("DIV").style.display="";
}
function hidden1(){
document.getElementById("DIV").style.display="none";
}
</script>
</head>
<body>
	<form action="updateEnterprise" method="post"
		enctype="multipart/form-data">

		<div style="margin-right:0.5%">
			<img src="images/right.png" width="100%" height="524">
		</div>
		<div style="position:absolute; top:2%; left:2%; width:10px;">
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
			style="position: absolute; top: 7.7%; left: 3%; width: 250px; color:#FFF;">目前操作的功能：企业基本信息查看</div>

		<div
			style="position: absolute; top: 6.5%; left: 93%; width: 200px; color:#FFF;">
			<c:if test="${loginUserAtLine!=3 }">
			<div style="float:left; margin-top:3%; margin-left:5%"">
			<a href="javascript:;" onclick="showResult();return false;">
				<img src="images/right-bianji.png" width="13" height="13" /></a>
			</div>
			
				<div style="float:left; margin-top:3%">
					<a href="javascript:;" onclick="showResult();return false;">保存</a>
				</div>
			</c:if>
		</div>

		<div
			style="width:100%; height:437px; position:absolute; top:12%; left:0.4%;">
			<div
				style="width:100%; height:100%; margin-top:0.5%; overflow-y:scroll; ">

				<table cellpadding="0" cellspacing="0" width="100%" align="left">
					<tr align="center" class="trBg">
						<s:hidden name="enter.id" />
						<s:hidden name="enter.username" />
						<s:hidden name="enter.isHeavyIndustry" />
						<s:hidden name="enter.otherProperty" />
						<s:hidden name="enter.createTime" />
						<s:hidden name="enter.deleteFlag" />
						<s:hidden name="enter.otherCharac" />
						<s:hidden name="enter.licenseUrl" />
						<s:hidden name="enter.taxUrl" />
						<s:hidden name="enter.orgNoUrl" />
						<td height="20" width="50%" align="left">&nbsp;企业名称： <s:textfield
								theme="simple" name="enter.epname" cssClass="text_input"  maxlength="32"
								id="epname" onfocus="epnameJSOne()" onblur="epnameJSTwo()"></s:textfield>
							<span id="mm1" class="error_msg"></span>
						</td>
						<td height="20" width="50%" class="STYLE19">
						&nbsp;企业地址： <s:textfield
								theme="simple" name="enter.address" cssClass="text_input"
							maxlength="80"	id="address" onfocus="addressJSOne()" ></s:textfield>
							<span id="mm3" class="error_msg"></span>
						
						</td>
					</tr>
					<tr>
						<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
							&nbsp;营业执照编号： <s:textfield theme="simple" name="enter.license"
							maxlength="16"			cssClass="text_input"></s:textfield>
						</td>
						<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
							&nbsp;注&nbsp;册&nbsp;地： <s:textfield theme="simple"
								name="enter.registAddress" cssClass="text_input" 	maxlength="80"	
								id="registAddress" onfocus="registAddressJSOne()"
							></s:textfield> <span id="mm5"
							class="error_msg"></span>
		
						</td>

					</tr>

					<tr align="center" class="trBg">
						<td height="20" width="50%" align="left">
								&nbsp;税务登记证编号： <s:textfield theme="simple" name="enter.tax"
								cssClass="text_input"></s:textfield>
							
						</td>
						<td height="20" width="50%" align="left">&nbsp;邮政编码： <s:textfield
								theme="simple" name="enter.postcode" cssClass="text_input" 	maxlength="6"	
								id="postcode" onfocus="postcodeJSOne()" onblur="postcodeJSTwo()"></s:textfield>
							<span id="mm4" class="error_msg"></span>
						</td>
					</tr>

					<tr align="center" class="trBg">
						<td height="20" width="50%" align="left">
						
								
								
								&nbsp;机构代码： <s:textfield
								theme="simple" name="enter.orgNo" cssClass="text_input"
								onfocus="orgNoJSOne()" readonly="true"></s:textfield> <span
							id="mm2" class="error_msg"></span>
						</td>
						<td height="20" width="50%" align="left">&nbsp;注册资本： <s:textfield
								theme="simple" name="enter.registMoney" cssClass="text_input"
								id="registMoney" onfocus="registMoneyJSOne()"  	maxlength="10"	
								onblur="registMoneyJSTwo()"></s:textfield> 万元 <span id="mm6"
							class="error_msg"></span>
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" width="50%" rowspan="2" align="left">
							&nbsp;联&nbsp;系&nbsp;人： <s:textfield theme="simple"
								name="enter.contacts" cssClass="text_input" id="contacts" 	maxlength="15"	
								onfocus="contactsJSOne()" onblur="contactsJSTwo()"></s:textfield>
							<span id="mm7" class="error_msg"></span>
						</td>
						<td height="20" width="50%" align="left">
							&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话： <s:textfield theme="simple"
								name="enter.contactPhone" cssClass="text_input"  	maxlength="22"	
								id="contactPhone" ></s:textfield> <span
							id="mm8" class="error_msg"></span>
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" width="50%" align="left">&nbsp;电子邮箱： <s:textfield
								theme="simple" name="enter.contactEmail" cssClass="text_input" 	maxlength="32"	
								id="contactEmail" ></s:textfield> <span
							id="mm9" class="error_msg" class="right_msg"></span>
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" width="50%" rowspan="2" align="left">
							&nbsp;法人代表： <s:textfield theme="simple" name="enter.legalPerson"
								cssClass="text_input" id="legalPerson" 	maxlength="30"	
								onfocus="legalPersonJSOne()" onblur="legalPersonJSTwo()"></s:textfield>
							<span id="mm10" class="error_msg"></span>
						</td>
						<td height="20" width="50%" align="left">
							&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话： <s:textfield theme="simple"
								name="enter.legalPhone" cssClass="text_input" id="legalPhone" 	maxlength="22"	
								></s:textfield> <span id="mm11"
							class="error_msg"></span>
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="20" width="50%" align="left">&nbsp;电子邮箱： <s:textfield
								theme="simple" name="enter.legalEmail" cssClass="text_input" 	maxlength="32"	
								id="legalEmail" ></s:textfield> <span
							id="mm12" class="error_msg"></span>
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="22" width="50%" colspan="2">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								style="border:none">
								<tr class="STYLE19">
									<td width="10%" align="left" style="border:none">&nbsp;所属地区：</td>
									<td width="85%" align="left" style="border:none"><s:radio
											theme="simple"
											list='#{1:"济南市  ",2:"青岛市",4:"淄博市",5:"枣庄市" ,6:"东营市",7:"烟台市",8:"潍坊市",
								9:"济宁市",10:"泰安市",11:"威海市 ",12:"日照市",13:"滨州市 ",14:"德州市",15:"聊城市",16:"临沂市 ",
								17:"菏泽市",18:"莱芜市 "}'
											listKey="key" listValue="value" name="enter.area" /></td>
									<td style="border:none"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td height="22" width="50%" colspan="2">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								style="border:none">
								<tr class="STYLE19">
									<td width="10%" align="left" style="border:none">
										&nbsp;所属行业：</td>
									<td width="85%" align="left" style="border:none"><s:radio
											theme="simple"
											list='#{20:"农、林、牧、渔业 ",21:"采矿业",22:"制造业",23:"电力、热力、燃气及水生产和供应业",24:"建筑业" ,25:"批发和零售业",26:"交通运输、仓储和邮政业",27:"住宿和餐饮业",
								28:"信息传输、软件和信息技术服务业",29:"金融业",30:"房地产业",31:"租赁和商务服务业",32:"科学研究和技术服务业",33:"水利、环境和公共设施管理业",34:"居民服务、修理和其他服务业",35:"教育",
								36:"卫生和社会工作",37:"文化、体育和娱乐业",38:"公共管理、社会保障和社会组织",39:"国际组织"}'
											listKey="key" listValue="value" name="enter.profession" /></td>
									<td style="border:none"></td>
								</tr>
							</table>
						</td>

					</tr>
					<tr align="center" class="trBg">
						<td height="22" width="50%" colspan="2">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								style="border:none">
								<tr class="STYLE19">
									<td width="10%" align="left" style="border:none">&nbsp;企业性质：</td>
									<td width="85%" align="left" style="border:none"><s:radio
											theme="simple"
											list='#{40:"有限责任公司",41:"有限责任公司(国有独资)",42:"有限责任公司(外商投资企业投资)",43:"有限责任公司(外商投资企业合资)",44:"有限责任公司(外商投资企业与内资合资)" ,45:"有限责任公司(外商投资企业法人独资)",46:"有限责任公司(自然人投资或控股)",47:"有限责任公司(国有控股)",
								48:"一人有限责任公司",49:"一人有限责任公司(自然独资)",50:"一人有限责任公司(法人独资)",51:"有限责任公司(非自然人投资或控股的法人独资)",52:"其他有限责任公司",53:"股份有限公司",54:"股份有限公司(非上市)",55:"股份有限公司(非上市、外商投资企业投资)",56:"股份有限公司(非上市、自然人投资或控股)",
								57:"股份有限公司(非上市、国有控股)",58:"其他股份有限公司(非上市)",59:"有限责任公司(外商投资企业)",60:"有限责任公司(中外合资)",61:"有限责任公司(中外合作)",62:"有限责任公司(外商合资)",63:"有限责任公司(外国自然人独资)",64:"有限责任公司(外国法人独资)",65:"有限责任公司(外国非法人经济组织独资)",
								66:"股份有限公司(外商投资企业)",67:"股份有限公司(中外合资、未上市)",68:"股份有限公司(中外合资、上市)",69:"股份有限公司(外商合资、未上市)",70:"股份有限公司(外商合资、上市)",71:"非公司外商投资企业(中外合作)",72:"非公司外商投资企业(外商合资)",73:"非公司其他",74:"有限责任公司(台、港、澳投资企业)",
								75:"有限责任公司(台港澳与境内合资)",76:"有限责任公司(台港澳与境内合作)",77:"有限责任公司(台港澳合资)",78:"有限责任公司(台港澳自然人独资 )",79:"有限责任公司(台港澳法人独资)",80:"有限责任公司(台港澳非法人经济组织独资)",81:"有限责任公司(台港澳与外国投资者合资)",82:"股份有限公司(台、港、澳投资企业)",
								83:"股份有限公司(台港澳与境内合资、未上市)",84:"股份有限公司(台港澳与境内合资、上市)",85:"股份有限公司(台港澳合资、未上市)",86:"股份有限公司(台港澳合资、上市)",87:"股份有限公司(台港澳与外国投资者合资、未上市)",88:"股份有限公司(台港澳与外国投资者合资、上市)",89:"非公司台、港、澳企业(台港澳与境内合作)",
								90:"非公司台、港、澳企业(台港澳合资)",91:"全民所有制",92:"集体所有制",93:"其他"}'
											listKey="key" listValue="value" name="enter.property" /></td>
									<td style="border:none"></td>
								</tr>
							</table>
						</td>
					</tr>

					<tr align="center" class="trBg">
						<td width="50%" colspan="2">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								id="table1" style="border:none">
								<tr align="center" class="trBg">
									<td align="left" width="10%" rowspan="3" width="10%"
										style="border:none">&nbsp;当前公司<br />&nbsp;人员情况：
									</td>
									<td align="left" width="42%" style="border:none">
										&nbsp;从业人员总数： <s:textfield theme="simple" name="enter.staff"
											cssClass="text_input" id="staff" onfocus="staffJSOne()" 	maxlength="8"	
											onblur="staffJSTwo()"></s:textfield> 人 <span id="mm13"
										class="error_msg"></span>
									</td>
									<td width="43%" align="left" style="border:none">
										&nbsp;本科以上毕业： <s:textfield theme="simple"
											name="enter.colleageStaff" cssClass="text_input"
											id="colleageStaff" onfocus="colleageStaffJSOne()"  maxlength="8"	
											onblur="colleageStaffJSTwo()"></s:textfield> 人 <span
										id="mm14" class="error_msg"></span>
									</td>
									<td width="10%" style="border:none"></td>
								</tr>
								<tr align="center" class="trBg">
									<td align="left" width="42%" style="border:none">
										&nbsp;专业技术人员： <s:textfield theme="simple"
											name="enter.technicalStaff" cssClass="text_input"  maxlength="8"	
											id="technicalStaff" onfocus="technicalStaffJSOne()"
											onblur="technicalStaffJSTwo()"></s:textfield> 人 <span
										id="mm15" class="error_msg"></span>
									</td>
									<td align="left" width="43%" style="border:none">
										&nbsp;高级管理人员： <s:textfield theme="simple"
											name="enter.manageStaff" cssClass="text_input" maxlength="8"	
											id="manageStaff" onfocus="manageStaffJSOne()"
											onblur="manageStaffJSTwo()"></s:textfield> 人 <span id="mm16"
										class="error_msg"></span>
									</td>
									<td width="10%" style="border:none"></td>
								</tr>
								
								
								
								<tr align="center" class="trBg">
									<td align="left" width="42%" style="border:none">
										&nbsp;女性职工人数： <s:textfield theme="simple" maxlength="8"	
											name="enter.womenStaff"  cssClass="text_input"
											id="womenStaff" 
											></s:textfield> 人 <span
										id="mm15" class="error_msg"></span>
									</td>
									<td align="left" width="43%" style="border:none">
										&nbsp;少数民族职工： <s:textfield theme="simple" 
											name="enter.minorityStaff" cssClass="text_input"
											id="minorityStaff" ></s:textfield> 人 <span id="mm16"
										class="error_msg"></span>
									</td>
									<td width="10%" style="border:none"></td>
								</tr>
								
								
							</table>
						</td>
					</tr>
					<tr align="center" class="trBg">
						<td align="left" height="20" class="STYLE19" colspan="2">
							&nbsp;生命周期： <s:select theme="simple"
								list="#{1:'初创期',2:'发展期',3:'稳定期'}" listKey="key"
								listValue="value" name="enter.stage" id="life">
							</s:select>
						</td>
					</tr>

					<tr>
						
						
						<td>营业执照：</td>
						<td><s:file name="imageLicense" label="营业执照" theme="simple"></s:file>
							<button type="button" class="btn" onclick="javascript:show('lic')">查看图片</button>
						</td>
					</tr>
						
				
						
					<tr>
						<td>税务登记：</td>
						<td><s:file name="imageTax" label="税务登记" theme="simple"></s:file>
							<button type="button" class="btn" onclick="javascript:show('tax')">查看图片</button>
						</td>
					</tr>
						
					<tr>
						
							<td>组织机构代码：</td>
						<td><s:file name="imageOrgNo" label="组织机构代码" theme="simple"></s:file>
							<button type="button" class="btn" onclick="javascript:show('org')">查看图片</button>
						</td>
					</tr>
				</table>
			</div>

		</div>
		
		
		<div style=" position:absolute; top:12%; left:0.4%; width: 98.5%; height: 86.9%; display: none; background-image: url('images/right-touming.png');"  id="DIV">
			<div style="text-align: center; margin-top: 2%"><img  alt="显示图片"   id="imageid" width="60%" height="60%"/></div>
			<div style=" position:absolute; top:0%; left:92.4%;"><button type="button" class="btn" onclick="javascript:hidden1()">关闭</button></div>
		</div>
	</form>
</body>
</html>
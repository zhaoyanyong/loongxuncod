<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/global.css" rel="stylesheet" type="text/css">
<script language="javascript" type="text/javascript"
	src="js/jquery-1.4.3.js"></script>
<script src="js/checkEnterprise.js"></script>
<title>企业注册</title>

</head>
<body>

	<div align="center">
		<form id="registerForm" action="register" method="post"
			enctype="multipart/form-data">
			<table border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce"
				style="margin-top: 10px;" width="100%">
				<tr>
					<th height="20" bgcolor="#d3eaef" class="STYLE10" align="center"
						colspan="2">企业注册</th>
				</tr>
				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;用&nbsp;户&nbsp;名： <input type="text"
						name="userBase.adminName" id="username" maxlength="16"
						class="text_input" style="width:50%" onfocus="tipUserName()"
						onblur="checkUserName()" /> <font color="red">*<span
							id="info1"></span></font>
					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;码： <input type="password"
						name="userBase.password" id="password" maxlength="16"
						class="text_input" style="width:50%" onfocus="tipPassword()"
						onblur="checknewPass()" /> <font color="red">*<span
							id="info2"></span></font>
					</td>
				</tr>
				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;重复密码： <input type="password" name="pwd" id="pwd"
						class="text_input" maxlength="16" style="width:50%"
						onfocus="tipPassword2()" onblur="checknewPass2()" /> <font
						color="red">*<span id="info3"></span></font>
					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">

					</td>
				</tr>
				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;企业名称： <input type="text" name="einfo.epname" id="epname"
						class="text_input" style="width:50%" maxlength="100"
						onblur="checkNull('epname')" /> <font color="red">*<span
							class="tip" id="epnameinfo">最大长度100</span></font>
					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;营业执照编号： <input type="text" name="einfo.license"
						id="licenseinfo" class="text_input" style="width:50%"
						maxlength="20" />
					</td>

				</tr>
				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;税务登记证编号： <input type="text" name="einfo.tax" id="taxinfo"
						class="text_input" style="width:50%" maxlength="20" />

					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">



						&nbsp;机构代码： <input type="text" name="einfo.orgNo" id="orgNo"
						class="text_input" style="width:50%" maxlength="10"
						onfocus="tipOrgNo()" onblur="checkOrgNo()" /> <font
						color="red">*<span class="tip" id="info4"></span></font>
					</td>

				</tr>

				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;通讯地址： <input type="text" name="einfo.address" id="address"
						class="text_input" style="width:50%" maxlength="50"
						 /> <font color="red">*<span
							class="tip" id="addressinfo">最大长度50</span></font>
					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;邮政编码： <input type="text" name="einfo.postcode" id="postcode"
						class="text_input" style="width:50%" maxlength="8"
						onkeyup="this.value=this.value.replace(/[\u4E00-\u9FA5]/g,'')"
						onblur="checkNull('postcode')" /> <font color="red">*<span
							class="tip" id="postcodeinfo">最大长度8</span></font>
					</td>
				</tr>

				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;注&nbsp;册&nbsp;地： <input type="text"
						name="einfo.registAddress" id="registAddress" class="text_input"
						style="width:50%" maxlength="50"
						/> <font color="red">*<span
							class="tip" id="registAddressinfo">最大长度50</span></font>
					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;注册资本： <input type="text" name="einfo.registMoney"
						id="registMoney" class="text_input" style="width:50%"
						maxlength="10" onblur="checkRegistMoney()"
						onkeyup="if(isNaN(value))execCommand('undo')" /> 万元<font
						color="red">*<span id="info5"></span></font>
					</td>
				</tr>

				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19"
						rowspan="2">&nbsp;联&nbsp;系&nbsp;人： <input type="text"
						name="einfo.contacts" id="contacts" class="text_input"
						style="width:50%" onblur="checkNull('contacts')" maxlength="8" />
						<font color="red">*<span id="contactsinfo"></span></font>
					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话： <input type="text"
						name="einfo.contactPhone" id="contactPhone" class="text_input"
						maxlength="16" style="width:50%"
						onblur="checkNull('contactPhone')"
						onkeyup="value=value.replace(/[^\d]/g,'') " /> <font color="red">*<span
							id="contactPhoneinfo"></span></font>
					</td>
				</tr>
				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;电子邮箱： <input type="text" name="einfo.contactEmail"
						id="contactEmail" class="text_input" style="width:50%"
						maxlength="50" onblur="checkNull('contactEmail')" /> <font
						color="red">*<span id="contactEmailinfo"></span></font>
					</td>
				</tr>
				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19"
						rowspan="2">&nbsp;法人代表： <input type="text"
						name="einfo.legalPerson" id="legalPerson" class="text_input"
						style="width:50%" onblur="checkNull('legalPerson')" maxlength="8" />
						<font color="red">*<span id="legalPersoninfo"></span></font>
					</td>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;电&nbsp;&nbsp;&nbsp;&nbsp;话： <input type="text"
						name="einfo.legalPhone" id="legalPhone" class="text_input"
						style="width:50%" onblur="checkNull('legalPhone')" maxlength="16"
						onkeyup="value=value.replace(/[^\d]/g,'') " /> <font color="red">*<span
							id="legalPhoneinfo"></span></font>
					</td>
				</tr>
				<tr>
					<td height="20" bgcolor="#FFFFFF" width="50%" class="STYLE19">
						&nbsp;电子邮箱： <input type="text" name="einfo.legalEmail"
						id="legalEmail" class="text_input" style="width:50%"
						onblur="checkNull('legalEmail')" maxlength="50" /> <font
						color="red">*<span id="legalEmailinfo"></span></font>
					</td>
				</tr>
				<tr>
					<td height="22" bgcolor="#FFFFFF" width="50%" class="STYLE19"
						colspan="2">
						<table width="100%" border="0" cellpadding="0" cellspacing="1">
							<tr class="STYLE19">
								<td width="10%">&nbsp;所属地区：</td>
								<td width="85%"><input type="radio" class="radio"
									name="einfo.area" value="1" checked="checked" />济南市 <input
									type="radio" class="radio" name="einfo.area" value="2" />青岛市 <input
									type="radio" class="radio" name="einfo.area" value="4" />淄博市 <input
									type="radio" class="radio" name="einfo.area" value="5" />枣庄市 <input
									type="radio" class="radio" name="einfo.area" value="6" />东营市 <input
									type="radio" class="radio" name="einfo.area" value="7" />烟台市 <input
									type="radio" class="radio" name="einfo.area" value="8" />潍坊市 <input
									type="radio" class="radio" name="einfo.area" value="9" />济宁市 <input
									type="radio" class="radio" name="einfo.area" value="10" />泰安市
									<br /> <input type="radio" class="radio" name="einfo.area"
									value="11" />威海市 <input type="radio" class="radio"
									name="einfo.area" value="12" />日照市 <input type="radio"
									class="radio" name="einfo.area" value="13" />滨州市 <input
									type="radio" class="radio" name="einfo.area" value="14" />德州市
									<input type="radio" class="radio" name="einfo.area" value="15" />聊城市
									<input type="radio" class="radio" name="einfo.area" value="16" />临沂市
									<input type="radio" class="radio" name="einfo.area" value="17" />菏泽市
									<input type="radio" class="radio" name="einfo.area" value="18" />莱芜市
								</td>
								<td><font color="red">*<span id="namewm"></span></font></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="22" bgcolor="#FFFFFF" width="50%" class="STYLE19"
						colspan="2">
						<table width="100%" border="0" cellpadding="0" cellspacing="1">
							<tr class="STYLE19">
								<td width="10%">&nbsp;所属行业：</td>
								<td width="85%"><input type="radio" class="radio1"
									name="einfo.profession" value="20" checked="checked" />电子信息 <input
									type="radio" class="radio1" name="einfo.profession" value="21" />光电一体化
									<input type="radio" class="radio1" name="einfo.profession"
									value="22" />生物、医药与医疗器械 <input type="radio" class="radio"
									name="einfo.profession" value="23" />航天航空 <input type="radio"
									class="radio1" name="einfo.profession" value="24" />软件 <input
									type="radio" class="radio1" name="einfo.profession" value="25" />新材料
									<input type="radio" class="radio1" name="einfo.profession"
									value="26" />环境保护 <br />
								<input type="radio" class="radio1" name="einfo.profession"
									value="27" />新能源与高效节能 <input type="radio" class="radio1"
									name="einfo.profession" value="28" />地球、空间与海洋 <input
									type="radio" class="radio1" name="einfo.profession" value="29" />高技术服务
									<input type="radio" class="radio1" name="einfo.profession"
									value="30" />造纸、纸制 <input type="radio" class="radio1"
									name="einfo.profession" value="31" />金属冶炼、金属制品业 <br />
								<input type="radio" class="radio1" name="einfo.profession"
									value="32" />农、林、牧、渔 <input type="radio" class="radio1"
									name="einfo.profession" value="33" />核应用技术 <input type="radio"
									class="radio1" name="einfo.profession" value="34" />仪器仪表 <input
									type="radio" class="radio1" name="einfo.profession" value="35" />机械设备制造
									<input type="radio" class="radio1" name="einfo.profession"
									value="36" />食品保健品 <input type="radio" class="radio1"
									name="einfo.profession" value="37" />纺织业皮革 <br />
								<input type="radio" class="radio1" name="einfo.profession"
									value="38" />化学化工原料及化学制品 <input type="radio" class="radio1"
									name="einfo.profession" value="39" />其他</td>
								<td><font color="red">*<span id="namewm"></span></font></td>
							</tr>
						</table>
					</td>

				</tr>
				<tr>
					<td height="22" bgcolor="#FFFFFF" width="50%" class="STYLE19"
						colspan="2">
						<table width="100%" border="0" cellpadding="0" cellspacing="1">
							<tr class="STYLE19">
								<td width="10%">&nbsp;企业性质：</td>
								<td width="85%"><input type="radio" class="radio"
									name="einfo.property" value="40" checked="checked" />国有企业 <input
									type="radio" class="radio" name="einfo.property" value="41" />集体企业
									<input type="radio" class="radio" name="einfo.property"
									value="42" />股份合作制企业 <input type="radio" class="radio"
									name="einfo.property" value="43" />有限责任公司 <input type="radio"
									class="radio" name="einfo.property" value="44" />股份制有限公司 <input
									type="radio" class="radio" name="einfo.property" value="45" />合伙公司<br />
									<input type="radio" class="radio" name="einfo.property"
									value="46" />个人独资企业 <input type="radio" class="radio"
									name="einfo.property" value="47" />中外合资经营企业 <input
									type="radio" class="radio" name="einfo.property" value="48" />中外合作经营企业
									<input type="radio" class="radio" name="einfo.property"
									value="49" />其他</td>
								<td><font color="red">*<span id="namewm"></span></font></td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFFFF" width="50%" class="STYLE19" colspan="2">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							id="table1">
							<tr class="STYLE19">
								<td width="10%" rowspan="2" bgcolor="#FFFFFF"
									style="border-right:2px solid;border-right-color:#d3eaef;"
									width="10%">&nbsp;当前公司<br />&nbsp;人员情况：
								</td>
								<td width="42%" bgcolor="#FFFFFF"
									style="border-right:2px solid;border-right-color:#d3eaef;">
									&nbsp;从业人员总数：<input type="text" name="einfo.staff" id="staff"
									height="15" class="text_input" maxlength="8" style="width:40%"
									onkeyup="value=value.replace(/[^\d]/g,'') "
									onblur="checkNull('staff')" /> <font color="red">*<span
										id="staffinfo"></span></font>
								</td>
								<td width="43%">&nbsp;大专及以上毕业人数：<input type="text"
									name="einfo.colleageStaff" id="colleageStaff" height="15"
									maxlength="8" class="text_input" style="width:40%"
									onkeyup="value=value.replace(/[^\d]/g,'') "
									onblur="checkNull('colleageStaff')" /> <font color="red">*<span
										id="colleageStaffinfo"></span></font>
								</td>

							</tr>
							<tr class="STYLE19">
								<td width="42%" bgcolor="#FFFFFF"
									style="border-right:2px solid;border-right-color:#d3eaef;border-top:2px solid;border-top-color:#d3eaef">
									&nbsp;技术人员数量：<input type="text" name="einfo.technicalStaff"
									id="technicalStaff" height="15" maxlength="8"
									class="text_input" style="width:40%"
									onkeyup="value=value.replace(/[^\d]/g,'') "
									onblur="checkNull('technicalStaff')" /> <font color="red">*<span
										id="technicalStaffinfo"></span></font>
								</td>
								<td width="43%"
									style="border-top:2px solid;border-top-color:#d3eaef">
									&nbsp;企业管理人员数量&nbsp;&nbsp;：<input type="text"
									name="einfo.manageStaff" id="manageStaff" maxlength="8"
									height="15" class="text_input" style="width:40%"
									onkeyup="value=value.replace(/[^\d]/g,'') "
									onblur="checkNull('manageStaff')" /> <font color="red">*<span
										id="manageStaffinfo"></span></font>
								</td>

							</tr>

						</table>
					</td>
				</tr>
				<tr>
					<td height="20" class="STYLE19">&nbsp;生命周期： <s:select
							list="#{1:'初创期',2:'发展期',3:'稳定期'}" listKey="key" listValue="value"
							headerKey="1" name="einfo.stage" theme="simple" id="life" />





					</td>
					<td class="STYLE19"><s:file  id="imageLicense"   name="imageLicense" label="营业执照" ></s:file>
					</td>
					<td class="STYLE19"><s:file   id="imageTax"    name="imageTax" label="税务登记证"></s:file>
						<s:fielderror /></td>

					<td class="STYLE19"><s:file    id="imageOrgNo"    name="imageOrgNo" label="组织机构代码"></s:file>
						<s:fielderror /></td>
				</tr>
			</table>
		</form>
		<br /> <input src="images/main_44.gif" name="imageField" type="image"
			onclick="javascript:checkRegister();return false;" /> <input
			src="images/main_40.gif" name="imageField" type="image"
			onclick="javascript:location.href='login.jsp';return false;" />
	</div>
</body>
</html>

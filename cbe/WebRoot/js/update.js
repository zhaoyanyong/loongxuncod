//企业名称验证
		function epnameJSOne(){
		
				var obj=document.getElementById('mm1');
obj.innerHTML='<font color="#808080">企业名称不能为空！</font>';
}

function epnameJSTwo(){

var epname=document.getElementById('epname').value;

var obj=document.getElementById('mm1');
var reg=/^[a-zA-Z|\u4e00-\u9fa5|0-9]*$/;
if(epname==null||epname==""||!reg.test(epname)){
js1=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js1=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}

     

	//联系人验证
		function contactsJSOne(){
		
				var obj=document.getElementById('mm7');
obj.innerHTML='<font color="#808080">联系人姓名不能为空！</font>';
}

function contactsJSTwo(){

var contacts=document.getElementById('contacts').value;

var obj=document.getElementById('mm7');
var reg=/^[a-zA-Z|\u4e00-\u9fa5]*$/;
if(contacts==null||contacts==""||!reg.test(contacts)){
js7=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js7=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}

     
	//法人代表验证
		function legalPersonJSOne(){
		
				var obj=document.getElementById('mm10');
obj.innerHTML='<font color="#808080">法人姓名不能为空！</font>';
}

function legalPersonJSTwo(){

var legalPerson=document.getElementById('legalPerson').value;

var obj=document.getElementById('mm10');
var reg=/^[a-zA-Z|\u4e00-\u9fa5]*$/;
if(legalPerson==null||legalPerson==""||!reg.test(legalPerson)){
js10=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js10=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}

    
     
     	//注册资金 验证
		function registMoneyJSOne(){
				var obj=document.getElementById('mm6');
obj.innerHTML='<font color="#808080">注册资金 不能为空！</font>';
}

function registMoneyJSTwo(){

var registMoney=document.getElementById('registMoney').value;

var obj=document.getElementById('mm6');
 var reg = /^(\d{1,6}|\d{1,6}\.\d{1,3})$/;;//整数部分最多6位，最多三位小数  
if(registMoney==null||registMoney==""||!reg.test(registMoney)){
js10=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js10=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}
     


//机构代码 验证
function orgNoJSOne(){
	var obj=document.getElementById('mm2');
	obj.innerHTML='<font color="#808080">不可修改 ！</font>';
}



/*

$(function() {

	// 给用户编号的文本框的光标移除事件绑定函数
	$("#orgNo").blur(function() {

		// 当用户编号光标移除时触发的代码
			var orgNo = $(this).val();
			alert(orgNo);
			var reg=/^(\d{7})$/;
			// 先校验是否为空
			if (!reg.test(orgNo)||orgNo == null || orgNo == "") {

				$("#mm2").text("机构代码不正确！");
				$("#mm2").addClass("error_msg");
				return;
			}

			// 校验是否重复
			$.post("checkorgNo", {
				"orgNo" : orgNo
			}, function(data) {
			
				var repeat = data;
			
				if (repeat) {
					// 重复的情况，提示
					js2=false;
					$("#mm2").text("机构代码不能重复！");
					$("#mm2").addClass("error_msg");
					

				} else {
					// 没重复的情况
					   js2=true;
					$("#mm2").text("输入正确！");
					$("#mm2").removeClass("error_msg");
          
				}
			});
		});
});
*/


/*
//修改用户名 
 function usernameJSOne(){
 var obj=document.getElementById('mm17');
	obj.innerHTML='<font color="#808080">4-16数字和小写字母的组合 ！</font>';
 
 }

	$(function() {
		// 给登录账号 的文本框的光标移除事件绑定函数
	$("#username").blur(function() {
		// 当登录账号 光标移除时触发的代码
			var username = $(this).val();
			alert(username);
			
	var reg=/^[a-z0-9]{4,16}$/;
			// 先校验是否为空
			if (!reg.test(username)||username == null || username == "") {

				$("#mm17").text("登录账号不能为空！");
				$("#mm17").removeClass("right_msg");
				$("#mm17").addClass("error_msg");
				
			}
  
// window.location.href="../system/checkUserName";

			// 校验是否重复
			$.post("enterprise/checkUserName", {
				"username" : username
			}, function(data) {
				
				var repeat = data;
				if (repeat) {
					// 重复的情况，提示
					$("#mm17").text("登录账号不能重复！");
					$("#mm17").removeClass("right_msg");
					$("#mm17").addClass("error_msg");
				js1 = false;
				} else {
					// 没重复的情况
					$("#mm17").text("输入正确！");
					$("#mm17").removeClass("error_msg");
					$("#mm17").addClass("right_msg");
					js1=true;
					
				}
			});
		});
});
*/






// 联系人 手机号验证
		function contactPhoneJSOne(){
		
				var obj=document.getElementById('mm8');
obj.innerHTML='<font color="#808080">手机号不能为空！</font>';
}

/**
$(function() {
	$('#contactPhone').blur(function() {
	
		var contactPhone=$(this).val();
		var reg = /^(13[0-9]|15[0-9]|18[0-9])|\d{8}$/;
		if (!reg.test(contactPhone)) {
			   js8=false;
			$('#mm8').text('输入有错，请输入正确的手机号');
			$("#mm8").addClass("error_msg");
       
		}else{
			js8=true;
			
			$('#mm8').text('正确的手机号');
			$("#mm8").removeClass("error_msg");
			$("#mm8").addClass("right_msg");
		}
	});

});
*/

// 法人  手机号验证

		function legalPhoneJSOne(){
		
				var obj=document.getElementById('mm11');
obj.innerHTML='<font color="#808080">手机号不能为空！</font>';
}

/**
$(function() {
	$('#legalPhone').blur(function() {
	
		var legalPhone=$(this).val();
		var reg = /^(13[0-9]|15[0-9]|18[0-9])|\d{8}$/;
		if (!reg.test(legalPhone)) {
			   js11=false;
			$('#mm11').text('输入有错，请输入正确的手机号');
			$("#mm11").addClass("error_msg");
       
		}else{
			js11=true;
			
			$('#mm11').text('正确的手机号');
			$("#mm11").removeClass("error_msg");
			$("#mm11").addClass("right_msg");
		}
	});

});

*/
    // 联系人 邮箱验证
    
		function contactEmailJSOne(){	
				var obj=document.getElementById('mm9');
obj.innerHTML='<font color="#808080">邮箱不能为空！</font>';
} 
    
    /**
$(function() {
	$('#contactEmail').blur(function() {
		var contactEmail = $(this).val();
		var reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!reg.test(contactEmail)) {
			js9 = false;
			$('#mm9').text('请按照正确的邮箱格式输入！');
	$("#mm9").addClass("error_msg");
		
		}else{
			js9=true;
			
			$('#mm9').text('正确的邮箱格式！');
		$("#mm9").removeClass("error_msg");
		$("#mm9").addClass("right_msg");
		
		}
	});

});
    */
   
    // 法人  邮箱验证
    
		function legalEmailJSOne(){	
				var obj=document.getElementById('mm12');
obj.innerHTML='<font color="#808080">邮箱不能为空！</font>';
}
    
    /**
$(function() {
	$('#legalEmail').blur(function() {
		var legalEmail = $(this).val();
		var reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!reg.test(legalEmail)) {
			js12 = false;
			$('#mm12').text('请按照正确的邮箱格式输入！');
	$("#mm12").addClass("error_msg");
		
		}else{
			js12=true;
			
			$('#mm12').text('正确的邮箱格式！');
		$("#mm12").removeClass("error_msg");
		$("#mm12").addClass("right_msg");
		}
	});

});
    **/
 
  

	//企业地址 验证
		function addressJSOne(){
		
				var obj=document.getElementById('mm3');
obj.innerHTML='<font color="#808080">企业地址不能为空！</font>';
}

function addressJSTwo(){

var address=document.getElementById('address').value;

var obj=document.getElementById('mm3');
var reg=/^[a-zA-Z|\u4e00-\u9fa5|0-9]*$/;
if(address==null||address==""||!reg.test(address)){
js3=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js3=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}
  

	//注册地 验证
		function registAddressJSOne(){
		
				var obj=document.getElementById('mm5');
obj.innerHTML='<font color="#808080">注册地不能为空！</font>';
}

function registAddressJSTwo(){

var registAddress=document.getElementById('registAddress').value;

var obj=document.getElementById('mm5');
var reg=/^[a-zA-Z|\u4e00-\u9fa5|0-9]*$/;
if(registAddress==null||registAddress==""||!reg.test(registAddress)){
js5=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js5=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}
  

	//邮政编码  验证
		function postcodeJSOne(){
		
				var obj=document.getElementById('mm4');
obj.innerHTML='<font color="#808080">邮政编码不能为空！</font>';
}

function postcodeJSTwo(){

var postcode=document.getElementById('postcode').value;

var obj=document.getElementById('mm4');
var reg=/^(\d{6})$/;
if(postcode==null||postcode==""||!reg.test(postcode)){
js4=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js4=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}
  

  
  



	//从业人员总数   验证
		function staffJSOne(){
		
				var obj=document.getElementById('mm13');
obj.innerHTML='<font color="#808080">从业人数不能为空！</font>';
}

function staffJSTwo(){

var staff=document.getElementById('staff').value;

var obj=document.getElementById('mm13');
var reg=/^(\d*)$/;
if(staff==null||staff==""||!reg.test(staff)){
js13=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js13=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}
  


	//大专及以上毕业人数   验证
		function colleageStaffJSOne(){
		
				var obj=document.getElementById('mm14');
obj.innerHTML='<font color="#808080">毕业人数不能为空！</font>';
}

function colleageStaffJSTwo(){

var colleageStaff=document.getElementById('colleageStaff').value;

var obj=document.getElementById('mm14');
var reg=/^(\d*)$/;
if(colleageStaff==null||colleageStaff==""||!reg.test(colleageStaff)){
js14=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js14=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}
  


	//技术人员数量   验证
		function technicalStaffJSOne(){
		
				var obj=document.getElementById('mm15');
obj.innerHTML='<font color="#808080">技术人数不能为空！</font>';
}

function technicalStaffJSTwo(){

var technicalStaff=document.getElementById('technicalStaff').value;

var obj=document.getElementById('mm15');
var reg=/^(\d*)$/;
if(technicalStaff==null||technicalStaff==""||!reg.test(technicalStaff)){
js15=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js15=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

}
  


	//企业管理人员数量   验证
		function manageStaffJSOne(){
		
				var obj=document.getElementById('mm16');
obj.innerHTML='<font color="#808080">管理人数不能为空！</font>';
}

function manageStaffJSTwo(){

var manageStaff=document.getElementById('manageStaff').value;

var obj=document.getElementById('mm16');
var reg=/^(\d*)$/;
if(manageStaff==null||manageStaff==""||!reg.test(manageStaff)){
js16=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
js16=true;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}


}


//提交 
var jj=0;
  function showResult() {
	 
 jj=0;
var epname=document.getElementById('epname').value;
var obj=document.getElementById('mm1');
var reg=/^[a-zA-Z|\u4e00-\u9fa5|0-9]*$/;
if(epname==null||epname==""||!reg.test(epname)){

obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1

obj.innerHTML='<font color="#32CD32">格式正确</font>';

}
 
var contacts=document.getElementById('contacts').value;

var obj=document.getElementById('mm7');
var reg=/^[a-zA-Z|\u4e00-\u9fa5]*$/;
if(contacts==null||contacts==""||!reg.test(contacts)){
js7=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;

obj.innerHTML='<font color="#32CD32">格式正确</font>';

}
 
var legalPerson=document.getElementById('legalPerson').value;

var obj=document.getElementById('mm10');
var reg=/^[a-zA-Z|\u4e00-\u9fa5]*$/;
if(legalPerson==null||legalPerson==""||!reg.test(legalPerson)){
js10=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;

obj.innerHTML='<font color="#32CD32">格式正确</font>';

}
 
 

/**
		var contactPhone=$('#contactPhone').val();
		var reg = /^(13[0-9]|15[0-9]|18[0-9])|\d{8}$/;
		if (!reg.test(contactPhone)) {
			   js8=false;
			$('#mm8').text('输入有错，请输入正确的手机号');
			$("#mm8").addClass("error_msg");
       
		}else{
			jj=jj+1;
		
			$('#mm8').text('正确的手机号');
			$("#mm8").removeClass("error_msg");
				$("#mm8").addClass("right_msg");
		}
	

		
// 法人  手机号验证

		var legalPhone=$('#legalPhone').val();
		var reg = /^(13[0-9]|15[0-9]|18[0-9])|\d{8}$/;
		if (!reg.test(legalPhone)) {
			   js11=false;
			$('#mm11').text('输入有错，请输入正确的手机号');
			$("#mm11").addClass("error_msg");
       
		}else{
		jj=jj+1;
	
			$('#mm11').text('正确的手机号');
			$("#mm11").removeClass("error_msg");
				$("#mm11").addClass("right_msg");
		}

    // 联系人 邮箱验证


		var contactEmail = $('#contactEmail').val();
		var reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!reg.test(contactEmail)) {
			js9 = false;
			$('#mm9').text('请按照正确的邮箱格式输入！');
	$("#mm9").addClass("error_msg");
		
		}else{
			jj=jj+1;
			$('#mm9').text('正确的邮箱格式！');
		$("#mm9").removeClass("error_msg");
		$("#mm9").addClass("right_msg");
		}

    
   
    // 法人  邮箱验证


		var legalEmail = $('#legalEmail').val();
		var reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (!reg.test(legalEmail)) {
			js12 = false;
			$('#mm12').text('请按照正确的邮箱格式输入！');
	$("#mm12").addClass("error_msg");
		
		}else{
		jj=jj+1;
			$('#mm12').text('正确的邮箱格式！');
		$("#mm12").removeClass("error_msg");
		$("#mm12").addClass("right_msg");
		}

 
  **/

	//企业地址 验证
	

/**
var address=document.getElementById('address').value;

var obj=document.getElementById('mm3');
var reg=/^[a-zA-Z|\u4e00-\u9fa5|0-9]*$/;
if(address==null||address==""||!reg.test(address)){
js3=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}



	//注册地 验证



var registAddress=document.getElementById('registAddress').value;

var obj=document.getElementById('mm5');
var reg=/^[a-zA-Z|\u4e00-\u9fa5|0-9]*$/;
if(registAddress==null||registAddress==""||!reg.test(registAddress)){
js5=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}

**/
  

	//邮政编码  验证



var postcode=document.getElementById('postcode').value;

var obj=document.getElementById('mm4');
var reg=/^(\d{6})$/;
if(postcode==null||postcode==""||!reg.test(postcode)){
js4=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}


  



	//从业人员总数   验证



var staff=document.getElementById('staff').value;

var obj=document.getElementById('mm13');
var reg=/^(\d*)$/;
if(staff==null||staff==""||!reg.test(staff)){
js13=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}


  


	//大专及以上毕业人数   验证



var colleageStaff=document.getElementById('colleageStaff').value;

var obj=document.getElementById('mm14');
var reg=/^(\d*)$/;
if(colleageStaff==null||colleageStaff==""||!reg.test(colleageStaff)){
js14=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}




	//技术人员数量   验证




var technicalStaff=document.getElementById('technicalStaff').value;

var obj=document.getElementById('mm15');
var reg=/^(\d*)$/;
if(technicalStaff==null||technicalStaff==""||!reg.test(technicalStaff)){
js15=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}


  


	//企业管理人员数量   验证



var manageStaff=document.getElementById('manageStaff').value;

var obj=document.getElementById('mm16');
var reg=/^(\d*)$/;
if(manageStaff==null||manageStaff==""||!reg.test(manageStaff)){
js16=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}
//注册资金 验证 

var registMoney=document.getElementById('registMoney').value;

var obj=document.getElementById('mm6');
 var reg = /^(\d{1,6}|\d{1,6}\.\d{1,3})$/;;//整数部分最多6位，最多三位小数  
if(registMoney==null||registMoney==""||!reg.test(registMoney)){
js10=false;
obj.innerHTML='<font color="red">格式不正确,请重新输入</font>';

}else{
jj=jj+1;
obj.innerHTML='<font color="#32CD32">格式正确</font>';

}



//js1&&js2&&js3&&js4&&js5&&js6&&js7&&js8&&js9&&js10&&js11&&js12&&js13&&js14&&js15&&js16
if(jj==9){

		document.forms[0].submit();
		
	}
	
}

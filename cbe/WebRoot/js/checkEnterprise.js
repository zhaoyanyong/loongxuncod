/*去左右空格**/
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/, "");
}

var flag1 = 0;// ipName合法标识
var flag2 = 0;// insCorporation合法标识
var flag3 = 0;// insPremiums
var flag4 = 0;// insAmount
var flag5 = 0;// incomeRatio
var flag6 = 0;// insPeriod
var flag7 = 0;// payYears
var flag8 = 0;// insContent
var flag9 = 0;// feeRate
var flag10 = 0;// discountFactor

var reg = /^(\d{1,6}|\d{1,6}\.\d{1,3})$/;;//整数部分最多6位，最多三位小数
var reg1 = /^(\d+)$/;;// 整数
var reg2 = /^[a-z0-9]{4,16}$/;// 字母数字

// 用户名提示
function tipUserName() {
	document.getElementById("info1").className = 'tip';
	document.getElementById("info1").innerHTML = '小写字母数字组成，4至16位';
}

// 用户名检查
function checkUserName() {
	var value = document.getElementById("username").value;
	if (trim(value) == '') {
		document.getElementById("info1").className = 'err';
		document.getElementById("info1").innerHTML = '用户名不能为空！';
		flag1 = 0;
	} else {
		if (!reg2.test(value)) {
			document.getElementById("info1").className = 'err';
			document.getElementById("info1").innerHTML = '小写字母数字组成，4至16位！';
			flag1 = 0;
		} else {
			uniqueName();
		}
	}
}

/* 惟一性验证 */
// 获取请求
function getXmlHttpRequest() {
	var xmlHttpRequest = null;
	if ((typeof XMLHttpRequest) != 'undefined') {
		// 非ie浏览器
		xmlHttpRequest = new XMLHttpRequest();
	} else {
		// ie浏览器
		xmlHttpRequest = new ActiveXObject('Microsoft.XMLHttp');
	}
	return xmlHttpRequest;
}
// 验证唯一性
function uniqueName() {
	var username = document.getElementById("username").value;
	var xmlReq = getXmlHttpRequest();
	var url = 'uniqueUserName';
	xmlReq.open('post', url, true);
	xmlReq
			.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
	xmlReq.onreadystatechange = function() {
		if (xmlReq.readyState == 4 && xmlReq.status == 200) {
			var respText = xmlReq.responseText;
			var jsonObj = eval('(' + respText + ')');
			var flag = jsonObj.flag;
			if (flag) {
				document.getElementById("info1").className = 'correct';
				document.getElementById("info1").innerHTML = '可用';
				flag1 = 1;
			} else {
				document.getElementById("info1").className = 'err';
				document.getElementById("info1").innerHTML = '企业用户名已存在！';
				flag1 = 0;
			}
		}
	}

	xmlReq.send('username=' + encodeURI(encodeURI(username)));
}
//密码
function tipPassword() {
	document.getElementById("info2").className = 'tip';
	document.getElementById("info2").innerHTML = '输入8-16位数字和大小写字母组合';
}
function tipPassword2() {
	document.getElementById("info3").className = 'tip';
	document.getElementById("info3").innerHTML = '再次输入密码';
}
function checknewPass() {
	var reg = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}/;
	var s = document.getElementById("password").value;
	var m = document.getElementById("pwd").value;
	if (!reg.test(document.getElementById("password").value)) {
		document.getElementById("info2").className = 'err';
		document.getElementById("info2").innerHTML = '输入8-16位数字和大小写字母组合';
	} else if (document.getElementById("pwd").value != '') {
		if (s != m) {
			document.getElementById("info2").className = 'err';
			document.getElementById("info2").innerHTML = '两次密码不一致,请重新输入。';
			document.getElementById("password").value = '';
			document.getElementById("pwd").value = '';
			document.getElementById("info3").innerHTML = '';
		}
	}
}
function checknewPass2() {
	var reg =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/;
	var s = document.getElementById("password").value;
	var m = document.getElementById("pwd").value;
	if (!reg.test(document.getElementById("pwd").value)) {
		document.getElementById("info3").className = 'err';
		document.getElementById("info3").innerHTML = '输入8-16位数字和大小写字母组合';
	} else if (s != m) {
		document.getElementById("info3").className = 'err';
		document.getElementById("info3").innerHTML = '两次密码不一致,请重新输入。';
		document.getElementById("pwd").value = '';
	}else{
		document.getElementById("info3").className = 'correct';
		document.getElementById("info3").innerHTML = '密码一致';
	}
}

// 机构代码
function tipOrgNo() {
	document.getElementById("info4").className = 'tip';
	document.getElementById("info4").innerHTML = '需输入10位，格式:XXXXXXXX-X！';
}

function checkOrgNo() {
	var r=/[A-Za-z0-9]{8}-[A-Za-z0-9]/g;
	var value = document.getElementById("orgNo").value;
	if (!r.test(value)) {
		document.getElementById("info4").className = 'err';
		document.getElementById("info4").innerHTML = '需输入10位，格式:XXXXXXXX-X！';
		flag2 = 0;
	} else {
		document.getElementById("info4").className = 'correct';
		document.getElementById("info4").innerHTML = '正确';
		flag2 = 1;
	}

}

// 注册资本
function checkRegistMoney() {
	var value = document.getElementById("registMoney").value;
		if (!reg.test(value)) {
			document.getElementById("info5").className = 'err';
			document.getElementById("info5").innerHTML = '1到6位整数，可带1到3位小数！';
			flag3 = 0;
		} else {
				document.getElementById("info5").className = 'correct';
				document.getElementById("info5").innerHTML = '';
				flag3 = 1;
			
		}
	
}


// 判空
function checkNull(id) {
	var value = document.getElementById(id).value;
	if (trim(value) == '') {
		document.getElementById(id+"info").className = 'err';
		document.getElementById(id+"info").innerHTML = '不能为空！';
		return false;
	} else{
		document.getElementById(id+"info").className = 'correct';
		document.getElementById(id+"info").innerHTML = '';
		return true;
	}
}
function lastname(filepath){  
   //为了避免转义反斜杠出问题，这里将对其进行转换  
   var re = /(\\+)/g;   
   var filename=filepath.replace(re,"#");  
   //对路径字符串进行剪切截取  
   var one=filename.split("#");  
   //获取数组中最后一个，即文件名  
   var two=one[one.length-1];  
   //再对文件名进行截取，以取得后缀名  
   var three=two.split(".");  
    //获取截取的最后一个字符串，即为后缀名  
   var last=three[three.length-1];  
   //添加需要判断的后缀名类型  
   var tp ="jpg,gif,bmp,JPG,GIF,BMP,png";  
   //返回符合条件的后缀名在字符串中的位置  
   var rs=tp.indexOf(last);  
   //如果返回的结果大于或等于0，说明包含允许上传的文件类型  
   if(rs!=-1){  
    return true;  
    }else{   
    //$('#subbutton').attr("disabled", "disabled");  
    return false;  
 }  
}


// 保存时check
function checkRegister() {
	var all=1;
	var imageLicense = document.getElementById("imageLicense").value;
	var imageTax = document.getElementById("imageTax").value;
	var imageOrgNo = document.getElementById("imageOrgNo").value;
	var t = lastname(imageLicense);
	var r = lastname(imageTax);
	var u = lastname(imageOrgNo);
	if(t&&r&&u){
	}else{
		alert("上传图片存在问题!");
		all=0;
	}
	checkUserName();
	checknewPass(); 
	checknewPass2();
	checkOrgNo();
	checkRegistMoney();
	checkNull('epname');
	//checkNull('address');
	checkNull('postcode');
//	checkNull('registAddress');
	checkNull('contacts');
	checkNull('contactPhone');
	checkNull('contactEmail');
	checkNull('legalPerson');
	checkNull('legalPhone');
	checkNull('legalEmail');
	checkNull('staff');
	checkNull('colleageStaff');
	checkNull('technicalStaff');
	checkNull('manageStaff');
	
	
	$("span").each(function(){
	    if(this.className=='err'){
	    	all=0;
	    }
	  });
	if (all==1) {
		
		if(confirm("确定保存信息吗？")){
			alert("保存信息成功！跳转到登陆页面！");
				document.getElementById("registerForm").submit();
				
		}
	} else {
		alert("请正确填写信息后再提交！");
		return false;
	}
}
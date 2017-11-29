<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <!--这是注册页面-->
  <body>
    <form action="userAction/addUserInfo.action" method="post" onSubmit="return check();">
     姓名 usersname:<input type="text" name="usersName"id="#in1A"/><div id="#in1a"></div>
     密码 userspwd:<input type="text" name="usersPwd"id="#in1B"/><div id="#in1b"></div>
     性别sex:<input type="text" name="sex"id="#in1D"/><div id="#in1d"></div>
     年龄age:<input type="text" name="age"id="#in1C"/><div id="#in1c"></div>
     请输入邮箱：<input type="text" name="emilName" id="inC" ></br><div id="inc"></div>
     电话tellphonenum:<input type="text" name="tellphoneNum" id="#in1E"/><div id="#in1e"></div>
      <input type="submit" value="注册" id="#kj"/>
    </form>
  </body>

</html>
<script>
var inputA = document.getElementById("#in1A");
var ida = document.getElementById("#in1a");
var inputB = document.getElementById("#in1B");
var idb = document.getElementById("#in1b");
var inputC = document.getElementById("#in1C");
var idc = document.getElementById("#in1c");
var inputD = document.getElementById("#in1D");
var idd = document.getElementById("#in1d");
var inputE = document.getElementById("#in1E");
var ide = document.getElementById("#in1e");
var sub = document.getElementById("#kj");
inC.onblur = function checkname(){
var reg=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	if(reg.test(inC.value)==false){
	inc.innerHTML="不符邮箱合格式要求";
	inC.focus();   
	}else{
	inc.innerHTML="";
	}
}
function check(){
if(inputA.value==""||inputB.value==""||inputC.value==""||inputD.value==""||inputE.value==""){
 return false;
}else{
 return true;
}
}
inputA.onblur = function checknamelength(){
               if(inputA.value.length<3||inputA.value.length>=8) {
               ida.innerHTML="长度必须大于3小于8";
               sub.style.display="none";
               inputA.focus();
               }
               else{ida.innerHTML="";
               sub.style.display="";}
}
inputB.onblur = function checkPwd() {
	var reg=/^(\w){6,20}$/;
	if(reg.test(inputB.value)==false){
	idb.innerHTML="不符合格式要求";
	sub.style.display="none";
	inputB.focus();
	}else{
	idb.innerHTML="";
	sub.style.display="";
	}
}
inputC.onblur = function checkAge() {
	var reg= /^(1[6-9]|[2-9][0-9])$/;
	if(reg.test(inputC.value)==false){
	idc.innerHTML="不符合格式要求";
	sub.style.display="none";
	inputC.focus();
	}else{
	idc.innerHTML="";
	sub.style.display="";
	}
}
inputD.onblur = function checkSex() {
	if(inputD.value=="男"||inputD.value=="女"){
	idd.innerHTML="";
	sub.style.display="";
	}else{
	idd.innerHTML="不符合格式要求";
	sub.style.display="none";
	inputD.focus();	
	}
}
inputE.onblur = function isTelCode() {
	var reg= /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
	if(reg.test(inputE.value)==false){
	ide.innerHTML="不符合格式要求";
	sub.style.display="none";
	inputE.focus();
	}else{
	ide.innerHTML="";
	sub.style.display="";
	}
}

 
</script>
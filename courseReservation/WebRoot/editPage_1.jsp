<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editPage_1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   ${userEdit.toString()}<br>
   ${users.id}
        用户资料编辑
   <form action="userAction/editPageAfter.action" method="post">
   <input type="hidden" name="id" value="${userEdit.id}">
   姓名<input type="text" name="usersName" value="${userEdit.usersName}" id="#in1A"/><div id="#in1a"></div>
   密码<input type="password" name="usersPwd" value="${userEdit.usersPwd}" id="#in1B"/><div id="#in1b"></div>
   年龄 <input type="text" name="age" value="${userEdit.age}" id="#in1C"/><div id="#in1c"></div>
   性别  <input type="text" name="sex" value="${userEdit.sex}" id="#in1D"/><div id="#in1d"></div>
   电话号码 <input type="text" name="tellphoneNum" value="${userEdit.tellphoneNum}" id="#in1E"/><div id="#in1e"></div>
   <input type="submit" value="保存"/> 
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
inputA.onblur = function checknamelength(){
               if(inputA.value.length<3||inputA.value.length>=8) {
               ida.innerHTML="长度必须大于3小于8";
               inputA.focus();
               }
               else{ida.innerHTML=""}
}
inputB.onblur = function checkPwd() {
	var reg=/^(\w){6,20}$/;
	if(reg.test(inputB.value)==false){
	idb.innerHTML="不符合格式要求";
	inputB.focus();
	}else{
	idb.innerHTML="";
	}
}
inputC.onblur = function checkAge() {
	var reg= /^(1[6-9]|[2-9][0-9])$/;
	if(reg.test(inputC.value)==false){
	idc.innerHTML="不符合格式要求";
	inputC.focus();
	}else{
	idc.innerHTML="";
	}
}
inputD.onblur = function checkSex() {
	if(inputD.value!="男"||inputD.value!="男"){
	idd.innerHTML="不符合格式要求";
	inputD.focus();
	}else{
	idd.innerHTML="";
	}
}
inputE.onblur = function isTelCode() {
	var reg= /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
	if(reg.test(inputE.value)==false){
	ide.innerHTML="不符合格式要求";
	inputE.focus();
	}else{
	ide.innerHTML="";
	}
}

 
</script>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language = "javascript" src = "code.js"></script>     
	<script language = "javascript" src = "js/jquery-1.8.3.js"></script>   
    <link rel="stylesheet" type="text/css" href="code.css">  
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style>
  .code{      
background-image:url(w1.jpg);      
font-family:Arial;      
font-style:italic;      
color:Red;      
border:0;      
padding:2px 3px;      
letter-spacing:3px;      
font-weight:bolder;      
}       
  
  </style>
  <body onload="createCode();">
   忘记密码<br><br>
    <form action="userAction/userUpdatePwd.action" method="post" onSubmit="return check();" id="myform">
           账号<input type="text" name="id" id="inA" ><div id="ina"></div><br>
           输入邮箱验证码：<input type="text" name="id" id="inD" ><button id="btn">点击发送验证码</button><br><br>
           密码<input type="password" name="usersPwd" id="inB" ><div id="inb"></div>            
           <br>验证码：<input type="text" id="input1" />      
           <input type="text" id="checkCode" class="code" style="width: 55px" /> <a href="#" onclick="createCode()">看不清楚</a>                 
           <input type="submit" value="提交" id="Button1"/>
    </form>
  </body>
</html>
<script type="text/javascript">

var code ; //在全局 定义验证码      
var inA= document.getElementById("inA");
var ina= document.getElementById("ina");
var inB= document.getElementById("inB");
var ina= document.getElementById("ina");
var input1= document.getElementById("input1");
var btn = document.getElementById("btn");
var but = document.getElementById("Button1");
var count = 5;
var timer= null;
function check(){
if(inA.value==""||inB.value==""||input1.value==""||inD.value==""){
 return false;
}else{
 return validate ();
}

}
            btn.onclick = function () {
            $.ajax({
			 type : "post",
			 url : 'userAction/pastMailcode.action?id='+$('#inA').val(),
			 async:true,
			 contentType: "application/json;charset=utf-8",
			 success : function(msg){
			 alert(msg);		 
			 }			 
		  });
                clearInterval(timer);
                this.disabled = true;
                var that = this;
                timer = setInterval(sendTextMessage,1000);//名字timer
                function sendTextMessage() {
                    count--;
                    if(count>=0){
                        that.innerHTML = "还剩余" + count +"秒";
                    }else{
                        that.innerHTML = "重新发送短信";
                        that.disabled =false;
                        clearInterval(timer);
                        count = 5;
                    }

                }}
            

inA.onblur = function checkname(){
if(inA.value==""){
  inA.focus(); }else{
	$(function(){
	var data ={usersName: inA.value,id: inB.value};
          $.ajax({
			 type : "post",
			 url : 'userAction/userAjaxId.action?id='+$('#inA').val(),
			 async:true,
			 contentType: "application/json;charset=utf-8",
			 success : function(msg){
			 alert(msg);
			 if(msg.length>5){
			 inA.value="";
			 }	 
			 }			 
		  });

		});
  }
}
inB.onblur = function checkname(){
if(inB.value=="")
  inB.focus(); 
}

inD.onblur = function checkname(){
if(inD.value=="")
{inD.focus();}else{
$.ajax({
			 type : "post",
			 url : 'userAction/equalEmilCode.action?emilCode='+$('#inD').val()+'&id='+$('#inA').val(),
			 async:true,
			 contentType: "application/json;charset=utf-8",
			 success : function(data){
			 alert(data);
			 if(data.length>6)	{
			 inD.value="";
			 }	 
			 }			 
		  });


}
  
}
inB.onblur = function checkname(){
if(inB.value=="")
  inB.focus(); 
}
input1.onblur = function checkname(){
if(input1.value=="")
  input1.focus(); 
}
function createCode(){       
code = "";      
var codeLength = 4;//验证码的长度      
var checkCode = document.getElementById("checkCode");      
checkCode.value = "";      
var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');      
      
for(var i=0;i<codeLength;i++) {      
   var charIndex = Math.floor(Math.random()*60);      
  code +=selectChar[charIndex];      
}      
if(code.length != codeLength){      
  createCode();      
}      
checkCode.value = code;      
}      
      
     
function validate () {      
var inputCode = document.getElementById("input1").value.toUpperCase();      
var codeToUp=code.toUpperCase();  
if(inputCode.length <=0) {      
  alert("请输入验证码！");      
  return false;      
}      
else if(inputCode != codeToUp ){      
   alert("验证码输入错误！");      
   createCode();      
   return false;      
}      
else {      
  alert("输入正确，输入的验证码为："+inputCode);      
  return true;      
}      
      
}         
</script>
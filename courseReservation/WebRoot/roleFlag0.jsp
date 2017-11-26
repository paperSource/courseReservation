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
    
    <title>My JSP 'roleFlag0.jsp' starting page</title>
    
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
        我是超级管理员${stId.usersName}<br><br><br>
        <form action="userAction/insertAdmin.action" method="post">
                添加管理员
                用户名<input type="text" name="usersName">
                登录密码<input type="password" name="usersPwd">
                <input type="submit" value="添加"> 
        </form>
        
        用户信息 <c:forEach items="${usersList}" var="usersL">
        <c:if test="${usersL.usersState==1}">
        <table>
	         <tr>
	               <td height="43">${usersL.id}</td>
		           <td height="43">${usersL.usersName}</td>		           
		           <td><a href="userAction/editPageBefor.action?id=${usersL.id}">编辑</a></td>
		           <td><a href="userAction/delectPageBefor.action?id=${usersL.id}">删除</a></td>
		           <td><a href="vsThemeAction/findThemeByIdOne.action?id=${usersL.id}"></a></td>
		           <td><a href="#">其他</a></td>
           </tr>
        </table>
        </c:if>
         <c:if test="${usersL.usersState==0}">
         <table>
	         <tr>
	               <td height="43">${usersL.id}</td>
		           <td height="43">${usersL.usersName}</td>		           
		           <td><a href="vsThemeAction/findThemeById.action?questionId=${usersL.id}">编辑</a></td>
		           <td><a href="vsThemeAction/delectTheme.action?questionId=${usersL.id}">删除</a></td>
		           <td><a href="vsThemeAction/findThemeByIdOne.action?questionId=${usersL.id}">发布</a></td>
		           <td><a href="#">其他</a></td>
           </tr>
         </c:if>      
	     </c:forEach>
        
  </body>
</html>

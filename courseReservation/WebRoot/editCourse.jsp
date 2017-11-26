<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editUser.jsp' starting page</title>
    
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
    编辑用户
    <form action="courseAction/updateCourse.action" method="post">
       <input type="hidden" name="id" value="${courseInfo.id }">
       <input type="text" name="courseTitle" value="${courseInfo.courseTitle }"/>
       <input type="text" name="classHour" value="${courseInfo.classHour }"/>
       <input type="text" name="teacherName" value="${courseInfo.teacherName }"/>
       <input type="text" name="classify" value="${courseInfo.classify }"/>
       <input type="text" name="classifyNo" value="${courseInfo.classifyNo }"/>
       <input type="submit" value="保存"/>
    </form>
  </body>
</html>

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
    
    <title>My JSP 'shouye.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery-1.9.1.min.js" type="text/javascript" /></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script>
  	function search(){
  		var key = document.getElementById("keyword").value;
  		alert(key);
  		window.location.href ="<%=basePath%>/courseAction/findCourseByName.action?courseTitle="+key;
  	}
  </script>
  </head>
  
  <body>
  	<table border="1">
  		<tr>
  		   <td><input type="text" name="keyword" id="keyword"></td>
           <td><h3 onclick = "search()">检索</h3></td>
  		</tr>
  	</table>
    <table border="1">
     <tr>
        <td>id</td>
         <td>courseTitle</td>
         <td>classHour</td>
         <td>teacherName</td>
         <td>classify</td>
         <td>classifyNo</td>
         <td>编辑</td>
         <td>删除</td>
         
     </tr>
    
	     <c:forEach items="${courseList }" var="courseList">
	         <tr>
		           <td>${courseList.id }</td>
		           <td>${courseList.courseTitle }</td>
		           <td>${courseList.classHour }</td>
		           <td>${courseList.teacherName }</td>
		           <td>${courseList.classify }</td>
		           <td>${courseList.classifyNo }</td>
		           <td><a href="courseAction/findCourseById.action?id=${courseList.id }">编辑</a></td>
                   <td><a href="courseAction/deleteCourseById.action?id=${courseList.id }">删除</a></td>
	         </tr>
	     </c:forEach>
      </table>
  </body>
</html>

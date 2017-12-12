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
	<link rel="stylesheet" type="text/css" href="./laypage/skin/laypage.css" />
	<script src="./js/jquery-1.9.1.js" type="text/javascript" /></script>
	<script type="text/javascript" src="./laypage/laypage.js"></script>
  <script type="text/javascript">
  	var curr = 1;
  	var pageSize = 10;
  	var genre="教育";
	$(function(){
  		$('.btn').click(function(){
  	      genre = $(this).attr('data');
  	      ResultList(curr,genre);
  	  	});
  	});
  	
	window.onload = function() {
		ResultList(curr,"教育");//直接执行onclick中的函数就行
	}
	
  	function ResultList(curr,genre){
  		var content='';
  		$.ajax({
  			type:"post",
  			url:"/courseReservation/courseAction/findCourseAll.action",
  			dateType:"json",
  			data:{pageSize:pageSize,pageNo:curr,genre:genre},
  			async:false,
  			success : function(data){
  				if(data.result == "error"){
  					content='<td>暂无数据</td>';
  					$("#listaa").html("");
  					$("#listaa").append(content);
  				}
  				var list = data.data;
  				var count = data.count;
  				var totalPage = data.totalPage;
  					content='';
  					content+='<table>';
  					content+='<tr>';
  					content+='<td>id</td>';
  			      	content+='<td>courseTitle</td>';
  			      	content+='<td>courseIntroduction</td>';
  			       	content+='<td>classHour</td>';
  			       	content+='<td>teacherName</td>';
  			       	content+='<td>teacherIntroduction</td>';
  			       	content+='<td>classify</td>';
  			       	content+='<td>编辑</td>';
  			       	content+='<td>删除</td>';
  			        content+='</tr>';
  			        var minNum = (curr - 1) * pageSize;
  			        var maxNum = curr * pageSize;
  			        if(maxNum>count){
  			        	maxNum = count;
  			        }
  				for(var i = minNum; i < maxNum; i++){
  					var item=list[i];
  					content+='<tr>';
  					content+='<td>'+item.id+'</td>';
  					content+='<td>'+item.courseTitle+'</td>';
  					content+='<td>'+item.courseIntroduction+'</td>';
  					content+='<td>'+item.classHour+'</td>';
  					content+='<td>'+item.teacherName+'</td>';
  					content+='<td>'+item.teacherIntroduction+'</td>';
  					content+='<td>'+item.classify+'</td>';
  					content+='<td><a href="courseAction/findCourseById.action?id='+item.id+'">编辑</a></td>';
  					content+='<td><a href="courseAction/deleteCourseById.action?id='+item.id+'">删除</a></td>';
  					content+='</tr>';
  				}
  				content+='</table>';
  				$("#listaa").html("");
				$("#listaa").append(content);
				laypage({
        			cont : document.getElementById('page'), //容器。值支持id名、原生dom对象，jquery对象,
        			pages : totalPage, //总页数
        			skip : true, //是否开启跳页
        			skin : 'molv', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
        			curr: curr || 1,
        			groups : 6,//连续显示分页数
        			jump : function(obj, first) { //触发分页后的回调
        				if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
        					ResultList(obj.curr,genre);
        					var curr = obj.curr;
        					curr=obj.curr;
        				}
        			}
        		}); 
  			},
  			error : function(data) {
  			content='<td>暂无数据</td>';
			$("#listaa").html("");
			$("#listaa").append(content);
		}
  		});
  	}
  	
  	
  	function search(){
  		var key = document.getElementById("keyword").value;
  		var curr = 1;
  		<%-- window.location.href ="<%=basePath%>/courseAction/findCourseByName.action?courseTitle="+key; --%>
  		ResultListByName(curr,key);
  	}
  	
  	function ResultListByName(curr,key){
  		var content='';
  		$.ajax({
  			type:"post",
  			url:"/courseReservation/courseAction/findCourseByName.action",
  			dateType:"json",
  			data:{pageSize:10,pageNo:curr,key:key},
  			async:false,
  			success : function(data){
  				if(data.result == "error"){
  					content='<td>暂无数据</td>';
  					$("#listaa").html("");
  					$("#listaa").append(content);
  				}
  				var list = data.data;
  				var count = data.count;
  				alert(count);
  				var totalPage = data.totalPage;
  					content='';
  					content+='<table>';
  					content+='<tr>';
  					content+='<td>id</td>';
  			      	content+='<td>courseTitle</td>';
  			      	content+='<td>courseIntroduction</td>';
  			       	content+='<td>classHour</td>';
  			       	content+='<td>teacherName</td>';
  			       	content+='<td>teacherIntroduction</td>';
  			       	content+='<td>classify</td>';
  			       	content+='<td>编辑</td>';
  			       	content+='<td>删除</td>';
  			        content+='</tr>';
  			        var minNum = (curr - 1) * pageSize;
  			        var maxNum = curr * pageSize;
  			      	if(maxNum>count){
			        	maxNum = count;
			        }
  				for(var i = minNum; i < maxNum; i++){
  					var item=list[i];
  					content+='<tr>';
  					content+='<td>'+item.id+'</td>';
  					content+='<td>'+item.courseTitle+'</td>';
  					content+='<td>'+item.courseIntroduction+'</td>';
  					content+='<td>'+item.classHour+'</td>';
  					content+='<td>'+item.teacherName+'</td>';
  					content+='<td>'+item.teacherIntroduction+'</td>';
  					content+='<td>'+item.classify+'</td>';
  					content+='<td><a href="courseAction/findCourseById.action?id='+item.id+'">编辑</a></td>';
  					content+='<td><a href="courseAction/deleteCourseById.action?id='+item.id+'">删除</a></td>';
  					content+='</tr>';
  				}
  				content+='</table>';
  				$("#listaa").html("");
				$("#listaa").append(content);
				laypage({
        			cont : document.getElementById('page'), //容器。值支持id名、原生dom对象，jquery对象,
        			pages : totalPage, //总页数
        			skip : true, //是否开启跳页
        			skin : 'molv', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
        			curr: curr || 1,
        			groups : 6,//连续显示分页数
        			jump : function(obj, first) { //触发分页后的回调
        				if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
        					ResultListByName(obj.curr,key);
        					var curr = obj.curr;
        					curr=obj.curr;
        				}
        			}
        		}); 
  			},
  			error : function(data) {
  			content='<td>暂无数据</td>';
			$("#listaa").html("");
			$("#listaa").append(content);
		}
  		});
  	}
  	
  </script>
  </head>
  
  <body>
	 用户Id：${stId.id}
 	 用户名：${stId.usersName}
 	<button class="btn" data="教育">教育</button>
	<button class="btn" data="智力">智力</button>
	<button class="btn" data="情商">情商</button>
	<button class="btn" data="运动">运动</button>
  <div style="border=1px;">
  	<div>
  	<table border="1">
  		<tr>
  		   <td><input type="text" name="keyword" id="keyword"></td>
           <td><h3 onclick = "search()">检索</h3></td>
  		</tr>
  	</table>
  	</div>
  	<div id="listaa">
    <table>
	     <tr>
	        <td>id</td>
	         <td>courseTitle</td>
	         <td>courseIntroduction</td>
	         <td>classHour</td>
	         <td>teacherName</td>
	         <td>teacherIntroduction</td>
	         <td>classify</td>
	         <td>classifyNo</td>
	         <td>编辑</td>
	         <td>删除</td>
	     </tr>
	     <tr>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	        <td></td>
	     </tr>
     </table>
      </div>
      <div id="page">111111111</div>
      <div><a href="pages/selectCourse/selectCourse.jsp">选课</a></div>
      </div>
  </body>
</html>

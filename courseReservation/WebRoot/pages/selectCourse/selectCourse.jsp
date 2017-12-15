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
	<script src="./js/jquery-1.9.1.min.js" type="text/javascript" /></script>
	<!-- <script src="./js/jquery-1.9.1.js" type="text/javascript" /></script> -->
	<script type="text/javascript" src="./laypage/laypage.js"></script>
  <script type="text/javascript">
  
  	var curr = 1;
  	var pageSize = 10;
  	var genre="";
  	/* ResultList(curr,genre); */
  	$(function(){
  		
  		$('.btn').click(function(){
  	      genre = $(this).attr('data');
  	      ResultList(curr,genre);
  	  	});
  		
  	});
  	
  	
  	
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
  					$("#page").html("");
  					$("#listaa").append(content);
  				}
  				var list = data.data;
  				var count = data.count;
  				var totalPage = data.totalPage;
  					content='';
  			        var minNum = (curr - 1) * pageSize;
  			        var maxNum = curr * pageSize;
  			        if(maxNum>count){
  			        	maxNum = count;
  			        }
  				for(var i = minNum; i < maxNum; i++){
  					content+='<form action="/courseReservation/selectionResultsAction/addSelectionResults.action" type="post" onsubmit="return verify()">';
  					var item=list[i];
  					content+='<div><input type="text" name="courseId" value='+item.id+'></div>';
  					content+='<div><input type="text" name="courseTitle" value='+item.courseTitle+'></div>';
  					content+='<div><input type="text" name="courseIntroduction" value='+item.courseIntroduction+'></div>';
  					content+='<div><input type="text" name="classHour" value='+item.classHour+'></div>';
  					content+='<div><input type="text" name="teacherName" value='+item.teacherName+'></div>';
  					content+='<div><input type="text" name="teacherIntroduction" value='+item.teacherIntroduction+'></div>';
  					content+='<div><input type="text" name="classify" value='+item.classify+'></div>';
  					content+='<div><input type="submit" value="预约"></div>';
  					content+='</form>';
  				}
  				
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
			$("#page").html("");
			$("#listaa").append(content);
		}
  		});
  	}
  	
  	function verify(){
  		$.ajax({
  			type:"post",
  			url:"/courseReservation/selectionResultsAction/getDataCount.action",
  			dateType:"json",
  			data:{pageSize:pageSize,pageNo:curr,genre:genre},
  			async:false,
  			success : function(data){
  				var userName = data.userName;
  				if(userName=="" || userName==null || userName==undefined){
  					alert("亲，登录后才能选课！");
  					return false;
  				}else{
  					var count = data.count;
  					if(count>=3){
  	  					alert("已选过3门课程，不能再次选择");
  	  					return false;
  	  				}else{
  	  					return true;
  	  				}
  				}
  				
  			},
  			error : function(data) {
  				content='<td>暂无数据</td>';
  				$("#listaa").html("");
  				$("#page").html("");
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
		<div><a href="pages/selectCourse/personalResult.jsp">我的选课</a></div>
  <div style="border=1px;">
  	
  	<div id="listaa">
  	
	        <div>id</div>
	         <div>courseTitle</div>
	         <div>courseIntroduction</div>
	         <div>classHour</div>
	         <div>teacherName</div>
	         <div>teacherIntroduction</div>
	         <div>classify</div>
	         <div>classifyNo</div>
	         <div>预约</div>
	  <form>
	        <div></div>
	        <div></div>
	        <div></div>
	        <div></div>
	        <div></div>
	        <div></div>
	        <div></div></br>
     </form>
      </div>
      <div id="page">111111111</div>
      </div>
  </body>
</html>

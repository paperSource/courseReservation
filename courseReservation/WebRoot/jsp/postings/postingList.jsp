<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>选课交流中心</title>
  	<link rel="stylesheet" href="<%=basePath%>css/posting/posting_main.css" type="text/css"></link>
  	<link rel="stylesheet" href="<%=basePath%>laypage/skin/laypage.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=basePath%>laypage/laypage.js"></script>
  	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
  </head>
<body>
<table border="0" width="100%">
	<tr>
		<td>
			<table style="line-height: 30px;" border="0" id="topic_list" width="100%" cellspacing="0"></table>
		</td>
	</tr>
	<tr>
		<td height="50">
			<div id="pageTurn" style="text-align: center;"></div>
		</td>
	</tr>
</table>
</body>
<script type="text/javascript">
	function formatDate(now) { 
		var year=now.getFullYear(); 
		var month=now.getMonth()+1; 
		var date=now.getDate(); 
		var hour=now.getHours()< 10 ? "0" + now.getHours() : now.getHours(); 
		var minute=now.getMinutes()< 10 ? "0" + now.getMinutes() : now.getMinutes(); 
		var sdate = new Date();
		var sys_year = sdate.getFullYear();
		var sys_month=sdate.getMonth() + 1; 
		var sys_date=sdate.getDate(); 
		var sys_hour=sdate.getHours()< 10 ? "0" + sdate.getHours() : sdate.getHours(); 
		var sys_minute=sdate.getMinutes()< 10 ? "0" + sdate.getMinutes() : sdate.getMinutes();
		if(year==sys_year){
			if(month==sys_month){
				if(date==sys_date){
					return hour+":"+minute;
				}else{
					return month+"-"+date;
				}
			}else{
				return month+"-"+date; 
			}
		}else{
			return year+"-"+month+"-"+date;
		}
	}
	function t_click(id){
		
	} 
</script>
<script type="text/javascript">
	$.getJSON('<%=basePath%>topicAction/query.action', {      
  	 	page:"1",      
  	 	num:"15"      
  	},function (res) {
		laypage({
	     	cont: 'pageTurn',    
	        pages: Math.ceil(res.total/15), //总页数    
	        totalData:res.total,//总数据量  
	        curr: 1,  
	        skin: 'molv', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00    
	        groups: 7 ,//连续显示分页数    
	        skip: true, //是否开启跳页    
	        prev: '<', //若不显示，设置false即可    
	        next: '>', //若不显示，设置false即可    
	        jump: function(e){ //触发分页后的回调    
	  			$.getJSON('<%=basePath%>topicAction/query.action', {      
	  					  page:e.curr,      
	  					  num:"15"      
	  			}, function (res) {
					$("#topic_list").empty();
					var topicList = res.topicList;
					var str = "";
					for(var topic in topicList){
						str = "<tr><td class='topic_title'><a class='t_title' href='###' onclick='t_click("+topicList[topic].id+")'>" + topicList[topic].title +"</a></td><td class='topic_staUsers'>" + topicList[topic].staUsers.usersName + "</td><td class='topic_date'>" + formatDate(new Date(topicList[topic].date)) +"</td></tr>";
						$("#topic_list").append(str);
					}
	  			});     
	        }    
		});
	})
</script>
</html>
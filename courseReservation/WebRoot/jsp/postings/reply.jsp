<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String topicId = request.getParameter("topicId");
//String topicId = "36";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>选课交流中心</title>
    <link rel="stylesheet" href="<%=basePath%>laypage/skin/laypage.css" type="text/css"></link>
    <link rel="stylesheet" href="<%=basePath%>css/posting/detail.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=basePath%>laypage/laypage.js"></script>
  	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function returnValue(replyList,user) {
		var str = "<table width='100%' cellspacing='0' class='post_topic'><tr><td class='userinfo_td'>";
		str=str+"<dl class='user_info'><dt class='user_head'><a href='###'>";
		str=str+"<img src='<%=basePath%>img/touxiang.jpg' class='avater' height='50px' width='50px' border='1'></img></a>";
		str=str+"</dt><dd class='username'><a href='###'>"+replyList.replyUser.usersName+"</a></dd></dl></td>";
		str=str+"<td height='100%' class='content_td'><table border='0' style='height: 100%;width: 100%;' cellspacing='0'>";
		str=str+"<tr style='height: 85%;'><td style='border-bottom: 1px solid #A9CBEE;'>";
		str=str+"<div class='post_body'>"+replyList.content+"</div></td></tr>";
		str=str+"<tr style='height: 15%;'><td style='background-color: #EFF4FB;'><div class='p_date'>";
		str=str+"<span>回复时间:"+formatDate(replyList.date)+"</span>";
		str=str+"</div><div class='p_button'><a href='###' onclick='addFlowers("+replyList.id+")'><img src='<%=basePath%>img/flows.ico' class='flows'/>送花[<span id='flowers_"+replyList.id+"'>"+replyList.flowers+"</span>]</a><a href='###' onclick='addEggs("+replyList.id+")'><img src='<%=basePath%>img/eggs.ico' class='eggs'/>扔蛋[<span id='eggs_"+replyList.id+"'>"+replyList.eggs+"</span>]</a>";
		if(user!=null){
			if(replyList.replyID == user.id){
				str=str+"<a href='###' onclick='deleteReply("+replyList.id+")'><span>删除</span></a>";
			}
		}
		str=str+"</div></td></tr></table></td></tr></table>";
		return str;
	}
	function formatDate(time) {
		var now = new Date(time); 
		var year=now.getFullYear(); 
		var month=now.getMonth()+1; 
		var date=now.getDate(); 
		var hour=now.getHours()< 10 ? "0" + now.getHours() : now.getHours(); 
		var minute=now.getMinutes()< 10 ? "0" + now.getMinutes() : now.getMinutes(); 
		return year+"-"+month+"-"+date+" "+hour+":"+minute;
	}
</script>
<script type="text/javascript">
	var addFlows = [];//记录送花标记
	var eggs = [];//丢蛋标记
	function deleteReply(rid){
		if (!confirm("确认要删除吗？")){
			return false;
		}
		$.ajax({
  				type:"post",
				url:"<%=basePath%>replyAction/deleteReply.action",
				data:{"replyId":rid},
				dataType:"text",
				success:function(data){
					alert(data);
					if(data == "删除成功"){
						location.reload();
					}
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
            	},
  			
  			})
	}
	function addFlowers(rid){
		var objs = eval(addFlows);
		for(var i = 0;i<objs.length;i++){
   			if(objs[i].replyId == rid){
   				alert("您已经送过花了");
   				return false;
   			}
  		}
		$.ajax({
  				type:"post",
				url:"<%=basePath%>replyAction/addFlowers.action",
				data:{"replyId":rid},
				dataType:"text",
				success:function(data){
					$("#flowers_"+rid).html(data);
					var row = {};
					row.replyId= rid;
					row.addTab = "1";
					addFlows.push(row);
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
            	},
  			
  			})
  			
	}
	function addEggs(rid){
		var objs = eval(eggs);
		for(var i = 0;i<objs.length;i++){
   			if(objs[i].replyId == rid){
   				alert("您已经扔过蛋了");
   				return false;
   			}
  		}
		$.ajax({
  				type:"post",
				url:"<%=basePath%>replyAction/addEggs.action",
				data:{"replyId":rid},
				dataType:"text",
				success:function(data){
					$("#eggs_"+rid).html(data);
					var row = {};
					row.replyId= rid;
					row.addTab = "1";
					eggs.push(row);
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
            	},
  			
  			})
  			
	}
</script>
  </head>
  <body>
    	<div id="rc"></div>
    	<div id="pageTurn" style="text-align: center; "></div>
  </body>
  <script type="text/javascript">
	$.getJSON('<%=basePath%>replyAction/query.action', {      
  	 	page:parent.pagetemp>0?parent.pagetemp:1,      
  	 	num:"15",
  	 	topicID:'<%=topicId%>'   
  	},function (res) {
		laypage({
	     	cont: 'pageTurn',    
	        pages: Math.ceil(res.total/15), //总页数    
	        totalData:res.total,//总数据量  
	        curr: parent.pagetemp>0?parent.pagetemp:1,  
	        skin: 'molv', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00    
	        groups: 7 ,//连续显示分页数    
	        skip: true, //是否开启跳页    
	        prev: '<', //若不显示，设置false即可    
	        next: '>', //若不显示，设置false即可    
	        jump: function(e){ //触发分页后的回调    
	  			$.getJSON('<%=basePath%>replyAction/query.action', {      
	  					  page:e.curr,      
	  					  num:"15",
	  					  topicID:'<%=topicId%>'     
	  			}, function (res) {
					$("#rc").empty();
					var replyList = res.replyList;
					var user = res.user;
					for(var reply in replyList){
						$("#rc").append(returnValue(replyList[reply],user));
					}
					parent.document.getElementById("reply_List").height=$("#rc").height()+50;
	  			});
	  			parent.pagetemp=e.curr;
	        }    
		});
	})
  </script>
</html>

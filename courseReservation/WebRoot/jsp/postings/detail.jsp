<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>选课交流中心</title>
    <link rel="stylesheet" href="<%=basePath%>editor/themes/default/default.css" type="text/css"></link>
  	<link rel="stylesheet" href="<%=basePath%>css/posting/detail.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=basePath%>editor/kindeditor-all.js"></script>
  	<script type="text/javascript" src="<%=basePath%>editor/lang/zh-CN.js"></script>
  	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
  	<script type="text/javascript">
  		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="reply_content"]', {
				cssPath : 'editor/plugins/code/prettify.css',
				resizeType:1,
				allowPreviewEmoticons: false,
                allowImageUpload:true,//允许上传图片
                allowFileManager:true, //允许对上传图片进行管理
                uploadJson:'<%=basePath%>jsp/upload_json.jsp', 
                fileManagerJson:'<%=basePath%>jsp/file_manager_json.jsp',
                afterUpload: function(){this.sync();}, //图片上传后，将上传内容同步到textarea中
                afterBlur: function(){this.sync();},   ////失去焦点时，将上传内容同步到textarea中
                items : [
                    'fontname','fontsize', '|','forecolor', 'hilitecolor','bold', 'italic','underline',
                    'removeformat','|', 'justifyleft','justifycenter', 'justifyright','insertorderedlist',
                    'insertunorderedlist','|', 'emoticons','link','media','|','image'],
			});
			prettyPrint();
		});
  	</script>
  </head>
  
  <body style="width: 1000px;">
  	<div id="top"></div>
  	<div id="content">
  		<div id="t_title">
  			<span>${topic.title }</span>
  		</div>
  		<div style="width: 100%;">
  		<table width="100%" cellspacing="0" class="post_topic">
  			<tr>
  				<td class="userinfo_td">
  					<dl class="user_info">
  						<dt class="user_head">
  							<a href="###">
  								<img src="<%=basePath%>img/touxiang.jpg" class="avater" height="50px" width="50px" border="1"></img>
  							</a>
  						</dt>
  						<dd class="username">
  							<a href="###">${topic.staUsers.usersName }</a>
  						</dd>
  					</dl>
  				</td>
  				<td height="100%" class="content_td">
  					<table border="0" style="height: 100%;width: 100%;" cellspacing="0">
  						<tr style="height: 85%;">
  							<td style="border-bottom: 1px solid #A9CBEE;">
  								<div class="post_body">${topic.content }</div>
  							</td>
  						</tr>
  						<tr style="height: 15%;">
  							<td style="background-color: #EFF4FB;">
  								<div class="p_date">
  									<span>发帖时间:<fmt:formatDate type="both" value="${topic.date}"/></span>
  								</div>
  								<div class="p_button">
  									<a href="###" onclick="addUpvote(${topic.id})">
  										<img src="<%=basePath%>img/prasie.png"/>点赞[<span id="upvote">${topic.upvote }</span>]
  									</a>
  									<c:if test="${delPermission==1 }">
  										<a href="###" onclick="deleteTopic(${topic.id})">
  											<span>删除</span>
  										</a>
  									</c:if>
  								</div>
  							</td>
  						</tr>
  					</table>
  				</td>
  			</tr>
  		</table>
  		<iframe frameborder=0 src="<%=basePath%>jsp/postings/reply.jsp?topicId=${topic.id}" name="reply_List" width="100%" id="reply_List"></iframe>
  	</div>
  	</div>
  	<div id="posting">
    	<form action="${pageContext.request.contextPath }/replyAction/addReply.action" method="post" id="reply_form">
    		<div id="p_content">
				<textarea id="editor_id" name="reply_content" style="width:920px;height:300px;"></textarea> 
    		</div>
    		<div id="p_button">
    			<a href="###" onclick="sumbit()"><span id="p_span">回复</span></a>
    		</div>
  		</form>
    </div>
  </body>
  <script type="text/javascript">
  		var pagetemp = -1;
  		var upvote = [];//点赞标记
  		function sumbit(){
  			var reply_content = $("#editor_id").val();
  			if(reply_content==null || reply_content==""){
  				alert("请填写回复内容！");
  				return false;
  			}
  			$.ajax({
  				type:"post",
				url:"<%=basePath%>replyAction/addReply.action",
				data:{"reply_content":reply_content,"topicID":'${topic.id}'},
				dataType:"text",
				success:function(data){
					alert(data);
					if(data == "回复成功"){
						KindEditor.html('#editor_id', '');
						var pnum=$(window.frames["reply_List"].document).find(".post_topic").length;
						if(pnum<15){
							document.getElementById("reply_List").src = "<%=basePath%>jsp/postings/reply.jsp?topicId=${topic.id}";
						}
					}
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
            	},
  			
  			})
  		}
  		function deleteTopic(tid){
  			if (!confirm("确认要删除吗？")){
			return false;
			}
			$.ajax({
  				type:"post",
				url:"<%=basePath%>topicAction/deleteTopic.action",
				data:{"topicId":tid},
				dataType:"text",
				success:function(data){
					alert(data);
					if(data == "删除成功"){
						location.href="<%=basePath%>jsp/postings/index.jsp";
					}
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
            	},
  			
  			})
  		}
  		function addUpvote(tid){
		var objs = eval(upvote);
		for(var i = 0;i<objs.length;i++){
   			if(objs[i].topicId == tid){
   				alert("您已经点过赞了");
   				return false;
   			}
  		}
		$.ajax({
  				type:"post",
				url:"<%=basePath%>topicAction/addUpvote.action",
				data:{"topicId":tid},
				dataType:"text",
				success:function(data){
					$("#upvote").html(data);
					var row = {};
					row.topicId= tid;
					row.addTab = "1";
					upvote.push(row);
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
            	},
  			
  			})
  			
	}
  </script>
</html>

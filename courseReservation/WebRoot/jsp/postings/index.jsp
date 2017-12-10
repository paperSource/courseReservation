<%@page import="cn.edu.chenggong.po.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>选课交流中心</title>
  	<link rel="stylesheet" href="<%=basePath%>editor/themes/default/default.css" type="text/css"></link>
  	<link rel="stylesheet" href="<%=basePath%>css/posting/posting_main.css" type="text/css"></link>
  	<script type="text/javascript" src="<%=basePath%>editor/kindeditor-all.js"></script>
  	<script type="text/javascript" src="<%=basePath%>editor/lang/zh-CN.js"></script>
  	<script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>	
  	<script type="text/javascript">
  		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="topic_content"]', {
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
  <body>
    	<div id="top"></div>
    	<div id="content">
    		<div id="main" >
				<iframe frameborder=0 src="postingList.jsp" name="topic_List" height="100%" width="100%" id="topic_List"></iframe>    			
    		</div>
    		<div id="posting">
    			<form action="${pageContext.request.contextPath }/topicAction/addTopic.action" method="post" id="topic_form">
    				<div id="p_title">
    					<label>标题：</label><input type="text" name="title" size="80px;" style="height: 30px;">
    				</div>
    				<div id="p_content">
						<textarea id="editor_id" name="topic_content" style="width:920px;height:300px;"></textarea> 
    				</div>
    				<div id="p_button">
    					<a href="###" onclick="sumbit()"><span id="p_span">发表</span></a>
    				</div>
  				</form>
    		</div>
    	</div>
    	<div id="foot">
    	
    	</div>
  </body>
  <script type="text/javascript">
  		function sumbit(){
  		    var title = $("input[name='title']").val();
  		    var reply_content = $("#editor_id").val();
  		    if(title == null || title == ""){
  		    	alert("请填写标题！");
  		    	return false;
  		    }
  		    if(reply_content == null || reply_content == ""){
  		    	alert("请填写正文内容！");
  		    	return false;
  		    }
  			$.ajax({
  				type:"post",
				url:"<%=basePath%>topicAction/addTopic.action",
				data:$('#topic_form').serialize(),
				dataType:"text",
				success:function(data){
					alert(data);
					if(data == "发表成功"){
						$("input[name='title']").val("");
						KindEditor.html('#editor_id', '');
						document.getElementById("topic_List").src = "<%=basePath%>jsp/postings/postingList.jsp";
					}
					
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					alert("系统错误！");
            	},
  			
  			})
  		}
  
  </script>
</html>

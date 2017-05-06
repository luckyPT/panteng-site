<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新建文章</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/kindeditor/plugins/code/prettify.css" />
	<style type="text/css">
	.add-style-label {
            padding-top: 6px;
            padding-left: 12px;
            margin-bottom: 0px;
    }
    </style>
	<script charset="utf-8" src="/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="/kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/kindeditor/plugins/code/prettify.css',
				uploadJson : '/file/save',
				fileManagerJson : '../jsp/file_manager_json',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
  </head>
  <body style="background-color:#2894FF">
  	<div class="container-fluid" style="height:auto;margin-top:10px">
  		<div class="row">
  			<div class="col-md-8 offset-md-2 col-sm-12">
			    <form name="example" method="post" action="/user/<%= request.getParameter("userName")%>/addArticle">
			    	<div class="form-inline" style="background-color:#E0E0E0;height:50px;">
			  				<h5 class="add-style-label">标&nbsp题:&nbsp&nbsp&nbsp&nbsp</h5>
			  				<input type="text" id="title" name="title" placeholder="标题" style="width:30%">
			  		</div>
					<textarea class="form-control" name="content1" cols="100" rows="8" style="width:100%;height:480px;visibility:hidden;"></textarea>
					<div class="form-inline" style="background-color:#E0E0E0;height:50px;">
			  				<h5 class="add-style-label">标&nbsp签:&nbsp&nbsp&nbsp&nbsp</h5>
			  				<input type="text" style="width:50%" id="tags" name="tags" placeholder="请使用英文逗号分隔">
			  		</div>
			  		<input class="btn btn-info" type="submit" name="button" value="保存" />
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
  </body>
</html>
<%!
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
%>
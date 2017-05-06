<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap-grid.min.css" rel="stylesheet">
        <link href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://unpkg.com/vue/dist/vue.js"></script>
        <title>猿媛驿站</title>
    <head>
    <body>
        <div class="container-fluid" style="height:auto;background-color:black">
            <!--titleBar-->
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-3">
                    <span style="cursor:pointer;color:#FFF;font-weight:bold;margin-top:5px;display:block;">
                    猿媛客栈
                    </span>
                </div>
                <div class="col-md-1 offset-md-6 col-sm-2 offset-sm-4 col-xs-2">
	                <span id="login_span" data-toggle="modal" data-target="#loginModal" style="cursor:pointer;color:#FFF;font-weight:bold;margin-top:5px;display:block; text-align:center;"
	                	onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background='#000000'">
	                    	{{login}}
	                </span>
                </div>
                <div class="col-md-1 col-sm-0 col-xs-0">
                    <span style="cursor:pointer;color:#FFF;font-weight:bold;margin-top:5px;display:block; text-align:center;"
                    	onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background='#000000'">
						注册
                    </span>
                </div>
            </div>
        </div>
        <div class="container-fluid" style="background-color:black">
            <!--功能区-->
            <div class="row" style="background-color:#F00">
                <div class="col-md-3 col-sm-12">
                    <div class="row">
                    	<div class="col-md-6 col-sm-12">
                    		<a href="/editor/newArticle?userName=panteng" target="_blank">
                    			<img src="/images/addArticle.jpg" style="max-width:100%;" class="img-polaroid">
                    		</a>
                    	</div>
                    	<div class="col-md-6 col-sm-12">
                    		功能2
                    	</div>
                    </div>
                </div>
                <div id="articles_div" class="col-md-9 col-sm-12" style="background-color:#99CCFF">
                    <div v-for="article in articles" style="margin-bottom:15px;box-shadow: 5px 5px 2px #3366CC;background-color:#F0F0F0; border:#00CC66 1px solid;margin-top:5px;">
                    	<a v-bind:href="['/attached/html/panteng/' + article.fileName + '.html']" target="_blank"><h3>{{article.title}}</h3></a>
                    	<hr>
                    	<div class="form-inline">
                    		<span style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[0]}}</span>&nbsp
                    		<span style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[1]}}</span>&nbsp
                    		<span style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[2]}}</span>&nbsp
                    		<span style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[3]}}</span>&nbsp
                    		<span style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[4]}}</span>&nbsp
                    	</div>
                    	<br>
                    	<span>
                    		<p>{{article.summary}}</p>
                    	</span>
                    	<span style="text-align:right;display:block">
                    		{{article.nickName}}&nbsp{{article.pubTime}}&nbsp
                    	</span>
                    </div>
                    
                </div>
            </div>
        </div>
        <!-- 登录框 -->
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">登录</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <input type="text" ref="userName" class="form-control" id="userName" placeholder="邮箱/昵称/手机号" v-bind:value="value"></input>
		        <br>
		        <input type="password" ref="passWord" class="form-control" id="passWord" placeholder="密码"  v-bind:value="value"></input>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
		        <button type="button" class="btn btn-primary" onclick="login()" data-dismiss="modal">登录</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- <div id="articles_div">
		<li v-for="article in articles">
           	{{article.title}}
        </li>
        </div> -->
       	<script src="https://cdn.bootcss.com/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
       	<script src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
		<script type="text/javascript">
			var userName=new Vue({
				el:"#userName",
				data: {
				   value: ''
				}
			});
			
			var passWord=new Vue({
				el:"#passWord",
				data: {
				   value: ''
				}
			});
			
			var login_span = new Vue({
				el:"#login_span",
				data:{
					login:"登录"
				}
			});
			
			function login(){
				$.ajax({
		            url: '/login',
		            type: 'POST', //GET
		            data: 'userName=' + userName.$refs.userName.value + '&passWord=' + passWord.$refs.passWord.value,
		            async: true,    //或false,是否异步
		            timeout: 15000,    //超时时间
		            dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
		            success: function (resp) {
		            	if(resp.loginSuccess=='true'){
		            		login_span.login = userName.$refs.userName.value;
		            	}else{
		            		alert(resp.errorMsg);
		            	}
					}
				});
			}
			var article1={};
			article1.title='java入门';
			article1.sumary='java 是一门高级编程语言，最大的特性在于一次编译，到处执行';
			var articleList = new Vue({
				el:"#articles_div",
				data:{
					articles:[
						{title:'java入门',summary:'djqiodjwqoi'},
						{title:'java入门',summary:'djqiodjwqoi'}
					]
				}
			});
			
			function getArticleList(){
				$.ajax({
		            url: '/articleList',
		            type: 'POST', //GET
		            data: '',
		            async: true,    //或false,是否异步
		            timeout: 15000,    //超时时间
		            dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
		            success: function (resp) {
		            	articleList.articles=resp;
					}
				});
			}
			
			getArticleList();
		</script>
     </body>
</html>
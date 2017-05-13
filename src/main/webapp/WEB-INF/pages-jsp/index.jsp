<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        [v-cloak] {
            display: none !important;
        }

        .removeBoderBlank {
            padding-right: 3px;
            padding-left: 1px;
        }
        
        .fd{
        	position:fixed;
        	top:50%; 
        	right:10px; 
        	margin:-50px 0 0 -50px;
        }
    </style>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://unpkg.com/vue/dist/vue.js"></script>
    <title>猿媛驿站</title>
<head>
<body>
<div class="container-fluid" style="height:auto;background-color:black">
    <!--titleBar-->
    <div class="row" style="height:24px">
        <div class="col-md-4 col-sm-4 col-xs-3">
                    <span style="cursor:pointer;color:#FFF;font-weight:bold;margin-top:5px;display:block;">
                    猿媛客栈
                    </span>
        </div>
        
        <div class="col-md-1 col-md-offset-6 col-sm-2 col-sm-offset-4 col-xs-offset-4 col-xs-2">
	                <span v-cloak id="login_span" data-toggle="modal" data-target="#loginModal"
                          style="cursor:pointer;color:#FFF;font-weight:bold;margin-top:5px;display:block; text-align:center;"
                          onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background='#000000'">
	                    	{{login}}
	                </span>
        </div>
        <div class="col-md-1 col-sm-2 col-xs-2">
                    <span style="cursor:pointer;color:#FFF;font-weight:bold;margin-top:5px;display:block; text-align:center;"
                          onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background='#000000'">
						注册
                    </span>
        </div>
    </div>
</div>
<div class="container-fluid removeBoderBlank" style="background-color:#99CCFF;">
    <!--功能区-->
    <div class="col-md-3 col-xs-12 col-sm-12" style="border:#000FFF solid 0px;height:auto;">
        <div class="row">
            <div class="col-md-6 col-xs-6 col-sm-6" style="text-align:center">
                <a href="/editor/newArticle" target="_blank">
                    <img src="/images/addArticle.png" style="max-width:100%; height:50px" class="img-polaroid">
                </a>
                <br>
                <label>添加文章</label>
            </div>
            <div class="col-md-6 col-xs-6 col-sm-6" style="text-align:center;display:none;">
                <a href="/editor/newArticle?userName=panteng" target="_blank">
                    <img src="/images/recommended.png" style="max-width:100%;height:50px" class="img-polaroid">
                </a>
                <br>
                <label>推荐文章</label>
            </div>
            <div class="col-md-6 col-xs-6 col-sm-6" style="text-align:center;display:none;">
                <a href="/editor/newArticle?userName=panteng" target="_blank">
                    <img src="/images/programers.png" style="max-width:100%;height:50px" class="img-polaroid">
                </a>
                <br>
                <label>猿媛简历</label>
            </div>
            <div class="col-md-6 col-xs-6 col-sm-6" style="text-align:center;display:none;">
                <a href="/editor/newArticle?userName=panteng" target="_blank">
                    <img src="/images/contract.png" style="max-width:100%;height:50px" class="img-polaroid">
                </a>
                <br>
                <label>联系作者</label>
            </div>
        </div>
    </div>
    <!--文章列表-->
    <div id="articles_div" class="col-md-9 col-xs-12 col-sm-12 removeBoderBlank"
         style="border:#009393 solid 0px;background-color:#99CCFF">
        <div v-for="article in articles"
             style="margin-bottom:10px;box-shadow: 5px 5px 2px #3366CC;background-color:#F0F0F0; border:#00CC66 1px solid;margin-top:5px;">
            <a v-bind:href="['/attached/html/' + article.nickName + '/' + article.fileName + '.html']" target="_blank"><h3>
                {{article.title}}</h3></a>
            <hr>
            <div class="form-inline">
                <span v-cloak style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[0]}}</span>&nbsp
                <span v-cloak style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[1]}}</span>&nbsp
                <span v-cloak style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[2]}}</span>&nbsp
                <span v-cloak style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[3]}}</span>&nbsp
                <span v-cloak style="background:#E0E0E0;border:1px solid #A0A0A0">{{article.tags[4]}}</span>&nbsp
            </div>
            <br>
                    	<span>
                    		<p>{{article.summary}}</p>
                    	</span>
                    	<span v-cloak style="color:#C0C0C0;text-align:right;display:block">
                    		{{article.nickName}}&nbsp|&nbsp{{article.pubTime}}&nbsp
                    	</span>
        </div>
        <div class="fd">
            <a href="javascript:scroll(0,0)">
            	<img alt="回到顶部" src="/images/top.jpg" style="height:49px;width:49px">
            </a>
        </div>
        <div style="text-align: center;">
            <span>加载中... ...</span>
            <a onclick="getArticleList()">手动加载</a>
        </div>
    </div>
</div>
</div>
<!-- 登录框 -->
<div id="loginModal" class="modal fade" style="" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" ref="userName" class="form-control" id="userName" placeholder="邮箱/昵称/手机号"
                       v-bind:value="value"></input>
                <br>
                <input type="password" ref="passWord" class="form-control" id="passWord" placeholder="密码"
                       v-bind:value="value"></input>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="login()" data-dismiss="modal">登录</button>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script type="text/javascript">
    var currentNum=1;
    var userName = new Vue({
        el: "#userName",
        data: {
            value: ''
        }
    });

    var passWord = new Vue({
        el: "#passWord",
        data: {
            value: ''
        }
    });

    var login_span = new Vue({
        el: "#login_span",
        data: {
            login: "登录"
        }
    });

    function login() {
        $.ajax({
            url: '/login',
            type: 'POST', //GET
            data: 'userName=' + userName.$refs.userName.value + '&passWord=' + passWord.$refs.passWord.value,
            async: true,    //或false,是否异步
            timeout: 15000,    //超时时间
            dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
            success: function (resp) {
                if (resp.loginSuccess == 'true') {
                    login_span.login = userName.$refs.userName.value;
                } else {
                    alert(resp.errorMsg);
                }
            }
        });
    }
    var article1 = {};
    article1.title = 'java入门';
    article1.sumary = 'java 是一门高级编程语言，最大的特性在于一次编译，到处执行';
    var articleList = new Vue({
        el: "#articles_div",
        data: {
            articles: []
        }
    });

    function getArticleList() {
        $.ajax({
            url: '/articleList?pageNum='+currentNum,
            type: 'POST', //GET
            data: '',
            async: true,    //或false,是否异步
            timeout: 15000,    //超时时间
            dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
            success: function (resp) {
                console.log(typeof resp);
                articleList.articles = articleList.articles.concat(resp);
                currentNum=currentNum+1;
            }
        });
    }

    getArticleList();
    /**
     * 判断滚动条是否到最底端的方法
     * @param Element obj
     */
    function isScrollBottom(obj) {
        if ($(window).scrollTop() + $(window).height() >= $(document).height()) {
            return true;
        } else {
            return false;
        }
    }
    /*添加滚动监听事件*/
    $(window).bind('scroll', function () {
        if (isScrollBottom(window)) {
            getArticleList();
        }
    });
</script>
</body>
</html>
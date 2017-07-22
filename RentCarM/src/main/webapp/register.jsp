<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<body>
	<div class="Log1" align="right">
    	<a href="index">回到首页</a> | 
    	<a href="">帮助中心</a> | 0411-88888888
    </div>
    <div class="TiTle" align="center">
    	<span>Easy-Car</span>
    	<strong>神牛租车</strong>
   	</div>
   	<br/>
    <div class="Case1">
    	<div class="Case2">
        	<div class="Er11">
        		<span>欢迎注册</span>
            	<div class="er12">
            		<span>如果您已经是会员，请点击</span>
                	<a href="login">登录</a>
                </div>
            </div>
        	<form action="UserAuthenticate" method="post">
        		<input type="hidden" name="opr" value="add"/>
	       		<div class="er2">
	        		<p>
	        			<span>手 机 号：</span>
	        			<input name="phonenumber" type="text" id="Er21" placeholder="请输入您的手机号码" />
	        		</p>
	           		<p>
	           			<span>用 户 名：</span>
	           			<input name="newusername" type="text" id="Er21" placeholder="请输入您的真实姓名" />
	           		</p>
	            	<p>
	            		<span>密&nbsp;&nbsp; &nbsp;码：</span>
	            		<input name="newuserpwd" type="password" id="Er21" placeholder="6-18位数字" />
	            	</p>
	           		<p>
	           			<span class="er22">确认密码：</span>
	           			<input type="password" id="Er21" placeholder="再次确认密码" />
	           		</p>
	            	<p class="er23">
	            		<input type="checkbox" id="er24"/>
	            		<label for="er24">我已阅读神牛租车会员服务条款</label>
	            	</p>
	            	<p>
	            		<input type="submit" class="L213" value="注&nbsp; 册"/>
	            	</p>
	            	<p>${sessionScope.message }</p>
	            </div>
            </form>
        </div>
    </div>
</body>
</html>

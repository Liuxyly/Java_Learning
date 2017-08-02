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
<title>登录</title>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/messages_zh.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#userLogin").validate({
			rules: {
				userName: "required",
				userPass: "required"
			},
			message: {
				userName: "请输入账号",
				userPass: "请输入密码"
			}
		});
	});
</script>
</head>
<body>
	<div class="Log1" align="right">
    	<a href="index.jsp">回到首页</a>
    	<span> | </span>
        <a href="admin/login.jsp">管理员登录</a>
        <span> | </span>
		<a href="">帮助中心</a>
		<span> | </span>
		<span>0411-88888888</span>
	</div>
    <div class="TiTle" align="center">
    	<span>Easy-Car</span>
    	<strong>神牛租车</strong>
    </div>
		<div class="log2">
			<form id="userLogin" action="UserAuthenticate" method="post">
				<input type="hidden" name="opr" value="login"/>
		    	<div class="log21">
		        	<span class="L211">
		        		<strong>欢迎登录</strong>
		        	</span>
		        	<a href="register.jsp">免费注册</a>
		        	<p>
		        		<span>账号：</span>
		        		<input name="userName" type="text" id="Er21" placeholder="手机号/QQ/邮箱" />
		        	</p>
		        	<p>
		        		<span>密码：</span>
		        		<input name="userPass" type="password" id="Er21" placeholder="6-18位数字" />
		        	</p>
		            <input type="submit" class="L213" value="登 录"/>
		        	<p>
		        		<input type="checkbox" id="L214"/>
		        		<label for="L214">自动登录</label>
		        		<a class="forget" href="">忘记密码？</a>
		        		${sessionScope.message}
		        	</p>
		   		</div> 
   			</form>   
    	<div class="log22">
    		<div class="L221">
    			<p>
    				<em>赠送GPS ！！</em>
    			</p>
        		<p>
        			<em>特价送
        				<strong class="L222">199</strong>元全险
        			</em>
        		</p> 
    		</div>
   		</div>    
	</div>
</body>
</html>

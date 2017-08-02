<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	session.removeAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录</title>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/messages_zh.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#adminUser").validate({
			rules: {
				adminName: "required",
				adminPwd: "required"
			},
			message: {
				adminName: "请输入账号",
				adminPwd: "请输入密码"
			}
		});
	});
</script>
</head>
<body>
	<div class="Log1" align="right">
    	<a href="index.jsp">回到首页</a> | 
    	<a href="">帮助中心</a> | 0411-88888888
    </div>
	<div class="TiTle" align="center">
    	Easy-Car<strong>神牛租车管理系统</strong>
   	</div> <br/>
    <div class="Case1">
    	<div class="Case2">
    		<form id="adminUser" action="UserAuthenticate" method="post">
	        	<div class="entry">
	        		<input name="opr" type="hidden" value="adminLogin">
	            	<p>账号：<input name="adminName" type="text" id="Er21"/></p>
	                <p>密码：<input name="adminPwd" type="password" id="Er21"/></p>
	                <p><input type="submit" class="L213" value="登 录"/></p>
	                <span>${sessionScope.message }</span>
	            </div>
            </form>    
        </div>
    </div>
</body>
</html>

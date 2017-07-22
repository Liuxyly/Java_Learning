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
<title>管理员登录</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<body>
	<div class="Log1" align="right">
    	<a href="首页.html">回到首页</a> | 
    	<a href="">帮助中心</a> | 0411-88888888
    </div>
	<div class="TiTle" align="center">
    	Easy-Car<strong>神牛租车管理系统</strong>
   	</div> <br/>
    <div class="Case1">
    	<div class="Case2">
    	<form action="UserAuthenticate" method="post"></form>
        	<div class="entry">
        		<input name="opr" type="hidden" value="adminLogin">
            	<p>账号：<input name="adminName" type="text" id="Er21"/></p>
                <p>密码：<input name="adminPwd" type="password" id="Er21"/></p>
                <p><input type="submit" class="L213" value="登 录"/></p>
            </div>      
        </div>
    </div>
</body>
</html>

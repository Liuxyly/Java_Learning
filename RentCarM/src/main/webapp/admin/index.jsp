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
<title>管理员首页</title>
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
        	<div class="admin1">
            	<a href="admin/orderCentre.jsp" id="ad">订 单 中 心</a>
            </div>
            <div class="admin1">
            	<a href="admin/updateCar.jsp" id="ad">更新车辆信息</a>
            </div>      
        </div>
    </div>
</body>
</html>

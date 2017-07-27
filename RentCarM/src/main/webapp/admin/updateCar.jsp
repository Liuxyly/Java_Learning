<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@include file="validateAdminUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员-更新车辆</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<body>
	<div class="Log1" align="right">
    	<a href="首页.html">回到首页</a> | 
        <a href="管理员首页.html">回到管理员首页</a>
    </div>
    <div class="TiTle" align="center">
    	Easy-Car<strong>神牛租车管理系统</strong>
   	</div> <br/>
    <div class="Case1">
    	<div class="Case2">
        	<div class="Or1">
            	<span class="Or11">更新车辆</span>
            </div>
            <form action="">
            	<span>&nbsp;&nbsp; &nbsp;品 牌：</span>
            	<input type="text"/>
            	<input type="submit" value="查 询"/>
            </form>
            <a href="admin/addNewCar.jsp">添加新车</a>
            <table width="870" height="75" border="1" cellpadding="0" cellspacing="0" id="tab2">
            	<tr>
                	<td><strong>#</strong></td>
                    <td><strong>品牌</strong></td>
                    <td><strong>型号</strong></td>
                    <td><strong>结构</strong></td>
                	<td><strong>排量</strong></td>
                    <td><strong>乘坐/人</strong></td>
                    <td><strong>原价</strong></td>
                    <td><strong>折扣</strong></td>
                    <td><strong>操作</strong></td>
                </tr>
                <c:set var="index" value="0" />
                <c:forEach items="${carInfos }" var="carInfo">
                <c:set var="index" value="${index+1}" />
                	<tr id = "${index}">
	                	<td><a href="">${index}</a></td>
	                    <td>${carInfo.carType.brand.brandName }</td>
	                    <td>${carInfo.carType.cartypeName }</td>
	                    <td>${carInfo.carJiegou }</td>
	                	<td>${carInfo.carPailiang }/${carInfo.carBox }</td>
	                    <td>${carInfo.carPeople }</td>
	                    <td>${carInfo.price }</td>
	                    <td>${carInfo.discount }</td>
	                    <td>
	                    	<a href="CarInfoServlet?opr=alterCarInfoCon&carInfoId=${carInfo.carId}">更新</a>
	                    	<input type="button" onclick='delCatInfo(${index}, ${carInfo.carId }, this)' value="删除"/>
	                    </td>
	                </tr>
                </c:forEach>
            </table>
       		<div class="Yj1">
            	当前第1页 <a href="" id="yj11">《上一页></a> <a href="" id="yj11">下一页》</a> 共计10页 到第<input type="text" id="yj12">页 <input type="submit" value="确 定">
            </div>      
    	</div>
    </div>
    
    
</body>
</html>

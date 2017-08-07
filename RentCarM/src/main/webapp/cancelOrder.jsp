<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page errorPage="error.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ include file="validateUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>取消订单</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<body>
	<div class="Log1" align="right">
    	<a href="index.jsp">回到首页</a> | 
    	<a href="orderCentre.jsp">订单中心</a> | 
    	<a href="">帮助中心</a> | 0411-88888888|
    	<c:if test="${!empty sessionScope.normalUser}">
	       <a href="UserAuthenticate?opr=exit">退出</a>
        </c:if>
    </div>
    <div class="TiTle" align="center">
    	Easy-Car<strong>神牛租车</strong>
   	</div> <br/>
    <div class="Case1">
    	<div class="Case2">
        	<div class="Or1">
            	<span class="Or11">订单取消成功</span> &nbsp;&nbsp;&nbsp;应付总价：¥ <span class="Money">${requestScope.orderInfo.fee}</span>
            </div>	 &nbsp;&nbsp;&nbsp;&nbsp; 
            订单号：${requestScope.orderInfo.orderId } | 租车人：${sessionScope.normalUser.userName}
            <div class="Er11">
			&nbsp;车辆信息
        	</div>
            <div class="tr1">
            	<img id="img11" height="60%" width="60%" src="CarInfoServlet?opr=getImg&carId=${requestScope.orderCarInfo.carId }"/>
                <img border="1px" height="40" width="440" cellpadding="0" cellspacing="0" id="tab1">
                <table>
                	<tr align="center">
                    	<td>${requestScope.orderCarInfo.carType.brand.brandName }&nbsp;${requestScope.orderCarInfo.carType.cartypeName }</td>
                        <td>${requestScope.orderCarInfo.carJiegou }/${requestScope.orderCarInfo.carPailiang }${requestScope.orderCarInfo.carBox }</td>
                        <td>乘坐${requestScope.orderCarInfo.carPeople }人</td>
                    </tr>
                </table>
            </div>
          	<div class="or2">
          		<p><strong>取车时间：</strong><fmt:formatDate value="${requestScope.orderInfo.getDate }" type="date" dateStyle="long"/></p>
            	<p><strong>还车时间：</strong><fmt:formatDate value="${requestScope.orderInfo.reDate }" type="date" dateStyle="long"/></p>
                <p><strong>取车地点：</strong>${requestScope.orderInfo.getAddress }</p>
                <p><strong>还车地点：</strong>${requestScope.orderInfo.reAddress }</p>
            </div>
          	<div class="Or3">
          		<a href="orderCentre.jsp" id="or31">订单中心</a>
          	</div>
    	</div>
    </div>
</body>
</html>

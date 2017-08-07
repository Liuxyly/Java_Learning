<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>订单</title>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</head>

<body>
	<div class="Log1" align="right">
    	<a href="index.jsp">回到首页</a> | 
        <a href="orderCentre.jsp">我的订单</a> | 
    	<a href="">帮助中心</a> | 0411-88888888
    </div>
    <div class="TiTle" align="center">
    	<span>Easy-Car</span>
    	<strong>神牛租车</strong>
   	</div>
   	<br/>
    <div class="Case1">
    	<div class="Case2">
    		<input name="carId" type="hidden" value="${requestScope.orderCarInfo.carId }"/>
            <input name="userId" type="hidden" value="${sessionScope.normalUser.userId }"/>
        	<div class="Or1">
            	<span class="Or11">订单提交成功</span>
            	<span>应付总价：</span>
            	<span>¥</span>
            	<span class="Money">${requestScope.orderInfo.fee }</span>
            </div> 
            <p>
            	<div class="Er10">
		            <span>订单号：</span>
		            <span name = "">${requestScope.orderInfo.orderId }</span>
		            <span> | </span>
		            <span>租车人：</span>
		            <span name = "">${sessionScope.normalUser.userName}</span>
		            <span> | </span>
		            <span>租期：</span>
		            <span id="days" name = "">2</span>
		            <span>天</span>
		            <span> | </span>
		            <span>取车时需要刷取预授权：</span>
		            <span>¥</span>
		            <span class="or12">3000</span>
	            </div>
            </p>
        	<div class="Er11">
				<span>车辆信息</span>
        	</div>    
            <div class="tr1">
            	<!-- <image id="img11" src="images/bieke1.png"/> -->
                <img id="img11" height="60%" width="60%" src="CarInfoServlet?opr=getImg&carId=${requestScope.orderCarInfo.carId }"/>
                <table border="1px" height="40" width="440" cellpadding="0" cellspacing="0" id="tab1">
                	<tr align="center">
                    	<td>${requestScope.orderCarInfo.carType.brand.brandName }&nbsp;${requestScope.orderCarInfo.carType.cartypeName }</td>
                        <td>${requestScope.orderCarInfo.carJiegou }/${requestScope.orderCarInfo.carPailiang }${requestScope.orderCarInfo.carBox }</td>
                        <td>乘坐${requestScope.orderCarInfo.carPeople }人</td>
                    </tr>
                </table>
            </div>
          	<div class="or2">
          		<p>
          			<strong>取车时间：</strong>
          			<input class="tmpfromDate" type="hidden" value="${requestScope.orderInfo.getDate }"/>
          			<span class="fromDate"></span>
          		</p>
            	<p>
					<strong>还车时间：</strong>
					<input class="tmptoDate" type="hidden" value="${requestScope.orderInfo.reDate }"/>
					<span class="toDate"></span>
            	</p>
                <p><strong>取车地点：</strong>${requestScope.orderInfo.getAddress }</p>
                <p><strong>还车地点：</strong>${requestScope.orderInfo.reAddress }</p>
            </div>
          	<div class="Or3">
          		<a href="orderCentre.jsp" id="or31">订单中心</a>
          	</div>
          	<div class="Or3">
            	<a href="OrderServlet?opr=rAlterOrder&orderId=${requestScope.orderInfo.orderId }&userId=${sessionScope.normalUser.userId }" id="or31">修改订单</a>
          	</div>
          	<div class="Or3">
            	<a href="OrderServlet?opr=cancelOrder&orderId=${requestScope.orderInfo.orderId }&userId=${sessionScope.normalUser.userId }&carId=${requestScope.orderCarInfo.carId }&req=true" id="or31">取消订单</a>
          	</div>
    	</div>
    </div>
</body>
<script type="text/javascript">
	var getDateString = $(".tmpfromDate").val();
	var reDateString = $(".tmptoDate").val();
	
	var _getDate = new Date(getDateString);
	var _reDate = new Date(reDateString);
	
	$(".fromDate").html(_getDate.toLocaleDateString());
	$(".toDate").html(_reDate.toLocaleDateString());
	
	var days = (_reDate.valueOf() - _getDate.valueOf()) / 86400000 + 1;
	
	$("#days").html(days);
</script>
</html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>交易</title>
<link rel="stylesheet" href="css/datedropper.css">
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/datedropper.min.js" ></script>
<script type="text/javascript">
	$(function () {
		$(".date").dateDropper({format: 'y年m月d日', color: '#66c8bba', animation: 'bounce', maxYear: 2030});
		
		$(".tx1").change(toDate);
		
		$(".tx2").change(toDate);
	});
	
	function toDate() {
		var getDateString = $(".tx1").val().replace(/[年月日]/g, "-").substr(0, 10);
		var reDateString = $(".tx2").val().replace(/[年月日]/g, "-").substr(0, 10);
		if (getDateString == "" || reDateString == "") {
			return;
		}
		
		var _getDate = new Date(getDateString).valueOf();
		var _reDate = new Date(reDateString).valueOf();
		
		if (_getDate > _reDate) {
			alert("取车时间和还车时间不正确");
		} else if (_getDate == _reDate) {
			days = 1;
		} else {
			var days = (_reDate - _getDate) / 86400000 + 1;
		}
		
		$("#days").html(days);
		
		var unitPrice = parseFloat($(".unitPrice").html());
		
		$(".unitPriceReal").val(days * unitPrice);
		
		$(".Money").html(days * unitPrice);
	} 
	
	
	
</script>
<body>
	<div class="Log1" align="right">
    	<a href="index">回到首页</a> | 
    	<a href="orderCentre">订单中心</a> | 
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
        		<span>车辆信息</span>
            	<div class="er12">
                	<a href="">重选</a>
                </div>
            </div>
            <div class="tr1">
            	<image id="img11" src="images/bieke1.png"/>
                <image id="img11" src="images/bieke2.png"/>
                <table border="1px" height="40" width="440" cellpadding="0" cellspacing="0" id="tab1">
                	<tr align="center">
                    	<td>${requestScope.orderCarInfo.carType.brand.brandName }&nbsp;${requestScope.orderCarInfo.carType.cartypeName }</td>
                        <td>${requestScope.orderCarInfo.carJiegou }/${requestScope.orderCarInfo.carPailiang }${requestScope.orderCarInfo.carBox }</td>
                        <td>乘坐${requestScope.orderCarInfo.carPeople }人</td>
                    </tr>
                </table>
            </div>
            <form action="OrderServlet?opr=tradeOrder" method="post">
            	<input name="carId" type="hidden" value="${requestScope.orderCarInfo.carId }"/>
            	<input name="userId" type="hidden" value="${sessionScope.normalUser.userId }"/>
	            <div class="tr2">
	            	<p>
	            		<span>取车时间：</span>
	            		<input name="getDate" type="text" class=" date tx1">
	            	</p>
	                <p>
	                	<span>还车时间：</span>
	                	<input name="reDate" type="text" class="date tx2">
	                </p>
	                <p>
	                	<span>取车地点：</span>
	                	<input name="getAddress" type="text" value="大连"/>
	                </p>
	                <p>
	                	<span>还车地点：</span>
	                	<input name="reAddress" type="text" value="大连"/>
	                </p>
	                <p>
	                	<span>租 赁 费：
		                	<span>原价：
		                		<fmt:formatNumber value="${requestScope.orderCarInfo.price}" type="currency" pattern="¥.00"/>
		                	</span>
	                		<span>打折后：
	                			<span class="unitPrice">
	                				<fmt:formatNumber value="${(requestScope.orderCarInfo.price * requestScope.orderCarInfo.discount) * 0.01}" type="currency" pattern=".00"/>
	                			</span>
	                			<input class="unitPriceReal" type="hidden" name="fee" value="" />
	                		</span> × <span id="days"></span> = &yen; </span>
	                	<span class="Money"></span>
	                	
	                </p>
	                <p>
	                	<input type="submit" class="L213" value="提&nbsp; 交"/>
	                </p>
	            </div>
	    	</form>
        </div>
    </div>
</body>
</html>

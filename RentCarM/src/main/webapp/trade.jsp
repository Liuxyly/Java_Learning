<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<title>交易</title>
<link rel="stylesheet" href="css/datedropper.css">
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/datedropper.min.js" ></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.min.js"></script>
<script type="text/javascript" src="js/order.js"></script>
<script type="text/javascript">
	$(function () {
		$(".Date").dateDropper({format: 'y年m月d日', color: '#66c8bba', animation: 'bounce', maxYear: 2030});
		
		$(".tx1").change(fromDate);
		
		$(".tx2").change(toDate);
		
		$("#days").html(1);
		var unitPrice = parseFloat($(".unitPrice").html());
		$(".Money").html(1 * unitPrice);
		
		$("#reset").click(function() {
			$(".resetData").val("");
		});
		
		$("#tradeOrder").validate({
			rules: {
				getAddress: "required",
				reAddress: "required"
			},
			messages:{
				getAddress: "取车地点",
				reAddress: "还车地点"
			}
		});
	});
</script>
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
    	<span>Easy-Car</span>
    	<strong>神牛租车</strong>
   	</div>
   	<br/>
	<div class="Case1">
    	<div class="Case2">
        	<div class="Er11">
        		<span>车辆信息</span>
            	<div class="er12">
                	<button id="reset" >重选</button>
                </div>
            </div>
            <div class="tr1">
            	<!-- <img id="img11" src="images/bieke1.png"/> -->
                <img id="img11" height="60%" width="60%" src="CarInfoServlet?opr=getImg&carId=${requestScope.orderCarInfo.carId }"/>
                <table border="1px" height="40" width="440" cellpadding="0" cellspacing="0" id="tab1">
                	<tr align="center">
                    	<td>${requestScope.orderCarInfo.carType.brand.brandName }&nbsp;${requestScope.orderCarInfo.carType.cartypeName }</td>
                        <td>${requestScope.orderCarInfo.carJiegou }/${requestScope.orderCarInfo.carPailiang }${requestScope.orderCarInfo.carBox }</td>
                        <td>乘坐${requestScope.orderCarInfo.carPeople }人</td>
                    </tr>
                </table>
            </div>
            <form id="tradeOrder" action="OrderServlet?opr=tradeOrder" method="post">
            	<input name="carId" type="hidden" value="${requestScope.orderCarInfo.carId }"/>
            	<input name="userId" type="hidden" value="${sessionScope.normalUser.userId }"/>
	            <div class="tr2">
	            	<p>
	            		<span>取车时间：</span>
	            		<input name="getDate" type="text" class="resetData Date tx1">
	            	</p>
	                <p>
	                	<span>还车时间：</span>
	                	<input name="reDate" type="text" class="resetData Date tx2">
	                </p>
	                <p>
	                	<span>取车地点：</span>
	                	<input class="resetData" name="getAddress" type="text" value=""/>
	                </p>
	                <p>
	                	<span>还车地点：</span>
	                	<input class="resetData" name="reAddress" type="text" value=""/>
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

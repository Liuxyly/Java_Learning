<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page errorPage="error.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@include file="validateUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改订单</title>
<link rel="stylesheet" href="css/datedropper.css">
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/datedropper.min.js" ></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.min.js"></script>
<script type="text/javascript" src="js/order.js"></script>
<script type="text/javascript">
	$(function () {
		$(".Date").dateDropper({format: 'y年m月d日', color: '#66c8bba', animation: 'bounce', maxYear: 2030});
		
		$("#tradeOrder :input").change(function() {
		     $("#tradeOrder").data("changed",true);
		});
		
		$(".tx1").change(fromDate);
		
		$(".tx2").change(toDate);
		
		$("#days").html(1);
		var unitPrice = parseFloat($(".unitPrice").html());
		$(".Money").html(unitPrice);
		
		$("#reset").click(function() {
			$(".resetData").val("");
		});
		
		$.validator.setDefaults({  
	        submitHandler: function() {  
	        	if ($("#tradeOrder").data("changed")) {
					return true;
	        	} else {
	        		alert("请更改页面或后退");
	        		return false;
	        	}
	        }  
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
</head>
<body>
	<div class="Log1" align="right">
    	<a href="首页.html">回到首页</a> | 
    	<a href="">订单中心</a> | 
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
            	<span class="Or11">修改订单</span> 
            </div> &nbsp;&nbsp;&nbsp;&nbsp; 
            订单号：${requestScope.orderInfo.orderId } | 租车人：${sessionScope.normalUser.userName}
        	<div class="Er11">车辆信息
            	<div class="er12">
                	<a href="OrderServlet?opr=cancelOrder&orderId=${requestScope.orderInfo.orderId }&userId=${sessionScope.normalUser.userId }&carId=${requestScope.orderCarInfo.carId }&req=true">取消订单</a>
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
            <form id="alterOrder" action="OrderServlet?opr=alterOrder" method="post">
            	<input name="carId" type="hidden" value="${requestScope.orderCarInfo.carId }"/>
            	<input name="orderId" type="hidden" value="${requestScope.orderInfo.orderId }"/>
            	<input name="userId" type="hidden" value="${sessionScope.normalUser.userId }"/>
            	<div class="tr2">
	            	<p>
	            		<span>取车时间：</span>
	            		<input name="getDate" type="text" class="Date tx1" value="<fmt:formatDate value="${requestScope.orderInfo.getDate }" type="date" dateStyle="long"/>">
	            	</p>
	                <p>
	                	<span>还车时间：</span>
	                	<input name="reDate" type="text" class="Date tx2" value="<fmt:formatDate value="${requestScope.orderInfo.reDate }" type="date" dateStyle="long"/>">
	                </p>
	                <p>
	                	<span>取车地点：</span>
	                	<input class="resetData" name="getAddress" type="text" value="${requestScope.orderInfo.getAddress }"/>
	                </p>
	                <p>
	                	<span>还车地点：</span>
	                	<input class="resetData" name="reAddress" type="text" value="${requestScope.orderInfo.reAddress }"/>
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

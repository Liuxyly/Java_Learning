<%@ page language="java" pageEncoding="UTF-8"%>
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
<title>订单中心</title>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/order.js"></script>

</head>
<body>
	<div class="Log1" align="right">
    	<a href="index.jsp">回到首页</a> | 
    	<a href="">帮助中心</a> | 
    	<span>0411-88888888</span>
    </div>
    <div class="TiTle" align="center">
    	<span>Easy-Car</span>
    	<strong>神牛租车</strong>
   	</div>
   	<br/>
    <div class="Case1">
    	<div class="Case2">
        	<div class="Or1">
            	<span class="Or11">订单中心</span> 
            </div>
            <div id="options">
            	<select id="brandNameList" >
            		<option value="-1">--请输入品牌--</option>
            	</select>
            	<input class="change" id="c1" type="checkbox" name="orderState" value="0"/>
            	<label for="c1">未付款</label>
            	<input class="change" id="c2" type="checkbox" name="orderState" value="1"/>
            	<label for="c2">取消</label>
            	<input class="change" id="c3" type="checkbox" name="orderState" value="2"/>
            	<label for="c3">关闭</label>
            	<input class="change" id="c4" type="checkbox" name="orderState" value="3"/>
            	<label for="c4">交易成功</label>
            	<input type="hidden" id="userId" value="${sessionScope.normalUser.userId }"/>
            </div>
            <table id = "orderTable" width="870" height="75" border="1" cellpadding="0" cellspacing="0" id="tab2">
            	<tbody>
	            	<tr>
	            		<td><strong>用户名</strong></td>
	                	<td><strong>订单号</strong></td>
	                    <td><strong>车型</strong></td>
	                    <td><strong>取车时间</strong></td>
	                    <td><strong>还车时间</strong></td>
	                	<td><strong>订单状态</strong></td>
	                	<td><strong>操作</strong></td>
	                </tr>
                </tbody>
            </table>
	       		<div class="Yj1">
	            	<span>当前第<span id="pageNumber"></span>页 </span>
	            	<input type="button" id="orderPagePrv" value="《上一页" />
	            	<span>|</span>
	            	<input type="button" id="orderPageNext" value="下一页》">
	            	<span>共计<span id="totalPage"></span>页 到第</span>
	            	<input type="text" id="toPageNumber" size="5"/>
	            	<span>页 </span>
	            	<input id="orderPageNumber" type="button" value="确 定"/>
	            </div>    
    	</div>
    </div>
</body>
<script type="text/javascript">
	initOrderCentrePage();
	
	$(function () {
		$.ajax({
			url: "CarInfoServlet",
			data: {
				opr: 'getBrands'
			},
			dataType: 'json',
			success: function (data) {
				$.each(data, function(index, brand) {
					$("#brandNameList").append("<option value='" + brand.brandId + "' >" + brand.brandName + "</option>");
				})
			}
		});
		
		$(document).on('change','#brandNameList', function() {
			getOrderPage(1);
		});
		
		$(document).on('change','input[name=orderState]', function() {
			getOrderPage(1);
		});
		
		$(document).on('click', '.cancelRentCar', function() {
			$thisObj = $(this);
			
			$.ajax({
				url:'OrderServlet',
				data: {
					opr: 'cancelOrder',
					orderId: $thisObj.parent().parent().find(".orderId").html(),
					userId: $thisObj.parent().find(".userId").val(),
					carId: $thisObj.parent().find(".carId").val(),
					req: 'false'
				},
				dataType: 'html',
				success: function(data) {
					if (data == 'true') {
						$thisObj.parent().parent().find(".orderStateName").html("已取消");
						$thisObj.remove();
					}
				}
			});
			
		});
		
		$("#orderPageNext").click(function() {
			var nextPage = parseInt($("#pageNumber").html()) + 1;
			var totalPage = parseInt($("#totalPage").html());
			
			if ( nextPage <= totalPage) {
				getOrderPage(nextPage);
			} else {
				alert("没有下一页了");
			}
		});
		
		$("#orderPagePrv").click(function() {
			var nextPage = parseInt($("#pageNumber").html()) - 1;
			
			if ( nextPage >= 1) {
				getOrderPage(nextPage);
			} else {
				alert("没有上一页了");
			}
		});
		
		$("#orderPageNumber").click(function() {
			var toPageNumber = parseInt($("#toPageNumber").val());
			var totalPage = parseInt($("#totalPage").html());
			
			if (toPageNumber <= 0 || toPageNumber > totalPage) {
				alert("请输入的正确的页数");
				$("#toPageNumber").val("");
				return;
			} else {
				getOrderPage(toPageNumber);
			}
		});
	});
	
</script>
</html>

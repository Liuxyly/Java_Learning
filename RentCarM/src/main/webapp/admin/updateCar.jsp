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
<script type="text/javascript">
	$(function(){
		
		initUpdateCarInfo();
		
		$("#pageDown").click(function() {
			var nextPage = parseInt($("#pageNo").html()) + 1;
			var totle = parseInt($("#pageTotle").html());
			if ( nextPage <= totle) {
				$.ajax({
					url: 'CarInfoServlet',
					data: {
						opr: 'pageControl',
						page: nextPage,
						brandName: $(".BrandName").val()
					},
					dataType: 'json',
					success: function (data) {
						listCarInfo(data);
						$("#pageNo").html(""+nextPage);
					}
				});
			} else {
				alert("没有下一页了");
			}
		});
		
		$("#pageUp").click(function() {
			var nextPage = parseInt($("#pageNo").html()) - 1;
			if ( nextPage >= 1) {
				$.ajax({
					url: 'CarInfoServlet',
					data: {
						opr: 'pageControl',
						page: nextPage,
						brandName: $(".BrandName").val()
					},
					dataType: 'json',
					success: function (data) {
						listCarInfo(data);
						$("#pageNo").html(""+nextPage);
					}
				});
				
			} else {
				alert("没有上一页了");
			}
		});
		
		$("#toPageB").click(function() {
			var pageNo = parseInt($("#toPage").val());
			var totle = parseInt($("#pageTotle").html());
			if (pageNo <= 0 || pageNo > totle) {
				alert("请输入的正确的页数");
				return;
			}
			
			$.ajax({
				url: 'CarInfoServlet',
				data: {
					opr: 'pageControl',
					page: pageNo,
					brandName: $(".BrandName").val()
				},
				dataType: 'json',
				success: function (data) {
					listCarInfo(data);
					$("#pageNo").html(""+pageNo);
				}
			});
		});
		
		$(".updateCarInfo").attr("href", function (index, oldData) {
			return oldData + "&page=" + $("#yj12").val();
		})
		
		$(".BrandName").change(function () {
			initUpdateCarInfo();
		});
		
		// 参考：http://blog.csdn.net/qq_26222859/article/details/51375239
		// 因为js运行与html渲染是两个线程所以会有找不到函数的问题
		$(document).on('click', '.delOneRow', delOneRow);
	});
</script>
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
            <div>
            	<span>&nbsp;&nbsp; &nbsp;品 牌：</span>
            	<input type="text" class="BrandName"/>
            	<!-- <input type="submit" value="查 询" id="queryByBrandName"/> -->
            </div>
            <a href="admin/addNewCar.jsp">添加新车</a>
            <table width="870" height="75" border="1" cellpadding="0" cellspacing="0" id="tab2">
            	<tr class="top">
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
            </table>
       		<div class="Yj1">
            	当前第<span id="pageNo">1</span>页 <input type="button" id="pageUp" value="《上一页" /><input type="button" id="pageDown" value="下一页》"/> 共计<span id="pageTotle"></span>页 到第<input value="1" type="text" id="toPage">页 <input id="toPageB" type="button" value="确 定">
            </div>      
    	</div>
    </div>
    
    
</body>
</html>

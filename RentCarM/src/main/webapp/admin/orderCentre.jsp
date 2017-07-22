<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员-订单中心</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
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
            	<span class="Or11">订单中心</span> &nbsp;&nbsp;&nbsp; * 订单号：
            	<form action="">
            		<input name="orderId" type="text" value="14407778607661"/>
            		<input type="submit"  value="查 询"/>
            	</form>
            </div>
            <table width="870" height="75" border="1" cellpadding="0" cellspacing="0" id="tab2">
            	<tr>
                	<td><strong>订单号</strong></td>
                    <td><strong>车型</strong></td>
                    <td><strong>取车时间</strong></td>
                    <td><strong>还车时间</strong></td>
                	<td><strong>订单状态</strong></td>
                    <td><strong>费用总计</strong></td>
                    <td><strong>结算</strong></td>
                </tr>
                
                <c:forEach items="${sessionScope.orderList }" var = "order">
                	<tr>
                		<form action="OrderOprations" method="post">
                			<input type="hidden" name="opr" value="${order.orderId }"/>
		                	<td><a href="">${order.orderId }</a></td>
		                    <td>别克凯越/三厢/1.6自动</td>
		                    <td>${order.getDate }</td>
		                    <td>${order.reDate }</td>
		                	<td>
		                		<c:if test="${order.orderState } eq 1">
		                			交易成功
		                		</c:if>
		                	</td>
		                    <td>¥${order.fee }</td>
		                    <td><input type="submit" value="确 定" /></td>
	                    </form>
	                </tr>
                </c:forEach>
                
                <tr>
                	<td><a href="">14407778607661</a></td>
                    <td>别克凯越/三厢/1.6自动</td>
                    <td>2016/12/20</td>
                    <td>2016/12/22</td>
                	<td>交易成功</td>
                    <td>¥513</td>
                    <td><input type="submit" value="确 定"/></td>
                </tr>
                <tr>
                	<td><a href="">14407778607662</a></td>
                    <td>别克凯越/三厢/1.6自动</td>
                    <td>2016/12/20</td>
                    <td>2016/12/22</td>
                	<td>未付款</td>
                    <td>¥513</td>
                    <td><input type="submit" value="确 定" disabled="disabled"/></td>
                </tr>
                <tr>
                	<td><a href="">14407778607663</a></td>
                    <td>别克凯越/三厢/1.6自动</td>
                    <td>2016/12/20</td>
                    <td>2016/12/22</td>
                	<td>已取消</td>
                    <td>¥513</td>
                    <td><input type="submit" value="确 定" disabled="disabled"/></td>
                </tr>
            </table>
       		<div class="Yj1">
            	当前第1页 <a href="" id="yj11">《上一页></a> <a href="" id="yj11">下一页》</a> 共计10页 到第<input type="text" id="yj12">页 <input type="submit" value="确 定">
            </div>      
    	</div>
    </div>
</body>
</html>

<%@ page language="java" pageEncoding="UTF-8"%>
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
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
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
        	<div class="Or1">
            	<span class="Or11">订单提交成功</span>
            	<span>应付总价：</span>
            	<span>¥</span>
            	<span class="Money">513</span>
            </div> 
            <p>
            	<div class="Er10">
		            <span>订单号：</span>
		            <span name = "">14407778607661</span>
		            <span> | </span>
		            <span>租车人：</span>
		            <span name = "">刘小明</span>
		            <span> | </span>
		            <span>租期：</span>
		            <span name = "">2</span>
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
            	<image id="img11" src="images/bieke1.png"/>
                <image id="img11" src="images/bieke2.png"/>
                <table border="1px" height="40" width="440" cellpadding="0" cellspacing="0" id="tab1">
                	<tr align="center">
                    	<td>别克凯越</td>
                        <td>三厢/1.6自动</td>
                        <td>乘坐5人</td>
                    </tr>
                </table>
            </div>
          	<div class="or2">
          		<p><strong>取车时间：</strong>2016年12月20日</p>
            	<p><strong>还车时间：</strong>2016年12月22日</p>
                <p><strong>取车地点：</strong>大连 解放广场</p>
                <p><strong>还车地点：</strong>大连 解放广场</p>
            </div>
          	<div class="Or3">
          		<a href="orderCentre.jsp" id="or31">订单中心</a>
          	</div>
          	<div class="Or3">
            	<a href="alterOrder.jsp" id="or31">修改订单</a>
          	</div>
          	<div class="Or3">
            	<a href="cancelOrder.jsp" id="or31">取消订单</a>
          	</div>
          	<div class="Or3">
            	<a href="" id="or31">关闭订单</a>
          	</div>      
    	</div>
    </div>
</body>
</html>

<%@ page language="java" pageEncoding="UTF-8"%>
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
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
<body>
	<div class="Log1" align="right">
    	<a href="首页.html">回到首页</a> | 
    	<a href="">订单中心</a> | 
    	<a href="">帮助中心</a> | 0411-88888888
    </div>
    <div class="TiTle" align="center">
    	Easy-Car<strong>神牛租车</strong>
   	</div> <br/>
    <div class="Case1">
    	<div class="Case2">
        	<div class="Or1">
            	<span class="Or11">修改订单</span> 
            </div> &nbsp;&nbsp;&nbsp;&nbsp; 
            订单号：14407778607661 | 租车人：刘小明 
        	<div class="Er11">车辆信息
            	<div class="er12">
                	<a href="取消订单.html">取消订单</a>
                </div>
            </div>
            <div class="tr1">
            	<img id="img11" src="images/bieke1.png"/>
                <img id="img11" src="images/bieke2.png"/>
                <table border="1px" height="40" width="440" cellpadding="0" cellspacing="0" id="tab1">
                	<tr align="center">
                    	<td>别克凯越</td>
                        <td>三厢/1.6自动</td>
                        <td>乘坐5人</td>
                    </tr>
                </table>
            </div>
            <div class="tr2">
            	<p>取车时间：<input type="text" id="tx1"/>年<input type="text" id="tx2"/>月<input type="text" id="tx2"/>日</p>
                <p>还车时间：<input type="text" id="tx1"/>年<input type="text" id="tx2"/>月<input type="text" id="tx2"/>日</p>
                <p>取车地点：<input type="text" value="大连"/></p>
                <p>还车地点：<input type="text" value="大连"/></p>
                <p>租 赁 费：220 × 2 = &yen; <span class="Money">440</span></p>
                <p><input type="submit" class="L213" value="提&nbsp; 交"/></p>
            </div>
        </div>
    </div>
    
    
    
</body>
</html>

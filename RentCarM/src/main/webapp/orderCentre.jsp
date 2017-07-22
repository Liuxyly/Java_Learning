<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单中心</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<body>
	<div class="Log1" align="right">
    	<a href="index">回到首页</a> | 
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
            <table width="870" height="75" border="1" cellpadding="0" cellspacing="0" id="tab2">
            	<tr>
                	<td><strong>订单号</strong></td>
                    <td><strong>车型</strong></td>
                    <td><strong>取车时间</strong></td>
                    <td><strong>还车时间</strong></td>
                	<td><strong>订单状态</strong></td>
                </tr>
                <tr>
                	<td><a href="">14407778607661</a></td>
                    <td>别克凯越/三厢/1.6自动</td>
                    <td>2016/12/20</td>
                    <td>2016/12/22</td>
                	<td>交易成功</td>
                </tr>
                <tr>
                	<td><a href="">14407778607662</a></td>
                    <td>别克凯越/三厢/1.6自动</td>
                    <td>2016/12/20</td>
                    <td>2016/12/22</td>
                	<td>未付款</td>
                </tr>
                <tr>
                	<td><a href="">14407778607663</a></td>
                    <td>别克凯越/三厢/1.6自动</td>
                    <td>2016/12/20</td>
                    <td>2016/12/22</td>
                	<td>已取消</td>
                </tr>
            </table>
            <form action="#" method="post">
	       		<div class="Yj1">
	            	<span>当前第1页 </span>
	            	<a href="#" id="yj11">《上一页</a>
	            	<span>|</span>
	            	<a href="#" id="yj11">下一页》</a>
	            	<span>共计10页 到第</span>
	            	<input type="text" id="yj12"/>
	            	<span>页 </span>
	            	<input type="submit" value="确 定"/>
	            </div>    
	    	</form> 
    	</div>
    </div>
</body>
</html>

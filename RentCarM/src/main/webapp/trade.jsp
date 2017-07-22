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
<title>交易</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
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
                    	<td>别克凯越</td>
                        <td>三厢/1.6自动</td>
                        <td>乘坐5人</td>
                    </tr>
                </table>
            </div>
            <form action="#" method="post">
	            <div class="tr2">
	            	<p>
	            		<span>取车时间：</span>
	            		<input type="text" id="tx1"/>
	            		<span>年</span>
	            		<input type="text" id="tx2"/>
	            		<span>月</span>
	            		<input type="text" id="tx2"/>
	            		<span>日</span>
	            	</p>
	                <p>
	                	<span>还车时间：</span>
	                	<input type="text" id="tx1"/>
	                	<span>年</span>
	                	<input type="text" id="tx2"/>
	                	<span>月</span>
	                	<input type="text" id="tx2"/>
	                	<span>日</span>
	                </p>
	                <p>
	                	<span>取车地点：</span>
	                	<input type="text" value="大连"/>
	                </p>
	                <p>
	                	<span>还车地点：</span>
	                	<input type="text" value="大连"/>
	                </p>
	                <p>
	                	<span>租 赁 费：220 × 2 = &yen; </span>
	                	<span class="Money">440</span>
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

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
<title>取消订单</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
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
            	<span class="Or11">订单取消成功</span> &nbsp;&nbsp;&nbsp;应付总价：¥ <span class="Money">513</span>
            </div>	 &nbsp;&nbsp;&nbsp;&nbsp; 
            订单号：14407778607661 | 租车人：刘小明 
            <div class="Er11">
			&nbsp;车辆信息
        	</div>
            <div class="tr1">
            	
            	<img id="img11" src="images/bieke1.png"/>
                <img id="img11" src="images/bieke2.png"/>
                <img border="1px" height="40" width="440" cellpadding="0" cellspacing="0" id="tab1">
                <table>
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
          		<a href="订单中心.html" id="or31">订单中心</a>
          	</div>
          	<div class="Or3">
            	<a href="修改订单.html" id="or31">修改订单</a>
          	</div>
          	<div class="Or3">
            	<a href="" id="or31">取消订单</a>
          	</div>
          	<div class="Or3">
            	<a href="首页.html" id="or31">关闭订单</a>
          	</div>      
    	</div>
    </div>
</body>
</html>

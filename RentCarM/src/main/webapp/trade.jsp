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
<link rel="stylesheet" href="css/datedropper.css">
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/datedropper.min.js" ></script>
<script type="text/javascript">
	$(function () {
		$(".date").dateDropper({format: 'y年m月d日', color: '#66c8bba', animation: 'bounce', maxYear: 2030});
		updateDays(0);
	});
	
	var toDate = function () {
		var getDateString = document.getElementsByClassName("tx1")[0].value.replace(/[年月日]/g, "-").substr(0, 10);
		var reDateString = document.getElementsByClassName("tx2")[0].value.replace(/[年月日]/g, "-").substr(0, 10);
		if (getDateString == "" || reDateString == "") {
			return;
		}
		
		var _getDate = new Date(getDateString);
		var _reDate = new Date(reDateString);
		
		if (_getDate > _reDate) {
			alert("取车时间和还车时间不正确");
		} else if (_getDate = _reDate) {
			
		}
		updateDays((_reDate.getTime() - _getDate.getTime()) / 86400000);
	}
	
	var updateDays = function (days) {
		document.getElementById( "days" ).innerHTML = days;
	}
	
</script>
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
	            		<input name="getDate" type="text" class=" date tx1" onchange="toDate()">
	            	</p>
	                <p>
	                	<span>还车时间：</span>
	                	<input name="retDate" type="text" class="date tx2" onchange="toDate()">
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
	                	<span>租 赁 费：<span name="unitPrice">220</span> × <span id="days">2</span> = &yen; </span>
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

<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/json2.min.js"></script>
<script type="text/javascript">
	$(function () {
		$.ajax({
			url: "CarInfoServlet",
			data: {
				opr: 'getBrands'
			},
			dataType: 'json',
			success: function (data) {
				$.each(data, function(index, brand) {
					$("#brandNameList").append("<li><input type='checkbox' name='brand' value='" + brand.brandId + "'/>" + brand.brandName + "</li>");
				})
			}
		});
		
		initIndexPage();
		
		$("#submit1").click(function() {
			choiceCar(1);
		});
		
		options("level", "checkbox");
		options("brand", "checkbox");
		
		$("input[name=dailyRate]").click(function () {
			$("input[name=dailyRateFrom]").prop("disabled", true).val("");
			$("input[name=dailyRateTo]").prop("disabled", true).val("");
		});
		
		$("#fromTo").click(function (e) {
			$("input[name=dailyRate]").prop("disabled", true).prop("checked", false);
			$("input[name=dailyRateFrom]").prop("disabled", false);
			$("input[name=dailyRateTo]").prop("disabled", false);
		});
		
		validatePrice("dailyRateFrom");
		validatePrice("dailyRateTo");
		
		$("#indexPageNext").click(function() {
			var nextPage = parseInt($("#pageNumber").html()) + 1;
			var totalPage = parseInt($("#totalPage").html());
			
			if ( nextPage <= totalPage) {
				choiceCar(nextPage);
			} else {
				alert("没有下一页了");
			}
		});
		
		$("#indexPagePrv").click(function() {
			var nextPage = parseInt($("#pageNumber").html()) - 1;
			
			if ( nextPage >= 1) {
				choiceCar(nextPage);
			} else {
				alert("没有上一页了");
			}
		});
		
		$("#indexPageNumber").click(function() {
			var toPageNumber = parseInt($("#toPageNumber").val());
			var totalPage = parseInt($("#totalPage").html());
			
			if (toPageNumber <= 0 || toPageNumber > totalPage) {
				alert("请输入的正确的页数");
				$("#toPageNumber").val("");
				return;
			} else {
				choiceCar(toPageNumber);
			}
		});
		
		$(document).on('click', 'input[disable!=disabled][class=rentCar]', function() {
			var url = 'OrderServlet?opr=toOrder&carId=' + $(this).siblings("#carId").val() + "&userId=" + $("#userId").val();
			location.href = url;
		});
	})
</script>
<body>
<nav>
	<%-- 顶部导航栏 --%>
	<div>
    	<span>欢迎光临易人租车</span>
    	<c:if test="${empty sessionScope.normalUser}">
	       <span>
	       	请<a href="login.jsp">登录</a>
	       	或<a href="register.jsp">注册</a>
	       </span>
        </c:if>
        <c:if test="${!empty sessionScope.normalUser}">
	       <span>
	       	欢迎${sessionScope.normalUser.userName}登陆
	       </span>
	       <a href="UserAuthenticate?opr=exit">退出</a>
        </c:if>
    </div>
    <div>
        <a href="
	        <c:if test="${empty sessionScope.normalUser}">
	        	login.jsp
	        </c:if>
	        <c:if test="${!empty sessionScope.normalUser}">
	        	orderCentre.jsp
	        </c:if>
        ">我的订单</a>|
        <a href="">帮助中心</a>|
        <span>0411-88888888</span>
    </div>
</nav>
<header>
	<%--网页logo部位--%>
	<div id="logo"><span>Easy-Car神牛租车</span></div>
    <%--车辆筛区域--%>
    <div id="screen">
    	<div id="insideScreen">
            <form>
                <div class="screenType1"><%--级别类--%>
                    <span>级&nbsp;&nbsp;&nbsp;&nbsp;别</span>
                    <ul>
                        <li><input type="checkbox" name="level" value="0"/>不限</li>
                        <li><input type="checkbox" name="level" value="1"/>紧凑型</li>
                        <li><input type="checkbox" name="level" value="2"/>中型</li>
                        <li><input type="checkbox" name="level" value="3"/>大型</li>
                        <li><input type="checkbox" name="level" value="4"/>SUV</li>
                        <li><input type="checkbox" name="level" value="5"/>MPV</li>
                        <li><input type="checkbox" name="level" value="6"/>跑车</li>
                    </ul>
                </div>
                <div class="screenType2"><%--品牌类--%>
                    <span>品&nbsp;&nbsp;&nbsp;&nbsp;牌</span>
                    <ul id="brandNameList">
                        <li><input type="checkbox" name="brand" value="0"/>不限</li>
                    </ul>
                </div>
                <div class="screenType3"><%--日租金--%>
                    <span>日租金</span>
                    <ul>
                        <li><input type="radio" name="dailyRate" value="0"/>不限</li>
                        <li><input type="radio" name="dailyRate" value="1"/>￥0-￥150</li>
                        <li><input type="radio" name="dailyRate" value="2"/>￥150-￥300</li>
                        <li><input type="radio" name="dailyRate" value="3"/>￥300-￥500</li>
                        <li><input type="radio" name="dailyRate" value="4"/>￥500以上</li>
                        <li id="fromTo">
                            <input type="text" name="dailyRateFrom" size="6" maxlength="6"/> ~ 
                            <input type="text" name="dailyRateTo" size="6" maxlength="6"/>
                            <span id = "validatePrice">请输入正确的价格</span>
                        </li>
                    </ul>
                </div>
                <div><%--选车按钮--%>
                    <div><input type="button" name="choiceCar" value="选&nbsp;车" id="submit1"></div>
                </div>
                <c:if test="${!empty sessionScope.normalUser}">
            		<input id="userId" type="hidden" value="${sessionScope.normalUser.userId}"/>
            	</c:if>
            </form>
        </div>
    </div>
</header>
<section><%--具体车辆信息--%>
    <div id="insideSection"><%--边框--%>
	    <div id="sortDiv">
	        <%--排序方式--%>
	        <div><input type="checkbox" name="defaultSort" />默认排序</div>
	        <div>
	             <input type="checkbox" name="toHighSort" />租金由低到高
	             <img src="images/homepage/arrow.png"/>
	        </div>
	        <div><input type="checkbox" name="stockOnlySort" />只看有库存</div>
	        <%--右上角提示--%>
	        <div>
	            <span>※全部车型不限里程</span>
	        </div>
	    </div>
    </div>	 
    <div id="pageFoot"><%--页脚--%>
	    	<div>当前第<span id="pageNumber"></span>页</div>
	        <div><a id="indexPagePrv" href="">《上一页</a></div>
	        <div><a id="indexPageNext" href="">下一页》</a></div>
	        <div>共计<span id="totalPage"></span>页</div>
	        <div>
	        	到第
	            <input id="toPageNumber" type="text" name="pageChoice" size="6" maxlength="6"/>
	            页
	            <input id="indexPageNumber" type="button" name="page-jump" value="确定"/>
	        </div>
	    </div>
</section>
</body>
</html>

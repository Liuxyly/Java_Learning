<%@ page language="java" pageEncoding="UTF-8"%>
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
<
<body>
<nav>
	<%-- 顶部导航栏 --%>
	<div>
    	<span>欢迎光临易人租车</span>
        <span>
        	请<a href="login.jsp">登录</a>
        	或<a href="register.jsp">注册</a>
        </span>
        ${sessionScope.normalUser.userName}
    </div>
    <div>
        <a href="">我的订单</a>|
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
                        <li><input type="checkbox" name="level" value="noLimit"/>不限</li>
                        <li><input type="checkbox" name="level" value="compact"/>紧凑型</li>
                        <li><input type="checkbox" name="level" value="medium"/>中型</li>
                        <li><input type="checkbox" name="level" value="large"/>大型</li>
                        <li><input type="checkbox" name="level" value="SUV"/>SUV</li>
                        <li><input type="checkbox" name="level" value="MPV"/>MPV</li>
                        <li><input type="checkbox" name="level" value="sports"/>跑车</li>
                    </ul>
                </div>
                <div class="screenType2"><%--品牌类--%>
                    <span>品&nbsp;&nbsp;&nbsp;&nbsp;牌</span>
                    <ul>
                        <li><input type="checkbox" name="brand" value="noLimit"/>不限</li>
                        <li><input type="checkbox" name="brand" value="Buick"/>别克</li>
                        <li><input type="checkbox" name="brand" value="Haval"/>哈弗</li>
                        <li><input type="checkbox" name="brand" value="Ford"/>福特</li>
                        <li><input type="checkbox" name="brand" value="Honda"/>本田</li>
                        <li><input type="checkbox" name="brand" value="Toyota"/>丰田</li>
                        <li><input type="checkbox" name="brand" value="Audi"/>奥迪</li>
                    </ul>
                </div>
                <div class="screenType3"><%--日租金--%>
                    <span>日租金</span>
                    <ul>
                        <li><input type="checkbox" name="dailyRate" value="noLimit"/>不限</li>
                        <li><input type="checkbox" name="dailyRate" value="0-150"/>￥0-￥150</li>
                        <li><input type="checkbox" name="dailyRate" value="150-300"/>￥150-￥300</li>
                        <li><input type="checkbox" name="dailyRate" value="300-500"/>￥300-￥500</li>
                        <li><input type="checkbox" name="dailyRate" value="500"/>￥500以上</li>
                        <li>
                            <input type="text" name="dailyRate1" size="6" maxlength="6"/> ~ 
                            <input type="text" name="dailyRate2" size="6" maxlength="6"/>
                        </li>
                    </ul>
                </div>
                <div><%--选车按钮--%>
                    <div><input type="submit" name="choiceCar" value="选&nbsp;车" id="submit1"></div>
                </div>
            </form>
        </div>
    </div>
</header>
<section><%--具体车辆信息--%>
    <div id="insideSection"><%--边框--%>
    	<form>
            <div id="sortDiv">
                <%--排序方式--%>
                <div><input type="checkbox" name="sort" value="default"/>默认排序</div>
                <div>
                     <input type="checkbox" name="sort" value="low to high"/>租金由低到高
                     <img src="image/homepage/arrow.png"/>
                </div>
                <div><input type="checkbox" name="sort" value="stock only"/>只看有库存</div>
                <%--右上角提示--%>
                <div>
                    <span>※全部车型不限里程</span>
                </div>
            </div>
            
            <div class="car" id="car1"><!--车辆1-->
            	<div>
                	<img src="image/cars/car1.png"height="80" width="200"/>
                </div>
                <div><%--3项信息--%>
                	<ul>
                    	<li>
                        	<img src="image/homepage/car1MiniType.png"/>
                            <span>别克凯越</span>
                        </li>
                        <li>
                        	<img src="image/homepage/carInformation.png"/>
                        	<span>三厢/1.6自动</span>
                        </li>
                        <li>
                        	<img src="image/homepage/memberLimit.png"/>
                            <span>乘坐5人</span>
                        </li>
                    </ul>
                </div>
                <div><%--热门--%>
                	<img src="image/homepage/hot.png"/>
                </div>
                <div><%--价格--%>
                	<p>￥<span>219</span>/日均</p>
                    <p>原价：￥438</p>
                </div>
				<div class="submit"><input type="submit" value="" id="submit2"></div>
            </div>
            
            
            <div class="car" id="car2"><!--车辆2-->
            	<div>
                	<img src="image/cars/car2.png"height="80" width="200"/>
                </div>
                <div><%--3项信息--%>
                	<ul>
                    	<li>
                        	<img src="image/homepage/car2MiniType.png"/>
                            <span>雪佛兰科鲁兹</span>
                        </li>
                        <li>
                        	<img src="image/homepage/carInformation.png"/>
                        	<span>三厢/1.6自动</span>
                        </li>
                        <li>
                        	<img src="image/homepage/memberLimit.png"/>
                            <span>乘坐5人</span>
                        </li>
                    </ul>
                </div>
                <div><%--热门--%>
                	<img src="image/homepage/hot.png"/>
                </div>
                <div><%--价格--%>
                	<p>￥<span>274</span>/日均</p>
                    <p>原价：￥548</p>
                </div>
                <div class="submit"><input type="submit" value="" id="submit2"></div>
            </div>
            <div class="car" id="car3"><%--车辆3--%>
            	<div>
                	<img src="image/cars/car3.png"height="80"width="200"/>
                </div>
                <div><%--3项信息--%>
                	<ul>
                    	<li>
                        	<img src="image/homepage/car3MiniType.png"/>
                            <span>别克新君越</span>
                        </li>
                        <li>
                        	<img src="image/homepage/carInformation.png"/>
                        	<span>三厢/2.4自动</span>
                        </li>
                        <li>
                        	<img src="image/homepage/memberLimit.png"/>
                            <span>乘坐5人</span>
                        </li>
                    </ul>
                </div>
                <div><%--热门--%>
                	<img src="image/homepage/hot.png"/>
                </div>
                <div><%--价格--%>
                	<p>￥<span>599</span>/日均</p>
                    <p>原价：￥1198</p>
                </div>
                <div class="submit"><input type="submit" value="" id="submit2"></div>
                
            </div>
            <div class="car" id="car4"><%--车辆4--%>
            	<div>
                	<img src="image/cars/car4.png"height="80" width="200"/>
                </div>
                <div><%--3项信息--%>
                	<ul>
                    	<li>
                        	<img src="image/homepage/car4MiniType.png"/>
                            <span>MINI</span>
                        </li>
                        <li>
                        	<img src="image/homepage/carInformation.png"/>
                        	<span>两厢/1.6自动</span>
                        </li>
                        <li>
                        	<img src="image/homepage/memberLimit.png"/>
                            <span>乘坐3人</span>
                        </li>
                    </ul>
                </div>
                <div><%--热门--%>
                	<img src="image/homepage/hot.png"/>
                </div>
                <div><%-- 价格 --%>
                	<p>￥<span>695</span>/日均</p>
                    <p>原价：￥1139</p>
                </div>
                <div class="submit"><input type="submit" value=" " id="submit2"></div>
            </div>
            <div id="pageFoot"><!--页脚-->
            	<div>当前第<span id="pageNumber">1</span>页</div>
                <div><a href="#">《上一页</a></div>
                <div><a href="#">下一页》</a></div>
                <div>共计<span name="totalPage">10</span>页</div>
                <div>
                	到第
                    <input type="text" name="pageChoice" size="6" maxlength="6"/>
                    页
                    <input type="submit" name="page-jump" value="确定"/>
                </div>
            </div>
        </form>
    </div>	
</section>
</body>
</html>

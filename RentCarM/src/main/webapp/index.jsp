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
<body>
	<header>
		<div>
			<div class="header_01">
				<div class="header_01_01">欢迎光临神牛租车</div>
				<div class="header_01_02">
					请<a href="login.jsp">登录</a>或<a href="register.jsp">注册</a>
				</div>
			</div>
			<div class="header_02">
				<div class="header_02_01">
					<a>我的订单</a>
				</div>
				<div class="header_02_02">
					<a>帮助中心</a>
				</div>
				<div class="header_02_03">
					<span>0411-88888888</span>
				</div>
			</div>
		</div>
		<div class="header_box">
			<div class="header_03">
				<h1>Easy-Car神牛租车</h1>
			</div>
		</div>
	</header>
	<main>
		<form action="#" method="post">
			<div class="header_04">
				<div class="header_04_01">
					<div class="header_04_01_tab">
						<div class="tab_row">
							<div class="tab_cell">
								<div class="tab_cell_type">级 别</div>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="types" /> <span>不限</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="types" /> <span>紧凑型</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="types" /> <span>中型</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="types" /> <span>大型</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="types" /> <span>SUV</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="types" /> <span>MPV</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="types" /> <span>跑车</span>
							</div>
						</div>
						<div class="tab_row">
							<div class="tab_cell">
								<div class="tab_cell_type">品 牌</div>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="pinpai" /> <span>不限</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="pinpai" /> <span>别克</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="pinpai" /> <span>哈弗</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="pinpai" /> <span>福特</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="pinpai" /> <span>本田</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="pinpai" /> <span>丰田</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="pinpai" /> <span>奥迪</span>
							</div>
						</div>
						<div class="tab_row">
							<div class="tab_cell">
								<div class="tab_cell_type">日租金</div>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="money" /> <span>不限</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="money" /> <span>¥0-¥150</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="money" /> <span>¥150-¥300</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="money" /> <span>¥300-¥500</span>
							</div>
							<div class="tab_cell">
								<input type="checkbox" name="money" /> <span>¥500以上</span>
							</div>
							<div class="tab_cell_bett">
								<input type="text" maxlength="10" /> <span>~</span> <input
									type="text" maxlength="10" />
							</div>
						</div>
					</div>
					<div class="header_04_01_btm">
						<p onClick="#">选 车</p>
					</div>
	
				</div>
			</div>
			<div class="main_01">
				<div class="items">
					<div class="main_01_option">
						<ul>
							<li><input type="checkbox" name="option" />
								<p>默认排序</p></li>
							<li>
								<p>租金由低到高</p>
								<div class="option_img"></div>
							</li>
							<li><input type="checkbox" name="option" />
								<p>默认排序</p></li>
						</ul>
						<div class="right_comment">※ 全部车型不限里程</div>
					</div>
					<div class="item">
						<ul class="detaillist">
							<li class="detailitem">
								<div class="detailitemdiv">
									<div class="image"></div>	
									<div class="info">
										<ul>
											<li></li>
											<li></li>
											<li></li>
										</ul>
									</div>
									<div class="price">
										<div><span class="discountprice"></span></div>
										<div><span class="realprice"></span></div>
									</div>
									<div>
										<div class="rentbtm">
											<p>
												
											</p>
										</div>
									</div>
								</div>
							</li>
							<li class="detailitem"></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="main_02">
				<p>
					当前第1页 <a href="" id="yj11">《上一页></a> <a href="" id="yj11">下一页》</a> 共计10页 到第<input type="text" id="yj12">页 <input type="submit" value="确 定">
				</p>
			</div>
		</form>
	</main>














</body>
</html>

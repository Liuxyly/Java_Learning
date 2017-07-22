<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@include file="validateAdminUser.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员-更改车辆</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
<body>
	<div class="Log1" align="right">
		<a href="首页.html">回到首页</a> | <a href="管理员首页.html">回到管理员首页</a>
	</div>
	<div class="TiTle" align="center">
		Easy-Car<strong>神牛租车管理系统</strong>
	</div>
	<br />
	<div class="Case1">
		<form action="#" method="post">
			<div class="Case2">
				<div class="Or1">
					<span class="Or11">更改车辆</span>
				</div>
				<div class="ps1">
					<p>
						<span>* 品&nbsp;&nbsp; 牌：</span>
						<select>
							<option value="0">--请选择--</option>
							<option value="1">奥迪</option>
							<option value="2">别克</option>
							<option value="3">宝马</option>
						</select>
					</p>
					<p>
						<span>* 级&nbsp;&nbsp; 别：</span>
						<input type="text" id="Er21" placeholder="请输入级别" />
						<span>* 型&nbsp;&nbsp; 号：</span>
						<input type="text" id="Er21" placeholder="请输入型号" />
					</p>
					<p>
						<span>* 结&nbsp;&nbsp; 构：</span>
						<input type="text" id="Er21" placeholder="请输入结构" />
						<span>* 排&nbsp;&nbsp; 量：</span>
						<input type="text" id="Er21" placeholder="请输入排量" />
					<p>
					<p>
						<span>* 变速箱：</span>
						<input type="text" id="Er21" placeholder="请输入变速箱类型" />
						<span>* 乘坐/人：</span>
						<input type="text" id="Er21" placeholder="请输入乘坐人数" />
					<p>
					<p>
						<span>* 原&nbsp;&nbsp; 价：</span>
						<input type="text" id="Er21" placeholder="请输入原价" />
						<span>* 折&nbsp;&nbsp; 扣：</span>
						<input type="text" id="Er21" placeholder="请输入折扣" />
					</p>
					<p>
						<span>* 图&nbsp;&nbsp; 片：</span>
						<input type="file" />
						<input type="submit" class="L213" value="提 交" />
					</p>
				</div>
			</div>
		</form>
	</div>
</body>
</html>

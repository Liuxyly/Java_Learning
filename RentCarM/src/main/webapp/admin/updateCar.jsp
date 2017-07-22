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
<title>管理员-更新车辆</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<body>
	<div class="Log1" align="right">
    	<a href="首页.html">回到首页</a> | 
        <a href="管理员首页.html">回到管理员首页</a>
    </div>
    <div class="TiTle" align="center">
    	Easy-Car<strong>神牛租车管理系统</strong>
   	</div> <br/>
    <div class="Case1">
    	<div class="Case2">
        	<div class="Or1">
            	<span class="Or11">更新车辆</span>
            </div> &nbsp;&nbsp; &nbsp;
            品 牌：<input type="text"/> <input type="submit" value="查 询"/> &nbsp;<a href="">添加新车</a>
            <table width="870" height="75" border="1" cellpadding="0" cellspacing="0" id="tab2">
            	<tr>
                	<td><strong>#</strong></td>
                    <td><strong>品牌</strong></td>
                    <td><strong>型号</strong></td>
                    <td><strong>结构</strong></td>
                	<td><strong>排量</strong></td>
                    <td><strong>乘坐/人</strong></td>
                    <td><strong>原价</strong></td>
                    <td><strong>折扣</strong></td>
                    <td><strong>操作</strong></td>
                </tr>
                <tr>
                	<td><a href="">1</a></td>
                    <td>奥迪</td>
                    <td>A7</td>
                    <td>三厢</td>
                	<td>2.0/自动档</td>
                    <td>5</td>
                    <td>299</td>
                    <td>7</td>
                    <td><a href="">更新</a> <a href="">删除</a></td>
                </tr>
                <tr>
                	<td><a href="">2</a></td>
                    <td>别克</td>
                    <td>凯越</td>
                    <td>两厢</td>
                	<td>1.6/手动挡</td>
                    <td>5</td>
                    <td>109</td>
                    <td>8</td>
                    <td><a href="">更新</a> <a href="">删除</a></td>
                </tr>
                <tr>
                	<td><a href="">3</a></td>
                    <td>宝马</td>
                    <td>530</td>
                    <td>掀背</td>
                	<td>2.4/自动挡</td>
                    <td>5</td>
                    <td>399</td>
                    <td>7</td>
                    <td><a href="">更新</a> <a href="">删除</a></td>
                </tr>
            </table>
       		<div class="Yj1">
            	当前第1页 <a href="" id="yj11">《上一页></a> <a href="" id="yj11">下一页》</a> 共计10页 到第<input type="text" id="yj12">页 <input type="submit" value="确 定">
            </div>      
    	</div>
    </div>
    
    
</body>
</html>

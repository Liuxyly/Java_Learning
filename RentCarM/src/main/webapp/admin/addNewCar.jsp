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
<title>添加车辆</title>
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
            	<span class="Or11">添加车辆</span> 
            </div>
            <div class="ps1">
            	<p>* 品&nbsp;&nbsp; 牌：<input type="text" id="Er21" value="请输入品牌" onfocus="if(value=='请输入品牌'){value=''}" onblur="if (value ==''){value='请输入品牌'}"/>
                 * 级&nbsp;&nbsp; 别：<input type="text" id="Er21"  value="请输入级别" onfocus="if(value=='请输入级别'){value=''}" onblur="if (value ==''){value='请输入级别'}"/></p>
                <p>* 型&nbsp;&nbsp; 号：<input type="text" id="Er21"  value="请输入型号" onfocus="if(value=='请输入型号'){value=''}" onblur="if (value ==''){value='请输入型号'}"/>
                 * 结&nbsp;&nbsp; 构：<input type="text" id="Er21"/  value="请输入结构" onfocus="if(value=='请输入结构'){value=''}" onblur="if (value ==''){value='请输入结构'}"></p>
                <p>* 排&nbsp;&nbsp; 量：<input type="text" id="Er21"  value="请输入排量" onfocus="if(value=='请输入排量'){value=''}" onblur="if (value ==''){value='请输入排量'}"/>
                 * 变速 箱：<input type="text" id="Er21"  value="请输入变速箱类型" onfocus="if(value=='请输入变速箱类型'){value=''}" onblur="if (value ==''){value='请输入变速箱类型'}"/></p>
                <p>* 乘坐/人：<input type="text" id="Er21"  value="请输入乘坐人数" onfocus="if(value=='请输入乘坐人数'){value=''}" onblur="if (value ==''){value='请输入乘坐人数'}"/>
                 * 原&nbsp;&nbsp; 价：<input type="text" id="Er21"  value="请输入原价" onfocus="if(value=='请输入原价'){value=''}" onblur="if (value ==''){value='请输入原价'}"/></p>
                <p>* 折&nbsp;&nbsp; 扣：<input type="text" id="Er21"  value="请输入折扣" onfocus="if(value=='请输入折扣'){value=''}" onblur="if (value ==''){value='请输入折扣'}"/></p>
                <p> * 图&nbsp;&nbsp; 片：<input type="file"/>
                <input type="submit" class="L213" value="提 交"/></p>
            </div>  
    	</div>
    </div>
</body>
</html>

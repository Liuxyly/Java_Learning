<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			tr:nth-of-type(even){
				background-color: #F3F3F3;
			}
			 
			tr:nth-of-type(odd){
				background-color: #DDDDDD;
			}
		</style>
	</head>
	<body>
		<div>
			<p>
				学生信息列表
			</p>
			<table>
				<tr><a href="toAdd">添加学员</a></tr>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>电话</td>
					<td>email</td>
					<td>班级</td>
				</tr>
				<s:iterator value="listStudents">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="name"/></td>
						<td><s:property value="gender"/></td>
						<td><s:property value="age"/></td>
						<td><s:property value="telephone"/></td>
						<td><s:property value="email"/></td>
						<td><s:property value="classes.name"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>	
	</body>
</html>
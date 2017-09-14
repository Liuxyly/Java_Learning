<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
 %>
<html>
	<head>
		<base href = "<%=basePath %>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script src="js/jquery.validate.min.js"></script>
		<script src="js/messages_zh.min.js"></script>
		<script type="text/javascript">
			$(function () {
				$("#addStudent").validate({
					onsubmit: true,
					rules: {
						"student.name": "required",
						"student.gender": "required",
						"student.age": "required",
						"student.telephone": "required",
						"student.email": "required",
						"student.classes.classid": {
							required: {
								depends: function (element) {
									return $("select[name='student.classes.classid']").val() == "-1";
								}
							}
						}
					},
					messages:{
						"student.name": "请输入名称",
						"student.gender": "请输入性别",
						"student.age": "请输入年龄",
						"student.telephone": "请输入电话号码",
						"student.email": "请输入Email",
						"student.classes.classid": "请选择班级"
					}
				});
			})
		</script>
	</head>
	<body>
		<div>
			<p>学生信息添加</p>
			<form id="addStudent" action="addStudent" method="post">
				<table>
					<tr>
						<td>姓名</td>
						<td><input  type="text" name="student.name"/></td>
					</tr>
					<tr>
						<td>性别</td>
						<td><input  type="text" name="student.gender"/></td>
					</tr>
					<tr>
						<td>年龄</td>
						<td><input  type="text" name="student.age"/></td>
					</tr>
					<tr>
						<td>电话</td>
						<td><input  type="text" name="student.telephone"/></td>
					</tr>
					<tr>
						<td>email</td>
						<td><input  type="text" name="student.email"/></td>
					</tr>
					<tr>
						<td><s:select label="班级"
								list="listClasses "
								listValue="name"
								listKey="classid "
								name="student.classes.classid"
             					headerKey="-1"
             					headerValue="请选择班级"
             					value="bean.id "/>
						</td>
					</tr>
				</table>
				<input type="submit" value="Add"/>
			</form>
		</div>
	</body>
</html>
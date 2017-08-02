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
<title>注册</title>
</head>
<link type="text/css" rel="stylesheet" href="css/carCSS.css"/>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/messages_zh.min.js"></script>

<script type="text/javascript">
	$(function(){
		var location = (window.location+'').split('/');
		var basePath = location[0]+'//'+location[2]+'/'+location[3];
		$("input[name='newusername']").blur(function () {
			if ($(this).val() != null && $(this).val() != '') {
				$.ajax({
					type: 'GET',
					url: basePath + "/UserAuthenticate",
					data: {
						opr: "verifyUser",
						userName: $(this).val()
					},
					success: function (returndata) {
						if (returndata == 'true') {
							$("#ajaxVerifyUserName").html("此用户名已被占用").css("color","red");
						} else {
							$("#ajaxVerifyUserName").html("此用户名可以使用").css("color","green");
						}
					}
				});
			}
		});
		
		$.validator.addMethod("isMobile", function(value, element) {
			var length = value.length;
			var mobile = /^1[34578]\d{9}$/;
			return this.optional(element) || (length == 11 && mobile.test(value));
		}, "请正确填写您的手机号码");
		
		$("#registerForm").validate({
			rules: {
				newusername: {
					required: true,
			        minlength: 4
				},
				newuserpwd: {
			        required: true,
			        minlength: 5
			    },
			    confirm_password: {
			        required: true,
			        minlength: 5,
			        equalTo: "#newuserpwd"
			    },
			    agree: "required",
			    phonenumber: {
			    	isMobile: true,
			    	required: true,
			        minlength: 11,
			        maxlength:11
			    }
			},
			messages:{
				newusername: {
					required: "请输入用户名",
			        minlength: "用户名必需由四个字母组成"
				},
				newuserpwd: {
			        required: "请输入密码",
			        minlength: "密码长度不能小于 5 个字母"
			    },
			    confirm_password: {
			        required: "请输入密码",
			        minlength: "密码长度不能小于 5 个字母",
			        equalTo: "两次密码输入不一致"
			    },
			    agree: "请接受我们的声明",
			    phonenumber: {
			    	required: "请输入手机号码",
			        minlength: "电话只能为11位",
			        maxlength: "电话只能为11位"
			    }
			}
		});
	});
</script>
<body>
	<div class="Log1" align="right">
    	<a href="index.jsp">回到首页</a> | 
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
        		<span>欢迎注册</span>
            	<div class="er12">
            		<span>如果您已经是会员，请点击</span>
                	<a href="login.jsp">登录</a>
                </div>
            </div>
        	<form action="UserAuthenticate" method="post" id="registerForm">
        		<input type="hidden" name="opr" value="add"/>
	       		<div class="er2">
	        		<p>
	        			<label for="phonenumber">手 机 号：</label>
	        			<input name="phonenumber" type="text" id="phonenumber" placeholder="请输入您的手机号码" />
	        		</p>
	           		<p>
	           			<label for="newusername">用 户 名：</label>
	           			<input name="newusername" type="text" id="newusername" placeholder="请输入您的真实姓名" />
	           			<label for="Er21" id="ajaxVerifyUserName"></label>
	           		</p>
	            	<p>
	            		<label for="newuserpwd">密&nbsp;&nbsp; &nbsp;码：</label>
	            		<input name="newuserpwd" type="password" id="newuserpwd" placeholder="6-18位数字" />
	            	</p>
	           		<p>
	           			<label for="confirm_password" class="er22">确认密码：</label>
	           			<input name="confirm_password" type="password" id="confirm_password" placeholder="再次确认密码" />
	           		</p>
	            	<p class="er23">
	            		<label for="agree">神牛租车会员服务条款</label>
	            		<input type="checkbox" name="agree"/>
	            	</p>
	            	<p>
	            		<input type="submit" class="L213" value="注&nbsp; 册"/>
	            	</p>
	            </div>
            </form>
        </div>
    </div>
</body>
</html>

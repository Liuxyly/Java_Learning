<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
	<link type="text/css" rel="stylesheet" href="css/carCSS.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/messages_zh.min.js"></script>
	<script type="text/javascript">
		$(function () {
			
			if ($("#carJibieVal").val() != "") {
				$("#carJibie").find("option[value="+ $("#carJibieVal").val() +"]").attr("selected",true);
			}
			
			if ($("#brandIdVal").val() != "") {
				$("#brandName").find("option[value="+ $("#brandIdVal").val() +"]").attr("selected",true);
				if ($("#cartypeIdVal").val() != "") {
					$("#cartypeName").find("option[value="+ $("#cartypeIdVal").val() +"]").attr("selected",true);
				}
			}
			
			$.validator.addMethod("isDecimal", function(value, element) {
				var decimal = /^\d+(\.\d{1,2})?$/;
				return this.optional(element) || (decimal.test(value));
			}, "请输入正确价格");
			
			$.validator.addMethod("idDigits", function (value, element) {
				var tmp = parseInt(value);
				var flag = tmp > 0 && tmp <= 100;
				
				return this.optional(element) || flag;
			}, "请输入正确折扣");
			
			$("#alterCatInfoForm").validate({
				rules: {
					brandName: "required",
					carJibie: "required",
					cartypeName: "required",
					carJiegou: "required",
					carPailiang: "required",
					carBox: "required",
					carPeople: "required",
					price: {
						required: true,
						isDecimal: true
					},
					discount: {
						required: true,
						idDigits: true
					}
				},
				messages:{
					brandName: "请输入品牌",
					carJibie: "请输入级别",
					cartypeName: "请输入型号",
					carJiegou: "请输入结构",
					carPailiang: "请输入排量",
					carBox: "请输入变速箱类型",
					carPeople: "请输入乘坐人数",
					price: "请输入原价",
					discount: "请输入折扣"
				}
			});
		})
	</script>
</head>
<body>
	<div class="Log1" align="right">
		<a href="index.jsp">回到首页</a> | <a href="admin/index.jsp">回到管理员首页</a>
	</div>
	<div class="TiTle" align="center">
		Easy-Car<strong>神牛租车管理系统</strong>
	</div>
	<br />
	<div class="Case1">
		<form id="alterCatInfoForm"  action="CarInfoServlet" method="post" enctype="multipart/form-data">
			<div class="Case2">
				<div class="Or1">
					<span class="Or11">更改车辆</span>
				</div>
				<div class="ps1">
	            	<p>
	            		<input type="hidden" value="${requestScope.carInfo.carId }" name="carIdVal"/>
	            		<label for="brandName">* 品&nbsp;&nbsp; 牌：</label>
						<input type="hidden" value="${requestScope.carInfo.carType.brand.brandId }" id="brandIdVal"/>
	            		<select id="brandName" name="brandName" class="brandNameC" onchange="brandNameChange()">
	            			<option value="-1">--请输入品牌--</option>
	            			<c:forEach items="${sessionScope.brandNames }" var="brand">
	            				<option value="${brand.brandId }" >${brand.brandName }</option>
	            			</c:forEach>
	            		</select>
	            		<!-- <input name="brandName" type="text" id="Er21"  placeholder="请输入品牌" /> -->
	            		<input type="hidden" name="brandId" value=""/>
	            		<input type="button" value="添加品牌" onclick="addBrand()">
            		</p>
            		<p>
	            		<%-- 级别 --%>
	                 	<label for="carJibie">* 级&nbsp;&nbsp;别：</label>
	                 	<!-- <input name="carJibie" type="text" id="carJibie" placeholder="请输入级别" /> -->
	                 	<input type="hidden" value="${requestScope.carInfo.carJibie }" id="carJibieVal"/>
	                 	<select id="carJibie" name="carJibie" class="carJibie">
	            			<option value="-1">--请输入级别--</option>
	            			<option value="1">紧凑型 </option>
	            			<option value="2">中型 </option>
	            			<option value="3">大型 </option>
	            			<option value="4">SUV</option>
	            			<option value="5">MPV</option>
	            			<option value="6">跑车</option>
	            		</select>
	                </p>
	                <div class="addNewbrandName">
	            		<input class="inBrandName" name="newBrandName" type="text" value=""/>
	            		<input type="button" value="添加" onclick="addNewbrandName()" />
	            		<input class="cancel" type="button" value="取消" onclick="cancelBrandName()">
	            	</div>
	                <p>
	                	<label for="cartypeName">* 型&nbsp;&nbsp; 号：</label>
	                	<input type="hidden" value="${requestScope.carInfo.carType.cartypeId }" id="cartypeIdVal"/>
	                	<select id="cartypeName" name="cartypeName" class="brandNameC" onfocus="cartypeNameChange()">
	            			<option value="-1">--请输入型号--</option>
	            			<c:forEach items="${requestScope.carType }" var="carType">
	            				<option value="${carType.cartypeId }" >${carType.cartypeName }</option>
	            			</c:forEach>
	            		</select>
	            		<input type="button" value="添加型号" onclick="addCarType()" />
            		</p>
            		<p>
	                	<!-- <input name="cartypeName" type="text" id="cartypeName"  placeholder="请输入型号"/> -->
	                	<label for="carJiegou">* 结&nbsp;&nbsp; 构：</label>
	                	<input name="carJiegou" type="text" id="carJiegou"  placeholder="请输入结构" value="${requestScope.carInfo.carJiegou }"/>
	                </p>
	                <div class="addNewCarType">
	            		<input class="inCarTypeName" name="newCarTypeName" type="text" value=""/>
	            		<input type="button" value="添加" onclick="addCarTypeName()">
	            		<input class="cancel" type="button" value="取消" onclick="cancelCarType()">
	            	</div>
	                <p>
	                	<label for="carPailiang">* 排&nbsp;&nbsp; 量：</label>
	                	<input name="carPailiang" type="text" id="carPailiang"  placeholder="请输入排量"  value="${requestScope.carInfo.carPailiang }"/>
	                </p>
	            	<p>
	                	<label for="carBox">* 变速 箱：</label>
	                	<input name="carBox" type="text" id="carBox"  placeholder="请输入变速箱类型" value="${requestScope.carInfo.carBox }"/>
	                </p>
	                <p>
	                	<label for="carPeople">* 乘坐/人：</label>
	                	<input name="carPeople" type="text" id="carPeople"  placeholder="请输入乘坐人数" value="${requestScope.carInfo.carPeople }"/>
	                </p>
	            	<p>
	                	<label for="price">* 原&nbsp;&nbsp; 价：</label>
	                	<input name="price" type="text" id="price"  placeholder="请输入原价" value="${requestScope.carInfo.price }"/>
	                </p>
	                <p>
	                	<label for="discount">* 折&nbsp;&nbsp; 扣：</label>
	                	<input name="discount" type="text" id="discount"  placeholder="请输入折扣" value="${requestScope.carInfo.discount }"/><span>%</span>
	                </p>
	                <p>
	                	<label for="uploadFile">* 图&nbsp;&nbsp; 片：</label>
	                	<input id="uploadFile" type="file" name="uploadFile"/>
	                </p>
	            	<p>
	                	<input type="submit" class="L213" value="提 交"/>
	                </p>
	            </div>
			</div>
		</form>
	</div>
</body>
</html>

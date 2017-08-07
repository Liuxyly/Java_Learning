/**
 * 
 */

function fromDate() {
		var getDateString = $(".tx1").val().replace(/[年月日]/g, "/").substr(0, 10);
		var reDateString = $(".tx2").val().replace(/[年月日]/g, "/").substr(0, 10);
		
		if (getDateString == "" || reDateString == "") {
			return;
		}
		
		var _getDate = new Date(getDateString).valueOf();
		var _reDate = new Date(reDateString).valueOf();
		var _now = new Date().valueOf();
		
		if (_getDate < _now || _getDate > _reDate) {
			alert("请输入正确的时间");
			$(this).val("");
			return;
		} else {
			var days = (_reDate - _getDate) / 86400000 + 1;
			
			$("#days").html(days);
			
			var unitPrice = parseFloat($(".unitPrice").html());
			
			$(".unitPriceReal").val(days * unitPrice);
			
			$(".Money").html(days * unitPrice);
		}
	}
	
	function toDate() {
		var getDateString = $(".tx1").val().replace(/[年月日]/g, "/").substr(0, 10);
		var reDateString = $(".tx2").val().replace(/[年月日]/g, "/").substr(0, 10);
		
		if (getDateString == "" || reDateString == "") {
			return;
		}
		
		var _getDate = new Date(getDateString).valueOf();
		var _reDate = new Date(reDateString).valueOf();
		var _nowString = new Date().toLocaleDateString();
		var _now = new Date(_nowString).valueOf();
		var days = 0;
		if (_reDate < _now || _getDate > _reDate) {
			alert("请输入正确的时间");
			$(this).val("");
			return;
		} else if (_getDate == _reDate) {
			days = 1
			updateDays(days);
		} else {
			days = (_reDate - _getDate) / 86400000 + 1;
			updateDays(days);
		}
	}
	
	function updateDays(days) {
		$("#days").html(days);
		
		var unitPrice = parseFloat($(".unitPrice").html());
		
		$(".unitPriceReal").val(days * unitPrice);
		
		$(".Money").html(days * unitPrice);
	}
	
	function initOrderCentrePage() {
		getOrderPage(1);
	}
	
	function initAdminOrderCentrePage() {
		getAdminOrderPage(1);
	}
	
	function getAdminOrderPage(pageNumber) {
		var pageData = {};
		
		pageData.orderState = [];
		
		$("input[name=orderState]:checked").each(function() {
			pageData.orderState.push($(this).val());
		});
		
		if ($("#brandNameList").val() != -1) {
			pageData.brandId = $("#brandNameList").val();
		}
		
		if ($("#i1").val() != '' && $("#i1").val() != null) {
			pageData.orderId = $("#i1").val();
		}
		
		if ($("#i2").val() != '' && $("#i2").val() != null) {
			pageData.userName = $("#i2").val();
		}
		
		pageData.pageNumber = pageNumber;
		
		$.ajax({
			url: "OrderServlet",
			data: {
				opr: "getAdminOrderPage",
				pageData: pageData
			},
			type: 'GET',
			dataType: 'json',
			success: function(data) {
				listAdminOrderDetail(data);
				$("#pageNumber").html(data.count);
				$("#totalPage").html(data.total);
			}
		});
	}
	
	function getOrderPage(pageNumber) {
		var pageData = {};
		
		pageData.orderState = [];
		
		$("input[name=orderState]:checked").each(function() {
			pageData.orderState.push($(this).val());
		});
		
		if ($("#brandNameList").val() != -1) {
			pageData.brandId = $("#brandNameList").val();
		}
		
		pageData.userId = $("#userId").val();
		
		pageData.pageNumber = pageNumber;
		
		$.ajax({
			url: "OrderServlet",
			data: {
				opr: "getOrderPage",
				pageData: pageData
			},
			type: 'GET',
			dataType: 'json',
			success: function(data) {
				listOrderDetail(data);
				$("#pageNumber").html(data.count);
				$("#totalPage").html(data.total);
			}
		});
	}
	
	function listAdminOrderDetail(data) {
		$(".order").remove();
		
		var i = 0;
		$.each(data.pageList, function(index, order) {
			i = i + 1;
			var htmlStr = "<tr class='order'>";
			htmlStr += "<td><a class = 'orderId' href=''>" + order.orderId + "</a></td>";
			htmlStr += "<td>" + order.normalUser.userName + "</td>";
			htmlStr += "<td>" + order.carType.brand.brandName + order.carType.cartypeName + "/";
			htmlStr += order.carInfo.carJiegou + "/" + order.carInfo.carPailiang + order.carInfo.carBox + "</td>";
			htmlStr += "<td>" +  new Date( parseInt(order.getDate) ).toLocaleDateString() + "</td>";
			htmlStr += "<td>" +  new Date( parseInt(order.reDate) ).toLocaleDateString() + "</td>";
			htmlStr += "<td class = 'orderStateName'>";
			switch (order.orderState) {
			case 0:
				htmlStr += "未付款";
				break;
			case 1:
				htmlStr += "已取消";
				break;
			case 2:
				htmlStr += "已关闭";
				break;
			case 3:
				htmlStr += "交易成功";
				break;
			default:
				break;
			}
			htmlStr += "</td>";
			htmlStr += "<td>" + order.fee + "</td>";
			htmlStr += "<td>";
			htmlStr += "<input type='hidden' class = 'userId' value = '"+ order.normalUser.userId +"'/>";
			htmlStr += "<input type='hidden' class = 'carId' value = '"+ order.carInfo.carId +"'/>";
			switch (order.orderState) {
			case 0:
				htmlStr += "<input class = 'confirmRentCar' type='button' value='确认'/>";
				break;
			case 3:
				htmlStr += "<input type='hidden' class = 'userId' value = '"+ order.normalUser.userId +"'/>";
				htmlStr += "<input type='hidden' class = 'carId' value = '"+ order.carInfo.carId +"'/>";
				htmlStr += "<input class = 'closeRentCar' type='button' value='关闭'/>";
				break;
			default:
				break;
			}
			htmlStr += "</td>";
			htmlStr += "</tr>";
			$("#orderTable tbody").append(htmlStr);
		});
	}
	
	function listOrderDetail(data) {
		$(".order").remove();
		
		var i = 0;
		$.each(data.pageList, function(index, order) {
			i = i + 1;
			var htmlStr = "<tr class='order'>";
			htmlStr += "<td>" + order.normalUser.userName + "</td>";
			htmlStr += "<td><a class = 'orderId' href=''>" + order.orderId + "</a></td>";
			htmlStr += "<td>" + order.carType.brand.brandName + order.carType.cartypeName + "/";
			htmlStr += order.carInfo.carJiegou + "/" + order.carInfo.carPailiang + order.carInfo.carBox + "</td>";
			htmlStr += "<td>" +  new Date( parseInt(order.getDate) ).toLocaleDateString() + "</td>";
			htmlStr += "<td>" +  new Date( parseInt(order.reDate) ).toLocaleDateString() + "</td>";
			htmlStr += "<td class = 'orderStateName'>";
			switch (order.orderState) {
			case 0:
				htmlStr += "未付款";
				break;
			case 1:
				htmlStr += "已取消";
				break;
			case 2:
				htmlStr += "已关闭";
				break;
			case 3:
				htmlStr += "交易成功";
				break;
			default:
				break;
			}
			htmlStr += "</td>";
			htmlStr += "<td>";
			switch (order.orderState) {
			case 0:
				htmlStr += "<input type='hidden' class = 'userId' value = '"+ order.normalUser.userId +"'/>";
				htmlStr += "<input type='hidden' class = 'carId' value = '"+ order.carInfo.carId +"'/>";
				htmlStr += "<input class = 'cancelRentCar' type='button' value='取消'/>";
				break;
			default:
				break;
			}
			htmlStr += "</td>";
			htmlStr += "</tr>";
			$("#orderTable tbody").append(htmlStr);
			
		});
	}
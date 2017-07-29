function cancelBrandName() {
	$(".addNewbrandName").hide();
	$(".inBrandName").val("");
}

function cancelCarType() {
	$(".addNewCarType").hide();
	$(".inCarTypeName").val("");
}

function addCarType() {
	$(".addNewCarType").show();
}

function addBrand() {
	$(".addNewbrandName").show();
}

function addNewbrandName() {
	// 把参数提交给Action
	var location = (window.location+'').split('/');
	var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
	
	$.ajax({
		url: "CarInfoServlet",
		type: 'GET',
		data: {
			opr: "addBrandName",
			brandName: $(".inBrandName").val()
		},
		dataType: 'json',
		success: function(data) {
			if (data == 'false') {
				$(".inBrandName").val("");
				alert("输入了重复的车辆品牌");
			} else {
				$("#brandName").append($("<option value='"+ data.brandId +"' >" + data.brandName +"</option>"));
				cancelBrandName();
			}
		}
	})
	cancelBrandName();
}

function brandNameChange() {
	// document.getElementsByName("brandId")[0].value = document.getElementsByClassName("brandNameC")[0].value;
	var location = (window.location+'').split('/');
	var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
	
	$.ajax({
		url: "CarInfoServlet",
		type: 'GET',
		data: {
			opr: "getCarTypeOptions",
			brandId: $("#brandName").val()
		},
		dataType: 'json',
		success: function(data) {
			if (data.length == 0) {
				alert("该品牌下没有具体类型的车");
			} else {
				$("#cartypeName").html("");
				$("#cartypeName").append("<option value='-1'>--请输入型号--</option>");
				$.each(data, function(index, carType) {
					$("#cartypeName").append($("<option value='"+ carType.cartypeId +"' >" + carType.cartypeName +"</option>"));
				})
				
				cancelCarType();
			}
		}
	})
	cancelCarType();
	
}

function cartypeNameChange() {
	if ($("#brandName").val() == -1) {
		$("#cartypeName").html("");
		$("#cartypeName").append("<option value='-1'>--请输入型号--</option>");
		$("#cartypeName").prop('selectedIndex', 0);
	}
}

function delCatInfo($selectObj) {
	
	var location = (window.location+'').split('/');
	var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
	var nextPage = parseInt($("#pageNo").html());
	var pageTotle = parseInt($("#pageTotle").html());
	if (pageTotle == 1) {
		nextPage = 1;
	} else if($(".row").size() <= 1) {
		nextPage = nextPage - 1;
	}
	
	console.log($selectObj.parent().parent().find(".carIdVal").val());
	
	var brandName = $(".BrandName").val();
	
	if (brandName == null) {
		brandName = "";
	}
	
	$.ajax({
		url: "CarInfoServlet",
		type: 'GET',
		data: {
			opr: "delCarInfo",
			page: nextPage,
			brandName: brandName,
			carInfoId: $selectObj.parent().parent().find(".carIdVal").val()
		},
		dataType: 'json',
		success: function(data) {
			listCarInfo(data);
			$("#pageNo").html(nextPage);
			$("#pageTotle").html(data.total);
		}
	});
	
	$selectObj.parent().parent().remove();
}

function addCarTypeName() {
	
	if ($("#brandName").val() != -1) {
		$.ajax({
			url: "CarInfoServlet",
			type: 'GET',
			data: {
				opr: "addCarType",
				brandId: $("#brandName").val(),
				carTypeName: $(".inCarTypeName").val()
			},
			dataType: 'json',
			success: function(data) {
				$("#cartypeName").html("");
				$("#cartypeName").append("<option value='-1'>--请输入型号--</option>");
				var flag = false;
				var tmp = null;
				$.each(data, function(index, carType) {
					$("#cartypeName").append($("<option value='"+ carType.cartypeId +"' >" + carType.cartypeName +"</option>"));
					if ($(".inCarTypeName").val() == carType.cartypeName) {
						tmp = carType.cartypeId;
						flag = true;
					}
				})
				
				if (flag) {
					$("#cartypeName").find("option[value="+ tmp +"]").attr("selected",true);
				}
				
				cancelCarType();
			}
		});
	} else {
		alert("请选择品牌名称");
	}
}

function listCarInfoRow($select, index, carInfo) {
	$select.parent().append(
			"<tr class = 'row' id = '"+ carInfo.carId +"'>"
			+	"<input type='hidden' class='carIdVal' value='"+ carInfo.carId +"'/>"
			+	"<td><a href=''>" + index + "</a></td>"
			+	"<td>" + carInfo.carType.brand.brandName + "</td>"
			+	"<td>" + carInfo.carType.cartypeName + "</td>"
			+	"<td>" + carInfo.carJiegou + "</td>"
			+	"<td>" + carInfo.carPailiang + "/" + carInfo.carBox + "</td>"
			+	"<td>" + carInfo.carPeople + "</td>"
			+	"<td>" + (carInfo.price).toFixed(2) + "</td>"
			+	"<td>" + (carInfo.discount).toFixed(2) + "</td>"
			+	"<td>"
			+		"<a class='updateCarInfo' href='CarInfoServlet?opr=alterCarInfoCon&carInfoId=" + carInfo.carId +"'>更新</a>"
			+		"<input type = 'button' class = 'delOneRow' value = '删除'/>"
			+	"</td>"
			+"</tr>");
}

function listCarInfo(data) {
	$(".row").remove();
	
	var i = 0;
	$.each(data.pageList, function(index, carInfo) {
		i = i + 1;
		listCarInfoRow($(".top"), i, carInfo);
	});
}

function initUpdateCarInfo() {
	$.ajax({
		url: 'CarInfoServlet',
		data: {
			opr: 'queryByBrandName',
			brandName: $(".BrandName").val()
		},
		dataType: 'json',
		success: function (data) {
			listCarInfo(data);
			$("#pageNo").html("1");
			$("#pageTotle").html(data.total);
		}
	});
}

function delOneRow() {
	if (confirm("确认删除?")) {
		delCatInfo($(this));
	}
}
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

function delCatInfo(index, carId, selectObj) {
	
	alert(index, carId + $(selectObj).val())
	var location = (window.location+'').split('/');
	var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
	
	$.ajax({
		url: "CarInfoServlet",
		type: 'GET',
		data: {
			opr: "delCarInfo",
			carInfoId: carId
		},
		dataType: 'json',
		success: function(data) {
			$("#" + index).remove();
		}
	});
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
						alert("输入了重复的车辆型号");
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
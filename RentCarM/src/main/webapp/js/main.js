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
			if (data.message == null) {
				$selectObj.parent().parent().remove();
				listCarInfo(data);
				$("#pageNo").html(nextPage);
				$("#pageTotle").html(data.total);
			} else {
				alert(data.message.w01);
			}
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

function options(opr, obj) {
	$("input[name=" + opr + "]:" + obj).click(function() {
		if ($(this).val() == 0) {
			if ($(this).is(":checked")) {
				$(this).parent("li").nextAll().hide();
				$(this).parent("li").nextAll().find("input").removeAttr("checked");
				$("input[name=dailyRateFrom]").val("");
				$("input[name=dailyRateTo]").val("");
			} else {
				$(this).parent("li").nextAll().show();
			}
		}
	});
}

function validatePrice(obj) {
	$("input[name= " + obj + "]").blur(function () {
		var patern = /^\d+(\.\d{1,2})?$/g;
		
		if ($(this).val() == '') {
			$("input[name=dailyRate]").prop("disabled",false);
			return;
		}
		
		$("input[name=dailyRate]").prop("disabled",true);
		
		if (!patern.test($(this).val())) {
			$("#validatePrice").css({
				color: "red",
				display: "inline"
			});
		} else {
			$("#validatePrice").css({
				display: "none"
			});
			var dailyRateFrom = parseInt($("input[name=dailyRateFrom]").val());
			var dailyRateTo = parseInt($("input[name=dailyRateTo]").val());
			
			if (dailyRateFrom != 0 && dailyRateTo != 0) {
				if (dailyRateTo - dailyRateFrom < 0) {
					$("#validatePrice").css({
						color: "red",
						display: "inline"
					});
				} else {
					$("#validatePrice").css({
						display: "none"
					});
				}
			}
		}
	});
}

function initIndexPage() {
	choiceCar(1);
}

function choiceCar(pageNumber) {
	var pageData = {};
	
	pageData.level = [];
	
	$("input[name=level]:checked").each(function() {
		if ($(this).val() != 0) {
			pageData.level.push($(this).val());
		}
	});
	
	pageData.brand = [];
	
	$("input[name=brand]:checked").each(function() {
		if ($(this).val() != 0) {
			pageData.brand.push($(this).val());
		}
	});
	
	pageData.price = [];
	
	var dailyRateFrom = parseInt($("input[name=dailyRateFrom]").val());
	var dailyRateTo = parseInt($("input[name=dailyRateTo]").val());
	
	if (isNaN(dailyRateFrom)) {
		dailyRateFrom = 0;
	}
	
	if (isNaN(dailyRateTo)) {
		dailyRateTo = 0;
	}
	
	if (dailyRateFrom != 0 || dailyRateTo != 0) {
		pageData.price = [dailyRateFrom, dailyRateTo];
	}
	
	switch ($("input[name=dailyRate]:checked").val()) {
		case '0':
			pageData.price = [];
			break;
		case '1':
			pageData.price = [0, 150];
			break;
		case '2':
			pageData.price = [150, 300];
			break;
		case '3':
			pageData.price = [300, 500];
			break;
		case '4':
			pageData.price = [500, 0];
			break;
		default:
			break;
	}
	
	if ($("input[name=defaultSort]").is(":checked")) {
		pageData.defaultSort = true;
	} else {
		pageData.defaultSort = false;
	}
	
	if ($("input[name=toHighSort]").is(":checked")) {
		pageData.RrlPriceSort = true;
	} else {
		pageData.RrlPriceSort = false;
	}
	
	if ($("input[name=stockOnlySort]").is(":checked")) {
		pageData.stockOnlySort = true;
	} else {
		pageData.stockOnlySort = false;
	}
	
	pageData.pageNumber = pageNumber;
	
	$.ajax({
		url: "CarInfoServlet",
		data: {
			opr: "choiceCar",
			pageData: pageData
		},
		type: 'GET',
		dataType: 'json',
		success: function(data) {
			listCarInfoDetail(data);
			$("#pageNumber").html(data.count);
			$("#totalPage").html(data.total);
		}
	});
}

function listCarInfoDetail(data) {
	$(".car").remove();
	
	var i = 0;
	$.each(data.pageList, function(index, carInfo) {
		i = i + 1;
		
		var htmlStr = "<div class = 'car' ><div>";
		htmlStr += "<img src='CarInfoServlet?opr=getImg&carId="+ carInfo.carId +"' height = '80' width='200'/>";
		htmlStr += "</div><div><ul><li>";
		
		// htmlStr += "<li><img src='images/homepage/'/>";
		htmlStr += "<span>" + carInfo.carType.brand.brandName + "</span></li>";
		htmlStr += "<li><img src='images/homepage/carInformation.png'/>";
		htmlStr += "<span>" + carInfo.carJiegou + "/"+ carInfo.carPailiang +"" + carInfo.carBox +"</span></li>";
		htmlStr += "<li><img src='images/homepage/memberLimit.png'/>";
		htmlStr += "<span>乘坐" + carInfo.carPeople + "人</span></li></ul></div>";
		
		var price = parseFloat(carInfo.price).toFixed(2);
		var discount = parseFloat(carInfo.discount).toFixed(2) * 0.01;
		htmlStr += "<div><p>￥<span>"+ (price * discount).toFixed(2) +"</span>/日均</p>";
		htmlStr += "<p>原价：￥" + price + "</p> </div>";
		htmlStr += "<div class='submit'><input id = 'carId' type = 'hidden' value = '"+ carInfo.carId +"'/><input class = 'rentCar' type='button' value='租车' ";
		if (carInfo.carState == '0') {
			htmlStr += "disabled = 'disabled'";
		}
		htmlStr +=" /></div>";
		
		$("#insideSection").append(htmlStr);
		
	});
}

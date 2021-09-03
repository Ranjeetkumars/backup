$(document).ready(function() {
	loadClassification();
	loadCountry();

});

/*
 * @Author : Ranjeet kumr
 * 
 * @Desc : loadClassification
 */
function loadClassification() {
	try {
		$('#classification_id').empty();
		var strUrl = Service.loadClassification;
		console.log("loadClassification Url is:" + strUrl);
		$.ajax({
			type : 'GET',
			url : strUrl,
			dataType : 'json',
			async : false,
			success : function(data) {
				var responsecode = data.responseCode;
				if (200 !== responsecode) {

				} else {
					var jsonArray = data.objSupplierControllerDTO;
					var selectfirst = "<option value='0'>"
							+ dropdownConstantobj.drop_down + "</option>";
					$('#classification_id').append(selectfirst);
					$.each(jsonArray, function(i, resData) {
						var schedule = "<option value="
								+ resData.classificationid + ">"
								+ resData.classificationName + "</option>";
						$(schedule).appendTo('#classification_id');
					});
				}
			},
			error : function(err) {
				console.error("Error in Classification" + JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error('Error in Classification()' + err);
	}
	$('#classification_id').trigger("chosen:updated");
	$('#classification_id').chosen();
}

/*
 * @Author : Ranjeet kumr
 * 
 * @Desc : loadClassification
 */
function loadCountry() {

	try {
		$('#country_id').empty();
		var strUrl = Service.loadCountry;
		console.log("loadCountry Url is:" + strUrl);
		$.ajax({
			type : 'GET',
			url : strUrl,
			dataType : 'json',
			async : false,
			success : function(data) {
				var responsecode = data.responseCode;
				if (200 !== responsecode) {

				} else {
					var jsonArray = data.objSupplierControllerDTO;
					var selectfirst = "<option value='0'>"
							+ dropdownConstantobj.drop_down + "</option>";
					$('#country_id').append(selectfirst);
					$.each(jsonArray, function(i, resData) {
						var country = "<option value=" + resData.countryid
								+ ">" + resData.countryName + "</option>";
						$(country).appendTo('#country_id');
					});
				}
			},
			error : function(err) {
				console.error("Error in loadcountry" + JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error('Error in loadcountry()' + err);
	}
	$('#country_id').trigger("chosen:updated");
	$('#country_id').chosen();
}

/*function loadState() {
	alert('loadStateloadStateloadStateloadState');
	
	var strUrl = Service.loadState;
	alert(strUrl);
	var countryId = $('#country_id').val();
	var json_Availability_Details = {
		"countryid" : 1
	};
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify(json_Availability_Details),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		headers : {
			"X-TENANT-ID" : "PROCREATE"
		},
		success : function(data) {
			alert("data::" + data);
		},
		error : function(err) {
			console.error('itemSearch  error: ' + JSON.stringify(err));
		}
	});

}*/

function loadDistrict() {
	$("#district_id").empty();
	var state_id = $('#state_id').val();
	var strUrl = Service.loadDistrict;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"stateid" : state_id
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objSupplierControllerDTO;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#state_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var dist = "<option value=" + resData.districtid + ">"
							+ resData.districtName + "</option>";
					$(dist).appendTo('#district_id');
				});
			}
		},
		error : function(err) {
			console.error('loadDistrict  error: ' + JSON.stringify(err));
		}
	});
	$('#district_id').trigger("chosen:updated");
	$('#district_id').chosen();
}

function loadCity() {
	$("#city_id").empty();
	var state_id = $('#state_id').val();
	var strUrl = Service.loadCity;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"stateid" : 1
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objSupplierControllerDTO;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#city_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var dist = "<option value=" + resData.cityid + ">"
							+ resData.cityName + "</option>";
					$(dist).appendTo('#city_id');
				});
			}
		},
		error : function(err) {
			console.error('loadDistrict  error: ' + JSON.stringify(err));
		}
	});
	$('#city_id').trigger("chosen:updated");
	$('#city_id').chosen();

}

function loadZipCode() {
	$("#zip_code").empty();
	var city_id = $('#city_id').val();
	var strUrl = Service.loadZipCode;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"cityid" : city_id
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objSupplierControllerDTO;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#zip_code').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var dist = "<option value=" + resData.zipCodeId + ">"
							+ resData.zipCode + "</option>";
					$(dist).appendTo('#zip_code');
				});
			}
		},
		error : function(err) {

			console.error('zip_code  error: ' + JSON.stringify(err));
		}
	});
	$('#zip_code').trigger("chosen:updated");
	$('#zip_code').chosen();
}

function loadLocality() {

	$("#address_id").empty();
	var zipcode = $('#zip_code').val();
	var strUrl = Service.loadLocality;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"cityid" : 1
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objSupplierControllerDTO;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#address_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var adddress = "<option value=" + resData.lacationId + ">"
							+ resData.lacationName + "</option>";
					$(adddress).appendTo('#address_id');
				});
			}
		},
		error : function(err) {
			console.error('loadLocality  error: ' + JSON.stringify(err));
		}
	});
	$('#address_id').trigger("chosen:updated");
	$('#address_id').chosen();

}

function loadLandmark() {
	$("#house_no").empty();
	var zipcode = $('#zip_code').val();
	var strUrl = Service.loadLandmark;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"localityid" : 1
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objSupplierControllerDTO;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#house_no').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var houseno = "<option value=" + resData.landmarkid + ">"
							+ resData.landmarName + "</option>";
					$(houseno).appendTo('#house_no');
				});
			}
		},
		error : function(err) {
			console.error('loadLocality  error: ' + JSON.stringify(err));
		}
	});
	$('#house_no').trigger("chosen:updated");
	$('#house_no').chosen();

}

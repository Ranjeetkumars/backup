$(document).ready(function() {
	loadBrandDetails();

});


function openModalBox() {
	console.log('openModalBox  javascript function is executed');
	$('#brandName').modal('show');
	$("#save_disable").attr("disabled", false);
	$("#reset_disable").attr("disabled", false);
	$("#item_approval_id").attr("disabled", false);
	$("#update_disable").attr("disabled", true);

}

function loadBrandDetails() {
	var strUrl = "http://localhost:2000/scmservice/BrandRegistrationController/loadBrandDetails";
	$.ajax({
		type : 'GET',
		url : strUrl,
		dataType : 'json',
		async : false,
		success : function(data) {
			if (data.responseCode == 200 || data.responseCode == "200") {
				loadBrands(data.objBrandDetailsControllerDTO);
				loadDataTable();
			}
		},
		error : function(err) {

			console.error('itemSearch  error: ' + JSON.stringify(err));
		}
	});

}
function saveBrandDetails() {
	var strUrl = "http://localhost:2000/scmservice/BrandRegistrationController/saveBrandDetails";

	var isStatus = ($('input:checkbox[name=checkme]').is(':checked'));
	var brandName = $('#brand_name_id').val();
	if (brandName == "" || brandName == '') {
		toastr.warning('Please enter Brand Name');
		return false;
	}

	$
			.ajax({
				type : "POST",
				url : strUrl,
				dataType : "json",
				data : JSON.stringify({
					"brandName" : brandName,
					"userId" : 268,
					"moduleId" : 40,
					"roleId" : 100,
					"status" : isStatus
				}),
				contentType : "application/json",
				async : false,
				crossDomain : true,
				success : function(data) {
					if (data.rtnReponseCount == "1"
							|| data.rtnReponseCount == 1) {
						toastr.info('Brand Registred successfully');
						resetMaster();
						$('#brandName').modal('hide');
						loadBrandDetails();
					} else if (data.rtnReponseCount == "0"
							|| data.rtnReponseCount == 0) {
						toastr.info('Same Brand already exist');
						resetMaster();
						$('#brandName').modal('hide');
						loadBrandDetails();
					} else {
						toastr.info('Something went wrong! try again');
					}
				},
				error : function(err) {
					alert("@@@@@@@@@@@@@@@@@@@@@@@" + JSON.stringify(err));
					console.error('itemSearch  error: ' + JSON.stringify(err));
				}
			});

}

function resetMaster() {
	$('#brand_name_id').val('');
	$('#myCheckbox').attr('checked', false);
}

var intbrandId;
function getRowValues(brandId, brandName, status) {
	intbrandId = brandId;
	alert('@@@@@@@@@@@@@@@@@@@@@@@@@@');
	$('#brandName').modal('show');
	$("#save_disable").attr("disabled", true);
	$("#reset_disable").attr("disabled", true);
	$("#update_disable").attr("disabled", false);
	$('#brand_name_id').val(brandName);

	if (status == "Active" || status == 'Active') {

		$('#myCheckbox').attr('checked', true); // Checks it
	} else {
		$('#myCheckbox').attr('checked', false); // Unchecks it
	}

}

function updateBrand() {
	var isStatus = ($('input:checkbox[name=checkme]').is(':checked'));
	var brandName = $('#brand_name_id').val();
	var strUrl = "http://localhost:2000/scmservice/BrandRegistrationController/UpdateDrugDetails";
	$
			.ajax({
				type : "POST",
				url : strUrl,
				dataType : "json",
				data : JSON.stringify({
					"brandId" : intbrandId,
					"brandName" : brandName,
					"userId" : 268,
					"moduleId" : 40,
					"roleId" : 100,
					"status" : isStatus
				}),
				contentType : "application/json",
				async : false,
				crossDomain : true,
				success : function(data) {
					if (data.rtnReponseCount == "1"
							|| data.rtnReponseCount == 1) {
						toastr.info('Brand updated successfully');
						resetMaster();
						$('#brandName').modal('hide');
						loadBrandDetails();
					} else if (data.rtnReponseCount == "0"
							|| data.rtnReponseCount == 0) {
						toastr.info('Same Brand already exist');
						resetMaster();
						$('#brandName').modal('hide');
						loadBrandDetails();
					} else {
						toastr.info('Something went wrong! try again');
					}
				},
				error : function(err) {
					alert("@@@@@@@@@@@@@@@@@@@@@@@" + JSON.stringify(err));
					console.error('itemSearch  error: ' + JSON.stringify(err));
				}
			});
}


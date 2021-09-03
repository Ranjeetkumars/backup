var int_classification_id;



function openModalBoxForRegistration_and_update() {

	$('#registration').modal('show');
	restSuppliers();
	$("#reset_disable").attr("disabled", false);
	$("#update_disable").attr("disabled", true);
	$("#save_disable").attr("disabled", false);
}

$(document).ready(function() {
	
	loadSuppliers();

});

function loadSuppliers() {

	var strUrl = vendorManagement.loadSuppliers;
	// alert('strUrl::'+strUrl);
	try {
		$.ajax({
			type : 'GET',
			url : strUrl,
			dataType : 'json',
			async : false,
			success : function(data) {
				var responsecode = data.responseCode;
				if (200 !== responsecode) {
				} else {
					loadSupplierDom(data.objControllerDto);
					applayDataTable();
				}
			},
			error : function(err) {
				console.error("Error in loadSupplierClassification"
						+ JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error('Error in loadSupplierClassification' + err);
	}
}

function loadSupplierDom(jsonArray) {

	// $("#disabled_update").attr("disabled", true);
	// $('#serviceRemainder').empty();
	// $('#serviceRemainder').DataTable().clear().destroy();

	$('#serviceRemainder').dataTable().fnClearTable();
	$('#serviceRemainder').dataTable().fnDestroy();
	for (var i = 0; i < jsonArray.length; i++) {
		$("#supplirDom")
				.append(
						'<tr><td>'
								+ jsonArray[i].supplierId
								+ '</td>'
								+ '<td>'
								+ jsonArray[i].supplierName
								+ '</td>'
								+ '<td>'
								+ jsonArray[i].isActive
								+ '</td>'
								+ '<td><button type="button" class="btn btn-primary btn-sm" data-toggle="modal" onclick="getSupplierDetailsBasedOnId('
								+ jsonArray[i].supplierId
								+ ')"><span class="fa fa-edit"></span> Edit</button></td>'
								+ '</tr>');

	}

}

function applayDataTable() {
	$('#serviceRemainder').DataTable(
			{
				"aLengthMenu" : [ [ 05, 10, 15, 25, -1 ],
						[ 05, 10, 15, 25, "All" ] ],
				pageLength : 5,
				responsive : true,
				dom : '<"html5buttons"B>lTfgitp',
				buttons : [
						{
							extend : 'copy'
						},
						{
							extend : 'csv'
						},
						{
							extend : 'excel',
							title : 'ExampleFile'
						},
						// {extend: 'pdf', title: 'ExampleFile'},
						{
							extend : 'print',
							customize : function(win) {
								$(win.document.body).addClass('white-bg');
								$(win.document.body).css('font-size', '10px');

								$(win.document.body).find('table').addClass(
										'compact').css('font-size', 'inherit');
							}
						} ]

			});
}

function saveSuppliers() {

	var rtnsupplierJsonObj = suppliersValidation();

	if (rtnsupplierJsonObj == false || rtnsupplierJsonObj == 'false') {
		return;
	}

	console.log('@@@@@@@@@@@@@@@@@@@@' + JSON.stringify(rtnsupplierJsonObj));
	var strUrl = vendorManagement.saveSupplier;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify(rtnsupplierJsonObj),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			if (data.rtnReponseCount == "1" || data.rtnReponseCount == 1) {
				toastr.info('Successfully saved');
				$('#registration').modal('hide');
				loadSuppliers();
			} else {
				toastr.info('vendor already exist');
				$('#registration').modal('hide');
				loadSuppliers();
			}
		},
		error : function(err) {
			console.error('itemSearch  error: ' + JSON.stringify(err));
		}
	});

}

function loadStateBasedOnCountryId() {
	var country_id = $("#state_id").val();
	var strUrl = vendorManagement.loadState;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"countryid" : 1
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {

			} else {
				var jsonArray = data.objSupplierControllerDTO;
				var selectfirst = "<option value='0'>Select State</option>";
				$('#state_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var state = "<option value=" + resData.stateid + ">"
							+ resData.stateName + "</option>";
					$(state).appendTo('#state_id');
				});
			}
		},
		error : function(err) {
			console.error('loadStateBasedOnCountryId  error: '
					+ JSON.stringify(err));
		}
	});
	$('#state_id').trigger("chosen:updated");
	$('#state_id').chosen();
}

function suppliersValidation() {
	var vendorName = $('#vendor_name').val();
	var classification = $('#classification_id').val();
	var country = $('#country_id').val();
	var state = $('#state_id').val();
	var district = $('#district_id').val();
	var city = $('#city_id').val();
	var zip = $('#zip_code').val();
	var address = $('#address_id').val();
	var house = $('#house_no').val();
	var pincode = $('#pin_code').val();
	var contactPerson = $('#contact_person').val();
	var telephoneNo = $('#telephone_id').val();
	var fax = $('#fax').val();
	var email = $('#email_id').val();
	var mobile_no = $('#mobile_no_id').val();
	var web_site = $('#web_site_id').val();
	var license = $('#license_no').val();
	var isStatus = ($('input:checkbox[name=checkme]').is(':checked'));
	if (vendorName == "" || vendorName == '') {
		toastr.warning(dropdownConstantobj.vendarName);
		return false;
	} else if (classification == "0" || classification == 0
			|| classification == '0') {
		toastr.warning(dropdownConstantobj.classification);
		return false;
	} else if (country == "0" || country == 0 || country == '0') {
		toastr.warning(dropdownConstantobj.country);
		return false;
	}

	else if (state == "0" || state == 0 || state == '0') {
		toastr.warning(dropdownConstantobj.state);
		return false;
	}

	else if (telephoneNo == "" || telephoneNo == '') {
		toastr.warning(dropdownConstantobj.telephoneNo);
		return false;
	} else if (telephoneNo == "" || telephoneNo == '') {
		toastr.warning(dropdownConstantobj.telephoneNo);
		return false;
	} else if (email == "" || email == '') {
		toastr.warning(dropdownConstantobj.email);
		return false;
	}

	if (int_classification_id == undefined
			|| int_classification_id == 'undefined ||int_classification_id==0') {
		var supplierJsonObj = {
			"suppliername" : vendorName,
			"countryid" : country,
			"stateid" : state,
			"districtid" : district,
			"mandalid" : zip,
			"cityid" : city,
			"localityid" : address,
			"landmarkid" : house,
			"email" : email,
			"website" : web_site,
			"licensenumber" : license,
			"telephone" : telephoneNo,
			"mobile" : mobile_no,
			"fax" : fax,
			"pincode" : pincode,
			"userid" : 161,
			"roleid" : 100,
			"moduleid" : 40,
			"status" : isStatus,
			"contactperson" : contactPerson,
			"classificationid" : classification
		};
		return supplierJsonObj;
	}

	else {
		var supplierJsonObj = {
			"supplierId" : int_classification_id,
			"suppliername" : vendorName,
			"countryid" : country,
			"stateid" : state,
			"districtid" : district,
			"mandalid" : zip,
			"cityid" : city,
			"localityid" : address,
			"landmarkid" : house,
			"email" : email,
			"website" : web_site,
			"licensenumber" : license,
			"telephone" : telephoneNo,
			"mobile" : mobile_no,
			"fax" : fax,
			"pincode" : pincode,
			"status" : isStatus,
			"contactperson" : contactPerson,
			"classificationid" : classification
		};

		return supplierJsonObj;
	}

}

function restSuppliers() {
	$("#classification_id").val('').trigger("chosen:updated");
	$("#country_id").val('').trigger("chosen:updated");
	$("#state_id").val('').trigger("chosen:updated");
	$("#district_id").val('').trigger("chosen:updated");
	$("#city_id").val('').trigger("chosen:updated");
	$("#address_id").val('').trigger("chosen:updated");
	$("#house_no").val('').trigger("chosen:updated");
	$('#pin_code').val('');
	$('#contact_person').val('');
	$('#telephone_id').val('');
	$('#fax').val('');
	$('#email_id').val('');
	$('#mobile_no_id').val('');
	$('#web_site_id').val('');
	$('#license_no').val('');
	
	
	
	
	

}
function getSupplierDetailsBasedOnId(classification_id) {
	$('#registration').modal('show');

	$("#reset_disable").attr("disabled", true);
	$("#update_disable").attr("disabled", false);
	$("#save_disable").attr("disabled", true);

	var strUrl = vendorManagement.getSupplier;
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"supplierId" : classification_id
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var jsonArray = data.objSupplierControllerDTO;
			int_classification_id = classification_id;
			appendDataForUpdate(jsonArray);

		},
		error : function(err) {

			console.error('loadLocality  error: ' + JSON.stringify(err));
		}
	});

}

function appendDataForUpdate(jsonArray) {

	$('#vendor_name').val(jsonArray[0].suppliername);
	$('#pin_code').val(jsonArray[0].pincode);
	$('#contact_person').val(jsonArray[0].contactperson);
	$('#telephone_id').val(jsonArray[0].telephone);
	$('#fax').val(jsonArray[0].fax);
	$('#email_id').val(jsonArray[0].email);
	$('#mobile_no_id').val(jsonArray[0].mobile);
	$('#web_site_id').val(jsonArray[0].website);
	$('#license_no').val(jsonArray[0].licensenumber);

	$("#country_id option:contains(" + jsonArray[0].countryid + ")").attr(
			'selected', 'selected').trigger("chosen:updated");

	$(
			"#classification_id option:contains("
					+ jsonArray[0].classificationName + ")").attr('selected',
			'selected').trigger("chosen:updated");

	$("#state_id option:contains(" + jsonArray[0].stateid + ")").attr(
			'selected', 'selected').trigger("chosen:updated");
//int_classification_id
}

function updateSupplier() {
	console.log('supplier Ids::'+int_classification_id);
	var rtnvalidationStatus = suppliersValidation();
	if (rtnvalidationStatus == false || rtnvalidationStatus == 'false') {
		return false;
	}
	var strUrl = "http://localhost:2000/scmservice/SupplierController/updateSupplier";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify(rtnvalidationStatus),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			alert('datadata::'+JSON.stringify(data))
			if (data.rtnReponseCount == 1 || data.rtnReponseCount == "1") {
				toastr.info('Vendor Details updated successfully');
				restSuppliers();
			}
		},
		error : function(err) {
			console.error('loadLocality  error: ' + JSON.stringify(err));
		}
	});

}

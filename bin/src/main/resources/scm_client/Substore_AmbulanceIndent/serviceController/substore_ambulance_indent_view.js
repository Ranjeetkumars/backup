$(document).ready(function() {

	loadIndentStatus();
	loadStores();
	centralSubStore();
});
var currentDate;
$(function() {
	$("#today_date_id").click(function() {
		if ($(this).is(":checked")) {
			alert('checked');
			currentDate = new Date().toJSON().slice(0, 10).replace(/-/g, '/');
			// $('#mydate').datepicker('enable');
		} else {
			currentDate = 'undefined';
			alert('unchecked');
		}
	});
});

function loadIndentStatus() {
	alert("loadIndentStatus");
	var strUrl = "http://localhost:2000/scmservice/indentItemListController/loadIndentStatus";
	$('#indent_sttaus_id').empty();
	$.ajax({
		type : 'GET',
		url : strUrl,
		dataType : 'json',
		async : false,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objIndentItemListControllerDTO;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#indent_sttaus_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var loadIndentStatus = "<option value="
							+ resData.indentStatus + ">"
							+ resData.indent_status_type + "</option>";
					$(loadIndentStatus).appendTo('#indent_sttaus_id');
				});
			}
		},
		error : function(err) {
			alert("@@@@@@@@@@@@@@@@@@@@@@@" + JSON.stringify(err));
			console.error('loadIndentStatus  error: ' + JSON.stringify(err));
		}
	});
	$('#indent_sttaus_id').trigger("chosen:updated");
	$('#indent_sttaus_id').chosen();

}

// http://localhost:2000/scmservice/expiryDrugsController/loadStores

function loadStores() {
	alert("loadIndentStatus");
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/loadStores";
	$('#sub_store_id').empty();
	$.ajax({
		type : 'GET',
		url : strUrl,
		dataType : 'json',
		async : false,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objControllerDto;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#sub_store_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var loadIndentStatus = "<option value=" + resData.countryId
							+ ">" + resData.countryName + "</option>";
					$(loadIndentStatus).appendTo('#sub_store_id');
				});
			}
		},
		error : function(err) {
			alert("@@@@@@@@@@@@@@@@@@@@@@@" + JSON.stringify(err));
			console.error('loadIndentStatus  error: ' + JSON.stringify(err));
		}
	});
	$('#sub_store_id').trigger("chosen:updated");
	$('#sub_store_id').chosen();

}

function centralSubStore() {
	alert("loadIndentStatus");
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/loadStores";
	$('#central_sub_store_id').empty();
	$.ajax({
		type : 'GET',
		url : strUrl,
		dataType : 'json',
		async : false,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objControllerDto;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#central_sub_store_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var loadIndentStatus = "<option value=" + resData.countryId
							+ ">" + resData.countryName + "</option>";
					$(loadIndentStatus).appendTo('#central_sub_store_id');
				});
			}
		},
		error : function(err) {
			alert("@@@@@@@@@@@@@@@@@@@@@@@" + JSON.stringify(err));
			console.error('loadIndentStatus  error: ' + JSON.stringify(err));
		}
	});
	$('#central_sub_store_id').trigger("chosen:updated");
	$('#central_sub_store_id').chosen();

}

// http://localhost:2001/scmservice/indentViewController/load_to_store

function load_to_store() {
	$('#central_sub_store_id').empty();
	var strUrl = "http://localhost:2000/scmservice/indentViewController/load_to_store";
	var fromsubStoreId = $('#sub_store_id').val();
	alert('fromsubStoreId value::' + fromsubStoreId);
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"counterId" : 99999//In  Old Scm Code they are passing static value as 99999
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objIndentViewControllerDTO;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#central_sub_store_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var substore = "<option value=" + resData.counterId + ">"
							+ resData.counterName + "</option>";
					$(substore).appendTo('#central_sub_store_id');
				});
			}
		},
		error : function(err) {
			alert("@@@@@@@@@@@@@@@@@@@@@@@" + JSON.stringify(err));
			console.error('loadDistrict  error: ' + JSON.stringify(err));
		}
	});
	$('#central_sub_store_id').trigger("chosen:updated");
	$('#central_sub_store_id').chosen();

}

function loadIndentRaisedSearch() {

	var intFromStore = 0;
	var intToStore = 0;

	var fromDate = $('#from_Date_id').val();
	var todate = $('#to_date_id').val();
	var subStore = $('#sub_store_id').val();
	var centralSubStore = $('#central_sub_store_id').val();

	console.log('fromDate::' + fromDate);
	console.log('todate::' + todate);
	console.log('Current date::' + currentDate);

	if (!currentDate == "" || !currentDate == '' || !currentDate == undefined
			|| !currentDate == 'undefined') {
		console.log('inside if-condition');
		todate = currentDate;
		fromDate = currentDate;
	} else {
		if (fromDate == "" && todate == "" && subStore == "0"
				&& centralSubStore == "0" && currentDate == 'undefined') {

			toastr.warning('Please select any search criteria');
			return false;
		}

		if(!fromDate==""&&todate==""){
			toastr.warning('Please select To Date');
			return false;
		}
		if(!todate==""&&fromDate==""){
			toastr.warning('Please select From Date');
			return false;
		}
		
		
		if(!subStore=="0"&&centralSubStore=="0"){
			toastr.warning('Please select To Store');
			return false;
		}
		if(!centralSubStore=="0"&&subStore=="0"){
			toastr.warning('Please select From Store');
			return false;
		}
	}

	var changeFromDateFormate = moment(fromDate).format('YYYY-MM-DD');
	var changeToDateFormate = moment(todate).format('YYYY-MM-DD');

	var indentStatus = $('#indent_sttaus_id').val();
	if (indentStatus == 0 || indentStatus == '0') {
		toastr.warning('Please select Indent status');
		return false;
	}
	var strUrl = "http://localhost:2000/scmservice/indentItemListController/loadIndentRaisedSearch";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"from_date" : changeFromDateFormate,
			"to_date" : changeToDateFormate,
			"from_store" : intFromStore,
			"to_store" : intToStore,
			"indentStatus" : indentStatus
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			console.log('data::' + JSON.stringify(data));
			if (data.responseCode == 200 || data.responseCode == '200') {
				$('#indent_view').empty();
				ambulanceIndentView(data.objIndentItemListControllerDTO);
				loadDataTable();
				clearAll();
			} else {
				toastr.info('Data Not found');
			}
		},
		error : function(err) {
			toastr.error("Something went wrong! try again" + JSON.stringify(err));
			console.error('loadDistrict  error: ' + JSON.stringify(err));
		}
	});

}



function clearAll(){
	alert('clearAll function is executed');
	$('#from_Date_id').val('');
	$('#to_date_id').val('');
	$("#sub_store_id").val('').trigger("chosen:updated");
	$("#central_sub_store_id").val('').trigger("chosen:updated");
	$("#indent_sttaus_id").val('').trigger("chosen:updated");
	$('input[type=checkbox]').prop('checked', false);
}

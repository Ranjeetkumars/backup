$(document).ready(function() {
	loadRackDetails();
	loadStore();
});

function openModalBox() {
	console.log('openModalBox  javascript function is executed');
	$('#rackMaster').modal('show');
	$("#save_disable").attr("disabled", false);
	$("#reset_disable").attr("disabled", false);
	$("#update_disable").attr("disabled", true);

}

function loadStore() {
	var strUrl = MASTER_END_POINT.loadStores;
	
	$('#load_store_id').empty();
	console.log("loadForm Url is:" + strUrl);
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
				var selectfirst = "<option value='0'>Select One </option>";
				$('#load_store_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var store = "<option value=" + resData.countryId + ">"
							+ resData.countryName + "</option>";
					$(store).appendTo('#load_store_id');
				});
			}
		},
		error : function(err) {
			console.error("Error in loadload_store_idStores"
					+ JSON.stringify(err));
		}
	});
	$('#load_store_id').trigger("chosen:updated");
	$('#load_store_id').chosen();
}
// localhost:2000/scmservice/RackDetailsController/loadRackDetails

function loadRackDetails() {
	
	var strUrl = MASTER_END_POINT.loadRackDetails;
	console.log('load Rack Details ::'+strUrl);
	console.log('localhost:2000/scmservice/RackDetailsController/loadRackDetails');
	$.ajax({
		type : 'GET',
		url : strUrl,
		dataType : 'json',
		async : false,
		success : function(data) {
            alert('success');
			listOfData(data.objRackDetailsControllerDTO);
			masterDataTable();
		},
		error : function(err) {
			console.error("Error in loadload_store_idStores"
					+ JSON.stringify(err));
			alert('Error!');
		}
	});

}

var gArrData;
function listOfData(arrData) {
	gArrData = arrData;
	destorTableBeforeLoad();
	var index = 0;
	for (var i = 0; i < arrData.length; i++) {
		index++;
		$('#list_of_rack_master_data_id')
				.append(
						'<tr>'
								+ '<td>'
								+ index
								+ '</td>'
								+ '<td>'
								+ arrData[i].rackName
								+ '</td>'
								+ '<td>'
								+ arrData[i].counterName
								+ '</td>'
								+ '<td>'
								+ arrData[i].status
								+ '</td>'
								+ '<td><button type="button" class="btn btn-primary btn-sm" onClick="getIds('
								+ i + ')">Edit</button></td>' + '</tr>');
	}

}
var intRackId;
function getIds(ids) {
	$("#save_disable").attr("disabled", true);
	$("#reset_disable").attr("disabled", true);
	$("#update_disable").attr("disabled", false);
	intRackId = gArrData[ids].rackId
	$('#rackMaster').modal('show');
	$('#rack_name_id').val(gArrData[ids].rackName);
	if (gArrData[ids].status == "Active"
			|| gArrData[ids].shelveName == 'Active') {
		$('#status_id').prop('checked', true);
	} else {
		$('#status_id').prop('checked', false);
	}

}

function masterDataTable() {

	$('#masterTable_id').DataTable(
			{
				"aLengthMenu" : [ [ 5, 10, 15, 25, 50, 75, -1 ],
						[ 5, 10, 15, 25, 50, 75, "All" ] ],
				"iDisplayLength" : 5,
				responsive : true,
				// "scrollY":"400px",
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
							title : 'TyreLifeData'
						},
						{
							extend : 'pdf',
							title : 'TyreLifeData'
						},
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

function destorTableBeforeLoad() {

	$('#masterTable_id').dataTable().fnClearTable();
	$('#masterTable_id').dataTable().fnDestroy();

}



function UpdateRackDetails() {
	var rackName = $('#rack_name_id').val();
	var load_store = $('#load_store_id').val();
	var isStatus = ($('input:checkbox[name=checkme]').is(':checked'));
	if(rackName ==""||rackName==''){
		toastr.error('Please enter Rack Name');
		return false;
	}
	if(load_store ==0||load_store=='0'){
		toastr.error('Please Select Store');
		return false;
	}
	
	var strUrl =  MASTER_END_POINT.UpdateRackDetails;
	console.log('update rack details::'+strUrl);
	
	var jsonObj = {
		"rackName" : rackName,
		"userId" : 185,
		"roleId" : 100,
		"moduleId" : 40,
		"storeId" : load_store,
		"rackId" : intRackId,
		"status" : isStatus
	}
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify(jsonObj),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			console.log('@@@@@@@@@@@@@@@@@@@@@:------------data'
					+ JSON.stringify(data));
			if (data.rtnReponseCount === 1 || data.rtnReponseCount === "1"
					|| data.rtnReponseCount === '1') {
				toastr.success('Successfully updated');
				$('#rackMaster').modal('hide');
				loadRackDetails();
			}
			if (data.responseCode == 500 || data.responseCode == '500') {
				toastr.error('Something went wrong');
			}
			if (data.rtnReponseCount === 0 || data.rtnReponseCount === "0"
					|| data.rtnReponseCount === '0') {
				toastr.success('Item is already Exists');
				$('#rackShelves').modal('hide');
				loadRackDetails();
			}
		},
		error : function() {
			console.log('something went wrong');
			console.log("Error In insertDrugDetails");
		}
	});
}





		
function saveRackDetails(){
	var rackName = $('#rack_name_id').val();
	var load_store = $('#load_store_id').val();
	var isStatus = ($('input:checkbox[name=checkme]').is(':checked'));
	if(rackName ==""||rackName==''){
		toastr.error('Please enter Rack Name');
		return false;
	}
	if(load_store ==0||load_store=='0'){
		toastr.error('Please Select Store');
		return false;
	}
	
	var strUrl = MASTER_END_POINT.saveRackDetails;
	console.log('register rack details url::'+strUrl);
	var jsonObj = {
			"rackName":rackName,
			"userId":185,
			"roleId":100,
			"moduleId":40,
			"storeId":load_store,
			"status":isStatus
	}
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify(jsonObj),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			console.log('@@@@@@@@@@@@@@@@@@@@@:------------data'
					+ JSON.stringify(data));
			if (data.rtnReponseCount === 1 || data.rtnReponseCount === "1"
					|| data.rtnReponseCount === '1') {
				toastr.success('Successfully saved');
				$('#rackMaster').modal('hide');
				loadRackDetails();
			}
			if (data.responseCode == 500 || data.responseCode == '500') {
				toastr.error('Something went wrong');
			}
			if (data.rtnReponseCount === 0 || data.rtnReponseCount === "0"
					|| data.rtnReponseCount === '0') {
				toastr.success('Item is already Exists');
				$('#rackShelves').modal('hide');
				loadRackDetails();
			}
		},
		error : function() {
			console.log('something went wrong');
			console.log("Error In insertDrugDetails");
		}
	}); 
}
		
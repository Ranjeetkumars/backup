$(document).ready(function() {
	loadMaterialForm();

});

function InventoryItemModel() {
	$('#inventoryformName').modal('show');
	loadMaterialGroup();
	$("#update_disable").attr("disabled", true);
	$("#reset_disable").attr("disabled", false);
	$("#save_disable").attr("disabled", false);
}

function loadMaterialGroup() {
	console.log('loadMaterialGroup');

	
	var strUrl = MASTER_END_POINT.loadMaterialGroup;
	try {
		$('#inventory_group_id').empty();
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
					var jsonArray = data.obMaterialGroupControllerDTO;
					var selectfirst = "<option value='0'>Select One </option>";
					$('#inventory_group_id').append(selectfirst);
					$.each(jsonArray, function(i, resData) {
						var inventoryFrom = "<option value=" + resData.groupId
								+ ">" + resData.groupName + "</option>";
						$(inventoryFrom).appendTo('#inventory_group_id');
					});
				}
			},
			error : function(err) {
				console.error("Error in inventory_group_id"
						+ JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error('Error in inventory_group_id()' + err);
	}
	$('#inventory_group_id').trigger("chosen:updated");
	$('#inventory_group_id').chosen();
}

function saveMaterialForm() {

	var isStatus = ($('input:checkbox[name="statusCheckBox"]').is(':checked'));
	var inventoryName = $('#inventory_item_id').val();
	var inventoryGroupId = $('#inventory_group_id').val();
	var strUrl = MASTER_END_POINT.saveMaterialForm;
    alert('strUrl::'+strUrl);
	if (inventoryName == "" || inventoryName == '') {
		toastr.error('Please enter inventory item form');
		return false;
	}
	if (inventoryGroupId == "0" || inventoryGroupId == 0) {
		toastr.error('Please select inventory group');
		return false;
	}
	
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"materialForm" : inventoryName,
			"userId" : 185,
			"roleId" : 100,
			"moduleId" : 40,
			"status" : isStatus,
			"materialFormId" : inventoryGroupId
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			console.log('@@@@@@@@@@@@@@@@@@@@@:------------data'
					+ JSON.stringify(data));

			if (data.rtnReponseCount === 1 || data.rtnReponseCount === "1"
					|| data.rtnReponseCount === '1') {
				toastr.success('Successfully saved');
				$('#inventoryformName').modal('hide');
				clearAllFilds();
				loadMaterialManufacture();

			}
		},
		error : function() {
			console.log('something went wrong');
			console.log("Error In insertDrugDetails");
		}
	});

}



function  loadMaterialForm(){
	alert('loadMaterialForm javascript function executed');
	
	var strUrl = MASTER_END_POINT.loadMaterialForm;	
	
	alert('strUrl::'+strUrl);
	$.ajax({
		type : 'GET',
		url : strUrl,
		dataType : 'json',
		async : false,
		success : function(data) {
			if (data.responseCode == 200 || data.responseCode == "200") {
				loadList(data.dto);
				dataTable();
			}
		},
		error : function(err) {
			console.error('itemSearch  error: ' + JSON.stringify(err));
		}
	});
	
	
}




function clearAllFilds() {
	$("#inventory_group_id").val('').trigger("chosen:updated");
	$('#inventory_item_id').val('');
	$('#status_id').prop("checked", false);

}


//"status": "Active",
//"materialGroupId": null,
//"serialId": "1",
//"fromType": "Equipment"


function loadList(strData) {
	$('#append_table').dataTable().fnClearTable();
	$('#append_table').dataTable().fnDestroy();
	arrData = strData;
	$('#list_of_inventory_item_id').empty();
	try {
		var sum = 0;
		for (var i = 0; i < strData.length; i++) {
			var index = i + 1;
			var tbleRow = document.createElement("tr");

			 var tablcol1 = document.createElement("td");
			  $(tablcol1).html(strData[i].serialId);
			  $(tbleRow).append(tablcol1);
			 

			var tablcol2 = document.createElement("td");
			$(tablcol2).html(strData[i].fromType);
			$(tbleRow).append(tablcol2);

			var tablcol4 = document.createElement("td");
			$(tablcol4).html(strData[i].status);
			$(tbleRow).append(tablcol4);

			var tablcol3 = document.createElement("td");
			$(tablcol3).html(strData[i].status);
			$(tbleRow).append(tablcol3);

			var tablcol9 = document.createElement("td");
			$(tablcol9).addClass('text-center');
			$(tablcol9)
					.append(
							'<button class="btn btn-primary btn-sm" data-toggle="modal" ><i class="fa fa-plus"></i>Update</button>');
			$(tablcol9).attr(
					'onclick',
					'get_RowData("' + strData[i].groupId + '","'
							+ strData[i].groupName + '","'
							+ strData[i].groupCode + '","' + strData[i].status
							+ '")');

			$(tablcol9).append(tablcol9);
			$(tablcol9).css('height', '36px');
			$(tbleRow).append(tablcol9);
			$("#list_of_inventory_item_id").append(tbleRow);
		}

	} catch (err) {
		console.log("list_of_inventory_item ERROR" + err);
	}

}


function dataTable() {
	$('#append_table').DataTable(
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
						{
							extend : 'pdf',
							title : 'ExampleFile'
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

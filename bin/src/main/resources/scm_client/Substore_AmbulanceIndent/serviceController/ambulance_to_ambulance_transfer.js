$(document).ready(function() {
	load_zones();
	load_to_zone();
});

function load_zones() {
	console.log('load_zones function is executed');
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/load_zones";
	$('#from_zone_id').empty();
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
				$('#from_zone_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var loadZone = "<option value=" + resData.locationId + ">"
							+ resData.locationName + "</option>";
					$(loadZone).appendTo('#from_zone_id');
				});
			}
		},
		error : function(err) {
			console.error('loadZone  error: ' + JSON.stringify(err));
		}
	});
	$('#from_zone_id').trigger("chosen:updated");
	$('#from_zone_id').chosen();

}
function load_to_zone() {
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/load_zones";
	$('#to_zone_id').empty();
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
				$('#to_zone_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var loadZone = "<option value=" + resData.locationId + ">"
							+ resData.locationName + "</option>";
					$(loadZone).appendTo('#to_zone_id');
				});
			}
		},
		error : function(err) {
			console.error('to_zone_id  error: ' + JSON.stringify(err));
		}
	});
	$('#to_zone_id').trigger("chosen:updated");
	$('#to_zone_id').chosen();

}

// 




function load_baselocations() {
	alert('load_baselocations');
	$('#from_base_location_id').empty();
	var fromZoneId = $('#from_zone_id').val();
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/load_baselocations";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"zoneId" : fromZoneId
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objControllerDto;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#from_base_location_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var baseLocation = "<option value=" + resData.baseLocationId + ">"
							+ resData.baseLocationName + "</option>";
					$(baseLocation).appendTo('#from_base_location_id');
				});
			}
		},
		error : function(err) {
			console.error('load_baselocations  error: ' + JSON.stringify(err));
		}
	});
	$('#from_base_location_id').trigger("chosen:updated");
	$('#from_base_location_id').chosen();

}


function load_to_baselocations() {
	
	$('#to_base_location_id').empty();
	var fromZoneId = $('#to_zone_id').val();
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/load_baselocations";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"zoneId" : fromZoneId
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objControllerDto;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#to_base_location_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					var baseLocation = "<option value=" + resData.baseLocationId + ">"
							+ resData.baseLocationName + "</option>";
					$(baseLocation).appendTo('#to_base_location_id');
				});
			}
		},
		error : function(err) {
			console.error('load_baselocations  error: ' + JSON.stringify(err));
		}
	});
	$('#to_base_location_id').trigger("chosen:updated");
	$('#to_base_location_id').chosen();

}

function load_vehicles(){
	$('#from_ambulance_id').empty();
	var baseLocationId = $('#from_base_location_id').val();
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/load_vehicles";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"baselocation" : baseLocationId
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objControllerDto;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#from_ambulance_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					
				/*	 "vehicleId": "1",
			            "permanentRegNo": "Arlington Pharmacy",
			            "vehicleTypeId": "1"*/
					
					var amb = "<option value=" + resData.vehicleId + ">"
							+ resData.permanentRegNo + "</option>";
					$(amb).appendTo('#from_ambulance_id');
				});
			}
		},
		error : function(err) {
			console.error('from_ambulance  error: ' + JSON.stringify(err));
		}
	});
	$('#from_ambulance_id').trigger("chosen:updated");
	$('#from_ambulance_id').chosen();
	
	
	
	
}












function to_load_vehicles(){
	$('#to_ambulance_id').empty();
	var baseLocationId = $('#to_base_location_id').val();
	var strUrl = "http://localhost:2000/scmservice/expiryDrugsController/load_vehicles";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"baselocation" : baseLocationId
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 !== responsecode) {
			} else {
				var jsonArray = data.objControllerDto;
				var selectfirst = "<option value='0'>"
						+ dropdownConstantobj.drop_down + "</option>";
				$('#to_ambulance_id').append(selectfirst);
				$.each(jsonArray, function(i, resData) {
					
				/*	 "vehicleId": "1",
			            "permanentRegNo": "Arlington Pharmacy",
			            "vehicleTypeId": "1"*/
					
					var amb = "<option value=" + resData.vehicleId + ">"
							+ resData.permanentRegNo + "</option>";
					$(amb).appendTo('#to_ambulance_id');
				});
			}
		},
		error : function(err) {
			console.error('from_ambulance  error: ' + JSON.stringify(err));
		}
	});
	$('#to_ambulance_id').trigger("chosen:updated");
	$('#to_ambulance_id').chosen();
	
}


function loadVehiItems(){
	$('#from_zone_table_id').DataTable().clear().destroy();
	var amb = $('#from_ambulance_id').val();
	if(amb>0){
	var strUrl = "http://localhost:2000/scmservice/ambToAmbController/loadVehicleItems";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"vehicleId" : amb
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			loadList(data.objAmbToAmbTransferControllerDTO);
			dataTable();
			alert('data::'+JSON.stringify(data));
		},
		error : function(err) {
			console.error('from_ambulance  error: ' + JSON.stringify(err));
		}
	});
	
	}
   }


/*"objAmbToAmbTransferControllerDTO": [
    {
        "vehicleId": null,
        "dr_short_unic_code": "DR-44",
        "dr_drug_name": "Amiadarone Inj",
        "drr_batch_number": "AE1212",
        "pt_packing_type": "1X20",
        "drr_expire_date": "2022-09-09",
        "drr_available_stock": "180.00",
        "drr_drug_id": "346",
        "drr_purchase_price": "350.00",
        "drr_mrp": "450.00",
        "drr_unit_cost": "50.00",
        "generic_drug_name": null,*/

var arrData;
function loadList(strData) {
	arrData = strData;
	$('#from_zone_list_of_data_id').empty();
	try {
		var sum = 0;
		for (var i = 0; i < strData.length; i++) {
			var index = i + 1;
			var tbleRow = document.createElement("tr");

			/*var tablcol1 = document.createElement("td");
			$(tablcol1).html(index);
			$(tbleRow).append(tablcol1);*/

			var drugidList = strData[i].drugidlist;

			var tablcol2 = document.createElement("td");
			$(tablcol2).html(strData[i].dr_short_unic_code);
			$(tbleRow).append(tablcol2);

			var tablcol3 = document.createElement("td");
			$(tablcol3).html(strData[i].dr_drug_name);
			$(tbleRow).append(tablcol3);

			var tablcol4 = document.createElement("td");
			$(tablcol4).html(strData[i].drr_batch_number);
			$(tbleRow).append(tablcol4);

			var tablcol5 = document.createElement("td");
			$(tablcol5).html(strData[i].pt_packing_type);
			$(tbleRow).append(tablcol5);

			var tablcol6 = document.createElement("td");
			$(tablcol6).html(strData[i].drr_expire_date);
			$(tbleRow).append(tablcol6);

			var tablcol7 = document.createElement("td");
			$(tablcol7).html(strData[i].drr_available_stock);
			$(tbleRow).append(tablcol7);

			var tablcol8 = document.createElement("td");
			$(tablcol8).html(
					'<input type="text"  id="issued_quantity' + i
							+ '" class="form-control" onchange ="handleEvt(this.value,'+i+')">');
			$(tbleRow).append(tablcol8);

			var tablcol9 = document.createElement("td");
			$(tablcol9).html(
					'<input type="text"  id="no_of_trips' + i
							+ '" class="form-control" onchange ="noOfTrips(this.value,'+i+')">');
			$(tbleRow).append(tablcol9);
			
			
			var tablcol10 = document.createElement("td");
			$(tablcol10).html(
					'<input type="text"  id="no_of_units' + i
							+ '" class="form-control"  onkeypress="noOfUnit('+i+')">');
			$(tbleRow).append(tablcol10);
			
			
			var tablcol11 = document.createElement("td");
			var buttonTag = document.createElement('button');
			
			var text = document.createTextNode("Transfer Item");
			buttonTag.appendChild(text);
			$(buttonTag).addClass('btn btn-primary btn-sm fa fa-edit');
			$(buttonTag).attr(
					'onclick',
					'get_RowData("' + strData[i].genericName + '","'
							+ strData[i].db_drug_brand_lang1 + '", "'
							+ strData[i].unicode + '", "'
							+ strData[i].df_form_type + '", "'
							+ strData[i].strenghtlist + '", "'
							+ strData[i].supplierName + '", "'
							+ strData[i].dmr_actuval_stock + '", "'
							+ strData[i].drr_actuval_stock + '",  "'
							+ strData[i].total_stock + '", "' + i + '", "'
							+ drugidList + '")');

			$(tablcol11).append(buttonTag);
			$(tablcol11).css('height', '36px');
			$(tbleRow).append(tablcol11);
			$("#from_zone_list_of_data_id").append(tbleRow);
		}

	} catch (err) {
		console.log("get_All_Sites_Details_DOM ERROR" + err);
	}
	
}

function get_RowData(genericName, db_drug_brand_lang1, unicode, df_form_type,
		strenghtlist, supplierName, dmr_actuval_stock, drr_actuval_stock,
		total_stock, position, drugidList) {
	
	
	var issuedQuantity = $('#issued_quantity' + position + '').val();
	var no_Of_Trips = $('#no_of_trips' + position + '').val();
	var no_of_units = $('#no_of_units' + position + '').val();
	
	if(issuedQuantity=="0"||no_Of_Trips=="0"||no_of_units=="0"){
		toastr.error("Please don't enter zero in issued quantity,No of Strips,No of Units ");
		return false
	}
	if(issuedQuantity==""){
		toastr.error("Please enter issued quantity");
		return false
	}
	
	//
	
	//
	
	alert('issuedQuantity::'+issuedQuantity);
	alert('no_Of_Trips::'+no_Of_Trips);
	alert('no_of_units::'+no_of_units);
	
	
	
	
	if (orderQuantity == null || orderQuantity == "" || orderQuantity === '') {
		alert("Enter Ordered Quantity");
	} else {
		var table = [];
		table.push({
			'genericName' : genericName,
			'db_drug_brand_lang1' : db_drug_brand_lang1,
			'unicode' : unicode,
			'df_form_type' : df_form_type,
			'strenghtlist' : strenghtlist,
			'supplierName' : supplierName,
			'dmr_actuval_stock' : dmr_actuval_stock,
			'drr_actuval_stock' : drr_actuval_stock,
			'total_stock' : total_stock,
			'orderQuantity' : orderQuantity,
			'drugidList' : drugidList

		});
		console.log("Data    " + JSON.stringify(table));
	}
	// alert(":genericName: "+genericName+" db_drug_brand_lang1:
	// "+db_drug_brand_lang1);
	// alert(":unicode: "+unicode+" df_form_type: "+df_form_type);
	// alert(":strenghtlist: "+strenghtlist+" supplierName: "+supplierName);
	// alert(":dmr_actuval_stock: "+dmr_actuval_stock+" drr_actuval_stock:
	// "+drr_actuval_stock);
	// alert(":total_stock: "+total_stock+" orderQunatity: "+orderQuantity);

	setDataToTable(table);
}





function loadVehicleReqAmbItems(){
	$('#to_zone_table_id').DataTable().clear().destroy();
	var toambulanceId = $('#to_ambulance_id').val();
	var strUrl = "http://localhost:2000/scmservice/ambToAmbController/loadVehicleReqAmbItems";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"vehicleId" : toambulanceId
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			to_zone_loadList(data.objAmbToAmbTransferControllerDTO);
			to_zone_dataTable();
			alert('data::'+JSON.stringify(data));
		},
		error : function(err) {
			console.error('from_ambulance  error: ' + JSON.stringify(err));
		}
	});
	
}



function to_zone_loadList(strData) {
	$('#list_of_to_ambulace_data_id').empty();
	try {
		var sum = 0;
		for (var i = 0; i < strData.length; i++) {
			var index = i + 1;
			var tbleRow = document.createElement("tr");

			/*var tablcol1 = document.createElement("td");
			$(tablcol1).html(index);
			$(tbleRow).append(tablcol1);*/

			var drugidList = strData[i].drugidlist;

			var tablcol2 = document.createElement("td");
			$(tablcol2).html(strData[i].dr_short_unic_code);
			$(tbleRow).append(tablcol2);

			var tablcol3 = document.createElement("td");
			$(tablcol3).html(strData[i].dr_drug_name);
			$(tbleRow).append(tablcol3);

			var tablcol4 = document.createElement("td");
			$(tablcol4).html(strData[i].drr_available_stock);
			$(tbleRow).append(tablcol4);

			
			$(tablcol4).css('height', '36px');
			$(tbleRow).append(tablcol4);

			$("#list_of_to_ambulace_data_id").append(tbleRow);
		}

	} catch (err) {
		console.log("get_All_Sites_Details_DOM ERROR" + err);
	}
}



function dataTable(){
	    $('#from_zone_table_id').DataTable({// Data table
    "aLengthMenu": [[05, 10, 15, 25, -1], [05, 10, 15, 25, "All"]],
    pageLength: 5,
    responsive: true,
    dom: '<"html5buttons"B>lTfgitp',
    buttons: [
        {extend: 'copy'},
        {extend: 'csv'},
        {extend: 'excel', title: 'ExampleFile'},
        {extend: 'pdf', title: 'ExampleFile'},
        {extend: 'print',
            customize: function(win) {
                $(win.document.body).addClass('white-bg');
                $(win.document.body).css('font-size', '10px');

                $(win.document.body).find('table')
                        .addClass('compact')
                        .css('font-size', 'inherit');
            }
        }
    ]

});
}

function to_zone_dataTable(){
    $('#to_zone_table_id').DataTable({// Data table
"aLengthMenu": [[05, 10, 15, 25, -1], [05, 10, 15, 25, "All"]],
pageLength: 5,
responsive: true,
dom: '<"html5buttons"B>lTfgitp',
buttons: [
    {extend: 'copy'},
    {extend: 'csv'},
    {extend: 'excel', title: 'ExampleFile'},
    {extend: 'pdf', title: 'ExampleFile'},
    {extend: 'print',
        customize: function(win) {
            $(win.document.body).addClass('white-bg');
            $(win.document.body).css('font-size', '10px');

            $(win.document.body).find('table')
                    .addClass('compact')
                    .css('font-size', 'inherit');
        }
    }
]

});
}



function saveTransferItemsDetails(){
	
	var fromZoneId = $('#from_zone_id').val();
	var from_base_location_id = $('#from_base_location_id').val();
	var from_ambulance_id = $('#from_ambulance_id').val();
	var to_zone_id = $('#to_zone_id').val();
	var to_base_location_id = $('#to_base_location_id').val();
	var to_ambulance_id = $('#to_ambulance_id').val();
	
	
	
	if(fromZoneId==0||fromZoneId=='0'){
		toastr.warning('Please select zone');
		return false;
	}
	
	if(from_base_location_id==0||from_base_location_id=='0'){
		toastr.warning('Please select base location');
		return false;
	}
	
	
	if(from_ambulance_id==0||from_ambulance_id=='0'){
		toastr.warning('Please select from ambulace');
		return false;
	}
	
	
	
	if(to_zone_id==0||to_zone_id=='0'){
		toastr.warning('Please select to zone');
		return false;
	}
	
	if(to_base_location_id==0||to_base_location_id=='0'){
		toastr.warning('Please select to base location');
		return false;
	}
	
	
	if(to_ambulance_id==0||to_ambulance_id=='0'){
		toastr.warning('Please select to ambulace');
		return false;
	}
	
	
	//saveTransferItemsDetails
	
	
}



function clearAllFields(){
	
	
	
	
	
}
function handleEvt(intIndentqty,index) {
	 var intStripsqty = 0;
	// alert('@@@@@@@@@@@@@@@::'+value);
     //alert('#################::'+arrData[index].pt_packing_type);
    var packingType = arrData[index].pt_packing_type;
   var aarPackingType = packingType.split('X');
   var intPackqty = aarPackingType[1];
   intStripsqty = intIndentqty / intPackqty;
   
 
   
  intStripsqty = intStripsqty | 0;
  
  
  
 var  resutls = intIndentqty % intPackqty;
 $('#no_of_trips' + index + '').val(intStripsqty);
  $('#no_of_units' + index + '').val(resutls);
  var intRemainunits =   $('#no_of_units' + index + '').val();
  var intIndentMinQtys = intIndentqty - intRemainunits;
  $('#issued_quantity' + index + '').val(intIndentMinQtys);
  
  var resutl = intIndentqty % intPackqty;
  
  if (resutl != 0) {
	  alert('resutl  is not equal to zero');
	  intStripsqty = intIndentqty / intPackqty;
      var resutlremai = intIndentqty % intPackqty; 
      $('#no_of_trips' + index + '').val(intStripsqty);
      $('#no_of_units' + index + '').val(resutlremai);
       var intRemainunit =  $('#no_of_units' + index + '').val();
       var intIndentMinQty = intIndentqty - intRemainunit;
       $('#issued_quantity' + index + '').val(intIndentMinQty);
  }
  if (intIndentqty < 10) {
	  alert('Indent Quentity is less than 10');
	  intStripsqty = intIndentqty / intPackqty;
      var resutlremai = intIndentqty % intPackqty;
      $('#no_of_trips' + index + '').val(intStripsqty);
      $('#no_of_units' + index + '').val(resutlremai);
      $('#issued_quantity' + index + '').val(0);
	  
  }
 
  
}


function noOfTrips(noOftrips,index){
	if(noOftrips==""){
		$('#issued_quantity' + index + '').val('');
	}
	else{
		 var packingType = arrData[index].pt_packing_type;
		 var aarPackingType = packingType.split('X');
		 var intPackqty = aarPackingType[1];
		var intStripsqty = noOftrips * intPackqty;
		$('#issued_quantity' + index + '').val(intStripsqty);
		 $('#no_of_units' + index + '').val(0);
		
}
	
}


function noOfUnit(index){
	var table = $('#to_zone_table_id').DataTable();
	if ( ! table.data().any() ) {
	    toastr.error('Please select To Zone');
	}
	else{
		var  issueqty = $('#issued_quantity' + index + '').val();
		if(issueqty==""){
			toastr.error('Please enter issued quantity');
		}
	}
}

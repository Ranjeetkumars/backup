function indentRisedListOfdata(strData) {
	//alert('indentRisedListOfdata function is executed');
	try {
		var objDivTag = document.createElement('div');
		$(objDivTag).addClass("table-responsive");

		var ObjTableTag = document.createElement("table");
		$(ObjTableTag)
				.addClass(
						"table table-striped table-bordered table-hover dataTables-example");
		$(objDivTag).append(ObjTableTag);
		// For table head
		var objTHead = document.createElement("thead");
		$(ObjTableTag).append(objTHead);

		// For table row
		var objTr = document.createElement("tr");
		$(objTHead).append(objTr);

		var objTHead1 = document.createElement("th");

		$(objTHead1).html('Item Name');
		$(objTr).append(objTHead1);
		// For table Heading1

		// For table Heading2
		var objTHead2 = document.createElement('th');
		$(objTHead2).html('Brand Name');
		$(objTr).append(objTHead2);

		// For table Heading3
		var objTHead3 = document.createElement('th');
		$(objTHead3).html('Short Code');
		$(objTr).append(objTHead3);

		var objTHead4 = document.createElement('th');
		$(objTHead4).html('Strength');
		$(objTr).append(objTHead4);
		// For table Heading4
		var objTHead5 = document.createElement('th');
		$(objTHead5).html('Manufacture');
		$(objTr).append(objTHead5);

		// For table Heading5
		var objTHead6 = document.createElement('th');
		$(objTHead6).html('Required Qty');
		$(objTr).append(objTHead6);

		var objTHead7 = document.createElement('th');
		$(objTHead7).html('Available Qty');
		$(objTr).append(objTHead7);

		var objTHead8 = document.createElement('th');
		$(objTHead8).html('Rack Location');
		$(objTr).append(objTHead8);

		var objTHead9 = document.createElement('th');
		$(objTHead9).html('View Item Details');
		$(objTr).append(objTHead9);

		var objTBody = document.createElement("tbody");
		$(objTBody).attr("id", "tbodyData");
		$(ObjTableTag).append(objTBody);

		// Table Data Appending Here
		for (var i = 0; i < strData.length; i++) {
			var index = i + 1;
			var tbleRow = document.createElement("tr");
			var tablcol1 = document.createElement("td");
			var tablcol1 = document.createElement("td");
			$(tablcol1).addClass('text-center');
			$(tablcol1).html(strData[i].drug_name);
			$(tbleRow).append(tablcol1);
			var tablcol2 = document.createElement("td");
			$(tablcol2).addClass('text-center');
			$(tablcol2).html(strData[i].drug_brand_lang1);
			$(tbleRow).append(tablcol2);
			var tablcol3 = document.createElement("td");
			$(tablcol3).addClass('text-center');
			$(tablcol3).html(strData[i].short_unic_code);
			$(tbleRow).append(tablcol3);
			var tablcol4 = document.createElement("td");
			$(tablcol4).addClass('text-center');
			$(tablcol4).html(strData[i].strength_type);
			$(tbleRow).append(tablcol4);
			var tablcol5 = document.createElement("td");
			$(tablcol5).addClass('text-center');
			$(tablcol5).html(strData[i].companyname);
			$(tbleRow).append(tablcol5);
			var tablcol6 = document.createElement("td");
			$(tablcol6).addClass('text-center');
			$(tablcol6).html(strData[i].indent_qty);
			$(tbleRow).append(tablcol6);

			var tablcol7 = document.createElement("td");
			$(tablcol7).addClass('text-center');
			$(tablcol7).html(strData[i].availableqty);
			$(tbleRow).append(tablcol7);

			var tablcol8 = document.createElement("td");
			$(tablcol8).addClass('text-center');
			$(tablcol8).html(strData[i].ddr_rackname);
			$(tbleRow).append(tablcol8);

			var tablcol9 = document.createElement("td");
			$(tablcol9).addClass('text-center');
			$(tablcol9)
					.append(
							'<button class="btn btn-primary btn-sm" data-toggle="modal" ><i class="fa fa-plus"></i>View Item Details</button>');
			$(tablcol9).attr(
					'onclick',
					'get_RowData("' + strData[i].item_id + '","'
							+ strData[i].barcode + '","' + strData[i].drug_name
							+ '","' + strData[i].drug_brand_lang1 + '","'
							+ strData[i].short_unic_code + '","'
							+ strData[i].companyname + '","'
							+ strData[i].availableqty + '","'
							+ strData[i].form_type + '","'
							+ strData[i].group_molecules_type_lang1 + '","'
							+ strData[i].strength_type + '","'
							+ strData[i].indent_qty + '","'
							+ strData[i].ddr_rackname + '")');

			$(tbleRow).append(tablcol8);
			$(tbleRow).append(tablcol9);
			$(objTBody).append(tbleRow);
		}

		$("#indent_rised").append(objDivTag);

	} catch (err) {
		console.log("indent_rised" + err);
	}
}

var strength;
var indentQty;
var rackLocation;
var batchNo;
var drugId ;
function get_RowData(item_id, barcode, itemName, brandName, unicCode,
		companyname, avalQty, fromType, group_molecules_type_lang1,
		strength_type, indent_qty, ddr_rackname) {

	alert('get_RowData function is executed');
	drugId = item_id;
	rackLocation = ddr_rackname;
	indentQty = indent_qty;
	strength = strength_type;
	$('#issued').modal('show');

	alert(item_id);
	alert(barcode);
	alert(itemName);
	alert(brandName);
	alert(unicCode);
	alert(companyname);
	alert(avalQty);

	alert(fromType);
	alert(group_molecules_type_lang1);

	$('#item_name').val(itemName);
	$('#bar_code_id').val(barcode);
	$('#generic_module_id').val(group_molecules_type_lang1);
	$('#unic_code_id').val(unicCode);
	$('#from_name_id').val(fromType);
	$('#manufacture_id').val(unicCode);
	$('#aval_qty').val(avalQty);
	$('#brand_name_id').val(brandName);

	alert('item_iditem_iditem_iditem_id::' + item_id);
	var strUrl = "http://localhost:2000/scmservice/indentItemListController/loadBatchNumber";
	$.ajax({
		type : "POST",
		url : strUrl,
		dataType : "json",
		data : JSON.stringify({
			"drug_id" : 1,
			"storeId" : 99999
		}),
		contentType : "application/json",
		async : false,
		crossDomain : true,
		success : function(data) {
			var responsecode = data.responseCode;
			if (200 == responsecode) {
				var jsonArray = data.objIndentItemListControllerDTO;
				$.each(jsonArray, function(i, resData) {
					var batch = "<option value=" + resData.serialid + ">"
							+ resData.batch_number + "</option>";
					$(batch).appendTo('#bach_number_id');
					
					 batchNo = resData.batch_number;
				});
			} else {
				$('#batch_no_not_found').append('Batch Not found');
			}
		},
		error : function(err) {
			alert("@@@@@@@@@@@@@@@@@@@@@@@" + JSON.stringify(err));
			console.error('loadDistrict  error: ' + JSON.stringify(err));
		}
	});
	$('#bach_number_id').trigger("chosen:updated");
	$('#bach_number_id').chosen();

}

function addIntoDataTable() {
    var itemNmae = $('#item_name').val();
	var barcode = $('#bar_code_id').val();
	var genericModuleId = $('#generic_module_id').val();
	var unicCode = $('#unic_code_id').val();
	var fromName = $('#from_name_id').val();
	var manufaacture = $('#manufacture_id').val();
	var avalQty = $('#aval_qty').val();
	var brandName = $('#brand_name_id').val();
	
	var isssuedQty = $('#issued_quty').val();
	var unitPrice = $('#unit_price_id').val();
	var price = $('#amount_id').val();
	
	
	
	
	

	
	
	
	
	
	
	
	
	// For Div Tag
	try {
		var objDivTag = document.createElement('div');
		$(objDivTag).addClass("table-responsive");

		// For table
		var ObjTableTag = document.createElement("table");
		$(ObjTableTag)
				.addClass(
						"table table-striped table-bordered table-hover dataTables-example");
		$(objDivTag).append(ObjTableTag);
		// For table head
		var objTHead = document.createElement("thead");
		$(ObjTableTag).append(objTHead);

		// For table row
		var objTr = document.createElement("tr");
		$(objTHead).append(objTr);

		var objTHead1 = document.createElement("th");

		
		$(objTHead1).html('Item Name');
		$(objTr).append(objTHead1);
		// For table Heading1

		// For table Heading2
		var objTHead2 = document.createElement('th');
		$(objTHead2).html('Brand Name');
		$(objTr).append(objTHead2);

		// For table Heading3
		var objTHead3 = document.createElement('th');
		$(objTHead3).html('Short Code');
		$(objTr).append(objTHead3);

		var objTHead4 = document.createElement('th');
		$(objTHead4).html('Strength');
		$(objTr).append(objTHead4);
		// For table Heading4
		var objTHead5 = document.createElement('th');
		$(objTHead5).html('Manufacturer');
		$(objTr).append(objTHead5);

		var objTHead6 = document.createElement('th');
		$(objTHead6).html('Required Qty');
		$(objTr).append(objTHead6);

		var objTHead7 = document.createElement('th');
		$(objTHead7).html('Issued Qty');
		$(objTr).append(objTHead7);

		var objTHead8 = document.createElement('th');
		$(objTHead8).html('Unit Price');
		$(objTr).append(objTHead8);

		var objTHead9 = document.createElement('th');
		$(objTHead9).html('Amount');
		$(objTr).append(objTHead9);

		var objTHead10 = document.createElement('th');
		$(objTHead10).html('Batch No');
		$(objTr).append(objTHead10);

		var objTHead11 = document.createElement('th');
		$(objTHead11).html('Rack Location');
		$(objTr).append(objTHead11);

		var objTHead12 = document.createElement('th');
		$(objTHead12).html('Save/Update Indent Rised');
		$(objTr).append(objTHead12);

		var objTBody = document.createElement("tbody");
		$(objTBody).attr("id", "tbodyData");
		$(ObjTableTag).append(objTBody);

		var tbleRow = document.createElement("tr");

		var tablcol1 = document.createElement("td");
		$(tablcol1).addClass('text-center');
		$(tablcol1).html(itemNmae);
		$(tbleRow).append(tablcol1);

		var tablcol2 = document.createElement("td");
		$(tablcol2).addClass('text-center');
		$(tablcol2).html(brandName);
		$(tbleRow).append(tablcol2);

		var tablcol3 = document.createElement("td");
		$(tablcol3).addClass('text-center');
		$(tablcol3).html(unicCode);
		$(tbleRow).append(tablcol3);

		var tablcol4 = document.createElement("td");
		$(tablcol4).addClass('text-center');
		$(tablcol4).html(strength);
		$(tbleRow).append(tablcol4);

		var tablcol5 = document.createElement("td");
		$(tablcol5).addClass('text-center');
		$(tablcol5).html(manufaacture);
		$(tbleRow).append(tablcol5);

		var tablcol6 = document.createElement("td");
		$(tablcol6).addClass('text-center');
		$(tablcol6).html(indentQty);
		$(tbleRow).append(tablcol6);

		var tablcol7 = document.createElement("td");
		$(tablcol7).addClass('text-center');
		$(tablcol7).html(isssuedQty);
		$(tbleRow).append(tablcol7);

		var tablcol8 = document.createElement("td");
		$(tablcol8).addClass('text-center');
		$(tablcol8).html(unitPrice);
		$(tbleRow).append(tablcol8);

		var tablcol9 = document.createElement("td");
		$(tablcol9).addClass('text-center');
		$(tablcol9).html(price);
		$(tbleRow).append(tablcol9);

		var tablcol10 = document.createElement("td");
		$(tablcol10).addClass('text-center');
		$(tablcol10).html(batchNo);
		$(tbleRow).append(tablcol10);

		var tablcol11 = document.createElement("td");
		$(tablcol11).addClass('text-center');
		$(tablcol11).html(rackLocation);
		$(tbleRow).append(tablcol11);

		var tablcol12 = document.createElement("td");
		$(tablcol12).addClass('text-center');
		$(tablcol12).append('<button class="btn btn-primary btn-sm" data-toggle="modal" ><i class="fa fa-plus"></i>Save/Update Indent Rised</button>');
		$(tablcol12).attr('onclick', 'insertAndUpdateIndentRaiseds("'+batchNo+'","'+drugId+'")');
		$(tablcol12).css('height', '5px');

		$(tbleRow).append(tablcol11);
		$(tbleRow).append(tablcol12);
		$(objTBody).append(tbleRow);

		$("#addIntoTable").append(objDivTag);

	} catch (err) {
		console.log("addIntoTable" + err);
	}
}

function insertAndUpdateIndentRaiseds() {

	alert('getSingleRowDatagetSingleRowDatagetSingleRowDatagetSingleRowData');
}

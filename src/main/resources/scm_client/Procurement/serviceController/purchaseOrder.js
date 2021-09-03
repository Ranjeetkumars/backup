$(document).ready(function() {
	try {

		getIndentDropdown();
		getAllIndentData();
	} catch (err) {
		console.log("errror in loading ready funtion" + err);
	}
});

/**
 * @Author: Habiboon Patan
 * @Functionality: getIndentDropdown
 * @Date: 17-04-2020
 */

function getIndentDropdown() {
	try {
		$('#indent_id').empty();
		var strUrl = ServiceProcreument.LOAD_INDENTS;
		console.log("LOAD_INDENTS::::: " + strUrl);
		$.ajax({
			type : 'GET',
			url : strUrl,
			dataType : 'json',
			async : false,
			success : function(data) {
				console.log("responsecode " + data.responseCode);
				var responsecode = data.responseCode;
				if (200 !== responsecode) {

				} else {
					var jsonArray = data.placingOrdersForPurchaseControllerDTO;
					var selectfirst = "<option value='0'>Select Form</option>";
					$('#indent_id').append(selectfirst);
					$.each(jsonArray, function(i, resData) {
						var module = "<option value=" + resData.serialId + ">"
								+ resData.indentidNumber + "</option>";
						$(module).appendTo('#indent_id');

					});
				}
			},
			error : function(err) {
				console.error("Error in GET_MANUFACTURE_FORM"
						+ JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error('Error in GET_MANUFACTURE_FORM()' + err);
	}
	$('indent_id').trigger("chosen:updated");
	$('#indent_id').chosen();

}
var indent_id;
$('#indent_id').on('change', function() {
	indent_id = $('#indent_id').val();
	$('#indentdataTable').empty();
	getAllIndentData(indent_id);
});

/**
 * @Author: Habiboon Patan
 * @Functionality: getAllPurchaseOrderList
 * @Date: 17-04-2020
 */
function getAllIndentData(indent_id) {
	try {

		var obj_Insert = {
			indent_id : indent_id

		};
		var strUrl = ServiceProcreument.INDENT_DETAILS;
		console.log("INDENT_DETAILS::::: " + strUrl);
		$.ajax({
			type : "POST",
			url : strUrl,
			dataType : "json",
			data : JSON.stringify(obj_Insert),
			contentType : "application/json",
			async : false,
			crossDomain : true,
			// var data=JSON.stringify(obj_Insert);
			success : function(data) {
				var responsecode = data.responseCode;
				if (200 !== responsecode || data.status === "NO_DATA_FOUND") {
					var divTag = document.createElement("h2");
					$(divTag).css("text-align", "center");
					// $(divTag).html("No data available....");
					$('#indentdataTable').append(divTag);
				} else {
					var jsonArray = data.objIndentDetailsControllerDTO;
					if (jsonArray.length > 0) {
						loadIndentDetails(jsonArray);
					}
				}
			},
			error : function(err) {
				console.error('loadPurchagesOrderList error: '
						+ JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error("error occur in loadPurchagesOrderList()"
				+ JSON.stringify(err))
	}
}


function loadIndentDetails(strData) {

	try {
		var sum = 0;
		for (var i = 0; i < strData.length; i++) {
			var index = i + 1;
			var tbleRow = document.createElement("tr");

			var tablcol1 = document.createElement("td");
			$(tablcol1).html(index);
			$(tbleRow).append(tablcol1);

			

			var tablcol2 = document.createElement("td");
			$(tablcol2).html(strData[i].drug_name);
			$(tbleRow).append(tablcol2);

			var tablcol3 = document.createElement("td");
			$(tablcol3).html(strData[i].brand_name);
			$(tbleRow).append(tablcol3);

			var tablcol4 = document.createElement("td");
			$(tablcol4).html(strData[i].company_name);
			$(tbleRow).append(tablcol4);

			var tablcol5 = document.createElement("td");
			$(tablcol5).html(strData[i].approved_quantity);
			$(tbleRow).append(tablcol5);

			 var drugidList = strData[i].item_id;
			 var form_id = strData[i].form_id;
			 var approved_quantity = strData[i].approved_quantity;
//			 var drugidList = strData[i].form_id;
			 
			 
			var tablcol6 = document.createElement("td");
			$(tablcol6)
					.html(
							'<select class="form-control" id="centrelsubstore'
									+ i
									+ '"><option value=0>Select Supplier</option></select>');
			$(tbleRow).append(tablcol6);
			$(tablcol6).attr('onclick',
					'onclickdropdown(' + i + ', ' + strData[i].item_id + ','+form_id+', '+approved_quantity+',"'+strData[i].stength_type+'")');

			$("#indentdataTable").append(tbleRow);
		}

	} catch (err) {
		console.log("get_All_Sites_Details_DOM ERROR" + err);
	}
}

var drug_Id;
var form_Id;
var approvedQuantity;
var stength_Type;
var position_id;

function onclickdropdown(position, drugid, form_id, approved_quantity, stength_type) {
	//alert("position : "+position+ " drugid: "+drugid);
	//	
	drug_Id = drugid;
	form_Id = form_id;
	approvedQuantity = approved_quantity;
	stength_Type= stength_type;
	position_id= position;
	try {
		$('#centrelsubstore' + position).empty();
		var obj_Insert = {
			"drugId" : drugid
		};
		var strUrl = ServiceProcreument.LOAD_SUPPLIERS;
		console.log("LOAD_SUPPLIERS::::: " + strUrl);
		$
				.ajax({
					type : "POST",
					url : strUrl,
					dataType : "json",
					data : JSON.stringify(obj_Insert),
					contentType : "application/json",
					async : false,
					crossDomain : true,
					success : function(data) {
						console.log("responsecode " + JSON.stringify(data.responseCode));
						var responsecode = data.responseCode;
						if (200 !== responsecode) {

						} else {
							var jsonArray = data.adjustmentStockControllerDTO;
							
							
							/*var selectfirst = "<option value='0'>Select Supplier</option>";
							$('#centrelsubstore' + position)
									.append(selectfirst);*/
							
							
							$.each(jsonArray, function(i, resData) {

								var module = "<option value="
										+ resData.supplierId+ ">"
										+ resData.supplierName
										+ resData.purchage_price + "</option>";
								$(module).appendTo(
										'#centrelsubstore' + position);
							});
						}
					},
					error : function(err) {
						console.error("Error in GET_MANUFACTURE_FORM"
								+ JSON.stringify(err));
					}
				});
	} catch (err) {
		console.error('Error in GET_MANUFACTURE_FORM()' + err);
	}
	$('#centrelsubstore' + position).trigger("chosen:updated");
	$('#centrelsubstore' + position).chosen();
}

function generatePoNumber() {
	// alert("poNUMBER: ");
	var po_number;
	try {
		var strUrl = ServiceProcreument.GENERATE_PO_NUMBER;
		console.log("GENERATE_PO_NUMBER:::::: " + strUrl);
		// alert("poNUMBER: "+strUrl);
		$.ajax({
			type : 'GET',
			url : strUrl,
			dataType : 'json',
			async : false,

			success : function(data) {
				po_number = data.rtnReponseCount;
				
				console.log("po_number::::::::::::::::::::::::::"+po_number);
				// alert("po_number "+po_number);
			},
			error : function(err) {
				console.error("Error in po_number" + JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error('Error in indentIdGeneration()' + err);
	}
	return po_number;
}



function raispoonclick() {
	savePurchasedOrder();
	
}

var poId;

/**
 * @Author: Habiboon Patan
 * @Functionality: savePurchasedOrder
 * @Date: 17-04-2020
 */
function savePurchasedOrder() {
	
	
	 var  indentId = $('#indent_id').val();
	// var expected_date_id = $('#expected_date_id').val();
	 var centrelsubstore0 = $('#centrelsubstore0').val();
	 
	 var edate = $('#expected_date_id').val();
	 if(indentId=="0"||indentId==0){
		 toastr.error('Please select indent');
		 return false;
	 }
	 if(centrelsubstore0=="0"||centrelsubstore0==0){
		 toastr.error('Please select vendor for the item ');
		 return false;
		 
	 }
	 if(edate==""||edate==undefined){
		 toastr.error('Please select expected data of delivery');
		 return false;
	 }
	  
	
	
	
	try {
		var po_number = generatePoNumber();
		var date = moment(); // Get the current date
		var strDate = date.format("YYYYMMDD");
		var po_id = "PO" + "-" + strDate + "-" + po_number;
//		alert("poNUMBER: " + po_id);
		$('#po_number_id').val(po_id);
		var expected_date_id = $('#expected_date_id').val();
		alert("expected_date_id: " + expected_date_id);
		var terms_conditions = $('#terms_condition_id').val();
		var expected_date = moment(expected_date_id).format("YYYY-MM-DD");

		// PO-20200417-106 PO-20200417-107  sp_insert_pms_scm_purchase_order_item_trans
		var obj_Insert = {
			
			"po_number" : po_id,
			"po_raised_date" : "now()",
			"po_order_date" : "now()",
			"createById" : 1,
			"roleId" : 1,
			"moduleId" : 1,
			"po_excepted_date" : expected_date,
			"po_terms_conditions" : terms_conditions
		};
		var strUrl = ServiceProcreument.SAVE_PURCHASE_ORDER;
		console.log("SAVE_PURCHASE_ORDER::::: " + strUrl);
		$.ajax({
			type : "POST",
			url : strUrl,
			dataType : "json",
			data : JSON.stringify(obj_Insert),
			contentType : "application/json",
			async : false,
			crossDomain : true,
			// var data=JSON.stringify(obj_Insert);
			success : function(data) {
				var responsecode = data.responseCode;
				console.log("responsecode:::::::::::::::::::::::::::::"+responsecode);
				if (200 !== responsecode || data.status === "NO_DATA_FOUND") {

				} else {
					var po_id = generatePoNumber();
					poId = po_id - 1;
					alert("po_id :  "+ poId);
					savePurchaseOrderItemDetails();
				}
			},
			error : function(err) {
				console.error('indentreitemsearchTable error: '
						+ JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error("error occur in indentreitemsearchTable()"
				+ JSON.stringify(err))
	}
}

/**
 * @Author: Habiboon Patan
 * @Functionality: savePurchaseOrderItemDetails
 * @Date: 17-04-2020
 */
function savePurchaseOrderItemDetails() {
	try {
		alert("position: "+position_id);
var suuplir_id = $('#centrelsubstore'+position_id).val();
		// PO-20200417-106 PO-20200417-107
		var obj_Insert = {
			"poId" : poId,
			"supplierId" : suuplir_id,
			"drugidlist" : drug_Id,
			"quantitylist" : approvedQuantity,
			"indentidlist" : indent_id,
			"formlist" : form_Id,
			"strenghtlist" : stength_Type,
			"count" : 1,
			"userId" : 1,
			"moduleId" : 1,
			"roleId" : 1
		};
		var strUrl = ServiceProcreument.SAVE_PURCHASE_ORDER_ITEM_DETAILS;
		console.log("SAVE_PURCHASE_ORDER_ITEM_DETAILS::::: " + JSON.stringify(obj_Insert));
		$.ajax({
			type : "POST",
			url : strUrl,
			dataType : "json",
			data : JSON.stringify(obj_Insert),
			contentType : "application/json",
			async : false,
			crossDomain : true,
			// var data=JSON.stringify(obj_Insert);
			success : function(data) {
				var responsecode = data.responseCode;
				if (200 !== responsecode || data.status === "NO_DATA_FOUND") {

				} else {
					centralClose();
				}
			},
			error : function(err) {
				console.error('indentreitemsearchTable error: '
						+ JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error("error occur in indentreitemsearchTable()"
				+ JSON.stringify(err))
	}
}
/**
 * @Author: Habiboon Patan
 * @Functionality: centralClose
 * @Date: 17-04-2020
 */
function centralClose() {
	try {
//		var expected_date_id = $('#expected_date_id').val();
		var obj_Insert = {
			"indent_id" : indent_id
		};
		var strUrl = ServiceProcreument.CENTRAL_CLOSE;
		console.log("CENTRAL_CLOSE::::: " + JSON.stringify(obj_Insert));
		$.ajax({
			type : "POST",
			url : strUrl,
			dataType : "json",
			data : JSON.stringify(obj_Insert),
			contentType : "application/json",
			async : false,
			crossDomain : true,
			// var data=JSON.stringify(obj_Insert);
			success : function(data) {
				var responsecode = data.responseCode;
				if (200 !== responsecode || data.status === "NO_DATA_FOUND") {

				} else {
					
				}
			},
			error : function(err) {
				console.error('centralClose error: '
						+ JSON.stringify(err));
			}
		});
	} catch (err) {
		console.error("error occur in centralClose()"
				+ JSON.stringify(err))
	}
}
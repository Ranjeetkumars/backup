$('#registration').on('shown.bs.modal', function(e) {
    getManufactureName();
    getInventoryGroup();
    barCode();

});
function getInventoryGroup() {
    try {
        $('#inventoryGroupId').empty();
        var strUrl = 'http://192.168.1.215:2000/scmservice/drugRegisteringService/api/version_1/loadMaterialGroup';
        $.ajax({
            type: 'GET',
            url: strUrl,
            dataType: 'json',
            async: false,
            success: function(data) {
                var responsecode = data.responseCode;
                if (200 !== responsecode) {

                } else {
                    var jsonArray = data.objControllerDto;
                    var selectfirst = "<option value='0'>Select Inventory Group</option>";
                    $('#inventoryGroupId').append(selectfirst);
                    $.each(jsonArray, function(i, resData) {
                        var InventoryGroupData = "<option value=" + resData.materialId + ">" + resData.materialGroupName + "</option>";
                        $(InventoryGroupData).appendTo('#inventoryGroupId');
                    });
                }
            },
            error: function(err) {
                console.error("Error in getBrndNameDropDown" + JSON.stringify(err));
            }
        });
    } catch (err) {
        console.error('Error in getmanufactureDropDown()' + err);
    }
    $('#inventoryGroupId').trigger("chosen:updated");
    $('#inventoryGroupId').chosen();
}
$('#inventoryGroupId').on('change', function() {
    var inventoryGroupId = $('#inventoryGroupId').val();
    $('#inventoryItemFormId').empty();
    getInventoryItemFormDropDown(inventoryGroupId, 'inventoryItemFormId');
});





function getInventoryItemFormDropDown(inventoryGroupId, inventoryItemFormId) {
    alert("inventory group id in item form---" + inventoryGroupId);
    try {
        var id = '#' + inventoryItemFormId;
        var strUrl = 'http://192.168.1.215:2000/scmservice/drugRegisteringService/api/version_1/loadMaterialForm';
        console.log("getInventoryItemFormDropDown Url is:" + strUrl);
        var obj_Insert = {
            materialid: inventoryGroupId
        }
        $.ajax({
            type: "POST",
            url: strUrl,
            dataType: "json",
            data: JSON.stringify(obj_Insert),
            contentType: "application/json",
            async: false,
            crossDomain: true,
            success: function(data) {
                var responsecode = data.responseCode;
                if (200 !== responsecode) {

                } else {
                    var jsonArray = data.objControllerDto;
                    var selectfirst = "<option value='0'>Select Inventory Item Form</option>";
                    $(id).append(selectfirst);
                    $.each(jsonArray, function(i, resData) {
                        var inventoryItemFormData = "<option value=" + resData.formId + ">" + resData.formPName + "</option>";
                        $(inventoryItemFormData).appendTo(id);
                    });
                }
            },
            error: function(err) {
                console.error("Error in getInventoryItemFormDropDown" + JSON.stringify(err));
            }
        });
    } catch (err) {
        console.error('Error in getInventoryItemFormDropDown()' + err);
    }
    $(id).trigger("chosen:updated");
    $(id).chosen();

}

$('#inventoryItemFormId').on('change', function() {
    var inventoryItemFormId = $('#inventoryItemFormId').val();
    $('packingId').empty();
    getPackingDropdown(inventoryItemFormId, 'packingId');
});



function getPackingDropdown(inventoryItemFormId, packingId) {
    alert("inventoryItemFormId-" + inventoryItemFormId);
    try {
        var id = '#' + packingId;
        $(id).empty();
        var strUrl = 'http://192.168.1.215:2000/scmservice/drugRegisteringService/api/version_1/loadPackingType';
        console.log("getPackingDropDown Url is:" + strUrl);
        var obj_Insert = {
            materialformid: inventoryItemFormId
        }
        $.ajax({
            type: "POST",
            url: strUrl,
            dataType: "json",
            data: JSON.stringify(obj_Insert),
            contentType: "application/json",
            async: false,
            crossDomain: true,
            success: function(data) {
                var responsecode = data.responseCode;
                if (200 !== responsecode) {

                } else {
                    var jsonArray = data.objControllerDto;
                    var selectfirst = "<option value='0'>Select PAcking</option>";
                    $(id).append(selectfirst);
                    $.each(jsonArray, function(i, resData) {
                        var PackingFormData = "<option value=" + resData.serialId + ">" + resData.packingType + "</option>";
                        var QuantityData = resData.ptConversionFactory;
                        $(PackingFormData).appendTo(id);
                        // document.getElementById('QuantityId').value=Quantity ; 
                        Quantity(QuantityData);
                    });
                }
            },
            error: function(err) {
                console.error("Error in getPackingDropDown" + JSON.stringify(err));
            }
        });
    } catch (err) {
        console.error('Error in getPackingDropDown()' + err);
    }
    $(id).trigger("chosen:updated");
    $(id).chosen();
}
function Quantity(QuantityData) {
    document.getElementById('QuantityId').value = QuantityData;
}
function getBrandName() {
    try {
        $('#brandNameId').empty();
        var strUrl = 'http://192.168.1.215:2000/scmservice/drugRegisteringService/loadBrand';
        $.ajax({
            type: 'GET',
            url: strUrl,
            dataType: 'json',
            async: false,
            success: function(data) {
                var responsecode = data.responseCode;
                if (200 !== responsecode) {

                } else {
                    var jsonArray = data.objBrandDetailsControllerDTO;
                    var selectfirst = "<option value='0'>Select Brand Name</option>";
                    $('#brandNameId').append(selectfirst);
                    $.each(jsonArray, function(i, resData) {
                        var BrandNameData = "<option value=" + resData.brandId + ">" + resData.brandName + "</option>";
                        $(BrandNameData).appendTo('#brandNameId');

                    });
                }
            },
            error: function(err) {
                console.error("Error in getBrndNameDropDown" + JSON.stringify(err));
            }
        });
    } catch (err) {
        console.error('Error in getmanufactureDropDown()' + err);
    }
    $('#brandNameId').trigger("chosen:updated");
    $('#brandNameId').chosen();
}
function getInventoryItemForm() {
    try {
        $('#inventoryFormId').empty();
        var strUrl = 'http://192.168.1.215:2000/scmservice/drugRegisteringService/loadForm';
        $.ajax({
            type: 'GET',
            url: strUrl,
            dataType: 'json',
            async: false,
            success: function(data) {
                var responsecode = data.responseCode;
                if (200 !== responsecode) {

                } else {
                    var jsonArray = data.objGetManufacturerControllerDTO;
                    var selectfirst = "<option value='0'>Select Inventory Form Item</option>";
                    $('#inventoryFormId').append(selectfirst);
                    // $('#ModManufacturNameId').append(selectfirst);
                    $.each(jsonArray, function(i, resData) {
                        var inventoryItemFormData = "<option value=" + resData.formId + ">" + resData.formType + "</option>";
                        $(inventoryItemFormData).appendTo('#inventoryFormId');
                        //$(inventoryItemFormData).appendTo('#ModManufacturNameId');
                    });
                }
            },
            error: function(err) {
                console.error("Error in getmanufactureDropDown" + JSON.stringify(err));
            }
        });
    }
    catch (err) {
        console.error('Error in getmanufactureDropDown()' + err);
    }
    $('#ManufacturNameId').trigger("chosen:updated");
    $('#ManufacturNameId').chosen();
}
function getManufactureName() {

    try {
        $('#ManufacturNameId').empty();
        var strUrl = 'http://192.168.1.215:2000/scmservice/drugRegisteringService/loadManufaturer';
        $.ajax({
            type: 'GET',
            url: strUrl,
            dataType: 'json',
            async: false,
            success: function(data) {
                var responsecode = data.responseCode;
                if (200 !== responsecode) {

                } else {
                    var jsonArray = data.objGetManufacturerControllerDTO;
                    var selectfirst = "<option value='0'>Select Manufacture Name</option>";
                    $('#ManufacturNameId').append(selectfirst);
                    $('#ModManufacturNameId').append(selectfirst);
                    $.each(jsonArray, function(i, resData) {
                        var manufactureData = "<option value=" + resData.manufactureId + ">" + resData.companyName + "</option>";
                        $(manufactureData).appendTo('#ManufacturNameId');
                        $(manufactureData).appendTo('#ModManufacturNameId');
                    });
                }
            },
            error: function(err) {
                console.error("Error in getmanufactureDropDown" + JSON.stringify(err));
            }
        });
    } catch (err) {
        console.error('Error in getmanufactureDropDown()' + err);
    }
    $('#ManufacturNameId').trigger("chosen:updated");
    $('#ManufacturNameId').chosen();

}


function barCode() {
    var strUrl = 'http://192.168.1.215:2000/scmservice/drugRegisteringService/api/version_1/generate_new_drug_barcode';
    var obj_Insert = {
        "genericId": 2,
        "genericName": ""
    }
    try {
        $.ajax({
            type: "POST",
            url: strUrl,
            dataType: "json",
            data: JSON.stringify(obj_Insert),
            contentType: "application/json",
            async: false,
            crossDomain: true,
            success: function(data) {
                var responsecode = data.responseCode;
                if (200 !== responsecode) {

                } else {
                    var jsonArray = data.objControllerDto;
                    $.each(jsonArray, function(i, resData) {
                        //var barcode = "<option value=" + resData.manufactureId + ">" + resData.companyName + "</option>";
                        var barcode = resData.barCode;
                        //alert("barcode---" + barcode);
                        document.getElementById('barCodeId').value = barcode;
                        var shortCode = barcode.substr(4);
                        document.getElementById('shortcodeId').value = shortCode;
                        JsBarcode("#barcode", barcode);
                    });
                }
            },
            error: function(err) {
                console.error("Error in getmanufactureDropDown" + JSON.stringify(err));
            }
        });
    }
    catch (err) {
        console.error('Error in generating bar code()' + err);
    }
}

function equipmentRegistration() {

    var serailID = document.getElementById("serailNoId").value;
    var itemName = document.getElementById("itemName").value;
    var shortCode = document.getElementById("shortcodeId").value;

    var manufactureName = document.getElementById("ModManufacturNameId");
    var manufactureValue = manufactureName.options[manufactureName.selectedIndex].value;


    var inventoryGroup = document.getElementById("inventoryGroupId");
    var inventoryGroupValue = inventoryGroup.options[inventoryGroup.selectedIndex].value;


    var inventoryitemForm = document.getElementById("inventoryItemFormId");
    var inventoryitemFormValue = inventoryitemForm.options[inventoryitemForm.selectedIndex].value;

    var packing = document.getElementById("packingId");
    var packingValue = packing.options[packing.selectedIndex].value;
    
    
}











/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    try {

        getdrugBrandDropDownDetails();
    }
    catch (err) {
        console.log("errror in loading ready funtion" + err);
    }
});

/*
 *@DESC : inserting BrandName for masterdata dropdown
 *@AuthorName : Habiboon Patan
 *@DATE : 2019-08-27
 */

function insertBrandNameDropDown() {
    var brandName = $('#scm_reg_brandNameId').val();
    var status = document.getElementById("switch2").checked;
    var createdbyid = 1;
    var createdbyroleid = 1;
    var createdbymoduleid = 1;
    if (brandName === "null" || brandName === "" || brandName === '') {
        showNotificationError("Enter BrandName", "scm_reg_brandNameId", "error");
        return;
    }

    var obj_Insert = {
        brandName: brandName,
        userId: createdbyid,
        moduleId: createdbyroleid,
        roleId: createdbymoduleid,
        status: status,
    };

    console.log('==== Obj_Insert' + JSON.stringify(obj_Insert));
    var strUrl = Service.INSERT_DRUG_DROPDOWN;
    console.log('==== strUrl' + strUrl);
    $.ajax({
        type: "POST",
        url: strUrl,
        dataType: "json",
        data: JSON.stringify(obj_Insert),
        contentType: "application/json",
        async: false,
        crossDomain: true,
        success: function(data) {
            if (data !== null || data !== 0) {
                showNotificationError("Inserted Successfully", "insertBrandNameDropDownId", "success");
               // window.location();
                //   getdrugBrandDropDownDetails();

            }
        },
        error: function() {
            console.log("Error In insertBrandNameDropDown");
        }
    });
}

function getdrugBrandDropDownDetails() {
    $('#driverTable').html("");
    var strUrl = Service.GET_DRUG_BRANDNAMES_DROPDOWN;
    console.log("strUrl : " + strUrl);
    $.ajax({
        type: 'GET',
        url: strUrl,
        dataType: 'json',
        async: false,
        success: function(data) {
            var responsecode = data.responseCode;
            if (200 !== responsecode || data.status === "NO_DATA_FOUND") {
                var divTag = document.createElement("h2");
                $(divTag).css("text-align", "center");
                $(divTag).html("No data available....");
                $('#driverTable').append(divTag);
            }
            else {
                var jsonArray = data.objBrandDetailsControllerDTO;
                if (jsonArray.length > 0) {
                    getDrugbrandList(jsonArray);
                    loadDataTable();
                }
            }
        },
        error: function(err) {
            console.error('update Stock error: ' + JSON.stringify(err));
        }
    });
}


function getDrugbrandList(strData) {

    var objDivTag = document.createElement('div');
    $(objDivTag).addClass('table-responsive');

    var objTableTag = document.createElement('table');
    $(objTableTag).addClass('table table-striped table-bordered table-hover dataTables-example');
    $(objDivTag).append(objTableTag);

    var objTHead = document.createElement('thead');
    $(objTableTag).append(objTHead);

    var objTr = document.createElement('tr');
    $(objTHead).append(objTr);

    var objTHead1 = document.createElement('th');
    $(objTHead1).html('S.No');
    $(objTr).append(objTHead1);

    var objTHead3 = document.createElement('th');
    $(objTHead3).html('Brand Name');
    $(objTr).append(objTHead3);

    var objTHead4 = document.createElement('th');
    $(objTHead4).html('Status');
    $(objTr).append(objTHead4);

    var objTHead5 = document.createElement('th');
    $(objTHead5).html('EDIT');
    $(objTr).append(objTHead5);

    var objTBody = document.createElement('tbody');
    $(objTBody).attr('id', 'driverTablebody');
    $(objTableTag).append(objTBody);

    for (var i = 0; i < strData.length; i++) {

        var index = i + 1;
        var tbleRow = document.createElement('tr');

        var tblCol = document.createElement('td');
        $(tblCol).addClass('text-center');
        $(tblCol).html(index);
        $(tbleRow).append(tblCol);

        var tblCol1 = document.createElement('td');
        $(tblCol1).addClass('text-center');
        $(tblCol1).html(strData[i].brandName);
        $(tbleRow).append(tblCol1);

        var tblCol2 = document.createElement('td');
        $(tblCol2).addClass('text-center');
        $(tblCol2).html(strData[i].status);
        $(tbleRow).append(tblCol2);

        var tablcol12 = document.createElement("td");
        var buttonTag = document.createElement('button');
        var text = document.createTextNode("EDIT");
        buttonTag.appendChild(text);
        $(buttonTag).addClass('btn btn-primary btn-sm');
        $(buttonTag).attr('onclick', 'drugBrandNamesEdit("' + strData[i].brandId + '","' + strData[i].brandName + '","' + strData[i].status + '")');
        $(buttonTag).attr('id', 'drugBrandNamesEditId');
        $(tablcol12).append(buttonTag);
        $(tablcol12).css('height', '36px');
        $(tbleRow).append(tablcol12);
        $(objTBody).append(tbleRow);
    }
    $("#driverTable").append(objDivTag);
}



var brandId;
function drugBrandNamesEdit(drugbrandId, brandName, status) {
    $('#updateBrandNameModalBoxId').modal('show');
    $("#update_scm_brandNameId").val(brandName);
    brandId = drugbrandId;
}

function updateDrugBrandDropDownValue() {
    var brandName = $('#update_scm_brandNameId').val();
    var status = document.getElementById("switch1").checked;
    var createdbyid = 1;
    var createdbyroleid = 1;
    var createdbymoduleid = 1;

    var obj_Insert = {
        brandId: brandId,
        brandName: brandName,
        userId: createdbyid,
        moduleId: createdbymoduleid,
        roleId: createdbyroleid,
        status: status
    };

    console.log('==== Obj_Insert' + JSON.stringify(obj_Insert));
    var strUrl = Service.UPDATE_DRUG_BANDNAMES_DROPDOWN;
    console.log('==== strUrl' + strUrl);
    $.ajax({
        type: "POST",
        url: strUrl,
        dataType: "json",
        data: JSON.stringify(obj_Insert),
        contentType: "application/json",
        async: false,
        crossDomain: true,
        success: function(data) {
            if (data !== null || data !== 0) {
                showNotificationError("Updated Successfully", "updateDrugBrandDropDownValueId", "success");
                //windows.location();
            }
        },
        error: function() {
            console.log("Error In updateDrugBrandDropDownValue");
        }
    });
}


function loadDataTable() {
    $('.dataTables-example').DataTable(
            {
                "aLengthMenu": [[5, 10, 15, 25, 50, 75, -1],
                    [5, 10, 15, 25, 50, 75, "All"]],
                "iDisplayLength": 5,
                responsive: true,
                dom: '<"html5buttons"B>lTfgitp',
                buttons: [
                    {
                        extend: 'copy'
                    },
                    {
                        extend: 'csv'
                    },
                    {
                        extend: 'excel',
                        title: 'DRUG_LIST'
                    },
                    {
                        extend: 'pdf',
                        title: 'DRUG_LIST'
                    },
                    {
                        extend: 'print',
                        customize: function(win) {
                            $(win.document.body).addClass('white-bg');
                            $(win.document.body).css('font-size', '10px');

                            $(win.document.body).find('table').addClass(
                                    'compact').css('font-size', 'inherit');
                        }
                    }]
            });
}



function showNotificationError(msg, id, msgType) {
    var boxId = '#' + id;

    var options = {
        // whether to hide the notification on click
        clickToHide: true,
        // whether to auto-hide the notification
        autoHide: true,
        // if autoHide, hide after milliseconds
        autoHideDelay: 2000,
        // show the arrow pointing at the element
        arrowShow: true,
        // arrow size in pixels
        arrowSize: 5,
        // position defines the notification position though uses the defaults below
        position: 'right',
        // default positions
        elementPosition: 'top right',
        globalPosition: 'top right',
        // default style
        style: 'bootstrap',
        // default class (string or [string])
        className: msgType,
        // show animation
        showAnimation: 'slideDown',
        // show animation duration
        showDuration: 400,
        // hide animation
        hideAnimation: 'slideUp',
        // hide animation duration
        hideDuration: 200,
        // padding between element and notification
        gap: 2
    };

    $(boxId).notify(msg, options);
}


function reset() {
    $('#scm_brandNameId').val('');
    $('#brand_Active_id').attr('checked', false);
    $('#brand_InActive_id').attr('checked', false);


}
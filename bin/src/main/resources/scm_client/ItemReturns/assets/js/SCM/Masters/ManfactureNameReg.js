/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//for saving the manufacture name 
function save() {
    var manufactureName = document.getElementById('manufactureNameId').value;
    var status = document.getElementById("switch2").checked;
    alert("manufactureName---"+manufactureName);
    if (manufactureName === "null" || manufactureName === "" || manufactureName === '') {
        showNotificationError("Enter ManufactureName", "manufactureNameId", "error");
        return;
    }
    alert("status---->" + status);
    var obj = {
        "manufactureName": manufactureName,
        "userId": 171,
        "moduleId": 40,
        "roleId": 100,
        "status": status
    };
  var strUrl = Service.saveManufactureName;
    $.ajax({
        type: "POST",
        url: strUrl,
        dataType: "json",
        data: JSON.stringify(obj),
        contentType: "application/json",
        async: false,
        crossDomain: true,
        success: function(data) {
            if (data.responseCode === 200 && data.rtnReponseCount === "1") {
                alert('Manufacture Name Inserted Succesfully');
                window.location.assign("http://127.0.0.1/SupplyChainManagement/Masters/ManufactureNameRegistration.html");
            }
            else if (data.rtnReponseCount === "0") {
                alert("Duplicate Manufacture Name inserted");
            }
            else {
                alert("login failed");
            }
        },
        error: function() {
            console.log("Error In Log In User");
        }
    });
}

function loadManufactureName() {

    var strUrl = Service.loadManufactureName;

    $.ajax({
        type: 'GET',
        dataType: "json",
        contentType: 'application/json',
        async: false,
        url: strUrl,
        crossDomain: true,
        success: function(data) {
            var responseCode = data.responseCode;
            if (200 !== responseCode || data.status === "NO_DATA_FOUND") {
                var divTag = document.createElement("h2");
                $(divTag).css("text-align", "center");
                $(divTag).html("No data available....");
                $('#dataTable_id').append(divTag);
            }
            else {
                var jsonArray = data.objMaterialManufactureControllerDTO;
                if (jsonArray.length > 0) {
                    loadManufactureNames(jsonArray);
                    loadDataTable();
                }
            }
        },
        error: function(err) {
            console.error('update Stock error: ' + JSON.stringify(err));
        }
    });
}
function loadManufactureNames(jsonArray) {

    //For Div Tag
    var objDivTag = document.createElement('div');
    $(objDivTag).addClass("table-responsive");

//For table
    var ObjTableTag = document.createElement("table");
    $(ObjTableTag).addClass("table table-bordered table-stripedss dataTables-example");
    $(objDivTag).append(ObjTableTag);
//For table head
    var objTHead = document.createElement("thead");
    $(ObjTableTag).append(objTHead);

//For table row
    var objTr = document.createElement("tr");
    $(objTHead).append(objTr);

    var objTHead1 = document.createElement('th');
    $(objTHead1).html('S.No');
    $(objTr).append(objTHead1);

    var objTHead2 = document.createElement('th');
    $(objTHead2).html('Manufacture Name');
    $(objTr).append(objTHead2);

    var objTHead3 = document.createElement('th');
    $(objTHead3).html('Status');
    $(objTr).append(objTHead3);

    var objTHead4 = document.createElement('th');
    $(objTHead4).html('Edit');
    $(objTr).append(objTHead4);

    //$(tbleRow).append(tablcol15);
    //$(objTBody).append(tbleRow);

    var objTBody = document.createElement("tbody");
    $(objTBody).attr("id", "tbodyData");
    $(ObjTableTag).append(objTBody);

    for (var i = 0; i < jsonArray.length; i++) {
        var index = i + 1;
        var tbleRow = document.createElement('tr');

        var tblCol = document.createElement('td');
        $(tblCol).addClass('text-center');
        $(tblCol).html(index);
        $(tbleRow).append(tblCol);

        var tblCol1 = document.createElement('td');
        $(tblCol1).addClass('text-center');
        $(tblCol1).html(jsonArray[i].manufactureName);
        $(tbleRow).append(tblCol1);

        var tblCol2 = document.createElement('td');
        $(tblCol2).addClass('text-center');
        $(tblCol2).html(jsonArray[i].status);
        $(tbleRow).append(tblCol2);

        var tblCol3 = document.createElement('td');
        $(tblCol3).addClass("text-center");
        var buttonTag = document.createElement('button');
        $(buttonTag).attr("type", 'button');
        //$(approvedButton).attr('onclick','openModalForApprovedKycDoc('+reqMemberID+','+fileUploadedSearailID+')');
        //$(buttonTag).attr("onclick", "updateManufactureName("' + jsonArray[i].manufactureId + '","''+jsonArray[i].manufactureName +'","'+jsonArray[i].status +'")");
        $(buttonTag).attr('onclick', 'updateManufactureName("' + jsonArray[i].manufactureId + '","' + jsonArray[i].manufactureName + '","' + jsonArray[i].status + '")');
        $(buttonTag).addClass('btn btn-primary btn-sm');
        $(buttonTag).html('Edit');
        tblCol3.appendChild(buttonTag);

        $(tbleRow).append(tblCol3);
        $(objTBody).append(tbleRow);
    }
    $("#manufactureTableId").append(objDivTag);
}

var manufacId;

function updateManufactureName(manufactureId, manufactureName, status) {

    alert("comming into updateManufactureName");
    $('#updateMOdalBOxID').modal('show');
//    alert("manufacture to Id" + manufactureId);
//    alert("manufacture name" + manufactureName);
//    alert("status" + status);
    manufacId = manufactureId;
    $('#upManufactureNameId').val(manufactureName);


}


function update() {
   
    var manfactureName = $('#upManufactureNameId').val();
    var status = document.getElementById("switch1").checked;
    
    if (manfactureName === "null" || manfactureName === "" || manfactureName === '') {
        showNotificationError("Enter ManufactureName", "upManufactureNameId", "error");
        return;
    }
    var obj_Insert = {
        manufactureId: manufacId,
        manufactureName: manfactureName,
        status: status,
    };

    console.log('==== Obj_Insert' + JSON.stringify(obj_Insert));
    //var strUrl = Service.UPDATE_DRUG_BANDNAMES_DROPDOWN;
    var strUrl = Service.updateMAnufactureName;
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
                //showNotificationError("Updated Successfully", "updateDrugBrandDropDownValueid", "success");
                //getdrugBrandDropDownDetails();
                alert("updated suceessfully");
            }
        },
        error: function() {
            console.log("Error In updateDrugBrandDropDownValue");
        }
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

function loadDataTable() {
    $('.dataTables-example').DataTable({
        pageLength: 10,
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
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    try {

        getInventoryGroupNamesData();
    }
    catch (err) {
        console.log("errror in loading ready funtion" + err);
    }
});



/*
 *@DESC : inserting InventoryGroupRegistration for masterdata dropdown
 *@AuthorName : Habiboon Patan
 *@DATE : 2019-08-28
 */

function insertInventoryGroupForDropDown() {
    var inventoryGroupName = $('#reg_scm_invGrpId').val();
    var status = document.getElementById("switch2").checked;
    var inventoryGroupCode = $('#reg_scm_invgroupCodeId').val();
    var createdbyid = 1;
    var createdbyroleid = 1;
    var createdbymoduleid = 1;
    if (inventoryGroupName === "null" || inventoryGroupName === "" || inventoryGroupName === '') {
        showNotificationError("Enter inventoryGroupName", "reg_scm_invGrpId", "error");
        return;
    } else if (inventoryGroupCode === "null" || inventoryGroupCode === "" || inventoryGroupCode === '') {
        showNotificationError("Enter inventoryGroupCode", "reg_scm_invgroupCodeId", "error");
        return;
    }

    var obj_Insert = {
        groupId: 0,
        groupCode: inventoryGroupCode,
        groupName: inventoryGroupName,
        userId: createdbyid,
        roleId: createdbyroleid,
        moduleId: createdbymoduleid,
        status: status,
        operationType: 1

    };
    console.log('==== Obj_Insert' + JSON.stringify(obj_Insert));
    var strUrl = Service.INSERT_UPDATE_INVENTORY_GROUP_DROPDOWN;
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
                showNotificationError("Inserted Successfully", "insertInventoryGroupId", "success");
                // window.location();
                //   getdrugBrandDropDownDetails();

            }
        },
        error: function() {
            console.log("Error In insertInventoryGroupRegistationForDropDown");
        }
    });
}


/*
 *@DESC : getInventoryGroupNamesData
 *@AuthorName : Habiboon Patan
 *@DATE : 2019-08-28
 */

function getInventoryGroupNamesData() {
    $('#driverTable').html("");
    var strUrl = Service.GET_INVENTORYGROUP_DATA;
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
                var jsonArray = data.obMaterialGroupControllerDTO;
                if (jsonArray.length > 0) {
                    getInventoryGroupList(jsonArray);
                    loadDataTable();
                }
            }
        },
        error: function(err) {
            console.error('update Stock error: ' + JSON.stringify(err));
        }
    });
}

function getInventoryGroupList(strData) {

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

    var objTHead2 = document.createElement('th');
    $(objTHead2).html('Inventory Group Name');
    $(objTr).append(objTHead2);

    var objTHead3 = document.createElement('th');
    $(objTHead3).html('Group Code');
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
        $(tblCol1).html(strData[i].groupName);
        $(tbleRow).append(tblCol1);

        var tblCol2 = document.createElement('td');
        $(tblCol2).addClass('text-center');
        $(tblCol2).html(strData[i].groupCode);
        $(tbleRow).append(tblCol2);

        var tblCol3 = document.createElement('td');
        $(tblCol3).addClass('text-center');
        $(tblCol3).html(strData[i].status);
        $(tbleRow).append(tblCol3);

        var tablcol12 = document.createElement("td");
        var buttonTag = document.createElement('button');
        var text = document.createTextNode("EDIT");
        buttonTag.appendChild(text);
        $(buttonTag).addClass('btn btn-primary btn-sm');
        $(buttonTag).attr('onclick', 'inventoryGroupNameEdit("' + strData[i].groupId + '","' + strData[i].groupName + '","' + strData[i].groupCode + '","' + strData[i].status + '")');
        $(buttonTag).attr('id', 'inventoryGroupNameEditId');
        $(tablcol12).append(buttonTag);
        $(tablcol12).css('height', '36px');
        $(tbleRow).append(tablcol12);
        $(objTBody).append(tbleRow);
    }
    $("#driverTable").append(objDivTag);
}
var groupId;
function inventoryGroupNameEdit(inventorygroupId, groupName, groupCode, status) {
    $('#update').modal('show');
    $("#up_scm_invGrpId").val(groupName);
    $("#up_scm_groupCodeId").val(groupCode);
    groupId = inventorygroupId;
}



function updateInventoryGroupNames() {
    var inventoryGroupName = $('#up_scm_invGrpId').val();
    var status = document.getElementById("switch1").checked;
    var inventoryGroupCode = $('#up_scm_groupCodeId').val();
    var createdbyid = 1;
    var createdbyroleid = 1;
    var createdbymoduleid = 1;
    if (inventoryGroupName === "null" || inventoryGroupName === "" || inventoryGroupName === '') {
        showNotificationError("Enter inventoryGroupName", "up_scm_invGrpId", "error");
        return;
    } else if (inventoryGroupCode === "null" || inventoryGroupCode === "" || inventoryGroupCode === '') {
        showNotificationError("Enter inventoryGroupCode", "up_scm_groupCodeId", "error");
        return;
    }

    var obj_Insert = {
        groupId: groupId,
        groupCode: inventoryGroupCode,
        groupName: inventoryGroupName,
        userId: createdbyid,
        roleId: createdbyroleid,
        moduleId: createdbymoduleid,
        status: status,
        operationType: 2

    };
    console.log('==== Obj_Insert' + JSON.stringify(obj_Insert));
    var strUrl = Service.INSERT_UPDATE_INVENTORY_GROUP_DROPDOWN;
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
                showNotificationError("Updated Successfully", "updateInventoryGroupNameId", "success");
                //windows.location();
            }
        },
        error: function() {
            console.log("Error In updateInventoryGroupNames");
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
                        title: 'Inventory_Group_Names_List'
                    },
                    {
                        extend: 'pdf',
                        title: 'Inventory_Group_Names_List'
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



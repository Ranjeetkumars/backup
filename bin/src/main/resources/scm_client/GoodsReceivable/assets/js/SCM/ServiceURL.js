
var SYSTEM_IP1 = "192.168.1.215:8081/FleetManagement";
var SYSTEM_IP = "192.168.1.215:2000/scmservice";
var serverIP = '192.168.1.100:2020';
Service = {
    //Login 
    isUserExist: 'http://' + SYSTEM_IP1 + '/login/isUserExist',
    checkForModule: 'http://' + SYSTEM_IP1 + '/login/checkForModule',
    getRoles: 'http://' + SYSTEM_IP1 + '/login/getRoles',
    getPrevillages: 'http://' + SYSTEM_IP1 + '/login/getPrevillages',
    loginUrl: 'http://' + SYSTEM_IP1 + '/login/login',
    logout: 'http://' + SYSTEM_IP1 + '/login/logout',
    //--------------------Brand Name Registration --------------------//

    INSERT_DRUG_DROPDOWN: 'http://' + SYSTEM_IP + '/BrandRegistrationController/saveDrugDetails',
    GET_DRUG_BRANDNAMES_DROPDOWN: 'http://' + SYSTEM_IP + '/BrandRegistrationController/loadBrandDetails',
    UPDATE_DRUG_BANDNAMES_DROPDOWN: 'http://' + SYSTEM_IP + '/BrandRegistrationController/UpdateDrugDetails',
    //---------------- Inventory Group Registration ---------------//

    INSERT_UPDATE_INVENTORY_GROUP_DROPDOWN: 'http://' + SYSTEM_IP + '/MaterialGroupController/saveorUpdateMaterialUnit',
    GET_INVENTORYGROUP_DATA: 'http://' + SYSTEM_IP + '/MaterialGroupController/loadMaterialGroup',
    
    ManufactureNameDropDown:'http://' + SYSTEM_IP + '/drugRegisteringService/loadManufaturer',
    
    saveManufactureName: 'http://' + serverIP + '/scmservice/MaterialManufactureController/saveManufacture',
    loadManufactureName: 'http://' + serverIP + '/scmservice/MaterialManufactureController/loadMaterialManufacture',
    updateMAnufactureName: 'http://' + serverIP + '/scmservice/MaterialManufactureController/updateManufacture',
    

};

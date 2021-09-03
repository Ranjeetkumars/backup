
var SYSTEM_IP = "localhost:2000/scmservice";

Service = {
		
		GET_PURCHASE_ORDER_LIST: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/getAllPurchaseOrderList',
        GET_GENERATE_INDENT_NUMBER: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/getGenerateIndentNumber',

        SAVE_INDENT_ITEM_DETAILS:'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/saveIndentItemDetails',
        SAVE_PURCHASE_ORDER_ITEM_QUANTITY: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/savePurchaseOrderItemQuantity',

        GET_BRAND_NAMES: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/loadBrandNames',
        GET_MANUFACTURE_FORM: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/loadManufactureForm',
        GET_MANUFACTURE_COMPANY: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/loadManufactureCompnayNames',

        GET_PUCHASED_ORDER_DRUGS: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/getAllPurchaseOrderDrugCount',
        
        LOAD_INDENTS: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/loadIndents',
        INDENT_DETAILS: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/getIndentDetails',
        LOAD_SUPPLIERS: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/loadSupplier',
        SAVE_PURCHASE_ORDER: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/savePoId',
        GENERATE_PO_NUMBER: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/generatePoNumber',
        SAVE_PURCHASE_ORDER_ITEM_DETAILS: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/savePurchaseOrderItemDetails',
        
        CENTRAL_CLOSE: 'http://' + SYSTEM_IP + '/PlacingOrdersForPurchaseController/centralClose',
        
        
        
        GET_ALL_INDENT_DETAILS: 'http://' + SYSTEM_IP + '/drugRegisteringService/getAllIndentDetails',
        UPDATE_INDENT_REJECTION: 'http://' + SYSTEM_IP + '/drugRegisteringService/updateIndentReject',
        APPROVAL_ITEM_LIST: 'http://' + SYSTEM_IP + '/drugRegisteringService/allApprovalItemList',
        INDENT_DATA: 'http://' + SYSTEM_IP + '/drugRegisteringService/strIndentDetails',
        UPDATE_INDENT_DETAILS: 'http://' + SYSTEM_IP + '/drugRegisteringService/updateIndentDetails',
        REJECT_INDENT: 'http://' + SYSTEM_IP + '/drugRegisteringService/rejectIndentData',
        
        
       
        
        GET_ALL_RECEIVED_GOODS: 'http://' + SYSTEM_IP + '/ReceivedGoodsController/getAllReceivedGoodsSearch',
        GET_TERMS_CONDITIONS: 'http://' + SYSTEM_IP + '/ReceivedGoodsController/getTermsConditions',
        GET_ALL_RECEIVED_GOODS_BY_INDENT_ID: 'http://' + SYSTEM_IP + '/ReceivedGoodsController/getAllReceivedGoodsByIndentId',
        SAVE_RECEIVED_GOODS: 'http://' + SYSTEM_IP + '/PurchaseOrderController/saveReceivedGoodsDetails',
        UPDATE_PO_ITEMS: 'http://' + SYSTEM_IP + '/PurchaseOrderController/updatePoitemns',
        UPDATE_STATUS: 'http://' + SYSTEM_IP + '/ReceivedGoodsController/updateStatus',
        
        
        ADJUSTMENT_TYPE: 'http://' + SYSTEM_IP + '/expiryDrugsController/loadAdjustmentType',
        LOAD_BRABDS_DROPDOWN: 'http://' + SYSTEM_IP + '/addNewDrugController/loadBrand',
        LOAD_FORM_DROPDOWN: 'http://' + SYSTEM_IP + '/addNewDrugController/loadForm',
        LOAD_MANUFACTURE_COMPANIES_DROPDOWN: 'http://' + SYSTEM_IP + '/addNewDrugController/loadManufacturer',
        LOAD_STORE_DROPDOWN: 'http://' + SYSTEM_IP + '/expiryDrugsController/loadStores',
        LOAD_USERS: 'http://' + SYSTEM_IP + '/expiryDrugsController/loadUsers',
        STOCK_ADJUSTMENT_SEARCH: 'http://' + SYSTEM_IP + '/expiryDrugsController/adjustmentSearch',
        
        SAVE_ADJUSTED_STOCK_DATA: 'http://' + SYSTEM_IP + '/AdjustmentStockController/saveAdjustedStockDetails',
        UPDATE_STOCK_QUANTITY: 'http://' + SYSTEM_IP + '/AdjustmentStockController/updateStockQuantity',
 
        LOAD_RETURN_DRUGS: 'http://' + SYSTEM_IP + '/expiryDrugsController/LoadReturnDrugs',
        LOAD_SUPPLIERS: 'http://' + SYSTEM_IP + '/AdjustmentStockController/loadEmployees',
        LOAD_ZONES: 'http://' + SYSTEM_IP + '/expiryDrugsController/load_zones',
        LOAD_BASELOCATIONS: 'http://' + SYSTEM_IP + '/expiryDrugsController/load_baselocations',
        LOAD_VEHICLES: 'http://' + SYSTEM_IP + '/expiryDrugsController/load_vehicles',
        
        LOAD_SUBSTORE: 'http://' + SYSTEM_IP + '/expiryDrugsController/loadSubStore',
        SAVE_RETURN_DRUGS: 'http://' + SYSTEM_IP + '/expiryDrugsController/saveReturnDrugs'
        
        
        
//        http://localhost:2000/scmservice/expiryDrugsController/getVehicleMappingStatus
//        http://localhost:2000/scmservice/expiryDrugsController/LoadReturnDrugs
//        http://localhost:2000/scmservice/expiryDrugsController/saveReturnDrugs
        
        
}
package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class DrugAndSupplierMappingControllerDto {
	private String supplierId;
    private String supplierName;
    
    private String drugId;
    private String unicCode;
    private String drugName;
    private String drugBarndlang1;
    private String fromType;
    private String strength;
    private String companyname;
    private String moleculesType;
    private String purchageprice;
    private String purchageunitcost;
    private String mrp;
    private String unitcost;
    private String vatpercentag;
    private String discount;
    private String startdate;
    
    
  
	private String strSupplierId;
	private String strPurchasprice;
	private String strPrUnit;
	private String strMrp;
	private String strUnitprice;
	private String strVat;
	private String strDiscount;
	private String strStardate;
	
	private String rowCountSize;
	private String createdById;
	private String createdByModuleId;
	private String createdByRoleId;
	

}

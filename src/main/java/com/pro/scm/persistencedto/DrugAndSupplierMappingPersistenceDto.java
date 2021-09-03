package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class DrugAndSupplierMappingPersistenceDto {
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
}

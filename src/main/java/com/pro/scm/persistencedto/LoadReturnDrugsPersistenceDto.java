package com.pro.scm.persistencedto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoadReturnDrugsPersistenceDto {
	
	private String drugId;
	private String drugName;
	private String drugBrand;
	private String drugShortUnicCode;
	private String dfFormType;
	private String drStrenghtType;
	private String companyName;
	private String batchNumber;
	private String expireDate;
	private String formId;
	private String ddjustedStockQty;
	private String datSerialId;
	private String datInvoiceNo;
	

}

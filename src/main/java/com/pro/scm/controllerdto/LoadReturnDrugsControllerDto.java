package com.pro.scm.controllerdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoadReturnDrugsControllerDto {
	
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
	private String storeId;
	private String adjId;
	private String typeId;
	private String suplierId;

}

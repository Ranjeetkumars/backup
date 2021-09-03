package com.pro.scm.controllerdto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoadExpiryDrugsControllerDto {
	
	private String drugId;
	private String drugName;
	private String drugBrand;
	private String drugShortUnicCode;
	private String billNo;
	private String dfFormType;
	private String drStrenghtType;
	private String companyName;
	private String batchNumber;
	private String expireDate;
	private String dmrAvailableStock;
	private String drrAvailableStock;
	private String totalExp;
	private String pdtQuantity;
	private String supplierId;
	private String drFormId;

}

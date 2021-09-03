package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class GenerateNewDrugBarcodeServiceDto {
	
	private String genericId;
	private String genericName;
	private String groupId;
	private String shortCode;
	private String barCode;

}

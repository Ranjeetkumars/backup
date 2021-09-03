package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class GenerateNewDrugBarcodeControllerDto {
	
	private String genericId;
	private String genericName;
	private String groupId;
	private String shortCode;
	private String barCode;

}

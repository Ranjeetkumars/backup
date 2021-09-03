package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class ListLoadActiveDrugsPersistenceDto {
	
	private String drugId;
	private String drugName;
	private String drugBrand;
	private String drugunicode;
	private String formType;
	private String drugStrength;
	private String manufacture;

}

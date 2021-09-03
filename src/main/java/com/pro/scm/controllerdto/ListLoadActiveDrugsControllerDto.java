package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class ListLoadActiveDrugsControllerDto {
    private String offset;
	private String drugStatusId;
	private String pageLimit;
	private String drugId;
	private String drugName;
	private String drugBrand;
	private String drugunicode;
	private String formType;
	private String drugStrength;
	private String manufacture;

}

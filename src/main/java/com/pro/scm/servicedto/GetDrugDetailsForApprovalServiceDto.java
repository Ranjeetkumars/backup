package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class GetDrugDetailsForApprovalServiceDto {
	
	
	private String drugId;
	private String genricName;
	private String drugBrandName;
	private String sheduleType;
	private String companyName;
	private String systypelanguageone;

	private String groupFunctionLanGone;
	private String grpModuleTypeLanGone;
	private String formtype;
	private String strength;
	private String packingType;
	private String shortUniCode;

	private String minimumLevelQty;
	private String maxLevelQty;
	private String expiryAlert;

	private String userName;
	private String roleName;
	private String createdDate;



}

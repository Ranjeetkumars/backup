package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class AllPurchaseOrdersByMesserIdControllerDto {
	
	private String drugId;
	private String druggenricName;
	private String brandName;
	private String formType;
	private String strength;
	private String companyName;
	private String approvlId;
	private String serialId;
	private String cdsiid;
	private String indentId;
	private String messerId;

}

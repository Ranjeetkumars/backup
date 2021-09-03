package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class AllPurchaseOrdersByMesserIdPersistenceDto {
	
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

}

package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class PharmacyStorePersistenanceDTO {
	private String storeId;	
	private String storeName;
	private String description;
	private String userId;
	private String roleId;
	private String moduleId;
	private String status;
	private String typeStoreId;
}

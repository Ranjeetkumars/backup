package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class ItemShelveDetailsServiceDTO {
	private String storeId;
	private String shelveId;
	private String itemId;
	private String userId;
	private String roleId;
	private String moduleId;
	private String status;
	private String rackShelveId;
	private String rackId;
	private String rackName;
}

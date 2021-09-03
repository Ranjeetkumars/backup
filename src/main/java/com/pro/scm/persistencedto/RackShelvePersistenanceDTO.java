package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class RackShelvePersistenanceDTO {
	private String shelveId;
	private String shelveName;
	private String userId;
	private String roleId;
	private String moduleId;
	private String storeId;
	private String rackId;
	private String status;
	private String rackName;
	private String counterName;
}

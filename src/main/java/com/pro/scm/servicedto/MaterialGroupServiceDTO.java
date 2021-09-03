package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class MaterialGroupServiceDTO {
	private String groupId;
	private String groupName;
	private String groupCode;
	private String status;
	private String operationType;
	private String userId;
	private String roleId;
	private String moduleId;

	private String unitId;
	private String unitName;
	private String conversionFactor;
	private String materialForm;
}

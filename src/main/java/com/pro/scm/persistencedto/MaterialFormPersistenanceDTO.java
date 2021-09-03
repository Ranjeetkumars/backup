package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class MaterialFormPersistenanceDTO {
	private String materialFormId;	
	private String materialForm;
	private String userId;
	private String roleId;
	private String moduleId;
	private String status;
	private String materialGroupId;
}

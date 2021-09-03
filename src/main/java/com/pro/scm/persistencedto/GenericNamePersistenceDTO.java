package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class GenericNamePersistenceDTO {
	private String genericId;
	private String genericName;
	private String shortCode;
	private String moduleId;
	private String roleId;
	private String userId;
	private String status;

}

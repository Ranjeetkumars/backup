package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class LoadMaterialFormPersistenceDto {
	
	private String formId;
	private String formPName;
	private String serialId;
	private String fromType;
	private String status;

}

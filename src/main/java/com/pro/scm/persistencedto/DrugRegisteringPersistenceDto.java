package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class DrugRegisteringPersistenceDto {
	
	private String serialId;
	private String drugName;
	private String drugBrandLang1;
	private String shortUnicCode;
	private String fromType;
	private String strength;
	private String companyName;
	private String groupMoleculesTypeLang1;

}

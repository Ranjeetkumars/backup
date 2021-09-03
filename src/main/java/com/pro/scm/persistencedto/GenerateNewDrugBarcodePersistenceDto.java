package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class GenerateNewDrugBarcodePersistenceDto {
	private String genericId;
	private String genericName;
	private String barCode;

}

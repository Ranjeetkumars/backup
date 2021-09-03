package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class Store_item_detailsPersistenceDto {
  
	private String drugId;
	private String drShortUnicCode;
	private String drugName;
	private String groupName;
	private String pt_PackingTyp;
	private String conersionFactor;
	private String ordeQty;
	private String availQty;

}

package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class Store_item_detailsServiceDto {
	private String  storeTypeId;
	private String drugId;
	private String drShortUnicCode;
	private String drugName;
	private String groupName;
	private String pt_PackingTyp;
	private String conersionFactor;
	private String ordeQty;
	private String availQty;

}

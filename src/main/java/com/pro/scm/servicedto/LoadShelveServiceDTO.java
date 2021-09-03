package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class LoadShelveServiceDTO {
	private String storeId;
	private String rackId;
	private String shelveId;
	private String shelvename;
}

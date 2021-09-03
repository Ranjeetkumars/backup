package com.pro.scm.servicedto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoadSubStoreServiceDto {
	
	private String supStoreTypeId;
	private String countryId;
	private String countryName;

}

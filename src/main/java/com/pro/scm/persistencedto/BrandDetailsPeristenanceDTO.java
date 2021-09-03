package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class BrandDetailsPeristenanceDTO {
	private String brandId;
	private String brandName;
	private String status;
	
	  private String serialId;
      private String materialGroupId;
      private String groupName;
      private String drugName;
      private String shortUnicCode;
      private String barCode;
}

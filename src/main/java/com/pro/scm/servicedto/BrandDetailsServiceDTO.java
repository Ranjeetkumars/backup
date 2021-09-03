package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class BrandDetailsServiceDTO {
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

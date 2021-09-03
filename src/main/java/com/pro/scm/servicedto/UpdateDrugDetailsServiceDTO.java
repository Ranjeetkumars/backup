package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class UpdateDrugDetailsServiceDTO {
	private String brandId;
	private String brandName;
	private String userId;
	private String moduleId;
	private String roleId;
	private String status;
}

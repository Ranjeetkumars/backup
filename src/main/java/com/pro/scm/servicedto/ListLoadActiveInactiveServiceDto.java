package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class ListLoadActiveInactiveServiceDto {
	private String drugstatus;
	private String serialId;
	private String GenricDrugName;
	private String drugName;
	private String drugBrandLang1;
	private String companyName;
	private String formType;
	private String createdDate;

}

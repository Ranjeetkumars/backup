package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class SaveWardWiseCreditSalesServiceDto {
	private String billNo;
	private String fltTotalAmount;
	private String fltCreditAmount;
	private String fltPaidAmount;
	private String employeeId;
	private String createdbyId;
	private String moduleID;

}

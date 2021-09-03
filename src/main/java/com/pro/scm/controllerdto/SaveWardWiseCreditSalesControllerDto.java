package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class SaveWardWiseCreditSalesControllerDto {
	
	private String billNo;
	private String fltTotalAmount;
	private String fltCreditAmount;
	private String fltPaidAmount;
	private String employeeId;
	private String createdbyId;
	private String moduleID;

}

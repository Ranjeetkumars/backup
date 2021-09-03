package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class LoadPaymentDetailsPersistenceDto {
	
	private String pbpCrcardNo;
    private String pbpCrexpMonth;
    private String pbpCrexpyear;
    private String pbpBankName;
    private String pbpCrholdName;
    private String payment;
    private String billNumber;
    private String tcSerialId;
    private String tcCompanyName;
    
    
    

}

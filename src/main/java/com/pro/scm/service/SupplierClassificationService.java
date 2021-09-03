package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.SupplierClassificationServiceDTO;

public interface SupplierClassificationService {
	
	   public String saveorupdateSupplierClass(SupplierClassificationServiceDTO objSupplierClassificationServiceDTO, String strRequestID,String operation_type)
			   throws DataNotFoundException;
		
	   public List<SupplierClassificationServiceDTO> loadSupplierClassification(String strRequestID) throws DataNotFoundException;
	   
	   
	   public List<SupplierClassificationServiceDTO> loadSupplierClassificationBasedId(String  Classification_id ,String strRequestID) throws DataNotFoundException;
	   //loadSupplierClassificationBasedId
}

package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.AdjustmentStockServiceDTO;


public interface AdjustmentStockService {
	 public String countDrugsByStore(AdjustmentStockServiceDTO  dataServiceDTO,String strRequestID) throws DataNotFoundException;
	 public String updateStockQuantity(AdjustmentStockServiceDTO dataServiceDTO, String strRequestID)throws DataNotFoundException;
	 public List<AdjustmentStockServiceDTO>loadEmployees(AdjustmentStockServiceDTO serviceDto , String strRequestID) throws DataNotFoundException;
	 public String saveAdjustedStockDetails(AdjustmentStockServiceDTO dataServiceDTO, String strRequestID)throws DataNotFoundException;


	
	 public List<AdjustmentStockServiceDTO>loadEmployees(String strRequestID) throws DataNotFoundException;
	
	


}

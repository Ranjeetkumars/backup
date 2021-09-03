package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.StockAdjustmentServiceDTO;



public interface StockAdjustmentService {
	
    public String addAdjustType(StockAdjustmentServiceDTO objStockAdjustmentServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String updateAdjustType(StockAdjustmentServiceDTO objStockAdjustmentServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<StockAdjustmentServiceDTO> loadAdjustTypes(String strRequestID) throws DataNotFoundException;
	
	public String adjustmentIsExist(StockAdjustmentServiceDTO objStockAdjustmentServiceDTO, String strRequestID)throws DataNotFoundException;
}

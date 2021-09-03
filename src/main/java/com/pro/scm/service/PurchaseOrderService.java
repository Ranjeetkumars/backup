package com.pro.scm.service;

import com.pro.scm.exceptions.DataNotFoundException;

import com.pro.scm.servicedto.PurchaseOrderServiceDTO;

public interface PurchaseOrderService {
	
	 public String saveReceivedGoodsDetails(PurchaseOrderServiceDTO dataServiceDTO, String strRequestID)throws DataNotFoundException;
	 public String updatePoitemns(PurchaseOrderServiceDTO dataServiceDTO, String strRequestID)throws DataNotFoundException;

}

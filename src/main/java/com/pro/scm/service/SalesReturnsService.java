package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.SalesReturnsServiceDTO;

public interface SalesReturnsService {
	 public String saveReturnDetails(SalesReturnsServiceDTO dataServiceDTO, String strRequestID)throws DataNotFoundException;
	 public String updateReturnStock(SalesReturnsServiceDTO dataServiceDTO, String strRequestID)throws DataNotFoundException;
     public List<SalesReturnsServiceDTO> getBillDetails(SalesReturnsServiceDTO dataInfo,String requestID) throws DataNotFoundException;
     public List<SalesReturnsServiceDTO> getBillItemDetails(SalesReturnsServiceDTO dataInfo,String requestID) throws DataNotFoundException;


}

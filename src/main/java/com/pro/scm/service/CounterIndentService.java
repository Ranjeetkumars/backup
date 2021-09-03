package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.CounterIndentServiceDTO;


public interface CounterIndentService {
	 public String insertRaiseCounterIndentQuantity(CounterIndentServiceDTO serviceDto, String strRequestID)throws DataNotFoundException;
	 public List<CounterIndentServiceDTO> getGenerateRetailIndentNumber(CounterIndentServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	 public String updateItemStatus(CounterIndentServiceDTO serviceDto, String strRequestID)throws DataNotFoundException;
	 public List<CounterIndentServiceDTO> loadIndentItemsList(CounterIndentServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	  
}

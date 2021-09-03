package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.IndentViewServiceDTO;

public interface IndentViewService {
	public List<IndentViewServiceDTO> load_to_store(IndentViewServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	public String saveReceivedStock(IndentViewServiceDTO serviceDto, String strRequestID)throws DataNotFoundException;
	public String UpdateStock(IndentViewServiceDTO serviceDto, String strRequestID)throws DataNotFoundException;
	public String insertRaiseIndentQuantity(IndentViewServiceDTO serviceDto, String strRequestID)throws DataNotFoundException;
	public String updateIndentStatus(IndentViewServiceDTO serviceDto, String strRequestID)throws DataNotFoundException;
	public List<IndentViewServiceDTO> getLoadMainStoreDrugs(IndentViewServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;

	
	
	
	
}

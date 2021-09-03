package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.RackShelveServiceDTO;


public interface RackShelveDetailsService {

	public String saveRackShelveDetails(RackShelveServiceDTO objRackShelveServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String updateRackShelveDetails(RackShelveServiceDTO objRackShelveServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<RackShelveServiceDTO> loadRackShelveDetails(String strRequestID)throws DataNotFoundException;
}

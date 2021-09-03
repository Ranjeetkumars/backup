package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.RackDetailsServiceDTO;



public interface RackDetailsService {

	public String saveRackDetails(RackDetailsServiceDTO objRackDetailsServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String UpdateRackDetails(RackDetailsServiceDTO objRackDetailsServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<RackDetailsServiceDTO> loadRackDetails(String strRequestID)throws DataNotFoundException;
}

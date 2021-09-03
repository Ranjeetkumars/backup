package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.VehicleSubStoreServiceDTO;

public interface VehicleSubStoreService {

	public List<VehicleSubStoreServiceDTO> loadVehicleSubStoreMapping(String strRequestID) throws DataNotFoundException;
	
	public String getStatusVehicleCount(VehicleSubStoreServiceDTO objVehicleSubStoreServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String saveVehicleSubStoreMapping(VehicleSubStoreServiceDTO objVehicleSubStoreServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String updateVehicleSubStoreMapping(VehicleSubStoreServiceDTO objVehicleSubStoreServiceDTO, String strRequestID)throws DataNotFoundException;
}

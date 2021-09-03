package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.UpdateDrugDetailsServiceDTO;
import com.pro.scm.servicedto.VehicleTypeServiceDTO;

public interface BrandRegistrationService {

	public String UpdateDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String saveDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<BrandDetailsServiceDTO> loadBrandDetails(String strRequestID) throws DataNotFoundException;

	public List<VehicleTypeServiceDTO> loadVehicleType(String strRequestID) throws DataNotFoundException;
}
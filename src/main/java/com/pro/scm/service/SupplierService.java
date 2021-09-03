package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.SupplierServiceDTO;

public interface SupplierService {

	public String saveSupplier(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String updateSupplier(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<SupplierServiceDTO> loadClassification(String strRequestID)throws DataNotFoundException;
	
	public List<SupplierServiceDTO> getSupplier(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;

	public List<SupplierServiceDTO> loadCountry(String strRequestID)throws DataNotFoundException;
	
	public List<SupplierServiceDTO> loadState(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;
	//
	
	
	
	public List<SupplierServiceDTO> loadDistrict(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;
	
	
	public List<SupplierServiceDTO> loadCity(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;
//
	public List<SupplierServiceDTO> loadLandmark(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;

	public List<SupplierServiceDTO> loadLocality(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;
	
	
	public List<SupplierServiceDTO> loadZipCode(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)throws DataNotFoundException;
	
}

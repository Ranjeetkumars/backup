package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.PharmacyStoreServiceDTO;
import com.pro.scm.servicedto.StoreServiceDTO;

public interface PharmacyStoreService {
	
	public String addStores(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String UpdateStores(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String checkPharmacyStoreExist(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String getStoreStatus(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO,String strRequestID)throws DataNotFoundException;
	
	public List<StoreServiceDTO> loadPharmacyStores(String strRequestID)throws DataNotFoundException;
	
	public List<StoreServiceDTO> loadStoreType(String strRequestID)throws DataNotFoundException;
}

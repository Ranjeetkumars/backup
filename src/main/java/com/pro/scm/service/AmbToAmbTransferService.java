package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.AcceptTransferItemsServiceDto;
import com.pro.scm.servicedto.AmbToAmbTransferServiceDTO;
public interface AmbToAmbTransferService {
	public List<AmbToAmbTransferServiceDTO> loadVehicleItems(AmbToAmbTransferServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	
	public List<AmbToAmbTransferServiceDTO> loadVehicleReqAmbItems(AmbToAmbTransferServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	
	public List<AmbToAmbTransferServiceDTO> getAllCounterMedicines(AmbToAmbTransferServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	
	public List<AmbToAmbTransferServiceDTO> getRetailIndentDetails(AmbToAmbTransferServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	
	public String saveUpdateItems(AcceptTransferItemsServiceDto serviceDTO,String strRequestID) throws DataNotFoundException;
	
	public String saveTransferItemsDetails(AcceptTransferItemsServiceDto ambToAmbTransferServiceDTO,String strRequestID) throws DataNotFoundException;
}

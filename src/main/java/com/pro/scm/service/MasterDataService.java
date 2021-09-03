package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.servicedto.UpdateDrugDetailsServiceDTO;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;


public interface MasterDataService {

	public String UpdateDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<PharamacyNewDrugQtyServiceDto> searchDrug(PharamacyNewDrugQtyServiceDto objPharamacyNewDrugQtyServiceDto,String strRequestID) throws DataNotFoundException;
	
	public String saveDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<BrandDetailsServiceDTO> loadBrandDetails(String strRequestID) throws DataNotFoundException;
	
	public List<VehicleTypeDrugsServiceDTO> loadVehicleTypeWiseDrugDetails(VehicleTypeDrugsServiceDTO objVehicleTypeDrugsServiceDTO,String strRequestID) throws DataNotFoundException;

	public List<BrandDetailsServiceDTO> printBarCode(String strRequestID) throws DataNotFoundException;
	
	

}
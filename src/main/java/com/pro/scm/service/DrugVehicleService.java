package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.DrugVehicleTypeMappingServiceDTO;
import com.pro.scm.servicedto.MapDrugToVehicleServiceDTO;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;

public interface DrugVehicleService {

	public List<DrugVehicleTypeMappingServiceDTO> loadDrugNames(DrugVehicleTypeMappingServiceDTO objServiceDTO,
			String StrRequestId) throws DataNotFoundException;

	public String saveMapDrugToVehicle(MapDrugToVehicleServiceDTO objMapDrugToVehicleServiceDTO, String StrRequestId)
			throws DataNotFoundException;

	public List<VehicleTypeDrugsServiceDTO> loadVehicleTypeWiseDrugDetails(
			VehicleTypeDrugsServiceDTO objVehicleTypeDrugsServiceDTO, String strRequestID) throws DataNotFoundException;

	public List<?> loadVehicleTypeWiseDrugDetails_Get(Integer vehicleTypeId, Integer mappedTypeId, String strRequestID)
			throws DataNotFoundException;

	public List<VehicleTypeDrugsServiceDTO> AmbulanceType(String strRequestID) throws DataNotFoundException;
}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.VehicleTypeControllerDTO;
import com.pro.scm.persistencedto.VehicleTypePersistenanceDTO;
import com.pro.scm.servicedto.VehicleTypeServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class VehicleTypeMapper {
	public VehicleTypeServiceDTO conversionControllerDtoToServiceDto(
			VehicleTypeControllerDTO objVehicleTypeControllerDTO) {
		VehicleTypeServiceDTO objVehicleTypeDrugsServiceDTO = new VehicleTypeServiceDTO();
		BeanUtils.copyProperties(objVehicleTypeControllerDTO, objVehicleTypeDrugsServiceDTO);

		return objVehicleTypeDrugsServiceDTO;
	}
	
	
	
	public List<VehicleTypeControllerDTO> conversionForServiceTOControllerDTO(List<VehicleTypeServiceDTO> objServicedto) {
		List<VehicleTypeControllerDTO> objVehicleTypeDrugsControllerDTO = new ArrayList<VehicleTypeControllerDTO>();
		objServicedto.forEach(objVehicleTypeDrugsServiceDTO -> {
			VehicleTypeControllerDTO objBrandDetailsControllerDTO1 = new VehicleTypeControllerDTO();
			BeanUtils.copyProperties(objVehicleTypeDrugsServiceDTO, objBrandDetailsControllerDTO1);
			objVehicleTypeDrugsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objVehicleTypeDrugsControllerDTO;
	}

	public List<VehicleTypeServiceDTO> conversionpersistanceDTOtoServiceDTO(List<VehicleTypePersistenanceDTO> persistenceDTOs) {
		List<VehicleTypeServiceDTO> objServicedtos = new ArrayList<VehicleTypeServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			VehicleTypeServiceDTO objSearchServiceDto = new VehicleTypeServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<VehicleTypePersistenanceDTO> conversionForVehicleType(List<Object[]> list) {
		List<VehicleTypePersistenanceDTO> listOfData = new ArrayList<VehicleTypePersistenanceDTO>();
		for (Object[] objects : list) {
			VehicleTypePersistenanceDTO objPersistenceDTO = new VehicleTypePersistenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setVehicleTypeId(objects[0].toString());
			} else {
				objPersistenceDTO.setVehicleTypeId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setVehcleType(objects[1].toString());
			} else {
				objPersistenceDTO.setVehcleType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.VehicleTypeDrugsControllerDTO;
import com.pro.scm.persistencedto.VehicleTypeDrugsPersistenanceDTO;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class VehicleTypeDrugMapper {
	public VehicleTypeDrugsServiceDTO conversionControllerDtoToServiceDto(
			VehicleTypeDrugsControllerDTO objVehicleTypeDrugsControllerDTO) {
		VehicleTypeDrugsServiceDTO objVehicleTypeDrugsServiceDTO = new VehicleTypeDrugsServiceDTO();
		BeanUtils.copyProperties(objVehicleTypeDrugsControllerDTO, objVehicleTypeDrugsServiceDTO);

		return objVehicleTypeDrugsServiceDTO;
	}
	
	
	
	public List<VehicleTypeDrugsControllerDTO> conversionForServiceTOControllerDTO(List<?> sDto) {
		List<VehicleTypeDrugsControllerDTO> objVehicleTypeDrugsControllerDTO = new ArrayList<VehicleTypeDrugsControllerDTO>();
		sDto.forEach(objVehicleTypeDrugsServiceDTO -> {
			VehicleTypeDrugsControllerDTO objBrandDetailsControllerDTO1 = new VehicleTypeDrugsControllerDTO();
			BeanUtils.copyProperties(objVehicleTypeDrugsServiceDTO, objBrandDetailsControllerDTO1);
			objVehicleTypeDrugsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objVehicleTypeDrugsControllerDTO;
	}

	public List<VehicleTypeDrugsServiceDTO> conversionpersistanceDTOtoServiceDTO(List<VehicleTypeDrugsPersistenanceDTO> persistenceDTOs) {
		List<VehicleTypeDrugsServiceDTO> objServicedtos = new ArrayList<VehicleTypeDrugsServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			VehicleTypeDrugsServiceDTO objSearchServiceDto = new VehicleTypeDrugsServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<VehicleTypeDrugsPersistenanceDTO> conversionOFVehicleTypeWiseDrugDetails(List<Object[]> list) {
		List<VehicleTypeDrugsPersistenanceDTO> listOfData = new ArrayList<VehicleTypeDrugsPersistenanceDTO>();
		for (Object[] objects : list) {
			VehicleTypeDrugsPersistenanceDTO objPersistenceDTO = new VehicleTypeDrugsPersistenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setDrSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setMaterialGroupId(objects[1].toString());
			} else {
				objPersistenceDTO.setMaterialGroupId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setMgGroupName(objects[2].toString());
				} else {
					objPersistenceDTO.setMgGroupName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setDrDrugName(objects[3].toString());
				} else {
					objPersistenceDTO.setDrDrugName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[4] != null) {
					objPersistenceDTO.setDrShortunicCode(objects[4].toString());
				} else {
					objPersistenceDTO.setDrShortunicCode(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

      public List<VehicleTypeDrugsPersistenanceDTO> conversionOFAmbulanceType(List<Object[]> list) {
  		List<VehicleTypeDrugsPersistenanceDTO> listOfData = new ArrayList<VehicleTypeDrugsPersistenanceDTO>();
  		for (Object[] objects : list) {
  			VehicleTypeDrugsPersistenanceDTO objPersistenceDTO = new VehicleTypeDrugsPersistenanceDTO();
  			if (objects[0] != null) {
  				objPersistenceDTO.setVehicleTypeId(objects[0].toString());
  			} else {
  				objPersistenceDTO.setVehicleTypeId(CommonConstants.DATA_NOT_AVIALABLE);
  			}
  			 if (objects[1] != null) {
  				objPersistenceDTO.setVehicleType(objects[1].toString());
  			} else {
  				objPersistenceDTO.setVehicleType(CommonConstants.DATA_NOT_AVIALABLE);
  			}
  			 listOfData.add(objPersistenceDTO);
  		}
  		return listOfData;
  	}

}

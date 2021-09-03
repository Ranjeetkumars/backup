package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.VehicleSubStoreControllerDTO;
import com.pro.scm.persistencedto.VehicleSubStorePersistenaceDTO;
import com.pro.scm.servicedto.VehicleSubStoreServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class VehicleSubStoreMapper {
	public VehicleSubStoreServiceDTO conversionControllerDtoToServiceDto(
			VehicleSubStoreControllerDTO objVehicleSubStoreControllerDTO) {
		VehicleSubStoreServiceDTO objVehicleSubStoreServiceDTO = new VehicleSubStoreServiceDTO();
		BeanUtils.copyProperties(objVehicleSubStoreControllerDTO, objVehicleSubStoreServiceDTO);

		return objVehicleSubStoreServiceDTO;
	}
	
	
	
	public List<VehicleSubStoreControllerDTO> conversionForServiceTOControllerDTO(List<VehicleSubStoreServiceDTO> objServicedto) {
		List<VehicleSubStoreControllerDTO> objVehicleTypeDrugsControllerDTO = new ArrayList<VehicleSubStoreControllerDTO>();
		objServicedto.forEach(objVehicleTypeDrugsServiceDTO -> {
			VehicleSubStoreControllerDTO objBrandDetailsControllerDTO1 = new VehicleSubStoreControllerDTO();
			BeanUtils.copyProperties(objVehicleTypeDrugsServiceDTO, objBrandDetailsControllerDTO1);
			objVehicleTypeDrugsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objVehicleTypeDrugsControllerDTO;
	}

	public List<VehicleSubStoreServiceDTO> conversionpersistanceDTOtoServiceDTO(List<VehicleSubStorePersistenaceDTO> persistenceDTOs) {
		List<VehicleSubStoreServiceDTO> objServicedtos = new ArrayList<VehicleSubStoreServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			VehicleSubStoreServiceDTO objSearchServiceDto = new VehicleSubStoreServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<VehicleSubStorePersistenaceDTO> conversionForvehicleSubStoremapping(List<Object[]> list) {
		List<VehicleSubStorePersistenaceDTO> listOfData = new ArrayList<VehicleSubStorePersistenaceDTO>();
		for (Object[] objects : list) {
			VehicleSubStorePersistenaceDTO objPersistenceDTO = new VehicleSubStorePersistenaceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setSubVehicleId(objects[0].toString());
			} else {
				objPersistenceDTO.setSubVehicleId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setSubStoreId(objects[1].toString());
			} else {
				objPersistenceDTO.setSubStoreId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setVehicleId(objects[2].toString());
				} else {
					objPersistenceDTO.setVehicleId(CommonConstants.DATA_NOT_AVIALABLE);
				}
//			 if (objects[3] != null) {
//					objPersistenceDTO.setStatus(objects[3].toString());
//				} else {
//					objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
//				}
			 
			 
               if (objects[3] != null) {
				 
				 if(objects[3].toString().equalsIgnoreCase("true")) {
					 objPersistenceDTO.setStatus("Active");
				 }
				 else {
					 objPersistenceDTO.setStatus("InActive");
				 }
					
				} else {
					objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[4] != null) {
					objPersistenceDTO.setSubStoreName(objects[4].toString());
				} else {
					objPersistenceDTO.setSubStoreName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[5] != null) {
					objPersistenceDTO.setVehicleName(objects[5].toString());
				} else {
					objPersistenceDTO.setVehicleName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[6] != null) {
					objPersistenceDTO.setBaseLocation(objects[6].toString());
				} else {
					objPersistenceDTO.setBaseLocation(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[7] != null) {
					objPersistenceDTO.setLocation(objects[7].toString());
				} else {
					objPersistenceDTO.setLocation(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[8] != null) {
					objPersistenceDTO.setDescription(objects[8].toString());
				} else {
					objPersistenceDTO.setDescription(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
}

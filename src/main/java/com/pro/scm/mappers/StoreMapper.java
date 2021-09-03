package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.StoreControllerDTO;
import com.pro.scm.persistencedto.StorepersistenanceDTO;
import com.pro.scm.servicedto.StoreServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class StoreMapper {
	public StoreServiceDTO conversionControllerDtoToServiceDto(
			StoreControllerDTO objStoreControllerDTO) {
		StoreServiceDTO objBrandDetailsServiceDTO = new StoreServiceDTO();
		BeanUtils.copyProperties(objStoreControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<StoreControllerDTO> conversionForServiceTOControllerDTO(List<StoreServiceDTO> objServicedto) {
		List<StoreControllerDTO> objStoreControllerDTO = new ArrayList<StoreControllerDTO>();
		objServicedto.forEach(obStoreServiceDTO -> {
			StoreControllerDTO objStoreControllerDTO1 = new StoreControllerDTO();
			BeanUtils.copyProperties(obStoreServiceDTO, objStoreControllerDTO1);
			objStoreControllerDTO.add(objStoreControllerDTO1);
		});
		return objStoreControllerDTO;
	}

	public List<StoreServiceDTO> conversionpersistanceDTOtoServiceDTO(List<StorepersistenanceDTO> persistenceDTOs) {
		List<StoreServiceDTO> objServicedtos = new ArrayList<StoreServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			StoreServiceDTO objSearchServiceDto = new StoreServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<StorepersistenanceDTO> conversionForpharmacyStores(List<Object[]> list) {
		List<StorepersistenanceDTO> listOfData = new ArrayList<StorepersistenanceDTO>();
		for (Object[] objects : list) {
			StorepersistenanceDTO objPersistenceDTO = new StorepersistenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setCounterId(objects[0].toString());
			} else {
				objPersistenceDTO.setCounterId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setCounterName(objects[1].toString());
			} else {
				objPersistenceDTO.setCounterName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setCounterDesc(objects[2].toString());
				} else {
					objPersistenceDTO.setCounterDesc(CommonConstants.DATA_NOT_AVIALABLE);
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
					objPersistenceDTO.setFieldType(objects[4].toString());
				} else {
					objPersistenceDTO.setFieldType(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
      
      public List<StorepersistenanceDTO> conversionForStoreType(List<Object[]> list) {
  		List<StorepersistenanceDTO> listOfData = new ArrayList<StorepersistenanceDTO>();
  		for (Object[] objects : list) {
  			StorepersistenanceDTO objPersistenceDTO = new StorepersistenanceDTO();
  			if (objects[0] != null) {
  				objPersistenceDTO.setFieldTypeId(objects[0].toString());
  			} else {
  				objPersistenceDTO.setFieldTypeId(CommonConstants.DATA_NOT_AVIALABLE);
  			}
  			 if (objects[1] != null) {
  				objPersistenceDTO.setFieldType(objects[1].toString());
  			} else {
  				objPersistenceDTO.setFieldType(CommonConstants.DATA_NOT_AVIALABLE);
  			}
  			 listOfData.add(objPersistenceDTO);
  		}
  		return listOfData;
  	}
      

}

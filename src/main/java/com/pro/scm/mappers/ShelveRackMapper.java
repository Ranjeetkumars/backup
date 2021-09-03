package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.ShelveRackControllerDTO;
import com.pro.scm.persistencedto.ShelveRackPersistenanceDTO;
import com.pro.scm.servicedto.ShelveRackServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class ShelveRackMapper {
	
	public ShelveRackServiceDTO conversionControllerDtoToServiceDto(
			ShelveRackControllerDTO objShelveRackControllerDTO) {
		ShelveRackServiceDTO objBrandDetailsServiceDTO = new ShelveRackServiceDTO();
		BeanUtils.copyProperties(objShelveRackControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<ShelveRackControllerDTO> conversionForServiceTOControllerDTO(List<ShelveRackServiceDTO> objServicedto) {
		List<ShelveRackControllerDTO> objBrandDetailsControllerDTO = new ArrayList<ShelveRackControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			ShelveRackControllerDTO objShelveRackControllerDTO1 = new ShelveRackControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objShelveRackControllerDTO1);
			objBrandDetailsControllerDTO.add(objShelveRackControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<ShelveRackServiceDTO> conversionpersistanceDTOtoServiceDTO(List<ShelveRackPersistenanceDTO> persistenceDTOs) {
		List<ShelveRackServiceDTO> objServicedtos = new ArrayList<ShelveRackServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			ShelveRackServiceDTO objSearchServiceDto = new ShelveRackServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	
	 public List<ShelveRackPersistenanceDTO> conversionForStore(List<Object[]> list) {
		 List<ShelveRackPersistenanceDTO> listOfData = new ArrayList<ShelveRackPersistenanceDTO>();
			for (Object[] objects : list) {
				ShelveRackPersistenanceDTO objPersistenceDTO = new ShelveRackPersistenanceDTO();
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
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		 
	 }
	
	
	
	
	
	 public List<ShelveRackPersistenanceDTO> conversionForRackShelve(List<Object[]> list) {
			List<ShelveRackPersistenanceDTO> listOfData = new ArrayList<ShelveRackPersistenanceDTO>();
			for (Object[] objects : list) {
				ShelveRackPersistenanceDTO objPersistenceDTO = new ShelveRackPersistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setCounterName(objects[0].toString());
				} else {
					objPersistenceDTO.setCounterName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setDrugName(objects[1].toString());
				} else {
					objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
					objPersistenceDTO.setRackName(objects[2].toString());
					} else {
						objPersistenceDTO.setRackName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setSelveName(objects[3].toString());
					} else {
						objPersistenceDTO.setSelveName(CommonConstants.DATA_NOT_AVIALABLE);
					}
//				 if (objects[4] != null) {
//						objPersistenceDTO.setStatus(objects[4].toString());
//					} else {
//						objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
//					}
				 
				 if (objects[4] != null) {
					 
					 if(objects[4].toString().equalsIgnoreCase("true")) {
						 objPersistenceDTO.setStatus("Active");
					 }
					 else {
						 objPersistenceDTO.setStatus("InActive");
					 }
						
					} else {
						objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 
				 if (objects[5] != null) {
						objPersistenceDTO.setDrugField(objects[5].toString());
					} else {
						objPersistenceDTO.setDrugField(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 if (objects[6] != null) {
						objPersistenceDTO.setCounterId(objects[6].toString());
					} else {
						objPersistenceDTO.setCounterId(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 if (objects[7] != null) {
						objPersistenceDTO.setRackId(objects[7].toString());
					} else {
						objPersistenceDTO.setRackId(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.GenericNameControllerDTO;
import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.persistencedto.GenericNamePersistenceDTO;
import com.pro.scm.persistencedto.PlacingOrdersForPurchasePersistanceDTO;
import com.pro.scm.servicedto.GenericServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.utills.CommonConstants;



public class GenericNameMapper {
	public GenericServiceDTO conversionControllerDtoToServiceDto(
			GenericNameControllerDTO objGenericNameControllerDTO) {
		GenericServiceDTO objGenericServiceDTO = new GenericServiceDTO();
		BeanUtils.copyProperties(objGenericNameControllerDTO, objGenericServiceDTO);

		return objGenericServiceDTO;
	}
	

	public List<GenericNameControllerDTO> conversionForServiceTOControllerDTO(List<GenericServiceDTO> objServicedto) {
		List<GenericNameControllerDTO> objGenericNameControllerDto = new ArrayList<GenericNameControllerDTO>();
		objServicedto.forEach(GenericServiceDTO -> {
			GenericNameControllerDTO objGenericNameForPurchaseControllerDto1 = new GenericNameControllerDTO();
			BeanUtils.copyProperties(GenericServiceDTO, objGenericNameForPurchaseControllerDto1);
			objGenericNameControllerDto.add(objGenericNameForPurchaseControllerDto1);
		});
		return objGenericNameControllerDto;
	}

	public List<GenericServiceDTO> conversionpersistanceDTOtoServiceDTO(List<GenericNamePersistenceDTO> persistenceDTOs) {
		List<GenericServiceDTO> objServicedtos = new ArrayList<GenericServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			GenericServiceDTO objSearchServiceDto = new GenericServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<GenericNamePersistenceDTO> convertObjetsArraytoGetdrugsName(List<Object[]> list) {
		List<GenericNamePersistenceDTO> listOfData = new ArrayList<GenericNamePersistenceDTO>();
		for (Object[] objects : list) {
			GenericNamePersistenceDTO objPersistenceDTO = new GenericNamePersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setGenericId(objects[0].toString());
			} else {
				objPersistenceDTO.setGenericId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setGenericName(objects[1].toString());
			} else {
				objPersistenceDTO.setGenericName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 
			 if (objects[2] != null) {
					objPersistenceDTO.setShortCode(objects[2].toString());
				} else {
					objPersistenceDTO.setShortCode(CommonConstants.DATA_NOT_AVIALABLE);
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
			 listOfData.add(objPersistenceDTO);
		}
		
		return listOfData;
	}

		
}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.RackDetailsControllerDTO;
import com.pro.scm.persistencedto.RackDetailsperistenanceDTO;
import com.pro.scm.servicedto.RackDetailsServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class RackDetailsMapper {
	public RackDetailsServiceDTO conversionControllerDtoToServiceDto(
			RackDetailsControllerDTO objRackDetailsControllerDTO) {
		RackDetailsServiceDTO objRackDetailsServiceDTO = new RackDetailsServiceDTO();
		BeanUtils.copyProperties(objRackDetailsControllerDTO, objRackDetailsServiceDTO);

		return objRackDetailsServiceDTO;
	}
	
	
	
	public List<RackDetailsControllerDTO> conversionForServiceTOControllerDTO(List<RackDetailsServiceDTO> objServicedto) {
		List<RackDetailsControllerDTO> objRackDetailsControllerDTO = new ArrayList<RackDetailsControllerDTO>();
		objServicedto.forEach(RackShelveDetailsControllerDTO -> {
			RackDetailsControllerDTO objRackDetailsControllerDTO1 = new RackDetailsControllerDTO();
			BeanUtils.copyProperties(RackShelveDetailsControllerDTO, objRackDetailsControllerDTO1);
			objRackDetailsControllerDTO.add(objRackDetailsControllerDTO1);
		});
		return objRackDetailsControllerDTO;
	}

	public List<RackDetailsServiceDTO> conversionpersistanceDTOtoServiceDTO(List<RackDetailsperistenanceDTO> persistenceDTOs) {
		List<RackDetailsServiceDTO> objServicedtos = new ArrayList<RackDetailsServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			RackDetailsServiceDTO objSearchServiceDto = new RackDetailsServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<RackDetailsperistenanceDTO> conversionForRackDetails(List<Object[]> list) {
		List<RackDetailsperistenanceDTO> listOfData = new ArrayList<RackDetailsperistenanceDTO>();
		for (Object[] objects : list) {
			RackDetailsperistenanceDTO objPersistenceDTO = new RackDetailsperistenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setRackId(objects[0].toString());
			} else {
				objPersistenceDTO.setRackId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setRackName(objects[1].toString());
			} else {
				objPersistenceDTO.setRackName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setCounterName(objects[2].toString());
				} else {
					objPersistenceDTO.setCounterName(CommonConstants.DATA_NOT_AVIALABLE);
				}
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

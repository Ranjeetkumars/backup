package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.RackShelveDetailsControllerDTO;
import com.pro.scm.persistencedto.RackShelvePersistenanceDTO;
import com.pro.scm.servicedto.RackShelveServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class RackShelveDetailsMapper {
	
	public RackShelveServiceDTO conversionControllerDtoToServiceDto(
			RackShelveDetailsControllerDTO objRackShelveDetailsControllerDTO) {
		RackShelveServiceDTO objRackShelveServiceDTO = new RackShelveServiceDTO();
		BeanUtils.copyProperties(objRackShelveDetailsControllerDTO, objRackShelveServiceDTO);

		return objRackShelveServiceDTO;
	}
	
	
	
	public List<RackShelveDetailsControllerDTO> conversionForServiceTOControllerDTO(List<RackShelveServiceDTO> objServicedto) {
		List<RackShelveDetailsControllerDTO> objRackShelveDetailsControllerDTO = new ArrayList<RackShelveDetailsControllerDTO>();
		objServicedto.forEach(RackShelveDetailsControllerDTO -> {
			RackShelveDetailsControllerDTO objRackShelveDetailsControllerDTO1 = new RackShelveDetailsControllerDTO();
			BeanUtils.copyProperties(RackShelveDetailsControllerDTO, objRackShelveDetailsControllerDTO1);
			objRackShelveDetailsControllerDTO.add(objRackShelveDetailsControllerDTO1);
		});
		return objRackShelveDetailsControllerDTO;
	}

	public List<RackShelveServiceDTO> conversionpersistanceDTOtoServiceDTO(List<RackShelvePersistenanceDTO> persistenceDTOs) {
		List<RackShelveServiceDTO> objServicedtos = new ArrayList<RackShelveServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			RackShelveServiceDTO objSearchServiceDto = new RackShelveServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<RackShelvePersistenanceDTO> conversionForRackShelveDetails(List<Object[]> list) {
		List<RackShelvePersistenanceDTO> listOfData = new ArrayList<RackShelvePersistenanceDTO>();
		for (Object[] objects : list) {
			RackShelvePersistenanceDTO objPersistenceDTO = new RackShelvePersistenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setShelveId(objects[0].toString());
			} else {
				objPersistenceDTO.setShelveId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setShelveName(objects[1].toString());
			} else {
				objPersistenceDTO.setShelveName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setRackName(objects[2].toString());
				} else {
					objPersistenceDTO.setRackName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setCounterName(objects[3].toString());
				} else {
					objPersistenceDTO.setCounterName(CommonConstants.DATA_NOT_AVIALABLE);
				}
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
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

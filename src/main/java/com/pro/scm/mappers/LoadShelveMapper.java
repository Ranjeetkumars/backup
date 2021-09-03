package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadShelvesControllerDTO;
import com.pro.scm.persistencedto.LoadShelvePersistenanceDTO;
import com.pro.scm.servicedto.LoadShelveServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class LoadShelveMapper {
	public LoadShelveServiceDTO conversionControllerDtoToServiceDto(
			LoadShelvesControllerDTO objBrandDetailsControllerDTO) {
		LoadShelveServiceDTO objBrandDetailsServiceDTO = new LoadShelveServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<LoadShelvesControllerDTO> conversionForServiceTOControllerDTO(List<LoadShelveServiceDTO> objServicedto) {
		List<LoadShelvesControllerDTO> objBrandDetailsControllerDTO = new ArrayList<LoadShelvesControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			LoadShelvesControllerDTO objBrandDetailsControllerDTO1 = new LoadShelvesControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<LoadShelveServiceDTO> conversionpersistanceDTOtoServiceDTO(List<LoadShelvePersistenanceDTO> persistenceDTOs) {
		List<LoadShelveServiceDTO> objServicedtos = new ArrayList<LoadShelveServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			LoadShelveServiceDTO objSearchServiceDto = new LoadShelveServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<LoadShelvePersistenanceDTO> conversionForShelves(List<Object[]> list) {
			List<LoadShelvePersistenanceDTO> listOfData = new ArrayList<LoadShelvePersistenanceDTO>();
			for (Object[] objects : list) {
				LoadShelvePersistenanceDTO objPersistenceDTO = new LoadShelvePersistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setShelveId(objects[0].toString());
				} else {
					objPersistenceDTO.setShelveId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setShelvename(objects[1].toString());
				} else {
					objPersistenceDTO.setShelvename(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

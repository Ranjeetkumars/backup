package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.ItemShelvesDetailsControllerDTO;
import com.pro.scm.persistencedto.ItemShelvePersistenanceDTO;
import com.pro.scm.servicedto.ItemShelveDetailsServiceDTO;
import com.pro.scm.utills.CommonConstants;



public class ItemShelveMapper {
	public ItemShelveDetailsServiceDTO conversionControllerDtoToServiceDto(
			ItemShelvesDetailsControllerDTO objBrandDetailsControllerDTO) {
		ItemShelveDetailsServiceDTO objBrandDetailsServiceDTO = new ItemShelveDetailsServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<ItemShelvesDetailsControllerDTO> conversionForServiceTOControllerDTO(List<ItemShelveDetailsServiceDTO> objServicedto) {
		List<ItemShelvesDetailsControllerDTO> objBrandDetailsControllerDTO = new ArrayList<ItemShelvesDetailsControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			ItemShelvesDetailsControllerDTO objBrandDetailsControllerDTO1 = new ItemShelvesDetailsControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<ItemShelveDetailsServiceDTO> conversionpersistanceDTOtoServiceDTO(List<ItemShelvePersistenanceDTO> persistenceDTOs) {
		List<ItemShelveDetailsServiceDTO> objServicedtos = new ArrayList<ItemShelveDetailsServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			ItemShelveDetailsServiceDTO objSearchServiceDto = new ItemShelveDetailsServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<ItemShelvePersistenanceDTO> conversionForRackbyStore(List<Object[]> list) {
			List<ItemShelvePersistenanceDTO> listOfData = new ArrayList<ItemShelvePersistenanceDTO>();
			for (Object[] objects : list) {
				ItemShelvePersistenanceDTO objPersistenceDTO = new ItemShelvePersistenanceDTO();
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
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadItemControllerDTO;
import com.pro.scm.persistencedto.LoadItemPersistenanceDTO;
import com.pro.scm.servicedto.LoadItemServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class LoadItemMapper {
	public LoadItemServiceDTO conversionControllerDtoToServiceDto(
			LoadItemControllerDTO objBrandDetailsControllerDTO) {
		LoadItemServiceDTO objBrandDetailsServiceDTO = new LoadItemServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<LoadItemControllerDTO> conversionForServiceTOControllerDTO(List<LoadItemServiceDTO> objServicedto) {
		List<LoadItemControllerDTO> objBrandDetailsControllerDTO = new ArrayList<LoadItemControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			LoadItemControllerDTO objBrandDetailsControllerDTO1 = new LoadItemControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<LoadItemServiceDTO> conversionpersistanceDTOtoServiceDTO(List<LoadItemPersistenanceDTO> persistenceDTOs) {
		List<LoadItemServiceDTO> objServicedtos = new ArrayList<LoadItemServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			LoadItemServiceDTO objSearchServiceDto = new LoadItemServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<LoadItemPersistenanceDTO> conversionForLoadItems(List<Object[]> list) {
			List<LoadItemPersistenanceDTO> listOfData = new ArrayList<LoadItemPersistenanceDTO>();
			for (Object[] objects : list) {
				LoadItemPersistenanceDTO objPersistenceDTO = new LoadItemPersistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setDrugId(objects[0].toString());
				} else {
					objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setDrugname(objects[1].toString());
				} else {
					objPersistenceDTO.setDrugname(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

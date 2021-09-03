package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadManufactureControllerDTO;
import com.pro.scm.persistencedto.LoadManufacturePeristenanceDTO;
import com.pro.scm.servicedto.LoadManufactureServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class LoadManufactureMapper {
	public LoadManufactureServiceDTO conversionControllerDtoToServiceDto(
			LoadManufactureControllerDTO objBrandDetailsControllerDTO) {
		LoadManufactureServiceDTO objBrandDetailsServiceDTO = new LoadManufactureServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<LoadManufactureControllerDTO> conversionForServiceTOControllerDTO(List<LoadManufactureServiceDTO> objServicedto) {
		List<LoadManufactureControllerDTO> objBrandDetailsControllerDTO = new ArrayList<LoadManufactureControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			LoadManufactureControllerDTO objBrandDetailsControllerDTO1 = new LoadManufactureControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<LoadManufactureServiceDTO> conversionpersistanceDTOtoServiceDTO(List<LoadManufacturePeristenanceDTO> persistenceDTOs) {
		List<LoadManufactureServiceDTO> objServicedtos = new ArrayList<LoadManufactureServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			LoadManufactureServiceDTO objSearchServiceDto = new LoadManufactureServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<LoadManufacturePeristenanceDTO> conversionForManufacture(List<Object[]> list) {
			List<LoadManufacturePeristenanceDTO> listOfData = new ArrayList<LoadManufacturePeristenanceDTO>();
			for (Object[] objects : list) {
				LoadManufacturePeristenanceDTO objPersistenceDTO = new LoadManufacturePeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setManufactureId(objects[0].toString());
				} else {
					objPersistenceDTO.setManufactureId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setManufactureCompanyName(objects[1].toString());
				} else {
					objPersistenceDTO.setManufactureCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
	 
}

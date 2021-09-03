package com.pro.scm.mappers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadActiveDrugsControllerDto;

import com.pro.scm.persistencedto.LoadActiveDrugsPersistenceDto;

import com.pro.scm.servicedto.LoadActiveDrugsServiceDto;

import com.pro.scm.utills.CommonConstants;


public class LoadActiveDrugsMapper {
	
	public LoadActiveDrugsServiceDto conversionControllerDtoToServiceDto(
			LoadActiveDrugsControllerDto loadVehicleTransferItemsControllerDto) {
		LoadActiveDrugsServiceDto scmLoginServiceDto = new LoadActiveDrugsServiceDto();
		BeanUtils.copyProperties(loadVehicleTransferItemsControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadActiveDrugsControllerDto> conversionForServiceTOControllerDTO(
			List<LoadActiveDrugsServiceDto> objServicedto) {
		List<LoadActiveDrugsControllerDto> objControllerDto = new ArrayList<LoadActiveDrugsControllerDto>();

		objServicedto.forEach(serviceDto -> {
			LoadActiveDrugsControllerDto objControllerDto1 = new LoadActiveDrugsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadActiveDrugsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadActiveDrugsPersistenceDto> persistenceDTOs) {
		List<LoadActiveDrugsServiceDto> loadVehicleTransferItemsServiceDto = new ArrayList<LoadActiveDrugsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadActiveDrugsServiceDto objSearchServiceDto = new LoadActiveDrugsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			loadVehicleTransferItemsServiceDto.add(objSearchServiceDto);
		});
		return loadVehicleTransferItemsServiceDto;
	}

	public List<LoadActiveDrugsPersistenceDto> settingDataIntoLoadActiveDrugsPersistenceDto(
			List<Object[]> list) {
		List<LoadActiveDrugsPersistenceDto> listOfData = new ArrayList<LoadActiveDrugsPersistenceDto>();
		for (Object[] objects : list) {
			LoadActiveDrugsPersistenceDto objPersistenceDTO = new LoadActiveDrugsPersistenceDto();
           
			if (objects[0] != null) {
				objPersistenceDTO.setSeralId(objects[0].toString());
			} else {
				objPersistenceDTO.setSeralId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGenricDrugName(objects[1].toString());
			} else {
				objPersistenceDTO.setGenricDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrugName(objects[2].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
	
			if (objects[3] != null) {
				objPersistenceDTO.setDrugBrandLang1(objects[3].toString());
			} else {
				objPersistenceDTO.setDrugBrandLang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setCompanyName(objects[4].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setFormType(objects[5].toString());
			} else {
				objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setCreatedDate(objects[6].toString());
			} else {
				objPersistenceDTO.setCreatedDate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	
	
	
}

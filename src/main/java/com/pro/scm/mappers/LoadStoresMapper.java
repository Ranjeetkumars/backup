package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadStoresControllerDto;

import com.pro.scm.persistencedto.LoadStoresPersistenceDto;

import com.pro.scm.servicedto.LoadStoresServiceDto;

import com.pro.scm.utills.CommonConstants;

public class LoadStoresMapper {
	
	
	public LoadStoresServiceDto conversionControllerDtoToServiceDto(LoadStoresControllerDto loadStoresControllerDto) {
		LoadStoresServiceDto loadStoresServiceDto = new LoadStoresServiceDto();
		BeanUtils.copyProperties(loadStoresControllerDto, loadStoresServiceDto);
		return loadStoresServiceDto;
	}

	public List<LoadStoresControllerDto> conversionForServiceTOControllerDTO(List<LoadStoresServiceDto> objServicedto) {
		List<LoadStoresControllerDto> loadStoresControllerDto = new ArrayList<LoadStoresControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadStoresControllerDto objControllerDto1 = new LoadStoresControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			loadStoresControllerDto.add(objControllerDto1);
		});
		return loadStoresControllerDto;
	}

	
	public List<LoadStoresServiceDto> conversionpersistanceDTOtoServiceDTO(List<LoadStoresPersistenceDto> persistenceDTOs) {
		List<LoadStoresServiceDto> objServicedtos = new ArrayList<LoadStoresServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadStoresServiceDto loadStoresServiceDto = new LoadStoresServiceDto();
			BeanUtils.copyProperties(persistence, loadStoresServiceDto);
			objServicedtos.add(loadStoresServiceDto);
		});
		return objServicedtos;
	}

	 public List<LoadStoresPersistenceDto> settingDataIntoLoadStoresPersistenceDto(List<Object[]> list) {
		List<LoadStoresPersistenceDto> listOfData = new ArrayList<LoadStoresPersistenceDto>();
		for (Object[] objects : list) {
			LoadStoresPersistenceDto objPersistenceDTO = new LoadStoresPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setCountryId(objects[0].toString());
			} else {
				objPersistenceDTO.setCountryId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setCountryName(objects[1].toString());
			} else {
				objPersistenceDTO.setCountryName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
      

}

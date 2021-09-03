package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadSubStoreControllerDto;
import com.pro.scm.persistencedto.LoadSubStorePersistenceDto;
import com.pro.scm.servicedto.LoadSubStoreServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadSubStoreMapper {

	public LoadSubStoreServiceDto conversionControllerDtoToServiceDto(LoadSubStoreControllerDto scmLoginControllerDto) {
		LoadSubStoreServiceDto scmLoginServiceDto = new LoadSubStoreServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadSubStoreControllerDto> conversionForServiceTOControllerDTO(
			List<LoadSubStoreServiceDto> objServicedto) {
		List<LoadSubStoreControllerDto> objControllerDto = new ArrayList<LoadSubStoreControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadSubStoreControllerDto objControllerDto1 = new LoadSubStoreControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadSubStoreServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadSubStorePersistenceDto> persistenceDTOs) {
		List<LoadSubStoreServiceDto> objServicedtos = new ArrayList<LoadSubStoreServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadSubStoreServiceDto subStoreServiceDto = new LoadSubStoreServiceDto();
			BeanUtils.copyProperties(persistence, subStoreServiceDto);
			objServicedtos.add(subStoreServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadSubStorePersistenceDto> settingDataIntoLoadSubStorePersistenceDto(List<Object[]> list) {
		List<LoadSubStorePersistenceDto> listOfData = new ArrayList<LoadSubStorePersistenceDto>();
		for (Object[] objects : list) {
			LoadSubStorePersistenceDto objPersistenceDTO = new LoadSubStorePersistenceDto();
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

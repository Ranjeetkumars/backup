package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadBaselocationsControllerDto;
import com.pro.scm.persistencedto.LoadBaselocationsPersistenceDto;
import com.pro.scm.servicedto.LoadBaselocationsServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadBaselocationsMapper {

	public LoadBaselocationsServiceDto conversionControllerDtoToServiceDto(
			LoadBaselocationsControllerDto objControllerDto) {
		LoadBaselocationsServiceDto scmLoginServiceDto = new LoadBaselocationsServiceDto();
		BeanUtils.copyProperties(objControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadBaselocationsControllerDto> conversionForServiceTOControllerDTO(
			List<LoadBaselocationsServiceDto> objServicedto) {
		List<LoadBaselocationsControllerDto> objControllerDto = new ArrayList<LoadBaselocationsControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadBaselocationsControllerDto objControllerDto1 = new LoadBaselocationsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadBaselocationsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadBaselocationsPersistenceDto> persistenceDTOs) {
		List<LoadBaselocationsServiceDto> objServicedtos = new ArrayList<LoadBaselocationsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadBaselocationsServiceDto objSearchServiceDto = new LoadBaselocationsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	
	
	
	public List<LoadBaselocationsPersistenceDto> settingDataIntoLoadBaselocationsPersistenceDto(List<Object[]> list) {
		List<LoadBaselocationsPersistenceDto> listOfData = new ArrayList<LoadBaselocationsPersistenceDto>();
		for (Object[] objects : list) {
			LoadBaselocationsPersistenceDto objPersistenceDTO = new LoadBaselocationsPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setBaseLocationId(objects[0].toString());
			} else {
				objPersistenceDTO.setBaseLocationId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setBaseLocationName(objects[1].toString());
			} else {
				objPersistenceDTO.setBaseLocationName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

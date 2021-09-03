package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadAdjustmentTypeControllerDto;
import com.pro.scm.persistencedto.LoadAdjustmentTypePersistenceDto;
import com.pro.scm.servicedto.LoadAdjustmentTypeServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadAdjustmentTypeMapper {

	public LoadAdjustmentTypeServiceDto conversionControllerDtoToServiceDto(
			LoadAdjustmentTypeControllerDto scmLoginControllerDto) {
		LoadAdjustmentTypeServiceDto scmLoginServiceDto = new LoadAdjustmentTypeServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadAdjustmentTypeControllerDto> conversionForServiceTOControllerDTO(
			List<LoadAdjustmentTypeServiceDto> objServicedto) {
		List<LoadAdjustmentTypeControllerDto> objControllerDto = new ArrayList<LoadAdjustmentTypeControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadAdjustmentTypeControllerDto objControllerDto1 = new LoadAdjustmentTypeControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadAdjustmentTypeServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadAdjustmentTypePersistenceDto> persistenceDTOs) {
		List<LoadAdjustmentTypeServiceDto> objServicedtos = new ArrayList<LoadAdjustmentTypeServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadAdjustmentTypeServiceDto objSearchServiceDto = new LoadAdjustmentTypeServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadAdjustmentTypePersistenceDto> settingDataIntoLoadAdjustmentTypePersistenceDto(List<Object[]> list) {
		List<LoadAdjustmentTypePersistenceDto> listOfData = new ArrayList<LoadAdjustmentTypePersistenceDto>();
		for (Object[] objects : list) {
			LoadAdjustmentTypePersistenceDto objPersistenceDTO = new LoadAdjustmentTypePersistenceDto();

			if (objects[0] != null) {
				objPersistenceDTO.setAdjustmentId(objects[0].toString());
			} else {
				objPersistenceDTO.setAdjustmentId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setAdjustmentDesc(objects[1].toString());
			} else {
				objPersistenceDTO.setAdjustmentDesc(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setAdjustmentType(objects[2].toString());
			} else {
				objPersistenceDTO.setAdjustmentType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

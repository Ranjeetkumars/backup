package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadPackingTypeControllerDto;
import com.pro.scm.persistencedto.LoadPackingTypePersistenceDto;
import com.pro.scm.servicedto.LoadPackingTypeServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadPackingTypeMapper {

	public LoadPackingTypeServiceDto conversionControllerDtoToServiceDto(
			LoadPackingTypeControllerDto loadPackingTypeControllerDto) {
		LoadPackingTypeServiceDto loadPackingTypeServiceDto = new LoadPackingTypeServiceDto();
		BeanUtils.copyProperties(loadPackingTypeControllerDto, loadPackingTypeServiceDto);
		return loadPackingTypeServiceDto;
	}

	public List<LoadPackingTypeControllerDto> conversionForServiceTOControllerDTO(

			List<LoadPackingTypeServiceDto> loadPackingTypeServiceDto) {
		List<LoadPackingTypeControllerDto> objControllerDto = new ArrayList<LoadPackingTypeControllerDto>();
		loadPackingTypeServiceDto.forEach(serviceDto -> {
			LoadPackingTypeControllerDto objControllerDto1 = new LoadPackingTypeControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadPackingTypeServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadPackingTypePersistenceDto> loadPackingTypePersistenceDto) {
		List<LoadPackingTypeServiceDto> objServicedtos = new ArrayList<LoadPackingTypeServiceDto>();
		loadPackingTypePersistenceDto.forEach(persistence -> {
			LoadPackingTypeServiceDto objSearchServiceDto = new LoadPackingTypeServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadPackingTypePersistenceDto> settingDataIntoLoadPackingTypePersistenceDto(List<Object[]> list) {
		List<LoadPackingTypePersistenceDto> listOfData = new ArrayList<LoadPackingTypePersistenceDto>();
		for (Object[] objects : list) {
			LoadPackingTypePersistenceDto objPersistenceDTO = new LoadPackingTypePersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setPackingType(objects[1].toString());
			} else {
				objPersistenceDTO.setPackingType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setPtConversionFactory(objects[2].toString());
			} else {
				objPersistenceDTO.setPtConversionFactory(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadScheduleControllerDto;
import com.pro.scm.persistencedto.LoadSchedulePersistenceDto;
import com.pro.scm.servicedto.LoadScheduleServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadScheduleMapper {

	public LoadScheduleServiceDto conversionControllerDtoToServiceDto(
			LoadScheduleControllerDto loadScheduleControllerDto) {
		LoadScheduleServiceDto loadScheduleServiceDto = new LoadScheduleServiceDto();
		BeanUtils.copyProperties(loadScheduleControllerDto, loadScheduleServiceDto);
		return loadScheduleServiceDto;

	}

	public List<LoadScheduleControllerDto> conversionForServiceTOControllerDTO(
			List<LoadScheduleServiceDto> objServicedto) {
		List<LoadScheduleControllerDto> objControllerDto = new ArrayList<LoadScheduleControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadScheduleControllerDto objControllerDto1 = new LoadScheduleControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadScheduleServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadSchedulePersistenceDto> persistenceDTOs) {
		List<LoadScheduleServiceDto> objServicedtos = new ArrayList<LoadScheduleServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadScheduleServiceDto objSearchServiceDto = new LoadScheduleServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadSchedulePersistenceDto> settingDataIntoLoadSchedulePersistenceDto(List<Object[]> list) {
		List<LoadSchedulePersistenceDto> listOfData = new ArrayList<LoadSchedulePersistenceDto>();
		for (Object[] objects : list) {
			LoadSchedulePersistenceDto objPersistenceDTO = new LoadSchedulePersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDs_scheduleId(objects[0].toString());
			} else {
				objPersistenceDTO.setDs_scheduleId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDs_schduleType(objects[1].toString());
			} else {
				objPersistenceDTO.setDs_schduleType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<LoadSchedulePersistenceDto> settingDataIntoLoadSchedulePersistenceDto1(List<Object[]> list) {
		List<LoadSchedulePersistenceDto> listOfData = new ArrayList<LoadSchedulePersistenceDto>();
		for (Object[] objects : list) {
			LoadSchedulePersistenceDto objPersistenceDTO = new LoadSchedulePersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setMaterialId(objects[0].toString());
			} else {
				objPersistenceDTO.setMaterialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setMaterialGroupName(objects[1].toString());
			} else {
				objPersistenceDTO.setMaterialGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

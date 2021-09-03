package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadVehiclesControllerDto;
import com.pro.scm.persistencedto.LoadVehiclesPersistenceDto;
import com.pro.scm.servicedto.LoadVehiclesServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadVehiclesMapper {

	public LoadVehiclesServiceDto conversionControllerDtoToServiceDto(LoadVehiclesControllerDto vehiclesControllerDto) {
		LoadVehiclesServiceDto vehiclesServiceDto = new LoadVehiclesServiceDto();
		BeanUtils.copyProperties(vehiclesControllerDto, vehiclesServiceDto);
		return vehiclesServiceDto;
	}

	public List<LoadVehiclesControllerDto> conversionForServiceTOControllerDTO(
			List<LoadVehiclesServiceDto> objServicedto) {
		List<LoadVehiclesControllerDto> objControllerDto = new ArrayList<LoadVehiclesControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadVehiclesControllerDto objControllerDto1 = new LoadVehiclesControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadVehiclesServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadVehiclesPersistenceDto> persistenceDTOs) {
		List<LoadVehiclesServiceDto> objServicedtos = new ArrayList<LoadVehiclesServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadVehiclesServiceDto objSearchServiceDto = new LoadVehiclesServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadVehiclesPersistenceDto> settingDataIntoLoadVehiclesPersistenceDto(List<Object[]> list) {
		List<LoadVehiclesPersistenceDto> listOfData = new ArrayList<LoadVehiclesPersistenceDto>();
		for (Object[] objects : list) {
			LoadVehiclesPersistenceDto objPersistenceDTO = new LoadVehiclesPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setVehicleId(objects[0].toString());
			} else {
				objPersistenceDTO.setVehicleId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setPermanentRegNo(objects[1].toString());
			} else {
				objPersistenceDTO.setPermanentRegNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setVehicleTypeId(objects[2].toString());
				} else {
					objPersistenceDTO.setVehicleTypeId(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

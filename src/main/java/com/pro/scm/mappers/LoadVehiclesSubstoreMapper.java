package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadVehiclesSubstoreControllerDto;
import com.pro.scm.persistencedto.LoadVehiclesSubstorePersistenceDto;
import com.pro.scm.servicedto.LoadVehiclesSubstoreServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadVehiclesSubstoreMapper {

	public LoadVehiclesSubstoreServiceDto conversionControllerDtoToServiceDto(
			LoadVehiclesSubstoreControllerDto loadVehiclesSubstoreControllerDto) {
		LoadVehiclesSubstoreServiceDto loadVehiclesSubstoreServiceDto = new LoadVehiclesSubstoreServiceDto();
		BeanUtils.copyProperties(loadVehiclesSubstoreControllerDto, loadVehiclesSubstoreServiceDto);
		return loadVehiclesSubstoreServiceDto;
	}

	public List<LoadVehiclesSubstoreControllerDto> conversionForServiceTOControllerDTO(
			List<LoadVehiclesSubstoreServiceDto> objServicedto) {

		List<LoadVehiclesSubstoreControllerDto> objControllerDto = new ArrayList<LoadVehiclesSubstoreControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadVehiclesSubstoreControllerDto objControllerDto1 = new LoadVehiclesSubstoreControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadVehiclesSubstoreServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadVehiclesSubstorePersistenceDto> persistenceDTOs) {
		List<LoadVehiclesSubstoreServiceDto> objServicedtos = new ArrayList<LoadVehiclesSubstoreServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadVehiclesSubstoreServiceDto objSearchServiceDto = new LoadVehiclesSubstoreServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	
	
	public List<LoadVehiclesSubstorePersistenceDto> settingDataIntoLoadVehiclesSubstorePersistenceDto(List<Object[]> list) {
		List<LoadVehiclesSubstorePersistenceDto> listOfData = new ArrayList<LoadVehiclesSubstorePersistenceDto>();
		for (Object[] objects : list) {
			LoadVehiclesSubstorePersistenceDto objPersistenceDTO = new LoadVehiclesSubstorePersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setVehicleId(objects[0].toString());
			} else {
				objPersistenceDTO.setVehicleId(CommonConstants.DATA_NOT_AVIALABLE);
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

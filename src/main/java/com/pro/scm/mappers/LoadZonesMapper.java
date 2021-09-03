package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadZonesControllerDto;
import com.pro.scm.persistencedto.LoadZonesPersistenceDto;
import com.pro.scm.servicedto.LoadZonesServiceDto;
import com.pro.scm.utills.CommonConstants;


public class LoadZonesMapper {
	
	
	public LoadZonesServiceDto conversionControllerDtoToServiceDto(LoadZonesControllerDto scmLoginControllerDto) {
		LoadZonesServiceDto scmLoginServiceDto = new LoadZonesServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	
	
	public List<LoadZonesControllerDto> conversionForServiceTOControllerDTO(List<LoadZonesServiceDto> objServicedto) {
		List<LoadZonesControllerDto> objControllerDto = new ArrayList<LoadZonesControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadZonesControllerDto objControllerDto1 = new LoadZonesControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadZonesServiceDto> conversionpersistanceDTOtoServiceDTO(List<LoadZonesPersistenceDto> persistenceDTOs) {
		List<LoadZonesServiceDto> objServicedtos = new ArrayList<LoadZonesServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadZonesServiceDto objSearchServiceDto = new LoadZonesServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	
	
	 public List<LoadZonesPersistenceDto> settingDataIntoLoadZonesPersistenceDto(List<Object[]> list) {
			List<LoadZonesPersistenceDto> listOfData = new ArrayList<LoadZonesPersistenceDto>();
			for (Object[] objects : list) {
				LoadZonesPersistenceDto objPersistenceDTO = new LoadZonesPersistenceDto();
				if (objects[0] != null) {
					objPersistenceDTO.setLocationId(objects[0].toString());
				} else {
					objPersistenceDTO.setLocationId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setLocationName(objects[1].toString());
				} else {
					objPersistenceDTO.setLocationName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}

	

}

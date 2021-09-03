package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadGenericNamesControllerDto;
import com.pro.scm.persistencedto.LoadGenericNamesPersistenceDto;
import com.pro.scm.servicedto.LoadGenericNamesServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadGenericNamesMapper {
	
	public LoadGenericNamesServiceDto conversionControllerDtoToServiceDto(LoadGenericNamesControllerDto loadGenericNamesControllerDto) {
		LoadGenericNamesServiceDto loadGenericNamesServiceDto = new LoadGenericNamesServiceDto();
		BeanUtils.copyProperties(loadGenericNamesControllerDto, loadGenericNamesServiceDto);
		return loadGenericNamesServiceDto;
	}

	
	
	public List<LoadGenericNamesControllerDto> conversionForServiceTOControllerDTO(List<LoadGenericNamesServiceDto> scmLoginServiceDto) {
		List<LoadGenericNamesControllerDto> loadGenericNamesControllerDto = new ArrayList<LoadGenericNamesControllerDto>();
		scmLoginServiceDto.forEach(serviceDto -> {
			LoadGenericNamesControllerDto objControllerDto1 = new LoadGenericNamesControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			loadGenericNamesControllerDto.add(objControllerDto1);
		});
		return loadGenericNamesControllerDto;
	}

	
	
	public List<LoadGenericNamesServiceDto> conversionpersistanceDTOtoServiceDTO(List<LoadGenericNamesPersistenceDto> persistenceDTOs) {
		List<LoadGenericNamesServiceDto> loadGenericNamesServiceDto = new ArrayList<LoadGenericNamesServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadGenericNamesServiceDto objSearchServiceDto = new LoadGenericNamesServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			loadGenericNamesServiceDto.add(objSearchServiceDto);
		});
		return loadGenericNamesServiceDto;
	}
	
	
	
	 public List<LoadGenericNamesPersistenceDto> settingDataIntoLoadGenericNamesPersistenceDto(List<Object[]> list) {
			List<LoadGenericNamesPersistenceDto> listOfData = new ArrayList<LoadGenericNamesPersistenceDto>();
			for (Object[] objects : list) {
				LoadGenericNamesPersistenceDto objPersistenceDTO = new LoadGenericNamesPersistenceDto();
				if (objects[0] != null) {
					objPersistenceDTO.setGenericId(objects[0].toString());
				} else {
					objPersistenceDTO.setGenericId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setGenericName(objects[1].toString());
				} else {
					objPersistenceDTO.setGenericName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}

	
	
	

}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadDrugTypeControllerDto;
import com.pro.scm.persistencedto.LoadDrugTypePersistenceDto;
import com.pro.scm.servicedto.LoadDrugTypeServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadDrugTypeMapper {
	
	public List<LoadDrugTypeControllerDto> conversionForServiceTOControllerDTO(List<LoadDrugTypeServiceDto> objServicedto) {
		List<LoadDrugTypeControllerDto> objControllerDto = new ArrayList<LoadDrugTypeControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadDrugTypeControllerDto objControllerDto1 = new LoadDrugTypeControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadDrugTypeServiceDto> conversionpersistanceDTOtoServiceDTO(List<LoadDrugTypePersistenceDto> persistenceDTOs) {
		List<LoadDrugTypeServiceDto> objServicedtos = new ArrayList<LoadDrugTypeServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadDrugTypeServiceDto objSearchServiceDto = new LoadDrugTypeServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	 public List<LoadDrugTypePersistenceDto> settingDataIntoLoadDrugTypePersistenceDto(List<Object[]> list) {
		List<LoadDrugTypePersistenceDto> listOfData = new ArrayList<LoadDrugTypePersistenceDto>();
		for (Object[] objects : list) {
			LoadDrugTypePersistenceDto objPersistenceDTO = new LoadDrugTypePersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setTypeId(objects[0].toString());
			} else {
				objPersistenceDTO.setTypeId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setDrugType(objects[1].toString());
			} else {
				objPersistenceDTO.setDrugType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
      
     

}

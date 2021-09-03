package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadLocalIndentDetailsControllerDto;
import com.pro.scm.persistencedto.LoadLocalIndentDetailsPersistenceDto;
import com.pro.scm.servicedto.LoadLocalIndentServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadLocalIndentDetailsMapper {

	public LoadLocalIndentServiceDto conversionControllerDtoToServiceDto(
			LoadLocalIndentDetailsControllerDto scmLoginControllerDto) {
		LoadLocalIndentServiceDto scmLoginServiceDto = new LoadLocalIndentServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadLocalIndentDetailsControllerDto> conversionForServiceTOControllerDTO(
			List<LoadLocalIndentServiceDto> objServicedto) {
		List<LoadLocalIndentDetailsControllerDto> objControllerDto = new ArrayList<LoadLocalIndentDetailsControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadLocalIndentDetailsControllerDto objControllerDto1 = new LoadLocalIndentDetailsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadLocalIndentServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadLocalIndentDetailsPersistenceDto> persistenceDTOs) {
		List<LoadLocalIndentServiceDto> objServicedtos = new ArrayList<LoadLocalIndentServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadLocalIndentServiceDto objSearchServiceDto = new LoadLocalIndentServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadLocalIndentDetailsPersistenceDto> settingDataIntoLoadLocalIndentDetailsPersistenceDto(List<Object[]> list) {
		List<LoadLocalIndentDetailsPersistenceDto> listOfData = new ArrayList<LoadLocalIndentDetailsPersistenceDto>();
		for (Object[] objects : list) {
			LoadLocalIndentDetailsPersistenceDto objPersistenceDTO = new LoadLocalIndentDetailsPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugName(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setCountryName(objects[1].toString());
			} else {
				objPersistenceDTO.setCountryName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setIndentQty(objects[2].toString());
			} else {
				objPersistenceDTO.setIndentQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setStipQty(objects[3].toString());
			} else {
				objPersistenceDTO.setStipQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

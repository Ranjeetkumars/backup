package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.AllIndentDetailsControllerDto;
import com.pro.scm.persistencedto.AllIndentDetailsPersistenceDto;
import com.pro.scm.persistencedto.LoadSchedulePersistenceDto;
import com.pro.scm.servicedto.AllIndentDetailsServiceDto;

import com.pro.scm.utills.CommonConstants;

public class AllIndentDetailsMapper {
	
	
	
	public AllIndentDetailsServiceDto conversionControllerDtoToServiceDto(
			AllIndentDetailsControllerDto allIndentDetailsControllerDto) {
		AllIndentDetailsServiceDto allIndentDetailsServiceDto = new AllIndentDetailsServiceDto();
		BeanUtils.copyProperties(allIndentDetailsControllerDto, allIndentDetailsServiceDto);
		return allIndentDetailsServiceDto;

	}

	public List<AllIndentDetailsControllerDto> conversionForServiceTOControllerDTO(
			List<AllIndentDetailsServiceDto> objServicedto) {
		List<AllIndentDetailsControllerDto> objControllerDto = new ArrayList<AllIndentDetailsControllerDto>();
		objServicedto.forEach(serviceDto -> {
			AllIndentDetailsControllerDto objControllerDto1 = new AllIndentDetailsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<AllIndentDetailsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<AllIndentDetailsPersistenceDto> persistenceDTOs) {
		List<AllIndentDetailsServiceDto> objServicedtos = new ArrayList<AllIndentDetailsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			AllIndentDetailsServiceDto objSearchServiceDto = new AllIndentDetailsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	

	public List<AllIndentDetailsPersistenceDto> settingDataIntoAllIndentDetailsPersistenceDto(List<Object[]> list) {
		List<AllIndentDetailsPersistenceDto> listOfData = new ArrayList<AllIndentDetailsPersistenceDto>();
		for (Object[] objects : list) {
			AllIndentDetailsPersistenceDto objPersistenceDTO = new AllIndentDetailsPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setIndetId(objects[0].toString());
			} else {
				objPersistenceDTO.setIndetId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setIndentCode(objects[1].toString());
			} else {
				objPersistenceDTO.setIndentCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setIndentraiseddate(objects[2].toString());
			} else {
				objPersistenceDTO.setIndentraiseddate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setIsActive(objects[3].toString());
			} else {
				objPersistenceDTO.setIsActive(CommonConstants.DATA_NOT_AVIALABLE);
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

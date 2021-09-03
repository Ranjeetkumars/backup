package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.ListLoadActiveInactiveCOntrollerDto;
import com.pro.scm.persistencedto.ListLoadActiveInactivePersistenceDto;
import com.pro.scm.servicedto.ListLoadActiveInactiveServiceDto;
import com.pro.scm.utills.CommonConstants;

public class ListLoadActiveInactiveMapper {

	public ListLoadActiveInactiveServiceDto conversionControllerDtoToServiceDto(
			ListLoadActiveInactiveCOntrollerDto scmLoginControllerDto) {
		ListLoadActiveInactiveServiceDto scmLoginServiceDto = new ListLoadActiveInactiveServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<ListLoadActiveInactiveCOntrollerDto> conversionForServiceTOControllerDTO(
			List<ListLoadActiveInactiveServiceDto> objServicedto) {
		List<ListLoadActiveInactiveCOntrollerDto> objControllerDto = new ArrayList<ListLoadActiveInactiveCOntrollerDto>();
		objServicedto.forEach(serviceDto -> {
			ListLoadActiveInactiveCOntrollerDto objControllerDto1 = new ListLoadActiveInactiveCOntrollerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<ListLoadActiveInactiveServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<ListLoadActiveInactivePersistenceDto> persistenceDTOs) {
		List<ListLoadActiveInactiveServiceDto> objServicedtos = new ArrayList<ListLoadActiveInactiveServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			ListLoadActiveInactiveServiceDto objSearchServiceDto = new ListLoadActiveInactiveServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<ListLoadActiveInactivePersistenceDto> settingDataIntoListLoadActiveInactivePersistenceDto(List<Object[]> list) {
		List<ListLoadActiveInactivePersistenceDto> listOfData = new ArrayList<ListLoadActiveInactivePersistenceDto>();
		for (Object[] objects : list) {
			ListLoadActiveInactivePersistenceDto objPersistenceDTO = new ListLoadActiveInactivePersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGenricDrugName(objects[1].toString());
			} else {
				objPersistenceDTO.setGenricDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrugName(objects[2].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setDrugBrandLang1(objects[3].toString());
			} else {
				objPersistenceDTO.setDrugBrandLang1(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[4] != null) {
				objPersistenceDTO.setCompanyName(objects[4].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setFormType(objects[5].toString());
			} else {
				objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setCreatedDate(objects[6].toString());
			} else {
				objPersistenceDTO.setCreatedDate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

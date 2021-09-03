package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.ListLoadActiveDrugsControllerDto;
import com.pro.scm.persistencedto.ListLoadActiveDrugsPersistenceDto;
import com.pro.scm.servicedto.ListLoadActiveDrugsServiceDto;
import com.pro.scm.utills.CommonConstants;

public class ListLoadActiveDrugsMapper {

	public ListLoadActiveDrugsServiceDto conversionControllerDtoToServiceDto(
			ListLoadActiveDrugsControllerDto scmLoginControllerDto) {
		ListLoadActiveDrugsServiceDto scmLoginServiceDto = new ListLoadActiveDrugsServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<ListLoadActiveDrugsControllerDto> conversionForServiceTOControllerDTO(
			List<ListLoadActiveDrugsServiceDto> objServicedto) {
		List<ListLoadActiveDrugsControllerDto> objControllerDto = new ArrayList<ListLoadActiveDrugsControllerDto>();
		objServicedto.forEach(serviceDto -> {
			ListLoadActiveDrugsControllerDto objControllerDto1 = new ListLoadActiveDrugsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<ListLoadActiveDrugsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<ListLoadActiveDrugsPersistenceDto> persistenceDTOs) {
		List<ListLoadActiveDrugsServiceDto> objServicedtos = new ArrayList<ListLoadActiveDrugsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			ListLoadActiveDrugsServiceDto objSearchServiceDto = new ListLoadActiveDrugsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	

	public List<ListLoadActiveDrugsPersistenceDto> settingDataIntoListLoadActiveDrugsPersistenceDto(
			List<Object[]> list) {
		List<ListLoadActiveDrugsPersistenceDto> listOfData = new ArrayList<ListLoadActiveDrugsPersistenceDto>();
		for (Object[] objects : list) {
			ListLoadActiveDrugsPersistenceDto objPersistenceDTO = new ListLoadActiveDrugsPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrugName(objects[1].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setDrugBrand(objects[2].toString());
			} else {
				objPersistenceDTO.setDrugBrand(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[3] != null) {
				objPersistenceDTO.setDrugunicode(objects[3].toString());
			} else {
				objPersistenceDTO.setDrugunicode(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[4] != null) {
				objPersistenceDTO.setFormType(objects[4].toString());
			} else {
				objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setDrugStrength(objects[5].toString());
			} else {
				objPersistenceDTO.setDrugStrength(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[6] != null) {
				objPersistenceDTO.setManufacture(objects[6].toString());
			} else {
				objPersistenceDTO.setManufacture(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

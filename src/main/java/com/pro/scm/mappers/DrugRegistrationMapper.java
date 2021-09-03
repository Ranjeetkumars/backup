package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.DrugRegistrationControllerDto;
import com.pro.scm.persistencedto.DrugRegisteringPersistenceDto;
import com.pro.scm.servicedto.DrugRegistrationServiceDto;
import com.pro.scm.utills.CommonConstants;

public class DrugRegistrationMapper {
	
	
	public  DrugRegistrationServiceDto converControllerToServiceDTO(DrugRegistrationControllerDto controllerDto) {
		
		DrugRegistrationServiceDto serviceDto = new DrugRegistrationServiceDto();
		BeanUtils.copyProperties(controllerDto, serviceDto);
		return serviceDto;
		
	}
	
	
	public List<DrugRegistrationControllerDto> conversionForServiceTOControllerDTO(
			List<DrugRegistrationServiceDto> objServicedto) {
		List<DrugRegistrationControllerDto> objControllerDto = new ArrayList<DrugRegistrationControllerDto>();
		objServicedto.forEach(serviceDto -> {
			DrugRegistrationControllerDto objControllerDto1 = new DrugRegistrationControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}
	
	
	
	
	
	public List<DrugRegistrationServiceDto> conversionpersistanceDTOtoServiceDTO(List<DrugRegisteringPersistenceDto> persistenceDTOs) {
		List<DrugRegistrationServiceDto> objServicedtos = new ArrayList<DrugRegistrationServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			DrugRegistrationServiceDto objSearchServiceDto = new DrugRegistrationServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	public List<DrugRegisteringPersistenceDto> convertObjetsArraytoPersistenceDto(List<Object[]> list) {
		List<DrugRegisteringPersistenceDto> listOfData = new ArrayList<DrugRegisteringPersistenceDto>();
		for (Object[] objects : list) {
			DrugRegisteringPersistenceDto objPersistenceDTO = new DrugRegisteringPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrugName(objects[1].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setDrugBrandLang1(objects[2].toString());
			} else {
				objPersistenceDTO.setDrugBrandLang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setShortUnicCode(objects[3].toString());
			} else {
				objPersistenceDTO.setShortUnicCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setFromType(objects[4].toString());
			} else {
				objPersistenceDTO.setFromType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setStrength(objects[5].toString());
			} else {
				objPersistenceDTO.setStrength(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[6] != null) {
				objPersistenceDTO.setCompanyName(objects[6].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[7] != null) {
				objPersistenceDTO.setGroupMoleculesTypeLang1(objects[7].toString());
			} else {
				objPersistenceDTO.setGroupMoleculesTypeLang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}

		return listOfData;
	}


}

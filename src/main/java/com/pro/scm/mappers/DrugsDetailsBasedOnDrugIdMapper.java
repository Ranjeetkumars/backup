package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.DrugsDetailsBasedOnDrugIdControllerDto;
import com.pro.scm.persistencedto.DrugsDetailsBasedOnDrugIdPerssisteenceDto;
import com.pro.scm.servicedto.DrugsDetailsBasedOnDrugIdServiceDto;
import com.pro.scm.utills.CommonConstants;

public class DrugsDetailsBasedOnDrugIdMapper {
	
	
	
	
	
	public DrugsDetailsBasedOnDrugIdServiceDto conversionControllerToServiceDto(DrugsDetailsBasedOnDrugIdControllerDto controllerDto) {
		DrugsDetailsBasedOnDrugIdServiceDto serviceDto = new DrugsDetailsBasedOnDrugIdServiceDto();
		BeanUtils.copyProperties(controllerDto, serviceDto);
		return serviceDto;
	}

	public List<DrugsDetailsBasedOnDrugIdControllerDto> conversionForServiceTOControllerDTO(
			List<DrugsDetailsBasedOnDrugIdServiceDto> objServicedto) {
		List<DrugsDetailsBasedOnDrugIdControllerDto> objControllerDto = new ArrayList<DrugsDetailsBasedOnDrugIdControllerDto>();
		objServicedto.forEach(serviceDto -> {
			DrugsDetailsBasedOnDrugIdControllerDto objControllerDto1 = new DrugsDetailsBasedOnDrugIdControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}
	
	
	
	
	
	public List<DrugsDetailsBasedOnDrugIdServiceDto> conversionpersistanceDTOtoServiceDTO(List<DrugsDetailsBasedOnDrugIdPerssisteenceDto> persistenceDTOs) {
		List<DrugsDetailsBasedOnDrugIdServiceDto> objServicedtos = new ArrayList<DrugsDetailsBasedOnDrugIdServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			DrugsDetailsBasedOnDrugIdServiceDto objSearchServiceDto = new DrugsDetailsBasedOnDrugIdServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	public List<DrugsDetailsBasedOnDrugIdPerssisteenceDto> convertObjetsArraytoPersistenceDtoForrDrugsDetails(List<Object[]> list) {
		List<DrugsDetailsBasedOnDrugIdPerssisteenceDto> listOfData = new ArrayList<DrugsDetailsBasedOnDrugIdPerssisteenceDto>();
		for (Object[] objects : list) {
			DrugsDetailsBasedOnDrugIdPerssisteenceDto objPersistenceDTO = new DrugsDetailsBasedOnDrugIdPerssisteenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setStrdrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setStrdrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setStrgenricname(objects[1].toString());
			} else {
				objPersistenceDTO.setStrgenricname(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setStrdrugBrandName(objects[2].toString());
			} else {
				objPersistenceDTO.setStrdrugBrandName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setStrsheduleType(objects[3].toString());
			} else {
				objPersistenceDTO.setStrsheduleType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setStrcompanyName(objects[4].toString());
			} else {
				objPersistenceDTO.setStrcompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setStrsystypelanguageOne(objects[5].toString());
			} else {
				objPersistenceDTO.setStrsystypelanguageOne(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[6] != null) {
				objPersistenceDTO.setStrgroupFUnctionLangone(objects[6].toString());
			} else {
				objPersistenceDTO.setStrgroupFUnctionLangone(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[7] != null) {
				objPersistenceDTO.setStrgrpmoduleTypelangone(objects[7].toString());
			} else {
				objPersistenceDTO.setStrgrpmoduleTypelangone(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[8] != null) {
				objPersistenceDTO.setStrformType(objects[8].toString());
			} else {
				objPersistenceDTO.setStrformType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[9] != null) {
				objPersistenceDTO.setStrstregnth(objects[9].toString());
			} else {
				objPersistenceDTO.setStrstregnth(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[10] != null) {
				objPersistenceDTO.setStrpackingType(objects[10].toString());
			} else {
				objPersistenceDTO.setStrpackingType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[11] != null) {
				objPersistenceDTO.setStrshortUnicode(objects[11].toString());
			} else {
				objPersistenceDTO.setStrshortUnicode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[12] != null) {
				objPersistenceDTO.setStrminimumlevelQty(objects[12].toString());
			} else {
				objPersistenceDTO.setStrminimumlevelQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[13] != null) {
				objPersistenceDTO.setStrmaxLevelQty(objects[13].toString());
			} else {
				objPersistenceDTO.setStrmaxLevelQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[14] != null) {
				objPersistenceDTO.setStrexpiryalert(objects[14].toString());
			} else {
				objPersistenceDTO.setStrexpiryalert(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[15] != null) {
				objPersistenceDTO.setStruserName(objects[15].toString());
			} else {
				objPersistenceDTO.setStruserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[16] != null) {
				objPersistenceDTO.setStrrolename(objects[16].toString());
			} else {
				objPersistenceDTO.setStrrolename(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[17] != null) {
				objPersistenceDTO.setStrcreatedDate(objects[17].toString());
				
			} else {
				objPersistenceDTO.setStrcreatedDate(CommonConstants.DATA_NOT_AVIALABLE);
				
			}
			listOfData.add(objPersistenceDTO);
		}

		return listOfData;
	}



}

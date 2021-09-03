package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.GetDrugDetailsForApprovalControllerDto;
import com.pro.scm.persistencedto.GetDrugDetailsForApprovalPersistenceDto;
import com.pro.scm.servicedto.GetDrugDetailsForApprovalServiceDto;
import com.pro.scm.utills.CommonConstants;

public class GetDrugDetailsForApprovalMapper {

	public GetDrugDetailsForApprovalServiceDto conversionControllerDtoToServiceDto(
			GetDrugDetailsForApprovalControllerDto scmLoginControllerDto) {
		GetDrugDetailsForApprovalServiceDto scmLoginServiceDto = new GetDrugDetailsForApprovalServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<GetDrugDetailsForApprovalControllerDto> conversionForServiceTOControllerDTO(
			List<GetDrugDetailsForApprovalServiceDto> objServicedto) {
		List<GetDrugDetailsForApprovalControllerDto> objControllerDto = new ArrayList<GetDrugDetailsForApprovalControllerDto>();
		objServicedto.forEach(serviceDto -> {
			GetDrugDetailsForApprovalControllerDto objControllerDto1 = new GetDrugDetailsForApprovalControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<GetDrugDetailsForApprovalServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<GetDrugDetailsForApprovalPersistenceDto> persistenceDTOs) {
		List<GetDrugDetailsForApprovalServiceDto> objServicedtos = new ArrayList<GetDrugDetailsForApprovalServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			GetDrugDetailsForApprovalServiceDto objSearchServiceDto = new GetDrugDetailsForApprovalServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	


	




	

	public List<GetDrugDetailsForApprovalPersistenceDto> settingDataIntoGetDrugDetailsForApprovalPersistenceDto(List<Object[]> list) {
		List<GetDrugDetailsForApprovalPersistenceDto> listOfData = new ArrayList<GetDrugDetailsForApprovalPersistenceDto>();
		for (Object[] objects : list) {
			GetDrugDetailsForApprovalPersistenceDto objPersistenceDTO = new GetDrugDetailsForApprovalPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGenricName(objects[1].toString());
			} else {
				objPersistenceDTO.setGenricName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setDrugBrandName(objects[2].toString());
			} else {
				objPersistenceDTO.setDrugBrandName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setSheduleType(objects[3].toString());
			} else {
				objPersistenceDTO.setSheduleType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setCompanyName(objects[4].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[5] != null) {
				objPersistenceDTO.setSystypelanguageone(objects[5].toString());
			} else {
				objPersistenceDTO.setSystypelanguageone(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setGroupFunctionLanGone(objects[6].toString());
			} else {
				objPersistenceDTO.setGroupFunctionLanGone(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[7] != null) {
				objPersistenceDTO.setGrpModuleTypeLanGone(objects[7].toString());
			} else {
				objPersistenceDTO.setGrpModuleTypeLanGone(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[8] != null) {
				objPersistenceDTO.setFormtype(objects[8].toString());
			} else {
				objPersistenceDTO.setFormtype(CommonConstants.DATA_NOT_AVIALABLE);
			}
           if (objects[9] != null) {
				objPersistenceDTO.setStrength(objects[9].toString());
			} else {
				objPersistenceDTO.setStrength(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setPackingType(objects[10].toString());
			} else {
				objPersistenceDTO.setPackingType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[11] != null) {
				objPersistenceDTO.setShortUniCode(objects[11].toString());
			} else {
				objPersistenceDTO.setShortUniCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[12] != null) {
				objPersistenceDTO.setMinimumLevelQty(objects[12].toString());
			} else {
				objPersistenceDTO.setMinimumLevelQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[13] != null) {
				objPersistenceDTO.setMaxLevelQty(objects[13].toString());
			} else {
				objPersistenceDTO.setMaxLevelQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[14] != null) {
				objPersistenceDTO.setExpiryAlert(objects[14].toString());
			} else {
				objPersistenceDTO.setExpiryAlert(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[15] != null) {
				objPersistenceDTO.setUserName(objects[15].toString());
			} else {
				objPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[16] != null) {
				objPersistenceDTO.setRoleName(objects[16].toString());
			} else {
				objPersistenceDTO.setRoleName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[17] != null) {
				objPersistenceDTO.setCreatedDate(objects[17].toString());
			} else {
				objPersistenceDTO.setCreatedDate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

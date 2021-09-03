package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.AllApprovalItemListControllerDto;
import com.pro.scm.persistencedto.AllApprovalItemListPersistenceDto;
import com.pro.scm.servicedto.AllApprovalItemListServiceDto;
import com.pro.scm.utills.CommonConstants;

public class AllApprovalItemListMapper {

	public AllApprovalItemListServiceDto conversionControllerDtoToServiceDto(
			AllApprovalItemListControllerDto allApprovalItemListControllerDto) {
		AllApprovalItemListServiceDto serviceDto = new AllApprovalItemListServiceDto();
		BeanUtils.copyProperties(allApprovalItemListControllerDto, serviceDto);
		return serviceDto;
	}

	public List<AllApprovalItemListControllerDto> conversionForServiceTOControllerDTO(
			List<AllApprovalItemListServiceDto> objServicedto) {
		List<AllApprovalItemListControllerDto> objControllerDto = new ArrayList<AllApprovalItemListControllerDto>();
		objServicedto.forEach(serviceDto -> {
			AllApprovalItemListControllerDto objControllerDto1 = new AllApprovalItemListControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<AllApprovalItemListServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<AllApprovalItemListPersistenceDto> persistenceDTOs) {
		List<AllApprovalItemListServiceDto> allApprovalItemListServiceDto = new ArrayList<AllApprovalItemListServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			AllApprovalItemListServiceDto objSearchServiceDto = new AllApprovalItemListServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			allApprovalItemListServiceDto.add(objSearchServiceDto);
		});
		return allApprovalItemListServiceDto;
	}

	public List<AllApprovalItemListPersistenceDto> settingDataIntoAllApprovalItemListPersistenceDto(
			List<Object[]> list) {
		List<AllApprovalItemListPersistenceDto> listOfData = new ArrayList<AllApprovalItemListPersistenceDto>();
		for (Object[] objects : list) {
			AllApprovalItemListPersistenceDto objPersistenceDTO = new AllApprovalItemListPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setCitIndentId(objects[0].toString());
			} else {
				objPersistenceDTO.setCitIndentId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrDrudName(objects[1].toString());
			} else {
				objPersistenceDTO.setDrDrudName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDbDrugBrandLang1(objects[2].toString());
			} else {
				objPersistenceDTO.setDbDrugBrandLang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setDfFormType(objects[3].toString());
			} else {
				objPersistenceDTO.setDfFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setDrStrengthType(objects[4].toString());
			} else {
				objPersistenceDTO.setDrStrengthType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setMaCompanyName(objects[5].toString());
			} else {
				objPersistenceDTO.setMaCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setCitIndentQty(objects[6].toString());
			} else {
				objPersistenceDTO.setCitIndentQty(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[7] != null) {
				objPersistenceDTO.setCitApprovedQty(objects[7].toString());
			} else {
				objPersistenceDTO.setCitApprovedQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setCitItemId(objects[8].toString());
			} else {
				objPersistenceDTO.setCitItemId(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

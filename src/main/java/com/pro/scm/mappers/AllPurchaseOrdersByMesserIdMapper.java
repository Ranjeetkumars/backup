package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.AllPurchaseOrdersByMesserIdControllerDto;

import com.pro.scm.persistencedto.AllPurchaseOrdersByMesserIdPersistenceDto;
import com.pro.scm.persistencedto.AllPurchaseOrdersByMesserIdServiceDto;
import com.pro.scm.utills.CommonConstants;

public class AllPurchaseOrdersByMesserIdMapper {

	public AllPurchaseOrdersByMesserIdServiceDto conversionControllerDtoToServiceDto(
			AllPurchaseOrdersByMesserIdControllerDto scmLoginControllerDto) {
		AllPurchaseOrdersByMesserIdServiceDto scmLoginServiceDto = new AllPurchaseOrdersByMesserIdServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<AllPurchaseOrdersByMesserIdControllerDto> conversionForServiceTOControllerDTO(
			List<AllPurchaseOrdersByMesserIdServiceDto> objServicedto) {
		List<AllPurchaseOrdersByMesserIdControllerDto> objControllerDto = new ArrayList<AllPurchaseOrdersByMesserIdControllerDto>();
		objServicedto.forEach(serviceDto -> {
			AllPurchaseOrdersByMesserIdControllerDto objControllerDto1 = new AllPurchaseOrdersByMesserIdControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<AllPurchaseOrdersByMesserIdServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<AllPurchaseOrdersByMesserIdPersistenceDto> persistenceDTOs) {
		List<AllPurchaseOrdersByMesserIdServiceDto> objServicedtos = new ArrayList<AllPurchaseOrdersByMesserIdServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			AllPurchaseOrdersByMesserIdServiceDto objSearchServiceDto = new AllPurchaseOrdersByMesserIdServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<AllPurchaseOrdersByMesserIdPersistenceDto> settingDataIntoAllPurchaseOrdersByMesserIdPersistenceDto(
			List<Object[]> list) {
		List<AllPurchaseOrdersByMesserIdPersistenceDto> listOfData = new ArrayList<AllPurchaseOrdersByMesserIdPersistenceDto>();
		for (Object[] objects : list) {
			AllPurchaseOrdersByMesserIdPersistenceDto objPersistenceDTO = new AllPurchaseOrdersByMesserIdPersistenceDto();
			
			if (objects[0] != null) {
				objPersistenceDTO.setDrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDruggenricName(objects[1].toString());
			} else {
				objPersistenceDTO.setDruggenricName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setBrandName(objects[2].toString());
			} else {
				objPersistenceDTO.setBrandName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setFormType(objects[3].toString());
			} else {
				objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[4] != null) {
				objPersistenceDTO.setStrength(objects[4].toString());
			} else {
				objPersistenceDTO.setStrength(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setCompanyName(objects[5].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[6] != null) {
				objPersistenceDTO.setApprovlId(objects[6].toString());
			} else {
				objPersistenceDTO.setApprovlId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setSerialId(objects[7].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setCdsiid(objects[8].toString());
			} else {
				objPersistenceDTO.setCdsiid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setIndentId(objects[9].toString());
			} else {
				objPersistenceDTO.setIndentId(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadPaymentDetailsControllerDto;
import com.pro.scm.persistencedto.LoadPaymentDetailsPersistenceDto;
import com.pro.scm.servicedto.LoadPaymentDetailsServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadPaymentDetailsMapper {

	public LoadPaymentDetailsServiceDto conversionControllerDtoToServiceDto(
			LoadPaymentDetailsControllerDto loadPaymentDetailsControllerDto) {
		LoadPaymentDetailsServiceDto loadPaymentDetailsServiceDto = new LoadPaymentDetailsServiceDto();
		BeanUtils.copyProperties(loadPaymentDetailsControllerDto, loadPaymentDetailsServiceDto);
		return loadPaymentDetailsServiceDto;
	}

	public List<LoadPaymentDetailsControllerDto> conversionForServiceTOControllerDTO(
			List<LoadPaymentDetailsServiceDto> objServicedto) {
		List<LoadPaymentDetailsControllerDto> loadPaymentDetailsControllerDto = new ArrayList<LoadPaymentDetailsControllerDto>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			LoadPaymentDetailsControllerDto objShelveRackControllerDTO1 = new LoadPaymentDetailsControllerDto();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objShelveRackControllerDTO1);
			loadPaymentDetailsControllerDto.add(objShelveRackControllerDTO1);
		});
		return loadPaymentDetailsControllerDto;
	}

	public List<LoadPaymentDetailsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadPaymentDetailsPersistenceDto> persistenceDTOs) {
		List<LoadPaymentDetailsServiceDto> objServicedtos = new ArrayList<LoadPaymentDetailsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadPaymentDetailsServiceDto objSearchServiceDto = new LoadPaymentDetailsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	
	
	
    
    
  
	public List<LoadPaymentDetailsPersistenceDto> settingDataIntoLoadPaymentDetailsPersistenceDtoForloadCompany(List<Object[]> list) {
		List<LoadPaymentDetailsPersistenceDto> listOfData = new ArrayList<LoadPaymentDetailsPersistenceDto>();
		for (Object[] objects : list) {
			LoadPaymentDetailsPersistenceDto objPersistenceDTO = new LoadPaymentDetailsPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setTcSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setTcSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setTcCompanyName(objects[1].toString());
			} else {
				objPersistenceDTO.setTcCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	public List<LoadPaymentDetailsPersistenceDto> settingDataIntoLoadPaymentDetailsPersistenceDto(List<Object[]> list) {
		List<LoadPaymentDetailsPersistenceDto> listOfData = new ArrayList<LoadPaymentDetailsPersistenceDto>();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@="+list.size());
		for (Object[] objects : list) {
			LoadPaymentDetailsPersistenceDto objPersistenceDTO = new LoadPaymentDetailsPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setPbpCrcardNo(objects[0].toString());
			} else {
				objPersistenceDTO.setPbpCrcardNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setPbpCrexpMonth(objects[1].toString());
			} else {
				objPersistenceDTO.setPbpCrexpMonth(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setPbpCrexpyear(objects[2].toString());
			} else {
				objPersistenceDTO.setPbpCrexpyear(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setPbpBankName(objects[3].toString());
			} else {
				objPersistenceDTO.setPbpBankName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setPbpCrholdName(objects[4].toString());
			} else {
				objPersistenceDTO.setPbpCrholdName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}


}

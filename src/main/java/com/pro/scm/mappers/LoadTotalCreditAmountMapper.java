package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadTotalCreditAmountControllerDto;
import com.pro.scm.persistencedto.LoadTotalCreditPersistenceDto;
import com.pro.scm.servicedto.LoadTotalCreditAmountServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadTotalCreditAmountMapper {

	public LoadTotalCreditAmountServiceDto conversionControllerDtoToServiceDto(
			LoadTotalCreditAmountControllerDto loadTotalCreditAmountControllerDto) {
		LoadTotalCreditAmountServiceDto loadTotalCreditAmountServiceDto = new LoadTotalCreditAmountServiceDto();
		BeanUtils.copyProperties(loadTotalCreditAmountControllerDto, loadTotalCreditAmountServiceDto);

		return loadTotalCreditAmountServiceDto;
	}

	public List<LoadTotalCreditAmountControllerDto> conversionForServiceTOControllerDTO(
			List<LoadTotalCreditAmountServiceDto> objServicedto) {
		List<LoadTotalCreditAmountControllerDto> objBrandDetailsControllerDTO = new ArrayList<LoadTotalCreditAmountControllerDto>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			LoadTotalCreditAmountControllerDto objShelveRackControllerDTO1 = new LoadTotalCreditAmountControllerDto();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objShelveRackControllerDTO1);
			objBrandDetailsControllerDTO.add(objShelveRackControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<LoadTotalCreditAmountServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadTotalCreditPersistenceDto> persistenceDTOs) {
		List<LoadTotalCreditAmountServiceDto> objServicedtos = new ArrayList<LoadTotalCreditAmountServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadTotalCreditAmountServiceDto objSearchServiceDto = new LoadTotalCreditAmountServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadTotalCreditPersistenceDto> settingDataIntoLoadTotalCreditPersistenceDto(List<Object[]> list) {
		List<LoadTotalCreditPersistenceDto> listOfData = new ArrayList<LoadTotalCreditPersistenceDto>();
		for (Object[] objects : list) {
			LoadTotalCreditPersistenceDto objPersistenceDTO = new LoadTotalCreditPersistenceDto();

			if (objects[0] != null) {
				objPersistenceDTO.setTotalAmount(objects[0].toString());
			} else {
				objPersistenceDTO.setTotalAmount(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setCreditamount(objects[1].toString());
			} else {
				objPersistenceDTO.setCreditamount(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	public List<LoadTotalCreditPersistenceDto> settingDataIntoLoadTotalCreditPersistenceDtoForloadWardWiseCredit(
			List<Object[]> list) {
		List<LoadTotalCreditPersistenceDto> listOfData = new ArrayList<LoadTotalCreditPersistenceDto>();
		for (Object[] objects : list) {
			LoadTotalCreditPersistenceDto objPersistenceDTO = new LoadTotalCreditPersistenceDto();

			if (objects[0] != null) {
				objPersistenceDTO.setPbdBillNo(objects[0].toString());
			} else {
				objPersistenceDTO.setPbdBillNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setErEmployeeFirstName(objects[1].toString());
			} else {
				objPersistenceDTO.setErEmployeeFirstName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setPbdAmountTopay(objects[2].toString());
			} else {
				objPersistenceDTO.setPbdAmountTopay(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setPbdCreditAmount(objects[3].toString());
			} else {
				objPersistenceDTO.setPbdCreditAmount(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

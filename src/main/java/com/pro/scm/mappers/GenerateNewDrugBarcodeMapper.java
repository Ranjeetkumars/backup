package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.GenerateNewDrugBarcodeControllerDto;
import com.pro.scm.persistencedto.GenerateNewDrugBarcodePersistenceDto;
import com.pro.scm.servicedto.GenerateNewDrugBarcodeServiceDto;
import com.pro.scm.utills.CommonConstants;

public class GenerateNewDrugBarcodeMapper {
	
	
	public GenerateNewDrugBarcodeServiceDto conversionControllerDtoToServiceDto(
			GenerateNewDrugBarcodeControllerDto generateNewDrugBarcodeControllerDto) {
		GenerateNewDrugBarcodeServiceDto generateNewDrugBarcodeServiceDto = new GenerateNewDrugBarcodeServiceDto();
		BeanUtils.copyProperties(generateNewDrugBarcodeControllerDto, generateNewDrugBarcodeServiceDto);
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhh="+generateNewDrugBarcodeServiceDto);
		return generateNewDrugBarcodeServiceDto;
	}

	public List<GenerateNewDrugBarcodeControllerDto> conversionForServiceTOControllerDTO(
			List<GenerateNewDrugBarcodeServiceDto> objServicedto) {
		List<GenerateNewDrugBarcodeControllerDto> objControllerDto = new ArrayList<GenerateNewDrugBarcodeControllerDto>();
		objServicedto.forEach(serviceDto -> {
			GenerateNewDrugBarcodeControllerDto objControllerDto1 = new GenerateNewDrugBarcodeControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<GenerateNewDrugBarcodeServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<GenerateNewDrugBarcodePersistenceDto> persistenceDTOs) {
		List<GenerateNewDrugBarcodeServiceDto> objServicedtos = new ArrayList<GenerateNewDrugBarcodeServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			GenerateNewDrugBarcodeServiceDto objSearchServiceDto = new GenerateNewDrugBarcodeServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<GenerateNewDrugBarcodePersistenceDto> settingDataIntoGenerateNewDrugBarcodePersistenceDto(List<Object[]> list) {
		List<GenerateNewDrugBarcodePersistenceDto> listOfData = new ArrayList<GenerateNewDrugBarcodePersistenceDto>();
		for (Object objects : list) {
			GenerateNewDrugBarcodePersistenceDto objPersistenceDTO = new GenerateNewDrugBarcodePersistenceDto();
			if (objects != null) {
				objPersistenceDTO.setBarCode(objects.toString());
			} else {
				objPersistenceDTO.setBarCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
		
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}


}

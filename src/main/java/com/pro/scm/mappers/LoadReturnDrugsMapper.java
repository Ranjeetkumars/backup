package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadReturnDrugsControllerDto;
import com.pro.scm.persistencedto.LoadReturnDrugsPersistenceDto;
import com.pro.scm.servicedto.LoadReturnDrugsServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadReturnDrugsMapper {
	
	
	
	public LoadReturnDrugsServiceDto conversionControllerDtoToServiceDto(
			LoadReturnDrugsControllerDto scmLoginControllerDto) {
		LoadReturnDrugsServiceDto scmLoginServiceDto = new LoadReturnDrugsServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadReturnDrugsControllerDto> conversionForServiceTOControllerDTO(
			List<LoadReturnDrugsServiceDto> objServicedto) {
		List<LoadReturnDrugsControllerDto> objControllerDto = new ArrayList<LoadReturnDrugsControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadReturnDrugsControllerDto objControllerDto1 = new LoadReturnDrugsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadReturnDrugsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadReturnDrugsPersistenceDto> persistenceDTOs) {
		List<LoadReturnDrugsServiceDto> objServicedtos = new ArrayList<LoadReturnDrugsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadReturnDrugsServiceDto objSearchServiceDto = new LoadReturnDrugsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	public List<LoadReturnDrugsPersistenceDto> settingDataIntoLoadReturnDrugsPersistenceDto(List<Object[]> list) {
		List<LoadReturnDrugsPersistenceDto> listOfData = new ArrayList<LoadReturnDrugsPersistenceDto>();
		for (Object[] objects : list) {
			LoadReturnDrugsPersistenceDto objPersistenceDTO = new LoadReturnDrugsPersistenceDto();
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
				objPersistenceDTO.setDrugShortUnicCode(objects[3].toString());
			} else {
				objPersistenceDTO.setDrugShortUnicCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setDfFormType(objects[4].toString());
			} else {
				objPersistenceDTO.setDfFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[5] != null) {
				objPersistenceDTO.setDrStrenghtType(objects[5].toString());
			} else {
				objPersistenceDTO.setDrStrenghtType(CommonConstants.DATA_NOT_AVIALABLE);
			}
		    if (objects[6] != null) {
				objPersistenceDTO.setCompanyName(objects[6].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setBatchNumber(objects[7].toString());
			} else {
				objPersistenceDTO.setBatchNumber(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setExpireDate(objects[8].toString());
			} else {
				objPersistenceDTO.setExpireDate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setFormId(objects[9].toString());
			} else {
				objPersistenceDTO.setFormId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setDdjustedStockQty(objects[10].toString());
			} else {
				objPersistenceDTO.setDdjustedStockQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[11] != null) {
				objPersistenceDTO.setDatSerialId(objects[11].toString());
			} else {
				objPersistenceDTO.setDatSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[12] != null) {
				objPersistenceDTO.setDatInvoiceNo(objects[12].toString());
			} else {
				objPersistenceDTO.setDatInvoiceNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}



	

	

}

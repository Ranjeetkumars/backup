package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadExpiryDrugsControllerDto;
import com.pro.scm.persistencedto.LoadExpiryDrugsPersistencedto;
import com.pro.scm.servicedto.LoadExpiryDrugsServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadExpiryDrugsMapper {

	public LoadExpiryDrugsServiceDto conversionControllerDtoToServiceDto(
			LoadExpiryDrugsControllerDto scmLoginControllerDto) {
		LoadExpiryDrugsServiceDto scmLoginServiceDto = new LoadExpiryDrugsServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadExpiryDrugsControllerDto> conversionForServiceTOControllerDTO(
			List<LoadExpiryDrugsServiceDto> objServicedto) {
		List<LoadExpiryDrugsControllerDto> objControllerDto = new ArrayList<LoadExpiryDrugsControllerDto>();
		objServicedto.forEach(serviceDto -> {
			LoadExpiryDrugsControllerDto objControllerDto1 = new LoadExpiryDrugsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadExpiryDrugsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadExpiryDrugsPersistencedto> persistenceDTOs) {
		List<LoadExpiryDrugsServiceDto> objServicedtos = new ArrayList<LoadExpiryDrugsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadExpiryDrugsServiceDto objSearchServiceDto = new LoadExpiryDrugsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


	

	
	
	

	public List<LoadExpiryDrugsPersistencedto> settingDataIntoLoadExpiryDrugsPersistencedto(List<Object[]> list) {
		List<LoadExpiryDrugsPersistencedto> listOfData = new ArrayList<LoadExpiryDrugsPersistencedto>();
		for (Object[] objects : list) {
			LoadExpiryDrugsPersistencedto objPersistenceDTO = new LoadExpiryDrugsPersistencedto();
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
				objPersistenceDTO.setBillNo(objects[4].toString());
			} else {
				objPersistenceDTO.setBillNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[4] != null) {
				objPersistenceDTO.setBillNo(objects[4].toString());
			} else {
				objPersistenceDTO.setBillNo(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setDfFormType(objects[5].toString());
			} else {
				objPersistenceDTO.setDfFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setDrStrenghtType(objects[6].toString());
			} else {
				objPersistenceDTO.setDrStrenghtType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setCompanyName(objects[7].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setBatchNumber(objects[8].toString());
			} else {
				objPersistenceDTO.setBatchNumber(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[9] != null) {
				objPersistenceDTO.setExpireDate(objects[9].toString());
			} else {
				objPersistenceDTO.setExpireDate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[10] != null) {
				objPersistenceDTO.setDmrAvailableStock(objects[10].toString());
			} else {
				objPersistenceDTO.setDmrAvailableStock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[11] != null) {
				objPersistenceDTO.setDrrAvailableStock(objects[11].toString());
			} else {
				objPersistenceDTO.setDrrAvailableStock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[12] != null) {
				objPersistenceDTO.setTotalExp(objects[12].toString());
			} else {
				objPersistenceDTO.setTotalExp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[13] != null) {
				objPersistenceDTO.setPdtQuantity(objects[13].toString());
			} else {
				objPersistenceDTO.setPdtQuantity(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[14] != null) {
				objPersistenceDTO.setSupplierId(objects[14].toString());
			} else {
				objPersistenceDTO.setSupplierId(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[15] != null) {
				objPersistenceDTO.setDrFormId(objects[15].toString());
			} else {
				objPersistenceDTO.setDrFormId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

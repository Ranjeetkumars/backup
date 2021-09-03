package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.GetMedicinesControllerDto;
import com.pro.scm.persistencedto.GetMedicinesPersistenceDto;
import com.pro.scm.servicedto.GetMedicinesServiceDto;
import com.pro.scm.utills.CommonConstants;

public class GetMedicinesMapper {

	public GetMedicinesServiceDto conversionControllerDtoToServiceDto(
			GetMedicinesControllerDto medicinesControllerDto) {
		GetMedicinesServiceDto scmLoginServiceDto = new GetMedicinesServiceDto();
		BeanUtils.copyProperties(medicinesControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<GetMedicinesControllerDto> conversionForServiceTOControllerDTO(
			List<GetMedicinesServiceDto> vehiclesSubstoreServiceDtos) {
		List<GetMedicinesControllerDto> objControllerDto = new ArrayList<GetMedicinesControllerDto>();
		vehiclesSubstoreServiceDtos.forEach(serviceDto -> {
			GetMedicinesControllerDto objControllerDto1 = new GetMedicinesControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<GetMedicinesServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<GetMedicinesPersistenceDto> persistenceDTOs) {
		List<GetMedicinesServiceDto> objServicedtos = new ArrayList<GetMedicinesServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			GetMedicinesServiceDto objSearchServiceDto = new GetMedicinesServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<GetMedicinesPersistenceDto> settingDataIntoGetMedicinesPersistenceDto(List<Object[]> list) {
		List<GetMedicinesPersistenceDto> listOfData = new ArrayList<GetMedicinesPersistenceDto>();
		for (Object[] objects : list) {
			GetMedicinesPersistenceDto objPersistenceDTO = new GetMedicinesPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[1] != null) {
				objPersistenceDTO.setGenericName(objects[1].toString());
			} else {
				objPersistenceDTO.setGenericName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setShortUnicCode(objects[2].toString());
			} else {
				objPersistenceDTO.setShortUnicCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setDrugBrandLang_1(objects[3].toString());
			} else {
				objPersistenceDTO.setDrugBrandLang_1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setCompanyName(objects[4].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setPackingType(objects[5].toString());
			} else {
				objPersistenceDTO.setPackingType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setGroupName(objects[6].toString());
			} else {
				objPersistenceDTO.setGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setFormType(objects[7].toString());
			} else {
				objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setStrengthType(objects[8].toString());
			} else {
				objPersistenceDTO.setStrengthType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setSystemTypeLang_1(objects[9].toString());
			} else {
				objPersistenceDTO.setSystemTypeLang_1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setDgGroupFunctionTypeLang_1(objects[10].toString());
			} else {
				objPersistenceDTO.setDgGroupFunctionTypeLang_1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[11] != null) {
				objPersistenceDTO.setDgmGroupMoleculesTypeLang_1(objects[11].toString());
			} else {
				objPersistenceDTO.setDgmGroupMoleculesTypeLang_1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[12] != null) {
				objPersistenceDTO.setDrugName(objects[12].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[13] != null) {
				objPersistenceDTO.setSchduleType(objects[13].toString());
			} else {
				objPersistenceDTO.setSchduleType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[14] != null) {
				objPersistenceDTO.setDr_MinmunLevelQty(objects[14].toString());
			} else {
				objPersistenceDTO.setDr_MinmunLevelQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[15] != null) {
				objPersistenceDTO.setDr_MaximunLevelQty(objects[15].toString());
			} else {
				objPersistenceDTO.setDr_MaximunLevelQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[16] != null) {
				objPersistenceDTO.setDr_ExpireAlert(objects[16].toString());
			} else {
				objPersistenceDTO.setDr_ExpireAlert(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[17] != null) {
				objPersistenceDTO.setVehminQty(objects[17].toString());
			} else {
				objPersistenceDTO.setVehminQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[18] != null) {
				objPersistenceDTO.setVehmaxQty(objects[18].toString());
			} else {
				objPersistenceDTO.setVehmaxQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[19] != null) {
				objPersistenceDTO.setDr_MinSalesQty(objects[19].toString());
			} else {
				objPersistenceDTO.setDr_MinSalesQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[20] != null) {
				objPersistenceDTO.setSubStoreMinQty(objects[20].toString());
			} else {
				objPersistenceDTO.setSubStoreMinQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[21] != null) {
				objPersistenceDTO.setSubStoreMaxQty(objects[21].toString());
			} else {
				objPersistenceDTO.setSubStoreMaxQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[22] != null) {
				objPersistenceDTO.setBarCode(objects[22].toString());
			} else {
				objPersistenceDTO.setBarCode(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[23] != null) {
				objPersistenceDTO.setDescription(objects[23].toString());
			} else {
				objPersistenceDTO.setDescription(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	public List<GetMedicinesPersistenceDto> settingDataIntoGetMedicinesNewInventoryProcessPersistenceDto(
			List<Object[]> list) {
		List<GetMedicinesPersistenceDto> listOfData = new ArrayList<GetMedicinesPersistenceDto>();
		for (Object[] objects : list) {
			GetMedicinesPersistenceDto objPersistenceDTO = new GetMedicinesPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugidList(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugidList(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[1] != null) {
				objPersistenceDTO.setGenericName(objects[1].toString());
			} else {
				objPersistenceDTO.setGenericName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDb_drug_brand_lang1(objects[2].toString());
			} else {
				objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setUnicode(objects[3].toString());
			} else {
				objPersistenceDTO.setUnicode(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[4] != null) {
				objPersistenceDTO.setDf_form_type(objects[4].toString());
			} else {
				objPersistenceDTO.setDf_form_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setStrenghtlist(objects[5].toString());
			} else {
				objPersistenceDTO.setStrenghtlist(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[6] != null) {
				objPersistenceDTO.setSupplierName(objects[6].toString());
			} else {
				objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[7] != null) {
				objPersistenceDTO.setGroupMolecules(objects[7].toString());
			} else {
				objPersistenceDTO.setGroupMolecules(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

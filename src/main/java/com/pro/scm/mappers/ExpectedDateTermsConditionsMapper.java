package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.BrandDetailsControllerDTO;
import com.pro.scm.controllerdto.BrandNameControllerDTO;
import com.pro.scm.controllerdto.ExpectedDateTermsConditionControllerDTO;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.BrandNamePersistanceDTO;
import com.pro.scm.persistencedto.ExpectedDateTermsConditionPersistanceDTO;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.servicedto.ExpectedDateTermsConditionServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class ExpectedDateTermsConditionsMapper {
	public ExpectedDateTermsConditionServiceDTO conversionControllerDtoToServiceDto(
			ExpectedDateTermsConditionControllerDTO objBrandDetailsControllerDTO) {
		ExpectedDateTermsConditionServiceDTO objBrandNameServiceDTO = new ExpectedDateTermsConditionServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandNameServiceDTO);

		return objBrandNameServiceDTO;
	}

	public List<ExpectedDateTermsConditionControllerDTO> conversionForServiceTOControllerDTO(
			List<ExpectedDateTermsConditionServiceDTO> objServicedto) {
		List<ExpectedDateTermsConditionControllerDTO> objBrandNameControllerDTO = new ArrayList<ExpectedDateTermsConditionControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			ExpectedDateTermsConditionControllerDTO brandNameControllerDTO = new ExpectedDateTermsConditionControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, brandNameControllerDTO);
			objBrandNameControllerDTO.add(brandNameControllerDTO);
		});
		return objBrandNameControllerDTO;
	}

	public List<ExpectedDateTermsConditionServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<ExpectedDateTermsConditionPersistanceDTO> persistenceDTOs) {
		List<ExpectedDateTermsConditionServiceDTO> objServicedtos = new ArrayList<ExpectedDateTermsConditionServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			ExpectedDateTermsConditionServiceDTO objSearchServiceDto = new ExpectedDateTermsConditionServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<ExpectedDateTermsConditionPersistanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<ExpectedDateTermsConditionPersistanceDTO> listOfData = new ArrayList<ExpectedDateTermsConditionPersistanceDTO>();
		for (Object[] objects : list) {
			ExpectedDateTermsConditionPersistanceDTO objPersistenceDTO = new ExpectedDateTermsConditionPersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setExpected_date(objects[0].toString());
			} else {
				objPersistenceDTO.setExpected_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setTerms_conditions(objects[1].toString());
			} else {
				objPersistenceDTO.setTerms_conditions(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.BrandDetailsControllerDTO;
import com.pro.scm.controllerdto.BrandNameControllerDTO;
import com.pro.scm.controllerdto.IndentDetailsControllerDTO;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.BrandNamePersistanceDTO;
import com.pro.scm.persistencedto.IndentDetailsPersistanceDTO;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.servicedto.IndentDetailsServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class IndentDetailsMapper {
	public IndentDetailsServiceDTO conversionControllerDtoToServiceDto(
			IndentDetailsControllerDTO objBrandDetailsControllerDTO) {
		IndentDetailsServiceDTO objBrandNameServiceDTO = new IndentDetailsServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandNameServiceDTO);

		return objBrandNameServiceDTO;
	}

	public List<IndentDetailsControllerDTO> conversionForServiceTOControllerDTO(
			List<IndentDetailsServiceDTO> objServicedto) {
		List<IndentDetailsControllerDTO> objBrandNameControllerDTO = new ArrayList<IndentDetailsControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			IndentDetailsControllerDTO brandNameControllerDTO = new IndentDetailsControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, brandNameControllerDTO);
			objBrandNameControllerDTO.add(brandNameControllerDTO);
		});
		return objBrandNameControllerDTO;
	}

	public List<IndentDetailsServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<IndentDetailsPersistanceDTO> persistenceDTOs) {
		List<IndentDetailsServiceDTO> objServicedtos = new ArrayList<IndentDetailsServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			IndentDetailsServiceDTO objSearchServiceDto = new IndentDetailsServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<IndentDetailsPersistanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<IndentDetailsPersistanceDTO> listOfData = new ArrayList<IndentDetailsPersistanceDTO>();
		for (Object[] objects : list) {
			IndentDetailsPersistanceDTO objPersistenceDTO = new IndentDetailsPersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setCit_id(objects[0].toString());
			} else {
				objPersistenceDTO.setCit_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setItem_id(objects[1].toString());
			} else {
				objPersistenceDTO.setItem_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrug_name(objects[2].toString());
			} else {
				objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setApproved_quantity(objects[3].toString());
			} else {
				objPersistenceDTO.setApproved_quantity(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setStength_type(objects[4].toString());
			} else {
				objPersistenceDTO.setStength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setForm_id(objects[5].toString());
			} else {
				objPersistenceDTO.setForm_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setForm_type(objects[6].toString());
			} else {
				objPersistenceDTO.setForm_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setManufacture_id(objects[7].toString());
			} else {
				objPersistenceDTO.setManufacture_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setCompany_name(objects[8].toString());
			} else {
				objPersistenceDTO.setCompany_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setBrand_id(objects[9].toString());
			} else {
				objPersistenceDTO.setBrand_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setBrand_name(objects[10].toString());
			} else {
				objPersistenceDTO.setBrand_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

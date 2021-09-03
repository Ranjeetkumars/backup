package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.AdjustmentSearchControllerDTO;
import com.pro.scm.controllerdto.BrandDetailsControllerDTO;
import com.pro.scm.persistencedto.AdjustmentSearchPersistanceDTO;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.servicedto.AdjustmentSearchServiceDTO;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class AjustmentSearchMapper {
	public AdjustmentSearchServiceDTO conversionControllerDtoToServiceDto(
			AdjustmentSearchControllerDTO objBrandDetailsControllerDTO) {
		AdjustmentSearchServiceDTO objBrandNameServiceDTO = new AdjustmentSearchServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandNameServiceDTO);

		return objBrandNameServiceDTO;
	}

	public List<AdjustmentSearchControllerDTO> conversionForServiceTOControllerDTO(
			List<AdjustmentSearchServiceDTO> objServicedto) {
		List<AdjustmentSearchControllerDTO> objBrandNameControllerDTO = new ArrayList<AdjustmentSearchControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			AdjustmentSearchControllerDTO brandNameControllerDTO = new AdjustmentSearchControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, brandNameControllerDTO);
			objBrandNameControllerDTO.add(brandNameControllerDTO);
		});
		return objBrandNameControllerDTO;
	}

	public List<AdjustmentSearchServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<AdjustmentSearchPersistanceDTO> persistenceDTOs) {
		List<AdjustmentSearchServiceDTO> objServicedtos = new ArrayList<AdjustmentSearchServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			AdjustmentSearchServiceDTO objSearchServiceDto = new AdjustmentSearchServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<AdjustmentSearchPersistanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<AdjustmentSearchPersistanceDTO> listOfData = new ArrayList<AdjustmentSearchPersistanceDTO>();
		for (Object[] objects : list) {
			AdjustmentSearchPersistanceDTO objPersistenceDTO = new AdjustmentSearchPersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrug_id(objects[0].toString());
			} else {
				objPersistenceDTO.setDrug_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setBrand_name(objects[2].toString());
			} else {
				objPersistenceDTO.setBrand_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setMolecule_type(objects[3].toString());
			} else {
				objPersistenceDTO.setMolecule_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setUnicode(objects[4].toString());
			} else {
				objPersistenceDTO.setUnicode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setForm_type(objects[5].toString());
			} else {
				objPersistenceDTO.setForm_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[6] != null) {
				objPersistenceDTO.setStrength_type(objects[6].toString());
			} else {
				objPersistenceDTO.setStrength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setManufacture_name(objects[7].toString());
			} else {
				objPersistenceDTO.setManufacture_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setPacking_type(objects[8].toString());
			} else {
				objPersistenceDTO.setPacking_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[9] != null) {
				objPersistenceDTO.setBatch_number(objects[9].toString());
			} else {
				objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setAvailable_stock(objects[10].toString());
			} else {
				objPersistenceDTO.setAvailable_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[11] != null) {
				objPersistenceDTO.setExpire_date(objects[11].toString());
			} else {
				objPersistenceDTO.setExpire_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[12] != null) {
				objPersistenceDTO.setMrp(objects[12].toString());
			} else {
				objPersistenceDTO.setMrp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[13] != null) {
				objPersistenceDTO.setUnit_cost(objects[13].toString());
			} else {
				objPersistenceDTO.setUnit_cost(CommonConstants.DATA_NOT_AVIALABLE);
			
			}
			if (objects[14] != null) {
				objPersistenceDTO.setStock_ref(objects[14].toString());
			} else {
				objPersistenceDTO.setStock_ref(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[15] != null) {
				objPersistenceDTO.setInvoice_number(objects[15].toString());
			} else {
				objPersistenceDTO.setInvoice_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.BrandDetailsControllerDTO;
import com.pro.scm.controllerdto.BrandNameControllerDTO;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.BrandNamePersistanceDTO;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class BrandNameMapper {
	public BrandNameServiceDTO conversionControllerDtoToServiceDto(
			BrandNameControllerDTO objBrandDetailsControllerDTO) {
		BrandNameServiceDTO objBrandNameServiceDTO = new BrandNameServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandNameServiceDTO);

		return objBrandNameServiceDTO;
	}
	
	
	
	public List<BrandNameControllerDTO> conversionForServiceTOControllerDTO(List<BrandNameServiceDTO> objServicedto) {
		List<BrandNameControllerDTO> objBrandNameControllerDTO = new ArrayList<BrandNameControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			BrandNameControllerDTO brandNameControllerDTO = new BrandNameControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, brandNameControllerDTO);
			objBrandNameControllerDTO.add(brandNameControllerDTO);
		});
		return objBrandNameControllerDTO;
	}

	public List<BrandNameServiceDTO> conversionpersistanceDTOtoServiceDTO(List<BrandNamePersistanceDTO> persistenceDTOs) {
		List<BrandNameServiceDTO> objServicedtos = new ArrayList<BrandNameServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			BrandNameServiceDTO objSearchServiceDto = new BrandNameServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<BrandNamePersistanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<BrandNamePersistanceDTO> listOfData = new ArrayList<BrandNamePersistanceDTO>();
		for (Object[] objects : list) {
			BrandNamePersistanceDTO objPersistenceDTO = new BrandNamePersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setBrand_id(objects[0].toString());
			} else {
				objPersistenceDTO.setBrand_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setBrand_name(objects[1].toString());
			} else {
				objPersistenceDTO.setBrand_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

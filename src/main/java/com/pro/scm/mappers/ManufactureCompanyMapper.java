package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.BrandDetailsControllerDTO;
import com.pro.scm.controllerdto.BrandNameControllerDTO;
import com.pro.scm.controllerdto.ManufactureCompanyControllerDTO;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.BrandNamePersistanceDTO;
import com.pro.scm.persistencedto.ManufactureCompanyPersistanceDTO;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.servicedto.ManufactureCompanyServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class ManufactureCompanyMapper {
	public ManufactureCompanyServiceDTO conversionControllerDtoToServiceDto(
			ManufactureCompanyControllerDTO objBrandDetailsControllerDTO) {
		ManufactureCompanyServiceDTO objBrandNameServiceDTO = new ManufactureCompanyServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandNameServiceDTO);

		return objBrandNameServiceDTO;
	}
	
	
	
	public List<ManufactureCompanyControllerDTO> conversionForServiceTOControllerDTO(List<ManufactureCompanyServiceDTO> objServicedto) {
		List<ManufactureCompanyControllerDTO> objManufactureCompanyControllerDTO = new ArrayList<ManufactureCompanyControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			ManufactureCompanyControllerDTO brandNameControllerDTO = new ManufactureCompanyControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, brandNameControllerDTO);
			objManufactureCompanyControllerDTO.add(brandNameControllerDTO);
		});
		return objManufactureCompanyControllerDTO;
	}

	public List<ManufactureCompanyServiceDTO> conversionpersistanceDTOtoServiceDTO(List<ManufactureCompanyPersistanceDTO> persistenceDTOs) {
		List<ManufactureCompanyServiceDTO> objServicedtos = new ArrayList<ManufactureCompanyServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			ManufactureCompanyServiceDTO objSearchServiceDto = new ManufactureCompanyServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<ManufactureCompanyPersistanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<ManufactureCompanyPersistanceDTO> listOfData = new ArrayList<ManufactureCompanyPersistanceDTO>();
		for (Object[] objects : list) {
			ManufactureCompanyPersistanceDTO objPersistenceDTO = new ManufactureCompanyPersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setManufacture_company_id(objects[0].toString());
			} else {
				objPersistenceDTO.setManufacture_company_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setManufacture_company_name(objects[1].toString());
			} else {
				objPersistenceDTO.setManufacture_company_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.BrandDetailsControllerDTO;
import com.pro.scm.controllerdto.BrandNameControllerDTO;
import com.pro.scm.controllerdto.GetUserDropdownControllerDTO;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.BrandNamePersistanceDTO;
import com.pro.scm.persistencedto.GetUserDropdownPersistanceDTO;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.servicedto.GetUserDropdownServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class GetUserDropdownMapper {
	public GetUserDropdownServiceDTO conversionControllerDtoToServiceDto(
			GetUserDropdownControllerDTO objBrandDetailsControllerDTO) {
		GetUserDropdownServiceDTO objBrandNameServiceDTO = new GetUserDropdownServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandNameServiceDTO);

		return objBrandNameServiceDTO;
	}
	
	
	
	public List<GetUserDropdownControllerDTO> conversionForServiceTOControllerDTO(List<GetUserDropdownServiceDTO> objServicedto) {
		List<GetUserDropdownControllerDTO> objBrandNameControllerDTO = new ArrayList<GetUserDropdownControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			GetUserDropdownControllerDTO brandNameControllerDTO = new GetUserDropdownControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, brandNameControllerDTO);
			objBrandNameControllerDTO.add(brandNameControllerDTO);
		});
		return objBrandNameControllerDTO;
	}

	public List<GetUserDropdownServiceDTO> conversionpersistanceDTOtoServiceDTO(List<GetUserDropdownPersistanceDTO> list) {
		List<GetUserDropdownServiceDTO> objServicedtos = new ArrayList<GetUserDropdownServiceDTO>();
		list.forEach(persistence -> {
			GetUserDropdownServiceDTO objSearchServiceDto = new GetUserDropdownServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<GetUserDropdownPersistanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<GetUserDropdownPersistanceDTO> listOfData = new ArrayList<GetUserDropdownPersistanceDTO>();
		for (Object[] objects : list) {
			GetUserDropdownPersistanceDTO objPersistenceDTO = new GetUserDropdownPersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setUser_id(objects[0].toString());
			} else {
				objPersistenceDTO.setUser_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setUser_name(objects[1].toString());
			} else {
				objPersistenceDTO.setUser_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

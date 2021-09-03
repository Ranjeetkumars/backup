package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.MaterialFormControllerDTO;
import com.pro.scm.servicedto.MaterialFormServiceDTO;


public class MaterialFormMapper {
	public MaterialFormServiceDTO conversionControllerDtoToServiceDto(
			MaterialFormControllerDTO objMaterialFormControllerDTO) {
		
		
		MaterialFormServiceDTO objMaterialFormServiceDTO = new MaterialFormServiceDTO();
		BeanUtils.copyProperties(objMaterialFormControllerDTO, objMaterialFormServiceDTO);

		return objMaterialFormServiceDTO;
	}
	
	
	
	public List<MaterialFormControllerDTO> conversionForServiceTOControllerDTO(List<MaterialFormServiceDTO> objServicedto) {
		List<MaterialFormControllerDTO> objMaterialFormControllerDTO = new ArrayList<MaterialFormControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			MaterialFormControllerDTO objMaterialFormControllerDTO1 = new MaterialFormControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objMaterialFormControllerDTO1);
			objMaterialFormControllerDTO.add(objMaterialFormControllerDTO1);
		});
		return objMaterialFormControllerDTO;
	}


}

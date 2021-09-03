package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.MaterialUnitControllerDTO;
import com.pro.scm.controllerdto.PharmacySalesControllerDTO;
import com.pro.scm.servicedto.MaterialUnitServiceDTO;
import com.pro.scm.servicedto.PharmacySalesServiceDTO;



public class MaterailUnitMapper {
	public MaterialUnitServiceDTO conversionControllerDtoToServiceDto(
			MaterialUnitControllerDTO objMaterialUnitControllerDTO) {
		MaterialUnitServiceDTO objMaterialUnitServiceDTO = new MaterialUnitServiceDTO();
		BeanUtils.copyProperties(objMaterialUnitControllerDTO, objMaterialUnitServiceDTO);

		return objMaterialUnitServiceDTO;
	}
}

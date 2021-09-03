package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.UpdateDrugDetailsControllerDTO;
import com.pro.scm.servicedto.UpdateDrugDetailsServiceDTO;



public class UpdateDrugDetailsMapper {
	public UpdateDrugDetailsServiceDTO conversionControllerDtoToServiceDto(
			UpdateDrugDetailsControllerDTO objUpdateDrugDetailsControllerDTO) {
		UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO = new UpdateDrugDetailsServiceDTO();
		BeanUtils.copyProperties(objUpdateDrugDetailsControllerDTO, objUpdateDrugDetailsServiceDTO);

		return objUpdateDrugDetailsServiceDTO;
	}

}

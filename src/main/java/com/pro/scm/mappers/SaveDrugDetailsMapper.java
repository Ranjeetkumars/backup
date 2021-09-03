package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.SaveDrugDetailsControllerDto;
import com.pro.scm.servicedto.SaveDrugDetailsServiceDto;

public class SaveDrugDetailsMapper {

	public SaveDrugDetailsServiceDto conversionControllerDtoToServiceDto(
			SaveDrugDetailsControllerDto saveDrugDetailsControllerDto) {
		SaveDrugDetailsServiceDto SaveDrugDetailsServiceDto = new SaveDrugDetailsServiceDto();
		BeanUtils.copyProperties(saveDrugDetailsControllerDto, SaveDrugDetailsServiceDto);
		return SaveDrugDetailsServiceDto;

	}

}

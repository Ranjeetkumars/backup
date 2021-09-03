package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.SaveInActiveDrugsControllerDto;
import com.pro.scm.servicedto.SaveInActiveDrugsServiceDto;

public class SaveInActiveDrugsMapper {

	public SaveInActiveDrugsServiceDto conversionControllerDtoToServiceDto(
			SaveInActiveDrugsControllerDto saveInActiveDrugsControllerDto) {
		SaveInActiveDrugsServiceDto saveInActiveDrugsServiceDto = new SaveInActiveDrugsServiceDto();
		BeanUtils.copyProperties(saveInActiveDrugsControllerDto, saveInActiveDrugsServiceDto);
		return saveInActiveDrugsServiceDto;
	}

}

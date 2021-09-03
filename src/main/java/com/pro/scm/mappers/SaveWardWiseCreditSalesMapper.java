package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.SaveWardWiseCreditSalesControllerDto;
import com.pro.scm.servicedto.SaveWardWiseCreditSalesServiceDto;

public class SaveWardWiseCreditSalesMapper {
	
	
	public SaveWardWiseCreditSalesServiceDto conversionControllerDtoToServiceDto(SaveWardWiseCreditSalesControllerDto cDto){
		
		SaveWardWiseCreditSalesServiceDto sDto = new SaveWardWiseCreditSalesServiceDto();
		BeanUtils.copyProperties(cDto, sDto);
		return sDto;
		
	}

}

package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.ExpiryDrugsControllerDto;
import com.pro.scm.servicedto.ExpiryDrugsServiceDto;

public class ExpiryDrugsMapper {

	public ExpiryDrugsServiceDto conversionControllerDtoToServiceDto(
			ExpiryDrugsControllerDto objExpiryDrugsControllerDto) {
		System.out.println("objExpiryDrugsControllerDto-------->"+objExpiryDrugsControllerDto.getStoreTypeId());
		
		ExpiryDrugsServiceDto expiryDrugsServiceDto = new ExpiryDrugsServiceDto();
		
		BeanUtils.copyProperties(objExpiryDrugsControllerDto, expiryDrugsServiceDto);
        System.out.println("expiryDrugsServiceDtoexpiryDrugsServiceDtoexpiryDrugsServiceDto="+expiryDrugsServiceDto.getStoreTypeId());
		return expiryDrugsServiceDto;
	}

}

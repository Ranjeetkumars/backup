package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.MesserAddressControllerDto;
import com.pro.scm.servicedto.MesserAddressServiceDto;

public class MesserAddressMapper {

	public MesserAddressServiceDto conversionControllerDtoToServiceDto(MesserAddressControllerDto cDtos) {
		
		MesserAddressServiceDto messerAddressServiceDto = new MesserAddressServiceDto();
				BeanUtils.copyProperties(cDtos, messerAddressServiceDto);
		return messerAddressServiceDto;
	}

}

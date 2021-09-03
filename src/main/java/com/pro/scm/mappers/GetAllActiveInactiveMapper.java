package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.GetAllActiveInactiveControllerDto;
import com.pro.scm.servicedto.GetAllActiveInactiveServiceDto;

public class GetAllActiveInactiveMapper {
	
	
	public GetAllActiveInactiveServiceDto conversionControllerDtoToServiceDto(GetAllActiveInactiveControllerDto getAllActiveInactiveControllerDto) {
		
		GetAllActiveInactiveServiceDto getAllActiveInactiveServiceDto =new GetAllActiveInactiveServiceDto();
		BeanUtils.copyProperties(getAllActiveInactiveControllerDto, getAllActiveInactiveServiceDto);
		return getAllActiveInactiveServiceDto;
	}

}

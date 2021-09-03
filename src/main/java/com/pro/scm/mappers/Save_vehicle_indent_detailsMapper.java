package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.Save_vehicle_indent_detailsControllerDto;
import com.pro.scm.servicedto.Save_vehicle_indent_detailsServiceDto;

public class Save_vehicle_indent_detailsMapper {
	
	
	
	public Save_vehicle_indent_detailsServiceDto conversionControllerDtoToServiceDto(Save_vehicle_indent_detailsControllerDto controllerDto) {
		Save_vehicle_indent_detailsServiceDto serviceDto = new Save_vehicle_indent_detailsServiceDto();
		BeanUtils.copyProperties(controllerDto, serviceDto);
		return serviceDto;
		
		
	}

}

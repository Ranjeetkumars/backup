package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.ListLoadActiveDrugsCountControllerDto;
import com.pro.scm.servicedto.ListLoadActiveDrugsCountServiceDto;

public class ListLoadActiveDrugsCountMapper {

	
	
	
	public ListLoadActiveDrugsCountServiceDto conversionControllerDtoToServiceDto(
			ListLoadActiveDrugsCountControllerDto listLoadActiveDrugsCountControllerDto) {
		ListLoadActiveDrugsCountServiceDto listLoadActiveDrugsCountServiceDto = new ListLoadActiveDrugsCountServiceDto();
		BeanUtils.copyProperties(listLoadActiveDrugsCountControllerDto, listLoadActiveDrugsCountServiceDto);
		return listLoadActiveDrugsCountServiceDto;
	}

}

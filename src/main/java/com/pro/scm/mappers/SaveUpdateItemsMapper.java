package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.SaveUpdateItemsControllerDto;
import com.pro.scm.servicedto.SaveUpdateItemsServiceDto;

public class SaveUpdateItemsMapper {
	
	public SaveUpdateItemsServiceDto conversionControllerDtoToServiceDto(SaveUpdateItemsControllerDto saveUpdateItemsControllerDto) {
		SaveUpdateItemsServiceDto saveUpdateItemsServiceDto = new SaveUpdateItemsServiceDto();
		BeanUtils.copyProperties(saveUpdateItemsControllerDto, saveUpdateItemsServiceDto);
		return saveUpdateItemsServiceDto;
		
		
	}

}

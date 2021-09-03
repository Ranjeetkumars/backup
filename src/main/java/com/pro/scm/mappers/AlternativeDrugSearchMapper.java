package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.AlternativeDrugSearchControllerDto;
import com.pro.scm.servicedto.AlternativeDrugSearchServiceDto;

public class AlternativeDrugSearchMapper {
	
	public AlternativeDrugSearchServiceDto conversionControllerDtoToServiceDto(AlternativeDrugSearchControllerDto cDtos) {
		AlternativeDrugSearchServiceDto  sDtos  = new AlternativeDrugSearchServiceDto();
		BeanUtils.copyProperties(cDtos, sDtos);
		return sDtos;
	}

}

package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.AcceptTransferItemsControllerDto;
import com.pro.scm.servicedto.AcceptTransferItemsServiceDto;

public class AcceptTransferItemsMapper {
	
	
	
	public AcceptTransferItemsServiceDto conversionControllerDtoToServiceDto(
			AcceptTransferItemsControllerDto objControllerDTO) {
		AcceptTransferItemsServiceDto objServiceDTO = new AcceptTransferItemsServiceDto();
		BeanUtils.copyProperties(objControllerDTO, objServiceDTO);
		return objServiceDTO;
	}

}

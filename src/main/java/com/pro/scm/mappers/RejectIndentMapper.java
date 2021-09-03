package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.RejectIndentDataControllerDto;
import com.pro.scm.servicedto.RejectIndentDataServiceDto;

public class RejectIndentMapper {
	public  RejectIndentDataServiceDto converControllerToServiceDTO(RejectIndentDataControllerDto controllerDto) {
		
		RejectIndentDataServiceDto serviceDto = new RejectIndentDataServiceDto();
			BeanUtils.copyProperties(controllerDto, serviceDto);
			return serviceDto;
			
		}
}

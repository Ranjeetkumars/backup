package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.GetMedicinesCountControllerDto;
import com.pro.scm.servicedto.GetMedicinesCountServiceDto;

public class GetMedicinesCountMapper {
	
	
	public GetMedicinesCountServiceDto conversionControllerDtoToServiceDto(GetMedicinesCountControllerDto getMedicinesCountControllerDto) {
		GetMedicinesCountServiceDto getMedicinesCountServiceDto = new GetMedicinesCountServiceDto();
		BeanUtils.copyProperties(getMedicinesCountControllerDto, getMedicinesCountServiceDto);
		return getMedicinesCountServiceDto;
		
	}

}

package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.UpdateActiveDrugForApprovalControllerDto;
import com.pro.scm.servicedto.UpdateActiveDrugForApprovalServiceDto;

public class UpdateActiveDrugForApprovalMapper {

	public UpdateActiveDrugForApprovalServiceDto conversionControllerDtoToServiceDto(
			UpdateActiveDrugForApprovalControllerDto updateActiveDrugForApprovalControllerDto) {
		UpdateActiveDrugForApprovalServiceDto updateActiveDrugForApprovalServiceDto = new UpdateActiveDrugForApprovalServiceDto();
		BeanUtils.copyProperties(updateActiveDrugForApprovalControllerDto, updateActiveDrugForApprovalServiceDto);
		return updateActiveDrugForApprovalServiceDto;
	}

}

package com.pro.scm.mappers;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.UpdateActiveDrugForRejectApprovalControllerDto;
import com.pro.scm.servicedto.UpdateActiveDrugForRejectApprovalServiceDto;

public class UpdateActiveDrugForRejectApprovalMapper {

	public UpdateActiveDrugForRejectApprovalServiceDto conversionControllerDtoToServiceDto(
			UpdateActiveDrugForRejectApprovalControllerDto cdto) {

		UpdateActiveDrugForRejectApprovalServiceDto sDto = new UpdateActiveDrugForRejectApprovalServiceDto();
		BeanUtils.copyProperties(cdto, sDto);
		return sDto;

	}

}

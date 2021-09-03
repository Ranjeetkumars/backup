package com.pro.scm.controllerdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VehicleTypeDrugsControllerDTO {

	private String vehicleTypeId;
	private String vehicleType;
	private String mappedType;
	private String drSerialId;
	private String materialGroupId;
	private String mgGroupName;
	private String drDrugName;
	private String drShortunicCode;
}

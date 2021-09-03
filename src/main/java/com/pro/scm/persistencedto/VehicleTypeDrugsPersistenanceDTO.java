package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class VehicleTypeDrugsPersistenanceDTO {
	
	private String vehicleTypeId;
	private String vehicleType;
	private String mappedType;
	private String drSerialId;
	private String materialGroupId;
	private String mgGroupName;
	private String drDrugName;
	private String drShortunicCode;
}

package com.pro.scm.persistencedto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoadVehiclesPersistenceDto {
	private String vehicleId;
	private String permanentRegNo;
	private String vehicleTypeId;

}

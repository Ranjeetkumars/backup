package com.pro.scm.controllerdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoadVehiclesControllerDto {
	private String baselocation;
	private String vehicleId;
	private String permanentRegNo;
	private String vehicleTypeId;
}

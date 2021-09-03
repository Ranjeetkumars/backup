package com.pro.scm.servicedto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoadVehiclesServiceDto {
	
	private String baselocation;
	private String vehicleId;
	private String permanentRegNo;
	private String vehicleTypeId;

}

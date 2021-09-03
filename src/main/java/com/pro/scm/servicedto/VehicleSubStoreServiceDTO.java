package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class VehicleSubStoreServiceDTO {
	private String subVehicleId;
	private String subStoreId;
	private String vehicleId;
	private String subStoreName;
	private String vehicleName;
	private String baseLocation;
	private String location;
	private String description;
	private String status;
	
	private String serialId;
	private String userId;
	private String moduleId;
	private String roleId;
}

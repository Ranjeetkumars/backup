package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class VehicleSubStorePersistenaceDTO {
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

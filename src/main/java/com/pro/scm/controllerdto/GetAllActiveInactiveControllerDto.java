package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class GetAllActiveInactiveControllerDto {
	
	private String genericName;
	private String brand;
	private String form;
	private String mfg;
	private String unicode;
	private String activeOrInactive;
	private String systemId;
    private String genericGroupId;
	private String genericMoleculeId;
	

}

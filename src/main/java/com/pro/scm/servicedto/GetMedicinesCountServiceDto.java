package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class GetMedicinesCountServiceDto {
	private String genericName;
	private String brand;
	private String form;
	private String mfg;
	private String unicode;
	private String systemId;
	private String genericGroupId;
	private String genericMoleculeId;

}

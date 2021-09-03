package com.pro.scm.controllerdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class GetMedicinesControllerDto {
	
	private String db_drug_brand_lang1;
	private String drugidList;
	private String df_form_type;
	private String strenghtlist;
	private String supplierName;
	
	private String activeAndInactive;
	private String genericName;
	private String brand;
	private String form;
	private String mfg;
	private String unicode;
	private String systemId;
	private String genericGroupId;
	private String genericMoleculeId;
	private String offsetValue;
	private String pageLimitValue;
	private String serialId;
	private String shortUnicCode;
	private String drugBrandLang_1;
	private String  companyName;
	private String packingType;
	private String groupName;
	private String formType;
	private String strengthType;
	private String systemTypeLang_1;
	private String dgGroupFunctionTypeLang_1;
	private String dgmGroupMoleculesTypeLang_1;
	private String drugName;
	private String schduleType;
	private String dr_MinmunLevelQty;
	private String dr_MaximunLevelQty;
	private String dr_ExpireAlert;
	private String vehminQty;
	private String vehmaxQty;
	private String dr_MinSalesQty;
	private String subStoreMinQty;
	private String subStoreMaxQty;
	private String barCode;
	private String description;
	private String groupMolecules;
	
	
	
	private int dmr_actuval_stock = 0;

	private int drr_actuval_stock = 0;

	private int	total_stock = 0;

}

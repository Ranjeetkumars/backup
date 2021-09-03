package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class SaveDrugDetailsControllerDto {
	
	private String drugId;
	private String drugName;
	private String brand_id;
	private String manufaturer_id;
	private String form_id;
	private String minmum_level_qty;
	private String maximum_lel_qty;
	private String short_unic_code;
	private String expire_alert;
	private String createdbyid;
	private String createdbyroleid;
	private String createdbymoduleid;
	private String strength_type;
	private String system_id;
	private String genric_group_id;
	private String genric_molecules_id;
	private String packId;
	private String scheduleid;
	private String vehicleReorderqty;
	private String vehicleMinqty;
	private String materialGroupformid;
	private String genericid;
	private String minsaleqty;
	private String barcode;
	private String subStoreMinLevelQty;
	private String subStoreMaxLevelQty;
	private String description;

}

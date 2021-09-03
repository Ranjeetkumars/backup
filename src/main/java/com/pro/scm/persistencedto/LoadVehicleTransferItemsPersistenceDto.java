package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class LoadVehicleTransferItemsPersistenceDto {
	private String dr_Short_Unic_Code;
	private String dr_drug_Name;
	private String drr_Batch_Number;
	private String pt_Packing_Type;
	private String drr_Expire_Date;
	private String arr_Available_Stock;
	private String dt_No_Strips;
	private String drr_Purchase_Price;
	private String drr_mrp;
	private String drr_Unit_Cost;
	private String dt_Drug_Id;
	private String dt_transfer_SerialId;
	private String dt_from_VehicleId;
	private String dt_Serial_Id;
}

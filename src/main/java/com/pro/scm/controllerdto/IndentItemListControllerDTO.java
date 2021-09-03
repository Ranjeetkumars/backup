package com.pro.scm.controllerdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)	
public class IndentItemListControllerDTO {
	private String mainstore_available_stock;
	private String mainstore_id;
	private String drug_id;
	private String batch_number;
	private String purchase_price;
	private String mrp;
	private String expire_date;
	private String recived_stock;
	private String available_stock;
	private String createdbyid;
	private String createdbyroleid;
	private String createdbymoduleid;
	private String unitprice;
	private String indent_code;
	private String size;
	private String status;
	private String indentNum;
	private String drug_name;
	private String countername;
	private String item_id;
	private String drug_brand_lang1;
	private String group_molecules_type_lang1;
	private String short_unic_code;
	private String form_type;
	private String strength_type;
	private String companyname;
	private String indent_qty;
	private String barcode;
	private String to_store_id;
	private String availableqty;
	private String ddr_rackname;
	private String dds_selfname;
	private String main_storeId;
	private String storeId;
	private String unitCost;
	private String serialid;
	private String templateId;
	private String templateType;
	private String createdbydtm;
	private String retailer_counter_name;
	private String store_countername;
	private String indent_status_type;
	private String username;
	private String tocounterId;
	private String fromCounterid;
	private String from_date;
	private String to_date;
	private String from_store;
	private String to_store;
	private String indentStatus;

}

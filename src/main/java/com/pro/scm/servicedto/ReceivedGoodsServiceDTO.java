package com.pro.scm.servicedto;



import lombok.Data;
@Data
public class ReceivedGoodsServiceDTO {
	private String isActive;
	private String totalAmount;
	private String po_id;
	private String trans_id;
	private String drug_name;
	private String drug_brand_lang;
	private String form_type;
	private String companyname;
	private String strength_type;
	private String packing_type;
	private String appoval;
	private String suppliername;
	private String  po_number;
	private String drug_id;
	private String dr_serialid;
	private String df_serialid;
	private String pt_serialid;
	private String supplierid;
	private String unit_cost;
	private String percentage;
	private String mrp;
	private String disscount;
	private String purchase_unitcost;
	private String purchage_price;
	private String conversionfactor;
	private String barcode;
	private String excepted_date;
	private String terms_conditions ;
	private String remarks ;
	private String count ;
	private String user_id ;
	private String role_id ;
	private String module_id ;
	private String purchaseOrderNumber;
	private String today_date;
	private String start_date;
	private String search_date;
	private String quotation_date;
	private String userName;

}
//select * from sp_select_search_pms_scm_purchase_order_ref('"+strPurchaseOrderNumber+"','"+strToday+"','"+strStartdate+"','"+dtSearchDate+"')
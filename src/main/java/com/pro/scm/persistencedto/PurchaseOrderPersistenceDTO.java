package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class PurchaseOrderPersistenceDTO {
	private String drugId;
	private String FormId;
	private String batchnumber;
	private String PurchasePrice;
	private String tax;
	private String mrp ;
	private String unitcost;
	private String expireDate ;
	private String receivedStock;
	private String userId;
	private String moduleId;
	private String roleId;
	private String supplierId;
	private String billNo ;
	private String  count;
	private String  totallist;
	private String  freeqty;
	private String unitCostPR;
	private String discount;
	private String po_id;
	private String status;
}

package com.pro.scm.controllerdto;

import lombok.Data;

@Data
public class StockAdjustmentControllerDTO {
private String adjustmentcode;
private String adjustmentDesc;
private String adjustmentType;
private String status;
private String userId;
private String roleId;
private String moduleId;
private String adjustmentId;
}

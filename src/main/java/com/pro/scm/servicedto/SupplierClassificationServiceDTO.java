package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class SupplierClassificationServiceDTO {
private String classification_id;
private String classification_name;
private String classification_description;
private String userId;
private String roleId;
private String moduleId;
private String status;
private String operation_type;
}

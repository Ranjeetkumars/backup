package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class StorepersistenanceDTO {
	private String counterId;
	private String counterName;
	private String counterDesc;
	private String status;
	private String fieldType;
	private String fieldTypeId;
}

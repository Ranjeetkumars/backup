package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class LoadSchedulePersistenceDto {
	
	private String ds_scheduleId;
	private String ds_schduleType;
	private String materialId;
	private String materialGroupName;

}

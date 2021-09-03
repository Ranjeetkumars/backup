package com.pro.scm.persistencedto;

import lombok.Data;

@Data
public class SchedulePeristenanceDTO {
	private String ScheduleName;
	private String userId;
	private String moduleId;
	private String roleId;
	private String status;
	private String scheduleId;
}

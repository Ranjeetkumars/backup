package com.pro.scm.servicedto;

import lombok.Data;

@Data
public class ScheduleServiceDTO {
	private String ScheduleName;
	private String userId;
	private String moduleId;
	private String roleId;
	private String status;
	private String scheduleId;
}

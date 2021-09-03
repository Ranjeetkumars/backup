package com.pro.scm.persistencedto;



import lombok.Data;

@Data
public class ReportPersistenceDTO {
	private String reportId;
	private String rrp_parameter_id;
	private String moduleId;
	private String rrn_id;
	private String rrn_name;
	private String rrn_path_name;
	private String isactive;
	private String moduleName;
}

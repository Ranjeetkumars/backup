package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.ScheduleServiceDTO;

public interface ScheduleService {
	
	public String saveSchedule(ScheduleServiceDTO objScheduleServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public String updateScheduleStores(ScheduleServiceDTO objScheduleServiceDTO, String strRequestID)throws DataNotFoundException;
	
	public List<ScheduleServiceDTO> loadSchedule(String strRequestID)throws DataNotFoundException;
}

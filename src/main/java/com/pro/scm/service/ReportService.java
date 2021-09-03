package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.ReportServiceDTO;

public interface ReportService {

	public List<ReportServiceDTO> getIPFields(ReportServiceDTO dataInfo, String requestID) throws DataNotFoundException;

	public List<ReportServiceDTO> loadReports(ReportServiceDTO dataInfo, String requestID) throws DataNotFoundException;

	public List<ReportServiceDTO> loadModules(String strRequestID) throws DataNotFoundException;

}

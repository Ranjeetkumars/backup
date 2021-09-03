package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.CreatePatientIssueServiceDTO;

public interface CreatePatientIssueService {
	 public List<CreatePatientIssueServiceDTO> getItemsDetails(CreatePatientIssueServiceDTO createPatientIssueServiceDTO,String strRequestID) throws DataNotFoundException;
	 public List<CreatePatientIssueServiceDTO> getAlternateDrugs(String strRequestID) throws DataNotFoundException;
	 public List<CreatePatientIssueServiceDTO> showBatchWiseDrugs(CreatePatientIssueServiceDTO createPatientIssueServiceDTO,String strRequestID) throws DataNotFoundException;
	 public String saveInpatientIssues(CreatePatientIssueServiceDTO createPatientIssueServiceDTO, String strRequestID)throws DataNotFoundException;
	 public String saveInpatientDetails(CreatePatientIssueServiceDTO createPatientIssueServiceDTO, String strRequestID)throws DataNotFoundException;

	 
	 
	
}

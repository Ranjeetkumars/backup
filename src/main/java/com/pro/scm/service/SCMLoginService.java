package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.SCMLoginServiceDto;

/**
* @author  Ranjeet kumar
* @version jdk1.8
* @since   26/07/2019
*/
public interface SCMLoginService {

	 public List<SCMLoginServiceDto> loadRoles(SCMLoginServiceDto scmLoginServiceDto, String strRequestID)throws DataNotFoundException;
	
	 public String getRoles(SCMLoginServiceDto scmLoginServiceDto, String strRequestID)throws DataNotFoundException;
	 
	 public String checkRoleforUser(SCMLoginServiceDto scmLoginServiceDto, String strRequestID)throws DataNotFoundException;
	 
	 public String updateCounterId(SCMLoginServiceDto scmLoginServiceDto, String strRequestID)throws DataNotFoundException;
	
  
	



	



}

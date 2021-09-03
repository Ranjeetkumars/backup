package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.GenericServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;

public interface GenericNameService {
	
	public String saveGenericName(GenericServiceDTO objGenericServiceDTO, String strRequestId)throws DataNotFoundException;
	
	public String updateGenericName(GenericServiceDTO objGenericServiceDTO, String strRequestId)throws DataNotFoundException;
	 public List<GenericServiceDTO>getdrugsName(String strRequestID) throws DataNotFoundException;

	// SELECT dgn_serialid, dgn_genericname,dgn_unic_short_code,dgn_isactive FROM pms_drug_genericname_ref
}

package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.DrugsDetailsBasedOnDrugIdServiceDto;
import com.pro.scm.servicedto.ItemApprovalServiceDto;

public interface ItemApprovalService {
	
	
	
	public List<ItemApprovalServiceDto> getActiveDrugs(ItemApprovalServiceDto serviceDto, String req)throws DataNotFoundException;
	public List<DrugsDetailsBasedOnDrugIdServiceDto> getDrugsDetailsBasedOnDrugId(DrugsDetailsBasedOnDrugIdServiceDto serviceDto, String req)throws DataNotFoundException;

}

package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.LoadUnitServiceDTO;
import com.pro.scm.servicedto.MaterialUnitServiceDTO;

public interface MaterialUnitService {

	public String saveorUpdateMaterialUnit(MaterialUnitServiceDTO objMaterialUnitServiceDTO, String strRequestId)
			throws DataNotFoundException;
	
	public List<LoadUnitServiceDTO> loadUnits(String strRequestId)throws DataNotFoundException;
	
	public List<LoadUnitServiceDTO> loadMaterialForm(String strRequestId)throws DataNotFoundException;
}

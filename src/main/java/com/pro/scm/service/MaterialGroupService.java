package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.MaterialGroupServiceDTO;



public interface MaterialGroupService {
	
	public String saveorUpdateMaterialGroup(MaterialGroupServiceDTO obMaterialGroupServiceDTO, String strRequestId, String operationType)
			throws DataNotFoundException;
	
	public List<MaterialGroupServiceDTO> loadMaterialGroup(String strRequestId)throws DataNotFoundException;
	
	
	public String saveorUpdatePackingVolume(MaterialGroupServiceDTO obMaterialGroupServiceDTO, String strRequestId, String operationType)
			throws DataNotFoundException;
}

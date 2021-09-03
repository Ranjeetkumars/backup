package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;

import com.pro.scm.servicedto.MaterialFormServiceDTO;

public interface MaterialFormService {

	public String saveMaterialForm(MaterialFormServiceDTO objMaterialFormServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String updateMaterialForm(MaterialFormServiceDTO objMaterialFormServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<MaterialFormServiceDTO> loadMaterialForm(String strRequestID) throws DataNotFoundException;

	public List<MaterialFormServiceDTO> loadActiveMatrialGroup(String strRequestID) throws DataNotFoundException;
}

package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.persistencedto.MaterialManufactureServiceDTO;


public interface MaterialManufactureService {

	public String saveManufacture(MaterialManufactureServiceDTO objMaterialManufactureServiceDTO,String strRequestID)throws DataNotFoundException;
	
	public String updateManufacture(MaterialManufactureServiceDTO objMaterialManufactureServiceDTO,String strRequestID)throws DataNotFoundException;
	
	public List<MaterialManufactureServiceDTO> loadMaterialManufacture(String strRequestID)throws DataNotFoundException;
}

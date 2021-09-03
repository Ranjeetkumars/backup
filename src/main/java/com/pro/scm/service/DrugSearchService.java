package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.AlternativeDrugSearchServiceDto;
import com.pro.scm.servicedto.LoadGenericDrugNameServiceDto;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;

public interface DrugSearchService {
	
	public List<PharamacyNewDrugQtyServiceDto> searchDrug(PharamacyNewDrugQtyServiceDto objPharamacyNewDrugQtyServiceDto,String strRequestID) throws DataNotFoundException;

	public String searchDrug(AlternativeDrugSearchServiceDto alternativeDrugSearchServiceDto,String strRequestID) throws DataNotFoundException;
	
	public List<LoadGenericDrugNameServiceDto> loadGenericDrugName(String strRequestID) throws DataNotFoundException;
	
	
	
	
	

}

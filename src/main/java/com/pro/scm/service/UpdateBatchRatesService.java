package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.LoadManufactureServiceDTO;
import com.pro.scm.servicedto.MedicineServiceDTO;

public interface UpdateBatchRatesService {

	public List<MedicineServiceDTO> getAllMedicines(MedicineServiceDTO objMedicineServiceDTO,String strRequestId)throws DataNotFoundException;
	
	public List<LoadManufactureServiceDTO> loadManufacture(String strRequestId)throws DataNotFoundException;
	
	public String updateBatchRates(MedicineServiceDTO objMedicineServiceDTO,String strRequestId)throws DataNotFoundException;
}

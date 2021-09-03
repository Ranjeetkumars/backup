package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.LoadManufactureMapper;

import com.pro.scm.mappers.MedicinesMapper;
import com.pro.scm.persistencedto.LoadManufacturePeristenanceDTO;
import com.pro.scm.persistencedto.MedicineperistenanceDTO;
import com.pro.scm.service.UpdateBatchRatesService;
import com.pro.scm.servicedto.LoadManufactureServiceDTO;
import com.pro.scm.servicedto.MedicineServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objUpdateBatchRatesService")
@SuppressWarnings("unchecked")
public class UpdateBatchRatesServiceImpl implements UpdateBatchRatesService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public List<MedicineServiceDTO> getAllMedicines(MedicineServiceDTO objMedicineServiceDTO, String strRequestId)
			throws DataNotFoundException {
		log.info("getAllMedicines method is executed inside UpdateBatchRatesServiceImpl");
		List<MedicineServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pharmacy_sales_qty(").append("'").append(objMedicineServiceDTO.getGenric_drug_name()).append("'").append(",") 
		     .append(objMedicineServiceDTO.getBrandId()).append(",").append(objMedicineServiceDTO.getFormId()).append(",").append(objMedicineServiceDTO.getManufactureId()).append(",'")
		 .append(objMedicineServiceDTO.getShortCode()).append("',").append(objMedicineServiceDTO.getSystemId()).append(",").append(objMedicineServiceDTO.getGenericGroupId()).append(",")
		  .append(objMedicineServiceDTO.getGenericMoleculeId()).append(",").append(objMedicineServiceDTO.getStoreId()).append(")");
		log.info(strRequestId + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestId + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			MedicinesMapper objMedicinesMapper = new MedicinesMapper();
			List<MedicineperistenanceDTO> objMedicineperistenanceDTO = objMedicinesMapper.conversionForMedicines(list);
			listOfData = objMedicinesMapper.conversionpersistanceDTOtoServiceDTO(objMedicineperistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public List<LoadManufactureServiceDTO> loadManufacture(String strRequestId)
			throws DataNotFoundException {
		log.info("loadManufacture method is executed inside UpdateBatchRatesServiceImpl");
		List<LoadManufactureServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_drugs_manufacture_ref_name_id()");
		log.info(strRequestId + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestId + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadManufactureMapper objLoadManufactureMapper = new LoadManufactureMapper();
			List<LoadManufacturePeristenanceDTO> objLoadManufacturePeristenanceDTO = objLoadManufactureMapper.conversionForManufacture(list);
			listOfData = objLoadManufactureMapper.conversionpersistanceDTOtoServiceDTO(objLoadManufacturePeristenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}

	@Override
	public String updateBatchRates(MedicineServiceDTO objMedicineServiceDTO, String strRequestId)
			throws DataNotFoundException {
		log.info("updateBatchRates method is executed inside UpdateBatchRatesServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_drug_retail_drug_mainstore(").append(objMedicineServiceDTO.getDrugId()).append(",'") 
		     .append(objMedicineServiceDTO.getBatchNumber()).append("',").append(objMedicineServiceDTO.getMrp()).append(",'").append(objMedicineServiceDTO.getExpireDate())
		  .append("',").append(objMedicineServiceDTO.getUnitCost()).append(")");
		log.info(strRequestId + ":::::::::::::" + stringBuilder.toString());
	return objSupervisorDao.saveData(stringBuilder.toString());
	}
}

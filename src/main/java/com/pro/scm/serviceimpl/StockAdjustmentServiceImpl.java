package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.StockAdjustmentMapper;
import com.pro.scm.persistencedto.StockAdjustmentPersistenanceDTO;
import com.pro.scm.service.StockAdjustmentService;
import com.pro.scm.servicedto.StockAdjustmentServiceDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("objStockAdjustmentService")
public class StockAdjustmentServiceImpl implements StockAdjustmentService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public String addAdjustType(StockAdjustmentServiceDTO objStockAdjustmentServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("addAdjustType method is executed inside StockAdjustmentServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_adjustment_ref('").append(objStockAdjustmentServiceDTO.getAdjustmentcode()).append("','")
		.append(objStockAdjustmentServiceDTO.getAdjustmentDesc()).append("','").append(objStockAdjustmentServiceDTO.getAdjustmentType()).append("',").append(objStockAdjustmentServiceDTO.getUserId()).append(",")
		.append(objStockAdjustmentServiceDTO.getModuleId()).append(",").append(objStockAdjustmentServiceDTO.getRoleId()).append(",").append(objStockAdjustmentServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::addAdjustType:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public String updateAdjustType(StockAdjustmentServiceDTO objStockAdjustmentServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("updateAdjustType method is executed inside StockAdjustmentServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_adjustment_ref1('")
		.append(objStockAdjustmentServiceDTO.getAdjustmentcode()).append("','").append(objStockAdjustmentServiceDTO.getAdjustmentDesc()).append("','")
		.append(objStockAdjustmentServiceDTO.getAdjustmentType()).append("',").append(objStockAdjustmentServiceDTO.getStatus()).append(",").append(objStockAdjustmentServiceDTO.getAdjustmentId()).append(")");
		log.info(strRequestID + ":::::::::::::::updateAdjustType:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<StockAdjustmentServiceDTO> loadAdjustTypes(
			String strRequestID)
			throws DataNotFoundException {
		log.info("loadAdjustTypes method is executed inside StockAdjustmentServiceImpl");
		List<StockAdjustmentServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_pms_drug_adjustment_all_data()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			StockAdjustmentMapper objStockAdjustmentMapper = new StockAdjustmentMapper();
			List<StockAdjustmentPersistenanceDTO> objStockAdjustmentPersistenanceDTO = objStockAdjustmentMapper.conversionForStockAdjustment(list);
			listOfData = objStockAdjustmentMapper.conversionpersistanceDTOtoServiceDTO(objStockAdjustmentPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public String adjustmentIsExist(StockAdjustmentServiceDTO objStockAdjustmentServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("adjustmentIsExist method is executed inside StockAdjustmentServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_drug_adjustment_ref('").append(objStockAdjustmentServiceDTO.getAdjustmentcode()).append("')");
		log.info(strRequestID + ":::::::::::::::adjustmentIsExist:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
}

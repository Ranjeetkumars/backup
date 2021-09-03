package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.StockAdjustmentControllerDTO;
import com.pro.scm.persistencedto.StockAdjustmentPersistenanceDTO;
import com.pro.scm.servicedto.StockAdjustmentServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class StockAdjustmentMapper {
	public StockAdjustmentServiceDTO conversionControllerDtoToServiceDto(
			StockAdjustmentControllerDTO objStockAdjustmentControllerDTO) {
		StockAdjustmentServiceDTO objStockAdjustmentServiceDTO = new StockAdjustmentServiceDTO();
		BeanUtils.copyProperties(objStockAdjustmentControllerDTO, objStockAdjustmentServiceDTO);

		return objStockAdjustmentServiceDTO;
	}
	
	
	
	public List<StockAdjustmentControllerDTO> conversionForServiceTOControllerDTO(List<StockAdjustmentServiceDTO> objServicedto) {
		List<StockAdjustmentControllerDTO> objBrandDetailsControllerDTO = new ArrayList<StockAdjustmentControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			StockAdjustmentControllerDTO objBrandDetailsControllerDTO1 = new StockAdjustmentControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<StockAdjustmentServiceDTO> conversionpersistanceDTOtoServiceDTO(List<StockAdjustmentPersistenanceDTO> persistenceDTOs) {
		List<StockAdjustmentServiceDTO> objServicedtos = new ArrayList<StockAdjustmentServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			StockAdjustmentServiceDTO objSearchServiceDto = new StockAdjustmentServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<StockAdjustmentPersistenanceDTO> conversionForStockAdjustment(List<Object[]> list) {
			List<StockAdjustmentPersistenanceDTO> listOfData = new ArrayList<StockAdjustmentPersistenanceDTO>();
			for (Object[] objects : list) {
				StockAdjustmentPersistenanceDTO objPersistenceDTO = new StockAdjustmentPersistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setAdjustmentId(objects[0].toString());
				} else {
					objPersistenceDTO.setAdjustmentId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setAdjustmentcode(objects[1].toString());
				} else {
					objPersistenceDTO.setAdjustmentcode(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
						objPersistenceDTO.setAdjustmentDesc(objects[2].toString());
					} else {
						objPersistenceDTO.setAdjustmentDesc(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setAdjustmentType(objects[3].toString());
					} else {
						objPersistenceDTO.setAdjustmentType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[4] != null) {
						objPersistenceDTO.setStatus(objects[4].toString());
					} else {
						objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

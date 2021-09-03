package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.AdjustmentStockControllerDTO;
import com.pro.scm.persistencedto.AdjustmentStockPersistenceDTO;
import com.pro.scm.servicedto.AdjustmentStockServiceDTO;

import com.pro.scm.utills.CommonConstants;

public class AdjustmentStockMapper {
	public AdjustmentStockServiceDTO conversionControllerDtoToServiceDto(
			AdjustmentStockControllerDTO objAdjustmentStockControllerDto) {
		AdjustmentStockServiceDTO objAdjustmentStockServiceDto = new AdjustmentStockServiceDTO();
		BeanUtils.copyProperties(objAdjustmentStockControllerDto, objAdjustmentStockServiceDto);

		return objAdjustmentStockServiceDto;
	}

	public List<AdjustmentStockControllerDTO> conversionForServiceTOControllerDTO(
			List<AdjustmentStockServiceDTO> objServicedto) {
		List<AdjustmentStockControllerDTO> objAdjustmentStockControllerDto = new ArrayList<AdjustmentStockControllerDTO>();
		objServicedto.forEach(ReportServiceDto -> {
			AdjustmentStockControllerDTO objAdjustmentStockControllerDto1 = new AdjustmentStockControllerDTO();
			BeanUtils.copyProperties(ReportServiceDto, objAdjustmentStockControllerDto1);
			objAdjustmentStockControllerDto.add(objAdjustmentStockControllerDto1);
		});
		return objAdjustmentStockControllerDto;
	}

	public List<AdjustmentStockServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<AdjustmentStockPersistenceDTO> persistenceDTOs) {
		List<AdjustmentStockServiceDTO> objServicedtos = new ArrayList<AdjustmentStockServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			AdjustmentStockServiceDTO objSearchServiceDto = new AdjustmentStockServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	/*
	 * public List<AdjustmentStockPersistenceDTO>
	 * convertObjetsArraytoGetEmployees(List<Object[]> list) {
	 * List<AdjustmentStockPersistenceDTO> listOfData = new
	 * ArrayList<AdjustmentStockPersistenceDTO>(); for (Object[] objects : list) {
	 * AdjustmentStockPersistenceDTO objPersistenceDTO = new
	 * AdjustmentStockPersistenceDTO(); if (objects[0] != null) {
	 * objPersistenceDTO.setUser_id(objects[0].toString()); } else {
	 * objPersistenceDTO.setUser_id(CommonConstants.DATA_NOT_AVIALABLE); } if
	 * (objects[1] != null) { objPersistenceDTO.setUserName(objects[1].toString());
	 * } else { objPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE); }
	 * 
	 * 
	 * listOfData.add(objPersistenceDTO); } return listOfData; }
	 */

	public List<AdjustmentStockPersistenceDTO> convertObjetsArraytoGetEmployees(List<Object[]> list) {
		List<AdjustmentStockPersistenceDTO> listOfData = new ArrayList<AdjustmentStockPersistenceDTO>();
		for (Object[] objects : list) {
			AdjustmentStockPersistenceDTO objPersistenceDTO = new AdjustmentStockPersistenceDTO();

			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[1] != null) {
				objPersistenceDTO.setSupplierId(objects[1].toString());
			} else {
				objPersistenceDTO.setSupplierId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setSupplierName(objects[2].toString());
			} else {
				objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[3] != null) {
				objPersistenceDTO.setPurchage_price(objects[3].toString());
			} else {
				objPersistenceDTO.setPurchage_price(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
			
			
			
		}
		return listOfData;
	}
	
	
	
	
	public List<AdjustmentStockPersistenceDTO> convertObjetsArraytoGetEmployees2(List<Object[]> list) {
		List<AdjustmentStockPersistenceDTO> listOfData = new ArrayList<AdjustmentStockPersistenceDTO>();
		for (Object[] objects : list) {
			AdjustmentStockPersistenceDTO objPersistenceDTO = new AdjustmentStockPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setUser_id(objects[0].toString());
			} else {
				objPersistenceDTO.setUser_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setUserName(objects[1].toString());
			} else {
				objPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 
				
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
}

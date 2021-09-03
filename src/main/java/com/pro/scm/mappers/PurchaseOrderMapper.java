package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;


import com.pro.scm.controllerdto.PurchaseOrderControllerDTO;

import com.pro.scm.persistencedto.PurchaseOrderPersistenceDTO;

import com.pro.scm.servicedto.PurchaseOrderServiceDTO;

public class PurchaseOrderMapper {
	public PurchaseOrderServiceDTO conversionControllerDtoToServiceDto(
			PurchaseOrderControllerDTO objPurchaseOrderControllerDto) {
		PurchaseOrderServiceDTO objPurchaseOrderServiceDto = new PurchaseOrderServiceDTO();
		BeanUtils.copyProperties(objPurchaseOrderControllerDto, objPurchaseOrderServiceDto);

		return objPurchaseOrderServiceDto;
	}
	
	
	
	public List<PurchaseOrderControllerDTO> conversionForServiceTOControllerDTO(List<PurchaseOrderServiceDTO> objServicedto) {
		List<PurchaseOrderControllerDTO> objPurchaseOrderControllerDto = new ArrayList<PurchaseOrderControllerDTO>();
		objServicedto.forEach(PurchaseOrderServiceDto -> {
			PurchaseOrderControllerDTO objPurchaseOrderControllerDto1 = new PurchaseOrderControllerDTO();
			BeanUtils.copyProperties(PurchaseOrderServiceDto, objPurchaseOrderControllerDto1);
			objPurchaseOrderControllerDto.add(objPurchaseOrderControllerDto1);
		});
		return objPurchaseOrderControllerDto;
	}

	public List<PurchaseOrderServiceDTO> conversionpersistanceDTOtoServiceDTO(List<PurchaseOrderPersistenceDTO> persistenceDTOs) {
		List<PurchaseOrderServiceDTO> objServicedtos = new ArrayList<PurchaseOrderServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			PurchaseOrderServiceDTO objSearchServiceDto = new PurchaseOrderServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

		
}

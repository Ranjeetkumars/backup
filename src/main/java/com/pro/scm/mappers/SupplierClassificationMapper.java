package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.SupplierClassificationControllerDTO;
import com.pro.scm.persistencedto.SupplierClassificationPersistenanceDTO;
import com.pro.scm.servicedto.SupplierClassificationServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class SupplierClassificationMapper {
	public SupplierClassificationServiceDTO conversionControllerDtoToServiceDto(
			SupplierClassificationControllerDTO objSupplierClassificationControllerDTO) {
		SupplierClassificationServiceDTO objSupplierClassificationServiceDTO = new SupplierClassificationServiceDTO();
		BeanUtils.copyProperties(objSupplierClassificationControllerDTO, objSupplierClassificationServiceDTO);

		return objSupplierClassificationServiceDTO;
	}
	
	
	
	public List<SupplierClassificationControllerDTO> conversionForServiceTOControllerDTO(List<SupplierClassificationServiceDTO> objServicedto) {
		List<SupplierClassificationControllerDTO> objBrandDetailsControllerDTO = new ArrayList<SupplierClassificationControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			SupplierClassificationControllerDTO objSupplierClassificationControllerDTO1 = new SupplierClassificationControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objSupplierClassificationControllerDTO1);
			objBrandDetailsControllerDTO.add(objSupplierClassificationControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<SupplierClassificationServiceDTO> conversionpersistanceDTOtoServiceDTO(List<SupplierClassificationPersistenanceDTO> persistenceDTOs) {
		List<SupplierClassificationServiceDTO> objServicedtos = new ArrayList<SupplierClassificationServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			SupplierClassificationServiceDTO objSearchServiceDto = new SupplierClassificationServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<SupplierClassificationPersistenanceDTO> conversionForSupplierClassification(List<Object[]> list) {
			List<SupplierClassificationPersistenanceDTO> listOfData = new ArrayList<SupplierClassificationPersistenanceDTO>();
			for (Object[] objects : list) {
				SupplierClassificationPersistenanceDTO objPersistenceDTO = new SupplierClassificationPersistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setClassification_id(objects[0].toString());
				} else {
					objPersistenceDTO.setClassification_id(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setClassification_name(objects[1].toString());
				} else {
					objPersistenceDTO.setClassification_name(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
						objPersistenceDTO.setClassification_description(objects[2].toString());
					} else {
						objPersistenceDTO.setClassification_description(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
					 if(objects[3].toString().equals("true")) {
						 objPersistenceDTO.setStatus("Active");
					 }
					 else {
						 objPersistenceDTO.setStatus("Inactive");
					 }
						
					} else {
						objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

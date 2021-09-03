package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.MedicineControllerDTO;
import com.pro.scm.persistencedto.MedicineperistenanceDTO;
import com.pro.scm.servicedto.MedicineServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class MedicinesMapper {
	public MedicineServiceDTO conversionControllerDtoToServiceDto(
			MedicineControllerDTO objMedicineControllerDTO) {
		MedicineServiceDTO objMedicineServiceDTO = new MedicineServiceDTO();
		BeanUtils.copyProperties(objMedicineControllerDTO, objMedicineServiceDTO);

		return objMedicineServiceDTO;
	}
	
	
	
	public List<MedicineControllerDTO> conversionForServiceTOControllerDTO(List<MedicineServiceDTO> objServicedto) {
		List<MedicineControllerDTO> objBrandDetailsControllerDTO = new ArrayList<MedicineControllerDTO>();
		objServicedto.forEach(MedicineServiceDTO -> {
			MedicineControllerDTO objMedicineControllerDTO1 = new MedicineControllerDTO();
			BeanUtils.copyProperties(MedicineServiceDTO, objMedicineControllerDTO1);
			objBrandDetailsControllerDTO.add(objMedicineControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<MedicineServiceDTO> conversionpersistanceDTOtoServiceDTO(List<MedicineperistenanceDTO> persistenceDTOs) {
		List<MedicineServiceDTO> objServicedtos = new ArrayList<MedicineServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			MedicineServiceDTO objSearchServiceDto = new MedicineServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<MedicineperistenanceDTO> conversionForMedicines(List<Object[]> list) {
			List<MedicineperistenanceDTO> listOfData = new ArrayList<MedicineperistenanceDTO>();
			for (Object[] objects : list) {
				MedicineperistenanceDTO objPersistenceDTO = new MedicineperistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setDrugId(objects[0].toString());
				} else {
					objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setShortCode(objects[1].toString());
				} else {
					objPersistenceDTO.setShortCode(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
						objPersistenceDTO.setDrugName(objects[2].toString());
					} else {
						objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setDrugBrandLang(objects[3].toString());
					} else {
						objPersistenceDTO.setDrugBrandLang(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[4] != null) {
						objPersistenceDTO.setManufactureCompany(objects[4].toString());
					} else {
						objPersistenceDTO.setManufactureCompany(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[5] != null) {
						objPersistenceDTO.setPackingType(objects[5].toString());
					} else {
						objPersistenceDTO.setPackingType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[6] != null) {
						objPersistenceDTO.setBatchNumber(objects[6].toString());
					} else {
						objPersistenceDTO.setBatchNumber(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[7] != null) {
						objPersistenceDTO.setAvailableStock(objects[7].toString());
					} else {
						objPersistenceDTO.setAvailableStock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[8] != null) {
						objPersistenceDTO.setExpireDate(objects[8].toString());
					} else {
						objPersistenceDTO.setExpireDate(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[9] != null) {
						objPersistenceDTO.setMrp(objects[9].toString());
					} else {
						objPersistenceDTO.setMrp(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[10] != null) {
						objPersistenceDTO.setPurchasePrice(objects[10].toString());
					} else {
						objPersistenceDTO.setPurchasePrice(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[11] != null) {
						objPersistenceDTO.setMoleculeType(objects[11].toString());
					} else {
						objPersistenceDTO.setMoleculeType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[12] != null) {
						objPersistenceDTO.setUnitCost(objects[12].toString());
					} else {
						objPersistenceDTO.setUnitCost(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[13] != null) {
						objPersistenceDTO.setFormType(objects[13].toString());
					} else {
						objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[14] != null) {
						objPersistenceDTO.setStrengthType(objects[14].toString());
					} else {
						objPersistenceDTO.setStrengthType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

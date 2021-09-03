package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadUnitControllerDTO;
import com.pro.scm.persistencedto.LoadUnitPeristenanceDTO;
import com.pro.scm.servicedto.LoadUnitServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class LoadUnitMapper {
	public LoadUnitServiceDTO conversionControllerDtoToServiceDto(
			LoadUnitControllerDTO objBrandDetailsControllerDTO) {
		LoadUnitServiceDTO objLoadUnitServiceDTO = new LoadUnitServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objLoadUnitServiceDTO);

		return objLoadUnitServiceDTO;
	}
	
	
	
	public List<LoadUnitControllerDTO> conversionForServiceTOControllerDTO(List<LoadUnitServiceDTO> objServicedto) {
		List<LoadUnitControllerDTO> objLoadUnitControllerDTO = new ArrayList<LoadUnitControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			LoadUnitControllerDTO objBrandDetailsControllerDTO1 = new LoadUnitControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objLoadUnitControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objLoadUnitControllerDTO;
	}

	public List<LoadUnitServiceDTO> conversionpersistanceDTOtoServiceDTO(List<LoadUnitPeristenanceDTO> persistenceDTOs) {
		List<LoadUnitServiceDTO> objServicedtos = new ArrayList<LoadUnitServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			LoadUnitServiceDTO objSearchServiceDto = new LoadUnitServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<LoadUnitPeristenanceDTO> conversionForLoadUnit(List<Object[]> list) {
			List<LoadUnitPeristenanceDTO> listOfData = new ArrayList<LoadUnitPeristenanceDTO>();
			for (Object[] objects : list) {
				LoadUnitPeristenanceDTO objPersistenceDTO = new LoadUnitPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setSerialId(objects[0].toString());
				} else {
					objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setPackingType(objects[1].toString());
				} else {
					objPersistenceDTO.setPackingType(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
						objPersistenceDTO.setConversionFactor(objects[2].toString());
					} else {
						objPersistenceDTO.setConversionFactor(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setFormType(objects[3].toString());
					} else {
						objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				  if (objects[4] != null) {
					  
					  if(objects[4].toString().equalsIgnoreCase("true")) {
						  objPersistenceDTO.setStatus("Active");
					  }
					  else {
						  objPersistenceDTO.setStatus("InActive");
					  }
					 } else {
						objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
	 
	 public List<LoadUnitPeristenanceDTO> conversionForLoadmaterialForm(List<Object[]> list) {
			List<LoadUnitPeristenanceDTO> listOfData = new ArrayList<LoadUnitPeristenanceDTO>();
			for (Object[] objects : list) {
				LoadUnitPeristenanceDTO objPersistenceDTO = new LoadUnitPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setSerialId(objects[0].toString());
				} else {
					objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setFormType(objects[1].toString());
				} else {
					objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
						objPersistenceDTO.setGroupName(objects[2].toString());
					} else {
						objPersistenceDTO.setGroupName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 if (objects[3] != null) {
						objPersistenceDTO.setStatus(objects[3].toString());
					} else {
						objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

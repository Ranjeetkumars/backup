package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.DrugVehicleTypeMappingControllerDTO;
import com.pro.scm.persistencedto.DrugVehicleTypeMappingPersistenanceDTO;
import com.pro.scm.servicedto.DrugVehicleTypeMappingServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class DrugVehicleTypeMappingMapper {
	public DrugVehicleTypeMappingServiceDTO conversionControllerDtoToServiceDto(
			DrugVehicleTypeMappingControllerDTO objBrandDetailsControllerDTO) {
		DrugVehicleTypeMappingServiceDTO objBrandDetailsServiceDTO = new DrugVehicleTypeMappingServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<DrugVehicleTypeMappingControllerDTO> conversionForServiceTOControllerDTO(List<DrugVehicleTypeMappingServiceDTO> objServicedto) {
		List<DrugVehicleTypeMappingControllerDTO> objBrandDetailsControllerDTO = new ArrayList<DrugVehicleTypeMappingControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			DrugVehicleTypeMappingControllerDTO objBrandDetailsControllerDTO1 = new DrugVehicleTypeMappingControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<DrugVehicleTypeMappingServiceDTO> conversionpersistanceDTOtoServiceDTO(List<DrugVehicleTypeMappingPersistenanceDTO> persistenceDTOs) {
		List<DrugVehicleTypeMappingServiceDTO> objServicedtos = new ArrayList<DrugVehicleTypeMappingServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			DrugVehicleTypeMappingServiceDTO objSearchServiceDto = new DrugVehicleTypeMappingServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	 public List<DrugVehicleTypeMappingPersistenanceDTO> conversionForDrugMapping(List<Object[]> list) {
			List<DrugVehicleTypeMappingPersistenanceDTO> listOfData = new ArrayList<DrugVehicleTypeMappingPersistenanceDTO>();
			for (Object[] objects : list) {
				DrugVehicleTypeMappingPersistenanceDTO objPersistenceDTO = new DrugVehicleTypeMappingPersistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setSerialId(objects[0].toString());
				} else {
					objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setDrugName(objects[1].toString());
				} else {
					objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
						objPersistenceDTO.setDrugbrandLang(objects[2].toString());
					} else {
						objPersistenceDTO.setDrugbrandLang(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setShortCode(objects[3].toString());
					} else {
						objPersistenceDTO.setShortCode(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[4] != null) {
						objPersistenceDTO.setFormType(objects[4].toString());
					} else {
						objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[5] != null) {
						objPersistenceDTO.setStrengthType(objects[5].toString());
					} else {
						objPersistenceDTO.setStrengthType(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[6] != null) {
						objPersistenceDTO.setCompanyName(objects[6].toString());
					} else {
						objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
}

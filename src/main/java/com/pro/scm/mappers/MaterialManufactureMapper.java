package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.MaterialManufactureControllerDTO;
import com.pro.scm.persistencedto.MaterialManufactureServiceDTO;
import com.pro.scm.servicedto.MaterialManufacturePersistenanceDTO;
import com.pro.scm.utills.CommonConstants;

public class MaterialManufactureMapper {
	public MaterialManufactureServiceDTO conversionControllerDtoToServiceDto(
			MaterialManufactureControllerDTO objBrandDetailsControllerDTO) {
		MaterialManufactureServiceDTO objLoadUnitServiceDTO = new MaterialManufactureServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objLoadUnitServiceDTO);

		return objLoadUnitServiceDTO;
	}
	
	
	
	public List<MaterialManufactureControllerDTO> conversionForServiceTOControllerDTO(List<MaterialManufactureServiceDTO> objServicedto) {
		List<MaterialManufactureControllerDTO> objLoadUnitControllerDTO = new ArrayList<MaterialManufactureControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			MaterialManufactureControllerDTO objBrandDetailsControllerDTO1 = new MaterialManufactureControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objLoadUnitControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objLoadUnitControllerDTO;
	}

	public List<MaterialManufactureServiceDTO> conversionpersistanceDTOtoServiceDTO(List<MaterialManufacturePersistenanceDTO> persistenceDTOs) {
		List<MaterialManufactureServiceDTO> objServicedtos = new ArrayList<MaterialManufactureServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			MaterialManufactureServiceDTO objSearchServiceDto = new MaterialManufactureServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<MaterialManufacturePersistenanceDTO> conversionForloadManufacture(List<Object[]> list) {
			List<MaterialManufacturePersistenanceDTO> listOfData = new ArrayList<MaterialManufacturePersistenanceDTO>();
			for (Object[] objects : list) {
				MaterialManufacturePersistenanceDTO objPersistenceDTO = new MaterialManufacturePersistenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setManufactureId(objects[0].toString());
				} else {
					objPersistenceDTO.setManufactureId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setManufactureName(objects[1].toString());
				} else {
					objPersistenceDTO.setManufactureName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
					 if(objects[2].toString().equals("true")) {
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
}

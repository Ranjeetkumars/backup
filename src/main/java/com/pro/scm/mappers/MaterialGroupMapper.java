package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.MaterialGroupControllerDTO;
import com.pro.scm.persistencedto.MaterialGrouppersistenanceDTO;
import com.pro.scm.servicedto.MaterialGroupServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class MaterialGroupMapper {
	public MaterialGroupServiceDTO conversionControllerDtoToServiceDto(
			MaterialGroupControllerDTO objBrandDetailsControllerDTO) {
		MaterialGroupServiceDTO objBrandDetailsServiceDTO = new MaterialGroupServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}

	public List<MaterialGroupControllerDTO> conversionForServiceTOControllerDTO(
			List<MaterialGroupServiceDTO> objServicedto) {
		List<MaterialGroupControllerDTO> objBrandDetailsControllerDTO = new ArrayList<MaterialGroupControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			MaterialGroupControllerDTO objBrandDetailsControllerDTO1 = new MaterialGroupControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<MaterialGroupServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<MaterialGrouppersistenanceDTO> persistenceDTOs) {
		List<MaterialGroupServiceDTO> objServicedtos = new ArrayList<MaterialGroupServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			MaterialGroupServiceDTO objSearchServiceDto = new MaterialGroupServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<MaterialGrouppersistenanceDTO> conversionForMaterialGroup(List<Object[]> list) {
		List<MaterialGrouppersistenanceDTO> listOfData = new ArrayList<MaterialGrouppersistenanceDTO>();
		for (Object[] objects : list) {
			MaterialGrouppersistenanceDTO objPersistenceDTO = new MaterialGrouppersistenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setGroupId(objects[0].toString());
			} else {
				objPersistenceDTO.setGroupId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGroupName(objects[1].toString());
			} else {
				objPersistenceDTO.setGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setGroupCode(objects[2].toString());
			} else {
				objPersistenceDTO.setGroupCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {

				if (objects[3].toString().equals("true")) {

					objPersistenceDTO.setStatus("Active");
				} else {
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

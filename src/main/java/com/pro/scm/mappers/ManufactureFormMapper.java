package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.ManufactureFormControllerDTO;
import com.pro.scm.persistencedto.ManufactureFormPersistanceDTO;
import com.pro.scm.servicedto.ManufactureFormServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class ManufactureFormMapper {
	public ManufactureFormServiceDTO conversionControllerDtoToServiceDto(
			ManufactureFormControllerDTO objBrandDetailsControllerDTO) {
		ManufactureFormServiceDTO objManufactureFormServiceDTO = new ManufactureFormServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objManufactureFormServiceDTO);

		return objManufactureFormServiceDTO;
	}

	public List<ManufactureFormControllerDTO> conversionForServiceTOControllerDTO(List<ManufactureFormServiceDTO> objServicedto) {
		List<ManufactureFormControllerDTO> objManufactureFormControllerDTO = new ArrayList<ManufactureFormControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			ManufactureFormControllerDTO brandNameControllerDTO = new ManufactureFormControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, brandNameControllerDTO);
			objManufactureFormControllerDTO.add(brandNameControllerDTO);
		});
		return objManufactureFormControllerDTO;
	}

	public List<ManufactureFormServiceDTO> conversionpersistanceDTOtoServiceDTO(List<ManufactureFormPersistanceDTO> persistenceDTOs) {
		List<ManufactureFormServiceDTO> objServicedtos = new ArrayList<ManufactureFormServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			ManufactureFormServiceDTO objSearchServiceDto = new ManufactureFormServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

    public List<ManufactureFormPersistanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<ManufactureFormPersistanceDTO> listOfData = new ArrayList<ManufactureFormPersistanceDTO>();
		for (Object[] objects : list) {
			ManufactureFormPersistanceDTO objPersistenceDTO = new ManufactureFormPersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setForm_id(objects[0].toString());
			} else {
				objPersistenceDTO.setForm_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setForm_name(objects[1].toString());
			} else {
				objPersistenceDTO.setForm_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

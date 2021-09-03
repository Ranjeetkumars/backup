package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.PharmacyStoreControllerDTO;
import com.pro.scm.persistencedto.PharmacyStorePersistenanceDTO;
import com.pro.scm.servicedto.PharmacyStoreServiceDTO;


public class PharmacyStoreMapper {
	public PharmacyStoreServiceDTO conversionControllerDtoToServiceDto(
			PharmacyStoreControllerDTO objPharmacyStoreControllerDTO) {
		PharmacyStoreServiceDTO objPharmacyStoreServiceDTO = new PharmacyStoreServiceDTO();
		BeanUtils.copyProperties(objPharmacyStoreControllerDTO, objPharmacyStoreServiceDTO);

		return objPharmacyStoreServiceDTO;
	}
	
	
	
	public List<PharmacyStoreControllerDTO> conversionForServiceTOControllerDTO(List<PharmacyStoreServiceDTO> objServicedto) {
		List<PharmacyStoreControllerDTO> objPharmacyStoreControllerDTO = new ArrayList<PharmacyStoreControllerDTO>();
		objServicedto.forEach(PharmacyStoreServiceDTO -> {
			PharmacyStoreControllerDTO objPharmacyStoreControllerDTO1 = new PharmacyStoreControllerDTO();
			BeanUtils.copyProperties(objPharmacyStoreControllerDTO, objPharmacyStoreControllerDTO1);
			objPharmacyStoreControllerDTO.add(objPharmacyStoreControllerDTO1);
		});
		return objPharmacyStoreControllerDTO;
	}

	public List<PharmacyStoreServiceDTO> conversionpersistanceDTOtoServiceDTO(List<PharmacyStorePersistenanceDTO> persistenceDTOs) {
		List<PharmacyStoreServiceDTO> objServicedtos = new ArrayList<PharmacyStoreServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			PharmacyStoreServiceDTO objSearchServiceDto = new PharmacyStoreServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

}

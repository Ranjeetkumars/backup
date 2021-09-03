package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.AddNewLocalDrugControllerDTO;
import com.pro.scm.controllerdto.CentralCloseControllerDTO;
import com.pro.scm.persistencedto.AddNewLocalDrugPersistencesDTO;
import com.pro.scm.persistencedto.CentralClosePersistanceDTO;
import com.pro.scm.servicedto.AddNewLocalDrugServiceDTO;
import com.pro.scm.servicedto.CentralCloseServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class CentralCloseMapper {

	public CentralCloseServiceDTO conversionControllerDtoToServiceDto(
			CentralCloseControllerDTO objAddNewLocalDrugControllerDTO) {
		CentralCloseServiceDTO objAddNewLocalDrugServiceDTO = new CentralCloseServiceDTO();
		BeanUtils.copyProperties(objAddNewLocalDrugControllerDTO, objAddNewLocalDrugServiceDTO);
		return objAddNewLocalDrugServiceDTO;
	}

	public List<CentralCloseControllerDTO> conversionForServiceTOControllerDTO(
			List<CentralCloseServiceDTO> objServicedto) {
		List<CentralCloseControllerDTO> objControllerDto = new ArrayList<CentralCloseControllerDTO>();
		objServicedto.forEach(serviceDto -> {
			CentralCloseControllerDTO objControllerDto1 = new CentralCloseControllerDTO();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<CentralCloseServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<CentralClosePersistanceDTO> persistenceDTOs) {
		List<CentralCloseServiceDTO> objServicedtos = new ArrayList<CentralCloseServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			CentralCloseServiceDTO objSearchServiceDto = new CentralCloseServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

}

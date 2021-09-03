package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.MapDrugToVehicleControllerDTO;
import com.pro.scm.persistencedto.MapDrugToVehiclePersistenanceDTO;
import com.pro.scm.servicedto.MapDrugToVehicleServiceDTO;


public class MapDrugToVehicleMapper {
	public MapDrugToVehicleServiceDTO conversionControllerDtoToServiceDto(
			MapDrugToVehicleControllerDTO objBrandDetailsControllerDTO) {
		MapDrugToVehicleServiceDTO objBrandDetailsServiceDTO = new MapDrugToVehicleServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<MapDrugToVehicleControllerDTO> conversionForServiceTOControllerDTO(List<MapDrugToVehicleServiceDTO> objServicedto) {
		List<MapDrugToVehicleControllerDTO> objBrandDetailsControllerDTO = new ArrayList<MapDrugToVehicleControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			MapDrugToVehicleControllerDTO objBrandDetailsControllerDTO1 = new MapDrugToVehicleControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<MapDrugToVehicleServiceDTO> conversionpersistanceDTOtoServiceDTO(List<MapDrugToVehiclePersistenanceDTO> persistenceDTOs) {
		List<MapDrugToVehicleServiceDTO> objServicedtos = new ArrayList<MapDrugToVehicleServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			MapDrugToVehicleServiceDTO objSearchServiceDto = new MapDrugToVehicleServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
}

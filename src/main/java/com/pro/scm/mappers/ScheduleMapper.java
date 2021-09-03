package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.ScheduleControllerDTO;
import com.pro.scm.persistencedto.SchedulePeristenanceDTO;
import com.pro.scm.servicedto.ScheduleServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class ScheduleMapper {
	public ScheduleServiceDTO conversionControllerDtoToServiceDto(
			ScheduleControllerDTO objScheduleControllerDTO) {
		ScheduleServiceDTO objSupplierServiceDTO = new ScheduleServiceDTO();
		BeanUtils.copyProperties(objScheduleControllerDTO, objSupplierServiceDTO);

		return objSupplierServiceDTO;
	}
	
	
	
	public List<ScheduleControllerDTO> conversionForServiceTOControllerDTO(List<ScheduleServiceDTO> objServicedto) {
		List<ScheduleControllerDTO> objSupplierControllerDTO = new ArrayList<ScheduleControllerDTO>();
		objServicedto.forEach(objVehicleTypeDrugsServiceDTO -> {
			ScheduleControllerDTO objBrandDetailsControllerDTO1 = new ScheduleControllerDTO();
			BeanUtils.copyProperties(objVehicleTypeDrugsServiceDTO, objBrandDetailsControllerDTO1);
			objSupplierControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objSupplierControllerDTO;
	}

	public List<ScheduleServiceDTO> conversionpersistanceDTOtoServiceDTO(List<SchedulePeristenanceDTO> persistenceDTOs) {
		List<ScheduleServiceDTO> objServicedtos = new ArrayList<ScheduleServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			ScheduleServiceDTO objScheduleServiceDTO = new ScheduleServiceDTO();
			BeanUtils.copyProperties(persistence, objScheduleServiceDTO);
			objServicedtos.add(objScheduleServiceDTO);
		});
		return objServicedtos;
	}
	
	public List<SchedulePeristenanceDTO> conversionForLoadSchedules(List<Object[]> list) {
		List<SchedulePeristenanceDTO> listOfData = new ArrayList<SchedulePeristenanceDTO>();
		for (Object[] objects : list) {
			SchedulePeristenanceDTO objPersistenceDTO = new SchedulePeristenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setScheduleId(objects[0].toString());
			} else {
				objPersistenceDTO.setScheduleId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setScheduleName(objects[1].toString());
			} else {
				objPersistenceDTO.setScheduleName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
				 
				 if(objects[2].toString().equalsIgnoreCase("true")) {
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

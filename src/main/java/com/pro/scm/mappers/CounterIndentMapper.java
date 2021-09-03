package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.CounterIndentControllerDTO;
import com.pro.scm.persistencedto.CounterIndentPersistenceDTO;
import com.pro.scm.servicedto.CounterIndentServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class CounterIndentMapper {
	public CounterIndentServiceDTO conversionControllerDtoToServiceDto(
			CounterIndentControllerDTO objAmbToAmbTransferControllerDTO) {
		CounterIndentServiceDTO objCounterIndentServiceDTO = new CounterIndentServiceDTO();
		BeanUtils.copyProperties(objAmbToAmbTransferControllerDTO, objCounterIndentServiceDTO);
		return objCounterIndentServiceDTO;
	}

	public List<CounterIndentControllerDTO> conversionForServiceTOControllerDTO(
			List<CounterIndentServiceDTO> objServicedto) {
		List<CounterIndentControllerDTO> objControllerDto = new ArrayList<CounterIndentControllerDTO>();
		objServicedto.forEach(serviceDto -> {
			CounterIndentControllerDTO objControllerDto1 = new CounterIndentControllerDTO();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<CounterIndentServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<CounterIndentPersistenceDTO> persistenceDTOs) {
		List<CounterIndentServiceDTO> objServicedtos = new ArrayList<CounterIndentServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			CounterIndentServiceDTO objAmbToAmbTransferServiceDTO = new CounterIndentServiceDTO();
			BeanUtils.copyProperties(persistence, objAmbToAmbTransferServiceDTO);
			objServicedtos.add(objAmbToAmbTransferServiceDTO);
		});
		return objServicedtos;
	}
	
	public List<CounterIndentPersistenceDTO> getGenerateRetailIndentNumber(List<?> list) {
		List<CounterIndentPersistenceDTO> listOfData = new ArrayList<CounterIndentPersistenceDTO>();
		for (Object objects : list) {
			CounterIndentPersistenceDTO objPersistenceDTO = new CounterIndentPersistenceDTO();
			if (objects != null) {
				objPersistenceDTO.setMaxIndent(objects.toString());
			} else {
				objPersistenceDTO.setMaxIndent(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<CounterIndentPersistenceDTO> getloadIndentItemsList(List<Object[]> list) {
		List<CounterIndentPersistenceDTO> listOfData = new ArrayList<CounterIndentPersistenceDTO>();
		for (Object[] objects : list) {
			CounterIndentPersistenceDTO objPersistenceDTO = new CounterIndentPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setLir_reqid(objects[0].toString());
			} else {
				objPersistenceDTO.setLir_reqid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setLir_indent_code(objects[1].toString());
			} else {
				objPersistenceDTO.setLir_indent_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setLir_item_id(objects[2].toString());
			} else {
				objPersistenceDTO.setLir_item_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setLir_indent_qty(objects[3].toString());
			} else {
				objPersistenceDTO.setLir_indent_qty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setDr_drug_name(objects[4].toString());
			} else {
				objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setDmr_expire_date(objects[5].toString());
			} else {
				objPersistenceDTO.setDmr_expire_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setShort_code(objects[6].toString());
			} else {
				objPersistenceDTO.setShort_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setBar_code(objects[7].toString());
			} else {
				objPersistenceDTO.setBar_code(CommonConstants.DATA_NOT_AVIALABLE);
			}

			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
}

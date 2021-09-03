package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.CreatePatientIssuesControllerDTO;
import com.pro.scm.persistencedto.CreatePatientIssuesPersistenceDTO;
import com.pro.scm.servicedto.CreatePatientIssueServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class CreatePatientIssueMapper {
	public CreatePatientIssueServiceDTO conversionControllerDtoToServiceDto(
			CreatePatientIssuesControllerDTO createPatientIssuesControllerDTO) {
		CreatePatientIssueServiceDTO createPatientIssueServiceDTO = new CreatePatientIssueServiceDTO();
		BeanUtils.copyProperties(createPatientIssuesControllerDTO, createPatientIssueServiceDTO);
		return createPatientIssueServiceDTO;
	}

	public List<CreatePatientIssuesControllerDTO> conversionForServiceTOControllerDTO(
			List<CreatePatientIssueServiceDTO> objServicedto) {
		List<CreatePatientIssuesControllerDTO> createPatientIssuesControllerDTO = new ArrayList<CreatePatientIssuesControllerDTO>();
		objServicedto.forEach(serviceDto -> {
			CreatePatientIssuesControllerDTO objControllerDto1 = new CreatePatientIssuesControllerDTO();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			createPatientIssuesControllerDTO.add(objControllerDto1);
		});
		return createPatientIssuesControllerDTO;
	}

	public List<CreatePatientIssueServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<CreatePatientIssuesPersistenceDTO> createPatientIssuesPersistenceDTO) {
		List<CreatePatientIssueServiceDTO> createPatientIssueServiceDTO = new ArrayList<CreatePatientIssueServiceDTO>();
		createPatientIssuesPersistenceDTO.forEach(persistence -> {
			CreatePatientIssueServiceDTO objCreatePatientIssueServiceDTO = new CreatePatientIssueServiceDTO();
			BeanUtils.copyProperties(persistence, objCreatePatientIssueServiceDTO);
			createPatientIssueServiceDTO.add(objCreatePatientIssueServiceDTO);
		});
		return createPatientIssueServiceDTO;
	}
	
	public List<CreatePatientIssuesPersistenceDTO> getItemsDetails(List<Object[]> list) {
		List<CreatePatientIssuesPersistenceDTO> listOfData = new ArrayList<CreatePatientIssuesPersistenceDTO>();
		for (Object[] objects : list) {
			CreatePatientIssuesPersistenceDTO objPersistenceDTO = new CreatePatientIssuesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setShort_unic_code(objects[2].toString());
			} else {
				objPersistenceDTO.setShort_unic_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setStrength_type(objects[3].toString());
			} else {
				objPersistenceDTO.setStrength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setGenericname(objects[4].toString());
			} else {
				objPersistenceDTO.setGenericname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setBatch_number(objects[5].toString());
			} else {
				objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setExpire_date(objects[6].toString());
			} else {
				objPersistenceDTO.setExpire_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setAvailable_stock(objects[7].toString());
			} else {
				objPersistenceDTO.setAvailable_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setUnit_cost(objects[8].toString());
			} else {
				objPersistenceDTO.setUnit_cost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setForm_type(objects[9].toString());
			} else {
				objPersistenceDTO.setForm_type(CommonConstants.DATA_NOT_AVIALABLE);
			}

			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<CreatePatientIssuesPersistenceDTO> getAlternateDrugs(List<Object[]> list) {
		List<CreatePatientIssuesPersistenceDTO> listOfData = new ArrayList<CreatePatientIssuesPersistenceDTO>();
		for (Object[] objects : list) {
			CreatePatientIssuesPersistenceDTO objPersistenceDTO = new CreatePatientIssuesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setShort_unic_code(objects[2].toString());
			} else {
				objPersistenceDTO.setShort_unic_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setBatch_number(objects[3].toString());
			} else {
				objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setAvailable_stock(objects[4].toString());
			} else {
				objPersistenceDTO.setAvailable_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<CreatePatientIssuesPersistenceDTO> showBatchWiseDrugs(List<Object[]> list) {
		List<CreatePatientIssuesPersistenceDTO> listOfData = new ArrayList<CreatePatientIssuesPersistenceDTO>();
		for (Object[] objects : list) {
			CreatePatientIssuesPersistenceDTO objPersistenceDTO = new CreatePatientIssuesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugid(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setUnicode(objects[1].toString());
			} else {
				objPersistenceDTO.setUnicode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrug_name(objects[2].toString());
			} else {
				objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setBatch_number(objects[3].toString());
			} else {
				objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setExpire_date(objects[4].toString());
			} else {
				objPersistenceDTO.setExpire_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setAvailable_stock(objects[5].toString());
			} else {
				objPersistenceDTO.setAvailable_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setUnit_cost(objects[6].toString());
			} else {
				objPersistenceDTO.setUnit_cost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
}

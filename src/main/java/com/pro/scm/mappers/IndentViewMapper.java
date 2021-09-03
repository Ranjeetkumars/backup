package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.IndentViewControllerDTO;

import com.pro.scm.persistencedto.IndentViewPersistenceDTO;
import com.pro.scm.servicedto.IndentViewServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class IndentViewMapper {
	public IndentViewServiceDTO conversionControllerDtoToServiceDto(
			IndentViewControllerDTO objAmbToAmbTransferControllerDTO) {
		IndentViewServiceDTO objIndentViewServiceDTO = new IndentViewServiceDTO();
		BeanUtils.copyProperties(objAmbToAmbTransferControllerDTO, objIndentViewServiceDTO);
		return objIndentViewServiceDTO;
	}

	public List<IndentViewControllerDTO> conversionForServiceTOControllerDTO(
			List<IndentViewServiceDTO> objServicedto) {
		List<IndentViewControllerDTO> objControllerDto = new ArrayList<IndentViewControllerDTO>();
		objServicedto.forEach(serviceDto -> {
			IndentViewControllerDTO objControllerDto1 = new IndentViewControllerDTO();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<IndentViewServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<IndentViewPersistenceDTO> persistenceDTOs) {
		List<IndentViewServiceDTO> objServicedtos = new ArrayList<IndentViewServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			IndentViewServiceDTO objIndentViewServiceDTO= new IndentViewServiceDTO();
			BeanUtils.copyProperties(persistence, objIndentViewServiceDTO);
			objServicedtos.add(objIndentViewServiceDTO);
		});
		return objServicedtos;
	}
	
	public List<IndentViewPersistenceDTO> load_to_store(List<Object[]> list) {
		List<IndentViewPersistenceDTO> listOfData = new ArrayList<IndentViewPersistenceDTO>();
		for (Object[] objects : list) {
			IndentViewPersistenceDTO objPersistenceDTO = new IndentViewPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setCounterId(objects[0].toString());
			} else {
				objPersistenceDTO.setCounterId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setCounterName(objects[1].toString());
			} else {
				objPersistenceDTO.setCounterName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<IndentViewPersistenceDTO> getLoadMainStoreDrugs(List<Object[]> list) {
		List<IndentViewPersistenceDTO> listOfData = new ArrayList<IndentViewPersistenceDTO>();
		for (Object[] objects : list) {
			IndentViewPersistenceDTO objPersistenceDTO = new IndentViewPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugid(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDb_drug_brand_lang1(objects[1].toString());
			} else {
				objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setForm_type(objects[2].toString());
			} else {
				objPersistenceDTO.setForm_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setDr_strength_type(objects[3].toString());
			} else {
				objPersistenceDTO.setDr_strength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setBatchnumber(objects[4].toString());
			} else {
				objPersistenceDTO.setBatchnumber(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setExpdate(objects[5].toString());
			} else {
				objPersistenceDTO.setExpdate(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[6] != null) {
				objPersistenceDTO.setMrp(objects[6].toString());
			} else {
				objPersistenceDTO.setMrp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setPurchaseprice(objects[7].toString());
			} else {
				objPersistenceDTO.setPurchaseprice(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setRecived_stock(objects[8].toString());
			} else {
				objPersistenceDTO.setRecived_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setAvailable_stock(objects[9].toString());
			} else {
				objPersistenceDTO.setAvailable_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setDmr_pack_id(objects[10].toString());
			} else {
				objPersistenceDTO.setDmr_pack_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
}

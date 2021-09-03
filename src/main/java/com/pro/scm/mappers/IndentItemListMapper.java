package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;


import com.pro.scm.controllerdto.IndentItemListControllerDTO;
import com.pro.scm.persistencedto.IndentItemListPersistenceDTO;
import com.pro.scm.servicedto.IndentItemListServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class IndentItemListMapper {

	public IndentItemListServiceDTO conversionControllerDtoToServiceDto(
			IndentItemListControllerDTO objAmbToAmbTransferControllerDTO) {
		IndentItemListServiceDTO objIndentItemListServiceDTO = new IndentItemListServiceDTO();
		BeanUtils.copyProperties(objAmbToAmbTransferControllerDTO, objIndentItemListServiceDTO);
		return objIndentItemListServiceDTO;
	}

	public List<IndentItemListControllerDTO> conversionForServiceTOControllerDTO(
			List<IndentItemListServiceDTO> objServicedto) {
		List<IndentItemListControllerDTO> objControllerDto = new ArrayList<IndentItemListControllerDTO>();
		objServicedto.forEach(serviceDto -> {
			IndentItemListControllerDTO objControllerDto1 = new IndentItemListControllerDTO();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<IndentItemListServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<IndentItemListPersistenceDTO> persistenceDTOs) {
		List<IndentItemListServiceDTO> objServicedtos = new ArrayList<IndentItemListServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			IndentItemListServiceDTO objIndentItemListServiceDTO= new IndentItemListServiceDTO();
			BeanUtils.copyProperties(persistence, objIndentItemListServiceDTO);
			objServicedtos.add(objIndentItemListServiceDTO);
		});
		return objServicedtos;
	}
	
	public List<IndentItemListPersistenceDTO> getloadLocalIndentIssuedDetails(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrug_name(objects[0].toString());
			} else {
				objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setBatch_number(objects[1].toString());
			} else {
				objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setRecived_stock(objects[2].toString());
			} else {
				objPersistenceDTO.setRecived_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setCountername(objects[3].toString());
			} else {
				objPersistenceDTO.setCountername(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
	
	
	
	public List<IndentItemListPersistenceDTO> arryObjectToPersistenceDtoForIndentRisedStatus(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrug_id(objects[0].toString());
			} else {
				objPersistenceDTO.setDrug_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setBatch_number(objects[1].toString());
			} else {
				objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setStatus(objects[2].toString());
			} else {
				objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List<IndentItemListPersistenceDTO> getloadIndentRaisedItems(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setItem_id(objects[0].toString());
			} else {
				objPersistenceDTO.setItem_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrug_brand_lang1(objects[2].toString());
			} else {
				objPersistenceDTO.setDrug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setGroup_molecules_type_lang1(objects[3].toString());
			} else {
				objPersistenceDTO.setGroup_molecules_type_lang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setShort_unic_code(objects[4].toString());
			} else {
				objPersistenceDTO.setShort_unic_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setForm_type(objects[5].toString());
			} else {
				objPersistenceDTO.setForm_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setStrength_type(objects[6].toString());
			} else {
				objPersistenceDTO.setStrength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setCompanyname(objects[7].toString());
			} else {
				objPersistenceDTO.setCompanyname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setIndent_qty(objects[8].toString());
			} else {
				objPersistenceDTO.setIndent_qty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setBarcode(objects[9].toString());
			} else {
				objPersistenceDTO.setBarcode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setTo_store_id(objects[10].toString());
			} else {
				objPersistenceDTO.setTo_store_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[11] != null) {
				objPersistenceDTO.setAvailableqty(objects[11].toString());
			} else {
				objPersistenceDTO.setAvailableqty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[12] != null) {
				objPersistenceDTO.setDdr_rackname(objects[12].toString());
			} else {
				objPersistenceDTO.setDdr_rackname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[13] != null) {
				objPersistenceDTO.setDds_selfname(objects[13].toString());
			} else {
				objPersistenceDTO.setDds_selfname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<IndentItemListPersistenceDTO> loadAvailableQty(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setAvailable_stock(objects[0].toString());
			} else {
				objPersistenceDTO.setAvailable_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setExpire_date(objects[1].toString());
			} else {
				objPersistenceDTO.setExpire_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setPurchase_price(objects[2].toString());
			} else {
				objPersistenceDTO.setPurchase_price(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setMrp(objects[3].toString());
			} else {
				objPersistenceDTO.setMrp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setUnitCost(objects[4].toString());
			} else {
				objPersistenceDTO.setUnitCost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<IndentItemListPersistenceDTO> loadBatchNumber(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialid(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setBatch_number(objects[1].toString());
			} else {
				objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<IndentItemListPersistenceDTO> getTemplate(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setTemplateId(objects[0].toString());
			} else {
				objPersistenceDTO.setTemplateId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setTemplateType(objects[1].toString());
			} else {
				objPersistenceDTO.setTemplateType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<IndentItemListPersistenceDTO> loadIndentRaisedSearch(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setIndent_code(objects[0].toString());
			} else {
				objPersistenceDTO.setIndent_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setCreatedbydtm(objects[1].toString());
			} else {
				objPersistenceDTO.setCreatedbydtm(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setRetailer_counter_name(objects[2].toString());
			} else {
				objPersistenceDTO.setRetailer_counter_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setStore_countername(objects[3].toString());
			} else {
				objPersistenceDTO.setStore_countername(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setIndent_status_type(objects[4].toString());
			} else {
				objPersistenceDTO.setIndent_status_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setUsername(objects[5].toString());
			} else {
				objPersistenceDTO.setUsername(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setTocounterId(objects[6].toString());
			} else {
				objPersistenceDTO.setTocounterId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setFromCounterid(objects[7].toString());
			} else {
				objPersistenceDTO.setFromCounterid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<IndentItemListPersistenceDTO> loadIndentStatus(List<Object[]> list) {
		List<IndentItemListPersistenceDTO> listOfData = new ArrayList<IndentItemListPersistenceDTO>();
		for (Object[] objects : list) {
			IndentItemListPersistenceDTO objPersistenceDTO = new IndentItemListPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setIndentStatus(objects[0].toString());
			} else {
				objPersistenceDTO.setIndentStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setIndent_status_type(objects[1].toString());
			} else {
				objPersistenceDTO.setIndent_status_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
}

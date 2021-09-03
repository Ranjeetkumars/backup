package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.AmbToAmbTransferControllerDTO;
import com.pro.scm.persistencedto.AmbToAmbTransferPersistenceDTO;
import com.pro.scm.servicedto.AcceptTransferItemsServiceDto;
import com.pro.scm.servicedto.AmbToAmbTransferServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class AmbToAmbTransferMapper {
	
	
	//AcceptTransferItemsServiceDto
	
	
	public AmbToAmbTransferServiceDTO conversionControllerDtoToServiceDto(AmbToAmbTransferControllerDTO objAmbToAmbTransferControllerDTO) {
		
		AmbToAmbTransferServiceDTO objAmbToAmbTransferServiceDTO = new AmbToAmbTransferServiceDTO();
		BeanUtils.copyProperties(objAmbToAmbTransferControllerDTO, objAmbToAmbTransferServiceDTO);
		return objAmbToAmbTransferServiceDTO;
	}

	
	
	
	
	
	
public AcceptTransferItemsServiceDto conversionControllerDtoToServiceDtoForAcceptTransferItem(AmbToAmbTransferControllerDTO objAmbToAmbTransferControllerDTO) {
	AcceptTransferItemsServiceDto objAmbToAmbTransferServiceDTO = new AcceptTransferItemsServiceDto();
		BeanUtils.copyProperties(objAmbToAmbTransferControllerDTO, objAmbToAmbTransferServiceDTO);
		return objAmbToAmbTransferServiceDTO;
	}
	
	
	public List<AmbToAmbTransferControllerDTO> conversionForServiceTOControllerDTO(
			List<AmbToAmbTransferServiceDTO> objServicedto) {
		List<AmbToAmbTransferControllerDTO> objControllerDto = new ArrayList<AmbToAmbTransferControllerDTO>();
		objServicedto.forEach(serviceDto -> {
			AmbToAmbTransferControllerDTO objControllerDto1 = new AmbToAmbTransferControllerDTO();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<AmbToAmbTransferServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<AmbToAmbTransferPersistenceDTO> persistenceDTOs) {
		List<AmbToAmbTransferServiceDTO> objServicedtos = new ArrayList<AmbToAmbTransferServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			AmbToAmbTransferServiceDTO objAmbToAmbTransferServiceDTO = new AmbToAmbTransferServiceDTO();
			BeanUtils.copyProperties(persistence, objAmbToAmbTransferServiceDTO);
			objServicedtos.add(objAmbToAmbTransferServiceDTO);
		});
		return objServicedtos;
	}
	
	public List<AmbToAmbTransferPersistenceDTO> getloadVehicleItems(List<Object[]> list) {
		List<AmbToAmbTransferPersistenceDTO> listOfData = new ArrayList<AmbToAmbTransferPersistenceDTO>();
		for (Object[] objects : list) {
			AmbToAmbTransferPersistenceDTO objPersistenceDTO = new AmbToAmbTransferPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDr_short_unic_code(objects[0].toString());
			} else {
				objPersistenceDTO.setDr_short_unic_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDr_drug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrr_batch_number(objects[2].toString());
			} else {
				objPersistenceDTO.setDrr_batch_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setPt_packing_type(objects[3].toString());
			} else {
				objPersistenceDTO.setPt_packing_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setDrr_expire_date(objects[4].toString());
			} else {
				objPersistenceDTO.setDrr_expire_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setDrr_available_stock(objects[5].toString());
			} else {
				objPersistenceDTO.setDrr_available_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setDrr_drug_id(objects[6].toString());
			} else {
				objPersistenceDTO.setDrr_drug_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setDrr_purchase_price(objects[7].toString());
			} else {
				objPersistenceDTO.setDrr_purchase_price(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setDrr_mrp(objects[8].toString());
			} else {
				objPersistenceDTO.setDrr_mrp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setDrr_unit_cost(objects[9].toString());
			} else {
				objPersistenceDTO.setDrr_unit_cost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AmbToAmbTransferPersistenceDTO> getloadVehicleReqAmbItems(List<Object[]> list) {
		List<AmbToAmbTransferPersistenceDTO> listOfData = new ArrayList<AmbToAmbTransferPersistenceDTO>();
		for (Object[] objects : list) {
			AmbToAmbTransferPersistenceDTO objPersistenceDTO = new AmbToAmbTransferPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDr_short_unic_code(objects[0].toString());
			} else {
				objPersistenceDTO.setDr_short_unic_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDr_drug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrr_available_stock(objects[2].toString());
			} else {
				objPersistenceDTO.setDrr_available_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setDrr_drug_id(objects[3].toString());
			} else {
				objPersistenceDTO.setDrr_drug_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AmbToAmbTransferPersistenceDTO> getAllCounterMedicines(List<Object[]> list) {
		List<AmbToAmbTransferPersistenceDTO> listOfData = new ArrayList<AmbToAmbTransferPersistenceDTO>();
		for (Object[] objects : list) {
			AmbToAmbTransferPersistenceDTO objPersistenceDTO = new AmbToAmbTransferPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrr_drug_id(objects[0].toString());
			} else {
				objPersistenceDTO.setDrr_drug_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGeneric_drug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setGeneric_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDb_drug_brand_lang1(objects[2].toString());
			} else {
				objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setGroup_molecules_type_lang1(objects[3].toString());
			} else {
				objPersistenceDTO.setGroup_molecules_type_lang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setDr_short_unic_code(objects[4].toString());
			} else {
				objPersistenceDTO.setDr_short_unic_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setDf_form_type(objects[5].toString());
			} else {
				objPersistenceDTO.setDf_form_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setDr_strength_type(objects[6].toString());
			} else {
				objPersistenceDTO.setDr_strength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setMa_companyname(objects[7].toString());
			} else {
				objPersistenceDTO.setMa_companyname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setDrr_available_stock(objects[8].toString());
			} else {
				objPersistenceDTO.setDrr_available_stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
				
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
	public List<AmbToAmbTransferPersistenceDTO> getRetailIndentDetails(List<Object[]> list) {
		List<AmbToAmbTransferPersistenceDTO> listOfData = new ArrayList<AmbToAmbTransferPersistenceDTO>();
		for (Object[] objects : list) {
			AmbToAmbTransferPersistenceDTO objPersistenceDTO = new AmbToAmbTransferPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrr_drug_id(objects[0].toString());
			} else {
				objPersistenceDTO.setDrr_drug_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDr_drug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDb_drug_brand_lang1(objects[2].toString());
			} else {
				objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setDr_short_unic_code(objects[3].toString());
			} else {
				objPersistenceDTO.setDr_short_unic_code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setDf_form_type(objects[4].toString());
			} else {
				objPersistenceDTO.setDf_form_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setDr_strength_type(objects[5].toString());
			} else {
				objPersistenceDTO.setDr_strength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setPdt_quantity(objects[6].toString());
			} else {
				objPersistenceDTO.setPdt_quantity(CommonConstants.DATA_NOT_AVIALABLE);
			}
					
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
}

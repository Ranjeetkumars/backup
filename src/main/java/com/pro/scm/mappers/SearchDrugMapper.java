package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.PharmacyNewDrugQtyControllerDto;
import com.pro.scm.persistencedto.PharamacyNewDrugQtyPersistanceDto;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.utills.CommonConstants;


public class SearchDrugMapper {

	
	public PharamacyNewDrugQtyServiceDto conversionControllerDtoToServiceDto(
			PharmacyNewDrugQtyControllerDto objPharmacyNewDrugQtyControllerDto) {
		PharamacyNewDrugQtyServiceDto objPharamacyNewDrugQtyServiceDto = new PharamacyNewDrugQtyServiceDto();
		BeanUtils.copyProperties(objPharmacyNewDrugQtyControllerDto, objPharamacyNewDrugQtyServiceDto);

		return objPharamacyNewDrugQtyServiceDto;
	}
	
	
	
	public List<PharmacyNewDrugQtyControllerDto> conversionForServiceTOControllerDTO(List<PharamacyNewDrugQtyServiceDto> objServicedto) {
		List<PharmacyNewDrugQtyControllerDto> objPharmacyNewDrugQtyControllerDto = new ArrayList<PharmacyNewDrugQtyControllerDto>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			PharmacyNewDrugQtyControllerDto objobjPharmacyNewDrugQtyControllerDto1 = new PharmacyNewDrugQtyControllerDto();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objobjPharmacyNewDrugQtyControllerDto1);
			objPharmacyNewDrugQtyControllerDto.add(objobjPharmacyNewDrugQtyControllerDto1);
		});
		return objPharmacyNewDrugQtyControllerDto;
	}

	public List<PharamacyNewDrugQtyServiceDto> conversionpersistanceDTOtoServiceDTO(List<PharamacyNewDrugQtyPersistanceDto> persistenceDTOs) {
		List<PharamacyNewDrugQtyServiceDto> objServicedtos = new ArrayList<PharamacyNewDrugQtyServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			PharamacyNewDrugQtyServiceDto objSearchServiceDto = new PharamacyNewDrugQtyServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<PharamacyNewDrugQtyPersistanceDto> ConvertDataOfSearchDrug(List<Object[]> list) {
		List<PharamacyNewDrugQtyPersistanceDto> listOfData = new ArrayList<PharamacyNewDrugQtyPersistanceDto>();
		for (Object[] objects : list) {
			PharamacyNewDrugQtyPersistanceDto objPersistenceDTO = new PharamacyNewDrugQtyPersistanceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDmrDrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setDmrDrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setDrDrugName(objects[1].toString());
			} else {
				objPersistenceDTO.setDrDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setDbDrugBrandLang1(objects[2].toString());
				} else {
					objPersistenceDTO.setDbDrugBrandLang1(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setDgmGroupMoleculesTypeLang1(objects[3].toString());
				} else {
					objPersistenceDTO.setDgmGroupMoleculesTypeLang1(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[4] != null) {
					objPersistenceDTO.setDrShortUniCode(objects[4].toString());
				} else {
					objPersistenceDTO.setDrShortUniCode(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[5] != null) {
					objPersistenceDTO.setDfFormType(objects[5].toString());
				} else {
					objPersistenceDTO.setDfFormType(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[6] != null) {
					objPersistenceDTO.setDrStrengthType(objects[6].toString());
				} else {
					objPersistenceDTO.setDrStrengthType(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[7] != null) {
					objPersistenceDTO.setMaCompanyName(objects[7].toString());
				} else {
					objPersistenceDTO.setMaCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[8] != null) {
					objPersistenceDTO.setDmrAvailableStock(objects[8].toString());
				} else {
					objPersistenceDTO.setDmrAvailableStock(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	
	
}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.DrugAndSupplierMappingControllerDto;
import com.pro.scm.persistencedto.DrugAndSupplierMappingPersistenceDto;
import com.pro.scm.servicedto.DrugAndSupplierMappingServiceDto;
import com.pro.scm.utills.CommonConstants;

public class DrugAndSupplierMappingMapper {
	
	
	
	
	
	
public  DrugAndSupplierMappingServiceDto converControllerToServiceDTO(DrugAndSupplierMappingControllerDto controllerDto) {
		
	DrugAndSupplierMappingServiceDto serviceDto = new DrugAndSupplierMappingServiceDto();
		BeanUtils.copyProperties(controllerDto, serviceDto);
		return serviceDto;
		
	}
	
	
	public List<DrugAndSupplierMappingControllerDto> conversionForServiceTOControllerDTO(
			List<DrugAndSupplierMappingServiceDto> objServicedto) {
		List<DrugAndSupplierMappingControllerDto> objControllerDto = new ArrayList<DrugAndSupplierMappingControllerDto>();
		objServicedto.forEach(serviceDto -> {
			DrugAndSupplierMappingControllerDto objControllerDto1 = new DrugAndSupplierMappingControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}
	
	public List<DrugAndSupplierMappingServiceDto> conversionpersistanceDTOtoServiceDTO(List<DrugAndSupplierMappingPersistenceDto> persistenceDTOs) {
		List<DrugAndSupplierMappingServiceDto> objServicedtos = new ArrayList<DrugAndSupplierMappingServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			DrugAndSupplierMappingServiceDto objSearchServiceDto = new DrugAndSupplierMappingServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	
	public List<DrugAndSupplierMappingPersistenceDto> settingDataIntoPersistenceDtoForlistloadSuppliers(List<Object[]> list) {
		List<DrugAndSupplierMappingPersistenceDto> listOfData = new ArrayList<DrugAndSupplierMappingPersistenceDto>();
		for (Object[] objects : list) {
			DrugAndSupplierMappingPersistenceDto objPersistenceDTO = new DrugAndSupplierMappingPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setSupplierId(objects[0].toString());
			} else {
				objPersistenceDTO.setSupplierId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setSupplierName(objects[1].toString());
			} else {
				objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
			}
          listOfData.add(objPersistenceDTO);
		}

		return listOfData;
	}
//

	

	public List<DrugAndSupplierMappingPersistenceDto> settingDataIntoPersistenceDtoForLoadMappedDrugs(List<Object[]> list) {
		List<DrugAndSupplierMappingPersistenceDto> listOfData = new ArrayList<DrugAndSupplierMappingPersistenceDto>();
		for (Object[] objects : list) {
			DrugAndSupplierMappingPersistenceDto objPersistenceDTO = new DrugAndSupplierMappingPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setUnicCode(objects[1].toString());
			} else {
				objPersistenceDTO.setUnicCode(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[2] != null) {
				objPersistenceDTO.setDrugName(objects[2].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setDrugBarndlang1(objects[3].toString());
			} else {
				objPersistenceDTO.setDrugBarndlang1(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setFromType(objects[4].toString());
			} else {
				objPersistenceDTO.setFromType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setStrength(objects[5].toString());
			} else {
				objPersistenceDTO.setStrength(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[6] != null) {
				objPersistenceDTO.setCompanyname(objects[6].toString());
			} else {
				objPersistenceDTO.setCompanyname(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setMoleculesType(objects[7].toString());
			} else {
				objPersistenceDTO.setMoleculesType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			
			
			
			if (objects[8] != null) {
				objPersistenceDTO.setPurchageprice(objects[8].toString());
			} else {
				objPersistenceDTO.setPurchageprice(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setPurchageunitcost(objects[9].toString());
			} else {
				objPersistenceDTO.setPurchageunitcost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setMrp(objects[10].toString());
			} else {
				objPersistenceDTO.setMrp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[11] != null) {
				objPersistenceDTO.setUnitcost(objects[11].toString());
			} else {
				objPersistenceDTO.setUnitcost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[12] != null) {
				objPersistenceDTO.setVatpercentag(objects[12].toString());
			} else {
				objPersistenceDTO.setVatpercentag(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[13] != null) {
				objPersistenceDTO.setDiscount(objects[13].toString());
			} else {
				objPersistenceDTO.setDiscount(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[14] != null) {
				objPersistenceDTO.setStartdate(objects[14].toString());
			} else {
				objPersistenceDTO.setStartdate(CommonConstants.DATA_NOT_AVIALABLE);
			}
          listOfData.add(objPersistenceDTO);
		}

		return listOfData;
	}
}

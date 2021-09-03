package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.ListOfLoadSuppliersControllerDto;

import com.pro.scm.persistencedto.ListOfLoadSuppliersPersistenceDto;

import com.pro.scm.servicedto.ListOfLoadSuppliersServiceDto;
import com.pro.scm.servicedto.SCMLoginServiceDto;
import com.pro.scm.utills.CommonConstants;

public class ListOfLoadSuppliersMapper {
	
	
	public SCMLoginServiceDto conversionControllerDtoToServiceDto(ListOfLoadSuppliersControllerDto scmLoginControllerDto) {
		SCMLoginServiceDto scmLoginServiceDto = new SCMLoginServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<ListOfLoadSuppliersControllerDto> conversionForServiceTOControllerDTO(List<ListOfLoadSuppliersServiceDto> loadStoresServiceDtos) {
		List<ListOfLoadSuppliersControllerDto> objControllerDto = new ArrayList<ListOfLoadSuppliersControllerDto>();
		loadStoresServiceDtos.forEach(serviceDto -> {
			ListOfLoadSuppliersControllerDto objControllerDto1 = new ListOfLoadSuppliersControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<ListOfLoadSuppliersServiceDto> conversionpersistanceDTOtoServiceDTO(List<ListOfLoadSuppliersPersistenceDto> persistenceDTOs) {
		List<ListOfLoadSuppliersServiceDto> objServicedtos = new ArrayList<ListOfLoadSuppliersServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			ListOfLoadSuppliersServiceDto objSearchServiceDto = new ListOfLoadSuppliersServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	 public List<ListOfLoadSuppliersPersistenceDto> settingDataIntoListOfLoadSuppliersPersistenceDto(List<Object[]> list) {
		List<ListOfLoadSuppliersPersistenceDto> listOfData = new ArrayList<ListOfLoadSuppliersPersistenceDto>();
		for (Object[] objects : list) {
			ListOfLoadSuppliersPersistenceDto objPersistenceDTO = new ListOfLoadSuppliersPersistenceDto();
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
      
     
	 public List<ListOfLoadSuppliersPersistenceDto> settingDataIntoListOfLoadSuppliersPersistenceDtoforloadSuppliers(List<Object[]> list) {
			List<ListOfLoadSuppliersPersistenceDto> listOfData = new ArrayList<ListOfLoadSuppliersPersistenceDto>();
			for (Object[] objects : list) {
				ListOfLoadSuppliersPersistenceDto objPersistenceDTO = new ListOfLoadSuppliersPersistenceDto();
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
				 
				 if (objects[2] != null) {
					 if(objects[2].toString().equals("true")) {
						 objPersistenceDTO.setIsActive("Active"); 
					 }
					 else {
						 objPersistenceDTO.setIsActive("InActive"); 
					 }
						
					} else {
						objPersistenceDTO.setIsActive(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		} 
      
      //
      

}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.BrandDetailsControllerDTO;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class BrandDetailsMapper {
	public BrandDetailsServiceDTO conversionControllerDtoToServiceDto(
			BrandDetailsControllerDTO objBrandDetailsControllerDTO) {
		BrandDetailsServiceDTO objBrandDetailsServiceDTO = new BrandDetailsServiceDTO();
		BeanUtils.copyProperties(objBrandDetailsControllerDTO, objBrandDetailsServiceDTO);

		return objBrandDetailsServiceDTO;
	}
	
	
	
	public List<BrandDetailsControllerDTO> conversionForServiceTOControllerDTO(List<BrandDetailsServiceDTO> objServicedto) {
		List<BrandDetailsControllerDTO> objBrandDetailsControllerDTO = new ArrayList<BrandDetailsControllerDTO>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			BrandDetailsControllerDTO objBrandDetailsControllerDTO1 = new BrandDetailsControllerDTO();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, objBrandDetailsControllerDTO1);
			objBrandDetailsControllerDTO.add(objBrandDetailsControllerDTO1);
		});
		return objBrandDetailsControllerDTO;
	}

	public List<BrandDetailsServiceDTO> conversionpersistanceDTOtoServiceDTO(List<BrandDetailsPeristenanceDTO> persistenceDTOs) {
		List<BrandDetailsServiceDTO> objServicedtos = new ArrayList<BrandDetailsServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			BrandDetailsServiceDTO objSearchServiceDto = new BrandDetailsServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}


      public List<BrandDetailsPeristenanceDTO> conversionOfBrandDetails(List<Object[]> list) {
		List<BrandDetailsPeristenanceDTO> listOfData = new ArrayList<BrandDetailsPeristenanceDTO>();
		for (Object[] objects : list) {
			BrandDetailsPeristenanceDTO objPersistenceDTO = new BrandDetailsPeristenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setBrandId(objects[0].toString());
			} else {
				objPersistenceDTO.setBrandId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setBrandName(objects[1].toString());
			} else {
				objPersistenceDTO.setBrandName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
				 if(objects[2].toString().equals("true")) {
					 objPersistenceDTO.setStatus("Active");
				 }
				 else {
					 objPersistenceDTO.setStatus("Inactive");
				 }
					
				} else {
					objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
      
    
      public List<BrandDetailsPeristenanceDTO> conversionOfBarCode(List<Object[]> list) {
  		List<BrandDetailsPeristenanceDTO> listOfData = new ArrayList<BrandDetailsPeristenanceDTO>();
  		for (Object[] objects : list) {
  			BrandDetailsPeristenanceDTO objPersistenceDTO = new BrandDetailsPeristenanceDTO();
  			if (objects[0] != null) {
  				objPersistenceDTO.setSerialId(objects[0].toString());
  			} else {
  				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
  			}
  			 if (objects[1] != null) {
  				objPersistenceDTO.setMaterialGroupId(objects[1].toString());
  			} else {
  				objPersistenceDTO.setMaterialGroupId(CommonConstants.DATA_NOT_AVIALABLE);
  			}
  			 if (objects[2] != null) {
  				objPersistenceDTO.setGroupName(objects[2].toString());
  				} else {
  					objPersistenceDTO.setGroupName(CommonConstants.DATA_NOT_AVIALABLE);
  				}
  			 
  			if (objects[3] != null) {
  				objPersistenceDTO.setDrugName(objects[3].toString());
  				} else {
  					objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
  				}
  			
  			
  			if (objects[4] != null) {
  				objPersistenceDTO.setShortUnicCode(objects[4].toString());
  				} else {
  					objPersistenceDTO.setShortUnicCode(CommonConstants.DATA_NOT_AVIALABLE);
  				}
  			if (objects[5] != null) {
  				objPersistenceDTO.setBarCode(objects[5].toString());
  				} else {
  					objPersistenceDTO.setBarCode(CommonConstants.DATA_NOT_AVIALABLE);
  				}
  			 listOfData.add(objPersistenceDTO);
  		}
  		return listOfData;
  	}

}

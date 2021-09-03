package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.SCMLoginControllerDto;
import com.pro.scm.persistencedto.SCMLoginPersistenceDto;
import com.pro.scm.servicedto.SCMLoginServiceDto;
import com.pro.scm.utills.CommonConstants;

public class SMCLoginMapper {

	public SCMLoginServiceDto conversionControllerDtoToServiceDto(SCMLoginControllerDto scmLoginControllerDto) {
		SCMLoginServiceDto scmLoginServiceDto = new SCMLoginServiceDto();
		BeanUtils.copyProperties(scmLoginControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<SCMLoginControllerDto> conversionForServiceTOControllerDTO(List<SCMLoginServiceDto> objServicedto) {
		List<SCMLoginControllerDto> objControllerDto = new ArrayList<SCMLoginControllerDto>();
		objServicedto.forEach(serviceDto -> {
			SCMLoginControllerDto objControllerDto1 = new SCMLoginControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<SCMLoginServiceDto> conversionpersistanceDTOtoServiceDTO(List<SCMLoginPersistenceDto> persistenceDTOs) {
		List<SCMLoginServiceDto> objServicedtos = new ArrayList<SCMLoginServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			SCMLoginServiceDto objSearchServiceDto = new SCMLoginServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	
	

 public List<SCMLoginPersistenceDto> settingDataIntoSCMLoginPersistenceDto(List<Object[]> list) {
		List<SCMLoginPersistenceDto> listOfData = new ArrayList<SCMLoginPersistenceDto>();
		
//			list.stream().forEach((temp)->{
//			SCMLoginPersistenceDto objPersistenceDTO = new SCMLoginPersistenceDto();
//			if(temp.getRoleId()!=null) {
//				objPersistenceDTO.setRoleId(temp.getRoleId());
//			}
//			else {
//				objPersistenceDTO.setRoleId(CommonConstants.DATA_NOT_AVIALABLE);
//			}
//			if(temp.getRoleName()!=null) {
//				objPersistenceDTO.setRoleName(temp.getRoleName());
//			}
//			else {
//				objPersistenceDTO.setRoleName(CommonConstants.DATA_NOT_AVIALABLE);
//			}
//			 listOfData.add(objPersistenceDTO);
//		});
		
		
		
		for (Object[] objects : list) {
			SCMLoginPersistenceDto objPersistenceDTO = new SCMLoginPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setRoleId(objects[0].toString());
			} else {
				objPersistenceDTO.setRoleId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setRoleName(objects[1].toString());
			} else {
				objPersistenceDTO.setRoleName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
      
     
      
      
      
      
      
      
      
      
      
      
      
      
      

}

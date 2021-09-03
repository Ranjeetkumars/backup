package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadGenericDrugNameControllerDto;
import com.pro.scm.persistencedto.LoadGenericDrugNamePersistenceDto;
import com.pro.scm.servicedto.LoadGenericDrugNameServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadGenericDrugNameMapper {
	
	
	
	public LoadGenericDrugNameServiceDto conversionControllerDtoToServiceDto(
			LoadGenericDrugNameControllerDto loadGenericDrugNameControllerDto) {
		LoadGenericDrugNameServiceDto loadGenericDrugNameServiceDto = new LoadGenericDrugNameServiceDto();
		BeanUtils.copyProperties(loadGenericDrugNameControllerDto, loadGenericDrugNameServiceDto);

		return loadGenericDrugNameServiceDto;
	}
	
	
	
	public List<LoadGenericDrugNameControllerDto> conversionForServiceTOControllerDTO(List<LoadGenericDrugNameServiceDto> objServicedto) {
		List<LoadGenericDrugNameControllerDto> loadGenericDrugNameControllerDto = new ArrayList<LoadGenericDrugNameControllerDto>();
		objServicedto.forEach(PharamacyNewDrugQtyServiceDto -> {
			LoadGenericDrugNameControllerDto loadGenericDrugNameControllerDto1 = new LoadGenericDrugNameControllerDto();
			BeanUtils.copyProperties(PharamacyNewDrugQtyServiceDto, loadGenericDrugNameControllerDto1);
			loadGenericDrugNameControllerDto.add(loadGenericDrugNameControllerDto1);
		});
		return loadGenericDrugNameControllerDto;
	}

	public List<LoadGenericDrugNameServiceDto> conversionpersistanceDTOtoServiceDTO(List<LoadGenericDrugNamePersistenceDto> persistenceDTOs) {
		List<LoadGenericDrugNameServiceDto> objServicedtos = new ArrayList<LoadGenericDrugNameServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadGenericDrugNameServiceDto loadGenericDrugNameServiceDto = new LoadGenericDrugNameServiceDto();
			BeanUtils.copyProperties(persistence, loadGenericDrugNameServiceDto);
			objServicedtos.add(loadGenericDrugNameServiceDto);
		});
		return objServicedtos;
	}
	
	 public List<LoadGenericDrugNamePersistenceDto> setdataIntoLoadGenericDrugNamePersistenceDto(List<Object[]> list) {
			List<LoadGenericDrugNamePersistenceDto> listOfData = new ArrayList<LoadGenericDrugNamePersistenceDto>();
			for (Object[] objects : list) {
				LoadGenericDrugNamePersistenceDto objPersistenceDTO = new LoadGenericDrugNamePersistenceDto();
				if (objects[0] != null) {
					objPersistenceDTO.setDgnSerialId(objects[0].toString());
				} else {
					objPersistenceDTO.setDgnSerialId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setDgnGenericName(objects[1].toString());
				} else {
					objPersistenceDTO.setDgnGenericName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}

}

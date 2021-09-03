package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.LoadMaterialFormControllerDto;
import com.pro.scm.persistencedto.LoadMaterialFormPersistenanceDTO;
import com.pro.scm.persistencedto.LoadMaterialFormPersistenceDto;
import com.pro.scm.servicedto.LoadMaterialFormServiceDto;
import com.pro.scm.servicedto.MaterialFormServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class LoadMaterialFormMapper {

	public LoadMaterialFormServiceDto conversionControllerDtoToServiceDto(
			LoadMaterialFormControllerDto loadMaterialFormControllerDto) {
		LoadMaterialFormServiceDto loadMaterialFormServiceDto = new LoadMaterialFormServiceDto();
		BeanUtils.copyProperties(loadMaterialFormControllerDto, loadMaterialFormServiceDto);
		return loadMaterialFormServiceDto;
	}

	public List<LoadMaterialFormControllerDto> conversionForServiceTOControllerDTO(
			List<LoadMaterialFormServiceDto> loadMaterialFormServiceDto) {
		List<LoadMaterialFormControllerDto> loadMaterialFormControllerDto = new ArrayList<LoadMaterialFormControllerDto>();
		loadMaterialFormServiceDto.forEach(serviceDto -> {
			LoadMaterialFormControllerDto objControllerDto1 = new LoadMaterialFormControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			loadMaterialFormControllerDto.add(objControllerDto1);
		});
		return loadMaterialFormControllerDto;
	}

	public List<LoadMaterialFormServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadMaterialFormPersistenceDto> loadMaterialFormPersistenceDto) {
		List<LoadMaterialFormServiceDto> objServicedtos = new ArrayList<LoadMaterialFormServiceDto>();
		loadMaterialFormPersistenceDto.forEach(persistence -> {
			LoadMaterialFormServiceDto objSearchServiceDto = new LoadMaterialFormServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<MaterialFormServiceDTO> conversionpersistanceDTOtoServiceDTOForListOfdata(
			List<LoadMaterialFormPersistenanceDTO> loadMaterialFormPersistenceDto) {
		List<MaterialFormServiceDTO> objServicedtos = new ArrayList<MaterialFormServiceDTO>();
		loadMaterialFormPersistenceDto.forEach(persistence -> {
			MaterialFormServiceDTO objSearchServiceDto = new MaterialFormServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<LoadMaterialFormPersistenceDto> settingDataIntoLoadLocalIndentDetailsPersistenceDto(
			List<Object[]> list) {
		List<LoadMaterialFormPersistenceDto> listOfData = new ArrayList<LoadMaterialFormPersistenceDto>();
		for (Object[] objects : list) {
			LoadMaterialFormPersistenceDto objPersistenceDTO = new LoadMaterialFormPersistenceDto();

			if (objects[0] != null) {
				objPersistenceDTO.setFormId(objects[0].toString());
			} else {
				objPersistenceDTO.setFormId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setFormPName(objects[1].toString());
			} else {
				objPersistenceDTO.setFormPName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	public List<LoadMaterialFormPersistenanceDTO> conversionForLoadMaterialFormist(List<Object[]> list) {
		List<LoadMaterialFormPersistenanceDTO> listOfData = new ArrayList<LoadMaterialFormPersistenanceDTO>();

		for (Object[] objects : list) {
			LoadMaterialFormPersistenanceDTO objPersistenceDTO = new LoadMaterialFormPersistenanceDTO();

			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setFromType(objects[1].toString());
			} else {
				objPersistenceDTO.setFromType(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setGroupName(objects[2].toString());
			} else {
				objPersistenceDTO.setGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[3] != null) {
				if (objects[3].toString().equals("true")) {
					objPersistenceDTO.setStatus("Active");
				} else {
					objPersistenceDTO.setStatus("InActive");
				}

			} else {
				objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	public List<LoadMaterialFormPersistenanceDTO> convertArrayObjctToPersistenceDtoForMatrialGroup(
			List<Object[]> list) {
		List<LoadMaterialFormPersistenanceDTO> listOfData = new ArrayList<LoadMaterialFormPersistenanceDTO>();

		for (Object[] objects : list) {
			LoadMaterialFormPersistenanceDTO objPersistenceDTO = new LoadMaterialFormPersistenanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setGroupId(objects[0].toString());
			} else {
				objPersistenceDTO.setGroupId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGroupName(objects[1].toString());
			} else {
				objPersistenceDTO.setGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

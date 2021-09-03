package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.Store_item_detailsControllerDto;
import com.pro.scm.persistencedto.Store_item_detailsPersistenceDto;
import com.pro.scm.servicedto.Store_item_detailsServiceDto;
import com.pro.scm.utills.CommonConstants;

public class Store_item_detailsMapper {

	public Store_item_detailsServiceDto conversionControllerDtoToServiceDto(
			Store_item_detailsControllerDto store_item_detailsControllerDto) {
		Store_item_detailsServiceDto store_item_detailsServiceDto = new Store_item_detailsServiceDto();
		BeanUtils.copyProperties(store_item_detailsControllerDto, store_item_detailsServiceDto);
		return store_item_detailsServiceDto;
	}

	public List<Store_item_detailsControllerDto> conversionForServiceTOControllerDTO(
			List<Store_item_detailsServiceDto> objServicedto) {
		List<Store_item_detailsControllerDto> objControllerDto = new ArrayList<Store_item_detailsControllerDto>();
		objServicedto.forEach(serviceDto -> {
			Store_item_detailsControllerDto objControllerDto1 = new Store_item_detailsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<Store_item_detailsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<Store_item_detailsPersistenceDto> persistenceDTOs) {
		List<Store_item_detailsServiceDto> objServicedtos = new ArrayList<Store_item_detailsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			Store_item_detailsServiceDto objSearchServiceDto = new Store_item_detailsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<Store_item_detailsPersistenceDto> settingDataIntoStore_item_detailsPersistenceDto(List<Object[]> list) {
		List<Store_item_detailsPersistenceDto> listOfData = new ArrayList<Store_item_detailsPersistenceDto>();
		for (Object[] objects : list) {
			Store_item_detailsPersistenceDto objPersistenceDTO = new Store_item_detailsPersistenceDto();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrShortUnicCode(objects[1].toString());
			} else {
				objPersistenceDTO.setDrShortUnicCode(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[2] != null) {
				objPersistenceDTO.setDrugName(objects[2].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setGroupName(objects[3].toString());
			} else {
				objPersistenceDTO.setGroupName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setPt_PackingTyp(objects[4].toString());
			} else {
				objPersistenceDTO.setPt_PackingTyp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setConersionFactor(objects[5].toString());
			} else {
				objPersistenceDTO.setConersionFactor(CommonConstants.DATA_NOT_AVIALABLE);
			}

			if (objects[6] != null) {
				objPersistenceDTO.setOrdeQty(objects[6].toString());
			} else {
				objPersistenceDTO.setOrdeQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setAvailQty(objects[7].toString());
			} else {
				objPersistenceDTO.setAvailQty(CommonConstants.DATA_NOT_AVIALABLE);
			}
			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

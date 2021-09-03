package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.LoadVehicleTransferItemsControllerDto;
import com.pro.scm.persistencedto.LoadVehicleTransferItemsPersistenceDto;
import com.pro.scm.servicedto.LoadVehicleTransferItemsServiceDto;
import com.pro.scm.utills.CommonConstants;

public class LoadVehicleTransferItemsMapper {

	public LoadVehicleTransferItemsServiceDto conversionControllerDtoToServiceDto(
			LoadVehicleTransferItemsControllerDto loadVehicleTransferItemsControllerDto) {
		LoadVehicleTransferItemsServiceDto scmLoginServiceDto = new LoadVehicleTransferItemsServiceDto();
		BeanUtils.copyProperties(loadVehicleTransferItemsControllerDto, scmLoginServiceDto);
		return scmLoginServiceDto;
	}

	public List<LoadVehicleTransferItemsControllerDto> conversionForServiceTOControllerDTO(
			List<LoadVehicleTransferItemsServiceDto> objServicedto) {
		List<LoadVehicleTransferItemsControllerDto> objControllerDto = new ArrayList<LoadVehicleTransferItemsControllerDto>();

		objServicedto.forEach(serviceDto -> {
			LoadVehicleTransferItemsControllerDto objControllerDto1 = new LoadVehicleTransferItemsControllerDto();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<LoadVehicleTransferItemsServiceDto> conversionpersistanceDTOtoServiceDTO(
			List<LoadVehicleTransferItemsPersistenceDto> persistenceDTOs) {
		List<LoadVehicleTransferItemsServiceDto> loadVehicleTransferItemsServiceDto = new ArrayList<LoadVehicleTransferItemsServiceDto>();
		persistenceDTOs.forEach(persistence -> {
			LoadVehicleTransferItemsServiceDto objSearchServiceDto = new LoadVehicleTransferItemsServiceDto();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			loadVehicleTransferItemsServiceDto.add(objSearchServiceDto);
		});
		return loadVehicleTransferItemsServiceDto;
	}

	public List<LoadVehicleTransferItemsPersistenceDto> settingDataIntoLoadVehicleTransferItemsPersistenceDto(
			List<Object[]> list) {
		List<LoadVehicleTransferItemsPersistenceDto> listOfData = new ArrayList<LoadVehicleTransferItemsPersistenceDto>();
		for (Object[] objects : list) {
			LoadVehicleTransferItemsPersistenceDto objPersistenceDTO = new LoadVehicleTransferItemsPersistenceDto();
           
			if (objects[0] != null) {
				objPersistenceDTO.setDr_Short_Unic_Code(objects[0].toString());
			} else {
				objPersistenceDTO.setDr_Short_Unic_Code(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDr_drug_Name(objects[1].toString());
			} else {
				objPersistenceDTO.setDr_drug_Name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				objPersistenceDTO.setDrr_Batch_Number(objects[2].toString());
			} else {
				objPersistenceDTO.setDrr_Batch_Number(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				objPersistenceDTO.setPt_Packing_Type(objects[3].toString());
			} else {
				objPersistenceDTO.setPt_Packing_Type(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				objPersistenceDTO.setDrr_Expire_Date(objects[4].toString());
			} else {
				objPersistenceDTO.setDrr_Expire_Date(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				objPersistenceDTO.setArr_Available_Stock(objects[5].toString());
			} else {
				objPersistenceDTO.setArr_Available_Stock(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[6] != null) {
				objPersistenceDTO.setDt_No_Strips(objects[6].toString());
			} else {
				objPersistenceDTO.setDt_No_Strips(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[7] != null) {
				objPersistenceDTO.setDrr_Purchase_Price(objects[7].toString());
			} else {
				objPersistenceDTO.setDrr_Purchase_Price(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[8] != null) {
				objPersistenceDTO.setDrr_mrp(objects[8].toString());
			} else {
				objPersistenceDTO.setDrr_mrp(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[9] != null) {
				objPersistenceDTO.setDrr_Unit_Cost(objects[9].toString());
			} else {
				objPersistenceDTO.setDrr_Unit_Cost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[10] != null) {
				objPersistenceDTO.setDt_Drug_Id(objects[10].toString());
			} else {
				objPersistenceDTO.setDt_Drug_Id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[11] != null) {
				objPersistenceDTO.setDt_transfer_SerialId(objects[11].toString());
			} else {
				objPersistenceDTO.setDt_transfer_SerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[12] != null) {
				objPersistenceDTO.setDt_from_VehicleId(objects[12].toString());
			} else {
				objPersistenceDTO.setDt_from_VehicleId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			if (objects[13] != null) {
				objPersistenceDTO.setDt_Serial_Id(objects[13].toString());
			} else {
				objPersistenceDTO.setDt_Serial_Id(CommonConstants.DATA_NOT_AVIALABLE);
			}

			listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
}

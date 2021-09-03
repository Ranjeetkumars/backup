package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.AllApprovalItemListMapper;
import com.pro.scm.mappers.AllIndentDetailsMapper;
import com.pro.scm.mappers.AllPurchaseOrdersByMesserIdMapper;
import com.pro.scm.mappers.DrugAndSupplierMappingMapper;
import com.pro.scm.mappers.DrugRegistrationMapper;
import com.pro.scm.mappers.GenerateNewDrugBarcodeMapper;
import com.pro.scm.mappers.LoadGenericNamesMapper;
import com.pro.scm.mappers.LoadMaterialFormMapper;
import com.pro.scm.mappers.LoadPackingTypeMapper;
import com.pro.scm.mappers.LoadScheduleMapper;
import com.pro.scm.persistencedto.AllApprovalItemListPersistenceDto;
import com.pro.scm.persistencedto.AllIndentDetailsPersistenceDto;
import com.pro.scm.persistencedto.AllPurchaseOrdersByMesserIdPersistenceDto;
import com.pro.scm.persistencedto.AllPurchaseOrdersByMesserIdServiceDto;
import com.pro.scm.persistencedto.DrugAndSupplierMappingPersistenceDto;
import com.pro.scm.persistencedto.DrugRegisteringPersistenceDto;
import com.pro.scm.persistencedto.GenerateNewDrugBarcodePersistenceDto;
import com.pro.scm.persistencedto.LoadGenericNamesPersistenceDto;
import com.pro.scm.persistencedto.LoadMaterialFormPersistenceDto;
import com.pro.scm.persistencedto.LoadPackingTypePersistenceDto;
import com.pro.scm.persistencedto.LoadSchedulePersistenceDto;
import com.pro.scm.service.DrugRegisteringService;
import com.pro.scm.servicedto.AllApprovalItemListServiceDto;
import com.pro.scm.servicedto.AllIndentDetailsServiceDto;
import com.pro.scm.servicedto.DrugAndSupplierMappingServiceDto;
import com.pro.scm.servicedto.DrugRegistrationServiceDto;
import com.pro.scm.servicedto.GenerateNewDrugBarcodeServiceDto;
import com.pro.scm.servicedto.LoadGenericNamesServiceDto;
import com.pro.scm.servicedto.LoadMaterialFormServiceDto;
import com.pro.scm.servicedto.LoadPackingTypeServiceDto;
import com.pro.scm.servicedto.LoadScheduleServiceDto;
import com.pro.scm.servicedto.MesserAddressServiceDto;
import com.pro.scm.servicedto.RejectIndentDataServiceDto;
import com.pro.scm.servicedto.SaveDrugDetailsServiceDto;
import com.pro.scm.servicedto.UpdateActiveDrugForRejectApprovalServiceDto;

import lombok.extern.slf4j.Slf4j;

@Service("drugRegisteringService")
@SuppressWarnings("unchecked")
@Slf4j
public class DrugRegisteringServiceImpl implements DrugRegisteringService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String saveDrugDetails(SaveDrugDetailsServiceDto saveDrugDetailsServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("saveDrugDetails method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();

		// select * from
		// sp_insert_drug_reg_ref('test',4,3,5,5,5,'','7',1,1,1,'10gm',1,3,1,7,3,1,1,1,1,1,'1',1,1,'test')
//select * from sp_insert_drug_reg_ref('test',2,4,4,,,'','',1,1,1,'10gm',1,3,1,0,1,,1,1,1,1,'1',1,1,'test')
		stringBuilder.append("select * from sp_insert_drug_reg_ref('");
		stringBuilder.append(saveDrugDetailsServiceDto.getDrugName());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getBrand_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getManufaturer_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getForm_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getMinmum_level_qty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getMaximum_lel_qty());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getShort_unic_code());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getExpire_alert());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getCreatedbyid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getCreatedbyroleid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getCreatedbymoduleid());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getStrength_type());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getSystem_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getGenric_group_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getGenric_molecules_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getPackId());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getScheduleid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getVehicleReorderqty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getVehicleMinqty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getMaterialGroupformid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getGenericid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getMinsaleqty());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getBarcode());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getSubStoreMinLevelQty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getSubStoreMaxLevelQty());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getDescription());
		stringBuilder.append("'");
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::saveDrugDetails:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for saveDrugDetails :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String UpdateDrugDetails(SaveDrugDetailsServiceDto saveDrugDetailsServiceDto, String strRequestID)
			throws DataNotFoundException {
		
		log.info("UpdateDrugDetails method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_drug_reg_ref(");
		stringBuilder.append(saveDrugDetailsServiceDto.getDrugId());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getDrugName());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getBrand_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getManufaturer_id());

		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getForm_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getMinmum_level_qty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getMaximum_lel_qty());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getShort_unic_code());
		stringBuilder.append("'");

		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getExpire_alert());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getCreatedbyid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getCreatedbyroleid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getCreatedbymoduleid());
		stringBuilder.append(",");

		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getStrength_type());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getSystem_id());

		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getGenric_group_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getGenric_molecules_id());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getPackId());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getScheduleid());
		stringBuilder.append(",");

		stringBuilder.append(saveDrugDetailsServiceDto.getVehicleReorderqty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getVehicleMinqty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getMaterialGroupformid());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getGenericid());
		stringBuilder.append(",").append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getRemarks()).append("'");
		stringBuilder.append(",");
		stringBuilder.append(0);
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getSubStoreMinLevelQty());
		stringBuilder.append(",");
		stringBuilder.append(saveDrugDetailsServiceDto.getSubStoreMaxLevelQty());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveDrugDetailsServiceDto.getDescription());
		stringBuilder.append("'");
		stringBuilder.append(")");

		System.out.println("getPurchageRate id @@@@@@@@@@@@@@@@@@@"+saveDrugDetailsServiceDto.getPurchageRate());
		System.out.println("getMrp id @@@@@@@@@@@@@@@@@@@"+saveDrugDetailsServiceDto.getMrp());
         
		log.info(strRequestID + ":::::::::::::::UpdateDrugDetails:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for UpdateDrugDetails :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<LoadPackingTypeServiceDto> loadPackingType(LoadPackingTypeServiceDto loadPackingTypeServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("loadPackingType method is executed inside DrugRegisteringServiceImpl");
		List<LoadPackingTypeServiceDto> loadPackingTypeServiceDto_2;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_packing_types(");// select * from sp_select_packing_types
		stringBuilder.append(loadPackingTypeServiceDto.getMaterialid());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadPackingTypeMapper mapper = new LoadPackingTypeMapper();
			List<LoadPackingTypePersistenceDto> drugsPersistencedtos = mapper
					.settingDataIntoLoadPackingTypePersistenceDto(list);
			loadPackingTypeServiceDto_2 = mapper.conversionpersistanceDTOtoServiceDTO(drugsPersistencedtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadPackingType::::::");
		}
		return loadPackingTypeServiceDto_2;

	}

	@Override
	public List<LoadMaterialFormServiceDto> loadMaterialForm(LoadMaterialFormServiceDto loadPackingTypeServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("loadMaterialForm method is executed inside DrugRegisteringServiceImpl");
		List<LoadMaterialFormServiceDto> loadMaterialFormServiceDto1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_loadMaterialForm(");
		stringBuilder.append(loadPackingTypeServiceDto.getMaterialid());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadMaterialFormMapper mapper = new LoadMaterialFormMapper();
			List<LoadMaterialFormPersistenceDto> loadMaterialFormPersistenceDto = mapper
					.settingDataIntoLoadLocalIndentDetailsPersistenceDto(list);
			loadMaterialFormServiceDto1 = mapper.conversionpersistanceDTOtoServiceDTO(loadMaterialFormPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadMaterialForm::::::");
		}
		return loadMaterialFormServiceDto1;
	}

	@Override
	public List<LoadGenericNamesServiceDto> loadGenericNames(String strRequestID) throws DataNotFoundException {
		log.info("loadMaterialForm method is executed inside DrugRegisteringServiceImpl");
		List<LoadGenericNamesServiceDto> loadGenericNamesServiceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Select * from sp_select_allgenericnames()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadGenericNamesMapper mapper = new LoadGenericNamesMapper();
			List<LoadGenericNamesPersistenceDto> loadMaterialFormPersistenceDto = mapper
					.settingDataIntoLoadGenericNamesPersistenceDto(list);
			loadGenericNamesServiceDto = mapper.conversionpersistanceDTOtoServiceDTO(loadMaterialFormPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadGenericNames::::::");
		}
		return loadGenericNamesServiceDto;
	}

	@Override
	public List<GenerateNewDrugBarcodeServiceDto> generate_new_drug_barcode(
			GenerateNewDrugBarcodeServiceDto generateNewDrugBarcodeServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("generate_new_drug_barcode method is executed inside DrugRegisteringServiceImpl");
		List<GenerateNewDrugBarcodeServiceDto> generateNewDrugBarcodeServiceDto1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_pms_genrate_barcode(");
		stringBuilder.append(generateNewDrugBarcodeServiceDto.getGenericId());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(generateNewDrugBarcodeServiceDto.getGenericName());
		stringBuilder.append("'");
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GenerateNewDrugBarcodeMapper mapper = new GenerateNewDrugBarcodeMapper();
			List<GenerateNewDrugBarcodePersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoGenerateNewDrugBarcodePersistenceDto(list);
			generateNewDrugBarcodeServiceDto1 = mapper
					.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No generate_new_drug_barcode::::::");
		}
		return generateNewDrugBarcodeServiceDto1;
	}

	@Override
	public List<LoadScheduleServiceDto> loadSchedule(String strRequestID) throws DataNotFoundException {
		log.info("loadSchedule method is executed inside DrugRegisteringServiceImpl");
		List<LoadScheduleServiceDto> listOfLoadScheduleServiceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SELECT ds_scheduleid, ds_schdule_type  FROM pms_drug_schdule_ref where ds_isactive=true order by 2");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadScheduleMapper mapper = new LoadScheduleMapper();
			List<LoadSchedulePersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoLoadSchedulePersistenceDto(list);
			listOfLoadScheduleServiceDto = mapper
					.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return listOfLoadScheduleServiceDto;
	}

	@Override
	public List<LoadScheduleServiceDto> loadMaterialGroup(String strRequestID) throws DataNotFoundException {
		List<LoadScheduleServiceDto> listOfLoadScheduleServiceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Select * from sp_select_loadMaterialgroup()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadScheduleMapper mapper = new LoadScheduleMapper();
			List<LoadSchedulePersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoLoadSchedulePersistenceDto1(list);
			listOfLoadScheduleServiceDto = mapper
					.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return listOfLoadScheduleServiceDto;
	}

	@Override
	public String updateActiveDrugForRejectApproval(UpdateActiveDrugForRejectApprovalServiceDto serviceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("updateActiveDrugForRejectApproval ");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pharmacy_drug_approvalreject_pms_drug_reg_ref(");
		stringBuilder.append(serviceDto.getSize());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(serviceDto.getDrugIds());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getUserId());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getDrugTypeId());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getApprovalId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::updateActiveDrugForRejectApproval:::::::::::"
				+ stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for updateActiveDrugForRejectApproval :::::::::::"
				+ strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String strIndentDetails(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("strIndentDetails mt executed ");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_indent_details_pms_scm_indent_ref(");
		stringBuilder.append(serviceDto.getIntIndentId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::strIndentDetails:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for strIndentDetails :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String updateIndentDetails(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("updateIndentDetails mt executed ");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_scm_indent_item_wise_trans('");
		stringBuilder.append(serviceDto.getIntIndentId());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(serviceDto.getQuantity());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getCount());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getUserId());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getRoleId());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getModuleId());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(serviceDto.getDrugIds());
		stringBuilder.append("'");
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::updateIndentDetails:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for updateIndentDetails :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String updateIndentItemsRejected(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("updateIndentItemsRejected mt executed ");
		String strRtnValue = null;
		boolean isstatus = true;
		if (isstatus) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("select * from sp_update_pms_indent_items_reject('");
			stringBuilder.append(serviceDto.getIntIndentId());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append("'");
			stringBuilder.append(serviceDto.getItemId());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getUserId());
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getModuleId());
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getRoleId());
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getCount());
			stringBuilder.append(",");
			stringBuilder.append("'");
			stringBuilder.append(serviceDto.getRemarks());
			stringBuilder.append("'");
			stringBuilder.append(")");
			log.info(strRequestID + ":::::::::::::::updateIndentItemsRejected:::::::::::" + stringBuilder.toString());
			log.info(strRequestID + ":::::::::::::::Request Id for updateIndentItemsRejected :::::::::::"
					+ strRequestID);
			strRtnValue = objSupervisorDao.saveData(stringBuilder.toString());
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("select * from sp_update_pms_indent_items_reject('");
			stringBuilder.append(serviceDto.getIntIndentId());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append("'");
			stringBuilder.append(serviceDto.getItemId());
			stringBuilder.append("'");
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getUserId());
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getModuleId());
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getRoleId());
			stringBuilder.append(",");
			stringBuilder.append(serviceDto.getCount());
			stringBuilder.append(",");
			stringBuilder.append("'");
			stringBuilder.append(serviceDto.getRemarks());
			stringBuilder.append("'");
			stringBuilder.append(")");
			log.info(strRequestID + ":::::::::::::::updateIndentItemsRejected:::::::::::" + stringBuilder.toString());
			log.info(strRequestID + ":::::::::::::::Request Id for updateIndentItemsRejected :::::::::::"
					+ strRequestID);
			strRtnValue = objSupervisorDao.saveData(stringBuilder.toString());
		}
		return strRtnValue;

	}

	@Override
	public String updateIndentReject(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("updateIndentItemsRejected mt executed ");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_indent_reject('");
		stringBuilder.append(serviceDto.getIntIndentId());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getUserId());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getModuleId());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getRoleId());
		stringBuilder.append(",");
		stringBuilder.append(serviceDto.getCount());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(serviceDto.getRemarks());
		stringBuilder.append("'");

		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::updateIndentItemsRejected:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for updateIndentItemsRejected :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<AllApprovalItemListServiceDto> allApprovalItemList(
			AllApprovalItemListServiceDto allApprovalItemListServiceDto, String strRequestID)
			throws DataNotFoundException {
		List<AllApprovalItemListServiceDto> serviceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select * from sp_select_pharmacy_Indentapproval_drugs( ");
		stringBuilder.append(allApprovalItemListServiceDto.getIndentId());
		stringBuilder.append(" ) ");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AllApprovalItemListMapper mapper = new AllApprovalItemListMapper();
			List<AllApprovalItemListPersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoAllApprovalItemListPersistenceDto(list);
			serviceDto = mapper.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return serviceDto;
	}

	@Override
	public List<AllIndentDetailsServiceDto> getAllIndentDetails(String strRequestID) throws DataNotFoundException {
		List<AllIndentDetailsServiceDto> serviceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select * from sp_select_pms_scm_indent_ref()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AllIndentDetailsMapper mapper = new AllIndentDetailsMapper();
			List<AllIndentDetailsPersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoAllIndentDetailsPersistenceDto(list);
			serviceDto = mapper.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return serviceDto;
	}

	@Override
	public List<AllPurchaseOrdersByMesserIdServiceDto> allPurchaseOrdersByMesserId(
			AllPurchaseOrdersByMesserIdServiceDto allPurchaseOrdersByMesserIdServiceDto, String strRequestID)
			throws DataNotFoundException {
		List<AllPurchaseOrdersByMesserIdServiceDto> serviceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_drug_company_xref(");
		stringBuilder.append(allPurchaseOrdersByMesserIdServiceDto.getMesserId());
		stringBuilder.append(")");

		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AllPurchaseOrdersByMesserIdMapper mapper = new AllPurchaseOrdersByMesserIdMapper();
			List<AllPurchaseOrdersByMesserIdPersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoAllPurchaseOrdersByMesserIdPersistenceDto(list);
			serviceDto = mapper.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return serviceDto;
	}

	@Override
	public String getMesserAddress(MesserAddressServiceDto messerAddressServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("getMesserAddress mt executed ");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_messers_address_pms_drugs_supplier_ref(");
		stringBuilder.append(messerAddressServiceDto.getMesserId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::getMesserAddress:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for getMesserAddress :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String getAllActiveInactiveCount(DrugRegistrationServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("getAllActiveInactiveCount mt executed ");
		String rtnAllActiveInactiveCount = "select count(*) from sp_select_pharmacy_active_inactive_search('"
				+ serviceDto.getGenericName() + "'," + serviceDto.getBrandId() + "," + serviceDto.getMatrialFromId()
				+ "," + serviceDto.getManufacfuredId() + ",'" + serviceDto.getUniCode() + "',"
				+ serviceDto.getActveOrInActieId() + "," + serviceDto.getSystemId() + ","
				+ serviceDto.getGenericGroupId() + "," + serviceDto.getGenericMoleculeId() + ")";
		log.info(strRequestID + ":::::::::::::::getAllActiveInactiveCount:::::::::::"
				+ rtnAllActiveInactiveCount.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for getAllActiveInactiveCount :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(rtnAllActiveInactiveCount.toString());
	}

	@Override
	public List<DrugRegistrationServiceDto> getAllActiveInactive(DrugRegistrationServiceDto serviceDto,
			String strRequestID) throws DataNotFoundException {
		List<DrugRegistrationServiceDto> listOfdata;
		log.info("getAllActiveInactiveCount mt executed ");
		String rtngetAllActiveInactive = "select * from sp_select_pharmacy_active_inactive_search('"
				+ serviceDto.getGenericName() + "'," + serviceDto.getBrandId() + "," + serviceDto.getMatrialFromId()
				+ "," + serviceDto.getManufacfuredId() + ",'" + serviceDto.getUniCode() + "',"
				+ serviceDto.getActveOrInActieId() + "," + serviceDto.getSystemId() + ","
				+ serviceDto.getGenericGroupId() + "," + serviceDto.getGenericMoleculeId() + ")";
		log.info(strRequestID + ":::::::::::::" + rtngetAllActiveInactive);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(rtngetAllActiveInactive);
		log.info(strRequestID + ":::::::list::::::" + list.size());

		if (null != list && !list.isEmpty() && list.size() > 0) {
			DrugRegistrationMapper mapper = new DrugRegistrationMapper();
			List<DrugRegisteringPersistenceDto> persistenceDTOs = mapper.convertObjetsArraytoPersistenceDto(list);
			listOfdata = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return listOfdata;
	}

	@Override
	public List<DrugAndSupplierMappingServiceDto> listloadSuppliers(String strRequestID) throws DataNotFoundException {
		List<DrugAndSupplierMappingServiceDto> listOfData;
		String rtnListofSupplier = "select * from sp_select_pms_drugsuppliers_pms_drugs_supplier_ref()";
		log.info(strRequestID + ":::::::::::::" + rtnListofSupplier);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(rtnListofSupplier);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			DrugAndSupplierMappingMapper mapper = new DrugAndSupplierMappingMapper();
			List<DrugAndSupplierMappingPersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoPersistenceDtoForlistloadSuppliers(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return listOfData;
	}

// select * from sp_select_pharmacy_suplier_mapped_drugs(3)
	@Override
	public List<DrugAndSupplierMappingServiceDto> loadMappedDrugs(DrugAndSupplierMappingServiceDto serviceDto,
			String strRequestID) throws DataNotFoundException {
		List<DrugAndSupplierMappingServiceDto> listOfData;
		String rtnListofSupplier = "select * from sp_select_pharmacy_suplier_mapped_drugs(" + serviceDto.getSupplierId()
				+ ")";
		log.info(strRequestID + ":::::::::::::" + rtnListofSupplier);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(rtnListofSupplier);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			DrugAndSupplierMappingMapper mapper = new DrugAndSupplierMappingMapper();
			List<DrugAndSupplierMappingPersistenceDto> generateNewDrugBarcodePersistenceDto = mapper
					.settingDataIntoPersistenceDtoForLoadMappedDrugs(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(generateNewDrugBarcodePersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No loadSchedule::::::");
		}
		return listOfData;
	}

	@Override
	public String updateMappedDrugToUnMap(DrugAndSupplierMappingServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		String rtnUpdateMappedDrugToUnMap = "select * from sp_update_drug_company_end_date(" + serviceDto.getDrugId()
				+ "," + serviceDto.getSupplierId() + ");";
		log.info(strRequestID + ":::::::::::::" + rtnUpdateMappedDrugToUnMap);
		return objSupervisorDao.getSingleData(rtnUpdateMappedDrugToUnMap);
	}

	/*
	 * drugid character varying, supplierid character varying, purchaseprice
	 * 
	 * character varying, prunitprice character varying, mrp character varying,
	 * unitprice character varying, vat character varying, discount character
	 * varying, startdate character varying, cid integer, mid integer, rid integer,
	 * size integer)
	 */

	@Override
	public String updateDrugSupplierMapping(DrugAndSupplierMappingServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		String rtnUpdateDrugSupplierMappingSttaus = "select * from sp_insert_update_pms_drug_supplier_mapping_pms_drugcompany_xref('"
				+ serviceDto.getDrugId() + "','" + serviceDto.getSupplierId() + "','" + serviceDto.getPurchageprice()
				+ "','" + serviceDto.getPurchageunitcost() + "','" + serviceDto.getMrp() + "','"
				+ serviceDto.getUnitcost() + "','" + serviceDto.getVatpercentag() + "','" + serviceDto.getDiscount()
				+ "','" + serviceDto.getStartdate() + "'," + serviceDto.getCreatedById() + ","
				+ serviceDto.getCreatedByModuleId() + "," + serviceDto.getCreatedByRoleId() + ","
				+ serviceDto.getRowCountSize() + ")";
		log.info(strRequestID + ":::::::::::::" + rtnUpdateDrugSupplierMappingSttaus);
		return objSupervisorDao.getSingleData(rtnUpdateDrugSupplierMappingSttaus);
	}

	@Override
	public String rejectIndentData(RejectIndentDataServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException {
		String rtnUpdateDrugSupplierMappingSttaus = "select * from sp_update_pms_reject_indentanditems('"
				+ serviceDto.getIndentid() + "','" + serviceDto.getDrugid() + "'," + serviceDto.getUserid() + ","
				+ serviceDto.getModuleid() + "," + serviceDto.getRoleid() + "," + serviceDto.getSize() + ",'"
				+ serviceDto.getRemarks() + "')";
		log.info(strRequestID + ":::::::::::::" + rtnUpdateDrugSupplierMappingSttaus);
		return objSupervisorDao.getSingleData(rtnUpdateDrugSupplierMappingSttaus);

	}

	// select * from
	// sp_insert_update_pms_drug_supplier_mapping_pms_drugcompany_xref('148','5','200','10','1000','50','5','2','2020-04-23',268,51,167,1)

}

package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.GetDrugDetailsForApprovalMapper;
import com.pro.scm.mappers.GetMedicinesMapper;
import com.pro.scm.mappers.ListLoadActiveDrugsMapper;
import com.pro.scm.mappers.ListLoadActiveInactiveMapper;
import com.pro.scm.mappers.LoadActiveDrugsMapper;
import com.pro.scm.mappers.LoadDrugTypeMapper;
import com.pro.scm.mappers.LoadLocalIndentDetailsMapper;
import com.pro.scm.mappers.LoadVehiclesSubstoreMapper;
import com.pro.scm.mappers.Store_item_detailsMapper;
import com.pro.scm.persistencedto.GetDrugDetailsForApprovalPersistenceDto;
import com.pro.scm.persistencedto.GetMedicinesPersistenceDto;
import com.pro.scm.persistencedto.ListLoadActiveDrugsPersistenceDto;
import com.pro.scm.persistencedto.ListLoadActiveInactivePersistenceDto;
import com.pro.scm.persistencedto.LoadActiveDrugsPersistenceDto;
import com.pro.scm.persistencedto.LoadDrugTypePersistenceDto;
import com.pro.scm.persistencedto.LoadLocalIndentDetailsPersistenceDto;
import com.pro.scm.persistencedto.LoadVehiclesSubstorePersistenceDto;
import com.pro.scm.persistencedto.Store_item_detailsPersistenceDto;
import com.pro.scm.service.SalesIndentRaisedService;
import com.pro.scm.servicedto.GetAllActiveInactiveServiceDto;
import com.pro.scm.servicedto.GetDrugDetailsForApprovalServiceDto;
import com.pro.scm.servicedto.GetMedicinesCountServiceDto;
import com.pro.scm.servicedto.GetMedicinesServiceDto;
import com.pro.scm.servicedto.ListLoadActiveDrugsCountServiceDto;
import com.pro.scm.servicedto.ListLoadActiveDrugsServiceDto;
import com.pro.scm.servicedto.ListLoadActiveInactiveServiceDto;
import com.pro.scm.servicedto.LoadActiveDrugsServiceDto;
import com.pro.scm.servicedto.LoadDrugTypeServiceDto;
import com.pro.scm.servicedto.LoadLocalIndentServiceDto;
import com.pro.scm.servicedto.LoadVehiclesSubstoreServiceDto;
import com.pro.scm.servicedto.SaveInActiveDrugsServiceDto;
import com.pro.scm.servicedto.Save_vehicle_indent_detailsServiceDto;
import com.pro.scm.servicedto.Store_item_detailsServiceDto;
import com.pro.scm.servicedto.UpdateActiveDrugForApprovalServiceDto;

import lombok.extern.slf4j.Slf4j;

@Service("salesIndentRaisedService")
@SuppressWarnings("unchecked")
@Slf4j
public class SalesIndentRaisedServiceImpl implements SalesIndentRaisedService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public List<LoadVehiclesSubstoreServiceDto> load_vehicles_substore(
			LoadVehiclesSubstoreServiceDto loadVehiclesSubstoreServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("load_vehicles_substore method is executed inside CASDashboardServiceImpl");
		List<LoadVehiclesSubstoreServiceDto> loadVehiclesSubstoreServiceDto1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_scm_load_subStoreVehicles(");
		stringBuilder.append(loadVehiclesSubstoreServiceDto.getBaseLocationId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadVehiclesSubstoreMapper mapper = new LoadVehiclesSubstoreMapper();
			List<LoadVehiclesSubstorePersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoLoadVehiclesSubstorePersistenceDto(list);
			loadVehiclesSubstoreServiceDto1 = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return loadVehiclesSubstoreServiceDto1;
	}

	@Override
	public List<LoadLocalIndentServiceDto> loadLocalIndentDetails(LoadLocalIndentServiceDto loadLocalIndentServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("loadLocalIndentDetails method is executed inside CASDashboardServiceImpl");
		List<LoadLocalIndentServiceDto> loadLocalIndentServiceDto1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_pms_scm_local_indent_drugs(");
		stringBuilder.append("'");
		stringBuilder.append(loadLocalIndentServiceDto.getText());
		stringBuilder.append("'");
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());

		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadLocalIndentDetailsMapper mapper = new LoadLocalIndentDetailsMapper();
			List<LoadLocalIndentDetailsPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoLoadLocalIndentDetailsPersistenceDto(list);
			loadLocalIndentServiceDto1 = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return loadLocalIndentServiceDto1;

	}

	@Override
	public List<Store_item_detailsServiceDto> store_item_details(Store_item_detailsServiceDto loadLocalIndentServiceDto,
			String strRequestID) throws DataNotFoundException {

		log.info("store_item_details method is executed inside CASDashboardServiceImpl");
		List<Store_item_detailsServiceDto> store_item_detailsServiceDto;
		// SELECT * FROM sp_select_scm_load_subStoreVehicles( " + intBaseLocationId + ")
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_store_wise_drugs_to_raise_indent(");
		stringBuilder.append(loadLocalIndentServiceDto.getStoreTypeId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			Store_item_detailsMapper mapper = new Store_item_detailsMapper();
			List<Store_item_detailsPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoStore_item_detailsPersistenceDto(list);
			store_item_detailsServiceDto = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return store_item_detailsServiceDto;

	}

	@Override
	public String save_vehicle_indent_details(
			Save_vehicle_indent_detailsServiceDto save_vehicle_indent_detailsServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("Save_vehicle_indent_detailsServiceDto method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_insert_pms_vehicle_wise_item_indent_details(");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getVehicleId());
		stringBuilder.append(",");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getCount());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getDrugIds());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getIndentQty());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getUserId());
		stringBuilder.append(",");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getRoleId());
		stringBuilder.append(",");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getModuleId());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getIndentStrips());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(save_vehicle_indent_detailsServiceDto.getEmpcode());
		stringBuilder.append("'");
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::Request Id for saveReturnDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<ListLoadActiveInactiveServiceDto> listLoadActiveInactive(
			ListLoadActiveInactiveServiceDto listLoadActiveInactiveServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("listLoadActiveInactiveServiceDto method is executed inside CASDashboardServiceImpl");
		List<ListLoadActiveInactiveServiceDto> listLoadActiveInactiveServiceDto1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_inactive_active_drug_for_approval(");
		stringBuilder.append(listLoadActiveInactiveServiceDto.getDrugstatus());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ListLoadActiveInactiveMapper mapper = new ListLoadActiveInactiveMapper();
			List<ListLoadActiveInactivePersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoListLoadActiveInactivePersistenceDto(list);
			listLoadActiveInactiveServiceDto1 = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return listLoadActiveInactiveServiceDto1;
	}

	@Override
	public String updateActiveDrugForApproval(
			UpdateActiveDrugForApprovalServiceDto updateActiveDrugForApprovalServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("Save_vehicle_indent_detailsServiceDto method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pharmacy_drug_approval_pms_drug_reg_ref(");
		stringBuilder.append(updateActiveDrugForApprovalServiceDto.getSize());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(updateActiveDrugForApprovalServiceDto.getDrugIds());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(updateActiveDrugForApprovalServiceDto.getUserId());
		stringBuilder.append(",");
		stringBuilder.append(updateActiveDrugForApprovalServiceDto.getDrugTypeId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::Request Id for saveReturnDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<GetDrugDetailsForApprovalServiceDto> getDrugDetailsForApproval(
			GetDrugDetailsForApprovalServiceDto getDrugDetailsForApprovalServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("GetDrugDetailsForApprovalServiceDto method is executed inside CASDashboardServiceImpl");
		List<GetDrugDetailsForApprovalServiceDto> GetDrugDetailsForApprovalServiceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_drug_details_pms_drug_approval(");
		stringBuilder.append(getDrugDetailsForApprovalServiceDto.getDrugId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GetDrugDetailsForApprovalMapper mapper = new GetDrugDetailsForApprovalMapper();
			List<GetDrugDetailsForApprovalPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoGetDrugDetailsForApprovalPersistenceDto(list);
			GetDrugDetailsForApprovalServiceDto = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return GetDrugDetailsForApprovalServiceDto;
	}

	@Override
	public List<LoadDrugTypeServiceDto> loadDrugType(String strRequestID) throws DataNotFoundException {
		log.info("loadDrugType method is executed inside CASDashboardServiceImpl");
		List<LoadDrugTypeServiceDto> loadDrugTypeServiceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_drug_Type()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadDrugTypeMapper mapper = new LoadDrugTypeMapper();
			List<LoadDrugTypePersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoLoadDrugTypePersistenceDto(list);
			loadDrugTypeServiceDto = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return loadDrugTypeServiceDto;
	}

	@Override
	public List<LoadActiveDrugsServiceDto> loadActiveDrugs(LoadActiveDrugsServiceDto loadActiveDrugsServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("loadActiveDrugs method is executed inside CASDashboardServiceImpl");
		List<LoadActiveDrugsServiceDto> loadDrugTypeServiceDto;
		StringBuilder stringBuilder = new StringBuilder();
		
		
		stringBuilder.append("select * from sp_select_active_drug_for_approval(");
		stringBuilder.append(loadActiveDrugsServiceDto.getActiveDrug());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadActiveDrugsMapper mapper = new LoadActiveDrugsMapper();
			List<LoadActiveDrugsPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoLoadActiveDrugsPersistenceDto(list);
			loadDrugTypeServiceDto = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return loadDrugTypeServiceDto;
	}

	@Override
	public List<ListLoadActiveDrugsServiceDto> listLoadActiveDrugs(
			ListLoadActiveDrugsServiceDto listLoadActiveDrugsServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("listLoadActiveDrugs method is executed inside CASDashboardServiceImpl");
		List<ListLoadActiveDrugsServiceDto> loadDrugTypeServiceDto;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pharmacy_activedrugs(");
		stringBuilder.append(listLoadActiveDrugsServiceDto.getDrugStatusId());
		stringBuilder.append(")");
		stringBuilder.append(" ");
		stringBuilder.append(" offset ");
		stringBuilder.append(" ");
		stringBuilder.append(listLoadActiveDrugsServiceDto.getOffset());
		stringBuilder.append(" ");
		stringBuilder.append("limit");
		stringBuilder.append(" ");
		stringBuilder.append(listLoadActiveDrugsServiceDto.getPageLimit());
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ListLoadActiveDrugsMapper mapper = new ListLoadActiveDrugsMapper();
			List<ListLoadActiveDrugsPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoListLoadActiveDrugsPersistenceDto(list);
			loadDrugTypeServiceDto = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No listLoadActiveDrugs::::::");
		}
		return loadDrugTypeServiceDto;
	}

	@Override
	public String getAllActiveInactive(GetAllActiveInactiveServiceDto getAllActiveInactiveServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("Save_vehicle_indent_detailsServiceDto method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select cast(count(*) as Integer) from  sp_select_pharmacy_active_inactive_search('");
		stringBuilder.append(getAllActiveInactiveServiceDto.getGenericName());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(getAllActiveInactiveServiceDto.getBrand());
		stringBuilder.append(",");
		stringBuilder.append(getAllActiveInactiveServiceDto.getForm());
		stringBuilder.append(",");
		stringBuilder.append(getAllActiveInactiveServiceDto.getMfg());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(getAllActiveInactiveServiceDto.getUnicode());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(getAllActiveInactiveServiceDto.getActiveOrInactive());
		stringBuilder.append(",");
		stringBuilder.append(getAllActiveInactiveServiceDto.getSystemId());
		stringBuilder.append(",");
		stringBuilder.append(getAllActiveInactiveServiceDto.getGenericGroupId());
		stringBuilder.append(",");
		stringBuilder.append(getAllActiveInactiveServiceDto.getGenericMoleculeId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::Request Id for saveReturnDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String saveInActiveDrugs(SaveInActiveDrugsServiceDto saveInActiveDrugsServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("saveInActiveDrugs method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pharmacy_inactive_drug_pms_drug_reg_ref(");
		stringBuilder.append(saveInActiveDrugsServiceDto.getStatudId());
		stringBuilder.append(",");
		stringBuilder.append(saveInActiveDrugsServiceDto.getListSize());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveInActiveDrugsServiceDto.getActiveDrugs());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(saveInActiveDrugsServiceDto.getRemarks());
		stringBuilder.append("'");
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::Request Id for saveInActiveDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String listLoadActiveDrugsCount(ListLoadActiveDrugsCountServiceDto listLoadActiveDrugsCountServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("saveInActiveDrugs method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(*) from sp_select_pharmacy_activedrugs(");
		stringBuilder.append(listLoadActiveDrugsCountServiceDto.getDrugStatusId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::Request Id for saveInActiveDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String getMedicinesCount(GetMedicinesCountServiceDto getMedicinesCountServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("getMedicinesCount method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select cast(count(*) as Integer) from sp_select_pharmacy_active_drug_search('");
		stringBuilder.append(getMedicinesCountServiceDto.getGenericName());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesCountServiceDto.getBrand());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesCountServiceDto.getForm());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesCountServiceDto.getMfg());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(getMedicinesCountServiceDto.getUnicode());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesCountServiceDto.getSystemId());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesCountServiceDto.getGenericGroupId());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesCountServiceDto.getGenericMoleculeId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::Request Id for getMedicinesCount :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	
	@Override
	public List<GetMedicinesServiceDto> getMedicines(GetMedicinesServiceDto getMedicinesServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("getMedicines method is executed inside CASDashboardServiceImpl");
		List<GetMedicinesServiceDto> medicinesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		stringBuilder.append("select * from sp_select_pharmacy_active_drug_search('");
		stringBuilder.append(getMedicinesServiceDto.getGenericName());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getBrand());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getForm());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getMfg());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(getMedicinesServiceDto.getUnicode());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getSystemId());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getGenericGroupId());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getGenericMoleculeId());
		stringBuilder.append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GetMedicinesMapper mapper = new GetMedicinesMapper();
			List<GetMedicinesPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoGetMedicinesPersistenceDto(list);
			medicinesServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return medicinesServiceDtos;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public List<GetMedicinesServiceDto> getMedicinesForProcessNewInventory(GetMedicinesServiceDto getMedicinesServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("getMedicines method is executed inside CASDashboardServiceImpl");
		List<GetMedicinesServiceDto> medicinesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		stringBuilder.append("select * from sp_select_pharmacy_active_search('");
		stringBuilder.append(getMedicinesServiceDto.getGenericName());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getBrand());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getForm());
		stringBuilder.append(",");
		stringBuilder.append(getMedicinesServiceDto.getMfg());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(getMedicinesServiceDto.getUnicode());
		stringBuilder.append("'");
//		stringBuilder.append(",");
//		stringBuilder.append(getMedicinesServiceDto.getActiveAndInactive());
//		stringBuilder.append(",");
//	    stringBuilder.append(getMedicinesServiceDto.getSystemId());
//		stringBuilder.append(",");
//		stringBuilder.append(getMedicinesServiceDto.getGenericGroupId());
//		stringBuilder.append(",");
//		stringBuilder.append(getMedicinesServiceDto.getGenericMoleculeId());
		stringBuilder.append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GetMedicinesMapper mapper = new GetMedicinesMapper();
			List<GetMedicinesPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoGetMedicinesNewInventoryProcessPersistenceDto(list);
			medicinesServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return medicinesServiceDtos;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<GetMedicinesServiceDto> getMedicinesDetailsBasedOnSerialId(GetMedicinesServiceDto getMedicinesServiceDto,
			String strRequestID) throws DataNotFoundException {
    	log.info("getMedicines method is executed inside CASDashboardServiceImpl");
		List<GetMedicinesServiceDto> medicinesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder("select * from sp_select_equipment_details(")
				.append(getMedicinesServiceDto.getSerialId())
						.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		

		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GetMedicinesMapper mapper = new GetMedicinesMapper();
			List<GetMedicinesPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoGetMedicinesPersistenceDto(list);
			medicinesServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return medicinesServiceDtos;
		
		
	}

	@Override
	public List<GetMedicinesServiceDto> getMedicinesForProcessNewInventoryBasedOnIds(
			GetMedicinesServiceDto getMedicinesServiceDto, String strRequestID) throws DataNotFoundException {
		log.info("getMedicines method is executed inside CASDashboardServiceImpl");
		List<GetMedicinesServiceDto> medicinesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		stringBuilder.append("select * from sp_select_active_pharmacy_based_on_serialid('");
		stringBuilder.append("{").append(getMedicinesServiceDto.getSerialId()).append("}')");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GetMedicinesMapper mapper = new GetMedicinesMapper();
			List<GetMedicinesPersistenceDto> scmLoginPersistenceDto = mapper
					.settingDataIntoGetMedicinesNewInventoryProcessPersistenceDto(list);
			medicinesServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No load_vehicles_substore::::::");
		}
		return medicinesServiceDtos;
	}

}

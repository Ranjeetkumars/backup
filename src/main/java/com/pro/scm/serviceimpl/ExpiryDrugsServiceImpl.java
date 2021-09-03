package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.AjustmentSearchMapper;
import com.pro.scm.mappers.GetUserDropdownMapper;
import com.pro.scm.mappers.ListOfLoadSuppliersMapper;
import com.pro.scm.mappers.LoadAdjustmentTypeMapper;
import com.pro.scm.mappers.LoadBaselocationsMapper;
import com.pro.scm.mappers.LoadExpiryDrugsMapper;
import com.pro.scm.mappers.LoadReturnDrugsMapper;
import com.pro.scm.mappers.LoadStoresMapper;
import com.pro.scm.mappers.LoadSubStoreMapper;
import com.pro.scm.mappers.LoadVehicleTransferItemsMapper;
import com.pro.scm.mappers.LoadVehiclesMapper;
import com.pro.scm.mappers.LoadZonesMapper;
import com.pro.scm.persistencedto.AdjustmentSearchPersistanceDTO;
import com.pro.scm.persistencedto.GetUserDropdownPersistanceDTO;
import com.pro.scm.persistencedto.ListOfLoadSuppliersPersistenceDto;
import com.pro.scm.persistencedto.LoadAdjustmentTypePersistenceDto;
import com.pro.scm.persistencedto.LoadBaselocationsPersistenceDto;
import com.pro.scm.persistencedto.LoadExpiryDrugsPersistencedto;
import com.pro.scm.persistencedto.LoadReturnDrugsPersistenceDto;
import com.pro.scm.persistencedto.LoadStoresPersistenceDto;
import com.pro.scm.persistencedto.LoadSubStorePersistenceDto;
import com.pro.scm.persistencedto.LoadVehicleTransferItemsPersistenceDto;
import com.pro.scm.persistencedto.LoadVehiclesPersistenceDto;
import com.pro.scm.persistencedto.LoadZonesPersistenceDto;
import com.pro.scm.service.ExpiryDrugsService;
import com.pro.scm.servicedto.AdjustmentSearchServiceDTO;
import com.pro.scm.servicedto.ExpiryDrugsServiceDto;
import com.pro.scm.servicedto.GetUserDropdownServiceDTO;
import com.pro.scm.servicedto.ListOfLoadSuppliersServiceDto;
import com.pro.scm.servicedto.LoadAdjustmentTypeServiceDto;
import com.pro.scm.servicedto.LoadBaselocationsServiceDto;
import com.pro.scm.servicedto.LoadExpiryDrugsServiceDto;
import com.pro.scm.servicedto.LoadReturnDrugsServiceDto;
import com.pro.scm.servicedto.LoadStoresServiceDto;
import com.pro.scm.servicedto.LoadSubStoreServiceDto;
import com.pro.scm.servicedto.LoadVehicleTransferItemsServiceDto;
import com.pro.scm.servicedto.LoadVehiclesServiceDto;
import com.pro.scm.servicedto.LoadZonesServiceDto;
import com.pro.scm.servicedto.SaveUpdateItemsServiceDto;

import lombok.extern.slf4j.Slf4j;

@Service("expiryDrugsService")
@SuppressWarnings("unchecked")
@Slf4j
public class ExpiryDrugsServiceImpl implements ExpiryDrugsService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String getVehicleMappingStatus(ExpiryDrugsServiceDto expiryDrugsServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("getVehicleMappingStatus method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_select_vehicle_Maping_status_count("
				+ expiryDrugsServiceDto.getStoreTypeId() + ")");
		log.info(strRequestID + ":::::::::::::::getVehicleMappingStatus:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for getVehicleMappingStatus :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String saveReturnDrugs(ExpiryDrugsServiceDto expiryDrugsServiceDto, String strRequestID)
			throws DataNotFoundException {

		log.info("saveReturnDrugs method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_expiry_return_trans('"
				+ expiryDrugsServiceDto.getDrugid() + "'," + "'" + expiryDrugsServiceDto.getBillNumbeer() + "','"
				+ expiryDrugsServiceDto.getBatchcod() + "','" + expiryDrugsServiceDto.getExpdate() + "','"
				+ expiryDrugsServiceDto.getReturstc() + "'," + "'" + expiryDrugsServiceDto.getFormid() + "',"
				+ expiryDrugsServiceDto.getSupplerid() + "," + expiryDrugsServiceDto.getUserid() + ","
				+ expiryDrugsServiceDto.getModuleid() + "," + expiryDrugsServiceDto.getRoleid() + ","
				+ expiryDrugsServiceDto.getReturnType() + "," + expiryDrugsServiceDto.getStoreid() + ")");
		log.info(strRequestID + ":::::::::::::::saveReturnDrugs:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for saveReturnDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());

	}

	@Override
	public List<LoadExpiryDrugsServiceDto> LoadExpiryDrugs(String strRequestID) throws DataNotFoundException {
		log.info("LoadExpiryDrugs method is executed inside CASDashboardServiceImpl");
		List<LoadExpiryDrugsServiceDto> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select *  from  sp_select_pms_expirydrugs()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadExpiryDrugsMapper mapper = new LoadExpiryDrugsMapper();
			List<LoadExpiryDrugsPersistencedto> drugsPersistencedtos = mapper
					.settingDataIntoLoadExpiryDrugsPersistencedto(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(drugsPersistencedtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadExpiryDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<LoadReturnDrugsServiceDto> LoadReturnDrugs(LoadReturnDrugsServiceDto drugsServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("LoadReturnDrugs method is executed inside ExpiryDrugsServiceImpl");
		List<LoadReturnDrugsServiceDto> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_returntype_drugs(" + drugsServiceDto.getStoreId() + ","
				+ drugsServiceDto.getAdjId() + "," + drugsServiceDto.getTypeId() + "," + drugsServiceDto.getSuplierId()
				+ ")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadReturnDrugsMapper mapper = new LoadReturnDrugsMapper();
			List<LoadReturnDrugsPersistenceDto> returnDrugsPersistenceDtos = mapper
					.settingDataIntoLoadReturnDrugsPersistenceDto(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(returnDrugsPersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<LoadZonesServiceDto> load_zones(String strRequestID) throws DataNotFoundException {
		log.info("LoadReturnDrugs method is executed inside ExpiryDrugsServiceImpl");
		List<LoadZonesServiceDto> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SELECT li_locationid, li_locationname FROM erslocationinfo_ref WHERE li_isactive=true ORDER BY li_locationname");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadZonesMapper mapper = new LoadZonesMapper();
			List<LoadZonesPersistenceDto> zonesPersistenceDtos = mapper.settingDataIntoLoadZonesPersistenceDto(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(zonesPersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;

	}

	@Override
	public List<LoadBaselocationsServiceDto> load_baselocations(LoadBaselocationsServiceDto baselocationsServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("load_baselocations method is executed inside ExpiryDrugsServiceImpl");
		List<LoadBaselocationsServiceDto> baselocationsServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("SELECT lb_locationbaseid, lb_baselocationname FROM  ersloactionbase_ref WHERE lb_locationid = "
						+ baselocationsServiceDto.getZoneId() + " AND lb_isactive=true ORDER BY lb_baselocationname");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadBaselocationsMapper mapper = new LoadBaselocationsMapper();
			List<LoadBaselocationsPersistenceDto> zonesPersistenceDtos = mapper
					.settingDataIntoLoadBaselocationsPersistenceDto(list);
			baselocationsServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(zonesPersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No load_baselocations::");
		}
		return baselocationsServiceDtos;
	}

	@Override
	public List<LoadVehiclesServiceDto> load_vehicles(LoadVehiclesServiceDto vehiclesServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("load_vehicles method is executed inside ExpiryDrugsServiceImpl");
		List<LoadVehiclesServiceDto> vehiclesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SELECT vd_vehicleid, vd_permenantregno, vd_vehicletypeid  FROM fmsvehicledetails_ref, erslocationvehicle_trans WHERE vl_vehicleid = vd_vehicleid  AND vl_locationbaseid =");
		stringBuilder.append(vehiclesServiceDto.getBaselocation());
		stringBuilder.append("AND vl_isactive = true AND vd_isactive = true");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadVehiclesMapper mapper = new LoadVehiclesMapper();
			List<LoadVehiclesPersistenceDto> loadVehiclesPersistenceDtos = mapper
					.settingDataIntoLoadVehiclesPersistenceDto(list);
			vehiclesServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(loadVehiclesPersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No load_baselocations::");
		}
		return vehiclesServiceDtos;

	}

	@Override
	public List<LoadSubStoreServiceDto> loadSubStore(LoadSubStoreServiceDto subStoreServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("loadSubStore method is executed inside ExpiryDrugsServiceImpl");
		List<LoadSubStoreServiceDto> subStoreServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_pms_counter_registration_ref(");
		stringBuilder.append(subStoreServiceDto.getSupStoreTypeId());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadSubStoreMapper mapper = new LoadSubStoreMapper();
			List<LoadSubStorePersistenceDto> subStorePersistenceDtos = mapper
					.settingDataIntoLoadSubStorePersistenceDto(list);
			subStoreServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return subStoreServiceDtos;

	}

	@Override
	public List<LoadAdjustmentTypeServiceDto> loadAdjustmentType(String strRequestID) throws DataNotFoundException {
		log.info("loadAdjustmentType method is executed inside ExpiryDrugsServiceImpl");
		List<LoadAdjustmentTypeServiceDto> typeServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SELECT db_adjustmentid, db_adjustment_desc, db_adjustment_type  FROM   pms_drug_adjustment_ref WHERE db_isactive=true ORDER BY db_adjustment_desc");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadAdjustmentTypeMapper typeMapper = new LoadAdjustmentTypeMapper();
			List<LoadAdjustmentTypePersistenceDto> subStorePersistenceDtos = typeMapper
					.settingDataIntoLoadAdjustmentTypePersistenceDto(list);
			typeServiceDtos = typeMapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return typeServiceDtos;

	}

	@Override
	public List<LoadStoresServiceDto> loadStores(String strRequestID) throws DataNotFoundException {
		log.info("loadStores method is executed inside ExpiryDrugsServiceImpl");
		List<LoadStoresServiceDto> storesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * from  sp_select_counters_ref()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadStoresMapper typeMapper = new LoadStoresMapper();
			List<LoadStoresPersistenceDto> subStorePersistenceDtos = typeMapper
					.settingDataIntoLoadStoresPersistenceDto(list);
			storesServiceDtos = typeMapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return storesServiceDtos;

	}

	@Override
	public List<ListOfLoadSuppliersServiceDto> ListOfLoad(String strRequestID) throws DataNotFoundException {
		log.info("loadStores method is executed inside ExpiryDrugsServiceImpl");
		List<ListOfLoadSuppliersServiceDto> storesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * from  sp_select_counters_ref()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ListOfLoadSuppliersMapper typeMapper = new ListOfLoadSuppliersMapper();
			List<ListOfLoadSuppliersPersistenceDto> subStorePersistenceDtos = typeMapper
					.settingDataIntoListOfLoadSuppliersPersistenceDto(list);
			storesServiceDtos = typeMapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return storesServiceDtos;
	}

	@Override
	public String saveUpdateItems(SaveUpdateItemsServiceDto updateItemsServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("saveUpdateItems method is executed inside ExpiryDrugsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_racks_ref('");
		stringBuilder.append(updateItemsServiceDto.getRackname());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(updateItemsServiceDto.getUserId());
		stringBuilder.append(",");
		stringBuilder.append(updateItemsServiceDto.getRoleId());
		stringBuilder.append(",");
		stringBuilder.append(updateItemsServiceDto.getModuleId());
		stringBuilder.append(",");
		stringBuilder.append(updateItemsServiceDto.getStoreid());
		stringBuilder.append(",");
		stringBuilder.append(updateItemsServiceDto.getStatus());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::saveReturnDrugs:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for saveReturnDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());

	}

	@Override
	public List<LoadVehicleTransferItemsServiceDto> loadVehicleTransferItems(
			LoadVehicleTransferItemsServiceDto subStoreServiceDto, String strRequestID) throws DataNotFoundException {
		log.info("loadVehicleTransferItems method is executed inside ExpiryDrugsServiceImpl");
		List<LoadVehicleTransferItemsServiceDto> vehicleTransferItemsServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_scm_vehciel_based_accept_items_by_transfer(");
		stringBuilder.append(subStoreServiceDto.getVehicleid());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadVehicleTransferItemsMapper typeMapper = new LoadVehicleTransferItemsMapper();
			List<LoadVehicleTransferItemsPersistenceDto> subStorePersistenceDtos = typeMapper
					.settingDataIntoLoadVehicleTransferItemsPersistenceDto(list);
			vehicleTransferItemsServiceDtos = typeMapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return vehicleTransferItemsServiceDtos;

	}

	@Override
	public List<ListOfLoadSuppliersServiceDto> loadSuppliers(String strRequestID) throws DataNotFoundException {
		log.info("loadStores method is executed inside ExpiryDrugsServiceImpl");
		List<ListOfLoadSuppliersServiceDto> storesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT dd_supplierid,dd_suppliername,dd_isactive FROM pms_drugs_supplier_ref");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ListOfLoadSuppliersMapper typeMapper = new ListOfLoadSuppliersMapper();
			List<ListOfLoadSuppliersPersistenceDto> subStorePersistenceDtos = typeMapper
					.settingDataIntoListOfLoadSuppliersPersistenceDtoforloadSuppliers(list);
			storesServiceDtos = typeMapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return storesServiceDtos;
	}

	@Override
	public List<GetUserDropdownServiceDTO> loadUsers(String strRequestID) throws DataNotFoundException {
		log.info("loadStores method is executed inside ExpiryDrugsServiceImpl");
		List<GetUserDropdownServiceDTO> storesServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();

		// stringBuilder.append("select * from sp_select_amsusers_name_id()");

		stringBuilder.append(
				"SELECT us_userid, us_username FROM amsusers_ref WHERE us_isactive = true ORDER BY us_username");

		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			GetUserDropdownMapper typeMapper = new GetUserDropdownMapper();
			List<GetUserDropdownPersistanceDTO> subStorePersistenceDtos = typeMapper.conversionOfBrandDetails(list);
			storesServiceDtos = typeMapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return storesServiceDtos;

	}

	@Override
	public List<AdjustmentSearchServiceDTO> adjustmentSearch(AdjustmentSearchServiceDTO subStoreServiceDto,
			String strRequestID) throws DataNotFoundException {
		log.info("loadSubStore method is executed inside ExpiryDrugsServiceImpl");
		List<AdjustmentSearchServiceDTO> subStoreServiceDtos;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_pms_adjustment_search('");
		stringBuilder.append(subStoreServiceDto.getDrug_name());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getBrand_id());
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getForm_id());
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getManufacture_id());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(subStoreServiceDto.getUnicode());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getSystem_id());
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getGeneric_group_id());
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getGeneric_molecules_id());
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getCounter_id());
		stringBuilder.append(",");
		stringBuilder.append(subStoreServiceDto.getType_id());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AjustmentSearchMapper mapper = new AjustmentSearchMapper();
			List<AdjustmentSearchPersistanceDTO> subStorePersistenceDtos = mapper.conversionOfBrandDetails(list);
			subStoreServiceDtos = mapper.conversionpersistanceDTOtoServiceDTO(subStorePersistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + "::No loadSubStore::");
		}
		return subStoreServiceDtos;
	}

	@Override
	public String updateAdjustmentStatus(ExpiryDrugsServiceDto expiryDrugsServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("updateAdjustmentStatus method is executed inside ExpiryDrugsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_adjustable_trans_returns_type('")
				.append(expiryDrugsServiceDto.getDrug_idlist()).append("','")
				.append(expiryDrugsServiceDto.getDrug_batchlist()).append("',").append(expiryDrugsServiceDto.getSize())
				.append(",").append(expiryDrugsServiceDto.getTypeid()).append(",'")
				.append(expiryDrugsServiceDto.getIntSerialId()).append("')");
		log.info(strRequestID + ":::::::::::::::updateAdjustmentStatus:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for updateAdjustmentStatus :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

}

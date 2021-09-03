package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.DrugVehicleTypeMappingMapper;
import com.pro.scm.mappers.VehicleTypeDrugMapper;
import com.pro.scm.persistencedto.DrugVehicleTypeMappingPersistenanceDTO;
import com.pro.scm.persistencedto.VehicleTypeDrugsPersistenanceDTO;
import com.pro.scm.service.DrugVehicleService;
import com.pro.scm.servicedto.DrugVehicleTypeMappingServiceDTO;

import com.pro.scm.servicedto.MapDrugToVehicleServiceDTO;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("objDrugVehicleService")
@SuppressWarnings("unchecked")
public class DrugVehicleServiceImpl implements DrugVehicleService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public List<DrugVehicleTypeMappingServiceDTO> loadDrugNames(DrugVehicleTypeMappingServiceDTO objServiceDTO,
			String StrRequestId) throws DataNotFoundException {
		log.info("loadDrugNames method is executed inside DrugVehicleServiceImpl");
		List<DrugVehicleTypeMappingServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_drug_reg_ref(").append(objServiceDTO.getSupplierId()).append(")");
		log.info(StrRequestId + ":::::::::::::" + stringBuilder.toString());
	    List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(StrRequestId + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			DrugVehicleTypeMappingMapper objItemShelveMapper = new DrugVehicleTypeMappingMapper();
			List<DrugVehicleTypeMappingPersistenanceDTO> objItemShelvePersistenanceDTO = objItemShelveMapper.conversionForDrugMapping(list);
			listOfData = objItemShelveMapper.conversionpersistanceDTOtoServiceDTO(objItemShelvePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public String saveMapDrugToVehicle(MapDrugToVehicleServiceDTO obMapDrugToVehicleServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveMapDrugToVehicle method is executed inside DrugVehicleServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT sp_insert_pms_pms_drug_vehicle_types_xref(")
		.append(obMapDrugToVehicleServiceDTO.getVehicleId()).append(",").append(obMapDrugToVehicleServiceDTO.getRecords()).append(",'").append(obMapDrugToVehicleServiceDTO.getGroupId()).append("','").append(obMapDrugToVehicleServiceDTO.getDrugId()).append("',")
		.append(obMapDrugToVehicleServiceDTO.getOperationType()).append(",").append(obMapDrugToVehicleServiceDTO.getUserId())
		.append(",").append(obMapDrugToVehicleServiceDTO.getRoleId()).append(",").append(obMapDrugToVehicleServiceDTO.getModuleId()).append(")");
		log.info(strRequestID + ":::::::::::::::saveGenericName:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<VehicleTypeDrugsServiceDTO> loadVehicleTypeWiseDrugDetails(VehicleTypeDrugsServiceDTO objVehicleTypeDrugsServiceDTO,String strRequestID)
			throws DataNotFoundException {
		log.info("loadVehicleTypeWiseDrugDetails method is executed inside MasterDataServiceImpl");
		List<VehicleTypeDrugsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_get_allitemsbyvehicles(").append(objVehicleTypeDrugsServiceDTO.getVehicleType()).append(",").append(objVehicleTypeDrugsServiceDTO.getMappedType()).append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			VehicleTypeDrugMapper objVehicleTypeDrugMapper = new VehicleTypeDrugMapper();
			List<VehicleTypeDrugsPersistenanceDTO> objVehicleTypeDrugsPersistenanceDTO = objVehicleTypeDrugMapper.conversionOFVehicleTypeWiseDrugDetails(list);
			listOfData = objVehicleTypeDrugMapper.conversionpersistanceDTOtoServiceDTO(objVehicleTypeDrugsPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}

	
	@Override
	public List<?> loadVehicleTypeWiseDrugDetails_Get(Integer vehicleTypeId, Integer mappedTypeId, String strRequestID)
			throws DataNotFoundException {
		// TODO Auto-generated method stub
		log.info("loadVehicleTypeWiseDrugDetails method is executed inside MasterDataServiceImpl");
		List<VehicleTypeDrugsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_get_allitemsbyvehicles(").append(vehicleTypeId).append(",").append(mappedTypeId).append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			VehicleTypeDrugMapper objVehicleTypeDrugMapper = new VehicleTypeDrugMapper();
			List<VehicleTypeDrugsPersistenanceDTO> objVehicleTypeDrugsPersistenanceDTO = objVehicleTypeDrugMapper.conversionOFVehicleTypeWiseDrugDetails(list);
			listOfData = objVehicleTypeDrugMapper.conversionpersistanceDTOtoServiceDTO(objVehicleTypeDrugsPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public List<VehicleTypeDrugsServiceDTO> AmbulanceType(String strRequestID) throws DataNotFoundException {
		log.info("AmbulanceType method is executed");
		List<VehicleTypeDrugsServiceDTO> listOfData;
	    String str = "SELECT vt_vehicletypeid, vt_vehicle_type FROM vmsvehicletypes_ref WHERE vt_isactive=true ORDER BY vt_vehicletypeid";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			VehicleTypeDrugMapper objVehicleTypeDrugMapper = new VehicleTypeDrugMapper();
			List<VehicleTypeDrugsPersistenanceDTO> objVehicleTypeDrugsPersistenanceDTO = objVehicleTypeDrugMapper.conversionOFAmbulanceType(list);
			listOfData = objVehicleTypeDrugMapper.conversionpersistanceDTOtoServiceDTO(objVehicleTypeDrugsPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}

	

	
}



//

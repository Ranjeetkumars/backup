package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.VehicleSubStoreMapper;
import com.pro.scm.persistencedto.VehicleSubStorePersistenaceDTO;
import com.pro.scm.service.VehicleSubStoreService;
import com.pro.scm.servicedto.VehicleSubStoreServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objVehicleSubStoreService")
@SuppressWarnings("unchecked")
public class VehicleSubStoreServiceImpl implements VehicleSubStoreService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	@Override
	public List<VehicleSubStoreServiceDTO> loadVehicleSubStoreMapping(String strRequestID)
			throws DataNotFoundException {
		log.info("loadVehicleSubStoreMapping method is executed inside MasterDataServiceImpl");
		List<VehicleSubStoreServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_substore_vehicle_xref()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
	
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			VehicleSubStoreMapper objVehicleSubStoreMapper = new VehicleSubStoreMapper();
			List<VehicleSubStorePersistenaceDTO> objVehicleSubStorePersistenaceDTO = objVehicleSubStoreMapper.conversionForvehicleSubStoremapping(list);
			listOfData = objVehicleSubStoreMapper.conversionpersistanceDTOtoServiceDTO(objVehicleSubStorePersistenaceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public String getStatusVehicleCount(VehicleSubStoreServiceDTO objVehicleSubStoreServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("getStatusVehicleCount method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_select_count_mapping_vehicles_status(").append(objVehicleSubStoreServiceDTO.getVehicleId()+")");
		log.info(strRequestID + ":::::::::::::::getStatusVehicleCount:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	
	
//	
	
	
	@Override
	public String saveVehicleSubStoreMapping(VehicleSubStoreServiceDTO objVehicleSubStoreServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveVehicleSubStoreMapping method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_substore_vehicle_xref(").append(objVehicleSubStoreServiceDTO.getSubStoreId()).append(",")
		.append(objVehicleSubStoreServiceDTO.getVehicleId()).append(",").append("'").append(objVehicleSubStoreServiceDTO.getDescription()).append("'").append(",")
		.append(objVehicleSubStoreServiceDTO.getUserId()).append(",").append(objVehicleSubStoreServiceDTO.getModuleId()).append(",").append(objVehicleSubStoreServiceDTO.getRoleId())
	.append(",").append(objVehicleSubStoreServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveVehicleSubStoreMapping:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	

	
	@Override
	public String updateVehicleSubStoreMapping(VehicleSubStoreServiceDTO objVehicleSubStoreServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("updateVehicleSubStoreMapping method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_substore_vehicle_xref(")
				.append(objVehicleSubStoreServiceDTO.getSubStoreId()).append(",").append("'").append(objVehicleSubStoreServiceDTO.getDescription()).append("'").append(",")
				.append(objVehicleSubStoreServiceDTO.getUserId()).append(",").append(objVehicleSubStoreServiceDTO.getModuleId()).append(",")
				.append(objVehicleSubStoreServiceDTO.getRoleId()).append(",").append(objVehicleSubStoreServiceDTO.getStatus()).append(",")
				.append(objVehicleSubStoreServiceDTO.getSerialId()).append(")");
		log.info(strRequestID + ":::::::::::::::saveVehicleSubStoreMapping:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
}

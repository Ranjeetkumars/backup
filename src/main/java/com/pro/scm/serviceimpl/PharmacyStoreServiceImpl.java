package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.StoreMapper;
import com.pro.scm.persistencedto.StorepersistenanceDTO;
import com.pro.scm.service.PharmacyStoreService;
import com.pro.scm.servicedto.PharmacyStoreServiceDTO;
import com.pro.scm.servicedto.StoreServiceDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objPharmacyStoreService")
@SuppressWarnings("unchecked")
public class PharmacyStoreServiceImpl implements PharmacyStoreService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String addStores(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("addStores method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_masters_insert_pms_counter_registration_ref('")
				.append(objPharmacyStoreServiceDTO.getStoreName()).append("','")
				.append(objPharmacyStoreServiceDTO.getDescription()).append("',")
				.append(objPharmacyStoreServiceDTO.getUserId()).append(",")
				.append(objPharmacyStoreServiceDTO.getRoleId()).append(",")
				.append(objPharmacyStoreServiceDTO.getModuleId()).append(",")
				.append(objPharmacyStoreServiceDTO.getStatus()).append(",")
				.append(objPharmacyStoreServiceDTO.getTypeStoreId()).append(")");
		log.info(strRequestID + ":::::::::::::::addStores:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String UpdateStores(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("UpdateStores method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_counter_registration_ref('")
				.append(objPharmacyStoreServiceDTO.getStoreName()).append("','")
				.append(objPharmacyStoreServiceDTO.getDescription()).append("',")
				.append(objPharmacyStoreServiceDTO.getStatus()).append(",")
				.append(objPharmacyStoreServiceDTO.getStoreId()).append(")");
		log.info(strRequestID + ":::::::::::::::UpdateStores:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String checkPharmacyStoreExist(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("checkPharmacyStoreExist method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_pharmacy_store_isexist_ref('")
				.append(objPharmacyStoreServiceDTO.getStoreName()).append("')");
		log.info(strRequestID + ":::::::::::::::checkPharmacyStoreExist:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String getStoreStatus(PharmacyStoreServiceDTO objPharmacyStoreServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("PharmacyStoreServiceDTO method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_select_count_store_status(")
				.append(objPharmacyStoreServiceDTO.getStoreId()).append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<StoreServiceDTO> loadPharmacyStores(String strRequestID) throws DataNotFoundException {
		log.info("loadPharmacyStores method is executed inside RackDetailsServiceImpl");
		List<StoreServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_load_storeDetails()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			StoreMapper objStoreMapper = new StoreMapper();
			List<StorepersistenanceDTO> objStorepersistenanceDTO = objStoreMapper.conversionForpharmacyStores(list);
			listOfData = objStoreMapper.conversionpersistanceDTOtoServiceDTO(objStorepersistenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<StoreServiceDTO> loadStoreType(String strRequestID) throws DataNotFoundException {
		log.info("loadStoreType method is executed inside RackDetailsServiceImpl");
		List<StoreServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * from sp_select_load_storeType()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			StoreMapper objStoreMapper = new StoreMapper();
			List<StorepersistenanceDTO> objStorepersistenanceDTO = objStoreMapper.conversionForStoreType(list);
			listOfData = objStoreMapper.conversionpersistanceDTOtoServiceDTO(objStorepersistenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}
}

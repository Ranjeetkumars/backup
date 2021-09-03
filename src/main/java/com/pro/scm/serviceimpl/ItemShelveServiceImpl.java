package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.ItemShelveMapper;
import com.pro.scm.mappers.LoadItemMapper;
import com.pro.scm.mappers.LoadShelveMapper;
import com.pro.scm.mappers.ShelveRackMapper;
import com.pro.scm.persistencedto.ItemShelvePersistenanceDTO;
import com.pro.scm.persistencedto.LoadItemPersistenanceDTO;
import com.pro.scm.persistencedto.LoadShelvePersistenanceDTO;
import com.pro.scm.persistencedto.ShelveRackPersistenanceDTO;
import com.pro.scm.service.ItemShelveService;
import com.pro.scm.servicedto.ItemShelveDetailsServiceDTO;
import com.pro.scm.servicedto.LoadItemServiceDTO;
import com.pro.scm.servicedto.LoadShelveServiceDTO;
import com.pro.scm.servicedto.ShelveRackServiceDTO;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objItemShelveService")
@SuppressWarnings("unchecked")
public class ItemShelveServiceImpl implements ItemShelveService{
	
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public String saveItemShelveDetails(ItemShelveDetailsServiceDTO objItemShelveDetailsServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveItemShelveDetails method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_selfs_xref('")
		.append(objItemShelveDetailsServiceDTO.getStoreId()).append("',").append(objItemShelveDetailsServiceDTO.getRackId()).append(",").append(objItemShelveDetailsServiceDTO.getShelveId()).append(",").append(objItemShelveDetailsServiceDTO.getItemId()).append(",")
		.append(objItemShelveDetailsServiceDTO.getUserId()).append(",").append(objItemShelveDetailsServiceDTO.getRoleId()).append(",").append(objItemShelveDetailsServiceDTO.getModuleId() + ","  + objItemShelveDetailsServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveItemShelveDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public String updateShelveItems(ItemShelveDetailsServiceDTO objItemShelveDetailsServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("updateShelveItems method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_selfs_xref(")
		.append(objItemShelveDetailsServiceDTO.getStoreId()).append(",").append(objItemShelveDetailsServiceDTO.getRackId()).append(",").append(objItemShelveDetailsServiceDTO.getShelveId()) 
		.append(",").append(objItemShelveDetailsServiceDTO.getItemId()).append(",").append(objItemShelveDetailsServiceDTO.getUserId()).append(",").append(objItemShelveDetailsServiceDTO.getRoleId())
		.append(",").append(objItemShelveDetailsServiceDTO.getModuleId()).append(",").append(objItemShelveDetailsServiceDTO.getStatus()) 
		.append(",").append(objItemShelveDetailsServiceDTO.getRackShelveId()).append(")");
		log.info(strRequestID + ":::::::::::::::updateShelveItems:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<ItemShelveDetailsServiceDTO> loadRackByStores(ItemShelveDetailsServiceDTO objItemShelveDetailsServiceDTO,String strRequestID)
			throws DataNotFoundException {
		log.info("loadRackByStores method is executed inside MasterDataServiceImpl");
		List<ItemShelveDetailsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_allRackDetailsbyStoreid(").append(objItemShelveDetailsServiceDTO.getStoreId()).append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ItemShelveMapper objItemShelveMapper = new ItemShelveMapper();
			List<ItemShelvePersistenanceDTO> objItemShelvePersistenanceDTO = objItemShelveMapper.conversionForRackbyStore(list);
			listOfData = objItemShelveMapper.conversionpersistanceDTOtoServiceDTO(objItemShelvePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public List<LoadItemServiceDTO> loadItems(LoadItemServiceDTO objLoadItemServiceDTO,String strRequestID)
			throws DataNotFoundException {
		log.info("loadItems method is executed inside MasterDataServiceImpl");
		List<LoadItemServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_allItems(").append(objLoadItemServiceDTO.getStoreId()).append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadItemMapper objLoadItemMapper = new LoadItemMapper();
			List<LoadItemPersistenanceDTO> objLoadItemPersistenanceDTO = objLoadItemMapper.conversionForLoadItems(list);
			listOfData = objLoadItemMapper.conversionpersistanceDTOtoServiceDTO(objLoadItemPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public List<LoadShelveServiceDTO> loadShelves(LoadShelveServiceDTO objLoadShelveServiceDTO,String strRequestID)
			throws DataNotFoundException {
		log.info("loadShelves method is executed inside MasterDataServiceImpl");
		List<LoadShelveServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_allSelfDetails(").append(objLoadShelveServiceDTO.getStoreId())
		.append(",").append(objLoadShelveServiceDTO.getRackId()).append(")");
		
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadShelveMapper objLoadShelveMapper = new LoadShelveMapper();
			List<LoadShelvePersistenanceDTO>objLoadItemPersistenanceDTO = objLoadShelveMapper.conversionForShelves(list);
			listOfData = objLoadShelveMapper.conversionpersistanceDTOtoServiceDTO(objLoadItemPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public List<ShelveRackServiceDTO> loadShelvesRack(ShelveRackServiceDTO objShelveRackServiceDTO,String strRequestID)
			throws DataNotFoundException {
		log.info("loadShelvesRack method is executed inside MasterDataServiceImpl");
		List<ShelveRackServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_allRakcShelf_Items(").append(objShelveRackServiceDTO.getStoreId()).append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ShelveRackMapper objShelveRackMapper = new ShelveRackMapper();
			List<ShelveRackPersistenanceDTO>objLoadItemPersistenanceDTO = objShelveRackMapper.conversionForRackShelve(list);
			listOfData = objShelveRackMapper.conversionpersistanceDTOtoServiceDTO(objLoadItemPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}

	@Override
	public List<ShelveRackServiceDTO> loadStore(String strRequestID) throws DataNotFoundException {
		log.info("loadStore method is executed");
		List<ShelveRackServiceDTO> listOfData;
		String strSpStore = "SELECT * FROM sp_pms_select_pms_counter_registration_ref()";
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strSpStore);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			
			ShelveRackMapper objShelveRackMapper = new ShelveRackMapper();
			List<ShelveRackPersistenanceDTO>objLoadItemPersistenanceDTO = objShelveRackMapper.conversionForStore(list);
			listOfData = objShelveRackMapper.conversionpersistanceDTOtoServiceDTO(objLoadItemPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}

}

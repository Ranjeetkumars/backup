package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.RackShelveDetailsMapper;
import com.pro.scm.persistencedto.RackShelvePersistenanceDTO;
import com.pro.scm.service.RackShelveDetailsService;
import com.pro.scm.servicedto.RackShelveServiceDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("objRackShelveDetailsService")
public class RackShelveDetailsServiceImpl implements RackShelveDetailsService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public String saveRackShelveDetails(RackShelveServiceDTO objRackShelveServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveRackShelveDetails method is executed inside RackShelveDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_selfs_reff('")
		.append(objRackShelveServiceDTO.getShelveName()).append("',").append(objRackShelveServiceDTO.getUserId()).append(",").append(objRackShelveServiceDTO.getRoleId()).append(",").append(objRackShelveServiceDTO.getModuleId()).append(",")
		.append(objRackShelveServiceDTO.getStoreId()).append(",'").append(objRackShelveServiceDTO.getRackId()).append("',").append(objRackShelveServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveRackShelveDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public String updateRackShelveDetails(RackShelveServiceDTO objRackShelveServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("updateRackShelveDetails method is executed inside RackShelveDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_selfs_ref('")
		.append(objRackShelveServiceDTO.getShelveName()).append("',").append(objRackShelveServiceDTO.getUserId()).append(",").append(objRackShelveServiceDTO.getRoleId())
		.append(",").append(objRackShelveServiceDTO.getModuleId()).append(",").append(objRackShelveServiceDTO.getStoreId()).append(",").append(objRackShelveServiceDTO.getRackId())
		.append(",").append(objRackShelveServiceDTO.getStatus()).append(",").append(objRackShelveServiceDTO.getShelveId()).append(")");
		log.info(strRequestID + ":::::::::::::::updateRackShelveDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<RackShelveServiceDTO> loadRackShelveDetails(String strRequestID)
			throws DataNotFoundException {
		log.info("loadRackShelveDetails method is executed inside RackShelveDetailsServiceImpl");
		List<RackShelveServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_allRackSelfDetails()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			RackShelveDetailsMapper objRackShelveDetailsMapper = new RackShelveDetailsMapper();
			List<RackShelvePersistenanceDTO> objRackShelvePersistenanceDTO = objRackShelveDetailsMapper.conversionForRackShelveDetails(list);
			listOfData = objRackShelveDetailsMapper.conversionpersistanceDTOtoServiceDTO(objRackShelvePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
}

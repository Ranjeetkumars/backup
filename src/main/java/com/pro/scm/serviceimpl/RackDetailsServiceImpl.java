package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.RackDetailsMapper;
import com.pro.scm.persistencedto.RackDetailsperistenanceDTO;
import com.pro.scm.service.RackDetailsService;
import com.pro.scm.servicedto.RackDetailsServiceDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("objRackDetailsService")
public class RackDetailsServiceImpl implements RackDetailsService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public String saveRackDetails(RackDetailsServiceDTO objRackDetailsServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveRackDetails method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_racks_ref('")
		.append(objRackDetailsServiceDTO.getRackName()).append("',").append(objRackDetailsServiceDTO.getUserId()).append(",").append(objRackDetailsServiceDTO.getRoleId()).append(",").append(objRackDetailsServiceDTO.getModuleId()).append(",")
		.append(objRackDetailsServiceDTO.getStoreId()).append(",").append(objRackDetailsServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveRackShelveDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public String UpdateRackDetails(RackDetailsServiceDTO objRackDetailsServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("UpdateRackDetails method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_racks_ref('")
		.append(objRackDetailsServiceDTO.getRackName()).append("',").append(objRackDetailsServiceDTO.getUserId()).append(",").append(objRackDetailsServiceDTO.getRoleId()) 
		.append(",").append(objRackDetailsServiceDTO.getModuleId()).append(",").append(objRackDetailsServiceDTO.getStoreId()).append(",").append(objRackDetailsServiceDTO.getRackId())
		.append(",").append(objRackDetailsServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::UpdateRackDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<RackDetailsServiceDTO> loadRackDetails(String strRequestID)
			throws DataNotFoundException {
		log.info("loadRackShelveDetails method is executed inside RackDetailsServiceImpl");
		List<RackDetailsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_allRackDetails()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			RackDetailsMapper objRackDetailsMapper = new RackDetailsMapper();
			List<RackDetailsperistenanceDTO> objRackDetailsperistenanceDTO = objRackDetailsMapper.conversionForRackDetails(list);
			listOfData = objRackDetailsMapper.conversionpersistanceDTOtoServiceDTO(objRackDetailsperistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
}

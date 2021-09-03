package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.ScheduleMapper;
import com.pro.scm.persistencedto.SchedulePeristenanceDTO;
import com.pro.scm.service.ScheduleService;
import com.pro.scm.servicedto.ScheduleServiceDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("objScheduleService")
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public String saveSchedule(ScheduleServiceDTO objScheduleServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveSchedule method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_schdule_ref('")
		.append(objScheduleServiceDTO.getScheduleName()).append("',").append(objScheduleServiceDTO.getUserId()).append(",").append(objScheduleServiceDTO.getModuleId()).append(",").append(objScheduleServiceDTO.getRoleId()).append(",")
		.append(objScheduleServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveSupplier:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public String updateScheduleStores(ScheduleServiceDTO objScheduleServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("updateSupplier method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_schdule_ref('")
		.append(objScheduleServiceDTO.getScheduleName()).append("',").append(objScheduleServiceDTO.getStatus()).append(",").append(objScheduleServiceDTO.getScheduleId()).append(")");
		log.info(strRequestID + ":::::::::::::::saveSupplier:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<ScheduleServiceDTO> loadSchedule(String strRequestID)
			throws DataNotFoundException {
		log.info("loadClassification method is executed inside MasterDataServiceImpl");
		List<ScheduleServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		//select * from sp_select_pms_drug_schdule_ref_all_data()
		stringBuilder.append("SELECT ds_scheduleid, ds_schdule_type, ds_isactive FROM pms_drug_schdule_ref");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ScheduleMapper objScheduleMapper = new ScheduleMapper();
			List<SchedulePeristenanceDTO> objSchedulePeristenanceDTO = objScheduleMapper.conversionForLoadSchedules(list);
			listOfData = objScheduleMapper.conversionpersistanceDTOtoServiceDTO(objSchedulePeristenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
}

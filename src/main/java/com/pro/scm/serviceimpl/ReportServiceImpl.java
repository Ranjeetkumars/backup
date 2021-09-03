package com.pro.scm.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.ReportMapper;
import com.pro.scm.persistencedto.ReportPersistenceDTO;
import com.pro.scm.service.ReportService;
import com.pro.scm.servicedto.ReportServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objReportServiceImpl")
@SuppressWarnings("unchecked")
public class ReportServiceImpl implements ReportService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public List<ReportServiceDTO> getIPFields(ReportServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		List<ReportServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_report_report_parameter_xref(").append(dataInfo.getReportId()).append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ReportMapper dataMapper = new ReportMapper();
			List<ReportPersistenceDTO> ReportPersistencePersDTOs = dataMapper.ConvertDataToGetIPFields(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(ReportPersistencePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<ReportServiceDTO> loadReports(ReportServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		List<ReportServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_report_reportnames_ref(").append(dataInfo.getModuleId()).append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ReportMapper dataMapper = new ReportMapper();
			List<ReportPersistenceDTO> ReportPersistencePersDTOs = dataMapper.ConvertDataToGetLoadReports(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(ReportPersistencePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<ReportServiceDTO> loadModules(String strRequestID) throws DataNotFoundException {
		List<ReportServiceDTO> datas = new ArrayList<ReportServiceDTO>();
		ReportMapper dataMapper = new ReportMapper();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_amsmodules_ref_id_name()");
		log.info(strRequestID + ":::::::::::::::loadModules():::::::::::" + stringBuilder.toString());

		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<ReportPersistenceDTO> reportPersDTOs = dataMapper.convertObjetsArraytoGetModules(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(reportPersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::loadModules()::::::");
		}
		return datas;

	}
}

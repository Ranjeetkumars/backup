package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.SMCLoginMapper;
import com.pro.scm.persistencedto.SCMLoginPersistenceDto;
import com.pro.scm.service.SCMLoginService;
import com.pro.scm.servicedto.SCMLoginServiceDto;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unchecked")
@Service("scmLoginService")
@Slf4j
public class SCMLoginServiceImpl implements SCMLoginService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public List<SCMLoginServiceDto> loadRoles(SCMLoginServiceDto scmLoginServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("getfailedDispatches method is executed inside CASDashboardServiceImpl");
		List<SCMLoginServiceDto> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT rl_roleid, rl_rolename FROM amsroles_ref where rl_moduleid="
				+ scmLoginServiceDto.getModuleId() + " and rl_isactive=" + true);
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		// List<Object[]> list = (List<Object[]>)
		// objSupervisorDao.getData(stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao
				.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SMCLoginMapper mapper = new SMCLoginMapper();
			List<SCMLoginPersistenceDto> scmLoginPersistenceDto = mapper.settingDataIntoSCMLoginPersistenceDto(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(scmLoginPersistenceDto);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No getErsEventInfo::::::");
		}
		return listOfData;
	}

	@Override
	public String getRoles(SCMLoginServiceDto scmLoginServiceDto, String strRequestID) throws DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_roleid_foruser('" + scmLoginServiceDto.getUserName() + "',"
				+ scmLoginServiceDto.getModuleId() + ")");
		log.info(strRequestID + ":::::::::::::::getRoles:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for getRoles :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String checkRoleforUser(SCMLoginServiceDto scmLoginServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("checkRoleforUser method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_user_for_role('" + scmLoginServiceDto.getModuleId() + "',"
				+ scmLoginServiceDto.getRoleId() + "," + scmLoginServiceDto.getUserId() + ")");
		log.info(strRequestID + ":::::::::::::::checkRoleforUser:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for checkRoleforUser :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String updateCounterId(SCMLoginServiceDto scmLoginServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("updateCounterId method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_user_counter_id(" + scmLoginServiceDto.getUserId() + ","
				+ scmLoginServiceDto.getCounterId() + ")");
		log.info(strRequestID + ":::::::::::::::checkRoleforUser:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for checkRoleforUser :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

}

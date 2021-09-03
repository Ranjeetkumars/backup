package com.pro.scm.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.GenericNameMapper;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.persistencedto.GenericNamePersistenceDTO;
import com.pro.scm.persistencedto.PlacingOrdersForPurchasePersistanceDTO;
import com.pro.scm.service.GenericNameService;
import com.pro.scm.servicedto.GenericServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.wrappers.GenericNameWrapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("objGenericNameService")
public class GenericNameServiceImpl implements GenericNameService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	@Override
	public String saveGenericName(GenericServiceDTO objGenericServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveGenericName method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_genericname_ref('")
		.append(objGenericServiceDTO.getGenericName()).append("','").append(objGenericServiceDTO.getShortCode()).append("',").append(objGenericServiceDTO.getModuleId()).append(",").append(objGenericServiceDTO.getRoleId()).append(",")
		.append(objGenericServiceDTO.getUserId()).append(",").append(objGenericServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveGenericName:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public String updateGenericName(GenericServiceDTO objGenericServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("updateGenericName method is executed inside RackDetailsServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_genericname_ref('")
		.append(objGenericServiceDTO.getGenericName()).append("','").append(objGenericServiceDTO.getShortCode()) 
		.append("',").append(objGenericServiceDTO.getStatus()).append(",").append(objGenericServiceDTO.getGenericId()).append(")");
		
		System.out.println("Quert::"+stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::updateGenericName:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<GenericServiceDTO> getdrugsName(String strRequestID) throws DataNotFoundException {
		List<GenericServiceDTO> datas = new ArrayList<GenericServiceDTO>();
		GenericNameMapper objGenericNameMapper = new GenericNameMapper();
		GenericNameWrapper objGenericNameWrapper = new GenericNameWrapper();
		//String strQuery = "select * from sp_select_pms_generic_names()";
		String strQuery = "SELECT dgn_serialid, dgn_genericname,dgn_unic_short_code,dgn_isactive FROM pms_drug_genericname_ref";
		//
		log.info(strRequestID + ":::::::::::::::getdrugsName:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		if (null != list && !list.isEmpty()) {
			List<GenericNamePersistenceDTO> genericNamePersDTOs = objGenericNameMapper
					.convertObjetsArraytoGetdrugsName(list);
			datas = objGenericNameMapper.conversionpersistanceDTOtoServiceDTO(genericNamePersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::getAllSuppliers()::::::");
		}
		return datas;

	}

}

package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.DrugsDetailsBasedOnDrugIdMapper;
import com.pro.scm.mappers.ItemApprovalMapper;
import com.pro.scm.persistencedto.DrugsDetailsBasedOnDrugIdPerssisteenceDto;
import com.pro.scm.persistencedto.ItemApprovalPersistenceDto;
import com.pro.scm.service.ItemApprovalService;
import com.pro.scm.servicedto.DrugsDetailsBasedOnDrugIdServiceDto;
import com.pro.scm.servicedto.ItemApprovalServiceDto;

import lombok.extern.slf4j.Slf4j;
@SuppressWarnings("unchecked")
@Service("itemApprovalService")
@Slf4j
public class ItemApprovalServiceImpl implements ItemApprovalService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	@Override
	public List<ItemApprovalServiceDto> getActiveDrugs(ItemApprovalServiceDto serviceDto, String req)
			throws DataNotFoundException {
		log.info("load_to_store method is executed inside IndentViewServiceImpl");
		List<ItemApprovalServiceDto> listOfData;
		String strQuery ="select * from sp_select_active_drug_for_approval("+serviceDto.getActiveId()+")";
		log.info(req + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		if (null != list && !list.isEmpty() && list.size() > 0) {
		ItemApprovalMapper mapper = new ItemApprovalMapper();
		List<ItemApprovalPersistenceDto> persistenceDtos = mapper.convertObjetsArraytoPersistenceDto(list);
		
		listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
	} else {
		throw new DataNotFoundException(req + ":::::::No LoadReturnDrugs::::::");
	}
	return listOfData;
}

	@Override
	public List<DrugsDetailsBasedOnDrugIdServiceDto> getDrugsDetailsBasedOnDrugId(DrugsDetailsBasedOnDrugIdServiceDto serviceDto, String req)
			throws DataNotFoundException {
		log.info("getDrugsDetailsBasedOnDrugId method is executed ");
		List<DrugsDetailsBasedOnDrugIdServiceDto> listOfData;
		String strQuery ="select * from sp_select_drug_details_pms_drug_form_ref("+serviceDto.getStrdrugId()+")";
		log.info(req + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		if (null != list && !list.isEmpty() && list.size() > 0) {
			DrugsDetailsBasedOnDrugIdMapper mapper = new DrugsDetailsBasedOnDrugIdMapper();
		List<DrugsDetailsBasedOnDrugIdPerssisteenceDto> persistenceDtos = mapper.convertObjetsArraytoPersistenceDtoForrDrugsDetails(list);
		
		
		
		
		listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
	} else {
		throw new DataNotFoundException(req + ":::::::No getDrugsDetailsBasedOnDrugId::::::");
	}
	return listOfData;
	}
	
	
	
	

	
	
	

}

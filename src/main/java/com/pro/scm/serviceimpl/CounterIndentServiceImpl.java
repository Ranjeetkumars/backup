package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.CounterIndentMapper;
import com.pro.scm.persistencedto.CounterIndentPersistenceDTO;
import com.pro.scm.service.CounterIndentService;
import com.pro.scm.servicedto.CounterIndentServiceDTO;
import lombok.extern.slf4j.Slf4j;


@SuppressWarnings("unchecked")
@Service("counterIndentService")
@Slf4j
public class CounterIndentServiceImpl implements CounterIndentService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String insertRaiseCounterIndentQuantity(CounterIndentServiceDTO serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("insertRaiseCounterIndentQuantity method is executed inside counterIndentService");
		String strQuery = "select * from sp_insert_pms_scm_ind_retailcounter_wise_item_trans('"
				+ serviceDto.getDrugidlist() + "','" + serviceDto.getQuantitylist() + "'," + serviceDto.getCreatedbyid()
				+ "," + serviceDto.getCreatedbyroleid() + "," + serviceDto.getCreatedbymoduleid() + ","
				+ serviceDto.getSize() + ",'" + serviceDto.getIndentnumber() + "'," + serviceDto.getIndenttype() + ","
				+ serviceDto.getFromcnterid() + "," + serviceDto.getTocnterid() + "," + serviceDto.getIndstatusid()
				+ ")";
	    log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}
	
	@Override
	public List<CounterIndentServiceDTO> getGenerateRetailIndentNumber(CounterIndentServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("getGenerateRetailIndentNumber method is executed inside ExpiryDrugsServiceImpl");
		List<CounterIndentServiceDTO> listOfData;
		String strQuery="SELECT count(distinct lir_reqid)+1 as maxindent FROM pms_scm_ind_retail_wise_item_req_trans where cast(lir_createdbydtm as date)= '"+serviceDTO.getCurrentdate()+"'";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			CounterIndentMapper mapper = new CounterIndentMapper();
			List<CounterIndentPersistenceDTO> persistenceDtos = mapper.getGenerateRetailIndentNumber(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public String updateItemStatus(CounterIndentServiceDTO serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("updateItemStatus method is executed inside counterIndentService");
		String strQuery = "select * from sp_update_indent_raised_item_approval('"
				+ serviceDto.getIndentnumber()+ "','" + serviceDto.getDrugId()+ "'," + serviceDto.getSize()
				+ ")";
	    log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}

	@Override
	public List<CounterIndentServiceDTO> loadIndentItemsList(CounterIndentServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadIndentItemsList method is executed inside ExpiryDrugsServiceImpl");
		List<CounterIndentServiceDTO> listOfData;
		String strQuery="select * from sp_select_pms_indent_issued_items_details('"+serviceDTO.getIndentnumber()+"')";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			CounterIndentMapper mapper = new CounterIndentMapper();
			List<CounterIndentPersistenceDTO> persistenceDtos = mapper.getloadIndentItemsList(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}
}

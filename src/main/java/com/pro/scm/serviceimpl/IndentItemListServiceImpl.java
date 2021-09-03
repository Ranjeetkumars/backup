package com.pro.scm.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.IndentItemListMapper;
import com.pro.scm.persistencedto.IndentItemListPersistenceDTO;
import com.pro.scm.service.IndentItemListService;
import com.pro.scm.servicedto.IndentItemListServiceDTO;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unchecked")
@Service("objIndentItemListService")
@Slf4j
public class IndentItemListServiceImpl implements IndentItemListService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public List<IndentItemListServiceDTO> insertAndUpdateIndentRaiseds(IndentItemListServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("insertAndUpdateIndentRaiseds method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String query = "select * from sp_insert_update_indent_raised_list('" + serviceDTO.getMainstore_available_stock()
				+ "','" + serviceDTO.getMainstore_id() + "','" + serviceDTO.getDrug_id() + "','"
				+ serviceDTO.getBatch_number() + "','" + serviceDTO.getPurchase_price() + "','" + serviceDTO.getMrp()
				+ "','" + serviceDTO.getExpire_date() + "','" + serviceDTO.getRecived_stock() + "','"
				+ serviceDTO.getAvailable_stock() + "'," + serviceDTO.getCreatedbyid() + ","
				+ serviceDTO.getCreatedbyroleid() + "," + serviceDTO.getCreatedbymoduleid() + ",'"
				+ serviceDTO.getUnitprice() + "','" + serviceDTO.getIndent_code() + "'," + serviceDTO.getSize() + ","+serviceDTO.getTo_store_id()+","+serviceDTO.getFromCounterid()+")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + query);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(query);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.arryObjectToPersistenceDtoForIndentRisedStatus(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<IndentItemListServiceDTO> loadLocalIndentIssuedDetails(IndentItemListServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("loadLocalIndentIssuedDetails method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String strQuery = "select * from sp_select_scm_localIndent_Issudedrug('" + serviceDTO.getIndentNum() + "')";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.getloadLocalIndentIssuedDetails(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<IndentItemListServiceDTO> loadIndentRaisedItems(IndentItemListServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("loadIndentRaisedItems method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String strQuery = "select * from sp_select_indent_raised_items('" + serviceDTO.getIndentNum() + "')";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.getloadIndentRaisedItems(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<IndentItemListServiceDTO> loadAvailableQty(IndentItemListServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadAvailableQty method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String strQuery = "select * from sp_select_getavailable_quantity(" + serviceDTO.getMain_storeId() + ","
				+ serviceDTO.getStoreId() + ")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.loadAvailableQty(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<IndentItemListServiceDTO> loadBatchNumber(IndentItemListServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadBatchNumber method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String strQuery = "select * from sp_select_getbatch_numbers(" + serviceDTO.getDrug_id() + ","
				+ serviceDTO.getStoreId() + ")";
		
		
		//sp_select_getbatch_numbers
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.loadBatchNumber(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<IndentItemListServiceDTO> getTemplate(IndentItemListServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("getTemplate method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String strQuery = "SELECT cet_template_id, cet_template_type  FROM hm_common_email_template_ref where cet_template_id="
				+ serviceDTO.getTemplateId() + "";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.getTemplate(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<IndentItemListServiceDTO> loadIndentRaisedSearch(IndentItemListServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("loadIndentRaisedSearch method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String strQuery = "select * from sp_select_indent_raised_search('" + serviceDTO.getFrom_date() + "','"
				+ serviceDTO.getTo_date() + "'," + serviceDTO.getFrom_store() + "," + serviceDTO.getTo_store() + ","
				+ serviceDTO.getIndentStatus() + ")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.loadIndentRaisedSearch(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<IndentItemListServiceDTO> loadIndentStatus(String strRequestID) throws DataNotFoundException {
		log.info("loadIndentStatus method is executed inside IndentItemListServiceImpl");
		List<IndentItemListServiceDTO> listOfData;
		String strQuery = "SELECT is_indent_status_id, is_indent_status_type  FROM pms_scm_indent_status_type_ref where is_isactive=true order by 2";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" + strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentItemListMapper mapper = new IndentItemListMapper();
			List<IndentItemListPersistenceDTO> persistenceDtos = mapper.loadIndentStatus(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}
}

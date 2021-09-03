package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.ExpectedDateTermsConditionsMapper;
import com.pro.scm.mappers.ReceivedGoodsMapper;
import com.pro.scm.persistencedto.ExpectedDateTermsConditionPersistanceDTO;
import com.pro.scm.persistencedto.ReceivedGoodsPersistenceDTO;

import com.pro.scm.service.ReceivedGoodsService;
import com.pro.scm.servicedto.ExpectedDateTermsConditionServiceDTO;
import com.pro.scm.servicedto.ReceivedGoodsServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objReceivedGoodsServiceImpl")
@SuppressWarnings("unchecked")
public class ReceivedGoodsServiceImpl implements ReceivedGoodsService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String updateStatus(ReceivedGoodsServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from  sp_update_puchaseorder_amount_data(").append(dataServiceDTO.getPo_id()).append(",").append(dataServiceDTO.getTotalAmount()).append(",").append(dataServiceDTO.getIsActive()).append(")");
		//stringBuilder.append("UPDATE pms_scm_purchase_order_ref   SET po_isactive=").append(dataServiceDTO.getIsActive())
		  // .append(",").append("po_total_amount=").append(dataServiceDTO.getTotalAmount()) .append(" WHERE po_id=").append(dataServiceDTO.getPo_id());
log.info(strRequestID + "::::::updateStatus():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;
	}

	@Override
	public List<ReceivedGoodsServiceDTO> getAllReceivedGoodsByIndentId(ReceivedGoodsServiceDTO dataInfo,
			String requestID) throws DataNotFoundException {
		List<ReceivedGoodsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from  sp_select_podrug_details(").append(dataInfo.getPo_id()).append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ReceivedGoodsMapper dataMapper = new ReceivedGoodsMapper();
			List<ReceivedGoodsPersistenceDTO> receivedGoodsPersistencePersDTOs = dataMapper
					.ConvertDataToGetAllReceivedGoods(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(receivedGoodsPersistencePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<ReceivedGoodsServiceDTO> loadEpectiedDateAndTermsCondtions(ReceivedGoodsServiceDTO dataInfo,
			String requestID) throws DataNotFoundException {
		List<ReceivedGoodsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select * from sp_select_pms_scm_purchase_order_date_conditions(")
				.append(dataInfo.getPo_id()).append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ReceivedGoodsMapper dataMapper = new ReceivedGoodsMapper();
			List<ReceivedGoodsPersistenceDTO> receivedGoodsPersistencePersDTOs = dataMapper
					.ConvertDataToGetEpectiedDateAndTermsCondtions(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(receivedGoodsPersistencePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public String updatePOStatusForceClose(ReceivedGoodsServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_scm_purchase_order_item_force_close('")
				.append(dataServiceDTO.getPo_id()).append("','").append(dataServiceDTO.getRemarks()).append("',")
				.append(dataServiceDTO.getCount()).append(",").append(dataServiceDTO.getUser_id()).append(",")
				.append(dataServiceDTO.getRole_id()).append(",").append(dataServiceDTO.getModule_id()).append(")");
		log.info(strRequestID + "::::::updatePOStatusForceClose():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public List<ReceivedGoodsServiceDTO> getAllReceivedGoodsSearch(ReceivedGoodsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		List<ReceivedGoodsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_search_pms_scm_purchase_order_ref('")
				.append(dataInfo.getPurchaseOrderNumber()).append("','").append(dataInfo.getToday_date()).append("','")
				.append(dataInfo.getStart_date()).append("','").append(dataInfo.getSearch_date()).append("')");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ReceivedGoodsMapper dataMapper = new ReceivedGoodsMapper();
			List<ReceivedGoodsPersistenceDTO> receivedGoodsPersistencePersDTOs = dataMapper
					.ConvertDataToGetAllReceivedGoodsSearch(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(receivedGoodsPersistencePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<ExpectedDateTermsConditionServiceDTO> getTermsConditions(ExpectedDateTermsConditionServiceDTO dataInfo,
			String requestID) throws DataNotFoundException {
		List<ExpectedDateTermsConditionServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("SELECT po_excepted_date, po_terms_conditions  FROM pms_scm_purchase_order_ref where po_id").append("=")
				.append(dataInfo.getPo_id());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			ExpectedDateTermsConditionsMapper dataMapper = new ExpectedDateTermsConditionsMapper();
			List<ExpectedDateTermsConditionPersistanceDTO> receivedGoodsPersistencePersDTOs = dataMapper
					.conversionOfBrandDetails(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(receivedGoodsPersistencePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

}

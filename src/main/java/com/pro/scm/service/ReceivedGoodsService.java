package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.ExpectedDateTermsConditionServiceDTO;
import com.pro.scm.servicedto.ReceivedGoodsServiceDTO;

public interface ReceivedGoodsService {
	public String updateStatus(ReceivedGoodsServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<ReceivedGoodsServiceDTO> getAllReceivedGoodsByIndentId(ReceivedGoodsServiceDTO dataInfo,
			String requestID) throws DataNotFoundException;

	public List<ReceivedGoodsServiceDTO> loadEpectiedDateAndTermsCondtions(ReceivedGoodsServiceDTO dataInfo,
			String requestID) throws DataNotFoundException;

	public String updatePOStatusForceClose(ReceivedGoodsServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<ReceivedGoodsServiceDTO> getAllReceivedGoodsSearch(ReceivedGoodsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public List<ExpectedDateTermsConditionServiceDTO> getTermsConditions(ExpectedDateTermsConditionServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

}

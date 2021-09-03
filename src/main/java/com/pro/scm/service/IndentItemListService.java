package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.IndentItemListServiceDTO;

public interface IndentItemListService {
	public List<IndentItemListServiceDTO> insertAndUpdateIndentRaiseds(IndentItemListServiceDTO serviceDto,
			String strRequestID) throws DataNotFoundException;

	public List<IndentItemListServiceDTO> loadLocalIndentIssuedDetails(IndentItemListServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException;

	public List<IndentItemListServiceDTO> loadIndentRaisedItems(IndentItemListServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException;

	public List<IndentItemListServiceDTO> loadAvailableQty(IndentItemListServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<IndentItemListServiceDTO> loadBatchNumber(IndentItemListServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<IndentItemListServiceDTO> getTemplate(IndentItemListServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<IndentItemListServiceDTO> loadIndentRaisedSearch(IndentItemListServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException;

	public List<IndentItemListServiceDTO> loadIndentStatus(String strRequestID) throws DataNotFoundException;

}

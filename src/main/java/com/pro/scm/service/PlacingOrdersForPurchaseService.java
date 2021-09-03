package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.servicedto.CentralCloseServiceDTO;
import com.pro.scm.servicedto.IndentDetailsServiceDTO;
import com.pro.scm.servicedto.ManufactureCompanyServiceDTO;
import com.pro.scm.servicedto.ManufactureFormServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;

public interface PlacingOrdersForPurchaseService {

	public String savePurchaseOrderItemDetails(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> getAllSuppliers(String strRequestID) throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> getReturnDrugDetailsByDrugId(
			PlacingOrdersForPurchaseServiceDTO dataInfo, String requestID) throws DataNotFoundException;

	public String savePurchaseOrderItemQuantity(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String getGenerateIndentNumber(String strRequestID) throws DataNotFoundException;

	public String generatePoNumber(String strRequestID) throws DataNotFoundException;

	public String saveIndentItemDetails(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> getAllPurchaseOrderList(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> getAllPurchaseOrderDrugCount(
			PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;

	
	public List<PlacingOrdersForPurchaseServiceDTO> getAllPurchaseOrderDrugCountWithEightParam(
			PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException;
	
	public String getAvailabeDrugs(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> loadIndentDetails(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException;

	public String getEmpMailId(PlacingOrdersForPurchaseServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public String updateReturnItemStaus(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String savePoId(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String getMesserAddress(PlacingOrdersForPurchaseServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> getPoDrug_Details(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException;

	public String insertMails(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> loadSupplier(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException;

	public List<PlacingOrdersForPurchaseServiceDTO> loadIndents(String strRequestID) throws DataNotFoundException;

	public List<BrandNameServiceDTO> loadBrandNames(String strRequestID) throws DataNotFoundException;

	public List<ManufactureFormServiceDTO> loadManufactureForm(String strRequestID) throws DataNotFoundException;

	public List<ManufactureCompanyServiceDTO> loadManufactureCompnayNames(String strRequestID)
			throws DataNotFoundException;

	public List<IndentDetailsServiceDTO> getIndentDetails(IndentDetailsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public String centralClose(CentralCloseServiceDTO dataInfo, String requestID) throws DataNotFoundException;

}

package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.LoadPaymentDetailsServiceDto;
import com.pro.scm.servicedto.LoadTotalCreditAmountServiceDto;
import com.pro.scm.servicedto.PharmacySalesServiceDTO;

import com.pro.scm.servicedto.SaveWardWiseCreditSalesServiceDto;

public interface PharmacySalesService {
	public String getListofSalesCount(PharmacySalesServiceDTO dataInfo, String requestID) throws DataNotFoundException;

	public List<PharmacySalesServiceDTO> getListofSales(PharmacySalesServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public List<?> loadPayment(String requestID) throws DataNotFoundException;

	public String getAllMedicinesCount1(PharmacySalesServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public String getAvailableMedicine(PharmacySalesServiceDTO dataInfo, String requestID) throws DataNotFoundException;

	public String checkAvailableQty(PharmacySalesServiceDTO dataInfo, String requestID) throws DataNotFoundException;

	public String getBillNumber(String requestID) throws DataNotFoundException;

	public String saveBilDetails(PharmacySalesServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String saveDrugstatus(PharmacySalesServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public String savePayment_Details(PharmacySalesServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

	public List<PharmacySalesServiceDTO> loadType(PharmacySalesServiceDTO dataInfo, String requestID)
			throws DataNotFoundException;

	public List<PharmacySalesServiceDTO> loadDoctors(String requestID) throws DataNotFoundException;

	public List<PharmacySalesServiceDTO> loadDepartment(String requestID) throws DataNotFoundException;

	public List<LoadPaymentDetailsServiceDto> loadPaymentDetails(
			LoadPaymentDetailsServiceDto loadPaymentDetailsServiceDto, String requestID) throws DataNotFoundException;

	public List<LoadPaymentDetailsServiceDto> loadCompany(String requestID) throws DataNotFoundException;

	public List<LoadTotalCreditAmountServiceDto> loadTotalCreditAmount(
			LoadTotalCreditAmountServiceDto loadTotalCreditAmountServiceDto, String requestID)
			throws DataNotFoundException;

	public List<LoadTotalCreditAmountServiceDto> loadWardWiseCredit(
			LoadTotalCreditAmountServiceDto loadTotalCreditAmountServiceDto, String requestID)
			throws DataNotFoundException;

	public String saveWardWiseCreditSales(SaveWardWiseCreditSalesServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException;

}

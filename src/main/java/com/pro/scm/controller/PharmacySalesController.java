package com.pro.scm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.pro.scm.controllerdto.LoadPaymentDetailsControllerDto;
import com.pro.scm.controllerdto.LoadTotalCreditAmountControllerDto;
import com.pro.scm.controllerdto.PharmacySalesControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SaveWardWiseCreditSalesControllerDto;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.LoadPaymentDetailsMapper;
import com.pro.scm.mappers.LoadTotalCreditAmountMapper;
import com.pro.scm.mappers.PharmacySalesMapper;
import com.pro.scm.mappers.SaveWardWiseCreditSalesMapper;
import com.pro.scm.service.PharmacySalesService;
import com.pro.scm.service.SalesReturnsService;
import com.pro.scm.servicedto.AllApprovalItemListServiceDto;
import com.pro.scm.servicedto.LoadPaymentDetailsServiceDto;
import com.pro.scm.servicedto.LoadTotalCreditAmountServiceDto;
import com.pro.scm.servicedto.PharmacySalesServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.servicedto.ReportServiceDTO;
import com.pro.scm.servicedto.SalesReturnsServiceDTO;
import com.pro.scm.utills.IsEmptyUtil;
import com.pro.scm.wrappers.AllApprovalItemListWrapper;
import com.pro.scm.wrappers.LoadPaymentDetailsWrapper;
import com.pro.scm.wrappers.LoadTotalCreditWrapper;
import com.pro.scm.wrappers.PharmacySalesWrapper;
import com.pro.scm.wrappers.PlacingOrdersForPurchaseWrapper;
import com.pro.scm.wrappers.ReportWrapper;
import com.pro.scm.wrappers.SalesReturnsWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Priyadarshini
 * @since 1.08.2019
 * @Des : SalesReturnsController
 */
@Slf4j
@RestController
@RequestMapping("/PharmacySalesController")
public class PharmacySalesController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	@Qualifier("objPharmacySalesServiceImpl")
	private PharmacySalesService objPharmacySalesServiceImpl;

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getListofSalesCount
	 * @URL :
	 *      192.168.1.149:2000/scmservice/PharmacySalesController/getListofSalesCount
	 * 
	 *      {"companyname":"¥", "patientName":"¥", "fromdate":"¥", "todate":"¥",
	 *      "paymentId":0, "storeId":0
	 * 
	 * 
	 * 
	 *      }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getListofSalesCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response getListofSalesCount(@RequestBody PharmacySalesControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::getListofSalesCount():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PharmacySalesServiceDTO dataInfo = new PharmacySalesServiceDTO();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getCompanyname())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPatientName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFromdate())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTodate())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPaymentId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getStoreId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String count = objPharmacySalesServiceImpl.getListofSalesCount(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(count);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::getListofSalesCount()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getIPFields
	 * @Parameters :reportId
	 * @URL :localhost:
	 *      192.168.1.149:2000/scmservice/PharmacySalesController/getListofSales
	 * @Parameters :{"companyname":"¥", "patientName":"¥", "fromdate":"¥",
	 *             "todate":"¥", "paymentId":0, "storeId":0
	 * 
	 * 
	 * 
	 *             }
	 */
	@RequestMapping(value = "/getListofSales", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getListofSales(@RequestBody PharmacySalesControllerDTO objReportControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getIPFields()::::::::::::::::::::::::::::"
				+ objReportControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PharmacySalesWrapper objPharmacySalesWrapper = new PharmacySalesWrapper();
		if (objReportControllerDTO.getCompanyname() != null || objReportControllerDTO.getPatientName() != null
				|| objReportControllerDTO.getFromdate() != null || objReportControllerDTO.getTodate() != null
				|| objReportControllerDTO.getPaymentId() != null || objReportControllerDTO.getStoreId() != null) {

			PharmacySalesMapper mapper = new PharmacySalesMapper();
			List<PharmacySalesServiceDTO> sDto = objPharmacySalesServiceImpl
					.getListofSales(mapper.conversionControllerDtoToServiceDto(objReportControllerDTO), strRequestID);
			objPharmacySalesWrapper.setPharmacySalesControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objPharmacySalesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objPharmacySalesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getListofSales()::::::::::::::::::::::::::::::::"
				+ objPharmacySalesWrapper.toString());
		return objPharmacySalesWrapper;
	}

	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadPayment
	 * @Parameters :NO
	 * @URL : 192.168.1.149:2000/scmservice/PharmacySalesController/loadPayment
	 * 
	 */
//	@CrossOrigin
//	@RequestMapping(value = "/loadPayment", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public Response loadPayment() throws DataNotFoundException {
//		String requestID = (String) request.getAttribute("sessionid");
//		log.info(requestID + ":::::::::::::::::::::::::::::loadPayment()::::::::::::::::::::::::::::::::::::::::::");
//		List<PharmacySalesControllerDTO> objPharmacySalesControllerDTO = new ArrayList<PharmacySalesControllerDTO>();
//		PharmacySalesMapper objPharmacySalesMapper = new PharmacySalesMapper();
//		PharmacySalesWrapper objPharmacySalesWrapper = new PharmacySalesWrapper();
//		List<PharmacySalesServiceDTO> datas = objPharmacySalesServiceImpl.loadPayment(requestID);
//		objPharmacySalesWrapper
//				.setPharmacySalesControllerDTO(new PharmacySalesMapper().conversionForServiceTOControllerDTO(datas));
//		objPharmacySalesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
//		objPharmacySalesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
//		log.info("::::OUTPUT:::::::::::::loadPayment()::::::::::::::::::::::::::::::::::::::"
//				+ objPharmacySalesWrapper.toString());
//		return objPharmacySalesWrapper;
//
//	}

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getListofSalesCount
	 * @URL :
	 *      192.168.1.149:2000/scmservice/PharmacySalesController/getAllMedicinesCount1
	 * 
	 *      {"genericName":"¥", "brandName":0, "form":0, "mfgId":0, "unicode":"¥",
	 *      "systemid":0, "genericgroupid":0, "genericMoleculeid":0, "storeId":0 }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getAllMedicinesCount1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response getAllMedicinesCount1(@RequestBody PharmacySalesControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::getAllMedicinesCount1():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PharmacySalesServiceDTO dataInfo = new PharmacySalesServiceDTO();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBrandName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getForm())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getMfgId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnicode())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSystemid())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericgroupid())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericMoleculeid())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getStoreId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String count = objPharmacySalesServiceImpl.getAllMedicinesCount1(dataInfo, strRequestID);

			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(count);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::getAllMedicinesCount1()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getListofSalesCount
	 * @URL :
	 *      192.168.1.149:2000/scmservice/PharmacySalesController/getAvailableMedicine
	 * 
	 *      {"genericName":"¥", "brandName":0, "form":0, "mfgId":0, "unicode":"¥", }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getAvailableMedicine", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response getAvailableMedicine(@RequestBody PharmacySalesControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::getAvailableMedicine():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PharmacySalesServiceDTO dataInfo = new PharmacySalesServiceDTO();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBrandName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getForm())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getMfgId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnicode())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String count = objPharmacySalesServiceImpl.getAvailableMedicine(dataInfo, strRequestID);

			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(count);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::getAvailableMedicine()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : checkAvailableQty
	 * @URL :
	 *      192.168.1.149:2000/scmservice/PharmacySalesController/checkAvailableQty
	 * 
	 *      {"batchNo":"H003", "drugId":111, "issuedQty":4, "counterId":100001 }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/checkAvailableQty", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response checkAvailableQty(@RequestBody PharmacySalesControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::checkAvailableQty():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PharmacySalesServiceDTO dataInfo = new PharmacySalesServiceDTO();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getBatchNo())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getIssuedQty())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCounterId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String count = objPharmacySalesServiceImpl.checkAvailableQty(dataInfo, strRequestID);

			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(count);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::checkAvailableQty()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getBillNumber
	 * @URL : 192.168.1.149:2000/scmservice/PharmacySalesController/getBillNumber
	 * 
	 * 
	 * 
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/getBillNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getBillNumber() throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getBillNumber():::::::::");
		List<PharmacySalesControllerDTO> objAllowanceControllerDTO = new ArrayList<PharmacySalesControllerDTO>();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();

		String billNumber = objPharmacySalesServiceImpl.getBillNumber(strRequestID);
		if (billNumber.isEmpty()) {
			throw new DataNotFoundException("");
		} else {
			dataWrapper.setPharmacySalesControllerDTO(objAllowanceControllerDTO);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(billNumber);
		}
		log.info(strRequestID + "::::::::getBillNumber():::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : savePurchaseOrderItemDetails
	 * @URL : 192.168.1.149:2000/scmservice/PharmacySalesController/saveBilDetails
	 * 
	 *      {"billNumber":"3123", "vat":"3123",
	 * 
	 *      "taxAmount":"3123", "netAmount":"3123", "disc":"3123",
	 *      "date":"2019-08-01", "patientName":"¥", "phoneNumber":"111",
	 *      "docId":"11", "userId":"11", "moduleId":"1", "roleId":"1",
	 *      "depatrmId":"1", "wardId":"1", "employee":"1", "credit":true,
	 *      "creditAmount":1, "paidAmount":1, "company":1, "store":1, "payment":1,
	 *      "opnumber":12264, "discount":1, "totalAmount":1 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveBilDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response saveBilDetails(@RequestBody PharmacySalesControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::saveBilDetails():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PharmacySalesServiceDTO dataInfo = new PharmacySalesServiceDTO();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getBillNumber())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getVat())

				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTaxAmount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getNetAmount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDisc())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDate())

				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPatientName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPhoneNumber())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDocId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDepatrmId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getWardId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getEmployee())

				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCredit())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCreditAmount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPaidAmount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCompany())

				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPayment())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getStore())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getOpnumber())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDiscount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTotalAmount())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPharmacySalesServiceImpl.saveBilDetails(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::saveBilDetails()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : saveDrugstatus
	 * @URL : 192.168.1.149:2000/scmservice/PharmacySalesController/saveDrugstatus
	 * 
	 *      { {"drugId":"1", "batchCode":"1",
	 * 
	 *      "expDate":"2019-08-01", "reqqty":"1", "salesrate":"1", "mrp":"1",
	 *      "billNumber":"1", "count":"1", "userId":"1", "roleId":"1",
	 *      "moduleId":"1", "opnumber":"1", "unicode":"1", "counterId":"1"
	 * 
	 *      }
	 * 
	 *      }
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveDrugstatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response saveDrugstatus(@RequestBody PharmacySalesControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::saveDrugstatus():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PharmacySalesServiceDTO dataInfo = new PharmacySalesServiceDTO();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBatchCode())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getExpDate())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getReqqty())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSalesrate())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getMrp())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBillNumber())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getOpnumber())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnicode())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCounterId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPharmacySalesServiceImpl.saveDrugstatus(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::saveDrugstatus()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : saveDrugstatus
	 * @URL :
	 *      192.168.1.149:2000/scmservice/PharmacySalesController/savePayment_Details
	 * 
	 *      { {"billNumber":"1", "storeId":"1",
	 * 
	 *      "crDbyear":"2019-08-01", "crDbmonth":"1", "crDbno":"1", "crDBbank":"1",
	 *      "crHname":"1", "count":"1", "chequeno":"1", "drawname":"1",
	 *      "cheqdate":"1", "userId":"1", "moduleId":"1", "roleId":"1"
	 * 
	 *      }
	 * 
	 *      }
	 */
	@CrossOrigin
	@RequestMapping(value = "/savePayment_Details", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response savePayment_Details(@RequestBody PharmacySalesControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::saveDrugstatus():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PharmacySalesServiceDTO dataInfo = new PharmacySalesServiceDTO();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getBillNumber())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getStoreId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCrDbyear())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCrDbmonth())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCrDbno())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCrDBbank())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCrHname())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getChequeno())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrawname())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCheqdate())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPharmacySalesServiceImpl.savePayment_Details(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::saveDrugstatus()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getIPFields
	 * @Parameters :reportId
	 * @URL :localhost:
	 *      192.168.1.149:2000/scmservice/PharmacySalesController/loadType
	 * @Parameters :{"groupId":"2",
	 * 
	 * 
	 * 
	 * 
	 *             }
	 */
	@RequestMapping(value = "/loadType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadType(@RequestBody PharmacySalesControllerDTO objReportControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getIPFields()::::::::::::::::::::::::::::"
				+ objReportControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PharmacySalesWrapper objPharmacySalesWrapper = new PharmacySalesWrapper();
		if (objReportControllerDTO.getGroupId() != null) {

			PharmacySalesMapper mapper = new PharmacySalesMapper();
			List<PharmacySalesServiceDTO> sDto = objPharmacySalesServiceImpl
					.loadType(mapper.conversionControllerDtoToServiceDto(objReportControllerDTO), strRequestID);
			objPharmacySalesWrapper.setPharmacySalesControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objPharmacySalesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objPharmacySalesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getListofSales()::::::::::::::::::::::::::::::::"
				+ objPharmacySalesWrapper.toString());
		return objPharmacySalesWrapper;
	}

	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadDoctors
	 * @Parameters :NO
	 * @URL : 192.168.1.149:2000/scmservice/PharmacySalesController/loadDoctors
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadDoctors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadDoctors() throws DataNotFoundException {
		String requestID = (String) request.getAttribute("sessionid");
		log.info(requestID + ":::::::::::::::::::::::::::::loadDoctors()::::::::::::::::::::::::::::::::::::::::::");
		List<PharmacySalesControllerDTO> objPharmacySalesControllerDTO = new ArrayList<PharmacySalesControllerDTO>();
		PharmacySalesWrapper objPharmacySalesWrapper = new PharmacySalesWrapper();
		List<PharmacySalesServiceDTO> datas = objPharmacySalesServiceImpl.loadDoctors(requestID);
		objPharmacySalesWrapper
				.setPharmacySalesControllerDTO(new PharmacySalesMapper().conversionForServiceTOControllerDTO(datas));
		objPharmacySalesWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objPharmacySalesWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT:::::::::::::loadDoctors()::::::::::::::::::::::::::::::::::::::"
				+ objPharmacySalesWrapper.toString());
		return objPharmacySalesWrapper;

	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : loadPaymentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/PharmacySalesController/api/version_1/loadPaymentDetails
	 */
	@RequestMapping(value = "/api/version_1/loadPaymentDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response loadPaymentDetails(@RequestBody LoadPaymentDetailsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadPaymentDetails method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadPaymentDetailsMapper mapper = new LoadPaymentDetailsMapper();
		LoadPaymentDetailsWrapper wrapper = new LoadPaymentDetailsWrapper();
		if (objControllerDto.getPayment() != null && objControllerDto.getBillNumber() != null) {
			List<LoadPaymentDetailsServiceDto> loadPaymentDetailsServiceDto = objPharmacySalesServiceImpl
					.loadPaymentDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadPaymentDetailsServiceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : loadPaymentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/PharmacySalesController/api/version_1/loadCompany
	 */
	@RequestMapping(value = "/api/version_1/loadCompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadCompany() throws InSufficientInputException, DataNotFoundException {
		log.info("loadPaymentDetails method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadPaymentDetailsMapper mapper = new LoadPaymentDetailsMapper();
		LoadPaymentDetailsWrapper wrapper = new LoadPaymentDetailsWrapper();
		List<LoadPaymentDetailsServiceDto> loadPaymentDetailsServiceDto = objPharmacySalesServiceImpl
				.loadCompany(strRequestID);
		wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadPaymentDetailsServiceDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : loadPaymentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/PharmacySalesController/api/version_1/loadTotalCreditAmount
	 */
	@RequestMapping(value = "/api/version_1/loadTotalCreditAmount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response loadTotalCreditAmount(@RequestBody LoadTotalCreditAmountControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadTotalCreditAmount method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadTotalCreditAmountMapper mapper = new LoadTotalCreditAmountMapper();
		LoadTotalCreditWrapper wrapper = new LoadTotalCreditWrapper();
		if (objControllerDto.getWardId() != null) {
			List<LoadTotalCreditAmountServiceDto> loadTotalCreditAmountServiceDto = objPharmacySalesServiceImpl
					.loadTotalCreditAmount(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadTotalCreditAmountServiceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	//
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : loadPaymentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/PharmacySalesController/api/version_1/loadWardWiseCredit
	 */
	@RequestMapping(value = "/api/version_1/loadWardWiseCredit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response loadWardWiseCredit(@RequestBody LoadTotalCreditAmountControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadTotalCreditAmount method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadTotalCreditAmountMapper mapper = new LoadTotalCreditAmountMapper();
		LoadTotalCreditWrapper wrapper = new LoadTotalCreditWrapper();
		if (objControllerDto.getWardId() != null) {
			List<LoadTotalCreditAmountServiceDto> loadTotalCreditAmountServiceDto = objPharmacySalesServiceImpl
					.loadTotalCreditAmount(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadTotalCreditAmountServiceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}


	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : saveDrugstatus
	 * @URL :
	 *      localhost:2000/scmservice/PharmacySalesController/saveWardWiseCreditSales
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveWardWiseCreditSales", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response saveWardWiseCreditSales(@RequestBody SaveWardWiseCreditSalesControllerDto dataControllerDTO)
			throws DataNotFoundException, InSufficientInputException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::saveDrugstatus():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();

		SaveWardWiseCreditSalesMapper dataMapper = new SaveWardWiseCreditSalesMapper();
		PharmacySalesWrapper dataWrapper = new PharmacySalesWrapper();
		if (dataControllerDTO.getBillNo() != null && dataControllerDTO.getFltTotalAmount() != null
				&& dataControllerDTO.getFltCreditAmount() != null && dataControllerDTO.getFltPaidAmount() != null
				&& dataControllerDTO.getEmployeeId() != null && dataControllerDTO.getCreatedbyId() != null
				&& dataControllerDTO.getModuleID() != null) {
			String rtnValueOfMT = objPharmacySalesServiceImpl.saveWardWiseCreditSales(
					new SaveWardWiseCreditSalesMapper().conversionControllerDtoToServiceDto(dataControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				dataWrapper.setResponseCode(HttpStatus.OK.value());
				dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				dataWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				dataWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(dataControllerDTO.toString());
		}
		log.info(strRequestID + ":::::::::::::" + dataWrapper.toString());
		return dataWrapper;

	}

}
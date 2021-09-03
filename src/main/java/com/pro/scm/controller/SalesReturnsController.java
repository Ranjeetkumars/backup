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

import com.pro.scm.controllerdto.AdjustmentStockControllerDTO;
import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SalesReturnsControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AdjustmentStockMapper;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.mappers.SalesReturnsMapper;
import com.pro.scm.service.AdjustmentStockService;
import com.pro.scm.service.SalesReturnsService;
import com.pro.scm.servicedto.AdjustmentStockServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.servicedto.SalesReturnsServiceDTO;
import com.pro.scm.utills.IsEmptyUtil;
import com.pro.scm.wrappers.AdjustmentStockWrapper;
import com.pro.scm.wrappers.PlacingOrdersForPurchaseWrapper;
import com.pro.scm.wrappers.SalesReturnsWrapper;

import lombok.extern.slf4j.Slf4j;

	/**
	 * @author Priyadarshini
	 * @since 1.08.2019
	 * @Des : SalesReturnsController
	 */
	@Slf4j
	@RestController
	@RequestMapping("/SalesReturnsController")
	public class SalesReturnsController {
		@Autowired
		private HttpServletRequest request;
		@Autowired
		@Qualifier("objSalesReturnsServiceImpl")
		private SalesReturnsService objSalesReturnsServiceImpl;
		/**
		 * @author : priyadarshini
		 * @throws : DataNotFoundException
		 * @Date : 2019-07-29
		 * @Des : saveReturnDetails
		 * @URL : 192.168.1.149:2000/scmservice/SalesReturnsController/saveReturnDetails
	        {"billNumber":"99999",
			"retun_amount":"111",
			"drugId":1,
			"batch_code":1,
			"expdate":"now()",
			"return_quantity":"11",
			"count":1,
			"userId":1,
			"moduleId":1,
			"roleId":1
			}
		 */
		@CrossOrigin
		@RequestMapping(value = "/saveReturnDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response saveReturnDetails(@RequestBody SalesReturnsControllerDTO dataControllerDTO)
				throws DataNotFoundException {
			String strRequestID = request.getAttribute("reqid").toString();
			log.info(strRequestID + ":::::::::::::::::::::::::::::::saveReturnDetails()::::::::::::::::::::::::" + dataControllerDTO);
			List<String> errmsgs = new ArrayList<String>();
			SalesReturnsServiceDTO dataInfo = new SalesReturnsServiceDTO();
			SalesReturnsMapper dataMapper = new SalesReturnsMapper();
			SalesReturnsWrapper dataWrapper = new SalesReturnsWrapper();
			if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getBillNumber())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRetun_amount())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBatch_code())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getExpdate())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())) {
				dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				dataWrapper.setErrorsMsgs(errmsgs);
			} else {
				dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
				String commonresponse = objSalesReturnsServiceImpl.saveReturnDetails(dataInfo, strRequestID);
				dataWrapper.setResponseCode(HttpStatus.OK.value());
				dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				dataWrapper.setErrorsMsgs(errmsgs);
				dataWrapper.setRtnReponseCount(commonresponse);
			}
		log.info(strRequestID + ":::::::::::::::::::::::::::::saveReturnDetails()::::::::::::::::" + dataWrapper.toString());
			return dataWrapper;

		}

		/**
		 * @author : priyadarshini
		 * @throws : DataNotFoundException
		 * @Date : 2019-08-1
		 * @Des : updateReturnStock
		 * @URL : 192.168.1.149:2000/scmservice/SalesReturnsController/updateReturnStock
	      {"drugId":"111",
			"return_quantity":"111",
			"retun_amount":1,
			"count":1,
			"returnRate":"1",
			"billNumber":"11",
			"batch_code":1
			}
		 */
		@CrossOrigin
		@RequestMapping(value = "/updateReturnStock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response updateReturnStock(@RequestBody SalesReturnsControllerDTO dataControllerDTO)
				throws DataNotFoundException {
			String strRequestID = request.getAttribute("reqid").toString();
			log.info(strRequestID + ":::::::::::::::::::::::::::::::updateReturnStock()::::::::::::::::::::::::" + dataControllerDTO);
			List<String> errmsgs = new ArrayList<String>();
			SalesReturnsServiceDTO dataInfo = new SalesReturnsServiceDTO();
			SalesReturnsMapper dataMapper = new SalesReturnsMapper();
			SalesReturnsWrapper dataWrapper = new SalesReturnsWrapper();
			if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getReturn_quantity())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRetun_amount())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getReturnRate())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBillNumber())
					|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBatch_code())) {
				dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				dataWrapper.setErrorsMsgs(errmsgs);
			} else {
				dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
				String commonresponse = objSalesReturnsServiceImpl.updateReturnStock(dataInfo, strRequestID);
				dataWrapper.setResponseCode(HttpStatus.OK.value());
				dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				dataWrapper.setErrorsMsgs(errmsgs);
				dataWrapper.setRtnReponseCount(commonresponse);
			}
		log.info(strRequestID + ":::::::::::::::::::::::::::::updateReturnStock()::::::::::::::::" + dataWrapper.toString());
			return dataWrapper;

		}

		/**
		 * @author : priyadarshini
		 * @throws DataNotFoundException
		 * @Date : 2019-07-29
		 * @Des : loadSupplier
		 * @Parameters :IndentidNumber
		 * @URL :localhost: 192.168.1.149:2000/scmservice/SalesReturnsController/getBillDetails
		 * @Parameters :{"billNumber":"20130806000002",
                          "patientName":"sdfs",
                          "createdByDate":"2013-08-06"
		}
		 */
		@RequestMapping(value = "/getBillDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response getBillDetails(@RequestBody  SalesReturnsControllerDTO objSalesReturnsControllerDTO)
				throws InSufficientInputException, DataNotFoundException {
			log.info("::::Inputs::Are:::::::::::::getBillDetails()::::::::::::::::::::::::::::"+objSalesReturnsControllerDTO.toString());
			String strRequestID = request.getAttribute("reqid").toString();
			SalesReturnsWrapper objSalesReturnsWrapper = new SalesReturnsWrapper();
			if(objSalesReturnsControllerDTO.getBillNumber()!= null||
					objSalesReturnsControllerDTO.getPatientName()!= null||
					objSalesReturnsControllerDTO.getCreatedByDate()!= null) {
				
				SalesReturnsMapper mapper = new SalesReturnsMapper();
				List<SalesReturnsServiceDTO> sDto = objSalesReturnsServiceImpl
						.getBillDetails(mapper.conversionControllerDtoToServiceDto(objSalesReturnsControllerDTO),strRequestID);
				objSalesReturnsWrapper.setSalesReturnsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
				objSalesReturnsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
				objSalesReturnsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			} else {
				throw new InSufficientInputException("");
			}
			log.info("::::OUTPUT:::::::::::::::::::::::getBillDetails()::::::::::::::::::::::::::::::::"+objSalesReturnsWrapper.toString());
			return objSalesReturnsWrapper;
		}	
	
		
		
		/**
		 * @author : priyadarshini
		 * @throws DataNotFoundException
		 * @Date : 2019-07-29
		 * @Des : loadSupplier
		 * @Parameters :IndentidNumber
		 * @URL :localhost: 192.168.1.149:2000/scmservice/SalesReturnsController/getBillItemDetails
		 * @Parameters :{"billNumber":"20130806000002",
                   
		}
		 */
		@RequestMapping(value = "/getBillItemDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response getBillItemDetails(@RequestBody  SalesReturnsControllerDTO objSalesReturnsControllerDTO)
				throws InSufficientInputException, DataNotFoundException {
			log.info("::::Inputs::Are:::::::::::::getBillDetails()::::::::::::::::::::::::::::"+objSalesReturnsControllerDTO.toString());
			String strRequestID = request.getAttribute("reqid").toString();
			SalesReturnsWrapper objSalesReturnsWrapper = new SalesReturnsWrapper();
			if(objSalesReturnsControllerDTO.getBillNumber()!= null) {
				
				SalesReturnsMapper mapper = new SalesReturnsMapper();
				List<SalesReturnsServiceDTO> sDto = objSalesReturnsServiceImpl
						.getBillItemDetails(mapper.conversionControllerDtoToServiceDto(objSalesReturnsControllerDTO),strRequestID);
				objSalesReturnsWrapper.setSalesReturnsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
				objSalesReturnsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
				objSalesReturnsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			} else {
				throw new InSufficientInputException("");
			}
			log.info("::::OUTPUT:::::::::::::::::::::::getBillDetails()::::::::::::::::::::::::::::::::"+objSalesReturnsWrapper.toString());
			return objSalesReturnsWrapper;
		}	
				
	
}

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

import com.pro.scm.controllerdto.ExpectedDateTermsConditionControllerDTO;
import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.controllerdto.PurchaseOrderControllerDTO;
import com.pro.scm.controllerdto.ReceivedGoodsControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.ExpectedDateTermsConditionsMapper;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.mappers.PurchaseOrderMapper;
import com.pro.scm.mappers.ReceivedGoodsMapper;
import com.pro.scm.service.PlacingOrdersForPurchaseService;
import com.pro.scm.service.PurchaseOrderService;
import com.pro.scm.service.ReceivedGoodsService;
import com.pro.scm.servicedto.ExpectedDateTermsConditionServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.servicedto.PurchaseOrderServiceDTO;
import com.pro.scm.servicedto.ReceivedGoodsServiceDTO;
import com.pro.scm.utills.IsEmptyUtil;
import com.pro.scm.wrappers.ExpectedDateTermsConditionWrapper;
import com.pro.scm.wrappers.PlacingOrdersForPurchaseWrapper;
import com.pro.scm.wrappers.PurchaseOrderWrapper;
import com.pro.scm.wrappers.ReceivedGoodsWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Habiboon Patan
 * @since 30.07.2019
 * @Des : ReceivedGoodsController
 */
@Slf4j
@RestController
@RequestMapping("/ReceivedGoodsController")
public class ReceivedGoodsController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	@Qualifier("objReceivedGoodsServiceImpl")
	private ReceivedGoodsService objReceivedGoodsServiceImpl;

	/**
	 * @author :Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 21-04-2020
	 * @Des : updateStatus
	 * @URL : loaclhost:2000/scmservice/ReceivedGoodsController/updateStatus
	 *      {"isActive":"true", "totalAmount":5896.00, "po_id":78 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateStatus(@RequestBody ReceivedGoodsControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::updateStatus():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		ReceivedGoodsServiceDTO dataInfo = new ReceivedGoodsServiceDTO();
		ReceivedGoodsMapper dataMapper = new ReceivedGoodsMapper();
		ReceivedGoodsWrapper dataWrapper = new ReceivedGoodsWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getIsActive())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTotalAmount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPo_id())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objReceivedGoodsServiceImpl.updateStatus(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::updateStatus()::::::::::::::::" + dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : Habiboon Patan
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getAllReceivedGoodsByIndentId
	 * @Parameters :Po_id
	 * @URL :localhost:
	 *      loaclhost:2000/scmservice/ReceivedGoodsController/getAllReceivedGoodsByIndentId
	 * @Parameters :{ "po_id":13
	 * 
	 *             }
	 */
	@RequestMapping(value = "/getAllReceivedGoodsByIndentId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllReceivedGoodsByIndentId(@RequestBody ReceivedGoodsControllerDTO objReceivedGoodsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getAllReceivedGoodsByIndentId()::::::::::::::::::::::::::::"
				+ objReceivedGoodsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ReceivedGoodsWrapper objReceivedGoodsWrapper = new ReceivedGoodsWrapper();
		if (objReceivedGoodsControllerDTO.getPo_id() != null) {

			ReceivedGoodsMapper mapper = new ReceivedGoodsMapper();
			List<ReceivedGoodsServiceDTO> sDto = objReceivedGoodsServiceImpl.getAllReceivedGoodsByIndentId(
					mapper.conversionControllerDtoToServiceDto(objReceivedGoodsControllerDTO), strRequestID);
			objReceivedGoodsWrapper.setReceivedGoodsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objReceivedGoodsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objReceivedGoodsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getAllReceivedGoodsByIndentId()::::::::::::::::::::::::::::::::"
				+ objReceivedGoodsWrapper.toString());
		return objReceivedGoodsWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadEpectiedDateAndTermsCondtions
	 * @Parameters :Po_id
	 * @URL :localhost:
	 *      loaclhost:2000/scmservice/ReceivedGoodsController/loadEpectiedDateAndTermsCondtions
	 * @Parameters :{ "po_id":10
	 * 
	 *             }
	 */
	@RequestMapping(value = "/loadEpectiedDateAndTermsCondtions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadEpectiedDateAndTermsCondtions(
			@RequestBody ReceivedGoodsControllerDTO objReceivedGoodsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::loadEpectiedDateAndTermsCondtions()::::::::::::::::::::::::::::"
				+ objReceivedGoodsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ReceivedGoodsWrapper objReceivedGoodsWrapper = new ReceivedGoodsWrapper();
		if (objReceivedGoodsControllerDTO.getPo_id() != null) {

			ReceivedGoodsMapper mapper = new ReceivedGoodsMapper();
			List<ReceivedGoodsServiceDTO> sDto = objReceivedGoodsServiceImpl.loadEpectiedDateAndTermsCondtions(
					mapper.conversionControllerDtoToServiceDto(objReceivedGoodsControllerDTO), strRequestID);
			objReceivedGoodsWrapper.setReceivedGoodsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objReceivedGoodsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objReceivedGoodsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::loadEpectiedDateAndTermsCondtions()::::::::::::::::::::::::::::::::"
				+ objReceivedGoodsWrapper.toString());
		return objReceivedGoodsWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : updatePOStatusForceClose
	 * @URL :
	 *      loaclhost:2000/scmservice/ReceivedGoodsController/updatePOStatusForceClose
	 *      { "po_id":"10", "remarks":"remaks", "count":1, "user_id":1, "role_id":1,
	 *      "module_id":1 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/updatePOStatusForceClose", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updatePOStatusForceClose(@RequestBody ReceivedGoodsControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::updatePOStatusForceClose():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		ReceivedGoodsServiceDTO dataInfo = new ReceivedGoodsServiceDTO();
		ReceivedGoodsMapper dataMapper = new ReceivedGoodsMapper();
		ReceivedGoodsWrapper dataWrapper = new ReceivedGoodsWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getPo_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRemarks())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUser_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRole_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModule_id())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objReceivedGoodsServiceImpl.updatePOStatusForceClose(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::updatePOStatusForceClose()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : Habiboon Patan
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getAllReceivedGoodsSearch
	 * @Parameters :Po_id
	 * @URL :localhost:
	 *      loaclhost:2000/scmservice/ReceivedGoodsController/getAllReceivedGoodsSearch
	 * @Parameters :{ "purchaseOrderNumber":10, { "purchaseOrderNumber":10,
	 *             "today_date":"now()", "start_date":"now()", "search_date":"now()"
	 *             }
	 * 
	 * 
	 *             }
	 */

	@RequestMapping(value = "/getAllReceivedGoodsSearch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllReceivedGoodsSearch(@RequestBody ReceivedGoodsControllerDTO objReceivedGoodsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getAllReceivedGoodsSearch()::::::::::::::::::::::::::::"
				+ objReceivedGoodsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ReceivedGoodsWrapper objReceivedGoodsWrapper = new ReceivedGoodsWrapper();
		if (objReceivedGoodsControllerDTO.getPurchaseOrderNumber() != null
				|| objReceivedGoodsControllerDTO.getToday_date() != null
				|| objReceivedGoodsControllerDTO.getStart_date() != null
				|| objReceivedGoodsControllerDTO.getSearch_date() != null) {

			ReceivedGoodsMapper mapper = new ReceivedGoodsMapper();
			List<ReceivedGoodsServiceDTO> sDto = objReceivedGoodsServiceImpl.getAllReceivedGoodsSearch(
					mapper.conversionControllerDtoToServiceDto(objReceivedGoodsControllerDTO), strRequestID);
			objReceivedGoodsWrapper.setReceivedGoodsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objReceivedGoodsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objReceivedGoodsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getAllReceivedGoodsSearch()::::::::::::::::::::::::::::::::"
				+ objReceivedGoodsWrapper.toString());
		return objReceivedGoodsWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws DataNotFoundException
	 * @Date : 2020-04-20
	 * @Des : getTermsConditions
	 * @Parameters :Po_id
	 * @URL :localhost:
	 *      loaclhost:2000/scmservice/ReceivedGoodsController/getTermsConditions
	 * @Parameters :{ "po_id":10 }
	 * 
	 */

	@RequestMapping(value = "/getTermsConditions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getTermsConditions(
			@RequestBody ExpectedDateTermsConditionControllerDTO objReceivedGoodsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getTermsConditions()::::::::::::::::::::::::::::"
				+ objReceivedGoodsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ExpectedDateTermsConditionWrapper objExpectedDateTermsConditionWrapper = new ExpectedDateTermsConditionWrapper();
		if (objReceivedGoodsControllerDTO.getPo_id() != null) {

			ExpectedDateTermsConditionsMapper mapper = new ExpectedDateTermsConditionsMapper();
			List<ExpectedDateTermsConditionServiceDTO> sDto = objReceivedGoodsServiceImpl.getTermsConditions(
					mapper.conversionControllerDtoToServiceDto(objReceivedGoodsControllerDTO), strRequestID);
			objExpectedDateTermsConditionWrapper
					.setObjExpectedDateTermsConditionControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objExpectedDateTermsConditionWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objExpectedDateTermsConditionWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getTermsConditions()::::::::::::::::::::::::::::::::"
				+ objExpectedDateTermsConditionWrapper.toString());
		return objExpectedDateTermsConditionWrapper;
	}

}

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
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AdjustmentStockMapper;
import com.pro.scm.service.AdjustmentStockService;
import com.pro.scm.servicedto.AdjustmentStockServiceDTO;
import com.pro.scm.utills.IsEmptyUtil;
import com.pro.scm.wrappers.AdjustmentStockWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Habiboon Patan
 * @since 30.07.2019
 * @Des : ReceivedGoodsController
 */
@Slf4j
@RestController
@RequestMapping("/AdjustmentStockController")
public class AdjustmentStockController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	@Qualifier("objAdjustmentStockServiceImpl")
	private AdjustmentStockService objAdjustmentStockServiceImpl;

	/**
	 * @author : priyadarshini
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : countDrugsByStore
	 * @URL :
	 *      192.168.1.149:2000/scmservice/AdjustmentStockController/countDrugsByStore
	 * 
	 * 
	 *      {"fromStoreId":"99", "drugName":"¥", "brandId":0, "formId":0,
	 *      "manufacturerId":0, "shortcode":"¥", "systemId":0, "genericGroupId":0,
	 *      "genericMoleculeId":0, "frimStoreId":0, "typeId":2 }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/countDrugsByStore", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response countDrugsByStore(@RequestBody AdjustmentStockControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::countDrugsByStore():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		AdjustmentStockServiceDTO dataInfo = new AdjustmentStockServiceDTO();
		AdjustmentStockMapper dataMapper = new AdjustmentStockMapper();
		AdjustmentStockWrapper dataWrapper = new AdjustmentStockWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBrandId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFormId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getManufacturerId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getShortcode())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSystemId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericGroupId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericMoleculeId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFromStoreId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTypeId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String count = objAdjustmentStockServiceImpl.countDrugsByStore(dataInfo, strRequestID);
			// dataWrapper.setPlacingOrdersForPurchaseControllerDTO(objAllowanceControllerDTO);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(count);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::countDrugsByStore()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}


	/**
	 * @author : Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 22-04-2020
	 * @Des : updateStockQuantity
	 * @URL :
	 *      localhost:2000/scmservice/AdjustmentStockController/updateStockQuantity
	 *      {"fromStoreId":"99999", "drugId":"111", "drugQtys":1, "drugBatchs":1,
	 *      "size":1, "increaseOrDecrease":1, "user_id":1, "module_id":1,
	 *      "role_id":1, "bufStockRefId":1 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateStockQuantity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response updateStockQuantity(@RequestBody AdjustmentStockControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::::::::::::::::::::::::::::updateReturnItemStaus()::::::::::::::::::::::::"
				+ dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		AdjustmentStockServiceDTO dataInfo = new AdjustmentStockServiceDTO();
		AdjustmentStockMapper dataMapper = new AdjustmentStockMapper();
		AdjustmentStockWrapper dataWrapper = new AdjustmentStockWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugQtys())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugBatchs())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSize())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getIncreaseOrDecrease())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUser_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModule_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRole_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBufStockRefId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objAdjustmentStockServiceImpl.updateStockQuantity(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::updateStockQuantity()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @author : RAnjeet kr
	 * @throws DataNotFoundException
	 * @Date : 27-05-2020
	 * @Des : loadEmployees
	 * @Parameters :drugId
	 * @URL : localhost:2000/scmservice/AdjustmentStockController/loadEmployees
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadEmployees", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes  = MediaType.APPLICATION_JSON_VALUE)
	public Response loadEmployees(@RequestBody AdjustmentStockControllerDTO controllerDto)
			throws DataNotFoundException, InSufficientInputException {
		String requestID = (String) request.getAttribute("sessionid");
		log.info(requestID + ":::::::::::::::::::::::::::::loadEmployees()::::::::::::::::::::::::::::::::::::::::::");
		List<AdjustmentStockControllerDTO> objAdjustmentStockControllerDTO = new ArrayList<AdjustmentStockControllerDTO>();
		AdjustmentStockMapper objAdjustmentStockMapper = new AdjustmentStockMapper();
		AdjustmentStockWrapper objAdjustmentStockWrapper = new AdjustmentStockWrapper();
		if (controllerDto.getDrugId() != null) {
			List<AdjustmentStockServiceDTO> datas = objAdjustmentStockServiceImpl.loadEmployees(
					objAdjustmentStockMapper.conversionControllerDtoToServiceDto(controllerDto), requestID);
			objAdjustmentStockWrapper.setAdjustmentStockControllerDTO(
					new AdjustmentStockMapper().conversionForServiceTOControllerDTO(datas));
			objAdjustmentStockWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objAdjustmentStockWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			log.info("::::OUTPUT:::::::::::::loadEmployees()::::::::::::::::::::::::::::::::::::::"
					+ objAdjustmentStockWrapper.toString());
		} else {
			objAdjustmentStockWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objAdjustmentStockWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(controllerDto.toString());
		}
		return objAdjustmentStockWrapper;

	}

	/**
	 * @author : Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 22-04-2020
	 * @Des : saveAdjustedStockDetails
	 * @URL :
	 *      localhost:2000/scmservice/AdjustmentStockController/saveAdjustedStockDetails
	 *      {"bufStockRefId":"99999", "drugId":"111", "drugBatchs":1, "drugQtys":1,
	 *      "storeId":1, "adj_type_id":1, "emp_id":1, "desc":1, "count":1,
	 *      "user_id":1, "module_id":1, "role_id":1, "expDate":"now", "typeId":1,
	 *      "inviceNo":1 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveAdjustedStockDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response saveAdjustedStockDetails(@RequestBody AdjustmentStockControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::::::::::::::::::::::::::::saveAdjustedStockDetails()::::::::::::::::::::::::"
				+ dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		AdjustmentStockServiceDTO dataInfo = new AdjustmentStockServiceDTO();
		AdjustmentStockMapper dataMapper = new AdjustmentStockMapper();
		AdjustmentStockWrapper dataWrapper = new AdjustmentStockWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getBufStockRefId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugBatchs())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugQtys())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getStoreId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getAdj_type_id())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getEmp_id())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDesc())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUser_id())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModule_id())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRole_id())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getExpDate())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTypeId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getInviceNo())
				) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objAdjustmentStockServiceImpl.saveAdjustedStockDetails(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::saveAdjustedStockDetails()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}
	
	
	
	
	/**
	 * @author : Habiboon Patan
	 * @throws DataNotFoundException
	 * @Date : 27-04-2020
	 * @Des : loadEmployees
	 * @Parameters :NO
	 * @URL : localhost:2000/scmservice/AdjustmentStockController/loadEmployees
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadEmployees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadEmployees() throws DataNotFoundException {
		String requestID = (String) request.getAttribute("sessionid");
		log.info(requestID + ":::::::::::::::::::::::::::::loadEmployees()::::::::::::::::::::::::::::::::::::::::::");
		List<AdjustmentStockControllerDTO> objAdjustmentStockControllerDTO = new ArrayList<AdjustmentStockControllerDTO>();
		AdjustmentStockMapper objAdjustmentStockMapper = new AdjustmentStockMapper();
		AdjustmentStockWrapper objAdjustmentStockWrapper = new AdjustmentStockWrapper();

		List<AdjustmentStockServiceDTO> datas = objAdjustmentStockServiceImpl.loadEmployees(requestID);
		objAdjustmentStockWrapper.setAdjustmentStockControllerDTO(
				new AdjustmentStockMapper().conversionForServiceTOControllerDTO(datas));
		objAdjustmentStockWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objAdjustmentStockWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		
		log.info("::::OUTPUT:::::::::::::loadEmployees()::::::::::::::::::::::::::::::::::::::"
				+ objAdjustmentStockWrapper.toString());
		return objAdjustmentStockWrapper;

	}

}

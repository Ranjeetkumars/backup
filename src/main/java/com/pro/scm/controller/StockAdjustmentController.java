package com.pro.scm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.StockAdjustmentControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.StockAdjustmentMapper;
import com.pro.scm.service.StockAdjustmentService;
import com.pro.scm.servicedto.StockAdjustmentServiceDTO;
import com.pro.scm.wrappers.StockAdjustmentWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/StockAdjustmentController")
@Slf4j
public class StockAdjustmentController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objStockAdjustmentService")
	private StockAdjustmentService objStockAdjustmentService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/StockAdjustmentController/addAdjustType
	 * @Parameters :{"adjustmentcode":"Ad124","adjustmentDesc":"Medicine","adjustmentType":"medicines",
	 * "userId":171,"moduleId":40,"roleId":100,"status":true }
	 */
	@RequestMapping(value = "/addAdjustType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response addAdjustType(@RequestBody StockAdjustmentControllerDTO objStockAdjustmentControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objStockAdjustmentControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		StockAdjustmentMapper objStockAdjustmentMapper = new StockAdjustmentMapper();
		StockAdjustmentWrapper objStockAdjustmentWrapper = new StockAdjustmentWrapper();
		if (objStockAdjustmentControllerDTO.getAdjustmentcode()!= null && objStockAdjustmentControllerDTO.getAdjustmentDesc()!= null &&
			objStockAdjustmentControllerDTO.getAdjustmentType()!= null && objStockAdjustmentControllerDTO.getUserId()!= null && 
			objStockAdjustmentControllerDTO.getModuleId()!= null &&
			objStockAdjustmentControllerDTO.getRoleId()!= null && objStockAdjustmentControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objStockAdjustmentService.addAdjustType(
					objStockAdjustmentMapper.conversionControllerDtoToServiceDto(objStockAdjustmentControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objStockAdjustmentWrapper.setResponseCode(HttpStatus.OK.value());
				objStockAdjustmentWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objStockAdjustmentWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objStockAdjustmentWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objStockAdjustmentWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objStockAdjustmentWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objStockAdjustmentWrapper.toString());
		return objStockAdjustmentWrapper;
	}
	
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/StockAdjustmentController/updateAdjustType
	 * @Parameters :{"adjustmentcode":"Ad124","adjustmentDesc":"Medicine","adjustmentType":"medicines","status":true,"adjustmentId":1 } 
	 */
	@RequestMapping(value = "/updateAdjustType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateAdjustType(@RequestBody StockAdjustmentControllerDTO objStockAdjustmentControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objStockAdjustmentControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		StockAdjustmentMapper objStockAdjustmentMapper = new StockAdjustmentMapper();
		StockAdjustmentWrapper objStockAdjustmentWrapper = new StockAdjustmentWrapper();
		if (objStockAdjustmentControllerDTO.getAdjustmentcode()!= null &&
			objStockAdjustmentControllerDTO.getAdjustmentDesc()!= null && objStockAdjustmentControllerDTO.getAdjustmentType()!= null &&
			objStockAdjustmentControllerDTO.getStatus()!= null && objStockAdjustmentControllerDTO.getAdjustmentId()!= null) {
			String rtnValueOfMT = objStockAdjustmentService.updateAdjustType(
					objStockAdjustmentMapper.conversionControllerDtoToServiceDto(objStockAdjustmentControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objStockAdjustmentWrapper.setResponseCode(HttpStatus.OK.value());
				objStockAdjustmentWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objStockAdjustmentWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objStockAdjustmentWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objStockAdjustmentWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objStockAdjustmentWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objStockAdjustmentWrapper.toString());
		return objStockAdjustmentWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/StockAdjustmentController/loadAdjustTypes
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadAdjustTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadAdjustTypes() throws InSufficientInputException, DataNotFoundException {
		StockAdjustmentWrapper objwrapper = new StockAdjustmentWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<StockAdjustmentServiceDTO> sDto = objStockAdjustmentService.loadAdjustTypes(strRequestID);
		objwrapper.setObjStockAdjustmentControllerDTO(
				new StockAdjustmentMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/StockAdjustmentController/adjustmentIsExist
	 * @Parameters :{"adjustmentcode":"2"}
	 */
	@RequestMapping(value = "/adjustmentIsExist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response adjustmentIsExist(@RequestBody StockAdjustmentControllerDTO objStockAdjustmentControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objStockAdjustmentControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		StockAdjustmentMapper objStockAdjustmentMapper = new StockAdjustmentMapper();
		StockAdjustmentWrapper objStockAdjustmentWrapper = new StockAdjustmentWrapper();
		if (objStockAdjustmentControllerDTO.getAdjustmentcode()!= null) {
			String rtnValueOfMT = objStockAdjustmentService.adjustmentIsExist(
					objStockAdjustmentMapper.conversionControllerDtoToServiceDto(objStockAdjustmentControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objStockAdjustmentWrapper.setResponseCode(HttpStatus.OK.value());
				objStockAdjustmentWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objStockAdjustmentWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objStockAdjustmentWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objStockAdjustmentWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objStockAdjustmentWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objStockAdjustmentWrapper.toString());
		return objStockAdjustmentWrapper;
	}
}

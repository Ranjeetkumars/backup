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

import com.pro.scm.controllerdto.GenericNameControllerDTO;
import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.GenericNameMapper;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.service.GenericNameService;
import com.pro.scm.servicedto.GenericServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.wrappers.GenericNameWrapper;
import com.pro.scm.wrappers.PlacingOrdersForPurchaseWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/GenericNameController")
@Slf4j
public class GenericNameController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objGenericNameService")
	private GenericNameService objGenericNameService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/GenericNameController/saveGenericName
	 * @Parameters :{"genericName":"Consumables","shortCode":CO-149,"moduleId":40,"roleId":100,"userId":171,"status":true} 
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveGenericNames", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveGenericName(@RequestBody GenericNameControllerDTO objGenericNameControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objGenericNameControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		GenericNameMapper objGenericNameMapper = new GenericNameMapper();
		GenericNameWrapper objGenericNameWrapper = new GenericNameWrapper();
		if (objGenericNameControllerDTO.getGenericName()!= null &&objGenericNameControllerDTO.getShortCode()!= null &&
			objGenericNameControllerDTO.getModuleId()!= null && objGenericNameControllerDTO.getRoleId()!= null &&
			objGenericNameControllerDTO.getUserId()!= null && objGenericNameControllerDTO.getStatus()!= null  ) {
			String rtnValueOfMT = objGenericNameService.saveGenericName(
					objGenericNameMapper.conversionControllerDtoToServiceDto(objGenericNameControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objGenericNameWrapper.setResponseCode(HttpStatus.OK.value());
				objGenericNameWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objGenericNameWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objGenericNameWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objGenericNameWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objGenericNameWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objGenericNameWrapper.toString());
		return objGenericNameWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/GenericNameController/updateGenericName
	 * @Parameters :{"genericName":"medical","shortCode":CO-149,"status":true,"genericId":1} 
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateGenericName", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateGenericName(@RequestBody GenericNameControllerDTO objGenericNameControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objGenericNameControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		GenericNameMapper objGenericNameMapper = new GenericNameMapper();
		GenericNameWrapper objGenericNameWrapper = new GenericNameWrapper();
		if (objGenericNameControllerDTO.getGenericName()!= null &&objGenericNameControllerDTO.getShortCode()!= null &&
			objGenericNameControllerDTO.getStatus()!= null && objGenericNameControllerDTO.getGenericId()!= null ) {
			String rtnValueOfMT = objGenericNameService.updateGenericName(
					objGenericNameMapper.conversionControllerDtoToServiceDto(objGenericNameControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objGenericNameWrapper.setResponseCode(HttpStatus.OK.value());
				objGenericNameWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objGenericNameWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objGenericNameWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objGenericNameWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objGenericNameWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objGenericNameWrapper.toString());
		return objGenericNameWrapper;
	}
	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-08-27
	 * @Des : getdrugsName
	 * @Parameters :NO
	 * @URL :
	 *  localhost:2000/scmservice/GenericNameController/getdrugsName
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/getdrugsName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getdrugsName() throws DataNotFoundException {
		String requestID = (String) request.getAttribute("sessionid");
		log.info(requestID + ":::::::::::::::::::::::::::::getdrugsName()::::::::::::::::::::::::::::::::::::::::::");
		GenericNameWrapper objGenericNameWrapper = new GenericNameWrapper();
		List<GenericServiceDTO> datas = objGenericNameService
				.getdrugsName(requestID);
		objGenericNameWrapper.setObjGenericNameControllerDTO(
				new GenericNameMapper().conversionForServiceTOControllerDTO(datas));
		objGenericNameWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objGenericNameWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT:::::::::::::getdrugsName()::::::::::::::::::::::::::::::::::::::"
				+ objGenericNameWrapper.toString());
		return objGenericNameWrapper;

	}
}

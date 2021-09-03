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

import com.pro.scm.controllerdto.PharmacyStoreControllerDTO;
import com.pro.scm.controllerdto.RackDetailsControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.BrandDetailsMapper;
import com.pro.scm.mappers.PharmacyStoreMapper;
import com.pro.scm.mappers.StoreMapper;
import com.pro.scm.service.PharmacyStoreService;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.StoreServiceDTO;
import com.pro.scm.wrappers.BrandDetailsWrapper;
import com.pro.scm.wrappers.PharmacyStoreWrapper;
import com.pro.scm.wrappers.StoreWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/PharmacyStoreController")
@Slf4j
public class PharmacyStoreController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objPharmacyStoreService")
	private PharmacyStoreService objPharmacyStoreService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/PharmacyStoreController/addStores
	 * @Parameters :{"storeName":"pharmacy medical Store","description":"medicines","userId":171,"roleId":100,"moduleId":40,"status":true,"typeStoreId":1} 
	 */
	@RequestMapping(value = "/addStores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveRackShelveDetails(@RequestBody PharmacyStoreControllerDTO objPharmacyStoreControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objPharmacyStoreControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PharmacyStoreMapper objPharmacyStoreMapper = new PharmacyStoreMapper();
		PharmacyStoreWrapper objPharmacyStoreWrapper = new PharmacyStoreWrapper();
		if (objPharmacyStoreControllerDTO.getStoreName()!= null &&objPharmacyStoreControllerDTO.getDescription()!= null &&
			objPharmacyStoreControllerDTO.getUserId()!= null && objPharmacyStoreControllerDTO.getRoleId()!= null &&
			objPharmacyStoreControllerDTO.getModuleId()!= null && objPharmacyStoreControllerDTO.getStatus()!= null &&
			objPharmacyStoreControllerDTO.getTypeStoreId()!= null) {
			String rtnValueOfMT = objPharmacyStoreService.addStores(
					objPharmacyStoreMapper.conversionControllerDtoToServiceDto(objPharmacyStoreControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.OK.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objPharmacyStoreWrapper.toString());
		return objPharmacyStoreWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/PharmacyStoreController/UpdateStores
	 * @Parameters :{"storeName":"R15","description":171,"status":true,"storeId":10000} 
	 */
	@RequestMapping(value = "/UpdateStores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response UpdateRackDetails(@RequestBody PharmacyStoreControllerDTO objPharmacyStoreControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objPharmacyStoreControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PharmacyStoreMapper objPharmacyStoreMapper = new PharmacyStoreMapper();
		PharmacyStoreWrapper objPharmacyStoreWrapper = new PharmacyStoreWrapper();
		if (objPharmacyStoreControllerDTO.getStoreName()!= null &&objPharmacyStoreControllerDTO.getDescription()!= null &&
				objPharmacyStoreControllerDTO.getStatus()!= null && objPharmacyStoreControllerDTO.getStoreId()!= null) {
			String rtnValueOfMT = objPharmacyStoreService.UpdateStores(
					objPharmacyStoreMapper.conversionControllerDtoToServiceDto(objPharmacyStoreControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.OK.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objPharmacyStoreWrapper.toString());
		return objPharmacyStoreWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/PharmacyStoreController/checkPharmacyStoreExist
	 * @Parameters :{"storeName":"pharmacy medical Store"} 
	 */
	@RequestMapping(value = "/checkPharmacyStoreExist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checkPharmacyStoreExist(@RequestBody PharmacyStoreControllerDTO objPharmacyStoreControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objPharmacyStoreControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PharmacyStoreMapper objPharmacyStoreMapper = new PharmacyStoreMapper();
		PharmacyStoreWrapper objPharmacyStoreWrapper = new PharmacyStoreWrapper();
		if (objPharmacyStoreControllerDTO.getStoreName()!= null) {
			String rtnValueOfMT = objPharmacyStoreService.checkPharmacyStoreExist(
					objPharmacyStoreMapper.conversionControllerDtoToServiceDto(objPharmacyStoreControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.OK.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objPharmacyStoreWrapper.toString());
		return objPharmacyStoreWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/PharmacyStoreController/getStoreStatus
	 * @Parameters :{"storeId":100000} 
	 */
	@RequestMapping(value = "/getStoreStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getStoreStatus(@RequestBody PharmacyStoreControllerDTO objPharmacyStoreControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objPharmacyStoreControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PharmacyStoreMapper objPharmacyStoreMapper = new PharmacyStoreMapper();
		PharmacyStoreWrapper objPharmacyStoreWrapper = new PharmacyStoreWrapper();
		if (objPharmacyStoreControllerDTO.getStoreId()!= null) {
			String rtnValueOfMT = objPharmacyStoreService.getStoreStatus(
					objPharmacyStoreMapper.conversionControllerDtoToServiceDto(objPharmacyStoreControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.OK.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objPharmacyStoreWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objPharmacyStoreWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objPharmacyStoreWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objPharmacyStoreWrapper.toString());
		return objPharmacyStoreWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/PharmacyStoreController/loadPharmacyStores
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadPharmacyStores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadBrandDetails() throws InSufficientInputException, DataNotFoundException {
		StoreWrapper objStoreWrapper = new StoreWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<StoreServiceDTO> sDto = objPharmacyStoreService.loadPharmacyStores(strRequestID);
		objStoreWrapper.setObjStoreControllerDTO(
				new StoreMapper().conversionForServiceTOControllerDTO(sDto));
		objStoreWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objStoreWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objStoreWrapper.toString());
		return objStoreWrapper;
	}

	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/PharmacyStoreController/loadStoreType
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadStoreType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadStoreType() throws InSufficientInputException, DataNotFoundException {
		StoreWrapper objStoreWrapper = new StoreWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<StoreServiceDTO> sDto = objPharmacyStoreService.loadStoreType(strRequestID);
		objStoreWrapper.setObjStoreControllerDTO(
				new StoreMapper().conversionForServiceTOControllerDTO(sDto));
		objStoreWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objStoreWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objStoreWrapper.toString());
		return objStoreWrapper;
	}
}

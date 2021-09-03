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


import com.pro.scm.controllerdto.CounterIndentControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.CounterIndentMapper;
import com.pro.scm.service.CounterIndentService;
import com.pro.scm.servicedto.CounterIndentServiceDTO;
import com.pro.scm.wrappers.CounterIndentWrapper;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Bhuneshwar
 *
 */
@RestController
@RequestMapping("/counterIndentController")
@Slf4j
public class CounterIndentController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("counterIndentService")
	private CounterIndentService counterIndentService;
	@Autowired
	private HttpServletRequest request;
	
	
	
	  /**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @json:{ "drugidlist":"12", "quantitylist":"567", "createdbyid":1,
	 *         "createdbyroleid":1, "createdbymoduleid":1, "size":1,
	 *         "indentnumber":"12", "indenttype":1, "fromcnterid":1, "tocnterid":1,
	 *         "indstatusid":1 }
	 * @URL :
	 *      http://localhost:2001/scmservice/counterIndentController/api/version_1/insertRaiseCounterIndentQuantity
	 */

	@RequestMapping(value = "/api/version_1/insertRaiseCounterIndentQuantity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response insertRaiseCounterIndentQuantity(@RequestBody CounterIndentControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		CounterIndentMapper mapper = new CounterIndentMapper();
		CounterIndentWrapper wrapper = new CounterIndentWrapper();
		if (objControllerDto.getDrugidlist() != null && objControllerDto.getQuantitylist() != null&&objControllerDto.getCreatedbyid()!=null
				&&objControllerDto.getCreatedbyroleid()!=null&&objControllerDto.getCreatedbymoduleid()!=null
				&&objControllerDto.getSize()!=null&&objControllerDto.getIndentnumber()!=null&&objControllerDto.getIndenttype()!=null
				&&objControllerDto.getFromcnterid()!=null&&objControllerDto.getTocnterid()!=null&&objControllerDto.getIndstatusid()!=null) {
			String rtnValueOfMT = counterIndentService
					.insertRaiseCounterIndentQuantity(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	 
	  /**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019 getGenerateRetailIndentNumber
	 * @json:{ "currentdate":"2019-01-01" }
	 * 
	 * @URL :
	 *      http://localhost:2001/scmservice/counterIndentController/api/version_1/getGenerateRetailIndentNumber
	 */
	@RequestMapping(value = "/api/version_1/getGenerateRetailIndentNumber", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getGenerateRetailIndentNumber(@RequestBody CounterIndentControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getGenerateRetailIndentNumber method is executed inside addNewDrugController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		CounterIndentMapper mapper = new CounterIndentMapper();
		CounterIndentWrapper wrapper = new CounterIndentWrapper();
		if (objControllerDto.getCurrentdate() != null) {
			List<CounterIndentServiceDTO> objAddNewLocalDrugServiceDTO = counterIndentService
					.getGenerateRetailIndentNumber(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjCounterIndentControllerDTO(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
						
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	

	  /**
		 * @author :Bhuneshwar Patel
		 * @throws InSufficientInputException ,DataNotFoundException
		 * @Date : 30-07-2019 getGenerateRetailIndentNumber
		 * @json:
		 * 
		 * @URL :
		 *      http://localhost:2001/scmservice/counterIndentController/api/version_1/updateItemStatus
		 */
	@RequestMapping(value = "/api/version_1/updateItemStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateItemStatus(@RequestBody CounterIndentControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		CounterIndentMapper mapper = new CounterIndentMapper();
		CounterIndentWrapper wrapper = new CounterIndentWrapper();
		if (objControllerDto.getIndentnumber() != null && objControllerDto.getDrugId()!= null && objControllerDto.getSize()!=null) {
			String rtnValueOfMT = counterIndentService
					.updateItemStatus(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	  /**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019 loadIndentItemsList
	 * @json:{ "indentnumber":1 }
	 * @URL :
	 *      http://localhost:2001/scmservice/counterIndentController/api/version_1/loadIndentItemsList
	 */
		@RequestMapping(value = "/api/version_1/loadIndentItemsList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response loadIndentItemsList(@RequestBody CounterIndentControllerDTO objControllerDto)
				throws InSufficientInputException, DataNotFoundException {
			log.info("loadIndentItemsList method is executed inside addNewDrugController" + objControllerDto);
			String strRequestID = request.getAttribute("reqid").toString();
			log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
			CounterIndentMapper mapper = new CounterIndentMapper();
			CounterIndentWrapper wrapper = new CounterIndentWrapper();
			if (objControllerDto.getIndentnumber() != null) {
				List<CounterIndentServiceDTO> objAddNewLocalDrugServiceDTO = counterIndentService
						.loadIndentItemsList(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
				wrapper.setObjCounterIndentControllerDTO(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
				wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
				wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
							
			} else {
				throw new InSufficientInputException(objControllerDto.toString());
			}
			log.info(strRequestID + ":::::::::::::" + wrapper.toString());
			return wrapper;
		}
	
}

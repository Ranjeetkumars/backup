package com.pro.scm.controller;

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

import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.ScheduleControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.ScheduleMapper;
import com.pro.scm.service.ScheduleService;
import com.pro.scm.servicedto.ScheduleServiceDTO;
import com.pro.scm.wrappers.ScheduleWrapper;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ScheduleController")
@Slf4j
public class ScheduleController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objScheduleService")
	private ScheduleService objScheduleService;
	@Autowired
	private HttpServletRequest request;
	
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ScheduleController/saveSupplier
	 * @Parameters :{"scheduleName":"rohith","userId":171,"moduleId":40,"roleId":100,"status":true} 
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveSupplier(@RequestBody ScheduleControllerDTO objScheduleControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objScheduleControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ScheduleMapper objScheduleMapper = new ScheduleMapper();
		ScheduleWrapper objScheduleWrapper = new ScheduleWrapper();
		if (objScheduleControllerDTO.getScheduleName()!= null &&
			objScheduleControllerDTO.getUserId()!= null && objScheduleControllerDTO.getModuleId()!= null &&
			objScheduleControllerDTO.getRoleId()!= null && objScheduleControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objScheduleService.saveSchedule(
					objScheduleMapper.conversionControllerDtoToServiceDto(objScheduleControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objScheduleWrapper.setResponseCode(HttpStatus.OK.value());
				objScheduleWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objScheduleWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objScheduleWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objScheduleWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objScheduleWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objScheduleWrapper.toString());
		return objScheduleWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ScheduleController/updateScheduleStores
	 * @Parameters :{"scheduleName":"rohit","status":true,"scheduleId":1} 
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateScheduleStores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateScheduleStores(@RequestBody ScheduleControllerDTO objScheduleControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objScheduleControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ScheduleMapper objScheduleMapper = new ScheduleMapper();
		ScheduleWrapper objScheduleWrapper = new ScheduleWrapper();
		if (objScheduleControllerDTO.getScheduleName()!= null &&
			objScheduleControllerDTO.getStatus()!= null && objScheduleControllerDTO.getScheduleId()!= null) {
			String rtnValueOfMT = objScheduleService.updateScheduleStores(
					objScheduleMapper.conversionControllerDtoToServiceDto(objScheduleControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objScheduleWrapper.setResponseCode(HttpStatus.OK.value());
				objScheduleWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objScheduleWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objScheduleWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objScheduleWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objScheduleWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objScheduleWrapper.toString());
		return objScheduleWrapper;
	}
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ScheduleController/loadSchedule
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadSchedule", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSchedule() throws InSufficientInputException, DataNotFoundException {
		ScheduleWrapper objwrapper = new ScheduleWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<ScheduleServiceDTO> sDto = objScheduleService.loadSchedule(strRequestID);
		objwrapper.setObjScheduleControllerDTO(
				new ScheduleMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
}

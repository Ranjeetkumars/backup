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

import com.pro.scm.controllerdto.RackShelveDetailsControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.RackShelveDetailsMapper;
import com.pro.scm.service.RackShelveDetailsService;
import com.pro.scm.servicedto.RackShelveServiceDTO;
import com.pro.scm.wrappers.RackShelveDetailsWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/RackShleveController")
@Slf4j
public class RackShleveController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objRackShelveDetailsService")
	private RackShelveDetailsService objRackShelveDetailsService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 201{"shelveName":"R15","userId":171,"roleId":100,"moduleId":40,"storeId":100017","rackId":12,"status":true}9-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/RackShleveController/saveRackShelveDetails
	 * @Parameters : 
	 */
	@RequestMapping(value = "/saveRackShelveDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveRackShelveDetails(@RequestBody RackShelveDetailsControllerDTO objRackShelveDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objRackShelveDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		RackShelveDetailsMapper objRackShelveDetailsMapper = new RackShelveDetailsMapper();
		RackShelveDetailsWrapper objRackShelveDetailsWrapper = new RackShelveDetailsWrapper();
		if (objRackShelveDetailsControllerDTO.getShelveName()!= null &&
			objRackShelveDetailsControllerDTO.getUserId()!= null && objRackShelveDetailsControllerDTO.getRoleId()!= null &&
			objRackShelveDetailsControllerDTO.getModuleId()!= null && objRackShelveDetailsControllerDTO.getStoreId()!= null &&
			objRackShelveDetailsControllerDTO.getRackId()!= null &&objRackShelveDetailsControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objRackShelveDetailsService.saveRackShelveDetails(
					objRackShelveDetailsMapper.conversionControllerDtoToServiceDto(objRackShelveDetailsControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objRackShelveDetailsWrapper.setResponseCode(HttpStatus.OK.value());
				objRackShelveDetailsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objRackShelveDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objRackShelveDetailsWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objRackShelveDetailsWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objRackShelveDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objRackShelveDetailsWrapper.toString());
		return objRackShelveDetailsWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/RackShleveController/updateRackShelveDetails
	 * @Parameters :{"shelveName":"R15","userId":171,"roleId":100,"moduleId":40,"storeId":100015,"rackId":15,"status":true,"shelveId":17} 
	 */
	@RequestMapping(value = "/updateRackShelveDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateScheduleStores(@RequestBody RackShelveDetailsControllerDTO objRackShelveDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objRackShelveDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		RackShelveDetailsMapper objRackShelveDetailsMapper = new RackShelveDetailsMapper();
		RackShelveDetailsWrapper objRackShelveDetailsWrapper = new RackShelveDetailsWrapper();
		if (objRackShelveDetailsControllerDTO.getShelveName()!= null &&objRackShelveDetailsControllerDTO.getUserId()!= null &&
				objRackShelveDetailsControllerDTO.getRoleId()!= null && objRackShelveDetailsControllerDTO.getModuleId()!= null
				&& objRackShelveDetailsControllerDTO.getStoreId()!= null&& objRackShelveDetailsControllerDTO.getRackId()!= null
				&& objRackShelveDetailsControllerDTO.getStatus()!= null&& objRackShelveDetailsControllerDTO.getShelveId()!= null) {
			String rtnValueOfMT = objRackShelveDetailsService.updateRackShelveDetails(
					objRackShelveDetailsMapper.conversionControllerDtoToServiceDto(objRackShelveDetailsControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objRackShelveDetailsWrapper.setResponseCode(HttpStatus.OK.value());
				objRackShelveDetailsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objRackShelveDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objRackShelveDetailsWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objRackShelveDetailsWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objRackShelveDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objRackShelveDetailsWrapper.toString());
		return objRackShelveDetailsWrapper;
	}
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/RackShleveController/loadRackShelveDetails
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadRackShelveDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSchedule() throws InSufficientInputException, DataNotFoundException {
		RackShelveDetailsWrapper objRackShelveDetailsWrapper = new RackShelveDetailsWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<RackShelveServiceDTO> sDto = objRackShelveDetailsService.loadRackShelveDetails(strRequestID);
		objRackShelveDetailsWrapper.setObjRackShelveDetailsControllerDTO(
				new RackShelveDetailsMapper().conversionForServiceTOControllerDTO(sDto));
		objRackShelveDetailsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objRackShelveDetailsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objRackShelveDetailsWrapper.toString());
		return objRackShelveDetailsWrapper;
	}
}

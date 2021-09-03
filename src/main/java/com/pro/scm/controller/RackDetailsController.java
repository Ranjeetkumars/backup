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

import com.pro.scm.controllerdto.RackDetailsControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.RackDetailsMapper;
import com.pro.scm.service.RackDetailsService;
import com.pro.scm.servicedto.RackDetailsServiceDTO;
import com.pro.scm.wrappers.RackDetailsWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/RackDetailsController")
@Slf4j
public class RackDetailsController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objRackDetailsService")
	private RackDetailsService objRackDetailsService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/RackDetailsController/saveRackDetails
	 * @Parameters :{"rackName":"R15","userId":171,"roleId":100,"moduleId":40,"storeId":100017","status":true} 
	 */
	@RequestMapping(value = "/saveRackDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveRackShelveDetails(@RequestBody RackDetailsControllerDTO objRackDetailsController)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objRackDetailsController.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		RackDetailsMapper objRackDetailsMapper = new RackDetailsMapper();
		RackDetailsWrapper objRackDetailsWrapper = new RackDetailsWrapper();
		if (objRackDetailsController.getRackName()!= null &&
			objRackDetailsController.getUserId()!= null && objRackDetailsController.getRoleId()!= null &&
			objRackDetailsController.getModuleId()!= null && objRackDetailsController.getStoreId()!= null &&
			objRackDetailsController.getStatus()!= null) {
			String rtnValueOfMT = objRackDetailsService.saveRackDetails(
					objRackDetailsMapper.conversionControllerDtoToServiceDto(objRackDetailsController), strRequestID);
			if (rtnValueOfMT != null) {
				objRackDetailsWrapper.setResponseCode(HttpStatus.OK.value());
				objRackDetailsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objRackDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objRackDetailsWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objRackDetailsWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objRackDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objRackDetailsWrapper.toString());
		return objRackDetailsWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/RackDetailsController/UpdateRackDetails
	 * @Parameters :{"rackName":"R15","userId":171,"roleId":100,"moduleId":40,"storeId":100015,"rackId":15,"status":true} 
	 */
	@RequestMapping(value = "/UpdateRackDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response UpdateRackDetails(@RequestBody RackDetailsControllerDTO objRackDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objRackDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		RackDetailsMapper objRackDetailsMapper = new RackDetailsMapper();
		RackDetailsWrapper obRackDetailsWrapper = new RackDetailsWrapper();
		if (objRackDetailsControllerDTO.getRackName()!= null &&objRackDetailsControllerDTO.getUserId()!= null &&
				objRackDetailsControllerDTO.getRoleId()!= null && objRackDetailsControllerDTO.getModuleId()!= null
				&& objRackDetailsControllerDTO.getStoreId()!= null&& objRackDetailsControllerDTO.getRackId()!= null
				&& objRackDetailsControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objRackDetailsService.UpdateRackDetails(
					objRackDetailsMapper.conversionControllerDtoToServiceDto(objRackDetailsControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				obRackDetailsWrapper.setResponseCode(HttpStatus.OK.value());
				obRackDetailsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				obRackDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				obRackDetailsWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				obRackDetailsWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				obRackDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+obRackDetailsWrapper.toString());
		return obRackDetailsWrapper;
	}
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/RackDetailsController/loadRackDetails
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadRackDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadRackDetails() throws InSufficientInputException, DataNotFoundException {
		RackDetailsWrapper obRackDetailsWrapper = new RackDetailsWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<RackDetailsServiceDTO> sDto = objRackDetailsService.loadRackDetails(strRequestID);
		obRackDetailsWrapper.setObjRackDetailsControllerDTO(
				new RackDetailsMapper().conversionForServiceTOControllerDTO(sDto));
		obRackDetailsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		obRackDetailsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+obRackDetailsWrapper.toString());
		return obRackDetailsWrapper;
	}
}

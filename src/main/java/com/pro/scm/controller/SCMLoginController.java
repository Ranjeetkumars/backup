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
import com.pro.scm.controllerdto.SCMLoginControllerDto;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.SMCLoginMapper;
import com.pro.scm.service.SCMLoginService;
import com.pro.scm.servicedto.SCMLoginServiceDto;

import com.pro.scm.wrappers.SCMLoginWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <h1>Regarding CASDashboard all functionlity has writen</h1>
 * 
 * @author Ranjeet kumar
 * @version JDK1.8
 * @since 05/26/2019
 */
@RestController
@RequestMapping("/scmloginController")
@Slf4j
public class SCMLoginController {

	InSufficientInputException obj;

	@Autowired
	@Qualifier("scmLoginService")
	private SCMLoginService scmLoginService;
	@Autowired
	private HttpServletRequest request;


	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : getRoles
	 * @URL :
	 *      http://localhost:2000/scmservice/scmloginController/api/version_1/getRoles
	 */
	@RequestMapping(value = "/api/version_1/getRoles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getRoles(@RequestBody SCMLoginControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		SMCLoginMapper mapper = new SMCLoginMapper();
		SCMLoginWrapper wrapper = new SCMLoginWrapper();
	if(objControllerDto.getModuleId() != null && objControllerDto.getUserName() != null) {
			String rtnValueOfMT = scmLoginService
					.getRoles(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : checkRoleforUser
	 * @URL :
	 *      http://localhost:2000/scmservice/scmloginController/api/version_1/checkRoleforUser
	 */
	@RequestMapping(value = "/api/version_1/checkRoleforUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response checkRoleforUser(@RequestBody SCMLoginControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		SMCLoginMapper mapper = new SMCLoginMapper();
		SCMLoginWrapper wrapper = new SCMLoginWrapper();
		if (objControllerDto.getModuleId() != null && objControllerDto.getRoleId() != null
				&& objControllerDto.getUserId() != null) {
			String rtnValueOfMT = scmLoginService
					.checkRoleforUser(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : checkRoleforUser
	 * @URL :
	 *      http://localhost:2000/scmservice/scmloginController/api/version_1/updateCounterId
	 */
	@RequestMapping(value = "/api/version_1/updateCounterId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateCounterId(@RequestBody SCMLoginControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		SMCLoginMapper mapper = new SMCLoginMapper();
		SCMLoginWrapper wrapper = new SCMLoginWrapper();
		if (objControllerDto.getCounterId() != null && objControllerDto.getUserId() != null) {
			String rtnValueOfMT = scmLoginService
					.updateCounterId(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : loadRoles
	 * @URL :
	 *      http://localhost:2000/scmservice/scmloginController/api/version_1/loadRoles
	 */
	@RequestMapping(value = "/api/version_1/loadRoles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadRoles(@RequestBody SCMLoginControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		SMCLoginMapper mapper = new SMCLoginMapper();
		SCMLoginWrapper wrapper = new SCMLoginWrapper();
		if (objControllerDto.getModuleId() != null) {
			List<SCMLoginServiceDto> scmLoginServiceDto = scmLoginService
					.loadRoles(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(scmLoginServiceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

}

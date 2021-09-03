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

import com.pro.scm.controllerdto.VehicleSubStoreControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;

import com.pro.scm.mappers.VehicleSubStoreMapper;
import com.pro.scm.service.VehicleSubStoreService;

import com.pro.scm.servicedto.VehicleSubStoreServiceDTO;

import com.pro.scm.wrappers.VehicleSubStoreMappingWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/VehicleSubStoreMappingController")
@Slf4j
public class VehicleSubStoreMappingController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objVehicleSubStoreService")
	private VehicleSubStoreService objVehicleSubStoreService;
	@Autowired
	private HttpServletRequest request;

	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/VehicleSubStoreMappingController/loadVehicleSubStoreMapping
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadVehicleSubStoreMapping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadVehicleSubStoreMapping() throws InSufficientInputException, DataNotFoundException {
		VehicleSubStoreMappingWrapper objwrapper = new VehicleSubStoreMappingWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<VehicleSubStoreServiceDTO> sDto = objVehicleSubStoreService.loadVehicleSubStoreMapping(strRequestID);
		objwrapper.setObjVehicleSubStoreControllerDTO(
				new VehicleSubStoreMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/VehicleSubStoreMappingController/getStatusVehicleCount
	 * @Parameters :{"vehicleId":8}
	 */
	@RequestMapping(value = "/getStatusVehicleCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getStatusVehicleCount(@RequestBody VehicleSubStoreControllerDTO objVehicleSubStoreControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objVehicleSubStoreControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		VehicleSubStoreMapper objVehicleSubStoreMapper = new VehicleSubStoreMapper();
		VehicleSubStoreMappingWrapper objVehicleSubStoreMappingWrapper = new VehicleSubStoreMappingWrapper();
		if (objVehicleSubStoreControllerDTO.getVehicleId()!= null) {
			String rtnValueOfMT = objVehicleSubStoreService.getStatusVehicleCount(
					objVehicleSubStoreMapper.conversionControllerDtoToServiceDto(objVehicleSubStoreControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objVehicleSubStoreMappingWrapper.setResponseCode(HttpStatus.OK.value());
				objVehicleSubStoreMappingWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objVehicleSubStoreMappingWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objVehicleSubStoreMappingWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objVehicleSubStoreMappingWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objVehicleSubStoreMappingWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objVehicleSubStoreMappingWrapper.toString());
		return objVehicleSubStoreMappingWrapper;
	}

	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/VehicleSubStoreMappingController/saveVehicleSubStoreMapping
	 * @Parameters :{"subStoreId":12,"vehicleId":100011,"description":"str","userId":171,"moduleId":40,"roleId":40,"status":true}
	 */
	
	
//	getSubStoreId integer,
////  getVehicleId integer,
////  getDescription character varying,
////  userid integer,
////  moduleid integer,
////  roleid integer,
////  status boolean)
	
	@CrossOrigin
	@RequestMapping(value = "/saveVehicleSubStoreMapping", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveVehicleSubStoreMapping(@RequestBody VehicleSubStoreControllerDTO objVehicleSubStoreControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objVehicleSubStoreControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		VehicleSubStoreMapper objVehicleSubStoreMapper = new VehicleSubStoreMapper();
		VehicleSubStoreMappingWrapper objVehicleSubStoreMappingWrapper = new VehicleSubStoreMappingWrapper();
		if (objVehicleSubStoreControllerDTO.getVehicleId()!= null && objVehicleSubStoreControllerDTO.getSubStoreId()!= null
			&& objVehicleSubStoreControllerDTO.getDescription()!= null && objVehicleSubStoreControllerDTO.getUserId()!= null
			&& objVehicleSubStoreControllerDTO.getModuleId()!= null && objVehicleSubStoreControllerDTO.getRoleId()!= null 
			&& objVehicleSubStoreControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objVehicleSubStoreService.saveVehicleSubStoreMapping(
					objVehicleSubStoreMapper.conversionControllerDtoToServiceDto(objVehicleSubStoreControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objVehicleSubStoreMappingWrapper.setResponseCode(HttpStatus.OK.value());
				objVehicleSubStoreMappingWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objVehicleSubStoreMappingWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objVehicleSubStoreMappingWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objVehicleSubStoreMappingWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objVehicleSubStoreMappingWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objVehicleSubStoreMappingWrapper.toString());
		return objVehicleSubStoreMappingWrapper;
	}

	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/VehicleSubStoreMappingController/updateVehicleSubStoreMapping
	 * @Parameters :{"subStoreId":100011,"description":str,"userId":"171","moduleId":40,"roleId":100,"status":true,"serialId":11}
	 */
	@RequestMapping(value = "/updateVehicleSubStoreMapping", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateVehicleSubStoreMapping(@RequestBody VehicleSubStoreControllerDTO objVehicleSubStoreControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objVehicleSubStoreControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		VehicleSubStoreMapper objVehicleSubStoreMapper = new VehicleSubStoreMapper();
		VehicleSubStoreMappingWrapper objVehicleSubStoreMappingWrapper = new VehicleSubStoreMappingWrapper();
		if (objVehicleSubStoreControllerDTO.getSubStoreId()!= null && objVehicleSubStoreControllerDTO.getDescription()!= null
			&& objVehicleSubStoreControllerDTO.getUserId()!= null && objVehicleSubStoreControllerDTO.getModuleId()!= null
			&& objVehicleSubStoreControllerDTO.getRoleId()!= null && objVehicleSubStoreControllerDTO.getStatus()!= null 
			&& objVehicleSubStoreControllerDTO.getSerialId()!= null) {
			String rtnValueOfMT = objVehicleSubStoreService.updateVehicleSubStoreMapping(
					objVehicleSubStoreMapper.conversionControllerDtoToServiceDto(objVehicleSubStoreControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objVehicleSubStoreMappingWrapper.setResponseCode(HttpStatus.OK.value());
				objVehicleSubStoreMappingWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objVehicleSubStoreMappingWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objVehicleSubStoreMappingWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objVehicleSubStoreMappingWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objVehicleSubStoreMappingWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objVehicleSubStoreMappingWrapper.toString());
		return objVehicleSubStoreMappingWrapper;
	}
}

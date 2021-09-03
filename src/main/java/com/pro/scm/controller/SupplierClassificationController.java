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
import com.pro.scm.controllerdto.SupplierClassificationControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.SupplierClassificationMapper;
import com.pro.scm.service.SupplierClassificationService;
import com.pro.scm.servicedto.SupplierClassificationServiceDTO;
import com.pro.scm.wrappers.SupplierClassificationWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/SupplierClassificationController")
@Slf4j
public class SupplierClassificationController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objSupplierClassificationService")
	private SupplierClassificationService objSupplierClassificationService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierClassificationController/saveorupdateSupplierClass
	 * @Parameters :{"classification_id":1,"classification_name":"vendorClassification",
	  "classification_description":"vendorClassificationDescription","userId":171,"roleId":100,"moduleId":40,"status":true,"operation_type":1 } 
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveorupdateSupplierClass", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveorupdateSupplierClass(@RequestBody SupplierClassificationControllerDTO objControllerDTO,String operation_type)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		SupplierClassificationMapper objSupplierClassificationMapper = new SupplierClassificationMapper();
		SupplierClassificationWrapper objSupplierClassificationWrapper = new SupplierClassificationWrapper();
		operation_type = objControllerDTO.getOperation_type();
		if (objControllerDTO.getClassification_id()!= null && objControllerDTO.getClassification_name()!= null &&
			objControllerDTO.getClassification_description()!= null && objControllerDTO.getUserId()!= null &&
			objControllerDTO.getRoleId()!= null &&objControllerDTO.getModuleId()!= null &&
			objControllerDTO.getStatus()!= null && objControllerDTO.getOperation_type()!= null ) {
			String rtnValueOfMT = objSupplierClassificationService.saveorupdateSupplierClass(
					objSupplierClassificationMapper.conversionControllerDtoToServiceDto(objControllerDTO), strRequestID,operation_type);
			if (rtnValueOfMT != null) {
				objSupplierClassificationWrapper.setResponseCode(HttpStatus.OK.value());
				objSupplierClassificationWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objSupplierClassificationWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objSupplierClassificationWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objSupplierClassificationWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objSupplierClassificationWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objSupplierClassificationWrapper.toString());
		return objSupplierClassificationWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierClassificationController/loadSupplierClassification
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadSupplierClassification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSupplierClassification() throws InSufficientInputException, DataNotFoundException {
		SupplierClassificationWrapper objwrapper = new SupplierClassificationWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<SupplierClassificationServiceDTO> sDto = objSupplierClassificationService.loadSupplierClassification(strRequestID);
		objwrapper.setObjSupplierClassificationControllerDTO(
				new SupplierClassificationMapper().conversionForServiceTOControllerDTO(sDto));
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
	 * @URL :localhost:2000/scmservice/SupplierClassificationController/loadSupplierClassificationBasedId
	 * @Parameters :No
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/loadSupplierClassificationBasedId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes  = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSupplierClassificationBasedId(@RequestBody SupplierClassificationControllerDTO  controllerDto) throws InSufficientInputException, DataNotFoundException {
		SupplierClassificationWrapper objwrapper = new SupplierClassificationWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@::"+controllerDto.getClassification_id());
		if(controllerDto.getClassification_id()!=null) {
			List<SupplierClassificationServiceDTO> sDto = objSupplierClassificationService.loadSupplierClassificationBasedId(controllerDto.getClassification_id(),strRequestID);
			objwrapper.setObjSupplierClassificationControllerDTO(
					new SupplierClassificationMapper().conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(HttpStatus.OK.value());
			objwrapper.setStatus(HttpStatus.OK.getReasonPhrase());
		}
		else {
			objwrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objwrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
}

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

import com.pro.scm.controllerdto.DrugsDetailsBasedOnDrugIdControllerDto;
import com.pro.scm.controllerdto.ItemAprovalControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SupplierClassificationControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.DrugsDetailsBasedOnDrugIdMapper;
import com.pro.scm.mappers.ItemApprovalMapper;
import com.pro.scm.mappers.SupplierClassificationMapper;
import com.pro.scm.service.ItemApprovalService;
import com.pro.scm.service.SupplierClassificationService;
import com.pro.scm.servicedto.DrugsDetailsBasedOnDrugIdServiceDto;
import com.pro.scm.servicedto.ItemApprovalServiceDto;
import com.pro.scm.servicedto.SupplierClassificationServiceDTO;
import com.pro.scm.wrappers.DrugsDetailsBasedOnDrugIdWrapper;
import com.pro.scm.wrappers.ItemApprovalWrapper;
import com.pro.scm.wrappers.SupplierClassificationWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/itemApproval")
@Slf4j
public class ItemApprovalController {
	
	
	
	
	@Autowired
	@Qualifier("itemApprovalService")
	private ItemApprovalService itemApprovalService;
	
	@Autowired
	@Qualifier("objSupplierClassificationService")
	private SupplierClassificationService objSupplierClassificationService;
	
	@Autowired
	private HttpServletRequest request;
	
	
	
	/**
	 * @author : Ranjeet kr.
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 04-04-2020
	 * @Des : loadVehicleItems
	 * @json:{ "vehicleId":17}  
	 * @URL :
	 *      http://localhost:2001/scmservice/itemApproval/getListOfActiveDrugs
	 */
	@CrossOrigin
	@RequestMapping(value = "/getListOfActiveDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getActiveDrugs(@RequestBody ItemAprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadGenricGroup method is executed inside ambToAmbController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ItemApprovalMapper mapper = new ItemApprovalMapper();
		ItemApprovalWrapper wrapper = new ItemApprovalWrapper();
		if (objControllerDto.getActiveId() != null) {
			List<ItemApprovalServiceDto> objAddNewLocalDrugServiceDTO = itemApprovalService
					.getActiveDrugs(mapper.conversionControllerToServiceDto(objControllerDto), strRequestID);
			wrapper.setItemAprovalControllerDto(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	
	

	/**
	 * @author : Ranjeet kr.
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 04-04-2020
	 * @Des : loadVehicleItems
	 * @json:{ "vehicleId":17}  
	 * @URL :
	 *      http://localhost:2001/scmservice/itemApproval/getListOfDrugsDetailsBasedOnDrugId
	 */
	@CrossOrigin
	@RequestMapping(value = "/getListOfDrugsDetailsBasedOnDrugId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getDrugsDetailsBasedOnDrugId(@RequestBody DrugsDetailsBasedOnDrugIdControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadGenricGroup method is executed inside ambToAmbController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		DrugsDetailsBasedOnDrugIdMapper mapper = new DrugsDetailsBasedOnDrugIdMapper();
		DrugsDetailsBasedOnDrugIdWrapper wrapper = new DrugsDetailsBasedOnDrugIdWrapper();
		if (objControllerDto.getStrdrugId() != null) {
			List<DrugsDetailsBasedOnDrugIdServiceDto> objAddNewLocalDrugServiceDTO = itemApprovalService.getDrugsDetailsBasedOnDrugId
					(mapper.conversionControllerToServiceDto(objControllerDto), strRequestID);
			wrapper.setDrugsDetailsBasedOnDrugIdControllerDto(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	
	
	/**
	 * @author : Ranjeet kr.
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 04-04-2020
	 * @Des : loadVehicleItems
	 * @json:{ "vehicleId":17}  
	 * @URL :
	 *      http://localhost:2001/scmservice/itemApproval/loadSupplierClassificationBasedId
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadSupplierClassificationBasedId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getActiveDrugss(@RequestBody SupplierClassificationControllerDTO  controllerDto)
			throws InSufficientInputException, DataNotFoundException {
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
	
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :http://localhost:2001/scmservice/itemApproval/saveorupdateSupplierClass
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
	
}

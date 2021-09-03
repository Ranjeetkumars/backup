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

import com.pro.scm.controllerdto.ExpiryDrugsControllerDto;
import com.pro.scm.controllerdto.GetAllActiveInactiveControllerDto;
import com.pro.scm.controllerdto.GetDrugDetailsForApprovalControllerDto;
import com.pro.scm.controllerdto.GetMedicinesControllerDto;
import com.pro.scm.controllerdto.GetMedicinesCountControllerDto;
import com.pro.scm.controllerdto.ListLoadActiveDrugsControllerDto;
import com.pro.scm.controllerdto.ListLoadActiveDrugsCountControllerDto;
import com.pro.scm.controllerdto.ListLoadActiveInactiveCOntrollerDto;
import com.pro.scm.controllerdto.LoadActiveDrugsControllerDto;
import com.pro.scm.controllerdto.LoadLocalIndentDetailsControllerDto;
import com.pro.scm.controllerdto.LoadReturnDrugsControllerDto;
import com.pro.scm.controllerdto.LoadVehiclesSubstoreControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SaveInActiveDrugsControllerDto;
import com.pro.scm.controllerdto.Save_vehicle_indent_detailsControllerDto;
import com.pro.scm.controllerdto.Store_item_detailsControllerDto;
import com.pro.scm.controllerdto.UpdateActiveDrugForApprovalControllerDto;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.ExpiryDrugsMapper;
import com.pro.scm.mappers.GetAllActiveInactiveMapper;
import com.pro.scm.mappers.GetDrugDetailsForApprovalMapper;
import com.pro.scm.mappers.GetMedicinesCountMapper;
import com.pro.scm.mappers.GetMedicinesMapper;
import com.pro.scm.mappers.ListLoadActiveDrugsCountMapper;
import com.pro.scm.mappers.ListLoadActiveDrugsMapper;
import com.pro.scm.mappers.ListLoadActiveInactiveMapper;
import com.pro.scm.mappers.LoadActiveDrugsMapper;
import com.pro.scm.mappers.LoadDrugTypeMapper;
import com.pro.scm.mappers.LoadLocalIndentDetailsMapper;
import com.pro.scm.mappers.LoadVehiclesSubstoreMapper;
import com.pro.scm.mappers.SaveInActiveDrugsMapper;
import com.pro.scm.mappers.Save_vehicle_indent_detailsMapper;
import com.pro.scm.mappers.Store_item_detailsMapper;
import com.pro.scm.mappers.UpdateActiveDrugForApprovalMapper;
import com.pro.scm.service.SalesIndentRaisedService;
import com.pro.scm.servicedto.GetDrugDetailsForApprovalServiceDto;
import com.pro.scm.servicedto.GetMedicinesServiceDto;
import com.pro.scm.servicedto.ListLoadActiveDrugsServiceDto;
import com.pro.scm.servicedto.ListLoadActiveInactiveServiceDto;
import com.pro.scm.servicedto.LoadActiveDrugsServiceDto;
import com.pro.scm.servicedto.LoadDrugTypeServiceDto;
import com.pro.scm.servicedto.LoadLocalIndentServiceDto;
import com.pro.scm.servicedto.LoadVehiclesSubstoreServiceDto;
import com.pro.scm.servicedto.Store_item_detailsServiceDto;
import com.pro.scm.wrappers.ExpiryDrugsWrapper;
import com.pro.scm.wrappers.GetDrugDetailsForApprovalWrapper;
import com.pro.scm.wrappers.GetMedicinesWrapper;
import com.pro.scm.wrappers.ListLoadActiveDrugsWrapper;
import com.pro.scm.wrappers.ListLoadActiveInactiveWrapper;
import com.pro.scm.wrappers.LoadActiveDrugsWrapper;
import com.pro.scm.wrappers.LoadDrugTypeWrapper;
import com.pro.scm.wrappers.LoadLocalIndentDetailsWrapper;
import com.pro.scm.wrappers.LoadVehiclesSubstoreWrapper;
import com.pro.scm.wrappers.Store_item_detailsWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/salesIndentRaisedController")
@Slf4j
public class SalesIndentRaisedController {

	@Autowired
	@Qualifier("salesIndentRaisedService")
	SalesIndentRaisedService salesIndentRaisedService;
	InSufficientInputException obj;
	@Autowired
	private HttpServletRequest request; 
	
	/**
	 * @author : Deepak
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : load_vehicles_substore
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedControllerload_vehicles_substore
	 */
	@CrossOrigin
	@RequestMapping(value = "/load_vehicles_substore", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response load_vehicles_substore(@RequestBody LoadVehiclesSubstoreControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("load_vehicles_substore method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadVehiclesSubstoreMapper mapper = new LoadVehiclesSubstoreMapper();
		LoadVehiclesSubstoreWrapper wrapper = new LoadVehiclesSubstoreWrapper();
		if (objControllerDto.getBaseLocationId() != null) {
			List<LoadVehiclesSubstoreServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.load_vehicles_substore(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
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
	 * @Des : loadLocalIndentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/api/version_1/loadLocalIndentDetails
	 */
	@RequestMapping(value = "/api/version_1/loadLocalIndentDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadLocalIndentDetails(@RequestBody LoadLocalIndentDetailsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadLocalIndentDetails method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadLocalIndentDetailsMapper mapper = new LoadLocalIndentDetailsMapper();
		LoadLocalIndentDetailsWrapper wrapper = new LoadLocalIndentDetailsWrapper();
		if (objControllerDto.getText() != null) {
			List<LoadLocalIndentServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.loadLocalIndentDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
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
	 * @Des : store_item_details
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/store_item_details
	 */
	@CrossOrigin
	@RequestMapping(value = "/store_item_details", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response store_item_details(@RequestBody Store_item_detailsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("store_item_details method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		Store_item_detailsMapper mapper = new Store_item_detailsMapper();
		Store_item_detailsWrapper wrapper = new Store_item_detailsWrapper();
		if (objControllerDto.getStoreTypeId() != null) {
			List<Store_item_detailsServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.store_item_details(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
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
	 * @Des : save_vehicle_indent_details
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/save_vehicle_indent_details
	 */
	@CrossOrigin
	@RequestMapping(value = "/save_vehicle_indent_details", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response save_vehicle_indent_details(@RequestBody Save_vehicle_indent_detailsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {

		log.info("save_vehicle_indent_details method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		Save_vehicle_indent_detailsMapper mapper = new Save_vehicle_indent_detailsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();

		System.out.println(objControllerDto.getCount() );
		System.out.println(objControllerDto.getDrugIds());
		System.out.println(objControllerDto.getEmpcode());
		System.out.println(objControllerDto.getIndentQty());
		System.out.println(objControllerDto.getIndentStrips());
		System.out.println(objControllerDto.getModuleId());
		System.out.println(objControllerDto.getRoleId());
		System.out.println(objControllerDto.getUserId());
		System.out.println(objControllerDto.getVehicleId());
		
		
		if (objControllerDto.getCount() != null && objControllerDto.getDrugIds() != null
				&& objControllerDto.getEmpcode() != null && objControllerDto.getIndentQty() != null
				&& objControllerDto.getIndentStrips() != null && objControllerDto.getModuleId() != null
				&& objControllerDto.getRoleId() != null && objControllerDto.getUserId() != null
				&& objControllerDto.getVehicleId() != null) {
			String rtnValueOfMT = salesIndentRaisedService.save_vehicle_indent_details(
					mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Des : store_item_details
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/listLoadActiveInactive
	 */
	@CrossOrigin
	@RequestMapping(value = "/listLoadActiveInactive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response listLoadActiveInactive(@RequestBody ListLoadActiveInactiveCOntrollerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("store_item_details method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ListLoadActiveInactiveMapper mapper = new ListLoadActiveInactiveMapper();
		ListLoadActiveInactiveWrapper wrapper = new ListLoadActiveInactiveWrapper();
		if (objControllerDto.getDrugstatus() != null) {
			List<ListLoadActiveInactiveServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.listLoadActiveInactive(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
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
	 * @Des : save_vehicle_indent_details
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/api/version_1/updateActiveDrugForApproval
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateActiveDrugForApproval", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateActiveDrugForApproval(@RequestBody UpdateActiveDrugForApprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("save_vehicle_indent_details method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		UpdateActiveDrugForApprovalMapper mapper = new UpdateActiveDrugForApprovalMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getSize() != null && objControllerDto.getDrugIds() != null
				&& objControllerDto.getUserId() != null && objControllerDto.getDrugTypeId() != null) {
			String rtnValueOfMT = salesIndentRaisedService.updateActiveDrugForApproval(
					mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Des : getDrugDetailsForApproval
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/getDrugDetailsForApproval
	 */
	@CrossOrigin
	@RequestMapping(value = "/getDrugDetailsForApproval", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getDrugDetailsForApproval(@RequestBody GetDrugDetailsForApprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {

		log.info("getDrugDetailsForApproval method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GetDrugDetailsForApprovalMapper mapper = new GetDrugDetailsForApprovalMapper();
		GetDrugDetailsForApprovalWrapper wrapper = new GetDrugDetailsForApprovalWrapper();
		if (objControllerDto.getDrugId() != null) {
			List<GetDrugDetailsForApprovalServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.getDrugDetailsForApproval(mapper.conversionControllerDtoToServiceDto(objControllerDto),
							strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
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
	 * @Des : loadDrugType
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/api/version_1/loadDrugType
	 */
	@RequestMapping(value = "/api/version_1/loadDrugType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadDrugType() throws InSufficientInputException, DataNotFoundException {
		log.info("getDrugDetailsForApproval method is executed inside ExpiryDrugsController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadDrugTypeWrapper wrapper = new LoadDrugTypeWrapper();
		List<LoadDrugTypeServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService.loadDrugType(strRequestID);
		wrapper.setObjControllerDto(
				new LoadDrugTypeMapper().conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	//

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : loadActiveDrugs
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/loadActiveDrugs
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadActiveDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadActiveDrugs(@RequestBody LoadActiveDrugsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadActiveDrugs method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadActiveDrugsMapper mapper = new LoadActiveDrugsMapper();
		LoadActiveDrugsWrapper wrapper = new LoadActiveDrugsWrapper();
		if (objControllerDto.getActiveDrug() != null) {
			List<LoadActiveDrugsServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.loadActiveDrugs(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
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
	 * @Des : listLoadActiveDrugs
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/api/version_1/listLoadActiveDrugs
	 */
	@RequestMapping(value = "/api/version_1/listLoadActiveDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response listLoadActiveDrugs(@RequestBody ListLoadActiveDrugsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadActiveDrugs method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ListLoadActiveDrugsMapper mapper = new ListLoadActiveDrugsMapper();
		ListLoadActiveDrugsWrapper wrapper = new ListLoadActiveDrugsWrapper();
		if (objControllerDto.getPageLimit() != null && objControllerDto.getOffset() != null
				&& objControllerDto.getDrugStatusId() != null) {
			List<ListLoadActiveDrugsServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.listLoadActiveDrugs(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
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
	 * @Des : save_vehicle_indent_details
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/getAllActiveInactive
	 */
	@CrossOrigin
	@RequestMapping(value = "/getAllActiveInactive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllActiveInactive(@RequestBody GetAllActiveInactiveControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getAllActiveInactive method is executed " + objControllerDto);
		
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GetAllActiveInactiveMapper mapper = new GetAllActiveInactiveMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getActiveOrInactive() != null && objControllerDto.getBrand() != null
				&& objControllerDto.getForm() != null && objControllerDto.getGenericGroupId() != null
				&& objControllerDto.getGenericMoleculeId() != null && objControllerDto.getGenericName() != null
				&& objControllerDto.getMfg() != null && objControllerDto.getSystemId() != null
				&& objControllerDto.getUnicode() != null) {
			String rtnValueOfMT = salesIndentRaisedService
					.getAllActiveInactive(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Des : saveInActiveDrugs
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/saveInActiveDrugs
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveInActiveDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveInActiveDrugs(@RequestBody SaveInActiveDrugsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("saveInActiveDrugs method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		SaveInActiveDrugsMapper mapper = new SaveInActiveDrugsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getActiveDrugs() != null && objControllerDto.getListSize() != null
				&& objControllerDto.getRemarks() != null && objControllerDto.getStatudId() != null) {
			String rtnValueOfMT = salesIndentRaisedService
					.saveInActiveDrugs(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Des : listLoadActiveDrugsCount
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/api/version_1/listLoadActiveDrugsCount
	 */
	@RequestMapping(value = "/api/version_1/listLoadActiveDrugsCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response listLoadActiveDrugsCount(@RequestBody ListLoadActiveDrugsCountControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("listLoadActiveDrugsCount method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ListLoadActiveDrugsCountMapper mapper = new ListLoadActiveDrugsCountMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getDrugStatusId() != null) {
			String rtnValueOfMT = salesIndentRaisedService.listLoadActiveDrugsCount(
					mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Des : listLoadActiveDrugsCount
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/api/version_1/getMedicinesCount
	 */
	@RequestMapping(value = "/api/version_1/getMedicinesCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMedicinesCount(@RequestBody GetMedicinesCountControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {

		log.info("getMedicinesCount method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GetMedicinesCountMapper mapper = new GetMedicinesCountMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getBrand() != null && objControllerDto.getForm() != null
				&& objControllerDto.getGenericGroupId() != null && objControllerDto.getGenericMoleculeId() != null
				&& objControllerDto.getGenericName() != null && objControllerDto.getMfg() != null
				&& objControllerDto.getSystemId() != null && objControllerDto.getUnicode() != null) {
			String rtnValueOfMT = salesIndentRaisedService
					.getMedicinesCount(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Des : getMedicines
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/api/version_1/getMedicines
	 */
	@CrossOrigin
	@RequestMapping(value = "/getMedicines", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMedicines(@RequestBody GetMedicinesControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getMedicines method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GetMedicinesMapper mapper = new GetMedicinesMapper();
		GetMedicinesWrapper wrapper = new GetMedicinesWrapper();
		if (objControllerDto.getGenericName() != null && objControllerDto.getOffsetValue() != null
				&& objControllerDto.getBrand() != null && objControllerDto.getForm() != null
				&& objControllerDto.getMfg() != null && objControllerDto.getUnicode() != null
				&& objControllerDto.getSystemId() != null && objControllerDto.getGenericGroupId() != null
				&& objControllerDto.getGenericMoleculeId() != null && objControllerDto.getPageLimitValue() != null) {
			List<GetMedicinesServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.getMedicines(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
//()
	@CrossOrigin
	@RequestMapping(value = "/getMedicinesDetailsBasedOnSerialId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMedicinesDetailsBasedOnSerialId(@RequestBody GetMedicinesControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getMedicines method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GetMedicinesMapper mapper = new GetMedicinesMapper();
		GetMedicinesWrapper wrapper = new GetMedicinesWrapper();
		if (objControllerDto.getSerialId() != null) {
			List<GetMedicinesServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.getMedicinesDetailsBasedOnSerialId(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	
	
	
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 15/05/2020
	 * @Des : getMedicines
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/processNewInventory
	 */
	@CrossOrigin
	@RequestMapping(value = "/processNewInventory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMedicinesForProcessNewInventory(@RequestBody GetMedicinesControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getMedicines method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GetMedicinesMapper mapper = new GetMedicinesMapper();
		GetMedicinesWrapper wrapper = new GetMedicinesWrapper();
		if (objControllerDto.getGenericName() != null 
				&& objControllerDto.getBrand() != null && objControllerDto.getForm() != null
				&& objControllerDto.getMfg() != null 
				
				
//				&& objControllerDto.getUnicode() != null
//				&& objControllerDto.getSystemId() != null && objControllerDto.getGenericGroupId() != null
//				&& objControllerDto.getGenericMoleculeId() != null && objControllerDto.getActiveAndInactive() != null
				) {
			List<GetMedicinesServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.getMedicinesForProcessNewInventory(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 15/05/2020
	 * @Des : getMedicines
	 * @URL :
	 *      http://localhost:2000/scmservice/salesIndentRaisedController/processNewInventoryByIds
	 */
	@CrossOrigin
	@RequestMapping(value = "/processNewInventoryByIds", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMedicinesForProcessNewInventoryBasedOnIds(@RequestBody GetMedicinesControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getMedicines method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GetMedicinesMapper mapper = new GetMedicinesMapper();
		GetMedicinesWrapper wrapper = new GetMedicinesWrapper();
		if (objControllerDto.getSerialId() != null ) {
			List<GetMedicinesServiceDto> vehiclesSubstoreServiceDtos = salesIndentRaisedService
					.getMedicinesForProcessNewInventoryBasedOnIds(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(vehiclesSubstoreServiceDtos));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
}

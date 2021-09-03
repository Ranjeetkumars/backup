package com.pro.scm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.scm.controllerdto.AddNewLocalDrugControllerDTO;
import com.pro.scm.controllerdto.LoadVehiclesControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AddNewLocalDrugMapper;
import com.pro.scm.mappers.LoadVehiclesMapper;
import com.pro.scm.mappers.LoadZonesMapper;
import com.pro.scm.mappers.SMCLoginMapper;
import com.pro.scm.service.AddNewLocalDrugService;
import com.pro.scm.service.ExpiryDrugsService;
import com.pro.scm.servicedto.AddNewLocalDrugServiceDTO;
import com.pro.scm.servicedto.LoadVehiclesServiceDto;
import com.pro.scm.servicedto.LoadZonesServiceDto;
import com.pro.scm.wrappers.AddNewLocalDrugWrapper;
import com.pro.scm.wrappers.LoadVehiclesWrapper;
import com.pro.scm.wrappers.LoadZonesWrapper;
import com.pro.scm.wrappers.SCMLoginWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Bhuneshwar
 *
 */

@RestController
@RequestMapping("/addNewDrugController")
@Slf4j
public class AddNewLocalDrugController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("addNewLocalDrugService")
	private AddNewLocalDrugService addNewLocalDrugService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : getLoadLocaldrugs
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/api/version_1/getLoadLocaldrugs
	 * 
	 */
	@RequestMapping(value = "/getLoadLocaldrugs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getLoadLocaldrugs() throws InSufficientInputException, DataNotFoundException {
		log.info("getLoadLocaldrugs method is executed inside addNewDrugController");
		String strRequestID = request.getAttribute("reqid").toString();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService.getLoadLocaldrugs(strRequestID);
		wrapper.setObjAddNewLocalDrugControllerDTO(
				new AddNewLocalDrugMapper().conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : getAllMedicinesCount
	 * @json:{ "genric_drug_name":"dffd", "brand_id":1, "from_id":1,
	 *         "manufacture_id":1, "unicode":1, "active_inactive":1, "system_id":1,
	 *         "genric_group_id":1, "generic_molecules_id":1
	 * 
	 *         }
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/api/version_1/getAllMedicinesCount
	 * 
	 */
	@RequestMapping(value = "/getAllMedicinesCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllMedicinesCount(@RequestBody AddNewLocalDrugControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getAllMedicinesCount method is executed inside addNewDrugController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		if (objControllerDto.getSystem_id() != null&&objControllerDto.getGenric_drug_name()!=null&&objControllerDto.getBrand_id()!=null
				&&objControllerDto.getFrom_id()!=null&&objControllerDto.getManufacture_id()!=null&&objControllerDto.getUnicode()!=null
				&&objControllerDto.getActive_inactive()!=null&&objControllerDto.getGenric_group_id()!=null&&objControllerDto.getGeneric_molecules_id()!=null) {
			List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService
					.getAllMedicinesCount(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAddNewLocalDrugControllerDTO(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
						
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : loadGenricGroup
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/api/version_1/loadGenricGroup
	 * 
	 */
	@RequestMapping(value = "/loadGenricGroup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadGenricGroup(@RequestBody AddNewLocalDrugControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadGenricGroup method is executed inside addNewDrugController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		if (objControllerDto.getSystemId() != null) {
			List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService
					.loadGenricGroup(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAddNewLocalDrugControllerDTO(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	
	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : loadGenricMolecules
	 * @json:{ "genericGroupId":1}
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/api/version_1/loadGenricMolecules
	 * 
	 */
	@RequestMapping(value = "/loadGenricMolecules", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadGenricMolecules(@RequestBody AddNewLocalDrugControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadGenricMolecules method is executed inside addNewDrugController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		if (objControllerDto.getGenericGroupId() != null) {
			List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService
					.loadGenricMolecules(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAddNewLocalDrugControllerDTO(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : loadManufacturer
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/api/version_1/loadManufacturer
	 * 
	 */
	@RequestMapping(value = "/loadManufacturer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadManufacturer() throws InSufficientInputException, DataNotFoundException {
		log.info("loadManufacturer method is executed inside addNewDrugController");
		String strRequestID = request.getAttribute("reqid").toString();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService.loadManufacturer(strRequestID);
		wrapper.setObjAddNewLocalDrugControllerDTO(
				new AddNewLocalDrugMapper().conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @Des : loadForm
	 * @URL :
	 *      http://localhost:2000/scmservice/addNewDrugController/loadForm
	 * 
	 */
	@RequestMapping(value = "/loadForm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadForm() throws InSufficientInputException, DataNotFoundException {
		log.info("loadForm method is executed inside addNewDrugController");
		String strRequestID = request.getAttribute("reqid").toString();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService.loadForm(strRequestID);
		wrapper.setObjAddNewLocalDrugControllerDTO(
				new AddNewLocalDrugMapper().conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @Des : loadBrand
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/api/version_1/loadBrand
	 * 
	 */
	@RequestMapping(value = "/loadBrand", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadBrand() throws InSufficientInputException, DataNotFoundException {
		log.info("loadBrand method is executed inside addNewDrugController");
		String strRequestID = request.getAttribute("reqid").toString();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService.loadBrand(strRequestID);
		wrapper.setObjAddNewLocalDrugControllerDTO(
				new AddNewLocalDrugMapper().conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @Des : loadBrand
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/api/version_1/loadSystem
	 * 
	 */
	@RequestMapping(value = "/api/version_1/loadSystem", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSystem() throws InSufficientInputException, DataNotFoundException {
		log.info("loadSystem method is executed inside addNewDrugController");
		String strRequestID = request.getAttribute("reqid").toString();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService.loadSystem(strRequestID);
		wrapper.setObjAddNewLocalDrugControllerDTO(
				new AddNewLocalDrugMapper().conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	

	     /**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : getVehicleAlsBls
	 * @json:{ "vehicleId":10 }
	 * 
	 * @URL :
	 *      http://localhost:2000/scmservice/addNewDrugController/getVehicleAlsBls
	 * 
	 */
	@RequestMapping(value = "/getVehicleAlsBls", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getVehicleAlsBls(@RequestBody AddNewLocalDrugControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getVehicleAlsBls method is executed inside addNewDrugController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		if (objControllerDto.getVehicleId() != null) {
			List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService
					.getVehicleAlsBls(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAddNewLocalDrugControllerDTO(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			
			
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	   /**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : getVehicleDrugStatus
	 * @json:{ "vehicleId":10,"drugid":"4" }
	 * 
	 * @URL :
	 *      http://localhost:2001/scmservice/addNewDrugController/getVehicleDrugStatus
	 * 
	 */
	@RequestMapping(value = "/getVehicleDrugStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getVehicleDrugStatus(@RequestBody AddNewLocalDrugControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getVehicleDrugStatus method is executed inside addNewDrugController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
		AddNewLocalDrugWrapper wrapper = new AddNewLocalDrugWrapper();
		if (objControllerDto.getVehicleId() != null && objControllerDto.getDrugid()!= null) {
			
			List<AddNewLocalDrugServiceDTO> objAddNewLocalDrugServiceDTO = addNewLocalDrugService
					.getVehicleDrugStatus(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAddNewLocalDrugControllerDTO(mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			
			
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	
}
package com.pro.scm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pro.scm.controllerdto.DrugVehicleTypeMappingControllerDTO;
import com.pro.scm.controllerdto.MapDrugToVehicleControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.VehicleTypeDrugsControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.DrugVehicleTypeMappingMapper;
import com.pro.scm.mappers.MapDrugToVehicleMapper;
import com.pro.scm.mappers.VehicleTypeDrugMapper;
import com.pro.scm.service.DrugVehicleService;
import com.pro.scm.servicedto.DrugVehicleTypeMappingServiceDTO;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;
import com.pro.scm.wrappers.DrugVehicleTypeMappingWrapper;
import com.pro.scm.wrappers.GenericNameWrapper;
import com.pro.scm.wrappers.VehicleWiseDrugWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/DrugVehicleTypeMappingController")
@Slf4j

public class DrugVehicleTypeMappingController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objDrugVehicleService")
	private DrugVehicleService objDrugVehicleService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/DrugVehicleTypeMappingController/loadDrugNames
	 * @Parameters :{ "supplierId":1 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadDrugNames", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadDrugNames(
			@RequestBody DrugVehicleTypeMappingControllerDTO objDrugVehicleTypeMappingControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objDrugVehicleTypeMappingControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		DrugVehicleTypeMappingWrapper objwrapper = new DrugVehicleTypeMappingWrapper();
		if (objDrugVehicleTypeMappingControllerDTO.getSupplierId() != null) {

			DrugVehicleTypeMappingMapper mapper = new DrugVehicleTypeMappingMapper();
			List<DrugVehicleTypeMappingServiceDTO> sDto = objDrugVehicleService.loadDrugNames(
					mapper.conversionControllerDtoToServiceDto(objDrugVehicleTypeMappingControllerDTO), strRequestID);
			objwrapper.setObjDrugVehicleTypeMappingControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/DrugVehicleTypeMappingController/saveMapDrugToVehicle
	 * @Parameters :{"vehicleId":"Consumables","records":CO-149,"groupId":40,"drugId":100,"operationType":171,"userId":true,"roleId":100,"moduleId":40}
	 */
	@RequestMapping(value = "/saveMapDrugToVehicle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveMapDrugToVehicle(@RequestBody MapDrugToVehicleControllerDTO objMapDrugToVehicleControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objMapDrugToVehicleControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MapDrugToVehicleMapper objMapDrugToVehicleMapper = new MapDrugToVehicleMapper();
		GenericNameWrapper objGenericNameWrapper = new GenericNameWrapper();
		if (objMapDrugToVehicleControllerDTO.getVehicleId() != null
				&& objMapDrugToVehicleControllerDTO.getRecords() != null
				&& objMapDrugToVehicleControllerDTO.getGroupId() != null
				&& objMapDrugToVehicleControllerDTO.getDrugId() != null
				&& objMapDrugToVehicleControllerDTO.getOperationType() != null
				&& objMapDrugToVehicleControllerDTO.getUserId() != null
				&& objMapDrugToVehicleControllerDTO.getRoleId() != null
				&& objMapDrugToVehicleControllerDTO.getModuleId() != null) {
			String rtnValueOfMT = objDrugVehicleService.saveMapDrugToVehicle(
					objMapDrugToVehicleMapper.conversionControllerDtoToServiceDto(objMapDrugToVehicleControllerDTO),
					strRequestID);
			if (rtnValueOfMT != null) {
				objGenericNameWrapper.setResponseCode(HttpStatus.OK.value());
				objGenericNameWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objGenericNameWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objGenericNameWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objGenericNameWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objGenericNameWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objGenericNameWrapper.toString());
		return objGenericNameWrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/DrugVehicleTypeMappingController/loadVehicleTypeWiseDrugDetails
	 * @Parameters :{"vehicleType":1, "mappedType":1 }
	 */
	@RequestMapping(value = "/loadVehicleTypeWiseDrugDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadVehicleTypeWiseDrugDetails(
			@RequestBody VehicleTypeDrugsControllerDTO objVehicleTypeDrugsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		
		log.info("::::Inputs::Are::::" + objVehicleTypeDrugsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		VehicleWiseDrugWrapper objVehicleWiseDrugWrapper = new VehicleWiseDrugWrapper();
		if (objVehicleTypeDrugsControllerDTO.getVehicleType() != null
				&& objVehicleTypeDrugsControllerDTO.getMappedType() != null) {

			VehicleTypeDrugMapper mapper = new VehicleTypeDrugMapper();
			List<VehicleTypeDrugsServiceDTO> sDto = objDrugVehicleService.loadVehicleTypeWiseDrugDetails(
					mapper.conversionControllerDtoToServiceDto(objVehicleTypeDrugsControllerDTO), strRequestID);
			objVehicleWiseDrugWrapper
					.setObjVehicleTypeDrugsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objVehicleWiseDrugWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objVehicleWiseDrugWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objVehicleWiseDrugWrapper.toString());
		return objVehicleWiseDrugWrapper;
		
	}
	
	
	
	@CrossOrigin
	@GetMapping("loadVehicleTypeWiseDrugDetails_Rak/{vehicleTypeId}/{mappedTypeId}")
	public Response loadVehicleTypeWiseDrugDetails(@PathVariable("vehicleTypeId") Integer vehicleTypeId,@PathVariable("mappedTypeId") Integer  mappedTypeId)
			throws InSufficientInputException, DataNotFoundException {
		
		System.out.println("vehicleTypeId--"+vehicleTypeId +"mappedTypeId--"+mappedTypeId);
		//log.info("::::Inputs::Are::::" + objVehicleTypeDrugsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		VehicleWiseDrugWrapper objVehicleWiseDrugWrapper = new VehicleWiseDrugWrapper();
		
		if (vehicleTypeId != null
				&& mappedTypeId != null) {
			VehicleTypeDrugMapper mapper = new VehicleTypeDrugMapper();
			List<?> sDto = objDrugVehicleService.loadVehicleTypeWiseDrugDetails_Get(vehicleTypeId,mappedTypeId,strRequestID);
			objVehicleWiseDrugWrapper
					.setObjVehicleTypeDrugsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objVehicleWiseDrugWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objVehicleWiseDrugWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} 
		else {
			throw new InSufficientInputException("");
		}
		return objVehicleWiseDrugWrapper;

	}
	
	// SELECT vt_vehicletypeid, vt_vehicle_type FROM vmsvehicletypes_ref WHERE
	// vt_isactive=true ORDER BY vt_vehicletypeid
	
	/**
	 * @author :Ranjeet Kumar.
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2021-07-17
	 * @Des : get ambulance type
	 * @URL :localhost:2000/scmservice/DrugVehicleTypeMappingController/ambulanceType
	 * @Parameters :
	 */
	@RequestMapping(value = "/ambulanceType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response ambulanceType() throws InSufficientInputException, DataNotFoundException {
		log.info("ambulanceType method executd");
		String strRequestID = request.getAttribute("reqid").toString();
		VehicleWiseDrugWrapper objVehicleWiseDrugWrapper = new VehicleWiseDrugWrapper();
		VehicleTypeDrugMapper mapper = new VehicleTypeDrugMapper();
		List<VehicleTypeDrugsServiceDTO> sDto = objDrugVehicleService.AmbulanceType(strRequestID);
		
		objVehicleWiseDrugWrapper.setObjVehicleTypeDrugsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
		objVehicleWiseDrugWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objVehicleWiseDrugWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::" + objVehicleWiseDrugWrapper.toString());
		return objVehicleWiseDrugWrapper;
	}

}

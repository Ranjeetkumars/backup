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
import com.pro.scm.controllerdto.UpdateDrugDetailsControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.BrandDetailsMapper;
import com.pro.scm.mappers.UpdateDrugDetailsMapper;
import com.pro.scm.mappers.VehicleTypeMapper;
import com.pro.scm.service.BrandRegistrationService;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.VehicleTypeServiceDTO;
import com.pro.scm.wrappers.BrandDetailsWrapper;
import com.pro.scm.wrappers.UpdateDetailsWrapper;
import com.pro.scm.wrappers.VehicleTypeWrapper;


import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/BrandRegistrationController")
@Slf4j
public class BrandRegistrationController {
	
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objBrandRegistrationService")
	private BrandRegistrationService objBrandRegistrationService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/BrandRegistrationController/UpdateDrugDetails
	 * @Parameters :{	"brandId":1,"brandName":"Others","userId":171,"moduleId":40,"roleId":100,"status":true } 
	 */
	@CrossOrigin
	@RequestMapping(value = "/UpdateDrugDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getVehicleMappingStatus(@RequestBody UpdateDrugDetailsControllerDTO objUpdateDrugDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objUpdateDrugDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		UpdateDrugDetailsMapper objUpdateDrugDetailsMapper = new UpdateDrugDetailsMapper();
		UpdateDetailsWrapper objUpdateDetailsWrapper = new UpdateDetailsWrapper();
		if (objUpdateDrugDetailsControllerDTO.getBrandId()!= null && objUpdateDrugDetailsControllerDTO.getBrandName()!= null &&
			objUpdateDrugDetailsControllerDTO.getUserId()!= null && objUpdateDrugDetailsControllerDTO.getModuleId()!= null &&
			objUpdateDrugDetailsControllerDTO.getRoleId()!= null && objUpdateDrugDetailsControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objBrandRegistrationService.UpdateDrugDetails(
					objUpdateDrugDetailsMapper.conversionControllerDtoToServiceDto(objUpdateDrugDetailsControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objUpdateDetailsWrapper.setResponseCode(HttpStatus.OK.value());
				objUpdateDetailsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objUpdateDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objUpdateDetailsWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objUpdateDetailsWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objUpdateDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objUpdateDetailsWrapper.toString());
		return objUpdateDetailsWrapper;
	}
	
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/BrandRegistrationController/saveBrandDetails
	 * @Parameters :{"brandName":"Others","userId":171,"moduleId":40,"roleId":100,"status":true } 
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveBrandDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveBrandDetails(@RequestBody UpdateDrugDetailsControllerDTO objUpdateDrugDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objUpdateDrugDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		UpdateDrugDetailsMapper objUpdateDrugDetailsMapper = new UpdateDrugDetailsMapper();
		UpdateDetailsWrapper objUpdateDetailsWrapper = new UpdateDetailsWrapper();
		if (objUpdateDrugDetailsControllerDTO.getBrandName()!= null &&
			objUpdateDrugDetailsControllerDTO.getUserId()!= null && objUpdateDrugDetailsControllerDTO.getModuleId()!= null &&
			objUpdateDrugDetailsControllerDTO.getRoleId()!= null && objUpdateDrugDetailsControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objBrandRegistrationService.saveDrugDetails(
					objUpdateDrugDetailsMapper.conversionControllerDtoToServiceDto(objUpdateDrugDetailsControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objUpdateDetailsWrapper.setResponseCode(HttpStatus.OK.value());
				objUpdateDetailsWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objUpdateDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objUpdateDetailsWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objUpdateDetailsWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objUpdateDetailsWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objUpdateDetailsWrapper.toString());
		return objUpdateDetailsWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/BrandRegistrationController/loadBrandDetails
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadBrandDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadBrandDetails() throws InSufficientInputException, DataNotFoundException {
		BrandDetailsWrapper objwrapper = new BrandDetailsWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<BrandDetailsServiceDTO> sDto = objBrandRegistrationService.loadBrandDetails(strRequestID);
		objwrapper.setObjBrandDetailsControllerDTO(
				new BrandDetailsMapper().conversionForServiceTOControllerDTO(sDto));
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
	 * @URL :localhost:2000/scmservice/BrandRegistrationController/loadVehicleType
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadVehicleType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadVehicleType() throws InSufficientInputException, DataNotFoundException {
		VehicleTypeWrapper objwrapper = new VehicleTypeWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<VehicleTypeServiceDTO> sDto = objBrandRegistrationService.loadVehicleType(strRequestID);
		objwrapper.setObjVehicleTypeControllerDTO(
				new VehicleTypeMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
}

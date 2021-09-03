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

import com.pro.scm.controllerdto.MaterialManufactureControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.MaterialManufactureMapper;
import com.pro.scm.persistencedto.MaterialManufactureServiceDTO;
import com.pro.scm.service.MaterialManufactureService;
import com.pro.scm.wrappers.MaterialManufactureWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/MaterialManufactureController")
@Slf4j
public class MaterialManufactureController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objMaterialManufactureService")
	private MaterialManufactureService objMaterialManufactureService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialManufactureController/saveManufacture
	 * @Parameters :{	"manufactureName":"others","userId":171,"moduleId":40,"roleId":100,"status":true } 
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveManufacture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveManufacture(@RequestBody MaterialManufactureControllerDTO obMaterialManufactureControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+obMaterialManufactureControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MaterialManufactureMapper obMaterialManufactureMapper = new MaterialManufactureMapper();
		MaterialManufactureWrapper objUpdateDetailsWrapper = new MaterialManufactureWrapper();
		if (obMaterialManufactureControllerDTO.getManufactureName()!= null &&
			obMaterialManufactureControllerDTO.getUserId()!= null && obMaterialManufactureControllerDTO.getModuleId()!= null &&
			obMaterialManufactureControllerDTO.getRoleId()!= null && obMaterialManufactureControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objMaterialManufactureService.saveManufacture(
					obMaterialManufactureMapper.conversionControllerDtoToServiceDto(obMaterialManufactureControllerDTO), strRequestID);
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
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialManufactureController/updateManufacture
	 * @Parameters :{"manufactureName":"Others","status":true, "manufactureId":1} 
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateManufacture", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateManufacture(@RequestBody MaterialManufactureControllerDTO objMaterialManufactureControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objMaterialManufactureControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MaterialManufactureMapper objMaterialManufactureMapper = new MaterialManufactureMapper();
		MaterialManufactureWrapper objMaterialManufactureWrapper = new MaterialManufactureWrapper();
		if (objMaterialManufactureControllerDTO.getManufactureName()!= null &&
				objMaterialManufactureControllerDTO.getStatus()!= null && objMaterialManufactureControllerDTO.getManufactureId()!= null) {
			String rtnValueOfMT = objMaterialManufactureService.updateManufacture(
					objMaterialManufactureMapper.conversionControllerDtoToServiceDto(objMaterialManufactureControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objMaterialManufactureWrapper.setResponseCode(HttpStatus.OK.value());
				objMaterialManufactureWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objMaterialManufactureWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objMaterialManufactureWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objMaterialManufactureWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objMaterialManufactureWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objMaterialManufactureWrapper.toString());
		return objMaterialManufactureWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialManufactureController/loadMaterialManufacture
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadMaterialManufacture", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadBrandDetails() throws InSufficientInputException, DataNotFoundException {
		MaterialManufactureWrapper objwrapper = new MaterialManufactureWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<MaterialManufactureServiceDTO> sDto = objMaterialManufactureService.loadMaterialManufacture(strRequestID);
		objwrapper.setObjMaterialManufactureControllerDTO(
				new MaterialManufactureMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}

}

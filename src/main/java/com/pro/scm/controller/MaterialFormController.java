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

import com.pro.scm.controllerdto.MaterialFormControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.MaterialFormMapper;
import com.pro.scm.service.MaterialFormService;
import com.pro.scm.servicedto.MaterialFormServiceDTO;
import com.pro.scm.wrappers.LoadMaterialFormWrapper;
import com.pro.scm.wrappers.MaterialFormWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/MaterialFormController")
@Slf4j
public class MaterialFormController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objMaterialFormService")
	private MaterialFormService objMaterialFormService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialFormController/saveMaterialForm
	 * @Parameters :{"materialForm":"R15","userId":171,"roleId":100,"moduleId":40,"status":true,"intMaterialFormId":1} 
	 */
	@RequestMapping(value = "/saveMaterialForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveMaterialForm(@RequestBody MaterialFormControllerDTO objMaterialFormControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objMaterialFormControllerDTO.toString());
		
		System.out.println("Material From " +objMaterialFormControllerDTO.getMaterialForm());
		System.out.println("User Id" +objMaterialFormControllerDTO.getUserId());
		System.out.println("Role Id" +objMaterialFormControllerDTO.getRoleId());
		System.out.println("Module Id " +objMaterialFormControllerDTO.getModuleId());
		
		System.out.println("Status  " +objMaterialFormControllerDTO.getStatus());
		System.out.println("Material From Id " +objMaterialFormControllerDTO.getMaterialFormId());
		
		
		String strRequestID = request.getAttribute("reqid").toString();
		MaterialFormMapper objMaterialFormMapper = new MaterialFormMapper();
		MaterialFormWrapper objMaterialFormWrapper = new MaterialFormWrapper();
		if (objMaterialFormControllerDTO.getMaterialForm()!= null &&
			objMaterialFormControllerDTO.getUserId()!= null && objMaterialFormControllerDTO.getRoleId()!= null &&
			objMaterialFormControllerDTO.getModuleId()!= null && objMaterialFormControllerDTO.getStatus()!= null &&
			objMaterialFormControllerDTO.getIntMaterialFormId()!= null) {
			String rtnValueOfMT = objMaterialFormService.saveMaterialForm(
					objMaterialFormMapper.conversionControllerDtoToServiceDto(objMaterialFormControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objMaterialFormWrapper.setResponseCode(HttpStatus.OK.value());
				objMaterialFormWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objMaterialFormWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objMaterialFormWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objMaterialFormWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objMaterialFormWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objMaterialFormWrapper.toString());
		return objMaterialFormWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialFormController/updateMaterialForm
	 * @Parameters :{"materialForm":"R15","materialGroupId":171,"materialFormId":100,"status":true} 
	 */
	@RequestMapping(value = "/updateMaterialForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateMaterialForm(@RequestBody MaterialFormControllerDTO objMaterialFormControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objMaterialFormControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MaterialFormMapper objMaterialFormMapper = new MaterialFormMapper();
		MaterialFormWrapper objMaterialFormWrapper = new MaterialFormWrapper();
		if (objMaterialFormControllerDTO.getMaterialForm()!= null &&
			objMaterialFormControllerDTO.getStatus()!= null && objMaterialFormControllerDTO.getMaterialGroupId()!= null &&
			objMaterialFormControllerDTO.getMaterialFormId()!= null) {
			String rtnValueOfMT = objMaterialFormService.updateMaterialForm(
					objMaterialFormMapper.conversionControllerDtoToServiceDto(objMaterialFormControllerDTO), strRequestID);
			if (rtnValueOfMT != null) {
				objMaterialFormWrapper.setResponseCode(HttpStatus.OK.value());
				objMaterialFormWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objMaterialFormWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objMaterialFormWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objMaterialFormWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objMaterialFormWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objMaterialFormWrapper.toString());
		return objMaterialFormWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialFormController/loadMaterialForm
	 * @Parameters :No
	 */
//	
	@CrossOrigin
	@RequestMapping(value = "/loadMaterialForm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadMaterialForm() throws InSufficientInputException, DataNotFoundException {
		LoadMaterialFormWrapper objwrapper = new LoadMaterialFormWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<MaterialFormServiceDTO> sDto = objMaterialFormService.loadMaterialForm(strRequestID);
		objwrapper.setDto(sDto);
		//MaterialFormServiceDTO
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
	
	
	
	
	/**
	 * @author :Rajeet 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2021-07-23
	 * @Des : loadActiveMatrialGroup
	 * @URL :localhost:2000/scmservice/MaterialFormController/dropdown-MatrialGroup
	 * @Parameters :No
	 */
//	
	@CrossOrigin
	@RequestMapping(value = "/dropdown-MatrialGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadActiveMatrialGroup() throws InSufficientInputException, DataNotFoundException {
		LoadMaterialFormWrapper objwrapper = new LoadMaterialFormWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<MaterialFormServiceDTO> sDto = objMaterialFormService.loadActiveMatrialGroup(strRequestID);
		objwrapper.setDto(sDto);
		//MaterialFormServiceDTO
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
	
	
	
	
	
	
	
}

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

import com.pro.scm.controllerdto.MaterialGroupControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.MaterialGroupMapper;
import com.pro.scm.service.MaterialGroupService;
import com.pro.scm.servicedto.MaterialGroupServiceDTO;
import com.pro.scm.wrappers.MaterialGroupWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/MaterialGroupController")
@Slf4j
public class MaterialGroupController {
	
	
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objMaterialGroupService")
	private MaterialGroupService objMaterialGroupService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialGroupController/saveorUpdateMaterialUnit
	 * @Parameters :{"groupId":1,"groupName":"vendorClassification",
	  "userId":171,"roleId":100,"moduleId":40,"status":true,"operationType":0} 
	 */
	@RequestMapping(value = "/saveorUpdateMaterialUnit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveorUpdateMaterialUnit(@RequestBody MaterialGroupControllerDTO objControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MaterialGroupMapper objMaterialGroupMapper = new MaterialGroupMapper();
		MaterialGroupWrapper objMaterialGroupWrapper = new MaterialGroupWrapper();
		
		
		System.out.println("getGroupId"+objControllerDTO.getGroupId());
		System.out.println("getGroupName"+objControllerDTO.getGroupName());
		System.out.println("getUserId"+objControllerDTO.getUserId());
		System.out.println("getRoleId"+objControllerDTO.getRoleId());
		System.out.println("getModuleId"+objControllerDTO.getModuleId());
		System.out.println("getStatus"+objControllerDTO.getStatus());
		System.out.println("getOperationType"+objControllerDTO.getOperationType());
		//Changed by Ranjeet
		if (objControllerDTO.getGroupId()!= null && objControllerDTO.getGroupName()!= null &&
			objControllerDTO.getUserId()!= null &&
			objControllerDTO.getRoleId()!= null &&objControllerDTO.getModuleId()!= null &&
			objControllerDTO.getStatus()!= null && objControllerDTO.getOperationType()!=null) {
			
			String rtnValueOfMT = objMaterialGroupService.saveorUpdateMaterialGroup(
					objMaterialGroupMapper.conversionControllerDtoToServiceDto(objControllerDTO), strRequestID,"3rd param not using");
			if (rtnValueOfMT != null) {
				objMaterialGroupWrapper.setResponseCode(HttpStatus.OK.value());
				objMaterialGroupWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objMaterialGroupWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objMaterialGroupWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objMaterialGroupWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objMaterialGroupWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {	
			throw new InSufficientInputException(objControllerDTO.toString());
		}
		log.info("::::OUTPUT::::::"+objMaterialGroupWrapper.toString());
		return objMaterialGroupWrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialGroupController/loadMaterialGroup
	 * @Parameters :No
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadMaterialGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadMaterialGroup() throws InSufficientInputException, DataNotFoundException {
		MaterialGroupWrapper objwrapper = new MaterialGroupWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<MaterialGroupServiceDTO> sDto = objMaterialGroupService.loadMaterialGroup(strRequestID);
		objwrapper.setObMaterialGroupControllerDTO(
				new MaterialGroupMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
	
}

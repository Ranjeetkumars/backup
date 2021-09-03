package com.pro.scm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.pro.scm.wrappers.MaterialGroupWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/PackingVolumeRegistration")
@Slf4j
public class PackingVolumeRegistration {

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
	 * @URL :localhost:2000/scmservice/PackingVolumeRegistration/saveorUpdatePackingVolume
	 * @Parameters :{"unitId":0,"unitName":"10x10","conversionFactor":"100",
	 *             "userId":171,"roleId":100,"moduleId":40,"status":true,"operationType":1,"materialForm":"1"}
	 */
	@RequestMapping(value = "/saveorUpdatePackingVolume", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveorUpdatePackingVolume(@RequestBody MaterialGroupControllerDTO objControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MaterialGroupMapper objMaterialGroupMapper = new MaterialGroupMapper();
		MaterialGroupWrapper objMaterialGroupWrapper = new MaterialGroupWrapper();

		// Changed by Ranjeet
		if (objControllerDTO.getUnitId() != null && objControllerDTO.getUnitName() != null
				&& objControllerDTO.getConversionFactor() != null && objControllerDTO.getRoleId() != null
				&& objControllerDTO.getModuleId() != null && objControllerDTO.getStatus() != null
				&& objControllerDTO.getOperationType() != null && objControllerDTO.getMaterialForm() != null) {

			String rtnValueOfMT = objMaterialGroupService.saveorUpdatePackingVolume(
					objMaterialGroupMapper.conversionControllerDtoToServiceDto(objControllerDTO), strRequestID,
					"3rd param not using");
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
		log.info("::::OUTPUT::::::" + objMaterialGroupWrapper.toString());
		return objMaterialGroupWrapper;
	}

}

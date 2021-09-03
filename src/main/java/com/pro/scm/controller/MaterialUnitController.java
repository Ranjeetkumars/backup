package com.pro.scm.controller;

import java.util.ArrayList;
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

import com.pro.scm.controllerdto.MaterialUnitControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SupplierClassificationControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.LoadUnitMapper;
import com.pro.scm.mappers.MaterailUnitMapper;
import com.pro.scm.mappers.VehicleTypeMapper;
import com.pro.scm.service.MaterialUnitService;
import com.pro.scm.servicedto.LoadUnitServiceDTO;
import com.pro.scm.servicedto.MaterialUnitServiceDTO;
import com.pro.scm.servicedto.PharmacySalesServiceDTO;
import com.pro.scm.servicedto.VehicleTypeServiceDTO;
import com.pro.scm.utills.IsEmptyUtil;
import com.pro.scm.wrappers.LoadUnitWrapper;
import com.pro.scm.wrappers.MaterialUnitWrapper;
import com.pro.scm.wrappers.VehicleTypeWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/MaterialUnitController")
@Slf4j
public class MaterialUnitController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objMaterialUnitService")
	private MaterialUnitService objMaterialUnitService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialUnitController/saveorUpdateMaterialUnit
	 * 
	 * @Parameters :{"unitId":0,"unitName":"1",
  "conversionFactor": "1x1","userId":171,"roleId":100,"moduleId":40,"status":true,"operationType":1,"materialForm":1}(insert)  }
  update 
  {"unitId":12,"unitName":"1",
  "conversionFactor": "1x1","userId":171,"roleId":100,"moduleId":40,"status":true,"operationType":2,"materialForm":1}
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveorUpdateMaterialUnit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveorUpdateMaterialUnit(@RequestBody MaterialUnitControllerDTO objControllerDTO,String operationType)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		List<String> errmsgs = new ArrayList<String>();
		MaterialUnitServiceDTO dataInfo = new MaterialUnitServiceDTO();
		MaterailUnitMapper obMaterailUnitMapper = new MaterailUnitMapper();
		MaterialUnitWrapper objMaterialUnitWrapper = new MaterialUnitWrapper();
			if (IsEmptyUtil.isEmptyObject(objControllerDTO.getUnitId())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getUnitName())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getConversionFactor())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getUserId())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getRoleId())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getModuleId())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getStatus())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getOperationType())
					|| IsEmptyUtil.isEmptyObject(objControllerDTO.getMaterialForm())){
			throw new InSufficientInputException("");
	
	} else {
		dataInfo = obMaterailUnitMapper.conversionControllerDtoToServiceDto(objControllerDTO);
		String commonresponse = objMaterialUnitService.saveorUpdateMaterialUnit(dataInfo, strRequestID);
		objMaterialUnitWrapper.setResponseCode(HttpStatus.OK.value());
		objMaterialUnitWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
		objMaterialUnitWrapper.setRtnReponseCount(commonresponse);
		objMaterialUnitWrapper.setErrorsMsgs(errmsgs);
	}
	log.info(strRequestID + ":::::::::::::::::::::::::::::saveorUpdateMaterialUnit()::::::::::::::::"
			+objMaterialUnitWrapper.toString());
	return objMaterialUnitWrapper;

}
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialUnitController/loadUnits
	 * @Parameters :No
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadUnits", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadUnits() throws InSufficientInputException, DataNotFoundException {
		LoadUnitWrapper objwrapper = new LoadUnitWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<LoadUnitServiceDTO> sDto = objMaterialUnitService.loadUnits(strRequestID);
		objwrapper.setObjLoadUnitControllerDTO(
				new LoadUnitMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-31
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/MaterialUnitController/loadMaterialForm
	 * @Parameters :No
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadMaterialForm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadMaterialForm() throws InSufficientInputException, DataNotFoundException {
		LoadUnitWrapper objwrapper = new LoadUnitWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<LoadUnitServiceDTO> sDto = objMaterialUnitService.loadMaterialForm(strRequestID);
		objwrapper.setObjLoadUnitControllerDTO(
				new LoadUnitMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
}

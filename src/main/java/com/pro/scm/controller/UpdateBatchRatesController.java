package com.pro.scm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.scm.controllerdto.MedicineControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.ItemShelveMapper;
import com.pro.scm.mappers.LoadManufactureMapper;
import com.pro.scm.mappers.MedicinesMapper;
import com.pro.scm.mappers.VehicleTypeMapper;
import com.pro.scm.service.UpdateBatchRatesService;
import com.pro.scm.servicedto.LoadManufactureServiceDTO;
import com.pro.scm.servicedto.MedicineServiceDTO;
import com.pro.scm.servicedto.VehicleTypeServiceDTO;
import com.pro.scm.wrappers.LoadManufactureWrapper;
import com.pro.scm.wrappers.MedicinesWrapper;
import com.pro.scm.wrappers.VehicleTypeWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/UpdateBatchRatesController")
@Slf4j
public class UpdateBatchRatesController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objUpdateBatchRatesService")
	private UpdateBatchRatesService objUpdateBatchRatesService;
	@Autowired
	private HttpServletRequest request;
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/UpdateBatchRatesController/getAllMedicines
	 * @Parameters :{"genric_drug_name":'str',"brandId":1,"formId":1,"manufactureId":1,"shortCode":"CO-149","systemId":1,
	 * "genericGroupId":1,"genericMoleculeId":1,"storeId":1} 
	 */
	
	@CrossOrigin
	@RequestMapping(value = "/getAllMedicines", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllMedicines(
			@RequestBody MedicineControllerDTO objMedicineControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objMedicineControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MedicinesWrapper objwrapper = new MedicinesWrapper();
		if(objMedicineControllerDTO.getGenric_drug_name()!= null && objMedicineControllerDTO.getBrandId()!= null 
		&& objMedicineControllerDTO.getFormId()!= null && objMedicineControllerDTO.getManufactureId()!= null &&	
			objMedicineControllerDTO.getShortCode()!= null && objMedicineControllerDTO.getSystemId()!= null &&
			objMedicineControllerDTO.getGenericGroupId()!= null && objMedicineControllerDTO.getGenericMoleculeId()!= null &&
			objMedicineControllerDTO.getStoreId()!= null) {
			
			MedicinesMapper mapper = new MedicinesMapper();
			List<MedicineServiceDTO> sDto = objUpdateBatchRatesService
					.getAllMedicines(mapper.conversionControllerDtoToServiceDto(objMedicineControllerDTO),
							strRequestID);
			objwrapper.setObjMedicineControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
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
	 * @URL :localhost:2000/scmservice/UpdateBatchRatesController/loadManufacture
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadManufacture", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadManufacture() throws InSufficientInputException, DataNotFoundException {
		LoadManufactureWrapper objwrapper = new LoadManufactureWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<LoadManufactureServiceDTO> sDto = objUpdateBatchRatesService.loadManufacture(strRequestID);
		objwrapper.setObjLoadManufactureControllerDTO(
				new LoadManufactureMapper().conversionForServiceTOControllerDTO(sDto));
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
	 * @URL :localhost:2000/scmservice/UpdateBatchRatesController/updateBatchRates
	 * @Parameters :{"drugId":str,"batchNumber":1,"mrp":1,"expireDate":"now()","unitCost":1000} 
	 */
	
	@RequestMapping(value = "/updateBatchRates", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateBatchRates(
			@RequestBody MedicineControllerDTO objMedicineControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objMedicineControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		MedicinesWrapper objwrapper = new MedicinesWrapper();
		if(objMedicineControllerDTO.getDrugId()!= null && objMedicineControllerDTO.getBatchNumber()!= null 
		&& objMedicineControllerDTO.getMrp()!= null && objMedicineControllerDTO.getExpireDate()!= null &&	
			objMedicineControllerDTO.getUnitCost()!= null ) {
			
			MedicinesMapper mapper = new MedicinesMapper();
			String sDto = objUpdateBatchRatesService
					.updateBatchRates(mapper.conversionControllerDtoToServiceDto(objMedicineControllerDTO),
							strRequestID);
			objwrapper.setRtnReponseCount(sDto);
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
}

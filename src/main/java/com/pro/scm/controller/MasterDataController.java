package com.pro.scm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.scm.controllerdto.PharmacyNewDrugQtyControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.UpdateDrugDetailsControllerDTO;
import com.pro.scm.controllerdto.VehicleTypeDrugsControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.BrandDetailsMapper;
import com.pro.scm.mappers.SearchDrugMapper;
import com.pro.scm.mappers.UpdateDrugDetailsMapper;
import com.pro.scm.mappers.VehicleTypeDrugMapper;
import com.pro.scm.service.MasterDataService;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;
import com.pro.scm.wrappers.BrandDetailsWrapper;
import com.pro.scm.wrappers.SearchDrugWrapper;
import com.pro.scm.wrappers.UpdateDetailsWrapper;
import com.pro.scm.wrappers.VehicleWiseDrugWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/masterDataController")
@Slf4j
public class MasterDataController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objMasterDataService")
	private MasterDataService objMasterDataService;
	@Autowired
	private HttpServletRequest request;
	

	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/masterDataController/UpdateDrugDetails
	 * @Parameters :{	"brandId":1,"brandName":"Others","userId":171,"moduleId":40,"roleId":100,"status":true } 
	 */
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
			String rtnValueOfMT = objMasterDataService.UpdateDrugDetails(
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
	 * @URL :localhost:2000/scmservice/masterDataController/SearchDrug
	 * @Parameters :{	"strBrandName":"others","strDrugCode":"CO-16","intCounterId":1 } 
	 */
	
	@RequestMapping(value = "/SearchDrug", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response SearchDrug(
			@RequestBody PharmacyNewDrugQtyControllerDto objPharmacyNewDrugQtyControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objPharmacyNewDrugQtyControllerDto.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		SearchDrugWrapper objwrapper = new SearchDrugWrapper();
		if(objPharmacyNewDrugQtyControllerDto.getStrBrandName()!= null
				&& objPharmacyNewDrugQtyControllerDto.getStrDrugCode()!=null
				&& objPharmacyNewDrugQtyControllerDto.getIntCounterId()!= null) {
			
			SearchDrugMapper mapper = new SearchDrugMapper();
			List<PharamacyNewDrugQtyServiceDto> sDto = objMasterDataService
					.searchDrug(mapper.conversionControllerDtoToServiceDto(objPharmacyNewDrugQtyControllerDto),
							strRequestID);
			objwrapper.setObjPharmacyNewDrugQtyControllerDto(mapper.conversionForServiceTOControllerDTO(sDto));
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
	 * @URL :localhost:2000/scmservice/masterDataController/saveDrugDetails
	 * @Parameters :{"brandName":"Others","userId":171,"moduleId":40,"roleId":100,"status":true } 
	 */
	@RequestMapping(value = "/saveDrugDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveDrugDetails(@RequestBody UpdateDrugDetailsControllerDTO objUpdateDrugDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objUpdateDrugDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		UpdateDrugDetailsMapper objUpdateDrugDetailsMapper = new UpdateDrugDetailsMapper();
		UpdateDetailsWrapper objUpdateDetailsWrapper = new UpdateDetailsWrapper();
		if (objUpdateDrugDetailsControllerDTO.getBrandName()!= null &&
			objUpdateDrugDetailsControllerDTO.getUserId()!= null && objUpdateDrugDetailsControllerDTO.getModuleId()!= null &&
			objUpdateDrugDetailsControllerDTO.getRoleId()!= null && objUpdateDrugDetailsControllerDTO.getStatus()!= null) {
			String rtnValueOfMT = objMasterDataService.saveDrugDetails(
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
	 * @URL :localhost:2000/scmservice/masterDataController/loadBrandDetails
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/loadBrandDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadBrandDetails() throws InSufficientInputException, DataNotFoundException {
		BrandDetailsWrapper objwrapper = new BrandDetailsWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<BrandDetailsServiceDTO> sDto = objMasterDataService.loadBrandDetails(strRequestID);
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
	 * @URL :localhost:2000/scmservice/masterDataController/loadVehicleTypeWiseDrugDetails
	 * @Parameters :{"vehicleType":1, "mappedType":1 }
	 */
	@RequestMapping(value = "/loadVehicleTypeWiseDrugDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadVehicleTypeWiseDrugDetails(
			@RequestBody VehicleTypeDrugsControllerDTO objVehicleTypeDrugsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::"+objVehicleTypeDrugsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		VehicleWiseDrugWrapper objVehicleWiseDrugWrapper = new VehicleWiseDrugWrapper();
		if(objVehicleTypeDrugsControllerDTO.getVehicleType()!= null
				&& objVehicleTypeDrugsControllerDTO.getMappedType()!=null) {
			
			VehicleTypeDrugMapper mapper = new VehicleTypeDrugMapper();
			List<VehicleTypeDrugsServiceDTO> sDto = objMasterDataService
					.loadVehicleTypeWiseDrugDetails(mapper.conversionControllerDtoToServiceDto(objVehicleTypeDrugsControllerDTO),
							strRequestID);
			objVehicleWiseDrugWrapper.setObjVehicleTypeDrugsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objVehicleWiseDrugWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objVehicleWiseDrugWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::"+objVehicleWiseDrugWrapper.toString());
		return objVehicleWiseDrugWrapper;
	}
	
	
	
	// 

	/**
	 * @author :Ranjeet kr
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2020-05-8
	 * @Des : printBarCode
	 * @URL :localhost:2000/scmservice/masterDataController/printBarCode
	 * @Parameters :No
	 */
	
	@RequestMapping(value = "/printBarCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response printBarCode() throws InSufficientInputException, DataNotFoundException {
		BrandDetailsWrapper objwrapper = new BrandDetailsWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<BrandDetailsServiceDTO> sDto = objMasterDataService.printBarCode(strRequestID);
		objwrapper.setObjBrandDetailsControllerDTO(
				new BrandDetailsMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::"+objwrapper.toString());
		return objwrapper;
	}
	
}

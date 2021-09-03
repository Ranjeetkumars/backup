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

import com.pro.scm.controllerdto.DrugAndSupplierMappingControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.DrugAndSupplierMappingMapper;
import com.pro.scm.service.DrugRegisteringService;
import com.pro.scm.servicedto.DrugAndSupplierMappingServiceDto;
import com.pro.scm.servicedto.LoadGenericNamesServiceDto;
import com.pro.scm.wrappers.DrugAndSupplierMappingwrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/drugAndSupplierMappingController")
public class DrugAndSupplierMappingController {

	@Autowired
	@Qualifier("drugRegisteringService")
	DrugRegisteringService drugRegisteringService;
	InSufficientInputException obj;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : listloadSuppliers
	 * @URL :
	 *      http://localhost:2000/scmservice/drugAndSupplierMappingController/listloadSuppliers
	 */
	@RequestMapping(value = "/listloadSuppliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response listloadSuppliers() throws InSufficientInputException, DataNotFoundException {
		log.info("listloadSuppliers method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data With RequestId=" + strRequestID);
		DrugAndSupplierMappingwrapper wrapper = new DrugAndSupplierMappingwrapper();
		List<DrugAndSupplierMappingServiceDto> serviceDto = drugRegisteringService.listloadSuppliers(strRequestID);
		wrapper.setDrugAndSupplierMappingControllerDto(
				new DrugAndSupplierMappingMapper().conversionForServiceTOControllerDTO(serviceDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : listloadSuppliers
	 * @URL :
	 *      http://localhost:2000/scmservice/drugAndSupplierMappingController/loadMappedDrugs
	 *      {"supplierId":"3"}
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadMappedDrugs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response loadMappedDrugs(@RequestBody DrugAndSupplierMappingControllerDto controllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadMappedDrugs method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data With RequestId=" + strRequestID);
		DrugAndSupplierMappingMapper mapper = new DrugAndSupplierMappingMapper();
		DrugAndSupplierMappingwrapper wrapper = new DrugAndSupplierMappingwrapper();
		if (controllerDto.getSupplierId() != null) {
			List<DrugAndSupplierMappingServiceDto> serviceDto = drugRegisteringService
					.loadMappedDrugs(mapper.converControllerToServiceDTO(controllerDto), strRequestID);
			wrapper.setDrugAndSupplierMappingControllerDto(
					new DrugAndSupplierMappingMapper().conversionForServiceTOControllerDTO(serviceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			wrapper.setResponseCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException("");
		}

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	// select * from sp_update_drug_company_end_date(148,5);
	//

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : listloadSuppliers
	 * @URL :
	 *      http://localhost:2000/scmservice/drugAndSupplierMappingController/updateMappedDrugToUnMap
	 *      {"supplierId":"3","drugId":"5"}
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateMappedDrugToUnMap", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response updateMappedDrugToUnMap(@RequestBody DrugAndSupplierMappingControllerDto controllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadMappedDrugs method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data With RequestId=" + strRequestID);
		DrugAndSupplierMappingMapper mapper = new DrugAndSupplierMappingMapper();
		DrugAndSupplierMappingwrapper wrapper = new DrugAndSupplierMappingwrapper();
		if (controllerDto.getSupplierId() != null && controllerDto.getDrugId() != null) {
			String rtnStatus = drugRegisteringService
					.updateMappedDrugToUnMap(mapper.converControllerToServiceDTO(controllerDto), strRequestID);
			wrapper.setRtnReponseCount(rtnStatus);
			;
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			wrapper.setResponseCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException("");
		}

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	// updateDrugSupplierMapping(strDrugId, strSupplierId, strPurchasprice,
	// strPrUnit, strMrp, strUnitprice, strVat, strDiscount, strStardate,
	// tblMappedDrugs.getRowCount(), ers);

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : listloadSuppliers
	 * @URL :
	 *      http://localhost:2000/scmservice/drugAndSupplierMappingController/updateDrugSupplierMapping
	 * 
	 */
	@CrossOrigin

	
	@RequestMapping(value = "/updateDrugSupplierMapping", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response updateDrugSupplierMapping(@RequestBody DrugAndSupplierMappingControllerDto controllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadMappedDrugs method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data With RequestId=" + strRequestID);
		DrugAndSupplierMappingMapper mapper = new DrugAndSupplierMappingMapper();
		DrugAndSupplierMappingwrapper wrapper = new DrugAndSupplierMappingwrapper();
		
		//serviceDto.() + "','" + serviceDto.()
		
		if (controllerDto.getDrugId() != null && controllerDto.getSupplierId() != null
				&& controllerDto.getPurchageprice() != null && controllerDto.getPurchageunitcost() != null
				&& controllerDto.getMrp() != null && controllerDto.getUnitcost() != null
						&& controllerDto.getVatpercentag() != null && controllerDto.getDiscount() != null
				&& controllerDto.getStartdate() != null && controllerDto.getCreatedById() != null
				&& controllerDto.getCreatedByModuleId() != null && controllerDto.getCreatedByRoleId() != null
				&& controllerDto.getRowCountSize() != null
				) {
			String rtnStatus = drugRegisteringService
					.updateDrugSupplierMapping(mapper.converControllerToServiceDTO(controllerDto), strRequestID);
			wrapper.setRtnReponseCount(rtnStatus);
			;
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			wrapper.setResponseCode(org.springframework.http.HttpStatus.BAD_REQUEST.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException("");
		}

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
}

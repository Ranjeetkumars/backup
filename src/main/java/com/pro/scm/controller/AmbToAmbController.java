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
import com.pro.scm.controllerdto.AmbToAmbTransferControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AmbToAmbTransferMapper;
import com.pro.scm.service.AmbToAmbTransferService;
import com.pro.scm.servicedto.AmbToAmbTransferServiceDTO;
import com.pro.scm.wrappers.AmbToAmbTransferWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ambToAmbController")
@Slf4j
public class AmbToAmbController {

	InSufficientInputException obj;
	@Autowired
	@Qualifier("ambToAmbTransferService")
	private AmbToAmbTransferService ambToAmbTransferService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @Des : loadVehicleItems
	 * @json:{ "vehicleId":17}
	 * @URL : http://localhost:2000/scmservice/ambToAmbController/loadVehicleItems
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadVehicleItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadVehicleItems(@RequestBody AmbToAmbTransferControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadGenricGroup method is executed inside ambToAmbController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
		AmbToAmbTransferWrapper wrapper = new AmbToAmbTransferWrapper();
		if (objControllerDto.getVehicleId() != null) {
			List<AmbToAmbTransferServiceDTO> objAddNewLocalDrugServiceDTO = ambToAmbTransferService
					.loadVehicleItems(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAmbToAmbTransferControllerDTO(
					mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @Des : loadVehicleReqAmbItems
	 * @json:{ "vehicleId":17}
	 * @URL :
	 *      http://localhost:2000/scmservice/ambToAmbController/loadVehicleReqAmbItems
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadVehicleReqAmbItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadVehicleReqAmbItems(@RequestBody AmbToAmbTransferControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadVehicleReqAmbItems method is executed inside ambToAmbController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
		AmbToAmbTransferWrapper wrapper = new AmbToAmbTransferWrapper();
		if (objControllerDto.getVehicleId() != null) {
			List<AmbToAmbTransferServiceDTO> objAddNewLocalDrugServiceDTO = ambToAmbTransferService
					.loadVehicleReqAmbItems(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAmbToAmbTransferControllerDTO(
					mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @Des : getAllCounterMedicines
	 * @json:{ "generic_drug_name":"gr", "brand_id":1, "form_id":1,
	 *         "manufacture_id":1, "unicode":1, "system_id":1, "generic_group_id":1,
	 *         "generic_molecules_id":1, "counterid":1 }
	 * @URL :
	 *      http://localhost:2001/scmservice/ambToAmbController/api/version_1/getAllCounterMedicines
	 */
	@RequestMapping(value = "/api/version_1/getAllCounterMedicines", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllCounterMedicines(@RequestBody AmbToAmbTransferControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getAllCounterMedicines method is executed inside ambToAmbController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
		AmbToAmbTransferWrapper wrapper = new AmbToAmbTransferWrapper();
		if (objControllerDto.getBrand_id() != null && objControllerDto.getGeneric_drug_name() != null
				&& objControllerDto.getForm_id() != null && objControllerDto.getManufacture_id() != null
				&& objControllerDto.getUnicode() != null && objControllerDto.getSystem_id() != null
				&& objControllerDto.getGeneric_group_id() != null && objControllerDto.getGeneric_group_id() != null
				&& objControllerDto.getGeneric_molecules_id() != null && objControllerDto.getCounterid() != null) {
			List<AmbToAmbTransferServiceDTO> objAddNewLocalDrugServiceDTO = ambToAmbTransferService
					.getAllCounterMedicines(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAmbToAmbTransferControllerDTO(
					mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Bhuneshwar patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @Des : getRetailIndentDetails
	 * @json:{ }
	 * @URL :
	 *      http://localhost:2001/scmservice/ambToAmbController/api/version_1/getRetailIndentDetails
	 */
	@RequestMapping(value = "/api/version_1/getRetailIndentDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getRetailIndentDetails(@RequestBody AmbToAmbTransferControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRetailIndentDetails method is executed inside ambToAmbController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
		AmbToAmbTransferWrapper wrapper = new AmbToAmbTransferWrapper();
		if (objControllerDto.getCounterid() != null) {
			List<AmbToAmbTransferServiceDTO> objAddNewLocalDrugServiceDTO = ambToAmbTransferService
					.getRetailIndentDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjAmbToAmbTransferControllerDTO(
					mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
//

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 13-08-2021
	 * @Des : saveTransferItemsDetails
	 * @json:{ }
	 * @URL :
	 *      http://localhost:2000/scmservice/ambToAmbController/api/version_1/saveTransferItemsDetails
	 */
	@RequestMapping(value = "/api/version_1/saveTransferItemsDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveTransferItemsDetails(@RequestBody AmbToAmbTransferControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRetailIndentDetails method is executed inside ambToAmbController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
		AmbToAmbTransferWrapper wrapper = new AmbToAmbTransferWrapper();

//		 drug_idlist text,
//		    drug_batchlist text,
//		    dr_expt character varying,

//		    drug_qtylist text,
//		    drug_noofstrips text,
//		    dr_pr_price text,
//		    dr_mrp text,
//		    dr_uni_cost text,
//		    from_vehicle_id integer,
//		    to_vehidi integer,
//		    size integer,
//		    userid integer,
//		    moduleid integer,
//		    roleid integer)

		System.out.println("getDrug_idlist ::" + objControllerDto.getDrug_idlist());
		System.out.println("getDrug_batchlist :: " + objControllerDto.getDrug_batchlist());
		System.out.println("getDr_expt :: " + objControllerDto.getDr_expt());
		System.out.println("getDrug_qtylist :: " + objControllerDto.getDrug_qtylist());
		System.out.println("getDrug_noofstrips :: " + objControllerDto.getDrug_noofstrips());
		System.out.println("getDr_pr_price :: " + objControllerDto.getDr_pr_price());
		System.out.println("getDr_mrp :: " + objControllerDto.getDr_mrp());
		System.out.println("getDr_uni_cost :: " + objControllerDto.getDr_uni_cost());
		System.out.println("getFrom_vehicle_id :: " + objControllerDto.getFrom_vehicle_id());
		System.out.println("getTo_vehidi :: " + objControllerDto.getTo_vehidi());
		System.out.println("getSize :: " + objControllerDto.getSize());
		System.out.println("getFrom_vehicle_id :: " + objControllerDto.getUserid());
		System.out.println("getModuleid :: " + objControllerDto.getModuleid());
		System.out.println("getRoleid :: " + objControllerDto.getRoleid());

		if (objControllerDto.getDrug_idlist() != null && objControllerDto.getDrug_batchlist() != null
				&& objControllerDto.getDr_expt() != null && objControllerDto.getDrug_qtylist() != null
				&& objControllerDto.getDrug_noofstrips() != null && objControllerDto.getDr_pr_price() != null

				&& objControllerDto.getDr_mrp() != null && objControllerDto.getDr_uni_cost() != null
				&& objControllerDto.getFrom_vehicle_id() != null && objControllerDto.getTo_vehidi() != null
				&& objControllerDto.getSize() != null && objControllerDto.getUserid() != null
				&& objControllerDto.getModuleid() != null && objControllerDto.getRoleid() != null) {
			String rtnValue = ambToAmbTransferService.saveTransferItemsDetails(
					mapper.conversionControllerDtoToServiceDtoForAcceptTransferItem(objControllerDto), strRequestID);

			wrapper.setRtnReponseCount(rtnValue);
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
}

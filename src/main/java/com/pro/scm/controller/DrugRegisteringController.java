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

import com.pro.scm.controllerdto.AllApprovalItemListControllerDto;
import com.pro.scm.controllerdto.AllPurchaseOrdersByMesserIdControllerDto;
import com.pro.scm.controllerdto.DrugRegistrationControllerDto;
import com.pro.scm.controllerdto.GenerateNewDrugBarcodeControllerDto;
import com.pro.scm.controllerdto.LoadMaterialFormControllerDto;
import com.pro.scm.controllerdto.LoadPackingTypeControllerDto;
import com.pro.scm.controllerdto.MesserAddressControllerDto;
import com.pro.scm.controllerdto.RejectIndentDataControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SaveDrugDetailsControllerDto;
import com.pro.scm.controllerdto.UpdateActiveDrugForRejectApprovalControllerDto;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AllApprovalItemListMapper;
import com.pro.scm.mappers.AllIndentDetailsMapper;
import com.pro.scm.mappers.AllPurchaseOrdersByMesserIdMapper;
import com.pro.scm.mappers.DrugRegistrationMapper;
import com.pro.scm.mappers.GenerateNewDrugBarcodeMapper;
import com.pro.scm.mappers.LoadGenericNamesMapper;
import com.pro.scm.mappers.LoadMaterialFormMapper;
import com.pro.scm.mappers.LoadPackingTypeMapper;
import com.pro.scm.mappers.LoadScheduleMapper;
import com.pro.scm.mappers.MesserAddressMapper;
import com.pro.scm.mappers.RejectIndentMapper;
import com.pro.scm.mappers.SaveDrugDetailsMapper;
import com.pro.scm.mappers.Save_vehicle_indent_detailsMapper;
import com.pro.scm.mappers.UpdateActiveDrugForRejectApprovalMapper;
import com.pro.scm.persistencedto.AllPurchaseOrdersByMesserIdServiceDto;
import com.pro.scm.service.DrugRegisteringService;
import com.pro.scm.servicedto.AllApprovalItemListServiceDto;
import com.pro.scm.servicedto.AllIndentDetailsServiceDto;
import com.pro.scm.servicedto.DrugRegistrationServiceDto;
import com.pro.scm.servicedto.GenerateNewDrugBarcodeServiceDto;
import com.pro.scm.servicedto.LoadGenericNamesServiceDto;
import com.pro.scm.servicedto.LoadMaterialFormServiceDto;
import com.pro.scm.servicedto.LoadPackingTypeServiceDto;
import com.pro.scm.servicedto.LoadScheduleServiceDto;
import com.pro.scm.wrappers.AllApprovalItemListWrapper;
import com.pro.scm.wrappers.AllIndentDetailsWrapper;
import com.pro.scm.wrappers.AllPurchaseOrdersByMesserIdWrapper;
import com.pro.scm.wrappers.DrugRegistrationWrapper;
import com.pro.scm.wrappers.ExpiryDrugsWrapper;
import com.pro.scm.wrappers.GenerateNewDrugBarcodeWrapper;
import com.pro.scm.wrappers.LoadGenericNamesWrapper;
import com.pro.scm.wrappers.LoadMaterialFormWrapper;
import com.pro.scm.wrappers.LoadPackingTypeWrapper;
import com.pro.scm.wrappers.LoadScheduleWrapper;
import com.pro.scm.wrappers.RejectIndentwrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("drugRegisteringService")
@Slf4j
public class DrugRegisteringController {

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
	 * @Des : saveDrugDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/saveDrugDetails
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveDrugDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveDrugDetails(@RequestBody SaveDrugDetailsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("saveDrugDetails method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		Save_vehicle_indent_detailsMapper mapper = new Save_vehicle_indent_detailsMapper();
		SaveDrugDetailsMapper saveDrugDetailsMapper = new SaveDrugDetailsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getDrugName() != null && objControllerDto.getBrand_id() != null
				&& objControllerDto.getManufaturer_id() != null && objControllerDto.getForm_id() != null
				&& objControllerDto.getMinmum_level_qty() != null && objControllerDto.getMaximum_lel_qty() != null
				&& objControllerDto.getShort_unic_code() != null && objControllerDto.getExpire_alert() != null
				&& objControllerDto.getCreatedbyid() != null && objControllerDto.getCreatedbyroleid() != null
				&& objControllerDto.getCreatedbymoduleid() != null && objControllerDto.getStrength_type() != null
				&& objControllerDto.getSystem_id() != null && objControllerDto.getGenric_group_id() != null
				&& objControllerDto.getGenric_molecules_id() != null && objControllerDto.getPackId() != null
				&& objControllerDto.getScheduleid() != null && objControllerDto.getVehicleReorderqty() != null
				&& objControllerDto.getVehicleMinqty() != null && objControllerDto.getMaterialGroupformid() != null
				&& objControllerDto.getGenericid() != null && objControllerDto.getMinsaleqty() != null
				&& objControllerDto.getBarcode() != null && objControllerDto.getSubStoreMinLevelQty() != null
				&& objControllerDto.getSubStoreMaxLevelQty() != null && objControllerDto.getDescription() != null) {
			String rtnValueOfMT = drugRegisteringService.saveDrugDetails(
					saveDrugDetailsMapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : saveDrugDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/updateDrugDetails
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateDrugDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateDrugDetails(@RequestBody SaveDrugDetailsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("saveDrugDetails method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		Save_vehicle_indent_detailsMapper mapper = new Save_vehicle_indent_detailsMapper();
		SaveDrugDetailsMapper saveDrugDetailsMapper = new SaveDrugDetailsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		System.out.println("getVehicleReorderqty ::"+objControllerDto.getVehicleReorderqty());
		System.out.println("@@@@@@@@@@@@@@@@@@getVehicleMinqty ::"+objControllerDto.getVehicleMinqty());
		
		if (objControllerDto.getDrugId() != null && objControllerDto.getDrugName() != null
				&& objControllerDto.getBrand_id() != null && objControllerDto.getManufaturer_id() != null
				&& objControllerDto.getForm_id() != null && objControllerDto.getMinmum_level_qty() != null
				&& objControllerDto.getMaximum_lel_qty() != null && objControllerDto.getShort_unic_code() != null
				&& objControllerDto.getExpire_alert() != null && objControllerDto.getCreatedbyid() != null
				&& objControllerDto.getCreatedbyroleid() != null && objControllerDto.getCreatedbymoduleid() != null
				&& objControllerDto.getStrength_type() != null && objControllerDto.getSystem_id() != null
				&& objControllerDto.getGenric_group_id() != null && objControllerDto.getGenric_molecules_id() != null
				&& objControllerDto.getPackId() != null && objControllerDto.getScheduleid() != null
				&& objControllerDto.getVehicleReorderqty() != null && objControllerDto.getVehicleMinqty() != null
				&& objControllerDto.getMaterialGroupformid() != null && objControllerDto.getGenericid() != null
				&& objControllerDto.getMinsaleqty() != null && objControllerDto.getBarcode() != null
				&& objControllerDto.getSubStoreMinLevelQty() != null
				&& objControllerDto.getSubStoreMaxLevelQty() != null && objControllerDto.getDescription() != null) {
			String rtnValueOfMT = drugRegisteringService.UpdateDrugDetails(
					saveDrugDetailsMapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : loadPackingType
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/loadPackingType
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadPackingType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadPackingType(@RequestBody LoadPackingTypeControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadPackingType method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadPackingTypeMapper mapper = new LoadPackingTypeMapper();
		LoadPackingTypeWrapper wrapper = new LoadPackingTypeWrapper();
		if (objControllerDto.getMaterialid() != null) {
			List<LoadPackingTypeServiceDto> scmLoginServiceDto = drugRegisteringService
					.loadPackingType(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(scmLoginServiceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : loadMaterialForm
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/loadMaterialForm
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadMaterialForm", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadMaterialForm(@RequestBody LoadMaterialFormControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadMaterialForm method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadMaterialFormMapper mapper = new LoadMaterialFormMapper();
		LoadMaterialFormWrapper wrapper = new LoadMaterialFormWrapper();
		if (objControllerDto.getMaterialid() != null) {
			List<LoadMaterialFormServiceDto> scmLoginServiceDto = drugRegisteringService
					.loadMaterialForm(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(scmLoginServiceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	// loadGenericNames

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : loadMaterialForm
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/loadGenericNames
	 */
	@RequestMapping(value = "/loadGenericNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadGenericNames() throws InSufficientInputException, DataNotFoundException {
		log.info("loadMaterialForm method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data With RequestId=" + strRequestID);
		LoadGenericNamesWrapper wrapper = new LoadGenericNamesWrapper();
		List<LoadGenericNamesServiceDto> scmLoginServiceDto = drugRegisteringService.loadGenericNames(strRequestID);
		wrapper.setObjControllerDto(
				new LoadGenericNamesMapper().conversionForServiceTOControllerDTO(scmLoginServiceDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	//

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : loadMaterialForm
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/generate_new_drug_barcode
	 */
	@RequestMapping(value = "/generate_new_drug_barcode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response generate_new_drug_barcode(@RequestBody GenerateNewDrugBarcodeControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadMaterialForm method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		GenerateNewDrugBarcodeMapper mapper = new GenerateNewDrugBarcodeMapper();
		GenerateNewDrugBarcodeWrapper wrapper = new GenerateNewDrugBarcodeWrapper();
		System.out.println("*******************=" + objControllerDto.getGroupId());
		System.out.println("*******************=" + objControllerDto.getShortCode());

if (objControllerDto.getGenericId() != null && objControllerDto.getGenericName() != null) {
			
			List<GenerateNewDrugBarcodeServiceDto> generateNewDrugBarcodeServiceDto = drugRegisteringService
					.generate_new_drug_barcode(mapper.conversionControllerDtoToServiceDto(objControllerDto),
							strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(generateNewDrugBarcodeServiceDto));
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
	 * @Date : 31-07-2019
	 * @Des : loadMaterialForm
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/loadSchedule
	 */
	@RequestMapping(value = "/loadSchedule", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSchedule() throws InSufficientInputException, DataNotFoundException {
		log.info("loadMaterialForm method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadScheduleWrapper wrapper = new LoadScheduleWrapper();
		List<LoadScheduleServiceDto> generateNewDrugBarcodeServiceDto = drugRegisteringService
				.loadSchedule(strRequestID);
		wrapper.setObjControllerDto(
				new LoadScheduleMapper().conversionForServiceTOControllerDTO(generateNewDrugBarcodeServiceDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
//

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : loadMaterialGroup
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/loadMaterialGroup
	 */
	@RequestMapping(value = "/loadMaterialGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadMaterialGroup() throws InSufficientInputException, DataNotFoundException {
		log.info("loadMaterialForm method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadScheduleWrapper wrapper = new LoadScheduleWrapper();
		List<LoadScheduleServiceDto> generateNewDrugBarcodeServiceDto = drugRegisteringService
				.loadMaterialGroup(strRequestID);
		wrapper.setObjControllerDto(
				new LoadScheduleMapper().conversionForServiceTOControllerDTO(generateNewDrugBarcodeServiceDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	//
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : saveDrugDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/updateActiveDrugForRejectApproval
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateActiveDrugForRejectApproval", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateActiveDrugForRejectApproval(
			@RequestBody UpdateActiveDrugForRejectApprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("updateActiveDrugForRejectApproval method is executed inside DrugRegisteringController"
				+ objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		UpdateActiveDrugForRejectApprovalMapper mapper = new UpdateActiveDrugForRejectApprovalMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getApprovalId() != null && objControllerDto.getDrugIds() != null
				&& objControllerDto.getDrugTypeId() != null && objControllerDto.getSize() != null
				&& objControllerDto.getUserId() != null) {
			String rtnValueOfMT = drugRegisteringService.updateActiveDrugForRejectApproval(
					mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
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
	 * @Date : 31-07-2019
	 * @Des : strIndentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/strIndentDetails
	 */
	@CrossOrigin
	@RequestMapping(value = "/strIndentDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response strIndentDetails(@RequestBody UpdateActiveDrugForRejectApprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("IndentDetails method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		UpdateActiveDrugForRejectApprovalMapper mapper = new UpdateActiveDrugForRejectApprovalMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getIntIndentId() != null) {

			String rtnValueOfMT = drugRegisteringService
					.strIndentDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
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
	 * @Date : 31-07-2019
	 * @Des : strIndentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/updateIndentDetails
	 */
	@RequestMapping(value = "/updateIndentDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateIndentDetails(@RequestBody UpdateActiveDrugForRejectApprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("IndentDetails method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		UpdateActiveDrugForRejectApprovalMapper mapper = new UpdateActiveDrugForRejectApprovalMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getIntIndentId() != null && objControllerDto.getQuantity() != null
				&& objControllerDto.getCount() != null && objControllerDto.getUserId() != null
				&& objControllerDto.getRoleId() != null && objControllerDto.getModuleId() != null
				&& objControllerDto.getDrugIds() != null) {
			String rtnValueOfMT = drugRegisteringService
					.updateIndentDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	// updateIndentDetails

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : updateIndentItemsRejected
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/updateIndentItemsRejected
	 */
	@RequestMapping(value = "/updateIndentItemsRejected", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateIndentItemsRejected(
			@RequestBody UpdateActiveDrugForRejectApprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("updateIndentItemsRejected method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		UpdateActiveDrugForRejectApprovalMapper mapper = new UpdateActiveDrugForRejectApprovalMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getIntIndentId() != null && objControllerDto.getItemId() != null
				&& objControllerDto.getCount() != null && objControllerDto.getUserId() != null
				&& objControllerDto.getRoleId() != null && objControllerDto.getModuleId() != null
				&& objControllerDto.getRemarks() != null) {
			String rtnValueOfMT = drugRegisteringService.updateIndentItemsRejected(
					mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : updateIndentReject
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/updateIndentReject
	 */
	@RequestMapping(value = "/updateIndentReject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateIndentReject(@RequestBody UpdateActiveDrugForRejectApprovalControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("updateIndentItemsRejected method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		UpdateActiveDrugForRejectApprovalMapper mapper = new UpdateActiveDrugForRejectApprovalMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getIntIndentId() != null && objControllerDto.getCount() != null
				&& objControllerDto.getUserId() != null && objControllerDto.getRoleId() != null
				&& objControllerDto.getModuleId() != null && objControllerDto.getRemarks() != null) {
			String rtnValueOfMT = drugRegisteringService
					.updateIndentReject(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : allApprovalItemList
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/allApprovalItemList
	 */
	@RequestMapping(value = "/allApprovalItemList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response allApprovalItemList(@RequestBody AllApprovalItemListControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("allApprovalItemList method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AllApprovalItemListMapper mapper = new AllApprovalItemListMapper();
		AllApprovalItemListWrapper wrapper = new AllApprovalItemListWrapper();
		if (objControllerDto.getIndentId() != null) {
			List<AllApprovalItemListServiceDto> generateNewDrugBarcodeServiceDto = drugRegisteringService
					.allApprovalItemList(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(generateNewDrugBarcodeServiceDto));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : getAllIndentDetails
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/getAllIndentDetails
	 */
	@RequestMapping(value = "/getAllIndentDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllIndentDetails() throws InSufficientInputException, DataNotFoundException {
		log.info("getAllIndentDetails method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data With RequestId=" + strRequestID);
		AllIndentDetailsWrapper wrapper = new AllIndentDetailsWrapper();
		List<AllIndentDetailsServiceDto> generateNewDrugBarcodeServiceDto = drugRegisteringService
				.getAllIndentDetails(strRequestID);
		wrapper.setObjControllerDto(
				new AllIndentDetailsMapper().conversionForServiceTOControllerDTO(generateNewDrugBarcodeServiceDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : allPurchaseOrdersByMesserId
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/allPurchaseOrdersByMesserId
	 */
	@RequestMapping(value = "/allPurchaseOrdersByMesserId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response allPurchaseOrdersByMesserId(@RequestBody AllPurchaseOrdersByMesserIdControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("allApprovalItemList method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AllPurchaseOrdersByMesserIdMapper mapper = new AllPurchaseOrdersByMesserIdMapper();
		AllPurchaseOrdersByMesserIdWrapper wrapper = new AllPurchaseOrdersByMesserIdWrapper();
		if (objControllerDto.getMesserId() != null) {
			List<AllPurchaseOrdersByMesserIdServiceDto> generateNewDrugBarcodeServiceDto = drugRegisteringService
					.allPurchaseOrdersByMesserId(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(generateNewDrugBarcodeServiceDto));
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
	 * @Date : 01-08-2019
	 * @Des : getMesserAddress
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/api/version_1/getMesserAddress
	 */
	@RequestMapping(value = "/getMesserAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getMesserAddress(@RequestBody MesserAddressControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("updateIndentItemsRejected method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		UpdateActiveDrugForRejectApprovalMapper mapper = new UpdateActiveDrugForRejectApprovalMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getMesserId()!= null) {
			String rtnValueOfMT = drugRegisteringService
					.getMesserAddress(new MesserAddressMapper().conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	
	//getAllActiveInactiveCount
	
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : getMesserAddress
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/getAllActiveInactiveCount
	 */
	@CrossOrigin
	@RequestMapping(value = "/getAllActiveInactiveCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllActiveInactiveCount(@RequestBody DrugRegistrationControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getAllActiveInactiveCount method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getActveOrInActieId()!= null &&objControllerDto.getBrandId()!= null
				&&objControllerDto.getGenericGroupId()!= null&&objControllerDto.getGenericMoleculeId()!= null
				&&objControllerDto.getGenericName()!= null&&objControllerDto.getManufacfuredId()!= null
				&&objControllerDto.getMatrialFromId()!= null&&objControllerDto.getUniCode()!= null
				&&objControllerDto.getSystemId()!= null
				) {
			String rtnValueOfMT = drugRegisteringService
					.getAllActiveInactiveCount(new DrugRegistrationMapper().converControllerToServiceDTO(objControllerDto), strRequestID);
			if (rtnValueOfMT != null) {
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				wrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	
	
	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 01-08-2019
	 * @Des : getMesserAddress
	 * @URL :
	 *      http://localhost:2000/scmservice/drugRegisteringService/getAllActiveInactive
	 */
	@CrossOrigin
	@RequestMapping(value = "/getAllActiveInactive", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllActiveInactive(@RequestBody DrugRegistrationControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getAllActiveInactiveCount method is executed inside DrugRegisteringController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		DrugRegistrationWrapper wrapper = new DrugRegistrationWrapper();
		
		DrugRegistrationMapper mapper =	new DrugRegistrationMapper();
		if (objControllerDto.getActveOrInActieId()!= null &&objControllerDto.getBrandId()!= null
				&&objControllerDto.getGenericGroupId()!= null&&objControllerDto.getGenericMoleculeId()!= null
				&&objControllerDto.getGenericName()!= null&&objControllerDto.getManufacfuredId()!= null
				&&objControllerDto.getMatrialFromId()!= null&&objControllerDto.getUniCode()!= null
				&&objControllerDto.getSystemId()!= null
				) {
			List<DrugRegistrationServiceDto> listOfData = drugRegisteringService
					.getAllActiveInactive(mapper.converControllerToServiceDTO(objControllerDto), strRequestID);
				wrapper.setResponseCode(HttpStatus.OK.value());
				wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(listOfData));
		} else {
			wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
	
	


	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @Des : listloadSuppliers
	 * @URL :
	 *      http://localhost:2000/scmservice/drugAndSupplierMappingController/rejectIndentData
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/rejectIndentData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Response rejectIndentData(@RequestBody RejectIndentDataControllerDto controllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("rejectIndentData method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		RejectIndentMapper mapper = new RejectIndentMapper();
		RejectIndentwrapper wrapper = new RejectIndentwrapper();
		
		//serviceDto.() + "','" + serviceDto.()
		
		if (controllerDto.getIndentid() != null
				) {
			String rtnStatus = drugRegisteringService
					.rejectIndentData(mapper.converControllerToServiceDTO(controllerDto), strRequestID);
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

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
import com.pro.scm.controllerdto.AdjustmentSearchControllerDTO;
import com.pro.scm.controllerdto.ExpiryDrugsControllerDto;
import com.pro.scm.controllerdto.LoadBaselocationsControllerDto;
import com.pro.scm.controllerdto.LoadReturnDrugsControllerDto;
import com.pro.scm.controllerdto.LoadSubStoreControllerDto;
import com.pro.scm.controllerdto.LoadVehicleTransferItemsControllerDto;
import com.pro.scm.controllerdto.LoadVehiclesControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SaveUpdateItemsControllerDto;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AjustmentSearchMapper;
import com.pro.scm.mappers.ExpiryDrugsMapper;
import com.pro.scm.mappers.GetUserDropdownMapper;
import com.pro.scm.mappers.ListOfLoadSuppliersMapper;
import com.pro.scm.mappers.LoadAdjustmentTypeMapper;
import com.pro.scm.mappers.LoadBaselocationsMapper;
import com.pro.scm.mappers.LoadExpiryDrugsMapper;
import com.pro.scm.mappers.LoadReturnDrugsMapper;
import com.pro.scm.mappers.LoadStoresMapper;
import com.pro.scm.mappers.LoadSubStoreMapper;
import com.pro.scm.mappers.LoadVehicleTransferItemsMapper;
import com.pro.scm.mappers.LoadVehiclesMapper;
import com.pro.scm.mappers.LoadZonesMapper;
import com.pro.scm.mappers.SaveUpdateItemsMapper;
import com.pro.scm.service.ExpiryDrugsService;
import com.pro.scm.servicedto.AdjustmentSearchServiceDTO;
import com.pro.scm.servicedto.GetUserDropdownServiceDTO;
import com.pro.scm.servicedto.ListOfLoadSuppliersServiceDto;
import com.pro.scm.servicedto.LoadAdjustmentTypeServiceDto;
import com.pro.scm.servicedto.LoadBaselocationsServiceDto;
import com.pro.scm.servicedto.LoadExpiryDrugsServiceDto;
import com.pro.scm.servicedto.LoadReturnDrugsServiceDto;
import com.pro.scm.servicedto.LoadStoresServiceDto;
import com.pro.scm.servicedto.LoadSubStoreServiceDto;
import com.pro.scm.servicedto.LoadVehicleTransferItemsServiceDto;
import com.pro.scm.servicedto.LoadVehiclesServiceDto;
import com.pro.scm.servicedto.LoadZonesServiceDto;
import com.pro.scm.wrappers.AdjustmentSearchWrapper;
import com.pro.scm.wrappers.ExpiryDrugsWrapper;
import com.pro.scm.wrappers.GetUsersDropdownWrapper;
import com.pro.scm.wrappers.ListOfLoadSuppliersWrapper;
import com.pro.scm.wrappers.LoadAdjustmentTypeWrapper;
import com.pro.scm.wrappers.LoadBaselocationsWrapper;
import com.pro.scm.wrappers.LoadExpiryDrugsWrapper;
import com.pro.scm.wrappers.LoadReturnDrugsWrapper;
import com.pro.scm.wrappers.LoadStoresWrapper;
import com.pro.scm.wrappers.LoadSubStoreWrapper;
import com.pro.scm.wrappers.LoadVehicleTransferItemsWrapper;
import com.pro.scm.wrappers.LoadVehiclesWrapper;
import com.pro.scm.wrappers.LoadZonesWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/expiryDrugsController")
@Slf4j
public class ExpiryDrugsController {

	InSufficientInputException obj;
	@Autowired
	@Qualifier("expiryDrugsService")
	private ExpiryDrugsService expiryDrugsService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : getVehicleMappingStatus
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/api/version_1/getVehicleMappingStatus
	 */
	@RequestMapping(value = "/api/version_1/getVehicleMappingStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getVehicleMappingStatus(@RequestBody ExpiryDrugsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ExpiryDrugsMapper mapper = new ExpiryDrugsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();

		System.out.println("objControllerDto.getStoreTypeId()=" + objControllerDto.getStoreTypeId());
		if (objControllerDto.getStoreTypeId() != null) {
			String rtnValueOfMT = expiryDrugsService.getVehicleMappingStatus(
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

	// saveReturnDrugs

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 29-07-2019
	 * @Des : saveReturnDrugs
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/api/version_1/saveReturnDrugs
	 */
	@RequestMapping(value = "/api/version_1/saveReturnDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveReturnDrugs(@RequestBody ExpiryDrugsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ExpiryDrugsMapper mapper = new ExpiryDrugsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		if (objControllerDto.getDrugid() != null && objControllerDto.getBillNumbeer() != null
				&& objControllerDto.getBatchcod() != null && objControllerDto.getExpdate() != null
				&& objControllerDto.getReturstc() != null && objControllerDto.getFormid() != null
				&& objControllerDto.getSupplerid() != null && objControllerDto.getUserid() != null
				&& objControllerDto.getModuleid() != null && objControllerDto.getRoleid() != null
				&& objControllerDto.getReturnType() != null && objControllerDto.getStoreid() != null) {
			String rtnValueOfMT = expiryDrugsService
					.saveReturnDrugs(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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

	/*
	 * stringBuilder.
	 * append("select * from sp_update_pms_adjustable_trans_returns_type(")
	 * .append(expiryDrugsServiceDto.getStoreid()).append(",").append(
	 * expiryDrugsServiceDto.getTypeid())
	 * .append(",").append(expiryDrugsServiceDto.getStatusid()).append(",")
	 * .append(expiryDrugsServiceDto.getSupplerid()).append(")");
	 */

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 11-08-2020
	 * @Des : updateAdjustmentStatus
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/api/version_1/updateAdjustmentStatus
	 */

	@RequestMapping(value = "/api/version_1/updateAdjustmentStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateAdjustmentStatus(@RequestBody ExpiryDrugsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		ExpiryDrugsMapper mapper = new ExpiryDrugsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();

		System.out.println("objControllerDto.getDrug_idlist() " + objControllerDto.getDrug_idlist());
		System.out.println("objControllerDto.getDrug_batchlist() " + objControllerDto.getDrug_batchlist());
		System.out.println("objControllerDto.getSize() " + objControllerDto.getSize());
		System.out.println("objControllerDto.getTypeid() " + objControllerDto.getTypeid());
		System.out.println("objControllerDto.getSupplerid() " + objControllerDto.getIntSerialId());

		if (objControllerDto.getDrug_idlist() != null && 
				objControllerDto.getDrug_batchlist() != null
				&& objControllerDto.getSize() != null 
				&& objControllerDto.getTypeid() != null
				&& objControllerDto.getIntSerialId() != null
				) {
			String rtnValueOfMT = expiryDrugsService
					.updateAdjustmentStatus(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Date : 26-07-2019
	 * @Des : LoadExpiryDrugs
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/api/version_1/LoadExpiryDrugs
	 * 
	 */
	@RequestMapping(value = "/api/version_1/LoadExpiryDrugs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response LoadExpiryDrugs() throws InSufficientInputException, DataNotFoundException {
		log.info("LoadExpiryDrugs method is executed inside ExpiryDrugsController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadExpiryDrugsMapper mapper = new LoadExpiryDrugsMapper();
		LoadExpiryDrugsWrapper wrapper = new LoadExpiryDrugsWrapper();
		List<LoadExpiryDrugsServiceDto> loadExpiryDrugsServiceDtos = expiryDrugsService.LoadExpiryDrugs(strRequestID);
		wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadExpiryDrugsServiceDtos));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : LoadReturnDrugs
	 * @URL : http://localhost:2000/scmservice/expiryDrugsController/LoadReturnDrugs
	 */
	@RequestMapping(value = "/LoadReturnDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response LoadReturnDrugs(@RequestBody LoadReturnDrugsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("LoadReturnDrugs method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadReturnDrugsMapper mapper = new LoadReturnDrugsMapper();
		LoadReturnDrugsWrapper wrapper = new LoadReturnDrugsWrapper();
		if (objControllerDto.getStoreId() != null && objControllerDto.getAdjId() != null
				&& objControllerDto.getTypeId() != null && objControllerDto.getSuplierId() != null) {
			List<LoadReturnDrugsServiceDto> loadReturnDrugsServiceDtos = expiryDrugsService
					.LoadReturnDrugs(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadReturnDrugsServiceDtos));
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
	 * @Date : 26-07-2019
	 * @Des : load_zones
	 * @URL : http://localhost:2000/scmservice/expiryDrugsController/load_zones
	 * 
	 */
	@RequestMapping(value = "/load_zones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response load_zones() throws InSufficientInputException, DataNotFoundException {
		log.info("LoadExpiryDrugs method is executed inside ExpiryDrugsController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadZonesWrapper wrapper = new LoadZonesWrapper();
		List<LoadZonesServiceDto> loadExpiryDrugsServiceDtos = expiryDrugsService.load_zones(strRequestID);
		wrapper.setObjControllerDto(
				new LoadZonesMapper().conversionForServiceTOControllerDTO(loadExpiryDrugsServiceDtos));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : load_baselocations
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/load_baselocations
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/load_baselocations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response load_baselocations(@RequestBody LoadBaselocationsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("load_baselocations method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadBaselocationsMapper mapper = new LoadBaselocationsMapper();
		LoadBaselocationsWrapper wrapper = new LoadBaselocationsWrapper();
		if (objControllerDto.getZoneId() != null) {
			List<LoadBaselocationsServiceDto> loadReturnDrugsServiceDtos = expiryDrugsService
					.load_baselocations(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadReturnDrugsServiceDtos));
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
	 * @Date : 26-07-2019
	 * @Des : load_baselocations
	 * @URL : http://localhost:2000/scmservice/expiryDrugsController/load_vehicles
	 * 
	 */

	@RequestMapping(value = "/load_vehicles", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response load_vehicles(@RequestBody LoadVehiclesControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("load_baselocations method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadVehiclesMapper mapper = new LoadVehiclesMapper();
		LoadVehiclesWrapper wrapper = new LoadVehiclesWrapper();

		if (objControllerDto.getBaselocation() != null) {
			List<LoadVehiclesServiceDto> loadVehiclesServiceDtos = expiryDrugsService
					.load_vehicles(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(loadVehiclesServiceDtos));
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
	 * @Date : 26-07-2019
	 * @Des : load_baselocations
	 * @URL : http://localhost:2000/scmservice/expiryDrugsController/loadSubStore
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadSubStore", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSubStore(@RequestBody LoadSubStoreControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadSubStore method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadSubStoreMapper mapper = new LoadSubStoreMapper();
		LoadSubStoreWrapper wrapper = new LoadSubStoreWrapper();
		if (objControllerDto.getSupStoreTypeId() != null) {
			List<LoadSubStoreServiceDto> subStoreServiceDtos = expiryDrugsService
					.loadSubStore(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjControllerDto(mapper.conversionForServiceTOControllerDTO(subStoreServiceDtos));
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
	 * @Date : 26-07-2019
	 * @Des : loadAdjustmentType
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/loadAdjustmentType
	 * 
	 */
	@RequestMapping(value = "/loadAdjustmentType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadAdjustmentType() throws InSufficientInputException, DataNotFoundException {
		log.info("loadAdjustmentType method is executed inside ExpiryDrugsController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadAdjustmentTypeWrapper loadAdjustmentTypeWrapper = new LoadAdjustmentTypeWrapper();
		List<LoadAdjustmentTypeServiceDto> loadAdjustmentTypeServiceDtos = expiryDrugsService
				.loadAdjustmentType(strRequestID);
		loadAdjustmentTypeWrapper.setObjControllerDto(
				new LoadAdjustmentTypeMapper().conversionForServiceTOControllerDTO(loadAdjustmentTypeServiceDtos));
		loadAdjustmentTypeWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		loadAdjustmentTypeWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + loadAdjustmentTypeWrapper.toString());
		return loadAdjustmentTypeWrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : loadStores
	 * @URL : http://localhost:2000/scmservice/expiryDrugsController/loadStores
	 * 
	 */
	@RequestMapping(value = "/loadStores", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadStores() throws InSufficientInputException, DataNotFoundException {
		log.info("loadStores method is executed inside ExpiryDrugsController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadStoresWrapper loadStoresWrapper = new LoadStoresWrapper();
		List<LoadStoresServiceDto> loadStoresServiceDtos = expiryDrugsService.loadStores(strRequestID);
		loadStoresWrapper
				.setObjControllerDto(new LoadStoresMapper().conversionForServiceTOControllerDTO(loadStoresServiceDtos));
		loadStoresWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		loadStoresWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + loadStoresWrapper.toString());
		return loadStoresWrapper;
	}

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : ListOfLoad
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/api/version_1/ListOfLoad
	 * 
	 */

	@RequestMapping(value = "/api/version_1/ListOfLoad", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response ListOfLoad() throws InSufficientInputException, DataNotFoundException {
		log.info("loadStores method is executed inside ExpiryDrugsController");
		String strRequestID = request.getAttribute("reqid").toString();
		ListOfLoadSuppliersWrapper loadStoresWrapper = new ListOfLoadSuppliersWrapper();
		List<ListOfLoadSuppliersServiceDto> loadStoresServiceDtos = expiryDrugsService.ListOfLoad(strRequestID);
		loadStoresWrapper.setObjControllerDto(
				new ListOfLoadSuppliersMapper().conversionForServiceTOControllerDTO(loadStoresServiceDtos));
		loadStoresWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		loadStoresWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + loadStoresWrapper.toString());
		return loadStoresWrapper;
	}
//

	/**
	 * @author : Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 26-07-2019
	 * @Des : getVehicleMappingStatus
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/api/version_1/saveUpdateItems
	 */
	@RequestMapping(value = "/api/version_1/saveUpdateItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveUpdateItems(@RequestBody SaveUpdateItemsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("saveUpdateItems method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		SaveUpdateItemsMapper mapper = new SaveUpdateItemsMapper();
		ExpiryDrugsWrapper wrapper = new ExpiryDrugsWrapper();
		System.out.println("objControllerDto.getStoreTypeId()=" + objControllerDto.getStoreid());

		if (objControllerDto.getModuleId() != null && objControllerDto.getRackname() != null
				&& objControllerDto.getRoleId() != null && objControllerDto.getStatus() != null
				&& objControllerDto.getStoreid() != null && objControllerDto.getUserId() != null) {
			String rtnValueOfMT = expiryDrugsService
					.saveUpdateItems(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Date : 26-07-2019
	 * @Des : load_baselocations
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/loadVehicleTransferItems
	 * 
	 */
	@RequestMapping(value = "/loadVehicleTransferItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadVehicleTransferItems(@RequestBody LoadVehicleTransferItemsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("LoadVehicleTransferItemsServiceDto method is executed inside ExpiryDrugsController"
				+ objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		LoadVehicleTransferItemsMapper mapper = new LoadVehicleTransferItemsMapper();
		LoadVehicleTransferItemsWrapper wrapper = new LoadVehicleTransferItemsWrapper();
		if (objControllerDto.getVehicleid() != null) {
			List<LoadVehicleTransferItemsServiceDto> vehicleTransferItemsServiceDtos = expiryDrugsService
					.loadVehicleTransferItems(mapper.conversionControllerDtoToServiceDto(objControllerDto),
							strRequestID);
			wrapper.setVehicleTransferItemsControllerDtos(
					mapper.conversionForServiceTOControllerDTO(vehicleTransferItemsServiceDtos));
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
	 * @Date : 20/04/2020
	 * @Des : loadSuppliers
	 * @URL : http://localhost:2000/scmservice/expiryDrugsController/loadSuppliers
	 * 
	 */

	@RequestMapping(value = "/loadSuppliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSuppliers() throws InSufficientInputException, DataNotFoundException {
		log.info("loadSuppliers method is executed inside ExpiryDrugsController");
		String strRequestID = request.getAttribute("reqid").toString();
		ListOfLoadSuppliersWrapper loadStoresWrapper = new ListOfLoadSuppliersWrapper();
		List<ListOfLoadSuppliersServiceDto> loadStoresServiceDtos = expiryDrugsService.loadSuppliers(strRequestID);
		loadStoresWrapper.setObjControllerDto(
				new ListOfLoadSuppliersMapper().conversionForServiceTOControllerDTO(loadStoresServiceDtos));
		loadStoresWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		loadStoresWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + loadStoresWrapper.toString());
		return loadStoresWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 23-04-2020
	 * @Des : loadUsers
	 * @URL : http://localhost:2000/scmservice/expiryDrugsController/loadUsers
	 * 
	 */
	@RequestMapping(value = "/loadUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadUsers() throws InSufficientInputException, DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();
		GetUsersDropdownWrapper loadStoresWrapper = new GetUsersDropdownWrapper();
		List<GetUserDropdownServiceDTO> loadStoresServiceDtos = expiryDrugsService.loadUsers(strRequestID);
		loadStoresWrapper.setObjGetUserDropdownControllerDTO(
				new GetUserDropdownMapper().conversionForServiceTOControllerDTO(loadStoresServiceDtos));
		loadStoresWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		loadStoresWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + loadStoresWrapper.toString());
		return loadStoresWrapper;
	}

	/**
	 * @author : Habiboon Patan
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 23-04-2020
	 * @Des : adjustmentSearch
	 * @URL :
	 *      http://localhost:2000/scmservice/expiryDrugsController/adjustmentSearch
	 *      {
	 * 
	 *      "drug_name":"", "brand_id":"", "form_id":"", "manufacture_id":"",
	 *      "unicode":"", "system_id":"", "generic_group_id":"",
	 *      "generic_molecules_id":"", "counter_id":"", "type_id":"" }
	 * 
	 */
	@RequestMapping(value = "/adjustmentSearch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response adjustmentSearch(@RequestBody AdjustmentSearchControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadSubStore method is executed inside ExpiryDrugsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AjustmentSearchMapper mapper = new AjustmentSearchMapper();
		AdjustmentSearchWrapper wrapper = new AdjustmentSearchWrapper();

		List<AdjustmentSearchServiceDTO> subStoreServiceDtos = expiryDrugsService
				.adjustmentSearch(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
		wrapper.setObjAdjustmentSearchControllerDTO(mapper.conversionForServiceTOControllerDTO(subStoreServiceDtos));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}
}

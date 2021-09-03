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

import com.pro.scm.controllerdto.CentralCloseControllerDTO;
import com.pro.scm.controllerdto.IndentDetailsControllerDTO;
import com.pro.scm.controllerdto.PharmacyNewDrugQtyControllerDto;
import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.UpdateDrugDetailsControllerDTO;
import com.pro.scm.controllerdto.VehicleTypeDrugsControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.BrandDetailsMapper;
import com.pro.scm.mappers.BrandNameMapper;
import com.pro.scm.mappers.CentralCloseMapper;
import com.pro.scm.mappers.IndentDetailsMapper;
import com.pro.scm.mappers.ManufactureCompanyMapper;
import com.pro.scm.mappers.ManufactureFormMapper;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.mappers.SearchDrugMapper;
import com.pro.scm.mappers.UpdateDrugDetailsMapper;
import com.pro.scm.mappers.VehicleTypeDrugMapper;
import com.pro.scm.service.MasterDataService;
import com.pro.scm.service.PlacingOrdersForPurchaseService;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.servicedto.CentralCloseServiceDTO;
import com.pro.scm.servicedto.IndentDetailsServiceDTO;
import com.pro.scm.servicedto.ManufactureCompanyServiceDTO;
import com.pro.scm.servicedto.ManufactureFormServiceDTO;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;
import com.pro.scm.utills.IsEmptyUtil;
import com.pro.scm.wrappers.BrandDetailsWrapper;
import com.pro.scm.wrappers.BrandNameWrapper;
import com.pro.scm.wrappers.CentralCloseWrapper;
import com.pro.scm.wrappers.IndentDetailsWrapper;
import com.pro.scm.wrappers.ManufactureCompanyWrapper;
import com.pro.scm.wrappers.ManufactureFormWrapper;
import com.pro.scm.wrappers.PlacingOrdersForPurchaseWrapper;
import com.pro.scm.wrappers.SearchDrugWrapper;
import com.pro.scm.wrappers.UpdateDetailsWrapper;
import com.pro.scm.wrappers.VehicleWiseDrugWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Habiboon Patan
 * @since 29.07.2019
 * @Des : PlacingOrdersForPurchaseController
 */

@Slf4j
@RestController
@RequestMapping("/PlacingOrdersForPurchaseController")
public class PlacingOrdersForPurchaseController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	@Qualifier("objPlacingOrdersForPurchaseServiceImpl")
	private PlacingOrdersForPurchaseService objPlacingOrdersForPurchaseServiceImpl;

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : savePurchaseOrderItemDetails
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/savePurchaseOrderItemDetails
	 * 
	 *      { "poId":1, "supplierId":"1", "drugidlist":1, "quantitylist":1,
	 *      "indentidlist":1, "formlist":1,
	 * 
	 *      "strenghtlist":1, "count":1, "userId":1, "moduleId":1, "roleId":1
	 * 
	 * 
	 * 
	 *      }
	 */
	@CrossOrigin
	@RequestMapping(value = "/savePurchaseOrderItemDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response savePurchaseOrderItemDetails(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::savePurchaseOrderItemDetails:::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getPoId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSupplierId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugidList())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getQuantitylist())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getIndentidlist())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFormlist())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getStrenghtlist())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPlacingOrdersForPurchaseServiceImpl.savePurchaseOrderItemDetails(dataInfo,
					strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::savePurchaseOrderItemDetails()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * 
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getAllSuppliers
	 * @Parameters :NO
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getAllSuppliers
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/getAllSuppliers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllSuppliers() throws DataNotFoundException {
		String requestID = (String) request.getAttribute("sessionid");
		log.info(
				requestID + ":::::::::::::::::::::::::::::getAllSuppliers()::::::::::::::::::::::::::::::::::::::::::");
		PlacingOrdersForPurchaseWrapper objPlacingOrdersForPurchaseWrapper = new PlacingOrdersForPurchaseWrapper();

		List<PlacingOrdersForPurchaseServiceDTO> datas = objPlacingOrdersForPurchaseServiceImpl
				.getAllSuppliers(requestID);
		objPlacingOrdersForPurchaseWrapper.setPlacingOrdersForPurchaseControllerDTO(
				new PlacingOrdersForPurchaseMapper().conversionForServiceTOControllerDTO(datas));
		objPlacingOrdersForPurchaseWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objPlacingOrdersForPurchaseWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT:::::::::::::getAllSuppliers()::::::::::::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseWrapper.toString());
		return objPlacingOrdersForPurchaseWrapper;

	}

	/**
	 * 
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getReturnDrugDetailsByDrugId
	 * @Parameters :drugidId
	 * @URL :localhost:
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getReturnDrugDetailsByDrugId
	 * @Parameters :{ "drugidlist":13
	 * 
	 *             }
	 */
	@RequestMapping(value = "/getReturnDrugDetailsByDrugId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getReturnDrugDetailsByDrugId(
			@RequestBody PlacingOrdersForPurchaseControllerDTO objPlacingOrdersForPurchaseControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getReturnDrugDetailsByDrugId()::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PlacingOrdersForPurchaseWrapper objPlacingOrdersForPurchaseWrapper = new PlacingOrdersForPurchaseWrapper();
		if (objPlacingOrdersForPurchaseControllerDTO.getDrugidList() != null) {

			PlacingOrdersForPurchaseMapper mapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchaseServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl
					.getReturnDrugDetailsByDrugId(
							mapper.conversionControllerDtoToServiceDto(objPlacingOrdersForPurchaseControllerDTO),
							strRequestID);
			objPlacingOrdersForPurchaseWrapper
					.setPlacingOrdersForPurchaseControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objPlacingOrdersForPurchaseWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objPlacingOrdersForPurchaseWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}

		log.info("::::OUTPUT:::::::::::::::::::::::getReturnDrugDetailsByDrugId()::::::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseWrapper.toString());
		return objPlacingOrdersForPurchaseWrapper;
	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : savePurchaseOrderItemDetails
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/savePurchaseOrderItemQuantity
	 * 
	 *      {"drugidlist":1, "quantity":1, "count":1, "createById":1, "roleId":1,
	 *      "moduleId":1, "indentidlist":1
	 * 
	 *      }
	 */
	@CrossOrigin
	@RequestMapping(value = "/savePurchaseOrderItemQuantity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response savePurchaseOrderItemQuantity(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::savePurchaseOrderItemQuantity():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugidList())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getQuantity())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCreateById())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getIndentidlist())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPlacingOrdersForPurchaseServiceImpl.savePurchaseOrderItemQuantity(dataInfo,
					strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::savePurchaseOrderItemQuantity()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getGenerateIndentNumber
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getGenerateIndentNumber
	 * 
	 * 
	 * 
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/getGenerateIndentNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getGenerateIndentNumber() throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::getGenerateIndentNumber():::::::::");
		List<PlacingOrdersForPurchaseControllerDTO> objAllowanceControllerDTO = new ArrayList<PlacingOrdersForPurchaseControllerDTO>();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		String maxIndent = objPlacingOrdersForPurchaseServiceImpl.getGenerateIndentNumber(strRequestID);
		if (maxIndent.isEmpty()) {
			throw new DataNotFoundException("");
		} else {
			dataWrapper.setPlacingOrdersForPurchaseControllerDTO(objAllowanceControllerDTO);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(maxIndent);
		}
		log.info(strRequestID + "::::::::getGenerateIndentNumber():::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : generatePoNumber
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/generatePoNumber
	 * 
	 * 
	 * 
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/generatePoNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response generatePoNumber() throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::generatePoNumber():::::::::");
		List<PlacingOrdersForPurchaseControllerDTO> objAllowanceControllerDTO = new ArrayList<PlacingOrdersForPurchaseControllerDTO>();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		String count = objPlacingOrdersForPurchaseServiceImpl.generatePoNumber(strRequestID);
		if (count.isEmpty()) {
			throw new DataNotFoundException("");
		} else {
			dataWrapper.setPlacingOrdersForPurchaseControllerDTO(objAllowanceControllerDTO);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(count);
		}
		log.info(strRequestID + "::::::::generatePoNumber():::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * @Author: Habiboon Patan.
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : savePurchaseOrderItemDetails
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/saveIndentItemDetails
	 * 
	 *      {"indentidNumber":1, "moduleId":1, "roleId":1, "createById":1,
	 *      "approvalId":1,
	 * 
	 *      }
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveIndentItemDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response saveIndentItemDetails(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::saveIndentItemDetails():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getIndentidNumber())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCreateById())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getApprovalId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPlacingOrdersForPurchaseServiceImpl.saveIndentItemDetails(dataInfo,
					strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::saveIndentItemDetails()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * 
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getAllPurchaseOrderList
	 * @Parameters :drugidId
	 * @URL :localhost:
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getAllPurchaseOrderList
	 *      {"genericName":"cipla", "brandId":1, "formId":1, "manufactureId":1,
	 *      "unicode":1, "pageOffset":1, "pageLimit":1
	 * 
	 *      }
	 * 
	 * 
	 */
	@RequestMapping(value = "/getAllPurchaseOrderList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getAllPurchaseOrderList(
			@RequestBody PlacingOrdersForPurchaseControllerDTO objPlacingOrdersForPurchaseControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getAllPurchaseOrderList()::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PlacingOrdersForPurchaseWrapper objPlacingOrdersForPurchaseWrapper = new PlacingOrdersForPurchaseWrapper();
		if (objPlacingOrdersForPurchaseControllerDTO.getGenericName() != null
				|| objPlacingOrdersForPurchaseControllerDTO.getBrandId() != null
				|| objPlacingOrdersForPurchaseControllerDTO.getFormId() != null
				|| objPlacingOrdersForPurchaseControllerDTO.getManufactureId() != null
				|| objPlacingOrdersForPurchaseControllerDTO.getUnicode() != null) {

			PlacingOrdersForPurchaseMapper mapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchaseServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl
					.getAllPurchaseOrderList(
							mapper.conversionControllerDtoToServiceDto(objPlacingOrdersForPurchaseControllerDTO),
							strRequestID);
			objPlacingOrdersForPurchaseWrapper
					.setPlacingOrdersForPurchaseControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objPlacingOrdersForPurchaseWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objPlacingOrdersForPurchaseWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getAllPurchaseOrderList()::::::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseWrapper.toString());
		return objPlacingOrdersForPurchaseWrapper;
	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : generatePoNumber
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getAllPurchaseOrderDrugCount
	 * 
	 *      {"genericName":"¥", "brandId":0, "formId":0, "manufactureId":0,
	 *      "unicode":"¥", "systemId":0, "genericgroupId":0, "moduleId":0
	 * 
	 * 
	 *      }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getAllPurchaseOrderDrugCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAllPurchaseOrderDrugCount(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::getAllPurchaseOrderDrugCount():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBrandId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFormId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getManufactureId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnicode()))
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSystemId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericgroupId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())) 
				{
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			List<PlacingOrdersForPurchaseServiceDTO> count = objPlacingOrdersForPurchaseServiceImpl
					.getAllPurchaseOrderDrugCount(dataInfo, strRequestID);
			dataWrapper.setPlacingOrdersForPurchaseControllerDTO(dataMapper.conversionForServiceTOControllerDTO(count));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getAllPurchaseOrderList()::::::::::::::::::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}
	
	
	
	
	
	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : generatePoNumber
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getAllPurchaseOrderDrugCountWIthEightParam
	 * 
	 *      {"genericName":"¥", "brandId":0, "formId":0, "manufactureId":0,
	 *      "unicode":"¥", "systemId":0, "genericgroupId":0, "moduleId":0
	 * 
	 * 
	 *      }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getAllPurchaseOrderDrugCountWIthEightParam", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAllPurchaseOrderDrugCountWIthEightParam(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::getAllPurchaseOrderDrugCount():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBrandId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFormId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getManufactureId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnicode())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSystemId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericgroupId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())) 
				{
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			List<PlacingOrdersForPurchaseServiceDTO> count = objPlacingOrdersForPurchaseServiceImpl
					.getAllPurchaseOrderDrugCountWithEightParam(dataInfo, strRequestID);
			dataWrapper.setPlacingOrdersForPurchaseControllerDTO(dataMapper.conversionForServiceTOControllerDTO(count));
			dataWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			dataWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getAllPurchaseOrderList()::::::::::::::::::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}
	
	

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getAvailabeDrugs
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getAvailabeDrugs
	 * 
	 *      {"genericName":"cipla", "brandId":1, "formId":1, "manufactureId":1,
	 *      "unicode":"DR-9" }
	 * 
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getAvailabeDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response getAvailabeDrugs(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {

		String strRequestID = request.getAttribute("reqid").toString();

		log.info(strRequestID + "::::::getAvailabeDrugs():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getGenericName())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBrandId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFormId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getManufactureId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnicode())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String count = objPlacingOrdersForPurchaseServiceImpl.getAvailabeDrugs(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(count);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::getAvailabeDrugs()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * 
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadIndentDetails
	 * @Parameters :loadIndentDetails
	 * @URL :localhost:
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/loadIndentDetails
	 * @Parameters :{"indentidNumber":"Ind_20130806_3"
	 * 
	 * 
	 *             }
	 */
	@RequestMapping(value = "/loadIndentDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadIndentDetails(
			@RequestBody PlacingOrdersForPurchaseControllerDTO objPlacingOrdersForPurchaseControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::loadIndentDetails()::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PlacingOrdersForPurchaseWrapper objPlacingOrdersForPurchaseWrapper = new PlacingOrdersForPurchaseWrapper();
		if (objPlacingOrdersForPurchaseControllerDTO.getIndentidNumber() != null) {

			PlacingOrdersForPurchaseMapper mapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchaseServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl.loadIndentDetails(
					mapper.conversionControllerDtoToServiceDto(objPlacingOrdersForPurchaseControllerDTO), strRequestID);
			objPlacingOrdersForPurchaseWrapper
					.setPlacingOrdersForPurchaseControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objPlacingOrdersForPurchaseWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objPlacingOrdersForPurchaseWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::loadIndentDetails()::::::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseWrapper.toString());
		return objPlacingOrdersForPurchaseWrapper;
	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : generatePoNumber
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getEmpMailId
	 * 
	 *      {"messerId":"1", }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getEmpMailId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response getEmpMailId(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::::::::::::getEmpMailId()::::::::::::::::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getMesserId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String mailId = objPlacingOrdersForPurchaseServiceImpl.getEmpMailId(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(mailId);

		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::getEmpMailId()::::::::::::::::" + dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : updateReturnItemStaus
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/updateReturnItemStaus
	 * 
	 *      {"messerId":1, "count":1
	 * 
	 * 
	 *      }
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateReturnItemStaus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response updateReturnItemStaus(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::::::::::::::::::::::::::::updateReturnItemStaus()::::::::::::::::::::::::"
				+ dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getMesserId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPlacingOrdersForPurchaseServiceImpl.updateReturnItemStaus(dataInfo,
					strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::updateReturnItemStaus()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : savePoId
	 * @URL : localhost:2000/scmservice/PlacingOrdersForPurchaseController/savePoId
	 * 
	 *      {"po_id":92, "po_number":"PO-20190726-78", "po_raised_date":"now()",
	 *      "po_order_date":"now()", "createById":171, "roleId":100, "moduleId":40,
	 *      "po_createdbydtm":"now()", "po_isactive":false,
	 *      "po_excepted_date":"now()", "po_terms_conditions":"scm" }
	 */
	@CrossOrigin
	@RequestMapping(value = "/savePoId", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response savePoId(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(
				strRequestID + ":::::::::::::::::::::::::::::::savePoId()::::::::::::::::::::::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getPo_number())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPo_raised_date())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPo_order_date())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCreateById())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPo_excepted_date())
				) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPlacingOrdersForPurchaseServiceImpl.savePoId(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::savePoId()::::::::::::::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getMesserAddress
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getMesserAddress
	 * 
	 *      {"messerId":"1" }
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/getMesserAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response getMesserAddress(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::::::::::::getMesserAddress()::::::::::::::::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getMesserId())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);

		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String address = objPlacingOrdersForPurchaseServiceImpl.getMesserAddress(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setRtnReponseCount(address);

		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::getMesserAddress()::::::::::::::::"
				+ dataWrapper.toString());
		return dataWrapper;

	}

	/**
	 * 
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getPoDrug_Details
	 * @Parameters :po_id
	 * @URL :localhost:
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getPoDrug_Details
	 * @Parameters :{"po_id":6
	 * 
	 * 
	 *             }
	 */
	@RequestMapping(value = "/getPoDrug_Details", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getPoDrug_Details(
			@RequestBody PlacingOrdersForPurchaseControllerDTO objPlacingOrdersForPurchaseControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getPoDrug_Details()::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PlacingOrdersForPurchaseWrapper objPlacingOrdersForPurchaseWrapper = new PlacingOrdersForPurchaseWrapper();
		if (objPlacingOrdersForPurchaseControllerDTO.getPo_id() != null) {

			PlacingOrdersForPurchaseMapper mapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchaseServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl.getPoDrug_Details(
					mapper.conversionControllerDtoToServiceDto(objPlacingOrdersForPurchaseControllerDTO), strRequestID);
			objPlacingOrdersForPurchaseWrapper
					.setPlacingOrdersForPurchaseControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objPlacingOrdersForPurchaseWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objPlacingOrdersForPurchaseWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getPoDrug_Details()::::::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseWrapper.toString());
		return objPlacingOrdersForPurchaseWrapper;
	}

	/**
	 * 
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : insertMails
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/insertMails
	 * 
	 *      {{"inboxqueueid":1, "replyuser":1, "mailId":"priya@", "subject":"a",
	 *      "ccmailids":"priya@", "bccmailids":"priya@", "replybodylist":"1",
	 *      "actionid":1 , "templateid":1, "isdeleted":"true", "createById":1,
	 *      "moduleId":1, "roleId":1, "size":1 }
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/insertMails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response insertMails(@RequestBody PlacingOrdersForPurchaseControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::::::::::::::::::::::::::::insertMails()::::::::::::::::::::::::"
				+ dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PlacingOrdersForPurchaseServiceDTO dataInfo = new PlacingOrdersForPurchaseServiceDTO();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		PlacingOrdersForPurchaseWrapper dataWrapper = new PlacingOrdersForPurchaseWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getInboxqueueid())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getReplyuser())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getMailId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSubject())

				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCcmailids())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBccmailids())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getReplybodylist())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getActionid())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTemplateid())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getIsdeleted())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCreateById())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getSize())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPlacingOrdersForPurchaseServiceImpl.insertMails(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::insertMails()::::::::::::::::" + dataWrapper.toString());
		return dataWrapper;
	}

	/**
	 * 
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadSupplier
	 * @Parameters :getDrugidlist
	 * @URL :localhost:
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/loadSupplier
	 * @Parameters :{"drugidlist":6
	 * 
	 * 
	 *             }
	 */
	@RequestMapping(value = "/loadSupplier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadSupplier(
			@RequestBody PlacingOrdersForPurchaseControllerDTO objPlacingOrdersForPurchaseControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::loadSupplier()::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		PlacingOrdersForPurchaseWrapper objPlacingOrdersForPurchaseWrapper = new PlacingOrdersForPurchaseWrapper();
		if (objPlacingOrdersForPurchaseControllerDTO.getDrugidList() != null) {

			PlacingOrdersForPurchaseMapper mapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchaseServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl.loadSupplier(
					mapper.conversionControllerDtoToServiceDto(objPlacingOrdersForPurchaseControllerDTO), strRequestID);
			objPlacingOrdersForPurchaseWrapper
					.setPlacingOrdersForPurchaseControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objPlacingOrdersForPurchaseWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objPlacingOrdersForPurchaseWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::loadSupplier()::::::::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseWrapper.toString());
		return objPlacingOrdersForPurchaseWrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadIndents
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/loadIndents
	 * 
	 * 
	 * 
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadIndents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadIndents() throws InSufficientInputException, DataNotFoundException {
		log.info(":::::::::::::::::loadIndents():::::::no input:::::::::::::::::::::");
		PlacingOrdersForPurchaseWrapper objPlacingOrdersForPurchaseWrapper = new PlacingOrdersForPurchaseWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<PlacingOrdersForPurchaseServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl
				.loadIndents(strRequestID);
		objPlacingOrdersForPurchaseWrapper.setPlacingOrdersForPurchaseControllerDTO(
				new PlacingOrdersForPurchaseMapper().conversionForServiceTOControllerDTO(sDto));
		objPlacingOrdersForPurchaseWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objPlacingOrdersForPurchaseWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::::::::loadIndents():::::::::::::::::::::::::::"
				+ objPlacingOrdersForPurchaseWrapper.toString());
		return objPlacingOrdersForPurchaseWrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 14-04-2020
	 * @Des : loadBrandNames
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/loadBrandNames
	 * 
	 * 
	 * 
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadBrandNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadBrandNames() throws InSufficientInputException, DataNotFoundException {
		log.info(":::::::::::::::::loadBrandNames():::::::no input:::::::::::::::::::::");
		BrandNameWrapper objBrandNameWrapper = new BrandNameWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<BrandNameServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl.loadBrandNames(strRequestID);
		objBrandNameWrapper
				.setObjBrandNameControllerDTO(new BrandNameMapper().conversionForServiceTOControllerDTO(sDto));
		objBrandNameWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objBrandNameWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::::::::loadBrandNames():::::::::::::::::::::::::::" + objBrandNameWrapper.toString());
		return objBrandNameWrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 14-04-2020
	 * @Des : loadManufactureForm
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/loadManufactureForm
	 * 
	 * 
	 * 
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadManufactureForm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadManufactureForm() throws InSufficientInputException, DataNotFoundException {
		log.info(":::::::::::::::::loadManufactureForm():::::::no input:::::::::::::::::::::");
		ManufactureFormWrapper objManufactureFormWrapper = new ManufactureFormWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<ManufactureFormServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl.loadManufactureForm(strRequestID);
		objManufactureFormWrapper.setObjManufactureFormControllerDTO(
				new ManufactureFormMapper().conversionForServiceTOControllerDTO(sDto));
		objManufactureFormWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objManufactureFormWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::::::::loadManufactureForm():::::::::::::::::::::::::::"
				+ objManufactureFormWrapper.toString());
		return objManufactureFormWrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 14-04-2020
	 * @Des : loadManufactureCompnayNames
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/loadManufactureCompnayNames
	 * 
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadManufactureCompnayNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadManufactureCompnayNames() throws InSufficientInputException, DataNotFoundException {
		log.info(":::::::::::::::::loadManufactureCompnayNames():::::::no input:::::::::::::::::::::");
		ManufactureCompanyWrapper objManufactureCompanyWrapper = new ManufactureCompanyWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<ManufactureCompanyServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl
				.loadManufactureCompnayNames(strRequestID);
		objManufactureCompanyWrapper.setObjManufactureCompanyControllerDTO(
				new ManufactureCompanyMapper().conversionForServiceTOControllerDTO(sDto));
		objManufactureCompanyWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objManufactureCompanyWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::::::::loadManufactureCompnayNames():::::::::::::::::::::::::::"
				+ objManufactureCompanyWrapper.toString());
		return objManufactureCompanyWrapper;
	}

	/**
	 * 
	 * @throws DataNotFoundException
	 * @Date : 17-04-2020
	 * @Des : getIndentDetails
	 * @Parameters :getIndentDetails
	 * @URL :localhost:
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/getIndentDetails
	 * @Parameters :{"indent_id":46
	 * 
	 * 
	 *             }
	 */
	@RequestMapping(value = "/getIndentDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getIndentDetails(@RequestBody IndentDetailsControllerDTO objIndentDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getIndentDetails()::::::::::::::::::::::::::::"
				+ objIndentDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		IndentDetailsWrapper objIndentDetailsWrapper = new IndentDetailsWrapper();
		if (objIndentDetailsControllerDTO.getIndent_id() != null) {

			IndentDetailsMapper mapper = new IndentDetailsMapper();
			List<IndentDetailsServiceDTO> sDto = objPlacingOrdersForPurchaseServiceImpl.getIndentDetails(
					mapper.conversionControllerDtoToServiceDto(objIndentDetailsControllerDTO), strRequestID);
			objIndentDetailsWrapper.setObjIndentDetailsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objIndentDetailsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objIndentDetailsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::loadSupplier()::::::::::::::::::::::::::::::::"
				+ objIndentDetailsWrapper.toString());
		return objIndentDetailsWrapper;
	}

	/**
	 * @Author: Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 2019-04-18
	 * @Des : centralClose
	 * @URL :
	 *      localhost:2000/scmservice/PlacingOrdersForPurchaseController/centralClose
	 * 
	 *      {"indent_id":92 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/centralClose", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public Response centralClose(@RequestBody CentralCloseControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + ":::::::::::::::::::::::::::::::centralClose()::::::::::::::::::::::::"
				+ dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		CentralCloseServiceDTO dataInfo = new CentralCloseServiceDTO();
		CentralCloseWrapper dataWrapper = new CentralCloseWrapper();
		CentralCloseMapper dataMapper = new CentralCloseMapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getIndent_id())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPlacingOrdersForPurchaseServiceImpl.centralClose(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
		log.info(strRequestID + ":::::::::::::::::::::::::::::centralClose()::::::::::::::::" + dataWrapper.toString());
		return dataWrapper;
	}
}
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

import com.pro.scm.controllerdto.IndentItemListControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.IndentItemListMapper;
import com.pro.scm.service.IndentItemListService;
import com.pro.scm.servicedto.IndentItemListServiceDTO;
import com.pro.scm.wrappers.IndentItemListWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Bhuneshwar
 *
 */
@RestController
@RequestMapping("/indentItemListController")
@Slf4j
public class IndentItemListController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objIndentItemListService")
	private IndentItemListService objIndentItemListService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @URL :http://localhost:2000/scmservice/indentItemListController/insertAndUpdateIndentRaiseds
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/insertAndUpdateIndentRaiseds", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response insertAndUpdateIndentRaiseds(@RequestBody IndentItemListControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getRoles method is executed inside indentItemListController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentItemListMapper mapper = new IndentItemListMapper();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		if (objControllerDto.getBatch_number() != null && objControllerDto.getMainstore_available_stock() != null
				&& objControllerDto.getMainstore_id() != null && objControllerDto.getDrug_id() != null
				&& objControllerDto.getBatch_number() != null && objControllerDto.getMrp() != null
				&& objControllerDto.getPurchase_price() != null && objControllerDto.getAvailable_stock() != null
				&& objControllerDto.getExpire_date() != null && objControllerDto.getRecived_stock() != null
				&& objControllerDto.getCreatedbyid() != null && objControllerDto.getCreatedbyroleid() != null
				&& objControllerDto.getCreatedbymoduleid() != null && objControllerDto.getUnitprice() != null
				&& objControllerDto.getIndent_code() != null && objControllerDto.getSize() != null) {
			List<IndentItemListServiceDTO> listOfData = objIndentItemListService.insertAndUpdateIndentRaiseds(
					mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setResponseCode(HttpStatus.OK.value());
			wrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			wrapper.setObjIndentItemListControllerDTO(mapper.conversionForServiceTOControllerDTO(listOfData));
		} else {
			wrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			wrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());

			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

	/**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun:loadLocalIndentIssuedDetails
	 * @json:{ "indentNum":1}
	 * @URL :http://localhost:2001/scmservice/indentItemListController/api/version_1/loadLocalIndentIssuedDetails
	 * 
	 */
	@RequestMapping(value = "/api/version_1/loadLocalIndentIssuedDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadLocalIndentIssuedDetails(@RequestBody IndentItemListControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadLocalIndentIssuedDetails method is executed inside indentItemListController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentItemListMapper mapper = new IndentItemListMapper();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		if (objControllerDto.getIndentNum() != null) {
			List<IndentItemListServiceDTO> objAddNewLocalDrugServiceDTO = objIndentItemListService
					.loadLocalIndentIssuedDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto),
							strRequestID);
			wrapper.setObjIndentItemListControllerDTO(
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun:loadIndentRaisedItems
	 * @json:{ "indentNum":1}
	 * @URL :http://localhost:2001/scmservice/indentItemListController/loadIndentRaisedItems
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadIndentRaisedItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadIndentRaisedItems(@RequestBody IndentItemListControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadIndentRaisedItems method is executed inside indentItemListController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentItemListMapper mapper = new IndentItemListMapper();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		if (objControllerDto.getIndentNum() != null) {
			List<IndentItemListServiceDTO> objAddNewLocalDrugServiceDTO = objIndentItemListService
					.loadIndentRaisedItems(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjIndentItemListControllerDTO(
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun:loadAvailableQty
	 * @json:{ "main_storeId":1, "storeId":1 }
	 * 
	 * @URL :http://localhost:2001/scmservice/indentItemListController/loadAvailableQty
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadAvailableQty", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadAvailableQty(@RequestBody IndentItemListControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadAvailableQty method is executed inside indentItemListController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentItemListMapper mapper = new IndentItemListMapper();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		if (objControllerDto.getMain_storeId() != null && objControllerDto.getStoreId() != null) {
			List<IndentItemListServiceDTO> objAddNewLocalDrugServiceDTO = objIndentItemListService
					.loadAvailableQty(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjIndentItemListControllerDTO(
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun:loadBatchNumber
	 * @json:{ "main_storeId":1, "storeId":1 }
	 * @URL :http://localhost:2001/scmservice/indentItemListController/loadBatchNumber
	 */
	@CrossOrigin
	@RequestMapping(value = "loadBatchNumber", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadBatchNumber(@RequestBody IndentItemListControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadBatchNumber method is executed inside indentItemListController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentItemListMapper mapper = new IndentItemListMapper();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		if (objControllerDto.getDrug_id() != null && objControllerDto.getStoreId() != null) {
			List<IndentItemListServiceDTO> objAddNewLocalDrugServiceDTO = objIndentItemListService
					.loadBatchNumber(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjIndentItemListControllerDTO(
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019 getTemplate
	 * @json:{"templateId":1}
	 * @URL :http://localhost:2001/scmservice/indentItemListController/api/version_1/getTemplate
	 */
	@RequestMapping(value = "/api/version_1/getTemplate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getTemplate(@RequestBody IndentItemListControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("getTemplate method is executed inside indentItemListController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentItemListMapper mapper = new IndentItemListMapper();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		if (objControllerDto.getTemplateId() != null) {
			List<IndentItemListServiceDTO> objAddNewLocalDrugServiceDTO = objIndentItemListService
					.getTemplate(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjIndentItemListControllerDTO(
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @func:loadIndentRaisedSearch
	 * @json:{"from_date":"2019-01-01", "to_date":"2019-01-01", "from_store":1,
	 *                                  "to_store":1, "indentStatus":1 }
	 * @URL :http://localhost:2000/scmservice/indentItemListController/loadIndentRaisedSearch
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadIndentRaisedSearch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadIndentRaisedSearch(@RequestBody IndentItemListControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("loadIndentRaisedSearch method is executed inside indentItemListController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentItemListMapper mapper = new IndentItemListMapper();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		if (objControllerDto.getFrom_date() != null && objControllerDto.getTo_date() != null
				&& objControllerDto.getFrom_store() != null && objControllerDto.getTo_store() != null
				&& objControllerDto.getIndentStatus() != null) {
			List<IndentItemListServiceDTO> objAddNewLocalDrugServiceDTO = objIndentItemListService
					.loadIndentRaisedSearch(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjIndentItemListControllerDTO(
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun:loadIndentStatus
	 * @URL :http://localhost:2000/scmservice/indentItemListController/loadIndentStatus
	 */
	@RequestMapping(value = "/loadIndentStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadIndentStatus() throws InSufficientInputException, DataNotFoundException {
		log.info("loadIndentStatus method is executed inside indentItemListController");
		String strRequestID = request.getAttribute("reqid").toString();
		IndentItemListWrapper wrapper = new IndentItemListWrapper();
		List<IndentItemListServiceDTO> objIndentItemListServiceDTO = objIndentItemListService
				.loadIndentStatus(strRequestID);
		wrapper.setObjIndentItemListControllerDTO(
				new IndentItemListMapper().conversionForServiceTOControllerDTO(objIndentItemListServiceDTO));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

}

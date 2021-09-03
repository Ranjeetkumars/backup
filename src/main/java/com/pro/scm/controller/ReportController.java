package com.pro.scm.controller;

import java.util.ArrayList;
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

import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.controllerdto.ReceivedGoodsControllerDTO;
import com.pro.scm.controllerdto.ReportControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.mappers.ReceivedGoodsMapper;
import com.pro.scm.mappers.ReportMapper;
import com.pro.scm.service.ReceivedGoodsService;
import com.pro.scm.service.ReportService;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.servicedto.ReceivedGoodsServiceDTO;
import com.pro.scm.servicedto.ReportServiceDTO;
import com.pro.scm.wrappers.PlacingOrdersForPurchaseWrapper;
import com.pro.scm.wrappers.ReceivedGoodsWrapper;
import com.pro.scm.wrappers.ReportWrapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Priyadarshini
 * @since 30.07.2019
 * @Des : ReportController
 */
@Slf4j
@RestController
@RequestMapping("/ReportController")
public class ReportController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	@Qualifier("objReportServiceImpl")
	private ReportService objReportServiceImpl;
	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : getIPFields
	 * @Parameters :reportId
	 * @URL :localhost:  192.168.1.149:2000/scmservice/ReportController/getIPFields
	 * @Parameters :{	"reportId":10

	                    }
	 */
	@RequestMapping(value = "/getIPFields", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getIPFields(
			@RequestBody  ReportControllerDTO objReportControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::getIPFields()::::::::::::::::::::::::::::"+objReportControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ReportWrapper objReceivedGoodsWrapper = new ReportWrapper();
		if(objReportControllerDTO.getReportId()!= null) {
			ReportMapper mapper = new ReportMapper();
			List<ReportServiceDTO> sDto = objReportServiceImpl.getIPFields(mapper.conversionControllerDtoToServiceDto(objReportControllerDTO),strRequestID);
			objReceivedGoodsWrapper.setReportControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objReceivedGoodsWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objReceivedGoodsWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::getIPFields()::::::::::::::::::::::::::::::::"+objReceivedGoodsWrapper.toString());
		return objReceivedGoodsWrapper;
	}
	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadReports
	 * @Parameters :moduleId
	 * @URL :localhost:  192.168.1.149:2000/scmservice/ReportController/loadReports
	 * @Parameters :{	"moduleId":10

	}
	 */
	@RequestMapping(value = "/loadReports", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadReports(
			@RequestBody  ReportControllerDTO objReportControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are:::::::::::::loadReports()::::::::::::::::::::::::::::"+objReportControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ReportWrapper objReportWrapper = new ReportWrapper();
		if(objReportControllerDTO.getModuleId()!= null) {
			
			ReportMapper mapper = new ReportMapper();
			List<ReportServiceDTO> sDto = objReportServiceImpl.loadReports(mapper.conversionControllerDtoToServiceDto(objReportControllerDTO),strRequestID);
			objReportWrapper.setReportControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objReportWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objReportWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT:::::::::::::::::::::::loadReports()::::::::::::::::::::::::::::::::"+objReportWrapper.toString());
		return objReportWrapper;
	}

	
	/**
	 * @author : priyadarshini
	 * @throws DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : loadModules
	 * @Parameters :NO 
	 * @URL :  192.168.1.149:2000/scmservice/ReportController/loadModules
	 *      
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadModules", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadModules() throws DataNotFoundException {
		String requestID = (String)request.getAttribute("sessionid");
		log.info(requestID + ":::::::::::::::::::::::::::::loadModules()::::::::::::::::::::::::::::::::::::::::::");
		ReportWrapper objReportWrapper = new ReportWrapper();
			List<ReportServiceDTO> datas = objReportServiceImpl.loadModules(requestID);
			objReportWrapper.setReportControllerDTO(
					new ReportMapper().conversionForServiceTOControllerDTO(datas));
			objReportWrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objReportWrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			log.info("::::OUTPUT:::::::::::::loadModules()::::::::::::::::::::::::::::::::::::::"+objReportWrapper.toString());
		return objReportWrapper;

	}
	
}

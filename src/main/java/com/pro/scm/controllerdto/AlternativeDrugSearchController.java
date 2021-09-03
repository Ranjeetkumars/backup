package com.pro.scm.controllerdto;

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
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AlternativeDrugSearchMapper;
import com.pro.scm.mappers.LoadGenericDrugNameMapper;
import com.pro.scm.service.DrugSearchService;
import com.pro.scm.servicedto.LoadGenericDrugNameServiceDto;
import com.pro.scm.wrappers.CounterIndentWrapper;
import com.pro.scm.wrappers.LoadGenericDrugNameWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AlternativeDrugSearchController {

	@Autowired
	@Qualifier("objDrugSearchService")
	DrugSearchService objDrugSearchService;
	InSufficientInputException obj;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author :Ranjeet kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 30-07-2019
	 * @URL : http://localhost:2000/scmservice/api/version_1/searchDrug
	 */

	@RequestMapping(value = "/api/version_1/searchDrug", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response searchDrug(@RequestBody AlternativeDrugSearchControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("searchDrug method is executed inside SCMLoginController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AlternativeDrugSearchMapper mapper = new AlternativeDrugSearchMapper();
		CounterIndentWrapper wrapper = new CounterIndentWrapper();
		if (objControllerDto.getGenericId() != null) {
			String rtnValueOfMT = objDrugSearchService
					.searchDrug(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @URL : http://localhost:2000/scmservice//api/version_1/loadGenericDrugName
	 */
	@RequestMapping(value = "/api/version_1/loadGenericDrugName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadGenericDrugName() throws InSufficientInputException, DataNotFoundException {
		log.info("loadGenericDrugName method is executed inside DrugRegisteringController");
		String strRequestID = request.getAttribute("reqid").toString();
		LoadGenericDrugNameMapper mapper = new LoadGenericDrugNameMapper();
		LoadGenericDrugNameWrapper wrapper = new LoadGenericDrugNameWrapper();
		List<LoadGenericDrugNameServiceDto> loadGenericDrugNameServiceDto = objDrugSearchService
				.loadGenericDrugName(strRequestID);
		wrapper.setLoadGenericDrugNameControllerDto(
				mapper.conversionForServiceTOControllerDTO(loadGenericDrugNameServiceDto));
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

}

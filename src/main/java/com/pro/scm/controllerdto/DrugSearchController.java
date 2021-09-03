package com.pro.scm.controllerdto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.SearchDrugMapper;
import com.pro.scm.service.DrugSearchService;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.wrappers.SearchDrugWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/DrugSearchController")
@Slf4j
public class DrugSearchController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objDrugSearchService")
	private DrugSearchService objDrugSearchService;
	@Autowired
	private HttpServletRequest request;
	
	
	/**
	 * @author :Deepak 
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/DrugSearchController/SearchDrug
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
			List<PharamacyNewDrugQtyServiceDto> sDto = objDrugSearchService
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
}

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

import com.pro.scm.controllerdto.PharmacyNewDrugQtyControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SupplierControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.SearchDrugMapper;
import com.pro.scm.mappers.SupplierMapper;
import com.pro.scm.service.SupplierService;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.servicedto.SupplierServiceDTO;
import com.pro.scm.wrappers.SearchDrugWrapper;
import com.pro.scm.wrappers.SupplierWrapper;
import com.pro.scm.wrappers.UpdateDetailsWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/SupplierController")
@Slf4j
public class SupplierController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objSupplierService")
	private SupplierService objSupplierService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierController/saveSupplier
	 * @Parameters :{"suppliername":"rohith","countryid":1,"stateid":1,"districtid":1,"mandalid":1,"cityid":1,"localityid":1,"landmarkid":1,"email":"oops@gmail.com",
	 *             "website":"www.oops.com","licensenumber":"AL1244","telephone":"04052561265","mobile":"779898989","fax":"1","pincode":110022,"userid":171,"roleid":100,
	 *             "moduleid":40,"status":true,"contactperson":"deepak","classificationid":1}
	 */

	@CrossOrigin
	@RequestMapping(value = "/saveSupplier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveSuppliers(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objSupplierControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		SupplierMapper objSupplierMapper = new SupplierMapper();
		UpdateDetailsWrapper objUpdateDetailsWrapper = new UpdateDetailsWrapper();
		if (objSupplierControllerDTO.getSuppliername() != null && objSupplierControllerDTO.getCountryid() != null
				&& objSupplierControllerDTO.getStateid() != null && objSupplierControllerDTO.getEmail() != null
				&& objSupplierControllerDTO.getTelephone() != null && objSupplierControllerDTO.getUserid() != null
				&& objSupplierControllerDTO.getRoleid() != null && objSupplierControllerDTO.getModuleid() != null
				&& objSupplierControllerDTO.getClassificationid() != null) {
			String rtnValueOfMT = objSupplierService.saveSupplier(
					objSupplierMapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
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
		log.info("::::OUTPUT::::::" + objUpdateDetailsWrapper.toString());
		return objUpdateDetailsWrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierController/updateSupplier
	 * @Parameters :{"supplierId":1"suppliername":"rohith","countryid":1,"stateid":1,"districtid":1,"mandalid":1,"cityid":1,"localityid":1,"landmarkid":1,"email":"oops@gmail.com",
	 *             "website":"www.oops.com","licensenumber":"AL1244","telephone":"04052561265","mobile":"779898989","fax":"1","pincode":110022,
	 *             "status":true,"contactperson":"deepak","classificationid":1}
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateSupplier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateSupplier(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objSupplierControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		SupplierMapper objSupplierMapper = new SupplierMapper();
		UpdateDetailsWrapper objUpdateDetailsWrapper = new UpdateDetailsWrapper();
		if (objSupplierControllerDTO.getSupplierId() != null && objSupplierControllerDTO.getSuppliername() != null
				&& objSupplierControllerDTO.getCountryid() != null && objSupplierControllerDTO.getStateid() != null
				&& objSupplierControllerDTO.getEmail() != null
                && objSupplierControllerDTO.getTelephone() != null
                && objSupplierControllerDTO.getClassificationid() != null) {
			String rtnValueOfMT = objSupplierService.updateSupplier(
					objSupplierMapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
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
		log.info("::::OUTPUT::::::" + objUpdateDetailsWrapper.toString());
		return objUpdateDetailsWrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierController/loadClassification
	 * @Parameters :No
	 */

	@RequestMapping(value = "/loadClassification", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadClassification() throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<SupplierServiceDTO> sDto = objSupplierService.loadClassification(strRequestID);
		objwrapper.setObjSupplierControllerDTO(new SupplierMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierController/getSupplier
	 * @Parameters :{"supplierId":1 }
	 */
	@CrossOrigin
	@RequestMapping(value = "/getSupplier", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getSupplier(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objSupplierControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		SupplierWrapper objwrapper = new SupplierWrapper();
		if (objSupplierControllerDTO.getSupplierId() != null) {

			SupplierMapper mapper = new SupplierMapper();
			List<SupplierServiceDTO> sDto = objSupplierService
					.getSupplier(mapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
			objwrapper.setObjSupplierControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	// SELECT cy_cyid,cy_lname FROM giscountries_ref where cy_isactive=true

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierController/loadCountry
	 * @Parameters :No
	 */

	@RequestMapping(value = "/loadCountry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadCountry() throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		String strRequestID = request.getAttribute("reqid").toString();
		List<SupplierServiceDTO> sDto = objSupplierService.loadCountry(strRequestID);
		objwrapper.setObjSupplierControllerDTO(new SupplierMapper().conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/SupplierController/loadState
	 * @Parameters :{"countryid":"1"}
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadState", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadState(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		SupplierMapper mapper = new SupplierMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		if (objSupplierControllerDTO.getCountryid() != null) {
			List<SupplierServiceDTO> sDto = objSupplierService
					.loadState(mapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
			objwrapper.setObjSupplierControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			objwrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objwrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(objSupplierControllerDTO.toString());
		}

		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	// SELECT sc_scid,sc_lname FROM gisstates_ref where sc_cyid=1 and
	// sc_isactive=true
	// SELECT ds_dsid,ds_lname FROM gisdistricts_ref where ds_scid=3 and
	// ds_isactive=true

	/**
	 * @author :unkonwn
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : loadDistrict
	 * @URL :localhost:2000/scmservice/SupplierController/loadDistrict
	 * @Parameters :{"stateid":"15"}
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadDistrict", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadDistrict(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		SupplierMapper mapper = new SupplierMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		if (objSupplierControllerDTO.getStateid() != null) {
			List<SupplierServiceDTO> sDto = objSupplierService
					.loadDistrict(mapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
			objwrapper.setObjSupplierControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			objwrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objwrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(objSupplierControllerDTO.toString());
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	// SELECT ct_ctid, ct_lname FROM giscities_ref where ct_mdlid=15 and
	// ct_isactive=true

	/**
	 * @author :unkonwn
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : loadDistrict
	 * @URL :localhost:2000/scmservice/SupplierController/loadCity
	 * @Parameters :{"stateid":"15"}
	 */

	// SELECT ds_dsid,ds_lname FROM gisdistricts_ref where ds_scid=1 and
	// ds_isactive=true
	@CrossOrigin
	@RequestMapping(value = "/loadCity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadCity(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		SupplierMapper mapper = new SupplierMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		if (objSupplierControllerDTO.getStateid() != null) {
			List<SupplierServiceDTO> sDto = objSupplierService
					.loadCity(mapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
			objwrapper.setObjSupplierControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			objwrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objwrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(objSupplierControllerDTO.toString());
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	//
	// SELECT lm_landmarkid,lm_lname FROM gislandmark_ref where lm_locationid=3 and
	// lm_isactive=true

	/**
	 * @author :unkonwn
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : loadLandmark
	 * @URL :localhost:2000/scmservice/SupplierController/loadLandmark
	 * @Parameters :{"stateid":"15"}
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadLandmark", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadLandmark(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		SupplierMapper mapper = new SupplierMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		if (objSupplierControllerDTO.getLocalityid() != null) {
			List<SupplierServiceDTO> sDto = objSupplierService
					.loadLandmark(mapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
			objwrapper.setObjSupplierControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			objwrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objwrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(objSupplierControllerDTO.toString());
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}
	// SELECT l_locationid,l_lname FROM gislocality_ref where l_ctid=3 and
	// l_isactive=true

	//

	/**
	 * @author :unkonwn
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : loadDistrict
	 * @URL :localhost:2000/scmservice/SupplierController/loadLocality
	 * @Parameters :{"stateid":"15"}
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadLocality", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadLocality(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		SupplierMapper mapper = new SupplierMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		if (objSupplierControllerDTO.getCityid() != null) {
			List<SupplierServiceDTO> sDto = objSupplierService
					.loadLocality(mapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
			objwrapper.setObjSupplierControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			objwrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objwrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(objSupplierControllerDTO.toString());
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	// SELECT ct_ctid, ct_lname FROM giscities_ref where ct_mdlid=1 and
	// ct_isactive=true

	/**
	 * @author :unkonwn
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : loadDistrict
	 * @URL :localhost:2000/scmservice/SupplierController/loadZipCode
	 * @Parameters :{"cityid":"15"}
	 */
	@CrossOrigin
	@RequestMapping(value = "/loadZipCode", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadZipCode(@RequestBody SupplierControllerDTO objSupplierControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		SupplierWrapper objwrapper = new SupplierWrapper();
		SupplierMapper mapper = new SupplierMapper();
		String strRequestID = request.getAttribute("reqid").toString();
		if (objSupplierControllerDTO.getCityid() != null) {
			List<SupplierServiceDTO> sDto = objSupplierService
					.loadZipCode(mapper.conversionControllerDtoToServiceDto(objSupplierControllerDTO), strRequestID);
			objwrapper.setObjSupplierControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			objwrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			objwrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			throw new InSufficientInputException(objSupplierControllerDTO.toString());
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

}

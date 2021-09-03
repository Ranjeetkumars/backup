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

import com.pro.scm.controllerdto.ItemShelvesDetailsControllerDTO;
import com.pro.scm.controllerdto.LoadItemControllerDTO;
import com.pro.scm.controllerdto.LoadShelvesControllerDTO;
import com.pro.scm.controllerdto.PharmacyNewDrugQtyControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.ShelveRackControllerDTO;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.ItemShelveMapper;
import com.pro.scm.mappers.LoadItemMapper;
import com.pro.scm.mappers.LoadShelveMapper;
import com.pro.scm.mappers.SearchDrugMapper;
import com.pro.scm.mappers.ShelveRackMapper;
import com.pro.scm.service.ItemShelveService;
import com.pro.scm.servicedto.ItemShelveDetailsServiceDTO;
import com.pro.scm.servicedto.LoadItemServiceDTO;
import com.pro.scm.servicedto.LoadShelveServiceDTO;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.servicedto.ShelveRackServiceDTO;
import com.pro.scm.wrappers.ItemShelveWrapper;
import com.pro.scm.wrappers.LoadItemWrapper;
import com.pro.scm.wrappers.LoadShelveWrapper;
import com.pro.scm.wrappers.SearchDrugWrapper;
import com.pro.scm.wrappers.ShelveRackWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ItemShelveController")
@Slf4j
public class ItemShelveController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objItemShelveService")
	private ItemShelveService objItemShelveService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ItemShelveController/saveItemShelveDetails
	 * @Parameters :{"storeId":1,"rackId":1,"shelveId":1000,"itemId":1,"userId":171,"roleId":100,"moduleId":40,"status":true}
	 */
	@RequestMapping(value = "/saveItemShelveDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveRackShelveDetails(
			@RequestBody ItemShelvesDetailsControllerDTO objItemShelvesDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objItemShelvesDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ItemShelveMapper objItemShelveMapper = new ItemShelveMapper();
		ItemShelveWrapper objItemShelveWrapper = new ItemShelveWrapper();
		if (objItemShelvesDetailsControllerDTO.getStoreId() != null
				&& objItemShelvesDetailsControllerDTO.getRackId() != null
				&& objItemShelvesDetailsControllerDTO.getShelveId() != null
				&& objItemShelvesDetailsControllerDTO.getItemId() != null
				&& objItemShelvesDetailsControllerDTO.getUserId() != null
				&& objItemShelvesDetailsControllerDTO.getRoleId() != null
				&& objItemShelvesDetailsControllerDTO.getModuleId() != null
				&& objItemShelvesDetailsControllerDTO.getStatus() != null) {
			String rtnValueOfMT = objItemShelveService.saveItemShelveDetails(
					objItemShelveMapper.conversionControllerDtoToServiceDto(objItemShelvesDetailsControllerDTO),
					strRequestID);
			if (rtnValueOfMT != null) {
				objItemShelveWrapper.setResponseCode(HttpStatus.OK.value());
				objItemShelveWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objItemShelveWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objItemShelveWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objItemShelveWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objItemShelveWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objItemShelveWrapper.toString());
		return objItemShelveWrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-30
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ItemShelveController/updateShelveItems
	 * @Parameters :{"storeId":1,"rackId":1,"shelveId":1000,"itemId":1,"userId":171,"roleId":100,"moduleId":40,"status":true,"rackShelveId":1}
	 */
	@RequestMapping(value = "/updateShelveItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateShelveItems(@RequestBody ItemShelvesDetailsControllerDTO objItemShelvesDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objItemShelvesDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ItemShelveMapper objItemShelveMapper = new ItemShelveMapper();
		ItemShelveWrapper objItemShelveWrapper = new ItemShelveWrapper();
		if (objItemShelvesDetailsControllerDTO.getStoreId() != null
				&& objItemShelvesDetailsControllerDTO.getRackId() != null
				&& objItemShelvesDetailsControllerDTO.getShelveId() != null
				&& objItemShelvesDetailsControllerDTO.getItemId() != null
				&& objItemShelvesDetailsControllerDTO.getUserId() != null
				&& objItemShelvesDetailsControllerDTO.getRoleId() != null
				&& objItemShelvesDetailsControllerDTO.getModuleId() != null
				&& objItemShelvesDetailsControllerDTO.getStatus() != null
				&& objItemShelvesDetailsControllerDTO.getRackShelveId() != null) {
			String rtnValueOfMT = objItemShelveService.updateShelveItems(
					objItemShelveMapper.conversionControllerDtoToServiceDto(objItemShelvesDetailsControllerDTO),
					strRequestID);
			if (rtnValueOfMT != null) {
				objItemShelveWrapper.setResponseCode(HttpStatus.OK.value());
				objItemShelveWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
				objItemShelveWrapper.setRtnReponseCount(rtnValueOfMT);
			} else {
				objItemShelveWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
				objItemShelveWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
				objItemShelveWrapper.setRtnReponseCount(rtnValueOfMT);
			}
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objItemShelveWrapper.toString());
		return objItemShelveWrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ItemShelveController/loadRackByStores
	 * @Parameters :{ "storeId":99999}
	 */

	@CrossOrigin
	@RequestMapping(value = "/loadRackByStores", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadRackByStores(@RequestBody ItemShelvesDetailsControllerDTO objItemShelvesDetailsControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objItemShelvesDetailsControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ItemShelveWrapper objwrapper = new ItemShelveWrapper();
		if (objItemShelvesDetailsControllerDTO.getStoreId() != null) {

			ItemShelveMapper mapper = new ItemShelveMapper();
			List<ItemShelveDetailsServiceDTO> sDto = objItemShelveService.loadRackByStores(
					mapper.conversionControllerDtoToServiceDto(objItemShelvesDetailsControllerDTO), strRequestID);
			objwrapper.setObjItemShelvesDetailsControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ItemShelveController/loadItems
	 * @Parameters :{ "storeId":99999}
	 */

	@RequestMapping(value = "/loadItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadItems(@RequestBody LoadItemControllerDTO objLoadItemControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objLoadItemControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		LoadItemWrapper objwrapper = new LoadItemWrapper();
		if (objLoadItemControllerDTO.getStoreId() != null) {

			LoadItemMapper mapper = new LoadItemMapper();
			List<LoadItemServiceDTO> sDto = objItemShelveService
					.loadItems(mapper.conversionControllerDtoToServiceDto(objLoadItemControllerDTO), strRequestID);
			objwrapper.setObjLoadItemControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ItemShelveController/loadShelves
	 * @Parameters :{ "storeId":99999,"rackId":1}
	 */

	@RequestMapping(value = "/loadShelves", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadShelves(@RequestBody LoadShelvesControllerDTO objLoadShelvesControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objLoadShelvesControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		LoadShelveWrapper objwrapper = new LoadShelveWrapper();
		if (objLoadShelvesControllerDTO.getStoreId() != null && objLoadShelvesControllerDTO.getRackId() != null) {

			LoadShelveMapper mapper = new LoadShelveMapper();
			List<LoadShelveServiceDTO> sDto = objItemShelveService
					.loadShelves(mapper.conversionControllerDtoToServiceDto(objLoadShelvesControllerDTO), strRequestID);
			objwrapper.setObjLoadShelvesControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	/**
	 * @author :Deepak
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2019-07-29
	 * @Des : updateVersion
	 * @URL :localhost:2000/scmservice/ItemShelveController/loadShelvesRack
	 * @Parameters :{ "storeId":99999}
	 */

	@RequestMapping(value = "/loadShelvesRack", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response loadShelvesRack(@RequestBody ShelveRackControllerDTO objShelveRackControllerDTO)
			throws InSufficientInputException, DataNotFoundException {
		log.info("::::Inputs::Are::::" + objShelveRackControllerDTO.toString());
		String strRequestID = request.getAttribute("reqid").toString();
		ShelveRackWrapper objwrapper = new ShelveRackWrapper();
		if (objShelveRackControllerDTO.getStoreId() != null) {

			ShelveRackMapper mapper = new ShelveRackMapper();
			List<ShelveRackServiceDTO> sDto = objItemShelveService.loadShelvesRack(
					mapper.conversionControllerDtoToServiceDto(objShelveRackControllerDTO), strRequestID);
			objwrapper.setObjShelveRackControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
			objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException("");
		}
		log.info("::::OUTPUT::::::" + objwrapper.toString());
		return objwrapper;
	}

	/**
	 * @author :Ranjeet kumar
	 * @throws DataNotFoundException
	 * @throws InSufficientInputException
	 * @Date : 2021-07-14
	 * @Des : get list of store
	 * @URL :localhost:2000/scmservice/ItemShelveController/store
	 * @Parameters :
	 */

	@RequestMapping(value = "/store", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public Response store() throws InSufficientInputException, DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		ShelveRackWrapper objwrapper = new ShelveRackWrapper();
		ShelveRackMapper mapper = new ShelveRackMapper();
		List<ShelveRackServiceDTO> sDto = objItemShelveService.loadStore(strRequestID);
		objwrapper.setObjShelveRackControllerDTO(mapper.conversionForServiceTOControllerDTO(sDto));
		objwrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		objwrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return objwrapper;
	}

}

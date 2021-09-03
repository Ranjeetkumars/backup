package com.pro.scm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pro.scm.controllerdto.AcceptTransferItemsControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.AcceptTransferItemsMapper;
import com.pro.scm.service.AmbToAmbTransferService;
import com.pro.scm.wrappers.AcceptTransferItemsWrapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/AcceptTransferItemsController")
@Slf4j
public class AcceptTransferItemsController {

	InSufficientInputException obj;
	@Autowired
	@Qualifier("ambToAmbTransferService")
	private AmbToAmbTransferService ambToAmbTransferService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * @author : Ranjeet Kumar
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2021
	 * @Des : saveUpdateItems
	 * @json:{ "vehicleId":17}
	 * @URL :
	 *      http://localhost:2000/scmservice/AcceptTransferItemsController/saveUpdateItems
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveUpdateItems", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveUpdateItems(@RequestBody AcceptTransferItemsControllerDto objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("saveUpdateItems method is executed inside AcceptTransferItemsController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();

		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		AcceptTransferItemsMapper mapper = new AcceptTransferItemsMapper();

		AcceptTransferItemsWrapper wrapper = new AcceptTransferItemsWrapper();
		if (objControllerDto.getDr_expt() != null && objControllerDto.getDr_mrp() != null
				&& objControllerDto.getDr_pr_price() != null && objControllerDto.getDr_reaminingqty() != null
				&& objControllerDto.getDr_remainingstrips() != null && objControllerDto.getDr_transferid() != null
				&& objControllerDto.getDr_uni_cost() != null && objControllerDto.getDrug_batchlist() != null
				&& objControllerDto.getDrug_idlist() != null && objControllerDto.getDrug_noofstrips() != null
				&& objControllerDto.getDrug_qtylist() != null && objControllerDto.getFrom_vehicle_id() != null
				&& objControllerDto.getModuleid() != null && objControllerDto.getRoleid() != null
				&& objControllerDto.getSize() != null && objControllerDto.getStock_ref_list() != null
				&& objControllerDto.getTo_vehidi() != null && objControllerDto.getUserid() != null) {

			String rtnStatus = ambToAmbTransferService
					.saveUpdateItems(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);

			wrapper.setRtnReponseCount(rtnStatus);
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		} else {
			throw new InSufficientInputException(objControllerDto.toString());
		}
		log.info(strRequestID + ":::::::::::::" + wrapper.toString());
		return wrapper;
	}

}

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

import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.controllerdto.PurchaseOrderControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.mappers.PurchaseOrderMapper;
import com.pro.scm.service.PlacingOrdersForPurchaseService;
import com.pro.scm.service.PurchaseOrderService;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.servicedto.PurchaseOrderServiceDTO;
import com.pro.scm.utills.IsEmptyUtil;
import com.pro.scm.wrappers.PlacingOrdersForPurchaseWrapper;
import com.pro.scm.wrappers.PurchaseOrderWrapper;

import lombok.extern.slf4j.Slf4j;
/**
 * @author Habiboon Patan
 * @since 13-04-2020
 * @Des : PurchaseOrderController
 */
@Slf4j
@RestController
@RequestMapping("/PurchaseOrderController")
public class PurchaseOrderController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	@Qualifier("objPurchaseOrderServiceImpl")
	private PurchaseOrderService objPurchaseOrderServiceImpl;
	/**
	 * @author : Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 13-04-2020
	 * @Des : savePurchaseOrderItemDetails
	 * @URL : localhost:2000/scmservice/PurchaseOrderController/saveReceivedGoodsDetails
	{	"drugId":1,
		"formId":"1",
		"batchnumber":1,
		"purchasePrice":1,
		"tax":1,
		"mrp":1,
		"unitcost":1,
		"expireDate":1,
		"receivedStock":1,
		"userId":1,
		"moduleId":1,
		"roleId":1,
		"billNo":1,
		"count":1,
		"totallist":1,
		"freeqty":1,
		}
	 */
	@CrossOrigin
	@RequestMapping(value = "/saveReceivedGoodsDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response saveReceivedGoodsDetails(@RequestBody PurchaseOrderControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::saveReceivedGoodsDetails:::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PurchaseOrderServiceDTO dataInfo = new PurchaseOrderServiceDTO();
		PurchaseOrderMapper dataMapper = new PurchaseOrderMapper();
		PurchaseOrderWrapper dataWrapper = new PurchaseOrderWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFormId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBatchnumber())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPurchasePrice())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTax())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getMrp())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUnitcost())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getExpireDate())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getReceivedStock())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getUserId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getModuleId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getRoleId())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getBillNo())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getTotallist())
//				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getFreeqty())
				) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPurchaseOrderServiceImpl.saveReceivedGoodsDetails(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
	log.info(strRequestID + ":::::::::::::::::::::::::::::saveReceivedGoodsDetails()::::::::::::::::" + dataWrapper.toString());
		return dataWrapper;
	}
	/**
	 * @author : Habiboon Patan
	 * @throws : DataNotFoundException
	 * @Date : 2019-07-29
	 * @Des : updatePoitemns
	 * @URL : localhost:2000/scmservice/PurchaseOrderController/updatePoitemns
	{	"drugId":"111",
		"po_id":1,
		"status":true,
		"count":1,
		}
	 */
	@CrossOrigin
	@RequestMapping(value = "/updatePoitemns", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updatePoitemns(@RequestBody PurchaseOrderControllerDTO dataControllerDTO)
			throws DataNotFoundException {
		String strRequestID = request.getAttribute("reqid").toString();
		log.info(strRequestID + "::::::updatePoitemns():::::" + dataControllerDTO);
		List<String> errmsgs = new ArrayList<String>();
		PurchaseOrderServiceDTO dataInfo = new PurchaseOrderServiceDTO();
		PurchaseOrderMapper dataMapper = new PurchaseOrderMapper();
		PurchaseOrderWrapper dataWrapper = new PurchaseOrderWrapper();
		if (IsEmptyUtil.isEmptyObject(dataControllerDTO.getDrugId())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getPo_id())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getStatus())
				|| IsEmptyUtil.isEmptyObject(dataControllerDTO.getCount())) {
			dataWrapper.setResponseCode(HttpStatus.BAD_REQUEST.value());
			dataWrapper.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
		} else {
			dataInfo = dataMapper.conversionControllerDtoToServiceDto(dataControllerDTO);
			String commonresponse = objPurchaseOrderServiceImpl.updatePoitemns(dataInfo, strRequestID);
			dataWrapper.setResponseCode(HttpStatus.OK.value());
			dataWrapper.setStatus(HttpStatus.OK.getReasonPhrase());
			dataWrapper.setErrorsMsgs(errmsgs);
			dataWrapper.setRtnReponseCount(commonresponse);
		}
	log.info(strRequestID + ":::::::::::::::::::::::::::::updatePoitemns()::::::::::::::::" + dataWrapper.toString());
		return dataWrapper;
	}

	}

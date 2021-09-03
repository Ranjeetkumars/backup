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
import com.pro.scm.controllerdto.IndentViewControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.IndentViewMapper;
import com.pro.scm.service.IndentViewService;
import com.pro.scm.servicedto.IndentViewServiceDTO;
import com.pro.scm.wrappers.IndentViewWrapper;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Bhuneshwar
 *
 */
@RestController
@RequestMapping("/indentViewController")
@Slf4j
public class IndentViewController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("objIndentViewService")
	private IndentViewService objIndentViewService;
	@Autowired
	private HttpServletRequest request;
	
	
	/**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun:  load_to_store
	 * @json:{ "counterId":99999}
	 * @URL :http://localhost:2001/scmservice/indentViewController/load_to_store
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/load_to_store", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response load_to_store(@RequestBody IndentViewControllerDTO objControllerDto)
			throws InSufficientInputException, DataNotFoundException {
		log.info("load_to_store method is executed inside indentViewController" + objControllerDto);
		String strRequestID = request.getAttribute("reqid").toString();
		log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
		IndentViewMapper mapper = new IndentViewMapper();
		IndentViewWrapper wrapper = new IndentViewWrapper();
		if (objControllerDto.getCounterId() != null) {
			List<IndentViewServiceDTO> objAddNewLocalDrugServiceDTO = objIndentViewService
					.load_to_store(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
			wrapper.setObjIndentViewControllerDTO(
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
	 * @Date : 30-07-2019
	 * @json:{"drugid":"678", "batchnumber":"10", "issuedqty":"10", "mrp":"89",
	 *                        "purchaseprice":"90", "packid":"09",
	 *                        "expdate":"2019-01-01", "cid":1, "rid":1, "mid":1,
	 *                        "size":1}                     
	 * @URL :
	 *      http://localhost:2001/scmservice/indentViewController/api/version_1/saveReceivedStock
	 */

		@RequestMapping(value = "/api/version_1/saveReceivedStock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response saveReceivedStock(@RequestBody IndentViewControllerDTO objControllerDto)
				throws InSufficientInputException, DataNotFoundException {
			log.info("saveReceivedStock is executed inside indentViewController" + objControllerDto);
			String strRequestID = request.getAttribute("reqid").toString();
			log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
			IndentViewMapper mapper = new IndentViewMapper();
			IndentViewWrapper wrapper = new IndentViewWrapper();
			if (objControllerDto.getDrugid() != null && objControllerDto.getBatchnumber()!= null &&objControllerDto.getIssuedqty()!= null && objControllerDto.getMrp()!= null
					&&objControllerDto.getPurchaseprice()!=null&&objControllerDto.getPackid()!=null&&objControllerDto.getExpdate()!=null
					&&objControllerDto.getCid()!=null&&objControllerDto.getRid()!=null&&objControllerDto.getMid()!=null&&objControllerDto.getSize()!=null) {
				String rtnValueOfMT = objIndentViewService
						.saveReceivedStock(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun: UpdateStock
	 * @json:{"drugid":"678", "batchnumber":"10", "quantity":"89", "size":1}                     
	 * @URL :http://localhost:2001/scmservice/indentViewController/api/version_1/UpdateStock
	 * 
	 */

		@RequestMapping(value = "/api/version_1/UpdateStock", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response UpdateStock(@RequestBody IndentViewControllerDTO objControllerDto)
				throws InSufficientInputException, DataNotFoundException {
			log.info("UpdateStock is executed inside indentViewController" + objControllerDto);
			String strRequestID = request.getAttribute("reqid").toString();
			log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
			IndentViewMapper mapper = new IndentViewMapper();
			IndentViewWrapper wrapper = new IndentViewWrapper();
			if (objControllerDto.getDrugid() != null && objControllerDto.getBatchnumber()!= null &&objControllerDto.getQuantity()!= null && objControllerDto.getSize()!= null) {
				String rtnValueOfMT = objIndentViewService
						.UpdateStock(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun: insertRaiseIndentQuantity
	 * @json:{"drugid":"62", "quantity":"89", "createdById":1, "createdByRoleId":1,
	 *                       "createdByModuleId":1, "size":1, "indentNumber":1 }
	 * 
	 * @URL :http://localhost:2001/scmservice/indentViewController/api/version_1/insertRaiseIndentQuantity
	 * 
	 */

		@RequestMapping(value = "/api/version_1/insertRaiseIndentQuantity", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response insertRaiseIndentQuantity(@RequestBody IndentViewControllerDTO objControllerDto)
				throws InSufficientInputException, DataNotFoundException {
			log.info("insertRaiseIndentQuantity is executed inside indentViewController" + objControllerDto);
			String strRequestID = request.getAttribute("reqid").toString();
			log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
			IndentViewMapper mapper = new IndentViewMapper();
			IndentViewWrapper wrapper = new IndentViewWrapper();
			if (objControllerDto.getDrugid() != null &&objControllerDto.getQuantity()!= null && objControllerDto.getSize()!= null
					&&objControllerDto.getCreatedById()!=null&&objControllerDto.getCreatedByModuleId()!=null&&objControllerDto.getCreatedByRoleId()!=null&&objControllerDto.getIndentNumber()!=null) {
				String rtnValueOfMT = objIndentViewService
						.insertRaiseIndentQuantity(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 31-07-2019
	 * @fun: updateIndentStatus
	 * @json:{ "size":1, "indentNumber":1 }
	 * @URL :http://localhost:2001/scmservice/indentViewController/updateIndentStatus
	 */
		@CrossOrigin
		@RequestMapping(value = "/updateIndentStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response updateIndentStatus(@RequestBody IndentViewControllerDTO objControllerDto)
				throws InSufficientInputException, DataNotFoundException {
			log.info("updateIndentStatus is executed inside indentViewController" + objControllerDto);
			String strRequestID = request.getAttribute("reqid").toString();
			log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
			IndentViewMapper mapper = new IndentViewMapper();
			IndentViewWrapper wrapper = new IndentViewWrapper();
			if (objControllerDto.getIndentNumber()!= null &&objControllerDto.getSize()!= null) {
				String rtnValueOfMT = objIndentViewService
						.updateIndentStatus(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
		 * @author :Bhuneshwar Patel
		 * @throws InSufficientInputException ,DataNotFoundException
		 * @Date : 31-07-2019
		 * @fun:  load_to_store
		 * @json:{ "counterId":99999}
		 * @URL :http://localhost:2001/scmservice/indentViewController/api/version_1/getLoadMainStoreDrugs
		 * 
		 */
		@RequestMapping(value = "/api/version_1/getLoadMainStoreDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response getLoadMainStoreDrugs(@RequestBody IndentViewControllerDTO objControllerDto)
				throws InSufficientInputException, DataNotFoundException {
			log.info("getLoadMainStoreDrugs  method is executed inside indentViewController" + objControllerDto);
			String strRequestID = request.getAttribute("reqid").toString();
			log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
			IndentViewMapper mapper = new IndentViewMapper();
			IndentViewWrapper wrapper = new IndentViewWrapper();
			if (objControllerDto.getDrugid() != null&&objControllerDto.getCurrentdate()!=null) {
				List<IndentViewServiceDTO> objAddNewLocalDrugServiceDTO = objIndentViewService
						.getLoadMainStoreDrugs(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
				wrapper.setObjIndentViewControllerDTO(
						mapper.conversionForServiceTOControllerDTO(objAddNewLocalDrugServiceDTO));
				wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
				wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());

			} else {
				throw new InSufficientInputException(objControllerDto.toString());
			}
			log.info(strRequestID + ":::::::::::::" + wrapper.toString());
			return wrapper;
		}
		
}

package com.pro.scm.controller;

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


import com.pro.scm.controllerdto.CreatePatientIssuesControllerDTO;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.exceptions.InSufficientInputException;
import com.pro.scm.mappers.CreatePatientIssueMapper;
import com.pro.scm.service.CreatePatientIssueService;
import com.pro.scm.servicedto.CreatePatientIssueServiceDTO;
import com.pro.scm.wrappers.CreatePatientIssueWrapper;
import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Bhuneshwar
 *
 */
@RestController
@RequestMapping("/createPatientIssuesController")
@Slf4j
public class CreatePatientIssuesController {
	InSufficientInputException obj;
	@Autowired
	@Qualifier("createPatientIssueService")
	private CreatePatientIssueService createPatientIssueService;
	@Autowired
	private HttpServletRequest request;

	

	  /**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 2-08-2019 loadIndentItemsList
	 * @json:{ "drugid":296 }
	 * @URL :
	 *      http://localhost:2001/scmservice/createPatientIssuesController/api/version_1/getItemsDetails
	 */
		@RequestMapping(value = "/api/version_1/getItemsDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response getItemsDetails(@RequestBody CreatePatientIssuesControllerDTO objControllerDto)
				throws InSufficientInputException, DataNotFoundException {
			log.info("getItemsDetails method is executed inside createPatientIssuesController" + objControllerDto);
			String strRequestID = request.getAttribute("reqid").toString();
			log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
			CreatePatientIssueMapper mapper = new CreatePatientIssueMapper();
			CreatePatientIssueWrapper wrapper = new CreatePatientIssueWrapper();
			if (objControllerDto.getDrugid()!= null) {
				List<CreatePatientIssueServiceDTO> createPatientIssueServiceDTO = createPatientIssueService
						.getItemsDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
				wrapper.setCreatePatientIssuesControllerDTO(mapper.conversionForServiceTOControllerDTO(createPatientIssueServiceDTO));
				wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
				wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
							
			} else {
				throw new InSufficientInputException(objControllerDto.toString());
			}
			log.info(strRequestID + ":::::::::::::" + wrapper.toString());
			return wrapper;
		}
		
		/**
		 * @author : Bhuneshwar patel
		 * @throws InSufficientInputException ,DataNotFoundException
		 * @Date : 2-08-2019
		 * @Des : getAlternateDrugs
		 * @URL :
		 *      http://localhost:2001/scmservice/createPatientIssuesController/api/version_1/getAlternateDrugs
		 * 
		 */
		@RequestMapping(value = "/api/version_1/getAlternateDrugs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public Response getAlternateDrugs() throws InSufficientInputException, DataNotFoundException {
			log.info("getAlternateDrugs method is executed inside createPatientIssuesController");
			String strRequestID = request.getAttribute("reqid").toString();
			CreatePatientIssueWrapper wrapper = new CreatePatientIssueWrapper();
			List<CreatePatientIssueServiceDTO> createPatientIssueServiceDTO = createPatientIssueService.getAlternateDrugs(strRequestID);
			wrapper.setCreatePatientIssuesControllerDTO(
					new CreatePatientIssueMapper().conversionForServiceTOControllerDTO(createPatientIssueServiceDTO));
			wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
			wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
			log.info(strRequestID + ":::::::::::::" + wrapper.toString());
			return wrapper;
		}
	

		  /**
	 * @author :Bhuneshwar Patel
	 * @throws InSufficientInputException ,DataNotFoundException
	 * @Date : 2-08-2019 loadIndentItemsList
	 * @json:{ "drug_name":"1" }
	 * 
	 * @URL :
	 *      http://localhost:2001/scmservice/createPatientIssuesController/api/version_1/showBatchWiseDrugs
	 */
			@RequestMapping(value = "/api/version_1/showBatchWiseDrugs", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			public Response showBatchWiseDrugs(@RequestBody CreatePatientIssuesControllerDTO objControllerDto)
					throws InSufficientInputException, DataNotFoundException {
				log.info("showBatchWiseDrugs method is executed inside createPatientIssuesController" + objControllerDto);
				String strRequestID = request.getAttribute("reqid").toString();
				log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
				CreatePatientIssueMapper mapper = new CreatePatientIssueMapper();
				CreatePatientIssueWrapper wrapper = new CreatePatientIssueWrapper();
				if (objControllerDto.getDrug_name()!= null) {
					List<CreatePatientIssueServiceDTO> createPatientIssueServiceDTO = createPatientIssueService
							.showBatchWiseDrugs(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
					wrapper.setCreatePatientIssuesControllerDTO(mapper.conversionForServiceTOControllerDTO(createPatientIssueServiceDTO));
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
	 * @json: { "billId":153467, "pdb_billno":123333, "pbd_vatpercentage":123,
	 *        "pbd_vatprice":1233, "pbd_amounttopay":5667, "pbd_createdbyid":1,
	 *        "pbd_createdbymoduleid":1, "pbd_createdbyroleid":1,
	 *        "pdb_createddate":"2019-01-01", "pbd_isactive":false,
	 *        "pdb_patient_name":"Raja", "pbd_doctor_id":1, "pbd_ward_id":1,
	 *        "pbd_employee_id":1, "store_id":1
	 * 
	 *        }
	 * @URL :
	 *      http://localhost:2001/scmservice/createPatientIssuesController/api/version_1/saveInpatientIssues
	 */

			@RequestMapping(value = "/api/version_1/saveInpatientIssues", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			public Response saveInpatientIssues(@RequestBody CreatePatientIssuesControllerDTO objControllerDto)
					throws InSufficientInputException, DataNotFoundException {
				log.info("saveInpatientIssues method is executed inside createPatientIssuesController" + objControllerDto);
				String strRequestID = request.getAttribute("reqid").toString();
				log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
				CreatePatientIssueMapper mapper = new CreatePatientIssueMapper();
				CreatePatientIssueWrapper wrapper = new CreatePatientIssueWrapper();
				if (objControllerDto.getBillId() != null &&objControllerDto.getPdb_billno()!=null
						&&objControllerDto.getPbd_vatpercentage()!=null&&objControllerDto.getPbd_vatprice()!=null
						&&objControllerDto.getPbd_amounttopay()!=null&&objControllerDto.getPbd_createdbyid()!=null&&objControllerDto.getPbd_createdbymoduleid()!=null
						&&objControllerDto.getPbd_createdbyroleid()!=null&&objControllerDto.getPdb_createddate()!=null&&objControllerDto.getPbd_isactive()!=null
						&&objControllerDto.getPdb_patient_name()!=null&&objControllerDto.getPbd_doctor_id()!=null&&objControllerDto.getPbd_ward_id()!=null
						&&objControllerDto.getPbd_employee_id()!=null&&objControllerDto.getStore_id()!=null) {
					String rtnValueOfMT = createPatientIssueService
							.saveInpatientIssues(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
	 * @Date : 30-07-2019
	 * @json: { "drugid":"2333", "qty":"33", "expire_date":"2019-01-01",
	 *        "batch_number":"1233", "unit_cost":"5667", "userId":1, "roleId":1,
	 *        "moduleid":1, "stipno":"2019-01-01", "pdb_billno":"648",
	 *        "pbd_vatpercentage":1, "size":1 }
	 * @URL :
	 *      http://localhost:2001/scmservice/createPatientIssuesController/api/version_1/saveInpatientDetails
	 */

			@RequestMapping(value = "/api/version_1/saveInpatientDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			public Response saveInpatientDetails(@RequestBody CreatePatientIssuesControllerDTO objControllerDto)
					throws InSufficientInputException, DataNotFoundException {
				log.info("saveInpatientDetails method is executed inside createPatientIssuesController" + objControllerDto);
				String strRequestID = request.getAttribute("reqid").toString();
				log.info("ControllerDto  Data=" + objControllerDto + "With RequestId=" + strRequestID);
				CreatePatientIssueMapper mapper = new CreatePatientIssueMapper();
				CreatePatientIssueWrapper wrapper = new CreatePatientIssueWrapper();
				if (objControllerDto.getDrugid() != null && objControllerDto.getQty() != null&&objControllerDto.getExpire_date()!=null
						&&objControllerDto.getBatch_number()!=null&&objControllerDto.getUnit_cost()!=null
						&&objControllerDto.getUserId()!=null&&objControllerDto.getRoleId()!=null&&objControllerDto.getModuleid()!=null
						&&objControllerDto.getStipno()!=null&&objControllerDto.getPdb_billno()!=null&&objControllerDto.getPbd_vatpercentage()!=null
						&&objControllerDto.getSize()!=null) {
					String rtnValueOfMT = createPatientIssueService
							.saveInpatientDetails(mapper.conversionControllerDtoToServiceDto(objControllerDto), strRequestID);
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
			
}

package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.CreatePatientIssueMapper;
import com.pro.scm.persistencedto.CreatePatientIssuesPersistenceDTO;
import com.pro.scm.service.CreatePatientIssueService;
import com.pro.scm.servicedto.CreatePatientIssueServiceDTO;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unchecked")
@Service("createPatientIssueService")
@Slf4j
public class CreatePatientIssueServiceImpl implements CreatePatientIssueService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	@Override
	public List<CreatePatientIssueServiceDTO> getItemsDetails(CreatePatientIssueServiceDTO createPatientIssueServiceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("getItemsDetails method is executed inside CreatePatientIssueServiceImpl");
		List<CreatePatientIssueServiceDTO> listOfData;
		String strQuery="select * from sp_select_pms_drug_reg_ref_all_drug_details("+createPatientIssueServiceDTO.getDrugid()+")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			CreatePatientIssueMapper mapper = new CreatePatientIssueMapper();
			List<CreatePatientIssuesPersistenceDTO> persistenceDtos = mapper.getItemsDetails(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}
	
	

	@Override
	public List<CreatePatientIssueServiceDTO> getAlternateDrugs(String strRequestID) throws DataNotFoundException {
		log.info("getAlternateDrugs method is executed inside CreatePatientIssueServiceImpl");
		List<CreatePatientIssueServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				" select * from sp_select_pms_drug_reg_mainstore_received_trans()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			CreatePatientIssueMapper mapper = new CreatePatientIssueMapper();
			List<CreatePatientIssuesPersistenceDTO> persistenceDtos = mapper.getAlternateDrugs(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<CreatePatientIssueServiceDTO> showBatchWiseDrugs(
			CreatePatientIssueServiceDTO createPatientIssueServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("showBatchWiseDrugs method is executed inside CreatePatientIssueServiceImpl");
		List<CreatePatientIssueServiceDTO> listOfData;
		String strQuery="SELECT drr_drug_id, dr_short_unic_code, dr_drug_name, drr_batch_number, cast(drr_expire_date as date), drr_available_stock, drr_unit_cost FROM sp_select_pharmacy_sales_qty( '"+createPatientIssueServiceDTO.getDrug_name()+"', 0, 0, 0, '¥',0, 0, 0)";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			CreatePatientIssueMapper mapper = new CreatePatientIssueMapper();
			List<CreatePatientIssuesPersistenceDTO> persistenceDtos = mapper.showBatchWiseDrugs(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	
	@Override
	public String saveInpatientIssues(CreatePatientIssueServiceDTO createPatientIssueServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("saveInpatientIssues method is executed inside CreatePatientIssueServiceImpl");
		String strTicketIdQuery = "select * from get_eventid()";
		String patientId = objSupervisorDao.saveData(strTicketIdQuery);
		String strQuery="select * from sp_insert_pms_patientdrug_bill_details_trans("+createPatientIssueServiceDTO.getBillId()+",'"+patientId+"','"
				+createPatientIssueServiceDTO.getPdb_billno()+"',"+createPatientIssueServiceDTO.getPbd_vatpercentage()+","
				+createPatientIssueServiceDTO.getPbd_vatprice()+","+createPatientIssueServiceDTO.getPbd_amounttopay()+","
				+createPatientIssueServiceDTO.getPbd_createdbyid()+","+createPatientIssueServiceDTO.getPbd_createdbymoduleid()+","
				+createPatientIssueServiceDTO.getPbd_createdbyroleid()+",'"+createPatientIssueServiceDTO.getPdb_createddate()+"',"
				+createPatientIssueServiceDTO.getPbd_isactive()+",'"+createPatientIssueServiceDTO.getPdb_patient_name()+"',"
				+createPatientIssueServiceDTO.getPbd_doctor_id()+",'"+createPatientIssueServiceDTO.getPbd_ward_id()+"',"
				+createPatientIssueServiceDTO.getPbd_employee_id()+","+createPatientIssueServiceDTO.getStore_id()+")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}

	@Override
	public String saveInpatientDetails(CreatePatientIssueServiceDTO createPatientIssueServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("saveInpatientDetails method is executed inside CreatePatientIssueServiceImpl");
		String strQuery="select * from sp_insert_update_pms_inpatient_issues('"+createPatientIssueServiceDTO.getDrugid()+"','"+createPatientIssueServiceDTO.getQty()+
				"','"+createPatientIssueServiceDTO.getExpire_date()+"','"+createPatientIssueServiceDTO.getBatch_number()+"','"
				+createPatientIssueServiceDTO.getUnit_cost()+"',"+createPatientIssueServiceDTO.getUserId()+","+createPatientIssueServiceDTO.getRoleId()+","
				+createPatientIssueServiceDTO.getModuleid()+",'"+createPatientIssueServiceDTO.getStipno()+"','"+createPatientIssueServiceDTO.getPdb_billno()+"',"
				+createPatientIssueServiceDTO.getPbd_vatpercentage()+","+createPatientIssueServiceDTO.getSize()+")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}

}

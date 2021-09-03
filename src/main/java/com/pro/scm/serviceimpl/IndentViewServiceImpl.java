package com.pro.scm.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.IndentViewMapper;
import com.pro.scm.persistencedto.IndentViewPersistenceDTO;
import com.pro.scm.service.IndentViewService;
import com.pro.scm.servicedto.IndentViewServiceDTO;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unchecked")
@Service("objIndentViewService")
@Slf4j
public class IndentViewServiceImpl implements IndentViewService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public List<IndentViewServiceDTO> load_to_store(IndentViewServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("load_to_store method is executed inside IndentViewServiceImpl");
		List<IndentViewServiceDTO> listOfData;
		String strQuery="SELECT cr_counterid, cr_countername FROM pms_counter_registration_ref WHERE cr_counterid="+serviceDTO.getCounterId()+"";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentViewMapper mapper = new IndentViewMapper();
			List<IndentViewPersistenceDTO> persistenceDtos = mapper.load_to_store(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public String saveReceivedStock(IndentViewServiceDTO serviceDto, String strRequestID) throws DataNotFoundException {
		log.info("saveReceivedStock method is executed inside IndentViewServiceImpl");
		String strQuery="select * from sp_insert_pharmacy_pms_drug_retail_trans('"+serviceDto.getDrugid()+"','"+serviceDto.getBatchnumber()+"','"
				+serviceDto.getIssuedqty()+"','"+serviceDto.getMrp()+"','"+serviceDto.getPurchaseprice()+"','"+serviceDto.getPackid()+"','"+serviceDto.getExpdate()+"',"
				+serviceDto.getCid()+","+serviceDto.getRid()+","+serviceDto.getMid()+","+serviceDto.getSize()+")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}
	
	@Override
	public String UpdateStock(IndentViewServiceDTO serviceDto, String strRequestID) throws DataNotFoundException {
		log.info("UpdateStock method is executed inside IndentViewServiceImpl");
		String strQuery="select * from sp_update_pharmacy_drug_mainstore_trans('"+serviceDto.getDrugid()+"','"+serviceDto.getBatchnumber()+"','"+serviceDto.getQuantity()+"',"+serviceDto.getSize()+")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}

	@Override
	public String insertRaiseIndentQuantity(IndentViewServiceDTO serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("insertRaiseIndentQuantity method is executed inside IndentViewServiceImpl");
		String strQuery="select * from sp_insert_pms_scm_ind_retail_wise_item_req_trans('"+serviceDto.getDrugid()+"','"+serviceDto.getQuantity()+"',"
		 +serviceDto.getCreatedById()+","+serviceDto.getCreatedByRoleId()+","+serviceDto.getCreatedByModuleId()+
		 ","+serviceDto.getSize()+",'"+serviceDto.getIndentNumber()+"')";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}

	@Override
	public String updateIndentStatus(IndentViewServiceDTO serviceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("insertRaiseIndentQuantity method is executed inside IndentViewServiceImpl");
		String strQuery="select * from sp_update_indent_raised_approval('"+serviceDto.getIndentNumber()+"',"+serviceDto.getSize()+")";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		return objSupervisorDao.saveData(strQuery);
	}

	@Override
	public List<IndentViewServiceDTO> getLoadMainStoreDrugs(IndentViewServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("getLoadMainStoreDrugs method is executed inside IndentViewServiceImpl");
		List<IndentViewServiceDTO> listOfData;
		String strQuery="select * from sp_select_pms_drug_mainstore_received_trans_details("+serviceDTO.getDrugid()+",'"+serviceDTO.getCurrentdate()+"')";
		log.info(strRequestID + ":::::::::::::::Query:::::::::::" +strQuery);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(strQuery);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			IndentViewMapper mapper = new IndentViewMapper();
			List<IndentViewPersistenceDTO> persistenceDtos = mapper.getLoadMainStoreDrugs(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

}

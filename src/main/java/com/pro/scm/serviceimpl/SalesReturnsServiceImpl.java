package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.SalesReturnsMapper;
import com.pro.scm.persistencedto.SalesReturnsPersistenceDTO;
import com.pro.scm.service.SalesReturnsService;
import com.pro.scm.servicedto.SalesReturnsServiceDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objSalesReturnsServiceImpl")
@SuppressWarnings("unchecked")
public class SalesReturnsServiceImpl implements SalesReturnsService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String saveReturnDetails(SalesReturnsServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
	
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_sales_return_trans( '").append(dataServiceDTO.getBillNumber()).append("','")
		.append(dataServiceDTO.getRetun_amount() ).append("','").append(dataServiceDTO.getDrugId()).append("','")
		.append(dataServiceDTO.getBatch_code()).append("','").append(dataServiceDTO.getExpdate() ).append("','")
		.append(dataServiceDTO.getReturn_quantity() ).append("',").append(dataServiceDTO.getCount()).append(",")
		.append(dataServiceDTO.getUserId()).append(",").append(dataServiceDTO.getModuleId()).append(",").append(dataServiceDTO.getRoleId())
		.append(")");
		log.info(strRequestID + "::::::SalesReturnsServiceImpl():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;
	}

	@Override
	public String updateReturnStock(SalesReturnsServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_patient_drug_sales_returns( '").append(dataServiceDTO.getDrugId()).append("','")
		.append(dataServiceDTO.getReturn_quantity()).append("','").append(dataServiceDTO.getRetun_amount()).append("',")
		.append(dataServiceDTO.getCount() ).append(",'").append(dataServiceDTO.getReturnRate() ).append("','")
		.append(dataServiceDTO.getBillNumber()).append("','").append(dataServiceDTO.getBatch_code()).append("')");
		log.info(strRequestID + "::::::updateReturnStock():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;
	}

	@Override
	public List<SalesReturnsServiceDTO> getBillDetails(SalesReturnsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		List<SalesReturnsServiceDTO> listOfData;
		stringBuilder.append("select * from sp_select_search_pms_patientdrug_bill_details_trans('")
		.append( dataInfo.getBillNumber() ).append("','").append(dataInfo.getPatientName()).append("','").append(dataInfo.getCreatedByDate())
		.append( "')");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SalesReturnsMapper dataMapper = new SalesReturnsMapper();
			List<SalesReturnsPersistenceDTO> salesReturnsPersDTOs = dataMapper.ConvertDataToGetBillDetails(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(salesReturnsPersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SalesReturnsServiceDTO> getBillItemDetails(SalesReturnsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		List<SalesReturnsServiceDTO> listOfData;
		stringBuilder.append("select * from  sp_select_pms_loadbill_Drugs_details('").append(dataInfo.getBillNumber()).append("')");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SalesReturnsMapper dataMapper = new SalesReturnsMapper();
			List<SalesReturnsPersistenceDTO> salesReturnsPersDTOs = dataMapper.ConvertDataToGetBillItemDetails(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(salesReturnsPersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

}

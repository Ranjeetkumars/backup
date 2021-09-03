package com.pro.scm.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.AdjustmentStockMapper;
import com.pro.scm.persistencedto.AdjustmentStockPersistenceDTO;
import com.pro.scm.service.AdjustmentStockService;
import com.pro.scm.servicedto.AdjustmentStockServiceDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objAdjustmentStockServiceImpl")
public class AdjustmentStockServiceImpl implements AdjustmentStockService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override

	public String countDrugsByStore(AdjustmentStockServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		String fromStore = dataServiceDTO.getFromStoreId();
		Integer result = Integer.valueOf(fromStore);
		if (result != 99999) {
			stringBuilder.append("select count(*) from sp_select_pms_adjustment_search('").append(dataServiceDTO.getDrugName()).append("',")
			.append(dataServiceDTO.getBrandId()).append(",").append(dataServiceDTO.getFormId()).append(",")
			.append(dataServiceDTO.getManufacturerId()) .append( ",'").append(dataServiceDTO.getShortcode()).append("',")
			.append(dataServiceDTO.getSystemId()).append(",").append(dataServiceDTO.getGenericGroupId()).append(",")
			.append(dataServiceDTO.getGenericMoleculeId() ).append(",").append(dataServiceDTO.getFromStoreId()).append(",")
			.append(dataServiceDTO.getTypeId()).append( ")");
		} else if (result == 99999) {// fromStoreId = ----> From Central
			stringBuilder.append("select count(*)  from sp_select_pms_adjustment_search_for_mainstore('")
			.append(dataServiceDTO.getDrugName()).append( "',").append(dataServiceDTO.getBrandId()).append(",")
			.append(dataServiceDTO.getFormId()).append(",").append(dataServiceDTO.getManufacturerId()).append(",'")
			.append(dataServiceDTO.getShortcode()).append("',").append(dataServiceDTO.getSystemId()).append(",")
			.append(dataServiceDTO.getGenericGroupId()).append(",").append(dataServiceDTO.getGenericMoleculeId()).append(",")
			.append(dataServiceDTO.getTypeId()).append(")");
		}
		log.info(strRequestID + "::::::countDrugsByStore():::::::" + stringBuilder.toString());
		String listData = null;
		if (null != dataServiceDTO) {
			listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		}
		return listData;

	}
	@Override
	public String updateStockQuantity(AdjustmentStockServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		String fromStore = dataServiceDTO.getFromStoreId();
		StringBuilder stringBuilder = new StringBuilder();
		Integer result = Integer.valueOf(fromStore);
		if (result != 99999) {
			stringBuilder.append("select * from sp_update_pms_drug_retail_received_trans('").append(dataServiceDTO.getDrugId()).append("','")
			.append(dataServiceDTO.getDrugQtys()) .append( "','").append(dataServiceDTO.getDrugBatchs()).append("',")
			.append(dataServiceDTO.getSize() ).append( ",").append(dataServiceDTO.getIncreaseOrDecrease()) .append(",")
			.append(dataServiceDTO.getUser_id()).append(",").append(dataServiceDTO.getModule_id()).append(",")
			.append(dataServiceDTO.getRole_id() ).append( ",'").append(dataServiceDTO.getBufStockRefId()) .append("')");
		} else if (result == 99999) {
			stringBuilder.append("select * from sp_update_pms_drug_mainstore_received_trans('").append(dataServiceDTO.getDrugId()).append("','")
			.append(dataServiceDTO.getDrugQtys()).append("','").append(dataServiceDTO.getDrugBatchs()).append("',")
			.append(dataServiceDTO.getSize()).append(",").append(dataServiceDTO.getIncreaseOrDecrease()).append(",")
			.append(dataServiceDTO.getUser_id()).append(",").append(dataServiceDTO.getModule_id()).append(",")
			.append(dataServiceDTO.getRole_id()).append(",'").append(dataServiceDTO.getBufStockRefId()).append( "')");
		}
		log.info(strRequestID + "::::::updateStockQuantity():::::::" + stringBuilder.toString());
		String listData = null;
		if (null != dataServiceDTO) {
			listData = objSupervisorDao.saveData(stringBuilder.toString());
		}
		return listData;

	}

	@Override
	public List<AdjustmentStockServiceDTO> loadEmployees(AdjustmentStockServiceDTO  serviceDto , String strRequestID) throws DataNotFoundException {
		List<AdjustmentStockServiceDTO> datas = new ArrayList<AdjustmentStockServiceDTO>();
		
		AdjustmentStockMapper dataMapper = new AdjustmentStockMapper();
		String rtnSingleSupplier = "select * from sp_select_scm_supplier_wise_costdetails("+serviceDto.getDrugId()+")";
		//SELECT dd_supplierid, dd_suppliername FROM pms_drugs_supplier_ref where dd_isactive = true order by 2
		log.info(strRequestID + ":::::::::::::::getAllSuppliers:::::::::::" + rtnSingleSupplier);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(rtnSingleSupplier);
		if (null != list && !list.isEmpty()) {
			List<AdjustmentStockPersistenceDTO> adjustmentStockPersDTOs = dataMapper
					.convertObjetsArraytoGetEmployees(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(adjustmentStockPersDTOs);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::getAllSuppliers()::::::");
		}
		return datas;

	}

	@Override
	public String saveAdjustedStockDetails(AdjustmentStockServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_adjustable_trans_type('").append(dataServiceDTO.getBufStockRefId()).append("','")
		.append(dataServiceDTO.getDrugId()).append("','").append(dataServiceDTO.getDrugBatchs()).append("','")
		.append( dataServiceDTO.getDrugQtys()).append("',").append(dataServiceDTO.getStoreId()).append(",")
		.append(dataServiceDTO.getAdj_type_id()).append(",").append(dataServiceDTO.getEmp_id()).append(",'").append(dataServiceDTO.getDesc())
		.append("',").append(dataServiceDTO.getCount()).append(",").append(dataServiceDTO.getUser_id()).append(",")
		.append(dataServiceDTO.getModule_id()).append(",").append(dataServiceDTO.getRole_id()).append(",'").append(dataServiceDTO.getExpDate())
		.append("',").append(dataServiceDTO.getTypeId()).append(",'").append(dataServiceDTO.getInviceNo()).append("')");
		log.info(strRequestID + "::::::saveAdjustedStockDetails():::::::" +stringBuilder.toString());
		String listData = null;
		if (null != dataServiceDTO) {
			listData = objSupervisorDao.saveData(stringBuilder.toString());
		}
		return listData;

	}
	
	
	@Override
	public List<AdjustmentStockServiceDTO> loadEmployees(String strRequestID) throws DataNotFoundException {
		List<AdjustmentStockServiceDTO> datas = new ArrayList<AdjustmentStockServiceDTO>();
		StringBuilder stringBuilder = new StringBuilder();
		AdjustmentStockMapper dataMapper = new AdjustmentStockMapper();
		stringBuilder.append("SELECT dd_supplierid, dd_suppliername FROM pms_drugs_supplier_ref where dd_isactive = true order by 2");
		log.info(strRequestID + ":::::::::::::::getAllSuppliers:::::::::::" + stringBuilder.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<AdjustmentStockPersistenceDTO> adjustmentStockPersDTOs = dataMapper
					.convertObjetsArraytoGetEmployees2(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(adjustmentStockPersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::getAllSuppliers()::::::");
		}
		return datas;

	}
}

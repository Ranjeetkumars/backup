package com.pro.scm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.service.PurchaseOrderService;
import com.pro.scm.servicedto.PurchaseOrderServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objPurchaseOrderServiceImpl")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override

	public String saveReceivedGoodsDetails(PurchaseOrderServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_mainstore_received_list_trans('").append(dataServiceDTO.getDrugId())
		.append( "','").append(dataServiceDTO.getFormId()).append("','").append(dataServiceDTO.getBatchnumber()).append("','")
		.append(dataServiceDTO.getPurchasePrice()).append("','").append(dataServiceDTO.getTax() ).append("','").append(dataServiceDTO.getMrp())
		.append("','").append(dataServiceDTO.getUnitcost()).append("','").append(dataServiceDTO.getExpireDate() ).append("','")
		.append(dataServiceDTO.getReceivedStock() ).append("',").append(dataServiceDTO.getUserId()).append(",")
		.append(dataServiceDTO.getModuleId() ).append(",").append(dataServiceDTO.getRoleId()).append(",'")
		.append(dataServiceDTO.getSupplierId()).append("','").append(dataServiceDTO.getBillNo()).append("',").append(dataServiceDTO.getCount())
		.append( ",'").append(dataServiceDTO.getTotallist()).append("','").append(dataServiceDTO.getFreeqty()).append("')");
		log.info(strRequestID + "::::::savePurchaseOrderItemDetails():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}
	@Override
	public String updatePoitemns(PurchaseOrderServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_poiteme_details('").append(dataServiceDTO.getDrugId()).append("',")
		.append( dataServiceDTO.getPo_id()).append(",").append(dataServiceDTO.getStatus()).append(",").append(dataServiceDTO.getCount()).append( ")");
		log.info(strRequestID + "::::::updatePoitemns():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}
}

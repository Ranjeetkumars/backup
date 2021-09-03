package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.AmbToAmbTransferMapper;
import com.pro.scm.persistencedto.AmbToAmbTransferPersistenceDTO;
import com.pro.scm.service.AmbToAmbTransferService;
import com.pro.scm.servicedto.AcceptTransferItemsServiceDto;
import com.pro.scm.servicedto.AmbToAmbTransferServiceDTO;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unchecked")
@Service("ambToAmbTransferService")
@Slf4j
public class AmbToAmbTransferServiceImpl implements AmbToAmbTransferService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public List<AmbToAmbTransferServiceDTO> loadVehicleItems(AmbToAmbTransferServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadVehicleItems method is executed inside ExpiryDrugsServiceImpl");
		List<AmbToAmbTransferServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"select * from sp_select_scm_vehciel_based_items_for_transfer(" + serviceDTO.getVehicleId() + ")");
		log.info(strRequestID + ":::::::::::::::query:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
			List<AmbToAmbTransferPersistenceDTO> persistenceDtos = mapper.getloadVehicleItems(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AmbToAmbTransferServiceDTO> loadVehicleReqAmbItems(AmbToAmbTransferServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("loadVehicleReqAmbItems method is executed inside ExpiryDrugsServiceImpl");
		List<AmbToAmbTransferServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				" select dr_short_unic_code,dr_drug_name,drr_available_stock ,drr_drug_id from sp_select_scm_vehciel_based_availitems_oftransfervehicle("
						+ serviceDTO.getVehicleId() + ")");
		log.info(strRequestID + ":::::::::::::::query:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
			List<AmbToAmbTransferPersistenceDTO> persistenceDtos = mapper.getloadVehicleReqAmbItems(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AmbToAmbTransferServiceDTO> getAllCounterMedicines(
			AmbToAmbTransferServiceDTO ambToAmbTransferServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("getAllCounterMedicines method is executed inside ExpiryDrugsServiceImpl");
		List<AmbToAmbTransferServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pharmacy_counter_wise_indent_qty('");
		stringBuilder.append(ambToAmbTransferServiceDTO.getGeneric_drug_name());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(ambToAmbTransferServiceDTO.getBrand_id());
		stringBuilder.append(",");
		stringBuilder.append(ambToAmbTransferServiceDTO.getForm_id());
		stringBuilder.append(",");
		stringBuilder.append(ambToAmbTransferServiceDTO.getManufacture_id());
		stringBuilder.append(",");
		stringBuilder.append("'");
		stringBuilder.append(ambToAmbTransferServiceDTO.getUnicode());
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append(ambToAmbTransferServiceDTO.getSystem_id());
		stringBuilder.append(",");
		stringBuilder.append(ambToAmbTransferServiceDTO.getGeneric_group_id());
		stringBuilder.append(",");
		stringBuilder.append(ambToAmbTransferServiceDTO.getGeneric_molecules_id());
		stringBuilder.append(",");
		stringBuilder.append(ambToAmbTransferServiceDTO.getCounterid());
		stringBuilder.append(")");
		log.info(strRequestID + ":::::::::::::::query:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
			List<AmbToAmbTransferPersistenceDTO> persistenceDtos = mapper.getAllCounterMedicines(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AmbToAmbTransferServiceDTO> getRetailIndentDetails(AmbToAmbTransferServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("getRetailIndentDetails method is executed inside ExpiryDrugsServiceImpl");
		List<AmbToAmbTransferServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append(" select * from sp_select_pharmacy_counter_yesterday_drugs(" + serviceDTO.getCounterid() + ")");
		log.info(strRequestID + ":::::::::::::::query:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AmbToAmbTransferMapper mapper = new AmbToAmbTransferMapper();
			List<AmbToAmbTransferPersistenceDTO> persistenceDtos = mapper.getRetailIndentDetails(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public String saveUpdateItems(AcceptTransferItemsServiceDto serviceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder sb = new StringBuilder("select * from sp_InsertUpdate_scm_transfer_retail_veh_to_veh('")
				.append(serviceDTO.getDrug_idlist()).append("','").append(serviceDTO.getDrug_batchlist()).append("','")
				.append(serviceDTO.getStock_ref_list()).append("','").append(serviceDTO.getDr_expt()).append("','")
				.append(serviceDTO.getDrug_qtylist()).append("','").append(serviceDTO.getDrug_noofstrips())
				.append("','").append(serviceDTO.getDr_pr_price()).append("','").append(serviceDTO.getDr_mrp())
				.append("','").append(serviceDTO.getDr_uni_cost()).append("',").append(serviceDTO.getFrom_vehicle_id())
				.append(",").append(serviceDTO.getTo_vehidi()).append(",").append(serviceDTO.getSize()).append(",'")
				.append(serviceDTO.getDr_reaminingqty()).append("','").append(serviceDTO.getDr_remainingstrips())
				.append("',").append(serviceDTO.getUserid()).append(",").append(serviceDTO.getModuleid()).append(",")
				.append(serviceDTO.getRoleid()).append(",'").append(serviceDTO.getDr_transferid()).append("')");
		return objSupervisorDao.saveData(sb.toString());
	}


	@Override
	public String saveTransferItemsDetails(AcceptTransferItemsServiceDto serviceDTO, String strRequestID)
			throws DataNotFoundException {

		StringBuilder sb = new StringBuilder("select * from sp_insert_pms_drug_transfer_veh_to_veh_trans('")
				.append(serviceDTO.getDrug_idlist())
				.append("','").
				append(serviceDTO.getDrug_batchlist())
				.append("','")
				.append(serviceDTO.getDr_expt())
				.append("','")
				.append(serviceDTO.getDrug_qtylist())
				.append("','")
				.append(serviceDTO.getDrug_noofstrips())
				.append("','")
				.append(serviceDTO.getDr_pr_price())
				.append("','")
				.append(serviceDTO.getDr_mrp())
				.append("','")
				.append(serviceDTO.getDr_uni_cost())
				.append("',")
				.append(serviceDTO.getFrom_vehicle_id())
				.append(",")
				.append(serviceDTO.getTo_vehidi())
				.append(",")
				.append(serviceDTO.getSize())
				.append(",")
				.append(serviceDTO.getUserid())
				.append(",")
				.append(serviceDTO.getModuleid())
				.append(",")
				.append(serviceDTO.getRoleid())
				.append(")");
       log.info(sb.toString());
		return objSupervisorDao.saveData(sb.toString());
	}

}

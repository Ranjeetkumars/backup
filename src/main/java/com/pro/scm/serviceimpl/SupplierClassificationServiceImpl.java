package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.SupplierClassificationMapper;
import com.pro.scm.persistencedto.SupplierClassificationPersistenanceDTO;
import com.pro.scm.service.SupplierClassificationService;
import com.pro.scm.servicedto.SupplierClassificationServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objSupplierClassificationService")
public class SupplierClassificationServiceImpl implements SupplierClassificationService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String saveorupdateSupplierClass(SupplierClassificationServiceDTO objSupplierClassificationServiceDTO,
			String strRequestID, String operation_type) throws DataNotFoundException {
		log.info("saveorupdateSupplierClass method is executed inside SupplierClassificationServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		if (operation_type == "1") {
			stringBuilder.append(" SELECT * FROM sp_pms_masters_insert_update_pms_supplier_classification_ref(")
					.append("0").append(",'").append(objSupplierClassificationServiceDTO.getClassification_name())
					.append("','").append(objSupplierClassificationServiceDTO.getClassification_description())
					.append("',").append(objSupplierClassificationServiceDTO.getUserId()).append(",")
					.append(objSupplierClassificationServiceDTO.getRoleId()).append(",")
					.append(objSupplierClassificationServiceDTO.getModuleId()).append(",")
					.append(objSupplierClassificationServiceDTO.getStatus()).append(",")
					.append(objSupplierClassificationServiceDTO.getOperation_type()).append(")");
		} else {
			stringBuilder.append(" SELECT * FROM sp_pms_masters_insert_update_pms_supplier_classification_ref(")
					.append(objSupplierClassificationServiceDTO.getClassification_id()).append(",'")
					.append(objSupplierClassificationServiceDTO.getClassification_name()).append("','")
					.append(objSupplierClassificationServiceDTO.getClassification_description()).append("',")
					.append(objSupplierClassificationServiceDTO.getUserId()).append(",")
					.append(objSupplierClassificationServiceDTO.getModuleId()).append(",")
					.append(objSupplierClassificationServiceDTO.getRoleId()).append(",")
					.append(objSupplierClassificationServiceDTO.getStatus()).append(",")
					.append(objSupplierClassificationServiceDTO.getOperation_type()).append(")");
		}
		log.info(strRequestID + ":::::::::::::::saveorupdateSupplierClass:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<SupplierClassificationServiceDTO> loadSupplierClassification(String strRequestID)
			throws DataNotFoundException {
		log.info("loadSupplierClassification method is executed inside MasterDataServiceImpl");
		List<SupplierClassificationServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_pms_masters_select_pms_supplier_classification_ref()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierClassificationMapper objSupplierClassificationMapper = new SupplierClassificationMapper();
			List<SupplierClassificationPersistenanceDTO> objBrandDetailsPeristenanceDTO = objSupplierClassificationMapper
					.conversionForSupplierClassification(list);
			listOfData = objSupplierClassificationMapper
					.conversionpersistanceDTOtoServiceDTO(objBrandDetailsPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierClassificationServiceDTO> loadSupplierClassificationBasedId(String Classification_id,
			String strRequestID) throws DataNotFoundException {
		log.info("loadSupplierClassification method is executed inside MasterDataServiceImpl");
		List<SupplierClassificationServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_pms_masters_select_pms_supplier_classification_ref("+Classification_id+")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierClassificationMapper objSupplierClassificationMapper = new SupplierClassificationMapper();
			List<SupplierClassificationPersistenanceDTO> objBrandDetailsPeristenanceDTO = objSupplierClassificationMapper
					.conversionForSupplierClassification(list);
			listOfData = objSupplierClassificationMapper
					.conversionpersistanceDTOtoServiceDTO(objBrandDetailsPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}
}

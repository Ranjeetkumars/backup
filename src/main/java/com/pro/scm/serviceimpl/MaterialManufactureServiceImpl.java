package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.MaterialManufactureMapper;
import com.pro.scm.persistencedto.MaterialManufactureServiceDTO;
import com.pro.scm.service.MaterialManufactureService;
import com.pro.scm.servicedto.MaterialManufacturePersistenanceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objMaterialManufactureService")
@SuppressWarnings("unchecked")
public class MaterialManufactureServiceImpl implements MaterialManufactureService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String saveManufacture(MaterialManufactureServiceDTO objMaterialManufactureServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("saveManufacture method is executed inside MaterialManufactureServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drugs_manufacture_ref('")
				.append(objMaterialManufactureServiceDTO.getManufactureName()).append("',")
				.append(objMaterialManufactureServiceDTO.getUserId()).append(",")
				.append(objMaterialManufactureServiceDTO.getModuleId()).append(",")
				.append(objMaterialManufactureServiceDTO.getRoleId()).append(",")
				.append(objMaterialManufactureServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveManufacture:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

//select * from sp_update_pms_drugs_manufacture_ref(8,'Bharat Biotech','false')
	@Override
	public String updateManufacture(MaterialManufactureServiceDTO objMaterialManufactureServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("UpdateDrugDetails method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drugs_manufacture_ref(")
				.append(objMaterialManufactureServiceDTO.getManufactureId()).append(",").append("'")
				.append(objMaterialManufactureServiceDTO.getManufactureName()).append("',").append("'")
				.append(objMaterialManufactureServiceDTO.getStatus()).append("'").append(")");
		log.info(strRequestID + ":::::::::::::::UpdateDrugDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<MaterialManufactureServiceDTO> loadMaterialManufacture(String strRequestID)
			throws DataNotFoundException {
		log.info("loadMaterialManufacture method is executed inside MaterialManufactureServiceImpl");
		List<MaterialManufactureServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT ma_manufactureid,ma_companyname,ma_isactive FROM pms_drugs_manufacture_ref");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			MaterialManufactureMapper objMaterialManufactureMapper = new MaterialManufactureMapper();
			List<MaterialManufacturePersistenanceDTO> objMaterialManufacturePersistenanceDTO = objMaterialManufactureMapper
					.conversionForloadManufacture(list);
			listOfData = objMaterialManufactureMapper
					.conversionpersistanceDTOtoServiceDTO(objMaterialManufacturePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

}

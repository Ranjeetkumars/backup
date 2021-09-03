package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.BrandDetailsMapper;
import com.pro.scm.mappers.VehicleTypeMapper;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.VehicleTypePersistenanceDTO;
import com.pro.scm.service.BrandRegistrationService;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.UpdateDrugDetailsServiceDTO;
import com.pro.scm.servicedto.VehicleTypeServiceDTO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("objBrandRegistrationService")
@SuppressWarnings("unchecked")
public class BrandRegistrationServiceImpl implements BrandRegistrationService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public String UpdateDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("UpdateDrugDetails method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_masters_update_pms_drug_brand_ref(").append(objUpdateDrugDetailsServiceDTO.getBrandId()).append(",'")
		.append(objUpdateDrugDetailsServiceDTO.getBrandName()).append("',").append(objUpdateDrugDetailsServiceDTO.getUserId()).append(",")
		.append(objUpdateDrugDetailsServiceDTO.getModuleId()).append(",").append(objUpdateDrugDetailsServiceDTO.getRoleId()).append(",").append(objUpdateDrugDetailsServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::UpdateDrugDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	
	
	
	@Override
	public String saveDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID) throws DataNotFoundException {
		log.info("saveDrugDetails method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_masters_insert_pms_drug_brand_ref('")
		.append(objUpdateDrugDetailsServiceDTO.getBrandName()).append("',").append(objUpdateDrugDetailsServiceDTO.getUserId()).append(",")
		.append(objUpdateDrugDetailsServiceDTO.getModuleId()).append(",").append(objUpdateDrugDetailsServiceDTO.getRoleId()).append(",").append(objUpdateDrugDetailsServiceDTO.getStatus()).append(")");
		log.info(strRequestID + ":::::::::::::::saveDrugDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<BrandDetailsServiceDTO> loadBrandDetails(
			String strRequestID)
			throws DataNotFoundException {
		log.info("loadBrandDetails method is executed inside MasterDataServiceImpl");
		List<BrandDetailsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_pms_drug_brand_ref()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			BrandDetailsMapper objBrandDetailsMapper = new BrandDetailsMapper();
			List<BrandDetailsPeristenanceDTO> objBrandDetailsPeristenanceDTO = objBrandDetailsMapper.conversionOfBrandDetails(list);
			listOfData = objBrandDetailsMapper.conversionpersistanceDTOtoServiceDTO(objBrandDetailsPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public List<VehicleTypeServiceDTO> loadVehicleType(String strRequestID)
			throws DataNotFoundException {
		log.info("loadVehicleType method is executed inside MasterDataServiceImpl");
		List<VehicleTypeServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_fmsvehicletypes_id()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
	
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			VehicleTypeMapper objVehicleTypeMapper = new VehicleTypeMapper();
			List<VehicleTypePersistenanceDTO> objVehicleTypePersistenanceDTO = objVehicleTypeMapper.conversionForVehicleType(list);
			listOfData = objVehicleTypeMapper.conversionpersistanceDTOtoServiceDTO(objVehicleTypePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
}

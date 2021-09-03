package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.SupplierMapper;
import com.pro.scm.persistencedto.SupplierPeristenanceDTO;
import com.pro.scm.service.SupplierService;
import com.pro.scm.servicedto.SupplierServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objSupplierService")
@SuppressWarnings("unchecked")
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String saveSupplier(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("saveSupplier method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_masters_insert_pms_drugs_supplier_ref('")
				.append(objSupplierServiceDTO.getSuppliername()).append("',")
				.append(objSupplierServiceDTO.getCountryid()).append(",").append(objSupplierServiceDTO.getStateid())
				.append(",").append(objSupplierServiceDTO.getDistrictid()).append(",")
				.append(objSupplierServiceDTO.getMandalid()).append(",").append(objSupplierServiceDTO.getCityid())
				.append(",").append(objSupplierServiceDTO.getLocalityid()).append(",")
				.append(objSupplierServiceDTO.getLandmarkid()).append(",'").append(objSupplierServiceDTO.getEmail())
				.append("','").append(objSupplierServiceDTO.getWebsite()).append("','")
				.append(objSupplierServiceDTO.getLicensenumber()).append("','")
				.append(objSupplierServiceDTO.getTelephone()).append("','").append(objSupplierServiceDTO.getMobile())
				.append("','").append(objSupplierServiceDTO.getFax()).append("',")
				.append(objSupplierServiceDTO.getPincode()).append(",").append(objSupplierServiceDTO.getUserid())
				.append(",").append(objSupplierServiceDTO.getRoleid()).append(",")
				.append(objSupplierServiceDTO.getModuleid()).append(",").append(objSupplierServiceDTO.getStatus())
				.append(",'").append(objSupplierServiceDTO.getContactperson()).append("',")
				.append(objSupplierServiceDTO.getClassificationid()).append(")");
		log.info(strRequestID + ":::::::::::::::saveSupplier:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public String updateSupplier(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("updateSupplier method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_masters_update_pms_drugs_supplier_ref(")
				.append(objSupplierServiceDTO.getSupplierId()).append(",'")
				.append(objSupplierServiceDTO.getSuppliername()).append("',")
				.append(objSupplierServiceDTO.getCountryid()).append(",").append(objSupplierServiceDTO.getStateid())
				.append(",").append(objSupplierServiceDTO.getDistrictid()).append(",")
				.append(objSupplierServiceDTO.getMandalid()).append(",").append(objSupplierServiceDTO.getCityid())
				.append(",").append(objSupplierServiceDTO.getLocalityid()).append(",")
				.append(objSupplierServiceDTO.getLandmarkid()).append(",'").append(objSupplierServiceDTO.getEmail())
				.append("','").append(objSupplierServiceDTO.getWebsite()).append("','")
				.append(objSupplierServiceDTO.getLicensenumber()).append("','")
				.append(objSupplierServiceDTO.getTelephone()).append("','").append(objSupplierServiceDTO.getMobile())
				.append("','").append(objSupplierServiceDTO.getFax()).append("',")
				.append(objSupplierServiceDTO.getPincode()).append(",").append(objSupplierServiceDTO.getStatus())
				.append(",'").append(objSupplierServiceDTO.getContactperson()).append("',")
				.append(objSupplierServiceDTO.getClassificationid()).append(")");
		log.info(strRequestID + ":::::::::::::::saveSupplier:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<SupplierServiceDTO> loadClassification(String strRequestID) throws DataNotFoundException {
		log.info("loadClassification method is executed inside MasterDataServiceImpl");
		//SELECT sc_classification_id, sc_classification_name FROM pms_supplier_classification_ref where sc_isactive=true
		
		List<SupplierServiceDTO> listOfData;
		/*
		 * StringBuilder stringBuilder = new StringBuilder(); stringBuilder.
		 * append("select * from sp_select_pms_supplier_classification_ref()");
		 */
		String str ="SELECT sc_classification_id, sc_classification_name FROM pms_supplier_classification_ref where sc_isactive=true";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper
					.conversionForClassification(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> getSupplier(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("getSupplier method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_supplier_data(").append(objSupplierServiceDTO.getSupplierId())
				.append(")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForSupplier(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> loadCountry(String strRequestID) throws DataNotFoundException {
		log.info("getSupplier method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		String str="SELECT  cy_cyid,cy_lname FROM giscountries_ref where  cy_isactive=true";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForloadCountry(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> loadState(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("getSupplier method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		String str="SELECT sc_scid,sc_lname FROM gisstates_ref where sc_cyid="+objSupplierServiceDTO.getCountryid()+" and sc_isactive=true";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForloadState(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> loadDistrict(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("getSupplier method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		String str=" SELECT ds_dsid,ds_lname FROM gisdistricts_ref where ds_scid="+objSupplierServiceDTO.getStateid()+" and ds_isactive=true";

		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForloadDistrict(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> loadLandmark(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("getSupplier method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		String str="SELECT lm_landmarkid,lm_lname FROM gislandmark_ref where lm_locationid="+objSupplierServiceDTO.getLocalityid()+"and lm_isactive=true";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForloadLandmark(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> loadLocality(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadLocality method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		String str="SELECT l_locationid,l_lname FROM gislocality_ref where l_ctid="+objSupplierServiceDTO.getCityid()+" and l_isactive=true";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForloadLocality(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> loadZipCode(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadLocality method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		String str="SELECT ct_ctid, ct_lname FROM giscities_ref where ct_mdlid="+objSupplierServiceDTO.getCityid()+" and ct_isactive=true";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForloadZipCode(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<SupplierServiceDTO> loadCity(SupplierServiceDTO objSupplierServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadLocality method is executed inside MasterDataServiceImpl");
		List<SupplierServiceDTO> listOfData;
		String str=" SELECT mdl_mdlid,mdl_lname FROM gismandal_ref where mdl_dsid="+objSupplierServiceDTO.getStateid()+" and mdl_isactive=true";
		log.info(strRequestID + ":::::::::::::" + str);
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(str);
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SupplierMapper objSupplierMapper = new SupplierMapper();
			List<SupplierPeristenanceDTO> objSupplierPeristenanceDTO = objSupplierMapper.conversionForloadCity(list);
			listOfData = objSupplierMapper.conversionpersistanceDTOtoServiceDTO(objSupplierPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}
}

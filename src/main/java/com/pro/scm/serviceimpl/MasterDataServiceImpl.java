package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.BrandDetailsMapper;
import com.pro.scm.mappers.SearchDrugMapper;
import com.pro.scm.mappers.VehicleTypeDrugMapper;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.PharamacyNewDrugQtyPersistanceDto;
import com.pro.scm.persistencedto.VehicleTypeDrugsPersistenanceDTO;
import com.pro.scm.service.MasterDataService;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;
import com.pro.scm.servicedto.UpdateDrugDetailsServiceDTO;
import com.pro.scm.servicedto.VehicleTypeDrugsServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objMasterDataService")
@SuppressWarnings("unchecked")
public class MasterDataServiceImpl implements MasterDataService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String UpdateDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("UpdateDrugDetails method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_masters_update_pms_drug_brand_ref("
				+ objUpdateDrugDetailsServiceDTO.getBrandId() + ",'" + objUpdateDrugDetailsServiceDTO.getBrandName()
				+ "'," + objUpdateDrugDetailsServiceDTO.getUserId() + "," + objUpdateDrugDetailsServiceDTO.getModuleId()
				+ "," + objUpdateDrugDetailsServiceDTO.getRoleId() + "," + objUpdateDrugDetailsServiceDTO.getStatus()
				+ ")");
		log.info(strRequestID + ":::::::::::::::UpdateDrugDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<PharamacyNewDrugQtyServiceDto> searchDrug(
			PharamacyNewDrugQtyServiceDto objPharamacyNewDrugQtyServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("searchDrug method is executed inside MasterDataServiceImpl");
		List<PharamacyNewDrugQtyServiceDto> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"select * from sp_select_pharmacy_new_drug_qty('" + objPharamacyNewDrugQtyServiceDto.getStrBrandName()
						+ "','" + objPharamacyNewDrugQtyServiceDto.getStrDrugCode() + "',"
						+ objPharamacyNewDrugQtyServiceDto.getIntCounterId() + ")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			SearchDrugMapper objSearchDrugMapper = new SearchDrugMapper();
			List<PharamacyNewDrugQtyPersistanceDto> objPharamacyNewDrugQtyPersistanceDto = objSearchDrugMapper
					.ConvertDataOfSearchDrug(list);
			listOfData = objSearchDrugMapper.conversionpersistanceDTOtoServiceDTO(objPharamacyNewDrugQtyPersistanceDto);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public String saveDrugDetails(UpdateDrugDetailsServiceDTO objUpdateDrugDetailsServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("saveDrugDetails method is executed inside MasterDataServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_pms_masters_insert_pms_drug_brand_ref('"
				+ objUpdateDrugDetailsServiceDTO.getBrandName() + "'," + objUpdateDrugDetailsServiceDTO.getUserId()
				+ "," + objUpdateDrugDetailsServiceDTO.getModuleId() + "," + objUpdateDrugDetailsServiceDTO.getRoleId()
				+ "," + objUpdateDrugDetailsServiceDTO.getStatus() + ")");
		log.info(strRequestID + ":::::::::::::::saveDrugDetails:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<BrandDetailsServiceDTO> loadBrandDetails(String strRequestID) throws DataNotFoundException {
		log.info("loadBrandDetails method is executed inside MasterDataServiceImpl");
		List<BrandDetailsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_select_pms_drug_brand_ref()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			BrandDetailsMapper objBrandDetailsMapper = new BrandDetailsMapper();
			List<BrandDetailsPeristenanceDTO> objBrandDetailsPeristenanceDTO = objBrandDetailsMapper
					.conversionOfBrandDetails(list);
			listOfData = objBrandDetailsMapper.conversionpersistanceDTOtoServiceDTO(objBrandDetailsPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<VehicleTypeDrugsServiceDTO> loadVehicleTypeWiseDrugDetails(
			VehicleTypeDrugsServiceDTO objVehicleTypeDrugsServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadVehicleTypeWiseDrugDetails method is executed inside MasterDataServiceImpl");
		List<VehicleTypeDrugsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_get_allitemsbyvehicles(" + objVehicleTypeDrugsServiceDTO.getVehicleType()
				+ "," + objVehicleTypeDrugsServiceDTO.getMappedType() + ")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			VehicleTypeDrugMapper objVehicleTypeDrugMapper = new VehicleTypeDrugMapper();
			List<VehicleTypeDrugsPersistenanceDTO> objVehicleTypeDrugsPersistenanceDTO = objVehicleTypeDrugMapper
					.conversionOFVehicleTypeWiseDrugDetails(list);
			listOfData = objVehicleTypeDrugMapper
					.conversionpersistanceDTOtoServiceDTO(objVehicleTypeDrugsPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<BrandDetailsServiceDTO> printBarCode(String strRequestID) throws DataNotFoundException {
		log.info("loadBrandDetails method is executed inside MasterDataServiceImpl");
		List<BrandDetailsServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SELECT  distinct(dr_serialid),dr_material_groupid, mg_group_name, dr_drug_name, dr_short_unic_code, dr_bar_code  FROM pms_drug_reg_ref , pms_drug_material_groups_ref WHERE dr_material_groupid = mg_group_id AND dr_approval_id!=0 and dr_drug_active_id=2  AND dr_isactive=true ORDER BY mg_group_name, dr_drug_name");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			BrandDetailsMapper objBrandDetailsMapper = new BrandDetailsMapper();
			List<BrandDetailsPeristenanceDTO> objBrandDetailsPeristenanceDTO = objBrandDetailsMapper
					.conversionOfBarCode(list);
			listOfData = objBrandDetailsMapper.conversionpersistanceDTOtoServiceDTO(objBrandDetailsPeristenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}
}

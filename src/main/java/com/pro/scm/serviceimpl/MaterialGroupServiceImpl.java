package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.MaterialGroupMapper;
import com.pro.scm.persistencedto.MaterialGrouppersistenanceDTO;
import com.pro.scm.service.MaterialGroupService;
import com.pro.scm.servicedto.MaterialGroupServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objMaterialGroupService")
@SuppressWarnings("unchecked")
public class MaterialGroupServiceImpl implements MaterialGroupService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

//select * from sp_pms_masters_insert_update_pms_material_groups_ref(null,'grp_name','grp_code',1,1,1,true)
	@Override
	public String saveorUpdateMaterialGroup(MaterialGroupServiceDTO obMaterialGroupServiceDTO, String strRequestId,
			String operationType) throws DataNotFoundException {
		log.info("saveorUpdateMaterialUnit method is executed inside MaterialGroupServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" SELECT * FROM sp_pms_masters_insert_update_pms_material_groups_ref(")
				.append(obMaterialGroupServiceDTO.getGroupId()).append(",'")
				.append(obMaterialGroupServiceDTO.getGroupName()).append("','")
				.append(obMaterialGroupServiceDTO.getGroupCode()).append("',")
				.append(obMaterialGroupServiceDTO.getUserId()).append(",").append(obMaterialGroupServiceDTO.getRoleId())
				.append(",").append(obMaterialGroupServiceDTO.getModuleId()).append(",")
				.append(obMaterialGroupServiceDTO.getStatus()).append(",")
				.append(obMaterialGroupServiceDTO.getOperationType()).append(")");

		log.info(strRequestId + ":::::::::::::::saveorUpdateMaterialGroup:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<MaterialGroupServiceDTO> loadMaterialGroup(String strRequestID) throws DataNotFoundException {
		log.info("loadUnits method is executed inside MaterialGroupServiceImpl");
		List<MaterialGroupServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * FROM sp_pms_masters_select_pms_material_groups_ref()");

		// stringBuilder.append("SELECT mg_group_id, mg_group_name FROM
		// pms_drug_material_groups_ref where mg_isactive=true");

		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			MaterialGroupMapper obMaterialGroupMapper = new MaterialGroupMapper();
			List<MaterialGrouppersistenanceDTO> objVehicleTypePersistenanceDTO = obMaterialGroupMapper
					.conversionForMaterialGroup(list);
			listOfData = obMaterialGroupMapper.conversionpersistanceDTOtoServiceDTO(objVehicleTypePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public String saveorUpdatePackingVolume(MaterialGroupServiceDTO obMaterialGroupServiceDTO, String strRequestId,
			String operationType) throws DataNotFoundException {
		log.info("saveorUpdatePackingVolume method is executed inside MaterialGroupServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" SELECT * FROM sp_pms_masters_insert_update_pms_unit_types_ref(")
				.append(obMaterialGroupServiceDTO.getUnitId()).append(",'")
				.append(obMaterialGroupServiceDTO.getUnitName()).append("',")
				.append(obMaterialGroupServiceDTO.getConversionFactor()).append(",")
				.append(obMaterialGroupServiceDTO.getUserId()).append(",").append(obMaterialGroupServiceDTO.getRoleId())
				.append(",").append(obMaterialGroupServiceDTO.getModuleId()).append(",")
				.append(obMaterialGroupServiceDTO.getStatus()).append(",")
				.append(obMaterialGroupServiceDTO.getOperationType()).append(",")
				.append(obMaterialGroupServiceDTO.getMaterialForm())
				
				.append(")");

		log.info(strRequestId + ":::::::::::::::saveorUpdateMaterialGroup:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

}

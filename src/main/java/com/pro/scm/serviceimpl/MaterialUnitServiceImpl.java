package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.LoadUnitMapper;
import com.pro.scm.persistencedto.LoadUnitPeristenanceDTO;
import com.pro.scm.service.MaterialUnitService;
import com.pro.scm.servicedto.LoadUnitServiceDTO;
import com.pro.scm.servicedto.MaterialUnitServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objMaterialUnitService")
@SuppressWarnings("unchecked")
public class MaterialUnitServiceImpl implements MaterialUnitService{
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;
	
	
	@Override
	public String saveorUpdateMaterialUnit(MaterialUnitServiceDTO objMaterialUnitServiceDTO, String strRequestId)
			throws DataNotFoundException {
		log.info("saveMaterialForm method is executed inside MaterialUnitServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		String operationType =objMaterialUnitServiceDTO.getOperationType();
		 if(operationType == "1"){
		stringBuilder.append(" SELECT * FROM sp_pms_masters_insert_update_pms_unit_types_ref(").append("0").append(",'")
		
		.append(objMaterialUnitServiceDTO.getUnitName()).append("',").append(objMaterialUnitServiceDTO.getConversionFactor()).append(",")
		.append(objMaterialUnitServiceDTO.getUserId()).append(",").append(objMaterialUnitServiceDTO.getRoleId()).append(",").append(objMaterialUnitServiceDTO.getModuleId())
		.append(",").append(objMaterialUnitServiceDTO.getStatus()).append(",").append(operationType).append(",")
	.append(objMaterialUnitServiceDTO.getMaterialForm()).append(")");
		}else {
			stringBuilder.append(" SELECT * FROM sp_pms_masters_insert_update_pms_unit_types_ref(").append(objMaterialUnitServiceDTO.getUnitId()).append(",'")
			.append(objMaterialUnitServiceDTO.getUnitName()).append("',").append(objMaterialUnitServiceDTO.getConversionFactor()).append(",")
			.append(objMaterialUnitServiceDTO.getUserId()).append(",")
			.append(objMaterialUnitServiceDTO.getRoleId()).append(",").append(objMaterialUnitServiceDTO.getModuleId()).append(",").append(objMaterialUnitServiceDTO.getStatus())
			.append(",").append(operationType).append(",").append(objMaterialUnitServiceDTO.getMaterialForm()).append(")");
		}
		log.info(strRequestId + ":::::::::::::::saveorUpdateMaterialUnit:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}
	
	@Override
	public List<LoadUnitServiceDTO> loadUnits(String strRequestID)
			throws DataNotFoundException {
		log.info("loadUnits method is executed inside MaterialUnitServiceImpl");
		List<LoadUnitServiceDTO> listOfData;
		String sp = "SELECT * FROM sp_pms_masters_select_pms_unit_types_ref()";
		log.info(strRequestID + ":::::::::::::" + sp.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(sp.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadUnitMapper objLoadUnitMapper = new LoadUnitMapper();
			List<LoadUnitPeristenanceDTO> objVehicleTypePersistenanceDTO = objLoadUnitMapper.conversionForLoadUnit(list);
			listOfData = objLoadUnitMapper.conversionpersistanceDTOtoServiceDTO(objVehicleTypePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
	
	@Override
	public List<LoadUnitServiceDTO> loadMaterialForm(String strRequestID)
			throws DataNotFoundException {
		log.info("loadMaterialForm method is executed inside MaterialUnitServiceImpl");
		List<LoadUnitServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" SELECT df_serialid, df_form_type,mg_group_name,df_isactive FROM pms_drug_form_ref inner join pms_drug_material_groups_ref on df_material_groupid=mg_group_id"); 
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadUnitMapper objLoadUnitMapper = new LoadUnitMapper();
			List<LoadUnitPeristenanceDTO> objVehicleTypePersistenanceDTO = objLoadUnitMapper.conversionForLoadmaterialForm(list);
			listOfData = objLoadUnitMapper.conversionpersistanceDTOtoServiceDTO(objVehicleTypePersistenanceDTO);
		} else {
			throw new DataNotFoundException("");		
			}
		return listOfData;
	}
}

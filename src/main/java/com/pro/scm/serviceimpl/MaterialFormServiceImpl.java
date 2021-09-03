package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.BrandDetailsMapper;
import com.pro.scm.mappers.LoadMaterialFormMapper;
import com.pro.scm.persistencedto.BrandDetailsPeristenanceDTO;
import com.pro.scm.persistencedto.LoadMaterialFormPersistenanceDTO;
import com.pro.scm.service.MaterialFormService;
import com.pro.scm.servicedto.BrandDetailsServiceDTO;
import com.pro.scm.servicedto.LoadMaterialFormServiceDto;
import com.pro.scm.servicedto.MaterialFormServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objMaterialFormService")
@SuppressWarnings("unchecked")
public class MaterialFormServiceImpl implements MaterialFormService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String saveMaterialForm(MaterialFormServiceDTO objMaterialFormServiceDTO, String strRequestID)
			throws DataNotFoundException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + objMaterialFormServiceDTO.getIntMaterialFormId());
		log.info("saveMaterialForm method is executed inside MaterialFormServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_drug_form_ref('")
				.append(objMaterialFormServiceDTO.getMaterialForm()).append("',")
				.append(objMaterialFormServiceDTO.getUserId()).append(",").append(objMaterialFormServiceDTO.getRoleId())
				.append(",").append(objMaterialFormServiceDTO.getModuleId()).append(",")
				.append(objMaterialFormServiceDTO.getStatus()).append(",")
				.append(objMaterialFormServiceDTO.getIntMaterialFormId()).append(")");
		log.info(strRequestID + ":::::::::::::::saveMaterialForm:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	public String updateMaterialForm(MaterialFormServiceDTO objMaterialFormServiceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("updateMaterialForm method is executed inside MaterialFormServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_form_ref('")
				.append(objMaterialFormServiceDTO.getMaterialForm()).append("',")
				.append(objMaterialFormServiceDTO.getStatus()).append(",")
				.append(objMaterialFormServiceDTO.getMaterialGroupId()).append(",")
				.append(objMaterialFormServiceDTO.getMaterialFormId()).append(")");
		log.info(strRequestID + ":::::::::::::::updateMaterialForm:::::::::::" + stringBuilder.toString());
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<MaterialFormServiceDTO> loadMaterialForm(String strRequestID) throws DataNotFoundException {
		log.info("loadMaterialForm method is executed inside MaterialFormServiceImpl");
		List<MaterialFormServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();

		// stringBuilder.append("select * from pms_drug_form_ref");
		//
		stringBuilder.append("SELECT df_serialid, df_form_type,mg_group_name,df_isactive FROM pms_drug_form_ref inner join pms_drug_material_groups_ref on df_material_groupid=mg_group_id");
        log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadMaterialFormMapper objLoadMaterialFormMapper = new LoadMaterialFormMapper();
			List<LoadMaterialFormPersistenanceDTO> objLoadMaterialFormPersistenanceDTO = objLoadMaterialFormMapper
					.conversionForLoadMaterialFormist(list);
			listOfData = objLoadMaterialFormMapper
					.conversionpersistanceDTOtoServiceDTOForListOfdata(objLoadMaterialFormPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<MaterialFormServiceDTO> loadActiveMatrialGroup(String strRequestID) throws DataNotFoundException {
		log.info("loadActiveMatrialGroup method is executed inside MaterialFormServiceImpl");
		List<MaterialFormServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT mg_group_id, mg_group_name  FROM pms_drug_material_groups_ref where mg_isactive=true");
        log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadMaterialFormMapper objLoadMaterialFormMapper = new LoadMaterialFormMapper();
			List<LoadMaterialFormPersistenanceDTO> objLoadMaterialFormPersistenanceDTO = objLoadMaterialFormMapper
					.convertArrayObjctToPersistenceDtoForMatrialGroup(list);
			listOfData = objLoadMaterialFormMapper
					.conversionpersistanceDTOtoServiceDTOForListOfdata(objLoadMaterialFormPersistenanceDTO);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

}

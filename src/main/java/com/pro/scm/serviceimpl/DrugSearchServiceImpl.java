package com.pro.scm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.LoadGenericDrugNameMapper;
import com.pro.scm.mappers.SearchDrugMapper;
import com.pro.scm.persistencedto.LoadGenericDrugNamePersistenceDto;
import com.pro.scm.persistencedto.PharamacyNewDrugQtyPersistanceDto;
import com.pro.scm.service.DrugSearchService;
import com.pro.scm.servicedto.AlternativeDrugSearchServiceDto;
import com.pro.scm.servicedto.LoadGenericDrugNameServiceDto;
import com.pro.scm.servicedto.PharamacyNewDrugQtyServiceDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objDrugSearchService")
@SuppressWarnings("unchecked")
public class DrugSearchServiceImpl implements DrugSearchService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public List<PharamacyNewDrugQtyServiceDto> searchDrug(
			PharamacyNewDrugQtyServiceDto objPharamacyNewDrugQtyServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("searchDrug method is executed inside MasterDataServiceImpl");
		List<PharamacyNewDrugQtyServiceDto> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pharmacy_new_drug_qty('")
				.append(objPharamacyNewDrugQtyServiceDto.getStrBrandName()).append("','")
				.append(objPharamacyNewDrugQtyServiceDto.getStrDrugCode()).append("',")
				.append(objPharamacyNewDrugQtyServiceDto.getIntCounterId()).append(")");
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
	public String searchDrug(AlternativeDrugSearchServiceDto alternativeDrugSearchServiceDto, String strRequestID)
			throws DataNotFoundException {
		log.info("saveReturnDrugs method is executed inside SCMLoginServiceImpl");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count(*) from sp_select_pharmacy_alternative_search(")
				.append(alternativeDrugSearchServiceDto.getGenericId()).append(")");

		log.info(strRequestID + ":::::::::::::::saveReturnDrugs:::::::::::" + stringBuilder.toString());
		log.info(strRequestID + ":::::::::::::::Request Id for saveReturnDrugs :::::::::::" + strRequestID);
		return objSupervisorDao.saveData(stringBuilder.toString());
	}

	@Override
	public List<LoadGenericDrugNameServiceDto> loadGenericDrugName(String strRequestID) throws DataNotFoundException {
		log.info("loadGenericDrugName method is executed inside MasterDataServiceImpl");
		List<LoadGenericDrugNameServiceDto> ladGenericDrugNameServiceDto1;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("SELECT dgn_serialid, dgn_genericname FROM pms_drug_genericname_ref where dgn_isactive=true");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			LoadGenericDrugNameMapper loadGenericDrugNameMapper = new LoadGenericDrugNameMapper();
			List<LoadGenericDrugNamePersistenceDto> loadGenericDrugNamePersistenceDto = loadGenericDrugNameMapper
					.setdataIntoLoadGenericDrugNamePersistenceDto(list);
			ladGenericDrugNameServiceDto1 = loadGenericDrugNameMapper
					.conversionpersistanceDTOtoServiceDTO(loadGenericDrugNamePersistenceDto);
		} else {
			throw new DataNotFoundException("");
		}
		return ladGenericDrugNameServiceDto1;
	}

	
}

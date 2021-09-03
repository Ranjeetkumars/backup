package com.pro.scm.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.AddNewLocalDrugMapper;

import com.pro.scm.persistencedto.AddNewLocalDrugPersistencesDTO;

import com.pro.scm.service.AddNewLocalDrugService;
import com.pro.scm.servicedto.AddNewLocalDrugServiceDTO;


import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Bhuneshwar
 *
 */
@SuppressWarnings("unchecked")
@Service("addNewLocalDrugService")
@Slf4j
public class AddNewLocalDrugServiceImpl implements AddNewLocalDrugService{

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public List<AddNewLocalDrugServiceDTO> getLoadLocaldrugs(String strRequestID) throws DataNotFoundException {
		log.info("getLoadLocaldrugs method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				" select * from sp_select_pharmacy_load_local_drugs()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getLoadLocaldrugs(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> getAllMedicinesCount(AddNewLocalDrugServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("getAllMedicinesCount method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select cast(count(*) as integer) from  sp_select_pharmacy_active_search('"
				+ serviceDTO.getGenric_drug_name() + "'," + serviceDTO.getBrand_id() + "," + serviceDTO.getFrom_id()
				+ "," + serviceDTO.getManufacture_id() + ",'" + serviceDTO.getUnicode() + "',"
				+ serviceDTO.getActive_inactive() + "," + serviceDTO.getSystem_id() + ","
				+ serviceDTO.getGenric_group_id() + "," + serviceDTO.getGeneric_molecules_id() + ")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getAllMedicinesCounts(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> loadGenricGroup(AddNewLocalDrugServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("loadGenricGroup method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_drug_groupfunction("+serviceDTO.getSystemId()+")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getloadGenricGroup(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> loadGenricMolecules(AddNewLocalDrugServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("loadGenricMolecules method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_drug_groupmolecules("+serviceDTO.getGenericGroupId()+")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getloadGenricMolecules(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> loadManufacturer(String strRequestID) throws DataNotFoundException {
		log.info("loadManufaturer method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				" select * from sp_select_drugs_manufacture_deatils()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getloadManufaturer(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> loadForm(String strRequestID) throws DataNotFoundException {
		log.info("loadForm method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				" select * from sp_select_drug_form()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getloadForms(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> loadBrand(String strRequestID) throws DataNotFoundException {
		log.info("loadBrand method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				" select * from sp_select_drug_brand()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getloadBrand(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> loadSystem(String strRequestID) throws DataNotFoundException {
		log.info("loadSystem method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				" select * from sp_select_drug_system()");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getloadSystem(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> getVehicleAlsBls(AddNewLocalDrugServiceDTO serviceDTO, String strRequestID)
			throws DataNotFoundException {
		log.info("getVehicleAlsBls method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT  vt_vehicletype  FROM fmsvehicledetails_ref inner join fmsvehicletypes_ref on vd_vehicletypeid= vt_vehicletypeid where vd_vehicleid="+serviceDTO.getVehicleId()+"");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getVehicleAlsBls(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}

	@Override
	public List<AddNewLocalDrugServiceDTO> getVehicleDrugStatus(AddNewLocalDrugServiceDTO serviceDTO,
			String strRequestID) throws DataNotFoundException {
		log.info("getVehicleDrugStatus method is executed inside ExpiryDrugsServiceImpl");
		List<AddNewLocalDrugServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_vehicle_drugmapped_status("+serviceDTO.getVehicleId()+","+serviceDTO.getDrugid()+")");
		log.info(strRequestID + ":::::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			AddNewLocalDrugMapper mapper = new AddNewLocalDrugMapper();
			List<AddNewLocalDrugPersistencesDTO> persistenceDtos = mapper.getVehicleDrugStatus(list);
			listOfData = mapper.conversionpersistanceDTOtoServiceDTO(persistenceDtos);
		} else {
			throw new DataNotFoundException(strRequestID + ":::::::No LoadReturnDrugs::::::");
		}
		return listOfData;
	}


}

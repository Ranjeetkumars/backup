package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.AddNewLocalDrugServiceDTO;


public interface AddNewLocalDrugService {
	public List<AddNewLocalDrugServiceDTO> getLoadLocaldrugs(String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> getAllMedicinesCount(AddNewLocalDrugServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> loadGenricGroup(AddNewLocalDrugServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> loadGenricMolecules(AddNewLocalDrugServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> loadManufacturer(String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> loadForm(String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> loadBrand(String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> loadSystem(String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> getVehicleAlsBls(AddNewLocalDrugServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	public List<AddNewLocalDrugServiceDTO> getVehicleDrugStatus(AddNewLocalDrugServiceDTO serviceDTO,String strRequestID) throws DataNotFoundException;
	
	


}

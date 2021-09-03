package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.GetAllActiveInactiveServiceDto;
import com.pro.scm.servicedto.GetDrugDetailsForApprovalServiceDto;
import com.pro.scm.servicedto.GetMedicinesCountServiceDto;
import com.pro.scm.servicedto.GetMedicinesServiceDto;
import com.pro.scm.servicedto.ListLoadActiveDrugsCountServiceDto;
import com.pro.scm.servicedto.ListLoadActiveDrugsServiceDto;
import com.pro.scm.servicedto.ListLoadActiveInactiveServiceDto;
import com.pro.scm.servicedto.LoadActiveDrugsServiceDto;
import com.pro.scm.servicedto.LoadDrugTypeServiceDto;
import com.pro.scm.servicedto.LoadLocalIndentServiceDto;
import com.pro.scm.servicedto.LoadVehiclesSubstoreServiceDto;
import com.pro.scm.servicedto.SaveInActiveDrugsServiceDto;
import com.pro.scm.servicedto.Save_vehicle_indent_detailsServiceDto;
import com.pro.scm.servicedto.Store_item_detailsServiceDto;
import com.pro.scm.servicedto.UpdateActiveDrugForApprovalServiceDto;


public interface SalesIndentRaisedService {

	public List<LoadVehiclesSubstoreServiceDto> load_vehicles_substore(LoadVehiclesSubstoreServiceDto loadVehiclesSubstoreServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public List<LoadLocalIndentServiceDto> loadLocalIndentDetails(LoadLocalIndentServiceDto loadLocalIndentServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
	public List<Store_item_detailsServiceDto> store_item_details(Store_item_detailsServiceDto loadLocalIndentServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public String save_vehicle_indent_details(Save_vehicle_indent_detailsServiceDto save_vehicle_indent_detailsServiceDto, String strRequestID)
			throws DataNotFoundException;
	//
	
	public List<ListLoadActiveInactiveServiceDto> listLoadActiveInactive(ListLoadActiveInactiveServiceDto listLoadActiveInactiveServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public String updateActiveDrugForApproval(UpdateActiveDrugForApprovalServiceDto save_vehicle_indent_detailsServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public List<GetDrugDetailsForApprovalServiceDto> getDrugDetailsForApproval(GetDrugDetailsForApprovalServiceDto getDrugDetailsForApprovalServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public List<LoadDrugTypeServiceDto> loadDrugType( String strRequestID)
			throws DataNotFoundException;
	

	
	public List<LoadActiveDrugsServiceDto> loadActiveDrugs(LoadActiveDrugsServiceDto loadActiveDrugsServiceDto, String strRequestID)
			throws DataNotFoundException;


	public List<ListLoadActiveDrugsServiceDto> listLoadActiveDrugs(ListLoadActiveDrugsServiceDto scmLoginServiceDto, String strRequestID)
			throws DataNotFoundException;
	

	
	public String getAllActiveInactive(GetAllActiveInactiveServiceDto getAllActiveInactiveServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public String saveInActiveDrugs(SaveInActiveDrugsServiceDto saveInActiveDrugsServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
	public String listLoadActiveDrugsCount(ListLoadActiveDrugsCountServiceDto listLoadActiveDrugsCountServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
	public String getMedicinesCount(GetMedicinesCountServiceDto getMedicinesCountServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public List<GetMedicinesServiceDto> getMedicines(GetMedicinesServiceDto getMedicinesServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public List<GetMedicinesServiceDto> getMedicinesDetailsBasedOnSerialId(GetMedicinesServiceDto getMedicinesServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
	
	
	public List<GetMedicinesServiceDto> getMedicinesForProcessNewInventory(GetMedicinesServiceDto getMedicinesServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public List<GetMedicinesServiceDto> getMedicinesForProcessNewInventoryBasedOnIds(GetMedicinesServiceDto getMedicinesServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
}

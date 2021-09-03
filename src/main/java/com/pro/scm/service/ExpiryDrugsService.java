package com.pro.scm.service;

import java.util.List;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.servicedto.AdjustmentSearchServiceDTO;
import com.pro.scm.servicedto.ExpiryDrugsServiceDto;
import com.pro.scm.servicedto.GetUserDropdownServiceDTO;
import com.pro.scm.servicedto.ListOfLoadSuppliersServiceDto;
import com.pro.scm.servicedto.LoadAdjustmentTypeServiceDto;
import com.pro.scm.servicedto.LoadBaselocationsServiceDto;
import com.pro.scm.servicedto.LoadExpiryDrugsServiceDto;
import com.pro.scm.servicedto.LoadReturnDrugsServiceDto;
import com.pro.scm.servicedto.LoadStoresServiceDto;
import com.pro.scm.servicedto.LoadSubStoreServiceDto;
import com.pro.scm.servicedto.LoadVehicleTransferItemsServiceDto;
import com.pro.scm.servicedto.LoadVehiclesServiceDto;
import com.pro.scm.servicedto.LoadZonesServiceDto;
import com.pro.scm.servicedto.SaveUpdateItemsServiceDto;

public interface ExpiryDrugsService {

	public String getVehicleMappingStatus(ExpiryDrugsServiceDto expiryDrugsServiceDto, String strRequestID)
			throws DataNotFoundException;

	public String saveReturnDrugs(ExpiryDrugsServiceDto expiryDrugsServiceDto, String strRequestID)
			throws DataNotFoundException;

	public List<LoadExpiryDrugsServiceDto> LoadExpiryDrugs(String strRequestID) throws DataNotFoundException;

	public List<LoadReturnDrugsServiceDto> LoadReturnDrugs(LoadReturnDrugsServiceDto drugsServiceDto,
			String strRequestID) throws DataNotFoundException;

	public List<LoadZonesServiceDto> load_zones(String strRequestID) throws DataNotFoundException;

	public List<LoadBaselocationsServiceDto> load_baselocations(LoadBaselocationsServiceDto baselocationsServiceDto,
			String strRequestID) throws DataNotFoundException;

	public List<LoadVehiclesServiceDto> load_vehicles(LoadVehiclesServiceDto vehiclesServiceDto, String strRequestID)
			throws DataNotFoundException;

	public List<LoadSubStoreServiceDto> loadSubStore(LoadSubStoreServiceDto subStoreServiceDto, String strRequestID)
			throws DataNotFoundException;

	public List<LoadAdjustmentTypeServiceDto> loadAdjustmentType(String strRequestID) throws DataNotFoundException;

	public List<LoadStoresServiceDto> loadStores(String strRequestID) throws DataNotFoundException;

	public List<ListOfLoadSuppliersServiceDto> ListOfLoad(String strRequestID) throws DataNotFoundException;

	public String saveUpdateItems(SaveUpdateItemsServiceDto updateItemsServiceDto, String strRequestID)
			throws DataNotFoundException;

	public List<LoadVehicleTransferItemsServiceDto> loadVehicleTransferItems(
			LoadVehicleTransferItemsServiceDto subStoreServiceDto, String strRequestID) throws DataNotFoundException;

	public List<GetUserDropdownServiceDTO> loadUsers(String strRequestID) throws DataNotFoundException;
	
	public List<AdjustmentSearchServiceDTO> adjustmentSearch(AdjustmentSearchServiceDTO subStoreServiceDto, String strRequestID)
			throws DataNotFoundException;

	public List<ListOfLoadSuppliersServiceDto> loadSuppliers(String strRequestID) throws DataNotFoundException;
	
	
	public String updateAdjustmentStatus(ExpiryDrugsServiceDto expiryDrugsServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
}

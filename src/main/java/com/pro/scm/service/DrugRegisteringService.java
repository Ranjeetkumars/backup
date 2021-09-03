package com.pro.scm.service;

import java.util.List;

import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.persistencedto.AllPurchaseOrdersByMesserIdServiceDto;
import com.pro.scm.servicedto.AllApprovalItemListServiceDto;
import com.pro.scm.servicedto.AllIndentDetailsServiceDto;
import com.pro.scm.servicedto.DrugAndSupplierMappingServiceDto;
import com.pro.scm.servicedto.DrugRegistrationServiceDto;
import com.pro.scm.servicedto.GenerateNewDrugBarcodeServiceDto;
import com.pro.scm.servicedto.LoadGenericNamesServiceDto;
import com.pro.scm.servicedto.LoadMaterialFormServiceDto;
import com.pro.scm.servicedto.LoadPackingTypeServiceDto;
import com.pro.scm.servicedto.LoadScheduleServiceDto;
import com.pro.scm.servicedto.MesserAddressServiceDto;
import com.pro.scm.servicedto.RejectIndentDataServiceDto;
import com.pro.scm.servicedto.SaveDrugDetailsServiceDto;
import com.pro.scm.servicedto.UpdateActiveDrugForRejectApprovalServiceDto;

public interface DrugRegisteringService {

	public String saveDrugDetails(SaveDrugDetailsServiceDto saveDrugDetailsServiceDto, String strRequestID)
			throws DataNotFoundException;

	public String UpdateDrugDetails(SaveDrugDetailsServiceDto saveDrugDetailsServiceDto, String strRequestID)
			throws DataNotFoundException;

	public List<LoadPackingTypeServiceDto> loadPackingType(LoadPackingTypeServiceDto loadPackingTypeServiceDto,
			String strRequestID) throws DataNotFoundException;

	public List<LoadMaterialFormServiceDto> loadMaterialForm(LoadMaterialFormServiceDto loadPackingTypeServiceDto,
			String strRequestID) throws DataNotFoundException;

	public List<LoadGenericNamesServiceDto> loadGenericNames(String strRequestID) throws DataNotFoundException;

	public List<GenerateNewDrugBarcodeServiceDto> generate_new_drug_barcode(
			GenerateNewDrugBarcodeServiceDto generateNewDrugBarcodeServiceDto, String strRequestID)
			throws DataNotFoundException;

	public List<LoadScheduleServiceDto> loadSchedule(String strRequestID) throws DataNotFoundException;

	public List<LoadScheduleServiceDto> loadMaterialGroup(String strRequestID) throws DataNotFoundException;

	public String updateActiveDrugForRejectApproval(UpdateActiveDrugForRejectApprovalServiceDto serviceDto,
			String strRequestID) throws DataNotFoundException;

	public String strIndentDetails(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException;

	public String updateIndentDetails(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException;

	public String updateIndentItemsRejected(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException;

	public String updateIndentReject(UpdateActiveDrugForRejectApprovalServiceDto serviceDto, String strRequestID)
			throws DataNotFoundException;

	public List<AllApprovalItemListServiceDto> allApprovalItemList(
			AllApprovalItemListServiceDto generateNewDrugBarcodeServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	public List<AllIndentDetailsServiceDto> getAllIndentDetails(
			 String strRequestID)
			throws DataNotFoundException;
	
	
	public List<AllPurchaseOrdersByMesserIdServiceDto> allPurchaseOrdersByMesserId(
			AllPurchaseOrdersByMesserIdServiceDto allPurchaseOrdersByMesserIdServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
	public String getMesserAddress(MesserAddressServiceDto messerAddressServiceDto, String strRequestID)
			throws DataNotFoundException;
	
	
	public String getAllActiveInactiveCount(DrugRegistrationServiceDto serviceDto , String strRequestID)throws DataNotFoundException;

//
	public List<DrugRegistrationServiceDto> getAllActiveInactive(DrugRegistrationServiceDto serviceDto , String strRequestID)throws DataNotFoundException;


	public List<DrugAndSupplierMappingServiceDto> listloadSuppliers(
			 String strRequestID)
			throws DataNotFoundException;
	
	
	public List<DrugAndSupplierMappingServiceDto> loadMappedDrugs(DrugAndSupplierMappingServiceDto serviceDto ,String strRequestID) throws DataNotFoundException;


	public String updateMappedDrugToUnMap(DrugAndSupplierMappingServiceDto serviceDto ,String strRequestID) throws DataNotFoundException;

	public String updateDrugSupplierMapping(DrugAndSupplierMappingServiceDto serviceDto ,String strRequestID) throws DataNotFoundException;
	public String rejectIndentData(RejectIndentDataServiceDto serviceDto ,String strRequestID) throws DataNotFoundException;


}

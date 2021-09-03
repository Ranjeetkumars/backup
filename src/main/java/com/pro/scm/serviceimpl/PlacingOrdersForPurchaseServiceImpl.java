package com.pro.scm.serviceimpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.BrandNameMapper;
import com.pro.scm.mappers.IndentDetailsMapper;
import com.pro.scm.mappers.ManufactureCompanyMapper;
import com.pro.scm.mappers.ManufactureFormMapper;
import com.pro.scm.mappers.PlacingOrdersForPurchaseMapper;
import com.pro.scm.persistencedto.BrandNamePersistanceDTO;
import com.pro.scm.persistencedto.IndentDetailsPersistanceDTO;
import com.pro.scm.persistencedto.ManufactureCompanyPersistanceDTO;
import com.pro.scm.persistencedto.ManufactureFormPersistanceDTO;
import com.pro.scm.persistencedto.PlacingOrdersForPurchasePersistanceDTO;
import com.pro.scm.service.PlacingOrdersForPurchaseService;
import com.pro.scm.servicedto.BrandNameServiceDTO;
import com.pro.scm.servicedto.CentralCloseServiceDTO;
import com.pro.scm.servicedto.IndentDetailsServiceDTO;
import com.pro.scm.servicedto.ManufactureCompanyServiceDTO;
import com.pro.scm.servicedto.ManufactureFormServiceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objPlacingOrdersForPurchaseServiceImpl")
@SuppressWarnings("unchecked")
public class PlacingOrdersForPurchaseServiceImpl implements PlacingOrdersForPurchaseService {
	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String savePurchaseOrderItemDetails(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_scm_purchase_order_item_trans(")
				.append(dataServiceDTO.getPoId()).append(",").append(dataServiceDTO.getSupplierId()).append(",'")
				.append(dataServiceDTO.getDrugidList()).append("','").append(dataServiceDTO.getQuantitylist())
				.append("','").append(dataServiceDTO.getIndentidlist()).append("','")
				.append(dataServiceDTO.getFormlist()).append("','").append(dataServiceDTO.getStrenghtlist())
				.append("',").append(dataServiceDTO.getCount()).append(",").append(dataServiceDTO.getUserId())
				.append(",").append(dataServiceDTO.getModuleId()).append(",").append(dataServiceDTO.getRoleId())
				.append(")");
		log.info(strRequestID + "::::::savePurchaseOrderItemDetails():::::::" + stringBuilder.toString());

		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> getAllSuppliers(String strRequestID) throws DataNotFoundException {
		List<PlacingOrdersForPurchaseServiceDTO> datas = new ArrayList<PlacingOrdersForPurchaseServiceDTO>();
		StringBuilder stringBuilder = new StringBuilder();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		stringBuilder.append(
				"SELECT dd_supplierid, dd_suppliername FROM pms_drugs_supplier_ref where dd_isactive = true order by 2");
		log.info(strRequestID + ":::::::::::::::getAllSuppliers:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.convertObjetsArraytoGetAllSuppliers(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::getAllSuppliers()::::::");
		}
		return datas;

	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> getReturnDrugDetailsByDrugId(
			PlacingOrdersForPurchaseServiceDTO dataInfo, String requestID) throws DataNotFoundException {
		List<PlacingOrdersForPurchaseServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_scm_select_vendorWise_returnor_expiryitems(")
				.append(dataInfo.getDrugidList()).append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.ConvertDataToGetDrugDetails(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public String savePurchaseOrderItemQuantity(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_scm_indent_item_wise_trans('")
				.append(dataServiceDTO.getDrugidList()).append("','").append(dataServiceDTO.getQuantity()).append("',")
				.append(dataServiceDTO.getCount()).append(",").append(dataServiceDTO.getCreateById()).append(",")
				.append(dataServiceDTO.getRoleId()).append(",").append(dataServiceDTO.getModuleId()).append(",")
				.append(dataServiceDTO.getIndentidlist()).append(")");
		log.info(strRequestID + "::::::savePurchaseOrderItemQuantity():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String getGenerateIndentNumber(String strRequestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"select count(cdsi_id)+1 as maxindent from pms_scm_indent_ref where cast (cdsi_createdbydtm as date)= current_date");
		log.info(strRequestID + ":::::::::::::::getGenerateIndentNumber():::::::::::" + stringBuilder.toString());
		String maxIndent = objSupervisorDao.getSingleData(stringBuilder.toString());
		return maxIndent;

	}

	@Override
	public String generatePoNumber(String strRequestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT (max(po_id)+1) FROM pms_scm_purchase_order_ref");
		log.info(strRequestID + ":::::::::::::::generatePoNumber():::::::::::" + stringBuilder.toString());
		String maxIndent = objSupervisorDao.getSingleData(stringBuilder.toString());
		return maxIndent;

	}
	

	@Override
	public String saveIndentItemDetails(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_scm_indent_ref('").append(dataServiceDTO.getIndentidNumber())
				.append("',").append(dataServiceDTO.getModuleId()).append(",").append(dataServiceDTO.getRoleId())
				.append(",").append(dataServiceDTO.getCreateById()).append(",").append(dataServiceDTO.getApprovalId())
				.append(")");
		log.info(strRequestID + "::::::saveIndentItemDetails():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> getAllPurchaseOrderList(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		List<PlacingOrdersForPurchaseServiceDTO> listOfData;

		stringBuilder.append("select * from sp_select_purchage_order_qty('").append(dataInfo.getGenericName())
				.append("',").append(dataInfo.getBrandId()).append(",").append(dataInfo.getFormId()).append(",")
				.append(dataInfo.getManufactureId()).append(",'").append(dataInfo.getUnicode()).append("')");

		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.ConvertDataToGetAllPurchaseOrderList(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> getAllPurchaseOrderDrugCount(
			PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		List<PlacingOrdersForPurchaseServiceDTO> listOfData;

//		stringBuilder.append("select *from sp_select_purchage_order_drug_search('")
//				.append(dataServiceDTO.getGenericName()).append("',").append(dataServiceDTO.getBrandId()).append(",")
//				.append(dataServiceDTO.getFormId()).append(",").append(dataServiceDTO.getManufactureId()).append(",'")
//				.append(dataServiceDTO.getUnicode()).append("',").append(dataServiceDTO.getSystemId()).append(",")
//				.append(dataServiceDTO.getGenericgroupId()).append(",").append(dataServiceDTO.getModuleId())
//				.append(")");
		
		
		
		stringBuilder.append("select *from sp_select_purchage_order_drug_search('")
		.append(dataServiceDTO.getGenericName()).append("',").append(dataServiceDTO.getBrandId()).append(",")
		.append(dataServiceDTO.getFormId()).append(",").append(dataServiceDTO.getManufactureId()).append(",'")
		.append(dataServiceDTO.getUnicode())
		.append("')");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@ " +stringBuilder.toString());
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+stringBuilder.toString());
		
		
		
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.getpurchagedorderDrug(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;

	}

	@Override
	public String getAvailabeDrugs(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_purchage_order_avilable('")
				.append(dataServiceDTO.getGenericName()).append("',").append(dataServiceDTO.getBrandId()).append(",")
				.append(dataServiceDTO.getFormId()).append(",").append(dataServiceDTO.getManufactureId()).append(",'")
				.append(dataServiceDTO.getUnicode()).append("')");
		log.info(strRequestID + "::::::getAllPurchaseOrderDrugCount():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		return listData;
	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> loadIndentDetails(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException {
		List<PlacingOrdersForPurchaseServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_scm_indent_drugs('").append(dataInfo.getIndentidNumber())
				.append("')");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.ConvertDataToGetIndentDetails(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public String getEmpMailId(PlacingOrdersForPurchaseServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_vendor_Mailids(").append(dataInfo.getMesserId()).append(")");
		log.info(requestID + "::::::getEmpMailId():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String updateReturnItemStaus(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_drug_return_trans('").append(dataServiceDTO.getMesserId())
				.append("',").append(dataServiceDTO.getCount()).append(")");
		log.info(strRequestID + "::::::updateReturnItemStaus():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String savePoId(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append("select * from sp_insert_pms_scm_purchase_order_ref('")
//				.append(dataServiceDTO.getPo_number()).append("','").append(dataServiceDTO.getPo_raised_date())
//				.append("','").append(dataServiceDTO.getPo_order_date()).append("',")
//				.append(dataServiceDTO.getCreateById()).append(",").append(dataServiceDTO.getRoleId()).append(",")
//				.append(dataServiceDTO.getModuleId()).append(",'").append(dataServiceDTO.getPo_excepted_date())
//				.append("','").append(dataServiceDTO.getPo_terms_conditions()).append("')");
		
		
		stringBuilder.append("select * from sp_insert_pms_scm_purchase_order('")
		.append(dataServiceDTO.getPo_number()).append("','").append(dataServiceDTO.getPo_raised_date())
		.append("','").append(dataServiceDTO.getPo_order_date()).append("',")
		.append(dataServiceDTO.getCreateById()).append(",").append(dataServiceDTO.getRoleId()).append(",")
		.append(dataServiceDTO.getModuleId()).append(",'").append(dataServiceDTO.getPo_excepted_date())
		.append("','").append(dataServiceDTO.getPo_terms_conditions()).append("')");
		log.info(strRequestID + "::::::savePoId():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String getMesserAddress(PlacingOrdersForPurchaseServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_messers_address_pms_drugs_supplier_ref(")
				.append(dataInfo.getMesserId()).append(")");
		log.info(requestID + "::::::getMesserAddress():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		return listData;

	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> getPoDrug_Details(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException {
		List<PlacingOrdersForPurchaseServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from  sp_select_purchase_order_item_trans_poid(").append(dataInfo.getPo_id())
				.append(")");

		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.ConvertDataToGetPoDrug_Details(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public String insertMails(PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_scm_email_outbox_queue_trans(")
				.append(dataServiceDTO.getInboxqueueid()).append(",").append(dataServiceDTO.getReplyuser()).append(",'")
				.append(dataServiceDTO.getMailId()).append("','").append(dataServiceDTO.getSubject()).append("','")
				.append(dataServiceDTO.getCcmailids()).append("','").append(dataServiceDTO.getBccmailids())
				.append("','").append(dataServiceDTO.getReplybodylist()).append("',")
				.append(dataServiceDTO.getActionid()).append(",").append(dataServiceDTO.getTemplateid()).append(",")
				.append(dataServiceDTO.getIsdeleted()).append(",").append(dataServiceDTO.getCreateById()).append(",")
				.append(dataServiceDTO.getModuleId()).append(",").append(dataServiceDTO.getRoleId()).append(",")
				.append(dataServiceDTO.getSize()).append(")");
		log.info(strRequestID + "::::::insertMails():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> loadSupplier(PlacingOrdersForPurchaseServiceDTO dataInfo,
			String requestID) throws DataNotFoundException {
		List<PlacingOrdersForPurchaseServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_scm_supplier_wise_costdetails(").append(dataInfo.getDrugidList())
				.append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.ConvertDataToGetLoadSupplier(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> loadIndents(String strRequestID) throws DataNotFoundException {
		List<PlacingOrdersForPurchaseServiceDTO> datas = new ArrayList<PlacingOrdersForPurchaseServiceDTO>();
		StringBuilder stringBuilder = new StringBuilder();
		PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
		stringBuilder.append("SELECT * from sp_select_pms_loadIndents()");
		log.info(strRequestID + ":::::::::::::::loadIndents:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.convertObjetsArraytoGetLoadIndents(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::loadIndents ()::::::");
		}
		return datas;

	}

	@Override
	public List<BrandNameServiceDTO> loadBrandNames(String strRequestID) throws DataNotFoundException {
		List<BrandNameServiceDTO> datas = new ArrayList<BrandNameServiceDTO>();
		StringBuilder stringBuilder = new StringBuilder();
		BrandNameMapper dataMapper = new BrandNameMapper();
		stringBuilder.append(
				"SELECT db_brandid, db_drug_brand_lang1 FROM pms_drug_brand_ref where db_isactive = true order by 2");
		log.info(strRequestID + ":::::::::::::::loadIndents:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<BrandNamePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper.conversionOfBrandDetails(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::loadBrandNames ()::::::");
		}
		return datas;
	}

	@Override
	public List<ManufactureFormServiceDTO> loadManufactureForm(String strRequestID) throws DataNotFoundException {
		List<ManufactureFormServiceDTO> datas = new ArrayList<ManufactureFormServiceDTO>();
		StringBuilder stringBuilder = new StringBuilder();
		ManufactureFormMapper dataMapper = new ManufactureFormMapper();
		stringBuilder
				.append("SELECT df_serialid, df_form_type FROM pms_drug_form_ref where df_isactive = true order by 2");
		log.info(strRequestID + ":::::::::::::::loadIndents:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<ManufactureFormPersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.conversionOfBrandDetails(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::loadBrandNames ()::::::");
		}
		return datas;
	}

	@Override
	public List<ManufactureCompanyServiceDTO> loadManufactureCompnayNames(String strRequestID)
			throws DataNotFoundException {
		List<ManufactureCompanyServiceDTO> datas = new ArrayList<ManufactureCompanyServiceDTO>();
		StringBuilder stringBuilder = new StringBuilder();
		ManufactureCompanyMapper dataMapper = new ManufactureCompanyMapper();
		stringBuilder.append(
				"SELECT ma_manufactureid, ma_companyname FROM pms_drugs_manufacture_ref where ma_isactive = true order by 2");
		log.info(strRequestID + ":::::::::::::::loadIndents:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<ManufactureCompanyPersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.conversionOfBrandDetails(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);

		} else {
			throw new DataNotFoundException(strRequestID + ":::::::loadManufactureCompnayNames ()::::::");
		}
		return datas;
	}

	@Override
	public List<IndentDetailsServiceDTO> getIndentDetails(IndentDetailsServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		IndentDetailsMapper objIndentDetailsMapper = new IndentDetailsMapper();
		String query = null;

		query = " SELECT cit_id, cit_item_id, dr_drug_name,cit_approved_qty,dr_strength_type,dr_form_id,df_form_type,dr_manufaturer_id,ma_companyname,dr_brand_id,db_drug_brand_lang1 FROM pms_scm_indent_item_wise_trans inner join pms_drug_reg_ref on dr_serialid=cit_item_id inner join  pms_drug_form_ref on df_serialid=dr_form_id inner join pms_drugs_manufacture_ref on ma_manufactureid=dr_manufaturer_id inner join pms_drug_brand_ref on db_brandid=dr_brand_id where cit_indent_id="
				+ dataInfo.getIndent_id() + "";

		log.info(requestID + ":::::: getIndentDetails :::::::" + query);
		List<IndentDetailsServiceDTO> objIndentDetailsServiceDTO = new ArrayList<IndentDetailsServiceDTO>();
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(query.toString());
		if (null != list && !list.isEmpty()) {
			List<IndentDetailsPersistanceDTO> gisPersDTOs = objIndentDetailsMapper.conversionOfBrandDetails(list);
			objIndentDetailsServiceDTO = objIndentDetailsMapper.conversionpersistanceDTOtoServiceDTO(gisPersDTOs);
		} else {
			throw new DataNotFoundException(requestID + ":::::-getAllRegisteredFAtalQuestions:::::");
		}
		return objIndentDetailsServiceDTO;

	}

	@Override
	public String centralClose(CentralCloseServiceDTO dataInfo, String requestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_update_pms_scm_indent_ref_central_close(")
				.append(dataInfo.getIndent_id()).append(")");
		log.info(requestID + "::::::centralClose():::::::" + stringBuilder.toString());

		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;
	}

	@Override
	public List<PlacingOrdersForPurchaseServiceDTO> getAllPurchaseOrderDrugCountWithEightParam(
			PlacingOrdersForPurchaseServiceDTO dataServiceDTO, String strRequestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		List<PlacingOrdersForPurchaseServiceDTO> listOfData;

		stringBuilder.append("select *from sp_select_purchage_order_drug_search('")
				.append(dataServiceDTO.getGenericName()).append("',").append(dataServiceDTO.getBrandId()).append(",")
				.append(dataServiceDTO.getFormId()).append(",").append(dataServiceDTO.getManufactureId()).append(",'")
				.append(dataServiceDTO.getUnicode()).append("',").append(dataServiceDTO.getSystemId()).append(",")
				.append(dataServiceDTO.getGenericgroupId()).append(",").append(dataServiceDTO.getModuleId())
				.append(")");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@ " +stringBuilder.toString());
		log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@ "+stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(strRequestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PlacingOrdersForPurchaseMapper dataMapper = new PlacingOrdersForPurchaseMapper();
			List<PlacingOrdersForPurchasePersistanceDTO> placingOrdersForPurchasePersDTOs = dataMapper
					.getpurchagedorderDrug(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(placingOrdersForPurchasePersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;

	}
}

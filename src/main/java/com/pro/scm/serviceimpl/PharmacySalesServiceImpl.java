package com.pro.scm.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pro.scm.dao.SCMDao;
import com.pro.scm.exceptions.DataNotFoundException;
import com.pro.scm.mappers.LoadPaymentDetailsMapper;
import com.pro.scm.mappers.LoadTotalCreditAmountMapper;
import com.pro.scm.mappers.PharmacySalesMapper;
import com.pro.scm.persistencedto.LoadPaymentDetailsPersistenceDto;
import com.pro.scm.persistencedto.LoadTotalCreditPersistenceDto;
import com.pro.scm.persistencedto.PharmacySalesPersistenceDTO;
import com.pro.scm.service.PharmacySalesService;
import com.pro.scm.servicedto.LoadPaymentDetailsServiceDto;
import com.pro.scm.servicedto.LoadTotalCreditAmountServiceDto;
import com.pro.scm.servicedto.PharmacySalesServiceDTO;
import com.pro.scm.servicedto.SaveWardWiseCreditSalesServiceDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("objPharmacySalesServiceImpl")
@SuppressWarnings("unchecked")
public class PharmacySalesServiceImpl implements PharmacySalesService {

	@Autowired
	@Qualifier("objSupervisorDao")
	SCMDao objSupervisorDao;

	@Override
	public String getListofSalesCount(PharmacySalesServiceDTO dataInfo, String requestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count (*) from  sp_select_pharmacy_sales_list('").append(dataInfo.getCompanyname()).append("','")
		.append(dataInfo.getPatientName()).append("','").append(dataInfo.getFromdate()).append("','").append(dataInfo.getTodate()).append("','")
		.append(dataInfo.getPaymentId()).append("','").append(dataInfo.getStoreId()).append ("')");
		log.info(requestID + "::::::getListofSalesCount():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		return listData;

	}
	@Override
	public List<PharmacySalesServiceDTO> getListofSales(PharmacySalesServiceDTO dataInfo, String requestID) throws DataNotFoundException {
		List<PharmacySalesServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from  sp_select_pharmacy_sales_list('").append(dataInfo.getCompanyname()).append("','")
		.append(dataInfo.getPatientName()).append("','").append(dataInfo.getFromdate()).append("','").append(dataInfo.getTodate()).append("','")
		.append(dataInfo.getPaymentId()).append("','").append(dataInfo.getStoreId()).append("')");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PharmacySalesMapper dataMapper = new PharmacySalesMapper();
			List<PharmacySalesPersistenceDTO> pharmacySalesPersDTOs = dataMapper.ConvertDataToGetListofSales(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<PharmacySalesServiceDTO> loadPayment(String requestID) throws DataNotFoundException {
		// TODO Auto-generated method stub
		List<PharmacySalesServiceDTO> datas = new ArrayList<PharmacySalesServiceDTO>();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("SELECT * from sp_select_payment_ref()");
		log.info(requestID + ":::::::::::::::loadPayment:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<PharmacySalesPersistenceDTO> pharmacySalesPersDTOs = dataMapper.convertObjetsArraytoGetPayment(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);

		} else {
			throw new DataNotFoundException(requestID + ":::::::loadPayment()::::::");
		}
		return datas;

	}

	@Override
	public String getAllMedicinesCount1(PharmacySalesServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select count (*) from  sp_select_pharmacy_sales_qty_id('").append(dataInfo.getGenericName()).append("',")
		.append(dataInfo.getBrandName()).append(",").append(dataInfo.getForm()).append(",").append(dataInfo.getMfgId()).append(",'")
		.append(dataInfo.getUnicode() ).append( "',").append(dataInfo.getSystemid()).append(",").append(dataInfo.getGenericgroupid()).append(",")
		.append( dataInfo.getGenericMoleculeid()).append(",").append(dataInfo.getStoreId()).append(")");
		log.info(requestID + "::::::getAllMedicinesCount1():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String getAvailableMedicine(PharmacySalesServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_search_pharmacy_sales_drug('").append(dataInfo.getGenericName() ).append("',")
		.append(dataInfo.getBrandName()).append(",").append(dataInfo.getForm()).append(",").append(dataInfo.getMfgId()).append(",'")
		.append( dataInfo.getUnicode()).append("')");
		log.info(requestID + "::::::getAvailableMedicine():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String checkAvailableQty(PharmacySalesServiceDTO dataInfo, String requestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_batchwise_available_quantity('").append(dataInfo.getBatchNo()).append("',")
		.append(dataInfo.getDrugId()).append(",").append(dataInfo.getIssuedQty()).append(",").append(dataInfo.getCounterId()).append( ")");
		log.info(requestID + "::::::checkAvailableQty():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.getSingleData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String getBillNumber(String requestID) throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from get_billno()");
		log.info(requestID + ":::::::::::::::getBillNumber():::::::::::" + stringBuilder.toString());
		String billNumber = objSupervisorDao.getSingleData(stringBuilder.toString());
		return billNumber;
	}

	@Override
	public String saveBilDetails(PharmacySalesServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pms_sales_trans('").append(dataServiceDTO.getBillNumber()).append("','")
		.append(dataServiceDTO.getVat()).append("','").append(dataServiceDTO.getTaxAmount()).append("','")
		.append(dataServiceDTO.getNetAmount()).append("','").append(dataServiceDTO.getDisc()).append("','" ).append( dataServiceDTO.getDate())
		.append( "','") .append( dataServiceDTO.getPatientName()).append("','").append(dataServiceDTO.getPhoneNumber()).append("',")
		.append(dataServiceDTO.getDocId()).append(",").append(dataServiceDTO.getUserId()).append(",").append(dataServiceDTO.getModuleId())
		.append( ",").append(dataServiceDTO.getRoleId()).append(",").append(dataServiceDTO.getDepatrmId()).append(",")
		.append(dataServiceDTO.getWardId()).append(",").append(dataServiceDTO.getEmployee()).append(",").append(dataServiceDTO.getCredit())
		.append( ",").append(dataServiceDTO.getCreditAmount()).append("," ).append( dataServiceDTO.getPaidAmount()).append(",")
		.append(dataServiceDTO.getCompany()).append( ",").append(dataServiceDTO.getPayment()).append(",").append(dataServiceDTO.getStore())
		.append( ",'").append(dataServiceDTO.getOpnumber()).append("',").append( dataServiceDTO.getDiscount()).append(",")
		.append(dataServiceDTO.getTotalAmount()).append(")");
		log.info(strRequestID + "::::::saveBilDetails():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String saveDrugstatus(PharmacySalesServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_insert_pharmacy_pms_drug_sales_trans('").append(dataServiceDTO.getDrugId()).append("','")
		.append(dataServiceDTO.getBatchCode()).append("','").append( dataServiceDTO.getExpDate()).append("','")
		.append(dataServiceDTO.getReqqty()).append("','").append(dataServiceDTO.getSalesrate()).append("','").append(dataServiceDTO.getMrp())
		.append("','").append(dataServiceDTO.getBillNumber()).append("',").append(dataServiceDTO.getCount()).append(",")
		.append(dataServiceDTO.getUserId()).append(",").append(dataServiceDTO.getRoleId() ).append(",").append(dataServiceDTO.getModuleId())
		.append( ",'").append(dataServiceDTO.getOpnumber()).append("','").append(dataServiceDTO.getUnicode()).append("',")
		.append(dataServiceDTO.getCounterId()).append (")");
		log.info(strRequestID + "::::::saveDrugstatus():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public String savePayment_Details(PharmacySalesServiceDTO dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_ins_pms_payment_Detaisl('").append(dataServiceDTO.getBillNumber()).append("',")
		.append(dataServiceDTO.getStoreId()).append(",").append(dataServiceDTO.getCrDbyear()).append(",").append(dataServiceDTO.getCrDbmonth())
		.append(",'").append(dataServiceDTO.getCrDbno()).append("','").append(dataServiceDTO.getCrDBbank()).append("','")
		.append(dataServiceDTO.getCrHname()) .append( "','").append(dataServiceDTO.getChequeno()).append("','")
		.append(dataServiceDTO.getDrawname()).append("','").append(dataServiceDTO.getCheqdate()).append("',")
		.append(dataServiceDTO.getUserId()).append(",").append(dataServiceDTO.getModuleId()).append(",").append(dataServiceDTO.getRoleId())
		.append( ")");
		log.info(strRequestID + "::::::saveDrugstatus():::::::" + stringBuilder.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(stringBuilder.toString());
		return listData;

	}

	@Override
	public List<PharmacySalesServiceDTO> loadType(PharmacySalesServiceDTO dataInfo, String requestID)
			throws DataNotFoundException {
		List<PharmacySalesServiceDTO> listOfData;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_app_fieldvalues_type(").append(dataInfo.getGroupId()).append(")");
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		log.info(requestID + ":::::::list::::::" + list.size());
		if (null != list && !list.isEmpty() && list.size() > 0) {
			PharmacySalesMapper dataMapper = new PharmacySalesMapper();
			List<PharmacySalesPersistenceDTO> pharmacySalesPersDTOs = dataMapper.ConvertDataToGetLoadType(list);
			listOfData = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);
		} else {
			throw new DataNotFoundException("");
		}
		return listOfData;
	}

	@Override
	public List<PharmacySalesServiceDTO> loadDoctors(String requestID) throws DataNotFoundException {
		List<PharmacySalesServiceDTO> datas = new ArrayList<PharmacySalesServiceDTO>();
		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pharmacy_loadDoctor()");
		log.info(requestID + ":::::::::::::::loadDoctors:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<PharmacySalesPersistenceDTO> pharmacySalesPersDTOs = dataMapper
					.convertObjetsArraytoGetLoadDoctors(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);

		} else {
			throw new DataNotFoundException(requestID + ":::::::loadDoctors()::::::");
		}
		return datas;

	}

	@Override
	public List<PharmacySalesServiceDTO> loadDepartment(String requestID) throws DataNotFoundException {
		List<PharmacySalesServiceDTO> datas = new ArrayList<PharmacySalesServiceDTO>();

		PharmacySalesMapper dataMapper = new PharmacySalesMapper();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_pms_department_name()");
		log.info(requestID + ":::::::::::::::loadDepartment:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			List<PharmacySalesPersistenceDTO> pharmacySalesPersDTOs = dataMapper
					.convertObjetsArraytoGetDepartment(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);
		} else {
			throw new DataNotFoundException(requestID + ":::::::loadDepartment()::::::");
		}
		return datas;

	}

	@Override
	public List<LoadPaymentDetailsServiceDto> loadPaymentDetails(
			LoadPaymentDetailsServiceDto loadPaymentDetailsServiceDto, String requestID) throws DataNotFoundException {
		List<LoadPaymentDetailsServiceDto> datas;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SELECT  pbp_crcardno,pbp_crexpmonth, pbp_crexpyear, pbp_bankname, pbp_crholdername  FROM pms_patientdrug_bill_details_trans inner join pms_patientdrug_bill_payment_trans on pbd_billno=pbp_bill_number where pbd_payment_type= ")
				.append(loadPaymentDetailsServiceDto.getPayment()).append(" and pbp_bill_number= ").append("'")
				.append(loadPaymentDetailsServiceDto.getBillNumber()).append("'");
		log.info(requestID + ":::::::::::::::loadPaymentDetails:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			LoadPaymentDetailsMapper dataMapper = new LoadPaymentDetailsMapper();
			List<LoadPaymentDetailsPersistenceDto> pharmacySalesPersDTOs = dataMapper
					.settingDataIntoLoadPaymentDetailsPersistenceDto(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);

		} else {
			throw new DataNotFoundException(requestID + ":::::::loadPaymentDetails()::::::");
		}
		return datas;
	}

	@Override
	public List<LoadPaymentDetailsServiceDto> loadCompany(String requestID) throws DataNotFoundException {
		List<LoadPaymentDetailsServiceDto> datas;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("select * from sp_select_company_tf_ref()");
		log.info(requestID + ":::::::::::::::loadPaymentDetails:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			LoadPaymentDetailsMapper dataMapper = new LoadPaymentDetailsMapper();
			List<LoadPaymentDetailsPersistenceDto> pharmacySalesPersDTOs = dataMapper
					.settingDataIntoLoadPaymentDetailsPersistenceDtoForloadCompany(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);

		} else {
			throw new DataNotFoundException(requestID + ":::::::loadPaymentDetails()::::::");
		}
		return datas;
	}

	@Override
	public List<LoadTotalCreditAmountServiceDto> loadTotalCreditAmount(
			LoadTotalCreditAmountServiceDto loadTotalCreditAmountServiceDto, String requestID)
			throws DataNotFoundException {
		List<LoadTotalCreditAmountServiceDto> datas;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"SELECT sum(pbd_amounttopay)as totalamount,sum(pbd_credit_amount)as creditamount FROM pms_patientdrug_bill_details_trans  where pbd_ward_id =");
		stringBuilder.append("'");
		stringBuilder.append(loadTotalCreditAmountServiceDto.getWardId());
		stringBuilder.append("'");
		stringBuilder.append("and pbd_credit_status= true and pbd_credit_amount<>0");
		log.info(requestID + ":::::::::::::::loadPaymentDetails:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			LoadTotalCreditAmountMapper dataMapper = new LoadTotalCreditAmountMapper();
			List<LoadTotalCreditPersistenceDto> pharmacySalesPersDTOs = dataMapper
					.settingDataIntoLoadTotalCreditPersistenceDto(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);
		} else {
			throw new DataNotFoundException(requestID + ":::::::loadPaymentDetails()::::::");
		}
		return datas;
	}

	@Override
	public List<LoadTotalCreditAmountServiceDto> loadWardWiseCredit(
			LoadTotalCreditAmountServiceDto loadTotalCreditAmountServiceDto, String requestID)
			throws DataNotFoundException {
		List<LoadTotalCreditAmountServiceDto> datas;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"   SELECT pbd_billno, er_employeefirstname,pbd_amounttopay,pbd_credit_amount FROM pms_patientdrug_bill_details_trans inner join pms_employee_registration_ref on pbd_employee_id=er_employeeid  where pbd_ward_id = ");
		stringBuilder.append("'");
		stringBuilder.append(loadTotalCreditAmountServiceDto.getWardId());
		stringBuilder.append("'");
		stringBuilder.append("and pbd_credit_amount is not null and pbd_credit_amount<>0");
		log.info(requestID + ":::::::::::::::loadPaymentDetails:::::::::::" + stringBuilder.toString());
		List<Object[]> list = (List<Object[]>) objSupervisorDao.getData(stringBuilder.toString());
		if (null != list && !list.isEmpty()) {
			LoadTotalCreditAmountMapper dataMapper = new LoadTotalCreditAmountMapper();
			List<LoadTotalCreditPersistenceDto> pharmacySalesPersDTOs = dataMapper
					.settingDataIntoLoadTotalCreditPersistenceDtoForloadWardWiseCredit(list);
			datas = dataMapper.conversionpersistanceDTOtoServiceDTO(pharmacySalesPersDTOs);
		} else {
			throw new DataNotFoundException(requestID + ":::::::loadPaymentDetails()::::::");
		}
		return datas;
	}

	@Override
	public String saveWardWiseCreditSales(SaveWardWiseCreditSalesServiceDto dataServiceDTO, String strRequestID)
			throws DataNotFoundException {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from sp_insert_update_credit_pay_pms_wardwise_credit_amount_trans('")
				.append(dataServiceDTO.getBillNo()).append("'");
		sb.append(",").append(dataServiceDTO.getFltTotalAmount()).append(",")
				.append(dataServiceDTO.getFltCreditAmount()).append(",").append(dataServiceDTO.getFltPaidAmount())
				.append(",");
		sb.append(dataServiceDTO.getEmployeeId()).append(",").append(dataServiceDTO.getCreatedbyId()).append(",")
				.append(dataServiceDTO.getModuleID()).append(")");
		log.info(strRequestID + "::::::saveDrugstatus():::::::" + sb.toString());
		String listData = null;
		listData = objSupervisorDao.saveData(sb.toString());
		return listData;

	}
}

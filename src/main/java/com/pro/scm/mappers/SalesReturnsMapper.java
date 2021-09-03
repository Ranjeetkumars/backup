package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;


import com.pro.scm.controllerdto.SalesReturnsControllerDTO;

import com.pro.scm.persistencedto.SalesReturnsPersistenceDTO;

import com.pro.scm.servicedto.SalesReturnsServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class SalesReturnsMapper {
	public SalesReturnsServiceDTO conversionControllerDtoToServiceDto(
			SalesReturnsControllerDTO objSalesReturnsControllerDto) {
		SalesReturnsServiceDTO objSalesReturnsServiceDto = new  SalesReturnsServiceDTO();
		BeanUtils.copyProperties(objSalesReturnsControllerDto, objSalesReturnsServiceDto);

		return objSalesReturnsServiceDto;
	}

	public List<SalesReturnsControllerDTO> conversionForServiceTOControllerDTO(List<SalesReturnsServiceDTO> objServicedto) {
		List<SalesReturnsControllerDTO> objSalesReturnsControllerDto = new ArrayList<SalesReturnsControllerDTO>();
		objServicedto.forEach(SalesReturnsServiceDto -> {
			SalesReturnsControllerDTO objSalesReturnsControllerDto1 = new  SalesReturnsControllerDTO();
			BeanUtils.copyProperties(SalesReturnsServiceDto, objSalesReturnsControllerDto1);
			objSalesReturnsControllerDto.add(objSalesReturnsControllerDto1);
		});
		return objSalesReturnsControllerDto;
	}

	public List<SalesReturnsServiceDTO> conversionpersistanceDTOtoServiceDTO(List<SalesReturnsPersistenceDTO> persistenceDTOs) {
		List<SalesReturnsServiceDTO> objServicedtos = new ArrayList<SalesReturnsServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			SalesReturnsServiceDTO objSearchServiceDto = new  SalesReturnsServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<SalesReturnsPersistenceDTO> ConvertDataToGetBillDetails(List<Object[]> list) {
		List<SalesReturnsPersistenceDTO> listOfData = new ArrayList<SalesReturnsPersistenceDTO>();
		for (Object[] objects : list) {
			SalesReturnsPersistenceDTO objPersistenceDTO = new SalesReturnsPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setBillNumber(objects[0].toString());
			} else {
				objPersistenceDTO.setBillNumber(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setCreatedByDate(objects[1].toString());
			} else {
				objPersistenceDTO.setCreatedByDate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setPatientName(objects[2].toString());
				} else {
					objPersistenceDTO.setPatientName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setVatPrice(objects[3].toString());
				} else {
					objPersistenceDTO.setVatPrice(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setConcession(objects[3].toString());
				} else {
					objPersistenceDTO.setConcession(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[4] != null) {
					objPersistenceDTO.setAmounttopay(objects[4].toString());
				} else {
					objPersistenceDTO.setAmounttopay(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[5] != null) {
					objPersistenceDTO.setVatPercentage(objects[5].toString());
				} else {
					objPersistenceDTO.setVatPercentage(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[6] != null) {
					objPersistenceDTO.setDiscountper(objects[6].toString());
				} else {
					objPersistenceDTO.setDiscountper(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
	public List<SalesReturnsPersistenceDTO> ConvertDataToGetBillItemDetails(List<Object[]> list) {
		List<SalesReturnsPersistenceDTO> listOfData = new ArrayList<SalesReturnsPersistenceDTO>();
		for (Object[] objects : list) {
			SalesReturnsPersistenceDTO objPersistenceDTO = new SalesReturnsPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDrugId(objects[0].toString());
			} else {
				objPersistenceDTO.setDrugId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setDrugName(objects[1].toString());
			} else {
				objPersistenceDTO.setDrugName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setBrandName(objects[2].toString());
				} else {
					objPersistenceDTO.setBrandName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setFormType(objects[3].toString());
				} else {
					objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setPackingType(objects[3].toString());
				} else {
					objPersistenceDTO.setPackingType(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[4] != null) {
					objPersistenceDTO.setBatch_code(objects[4].toString());
				} else {
					objPersistenceDTO.setBatch_code(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[5] != null) {
					objPersistenceDTO.setExpdate(objects[5].toString());
				} else {
					objPersistenceDTO.setExpdate(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[6] != null) {
					objPersistenceDTO.setUnitCost(objects[6].toString());
				} else {
					objPersistenceDTO.setUnitCost(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[7] != null) {
					objPersistenceDTO.setMainStock(objects[7].toString());
				} else {
					objPersistenceDTO.setMainStock(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[8] != null) {
					objPersistenceDTO.setMrp(objects[8].toString());
				} else {
					objPersistenceDTO.setMrp(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[9] != null) {
					objPersistenceDTO.setAmount(objects[9].toString());
				} else {
					objPersistenceDTO.setAmount(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[10] != null) {
					objPersistenceDTO.setAvailableStock(objects[10].toString());
				} else {
					objPersistenceDTO.setAvailableStock(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[10] != null) {
					objPersistenceDTO.setStrength(objects[10].toString());
				} else {
					objPersistenceDTO.setStrength(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[11] != null) {
					objPersistenceDTO.setMin_sales_qty(objects[11].toString());
				} else {
					objPersistenceDTO.setMin_sales_qty(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

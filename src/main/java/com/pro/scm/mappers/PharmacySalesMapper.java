package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.PharmacySalesControllerDTO;
import com.pro.scm.persistencedto.PharmacySalesPersistenceDTO;
import com.pro.scm.servicedto.PharmacySalesServiceDTO;
import com.pro.scm.utills.CommonConstants;
public class PharmacySalesMapper {
	public PharmacySalesServiceDTO conversionControllerDtoToServiceDto(
			PharmacySalesControllerDTO objPharmacySalesControllerDto) {
		PharmacySalesServiceDTO objPharmacySalesServiceDto = new  PharmacySalesServiceDTO();
		BeanUtils.copyProperties(objPharmacySalesControllerDto, objPharmacySalesServiceDto);

		return objPharmacySalesServiceDto;
	}

	public List<PharmacySalesControllerDTO> conversionForServiceTOControllerDTO(List<PharmacySalesServiceDTO> objServicedto) {
		List<PharmacySalesControllerDTO> objPharmacySalesControllerDto = new ArrayList<PharmacySalesControllerDTO>();
		objServicedto.forEach(PharmacySalesServiceDto -> {
			PharmacySalesControllerDTO objPharmacySalesControllerDto1 = new  PharmacySalesControllerDTO();
			BeanUtils.copyProperties(PharmacySalesServiceDto, objPharmacySalesControllerDto1);
			objPharmacySalesControllerDto.add(objPharmacySalesControllerDto1);
		});
		return objPharmacySalesControllerDto;
	}

	public List<PharmacySalesServiceDTO> conversionpersistanceDTOtoServiceDTO(List<PharmacySalesPersistenceDTO> persistenceDTOs) {
		List<PharmacySalesServiceDTO> objServicedtos = new ArrayList<PharmacySalesServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			PharmacySalesServiceDTO objSearchServiceDto = new  PharmacySalesServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	
	
	public List<PharmacySalesPersistenceDTO> ConvertDataToGetListofSales(List<Object[]> list) {
		List<PharmacySalesPersistenceDTO> listOfData = new ArrayList<PharmacySalesPersistenceDTO>();
		for (Object[] objects : list) {
			PharmacySalesPersistenceDTO objPersistenceDTO = new PharmacySalesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setBillDate(objects[0].toString());
			} else {
				objPersistenceDTO.setBillDate(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setPatientId(objects[1].toString());
			} else {
				objPersistenceDTO.setPatientId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 if (objects[2] != null) {
					objPersistenceDTO.setBillNumber(objects[2].toString());
				} else {
					objPersistenceDTO.setBillNumber(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setAmount(objects[3].toString());
				} else {
					objPersistenceDTO.setAmount(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[4] != null) {
					objPersistenceDTO.setPatientName(objects[4].toString());
				} else {
					objPersistenceDTO.setPatientName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[5] != null) {
					objPersistenceDTO.setUserName(objects[5].toString());
				} else {
					objPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[6] != null) {
					objPersistenceDTO.setPaymentId(objects[6].toString());
				} else {
					objPersistenceDTO.setPaymentId(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[7] != null) {
					objPersistenceDTO.setCompanyname(objects[7].toString());
				} else {
					objPersistenceDTO.setCompanyname(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[8] != null) {
					objPersistenceDTO.setCounterName(objects[8].toString());
				} else {
					objPersistenceDTO.setCounterName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
	public List<PharmacySalesPersistenceDTO> convertObjetsArraytoGetPayment(List<Object[]> list) {
		List<PharmacySalesPersistenceDTO> listOfData = new ArrayList<PharmacySalesPersistenceDTO>();
		for (Object[] objects : list) {
			PharmacySalesPersistenceDTO objPersistenceDTO = new PharmacySalesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setPaymentId(objects[0].toString());
			} else {
				objPersistenceDTO.setPaymentId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setPaymentName(objects[1].toString());
			} else {
				objPersistenceDTO.setPaymentName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	public List<PharmacySalesPersistenceDTO> ConvertDataToGetLoadType(List<Object[]> list) {
		List<PharmacySalesPersistenceDTO> listOfData = new ArrayList<PharmacySalesPersistenceDTO>();
		for (Object[] objects : list) {
			PharmacySalesPersistenceDTO objPersistenceDTO = new PharmacySalesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setFieldId(objects[0].toString());
			} else {
				objPersistenceDTO.setFieldId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setFieldType(objects[1].toString());
			} else {
				objPersistenceDTO.setFieldType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	public List<PharmacySalesPersistenceDTO> convertObjetsArraytoGetLoadDoctors(List<Object[]> list) {
		List<PharmacySalesPersistenceDTO> listOfData = new ArrayList<PharmacySalesPersistenceDTO>();
		for (Object[] objects : list) {
			PharmacySalesPersistenceDTO objPersistenceDTO = new PharmacySalesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setUserId(objects[0].toString());
			} else {
				objPersistenceDTO.setUserId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setUserName(objects[1].toString());
			} else {
				objPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<PharmacySalesPersistenceDTO> convertObjetsArraytoGetDepartment(List<Object[]> list) {
		List<PharmacySalesPersistenceDTO> listOfData = new ArrayList<PharmacySalesPersistenceDTO>();
		for (Object[] objects : list) {
			PharmacySalesPersistenceDTO objPersistenceDTO = new PharmacySalesPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDepatrmId(objects[0].toString());
			} else {
				objPersistenceDTO.setDepatrmId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setDepartmentName(objects[1].toString());
			} else {
				objPersistenceDTO.setDepartmentName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	

}

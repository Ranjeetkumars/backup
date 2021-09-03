package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.ReceivedGoodsControllerDTO;
import com.pro.scm.persistencedto.ReceivedGoodsPersistenceDTO;
import com.pro.scm.servicedto.ReceivedGoodsServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class ReceivedGoodsMapper {
	public ReceivedGoodsServiceDTO conversionControllerDtoToServiceDto(
			 ReceivedGoodsControllerDTO objReceivedGoodsControllerDto) {
		 ReceivedGoodsServiceDTO objReceivedGoodsServiceDto = new  ReceivedGoodsServiceDTO();
		BeanUtils.copyProperties(objReceivedGoodsControllerDto, objReceivedGoodsServiceDto);

		return objReceivedGoodsServiceDto;
	}
	
	
	
	public List<ReceivedGoodsControllerDTO> conversionForServiceTOControllerDTO(List<ReceivedGoodsServiceDTO> objServicedto) {
		List< ReceivedGoodsControllerDTO> objReceivedGoodsControllerDto = new ArrayList< ReceivedGoodsControllerDTO>();
		objServicedto.forEach(PurchaseOrderServiceDto -> {
			 ReceivedGoodsControllerDTO objReceivedGoodsControllerDto1 = new  ReceivedGoodsControllerDTO();
			BeanUtils.copyProperties(PurchaseOrderServiceDto, objReceivedGoodsControllerDto1);
			objReceivedGoodsControllerDto.add(objReceivedGoodsControllerDto1);
		});
		return objReceivedGoodsControllerDto;
	}

	public List<ReceivedGoodsServiceDTO> conversionpersistanceDTOtoServiceDTO(List<ReceivedGoodsPersistenceDTO> persistenceDTOs) {
		List<ReceivedGoodsServiceDTO> objServicedtos = new ArrayList<ReceivedGoodsServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			 ReceivedGoodsServiceDTO objSearchServiceDto = new  ReceivedGoodsServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}



public List<ReceivedGoodsPersistenceDTO> ConvertDataToGetAllReceivedGoods(List<Object[]> list) {
	List<ReceivedGoodsPersistenceDTO> listOfData = new ArrayList<ReceivedGoodsPersistenceDTO>();
	for (Object[] objects : list) {
		ReceivedGoodsPersistenceDTO objPersistenceDTO = new ReceivedGoodsPersistenceDTO();
		if (objects[0] != null) {
			objPersistenceDTO.setTrans_id(objects[0].toString());
		} else {
			objPersistenceDTO.setTrans_id(CommonConstants.DATA_NOT_AVIALABLE);
		}
		 if (objects[1] != null) {
			objPersistenceDTO.setDrug_name(objects[1].toString());
		} else {
			objPersistenceDTO.setDrug_name(CommonConstants.DATA_NOT_AVIALABLE);
		}
		 
		 if (objects[2] != null) {
				objPersistenceDTO.setDrug_brand_lang(objects[2].toString());
			} else {
				objPersistenceDTO.setDrug_brand_lang(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[3] != null) {
				objPersistenceDTO.setForm_type(objects[3].toString());
			} else {
				objPersistenceDTO.setForm_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[4] != null) {
				objPersistenceDTO.setCompanyname(objects[4].toString());
			} else {
				objPersistenceDTO.setCompanyname(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[5] != null) {
				objPersistenceDTO.setStrength_type(objects[5].toString());
			} else {
				objPersistenceDTO.setStrength_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[6] != null) {
				objPersistenceDTO.setPacking_type(objects[6].toString());
			} else {
				objPersistenceDTO.setPacking_type(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[7] != null) {
				objPersistenceDTO.setAppoval(objects[7].toString());
			} else {
				objPersistenceDTO.setAppoval(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[8] != null) {
				objPersistenceDTO.setSuppliername(objects[8].toString());
			} else {
				objPersistenceDTO.setSuppliername(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[9] != null) {
				objPersistenceDTO.setPo_number(objects[9].toString());
			} else {
				objPersistenceDTO.setPo_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[10] != null) {
				objPersistenceDTO.setDrug_id(objects[10].toString());
			} else {
				objPersistenceDTO.setDrug_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[11] != null) {
				objPersistenceDTO.setDr_serialid(objects[11].toString());
			} else {
				objPersistenceDTO.setDr_serialid(CommonConstants.DATA_NOT_AVIALABLE);
			} if (objects[12] != null) {
				objPersistenceDTO.setDf_serialid(objects[12].toString());
			} else {
				objPersistenceDTO.setDf_serialid(CommonConstants.DATA_NOT_AVIALABLE);
			} if (objects[13] != null) {
				objPersistenceDTO.setPt_serialid(objects[13].toString());
			} else {
				objPersistenceDTO.setPt_serialid(CommonConstants.DATA_NOT_AVIALABLE);
			} if (objects[14] != null) {
				objPersistenceDTO.setSupplierid(objects[14].toString());
			} else {
				objPersistenceDTO.setSupplierid(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[15] != null) {
				objPersistenceDTO.setUnit_cost(objects[15].toString());
			} else {
				objPersistenceDTO.setUnit_cost(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
if (objects[16] != null) {
		objPersistenceDTO.setPercentage(objects[16].toString());
	} else {
		objPersistenceDTO.setPercentage(CommonConstants.DATA_NOT_AVIALABLE);
	}
if (objects[17] != null) {
	objPersistenceDTO.setMrp(objects[17].toString());
} else {
	objPersistenceDTO.setMrp(CommonConstants.DATA_NOT_AVIALABLE);
}
if (objects[18] != null) {
	objPersistenceDTO.setDisscount(objects[18].toString());
} else {
	objPersistenceDTO.setDisscount(CommonConstants.DATA_NOT_AVIALABLE);
}if (objects[19] != null) {
	objPersistenceDTO.setPurchase_unitcost(objects[19].toString());
} else {
	objPersistenceDTO.setPurchase_unitcost(CommonConstants.DATA_NOT_AVIALABLE);
}
			if (objects[20] != null) {
				objPersistenceDTO.setPurchage_price(objects[20].toString());
			} else {
				objPersistenceDTO.setPurchage_price(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[21] != null) {
				objPersistenceDTO.setConversionfactor(objects[21].toString());
			} else {
				objPersistenceDTO.setConversionfactor(CommonConstants.DATA_NOT_AVIALABLE);
			}if (objects[22] != null) {
				objPersistenceDTO.setBarcode(objects[22].toString());
			} else {
				objPersistenceDTO.setBarcode(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 listOfData.add(objPersistenceDTO);
	}
	return listOfData;
}

public List<ReceivedGoodsPersistenceDTO> ConvertDataToGetEpectiedDateAndTermsCondtions(List<Object[]> list) {
	List<ReceivedGoodsPersistenceDTO> listOfData = new ArrayList<ReceivedGoodsPersistenceDTO>();
	for (Object[] objects : list) {
		ReceivedGoodsPersistenceDTO objPersistenceDTO = new ReceivedGoodsPersistenceDTO();
		if (objects[0] != null) {
			objPersistenceDTO.setExcepted_date(objects[0].toString());
		} else {
			objPersistenceDTO.setExcepted_date(CommonConstants.DATA_NOT_AVIALABLE);
		}
		 if (objects[1] != null) {
			objPersistenceDTO.setTerms_conditions(objects[1].toString());
		} else {
			objPersistenceDTO.setTerms_conditions(CommonConstants.DATA_NOT_AVIALABLE);
		}
			
		 listOfData.add(objPersistenceDTO);
	}
	return listOfData;
}

public List<ReceivedGoodsPersistenceDTO> ConvertDataToGetAllReceivedGoodsSearch(List<Object[]> list) {
	List<ReceivedGoodsPersistenceDTO> listOfData = new ArrayList<ReceivedGoodsPersistenceDTO>();
	for (Object[] objects : list) {
		ReceivedGoodsPersistenceDTO objPersistenceDTO = new ReceivedGoodsPersistenceDTO();
		if (objects[0] != null) {
			objPersistenceDTO.setTrans_id(objects[0].toString());
		} else {
			objPersistenceDTO.setTrans_id(CommonConstants.DATA_NOT_AVIALABLE);
		}
		 if (objects[1] != null) {
			objPersistenceDTO.setPo_id(objects[1].toString());
		} else {
			objPersistenceDTO.setPo_id(CommonConstants.DATA_NOT_AVIALABLE);
		}
		 if (objects[2] != null) {
				objPersistenceDTO.setPo_number(objects[2].toString());
			} else {
				objPersistenceDTO.setPo_number(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[3] != null) {
				objPersistenceDTO.setToday_date(objects[3].toString());
			} else {
				objPersistenceDTO.setToday_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[4] != null) {
				objPersistenceDTO.setQuotation_date(objects[4].toString());
			} else {
				objPersistenceDTO.setQuotation_date(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[5] != null) {
				objPersistenceDTO.setSuppliername(objects[5].toString());
			} else {
				objPersistenceDTO.setSuppliername(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[6] != null) {
				objPersistenceDTO.setUserName(objects[6].toString());
			} else {
				objPersistenceDTO.setUserName(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 if (objects[7] != null) {
				objPersistenceDTO.setTotalAmount(objects[7].toString());
			} else {
				objPersistenceDTO.setTotalAmount(CommonConstants.DATA_NOT_AVIALABLE);
			}
		 listOfData.add(objPersistenceDTO);
	}
	return listOfData;
}
















}
 
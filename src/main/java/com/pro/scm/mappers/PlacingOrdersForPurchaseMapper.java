package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;



import com.pro.scm.controllerdto.PlacingOrdersForPurchaseControllerDTO;
import com.pro.scm.persistencedto.PlacingOrdersForPurchasePersistanceDTO;
import com.pro.scm.servicedto.PlacingOrdersForPurchaseServiceDTO;
import com.pro.scm.utills.CommonConstants;



public class PlacingOrdersForPurchaseMapper {


	public PlacingOrdersForPurchaseServiceDTO conversionControllerDtoToServiceDto(
			PlacingOrdersForPurchaseControllerDTO objPlacingOrdersForPurchaseControllerDto) {
		PlacingOrdersForPurchaseServiceDTO objPlacingOrdersForPurchaseServiceDto = new PlacingOrdersForPurchaseServiceDTO();
		BeanUtils.copyProperties(objPlacingOrdersForPurchaseControllerDto, objPlacingOrdersForPurchaseServiceDto);

		return objPlacingOrdersForPurchaseServiceDto;
	}
	
	
	
	public List<PlacingOrdersForPurchaseControllerDTO> conversionForServiceTOControllerDTO(List<PlacingOrdersForPurchaseServiceDTO> objServicedto) {
		List<PlacingOrdersForPurchaseControllerDTO> objPlacingOrdersForPurchaseControllerDto = new ArrayList<PlacingOrdersForPurchaseControllerDTO>();
		objServicedto.forEach(PlacingOrdersForPurchaseServiceDto -> {
			PlacingOrdersForPurchaseControllerDTO objPlacingOrdersForPurchaseControllerDto1 = new PlacingOrdersForPurchaseControllerDTO();
			BeanUtils.copyProperties(PlacingOrdersForPurchaseServiceDto, objPlacingOrdersForPurchaseControllerDto1);
			objPlacingOrdersForPurchaseControllerDto.add(objPlacingOrdersForPurchaseControllerDto1);
		});
		return objPlacingOrdersForPurchaseControllerDto;
	}

	public List<PlacingOrdersForPurchaseServiceDTO> conversionpersistanceDTOtoServiceDTO(List<PlacingOrdersForPurchasePersistanceDTO> persistenceDTOs) {
		List<PlacingOrdersForPurchaseServiceDTO> objServicedtos = new ArrayList<PlacingOrdersForPurchaseServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			PlacingOrdersForPurchaseServiceDTO objSearchServiceDto = new PlacingOrdersForPurchaseServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

		

		
	
		
		
		
	 public List<PlacingOrdersForPurchasePersistanceDTO> convertObjetsArraytoGetAllSuppliers(List<Object[]> list) {
		List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
		for (Object[] objects : list) {
			PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setSupplierId(objects[0].toString());
			} else {
				objPersistenceDTO.setSupplierId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setSupplierName(objects[1].toString());
			} else {
				objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 
				
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	 
	 
	 public List<PlacingOrdersForPurchasePersistanceDTO> ConvertDataToGetDrugDetails(List<Object[]> list) {
		List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
		for (Object[] objects : list) {
			PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setSerialId(objects[0].toString());
			} else {
				objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setDr_drug_name(objects[1].toString());
			} else {
				objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 
			 if (objects[2] != null) {
					objPersistenceDTO.setDb_drug_brand_lang1(objects[2].toString());
				} else {
					objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[3] != null) {
					objPersistenceDTO.setDf_form_type(objects[3].toString());
				} else {
					objPersistenceDTO.setDf_form_type(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[41] != null) {
					objPersistenceDTO.setPacking_type(objects[4].toString());
				} else {
					objPersistenceDTO.setPacking_type(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[5] != null) {
					objPersistenceDTO.setBatch_number(objects[5].toString());
				} else {
					objPersistenceDTO.setBatch_number(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[6] != null) {
					objPersistenceDTO.setExpire_date(objects[6].toString());
				} else {
					objPersistenceDTO.setExpire_date(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[7] != null) {
					objPersistenceDTO.setPurchase_price(objects[7].toString());
				} else {
					objPersistenceDTO.setPurchase_price(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[8] != null) {
					objPersistenceDTO.setDmr_mrp(objects[8].toString());
				} else {
					objPersistenceDTO.setDmr_mrp(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[9] != null) {
					objPersistenceDTO.setBill_invoice_number(objects[9].toString());
				} else {
					objPersistenceDTO.setBill_invoice_number(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[10] != null) {
					objPersistenceDTO.setStock(objects[10].toString());
				} else {
					objPersistenceDTO.setStock(CommonConstants.DATA_NOT_AVIALABLE);
				}
		
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public List<PlacingOrdersForPurchasePersistanceDTO> ConvertDataToGetAllPurchaseOrderList(List<Object[]> list) {
			List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
			for (Object[] objects : list) {
				PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setDrugidList(objects[0].toString());
				} else {
					objPersistenceDTO.setDrugidList(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setGenericName(objects[1].toString());
				} else {
					objPersistenceDTO.setGenericName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 
				 if (objects[2] != null) {
						objPersistenceDTO.setDb_drug_brand_lang1(objects[2].toString());
					} else {
						objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setDf_form_type(objects[3].toString());
					} else {
						objPersistenceDTO.setDf_form_type(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[4] != null) {
						objPersistenceDTO.setUnicode(objects[4].toString());
					} else {
						objPersistenceDTO.setUnicode(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[5] != null) {
						objPersistenceDTO.setStrenghtlist(objects[5].toString());
					} else {
						objPersistenceDTO.setStrenghtlist(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[6] != null) {
						objPersistenceDTO.setSupplierName(objects[6].toString());
					} else {
						objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[7] != null) {
						objPersistenceDTO.setDmr_actuval_stock(objects[7].toString());
					} else {
						objPersistenceDTO.setDmr_actuval_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[8] != null) {
						objPersistenceDTO.setDrr_actuval_stock(objects[8].toString());
					} else {
						objPersistenceDTO.setDrr_actuval_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[9] != null) {
						objPersistenceDTO.setTotal_stock(objects[9].toString());
					} else {
						objPersistenceDTO.setTotal_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[10] != null) {
						objPersistenceDTO.setMaterialgroup(objects[10].toString());
					} else {
						objPersistenceDTO.setMaterialgroup(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[11] != null) {
						objPersistenceDTO.setMaterialgroup_id(objects[11].toString());
					} else {
						objPersistenceDTO.setMaterialgroup_id(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
	 
	 
	 
	 
	 public List<PlacingOrdersForPurchasePersistanceDTO> ConvertDataToGetIndentDetails(List<Object[]> list) {
			List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
			for (Object[] objects : list) {
				PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setDr_drug_name(objects[0].toString());
				} else {
					objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setIndentidNumber(objects[1].toString());
				} else {
					objPersistenceDTO.setIndentidNumber(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 
				 if (objects[2] != null) {
						objPersistenceDTO.setIndent_raised_date(objects[2].toString());
					} else {
						objPersistenceDTO.setIndent_raised_date(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setQuantity(objects[3].toString());
					} else {
						objPersistenceDTO.setQuantity(CommonConstants.DATA_NOT_AVIALABLE);
					}

				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
	 
	 
	 
	 public List<PlacingOrdersForPurchasePersistanceDTO> ConvertDataToGetEmpMailIds(List<Object[]> list) {
			List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
			for (Object[] objects : list) {
				PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setMailId(objects[0].toString());
				} else {
					objPersistenceDTO.setMailId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		} 
	 
	 

	 public List<PlacingOrdersForPurchasePersistanceDTO> ConvertDataToGetPoDrug_Details(List<Object[]> list) {
			List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
			for (Object[] objects : list) {
				PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setDr_drug_name(objects[0].toString());
				} else {
					objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setDb_drug_brand_lang1(objects[1].toString());
				} else {
					objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 
				 if (objects[2] != null) {
						objPersistenceDTO.setDf_form_type(objects[2].toString());
					} else {
						objPersistenceDTO.setDf_form_type(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setStrenghtlist(objects[3].toString());
					} else {
						objPersistenceDTO.setStrenghtlist(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[4] != null) {
						objPersistenceDTO.setCompany_name(objects[4].toString());
					} else {
						objPersistenceDTO.setCompany_name(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[5] != null) {
						objPersistenceDTO.setQuantity(objects[5].toString());
					} else {
						objPersistenceDTO.setQuantity(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[6] != null) {
						objPersistenceDTO.setSupplierName(objects[6].toString());
					} else {
						objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[7] != null) {
						objPersistenceDTO.setMailId(objects[7].toString());
					} else {
						objPersistenceDTO.setMailId(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[8] != null) {
						objPersistenceDTO.setAmount(objects[8].toString());
					} else {
						objPersistenceDTO.setAmount(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}

	 
	 public List<PlacingOrdersForPurchasePersistanceDTO> ConvertDataToGetLoadSupplier(List<Object[]> list) {
			List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
			for (Object[] objects : list) {
				PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setSerialId(objects[0].toString());
				} else {
					objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setSupplierId(objects[1].toString());
				} else {
					objPersistenceDTO.setSupplierId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 
				 if (objects[2] != null) {
						objPersistenceDTO.setSupplierName(objects[2].toString());
					} else {
						objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setPurchage_price(objects[3].toString());
					} else {
						objPersistenceDTO.setPurchage_price(CommonConstants.DATA_NOT_AVIALABLE);
					}

				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
	 
	 
	 
	 
	 
	 
	 public List<PlacingOrdersForPurchasePersistanceDTO> convertObjetsArraytoGetLoadIndents(List<Object[]> list) {
			List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
			for (Object[] objects : list) {
				PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setSerialId(objects[0].toString());
				} else {
					objPersistenceDTO.setSerialId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setIndentidNumber(objects[1].toString());
				} else {
					objPersistenceDTO.setIndentidNumber(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 
			

				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		} 
	 
	 
	 public List<PlacingOrdersForPurchasePersistanceDTO> getpurchagedorderDrug(List<Object[]> list) {
			List<PlacingOrdersForPurchasePersistanceDTO> listOfData = new ArrayList<PlacingOrdersForPurchasePersistanceDTO>();
			for (Object[] objects : list) {
				PlacingOrdersForPurchasePersistanceDTO objPersistenceDTO = new PlacingOrdersForPurchasePersistanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setDrugidList(objects[0].toString());
				} else {
					objPersistenceDTO.setDrugidList(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setDr_drug_name(objects[1].toString());
				} else {
					objPersistenceDTO.setDr_drug_name(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 
				 if (objects[2] != null) {
						objPersistenceDTO.setDb_drug_brand_lang1(objects[2].toString());
					} else {
						objPersistenceDTO.setDb_drug_brand_lang1(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setDf_form_type(objects[3].toString());
					} else {
						objPersistenceDTO.setDf_form_type(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[4] != null) {
						objPersistenceDTO.setUnicode(objects[4].toString());
					} else {
						objPersistenceDTO.setUnicode(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[5] != null) {
						objPersistenceDTO.setStrenghtlist(objects[5].toString());
					} else {
						objPersistenceDTO.setStrenghtlist(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[6] != null) {
						objPersistenceDTO.setSupplierName(objects[6].toString());
					} else {
						objPersistenceDTO.setSupplierName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[7] != null) {
						objPersistenceDTO.setDmr_actuval_stock(objects[7].toString());
					} else {
						objPersistenceDTO.setDmr_actuval_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[8] != null) {
						objPersistenceDTO.setDrr_actuval_stock(objects[8].toString());
					} else {
						objPersistenceDTO.setDrr_actuval_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[9] != null) {
						objPersistenceDTO.setTotal_stock(objects[9].toString());
					} else {
						objPersistenceDTO.setTotal_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[10] != null) {
						objPersistenceDTO.setCritical_level(objects[10].toString());
					} else {
						objPersistenceDTO.setCritical_level(CommonConstants.DATA_NOT_AVIALABLE);
					}
				
				 
			 if (objects[11] != null) {
						objPersistenceDTO.setSales(objects[11].toString());
					} else {
						objPersistenceDTO.setSales(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 if (objects[12] != null) {
						objPersistenceDTO.setDmr_pys_actual_stock(objects[12].toString());
					} else {
						objPersistenceDTO.setDmr_pys_actual_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 if (objects[13] != null) {
						objPersistenceDTO.setDrr_oys_actual_stock(objects[13].toString());
					} else {
						objPersistenceDTO.setDrr_oys_actual_stock(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 if (objects[14] != null) {
						objPersistenceDTO.setGroup_molecules_type_lang1(objects[14].toString());
					} else {
						objPersistenceDTO.setGroup_molecules_type_lang1(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}

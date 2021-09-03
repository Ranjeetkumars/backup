package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.SupplierControllerDTO;

import com.pro.scm.persistencedto.SupplierPeristenanceDTO;
import com.pro.scm.servicedto.SupplierServiceDTO;
import com.pro.scm.utills.CommonConstants;


public class SupplierMapper {
		public SupplierServiceDTO conversionControllerDtoToServiceDto(
				SupplierControllerDTO objSupplierControllerDTO) {
			SupplierServiceDTO objSupplierServiceDTO = new SupplierServiceDTO();
			BeanUtils.copyProperties(objSupplierControllerDTO, objSupplierServiceDTO);

			return objSupplierServiceDTO;
		}
		
		public List<SupplierControllerDTO> conversionForServiceTOControllerDTO(List<SupplierServiceDTO> objServicedto) {
			List<SupplierControllerDTO> objSupplierControllerDTO = new ArrayList<SupplierControllerDTO>();
			objServicedto.forEach(objVehicleTypeDrugsServiceDTO -> {
				SupplierControllerDTO objBrandDetailsControllerDTO1 = new SupplierControllerDTO();
				BeanUtils.copyProperties(objVehicleTypeDrugsServiceDTO, objBrandDetailsControllerDTO1);
				objSupplierControllerDTO.add(objBrandDetailsControllerDTO1);
			});
			return objSupplierControllerDTO;
		}

		public List<SupplierServiceDTO> conversionpersistanceDTOtoServiceDTO(List<SupplierPeristenanceDTO> persistenceDTOs) {
			List<SupplierServiceDTO> objServicedtos = new ArrayList<SupplierServiceDTO>();
			persistenceDTOs.forEach(persistence -> {
				SupplierServiceDTO objSearchServiceDto = new SupplierServiceDTO();
				BeanUtils.copyProperties(persistence, objSearchServiceDto);
				objServicedtos.add(objSearchServiceDto);
			});
			return objServicedtos;
		}
		
		public List<SupplierPeristenanceDTO> conversionForClassification(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setClassificationid(objects[0].toString());
				} else {
					objPersistenceDTO.setClassificationid(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setClassificationName(objects[1].toString());
				} else {
					objPersistenceDTO.setClassificationName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		//
		
		public List<SupplierPeristenanceDTO> conversionForloadState(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setStateid(objects[0].toString());
				} else {
					objPersistenceDTO.setStateid(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setStateName(objects[1].toString());
				} else {
					objPersistenceDTO.setStateName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		public List<SupplierPeristenanceDTO> conversionForSupplier(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setSuppliername(objects[0].toString());
				} else {
					objPersistenceDTO.setSuppliername(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setCountryName(objects[1].toString());
				} else {
					objPersistenceDTO.setCountryName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[2] != null) {
						objPersistenceDTO.setStateName(objects[2].toString());
					} else {
						objPersistenceDTO.setStateName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[3] != null) {
						objPersistenceDTO.setDistrictName(objects[3].toString());
					} else {
						objPersistenceDTO.setDistrictName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 if (objects[4] != null) {
						objPersistenceDTO.setMandalName(objects[4].toString());
					} else {
						objPersistenceDTO.setMandalName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[5] != null) {
						objPersistenceDTO.setZipCode(objects[5].toString());
					} else {
						objPersistenceDTO.setZipCode(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[6] != null) {
						objPersistenceDTO.setLocalityName(objects[6].toString());
					} else {
						objPersistenceDTO.setLocalityName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[7] != null) {
						objPersistenceDTO.setLandmarkName(objects[7].toString());
					} else {
						objPersistenceDTO.setLandmarkName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[8] != null) {
						objPersistenceDTO.setEmail(objects[8].toString());
					} else {
						objPersistenceDTO.setEmail(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[9] != null) {
						objPersistenceDTO.setWebsite(objects[9].toString());
					} else {
						objPersistenceDTO.setWebsite(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[10] != null) {
						objPersistenceDTO.setLicensenumber(objects[10].toString());
					} else {
						objPersistenceDTO.setLicensenumber(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[11] != null) {
						objPersistenceDTO.setTelephone(objects[11].toString());
					} else {
						objPersistenceDTO.setTelephone(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[12] != null) {
						objPersistenceDTO.setMobile(objects[12].toString());
					} else {
						objPersistenceDTO.setMobile(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[13] != null) {
						objPersistenceDTO.setFax(objects[13].toString());
					} else {
						objPersistenceDTO.setFax(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[14] != null) {
						objPersistenceDTO.setPincode(objects[14].toString());
					} else {
						objPersistenceDTO.setPincode(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
			/*
			 * if (objects[15] != null) {
			 * objPersistenceDTO.setStatus(objects[15].toString()); } else {
			 * objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE); }
			 */
				 
				 if (objects[15] != null) {
					 
					 if(objects[15].toString().equalsIgnoreCase("true")) {
						 objPersistenceDTO.setStatus("Active");
					 }
					 else {
						 objPersistenceDTO.setStatus("InActive");
					 }
						
					} else {
						objPersistenceDTO.setStatus(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 
				 
				 
				 
				 if (objects[16] != null) {
						objPersistenceDTO.setContactperson(objects[16].toString());
					} else {
						objPersistenceDTO.setContactperson(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 if (objects[17] != null) {
						objPersistenceDTO.setClassificationName(objects[17].toString());
					} else {
						objPersistenceDTO.setClassificationName(CommonConstants.DATA_NOT_AVIALABLE);
					}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		//
		
		public List<SupplierPeristenanceDTO> conversionForloadCountry(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setCountryid(objects[0].toString());
				} else {
					objPersistenceDTO.setCountryid(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setCountryName(objects[1].toString());
				} else {
					objPersistenceDTO.setCountryName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		//
		public List<SupplierPeristenanceDTO> conversionForloadDistrict(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setDistrictid(objects[0].toString());
				} else {
					objPersistenceDTO.setDistrictid(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setDistrictName(objects[1].toString());
				} else {
					objPersistenceDTO.setDistrictName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		
		
		public List<SupplierPeristenanceDTO> conversionForloadLandmark(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setLandmarkid(objects[0].toString());
				} else {
					objPersistenceDTO.setLandmarkid(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setLandmarName(objects[1].toString());
				} else {
					objPersistenceDTO.setLandmarName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		
		
		public List<SupplierPeristenanceDTO> conversionForloadLocality(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setLacationId(objects[0].toString());
				} else {
					objPersistenceDTO.setLacationId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setLacationName(objects[1].toString());
				} else {
					objPersistenceDTO.setLacationName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		
		//
		

		public List<SupplierPeristenanceDTO> conversionForloadZipCode(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setZipCodeId(objects[0].toString());
				} else {
					objPersistenceDTO.setZipCodeId(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setZipCode(objects[1].toString());
				} else {
					objPersistenceDTO.setZipCode(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
		
		//
		
		public List<SupplierPeristenanceDTO> conversionForloadCity(List<Object[]> list) {
			List<SupplierPeristenanceDTO> listOfData = new ArrayList<SupplierPeristenanceDTO>();
			for (Object[] objects : list) {
				SupplierPeristenanceDTO objPersistenceDTO = new SupplierPeristenanceDTO();
				if (objects[0] != null) {
					objPersistenceDTO.setCityid(objects[0].toString());
				} else {
					objPersistenceDTO.setCityid(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 if (objects[1] != null) {
					objPersistenceDTO.setCityName(objects[1].toString());
				} else {
					objPersistenceDTO.setCityName(CommonConstants.DATA_NOT_AVIALABLE);
				}
				 listOfData.add(objPersistenceDTO);
			}
			return listOfData;
		}
	}

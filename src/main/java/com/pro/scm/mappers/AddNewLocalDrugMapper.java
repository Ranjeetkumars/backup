package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import com.pro.scm.controllerdto.AddNewLocalDrugControllerDTO;
import com.pro.scm.persistencedto.AddNewLocalDrugPersistencesDTO;
import com.pro.scm.servicedto.AddNewLocalDrugServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class AddNewLocalDrugMapper {

	public AddNewLocalDrugServiceDTO conversionControllerDtoToServiceDto(
			AddNewLocalDrugControllerDTO objAddNewLocalDrugControllerDTO) {
		AddNewLocalDrugServiceDTO objAddNewLocalDrugServiceDTO = new AddNewLocalDrugServiceDTO();
		BeanUtils.copyProperties(objAddNewLocalDrugControllerDTO, objAddNewLocalDrugServiceDTO);
		return objAddNewLocalDrugServiceDTO;
	}

	public List<AddNewLocalDrugControllerDTO> conversionForServiceTOControllerDTO(
			List<AddNewLocalDrugServiceDTO> objServicedto) {
		List<AddNewLocalDrugControllerDTO> objControllerDto = new ArrayList<AddNewLocalDrugControllerDTO>();
		objServicedto.forEach(serviceDto -> {
			AddNewLocalDrugControllerDTO objControllerDto1 = new AddNewLocalDrugControllerDTO();
			BeanUtils.copyProperties(serviceDto, objControllerDto1);
			objControllerDto.add(objControllerDto1);
		});
		return objControllerDto;
	}

	public List<AddNewLocalDrugServiceDTO> conversionpersistanceDTOtoServiceDTO(
			List<AddNewLocalDrugPersistencesDTO> persistenceDTOs) {
		List<AddNewLocalDrugServiceDTO> objServicedtos = new ArrayList<AddNewLocalDrugServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			AddNewLocalDrugServiceDTO objSearchServiceDto = new AddNewLocalDrugServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}

	public List<AddNewLocalDrugPersistencesDTO> getLoadLocaldrugs(List<Object[]> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object[] objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDr_serialId(objects[0].toString());
			} else {
				objPersistenceDTO.setDr_serialId(CommonConstants.DATA_NOT_AVIALABLE);
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
					objPersistenceDTO.setDf_from_type(objects[3].toString());
				} else {
					objPersistenceDTO.setDf_from_type(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[4] != null) {
					objPersistenceDTO.setDr_strength_type(objects[4].toString());
				} else {
					objPersistenceDTO.setDr_strength_type(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[5] != null) {
					objPersistenceDTO.setMa_companyName(objects[5].toString());
				} else {
					objPersistenceDTO.setMa_companyName(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[6] != null) {
					objPersistenceDTO.setDr_pack_type_id(objects[6].toString());
				} else {
					objPersistenceDTO.setDr_pack_type_id(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 if (objects[7] != null) {
					objPersistenceDTO.setDr_createdbydtm(objects[7].toString());
				} else {
					objPersistenceDTO.setDr_createdbydtm(CommonConstants.DATA_NOT_AVIALABLE);
				}

			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	

	public List<AddNewLocalDrugPersistencesDTO> getAllMedicinesCounts(List<?> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects != null) {
				objPersistenceDTO.setCount(objects.toString());
			} else {
				objPersistenceDTO.setCount(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
	public List<AddNewLocalDrugPersistencesDTO> getloadGenricGroup(List<Object[]> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object[] objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setGroup_functionId(objects[0].toString());
			} else {
				objPersistenceDTO.setGroup_functionId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGroup_function(objects[1].toString());
			} else {
				objPersistenceDTO.setGroup_function(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AddNewLocalDrugPersistencesDTO> getloadGenricMolecules(List<Object[]> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object[] objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setGroup_moleculesId(objects[0].toString());
			} else {
				objPersistenceDTO.setGroup_moleculesId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setGroup_molecules(objects[1].toString());
			} else {
				objPersistenceDTO.setGroup_molecules(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	
	public List<AddNewLocalDrugPersistencesDTO> getloadManufaturer(List<Object[]> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object[] objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setManufactureId(objects[0].toString());
			} else {
				objPersistenceDTO.setManufactureId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setCompanyName(objects[1].toString());
			} else {
				objPersistenceDTO.setCompanyName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AddNewLocalDrugPersistencesDTO> getloadForms(List<Object[]> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object[] objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setFrom_id(objects[0].toString());
			} else {
				objPersistenceDTO.setFrom_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setFormType(objects[1].toString());
			} else {
				objPersistenceDTO.setFormType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AddNewLocalDrugPersistencesDTO> getloadBrand(List<Object[]> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object[] objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setBrand_id(objects[0].toString());
			} else {
				objPersistenceDTO.setBrand_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setDrug_brand(objects[1].toString());
			} else {
				objPersistenceDTO.setDrug_brand(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AddNewLocalDrugPersistencesDTO> getloadSystem(List<Object[]> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object[] objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setDr_serialId(objects[0].toString());
			} else {
				objPersistenceDTO.setDr_serialId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				objPersistenceDTO.setSystemType(objects[1].toString());
			} else {
				objPersistenceDTO.setSystemType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AddNewLocalDrugPersistencesDTO> getVehicleAlsBls(List<?> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects != null) {
				objPersistenceDTO.setVehicleType(objects.toString());
			} else {
				objPersistenceDTO.setVehicleType(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
	public List<AddNewLocalDrugPersistencesDTO> getVehicleDrugStatus(List<?> list) {
		List<AddNewLocalDrugPersistencesDTO> listOfData = new ArrayList<AddNewLocalDrugPersistencesDTO>();
		for (Object objects : list) {
			AddNewLocalDrugPersistencesDTO objPersistenceDTO = new AddNewLocalDrugPersistencesDTO();
			if (objects != null) {
				objPersistenceDTO.setVehicleDrugStatus(objects.toString());
			} else {
				objPersistenceDTO.setVehicleDrugStatus(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	
}

package com.pro.scm.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pro.scm.controllerdto.ReportControllerDTO;
import com.pro.scm.persistencedto.ReportPersistenceDTO;
import com.pro.scm.servicedto.ReportServiceDTO;
import com.pro.scm.utills.CommonConstants;

public class ReportMapper {
	public ReportServiceDTO conversionControllerDtoToServiceDto(
			ReportControllerDTO objReceivedGoodsControllerDto) {
		ReportServiceDTO objReceivedGoodsServiceDto = new  ReportServiceDTO();
		BeanUtils.copyProperties(objReceivedGoodsControllerDto, objReceivedGoodsServiceDto);

		return objReceivedGoodsServiceDto;
	}

	public List<ReportControllerDTO> conversionForServiceTOControllerDTO(List<ReportServiceDTO> objServicedto) {
		List<ReportControllerDTO> objReceivedGoodsControllerDto = new ArrayList<ReportControllerDTO>();
		objServicedto.forEach(ReportServiceDto -> {
			ReportControllerDTO objReportControllerDto1 = new  ReportControllerDTO();
			BeanUtils.copyProperties(ReportServiceDto, objReportControllerDto1);
			objReceivedGoodsControllerDto.add(objReportControllerDto1);
		});
		return objReceivedGoodsControllerDto;
	}

	public List<ReportServiceDTO> conversionpersistanceDTOtoServiceDTO(List<ReportPersistenceDTO> persistenceDTOs) {
		List<ReportServiceDTO> objServicedtos = new ArrayList<ReportServiceDTO>();
		persistenceDTOs.forEach(persistence -> {
			ReportServiceDTO objSearchServiceDto = new  ReportServiceDTO();
			BeanUtils.copyProperties(persistence, objSearchServiceDto);
			objServicedtos.add(objSearchServiceDto);
		});
		return objServicedtos;
	}
	

	
	public List<ReportPersistenceDTO> ConvertDataToGetIPFields(List<?>  list) {
		List<ReportPersistenceDTO> listOfData = new ArrayList<ReportPersistenceDTO>();
		for (Object objects : list) {
			ReportPersistenceDTO objPersistenceDTO = new ReportPersistenceDTO();
			if (objects != null) {
				objPersistenceDTO.setRrp_parameter_id(objects.toString());
			} else {
				objPersistenceDTO.setRrp_parameter_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
				
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	public List<ReportPersistenceDTO> ConvertDataToGetLoadReports(List<Object[]> list) {
		List<ReportPersistenceDTO> listOfData = new ArrayList<ReportPersistenceDTO>();
		for (Object[] objects : list) {
			ReportPersistenceDTO objPersistenceDTO = new ReportPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setRrn_id(objects[0].toString());
			} else {
				objPersistenceDTO.setRrn_id(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setRrn_name(objects[1].toString());
			} else {
				objPersistenceDTO.setRrn_name(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[2] != null) {
					objPersistenceDTO.setRrn_path_name(objects[2].toString());
				} else {
					objPersistenceDTO.setRrn_path_name(CommonConstants.DATA_NOT_AVIALABLE);
				}
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}
	public List<ReportPersistenceDTO> convertObjetsArraytoGetModules(List<Object[]> list) {
		List<ReportPersistenceDTO> listOfData = new ArrayList<ReportPersistenceDTO>();
		for (Object[] objects : list) {
			ReportPersistenceDTO objPersistenceDTO = new ReportPersistenceDTO();
			if (objects[0] != null) {
				objPersistenceDTO.setModuleId(objects[0].toString());
			} else {
				objPersistenceDTO.setModuleId(CommonConstants.DATA_NOT_AVIALABLE);
			}
			 if (objects[1] != null) {
				objPersistenceDTO.setModuleName(objects[1].toString());
			} else {
				objPersistenceDTO.setModuleName(CommonConstants.DATA_NOT_AVIALABLE);
			}
			
			 listOfData.add(objPersistenceDTO);
		}
		return listOfData;
	}

}

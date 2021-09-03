package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.LoadMaterialFormControllerDto;
import com.pro.scm.controllerdto.Response;
import com.pro.scm.servicedto.MaterialFormServiceDTO;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class LoadMaterialFormWrapper  extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137372L;
	private List<LoadMaterialFormControllerDto> objControllerDto;
	private List<MaterialFormServiceDTO> dto;
	
	

}

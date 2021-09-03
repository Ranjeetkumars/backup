package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.DrugAndSupplierMappingControllerDto;
import com.pro.scm.controllerdto.Response;

import lombok.Data;
@Data
public class DrugAndSupplierMappingwrapper extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137371L;
	List<DrugAndSupplierMappingControllerDto> drugAndSupplierMappingControllerDto;

}

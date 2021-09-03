package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.DrugRegistrationControllerDto;
import com.pro.scm.controllerdto.Response;

import lombok.Data;
@Data
public class DrugRegistrationWrapper  extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137371L;
	private List<DrugRegistrationControllerDto> objControllerDto;

}

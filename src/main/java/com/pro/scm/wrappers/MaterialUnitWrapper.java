package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.MaterialUnitControllerDTO;
import com.pro.scm.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

public class MaterialUnitWrapper extends Response implements Serializable{
	private static final long serialVersionUID = 4211593995472137371L;
	private List<MaterialUnitControllerDTO> objMaterialUnitControllerDTO;
}

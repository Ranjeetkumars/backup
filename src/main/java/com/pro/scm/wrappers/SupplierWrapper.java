package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SupplierControllerDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class SupplierWrapper extends Response implements Serializable{
	private static final long serialVersionUID = 4211593995472137371L;
	private List<SupplierControllerDTO> objSupplierControllerDTO;
}

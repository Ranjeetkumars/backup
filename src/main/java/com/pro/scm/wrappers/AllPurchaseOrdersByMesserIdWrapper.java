package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.AllPurchaseOrdersByMesserIdControllerDto;
import com.pro.scm.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AllPurchaseOrdersByMesserIdWrapper  extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137375L;
	private List<AllPurchaseOrdersByMesserIdControllerDto> objControllerDto;

}

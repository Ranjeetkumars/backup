package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;


import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SalesReturnsControllerDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SalesReturnsWrapper  extends Response implements Serializable {
		private static final long serialVersionUID = 4211593995472137371L;
		private List<SalesReturnsControllerDTO>salesReturnsControllerDTO;
	}
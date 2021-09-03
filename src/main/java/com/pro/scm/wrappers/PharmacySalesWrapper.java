package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.PharmacySalesControllerDTO;
import com.pro.scm.controllerdto.Response;


import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PharmacySalesWrapper  extends Response implements Serializable {
		private static final long serialVersionUID = 4211593995472137371L;
		private List<PharmacySalesControllerDTO>pharmacySalesControllerDTO;
	}
package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.LoadExpiryDrugsControllerDto;
import com.pro.scm.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class LoadExpiryDrugsWrapper  extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137372L;
	private List<LoadExpiryDrugsControllerDto> objControllerDto;

}

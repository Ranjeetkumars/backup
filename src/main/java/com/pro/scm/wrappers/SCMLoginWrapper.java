package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.SCMLoginControllerDto;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SCMLoginWrapper  extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137370L;
	private List<SCMLoginControllerDto> objControllerDto;

}

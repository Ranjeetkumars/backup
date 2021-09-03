package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;


import com.pro.scm.controllerdto.ListLoadActiveDrugsControllerDto;
import com.pro.scm.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ListLoadActiveDrugsWrapper extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137370L;
	private List<ListLoadActiveDrugsControllerDto> objControllerDto;

}

package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;

import com.pro.scm.controllerdto.Response;
import com.pro.scm.controllerdto.Store_item_detailsControllerDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class Store_item_detailsWrapper extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137370L;
	private List<Store_item_detailsControllerDto> objControllerDto;

}

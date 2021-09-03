package com.pro.scm.wrappers;

import java.io.Serializable;
import java.util.List;


import com.pro.scm.controllerdto.PurchaseOrderControllerDTO;
import com.pro.scm.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class PurchaseOrderWrapper extends Response implements Serializable  {
	private static final long serialVersionUID = -4055925064027662526L;
	private List<PurchaseOrderControllerDTO> purchaseOrderControllerDTO;
}
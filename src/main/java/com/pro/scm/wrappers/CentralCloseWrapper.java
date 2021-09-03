package com.pro.scm.wrappers;
import java.io.Serializable;
import java.util.List;
import com.pro.scm.controllerdto.AddNewLocalDrugControllerDTO;
import com.pro.scm.controllerdto.CentralCloseControllerDTO;
import com.pro.scm.controllerdto.Response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CentralCloseWrapper extends Response implements Serializable {
	private static final long serialVersionUID = 4211593995472137371L;
	private List<CentralCloseControllerDTO> objCentralCloseControllerDTO;
}

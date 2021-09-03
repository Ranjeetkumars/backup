package com.pro.scm.dao;

import java.util.List;
/**
 * @author VENKAT_PRO
 *
 */
public interface SCMDao {
	
	public List<?> getData(String strQuery);

	public String saveData(String strQuery);

	public String getSingleData(String strQuery);

}

package com.pro.scm.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pro.scm.dao.SCMDao;
/**
 * @author VENKAT_PRO
 *
 */

@Repository("objSupervisorDao")
@Transactional
public class SCMDaoImpl  implements SCMDao{
	@Autowired     
	private SessionFactory sessionFactory;
    @SuppressWarnings("unchecked")
	@Override 
	public List<Object[]> getData(String strQuery){
		Session session = null;
		List<Object[]> listData = null;
		session = sessionFactory.getCurrentSession();
		listData = session.createSQLQuery(strQuery).list();
		return listData;
	}

	@Override
	public String saveData(String strQuery) {
		Session session = null;
		String strResult = null;
		session = sessionFactory.getCurrentSession();
		strResult = session.createSQLQuery(strQuery).list().get(0).toString();
		return strResult;
	}

	@Override
	public String getSingleData(String strQuery) {
		Session session = null;
		String listData = null;
		session = sessionFactory.getCurrentSession();
		//listData = session.createSQLQuery(strQuery).toString();
		listData = session.createSQLQuery(strQuery).list().get(0).toString();
		return listData;
	}

}

/**
 * This package contain  class as Service is used to call the Generic Services
 */
package org.goup.generic_service;

import org.goup.generic_dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class use as Service to call all the Generic Dao Method in all possible
 * cases to interact with Databases for their different CRUD and other Functionality
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-07-30
 */
@Service
@Transactional(readOnly=false,noRollbackFor=Exception.class)
@SuppressWarnings("rawtypes")
public class GenericService {

	/**
	 * To access the Methodality of the following Class Method
	 */
	@Autowired
	private GenericDao genericDao;

	/**
	 * To Declare the save Method
	 *  
	 * @param object
	 * 			data object
	 * @return Object
	 */
	public Object save(Object object) {
		return genericDao.save(object);
	}

	/**
	 * To Declare the findByID Method
	 * 
	 * @param clz
	 * 			entity name
	 * @param object
	 * 			data object
	 * @return Object
	 */
	public Object findByID(Class clz, Object object) {
		return genericDao.findByID(clz, object);
	}

	/**
	 * To Declare the findByColumn Method
	 * 
	 * @param clz
	 * 			entity name
	 * @param key
	 * 			column name
	 * @param object
	 * 			data object
	 * @return Object
	 */
	public Object findByColumn(Class clz, String key, Object object) {
		return genericDao.findByColumn(clz, key, object);
	}

	/**
	 * To Declare the findAll Method
	 * 
	 * @param clz
	 * 			entity name
	 * @return Object
	 */
	public Object findAll(Class clz) {
		return genericDao.findAll(clz);
	}

	/**
	 * To Declare the update Method
	 * 
	 * @param object
	 * 			data object
	 * @return Object
	 */
	public Object update(Object object) {
		return genericDao.update(object);
	}

	/**
	 * To Declare the findByColumnUnique Method
	 * 
	 * @param clz
	 * 			entity name
	 * @param key
	 * 			column name
	 * @param value
	 * 			record id
	 * @return Object
	 */
	public Object findByColumnUnique(Class clz, String key, Object value) {
		return genericDao.findByColumnUnique(clz, key, value);
	}

	/**
	 * To Declare the executeSqlQuery Method
	 * 
	 * @param sql
	 * 			String value represents SQL query
	 * @return Object
	 */
	public Object executeSqlQuery(String sql) {
		return genericDao.executeSqlQuery(sql);
	}

	/**
	 * To Declare the executeAnySqlQuery Method
	 * 
	 * @param sql
	 * 			String value represents SQL query
	 * @return Object
	 */
	public Object executeAnySqlQuery(String sql) {
		return genericDao.executeAnySqlQuery(sql);
	}

	/**
	 * To Declare the executeProcesure Method
	 * 
	 * @param clz
	 * 			entity name
	 * @param sql
	 * 			String value represents SQL query
	 * @param objects
	 * 			store procedure parameters
	 * @return Object
	 */
	public Object executeThirdPartyProcesure(Class clz, String sql, Object... objects) {
		return genericDao.executeThirdPartyProcesure(clz, sql, objects);
	}

}

/**
 * This package contain  class as Repository is used to call the GenericDao
 */
package org.goup.generic_dao;

/**
 * To Import Classes to access their functionality
 */
import java.util.Collection;

import org.goup.hibernate.transform.AliasToEntityLinkedHashMapResultTransformer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class use as Repository to call all Method in all possible cases to
 * interact with Databases for their different CRUD and other Functionality
 * 
 * @author	Sanjay Kumar
 * @version	1.0
 * @since	2018-07-30
 */
@Repository
@SuppressWarnings("rawtypes")
public class GenericDao {
	
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private SessionFactory sessionFactory;


	/**
	 * This method is use for save the data in database
	 * 
	 * @param object
	 * 			data to save
	 * @return SQL result
	 */
	public Object save(Object object) {
		try {
			return sessionFactory.getCurrentSession().save(object);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for update row the data in database
	 * 
	 * @param object
	 * 			data to update
	 * @return SQL result
	 */
	public Object update(Object object) {
		try {
			sessionFactory.getCurrentSession().update(object);

			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for save and update row the data in database
	 * 
	 * @param object
	 * 			data to save and update
	 * @return SQL result
	 */
	public Object saveAndUpdate(Object object) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(object);

			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for save and update all data in database
	 * 
	 * @param object
	 * 			data to save
	 * @return SQL result
	 */
	public Object saveOrUpdateAll(Collection collection) {
		try {

			for (Object object : collection) {
				sessionFactory.getCurrentSession().saveOrUpdate(object);

			}
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for delete data in database
	 * 
	 * @param object
	 * 			data to delete
	 * @return SQL result
	 */
	public Object delete(Object object) {
		try {
			sessionFactory.getCurrentSession().delete(object);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for find all data in database
	 * 
	 * @param clz
	 * 			table name
	 * @return SQL result
	 */
	public Object findAll(Class clz) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz);
			return criteria.list();

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for find data by id in database
	 * 
	 * @param clz
	 * 			table name
	 * @param value
	 * 			row id
	 * @return SQL result
	 */
	public Object findByID(Class clz, Object value) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.idEq(value));
			return criteria.uniqueResult();

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for find data by column in database
	 * 
	 * @param clz
	 * 			table name
	 * @param key
	 * 			column name
	 * @param value
	 * 			row id
	 * @return SQL result
	 */
	public Object findByColumn(Class clz, String key, Object value) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.eq(key, value));
			return criteria.list();
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is use for find data by column in database
	 * 
	 * @param clz
	 * 			table name
	 * @param key
	 * 			column name
	 * @param value
	 * 			row id
	 * @return SQL result
	 */
	public Object findByColumnUnique(Class clz, String key, Object value) {
		try {

			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clz).add(Restrictions.eq(key, value));
			return criteria.uniqueResult();

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	/**
	 * This method is used to execute select query in database
	 * 
	 * @param sql
	 * 			String value represents sql query
	 * @return SQL result
	 */
	public Object executeSqlQuery(String sql) {
		try {
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			return query.list();
			
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * This method is used to execute any sql query in database
	 * 
	 * @param sql
	 * 			String value represents sql query
	 * @return SQL result
	 */
	public Object executeAnySqlQuery(String sql) {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			return query.executeUpdate();

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	/**
	 * This method is used to execute query in database when query any class is passed
	 * 
	 * @param sql
	 * 			String value represents sql query
	 * @param clz
	 * 			entity name
	 * @return SQL result
	 */
	public Object executeSqlQuery(String sql, Class clz) {
		try {

			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.addEntity(clz);
			return query.list();

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * This method is used to executeProcesure() method is used to execute the Procesure
	 * 
	 * @param clz
	 * 			class name
	 * @param sql
	 * 			sql query
	 * @param objects
	 * 			store procedure parameters
	 * @return SQL result
	 */
	public Object executeThirdPartyProcesure(Class clz, String sql, Object[] objects) {

		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);

		if (clz != null) {
			query.setResultTransformer(Transformers.aliasToBean(clz));
		} else {
			query.setResultTransformer(AliasToEntityLinkedHashMapResultTransformer.INSTANCE);
		}

		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}

		return query.list();

	}
	

}

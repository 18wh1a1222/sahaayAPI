package com.db;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dto.Customer;
import com.dto.Needs;
import com.dto.Volunteer;



public class HibernateTemplate {

	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();

	}

	public static int addObject(Object obj){
		System.out.println("Inside Template...");
		int result=0;

		Transaction tx=null;

		try {

			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();

			session.save(obj);

			tx.commit();

			result=1;

		} catch (Exception e) {

			tx.rollback();

			e.printStackTrace();
		}

		return result;
	}

	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;

		try {			
			return sessionFactory.openSession().get(c,serializable);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return obj;
	}

	public static Customer getCustomerLogin(String loginId, String password) {
		String qString = "from Customer where loginId= :loginId and password =: password";
		Query query = sessionFactory.openSession().createQuery(qString);
		query.setString("loginId", loginId);
		query.setString("password", password);
		Object queryResult = query.uniqueResult();
		Customer cust = (Customer)queryResult;
		return cust;

	}
	
	public static Volunteer getVolunteerLogin(String loginId, String password) {
		String qString = "from Volunteer where loginId= :loginId and password =: password";
		Query query = sessionFactory.openSession().createQuery(qString);
		query.setString("loginId", loginId);
		query.setString("password", password);
		Object queryResult = query.uniqueResult();
		Volunteer vol = (Volunteer)queryResult;
		return vol;

	}
	
	public static Object getVolunteer(int volunteerId) {
		String queryString = "from Volunteer where volunteerId = :volunteerId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("volunteerId", volunteerId);
		  Object queryResult = query.uniqueResult();
		  Volunteer volunteer = (Volunteer)queryResult;
		  return volunteer; 
	}
	
	public static Customer getCustomer(int customerId) {
		String queryString = "from Customer where customerId = :customerId";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setInteger("customerId", customerId);
		  Object queryResult = query.uniqueResult();
		  Customer customer = (Customer)queryResult;
		  return customer; 
	}
	
	


	public static List<Needs> getObjectListByQuery(String query)
	{
		return sessionFactory.openSession().createQuery(query).list();
	}

	public static int updateObject(Object obj)
	{
		int result=0;

		Transaction tx=null;

		try {

			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();

			session.saveOrUpdate(obj);

			tx.commit();

			result=1;

		} catch (Exception e) {

			tx.rollback();

			e.printStackTrace();
		}

		return result;
	}

	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;

		Session session=sessionFactory.openSession();

		Transaction tx=session.beginTransaction();

		try {

			Object obj=session.get(c,serializable);

			session.delete(obj);

			tx.commit();

			result=1;

		} catch (Exception e) {

			e.printStackTrace();

			tx.rollback();
		}

		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(c);
		Criterion nameCriterion = Restrictions.eq(columName, value);
		criteria.add(nameCriterion);
		return criteria.list();
	}
	
	public static List<Object> getObjectListById(Class c, String columName, int value) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(c);
		Criterion nameCriterion = Restrictions.eq(columName, value);
		criteria.add(nameCriterion);
		return criteria.list();
	}

	
}

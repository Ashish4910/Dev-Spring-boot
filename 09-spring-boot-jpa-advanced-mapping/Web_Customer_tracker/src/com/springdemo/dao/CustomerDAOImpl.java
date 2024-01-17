package com.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	// @Transactional
	/*
	 * ==> as this is implemented in Service we can use @Transactional annotation in
	 * the service
	 */

	public List<Customer> getCustomer() {

		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// get the Query
		// create the query to sort the lastName
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		// execute the Query

		List<Customer> theResult = theQuery.getResultList();
		// return the

		return theResult;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current session
		Session currentSession = sessionFactory.getCurrentSession();

		/*
		 * ======================== only save the data with new record if you using same
		 * form to update and save then this method would create new Customer when you
		 * update data=======================
		 */
		// save the customer
		// currentSession.save(theCustomer);

		/* =============================================================== */

		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the Currrent session

		Session currentSession = sessionFactory.getCurrentSession();

		// retrive/read the customer form database

		Customer theCustomer = currentSession.get(Customer.class, theId);
		// redirect to the form

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currSession = sessionFactory.getCurrentSession();

		// get the customer and delete the customer
		Query theQuery = currSession.createQuery("delete from Customer where id=:customerId");

		theQuery.setParameter("customerId", theId);

		// return execute Update
		theQuery.executeUpdate();

	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			// search for firstName or lastName ... case insensitive
			theQuery = currentSession.createQuery(
					"from Customer where lower(firstName) like :theName or lower(lastName) like :theName",
					Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			// theSearchName is empty ... so just get all customers
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;

	}

}

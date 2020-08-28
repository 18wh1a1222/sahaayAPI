package com.dao;

import com.dto.Customer;
import com.db.HibernateTemplate;

public class CustomerDAO {
	public int register(Customer customer) {
		return HibernateTemplate.addObject(customer);
	}

	public Customer login(String loginId, String password) {
		return (Customer) HibernateTemplate.getCustomerLogin(loginId, password);
	}

	public Customer getCustomerById(int customerId) {
		return (Customer) HibernateTemplate.getCustomer(customerId);
	}

	
		
}

	
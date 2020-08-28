package com.dao;

import com.dto.Customer;
import com.dto.Needs;

import java.util.List;

import com.db.HibernateTemplate;

public class NeedsDAO {
	public int register(Needs need) {	
		java.util.Date utilDate = new java.sql.Date(need.getDon().getTime()); 
		return HibernateTemplate.addObject(need);
	}

	public List<Needs> getAllNeeds() {
		List<Needs> needsList = (List)HibernateTemplate.getObjectListByName( Needs.class, "status", "open");
		return needsList;
	}

	public List<Needs> getMyNeeds(Customer customer) {
		//List<Needs> needsList = (List)HibernateTemplate.getObjectListById( Needs.class, "customer", customer);
		return null;
	}
}

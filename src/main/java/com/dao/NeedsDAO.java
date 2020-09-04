package com.dao;

import java.util.List;

import com.db.HibernateTemplate;
import com.dto.Needs;

public class NeedsDAO {
	public int register(Needs need) {	
		java.util.Date utilDate = new java.sql.Date(need.getDon().getTime()); 
		return HibernateTemplate.addObject(need);
	}

	public List<Needs> getAllNeeds() {
		List<Needs> needsList = (List)HibernateTemplate.getObjectListByName( Needs.class, "status", "open");
		return needsList;
	}

	public List<Needs> getMyNeeds(int customerId) {
		String query = "from Needs where customerId =" + customerId;
		List<Needs> needsList = (List)HibernateTemplate.getObjectListByQuery(query);
		return needsList;
	}
}
